package com.liziczh.archetype.ref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.liziczh.*" })
public class RefApplication {
	public static void main(String[] args) {
		SpringApplication.run(RefApplication.class, args);
	}
}
