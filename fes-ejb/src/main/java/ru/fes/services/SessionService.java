package ru.fes.services;

import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
public class SessionService {
    private UUID userId;
    private String email;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
