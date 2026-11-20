package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import android.net.Uri;
import com.yalantis.ucrop.model.ExifInfo;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BitmapLoadCallback {
    void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2);

    void onFailure(Exception exc);
}
