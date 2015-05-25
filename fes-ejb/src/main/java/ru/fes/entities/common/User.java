package ru.fes.entities.common;

import org.hibernate.annotations.Proxy;
import ru.fes.entities.expenses.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by VMakarenko on 2/3/15.
 */
@Entity
@Table(name="users")
@Proxy(lazy = false)
public class User extends DomainEntity {
    @Column(name="password")
    @NotNull
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="phone")
    private String phone;
    @ManyToMany
    @JoinTable(name = "userы_accountы",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="account_id"))
    private List<Account> accountList;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
