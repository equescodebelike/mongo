package org.example.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoClientProperties {

	private String host;

	private Integer port;

	private String authenticationDatabase;

	private String database;

	private String username;

	private String password;
}
