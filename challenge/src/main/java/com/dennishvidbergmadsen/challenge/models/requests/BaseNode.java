package com.dennishvidbergmadsen.challenge.models.requests;

import com.dennishvidbergmadsen.challenge.models.NodeType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BaseNode {

    private Long parentId;

    @NotBlank
    private String name;



    //Getters and setters


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
