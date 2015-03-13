package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.common.RestResult;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ExpensesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("expenses")
public class ExpensesResource {
    @Inject
    private ExpensesService expensesService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(value = "id") Long id, @Context HttpServletRequest request){
        try{
            return Response.ok(expensesService.getById(id)).build();
        }catch ( Exception e){
            return Response.ok(RestResult.getBad()).build();
        }
    }

    @POST
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(ExpensesFilter filter, @Context HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE);
        if(userObj == null) Response.ok(RestResult.getBad()).build();
        filter.setUser((User) request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE));
        return Response.ok(expensesService.getAll(filter)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExpense(Expense expense, @Context HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE);
        if(userObj == null) Response.ok(RestResult.getBad()).build();
        return Response.ok(expensesService.update(expense)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createExpense(Expense expense, @Context HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE);
        if(userObj == null) Response.ok(RestResult.getBad()).build();
        return Response.ok(
                expensesService.create(expense,
                        (User)request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE)
        )).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteExpense(@PathParam(value = "id") Long id, @Context HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE);
        if(userObj == null) Response.ok(RestResult.getBad()).build();
        expensesService.delete(id);
        return Response.ok().build();
    }

}
