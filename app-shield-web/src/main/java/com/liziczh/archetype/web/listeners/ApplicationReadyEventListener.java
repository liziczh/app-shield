package com.liziczh.archetype.web.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		log.info("===========ApplicationReadyEvent========");
	}
}
