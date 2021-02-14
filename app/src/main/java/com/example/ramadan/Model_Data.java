package com.example.ramadan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Data {

    @SerializedName("date")
    @Expose
    private String date;


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

    public Model_Data(String date, String seheri, String iftar, String category) {
        this.date = date;
        this.seheri = seheri;
        this.iftar = iftar;
        this.category = category;
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

    public void setCategory(String category) {
        this.category = category;
    }
}
