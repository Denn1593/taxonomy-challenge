package com.dennishvidbergmadsen.challenge.services;

import com.dennishvidbergmadsen.challenge.exceptions.InvalidIdException;
import com.dennishvidbergmadsen.challenge.exceptions.InvalidNodeException;
import com.dennishvidbergmadsen.challenge.exceptions.InvalidTypeException;
import com.dennishvidbergmadsen.challenge.models.Node;
import com.dennishvidbergmadsen.challenge.models.NodeType;
import com.dennishvidbergmadsen.challenge.models.NodeTypeName;
import com.dennishvidbergmadsen.challenge.models.requests.CreateBuildingRequest;
import com.dennishvidbergmadsen.challenge.models.requests.CreateCorporationRequest;
import com.dennishvidbergmadsen.challenge.models.requests.CreatePropertyRequest;
import com.dennishvidbergmadsen.challenge.persistence.NodeRepository;
import com.dennishvidbergmadsen.challenge.persistence.NodeTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private NodeTypeRepository nodeTypeRepository;

    private Node validateParent(Long parentId, NodeTypeName type){
        Optional<Node> parentResponse = nodeRepository.findById(parentId);

        if(parentResponse.isEmpty()){
            throw new InvalidIdException(Node.class, parentId);
        }

        Node parent = parentResponse.get();


        if(type == NodeTypeName.BUILDING && parent.getType().getName() == NodeTypeName.PROPERTY) {
            throw new InvalidNodeException("Building cannot have property as parent");
        }

        return parent;
    }

    private NodeType validateType(NodeTypeName type){
        Optional<NodeType> typeResponse = nodeTypeRepository.findByName(type);

        if(typeResponse.isEmpty()){
            throw new InvalidTypeException(type.name());
        }

        return typeResponse.get();
    }


    // Public methods

    public Node getNode(long id){
        Optional<Node> nodeResponse = nodeRepository.findById(id);

        if(nodeResponse.isEmpty()){
            throw new InvalidIdException(Node.class, id);
        }

        return nodeResponse.get();
    }

    @Transactional
    public Node changeParent(long id, long parentId){
        Node node = getNode(id);
        Node newParent = validateParent(parentId, node.getType().getName());

        node.setParent(newParent);
        nodeRepository.save(node);
        return node;
    }

    @Transactional
    public Node createCorporation(CreateCorporationRequest body) {
        int height = 0;

        Node parent = null;
        if(body.getParentId() != null){
            parent = validateParent(body.getParentId(), NodeTypeName.CORPORATION);
            height = parent.getHeight() + 1;
        }

        NodeType type = validateType(NodeTypeName.CORPORATION);

        Node newNode = new Node();
        newNode.setHeight(height);
        newNode.setName(body.getName());
        newNode.setParent(parent);
        newNode.setType(type);
        nodeRepository.save(newNode);
        return newNode;
    }

    @Transactional
    public Node createBuilding(CreateBuildingRequest body) {
        int height = 0;

        Node parent = null;
        if(body.getParentId() != null){
            parent = validateParent(body.getParentId(), NodeTypeName.BUILDING);
            height = parent.getHeight() + 1;
        }

        NodeType type = validateType(NodeTypeName.BUILDING);

        Node newNode = new Node();
        newNode.setHeight(height);
        newNode.setName(body.getName());
        newNode.setParent(parent);
        newNode.setType(type);
        newNode.setZipCode(body.getZipCode());
        nodeRepository.save(newNode);
        return newNode;
    }

    @Transactional
    public Node createProperty(CreatePropertyRequest body) {
        int height = 0;

        Node parent = null;
        if(body.getParentId() != null){
            parent = validateParent(body.getParentId(), NodeTypeName.PROPERTY);
            height = parent.getHeight() + 1;
        }

        NodeType type = validateType(NodeTypeName.PROPERTY);

        Node newNode = new Node();
        newNode.setHeight(height);
        newNode.setName(body.getName());
        newNode.setParent(parent);
        newNode.setType(type);
        newNode.setMonthlyRent(body.getMonthlyRent());
        nodeRepository.save(newNode);
        return newNode;
    }
}
