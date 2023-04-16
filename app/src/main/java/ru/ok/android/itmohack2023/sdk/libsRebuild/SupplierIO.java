package ru.ok.android.itmohack2023.sdk.libsRebuild;

import java.io.IOException;

@FunctionalInterface
public interface SupplierIO<R> {
    R get() throws IOException;
}
