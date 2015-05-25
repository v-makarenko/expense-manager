package ru.fes.dao.impl.expenses;

import ru.fes.dao.generic.GenericDao;
import ru.fes.dto.expenses.AccountTypeDto;
import ru.fes.entities.expenses.Account;
import ru.fes.entities.expenses.AccountType;

import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Stateless
public class AccountDao extends GenericDao<Account> {


    public List<Account> findAllByUserId(UUID id) {
        return em.createQuery("select a from Account a where a.user.id = :id", Account.class)
                .setParameter("id", id).getResultList();
    }
}
