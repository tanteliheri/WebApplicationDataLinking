package org.data.linking.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Utils {
    /**
     * Set the headers you need send
     * Create a new HttpEntity
     *
     * @return HttpEntity<String>
     */
    public static HttpEntity<String> getHttpEntity(String authorizationBearer) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authorizationBearer);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }
}
