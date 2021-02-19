package com.example.ramadan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Data {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("ramadan_sl")
    @Expose
    private String ramadan_sl;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("seheri")
    @Expose
    private String seheri;

    @SerializedName("iftar")
    @Expose
    private String iftar;

    @SerializedName("category")
    @Expose
    private String category;

    public Model_Data(String date, String seheri, String iftar, String category,String ramadan_sl) {
        this.date = date;
        this.seheri = seheri;
        this.iftar = iftar;
        this.category = category;
        this.ramadan_sl = ramadan_sl;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeheri() {
        return seheri;
    }

    public void setSeheri(String seheri) {
        this.seheri = seheri;
    }

    public String getIftar() {
        return iftar;
    }

    public void setIftar(String iftar) {
        this.iftar = iftar;
    }

    public String getCategory() {
        return category;
    }

    public String getRamadan_sl() {
        return ramadan_sl;
    }

    public void setRamadan_sl(String ramadan_sl) {
        this.ramadan_sl = ramadan_sl;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
