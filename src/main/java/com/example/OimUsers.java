package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class OimUsers {

    private static final String OIM_URL = "http://10.2.2.97:14000/iam/governance/selfservice/api/v1/users";
    private static final String USERNAME = "xelsysadm"; // Replace with your username
    private static final String PASSWORD = "welcome1"; // Replace with your password

    public static void displayAllUsers() throws IOException {
        URL url = new URL(OIM_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Encode username and password for Basic Authentication
        String auth = USERNAME + ":" + PASSWORD;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        conn.setRequestProperty("Authorization", authHeaderValue);
        conn.setDoOutput(false);

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Fetched users: " + response.toString());
        } else {
            System.out.println("Error fetching users: " + conn.getResponseCode());
        }

        conn.disconnect();
    }
}
