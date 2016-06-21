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
    
3) Check the API spec

    GET http://localhost:8080/swagger.json
    
4) Go to:

    http://petstore.swagger.io/

5) Change URL in top bar to:

    http://localhost:8080/swagger.json

6) Hit 'Explore' and expand 'customers'. You should see the operations on Customer.

7) Have a play with each operation. These work against the running service.
