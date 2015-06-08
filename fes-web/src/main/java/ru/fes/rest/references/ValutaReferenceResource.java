package ru.fes.rest.references;

import ru.fes.common.AppConsts;
import ru.fes.common.RestResult;
import ru.fes.dto.expenses.ValutaDto;
import ru.fes.entities.ExpensesFilter;
import ru.fes.entities.common.User;
import ru.fes.entities.expenses.Expense;
import ru.fes.services.expenses.ExpensesService;
import ru.fes.services.expenses.ValutaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("references/valuta")
public class ValutaReferenceResource {
    @Inject
    private ValutaService service;


    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(RestResult.getOk().data(service.getAll())).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(ValutaDto dto, @Context HttpServletRequest request){
        service.update(dto);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ValutaDto dto, @Context HttpServletRequest request){
        service.create(dto);
        return Response.ok().build();
    }


    @DELETE
    public Response delete(@QueryParam(value = "id") UUID id
            , @Context HttpServletRequest request){
        service.delete(id);
        return Response.ok().build();
    }

}
