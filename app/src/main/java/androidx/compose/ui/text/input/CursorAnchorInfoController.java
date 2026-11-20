package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.emoji2.text.EmojiProcessor;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnchorInfoController {
    public Rect decorationBoxBounds;
    public boolean hasPendingImmediateRequest;
    public boolean includeCharacterBounds;
    public boolean includeEditorBounds;
    public boolean includeInsertionMarker;
    public boolean includeLineBounds;
    public Rect innerTextFieldBounds;
    public final EmojiProcessor inputMethodManager;
    public boolean monitorEnabled;
    public OffsetMapping offsetMapping;
    public final AndroidComposeView rootPositionCalculator;
    public TextFieldValue textFieldValue;
    public TextLayoutResult textLayoutResult;
    public final Object lock = new Object();
    public Function1 textFieldToRootTransform = CursorAnchorInfoController$invalidate$1$1.INSTANCE$1;
    public final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    public final float[] matrix = Matrix.m507constructorimpl$default();
    public final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    public CursorAnchorInfoController(AndroidComposeView androidComposeView, EmojiProcessor emojiProcessor) {
        this.rootPositionCalculator = androidComposeView;
        this.inputMethodManager = emojiProcessor;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0185  */
    public final void updateCursorAnchorInfo() {
        EmojiProcessor emojiProcessor = this.inputMethodManager;
        Lazy lazy = (Lazy) emojiProcessor.mMetadataRepo;
        InputMethodManager inputMethodManager = (InputMethodManager) lazy.getValue();
        View view = (View) emojiProcessor.mSpanFactory;
        if (inputMethodManager.isActive(view)) {
            Function1 function1 = this.textFieldToRootTransform;
            float[] fArr = this.matrix;
            function1.invoke(new Matrix(fArr));
            this.rootPositionCalculator.m685localToScreen58bKbWc(fArr);
            android.graphics.Matrix matrix = this.androidMatrix;
            ColorKt.m495setFromEL8BTi8(matrix, fArr);
            TextFieldValue textFieldValue = this.textFieldValue;
            textFieldValue.getClass();
            long j = textFieldValue.selection;
            OffsetMapping offsetMapping = this.offsetMapping;
            offsetMapping.getClass();
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            textLayoutResult.getClass();
            Rect rect = this.innerTextFieldBounds;
            rect.getClass();
            Rect rect2 = this.decorationBoxBounds;
            rect2.getClass();
            boolean z = this.includeInsertionMarker;
            boolean z2 = this.includeCharacterBounds;
            boolean z3 = this.includeEditorBounds;
            boolean z4 = this.includeLineBounds;
            CursorAnchorInfo.Builder builder = this.builder;
            builder.reset();
            builder.setMatrix(matrix);
            TextRange textRange = textFieldValue.composition;
            int iM744getMinimpl = TextRange.m744getMinimpl(j);
            builder.setSelectionRange(iM744getMinimpl, TextRange.m743getMaximpl(j));
            ResolvedTextDirection resolvedTextDirection = ResolvedTextDirection.Rtl;
            if (z && iM744getMinimpl >= 0) {
                int iOriginalToTransformed = offsetMapping.originalToTransformed(iM744getMinimpl);
                Rect cursorRect = textLayoutResult.getCursorRect(iOriginalToTransformed);
                float fCoerceIn = UuidKt.coerceIn(cursorRect.left, CropImageView.DEFAULT_ASPECT_RATIO, (int) (textLayoutResult.size >> 32));
                boolean zContainsInclusive = FileSystemsKt.containsInclusive(rect, fCoerceIn, cursorRect.top);
                boolean zContainsInclusive2 = FileSystemsKt.containsInclusive(rect, fCoerceIn, cursorRect.bottom);
                boolean z5 = textLayoutResult.getBidiRunDirection(iOriginalToTransformed) == resolvedTextDirection;
                int i = (zContainsInclusive || zContainsInclusive2) ? 1 : 0;
                if (!zContainsInclusive || !zContainsInclusive2) {
                    i |= 2;
                }
                if (z5) {
                    i |= 4;
                }
                float f = cursorRect.top;
                float f2 = cursorRect.bottom;
                builder.setInsertionMarkerLocation(fCoerceIn, f, f2, f2, i);
            }
            if (z2) {
                int iM744getMinimpl2 = textRange != null ? TextRange.m744getMinimpl(textRange.packedValue) : -1;
                int iM743getMaximpl = textRange != null ? TextRange.m743getMaximpl(textRange.packedValue) : -1;
                if (iM744getMinimpl2 >= 0 && iM744getMinimpl2 < iM743getMaximpl) {
                    builder.setComposingText(iM744getMinimpl2, textFieldValue.annotatedString.text.subSequence(iM744getMinimpl2, iM743getMaximpl));
                    int iOriginalToTransformed2 = offsetMapping.originalToTransformed(iM744getMinimpl2);
                    int iOriginalToTransformed3 = offsetMapping.originalToTransformed(iM743getMaximpl);
                    float[] fArr2 = new float[(iOriginalToTransformed3 - iOriginalToTransformed2) * 4];
                    textLayoutResult.multiParagraph.m728fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(iOriginalToTransformed2, iOriginalToTransformed3), fArr2);
                    while (iM744getMinimpl2 < iM743getMaximpl) {
                        int iOriginalToTransformed4 = offsetMapping.originalToTransformed(iM744getMinimpl2);
                        int i2 = (iOriginalToTransformed4 - iOriginalToTransformed2) * 4;
                        float f3 = fArr2[i2];
                        float f4 = fArr2[i2 + 1];
                        int i3 = iM743getMaximpl;
                        float f5 = fArr2[i2 + 2];
                        float f6 = fArr2[i2 + 3];
                        int i4 = iOriginalToTransformed2;
                        int i5 = (rect.left < f5 ? 1 : 0) & (f3 < rect.right ? 1 : 0) & (rect.top < f6 ? 1 : 0) & (f4 < rect.bottom ? 1 : 0);
                        if (!FileSystemsKt.containsInclusive(rect, f3, f4) || !FileSystemsKt.containsInclusive(rect, f5, f6)) {
                            i5 |= 2;
                        }
                        if (textLayoutResult.getBidiRunDirection(iOriginalToTransformed4) == resolvedTextDirection) {
                            i5 |= 4;
                        }
                        int i6 = iM744getMinimpl2;
                        builder.addCharacterBounds(i6, f3, f4, f5, f6, i5);
                        iM744getMinimpl2 = i6 + 1;
                        iM743getMaximpl = i3;
                        iOriginalToTransformed2 = i4;
                    }
                }
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 33 && z3) {
                BundleCompat$Api33Impl.setEditorBoundsInfo(builder, rect2);
            }
            if (i7 >= 34 && z4) {
                TextViewCompat$Api34Impl.addVisibleLineBounds(builder, textLayoutResult, rect);
            }
            ((InputMethodManager) lazy.getValue()).updateCursorAnchorInfo(view, builder.build());
            this.hasPendingImmediateRequest = false;
        }
    }
}
