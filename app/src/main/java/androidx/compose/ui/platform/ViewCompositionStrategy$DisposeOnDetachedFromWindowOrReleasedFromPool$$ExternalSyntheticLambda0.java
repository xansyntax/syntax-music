package androidx.compose.ui.platform;

import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 implements DoubleFunction, ShouldPauseCallback, VisualTransformation {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString annotatedString) {
        return new TransformedText(annotatedString, OffsetMapping.Companion.Identity);
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        switch (this.$r8$classId) {
            case 15:
                double d2 = d < 0.0d ? -d : d;
                return Math.copySign(d2 >= 0.0031308049535603718d ? (Math.pow(d2, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d2 / 0.07739938080495357d, d);
            case 16:
                double d3 = d < 0.0d ? -d : d;
                return Math.copySign(d3 >= 0.04045d ? Math.pow((0.9478672985781991d * d3) + 0.05213270142180095d, 2.4d) : d3 * 0.07739938080495357d, d);
            case 17:
                float[] fArr = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferHlgOetf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, d);
            case 18:
                float[] fArr2 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferHlgEotf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, d);
            case 19:
                float[] fArr3 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferSt2048Oetf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, d);
            case 20:
                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferSt2048Eotf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, d);
            default:
                return d;
        }
    }

    @Override // androidx.compose.runtime.ShouldPauseCallback
    public boolean shouldPause() {
        return false;
    }

    public static /* bridge */ /* synthetic */ ContentCaptureSession m(Object obj) {
        return (ContentCaptureSession) obj;
    }
}
