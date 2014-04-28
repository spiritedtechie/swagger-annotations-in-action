package lab.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

@WebServlet(name = "SwaggerJaxrsConfig", loadOnStartup = 1)
public class SwaggerJaxrsConfig extends HttpServlet {

    static {
        BeanConfig bean = new BeanConfig();
        bean.setScan(true);
        bean.setResourcePackage("lab.api");
        // at some point, this should be made dynamically settable/configurable
        bean.setBasePath("http://swagger-api-server:8080/swagger-jaxrs-customer-service");
        bean.setVersion("1.0");
    }

}