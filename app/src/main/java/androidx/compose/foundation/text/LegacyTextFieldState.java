package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Dp;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.LongArrayQueue;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyTextFieldState {
    public LayoutCoordinates _layoutCoordinates;
    public final ParcelableSnapshotMutableState autofillHighlightOn$delegate;
    public final ParcelableSnapshotMutableState deletionPreviewHighlightRange$delegate;
    public final ParcelableSnapshotMutableState handleState$delegate;
    public final ParcelableSnapshotMutableState hasFocus$delegate;
    public final ParcelableSnapshotMutableState heightForSingleLineField$delegate;
    public final AndroidPaint highlightPaint;
    public TextInputSession inputSession;
    public final ParcelableSnapshotMutableState isInTouchMode$delegate;
    public boolean isLayoutResultStale;
    public final ParcelableSnapshotMutableState justAutofilled$delegate;
    public final KeyboardActionRunner keyboardActionRunner;
    public final SoftwareKeyboardController keyboardController;
    public final ParcelableSnapshotMutableState layoutResultState;
    public final CoreTextFieldKt$$ExternalSyntheticLambda1 onImeActionPerformed;
    public final CoreTextFieldKt$$ExternalSyntheticLambda1 onImeActionPerformedWithResult;
    public final CoreTextFieldKt$$ExternalSyntheticLambda1 onValueChange;
    public Function1 onValueChangeOriginal;
    public final CallbackWrapper processor;
    public final RecomposeScopeImpl recomposeScope;
    public long selectionBackgroundColor;
    public final ParcelableSnapshotMutableState selectionPreviewHighlightRange$delegate;
    public final ParcelableSnapshotMutableState showCursorHandle$delegate;
    public final ParcelableSnapshotMutableState showFloatingToolbar$delegate;
    public final ParcelableSnapshotMutableState showSelectionHandleEnd$delegate;
    public final ParcelableSnapshotMutableState showSelectionHandleStart$delegate;
    public TextDelegate textDelegate;
    public AnnotatedString untransformedText;

    public LegacyTextFieldState(TextDelegate textDelegate, RecomposeScopeImpl recomposeScopeImpl, SoftwareKeyboardController softwareKeyboardController) {
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScopeImpl;
        this.keyboardController = softwareKeyboardController;
        CallbackWrapper callbackWrapper = new CallbackWrapper((byte) 13, false);
        AnnotatedString annotatedString = AnnotatedStringKt.EmptyAnnotatedString;
        long j = TextRange.Zero;
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString, j, (TextRange) null);
        callbackWrapper.mCallback = textFieldValue;
        callbackWrapper.mExecutor = new LongArrayQueue(annotatedString, textFieldValue.selection);
        this.processor = callbackWrapper;
        Boolean bool = Boolean.FALSE;
        this.hasFocus$delegate = Stack.mutableStateOf$default(bool);
        this.heightForSingleLineField$delegate = Stack.mutableStateOf$default(new Dp(CropImageView.DEFAULT_ASPECT_RATIO));
        this.layoutResultState = Stack.mutableStateOf$default(null);
        this.handleState$delegate = Stack.mutableStateOf$default(HandleState.None);
        this.showFloatingToolbar$delegate = Stack.mutableStateOf$default(bool);
        this.showSelectionHandleStart$delegate = Stack.mutableStateOf$default(bool);
        this.showSelectionHandleEnd$delegate = Stack.mutableStateOf$default(bool);
        this.showCursorHandle$delegate = Stack.mutableStateOf$default(bool);
        this.isLayoutResultStale = true;
        this.isInTouchMode$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
        this.keyboardActionRunner = new KeyboardActionRunner(softwareKeyboardController);
        this.autofillHighlightOn$delegate = Stack.mutableStateOf$default(bool);
        this.justAutofilled$delegate = Stack.mutableStateOf$default(bool);
        this.onValueChangeOriginal = new OffsetKt$$ExternalSyntheticLambda0((byte) 28);
        this.onValueChange = new CoreTextFieldKt$$ExternalSyntheticLambda1(this, (byte) 1);
        this.onImeActionPerformed = new CoreTextFieldKt$$ExternalSyntheticLambda1(this, (byte) 2);
        this.onImeActionPerformedWithResult = new CoreTextFieldKt$$ExternalSyntheticLambda1(this, (byte) 3);
        this.highlightPaint = ColorKt.Paint();
        this.selectionBackgroundColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        this.selectionPreviewHighlightRange$delegate = Stack.mutableStateOf$default(new TextRange(j));
        this.deletionPreviewHighlightRange$delegate = Stack.mutableStateOf$default(new TextRange(j));
    }

    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this._layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached$1()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy) this.layoutResultState.getValue();
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m198setDeletionPreviewHighlightRange5zctL8(long j) {
        this.deletionPreviewHighlightRange$delegate.setValue(new TextRange(j));
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m199setSelectionPreviewHighlightRange5zctL8(long j) {
        this.selectionPreviewHighlightRange$delegate.setValue(new TextRange(j));
    }
}
