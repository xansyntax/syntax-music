package androidx.core.os;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class BuildCompat$$ExternalSyntheticBackportWithForwarding1 {
    public static /* synthetic */ int m() {
        int i = Build.VERSION.SDK_INT;
        return i < 36 ? i * 100000 : Build.VERSION.SDK_INT_FULL;
    }
}
