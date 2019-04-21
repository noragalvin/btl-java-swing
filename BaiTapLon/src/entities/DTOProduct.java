/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author aboyb
 */
public class DTOProduct {
    private int quantity, status, category_id;
    private String name, id;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DTOProduct() {
    }

    public DTOProduct(String id, int quantity, int status, int category_id, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "quantity=" + quantity + ", status=" + status + ", category_id=" + category_id + ", name=" + name + ", id=" + id + ", price=" + price + '}';
    }

    
    
}
