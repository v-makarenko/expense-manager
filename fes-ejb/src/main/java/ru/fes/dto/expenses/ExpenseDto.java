package ru.fes.dto.expenses;

import ru.fes.dto.common.IdDto;
import ru.fes.dto.common.IdNameDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 5/5/2015.
 */
public class ExpenseDto extends IdDto {
    private List<IdNameDto> tagList;
    private UUID categoryId;
    private String categoryName;

    public List<IdNameDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<IdNameDto> tagList) {
        this.tagList = tagList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }
}
