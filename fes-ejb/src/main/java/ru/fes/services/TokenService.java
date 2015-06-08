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

    public  synchronized boolean createEntry(String username, String token){
        if(checkEntry(username, token)){
            return false;
        }else {
            tokenMap.put(username, token);
            return true;
        }
    }

    public synchronized boolean checkEntry(String username, String token){
        String value = tokenMap.get(username);
        if(value != null){
            return value.equals(token);
        }else{
            return false;
        }
    }

    public synchronized boolean deleteEntry(String username, String token){
        String value = tokenMap.get(username);
        if(value != null){
            tokenMap.remove(username);
            return true;
        }else{
            return false;
        }
    }
}
