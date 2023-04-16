package ru.ok.android.itmohack2023.sdk.libsRebuild;

import com.squareup.picasso.RequestCreator;

import java.util.Date;

import ru.ok.android.itmohack2023.sdk.Logger;

public class Picasso {
        public static Picasso get() {
            return new Picasso();
        }
        public RequestCreator load(String url) {
            Date dateStart = new Date();
            RequestCreator rc = com.squareup.picasso.Picasso.get().load(url);
            Long interval = new Date().getTime() - dateStart.getTime();
            StackTraceElement[] stackArray=new Exception().getStackTrace();
            String path=stackArray[1].toString();
            Logger.log(interval, path);
            return rc;
        }

}
