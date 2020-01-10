package edu.curso.android.shipsmaru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.List;

import edu.curso.android.shipsmaru.api.ApiClient;
import edu.curso.android.shipsmaru.api.Ship;
import edu.curso.android.shipsmaru.api.ShipList;
import edu.curso.android.shipsmaru.api.ShipService;
import edu.curso.android.shipsmaru.recyclerView.RecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnShipListener {

    private List<Ship> shipList;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = ApiClient.getClient();

        ShipService shipService = retrofit.create(ShipService.class);


        recyclerView = (RecyclerView)findViewById(R.id.shipListRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        Call<ShipList> call = shipService.getShips();

        recyclerView = findViewById(R.id.shipListRV);

        call.enqueue(new Callback<ShipList>() {
            @Override
            public void onResponse(Call<ShipList> call, Response<ShipList> response) {
               shipList = response.body().getResults();
               Log.i("Main", "onResponse");
                System.out.println(shipList.get(0).toString());

                setShipList();


                for (Ship ship : shipList
                     )
                {
                    System.out.println(ship);
                }

                //recyclerAdapter.setShipList(shipList);


            }

            @Override
            public void onFailure(Call<ShipList> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });


    }


    private void setShipList(){
        recyclerAdapter = new RecyclerAdapter(this, shipList, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onShipClick(int position) {
        Intent intent = new Intent(this, ShipDetailActivity.class);
        intent.putExtra("ships", shipList.get(position));
        startActivity(intent);
    }
}
