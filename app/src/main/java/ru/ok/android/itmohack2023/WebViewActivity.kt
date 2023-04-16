package ru.ok.android.itmohack2023

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import ru.ok.android.itmohack2023.sdk.Logger
import java.util.Date


class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true

        val start : Date = Date();
        val htmlText = resources.assets.open("webview.html")
            .bufferedReader()
            .use { it.readText() }
        val interval : Long = Date().time - start.time
        val stackArray = Exception().stackTrace
        val path = stackArray[0].toString()
        Logger.log(interval, path);

        webView.loadDataWithBaseURL("", htmlText, "text/html", "UTF-8", "")
    }
}