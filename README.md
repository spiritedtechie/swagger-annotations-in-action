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
1. In the web.xml, the SpringContextLoaderListener is used to load JAX-RS resources and providers into RESTEasy from the Spring application context.
2. The CustomerResource has a @Component annotation and so is implicitly scanned into the Spring application context. The Swagger resources and providers do NOT have this annotation.
3. Due to 1 and 2, the Swagger resources and providers must be explicitly listed in the WEB-INF/applicationContext.xml. 
4. If not using Spring, then simply define an Application class returning the resource and provider classes.
5. The SwaggerJaxrsConfig servlet class uses a BeanConfig to set the Swagger JAX-RS properties and configuration. This could instead be added to the Spring context file.
6. The CORSFilter is needed if the Swagger UI is on a different server to the API service.
7. Swagger annotations have been added to the CustomerResource class, and the model classes (Customers, Customer), to define the documentation for the APIs.
