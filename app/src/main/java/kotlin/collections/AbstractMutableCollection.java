package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMutableCollection extends java.util.AbstractCollection implements Collection, KMutableCollection {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
