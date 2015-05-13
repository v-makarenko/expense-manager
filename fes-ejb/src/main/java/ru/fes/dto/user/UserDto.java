package ru.fes.dto.user;

import ru.fes.dto.common.AbstractDto;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class UserDto extends AbstractDto {
    private String email;
    private String password;
    private String password2;
    private String name;
    private String surname;


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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
