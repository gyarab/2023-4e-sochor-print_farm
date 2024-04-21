package com.example.printfarm;

import android.app.Activity;
import android.widget.TextView;

public class MainThreadHandler {
    private static Thread thread;
    private static TextView text;

    public static synchronized Thread getThread() {
        return thread;
    }
    public static synchronized void setThread(Thread thread) {
        MainThreadHandler.thread = thread;
    }
    public static synchronized TextView getText() {
        return text;
    }
    public static synchronized void setText(TextView text) {
        MainThreadHandler.text = text;
    }

}

