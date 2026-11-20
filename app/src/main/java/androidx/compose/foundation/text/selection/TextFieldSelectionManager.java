package androidx.compose.foundation.text.selection;

import android.content.ClipDescription;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarHandlerState;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidClipboardImpl;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.session.MediaSessionImpl$1;
import coil3.compose.AsyncImagePainter;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$MetrolistApp$5$1;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public Clipboard clipboard;
    public CoroutineScope coroutineScope;
    public final ParcelableSnapshotMutableState currentDragPosition$delegate;
    public long dragBeginPosition;
    public TextRange dragBeginSelection;
    public long dragTotalDistance;
    public final ParcelableSnapshotMutableState draggingHandle$delegate;
    public final ParcelableSnapshotMutableState editable$delegate;
    public final ParcelableSnapshotMutableState enabled$delegate;
    public FocusRequester focusRequester;
    public HapticFeedback hapticFeedBack;
    public final ParcelableSnapshotMutableState hasAvailableTextToPaste$delegate;
    public TextRange latestSelection;
    public final MediaSessionImpl$1 mouseSelectionObserver;
    public TextFieldValue oldValue;
    public PlatformSelectionBehaviors platformSelectionBehaviors;
    public int previousRawDragOffset;
    public MediaSessionImpl$1 previousSelectionLayout;
    public Function0 requestAutofillAction;
    public LegacyTextFieldState state;
    public boolean textToolbarShownViaProvider;
    public final WeakCache toolbarRequester;
    public final TextFieldSelectionManager$touchSelectionObserver$1 touchSelectionObserver;
    public final UndoManager undoManager;
    public OffsetMapping offsetMapping = ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity;
    public Function1 onValueChange = new ChipKt$$ExternalSyntheticLambda3(16);
    public final ParcelableSnapshotMutableState valueState = Stack.mutableStateOf$default(new TextFieldValue(7, 0, (String) null));
    public VisualTransformation visualTransformation = VisualTransformation.Companion.None;

    /* JADX WARN: Type inference failed for: r6v15, types: [androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1] */
    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        Boolean bool = Boolean.TRUE;
        this.editable$delegate = Stack.mutableStateOf$default(bool);
        this.enabled$delegate = Stack.mutableStateOf$default(bool);
        this.dragBeginPosition = 0L;
        this.dragTotalDistance = 0L;
        this.draggingHandle$delegate = Stack.mutableStateOf$default(null);
        this.currentDragPosition$delegate = Stack.mutableStateOf$default(null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue(7, 0L, (String) null);
        this.hasAvailableTextToPaste$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        WeakCache weakCache = new WeakCache((byte) 5, false);
        weakCache.referenceQueue = ToolbarHandlerState.Uninitialized;
        this.toolbarRequester = weakCache;
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            public TextRange runningSelection;
            public boolean isLongPressSelectionOnly = true;
            public MarqueeSpacing$Companion$$ExternalSyntheticLambda0 selectionAdjustmentMode = SelectionAdjustment$Companion.None;

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onCancel() {
                onEnd();
            }

            /* JADX WARN: Code duplicated, block: B:21:0x0094  */
            /* JADX WARN: Code duplicated, block: B:23:0x0098  */
            /* JADX WARN: Code duplicated, block: B:24:0x009f  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public final void mo201onDragk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                TextRange textRange;
                int iM204getOffsetForPosition3MmeM6k;
                long jM236updateSelectionjSglsI8;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0) {
                    return;
                }
                textFieldSelectionManager.dragTotalDistance = Offset.m439plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                    textFieldSelectionManager.m235setCurrentDragPosition_kEHs6E(new Offset(Offset.m439plusMKHz9U(textFieldSelectionManager.dragBeginPosition, textFieldSelectionManager.dragTotalDistance)));
                    if (textFieldSelectionManager.dragBeginSelection == null) {
                        Offset offsetM232getCurrentDragPosition_m7T9E = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                        offsetM232getCurrentDragPosition_m7T9E.getClass();
                        if (layoutResult.m205isPositionOnTextk4lQ0M(offsetM232getCurrentDragPosition_m7T9E.packedValue)) {
                            textRange = textFieldSelectionManager.dragBeginSelection;
                            if (textRange != null) {
                                iM204getOffsetForPosition3MmeM6k = (int) (textRange.packedValue >> 32);
                            } else {
                                iM204getOffsetForPosition3MmeM6k = layoutResult.m204getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                            }
                            Offset offsetM232getCurrentDragPosition_m7T9E2 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                            offsetM232getCurrentDragPosition_m7T9E2.getClass();
                            int iM204getOffsetForPosition3MmeM6k2 = layoutResult.m204getOffsetForPosition3MmeM6k(offsetM232getCurrentDragPosition_m7T9E2.packedValue, false);
                            if (textFieldSelectionManager.dragBeginSelection != null && iM204getOffsetForPosition3MmeM6k == iM204getOffsetForPosition3MmeM6k2) {
                                return;
                            }
                            TextFieldValue value$foundation = textFieldSelectionManager.getValue$foundation();
                            Offset offsetM232getCurrentDragPosition_m7T9E3 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                            offsetM232getCurrentDragPosition_m7T9E3.getClass();
                            jM236updateSelectionjSglsI8 = textFieldSelectionManager.m236updateSelectionjSglsI8(value$foundation, offsetM232getCurrentDragPosition_m7T9E3.packedValue, false, false, this.selectionAdjustmentMode, true, new HapticFeedbackType(9));
                        } else {
                            int iTransformedToOriginal = textFieldSelectionManager.offsetMapping.transformedToOriginal(layoutResult.m204getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, true));
                            OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                            Offset offsetM232getCurrentDragPosition_m7T9E4 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                            offsetM232getCurrentDragPosition_m7T9E4.getClass();
                            MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0 = iTransformedToOriginal == offsetMapping.transformedToOriginal(layoutResult.m204getOffsetForPosition3MmeM6k(offsetM232getCurrentDragPosition_m7T9E4.packedValue, true)) ? SelectionAdjustment$Companion.None : SelectionAdjustment$Companion.Word;
                            TextFieldValue value$foundation2 = textFieldSelectionManager.getValue$foundation();
                            Offset offsetM232getCurrentDragPosition_m7T9E5 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                            offsetM232getCurrentDragPosition_m7T9E5.getClass();
                            jM236updateSelectionjSglsI8 = textFieldSelectionManager.m236updateSelectionjSglsI8(value$foundation2, offsetM232getCurrentDragPosition_m7T9E5.packedValue, false, false, marqueeSpacing$Companion$$ExternalSyntheticLambda0, true, new HapticFeedbackType(9));
                        }
                    } else {
                        textRange = textFieldSelectionManager.dragBeginSelection;
                        if (textRange != null) {
                            iM204getOffsetForPosition3MmeM6k = (int) (textRange.packedValue >> 32);
                        } else {
                            iM204getOffsetForPosition3MmeM6k = layoutResult.m204getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                        }
                        Offset offsetM232getCurrentDragPosition_m7T9E6 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                        offsetM232getCurrentDragPosition_m7T9E6.getClass();
                        int iM204getOffsetForPosition3MmeM6k3 = layoutResult.m204getOffsetForPosition3MmeM6k(offsetM232getCurrentDragPosition_m7T9E6.packedValue, false);
                        if (textFieldSelectionManager.dragBeginSelection != null) {
                        }
                        TextFieldValue value$foundation3 = textFieldSelectionManager.getValue$foundation();
                        Offset offsetM232getCurrentDragPosition_m7T9E7 = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                        offsetM232getCurrentDragPosition_m7T9E7.getClass();
                        jM236updateSelectionjSglsI8 = textFieldSelectionManager.m236updateSelectionjSglsI8(value$foundation3, offsetM232getCurrentDragPosition_m7T9E7.packedValue, false, false, this.selectionAdjustmentMode, true, new HapticFeedbackType(9));
                    }
                    this.runningSelection = new TextRange(jM236updateSelectionjSglsI8);
                    if (!TextRange.m739equalsimpl(jM236updateSelectionjSglsI8, textFieldSelectionManager.dragBeginSelection)) {
                        this.isLongPressSelectionOnly = false;
                    }
                }
                textFieldSelectionManager.updateFloatingToolbar(false);
            }

            public final void onEnd() {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.setDraggingHandle(null);
                textFieldSelectionManager.m235setCurrentDragPosition_kEHs6E(null);
                this.selectionAdjustmentMode = SelectionAdjustment$Companion.None;
                textFieldSelectionManager.updateFloatingToolbar(true);
                TextRange textRange = this.runningSelection;
                boolean zM741getCollapsedimpl = TextRange.m741getCollapsedimpl(textRange != null ? textRange.packedValue : textFieldSelectionManager.getValue$foundation().selection);
                textFieldSelectionManager.setHandleState(zM741getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState != null) {
                    legacyTextFieldState.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(!zM741getCollapsedimpl && MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, true)));
                }
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                if (legacyTextFieldState2 != null) {
                    legacyTextFieldState2.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(!zM741getCollapsedimpl && MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, false)));
                }
                LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                if (legacyTextFieldState3 != null) {
                    legacyTextFieldState3.showCursorHandle$delegate.setValue(Boolean.valueOf(zM741getCollapsedimpl && MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, true)));
                }
                if (this.isLongPressSelectionOnly) {
                    textFieldSelectionManager.m234maybeSuggestSelectionOEnZFl4(textFieldSelectionManager.dragBeginSelection);
                }
                textFieldSelectionManager.dragBeginSelection = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public final void mo202onStart3MmeM6k(long j, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                if (textFieldSelectionManager.getEnabled() && ((Handle) textFieldSelectionManager.draggingHandle$delegate.getValue()) == null) {
                    textFieldSelectionManager.setDraggingHandle(Handle.SelectionEnd);
                    textFieldSelectionManager.previousRawDragOffset = -1;
                    this.isLongPressSelectionOnly = true;
                    this.selectionAdjustmentMode = marqueeSpacing$Companion$$ExternalSyntheticLambda0;
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                    LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                    if (legacyTextFieldState == null || (layoutResult2 = legacyTextFieldState.getLayoutResult()) == null || !layoutResult2.m205isPositionOnTextk4lQ0M(j)) {
                        j2 = j;
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        if (legacyTextFieldState2 != null && (layoutResult = legacyTextFieldState2.getLayoutResult()) != null) {
                            int iTransformedToOriginal = textFieldSelectionManager.offsetMapping.transformedToOriginal(layoutResult.m204getOffsetForPosition3MmeM6k(j2, true));
                            TextFieldValue textFieldValueM230createTextFieldValueFDrldGo = TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation(false);
                            HapticFeedback hapticFeedback = textFieldSelectionManager.hapticFeedBack;
                            if (hapticFeedback != null) {
                                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                            }
                            textFieldSelectionManager.onValueChange.invoke(textFieldValueM230createTextFieldValueFDrldGo);
                            textFieldSelectionManager.latestSelection = new TextRange(textFieldValueM230createTextFieldValueFDrldGo.selection);
                        }
                        this.isLongPressSelectionOnly = false;
                    } else {
                        if (textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0) {
                            return;
                        }
                        textFieldSelectionManager.enterSelectionMode$foundation(false);
                        long jM236updateSelectionjSglsI8 = textFieldSelectionManager.m236updateSelectionjSglsI8(TextFieldValue.m762copy3r_uNRQ$default(textFieldSelectionManager.getValue$foundation(), null, TextRange.Zero, 5), j, true, false, this.selectionAdjustmentMode, true, new HapticFeedbackType(0));
                        j2 = j;
                        textFieldSelectionManager.dragBeginSelection = new TextRange(jM236updateSelectionjSglsI8);
                        this.runningSelection = new TextRange(jM236updateSelectionjSglsI8);
                    }
                    textFieldSelectionManager.setHandleState(HandleState.None);
                    textFieldSelectionManager.dragBeginPosition = j2;
                    textFieldSelectionManager.m235setCurrentDragPosition_kEHs6E(new Offset(j2));
                    textFieldSelectionManager.dragTotalDistance = 0L;
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public final void mo200onDownk4lQ0M() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onUp() {
            }
        };
        this.mouseSelectionObserver = new MediaSessionImpl$1(this);
    }

    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public static TextFieldValue m230createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null);
    }

    public final StandaloneCoroutine copy$foundation(boolean z) {
        CoroutineScope coroutineScope = this.coroutineScope;
        Continuation continuation = null;
        if (coroutineScope == null) {
            return null;
        }
        return AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new Updater$checkForUpdate$2((Object) this, z, continuation, (byte) 1), 1);
    }

    public final void cut$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new SyncUtils.AnonymousClass2(this, null, (byte) 9), 1);
        }
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation, reason: not valid java name */
    public final void m231deselect_kEHs6E$foundation(Offset offset) {
        if (!TextRange.m741getCollapsedimpl(getValue$foundation().selection)) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            int iM743getMaximpl = (offset == null || layoutResult == null) ? TextRange.m743getMaximpl(getValue$foundation().selection) : this.offsetMapping.transformedToOriginal(layoutResult.m204getOffsetForPosition3MmeM6k(offset.packedValue, true));
            TextFieldValue textFieldValueM762copy3r_uNRQ$default = TextFieldValue.m762copy3r_uNRQ$default(getValue$foundation(), null, TextRangeKt.TextRange(iM743getMaximpl, iM743getMaximpl), 5);
            this.onValueChange.invoke(textFieldValueM762copy3r_uNRQ$default);
            this.latestSelection = new TextRange(textFieldValueM762copy3r_uNRQ$default.selection);
        }
        setHandleState((offset == null || getValue$foundation().annotatedString.text.length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    public final void enterSelectionMode$foundation(boolean z) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
        }
        this.oldValue = getValue$foundation();
        updateFloatingToolbar(z);
        setHandleState(HandleState.Selection);
    }

    public final Pair getContextTextAndSelection() {
        String str;
        TextRange textRange;
        AnnotatedString transformedText$foundation = getTransformedText$foundation();
        if (transformedText$foundation == null || (str = transformedText$foundation.text) == null || (textRange = this.latestSelection) == null) {
            return null;
        }
        long j = textRange.packedValue;
        return new Pair(str, new TextRange(TextRangeKt.TextRange(this.offsetMapping.originalToTransformed((int) (j >> 32)), this.offsetMapping.originalToTransformed((int) (j & 4294967295L)))));
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m232getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation, reason: not valid java name */
    public final long m233getHandlePositiontuRUvjQ$foundation(boolean z) {
        TextLayoutResultProxy layoutResult;
        long j;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return 9205357640488583168L;
        }
        TextLayoutResult textLayoutResult = layoutResult.value;
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        AnnotatedString transformedText$foundation = getTransformedText$foundation();
        if (transformedText$foundation == null) {
            return 9205357640488583168L;
        }
        if (!Intrinsics.areEqual(transformedText$foundation.text, textLayoutResult.layoutInput.text.text)) {
            return 9205357640488583168L;
        }
        TextFieldValue value$foundation = getValue$foundation();
        if (z) {
            long j2 = value$foundation.selection;
            int i = TextRange.$r8$clinit;
            j = j2 >> 32;
        } else {
            long j3 = value$foundation.selection;
            int i2 = TextRange.$r8$clinit;
            j = j3 & 4294967295L;
        }
        int iOriginalToTransformed = this.offsetMapping.originalToTransformed((int) j);
        boolean zM745getReversedimpl = TextRange.m745getReversedimpl(getValue$foundation().selection);
        long j4 = textLayoutResult.size;
        int lineForOffset = multiParagraph.getLineForOffset(iOriginalToTransformed);
        if (lineForOffset >= multiParagraph.lineCount) {
            return 9205357640488583168L;
        }
        boolean z2 = textLayoutResult.getBidiRunDirection(((!z || zM745getReversedimpl) && (z || !zM745getReversedimpl)) ? Math.max(iOriginalToTransformed + (-1), 0) : iOriginalToTransformed) == textLayoutResult.getParagraphDirection(iOriginalToTransformed);
        multiParagraph.requireIndexInRangeInclusiveEnd(iOriginalToTransformed);
        int length = ((AnnotatedString) multiParagraph.intrinsics.application).text.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iOriginalToTransformed == length ? arrayList.size() - 1 : TextRangeKt.findParagraphByIndex(iOriginalToTransformed, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(iOriginalToTransformed);
        TextLayout textLayout = androidParagraph.layout;
        return (((long) Float.floatToRawIntBits(UuidKt.coerceIn(multiParagraph.getLineBottom(lineForOffset), CropImageView.DEFAULT_ASPECT_RATIO, (int) (j4 & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(UuidKt.coerceIn(z2 ? textLayout.getPrimaryHorizontal(localIndex, false) : textLayout.getSecondaryHorizontal(localIndex, false), CropImageView.DEFAULT_ASPECT_RATIO, (int) (j4 >> 32)))) << 32);
    }

    public final AnnotatedString getTransformedText$foundation() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            return (AnnotatedString) legacyTextFieldState.textDelegate.text;
        }
        return null;
    }

    public final TextFieldValue getValue$foundation() {
        return (TextFieldValue) this.valueState.getValue();
    }

    public final void hideSelectionToolbar$foundation() {
        StandaloneCoroutine standaloneCoroutine;
        TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) this.toolbarRequester.values;
        if (textContextMenuToolbarHandlerNode == null || (standaloneCoroutine = textContextMenuToolbarHandlerNode.textToolbarJob) == null) {
            return;
        }
        standaloneCoroutine.cancel(null);
        textContextMenuToolbarHandlerNode.textToolbarJob = null;
    }

    /* JADX INFO: renamed from: maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    public final void m234maybeSuggestSelectionOEnZFl4(TextRange textRange) {
        AnnotatedString transformedText$foundation;
        String str;
        CoroutineScope coroutineScope;
        if (textRange == null) {
            return;
        }
        long j = textRange.packedValue;
        PlatformSelectionBehaviors platformSelectionBehaviors = this.platformSelectionBehaviors;
        if (platformSelectionBehaviors == null || (transformedText$foundation = getTransformedText$foundation()) == null || (str = transformedText$foundation.text) == null) {
            return;
        }
        OffsetMapping offsetMapping = this.offsetMapping;
        long jTextRange = TextRangeKt.TextRange(offsetMapping.originalToTransformed((int) (j >> 32)), offsetMapping.originalToTransformed((int) (j & 4294967295L)));
        if (str.length() <= 0 || TextRange.m741getCollapsedimpl(jTextRange) || (coroutineScope = this.coroutineScope) == null) {
            return;
        }
        AwaitKt.launch$default(coroutineScope, null, null, new MainActivity$MetrolistApp$5$1(platformSelectionBehaviors, str, jTextRange, textRange, this, offsetMapping, (Continuation) null), 3);
    }

    public final void paste$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null, (byte) 0), 1);
        }
    }

    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m235setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.handleState$delegate.setValue(handleState);
            }
        }
    }

    public final void showSelectionToolbar$foundation() {
        LegacyTextFieldState legacyTextFieldState;
        TextContextMenuProvider textContextMenuProvider;
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Continuation continuation = null;
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (!getEnabled() || ((legacyTextFieldState = this.state) != null && !((Boolean) legacyTextFieldState.isInTouchMode$delegate.getValue()).booleanValue())) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                return;
            }
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            WeakCache weakCache = this.toolbarRequester;
            if (((ToolbarHandlerState) weakCache.referenceQueue) == ToolbarHandlerState.Uninitialized) {
                InlineClassHelperKt.throwIllegalStateException("ToolbarRequester is not initialized.");
            }
            TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) weakCache.values;
            if (textContextMenuToolbarHandlerNode == null || !textContextMenuToolbarHandlerNode.isAttached) {
                return;
            }
            StandaloneCoroutine standaloneCoroutine = textContextMenuToolbarHandlerNode.textToolbarJob;
            if ((standaloneCoroutine == null || !standaloneCoroutine.isActive()) && (textContextMenuProvider = (TextContextMenuProvider) HitTestResultKt.currentValueOf(textContextMenuToolbarHandlerNode, TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider)) != null) {
                textContextMenuToolbarHandlerNode.textToolbarJob = AwaitKt.launch$default(textContextMenuToolbarHandlerNode.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(textContextMenuToolbarHandlerNode, textContextMenuProvider, continuation, (byte) 4), 1);
            }
        } catch (Throwable th) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateClipboardEntry$foundation(ContinuationImpl continuationImpl) {
        TextFieldSelectionManager$updateClipboardEntry$1 textFieldSelectionManager$updateClipboardEntry$1;
        if (continuationImpl instanceof TextFieldSelectionManager$updateClipboardEntry$1) {
            textFieldSelectionManager$updateClipboardEntry$1 = (TextFieldSelectionManager$updateClipboardEntry$1) continuationImpl;
            int i = textFieldSelectionManager$updateClipboardEntry$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$updateClipboardEntry$1.label = i - Integer.MIN_VALUE;
            } else {
                textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuationImpl);
            }
        } else {
            textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuationImpl);
        }
        Object objValueOf = textFieldSelectionManager$updateClipboardEntry$1.result;
        int i2 = textFieldSelectionManager$updateClipboardEntry$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objValueOf);
            Clipboard clipboard = this.clipboard;
            if (clipboard != null) {
                textFieldSelectionManager$updateClipboardEntry$1.L$0 = this;
                textFieldSelectionManager$updateClipboardEntry$1.label = 1;
                if (!(clipboard instanceof AndroidClipboardImpl)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Extracting native reference is only supported from androidx.compose.ui.platform.AndroidClipboard instances but received ", Reflection.getOrCreateKotlinClass(clipboard.getClass()).getQualifiedName()));
                    return null;
                }
                ClipDescription primaryClipDescription = ((AndroidClipboardImpl) clipboard).androidClipboardManager.getClipboardManager().getPrimaryClipDescription();
                objValueOf = Boolean.valueOf(primaryClipDescription == null ? false : primaryClipDescription.hasMimeType("text/*"));
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objValueOf == obj) {
                    return obj;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = textFieldSelectionManager$updateClipboardEntry$1.L$0;
        ResultKt.throwOnFailure(objValueOf);
        Boolean bool = (Boolean) objValueOf;
        bool.getClass();
        this.hasAvailableTextToPaste$delegate.setValue(bool);
        return Unit.INSTANCE;
    }

    public final void updateFloatingToolbar(boolean z) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.showFloatingToolbar$delegate.setValue(Boolean.valueOf(z));
        }
        if (z) {
            showSelectionToolbar$foundation();
        } else {
            hideSelectionToolbar$foundation();
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0156  */
    /* JADX INFO: renamed from: updateSelection-jSglsI8, reason: not valid java name */
    public final long m236updateSelectionjSglsI8(TextFieldValue textFieldValue, long j, boolean z, boolean z2, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0, boolean z3, HapticFeedbackType hapticFeedbackType) {
        TextLayoutResultProxy layoutResult;
        long j2;
        int i;
        long j3;
        Selection selection;
        Selection selection2;
        boolean z4;
        HapticFeedback hapticFeedback;
        Selection.AnchorInfo anchorInfoUpdateSelectionBoundary;
        Selection.AnchorInfo anchorInfo;
        Selection.AnchorInfo anchorInfo2;
        Selection selection3;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Zero;
        }
        OffsetMapping offsetMapping = this.offsetMapping;
        long j4 = textFieldValue.selection;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        int i2 = TextRange.$r8$clinit;
        long jTextRange = TextRangeKt.TextRange(offsetMapping.originalToTransformed((int) (j4 >> 32)), this.offsetMapping.originalToTransformed((int) (j4 & 4294967295L)));
        int iM204getOffsetForPosition3MmeM6k = layoutResult.m204getOffsetForPosition3MmeM6k(j, false);
        int i3 = (z2 || z) ? iM204getOffsetForPosition3MmeM6k : (int) (jTextRange >> 32);
        if (!z2 || z) {
            j2 = 4294967295L;
            i = iM204getOffsetForPosition3MmeM6k;
        } else {
            j2 = 4294967295L;
            i = (int) (jTextRange & 4294967295L);
        }
        MediaSessionImpl$1 mediaSessionImpl$1 = this.previousSelectionLayout;
        int i4 = -1;
        if (z || mediaSessionImpl$1 == null) {
            j3 = j2;
        } else {
            j3 = j2;
            int i5 = this.previousRawDragOffset;
            if (i5 != -1) {
                i4 = i5;
            }
        }
        TextLayoutResult textLayoutResult = layoutResult.value;
        if (z) {
            selection = null;
        } else {
            int i6 = (int) (jTextRange >> 32);
            int i7 = (int) (jTextRange & j3);
            selection = new Selection(new Selection.AnchorInfo(DatabaseDao_Impl.AnonymousClass17.getTextDirectionForOffset(textLayoutResult, i6), i6, 1L), new Selection.AnchorInfo(DatabaseDao_Impl.AnonymousClass17.getTextDirectionForOffset(textLayoutResult, i7), i7, 1L), TextRange.m745getReversedimpl(jTextRange));
        }
        MediaSessionImpl$1 mediaSessionImpl$2 = new MediaSessionImpl$1(z2, selection, new GapBuffer(i3, i, i4, textLayoutResult));
        if (selection != null && mediaSessionImpl$1 != null && z2 == mediaSessionImpl$1.val$callOnPlayerInteractionFinished) {
            GapBuffer gapBuffer = (GapBuffer) mediaSessionImpl$1.this$0;
            if (i3 == gapBuffer.capacity && i == gapBuffer.gapStart) {
                return j4;
            }
        }
        this.previousSelectionLayout = mediaSessionImpl$2;
        this.previousRawDragOffset = iM204getOffsetForPosition3MmeM6k;
        byte b = marqueeSpacing$Companion$$ExternalSyntheticLambda0.$r8$classId;
        CrossStatus crossStatus = CrossStatus.CROSSED;
        Object obj = mediaSessionImpl$2.this$0;
        switch (b) {
            case 6:
                GapBuffer gapBuffer2 = (GapBuffer) obj;
                selection2 = new Selection(gapBuffer2.anchorForOffset(gapBuffer2.capacity), gapBuffer2.anchorForOffset(gapBuffer2.gapStart), mediaSessionImpl$2.getCrossStatus() == crossStatus);
                break;
            case 7:
                selection2 = UtilsKt.adjustToBoundaries(mediaSessionImpl$2, SelectionAdjustment$Companion.INSTANCE$1);
                break;
            case 8:
                selection2 = UtilsKt.adjustToBoundaries(mediaSessionImpl$2, SelectionAdjustment$Companion.INSTANCE);
                break;
            default:
                selection2 = (Selection) mediaSessionImpl$2.val$controllerForRequest;
                GapBuffer gapBuffer3 = (GapBuffer) obj;
                if (selection2 != null) {
                    Selection.AnchorInfo anchorInfo3 = selection2.end;
                    Selection.AnchorInfo anchorInfo4 = selection2.start;
                    if (mediaSessionImpl$2.val$callOnPlayerInteractionFinished) {
                        anchorInfoUpdateSelectionBoundary = UtilsKt.updateSelectionBoundary(mediaSessionImpl$2, gapBuffer3, anchorInfo4);
                        anchorInfo2 = anchorInfo3;
                        anchorInfo3 = anchorInfo4;
                        anchorInfo = anchorInfoUpdateSelectionBoundary;
                    } else {
                        anchorInfoUpdateSelectionBoundary = UtilsKt.updateSelectionBoundary(mediaSessionImpl$2, gapBuffer3, anchorInfo3);
                        anchorInfo = anchorInfo4;
                        anchorInfo2 = anchorInfoUpdateSelectionBoundary;
                    }
                    if (!Intrinsics.areEqual(anchorInfoUpdateSelectionBoundary, anchorInfo3)) {
                        Selection selection4 = new Selection(anchorInfo, anchorInfo2, mediaSessionImpl$2.getCrossStatus() == crossStatus || (mediaSessionImpl$2.getCrossStatus() == CrossStatus.COLLAPSED && anchorInfo.offset > anchorInfo2.offset));
                        GapBuffer gapBuffer4 = (GapBuffer) obj;
                        Selection.AnchorInfo anchorInfo5 = selection4.start;
                        long j5 = anchorInfo5.selectableId;
                        Selection.AnchorInfo anchorInfo6 = selection4.end;
                        if (j5 != anchorInfo6.selectableId) {
                            boolean z5 = selection4.handlesCrossed;
                            if ((z5 ? anchorInfo5 : anchorInfo6).offset == 0) {
                                if (((TextLayoutResult) gapBuffer4.buffer).layoutInput.text.text.length() == (z5 ? anchorInfo6 : anchorInfo5).offset) {
                                    selection3 = (Selection) mediaSessionImpl$2.val$controllerForRequest;
                                    String str = ((TextLayoutResult) gapBuffer4.buffer).layoutInput.text.text;
                                    if (selection3 == null) {
                                    }
                                }
                            }
                        } else if (anchorInfo5.offset == anchorInfo6.offset) {
                            selection3 = (Selection) mediaSessionImpl$2.val$controllerForRequest;
                            String str2 = ((TextLayoutResult) gapBuffer4.buffer).layoutInput.text.text;
                            if (selection3 == null && str2.length() != 0) {
                                boolean z6 = mediaSessionImpl$2.val$callOnPlayerInteractionFinished;
                                String str3 = ((TextLayoutResult) gapBuffer4.buffer).layoutInput.text.text;
                                int i8 = gapBuffer4.capacity;
                                int length = str3.length();
                                if (i8 == 0) {
                                    int iFindFollowingBreak = BasicTextKt.findFollowingBreak(0, str3);
                                    selection2 = !z6 ? Selection.copy$default(selection4, null, UtilsKt.changeOffset(anchorInfo6, gapBuffer4, iFindFollowingBreak), false, 1) : Selection.copy$default(selection4, UtilsKt.changeOffset(anchorInfo5, gapBuffer4, iFindFollowingBreak), null, true, 2);
                                } else if (i8 != length) {
                                    boolean z7 = selection3.handlesCrossed;
                                    int iFindPrecedingBreak = z6 ^ z7 ? BasicTextKt.findPrecedingBreak(i8, str3) : BasicTextKt.findFollowingBreak(i8, str3);
                                    selection2 = !z6 ? Selection.copy$default(selection4, null, UtilsKt.changeOffset(anchorInfo6, gapBuffer4, iFindPrecedingBreak), z7, 1) : Selection.copy$default(selection4, UtilsKt.changeOffset(anchorInfo5, gapBuffer4, iFindPrecedingBreak), null, z7, 2);
                                } else {
                                    int iFindPrecedingBreak2 = BasicTextKt.findPrecedingBreak(length, str3);
                                    selection2 = !z6 ? Selection.copy$default(selection4, null, UtilsKt.changeOffset(anchorInfo6, gapBuffer4, iFindPrecedingBreak2), true, 1) : Selection.copy$default(selection4, UtilsKt.changeOffset(anchorInfo5, gapBuffer4, iFindPrecedingBreak2), null, false, 2);
                                }
                                break;
                            }
                        }
                        selection2 = selection4;
                    }
                } else {
                    selection2 = UtilsKt.adjustToBoundaries(mediaSessionImpl$2, SelectionAdjustment$Companion.INSTANCE$1);
                }
                break;
        }
        long jTextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(selection2.start.offset), this.offsetMapping.transformedToOriginal(selection2.end.offset));
        if (TextRange.m740equalsimpl0(jTextRange2, j4)) {
            return j4;
        }
        boolean z8 = TextRange.m745getReversedimpl(jTextRange2) != TextRange.m745getReversedimpl(j4) && TextRange.m740equalsimpl0(TextRangeKt.TextRange((int) (jTextRange2 & j3), (int) (jTextRange2 >> 32)), j4);
        boolean z9 = TextRange.m741getCollapsedimpl(jTextRange2) && TextRange.m741getCollapsedimpl(j4);
        if (z3 && annotatedString.text.length() > 0 && !z8 && !z9 && hapticFeedbackType != null && (hapticFeedback = this.hapticFeedBack) != null) {
            ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(hapticFeedbackType.value);
        }
        this.onValueChange.invoke(m230createTextFieldValueFDrldGo(annotatedString, jTextRange2));
        this.latestSelection = new TextRange(jTextRange2);
        if (!z3) {
            updateFloatingToolbar(!TextRange.m741getCollapsedimpl(jTextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.isInTouchMode$delegate.setValue(Boolean.valueOf(z3));
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(!TextRange.m741getCollapsedimpl(jTextRange2) && MathKt.isSelectionHandleInVisibleBoundDefault(this, true)));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            z4 = false;
            legacyTextFieldState4.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(!TextRange.m741getCollapsedimpl(jTextRange2) && MathKt.isSelectionHandleInVisibleBoundDefault(this, false)));
        } else {
            z4 = false;
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 != null) {
            legacyTextFieldState5.showCursorHandle$delegate.setValue(Boolean.valueOf((TextRange.m741getCollapsedimpl(jTextRange2) && MathKt.isSelectionHandleInVisibleBoundDefault(this, true)) ? true : z4));
        }
        return jTextRange2;
    }
}
