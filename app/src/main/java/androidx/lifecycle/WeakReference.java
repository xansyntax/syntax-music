package androidx.lifecycle;

import androidx.compose.runtime.saveable.SaveableStateHolder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WeakReference {
    public final java.lang.ref.WeakReference delegate;

    public WeakReference(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getClass();
        this.delegate = new java.lang.ref.WeakReference(lifecycleOwner);
    }

    public WeakReference(SaveableStateHolder saveableStateHolder) {
        this.delegate = new java.lang.ref.WeakReference(saveableStateHolder);
    }
}
