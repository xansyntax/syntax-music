package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextFieldSelectionManager f$0;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda7(TextFieldSelectionManager textFieldSelectionManager, byte b) {
        this.$r8$classId = b;
        this.f$0 = textFieldSelectionManager;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0122  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Rect rect;
        LayoutCoordinates layoutCoordinates;
        char c;
        float fIntBitsToFloat;
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LayoutCoordinates layoutCoordinates5;
        byte b = this.$r8$classId;
        TextFieldSelectionManager textFieldSelectionManager = this.f$0;
        switch (b) {
            case 0:
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 8, textFieldSelectionManager);
            case 1:
                textFieldSelectionManager.showSelectionToolbar$foundation();
                return Unit.INSTANCE;
            default:
                LayoutCoordinates layoutCoordinates6 = (LayoutCoordinates) obj;
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                Rect rect2 = Rect.Zero;
                if (legacyTextFieldState == null) {
                    rect = rect2;
                } else {
                    if (legacyTextFieldState.isLayoutResultStale) {
                        legacyTextFieldState = null;
                    }
                    if (legacyTextFieldState != null) {
                        OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                        long j = textFieldSelectionManager.getValue$foundation().selection;
                        int i = TextRange.$r8$clinit;
                        int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
                        int iOriginalToTransformed2 = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection & 4294967295L));
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        long jMo606localToRootMKHz9U = 0;
                        long jMo606localToRootMKHz9U2 = (legacyTextFieldState2 == null || (layoutCoordinates5 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? 0L : layoutCoordinates5.mo606localToRootMKHz9U(textFieldSelectionManager.m233getHandlePositiontuRUvjQ$foundation(true));
                        LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                        if (legacyTextFieldState3 != null && (layoutCoordinates4 = legacyTextFieldState3.getLayoutCoordinates()) != null) {
                            jMo606localToRootMKHz9U = layoutCoordinates4.mo606localToRootMKHz9U(textFieldSelectionManager.m233getHandlePositiontuRUvjQ$foundation(false));
                        }
                        LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                        float fIntBitsToFloat2 = CropImageView.DEFAULT_ASPECT_RATIO;
                        if (legacyTextFieldState4 == null || (layoutCoordinates3 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                            c = ' ';
                            fIntBitsToFloat = 0.0f;
                        } else {
                            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                            c = ' ';
                            fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinates3.mo606localToRootMKHz9U((((long) Float.floatToRawIntBits(layoutResult != null ? layoutResult.value.getCursorRect(iOriginalToTransformed).top : 0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32)) & 4294967295L));
                        }
                        LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                        if (legacyTextFieldState5 != null && (layoutCoordinates2 = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                            fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutCoordinates2.mo606localToRootMKHz9U((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << c) | (((long) Float.floatToRawIntBits(layoutResult2 != null ? layoutResult2.value.getCursorRect(iOriginalToTransformed2).top : 0.0f)) & 4294967295L)) & 4294967295L));
                        }
                        int i2 = (int) (jMo606localToRootMKHz9U2 >> c);
                        int i3 = (int) (jMo606localToRootMKHz9U >> c);
                        rect = new Rect(Math.min(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3)), (((Density) legacyTextFieldState.textDelegate.density).getDensity() * 25.0f) + Math.max(Float.intBitsToFloat((int) (jMo606localToRootMKHz9U2 & 4294967295L)), Float.intBitsToFloat((int) (jMo606localToRootMKHz9U & 4294967295L))));
                    } else {
                        rect = rect2;
                    }
                }
                LegacyTextFieldState legacyTextFieldState6 = textFieldSelectionManager.state;
                if (legacyTextFieldState6 == null || (layoutCoordinates = legacyTextFieldState6.getLayoutCoordinates()) == null) {
                    return null;
                }
                return (layoutCoordinates.isAttached$1() && layoutCoordinates6.isAttached$1()) ? IntMath.m896Recttz77jQw(layoutCoordinates6.mo609screenToLocalMKHz9U(RulerKt.findRootCoordinates(layoutCoordinates).mo607localToScreenMKHz9U(rect.m445getTopLeftF1C5BW0())), rect.m444getSizeNHjbRc()) : rect2;
        }
    }
}
