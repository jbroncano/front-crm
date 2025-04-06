package com.frontcrm.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Getter
@Setter
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String message;
    
    @ConfigProperty(name = "api.login")
    private String apiLoginUrl;
    

    public String login() {

        try {
            URL url = new URL("http://localhost:8080/crm/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String postData = "username=" + username + "&password=" + password;
            connection.getOutputStream().write(postData.getBytes(StandardCharsets.UTF_8));

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String response = in.lines().collect(Collectors.joining());

                   
                    if (response.contains("\"username\":\"" + username + "\"") && response.contains("\"role\":\"administrator\"")) {
                        message = "Login successful!";
                        return "home.xhtml";
                    } else {
                        message = "Invalid username or password";
                    }
                }
            } else {
                message = "Failed to connect to the server. Response code: " + responseCode;
            }
        } catch (Exception e) {
            message = "An error occurred: " + e.getMessage();
        }
        return null;
    }
    
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }


}
