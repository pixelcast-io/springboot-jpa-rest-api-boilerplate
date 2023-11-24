# Getting Started

Springboot REST api boilerplate (template) application with the following configurations. 

* Springboot 3
* JPA integration for persistence. 
* Swagger integration for API documentation.
* liquibase integration for database change management. 
* Centralized exception handling. 

## Code Structure & Layers

### Configurations (config package)
* provider/PropertyProvider.java - An abstract implementation for the different type iof the property providers such as file based property providers, API based providers, etc. 
* provider/FilePropertyProvider - An implementation for a file based property provider where the application can use configuration/property files to do the application configuration.
* PropertyConfig.java - Injects the application property providers in the runtime based on the environment. 
* swagger/SwaggerConfig.java - For swagger configurations. 
* datasource/DataSourceConfig.java = For datasource configurations. Default configuration is MySql

### Constants (constant package)
All the application constants and definitions goes here. 

* ErrorCode.java - The error code definitions. 

### Models (model package)
All the entities comes here.

### DTOs (Data Transfer Objects = dto package)
If the entity cannot be directly exposed to the public, a transfer object can be used instead. In such cased the DTO classes comes here. 

### Controllers (controller package)
All the controller classes goes here. 

### Services (service package)
All the service classes goes here. 

### Repositories (repository package)
All the repositories goes here. 

### Exceptions (exception package)
All the custom exceptions goes here. 

* ApiErrorResponse.java - A common response entity to return the errors to the end user. 
* ApiExceptionHandler.java - The common exception handler.
