package com.FreshTastyBitesHouseWeb.springboot.FTBHW.model;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KhaltiPaymentService {

    private final String KHALTI_API_URL = "https://a.khalti.com/api/v2/epayment/initiate/";
    private final String AUTHORIZATION_KEY = "2a915207232c45c3a20af84e00c75ca6"; // Replace with your actual key

    public String initiatePayment(String websiteUrl, String returnUrl, int amount, String purchaseOrderId,
            String purchaseOrderName) {
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", AUTHORIZATION_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        Map<String, Object> body = new HashMap<>();
        body.put("website_url", websiteUrl);
        body.put("return_url", returnUrl); // This is the return URL
        body.put("amount", amount);
        body.put("purchase_order_id", purchaseOrderId);
        body.put("purchase_order_name", purchaseOrderName);

        // Create request entity
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        // Send POST request
        ResponseEntity<Map> response = restTemplate.exchange(KHALTI_API_URL, HttpMethod.POST, entity, Map.class);

        // Extract the payment URL from the response
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("payment_url")) {
                return (String) responseBody.get("payment_url"); // Return the payment URL
            }
        }
        return null;
    }
}
