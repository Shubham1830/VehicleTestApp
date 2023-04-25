package com.fev_io.fev_vehicleapitestapp.controller;

import android.car.Car;
import android.car.VehiclePropertyIds;
import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.property.CarPropertyManager;
import android.content.Context;
import android.util.Log;

import com.fev_io.fev_vehicleapitestapp.model.PropertyDB;
import com.fev_io.fev_vehicleapitestapp.model.PropertyInfo;

import java.util.ArrayList;
import java.util.List;

public class CarApiController {
  private IPropertyList mActivity;
  private Context mContext;
    private static CarApiController mCarApiController;
    private final String TAG = "CarApiController";
    private CarPropertyManager mCarPropertyManager;

    public CarApiController() {
        this.mActivity = mActivity;
        this.mContext = mContext;

    }

    public static CarApiController getInstance(){
        if (mCarApiController==null){
            mCarApiController=new CarApiController();
            return mCarApiController;
        }else {
            return mCarApiController;
        }
    }

    public void initCarPropertyManger(Car mCar){
        if (mCarPropertyManager==null){
            mCarPropertyManager= (CarPropertyManager) mCar.getCarManager(Car.PROPERTY_SERVICE);
        }else {
            Log.d(TAG, "initCarPropertyManger: not supported on the device");
        }
    }

    public List<PropertyInfo> getPropertyList(){
        List<PropertyInfo> mPropertyList = new ArrayList<>();

        List<CarPropertyConfig> list = mCarPropertyManager.getPropertyList();

        for(CarPropertyConfig c:list){
            VehiclePropertyIds.toString(c.getPropertyId());
            PropertyInfo mPropertyInfo=new PropertyInfo(VehiclePropertyIds.toString(c.getPropertyId()),
                    c.getPropertyId(),c.getAreaIds(),c.getAccess(),c.getAreaType(),
                    c.getChangeMode(),c.getMaxSampleRate(),c.getMinSampleRate(),
                    c.getMaxValue(),c.getMinValue(),c.isGlobalProperty()
            );
            mPropertyList.add(mPropertyInfo);
            Log.d("CarApiController","list of data"+mPropertyInfo);
            PropertyDB.getInstance().setmPropList(mPropertyList);
            Log.d("CarApiController","list of set"+mPropertyList);
        }
        return mPropertyList;
}

    public String getPropertyConfig(int pos) {

        //CarPropertyConfig mPropConfig = mCarPropertyManager.getPropertyList().get(pos);

        //PropertyInfo mPropConfig = mPropertyDB.getmPropList().get(pos);

        PropertyInfo mPropConfig = PropertyDB.getInstance().getDummyList().get(pos);

//        CarPropertyConfig<?> mCarconfig = mCarPropertyManager.getCarPropertyConfig(mPropConfig.getmPropertyId());

//        Log.d(TAG, "getPropertyConfig: " + VehiclePropertyIds.toString(mCarconfig.getPropertyId()));


        String value = String.format("PropertyConfig: PropertyName=%1$s  PropertyId=%2$s  AreaId=%3$s  Access=%4$s  AreaType=%5$s  ChangeMode=%6$s  MaxSampleRate=%7$s  MinSampleRate=%8$s",
                mPropConfig.getmPropertyName(),
                mPropConfig.getmPropertyId(),
                PropertyDB.getInstance().getAreaId(),
                mPropConfig.getmAccess(),
                mPropConfig.getmAreaType(),
                mPropConfig.getmChangeMode(),
                mPropConfig.getmMaxSampleRate(),
                mPropConfig.getmMinSampleRate());

                /*VehiclePropertyIds.toString(mCarconfig.getPropertyId()),
                mCarconfig.getPropertyId(),
                mCarconfig.getAreaIds(),
                mCarconfig.getAccess(),
                mCarconfig.getAreaType(),
                mCarconfig.getChangeMode(),
                mCarconfig.getMaxSampleRate(),
                mCarconfig.getMinSampleRate());*/
        return value;
    }

    public String getProperty(int position){
// int id = 0;
        PropertyInfo propertyInfo = PropertyDB.getInstance().getDummyList().get(position);
        PropertyDB.getInstance().setCurrentInfo(propertyInfo);
        // mPropertyDB.setPosition(position);
//       CarPropertyValue value= mCarPropertyManager.getProperty(propertyInfo.getmPropertyId(), PropertyDB.getInstance().getAreaId());
//           int val = PropertyDB.getInstance().getAreaId();
        String value = String.format("PropertyConfig: PropertyName=%1$s  PropertyId=%2$s  AreaId=%3$s  Access=%4$s  AreaType=%5$s  ChangeMode=%6$s  MaxSampleRate=%7$s  MinSampleRate=%8$s",
                propertyInfo.getmPropertyName(),
                propertyInfo.getmPropertyId(),
                PropertyDB.getInstance().getAreaId(),
                propertyInfo.getmAccess(),
                propertyInfo.getmAreaType(),
                propertyInfo.getmChangeMode(),
                propertyInfo.getmMaxSampleRate(),
                propertyInfo.getmMinSampleRate());
        Log.d(TAG, "AreaId+++++++++++++: "+PropertyDB.getInstance().getAreaId());
        return value;
    }

//    public CarPropertyValue setProperty(int id,int ar, int val,int position){
//        PropertyInfo propertyInfo = PropertyDB.getInstance().getDummyList().get(position);
//       CarPropertyValue xyz = mCarPropertyManager.setIntProperty(propertyInfo.getmPropertyId(),PropertyDB.getInstance().getAreaId(),PropertyDB.getInstance().getValue());
//       return  xyz;
//    }

//    public CarPropertyValue getGet(){
//      //  PropertyInfo propertyInfo = mPropertyDB.getCurrentInfo();
//        PropertyInfo  prop = mPropertyDB.getCurrentInfo();
//      CarPropertyValue value = mCarPropertyManager.getProperty(prop.getmPropertyId(),prop.getmAreaID());
//        //St value = String.format("PropertyId=%1$s  AreaId=%2$s", propertyInfo.getmPropertyId(), propertyInfo.getmPropertyName());
//        return value;
//    }

    public PropertyInfo propInfo(){
        PropertyInfo prop = PropertyDB.getInstance().getCurrentInfo();
        return prop;
    }
    
    private final CarPropertyManager.CarPropertyEventCallback mPropCb =
            new CarPropertyManager.CarPropertyEventCallback() {
                @Override
                public void onChangeEvent(CarPropertyValue value) {
                   // onPropertyEvent(value);
                }



                @Override
                public void onErrorEvent(int propId, int zone) {}
            };
}


/*public CarPropertyConfig getPropertyConfig(int pos) {

        CarPropertyConfig mPropConfig = mCarPropertyManager.getPropertyList().get(pos);

        CarPropertyConfig<?> mCarProperty = mCarPropertyManager.getCarPropertyConfig(mPropConfig.getPropertyId());

        Log.d(TAG, "getPropertyConfig: "+VehiclePropertyIds.toString(mPropConfig.getPropertyId()));
        return mCarProperty;
    }
*/
