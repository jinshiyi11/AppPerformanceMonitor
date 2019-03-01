package com.seagle.performance.performance.entity;

/**
 *
 */
public class ResponseBlockDetail {
    private long mId;
    private String mStackTrace;
    private int mBlockTime;
    private String mInsertTime;
    private int mOccurCount;
    private String mModel;
    private String mVersionName;
    private int mVersionCode;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getStackTrace() {
        return mStackTrace;
    }

    public void setStackTrace(String stackTrace) {
        mStackTrace = stackTrace;
    }

    public int getBlockTime() {
        return mBlockTime;
    }

    public void setBlockTime(int blockTime) {
        mBlockTime = blockTime;
    }

    public String getInsertTime() {
        return mInsertTime;
    }

    public void setInsertTime(String insertTime) {
        this.mInsertTime = insertTime;
    }

    public int getOccurCount() {
        return mOccurCount;
    }

    public void setOccurCount(int occurCount) {
        this.mOccurCount = occurCount;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        this.mModel = model;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public void setVersionName(String versionName) {
        this.mVersionName = versionName;
    }

    public int getVersionCode() {
        return mVersionCode;
    }

    public void setVersionCode(int versionCode) {
        this.mVersionCode = versionCode;
    }
}
