package ru.fes.dto.expenses;

import ru.fes.dto.common.IdDto;

import java.util.List;

/**
 * Created by VMakarenko on 5/24/2015.
 */
public class AccountTypeDto extends IdDto{
    private String name;
    private List<AccountDto> accountList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountDto> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountDto> accountList) {
        this.accountList = accountList;
    }
}
