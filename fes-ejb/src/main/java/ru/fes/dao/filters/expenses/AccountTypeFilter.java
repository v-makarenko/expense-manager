package ru.fes.dao.filters.expenses;

import ru.fes.dao.anno.FilterParam;

/**
 * Created by vmakarenko on 04.03.2015.
 */
public class AccountTypeFilter {
    @FilterParam(joinPath = "user", name = "username")
    private Long username;

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
    public AccountTypeFilter username(Long username) {
        this.username = username;
        return this;
    }
}

