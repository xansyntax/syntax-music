package com.yalantis.ucrop.callback;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri, int i, int i2, int i3, int i4);

    void onCropFailure(Throwable th);
}
