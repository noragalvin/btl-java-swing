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
public class DTOProductBill {
    int bill_id, product_quantity;
    String product_id;
    double price;

    public DTOProductBill() {
    }

    public DTOProductBill(int bill_id, int product_quantity, String product_id, double price) {
        this.bill_id = bill_id;
        this.product_quantity = product_quantity;
        this.product_id = product_id;
        this.price = price;
    }
    
    

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DTOProductBill{" + "bill_id=" + bill_id + ", product_quantity=" + product_quantity + ", product_id=" + product_id + ", price=" + price + '}';
    }
    
}
