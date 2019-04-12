package com.seagle.performance.performance.io.bean;

import com.google.gson.annotations.SerializedName;

public class ResponseIoLeakInfo {
    @SerializedName("id")
    public long mId;

    @SerializedName("stack")
    public String mStack;

    @SerializedName("insertTime")
    public long mInsertTime;
}
