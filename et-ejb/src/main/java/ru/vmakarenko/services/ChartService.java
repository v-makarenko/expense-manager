package ru.vmakarenko.services;

import ru.vmakarenko.common.GroupByType;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface ChartService {

    List<Long> getOrdered(Date from, Date to, GroupByType type);
}
