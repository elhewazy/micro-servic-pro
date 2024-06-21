package com.genspark.user.Config;

import com.genspark.user.Client.InventoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient inventoryWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public InventoryClient inventoryClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(inventoryWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}
