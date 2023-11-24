package com.example.api.service;

import com.example.api.exception.ApiException;
import com.example.api.model.sample.SampleEntity;

public interface SampleService {

    SampleEntity registerDevice(SampleEntity sampleEntity) throws ApiException;
}
