package com.seagle.performance.performance.leak.bean;

import com.google.gson.annotations.SerializedName;

public class ResponseLeakCanaryInfo {
    @SerializedName("id")
    public long mId;

    @SerializedName("info")
    public String mInfo;

    @SerializedName("insertTime")
    public long mInsertTime;
}
