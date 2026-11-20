package androidx.compose.ui.text.input;

import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteAllCommand implements EditCommand {
    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        longArrayQueue.replace$ui_text(0, ((TimedValueQueue) longArrayQueue.data).getLength(), "");
    }

    public final boolean equals(Object obj) {
        return obj instanceof DeleteAllCommand;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(DeleteAllCommand.class).hashCode();
    }

    public final String toString() {
        return "DeleteAllCommand()";
    }
}
