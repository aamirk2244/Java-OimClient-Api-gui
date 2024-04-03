package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class createUser {
 
    private static final String OIM_URL = "http://10.2.2.97:14000/iam/governance/selfservice/api/v1/users";
    private static final String USERNAME = "xelsysadm"; // Replace with your username
    private static final String PASSWORD = "welcome1"; // Replace with your password

    public static void create() throws IOException {
        URL url = new URL(OIM_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("X-Requested-By", "99"); // Set the X-Requested-By header with any value

        // Encode username and password for Basic Authentication
        String auth = USERNAME + ":" + PASSWORD;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        conn.setRequestProperty("Authorization", authHeaderValue);
        conn.setDoOutput(true);

        // Create a HashMap to represent the user attributes
        String jsonPayload = "{\n" +
        "    \"users\": [\n" +
        "        {\n" +
        "            \"requestId\": \"129\",\n" +
        "            \"fields\": [\n" +
        "                {\n" +
        "                    \"name\": \"Last Name\",\n" +
        "                    \"value\": \"Test1 Through API\"\n" +
        "                },\n" +
        "                {\n" +
        "                    \"name\": \"Role\",\n" +
        "                    \"value\": \"EMP\"\n" +
        "                },\n" +
        "                {\n" +
        "                    \"name\": \"act_key\",\n" +
        "                    \"value\": \"1\"\n" +
        "                }\n" +
        "            ]\n" +
        "        }\n" +
        "    ]\n" +
        "}";
        System.out.println(jsonPayload);
        // Write the JSON payload to the request body
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response: " + response.toString());
        } else {


            BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            String line;
            StringBuilder errorMessage = new StringBuilder();
            while ((line = errorReader.readLine()) != null) {
                errorMessage.append(line);
            }
            errorReader.close();

            System.out.println("Error Message: " + errorMessage.toString());
            System.out.println("Error Code: " + conn.getResponseCode());

        }

        conn.disconnect();
    }
}
