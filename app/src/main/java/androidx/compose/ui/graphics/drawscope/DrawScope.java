package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import coil3.util.FileSystemsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DrawScope extends Density {
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static void m543drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, DrawStyle drawStyle, int i, int i2) {
        if ((i2 & 4) != 0) {
            j2 = drawScope.mo555getCenterF1C5BW0();
        }
        drawScope.mo532drawCircleVaOC9Bg(j, f, j2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? 3 : i);
    }

    /* JADX INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static void m544drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, float f, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
        long height;
        if ((i2 & 4) != 0) {
            height = (((long) ((AndroidImageBitmap) imageBitmap).bitmap.getHeight()) & 4294967295L) | (((long) ((AndroidImageBitmap) imageBitmap).bitmap.getWidth()) << 32);
        } else {
            height = j;
        }
        drawScope.mo533drawImageAZ2fEMs(imageBitmap, 0L, height, (i2 & 16) != 0 ? height : j2, (i2 & 32) != 0 ? 1.0f : f, (i2 & 128) != 0 ? null : blendModeColorFilter, (i2 & 512) != 0 ? 1 : i);
    }

    /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static void m545drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, BlendModeColorFilter blendModeColorFilter, int i) {
        if ((i & 16) != 0) {
            blendModeColorFilter = null;
        }
        drawScope.mo534drawImagegbVJVH8(imageBitmap, blendModeColorFilter);
    }

    /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static void m547drawPathGBMwjPU$default(DrawScope drawScope, AndroidPath androidPath, Brush brush, float f, Stroke stroke, int i) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        DrawStyle drawStyle = stroke;
        if ((i & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        drawScope.mo536drawPathGBMwjPU(androidPath, brush, f2, drawStyle, (i & 32) != 0 ? 3 : 0);
    }

    /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static void m548drawPathLG529CI$default(DrawScope drawScope, AndroidPath androidPath, long j, float f, DrawStyle drawStyle, int i) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        drawScope.mo537drawPathLG529CI(androidPath, j, f2, drawStyle);
    }

    /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static void m549drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        drawScope.mo538drawRectAsUm42w(brush, j3, (i2 & 4) != 0 ? m553offsetSizePENXr5M(drawScope.mo556getSizeNHjbRc(), j3) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : blendModeColorFilter, (i2 & 64) != 0 ? 3 : i);
    }

    /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static void m550drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, int i2) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        long j4 = j2;
        drawScope.mo539drawRectnJ9OG0(j, j4, (i2 & 4) != 0 ? m553offsetSizePENXr5M(drawScope.mo556getSizeNHjbRc(), j4) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 64) != 0 ? 3 : i);
    }

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static void m551drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j4 = j;
        drawScope.mo540drawRoundRectZuiqVtQ(brush, j4, (i & 4) != 0 ? m553offsetSizePENXr5M(drawScope.mo556getSizeNHjbRc(), j4) : j2, j3, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? Fill.INSTANCE : drawStyle);
    }

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static void m552drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, int i) {
        long j5 = (i & 2) != 0 ? 0L : j2;
        drawScope.mo541drawRoundRectuAw5IA(j, j5, (i & 4) != 0 ? m553offsetSizePENXr5M(drawScope.mo556getSizeNHjbRc(), j5) : j3, j4, (i & 16) != 0 ? Fill.INSTANCE : drawStyle);
    }

    /* JADX INFO: renamed from: offsetSize-PENXr5M, reason: not valid java name */
    static long m553offsetSizePENXr5M(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo531drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo532drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle, int i);

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    void mo533drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo534drawImagegbVJVH8(ImageBitmap imageBitmap, BlendModeColorFilter blendModeColorFilter);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo535drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, int i2);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo536drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, int i);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo537drawPathLG529CI(AndroidPath androidPath, long j, float f, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo538drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo539drawRectnJ9OG0(long j, long j2, long j3, float f, int i);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo540drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo541drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle);

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo555getCenterF1C5BW0() {
        return FileSystemsKt.m881getCenteruvyYCjk(getDrawContext().m831getSizeNHjbRc());
    }

    EmojiProcessor getDrawContext();

    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo556getSizeNHjbRc() {
        return getDrawContext().m831getSizeNHjbRc();
    }
}
