package edu.curso.android.shipsmaru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import edu.curso.android.shipsmaru.api.Ship;

public class ShipDetailActivity extends AppCompatActivity {


    private TextView textViewName;
    private TextView textViewModel;
    private TextView textViewManufacturer;
    private TextView textViewCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_detail);

        textViewName = findViewById(R.id.textViewNameDetail);
        textViewModel = findViewById(R.id.textViewModelDetail);
        textViewManufacturer = findViewById(R.id.textViewManufacturerDetail);
        textViewCost = findViewById(R.id.textViewCostDetail);

        Ship ship = (Ship) getIntent().getSerializableExtra("ships");

        textViewName.setText(ship.getName());
        textViewModel.setText("Model: " + ship.getModel());
        textViewManufacturer.setText("Made by " + ship.getManufacturer());
        textViewCost.setText(ship.getCost() + " credits");


    }
}
