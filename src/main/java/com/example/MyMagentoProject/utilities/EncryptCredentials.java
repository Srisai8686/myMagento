package com.example.MyMagentoProject.utilities;

import java.util.Base64;

public class EncryptCredentials {
    public static void main(String[] args) {
        String username = "narutouzumaki@gmail.com";
        String password = "Naruto@123";
        
        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        
        System.out.println("Encoded Username: " + encodedUsername);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
