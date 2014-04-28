package lab.api;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import lab.domain.Customer;
import lab.domain.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Component
@Path("/api/customers")
@Api(value = "/customers", description = "the customer API")
public class CustomerResource {

    private CustomerService service;

    @Autowired
    public CustomerResource(final CustomerService service) {
        this.service = service;
    }

    public CustomerResource() {
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @ApiOperation(value = "Get all customers", notes = "This will retrieve all customers for the company", response = Customers.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Customer(s) found"),
            @ApiResponse(code = 404, message = "Customer not found") })
    public Response getCustomers() {
        final Customers customers = service.allCustomers();
        if (customers == null || customers.getCustomers() == null || customers.getCustomers().isEmpty())
            return Response.status(Status.NOT_FOUND).entity("Customers not found").build();
        return Response.ok(customers).build();
    }

    @GET
    @Path("/{customerId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @ApiOperation(value = "Get customer by id", notes = "This will retrieve a customer by id", response = Customer.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Customer found"),
            @ApiResponse(code = 404, message = "Customer not found") })
    public Response getCustomer(
            @PathParam("customerId") @ApiParam(defaultValue = "1", required = true) final String customerId) {
        final Customer customer = service.findCustomer(customerId);
        if (customer == null) return Response.status(Status.NOT_FOUND).entity("Customer not found").build();
        return Response.ok(customer).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @ApiOperation(value = "Create a new customer", notes = "This will create a new customer with a unique id", response = Customer.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Customer has been created"),
            @ApiResponse(code = 400, message = "Customer details supplied are invalid") })
    public Response createCustomer(final Customer customer) throws Exception {
        final Customer createdCustomer = service.newCustomer(customer);
        return Response.created(new URI("/customer/" + customer.getId())).entity(createdCustomer).build();
    }

    @PUT
    @Path("/{customerId}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @ApiOperation(value = "Updates an existing customer", notes = "This will update a customer with supplied id", response = Customer.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Customer has been updated"),
            @ApiResponse(code = 400, message = "Customer details supplied are invalid"),
            @ApiResponse(code = 404, message = "Customer not found") })
    public Response updateCustomer(@PathParam("customerId") final String customerId, final Customer customer)
            throws Exception {
        final Customer findCustomer = service.findCustomer(customerId);
        if (findCustomer == null) return Response.status(Status.NOT_FOUND).entity("Customer not found").build();
        customer.setId(customerId);
        final Customer updatedCustomer = service.updateCustomer(customer);
        return Response.ok(updatedCustomer).build();
    }

    @DELETE
    @Path("/{customerId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @ApiOperation(value = "Deletes an existing customer", notes = "This will delete a customer with supplied id", response = Customer.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Customer has been deleted"), })
    public Response updateCustomer(@PathParam("customerId") final String customerId) throws Exception {
        final Customer deletedCustomer = service.deleteCustomer(customerId);
        if (deletedCustomer != null) return Response.ok().entity(deletedCustomer).build();
        return Response.ok().entity("No customer to delete").build();
    }

    @OPTIONS
    @Path("/{path:.*}")
    public Response options() {
        return Response.ok().build();
    }

    @OPTIONS
    public Response options2() {
        return Response.ok().build();
    }

}
