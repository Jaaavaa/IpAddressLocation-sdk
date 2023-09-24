package io.jaaavaa.IpAddressLocation;

import io.jaaavaa.IpAddressLocation.config.IpLocationApiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
/**
 * TODO: This class is for local testing purposes only and will be deleted later.It is not required in the final SDK.
 */
public class Test {
    private final WebClient webClient;

    private final IpLocationApiConfig ipLocationApiConfig;

    public Test(WebClient webClient, IpLocationApiConfig ipLocationApiConfig) {
        this.webClient = webClient;
        this.ipLocationApiConfig = ipLocationApiConfig;
    }

    @GetMapping("/test")
    public Mono<String> makeRequest() {
        // Define the complete URL by combining base URL and additional path
        String url = ipLocationApiConfig.getBaseUrl() + "/" + ipLocationApiConfig.getResponseFormat();

        // Make the GET request and retrieve the response as a String
        return webClient.get().uri(url).retrieve().bodyToMono(String.class);
    }

}
