package com.liziczh.archetype.web.listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebServerInitEventListener implements ApplicationListener<WebServerInitializedEvent> {
	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		String address = null;
		try {
			address = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Integer port = event.getWebServer().getPort();
		Environment env = event.getApplicationContext().getEnvironment();
		String contextPath = env.getProperty("server.servlet.context-path");
		log.info("Swagger API：http://{}:{}{}/doc.html", address, port, contextPath);
	}
}
