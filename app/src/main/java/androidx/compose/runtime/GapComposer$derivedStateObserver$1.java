package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GapComposer$derivedStateObserver$1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ GapComposer$derivedStateObserver$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    public final void done() {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                ((GapComposer) obj).childrenComposing--;
                break;
            default:
                ((SnapshotStateObserver.ObservedScopeMap) obj).deriveStateScopeCount--;
                break;
        }
    }

    public final void start() {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                ((GapComposer) obj).childrenComposing++;
                break;
            default:
                ((SnapshotStateObserver.ObservedScopeMap) obj).deriveStateScopeCount++;
                break;
        }
    }
}
