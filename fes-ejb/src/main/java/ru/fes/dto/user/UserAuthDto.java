package ru.fes.dto.user;

import ru.fes.dto.common.AbstractDto;
import ru.fes.dto.common.CommonDto;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class UserAuthDto extends AbstractDto {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
