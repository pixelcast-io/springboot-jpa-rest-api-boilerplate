package com.example.api.repository;

import com.example.api.model.sample.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}