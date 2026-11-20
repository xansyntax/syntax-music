package androidx.compose.ui.platform;

import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InputMethodSession {
    public boolean disposed;
    public final RoomDatabase$$ExternalSyntheticLambda0 onAllConnectionsClosed;
    public final LegacyTextInputMethodRequest request;
    public final Object lock = new Object();
    public final MutableVector connections = new MutableVector(new WeakReference[16]);

    public InputMethodSession(LegacyTextInputMethodRequest legacyTextInputMethodRequest, RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0) {
        this.request = legacyTextInputMethodRequest;
        this.onAllConnectionsClosed = roomDatabase$$ExternalSyntheticLambda0;
    }
}
