package ru.fes.rest;

import ru.fes.services.UserService;
import ru.fes.services.expenses.CategoryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("expenseCategory")
public class ExpenseCategoryResource {
    @Inject
    private CategoryService service;
    @GET
    public Response getCategories(){
        return Response.ok().build();
    }
}

