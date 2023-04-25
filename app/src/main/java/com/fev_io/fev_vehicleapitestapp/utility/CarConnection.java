package com.fev_io.fev_vehicleapitestapp.utility;

import android.car.Car;
import android.content.Context;
import android.content.pm.PackageManager;

import com.fev_io.fev_vehicleapitestapp.controller.CarApiController;

public class CarConnection {
    private static String TAG = "CarConnection";
    private Car mCar;
    private Context mContext;

    public CarConnection(Context mContext){
        this.mContext=mContext;
    }

    public void createCar(){
        if (mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_AUTOMOTIVE))
        {
            mCar = Car.createCar(mContext, null, 1, new Car.CarServiceLifecycleListener() {
                @Override
                public void onLifecycleChanged(Car car, boolean b) {
                  mCar = car;
                    CarApiController.getInstance().initCarPropertyManger(mCar);
                }
            });
        }
    }

}
