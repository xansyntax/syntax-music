package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextInclusionStrategy$Companion;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import io.ktor.sse.ServerSentEventKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.Regex;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EditorInfoApi34 {
    public static final void addVisibleLineBounds(CursorAnchorInfo.Builder builder, TextLayoutResult textLayoutResult, Rect rect) {
        if (rect.isEmpty()) {
            return;
        }
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int i = multiParagraph.lineCount - 1;
        if (i < 0) {
            i = 0;
        }
        int iCoerceIn = UuidKt.coerceIn(multiParagraph.getLineForVerticalPosition(rect.top), 0, i);
        int iCoerceIn2 = UuidKt.coerceIn(multiParagraph.getLineForVerticalPosition(rect.bottom), 0, i);
        if (iCoerceIn > iCoerceIn2) {
            return;
        }
        while (true) {
            builder.addVisibleLineBounds(textLayoutResult.getLineLeft(iCoerceIn), multiParagraph.getLineTop(iCoerceIn), textLayoutResult.getLineRight(iCoerceIn), multiParagraph.getLineBottom(iCoerceIn));
            if (iCoerceIn == iCoerceIn2) {
                return;
            } else {
                iCoerceIn++;
            }
        }
    }

    public static int fallbackOnLegacyTextField(HandwritingGesture handwritingGesture, ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        scrollState$$ExternalSyntheticLambda0.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* JADX INFO: renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    public static void m213performDeletionOnLegacyTextFieldvJH6DeI(long j, AnnotatedString annotatedString, boolean z, ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0) {
        if (z) {
            int i = TextRange.$r8$clinit;
            int iCharCount = (int) (j >> 32);
            int iCharCount2 = (int) (j & 4294967295L);
            int iCodePointBefore = iCharCount > 0 ? Character.codePointBefore(annotatedString, iCharCount) : 10;
            int iCodePointAt = iCharCount2 < annotatedString.text.length() ? Character.codePointAt(annotatedString, iCharCount2) : 10;
            if (HandwritingGesture_androidKt.isWhitespaceExceptNewline(iCodePointBefore) && (HandwritingGesture_androidKt.isWhitespace(iCodePointAt) || HandwritingGesture_androidKt.isPunctuation(iCodePointAt))) {
                do {
                    iCharCount -= Character.charCount(iCodePointBefore);
                    if (iCharCount == 0) {
                        break;
                    } else {
                        iCodePointBefore = Character.codePointBefore(annotatedString, iCharCount);
                    }
                } while (HandwritingGesture_androidKt.isWhitespaceExceptNewline(iCodePointBefore));
                j = TextRangeKt.TextRange(iCharCount, iCharCount2);
            } else if (HandwritingGesture_androidKt.isWhitespaceExceptNewline(iCodePointAt) && (HandwritingGesture_androidKt.isWhitespace(iCodePointBefore) || HandwritingGesture_androidKt.isPunctuation(iCodePointBefore))) {
                do {
                    iCharCount2 += Character.charCount(iCodePointAt);
                    if (iCharCount2 == annotatedString.text.length()) {
                        break;
                    } else {
                        iCodePointAt = Character.codePointAt(annotatedString, iCharCount2);
                    }
                } while (HandwritingGesture_androidKt.isWhitespaceExceptNewline(iCodePointAt));
                j = TextRangeKt.TextRange(iCharCount, iCharCount2);
            }
        }
        int i2 = (int) (4294967295L & j);
        scrollState$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i2, i2), new DeleteSurroundingTextCommand(TextRange.m742getLengthimpl(j), 0)}));
    }

    /* JADX WARN: Code duplicated, block: B:140:0x0264  */
    public static int performHandwritingGesture$foundation(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0) {
        long jM730getRangeForRect86BmAI;
        int i;
        TextLayoutResultProxy layoutResult;
        TextLayoutResultProxy layoutResult2;
        TextLayoutInput textLayoutInput;
        AnnotatedString annotatedString = legacyTextFieldState.untransformedText;
        if (annotatedString == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult3 = legacyTextFieldState.getLayoutResult();
        if (!annotatedString.equals((layoutResult3 == null || (textLayoutInput = layoutResult3.value.layoutInput) == null) ? null : textLayoutInput.text)) {
            return 3;
        }
        if (handwritingGesture instanceof SelectGesture) {
            SelectGesture selectGesture = (SelectGesture) handwritingGesture;
            long jM216getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, ColorKt.toComposeRect(selectGesture.getSelectionArea()), selectGesture.getGranularity() == 1 ? 1 : 0);
            if (TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo)) {
                return fallbackOnLegacyTextField(selectGesture, scrollState$$ExternalSyntheticLambda0);
            }
            scrollState$$ExternalSyntheticLambda0.invoke(new SetSelectionCommand((int) (jM216getRangeForScreenRectOH9lIzo >> 32), (int) (jM216getRangeForScreenRectOH9lIzo & 4294967295L)));
            if (textFieldSelectionManager != null) {
                textFieldSelectionManager.enterSelectionMode$foundation(true);
                return 1;
            }
        } else {
            if (handwritingGesture instanceof DeleteGesture) {
                DeleteGesture deleteGesture = (DeleteGesture) handwritingGesture;
                int i2 = deleteGesture.getGranularity() != 1 ? 0 : 1;
                long jM216getRangeForScreenRectOH9lIzo2 = HandwritingGesture_androidKt.m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, ColorKt.toComposeRect(deleteGesture.getDeletionArea()), i2);
                if (TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo2)) {
                    return fallbackOnLegacyTextField(deleteGesture, scrollState$$ExternalSyntheticLambda0);
                }
                m213performDeletionOnLegacyTextFieldvJH6DeI(jM216getRangeForScreenRectOH9lIzo2, annotatedString, i2 == 1, scrollState$$ExternalSyntheticLambda0);
                return 1;
            }
            if (!(handwritingGesture instanceof SelectRangeGesture)) {
                if (handwritingGesture instanceof DeleteRangeGesture) {
                    DeleteRangeGesture deleteRangeGesture = (DeleteRangeGesture) handwritingGesture;
                    int i3 = deleteRangeGesture.getGranularity() != 1 ? 0 : 1;
                    long jM217getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m217getRangeForScreenRectsO048IG0(legacyTextFieldState, ColorKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), ColorKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), i3);
                    if (TextRange.m741getCollapsedimpl(jM217getRangeForScreenRectsO048IG0)) {
                        return fallbackOnLegacyTextField(deleteRangeGesture, scrollState$$ExternalSyntheticLambda0);
                    }
                    m213performDeletionOnLegacyTextFieldvJH6DeI(jM217getRangeForScreenRectsO048IG0, annotatedString, i3 == 1, scrollState$$ExternalSyntheticLambda0);
                    return 1;
                }
                if (handwritingGesture instanceof JoinOrSplitGesture) {
                    JoinOrSplitGesture joinOrSplitGesture = (JoinOrSplitGesture) handwritingGesture;
                    if (viewConfiguration == null) {
                        return fallbackOnLegacyTextField(joinOrSplitGesture, scrollState$$ExternalSyntheticLambda0);
                    }
                    int iM215getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m215getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
                    if (iM215getOffsetForHandwritingGestured4ec7I == -1 || ((layoutResult2 = legacyTextFieldState.getLayoutResult()) != null && HandwritingGesture_androidKt.isBiDiBoundary(layoutResult2.value, iM215getOffsetForHandwritingGestured4ec7I))) {
                        return fallbackOnLegacyTextField(joinOrSplitGesture, scrollState$$ExternalSyntheticLambda0);
                    }
                    int iCharCount = iM215getOffsetForHandwritingGestured4ec7I;
                    while (iCharCount > 0) {
                        int iCodePointBefore = Character.codePointBefore(annotatedString, iCharCount);
                        if (!HandwritingGesture_androidKt.isWhitespace(iCodePointBefore)) {
                            break;
                        }
                        iCharCount -= Character.charCount(iCodePointBefore);
                    }
                    while (iM215getOffsetForHandwritingGestured4ec7I < annotatedString.text.length()) {
                        int iCodePointAt = Character.codePointAt(annotatedString, iM215getOffsetForHandwritingGestured4ec7I);
                        if (!HandwritingGesture_androidKt.isWhitespace(iCodePointAt)) {
                            break;
                        }
                        iM215getOffsetForHandwritingGestured4ec7I += Character.charCount(iCodePointAt);
                    }
                    long jTextRange = TextRangeKt.TextRange(iCharCount, iM215getOffsetForHandwritingGestured4ec7I);
                    if (!TextRange.m741getCollapsedimpl(jTextRange)) {
                        m213performDeletionOnLegacyTextFieldvJH6DeI(jTextRange, annotatedString, false, scrollState$$ExternalSyntheticLambda0);
                        return 1;
                    }
                    int i4 = (int) (jTextRange >> 32);
                    scrollState$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i4, i4), new CommitTextCommand(ServerSentEventKt.SPACE, 1)}));
                    return 1;
                }
                if (handwritingGesture instanceof InsertGesture) {
                    InsertGesture insertGesture = (InsertGesture) handwritingGesture;
                    if (viewConfiguration == null) {
                        return fallbackOnLegacyTextField(insertGesture, scrollState$$ExternalSyntheticLambda0);
                    }
                    int iM215getOffsetForHandwritingGestured4ec7I2 = HandwritingGesture_androidKt.m215getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
                    if (iM215getOffsetForHandwritingGestured4ec7I2 == -1 || ((layoutResult = legacyTextFieldState.getLayoutResult()) != null && HandwritingGesture_androidKt.isBiDiBoundary(layoutResult.value, iM215getOffsetForHandwritingGestured4ec7I2))) {
                        return fallbackOnLegacyTextField(insertGesture, scrollState$$ExternalSyntheticLambda0);
                    }
                    scrollState$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(iM215getOffsetForHandwritingGestured4ec7I2, iM215getOffsetForHandwritingGestured4ec7I2), new CommitTextCommand(insertGesture.getTextToInsert(), 1)}));
                    return 1;
                }
                if (!(handwritingGesture instanceof RemoveSpaceGesture)) {
                    return 2;
                }
                RemoveSpaceGesture removeSpaceGesture = (RemoveSpaceGesture) handwritingGesture;
                TextLayoutResultProxy layoutResult4 = legacyTextFieldState.getLayoutResult();
                TextLayoutResult textLayoutResult = layoutResult4 != null ? layoutResult4.value : null;
                long offset = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint());
                long offset2 = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint());
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                if (textLayoutResult != null) {
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    if (layoutCoordinates == null) {
                        jM730getRangeForRect86BmAI = TextRange.Zero;
                    } else {
                        long jMo609screenToLocalMKHz9U = layoutCoordinates.mo609screenToLocalMKHz9U(offset);
                        long jMo609screenToLocalMKHz9U2 = layoutCoordinates.mo609screenToLocalMKHz9U(offset2);
                        int iM214getLineForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m214getLineForHandwritingGestured4ec7I(multiParagraph, jMo609screenToLocalMKHz9U, viewConfiguration);
                        int iM214getLineForHandwritingGestured4ec7I2 = HandwritingGesture_androidKt.m214getLineForHandwritingGestured4ec7I(multiParagraph, jMo609screenToLocalMKHz9U2, viewConfiguration);
                        if (iM214getLineForHandwritingGestured4ec7I != -1) {
                            if (iM214getLineForHandwritingGestured4ec7I2 != -1) {
                                iM214getLineForHandwritingGestured4ec7I = Math.min(iM214getLineForHandwritingGestured4ec7I, iM214getLineForHandwritingGestured4ec7I2);
                            }
                            iM214getLineForHandwritingGestured4ec7I2 = iM214getLineForHandwritingGestured4ec7I;
                        } else if (iM214getLineForHandwritingGestured4ec7I2 == -1) {
                            jM730getRangeForRect86BmAI = TextRange.Zero;
                        }
                        float lineBottom = (multiParagraph.getLineBottom(iM214getLineForHandwritingGestured4ec7I2) + multiParagraph.getLineTop(iM214getLineForHandwritingGestured4ec7I2)) / 2.0f;
                        int i5 = (int) (jMo609screenToLocalMKHz9U >> 32);
                        int i6 = (int) (jMo609screenToLocalMKHz9U2 >> 32);
                        jM730getRangeForRect86BmAI = multiParagraph.m730getRangeForRect86BmAI(new Rect(Math.min(Float.intBitsToFloat(i5), Float.intBitsToFloat(i6)), lineBottom - 0.1f, Math.max(Float.intBitsToFloat(i5), Float.intBitsToFloat(i6)), lineBottom + 0.1f), 0, TextInclusionStrategy$Companion.AnyOverlap);
                    }
                } else {
                    jM730getRangeForRect86BmAI = TextRange.Zero;
                }
                if (TextRange.m741getCollapsedimpl(jM730getRangeForRect86BmAI)) {
                    return fallbackOnLegacyTextField(removeSpaceGesture, scrollState$$ExternalSyntheticLambda0);
                }
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = -1;
                Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                ref$IntRef2.element = -1;
                String strReplace = new Regex("\\s+").replace(annotatedString.subSequence(TextRange.m744getMinimpl(jM730getRangeForRect86BmAI), TextRange.m743getMaximpl(jM730getRangeForRect86BmAI)).text, new ZIndexNode$$ExternalSyntheticLambda0((Object) ref$IntRef, (Object) ref$IntRef2, (byte) 7));
                int i7 = ref$IntRef.element;
                if (i7 == -1 || (i = ref$IntRef2.element) == -1) {
                    return fallbackOnLegacyTextField(removeSpaceGesture, scrollState$$ExternalSyntheticLambda0);
                }
                int i8 = (int) (jM730getRangeForRect86BmAI >> 32);
                scrollState$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i8 + i7, i8 + i), new CommitTextCommand(strReplace.substring(i7, strReplace.length() - (TextRange.m742getLengthimpl(jM730getRangeForRect86BmAI) - ref$IntRef2.element)), 1)}));
                return 1;
            }
            SelectRangeGesture selectRangeGesture = (SelectRangeGesture) handwritingGesture;
            long jM217getRangeForScreenRectsO048IG1 = HandwritingGesture_androidKt.m217getRangeForScreenRectsO048IG0(legacyTextFieldState, ColorKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), ColorKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), selectRangeGesture.getGranularity() == 1 ? 1 : 0);
            if (TextRange.m741getCollapsedimpl(jM217getRangeForScreenRectsO048IG1)) {
                return fallbackOnLegacyTextField(selectRangeGesture, scrollState$$ExternalSyntheticLambda0);
            }
            scrollState$$ExternalSyntheticLambda0.invoke(new SetSelectionCommand((int) (jM217getRangeForScreenRectsO048IG1 >> 32), (int) (jM217getRangeForScreenRectsO048IG1 & 4294967295L)));
            if (textFieldSelectionManager != null) {
                textFieldSelectionManager.enterSelectionMode$foundation(true);
            }
        }
        return 1;
    }

    public static boolean previewHandwritingGesture$foundation(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutInput textLayoutInput;
        AnnotatedString annotatedString = legacyTextFieldState.untransformedText;
        byte b = 0;
        if (annotatedString != null) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (annotatedString.equals((layoutResult == null || (textLayoutInput = layoutResult.value.layoutInput) == null) ? null : textLayoutInput.text)) {
                boolean z = previewableHandwritingGesture instanceof SelectGesture;
                HandleState handleState = HandleState.None;
                if (z) {
                    SelectGesture selectGesture = (SelectGesture) previewableHandwritingGesture;
                    if (textFieldSelectionManager != null) {
                        long jM216getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, ColorKt.toComposeRect(selectGesture.getSelectionArea()), selectGesture.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        if (legacyTextFieldState2 != null) {
                            legacyTextFieldState2.m199setSelectionPreviewHighlightRange5zctL8(jM216getRangeForScreenRectOH9lIzo);
                        }
                        LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                        if (legacyTextFieldState3 != null) {
                            legacyTextFieldState3.m198setDeletionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (previewableHandwritingGesture instanceof DeleteGesture) {
                    DeleteGesture deleteGesture = (DeleteGesture) previewableHandwritingGesture;
                    if (textFieldSelectionManager != null) {
                        long jM216getRangeForScreenRectOH9lIzo2 = HandwritingGesture_androidKt.m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, ColorKt.toComposeRect(deleteGesture.getDeletionArea()), deleteGesture.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                        if (legacyTextFieldState4 != null) {
                            legacyTextFieldState4.m198setDeletionPreviewHighlightRange5zctL8(jM216getRangeForScreenRectOH9lIzo2);
                        }
                        LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                        if (legacyTextFieldState5 != null) {
                            legacyTextFieldState5.m199setSelectionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo2)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
                    SelectRangeGesture selectRangeGesture = (SelectRangeGesture) previewableHandwritingGesture;
                    if (textFieldSelectionManager != null) {
                        long jM217getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m217getRangeForScreenRectsO048IG0(legacyTextFieldState, ColorKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), ColorKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), selectRangeGesture.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState6 = textFieldSelectionManager.state;
                        if (legacyTextFieldState6 != null) {
                            legacyTextFieldState6.m199setSelectionPreviewHighlightRange5zctL8(jM217getRangeForScreenRectsO048IG0);
                        }
                        LegacyTextFieldState legacyTextFieldState7 = textFieldSelectionManager.state;
                        if (legacyTextFieldState7 != null) {
                            legacyTextFieldState7.m198setDeletionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m741getCollapsedimpl(jM217getRangeForScreenRectsO048IG0)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (previewableHandwritingGesture instanceof DeleteRangeGesture) {
                    DeleteRangeGesture deleteRangeGesture = (DeleteRangeGesture) previewableHandwritingGesture;
                    if (textFieldSelectionManager != null) {
                        long jM217getRangeForScreenRectsO048IG1 = HandwritingGesture_androidKt.m217getRangeForScreenRectsO048IG0(legacyTextFieldState, ColorKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), ColorKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), deleteRangeGesture.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState8 = textFieldSelectionManager.state;
                        if (legacyTextFieldState8 != null) {
                            legacyTextFieldState8.m198setDeletionPreviewHighlightRange5zctL8(jM217getRangeForScreenRectsO048IG1);
                        }
                        LegacyTextFieldState legacyTextFieldState9 = textFieldSelectionManager.state;
                        if (legacyTextFieldState9 != null) {
                            legacyTextFieldState9.m199setSelectionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m741getCollapsedimpl(jM217getRangeForScreenRectsO048IG1)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda0(b, textFieldSelectionManager));
                }
                return true;
            }
        }
        return false;
    }

    public static void setHandwritingGestures(EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(CollectionsKt__IterablesKt.listOf((Object[]) new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class, JoinOrSplitGesture.class, InsertGesture.class, RemoveSpaceGesture.class}));
        editorInfo.setSupportedHandwritingGesturePreviews(ArraysKt.toSet(new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class}));
    }
}
