package ru.ok.android.itmohack2023

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import ru.ok.android.itmohack2023.sdk.Logger
import java.util.Date

class JNIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jniactivity)
        Threads.ioPool.execute {
            var result = nativeFunction() ?: return@execute

            result = result.dropWhile { it != '{' }

            val textJson = JSONObject(result)
            val dateStart = Date();
            val act =
                textJson.getString("activity")
            runOnUiThread {
                val interval = Date().time - dateStart.time
                val stackArray = Exception().stackTrace
                val path = stackArray[0].toString()
                Logger.log(interval, path)
                findViewById<TextView>(R.id.result).text = act
            }

        }
    }

    external fun nativeFunction(): String?

    companion object {
        init {
            System.loadLibrary("jnisocket");
        }
    }
}