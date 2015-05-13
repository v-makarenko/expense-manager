package ru.fes.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fes.dao.filters.CommonFilter;
import ru.fes.dao.filters.UserFilter;
import ru.fes.dao.impl.common.UserDao;
import ru.fes.dto.user.UserDto;
import ru.fes.entities.common.User;
import ru.fes.services.common.MapperService;
import ru.fes.services.expenses.CategoryService;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Singleton
public class TokenService {
    private Map<String, String> tokenMap = new HashMap();

    public  synchronized boolean createEntry(String id, String token){
        if(checkEntry(id, token)){
            return false;
        }else {
            tokenMap.put(id, token);
            return true;
        }
    }

    public synchronized boolean checkEntry(String id, String token){
        String value = tokenMap.get(id);
        if(value != null){
            return value.equals(token);
        }else{
            return false;
        }
    }

    public synchronized boolean deleteEntry(String id, String token){
        String value = tokenMap.get(id);
        if(value != null){
            tokenMap.remove(id);
            return true;
        }else{
            return false;
        }
    }
}
