package com.fev_io.fev_vehicleapitestapp.model;

import android.util.Log;

import com.fev_io.fev_vehicleapitestapp.controller.CarApiController;

import java.util.ArrayList;
import java.util.List;

public class PropertyDB {
    private int position = 0 ;
    private static PropertyDB mPropertyDB;
    private PropertyInfo mCurrentInfo;
    private int areaId ;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int valPositon;


    public int getValPositon() {
        return valPositon;
    }

    public void setValPositon(int valPositon) {
        this.valPositon = valPositon;
    }

    private final String TAG = "PropertyDB";
    private List<PropertyInfo> mPropList = new ArrayList<>();
    public List<PropertyInfo> getmPropList() {
        return mPropList;
    }

    public static PropertyDB getInstance(){
        if (mPropertyDB==null){
            mPropertyDB=new PropertyDB();
            return mPropertyDB;
        }else {
            return mPropertyDB;
        }
    }

    public ArrayList<PropertyInfo> getDummyList() {
        ArrayList list =  new ArrayList<>();
        int[] areaId = new int[2];
        areaId[0]=101;
        areaId[1]=102;
        list.add(new PropertyInfo("Info_Fuel_Type",101, areaId, 100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("ParkingMode",102,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Info_Battery_Capacity",103,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Info_Model",104,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Info_Fuel_Capacity",105,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Info_Model_Year",106,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Night_Mode",107,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        list.add(new PropertyInfo("Info_Driver_Seat",108,areaId,100101, 0x002f, 0x322d, 10.500f, 10.100f, 500, 200, true));
        return list;
    }

    public void setmPropList(List<PropertyInfo> mPropList) {
        Log.d(TAG, "setmPropList: "+mPropList);
        this.mPropList = mPropList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public PropertyInfo getCurrentInfo() {
        return mCurrentInfo;
    }

    public void setCurrentInfo(PropertyInfo mCurrentInfo) {
        this.mCurrentInfo = mCurrentInfo;
    }

    public int getAreaId() {
        Log.d(TAG, "get: "+areaId);
        return areaId;
    }
    public void setAreaId(int areaId) {
        this.areaId = areaId;
        Log.d(TAG, "setAreaId: "+areaId);
    }


}
