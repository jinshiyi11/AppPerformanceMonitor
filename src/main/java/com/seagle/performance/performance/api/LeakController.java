package com.seagle.performance.performance.api;

import com.seagle.performance.performance.entity.*;
import com.seagle.performance.performance.leak.UploadLeakInfo;
import com.seagle.performance.performance.mapper.DbMapper;
import com.seagle.performance.performance.response.ErrorCode;
import com.seagle.performance.performance.response.ResponseInfo;
import com.seagle.performance.performance.util.StackTraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@RestController
public class LeakController {
    private static final int PAGE_COUNT = 10;

    @Autowired
    private DbMapper mMapper;

    @PostMapping("/api/uploadLeakInfo")
    @ResponseBody
    public ResponseInfo uploadBlockInfo(@RequestBody UploadLeakInfo leakInfo) throws IOException {
//        mMapper.addBlockInfo(blockInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
