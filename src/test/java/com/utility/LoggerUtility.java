package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility
{
    //Logger logger;
    private LoggerUtility()
    {}
    public static Logger GetLogger(Class<?> clasz)
    {
        Logger logger = null;
        if(logger == null)
        {
            logger = LogManager.getLogger(clasz);
        }
        return logger;

    }

}
