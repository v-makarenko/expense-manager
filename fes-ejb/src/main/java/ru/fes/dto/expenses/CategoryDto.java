package ru.fes.dto.expenses;

import ru.fes.dto.common.AbstractDto;
import ru.fes.dto.common.IdDto;
import ru.fes.dto.common.IdNameDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class CategoryDto extends IdDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
