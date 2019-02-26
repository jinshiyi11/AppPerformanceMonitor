package com.seagle.performance.performance.entity;

import java.util.Collections;
import java.util.List;

public class ResponseBlockInfoList {
    private int mTotal;
    private List<ResponseBlockInfo> mData;

    public ResponseBlockInfoList(int total, List<ResponseBlockInfo> data) {
        this.mTotal = total;
        this.mData = data != null ? data : Collections.emptyList();
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        this.mTotal = total;
    }

    public List<ResponseBlockInfo> getData() {
        return mData;
    }

    public void setData(List<ResponseBlockInfo> data) {
        this.mData = data;
    }
}
