package com.dennishvidbergmadsen.challenge.persistence;

import com.dennishvidbergmadsen.challenge.models.NodeType;
import com.dennishvidbergmadsen.challenge.models.NodeTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodeTypeRepository extends JpaRepository<NodeType, Long> {

    public Optional<NodeType> findByName(NodeTypeName name);
}
