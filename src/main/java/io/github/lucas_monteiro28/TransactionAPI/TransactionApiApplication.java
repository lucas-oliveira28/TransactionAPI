package io.github.lucas_monteiro28.TransactionAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "io.github.lucas_monteiro28.TransactionAPI.controllers")
public class TransactionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApiApplication.class, args);
	}

}
