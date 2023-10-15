package com.dennishvidbergmadsen.challenge.models;

import jakarta.persistence.*;

@Entity
@Table(name = "node_type")
public class NodeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NodeTypeName name;

    // Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NodeTypeName getName() {
        return name;
    }

    public void setName(NodeTypeName name) {
        this.name = name;
    }
}
