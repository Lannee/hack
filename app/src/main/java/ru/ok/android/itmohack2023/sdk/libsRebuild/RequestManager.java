package ru.ok.android.itmohack2023.sdk.libsRebuild;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class RequestManager {

    private com.bumptech.glide.RequestManager requestManager;

    public RequestManager(com.bumptech.glide.RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public RequestBuilder<Drawable> load(@Nullable String string) {
        return new ru.ok.android.itmohack2023.sdk.libsRebuild.RequestBuilder<>(requestManager.load(string));
    }

}
