package org.wael.microservice_workshp_maven.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Lob
    private String description;
    private BigDecimal price;
    // Reference to the category ID
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] img;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false) // Set nullable to false @OnDelete(action = OnDeleteAction.CASCADE) // Specify the cascade action
    @JsonIgnore
    private Category category;
    private long quantity;
}
