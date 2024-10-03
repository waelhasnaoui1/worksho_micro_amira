package org.wael.microservice_workshp_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceWorkshpMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWorkshpMavenApplication.class, args);
    }

}
