package com.fev_io.fev_vehicleapitestapp;

import android.app.Application;
import android.util.Log;

import com.fev_io.fev_vehicleapitestapp.utility.CarConnection;

public class VehicleAppliCation extends Application {
private static String TAG ="VehicleAppliCation";
CarConnection mCarConnection;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: VehicleAppliCation");
        mCarConnection= new CarConnection(this);
        mCarConnection.createCar();
    }
}
