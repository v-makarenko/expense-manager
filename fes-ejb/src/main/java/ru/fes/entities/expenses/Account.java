package ru.fes.entities.expenses;


import ru.fes.entities.common.DomainEntity;
import ru.fes.entities.common.User;

import javax.persistence.*;

/**
 * Created by VMakarenko on 5/19/2015.
 */
@Entity
@Table(name = "accounts")
public class Account extends DomainEntity {
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="account_type_id")
    private AccountType type;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
