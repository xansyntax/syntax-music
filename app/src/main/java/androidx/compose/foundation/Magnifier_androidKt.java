package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.semantics.SemanticsPropertyKey;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Magnifier_androidKt {
    public static final SemanticsPropertyKey MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot");

    public static boolean isPlatformMagnifierSupported$default() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
