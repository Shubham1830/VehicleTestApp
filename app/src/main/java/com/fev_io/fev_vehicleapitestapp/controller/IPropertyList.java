package com.fev_io.fev_vehicleapitestapp.controller;

import android.car.hardware.CarPropertyConfig;

import com.fev_io.fev_vehicleapitestapp.model.PropertyInfo;

import java.util.List;

public interface IPropertyList {
    public void onPropertyListFetched(List<PropertyInfo> mlist);



}

