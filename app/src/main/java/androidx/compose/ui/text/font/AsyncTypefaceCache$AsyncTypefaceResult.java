package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTypefaceCache$AsyncTypefaceResult {
    public final Object result;

    public final boolean equals(Object obj) {
        if (obj instanceof AsyncTypefaceCache$AsyncTypefaceResult) {
            return Intrinsics.areEqual(this.result, ((AsyncTypefaceCache$AsyncTypefaceResult) obj).result);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.result;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "AsyncTypefaceResult(result=" + this.result + ")";
    }
}
