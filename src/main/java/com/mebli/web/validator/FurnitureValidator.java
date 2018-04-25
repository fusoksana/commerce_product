package com.mebli.web.validator;

//import com.mebli.domain.Furniture;
//import com.mebli.service.FurnitureServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component("beforeCreateFurnitureValidator")
//public class FurnitureValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Furniture.class.equals(clazz);
//    }
//    @Override
//    public void validate(Object obj, Errors errors) {
//        Furniture element = (Furniture) obj;
//        if (checkInputString(element.getName())) {
//            errors.rejectValue("name", "name.empty");
//        }
//        if (checkInputString(String.valueOf(element.getSubCategory()))) {
//            errors.rejectValue("subCategory", "subCategory.empty");
//        }
//        if (checkInputString(element.getDescription())) {
//            errors.rejectValue("description", "description.empty");
//        }
//        if (checkInputString(element.getSize())) {
//            errors.rejectValue("size", "size.empty");
//        }
//        if (checkInputString(String.valueOf(element.getCategory()))) {
//            errors.rejectValue("category", "category.empty");
//        }
//        if (checkInputString(String.valueOf(element.getItemId()))) {
//            errors.rejectValue("itemId", "itemId.empty");
//        }
//        if (checkInputString(element.getManufacturer())) {
//            errors.rejectValue("manufacturer", "manufacturer.empty");
//        }
//        if (checkInputString(String.valueOf(element.getAvailability()))) {
//            errors.rejectValue("availability", "availability.empty");
//        }
//    }
//    private boolean checkInputString(String input) {
//        return (input == null || input.trim().length() == 0);
//    }
//}