package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NodeList extends LockFreeLinkedListNode implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean isRemoved() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return this;
    }
}
