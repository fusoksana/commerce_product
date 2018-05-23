package com.mebli.dto;

public class FurnitureDTO {

    private int itemId;

    private int categoryId;

    private int subCategoryId;

    private String name;

    private String manufacturer;

    private String size;

    private int availability;

    private String description;

    public int getSubCategory() {
        return subCategoryId;
    }

    public int getCategory() {
        return categoryId;
    }

    public FurnitureDTO() {
    }

    public void setCategoryId(int categoryId){
        this.categoryId=categoryId;
    }

    public void setSubCategoryId(int subCategoryId){
        this.subCategoryId=subCategoryId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
