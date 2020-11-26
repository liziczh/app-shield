package com.liziczh.app.shield.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.app.shield.internal.InternalApplication;
import com.liziczh.app.shield.mybatisplus.MybatisPlusApplication;
import com.liziczh.app.shield.ref.RefApplication;

@SpringBootApplication
public class MgmApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { MybatisPlusApplication.class, RefApplication.class, InternalApplication.class, MgmApplication.class };
		SpringApplication.run(sources, args);
	}
}
