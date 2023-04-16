package ru.ok.android.itmohack2023.sdk.libsRebuild;

import java.io.IOException;
import java.util.Date;

import okhttp3.Response;
import ru.ok.android.itmohack2023.sdk.Logger;

public class Call {

    private okhttp3.Call call;

    public Call(okhttp3.Call call) {
        this.call = call;
    }

    public Response execute() throws IOException {
        Date dateStart = new Date();
        Response response = call.execute();
        Long interval = new Date().getTime() - dateStart.getTime();
        StackTraceElement[] stackArray=new Exception().getStackTrace();
        String path=stackArray[1].toString();
        Logger.log(interval, path);
        return response;
    }

}
