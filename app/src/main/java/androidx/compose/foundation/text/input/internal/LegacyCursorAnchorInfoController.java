package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyCursorAnchorInfoController {
    public Rect decorationBoxBounds;
    public boolean hasPendingImmediateRequest;
    public boolean includeCharacterBounds;
    public boolean includeEditorBounds;
    public boolean includeInsertionMarker;
    public boolean includeLineBounds;
    public Rect innerTextFieldBounds;
    public final WeakCache inputMethodManager;
    public final AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 localToScreen;
    public boolean monitorEnabled;
    public OffsetMapping offsetMapping;
    public TextFieldValue textFieldValue;
    public TextLayoutResult textLayoutResult;
    public final Object lock = new Object();
    public final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    public final float[] matrix = Matrix.m507constructorimpl$default();
    public final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    public LegacyCursorAnchorInfoController(AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, WeakCache weakCache) {
        this.localToScreen = androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1;
        this.inputMethodManager = weakCache;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01b7  */
    public final void updateCursorAnchorInfo() {
        WeakCache weakCache = this.inputMethodManager;
        InputMethodManager imm = weakCache.getImm();
        View view = (View) weakCache.values;
        if (!imm.isActive(view) || this.textFieldValue == null || this.offsetMapping == null || this.textLayoutResult == null || this.innerTextFieldBounds == null || this.decorationBoxBounds == null) {
            return;
        }
        float[] fArr = this.matrix;
        Matrix.m510resetimpl(fArr);
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.localToScreen.$node.layoutCoordinates$delegate.getValue();
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached$1()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                layoutCoordinates.mo611transformToScreen58bKbWc(fArr);
            }
        }
        Rect rect = this.decorationBoxBounds;
        rect.getClass();
        float f = -rect.left;
        Rect rect2 = this.decorationBoxBounds;
        rect2.getClass();
        Matrix.m514translateimpl(fArr, f, -rect2.top);
        android.graphics.Matrix matrix = this.androidMatrix;
        ColorKt.m495setFromEL8BTi8(matrix, fArr);
        TextFieldValue textFieldValue = this.textFieldValue;
        textFieldValue.getClass();
        long j = textFieldValue.selection;
        OffsetMapping offsetMapping = this.offsetMapping;
        offsetMapping.getClass();
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        textLayoutResult.getClass();
        Rect rect3 = this.innerTextFieldBounds;
        rect3.getClass();
        Rect rect4 = this.decorationBoxBounds;
        rect4.getClass();
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
            boolean zContainsInclusive = HandwritingGesture_androidKt.containsInclusive(rect3, fCoerceIn, cursorRect.top);
            boolean zContainsInclusive2 = HandwritingGesture_androidKt.containsInclusive(rect3, fCoerceIn, cursorRect.bottom);
            boolean z5 = textLayoutResult.getBidiRunDirection(iOriginalToTransformed) == resolvedTextDirection;
            int i = (zContainsInclusive || zContainsInclusive2) ? 1 : 0;
            if (!zContainsInclusive || !zContainsInclusive2) {
                i |= 2;
            }
            if (z5) {
                i |= 4;
            }
            float f2 = cursorRect.top;
            float f3 = cursorRect.bottom;
            builder.setInsertionMarkerLocation(fCoerceIn, f2, f3, f3, i);
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
                    float f4 = fArr2[i2];
                    float f5 = fArr2[i2 + 1];
                    int i3 = iM743getMaximpl;
                    float f6 = fArr2[i2 + 2];
                    float f7 = fArr2[i2 + 3];
                    int i4 = iOriginalToTransformed2;
                    int i5 = (rect3.left < f6 ? 1 : 0) & (f4 < rect3.right ? 1 : 0) & (rect3.top < f7 ? 1 : 0) & (f5 < rect3.bottom ? 1 : 0);
                    if (!HandwritingGesture_androidKt.containsInclusive(rect3, f4, f5) || !HandwritingGesture_androidKt.containsInclusive(rect3, f6, f7)) {
                        i5 |= 2;
                    }
                    if (textLayoutResult.getBidiRunDirection(iOriginalToTransformed4) == resolvedTextDirection) {
                        i5 |= 4;
                    }
                    int i6 = iM744getMinimpl2;
                    builder.addCharacterBounds(i6, f4, f5, f6, f7, i5);
                    iM744getMinimpl2 = i6 + 1;
                    iM743getMaximpl = i3;
                    iOriginalToTransformed2 = i4;
                }
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33 && z3) {
            Api34StartStylusHandwriting.setEditorBoundsInfo(builder, rect4);
        }
        if (i7 >= 34 && z4) {
            EditorInfoApi34.addVisibleLineBounds(builder, textLayoutResult, rect3);
        }
        weakCache.getImm().updateCursorAnchorInfo(view, builder.build());
        this.hasPendingImmediateRequest = false;
    }
}
