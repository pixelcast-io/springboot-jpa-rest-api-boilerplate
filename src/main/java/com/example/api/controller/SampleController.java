package com.example.api.controller;

import com.example.api.exception.ApiException;
import com.example.api.model.sample.SampleEntity;
import com.example.api.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class SampleController{

    @Autowired
    SampleService sampleService;
    @Operation(summary = "Create a new example entity.")
    @PostMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    public SampleEntity createEntity(@RequestBody SampleEntity sampleEntity) throws ApiException {
        return sampleService.registerDevice(sampleEntity);
    }
}
