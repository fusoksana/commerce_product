package com.mebli.domain;

import javax.persistence.*;

@Entity
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;
    private String name;
    private String manufacturer;
    private String size;
    private int availability;
    private String description;

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public Category getCategory() {
        return category;
    }

    public Furniture() {
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