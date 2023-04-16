package ru.ok.android.itmohack2023.sdk.libsRebuild;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.request.target.ViewTarget;

import java.io.IOException;
import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class RequestBuilder <T> {

    private com.bumptech.glide.RequestBuilder<T> requestBuilder;

    public RequestBuilder(com.bumptech.glide.RequestBuilder<T> requestBuilder) {
        this.requestBuilder = requestBuilder;
    }

    public ViewTarget<ImageView, T> into(@NonNull android.widget.ImageView view) throws IOException {
        return Logger.createLog(() -> requestBuilder.into(view));
//        Date dateStart = new Date();
//        ViewTarget<ImageView, T> viewRes = requestBuilder.into(view);
//        Long interval = new Date().getTime() - dateStart.getTime();
//        StackTraceElement[] stackArray=new Exception().getStackTrace();
//        String path=stackArray[1].toString();
//        Logger.log(interval, path);
//        return viewRes;
    }
}
