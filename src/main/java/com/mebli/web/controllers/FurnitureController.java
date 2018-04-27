package com.mebli.web.controllers;
import com.mebli.domain.Furniture;
import com.mebli.repository.FurnitureRepository;
import com.mebli.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@RestController
public class FurnitureController {
    private FurnitureRepository furnitureRepository;
    private FurnitureServiceImpl furnitureService;
    @Autowired
    public FurnitureController(FurnitureRepository furnitureRepository, FurnitureServiceImpl furnitureService){
        this.furnitureRepository=furnitureRepository;
        this.furnitureService=furnitureService;
    }
    @RequestMapping(value = "/furnitures/{id}", method = RequestMethod.GET)
    public Optional<Furniture> findItemById(@PathVariable("id")Integer id){
        return furnitureRepository.findById(id);
    }
    @RequestMapping(value = "/furnitures", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> createElement(@Valid @RequestBody Furniture furniture) {
        try {
            furnitureService.saveElement(furniture);
            return new ResponseEntity<String>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>( HttpStatus.CONFLICT);
        }
    }
}
