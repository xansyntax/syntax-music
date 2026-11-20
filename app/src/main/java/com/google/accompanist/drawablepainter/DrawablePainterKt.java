package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Drawable;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DrawablePainterKt {
    public static final Lazy MAIN_HANDLER$delegate = ResultKt.lazy(LazyThreadSafetyMode.NONE, new UtilsKt$$ExternalSyntheticLambda0((byte) 25));

    public static final long getIntrinsicSize(Drawable drawable) {
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return 9205357640488583168L;
        }
        return (((long) Float.floatToRawIntBits(drawable.getIntrinsicWidth())) << 32) | (((long) Float.floatToRawIntBits(drawable.getIntrinsicHeight())) & 4294967295L);
    }
}
