package edu.curso.android.shipsmaru.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.curso.android.shipsmaru.R;
import edu.curso.android.shipsmaru.api.Ship;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ShipviewHolder> {

    Context context;
    List<Ship> shipList;
    private OnShipListener onShipListener;

    public RecyclerAdapter(Context context, List<Ship> shipList, OnShipListener onShipListener) {
        this.context = context;
        this.shipList = shipList;
        this.onShipListener = onShipListener;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
        notifyDataSetChanged();
    }

    @Override
    public ShipviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ship_item_rv,parent,false);
        return new ShipviewHolder(view, onShipListener);
    }

    @Override
    public void onBindViewHolder(ShipviewHolder holder, int position) {
        holder.textViewName.setText(shipList.get(position).getName());
        holder.textViewModel.setText("Model: " + shipList.get(position).getModel());


    }

    @Override
    public int getItemCount() {
        if(shipList != null){
            return shipList.size();
        }
        return 0;

    }

    public class ShipviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewModel;
        OnShipListener onShipListener;

        public ShipviewHolder(View itemView, OnShipListener onShipListener) {
            super(itemView);
            textViewName = (TextView)itemView.findViewById(R.id.textViewNameItem);
            textViewModel = (TextView)itemView.findViewById(R.id.textViewModelItem);
            this.onShipListener = onShipListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        onShipListener.onShipClick(getAdapterPosition());
        }
    }

    public interface OnShipListener{
        void onShipClick(int position);
    }
}




