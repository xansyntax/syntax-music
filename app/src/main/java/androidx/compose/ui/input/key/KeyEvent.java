package androidx.compose.ui.input.key;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEvent {
    public final android.view.KeyEvent nativeKeyEvent;

    public final boolean equals(Object obj) {
        if (obj instanceof KeyEvent) {
            return Intrinsics.areEqual(this.nativeKeyEvent, ((KeyEvent) obj).nativeKeyEvent);
        }
        return false;
    }

    public final int hashCode() {
        return this.nativeKeyEvent.hashCode();
    }

    public final String toString() {
        return "KeyEvent(nativeKeyEvent=" + this.nativeKeyEvent + ")";
    }
}
