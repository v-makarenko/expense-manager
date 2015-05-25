package ru.fes.entities.expenses;

import org.hibernate.annotations.Proxy;
import ru.fes.entities.common.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VMakarenko on 2/3/15.
 */
@Entity
@Table(name = "valutas")
@Proxy(lazy = false)
public class ExpenseCategory extends DomainEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
