package org.wael.microservice_workshp_maven.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @GetMapping("/datasource")
    public ResponseEntity<String> getDatasource() {
        String configDetails = String.format(
                "URL: %s, Username: %s ,Password: %s",
                datasourceUrl,
                datasourceUsername,
                datasourcePassword
        );
        return ResponseEntity.ok(configDetails);
    }


}
