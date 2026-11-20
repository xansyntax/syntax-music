package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChangeList extends MathKt {
    public final Operations operations = new Operations();

    public final void clear() {
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingChanges(Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
        this.operations.executeAndFlushAllPendingOperations(applier, slotWriter, rememberEventDispatcher, operationErrorContext);
    }
}
