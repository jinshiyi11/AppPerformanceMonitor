package com.seagle.performance.performance.leak;

import com.google.gson.annotations.SerializedName;

public class UploadLeakInfo {
    @SerializedName("versionName")
    private String mVersionName;

    @SerializedName("versionCode")
    private int mVersionCode;


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
