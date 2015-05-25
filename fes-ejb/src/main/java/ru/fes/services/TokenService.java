package ru.fes.services;

import javax.ejb.Singleton;
import java.util.HashMap;
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
