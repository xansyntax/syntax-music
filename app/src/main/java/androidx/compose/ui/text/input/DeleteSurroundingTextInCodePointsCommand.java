package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public final int lengthAfterCursor;
    public final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        int i = 0;
        for (int i2 = 0; i2 < this.lengthBeforeCursor; i2++) {
            int i3 = i + 1;
            int i4 = longArrayQueue.headIndex;
            if (i4 <= i3) {
                i = i4;
                break;
            }
            i = (Character.isHighSurrogate(longArrayQueue.get$ui_text((i4 - i3) + (-1))) && Character.isLowSurrogate(longArrayQueue.get$ui_text(longArrayQueue.headIndex - i3))) ? i + 2 : i3;
        }
        int length = 0;
        for (int i5 = 0; i5 < this.lengthAfterCursor; i5++) {
            int i6 = length + 1;
            int i7 = longArrayQueue.tailIndex;
            TimedValueQueue timedValueQueue = (TimedValueQueue) longArrayQueue.data;
            if (i7 + i6 >= timedValueQueue.getLength()) {
                length = timedValueQueue.getLength() - longArrayQueue.tailIndex;
                break;
            }
            length = (Character.isHighSurrogate(longArrayQueue.get$ui_text((longArrayQueue.tailIndex + i6) + (-1))) && Character.isLowSurrogate(longArrayQueue.get$ui_text(longArrayQueue.tailIndex + i6))) ? length + 2 : i6;
        }
        int i8 = longArrayQueue.tailIndex;
        longArrayQueue.delete$ui_text(i8, length + i8);
        int i9 = longArrayQueue.headIndex;
        longArrayQueue.delete$ui_text(i9 - i, i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public final int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.lengthBeforeCursor, "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=", ", lengthAfterCursor=", this.lengthAfterCursor, ")");
    }
}
