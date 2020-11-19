package com.liziczh.archetype.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.archetype.mybatisplus.MybatisPlusApplication;
import com.liziczh.archetype.ref.RefApplication;
import com.liziczh.archetype.service.ServiceApplication;

@SpringBootApplication(scanBasePackages = { "com.liziczh.*" })
public class WebApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { MybatisPlusApplication.class, ServiceApplication.class, RefApplication.class, WebApplication.class };
		SpringApplication.run(sources, args);
	}
}
