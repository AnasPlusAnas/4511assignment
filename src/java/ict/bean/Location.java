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

public class Location implements Serializable {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public Location() {
        name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
