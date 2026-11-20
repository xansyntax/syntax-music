package kotlinx.coroutines;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InactiveNodeList implements Incomplete {
    public final NodeList list;

    public InactiveNodeList(NodeList nodeList) {
        this.list = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return this.list;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return false;
    }
}
