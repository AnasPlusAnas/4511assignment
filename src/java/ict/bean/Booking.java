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
public class Booking {

    private int id, fee;
    private String venue, userName, date, time1, time2, time3, time4, guest1, guest2, guest3, guest4, guest5, guest6, guest7, guest8, guest9, guest10, status;

    public Booking() {
        this.id = 0;
        this.fee = 0;
        this.venue = "";
        this.userName = "";
        this.date = "";
        this.time1 = "";
        this.time2 = "";
        this.time3 = "";
        this.time4 = "";
        this.guest1 = "";
        this.guest2 = "";
        this.guest3 = "";
        this.guest4 = "";
        this.guest5 = "";
        this.guest6 = "";
        this.guest7 = "";
        this.guest8 = "";
        this.guest9 = "";
        this.guest10 = "";
        this.status = "";
    }

    public Booking(int id, String venue, String userName, String date, String time1, String time2, String time3, String time4, int fee, String guest1, String guest2, String guest3, String guest4, String guest5, String guest6, String guest7, String guest8, String guest9, String guest10) {
        this.id = id;
        this.venue = venue;
        this.userName = userName;
        this.date = date;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.fee = fee;
        this.guest1 = guest1;
        this.guest2 = guest2;
        this.guest3 = guest3;
        this.guest4 = guest4;
        this.guest5 = guest5;
        this.guest6 = guest6;
        this.guest7 = guest7;
        this.guest8 = guest8;
        this.guest9 = guest9;
        this.guest10 = guest10;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getGuest1() {
        return guest1;
    }

    public void setGuest1(String guest1) {
        this.guest1 = guest1;
    }

    public String getGuest2() {
        return guest2;
    }

    public void setGuest2(String guest2) {
        this.guest2 = guest2;
    }

    public String getGuest3() {
        return guest3;
    }

    public void setGuest3(String guest3) {
        this.guest3 = guest3;
    }

    public String getGuest4() {
        return guest4;
    }

    public void setGuest4(String guest4) {
        this.guest4 = guest4;
    }

    public String getGuest5() {
        return guest5;
    }

    public void setGuest5(String guest5) {
        this.guest5 = guest5;
    }

    public String getGuest6() {
        return guest6;
    }

    public void setGuest6(String guest6) {
        this.guest6 = guest6;
    }

    public String getGuest7() {
        return guest7;
    }

    public void setGuest7(String guest7) {
        this.guest7 = guest7;
    }

    public String getGuest8() {
        return guest8;
    }

    public void setGuest8(String guest8) {
        this.guest8 = guest8;
    }

    public String getGuest9() {
        return guest9;
    }

    public void setGuest9(String guest9) {
        this.guest9 = guest9;
    }

    public String getGuest10() {
        return guest10;
    }

    public void setGuest10(String guest10) {
        this.guest10 = guest10;
    }

    public String getStatus() {
        return this.status;

    }

    public void setStatus(String status) {
        this.status = status;
    }
}
