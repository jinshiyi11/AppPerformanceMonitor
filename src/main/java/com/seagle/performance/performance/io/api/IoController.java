package com.seagle.performance.performance.io.api;

import com.google.gson.Gson;
import com.seagle.performance.performance.entity.ResponseInfoList;
import com.seagle.performance.performance.io.bean.ResponseIoLeakInfo;
import com.seagle.performance.performance.io.bean.UploadIoLeakInfo;
import com.seagle.performance.performance.io.db.IoMapper;
import com.seagle.performance.performance.response.ErrorCode;
import com.seagle.performance.performance.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@RestController
public class IoController {
    private static final int PAGE_COUNT = 10;

    @Autowired
    private IoMapper mMapper;

    @PostMapping("/api/uploadIoLeakInfo")
    @ResponseBody
    public ResponseInfo uploadIoLeakInfo(@RequestParam("data") String data) throws IOException {
        Gson gson = new Gson();
        UploadIoLeakInfo leakInfo = gson.fromJson(data, UploadIoLeakInfo.class);
        mMapper.addIoBlockInfo(leakInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @RequestMapping("api/getIoLeakInfoList")
    public ResponseInfo<ResponseInfoList<ResponseIoLeakInfo>> getIoLeakInfoList(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // page从0开始
        page = page - 1;
        if (page < 0) {
            page = 0;
        }


        int count = mMapper.getIoLeakInfoCount();
        List<ResponseIoLeakInfo> data = mMapper.getIoLeakInfoList(page * PAGE_COUNT, PAGE_COUNT);

        ResponseInfo<ResponseInfoList<ResponseIoLeakInfo>> result = new ResponseInfo<>();
        result.setData(new ResponseInfoList<>(count, data));
        return result;
    }
}
