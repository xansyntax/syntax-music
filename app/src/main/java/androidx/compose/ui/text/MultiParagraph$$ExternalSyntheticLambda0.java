package androidx.compose.ui.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.Layout;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.State;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.CanvasKt;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNodeKt;
import dev.chrisbanes.haze.HazeTint;
import dev.chrisbanes.haze.PaintKt;
import dev.chrisbanes.haze.RenderEffect_androidKt;
import dev.chrisbanes.haze.RenderScriptBlurEffect;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MultiParagraph$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(long j, Ref$FloatRef ref$FloatRef, RenderScriptBlurEffect renderScriptBlurEffect, Context context) {
        this.$r8$classId = (byte) 3;
        this.f$0 = j;
        this.f$3 = ref$FloatRef;
        this.f$1 = renderScriptBlurEffect;
        this.f$2 = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        long j;
        int i;
        boolean z;
        TextLayout textLayout;
        float f;
        float f2;
        long j2;
        HazeEffectNode hazeEffectNode;
        long j3;
        long j4;
        AndroidPaint androidPaint;
        AndroidPaint androidPaint2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$3;
        switch (b) {
            case 0:
                float[] fArr = (float[]) obj3;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj2;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj4;
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                int i2 = paragraphInfo.startIndex;
                AndroidParagraph androidParagraph = paragraphInfo.paragraph;
                int iM743getMaximpl = paragraphInfo.endIndex;
                long j5 = this.f$0;
                int iM744getMinimpl = i2 > TextRange.m744getMinimpl(j5) ? paragraphInfo.startIndex : TextRange.m744getMinimpl(j5);
                if (iM743getMaximpl >= TextRange.m743getMaximpl(j5)) {
                    iM743getMaximpl = TextRange.m743getMaximpl(j5);
                }
                long jTextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(iM744getMinimpl), paragraphInfo.toLocalIndex(iM743getMaximpl));
                int i3 = ref$IntRef.element;
                TextLayout textLayout2 = androidParagraph.layout;
                int iM744getMinimpl2 = TextRange.m744getMinimpl(jTextRange);
                int iM743getMaximpl2 = TextRange.m743getMaximpl(jTextRange);
                Layout layout = textLayout2.layout;
                int length = layout.getText().length();
                if (iM744getMinimpl2 < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("startOffset must be > 0");
                }
                if (iM744getMinimpl2 >= length) {
                    InlineClassHelperKt.throwIllegalArgumentException("startOffset must be less than text length");
                }
                if (iM743getMaximpl2 <= iM744getMinimpl2) {
                    InlineClassHelperKt.throwIllegalArgumentException("endOffset must be greater than startOffset");
                }
                if (iM743getMaximpl2 > length) {
                    InlineClassHelperKt.throwIllegalArgumentException("endOffset must be smaller or equal to text length");
                }
                if (fArr.length - i3 < (iM743getMaximpl2 - iM744getMinimpl2) * 4) {
                    InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
                }
                int lineForOffset = textLayout2.getLineForOffset(iM744getMinimpl2);
                int lineForOffset2 = textLayout2.getLineForOffset(iM743getMaximpl2 - 1);
                RelativeScroller relativeScroller = new RelativeScroller(textLayout2);
                if (lineForOffset <= lineForOffset2) {
                    while (true) {
                        int lineStart = layout.getLineStart(lineForOffset);
                        j = jTextRange;
                        int lineEnd = textLayout2.getLineEnd(lineForOffset);
                        int iMax = Math.max(iM744getMinimpl2, lineStart);
                        int iMin = Math.min(iM743getMaximpl2, lineEnd);
                        float lineTop = textLayout2.getLineTop(lineForOffset);
                        float lineBottom = textLayout2.getLineBottom(lineForOffset);
                        int i4 = i3;
                        boolean z2 = layout.getParagraphDirection(lineForOffset) == 1;
                        int i5 = iMax;
                        while (i5 < iMin) {
                            boolean zIsRtlCharAt = layout.isRtlCharAt(i5);
                            if (!z2 || zIsRtlCharAt) {
                                i = iMin;
                                z = z2;
                                if (z && zIsRtlCharAt) {
                                    float f3 = relativeScroller.get(i5, false, false, false);
                                    textLayout = textLayout2;
                                    f = relativeScroller.get(i5 + 1, true, true, false);
                                    f2 = f3;
                                } else {
                                    textLayout = textLayout2;
                                    if (z || !zIsRtlCharAt) {
                                        f = relativeScroller.get(i5, false, false, false);
                                        f2 = relativeScroller.get(i5 + 1, true, true, false);
                                    } else {
                                        f2 = relativeScroller.get(i5, false, false, true);
                                        f = relativeScroller.get(i5 + 1, true, true, true);
                                    }
                                }
                                fArr[i4] = f;
                                fArr[i4 + 1] = lineTop;
                                fArr[i4 + 2] = f2;
                                fArr[i4 + 3] = lineBottom;
                                i4 += 4;
                                i5++;
                                z2 = z;
                                iMin = i;
                                textLayout2 = textLayout;
                            } else {
                                i = iMin;
                                z = z2;
                                f = relativeScroller.get(i5, false, false, true);
                                textLayout = textLayout2;
                                f2 = relativeScroller.get(i5 + 1, true, true, true);
                            }
                            fArr[i4] = f;
                            fArr[i4 + 1] = lineTop;
                            fArr[i4 + 2] = f2;
                            fArr[i4 + 3] = lineBottom;
                            i4 += 4;
                            i5++;
                            z2 = z;
                            iMin = i;
                            textLayout2 = textLayout;
                        }
                        TextLayout textLayout3 = textLayout2;
                        if (lineForOffset != lineForOffset2) {
                            lineForOffset++;
                            jTextRange = j;
                            i3 = i4;
                            textLayout2 = textLayout3;
                        }
                    }
                } else {
                    j = jTextRange;
                }
                int iM742getLengthimpl = (TextRange.m742getLengthimpl(j) * 4) + ref$IntRef.element;
                for (int i6 = ref$IntRef.element; i6 < iM742getLengthimpl; i6 += 4) {
                    int i7 = i6 + 1;
                    float f4 = fArr[i7];
                    float f5 = ref$FloatRef.element;
                    fArr[i7] = f4 + f5;
                    int i8 = i6 + 3;
                    fArr[i8] = fArr[i8] + f5;
                }
                ref$IntRef.element = iM742getLengthimpl;
                ref$FloatRef.element += androidParagraph.resolvedLineHeight;
                return unit;
            case 1:
                Rect rect = (Rect) obj3;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj2;
                long j6 = this.f$0;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj4;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                float f6 = rect.left;
                float f7 = rect.top;
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f6, f7);
                try {
                    DrawScope.m544drawImageAZ2fEMs$default(layoutNodeDrawScope, (ImageBitmap) ref$ObjectRef.element, j6, 0L, CropImageView.DEFAULT_ASPECT_RATIO, blendModeColorFilter, 0, 890);
                    return unit;
                } finally {
                    ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f6, -f7);
                }
            case 2:
                long j7 = this.f$0;
                AndroidPath androidPath = (AndroidPath) obj4;
                DrawScope drawScope = (DrawScope) obj;
                float fInvoke = ((FloatProducer) obj3).invoke();
                float fMax = (Math.max(Math.min(1.0f, fInvoke) - 0.4f, CropImageView.DEFAULT_ASPECT_RATIO) * 5.0f) / 3.0f;
                float fCoerceIn = UuidKt.coerceIn(Math.abs(fInvoke) - 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f);
                float fPow = (((0.4f * fMax) - 0.25f) + (fCoerceIn - (((float) Math.pow(fCoerceIn, 2.0d)) / 4.0f))) * 0.5f;
                float f8 = fPow * 360.0f;
                float f9 = ((0.8f * fMax) + fPow) * 360.0f;
                FlingCalculator flingCalculator = new FlingCalculator(fPow, f8, f9, Math.min(1.0f, fMax));
                float fFloatValue = ((Number) ((State) obj2).getValue()).floatValue();
                long jMo555getCenterF1C5BW0 = drawScope.mo555getCenterF1C5BW0();
                EmojiProcessor drawContext = drawScope.getDrawContext();
                long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    ((DrawResult) drawContext.mSpanFactory).m402rotateUv8p0NA(jMo555getCenterF1C5BW0, fPow);
                    float fMo81toPx0680j_4 = (drawScope.mo81toPx0680j_4(2.5f) / 2.0f) + drawScope.mo81toPx0680j_4(5.5f);
                    long jM881getCenteruvyYCjk = FileSystemsKt.m881getCenteruvyYCjk(drawScope.mo556getSizeNHjbRc());
                    int i9 = (int) (jM881getCenteruvyYCjk >> 32);
                    try {
                        int i10 = (int) (jM881getCenteruvyYCjk & 4294967295L);
                        Rect rect2 = new Rect(Float.intBitsToFloat(i9) - fMo81toPx0680j_4, Float.intBitsToFloat(i10) - fMo81toPx0680j_4, Float.intBitsToFloat(i9) + fMo81toPx0680j_4, Float.intBitsToFloat(i10) + fMo81toPx0680j_4);
                        drawScope.mo531drawArcyD3GUKo(j7, f8, f9 - f8, rect2.m445getTopLeftF1C5BW0(), rect2.m444getSizeNHjbRc(), (768 & 64) != 0 ? 1.0f : fFloatValue, new Stroke(drawScope.mo81toPx0680j_4(2.5f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 26));
                        SizeKt.m865drawArrowuDrxG_w(drawScope, androidPath, rect2, j7, fFloatValue, flingCalculator);
                        IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                        return unit;
                    } catch (Throwable th) {
                        th = th;
                        j2 = jM831getSizeNHjbRc;
                        IntIntPair$$ExternalSyntheticOutline0.m(drawContext, j2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j2 = jM831getSizeNHjbRc;
                }
                break;
            default:
                Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) obj4;
                RenderScriptBlurEffect renderScriptBlurEffect = (RenderScriptBlurEffect) obj3;
                Context context = (Context) obj2;
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                long j8 = this.f$0;
                long j9 = j8 ^ (-9223372034707292160L);
                long jM450times7Ah8Wj8 = Size.m450times7Ah8Wj8(drawScope2.mo556getSizeNHjbRc(), ref$FloatRef2.element);
                HazeEffectNode hazeEffectNode2 = renderScriptBlurEffect.node;
                Lazy lazy = HazeEffectNodeKt.renderEffectCache$delegate;
                CanvasKt.m1539drawScaledContentLF441nw(drawScope2, j9, jM450times7Ah8Wj8, hazeEffectNode2.blurredEdgeTreatment != null, new MimesKt$$ExternalSyntheticLambda0((byte) 21, renderScriptBlurEffect));
                long jMo556getSizeNHjbRc = drawScope2.mo556getSizeNHjbRc();
                float fMax2 = Math.max(Float.intBitsToFloat((int) (j8 >> 32)), CropImageView.DEFAULT_ASPECT_RATIO) * 2.0f;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo556getSizeNHjbRc & 4294967295L)) + (Math.max(Float.intBitsToFloat((int) (j8 & 4294967295L)), CropImageView.DEFAULT_ASPECT_RATIO) * 2.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo556getSizeNHjbRc >> 32)) + fMax2)) << 32);
                float fResolveNoiseFactor = HazeEffectNodeKt.resolveNoiseFactor(hazeEffectNode2);
                if (fResolveNoiseFactor > CropImageView.DEFAULT_ASPECT_RATIO) {
                    if (((((j9 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
                        j4 = j9;
                        if (Offset.m434equalsimpl0(j4, 0L)) {
                            j3 = jFloatToRawIntBits;
                        } else {
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L));
                            ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(fIntBitsToFloat, fIntBitsToFloat2);
                            try {
                                ConnectionPool connectionPool = PaintKt.PaintPool;
                                AndroidPaint orCreate = PaintKt.getOrCreate(connectionPool);
                                try {
                                    Paint paint = orCreate.internalPaint;
                                    paint.setAntiAlias(true);
                                    AndroidPaint androidPaint3 = orCreate;
                                    try {
                                        try {
                                            androidPaint3.setAlpha(UuidKt.coerceIn(fResolveNoiseFactor, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                            Bitmap noiseTexture = RenderEffect_androidKt.getNoiseTexture(context);
                                            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                            BitmapShader bitmapShader = new BitmapShader(noiseTexture, tileMode, tileMode);
                                            float f10 = ref$FloatRef2.element;
                                            if (f10 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                                f10 = 1.0f;
                                            }
                                            if (Math.abs(f10 - 1.0f) >= 0.001f) {
                                                Matrix matrix = new Matrix();
                                                float f11 = 1.0f / f10;
                                                matrix.setScale(f11, f11);
                                                bitmapShader.setLocalMatrix(matrix);
                                            }
                                            androidPaint3.setShader(bitmapShader);
                                            androidPaint3.m463setBlendModes9anfk8(9);
                                            Canvas canvas = drawScope2.getDrawContext().getCanvas();
                                            j8 = j8;
                                            j3 = jFloatToRawIntBits;
                                            hazeEffectNode = hazeEffectNode2;
                                            Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, j3);
                                            androidPaint3 = androidPaint3;
                                            canvas.drawRect(rectM896Recttz77jQw.left, rectM896Recttz77jQw.top, rectM896Recttz77jQw.right, rectM896Recttz77jQw.bottom, androidPaint3);
                                            paint.reset();
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) connectionPool.delegate;
                                            if (mutableScatterSet._size < 3) {
                                                mutableScatterSet.plusAssign(androidPaint3);
                                            }
                                            ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            androidPaint2 = androidPaint3;
                                            androidPaint2.internalPaint.reset();
                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) connectionPool.delegate;
                                            if (mutableScatterSet2._size < 3) {
                                                mutableScatterSet2.plusAssign(androidPaint2);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        androidPaint2 = androidPaint3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    androidPaint2 = orCreate;
                                }
                            } catch (Throwable th6) {
                                ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                throw th6;
                            }
                        }
                    } else {
                        j3 = jFloatToRawIntBits;
                        j4 = j9;
                    }
                    hazeEffectNode = hazeEffectNode2;
                    ConnectionPool connectionPool2 = PaintKt.PaintPool;
                    AndroidPaint orCreate2 = PaintKt.getOrCreate(connectionPool2);
                    MutableScatterSet mutableScatterSet3 = (MutableScatterSet) connectionPool2.delegate;
                    Paint paint2 = orCreate2.internalPaint;
                    try {
                        paint2.setAntiAlias(true);
                        orCreate2.setAlpha(UuidKt.coerceIn(fResolveNoiseFactor, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                        Bitmap noiseTexture2 = RenderEffect_androidKt.getNoiseTexture(context);
                        Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                        BitmapShader bitmapShader2 = new BitmapShader(noiseTexture2, tileMode2, tileMode2);
                        float f12 = ref$FloatRef2.element;
                        float f13 = f12 > CropImageView.DEFAULT_ASPECT_RATIO ? f12 : 1.0f;
                        if (Math.abs(f13 - 1.0f) >= 0.001f) {
                            Matrix matrix2 = new Matrix();
                            float f14 = 1.0f / f13;
                            matrix2.setScale(f14, f14);
                            bitmapShader2.setLocalMatrix(matrix2);
                        }
                        orCreate2.setShader(bitmapShader2);
                        orCreate2.m463setBlendModes9anfk8(9);
                        Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
                        Rect rectM896Recttz77jQw2 = IntMath.m896Recttz77jQw(0L, j3);
                        try {
                            canvas2.drawRect(rectM896Recttz77jQw2.left, rectM896Recttz77jQw2.top, rectM896Recttz77jQw2.right, rectM896Recttz77jQw2.bottom, orCreate2);
                            paint2.reset();
                            if (mutableScatterSet3._size < 3) {
                                mutableScatterSet3.plusAssign(orCreate2);
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            androidPaint = orCreate2;
                            paint2.reset();
                            if (mutableScatterSet3._size < 3) {
                                mutableScatterSet3.plusAssign(androidPaint);
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        androidPaint = orCreate2;
                    }
                } else {
                    j8 = j8;
                    hazeEffectNode = hazeEffectNode2;
                    j3 = jFloatToRawIntBits;
                    j4 = j9;
                }
                if (((((j4 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m434equalsimpl0(j4, 0L)) {
                    long j10 = j8;
                    long j11 = j3;
                    HazeEffectNode hazeEffectNode3 = hazeEffectNode;
                    Iterator it = HazeEffectNodeKt.resolveTints(hazeEffectNode3).iterator();
                    while (it.hasNext()) {
                        CanvasKt.m1540drawScrimDBWKusU(drawScope2, (HazeTint) it.next(), hazeEffectNode3, j10, j11);
                    }
                } else {
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j4 >> 32));
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j4 & 4294967295L));
                    ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                    try {
                        Iterator it2 = HazeEffectNodeKt.resolveTints(hazeEffectNode).iterator();
                        while (it2.hasNext()) {
                            long j12 = j8;
                            long j13 = j3;
                            HazeEffectNode hazeEffectNode4 = hazeEffectNode;
                            CanvasKt.m1540drawScrimDBWKusU(drawScope2, (HazeTint) it2.next(), hazeEffectNode4, j12, j13);
                            hazeEffectNode = hazeEffectNode4;
                            j8 = j12;
                            j3 = j13;
                        }
                        ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    } catch (Throwable th9) {
                        ((DrawResult) drawScope2.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                        throw th9;
                    }
                }
                return unit;
        }
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(long j, float[] fArr, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef) {
        this.$r8$classId = (byte) 0;
        this.f$0 = j;
        this.f$1 = fArr;
        this.f$2 = ref$IntRef;
        this.f$3 = ref$FloatRef;
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(Object obj, Object obj2, long j, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = j;
        this.f$3 = obj3;
    }
}
