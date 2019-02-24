package com.seagle.performance.performance.util;

import org.springframework.util.DigestUtils;

/**
 *
 */
public class StackTraceUtil {
    public static String generateStackTrackKey(String stackTrace){
        String[] stacks=stackTrace.split("\r");
        return DigestUtils.md5DigestAsHex(stackTrace.getBytes());
    }
}
