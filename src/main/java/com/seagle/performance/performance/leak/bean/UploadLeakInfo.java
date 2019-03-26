package com.seagle.performance.performance.leak.bean;

import com.google.gson.annotations.SerializedName;

public class UploadLeakInfo {
    @SerializedName("versionName")
    public String mVersionName;

    @SerializedName("versionCode")
    public int mVersionCode;
}
