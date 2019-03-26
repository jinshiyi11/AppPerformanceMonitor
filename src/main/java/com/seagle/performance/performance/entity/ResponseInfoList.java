package com.seagle.performance.performance.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class ResponseInfoList<T> {
    @SerializedName("total")
    private int mTotal;

    @SerializedName("data")
    private List<T> mData;

    public ResponseInfoList(int total, List<T> data) {
        this.mTotal = total;
        this.mData = data != null ? data : Collections.emptyList();
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        this.mTotal = total;
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        this.mData = data;
    }
}
