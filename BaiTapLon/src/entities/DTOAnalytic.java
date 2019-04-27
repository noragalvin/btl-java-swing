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
public class DTOAnalytic {
    String name, created_at;
    double price;
    int product_quantity;

    public DTOAnalytic() {
    }

    public DTOAnalytic(String name, String created_at, double price, int product_quantity) {
        this.name = name;
        this.created_at = created_at;
        this.price = price;
        this.product_quantity = product_quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    @Override
    public String toString() {
        return "DTOAnalytic{" + "name=" + name + ", created_at=" + created_at + ", price=" + price + ", product_quantity=" + product_quantity + '}';
    }
    
    
}
