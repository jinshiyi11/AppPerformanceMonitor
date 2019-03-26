package com.seagle.performance.performance.leak.api;

import com.seagle.performance.performance.leak.bean.UploadLeakInfo;
import com.seagle.performance.performance.leak.db.LeakMapper;
import com.seagle.performance.performance.response.ErrorCode;
import com.seagle.performance.performance.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 *
 */
@RestController
public class LeakController {
    private static final int PAGE_COUNT = 10;

    @Autowired
    private LeakMapper mMapper;

    @PostMapping("/api/uploadLeakInfo")
    @ResponseBody
    public ResponseInfo uploadBlockInfo(@RequestParam("data") UploadLeakInfo leakInfo) throws IOException {
        mMapper.addBlockInfo(leakInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
