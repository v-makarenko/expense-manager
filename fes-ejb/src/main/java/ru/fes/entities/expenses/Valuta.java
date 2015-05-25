package ru.fes.entities.expenses;

import org.hibernate.annotations.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fes.entities.common.DomainEntity;
import ru.fes.entities.common.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by VMakarenko on 2/3/15.
 */
@Entity
@Table(name = "valutas")
@Proxy(lazy = false)
public class Valuta extends DomainEntity {
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
