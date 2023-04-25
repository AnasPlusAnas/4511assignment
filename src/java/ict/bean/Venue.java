/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author a1397
 */
import java.io.Serializable;

/**
 *
 * @author a1397
 */
//venue detail
public class Venue implements Serializable {

    private String name;
    private String address;
    private String img;
    private String capacity;
    private String description;
    private int booking_fee;
    private int personCharge;
    private int id;

    public Venue(int id, String name, String img, String address, String capacity, String description, int booking_fee,
            int personCharge) {
        this.name = name;
        this.img = img;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        this.booking_fee = booking_fee;
        this.personCharge = personCharge;
        this.id = id;

    }

    public Venue() {
        name = "";
        address = "";
        img = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDes() {
        return description;
    }

    public void setDes(String description) {
        this.description = description;
    }

    public int getBkFee() {
        return booking_fee;
    }

    public void setBkFee(int booking_fee) {
        this.booking_fee = booking_fee;
    }

    public int getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(int personCharge) {
        this.personCharge = personCharge;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getStatus() {
        return id;
    }

    public void setStatus(int id) {
        this.id = id;
    }

}
