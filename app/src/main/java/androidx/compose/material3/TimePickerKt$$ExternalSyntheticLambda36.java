package androidx.compose.material3;

import androidx.collection.internal.Lock;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketDeflateExtension;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda36 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda36(LazyListState lazyListState, int i) {
        this.$r8$classId = (byte) 1;
        this.f$0 = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zM418requestFocus3ESFkO8;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$0;
        switch (b) {
            case 0:
                SemanticsPropertiesKt.setTraversalIndex((SemanticsPropertyReceiver) obj, i + 1.0f);
                return unit;
            case 1:
                LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = (LazyLayoutPrefetchState.NestedPrefetchScopeImpl) obj;
                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                Lock.restoreNonObservable(currentThreadSnapshot, Lock.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
                int i2 = nestedPrefetchScopeImpl.nestedPrefetchItemCount;
                if (i2 == -1) {
                    i2 = 2;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    nestedPrefetchScopeImpl.schedulePrecomposition(i + i3);
                }
                return unit;
            case 2:
                SemanticsPropertiesKt.setTraversalIndex((SemanticsPropertyReceiver) obj, i + 1.0f);
                return unit;
            case 3:
                zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m418requestFocus3ESFkO8(i);
                break;
            case 4:
                zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m418requestFocus3ESFkO8(i);
                break;
            case 5:
                zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m417assignFocus3ESFkO8(i);
                break;
            case 6:
                zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m418requestFocus3ESFkO8(i);
                break;
            case 7:
                zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m418requestFocus3ESFkO8(i);
                break;
            case 8:
                zM418requestFocus3ESFkO8 = WebSocketDeflateExtension.Config.compressIfBiggerThan$lambda$0(i, (Frame) obj);
                break;
            default:
                ((Integer) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i + '.');
        }
        return Boolean.valueOf(zM418requestFocus3ESFkO8);
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda36(byte b, int i) {
        this.$r8$classId = b;
        this.f$0 = i;
    }
}
