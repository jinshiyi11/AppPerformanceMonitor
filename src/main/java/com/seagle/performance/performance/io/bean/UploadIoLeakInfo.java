package com.seagle.performance.performance.io.bean;

import com.google.gson.annotations.SerializedName;

public class UploadIoLeakInfo {
    @SerializedName("stack")
    public String mStack;

    @SerializedName("process")
    public String mProcess;

    @SerializedName("time")
    public long mOccurTime;
}
