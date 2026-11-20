package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda44;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextMenuPopupPositionProviderKt {

    /* JADX INFO: renamed from: lambda$-1571120048, reason: not valid java name */
    public static final ComposableLambdaImpl f1lambda$1571120048 = new ComposableLambdaImpl(false, -1571120048, new ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda0());

    /* JADX INFO: renamed from: lambda$-1455401925, reason: not valid java name */
    public static final ComposableLambdaImpl f0lambda$1455401925 = new ComposableLambdaImpl(false, -1455401925, new MainActivity$$ExternalSyntheticLambda44((byte) 1));

    /* JADX WARN: Code duplicated, block: B:27:0x0026 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0027  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0011, code lost:
    
        if (r5 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0015, code lost:
    
        return r2 - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int alignPopupAxis(int i, int i2, int i3, boolean z) {
        if (i2 >= i3) {
            if (z) {
                return 0;
            }
            return i3 - i2;
        }
        if (z) {
            if (z) {
                if (z) {
                    return i3 - i2;
                }
                return 0;
            }
            if (z) {
                return 0;
            }
            return i3 - i2;
        }
        if (z ? i3 - i2 <= i : i2 > i) {
            if (z) {
                return 0;
            }
            return i3 - i2;
        }
        if (z) {
            return i - i2;
        }
        return i;
    }
}
