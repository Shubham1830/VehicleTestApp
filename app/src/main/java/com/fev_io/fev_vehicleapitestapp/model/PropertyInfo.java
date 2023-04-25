package com.fev_io.fev_vehicleapitestapp.model;

import android.animation.IntArrayEvaluator;

public class PropertyInfo {
    private String mPropertyName;
    private int mPropertyId;
    private int mAccess;
    private int[] mAreaIdes;
    private int mDescribeContents;
    private int mAreaType;
    private int mChangeMode;
    private float mMaxSampleRate;
    private float mMinSampleRate;
    private int mMaxValue;
    private int mMinValue;


    private Boolean mIsGlobalProperty;

    public PropertyInfo(String mPropertyName, int mPropertyId, int[] mAreaIdes, int access, int mAreaType, int mChangeMode, float mMaxSampleRate, float mMinSampleRate, Object mMaxValue, Object mMinValue, boolean mIsGlobalProperty) {
        this.mPropertyName = mPropertyName;
        this.mPropertyId = mPropertyId;
        this.mAreaIdes = mAreaIdes;
        this.mAccess = access;
        this.mAreaType = mAreaType;
        this.mChangeMode = mChangeMode;
        this.mMaxSampleRate = mMaxSampleRate;
        this.mMinSampleRate = mMinSampleRate;
        this.mMaxValue = (int) mMaxValue;
        this.mMinValue = (int) mMinValue;
        this.mIsGlobalProperty = mIsGlobalProperty;
    }

    public String getmPropertyName() {
        return mPropertyName;
    }

    public void setmPropertyName(String mPropertyName) {
        this.mPropertyName = mPropertyName;
    }

    public int getmPropertyId() {
        return mPropertyId;
    }

    public void setmPropertyId(int mPropertyId) {
        this.mPropertyId = mPropertyId;
    }

    public int[] getmAreaIdes() {
        return mAreaIdes;
    }

    public void setmAreaIdes(int[] mAreaIdes) {
        this.mAreaIdes = mAreaIdes;
    }

    public int getmDescribeContents() {
        return mDescribeContents;
    }

    public void setmDescribeContents(int mDescribeContents) {
        this.mDescribeContents = mDescribeContents;
    }

    public int getmAccess() {
        return mAccess;
    }

    public void setmAccess(int mAccess) {
        this.mAccess = mAccess;
    }

    public int getmAreaType() {
        return mAreaType;
    }

    public void setmAreaType(int mAreaType) {
        this.mAreaType = mAreaType;
    }

    public int getmChangeMode() {
        return mChangeMode;
    }

    public void setmChangeMode(int mChangeMode) {
        this.mChangeMode = mChangeMode;
    }

    public float getmMaxSampleRate() {
        return mMaxSampleRate;
    }

    public void setmMaxSampleRate(float mMaxSampleRate) {
        this.mMaxSampleRate = mMaxSampleRate;
    }

    public float getmMinSampleRate() {
        return mMinSampleRate;
    }

    public void setmMinSampleRate(float mMinSampleRate) {
        this.mMinSampleRate = mMinSampleRate;
    }

    public int getmMaxValue() {
        return mMaxValue;
    }

    public void setmMaxValue(int mMaxValue) {
        this.mMaxValue = mMaxValue;
    }

    public int getmMinValue() {
        return mMinValue;
    }

    public void setmMinValue(int mMinValue) {
        this.mMinValue = mMinValue;
    }

    public Boolean getmIsGlobalProperty() {
        return mIsGlobalProperty;
    }

    public void setmIsGlobalProperty(Boolean mIsGlobalProperty) {
        this.mIsGlobalProperty = mIsGlobalProperty;
    }
}
