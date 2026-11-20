package androidx.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class GapRememberObserverHolder implements RememberObserverHolder {
    public final int afterGroupIndex;
    public final RememberObserver wrapped;

    public GapRememberObserverHolder(RememberObserver rememberObserver, int i) {
        this.wrapped = rememberObserver;
        this.afterGroupIndex = i;
    }

    @Override // androidx.compose.runtime.RememberObserverHolder
    public final RememberObserver getWrapped() {
        return this.wrapped;
    }
}
