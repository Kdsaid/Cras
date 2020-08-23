package com.ibsvalley.androidtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ibsvalley.androidtask.helper.EndlessRecyclerViewScrollListener;
import com.ibsvalley.androidtask.model.carsModel;
import com.ibsvalley.androidtask.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HomeViewModel homeViewModel;
    private RecyclerView rvCars;
    private int PAGE = 1;
    private LinearLayoutManager layout;
    private List<carsModel.Data> data=new ArrayList<>();
    private CarsAdapter carsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCars = findViewById(R.id.rvCars);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCars.setLayoutManager(layout);
         carsAdapter = new CarsAdapter(MainActivity.this, data);
        rvCars.setAdapter(carsAdapter);

        rvCars.addOnScrollListener(new EndlessRecyclerViewScrollListener(layout) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                PAGE++;
                Log.i("@@@@@@@@@", "onLoadMore: "+PAGE);
                getData(PAGE);


            }

        });
        getData(PAGE);

    }

    private void getData(int PAGE) {
        if (PAGE==1){
            data.clear();
            rvCars.getRecycledViewPool().clear();
            carsAdapter.notifyDataSetChanged();

        }
        homeViewModel.getCars(MainActivity.this, PAGE).observe(MainActivity.this, carsModel ->
                {


                    data.addAll(carsModel.getData());

                    carsAdapter.notifyItemRangeChanged(carsAdapter.getItemCount(), data.size());
                }
        );

    }

}