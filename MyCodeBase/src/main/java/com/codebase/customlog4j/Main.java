package com.codebase.customlog4j;

import org.apache.logging.log4j.ThreadContext;

public class Main {

    public static void main(String[] args) {
        ThreadContext.put("logFilename","main");
       // MyLogger.init();
        MyLogger m = new MyLogger();
        m.init(Main.class);

        int i;
       // MyLogger.getLogger().info("Started");
        m.getLogger().info("Started");
        TestThread testThread;
        testThread = new TestThread("test1");
        testThread.start();
        testThread = new TestThread("test2");
        testThread.start();

        for ( i = 0; i < 4; i++){
            try {

                //MyLogger.getLogger().debug("GUI log");
            	m.getLogger().debug("GUI log");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //MyLogger.getLogger().info("Finished");
        m.getLogger().info("Finished");
    }
}