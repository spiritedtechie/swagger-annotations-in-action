package lab.api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.jaxrs.listing.ApiListingResource;

@Path("/api-docs")
@Api("/api-docs")
@Produces(value = { "application/json" })
class ApiListingResourceJSON extends ApiListingResource {

}