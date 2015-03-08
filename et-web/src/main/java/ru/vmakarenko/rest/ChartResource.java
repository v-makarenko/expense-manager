package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.common.GroupByType;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ChartService;
import ru.vmakarenko.services.ExpensesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("chartData")
public class ChartResource {
    @Inject
    private ChartService chartService;

    @GET
    public Response getData(@QueryParam(value = "for") String period) {
        Calendar to = Calendar.getInstance();
        Calendar from = Calendar.getInstance();
        GroupByType groupByType = GroupByType.HOUR;
        switch (period) {
            case "year":
                from.set(Calendar.MONTH, 0);
            case "month":
                from.set(Calendar.DAY_OF_MONTH, 0);
            case "week":
                from.set(Calendar.DAY_OF_WEEK, 0);
            case "day":
                from.set(Calendar.HOUR_OF_DAY, 0);
        }
        switch (period) {
            case "year":
                groupByType = GroupByType.MONTH;
                break;
            case "month":
                groupByType = GroupByType.WEEK;
                break;
            case "week":
                groupByType = GroupByType.DAY;
                break;
            case "day":
                groupByType = GroupByType.HOUR;
                break;
        }

        return Response.ok(chartService.getOrdered(from.getTime(), to.getTime(), groupByType)).build();


    }

}
