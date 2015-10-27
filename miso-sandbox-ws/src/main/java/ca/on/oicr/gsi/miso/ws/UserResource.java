package ca.on.oicr.gsi.miso.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class UserResource {

  // private static final Logger log = LoggerFactory.getLogger(UserResource.class);

  @Context
  private UriInfo uriInfo;

  @GET
  @Produces({ "application/json" })
  @Path("/users")
  public String getUsers() {
    return "{name:'hello'}";
  }

}
