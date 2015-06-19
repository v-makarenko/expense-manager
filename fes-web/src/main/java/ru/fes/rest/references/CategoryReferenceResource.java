package ru.fes.rest.references;

import ru.fes.common.RestResult;
import ru.fes.dto.expenses.AccountDto;
import ru.fes.dto.expenses.CategoryDto;
import ru.fes.services.expenses.AccountService;
import ru.fes.services.expenses.CategoryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("private/references/category")
public class CategoryReferenceResource {
    @Inject
    private CategoryService service;


    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(RestResult.getOk().data(service.getAll())).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(CategoryDto dto){
        service.update(dto);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CategoryDto dto){
        service.create(dto);
        return Response.ok().build();
    }


    @DELETE
    public Response delete(@QueryParam(value = "id") UUID id){
        service.delete(id);
        return Response.ok().build();
    }

}
