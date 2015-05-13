package ru.fes.entities;

import ru.fes.entities.common.User;

import java.util.Date;

/**
 * Created by VMakarenko on 2/4/15.
 */
public class ExpensesFilter {
    private Integer amountMin;
    private Integer amountMax;
    private String dateFrom;
    private String dateTo;
    private String description;
    private String comment;
    private User user;
    private Date timestampFrom;
    private Date timestampTo;


    public Integer getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(Integer amountMin) {
        this.amountMin = amountMin;
    }

    public Integer getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(Integer amountMax) {
        this.amountMax = amountMax;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ExpensesFilter timestampFrom(Date date){
        timestampFrom = date;
        return this;
    }

    public ExpensesFilter timestampTo(Date date){
        timestampTo = date;
        return this;
    }

    public Date getTimestampFrom() {
        return timestampFrom;
    }

    public void setTimestampFrom(Date timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    public Date getTimestampTo() {
        return timestampTo;
    }

    public void setTimestampTo(Date timestampTo) {
        this.timestampTo = timestampTo;
    }
}
