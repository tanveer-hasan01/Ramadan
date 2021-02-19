package com.example.ramadan;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ramadan")
public class Model_Room {

    @PrimaryKey(autoGenerate = true)
    int id;
    String iftar;
    String seheri;
    String category;
    String ramadan_sl,date;


    public Model_Room(String iftar, String seheri, String category, String ramadan_sl, String date) {

        this.iftar = iftar;
        this.seheri = seheri;
        this.category = category;
        this.ramadan_sl = ramadan_sl;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIftar() {
        return iftar;
    }

    public void setIftar(String iftar) {
        this.iftar = iftar;
    }

    public String getSeheri() {
        return seheri;
    }

    public void setSeheri(String seheri) {
        this.seheri = seheri;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRamadan_sl() {
        return ramadan_sl;
    }

    public void setRamadan_sl(String ramadan_sl) {
        this.ramadan_sl = ramadan_sl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
