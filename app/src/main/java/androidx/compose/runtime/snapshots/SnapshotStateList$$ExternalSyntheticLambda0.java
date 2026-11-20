package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateList$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda0(Collection collection, byte b) {
        this.$r8$classId = b;
        this.f$0 = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zRetainAll;
        byte b = this.$r8$classId;
        Collection<?> collection = this.f$0;
        switch (b) {
            case 0:
                zRetainAll = ((List) obj).retainAll(collection);
                break;
            case 1:
                zRetainAll = collection.contains(obj);
                break;
            default:
                zRetainAll = collection.contains(obj);
                break;
        }
        return Boolean.valueOf(zRetainAll);
    }
}
