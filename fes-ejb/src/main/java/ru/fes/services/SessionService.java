package ru.fes.services;

import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
public class SessionService {
    private UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
