package com.nanobi.customlog4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {

    private Logger logger;

    public void init(Class c){
        logger = LogManager.getLogger(c);
    }

    public  Logger getLogger(){
        return logger;
    }
}
