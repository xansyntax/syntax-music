package androidx.compose.foundation.text.handwriting;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StylusHandwriting_androidKt {
    public static final boolean isStylusHandwritingSupported;

    static {
        isStylusHandwritingSupported = Build.VERSION.SDK_INT >= 34;
    }
}
