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
public class DTOBill {
    int id, staff_id, customer_id;
    String voucher_id, created_at;
    double total_prices, discount_prices;

    public DTOBill(int id, int staff_id, int customer_id, String voucher_id, String created_at, double total_prices, double discount_prices) {
        this.id = id;
        this.staff_id = staff_id;
        this.customer_id = customer_id;
        this.voucher_id = voucher_id;
        this.created_at = created_at;
        this.total_prices = total_prices;
        this.discount_prices = discount_prices;
    }
    
    public DTOBill(int staff_id, int customer_id, String voucher_id, String created_at, double total_prices, double discount_prices) {
        this.staff_id = staff_id;
        this.customer_id = customer_id;
        this.voucher_id = voucher_id;
        this.created_at = created_at;
        this.total_prices = total_prices;
        this.discount_prices = discount_prices;
    }
    
    public DTOBill(int staff_id, int customer_id, String voucher_id, double total_prices, double discount_prices) {
        this.staff_id = staff_id;
        this.customer_id = customer_id;
        this.voucher_id = voucher_id;
        this.total_prices = total_prices;
        this.discount_prices = discount_prices;
    }

    public DTOBill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal_prices() {
        return total_prices;
    }

    public void setTotal_prices(double total_prices) {
        this.total_prices = total_prices;
    }

    public double getDiscount_prices() {
        return discount_prices;
    }

    public void setDiscount_prices(double discount_prices) {
        this.discount_prices = discount_prices;
    }

    @Override
    public String toString() {
        return "DTOBill{" + "id=" + id + ", staff_id=" + staff_id + ", customer_id=" + customer_id + ", voucher_id=" + voucher_id + ", created_at=" + created_at + ", total_prices=" + total_prices + ", discount_prices=" + discount_prices + '}';
    }
    
    
}
