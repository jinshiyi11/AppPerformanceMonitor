package com.seagle.performance.performance.entity;

/**
 *
 */
public class UploadBlockInfo {
    private long mId;
    private String mKey;
    private String mStackTrace;
    private int mBlockTime;
    private long mInsertTime;
    private String mModel;
    private String mVersionName;
    private int mVersionCode;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
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

    public long getInsertTime() {
        return mInsertTime;
    }

    public void setInsertTime(long insertTime) {
        this.mInsertTime = insertTime;
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
