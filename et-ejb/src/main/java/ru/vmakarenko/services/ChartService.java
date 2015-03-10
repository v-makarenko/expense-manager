package ru.vmakarenko.services;

import java.util.Date;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface ChartService {

    List<Long> getOrdered(Date from, Date to, int type);

}
