package com.seagle.performance.performance.entity;

/**
 *
 */
public class ResponseBlockInfo {
    private long mId;
    private String mStackTrace;
    private int mBlockTime;
    private long mInsertTime;
    private int mOccurCount;

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

    public long getInsertTime() {
        return mInsertTime;
    }

    public void setInsertTime(long insertTime) {
        this.mInsertTime = insertTime;
    }

    public int getOccurCount() {
        return mOccurCount;
    }

    public void setOccurCount(int occurCount) {
        this.mOccurCount = occurCount;
    }
}
