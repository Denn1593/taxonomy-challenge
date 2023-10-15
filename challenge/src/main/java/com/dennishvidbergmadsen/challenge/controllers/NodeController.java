package com.dennishvidbergmadsen.challenge.controllers;

import com.dennishvidbergmadsen.challenge.models.Node;
import com.dennishvidbergmadsen.challenge.models.requests.CreateBuildingRequest;
import com.dennishvidbergmadsen.challenge.models.requests.CreateCorporationRequest;
import com.dennishvidbergmadsen.challenge.models.requests.CreatePropertyRequest;
import com.dennishvidbergmadsen.challenge.services.NodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/node")
@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Node> getNode(@PathVariable int id){
        return new ResponseEntity<>(nodeService.getNode(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/parent/{parentId}")
    public ResponseEntity<Node> changeParent(@PathVariable int id, @PathVariable int parentId){
        return new ResponseEntity<>(nodeService.changeParent(id, parentId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/corporation")
    public ResponseEntity<Node> createCorporation(@RequestBody @Valid CreateCorporationRequest body){
        return new ResponseEntity<>(nodeService.createCorporation(body), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/building")
    public ResponseEntity<Node> createBuilding(@RequestBody @Valid CreateBuildingRequest body){
        return new ResponseEntity<>(nodeService.createBuilding(body), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/property")
    public ResponseEntity<Node> createProperty(@RequestBody @Valid CreatePropertyRequest body){
        return new ResponseEntity<>(nodeService.createProperty(body), HttpStatus.OK);
    }
}
