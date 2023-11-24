package com.example.api.service.impl;

import com.example.api.exception.ApiException;
import com.example.api.model.sample.SampleEntity;
import com.example.api.service.SampleService;
import com.example.api.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Autowired
    SampleRepository deviceRepository;
    @Override
    public SampleEntity registerDevice(SampleEntity sampleEntity) throws ApiException {
        return deviceRepository.save(sampleEntity);
    }
}
