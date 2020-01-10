package edu.curso.android.shipsmaru.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShipList {

    @SerializedName("results")
    private List<Ship> results;

    public List<Ship> getResults() {
        return results;
    }
}
