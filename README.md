# SDK
## Installing
git clone https://github.com/Lannee/hack.git
## Setting
Set in Config.class:
* LOWER_BOUNT - Наименьшее отслеживаемое значение задержки
* serverURL - Ссылка на сервер
## Usage

```java
package ru.ok.android.itmohack2023

import ...
import ru.ok.android.itmohack2023.sdk.libsRebuild.OkHttpClient

class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        'Some code...'
    }

    @Throws(IOException::class)
    fun run(url: String): String? {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        OkHttpClient().newCall(request).execute().use { response -> return response.body?.string() }
    }
}

```

## System requirements
Android version 12


![Image alt](https://media.tenor.com/ZbMRvPVH9NMAAAAC/yuriyuri-lol.gif)
