package com.mebli.web.controllers;

import com.mebli.domain.Furniture;
import com.mebli.dto.FurnitureDTO;
import com.mebli.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FurnitureController {

    private FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @RequestMapping(value = "/furnitures/{id}", method = RequestMethod.GET)
    public FurnitureDTO findItemById(@PathVariable("id") Integer id) {
        return furnitureService.retrieveById(id);
    }

    @RequestMapping(value = "/furnitures", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> createElement(@Valid @RequestBody Furniture furniture) {
        try {
            furnitureService.saveElement(furniture);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }
    }
}
