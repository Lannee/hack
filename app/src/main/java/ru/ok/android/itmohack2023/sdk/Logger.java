package ru.ok.android.itmohack2023.sdk;

import android.os.Build;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ru.ok.android.itmohack2023.ItmohackApplication;

public class Logger {

    private static int LOWER_BOUND = 0;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static String serverURL = "https://5352-77-234-205-3.ngrok-free.app/serve.php";

    static void postRequest(String postUrl, String postBody) throws IOException {

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
                Log.d("sat",response.body().string());
            }
        });
    }

    static String version = android.os.Build.VERSION.RELEASE + ":" + Build.BOARD;
    static String android_id = Settings.Secure.getString(ItmohackApplication.Companion.getContext().getContentResolver(), Secure.ANDROID_ID);

    public static void log(Long interval, String path) {
        if (interval <= LOWER_BOUND) return;
        String json = "{\"user\":\""+android_id+"\",\"time\":"+interval+",\"label\":\""+path+"\", \"version\":\""+
                version+"\"}";
        Log.d("pg",json);
        try {
            postRequest(serverURL,json);
        }catch (Exception e){
            Log.e("lib error",e.toString());
        }
    }

}
