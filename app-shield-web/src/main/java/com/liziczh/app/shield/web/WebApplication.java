package com.liziczh.app.shield.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.app.shield.internal.InternalApplication;
import com.liziczh.app.shield.mybatisplus.MybatisPlusApplication;
import com.liziczh.app.shield.ref.RefApplication;
import com.liziczh.app.shield.service.ServiceApplication;

@SpringBootApplication(scanBasePackages = { "com.liziczh.*" })
public class WebApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { MybatisPlusApplication.class, RefApplication.class, InternalApplication.class, ServiceApplication.class, WebApplication.class };
		SpringApplication.run(sources, args);
	}
}
