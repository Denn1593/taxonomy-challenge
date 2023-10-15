package com.dennishvidbergmadsen.challenge.models.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreatePropertyRequest extends BaseNode{

    @NotNull
    @Min(0)
    private Integer monthlyRent;


    // Getters and setters


    public Integer getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Integer monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}
