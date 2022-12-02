package com.kruger.msvc.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCursoApplication.class, args);
	}

}
