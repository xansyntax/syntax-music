package androidx.compose.runtime.internal;

import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntRef {
    public int element = 0;

    public final String toString() {
        int i = this.element;
        int iHashCode = hashCode();
        CharsKt.checkRadix(16);
        String string = Integer.toString(iHashCode, 16);
        string.getClass();
        return "IntRef(element = " + i + ")@" + string;
    }
}
