package androidx.lifecycle.viewmodel.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelImpl {
    public volatile boolean isCleared;
    public final SynchronizedObject lock = new SynchronizedObject();
    public final LinkedHashMap keyToCloseables = new LinkedHashMap();
    public final LinkedHashSet closeables = new LinkedHashSet();

    public static void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                Fragment$5$$ExternalSyntheticOutline0.m(autoCloseable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
