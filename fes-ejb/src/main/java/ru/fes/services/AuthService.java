package ru.fes.services;

import ru.fes.dto.user.AccessAuthDto;
import ru.fes.dto.user.UserAuthDto;
import ru.fes.entities.common.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */

@Stateless
public class AuthService {

    @PersistenceContext
    EntityManager em;

    @Inject
    UserService userService;

    public AccessAuthDto login(UserAuthDto dto){
        User user = userService.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user != null) {
            AccessAuthDto accessAuthDto = new AccessAuthDto();
            accessAuthDto.setId(dto.getEmail());
            accessAuthDto.setToken(UUID.randomUUID().toString());
            return accessAuthDto;
        }
        return null;
    }

    public User logout() {
        return null;
    }


    public boolean isAuthorized(String authId, String authToken) {
        return false;
    }
}
