package ru.ok.android.itmohack2023.sdk.libsRebuild;

import android.net.Uri;
import android.provider.ContactsContract;

import com.facebook.imagepipeline.request.ImageRequest;

import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class ImageRequestBuilder {

    private com.facebook.imagepipeline.request.ImageRequestBuilder imageRequestBuilder;

    private ImageRequestBuilder(Uri uri) {
        this.imageRequestBuilder = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri);
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder(uri);
    }

    public ImageRequestBuilder disableDiskCache() {
        imageRequestBuilder = imageRequestBuilder.disableDiskCache();
        return this;
    }

    public ImageRequestBuilder disableMemoryCache() {
        imageRequestBuilder = imageRequestBuilder.disableMemoryCache();
        return this;
    }

    public ImageRequest build() {
        Date dateStart = new Date();
        ImageRequest ir = imageRequestBuilder.build();
        Long interval = new Date().getTime() - dateStart.getTime();
        StackTraceElement[] stackArray=new Exception().getStackTrace();
        String path=stackArray[0].toString();
        Logger.log(interval, path);
        return ir;
    }

}
