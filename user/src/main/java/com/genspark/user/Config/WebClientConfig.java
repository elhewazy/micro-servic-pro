package com.genspark.user.Config;

import com.genspark.user.Client.BookClient;
import com.genspark.user.Client.CatalogClient;
import com.genspark.user.Client.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public WebClient catalogWebClient() {
        return WebClient.builder()
                .baseUrl("http://catalog-service")
                .filter(filterFunction)
                .build();
    }
    @Bean
    public WebClient bookWebClient() {
        return WebClient.builder()
                .baseUrl("http://book-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public WebClient customerWebClient() {
        return WebClient.builder()
                .baseUrl("http://customer-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public CatalogClient inventoryClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(catalogWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(CatalogClient.class);
    }

    @Bean
    BookClient bookClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(bookWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(BookClient.class);
    }

    @Bean
    CustomerClient customerClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(customerWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(CustomerClient.class);
    }
}
