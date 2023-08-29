package io.akalabs.eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverdemoApplication.class, args);
	}

}
