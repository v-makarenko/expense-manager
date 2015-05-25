package ru.fes.dto.expenses;

import ru.fes.dto.common.IdDto;

import java.util.UUID;

/**
 * Created by VMakarenko on 5/24/2015.
 */
public class AccountDto extends IdDto{
    private String name;
    private UUID accountTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(UUID accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
}
