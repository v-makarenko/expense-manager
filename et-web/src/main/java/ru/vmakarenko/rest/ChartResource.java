package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.common.RestResult;
import ru.vmakarenko.services.ChartService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Security;
import java.util.Calendar;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("chartData")
public class ChartResource {
    @Inject
    private ChartService chartService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@QueryParam(value = "for") int period, @Context HttpServletRequest request) {
        if(request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE) == null){
            return Response.ok(RestResult.getBad()).build();
        }
        Calendar to = Calendar.getInstance();
        Calendar from = Calendar.getInstance();
        int groupByType = 0;
        switch (period) {
            case 3:
                from.set(Calendar.MONTH, 0);
            case 2:
                from.set(Calendar.DAY_OF_MONTH, 0);
            case 1:
                from.set(Calendar.DAY_OF_MONTH, 0);
            case 0:
                from.set(Calendar.HOUR_OF_DAY, 0);
        }
        switch (period) {
            case 3:
                groupByType = 3;
                break;
            case 2:
                groupByType = 2;
                break;
            case 1:
                groupByType = 1;
                break;
            case 0:
                groupByType = 0;
                break;
        }

        return Response.ok(chartService.getOrdered(from.getTime(), to.getTime(), groupByType)).build();


    }

}
