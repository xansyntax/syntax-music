package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class NullableInputConnectionWrapperApi25 implements InputConnection {
    public androidx.compose.foundation.text.input.internal.RecordingInputConnection delegate;
    public final DiskLruCache$$ExternalSyntheticLambda0 onConnectionClosed;

    public NullableInputConnectionWrapperApi25(androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection, DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0) {
        this.onConnectionClosed = diskLruCache$$ExternalSyntheticLambda0;
        this.delegate = recordingInputConnection;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.beginBatchEdit();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.clearMetaKeyStates(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            if (recordingInputConnection != null) {
                recordingInputConnection.closeConnection();
                this.delegate = null;
            }
            this.onConnectionClosed.invoke(this);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.commitCompletion(completionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.commitContent(inputContentInfo, i, bundle);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.commitCorrection(correctionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.commitText(charSequence, i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.deleteSurroundingText(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.endBatchEditInternal();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.finishComposingText();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.getCursorCapsMode(i);
        }
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.getExtractedText(extractedTextRequest, i);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.getSelectedText(i);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.getTextAfterCursor(i, i2);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.getTextBeforeCursor(i, i2);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.performContextMenuAction(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.performEditorAction(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.performPrivateCommand(str, bundle);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.requestCursorUpdates(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.sendKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.setComposingRegion(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.setComposingText(charSequence, i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.setSelection(i, i2);
        }
        return false;
    }
}
