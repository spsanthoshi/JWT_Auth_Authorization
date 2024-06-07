package com.neuron.admin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class NeuronAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeuronAdminServerApplication.class, args);
	}

}
