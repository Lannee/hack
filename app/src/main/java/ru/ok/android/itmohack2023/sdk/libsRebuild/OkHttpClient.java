package ru.ok.android.itmohack2023.sdk.libsRebuild;

import okhttp3.Request;

public class OkHttpClient {
    public OkHttpClient() {
    }

    public Call newCall(Request request) {
        okhttp3.Call call = new okhttp3.OkHttpClient().newCall(request);
        return new Call(call);
    }
}
