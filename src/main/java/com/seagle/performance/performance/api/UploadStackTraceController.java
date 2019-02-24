package com.seagle.performance.performance.api;

import com.seagle.performance.performance.entity.BlockInfo;
import com.seagle.performance.performance.mapper.DbMapper;
import com.seagle.performance.performance.response.ErrorCode;
import com.seagle.performance.performance.response.ResponseInfo;
import com.seagle.performance.performance.util.StackTraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@RestController
public class UploadStackTraceController {
    @Autowired
    private DbMapper mMapper;

    @PostMapping("/api/uploadStackTrace")
    @ResponseBody
    public ResponseInfo uploadStackTrace(
            @RequestParam("version") int version,
            @RequestParam("stackTrace") String stackTrace,
            @RequestParam("blockTime") int blockTime,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        BlockInfo blockInfo = new BlockInfo();
        String key = StackTraceUtil.generateStackTrackKey(stackTrace);
        blockInfo.setKey(key);
        blockInfo.setStackTrace(stackTrace);
        blockInfo.setBlockTime(blockTime);
        mMapper.addBlockInfo(blockInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }
}
