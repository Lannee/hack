package ru.ok.android.itmohack2023

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

class ItmohackApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    companion object {
        var context: Context? = null
    }
}