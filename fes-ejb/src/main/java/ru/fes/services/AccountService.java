package ru.fes.services;

import ru.fes.dao.filters.common.CommonFilter;
import ru.fes.dao.filters.expenses.AccountFilter;
import ru.fes.dao.impl.expenses.AccountDao;
import ru.fes.dao.impl.expenses.AccountTypeDao;
import ru.fes.dto.expenses.AccountDto;
import ru.fes.dto.expenses.AccountTypeDto;
import ru.fes.entities.expenses.Account;
import ru.fes.entities.expenses.AccountType;
import ru.fes.services.common.MapperService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@Stateless
public class AccountService {
    @Inject
    private SessionService sessionService;
    @Inject
    private AccountDao accountDao;
    @Inject
    private AccountTypeDao accountTypeDao;
    @Inject
    private MapperService mapperService;

    public List<AccountTypeDto> getAccountsWithTypes(){
        List<AccountTypeDto> accountTypeDtoList = new ArrayList<>();
        List<Account> accountList = accountDao.findAllByUserId(sessionService.getUserId());
        outer:
        for (Account account : accountList) {
            for (AccountTypeDto accountTypeDto : accountTypeDtoList) {
                if(account.getType().getId().equals(accountTypeDto.getId())){
                    accountTypeDto.getAccountList().add(mapperService.map(account, AccountDto.class));
                    break outer;
                }
            }
            accountTypeDtoList.add(mapperService.map(account.getType(), AccountTypeDto.class));
            AccountTypeDto accountTypeDto = accountTypeDtoList.get(accountTypeDtoList.size() - 1);
            accountTypeDto.setAccountList(new ArrayList<>());
            accountTypeDto.getAccountList().add(mapperService.map(account, AccountDto.class));
        }

        return accountTypeDtoList;
    }
}
