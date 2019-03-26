package com.seagle.performance.performance.leak.bean;

import com.google.gson.annotations.SerializedName;

public class UploadMatrixLeakInfo {
    @SerializedName("activity")
    public String mActivity;

    @SerializedName("tag")
    public String mTag;

    @SerializedName("process")
    public String mProcess;

    @SerializedName("time")
    public long mOccurTime;
}
