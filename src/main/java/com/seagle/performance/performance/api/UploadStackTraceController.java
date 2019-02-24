package com.seagle.performance.performance.api;

import com.seagle.performance.performance.entity.BlockInfo;
import com.seagle.performance.performance.mapper.DbMapper;
import com.seagle.performance.performance.response.ErrorCode;
import com.seagle.performance.performance.response.ResponseInfo;
import com.seagle.performance.performance.util.StackTraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 */
@RestController
public class UploadStackTraceController {
    private static final int PAGE_COUNT = 30;

    @Autowired
    private DbMapper mMapper;

    @PostMapping("/api/uploadBlockInfo")
    @ResponseBody
    public ResponseInfo uploadBlockInfo(
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

    @RequestMapping("api/getBlockInfoList")
    public ResponseInfo<List<BlockInfo>> getBlockInfoList(
            @RequestParam(value = "id", required = false, defaultValue = "-1") long id) {
        if (id < 0) {
            id = 0x7FFFFFFF;
        }


        List<BlockInfo> data = mMapper.getBlockInfoList(id, PAGE_COUNT);
//        if (data != null) {
//            Collections.reverse(data);
//        }

        ResponseInfo<List<BlockInfo>> result = new ResponseInfo<>();
        result.setData(data);
        return result;
    }
}
