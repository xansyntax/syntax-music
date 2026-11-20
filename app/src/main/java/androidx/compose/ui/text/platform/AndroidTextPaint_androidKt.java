package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidTextPaint_androidKt {
    public static final ImmutableBool Falsey = new ImmutableBool(false);

    /* JADX INFO: renamed from: drawMultiParagraph-7AXcY_I, reason: not valid java name */
    public static final void m766drawMultiParagraph7AXcY_I(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        canvas.save();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (arrayList.size() <= 1 || (brush instanceof SolidColor)) {
            m767drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle);
        } else {
            if (!(brush instanceof ShaderBrush)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            int size = arrayList.size();
            float fMax = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < size; i++) {
                AndroidParagraph androidParagraph = ((ParagraphInfo) arrayList.get(i)).paragraph;
                f2 += androidParagraph.resolvedLineHeight;
                fMax = Math.max(fMax, androidParagraph.getWidth());
            }
            Shader shaderMo474createShaderuvyYCjk = ((ShaderBrush) brush).mo474createShaderuvyYCjk((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            Matrix matrix = new Matrix();
            shaderMo474createShaderuvyYCjk.getLocalMatrix(matrix);
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AndroidParagraph androidParagraph2 = ((ParagraphInfo) arrayList.get(i2)).paragraph;
                androidParagraph2.m726painthn5TExg(canvas, new BrushKt$ShaderBrush$1(shaderMo474createShaderuvyYCjk), f, shadow, textDecoration, drawStyle);
                canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, androidParagraph2.resolvedLineHeight);
                matrix.setTranslate(CropImageView.DEFAULT_ASPECT_RATIO, -androidParagraph2.resolvedLineHeight);
                shaderMo474createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: drawParagraphs-7AXcY_I, reason: not valid java name */
    public static final void m767drawParagraphs7AXcY_I(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i);
            paragraphInfo.paragraph.m726painthn5TExg(canvas, brush, f, shadow, textDecoration, drawStyle);
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, paragraphInfo.paragraph.resolvedLineHeight);
        }
    }

    public static final void setAlpha(TextPaint textPaint, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        textPaint.setAlpha(Math.round(f * 255.0f));
    }
}
