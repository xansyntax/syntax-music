package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SetComposingRegionCommand implements EditCommand {
    public final int end;
    public final int start;

    public SetComposingRegionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        boolean z = longArrayQueue.size != -1;
        TimedValueQueue timedValueQueue = (TimedValueQueue) longArrayQueue.data;
        if (z) {
            longArrayQueue.size = -1;
            longArrayQueue.wrapAroundMask = -1;
        }
        int iCoerceIn = UuidKt.coerceIn(this.start, 0, timedValueQueue.getLength());
        int iCoerceIn2 = UuidKt.coerceIn(this.end, 0, timedValueQueue.getLength());
        if (iCoerceIn != iCoerceIn2) {
            if (iCoerceIn < iCoerceIn2) {
                longArrayQueue.setComposition$ui_text(iCoerceIn, iCoerceIn2);
            } else {
                longArrayQueue.setComposition$ui_text(iCoerceIn2, iCoerceIn);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingRegionCommand)) {
            return false;
        }
        SetComposingRegionCommand setComposingRegionCommand = (SetComposingRegionCommand) obj;
        return this.start == setComposingRegionCommand.start && this.end == setComposingRegionCommand.end;
    }

    public final int hashCode() {
        return (this.start * 31) + this.end;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.start, "SetComposingRegionCommand(start=", ", end=", this.end, ")");
    }
}
