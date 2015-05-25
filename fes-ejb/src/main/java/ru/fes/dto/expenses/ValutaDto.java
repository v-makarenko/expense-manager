package ru.fes.dto.expenses;

import ru.fes.dto.common.IdDto;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class ValutaDto extends IdDto {
    private String name;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
