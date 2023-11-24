package com.example.api.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    //@Null(message = "The ID will be populated internally")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @JsonIgnore
    //@Null(message = "The created date is populated in runtime")
    @Column(name = "CREATED_DATE", nullable = false, updatable = false, precision = 14)
    private long createdDate;

    @JsonIgnore
    //@Null(message = "The created date is populated in runtime")
    @Column(name = "UPDATED_DATE", nullable = false, updatable = false, precision = 14)
    private long updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    @PrePersist
    private void onPrePersists(){
        createdDate = System.currentTimeMillis();
    }

    @PreUpdate
    private void onPreUpdate(){
        updatedDate = System.currentTimeMillis();
    }

}
