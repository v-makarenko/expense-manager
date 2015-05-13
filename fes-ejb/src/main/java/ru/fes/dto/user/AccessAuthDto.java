package ru.fes.dto.user;

import java.util.UUID;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class AccessAuthDto {
    private String token;
    private String id;

    public static final String COOKIE_TOKEN = "COOKIE_TOKEN";
    public static final String COOKIE_ID = "COOKIE_ID";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
