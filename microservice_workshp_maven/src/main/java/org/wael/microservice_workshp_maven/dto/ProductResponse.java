package org.wael.microservice_workshp_maven.dto;

import java.math.BigDecimal;

public record ProductResponse (int id, String name, String description, BigDecimal price, Long categoryId,

                               Long quantity) {
}
