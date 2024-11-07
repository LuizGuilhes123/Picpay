package com.picpay.picpay.utils;

import org.springframework.web.client.RestTemplate;

public class HttpClient {

    private static final String AUTHORIZATION_URL = "https://util.devi.tools/api/v2/authorize";
    private static final String NOTIFY_URL = "https://util.devi.tools/api/v1/notify";

    public static boolean isAuthorized() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(AUTHORIZATION_URL, Boolean.class);
    }

    public static void sendNotification() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(NOTIFY_URL, null, String.class);
    }
}
