package com.seagle.performance.performance.leak.api;

import com.google.gson.Gson;
import com.seagle.performance.performance.entity.ResponseBlockInfo;
import com.seagle.performance.performance.entity.ResponseBlockInfoList;
import com.seagle.performance.performance.entity.ResponseInfoList;
import com.seagle.performance.performance.leak.bean.ResponseMatrixLeakInfo;
import com.seagle.performance.performance.leak.bean.UploadMatrixLeakInfo;
import com.seagle.performance.performance.leak.db.LeakMapper;
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
public class LeakController {
    private static final int PAGE_COUNT = 10;

    @Autowired
    private LeakMapper mMapper;

    @PostMapping("/api/uploadMatrixLeakInfo")
    @ResponseBody
    public ResponseInfo uploadMatrixLeakInfo(@RequestParam("data") String data) throws IOException {
        Gson gson = new Gson();
        UploadMatrixLeakInfo leakInfo = gson.fromJson(data,UploadMatrixLeakInfo.class);
        mMapper.addMatrixBlockInfo(leakInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @RequestMapping("api/getMatrixLeakInfoList")
    public ResponseInfo<ResponseInfoList<ResponseMatrixLeakInfo>> getMatrixLeakInfoList(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // page从0开始
        page = page - 1;
        if (page < 0) {
            page = 0;
        }


        int count = mMapper.getMatrixLeakInfoCount();
        List<ResponseMatrixLeakInfo> data = mMapper.getMatrixLeakInfoList(page * PAGE_COUNT, PAGE_COUNT);

        ResponseInfo<ResponseInfoList<ResponseMatrixLeakInfo>> result = new ResponseInfo<>();
        result.setData(new ResponseInfoList<ResponseMatrixLeakInfo>(count, data));
        return result;
    }

    @PostMapping("/api/uploadLeakCanaryInfo")
    @ResponseBody
    public ResponseInfo uploadLeakCanaryInfo(@RequestParam("data") UploadMatrixLeakInfo leakInfo) throws IOException {
        mMapper.addMatrixBlockInfo(leakInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
