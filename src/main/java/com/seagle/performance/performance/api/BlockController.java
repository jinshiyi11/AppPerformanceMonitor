package com.seagle.performance.performance.api;

import com.seagle.performance.performance.entity.*;
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
public class BlockController {
    private static final int PAGE_COUNT = 10;

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
        UploadBlockInfo blockInfo = new UploadBlockInfo();
        String key = StackTraceUtil.generateStackTrackKey(stackTrace);
        blockInfo.setKey(key);
        blockInfo.setStackTrace(stackTrace);
        blockInfo.setBlockTime(blockTime);
        mMapper.addBlockInfo(blockInfo);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @RequestMapping("api/getBlockInfoList")
    public ResponseInfo<ResponseBlockInfoList> getBlockInfoList(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // page从0开始
        page = page - 1;
        if (page < 0) {
            page = 0;
        }


        int count = mMapper.getBlockInfoCount();
        List<ResponseBlockInfo> data = mMapper.getBlockInfoList(page * PAGE_COUNT, PAGE_COUNT);
//        if (data != null) {
//            Collections.reverse(data);
//        }

        ResponseInfo<ResponseBlockInfoList> result = new ResponseInfo<>();
        result.setData(new ResponseBlockInfoList(count, data));
        return result;
    }

    @RequestMapping("api/getBlockDetailList")
    public ResponseInfo<ResponseBlockDetailList> getBlockDetailList(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // page从0开始
        page = page - 1;
        if (page < 0) {
            page = 0;
        }


        String key = mMapper.getBlockKey(id);
        int count = mMapper.getBlockInfoCountByKey(key);
        List<ResponseBlockDetail> data = mMapper.getBlockDetailList(key ,page * PAGE_COUNT, PAGE_COUNT);
//        if (data != null) {
//            Collections.reverse(data);
//        }

        ResponseInfo<ResponseBlockDetailList> result = new ResponseInfo<>();
        result.setData(new ResponseBlockDetailList(count, data));
        return result;
    }
}
