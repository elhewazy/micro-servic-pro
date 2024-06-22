package com.genspark.Customer_service.config;

import com.genspark.Customer_service.client.Bookclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    @LoadBalanced
    public WebClient bookWebClient() {
        return WebClient.builder()
                .baseUrl("http://book-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public Bookclient bookClient(){
        WebClientAdapter webClientAdapter = WebClientAdapter.create(bookWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(Bookclient.class);

    }


}
