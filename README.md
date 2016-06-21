Description
===========

This example shows how Swagger annotations can be integrated with JAX-RS and Spring Boot to generate and serve API specification.

Instructions
------------

From the project root:

1) Build the project

    ./gradlew build
    
2) Run the jar

    ./java -jar build/libs/swagger-customer-api-1.0.jar
    
3) Get the API spec

    GET http://localhost:8080/swagger.json
