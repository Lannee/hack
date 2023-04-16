package ru.ok.android.itmohack2023.sdk.libsRebuild;

import androidx.annotation.NonNull;

public class Glide {

    public static RequestManager with(@NonNull androidx.fragment.app.FragmentActivity activity) {
        return new RequestManager(com.bumptech.glide.Glide.with(activity));
    }
}
