package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteSurroundingTextCommand implements EditCommand {
    public final int lengthAfterCursor;
    public final int lengthBeforeCursor;

    public DeleteSurroundingTextCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        int i = longArrayQueue.tailIndex;
        TimedValueQueue timedValueQueue = (TimedValueQueue) longArrayQueue.data;
        int i2 = this.lengthAfterCursor;
        int length = i + i2;
        if (((i ^ length) & (i2 ^ length)) < 0) {
            length = timedValueQueue.getLength();
        }
        longArrayQueue.delete$ui_text(longArrayQueue.tailIndex, Math.min(length, timedValueQueue.getLength()));
        int i3 = longArrayQueue.headIndex;
        int i4 = this.lengthBeforeCursor;
        int i5 = i3 - i4;
        if (((i4 ^ i3) & (i3 ^ i5)) < 0) {
            i5 = 0;
        }
        longArrayQueue.delete$ui_text(Math.max(0, i5), longArrayQueue.headIndex);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextCommand)) {
            return false;
        }
        DeleteSurroundingTextCommand deleteSurroundingTextCommand = (DeleteSurroundingTextCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextCommand.lengthAfterCursor;
    }

    public final int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.lengthBeforeCursor, "DeleteSurroundingTextCommand(lengthBeforeCursor=", ", lengthAfterCursor=", this.lengthAfterCursor, ")");
    }
}
