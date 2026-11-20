package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SetComposingTextCommand implements EditCommand {
    public final AnnotatedString annotatedString;
    public final int newCursorPosition;

    public SetComposingTextCommand(String str, int i) {
        this.annotatedString = new AnnotatedString(str);
        this.newCursorPosition = i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        String str = this.annotatedString.text;
        int i = longArrayQueue.size;
        if (i != -1) {
            longArrayQueue.replace$ui_text(i, longArrayQueue.wrapAroundMask, str);
            if (str.length() > 0) {
                longArrayQueue.setComposition$ui_text(i, str.length() + i);
            }
        } else {
            int i2 = longArrayQueue.headIndex;
            longArrayQueue.replace$ui_text(i2, longArrayQueue.tailIndex, str);
            if (str.length() > 0) {
                longArrayQueue.setComposition$ui_text(i2, str.length() + i2);
            }
        }
        int i3 = longArrayQueue.headIndex;
        int i4 = longArrayQueue.tailIndex;
        int i5 = i3 == i4 ? i4 : -1;
        int i6 = this.newCursorPosition;
        int iCoerceIn = UuidKt.coerceIn(i6 > 0 ? (i5 + i6) - 1 : (i5 + i6) - str.length(), 0, ((TimedValueQueue) longArrayQueue.data).getLength());
        longArrayQueue.setSelection$ui_text(iCoerceIn, iCoerceIn);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingTextCommand)) {
            return false;
        }
        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) obj;
        return Intrinsics.areEqual(this.annotatedString.text, setComposingTextCommand.annotatedString.text) && this.newCursorPosition == setComposingTextCommand.newCursorPosition;
    }

    public final int hashCode() {
        return (this.annotatedString.text.hashCode() * 31) + this.newCursorPosition;
    }

    public final String toString() {
        return "SetComposingTextCommand(text='" + this.annotatedString.text + "', newCursorPosition=" + this.newCursorPosition + ")";
    }
}
