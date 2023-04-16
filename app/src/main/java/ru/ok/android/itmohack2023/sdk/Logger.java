package ru.ok.android.itmohack2023.sdk;

import static ru.ok.android.itmohack2023.sdk.Config.serverURL;

import android.os.Build;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.util.Log;

import java.io.IOException;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ru.ok.android.itmohack2023.ItmohackApplication;
import ru.ok.android.itmohack2023.sdk.libsRebuild.SupplierIO;

public class Logger {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static void postRequest(String postUrl, String postBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, postBody);

        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("sat", response.body().string());
            }
        });
    }

    private static String version = android.os.Build.VERSION.RELEASE + ":" + Build.BOARD;
    private static String android_id = Settings.Secure.getString(ItmohackApplication.Companion.getContext().getContentResolver(), Secure.ANDROID_ID);

    public static void log(Long interval, String path) {
        if (interval <= Config.LOWER_BOUND) return;
        Date time = new Date();
        String json = "{\"user\":\"" + android_id + "\",\"time\":" + interval + ",\"label\":\"" + path + "\", \"version\":\"" +
                version + "\"}";
        Log.d("pg", json);
        try {
            postRequest(serverURL, json);
        } catch (Exception e) {
            Log.e("lib error", e.toString());
        }
    }

    public static <R> R createLog(SupplierIO<R> traced) throws IOException {
        Date start = new Date();
        R connection = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            connection = traced.get();
        }
        Long interval = new Date().getTime() - start.getTime();

        StackTraceElement[] stackArray = new Exception().getStackTrace();
        String path=stackArray[2].toString();

        Logger.log(interval, path);
        return connection;
    }
}
