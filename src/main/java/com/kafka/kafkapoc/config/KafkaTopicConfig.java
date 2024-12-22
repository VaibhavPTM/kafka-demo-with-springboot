package com.kafka.kafkapoc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaGuidesTopic () {
        return TopicBuilder.name("JavaGuides")
//                .partitions(10);
                .build();
    }

    @Bean
    public NewTopic javaJsonGuidesTopic () {
        return TopicBuilder.name("JsonJavaGuides")
//                .partitions(10);
                .build();
    }
}
