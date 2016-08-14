package com.cobot00.cassandra_generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
public class ResourceConfiguration {

    @Value("${spring.datasource.url}")
    @Getter
    private String pgUrl;

    @Value("${spring.datasource.username}")
    @Getter
    private String pgUser;

    @Value("${spring.datasource.password}")
    @Getter
    private String pgPswd;

    @Value("${generator.output_directory}")
    @Getter
    private String outputDirectory;

    @Value("${generator.java_package_path}")
    @Getter
    private String javaPackagePath;
}
