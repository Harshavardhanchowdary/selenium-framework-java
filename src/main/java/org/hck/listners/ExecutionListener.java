package org.hck.listners;

import org.testng.IExecutionListener;

import java.util.Date;

public class ExecutionListener implements IExecutionListener {
    private static final String pattern = "**********************************************************";
    @Override
    public void onExecutionStart() {

        System.out.println(pattern);
        System.out.println("     TESTING IS ABOUT TO START. ["+new Date( )+"]");
        System.out.println(pattern);

    }

    @Override
    public void onExecutionFinish() {
        System.out.println(pattern);
        System.out.println("     TESTING FINISHED. ["+new Date( )+"]");
        System.out.println(pattern);

    }



}
