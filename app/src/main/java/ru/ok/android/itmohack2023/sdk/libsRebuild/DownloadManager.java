package ru.ok.android.itmohack2023.sdk.libsRebuild;

import android.net.Uri;

import java.util.Date;

import okhttp3.Response;
import ru.ok.android.itmohack2023.sdk.Logger;

public class DownloadManager {

    private android.app.DownloadManager downloadManager;

    public DownloadManager(android.app.DownloadManager downloadManager) {
        this.downloadManager = downloadManager;
    }

    public static class Request {

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        private android.app.DownloadManager.Request request;

        public Request(Uri uri) {
            this.request = new android.app.DownloadManager.Request(uri);
        }

        public Request(android.app.DownloadManager.Request request) {
            this.request = request;
        }

        public DownloadManager.Request setTitle(CharSequence title) {
            return new Request(request.setTitle(title));
        }

        public  DownloadManager.Request setDescription(CharSequence description) {
            return new Request(request.setDescription(description));
        }

        public DownloadManager.Request setNotificationVisibility(int visibility) {
            return new Request(request.setNotificationVisibility(visibility));
        }

        public DownloadManager.Request setDestinationInExternalPublicDir(String dirType,
                                                                              String subPath) {
            return new Request(request.setDestinationInExternalPublicDir(dirType, subPath));
        }
    }

    public long enqueue(DownloadManager.Request request) {
        Date dateStart = new Date();
        long download = downloadManager.enqueue(request.request);
        Long interval = new Date().getTime() - dateStart.getTime();
        StackTraceElement[] stackArray=new Exception().getStackTrace();
        String path=stackArray[0].toString();
        Logger.log(interval, path);
        return download;
    }
}
