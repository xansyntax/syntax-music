package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda1;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import coil3.util.UtilsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    public final Lazy baseInputConnection$delegate;
    public final CursorAnchorInfoController cursorAnchorInfoController;
    public boolean editorHasFocus;
    public Rect focusedRect;
    public ActivityCompat$$ExternalSyntheticLambda0 frameCallback;
    public final ArrayList ics;
    public ImeOptions imeOptions;
    public final MediaControllerHolder$$ExternalSyntheticLambda1 inputCommandProcessorExecutor;
    public final EmojiProcessor inputMethodManager;
    public Function1 onEditCommand;
    public Function1 onImeActionPerformed;
    public TextFieldValue state;
    public final MutableVector textInputCommandQueue;
    public final View view;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextInputCommand {
        public static final /* synthetic */ TextInputCommand[] $VALUES;
        public static final TextInputCommand HideKeyboard;
        public static final TextInputCommand ShowKeyboard;
        public static final TextInputCommand StartInput;
        public static final TextInputCommand StopInput;

        static {
            TextInputCommand textInputCommand = new TextInputCommand("StartInput", 0);
            StartInput = textInputCommand;
            TextInputCommand textInputCommand2 = new TextInputCommand("StopInput", 1);
            StopInput = textInputCommand2;
            TextInputCommand textInputCommand3 = new TextInputCommand("ShowKeyboard", 2);
            ShowKeyboard = textInputCommand3;
            TextInputCommand textInputCommand4 = new TextInputCommand("HideKeyboard", 3);
            HideKeyboard = textInputCommand4;
            $VALUES = new TextInputCommand[]{textInputCommand, textInputCommand2, textInputCommand3, textInputCommand4};
        }

        public static TextInputCommand valueOf(String str) {
            return (TextInputCommand) Enum.valueOf(TextInputCommand.class, str);
        }

        public static TextInputCommand[] values() {
            return (TextInputCommand[]) $VALUES.clone();
        }
    }

    public TextInputServiceAndroid(View view, AndroidComposeView androidComposeView, MediaControllerHolder$$ExternalSyntheticLambda1 mediaControllerHolder$$ExternalSyntheticLambda1) {
        EmojiProcessor emojiProcessor = new EmojiProcessor(view);
        this.view = view;
        this.inputMethodManager = emojiProcessor;
        this.inputCommandProcessorExecutor = mediaControllerHolder$$ExternalSyntheticLambda1;
        this.onEditCommand = new SaversKt$$ExternalSyntheticLambda6((byte) 18);
        this.onImeActionPerformed = new SaversKt$$ExternalSyntheticLambda6((byte) 19);
        this.state = new TextFieldValue(4, TextRange.Zero, "");
        this.imeOptions = ImeOptions.Default;
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = ResultKt.lazy(LazyThreadSafetyMode.NONE, new RoomDatabase$$ExternalSyntheticLambda0((byte) 19, this));
        this.cursorAnchorInfoController = new CursorAnchorInfoController(androidComposeView, emojiProcessor);
        this.textInputCommandQueue = new MutableVector(new TextInputCommand[16]);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.left), MathKt.roundToInt(rect.top), MathKt.roundToInt(rect.right), MathKt.roundToInt(rect.bottom));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    public final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda0 = new ActivityCompat$$ExternalSyntheticLambda0((byte) 8, this);
            this.inputCommandProcessorExecutor.execute(activityCompat$$ExternalSyntheticLambda0);
            this.frameCallback = activityCompat$$ExternalSyntheticLambda0;
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0, CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1) {
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions;
        this.onEditCommand = utilsKt$$ExternalSyntheticLambda0;
        this.onImeActionPerformed = coreTextFieldKt$$ExternalSyntheticLambda1;
        sendInputCommand(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = new SaversKt$$ExternalSyntheticLambda6((byte) 16);
        this.onImeActionPerformed = new SaversKt$$ExternalSyntheticLambda6((byte) 17);
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z = (TextRange.m740equalsimpl0(this.state.selection, textFieldValue2.selection) && Intrinsics.areEqual(this.state.composition, textFieldValue2.composition)) ? false : true;
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) this.ics.get(i)).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.mTextFieldValue = textFieldValue2;
            }
        }
        CursorAnchorInfoController cursorAnchorInfoController = this.cursorAnchorInfoController;
        synchronized (cursorAnchorInfoController.lock) {
            cursorAnchorInfoController.textFieldValue = null;
            cursorAnchorInfoController.offsetMapping = null;
            cursorAnchorInfoController.textLayoutResult = null;
            cursorAnchorInfoController.textFieldToRootTransform = CursorAnchorInfoController$invalidate$1$1.INSTANCE;
            cursorAnchorInfoController.innerTextFieldBounds = null;
            cursorAnchorInfoController.decorationBoxBounds = null;
        }
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z) {
                EmojiProcessor emojiProcessor = this.inputMethodManager;
                int iM744getMinimpl = TextRange.m744getMinimpl(textFieldValue2.selection);
                int iM743getMaximpl = TextRange.m743getMaximpl(textFieldValue2.selection);
                TextRange textRange = this.state.composition;
                int iM744getMinimpl2 = textRange != null ? TextRange.m744getMinimpl(textRange.packedValue) : -1;
                TextRange textRange2 = this.state.composition;
                ((InputMethodManager) ((Lazy) emojiProcessor.mMetadataRepo).getValue()).updateSelection((View) emojiProcessor.mSpanFactory, iM744getMinimpl, iM743getMaximpl, iM744getMinimpl2, textRange2 != null ? TextRange.m743getMaximpl(textRange2.packedValue) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.annotatedString.text, textFieldValue2.annotatedString.text) || (TextRange.m740equalsimpl0(textFieldValue.selection, textFieldValue2.selection) && !Intrinsics.areEqual(textFieldValue.composition, textFieldValue2.composition)))) {
            EmojiProcessor emojiProcessor2 = this.inputMethodManager;
            ((InputMethodManager) ((Lazy) emojiProcessor2.mMetadataRepo).getValue()).restartInput((View) emojiProcessor2.mSpanFactory);
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) this.ics.get(i2)).get();
            if (recordingInputConnection2 != null) {
                TextFieldValue textFieldValue3 = this.state;
                EmojiProcessor emojiProcessor3 = this.inputMethodManager;
                if (recordingInputConnection2.isActive) {
                    recordingInputConnection2.mTextFieldValue = textFieldValue3;
                    if (recordingInputConnection2.extractedTextMonitorMode) {
                        ((InputMethodManager) ((Lazy) emojiProcessor3.mMetadataRepo).getValue()).updateExtractedText((View) emojiProcessor3.mSpanFactory, recordingInputConnection2.currentExtractedTextRequestToken, UtilsKt.toExtractedText(textFieldValue3));
                    }
                    TextRange textRange3 = textFieldValue3.composition;
                    long j = textFieldValue3.selection;
                    int iM744getMinimpl3 = textRange3 != null ? TextRange.m744getMinimpl(textRange3.packedValue) : -1;
                    TextRange textRange4 = textFieldValue3.composition;
                    ((InputMethodManager) ((Lazy) emojiProcessor3.mMetadataRepo).getValue()).updateSelection((View) emojiProcessor3.mSpanFactory, TextRange.m744getMinimpl(j), TextRange.m743getMaximpl(j), iM744getMinimpl3, textRange4 != null ? TextRange.m743getMaximpl(textRange4.packedValue) : -1);
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, CallsKt$await$2$1 callsKt$await$2$1, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        CursorAnchorInfoController cursorAnchorInfoController = this.cursorAnchorInfoController;
        synchronized (cursorAnchorInfoController.lock) {
            try {
                cursorAnchorInfoController.textFieldValue = textFieldValue;
                cursorAnchorInfoController.offsetMapping = offsetMapping;
                cursorAnchorInfoController.textLayoutResult = textLayoutResult;
                cursorAnchorInfoController.textFieldToRootTransform = callsKt$await$2$1;
                cursorAnchorInfoController.innerTextFieldBounds = rect;
                cursorAnchorInfoController.decorationBoxBounds = rect2;
                if (cursorAnchorInfoController.hasPendingImmediateRequest || cursorAnchorInfoController.monitorEnabled) {
                    cursorAnchorInfoController.updateCursorAnchorInfo();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput() {
        sendInputCommand(TextInputCommand.StartInput);
    }
}
