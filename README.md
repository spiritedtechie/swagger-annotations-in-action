swagger-jaxrs-in-action
=======================

This example shows how Swagger annotations can be integrated with JAX-RS, RESTEasy and Spring.

Instructions
------------
1. Build the Maven project with 'mvn clean package'.

2. Deploy the WAR to a JBoss 7/EAP instance running on localhost.

3. Install Swagger UI i.e. follow steps 4, 5 and 6 from the following:

  https://github.com/spiritedtechie/swagger-ui-in-action

3. Point Swagger UI to the api specification:
  
  http://localhost:8080/swagger-jaxrs-customer-service/api-docs

4. Check that the it all works by performing the CRUD operations from within the Swagger UI documentation.


Key Points
----------
