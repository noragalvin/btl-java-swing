package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aboyb
 */
public class DTOCategory {
    private int id, status;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DTOCategory() {
    }

    public DTOCategory(int id, int status, String name) {
        this.id = id;
        this.status = status;
        this.name = name;
    }
    
    public DTOCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public DTOCategory(String name) {
        this.name = name;
    }
    
    public DTOCategory(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", status=" + status + ", name=" + name + '}';
    }

    
    
    
}
