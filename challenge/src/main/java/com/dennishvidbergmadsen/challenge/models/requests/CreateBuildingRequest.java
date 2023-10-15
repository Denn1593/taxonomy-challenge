package com.dennishvidbergmadsen.challenge.models.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CreateBuildingRequest extends BaseNode {

    @Min(1000)
    @Max(9999)
    private Integer zipCode;

    // Getters and setters


    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
