package io.jaaavaa.IpAddressLocation.config;

import org.springframework.stereotype.Component;

/**
 * Configuration class for the IP Location API.
 * Provides base URL and response format for API requests.
 */

@Component
public class IpLocationApiConfig {

    // Base URL of the IP Location API
    private final String BASE_URL = "https://ipapi.co";

    // Desired response format (in this case, JSON)
    private final String responseFormat = "json";

    /**
     * Gets the base URL of the IP Location API.
     *
     * @return The base URL.
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets the desired response format for API requests.
     *
     * @return The response format (e.g., JSON).
     */
    public String getResponseFormat() {
        return responseFormat;
    }
}

