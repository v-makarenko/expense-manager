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
    private Boolean isIncome = false;
    private Boolean isOutcome = false;
    private UUID parentId;
    private List<CategoryDto> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsIncome() {
        return isIncome;
    }

    public Boolean getIsOutcome() {
        return isOutcome;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public List<CategoryDto> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDto> children) {
        this.children = children;
    }

    public void setIsIncome(Boolean isIncome) {
        this.isIncome = isIncome;
    }

    public void setIsOutcome(Boolean isOutcome) {
        this.isOutcome = isOutcome;
    }
}
