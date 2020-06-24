package com.ibsvalley.androidtask;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibsvalley.androidtask.helper.AppFunctions;
import com.ibsvalley.androidtask.model.carsModel;

import java.util.List;

import static com.ibsvalley.androidtask.helper.AppFunctions.loadImage;


public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    private final List<carsModel.Data> data;
    private MainActivity context;


    public CarsAdapter(MainActivity context, List<com.ibsvalley.androidtask.model.carsModel.Data> data) {

        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cars, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        loadImage(data.get(position).getImageUrl(), holder.carImage);

        holder.brand.setText(data.get(position).getBrand());
        holder.isUsedOrNew.setText(String.valueOf(data.get(position).getIsUsed()));
        holder.construction.setText(data.get(position).getConstructionYear());

    }


    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView brand, isUsedOrNew, construction;
        private ImageView carImage;

        public ViewHolder(View itemView) {
            super(itemView);

            brand = itemView.findViewById(R.id.brand);
            carImage = itemView.findViewById(R.id.carImage);
            isUsedOrNew = itemView.findViewById(R.id.isUsedOrNew);
            construction = itemView.findViewById(R.id.construction);

        }
    }
}