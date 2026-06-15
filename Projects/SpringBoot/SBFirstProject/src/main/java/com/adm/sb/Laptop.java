package com.adm.sb;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private String brand;
    private int Lid;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLid() {
        return Lid;
    }

    public void setLid(int lid) {
        Lid = lid;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", Lid=" + Lid +
                '}';
    }
    public void compile(){
        System.out.println("Laptop Created");
    }
}
