package ru.fes.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fes.common.AppConsts;
import ru.fes.common.LoginPassCheckResult;
import ru.fes.dao.filters.CommonFilter;
import ru.fes.dao.filters.UserFilter;
import ru.fes.dao.impl.common.UserDao;
import ru.fes.dto.user.UserAuthDto;
import ru.fes.dto.user.UserDto;
import ru.fes.entities.common.User;
import ru.fes.services.common.MapperService;
import ru.fes.services.expenses.CategoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @PersistenceContext
    EntityManager em;

    @Inject
    CategoryService categoryService;

    @Inject
    MapperService mapperService;

    @Inject
    UserDao dao;

    public void createUser(UserDto dto) {
        User user = mapperService.map(dto, User.class);
        addDefaults();
        em.persist(user);
    }

    private void addDefaults() {
        addDefaultValutas();
        addDefaultCategories();
    }

    private void addDefaultValutas() {

    }

    private void addDefaultCategories() {

    }

    public User findByEmailAndPassword(String email, String password) {
        List<User> userList = dao.findAll(new CommonFilter(new UserFilter()
                .email(email)
                .password(password)));
        if(userList.isEmpty()){
            return null;
        }else{
            return userList.get(0);
        }
    }
}
