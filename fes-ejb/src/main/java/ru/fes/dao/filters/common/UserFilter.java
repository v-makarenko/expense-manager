package ru.fes.dao.filters.common;

import ru.fes.dao.anno.FilterParam;

/**
 * Created by VMakarenko on 4/26/2015.
 */
public class UserFilter extends BasicFilter {
    @FilterParam
    private String email;
    @FilterParam
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserFilter email(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserFilter password(String password) {
        this.password = password;
        return this;
    }
}
