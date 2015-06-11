package ru.fes.services.expenses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import ru.fes.common.AppConsts;
import ru.fes.dao.impl.expenses.AccountDao;
import ru.fes.dao.impl.expenses.ValutaDao;
import ru.fes.dto.expenses.AccountDto;
import ru.fes.dto.expenses.ValutaDto;
import ru.fes.entities.ExpensesFilter;
import ru.fes.entities.common.User;
import ru.fes.entities.expenses.Account;
import ru.fes.entities.expenses.Expense;
import ru.fes.entities.expenses.Valuta;
import ru.fes.services.UserService;
import ru.fes.services.common.MapperService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @PersistenceContext
    EntityManager em;

    @Inject
    AccountDao dao;

    @Inject
    MapperService mapperService;



    public List<AccountDto> getAll() {
        return mapperService.map(dao.findAll(), AccountDto.class);
    }


    public void update(AccountDto dto) {
        dao.update(mapperService.map(dto, Account.class));
    }

    public void create(AccountDto dto) {
        dao.insert(mapperService.map(dto, Account.class));
    }

    public void delete(UUID id) {
        Account account =
                em.getReference(Account.class, id);
        if (account != null) {
            em.remove(account);
        } else {
            throw new RuntimeException("Wrong id!");
        }
    }
}
