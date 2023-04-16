package ru.ok.android.itmohack2023.sdk.libsRebuild;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class HlsMediaSource {

    com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory factory;

    public HlsMediaSource(
            com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory) {
        factory = new com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory(dataSourceFactory);
    }

    public static class Factory {

        private com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory factory;

        public Factory(
                com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory) throws IOException {
            Logger.createLog(() -> {
                this.factory = new com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory(
                        dataSourceFactory);
                return factory;
            });
//            Date start = new Date();
//            this.factory = new com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory(
//                    dataSourceFactory);
//            long interval = new Date().getTime() - start.getTime();
//
//            StackTraceElement[] stackArray=new Exception().getStackTrace();
//            String path=stackArray[1].toString();
//            Logger.log(interval, path);
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(@NonNull
                                                com.google.android.exoplayer2.MediaItem mediaItem) {
            return factory.createMediaSource(mediaItem);
        }
    }


}
