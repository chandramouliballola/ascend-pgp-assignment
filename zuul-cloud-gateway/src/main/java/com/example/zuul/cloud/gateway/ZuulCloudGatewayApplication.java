package com.example.zuul.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ZuulCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulCloudGatewayApplication.class, args);
	}

}
