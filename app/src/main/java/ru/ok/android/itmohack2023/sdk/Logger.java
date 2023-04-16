package ru.ok.android.itmohack2023.sdk;

import static android.content.Context.ACCOUNT_SERVICE;
import static android.os.Build.VERSION.BASE_OS;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;

import ru.ok.android.itmohack2023.ItmohackApplication;

public class Logger {
    /*
        public static void log(String log){
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("D:\\Egor\\hack\\Itmo-hack-2023\\app\\src\\main\\java\\ru\\ok\\android\\itmohack2023\\sdk\\test");
                fos.write(log.getBytes(StandardCharsets.UTF_8));
                fos.close();
            } catch (IOException e) {
                String error = e.getMessage();
            }
        }
        */

    String maks;
    static String version = android.os.Build.VERSION.RELEASE+":"+Build.BOARD;
    static String android_id=Settings.Secure.getString(ItmohackApplication.Companion.getContext().getContentResolver(), Secure.ANDROID_ID);

    public static void log(Long interval, String path) {
        Log.d("jopa",interval+" "+path+" "+android_id+" "+version);
    }
}
