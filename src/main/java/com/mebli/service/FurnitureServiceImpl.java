package com.mebli.service;

import com.mebli.domain.Furniture;
import com.mebli.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FurnitureServiceImpl  implements FurnitureService {
    public FurnitureRepository furnitureRepository;
    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository){
        this.furnitureRepository=furnitureRepository;
    }
    @Transactional
    @Override
    public void saveElement(Furniture element) {
        furnitureRepository.save(element);
    }
}
