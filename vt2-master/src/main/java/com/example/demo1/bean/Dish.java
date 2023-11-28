package com.example.demo1.bean;

import java.util.Base64;

/**
 * Class representing a product.
 */
public class Dish {

    /** The unique identifier for the dish. */
    public int id;

    /** The name of the dish. */
    public String dishName;

    /** The price of the dish. */
    public int price;

    /** The description of the dish. */
    public String description;

    /** The image of the dish in Base64 format. */
    public String image;

    public int amount;

    /**
     * Constructor for creating a product with an image as a Base64 string.
     * @param id          the unique identifier for the product
     * @param productName the name of the product
     * @param price       the price of the product
     * @param image       the image of the product as a Base64 string
     */
    public Dish(int id, String productName, int price, String descr, String image) {
        this.id = id;
        this.dishName = productName;
        this.price = price;
        this.description = descr;
        this.image = image;
        this.amount = 0;
    }

    /**
     * Clones the product.
     * @return a new Product object with the same attributes as the original
     */
    public Dish Clone() {
        return new Dish(id, dishName, price, description, image);
    }

    /**
     * Gets the name of the product.
     * @return the name of the product
     */
    public String getDishName() {
        return dishName;
    }


    /**
     * Sets the name of the product.
     * @param dishName the name of the product to set
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the product.
     * @return the price of the product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the price of the product to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets the unique identifier for the product.
     * @return the unique identifier for the product
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the product.
     * @param id the unique identifier for the product to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the image of the product as a Base64 string.
     * @return the image of the product as a Base64 string
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image of the product as a Base64 string.
     * @param image the image of the product to set as a Base64 string
     */
    public void setImage(String image) {
        this.image = image;
    }
}
