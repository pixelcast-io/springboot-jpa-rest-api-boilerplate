package com.example.api.model.sample;

import com.example.api.model.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "EXAMPLE")
public class SampleEntity extends BaseEntity {

    @Schema(description = "The name of the entity")
    @Column(name = "NAME", updatable = true, length = 100)
    private String description;

}
