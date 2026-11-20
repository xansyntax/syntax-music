package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.provider.CallbackWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UndoManager {
    public boolean forceNextSnapshot;
    public Long lastSnapshot;
    public CallbackWrapper redoStack;
    public int storedCharacters;
    public CallbackWrapper undoStack;

    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    public final void makeSnapshot(TextFieldValue textFieldValue) {
        CallbackWrapper callbackWrapper;
        TextFieldValue textFieldValue2;
        this.forceNextSnapshot = false;
        CallbackWrapper callbackWrapper2 = this.undoStack;
        if (Intrinsics.areEqual(textFieldValue, callbackWrapper2 != null ? (TextFieldValue) callbackWrapper2.mExecutor : null)) {
            return;
        }
        String str = textFieldValue.annotatedString.text;
        CallbackWrapper callbackWrapper3 = this.undoStack;
        boolean zAreEqual = Intrinsics.areEqual(str, (callbackWrapper3 == null || (textFieldValue2 = (TextFieldValue) callbackWrapper3.mExecutor) == null) ? null : textFieldValue2.annotatedString.text);
        CallbackWrapper callbackWrapper4 = this.undoStack;
        if (zAreEqual) {
            if (callbackWrapper4 != null) {
                callbackWrapper4.mExecutor = textFieldValue;
                return;
            }
            return;
        }
        this.undoStack = new CallbackWrapper(callbackWrapper4, textFieldValue, (byte) 4);
        this.redoStack = null;
        int length = textFieldValue.annotatedString.text.length() + this.storedCharacters;
        this.storedCharacters = length;
        if (length > 100000) {
            CallbackWrapper callbackWrapper5 = this.undoStack;
            if ((callbackWrapper5 != null ? (CallbackWrapper) callbackWrapper5.mCallback : null) == null) {
                return;
            }
            while (true) {
                if (callbackWrapper5 == null) {
                    callbackWrapper = null;
                } else {
                    CallbackWrapper callbackWrapper6 = (CallbackWrapper) callbackWrapper5.mCallback;
                    if (callbackWrapper6 != null) {
                        callbackWrapper = (CallbackWrapper) callbackWrapper6.mCallback;
                    } else {
                        callbackWrapper = null;
                    }
                }
                if (callbackWrapper == null) {
                    break;
                } else {
                    callbackWrapper5 = (CallbackWrapper) callbackWrapper5.mCallback;
                }
            }
            if (callbackWrapper5 != null) {
                callbackWrapper5.mCallback = null;
            }
        }
    }
}
