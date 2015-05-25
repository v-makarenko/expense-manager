package ru.fes.entities.expenses;


import ru.fes.entities.common.DomainEntity;
import ru.fes.entities.common.User;

import javax.persistence.*;

/**
 * Created by VMakarenko on 5/19/2015.
 */
@Entity
@Table(name = "account_types")
public class AccountType extends DomainEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
