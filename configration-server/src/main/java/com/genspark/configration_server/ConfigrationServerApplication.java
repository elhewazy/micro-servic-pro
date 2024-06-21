package com.genspark.configration_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigrationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigrationServerApplication.class, args);
	}

}
