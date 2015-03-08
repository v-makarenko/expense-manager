package ru.vmakarenko.common;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by VMakarenko on 3/4/15.
 */
public class ListGenUtils {
    public static List<Long> getList(GroupByType type){
        List<Long> resultList = new ArrayList<>();
        int q = 0;
        switch (type){
            case DAY:
                q = 7;
                break;
            case HOUR:
                q = 24;
                break;
            case MONTH:
                q = 12;
                break;
            case WEEK:
                q = Calendar.getInstance().getMaximum(Calendar.WEEK_OF_MONTH);
                break;
        }
        for(int i = 0; i < q ; i++){
            resultList.add(0L);
        }
        return resultList;
    }

}
