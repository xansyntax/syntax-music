package kotlin;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InitializedLazyImpl implements Lazy, Serializable {
    public final Object value;

    public InitializedLazyImpl(Object obj) {
        this.value = obj;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        return this.value;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return true;
    }

    public final String toString() {
        return String.valueOf(this.value);
    }
}
