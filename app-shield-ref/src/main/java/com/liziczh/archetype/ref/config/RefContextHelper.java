package com.liziczh.archetype.ref.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RefContextHelper {
	@Value("${health.username}")
	private String USERNAME;
	@Value("${health.password}")
	private String PASSWORD;
	@Value("${archetype.web}")
	private String ARCHETYPE_WEB;
	private Map<String, String> config = new HashMap<String, String>();

	public String getProperty(String key) {
		return config.get(key);
	}
	@PostConstruct
	public void initConfig() {
		config.put("USERNAME", USERNAME);
		config.put("PASSWORD", PASSWORD);
		config.put("ARCHETYPE_WEB.DEMO.HELLO", "http://"+ARCHETYPE_WEB+"/demo/hello");
	}
}
