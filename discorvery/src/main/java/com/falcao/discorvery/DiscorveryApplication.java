package com.falcao.discorvery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscorveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscorveryApplication.class, args);
	}

}
