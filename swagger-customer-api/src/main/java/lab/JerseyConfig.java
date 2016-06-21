package lab;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import lab.api.CustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
        register(CustomerResource.class);
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Customer API");
        beanConfig.setDescription("For performing CRUD operations on the Customers resource");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("lab.api");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }


}
