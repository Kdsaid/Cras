package com.ibsvalley.androidtask.viewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.ibsvalley.androidtask.api.RetrofitClient;
import com.ibsvalley.androidtask.helper.AppFunctions;
import com.ibsvalley.androidtask.model.carsModel;
import com.kaopiz.kprogresshud.KProgressHUD;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class HomeViewModel extends ViewModel {


    private MutableLiveData<carsModel> carsModelMutableLiveData;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    //we will call this method to get the data
    public LiveData<carsModel> getCars(Context context,int page) {
        //if the list is null

            carsModelMutableLiveData = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadCars(context,page);

        //finally we will return the list
        return carsModelMutableLiveData;
    }


    private void loadCars(Context context,int page) {

        KProgressHUD kProgressHUD = AppFunctions.getKProgressHUD(context);
        kProgressHUD.show();
        Single<carsModel> observable = RetrofitClient.getInstance().getApi().getLanguage_Model(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(o -> {
            if (o.getStatus()==1){
                carsModelMutableLiveData.setValue(o);

            }else {
                Toast.makeText(context, "page not found ", Toast.LENGTH_SHORT).show();
            }
            kProgressHUD.dismiss();

        }, e -> {

            Log.i(TAG, "loadProduct: "+            e.getLocalizedMessage());
            Toast.makeText(context, "no internet connections", Toast.LENGTH_SHORT).show();

                    kProgressHUD.dismiss();
        }));


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}




