package org.wael.microservice_workshp_maven.dto;

import java.math.BigDecimal;

public record ProductRequest(int id, String name, String description, BigDecimal price, Long categoryId, byte[] img,

                             long quantity) {
}
