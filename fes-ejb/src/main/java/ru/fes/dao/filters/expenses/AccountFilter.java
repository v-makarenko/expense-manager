package ru.fes.dao.filters.expenses;

import ru.fes.dao.anno.FilterParam;

/**
 * Created by vmakarenko on 04.03.2015.
 */
public class AccountFilter {
    @FilterParam(joinPath = "user", name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public AccountFilter username(String username) {
        this.username = username;
        return this;
    }
}
