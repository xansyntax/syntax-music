package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StateMapMutableKeysIterator extends AbstractJsonLexer implements Iterator, KMappedMarker {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StateMapMutableKeysIterator(SnapshotStateMap snapshotStateMap, Iterator it, byte b) {
        super(snapshotStateMap, it);
        this.$r8$classId = b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                Map.Entry entry = (Map.Entry) this.escapedString;
                if (entry != null) {
                    advance$1();
                    return entry.getKey();
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return null;
            case 1:
                advance$1();
                if (((Map.Entry) this.peekedString) != null) {
                    return new StateMapMutableEntriesIterator$next$1(this);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return null;
            default:
                Map.Entry entry2 = (Map.Entry) this.escapedString;
                if (entry2 != null) {
                    advance$1();
                    return entry2.getValue();
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return null;
        }
    }
}
