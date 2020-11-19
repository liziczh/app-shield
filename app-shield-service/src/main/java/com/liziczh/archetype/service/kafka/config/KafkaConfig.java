package com.liziczh.archetype.service.kafka.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
@Configuration
public class KafkaConfig {
	@Value("${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapServers;
	@Value("${spring.kafka.init.create-topics}")
	private String createTopics;
	@Value("${spring.kafka.init.partition-num:1}")
	private String partitionNum;
	@Value("${spring.kafka.init.replication-factor:1}")
	private String replicationFactor;

	@PostConstruct
	private void createTopic() {
		if (StringUtils.isNoneBlank(createTopics, partitionNum, replicationFactor)) {
			List<NewTopic> newTopics = new ArrayList<>();
			for (String topicName : createTopics.split(",")) {
				newTopics.add(new NewTopic(topicName, Integer.parseInt(partitionNum), Short.parseShort(replicationFactor)));
			}
			AdminClient client = AdminClient.create(kafkaAdmin().getConfig());
			client.createTopics(newTopics);
			client.close();
		}
	}
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>(1);
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		KafkaAdmin admin = new KafkaAdmin(configs);
		return admin;
	}
}
