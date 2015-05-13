package ru.fes.rest;

import ru.fes.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("user")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Path("checkUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUsername(@QueryParam(value = "username") String username){
        return Response.ok().build();

    }
}

