package edu.curso.android.shipsmaru.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ship implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("cost_in_credits")
    private String cost;

    public Ship(){

    }

    public Ship(String name, String model, String manufacturer, String cost){
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }

    public String getModel(){
        return model;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String getCost(){
        return cost;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
