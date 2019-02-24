package com.seagle.performance.performance.entity;

/**
 *
 */
public class BlockInfo {
    private long mId;
    private String mKey;
    private String mStackTrace;
    private int mBlockTime;
    private long mInsertTime;

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
}
