package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SetSelectionCommand implements EditCommand {
    public final int end;
    public final int start;

    public SetSelectionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        int iCoerceIn = UuidKt.coerceIn(this.start, 0, ((TimedValueQueue) longArrayQueue.data).getLength());
        int iCoerceIn2 = UuidKt.coerceIn(this.end, 0, ((TimedValueQueue) longArrayQueue.data).getLength());
        if (iCoerceIn < iCoerceIn2) {
            longArrayQueue.setSelection$ui_text(iCoerceIn, iCoerceIn2);
        } else {
            longArrayQueue.setSelection$ui_text(iCoerceIn2, iCoerceIn);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetSelectionCommand)) {
            return false;
        }
        SetSelectionCommand setSelectionCommand = (SetSelectionCommand) obj;
        return this.start == setSelectionCommand.start && this.end == setSelectionCommand.end;
    }

    public final int hashCode() {
        return (this.start * 31) + this.end;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.start, "SetSelectionCommand(start=", ", end=", this.end, ")");
    }
}
