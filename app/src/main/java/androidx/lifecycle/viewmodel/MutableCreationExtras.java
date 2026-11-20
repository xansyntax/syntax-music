package androidx.lifecycle.viewmodel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(CreationExtras creationExtras) {
        creationExtras.getClass();
        this.extras.putAll(creationExtras.extras);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public final Object get(CreationExtras.Key key) {
        return this.extras.get(key);
    }

    public /* synthetic */ MutableCreationExtras(int i) {
        this(CreationExtras.Empty.INSTANCE);
    }
}
