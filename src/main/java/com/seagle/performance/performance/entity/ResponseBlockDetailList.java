package com.seagle.performance.performance.entity;

import java.util.Collections;
import java.util.List;

public class ResponseBlockDetailList {
    private int mTotal;
    private List<ResponseBlockDetail> mData;

    public ResponseBlockDetailList(int total, List<ResponseBlockDetail> data) {
        this.mTotal = total;
        this.mData = data != null ? data : Collections.emptyList();
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        this.mTotal = total;
    }

    public List<ResponseBlockDetail> getData() {
        return mData;
    }

    public void setData(List<ResponseBlockDetail> data) {
        this.mData = data;
    }
}
