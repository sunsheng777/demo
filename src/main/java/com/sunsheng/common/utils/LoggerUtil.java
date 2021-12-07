package com.sunsheng.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public Logger getLogger(){
        return LoggerFactory.getLogger(getClass());
    }
}
