package ru.fes.entities.expenses;

import ru.fes.entities.common.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Entity
@Table(name = "expense_currency")
public class Currency  extends DomainEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "symbol")
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
