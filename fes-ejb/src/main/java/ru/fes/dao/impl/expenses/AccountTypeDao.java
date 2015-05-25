package ru.fes.dao.impl.expenses;

import ru.fes.dao.generic.GenericDao;
import ru.fes.dto.expenses.AccountTypeDto;
import ru.fes.entities.expenses.Account;
import ru.fes.entities.expenses.AccountType;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Stateless
public class AccountTypeDao extends GenericDao<AccountType> {

}
