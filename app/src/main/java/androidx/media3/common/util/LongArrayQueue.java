package androidx.media3.common.util;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LongArrayQueue {
    public final /* synthetic */ byte $r8$classId = 0;
    public Object data;
    public int headIndex;
    public int size;
    public int tailIndex;
    public int wrapAroundMask;

    public LongArrayQueue(AnnotatedString annotatedString, long j) {
        String str = annotatedString.text;
        TimedValueQueue timedValueQueue = new TimedValueQueue((byte) 3);
        timedValueQueue.timestamps = str;
        timedValueQueue.first = -1;
        timedValueQueue.size = -1;
        this.data = timedValueQueue;
        this.headIndex = TextRange.m744getMinimpl(j);
        this.tailIndex = TextRange.m743getMaximpl(j);
        this.size = -1;
        this.wrapAroundMask = -1;
        int iM744getMinimpl = TextRange.m744getMinimpl(j);
        int iM743getMaximpl = TextRange.m743getMaximpl(j);
        if (iM744getMinimpl < 0 || iM744getMinimpl > str.length()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(iM744getMinimpl, str.length(), "start (", ") offset is outside of text region "));
            throw null;
        }
        if (iM743getMaximpl < 0 || iM743getMaximpl > str.length()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(iM743getMaximpl, str.length(), "end (", ") offset is outside of text region "));
            throw null;
        }
        if (iM744getMinimpl <= iM743getMaximpl) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(iM744getMinimpl, iM743getMaximpl, "Do not set reversed range: ", " > "));
        throw null;
    }

    public void delete$ui_text(int i, int i2) {
        long jTextRange = TextRangeKt.TextRange(i, i2);
        ((TimedValueQueue) this.data).replace(i, i2, "");
        long jM889updateRangeAfterDeletepWDy79M = LifecyclesKt.m889updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.headIndex, this.tailIndex), jTextRange);
        setSelectionStart(TextRange.m744getMinimpl(jM889updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m743getMaximpl(jM889updateRangeAfterDeletepWDy79M));
        int i3 = this.size;
        if (i3 != -1) {
            long jM889updateRangeAfterDeletepWDy79M2 = LifecyclesKt.m889updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(i3, this.wrapAroundMask), jTextRange);
            if (TextRange.m741getCollapsedimpl(jM889updateRangeAfterDeletepWDy79M2)) {
                this.size = -1;
                this.wrapAroundMask = -1;
            } else {
                this.size = TextRange.m744getMinimpl(jM889updateRangeAfterDeletepWDy79M2);
                this.wrapAroundMask = TextRange.m743getMaximpl(jM889updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public char get$ui_text(int i) {
        TimedValueQueue timedValueQueue = (TimedValueQueue) this.data;
        GapBuffer gapBuffer = (GapBuffer) timedValueQueue.values;
        if (gapBuffer == null) {
            return ((String) timedValueQueue.timestamps).charAt(i);
        }
        if (i < timedValueQueue.first) {
            return ((String) timedValueQueue.timestamps).charAt(i);
        }
        int iGapLength = gapBuffer.capacity - gapBuffer.gapLength();
        int i2 = timedValueQueue.first;
        if (i >= iGapLength + i2) {
            return ((String) timedValueQueue.timestamps).charAt(i - ((iGapLength - timedValueQueue.size) + i2));
        }
        int i3 = i - i2;
        int i4 = gapBuffer.gapStart;
        char[] cArr = (char[]) gapBuffer.buffer;
        return i3 < i4 ? cArr[i3] : cArr[(i3 - i4) + gapBuffer.gapEnd];
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text, reason: not valid java name */
    public TextRange m836getCompositionMzsxiRA$ui_text() {
        int i = this.size;
        if (i != -1) {
            return new TextRange(TextRangeKt.TextRange(i, this.wrapAroundMask));
        }
        return null;
    }

    public long remove() {
        int i = this.size;
        if (i == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return 0L;
        }
        long[] jArr = (long[]) this.data;
        int i2 = this.headIndex;
        long j = jArr[i2];
        this.headIndex = this.wrapAroundMask & (i2 + 1);
        this.size = i - 1;
        return j;
    }

    public void replace$ui_text(int i, int i2, String str) {
        TimedValueQueue timedValueQueue = (TimedValueQueue) this.data;
        if (i < 0 || i > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, timedValueQueue.getLength(), "start (", ") offset is outside of text region "));
            return;
        }
        if (i2 < 0 || i2 > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i2, timedValueQueue.getLength(), "end (", ") offset is outside of text region "));
            return;
        }
        if (i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "Do not set reversed range: ", " > "));
            return;
        }
        timedValueQueue.replace(i, i2, str);
        setSelectionStart(str.length() + i);
        setSelectionEnd(str.length() + i);
        this.size = -1;
        this.wrapAroundMask = -1;
    }

    public void setComposition$ui_text(int i, int i2) {
        TimedValueQueue timedValueQueue = (TimedValueQueue) this.data;
        if (i < 0 || i > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, timedValueQueue.getLength(), "start (", ") offset is outside of text region "));
            return;
        }
        if (i2 < 0 || i2 > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i2, timedValueQueue.getLength(), "end (", ") offset is outside of text region "));
        } else if (i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "Do not set reversed or empty range: ", " > "));
        } else {
            this.size = i;
            this.wrapAroundMask = i2;
        }
    }

    public void setSelection$ui_text(int i, int i2) {
        TimedValueQueue timedValueQueue = (TimedValueQueue) this.data;
        if (i < 0 || i > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, timedValueQueue.getLength(), "start (", ") offset is outside of text region "));
            return;
        }
        if (i2 < 0 || i2 > timedValueQueue.getLength()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i2, timedValueQueue.getLength(), "end (", ") offset is outside of text region "));
        } else if (i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "Do not set reversed range: ", " > "));
        } else {
            setSelectionStart(i);
            setSelectionEnd(i2);
        }
    }

    public void setSelectionEnd(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + i);
        }
        this.tailIndex = i;
    }

    public void setSelectionStart(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + i);
        }
        this.headIndex = i;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return ((TimedValueQueue) this.data).toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ LongArrayQueue() {
    }
}
