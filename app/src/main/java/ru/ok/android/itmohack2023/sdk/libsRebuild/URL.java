package ru.ok.android.itmohack2023.sdk.libsRebuild;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class URL {

    private final java.net.URL url;

    public URL(String spec) throws MalformedURLException {
        url = new java.net.URL(spec);
    }

    public URLConnection openConnection() throws IOException {
        Date start = new Date();
        URLConnection connection = url.openConnection();
        Long interval = new Date().getTime() - start.getTime();

        StackTraceElement[] stackArray = new Exception().getStackTrace();
        String path=stackArray[stackArray.length - 4].toString();

        Logger.log(interval, path);
        return connection;
    }
}
