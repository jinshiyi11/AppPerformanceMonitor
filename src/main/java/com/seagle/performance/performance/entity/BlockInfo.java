package com.seagle.performance.performance.entity;

/**
 *
 */
public class BlockInfo {
    private String mKey;
    private String mStackTrace;
    private int mBlockTime;

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
}
