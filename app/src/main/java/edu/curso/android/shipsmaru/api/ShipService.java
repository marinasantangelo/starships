package edu.curso.android.shipsmaru.api;

import retrofit2.Call;
import retrofit2.http.*;

public interface ShipService {

    @GET("starships/")
    public Call<ShipList> getShips();



}
