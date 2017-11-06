package com.nanobi.customlog4j;

import org.apache.logging.log4j.ThreadContext;

public class TestThread extends Thread implements Runnable {

    private final String threadName;

    public TestThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        ThreadContext.put("logFilename",   Thread.currentThread().getName());
        MyLogger m = new MyLogger();
        m.init(TestThread.class);
       // MyLogger.getLogger().debug("Starting new loop");
        m.getLogger().debug("Starting new loop");
        int i = 0;
        long threadId = Thread.currentThread().getId();
        for ( int z = 0; z < 3; z++){
            m.getLogger().warn("Thread number: " + threadId + " message number " + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                m.getLogger().error(e.toString(),e);
            }
        }
        MyNewClass m2 = new MyNewClass();
        m2.printSomething();
    }
}