package com.fev_io.fev_vehicleapitestapp.view;

import static android.content.ContentValues.TAG;

import android.car.VehiclePropertyIds;
import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fev_io.fev_vehicleapitestapp.R;
import com.fev_io.fev_vehicleapitestapp.controller.CarApiController;
import com.fev_io.fev_vehicleapitestapp.controller.IPropertyList;
import com.fev_io.fev_vehicleapitestapp.model.PropertyDB;
import com.fev_io.fev_vehicleapitestapp.model.PropertyInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PropertyInfoAdapter.IClickListner {
    public Button mBtnSet;
    private Button mBtnGet;
    private PropertyInfoAdapter mPropInfoAdapter;
    private RecyclerView mPropListRecyclerView;
    private TextView mPropConfig_tv;
    private LinearLayout mLinearLayout;
    private  LinearLayout ll_btn_rdoGroup;

    CarPropertyValue mCarPropertyValue;
    private TextView tv_logs_screen2;
    private int ext = 0;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSet = findViewById(R.id.btn_set_screen2);
        mBtnGet = findViewById(R.id.btn_get_screen2);
        mLinearLayout = findViewById(R.id.ll3_screen2);

        ll_btn_rdoGroup =  findViewById(R.id.btn_rdo);
        mPropConfig_tv = findViewById(R.id.tv_propConfig_screen2);
        tv_logs_screen2 = findViewById(R.id.tv_logs_screen2);
        mPropListRecyclerView = findViewById(R.id.rv_propertyList_screen1);
        mPropInfoAdapter = new PropertyInfoAdapter(this, PropertyDB.getInstance().getDummyList(), this);
        mLayoutManager= new LinearLayoutManager(this,null,LinearLayoutManager.VERTICAL,1);
        mPropListRecyclerView.setLayoutManager(mLayoutManager);
        mPropListRecyclerView.setAdapter(mPropInfoAdapter);
        //fetchPropertyList();

        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayout.setVisibility(View.GONE);
               // CarApiController.getInstance().propInfo();
                int val = PropertyDB.getInstance().getValPositon();
                tv_logs_screen2.setText(String.valueOf(CarApiController.getInstance().getProperty(val)));
            }
        });

        mBtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinearLayout.setVisibility(View.VISIBLE);
                ll_btn_rdoGroup.setVisibility(View.GONE);
            }
        });
    }
    public void fetchPropertyList(){
        CarApiController.getInstance().getPropertyList();
    }
    @Override
    public void itemClicked(int position) {
        ll_btn_rdoGroup.setVisibility(View.VISIBLE);
        mLinearLayout.setVisibility(View.GONE);
        ext = position;
        PropertyDB.getInstance().setValPositon(position);
        mPropConfig_tv.setText(CarApiController.getInstance().getPropertyConfig(position));
        PropertyInfo propertyDB = PropertyDB.getInstance().getDummyList().get(position);
        RadioGroup rgp = (RadioGroup) findViewById(R.id.radio_group);
        rgp.setOrientation(LinearLayout.HORIZONTAL);
        rgp.removeAllViews();
        RadioButton rbn ;

            for (int i : propertyDB.getmAreaIdes()) {
                    Log.d(TAG, "itemClicked areaId:" + propertyDB.getmAreaIdes().length);
                     rbn = new RadioButton(this);
                rbn.setId(i);
                     rbn.setText("" + i);
                     Log.d(TAG, "area id: "+i);
                     LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                     rbn.setLayoutParams(params);
                     rgp.addView(rbn);
            }

        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = rgp.getCheckedRadioButtonId();
                Log.d(TAG, "onCheckedChanged: getId******"+selectedId);
                PropertyDB.getInstance().setAreaId(selectedId);
            }
        });
    }
}