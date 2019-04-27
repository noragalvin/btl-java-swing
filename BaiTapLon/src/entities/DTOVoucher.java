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
public class DTOVoucher {
    int status, discount_percent, id;
    String code;

    public DTOVoucher() {
    }

    public DTOVoucher(int status, int discount_percent, int id, String code) {
        this.status = status;
        this.discount_percent = discount_percent;
        this.id = id;
        this.code = code;
    }
    
    public DTOVoucher(String code, int percent) {
        this.code = code;
        this.discount_percent = percent;
    }
    
    
    public DTOVoucher(int id, String code, int percent) {
        this.code = code;
        this.discount_percent = percent;
        this.id = id;
    }
    
    public DTOVoucher(int id) {
        this.id = id;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DTOVoucher{" + "status=" + status + ", discount_percent=" + discount_percent + ", id=" + id + ", code=" + code + '}';
    }
    
    
}
