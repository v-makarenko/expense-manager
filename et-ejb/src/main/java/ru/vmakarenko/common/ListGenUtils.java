package ru.vmakarenko.common;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by VMakarenko on 3/4/15.
 */
public class ListGenUtils {
    public static List<Long> getList(int type){
        List<Long> resultList = new ArrayList<>();
        int q = 0;
        switch (type){
            case 0:
                q = 24;
                break;
            case 1:
                q = 7;
                break;
            case 2:
                q = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 3:
                q = 12;
                break;
        }
        for(int i = 0; i < q ; i++){
            resultList.add(0L);
        }
        return resultList;
    }

}
