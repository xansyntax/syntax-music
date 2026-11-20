package androidx.compose.foundation.text.input.internal;

import android.view.View;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.material3.SliderState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import java.lang.ref.WeakReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidLegacyPlatformTextInputServiceAdapter implements PlatformTextInputService {
    public SharedFlowImpl backingStylusHandwritingTrigger;
    public LegacyTextInputMethodRequest currentRequest;
    public StandaloneCoroutine job;
    public LegacyAdaptingPlatformTextInputModifierNode textInputModifierNode;

    public final MutableSharedFlow getStylusHandwritingTrigger() {
        SharedFlowImpl sharedFlowImpl = this.backingStylusHandwritingTrigger;
        if (sharedFlowImpl != null) {
            return sharedFlowImpl;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported) {
            return null;
        }
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default = StateFlowKt.MutableSharedFlow$default(0, 2, BufferOverflow.DROP_LATEST);
        this.backingStylusHandwritingTrigger = sharedFlowImplMutableSharedFlow$default;
        return sharedFlowImplMutableSharedFlow$default;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void hideSoftwareKeyboard() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null || (softwareKeyboardController = (SoftwareKeyboardController) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalSoftwareKeyboardController)) == null) {
            return;
        }
        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void notifyFocusedRect(Rect rect) {
        android.graphics.Rect rect2;
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.focusedRect = new android.graphics.Rect(MathKt.roundToInt(rect.left), MathKt.roundToInt(rect.top), MathKt.roundToInt(rect.right), MathKt.roundToInt(rect.bottom));
            if (!legacyTextInputMethodRequest.ics.isEmpty() || (rect2 = legacyTextInputMethodRequest.focusedRect) == null) {
                return;
            }
            legacyTextInputMethodRequest.view.requestRectangleOnScreen(new android.graphics.Rect(rect2));
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void showSoftwareKeyboard() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null || (softwareKeyboardController = (SoftwareKeyboardController) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalSoftwareKeyboardController)) == null) {
            return;
        }
        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
    }

    public final void startInput(AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda40) {
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null) {
            return;
        }
        StandaloneCoroutine standaloneCoroutineLaunch$default = null;
        InnerTube$feedback$2 innerTube$feedback$2 = new InnerTube$feedback$2((Object) albumMenuKt$$ExternalSyntheticLambda40, (Object) this, (Object) legacyAdaptingPlatformTextInputModifierNode, (Continuation) standaloneCoroutineLaunch$default, (byte) 5);
        if (legacyAdaptingPlatformTextInputModifierNode.isAttached) {
            standaloneCoroutineLaunch$default = AwaitKt.launch$default(legacyAdaptingPlatformTextInputModifierNode.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SliderState.AnonymousClass2(legacyAdaptingPlatformTextInputModifierNode, innerTube$feedback$2, standaloneCoroutineLaunch$default, (byte) 12), 1);
        }
        this.job = standaloneCoroutineLaunch$default;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void stopInput() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.job = null;
        MutableSharedFlow stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            SharedFlowImpl sharedFlowImpl = (SharedFlowImpl) stylusHandwritingTrigger;
            synchronized (sharedFlowImpl) {
                sharedFlowImpl.updateBufferLocked(sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize), sharedFlowImpl.minCollectorIndex, sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize), sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize) + ((long) sharedFlowImpl.queueSize));
            }
        }
    }

    public final void unregisterModifier(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode) {
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode2 = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode2 != legacyAdaptingPlatformTextInputModifierNode) {
            InlineClassHelperKt.throwIllegalStateException("Expected textInputModifierNode to be " + legacyAdaptingPlatformTextInputModifierNode + " but was " + legacyAdaptingPlatformTextInputModifierNode2);
        }
        this.textInputModifierNode = null;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            boolean z = (TextRange.m740equalsimpl0(legacyTextInputMethodRequest.state.selection, textFieldValue2.selection) && Intrinsics.areEqual(legacyTextInputMethodRequest.state.composition, textFieldValue2.composition)) ? false : true;
            legacyTextInputMethodRequest.state = textFieldValue2;
            int size = legacyTextInputMethodRequest.ics.size();
            for (int i = 0; i < size; i++) {
                RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) legacyTextInputMethodRequest.ics.get(i)).get();
                if (recordingInputConnection != null) {
                    recordingInputConnection.textFieldValue = textFieldValue2;
                }
            }
            LegacyCursorAnchorInfoController legacyCursorAnchorInfoController = legacyTextInputMethodRequest.cursorAnchorInfoController;
            synchronized (legacyCursorAnchorInfoController.lock) {
                legacyCursorAnchorInfoController.textFieldValue = null;
                legacyCursorAnchorInfoController.offsetMapping = null;
                legacyCursorAnchorInfoController.textLayoutResult = null;
                legacyCursorAnchorInfoController.innerTextFieldBounds = null;
                legacyCursorAnchorInfoController.decorationBoxBounds = null;
            }
            if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
                if (z) {
                    WeakCache weakCache = legacyTextInputMethodRequest.inputMethodManager;
                    int iM744getMinimpl = TextRange.m744getMinimpl(textFieldValue2.selection);
                    int iM743getMaximpl = TextRange.m743getMaximpl(textFieldValue2.selection);
                    TextRange textRange = legacyTextInputMethodRequest.state.composition;
                    int iM744getMinimpl2 = textRange != null ? TextRange.m744getMinimpl(textRange.packedValue) : -1;
                    TextRange textRange2 = legacyTextInputMethodRequest.state.composition;
                    weakCache.getImm().updateSelection((View) weakCache.values, iM744getMinimpl, iM743getMaximpl, iM744getMinimpl2, textRange2 != null ? TextRange.m743getMaximpl(textRange2.packedValue) : -1);
                    return;
                }
                return;
            }
            if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.annotatedString.text, textFieldValue2.annotatedString.text) || (TextRange.m740equalsimpl0(textFieldValue.selection, textFieldValue2.selection) && !Intrinsics.areEqual(textFieldValue.composition, textFieldValue2.composition)))) {
                WeakCache weakCache2 = legacyTextInputMethodRequest.inputMethodManager;
                weakCache2.getImm().restartInput((View) weakCache2.values);
                return;
            }
            int size2 = legacyTextInputMethodRequest.ics.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) legacyTextInputMethodRequest.ics.get(i2)).get();
                if (recordingInputConnection2 != null) {
                    TextFieldValue textFieldValue3 = legacyTextInputMethodRequest.state;
                    WeakCache weakCache3 = legacyTextInputMethodRequest.inputMethodManager;
                    if (recordingInputConnection2.isActive) {
                        recordingInputConnection2.textFieldValue = textFieldValue3;
                        if (recordingInputConnection2.extractedTextMonitorMode) {
                            weakCache3.getImm().updateExtractedText((View) weakCache3.values, recordingInputConnection2.currentExtractedTextRequestToken, HandwritingGesture_androidKt.toExtractedText(textFieldValue3));
                        }
                        TextRange textRange3 = textFieldValue3.composition;
                        long j = textFieldValue3.selection;
                        int iM744getMinimpl3 = textRange3 != null ? TextRange.m744getMinimpl(textRange3.packedValue) : -1;
                        TextRange textRange4 = textFieldValue3.composition;
                        weakCache3.getImm().updateSelection((View) weakCache3.values, TextRange.m744getMinimpl(j), TextRange.m743getMaximpl(j), iM744getMinimpl3, textRange4 != null ? TextRange.m743getMaximpl(textRange4.packedValue) : -1);
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, CallsKt$await$2$1 callsKt$await$2$1, Rect rect, Rect rect2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            LegacyCursorAnchorInfoController legacyCursorAnchorInfoController = legacyTextInputMethodRequest.cursorAnchorInfoController;
            synchronized (legacyCursorAnchorInfoController.lock) {
                try {
                    legacyCursorAnchorInfoController.textFieldValue = textFieldValue;
                    legacyCursorAnchorInfoController.offsetMapping = offsetMapping;
                    legacyCursorAnchorInfoController.textLayoutResult = textLayoutResult;
                    legacyCursorAnchorInfoController.innerTextFieldBounds = rect;
                    legacyCursorAnchorInfoController.decorationBoxBounds = rect2;
                    if (legacyCursorAnchorInfoController.hasPendingImmediateRequest || legacyCursorAnchorInfoController.monitorEnabled) {
                        legacyCursorAnchorInfoController.updateCursorAnchorInfo();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0, CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1) {
        startInput(new AlbumMenuKt$$ExternalSyntheticLambda40((Object) textFieldValue, (Object) this, (Object) imeOptions, (Object) utilsKt$$ExternalSyntheticLambda0, (Object) coreTextFieldKt$$ExternalSyntheticLambda1, (byte) 4));
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput() {
        startInput(null);
    }
}
