package com.muke.util;

import cn.hutool.core.util.IdUtil;

/**
 * 雪花算法工具类
 *
 * @author tangcj
 * @date 2024/01/11 16:11
 **/
public class SnowUtil {

    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}
