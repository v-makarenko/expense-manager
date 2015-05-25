package ru.fes.rest;

import ru.fes.common.AppConsts;
import ru.fes.common.RestResult;
import ru.fes.entities.ExpensesFilter;
import ru.fes.entities.common.User;
import ru.fes.entities.expenses.Expense;
import ru.fes.services.AccountService;
import ru.fes.services.expenses.ExpensesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("/private/accounts")
public class AccountResource {
    @Inject
    private AccountService accountService;

    @GET
    @Path("all")
    public Response getAll(){
        return Response.ok(RestResult.getOk().data(accountService.getAccountsWithTypes())).build();
    }
}
