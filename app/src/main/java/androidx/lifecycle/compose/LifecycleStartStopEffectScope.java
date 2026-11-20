package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleStartStopEffectScope implements LifecycleOwner {
    public final Lifecycle lifecycle;

    public LifecycleStartStopEffectScope(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }
}
