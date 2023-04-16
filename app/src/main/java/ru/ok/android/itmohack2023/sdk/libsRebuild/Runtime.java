package ru.ok.android.itmohack2023.sdk.libsRebuild;

import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class Runtime {

    private static Runtime runtime = null;

    private Runtime() {

    }

    public static Runtime getRuntime() {
        return runtime != null ? runtime : (runtime = new Runtime());
    }

    public Process exec(String command) throws java.io.IOException {
        Date start = new Date();
        Process process = java.lang.Runtime.getRuntime().exec(command);
        Long interval = new Date().getTime() - start.getTime();

        StackTraceElement[] stackArray = new Exception().getStackTrace();
        String path=stackArray[stackArray.length - 1].toString();

        Logger.log(interval, path);
        return process;
    }
}
