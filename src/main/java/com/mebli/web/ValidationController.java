package com.mebli.web;

import com.mebli.FurnitureValidator;
import com.mebli.domain.Furniture;
import com.mebli.repository.FurnitureRepository;
import com.mebli.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController


@RequestMapping(value = "/furniture")
public class ValidationController {
    private FurnitureValidator furnitureValidator;
    private FurnitureRepository furnitureRepository;
    private FurnitureServiceImpl furnitureService;
    @Autowired
    public ValidationController(FurnitureRepository furnitureRepository,FurnitureValidator furnitureValidator,FurnitureServiceImpl furnitureService){
        this.furnitureRepository=furnitureRepository;
        this.furnitureValidator=furnitureValidator;
        this.furnitureService=furnitureService;
    }
    @InitBinder("element")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(furnitureValidator);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> createElement(@Valid @RequestBody Furniture element) {
        try {
            furnitureService.saveElement(element);
            return new ResponseEntity<String>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>( HttpStatus.CONFLICT);
        }

    }
}
