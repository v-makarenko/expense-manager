package ru.fes.entities.expenses;

import ru.fes.entities.common.DomainEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Entity
@Table(name = "expense_categories")
public class Category  extends DomainEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "is_income")
    private Boolean isIncome;
    @Column(name = "is_outcome")
    private Boolean isOutcome;
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsIncome() {
        return isIncome;
    }

    public void setIsIncome(Boolean isIncome) {
        this.isIncome = isIncome;
    }

    public Boolean getIsOutcome() {
        return isOutcome;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
