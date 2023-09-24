package io.jaaavaa.IpAddressLocation.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Configuration class for WebClient used in the application.
 * <p>
 * To Do: Provision of custom time out and user agent,
 * Keep documentation up-to-date with any changes or additional configurations.
 */
@Configuration
public class WebClientConfig {
    /**
     * Default timeouts for connection and read operations.
     */
    private final Duration DEFAULT_CONNECTION_TIMEOUT = Duration.ofMillis(1000);
    private final Duration DEFAULT_READ_TIMEOUT = Duration.ofMillis(1000);

    /**
     * Default user agent for HTTP requests.
     */
    private final String DEFAULT_USER_AGENT = "jaaava-sdk-1.0.0";

    private final IpLocationApiConfig ipLocationApiConfig;

    /**
     * Constructor to inject IpLocationApiConfig.
     *
     * @param ipLocationApiConfig Configuration for the IP Location API.
     */
    public WebClientConfig(IpLocationApiConfig ipLocationApiConfig) {
        this.ipLocationApiConfig = ipLocationApiConfig;
    }

    /**
     * Method to create and configure a WebClient.
     *
     * @return Configured WebClient instance.
     */

    @Bean
    public WebClient getWebClient() {
        HttpClient httpClient = createDefaultWebClientWithTimeOut();
        return getWebClientConfigurations(httpClient, ipLocationApiConfig.getBaseUrl());
    }

    /**
     * Method to create an HttpClient with custom timeouts.
     *
     * @return Configured HttpClient instance.
     */
    private HttpClient createDefaultWebClientWithTimeOut() {

        return HttpClient.create().responseTimeout(DEFAULT_READ_TIMEOUT).doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(DEFAULT_READ_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS))).responseTimeout(DEFAULT_CONNECTION_TIMEOUT);
    }

    /**
     * Method to configure and build a WebClient.
     *
     * @param httpClient HttpClient instance to use with the WebClient.
     * @param baseUrl    Base URL for the WebClient.
     * @return Configured WebClient instance.
     */
    private WebClient getWebClientConfigurations(HttpClient httpClient, String baseUrl) {
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).baseUrl(baseUrl).defaultHeader(HttpHeaders.USER_AGENT, DEFAULT_USER_AGENT).build();
    }


}

