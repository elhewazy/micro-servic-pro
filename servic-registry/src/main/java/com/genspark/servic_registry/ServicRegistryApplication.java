package com.genspark.servic_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServicRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicRegistryApplication.class, args);
	}

}
