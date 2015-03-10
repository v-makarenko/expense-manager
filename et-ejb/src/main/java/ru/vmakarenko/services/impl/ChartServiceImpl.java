package ru.vmakarenko.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vmakarenko.common.ListGenUtils;
import ru.vmakarenko.services.ChartService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
@Local(ChartService.class)
@Named
public class ChartServiceImpl implements ChartService {
    private static final Logger logger = LoggerFactory.getLogger(ChartServiceImpl.class);
    @PersistenceContext
    EntityManager em;


    @Override
    public List<Long> getOrdered(Date from, Date to, int type) {
        String formattingPart = "";
        switch (type) {
            case 0:
                formattingPart = "to_char(date_time, 'HH24')";
                break;
            case 1:
                formattingPart = "to_char(date_time, 'D')";
                break;
            case 2:
                formattingPart = "to_char(date_time, 'DD')";
                break;
            case 3:
                formattingPart = "to_char(date_time, 'MM')";
                break;
        }
        String query = "select sum(e.amount), " + formattingPart + " from expense e " +
                "where date_time > :dateTimeFrom and date_time < :dateTimeTo " +
                " group by " + formattingPart;
        List<Object[]> resultList = em.createNativeQuery(query).setParameter("dateTimeFrom", from).setParameter("dateTimeTo", to).getResultList();
        List<Long> list = ListGenUtils.getList(type);
        for (Object[] row : resultList) {
            list.set(Integer.parseInt((String) row[1]) - 1, ((BigDecimal) row[0]).subtract(new BigDecimal(1)).longValue());
        }
        return list;
    }

}
