package androidx.compose.material3.internal;

import android.graphics.Path;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$4$1;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DeterminateLinearWavyProgressNode f$0;

    public /* synthetic */ DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0(DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = determinateLinearWavyProgressNode;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:52:0x010c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:57:0x0126 A[LOOP:3: B:55:0x0122->B:57:0x0126, LOOP_END] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b;
        float f;
        float f2;
        float fIntBitsToFloat;
        char c;
        float fIntBitsToFloat2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        boolean z;
        float f11;
        byte b2 = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode = this.f$0;
        switch (b2) {
            case 0:
                byte b3 = 2;
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                float fFloatValue = ((Number) determinateLinearWavyProgressNode.progress.invoke()).floatValue();
                if (fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                float fFloatValue2 = ((Number) determinateLinearWavyProgressNode.amplitude.invoke(Float.valueOf(fFloatValue > 1.0f ? 1.0f : fFloatValue))).floatValue();
                float f12 = fFloatValue2 < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : fFloatValue2;
                float f13 = f12 > 1.0f ? 1.0f : f12;
                Animatable animatableAnimatable$default = determinateLinearWavyProgressNode.amplitudeAnimatable;
                if (animatableAnimatable$default == null) {
                    animatableAnimatable$default = ArcSplineKt.Animatable$default(f13);
                    determinateLinearWavyProgressNode.amplitudeAnimatable = animatableAnimatable$default;
                }
                if (determinateLinearWavyProgressNode.isAttached && ((Number) animatableAnimatable$default.targetValue$delegate.getValue()).floatValue() != f13) {
                    StandaloneCoroutine standaloneCoroutine = determinateLinearWavyProgressNode.amplitudeAnimationJob;
                    if (standaloneCoroutine != null) {
                        b = 1;
                        if (standaloneCoroutine.isCompleted()) {
                        }
                    } else {
                        b = 1;
                    }
                    determinateLinearWavyProgressNode.amplitudeAnimationJob = AwaitKt.launch$default(determinateLinearWavyProgressNode.getCoroutineScope(), null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatableAnimatable$default, f13, null, b), 3);
                }
                return cacheDrawScope.onDrawWithContent(new DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0(determinateLinearWavyProgressNode, b3));
            case 1:
                determinateLinearWavyProgressNode.waveOffset.setFloatValue(((Number) ((Animatable) obj).getValue()).floatValue() % 1.0f);
                return unit;
            default:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                Animatable animatable = determinateLinearWavyProgressNode.amplitudeAnimatable;
                LinearProgressDrawingCache linearProgressDrawingCache = determinateLinearWavyProgressNode.progressDrawingCache;
                float fFloatValue3 = animatable != null ? ((Number) animatable.getValue()).floatValue() : 0.0f;
                long jMo556getSizeNHjbRc = layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc();
                float f14 = determinateLinearWavyProgressNode.wavelength;
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                float fMo81toPx0680j_4 = layoutNodeDrawScope.mo81toPx0680j_4(f14);
                float[] progressFractions = determinateLinearWavyProgressNode.getProgressFractions();
                float floatValue = fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO ? determinateLinearWavyProgressNode.waveOffset.getFloatValue() : 0.0f;
                float fMo81toPx0680j_5 = layoutNodeDrawScope.mo81toPx0680j_4(determinateLinearWavyProgressNode.gapSize);
                Stroke stroke = determinateLinearWavyProgressNode.stroke;
                Stroke stroke2 = determinateLinearWavyProgressNode.trackStroke;
                float f15 = 1.0f;
                AndroidPathMeasure androidPathMeasure = linearProgressDrawingCache.pathMeasure;
                AndroidPath androidPath = linearProgressDrawingCache.trackPathToDraw;
                if (linearProgressDrawingCache.currentProgressFractions == null) {
                    linearProgressDrawingCache.currentProgressFractions = new float[progressFractions.length];
                    int length = progressFractions.length / 2;
                    AndroidPath[] androidPathArr = new AndroidPath[length];
                    for (int i = 0; i < length; i++) {
                        androidPathArr[i] = AndroidPath_androidKt.Path();
                    }
                    linearProgressDrawingCache.progressPathsToDraw = androidPathArr;
                }
                AndroidPath androidPath2 = linearProgressDrawingCache.fullProgressPath;
                float f16 = fFloatValue3;
                if (Size.m447equalsimpl0(linearProgressDrawingCache.currentSize, jMo556getSizeNHjbRc) && linearProgressDrawingCache.currentWavelength == fMo81toPx0680j_4 && Intrinsics.areEqual(linearProgressDrawingCache.currentStroke, stroke) && Intrinsics.areEqual(linearProgressDrawingCache.currentTrackStroke, stroke2) && linearProgressDrawingCache.currentIndicatorTrackGapSize == fMo81toPx0680j_5) {
                    float f17 = linearProgressDrawingCache.currentAmplitude;
                    if (!(f17 == CropImageView.DEFAULT_ASPECT_RATIO || f16 == CropImageView.DEFAULT_ASPECT_RATIO) || (f17 == CropImageView.DEFAULT_ASPECT_RATIO && f16 == CropImageView.DEFAULT_ASPECT_RATIO)) {
                        z = false;
                        f2 = 2.0f;
                        c = ' ';
                    } else {
                        f = fMo81toPx0680j_5;
                        f2 = 2.0f;
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jMo556getSizeNHjbRc & 4294967295L));
                        c = ' ';
                        fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo556getSizeNHjbRc >> 32));
                        int i2 = stroke.cap;
                        f3 = stroke.width;
                        linearProgressDrawingCache.currentStrokeCapWidth = ((i2 == 0 || stroke2.cap != 0) && fIntBitsToFloat <= fIntBitsToFloat2) ? Math.max(f3 / 2.0f, stroke2.width / 2.0f) : 0.0f;
                        androidPath2.rewind();
                        androidPath2.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                        if (f16 == CropImageView.DEFAULT_ASPECT_RATIO) {
                            androidPath2.lineTo(fIntBitsToFloat2, CropImageView.DEFAULT_ASPECT_RATIO);
                            f9 = fIntBitsToFloat;
                            f10 = 0.0f;
                        } else {
                            f4 = fMo81toPx0680j_4 / 2.0f;
                            f5 = fIntBitsToFloat - f3;
                            f6 = (fMo81toPx0680j_4 * 2.0f) + fIntBitsToFloat2;
                            f7 = f4;
                            f8 = f4 / 2.0f;
                            while (f7 <= f6) {
                                androidPath2.internalPath.quadTo(f8, f5, f7, CropImageView.DEFAULT_ASPECT_RATIO);
                                f7 += f4;
                                f8 += f4;
                                f5 *= -1.0f;
                                f = f;
                                fIntBitsToFloat = fIntBitsToFloat;
                            }
                            f9 = fIntBitsToFloat;
                            f10 = CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        float f18 = f;
                        androidPath2.m472translatek4lQ0M((((long) Float.floatToRawIntBits(f10)) << c) | (((long) Float.floatToRawIntBits(f9 / 2.0f)) & 4294967295L));
                        androidPathMeasure.setPath(androidPath2);
                        float length2 = androidPathMeasure.internalPathMeasure.getLength();
                        Rect bounds = androidPath2.getBounds();
                        linearProgressDrawingCache.progressPathScale = length2 / ((bounds.right - bounds.left) + 1.0E-8f);
                        linearProgressDrawingCache.currentSize = jMo556getSizeNHjbRc;
                        linearProgressDrawingCache.currentWavelength = fMo81toPx0680j_4;
                        linearProgressDrawingCache.currentStroke = stroke;
                        linearProgressDrawingCache.currentTrackStroke = stroke2;
                        linearProgressDrawingCache.currentIndicatorTrackGapSize = f18;
                        z = true;
                    }
                } else {
                    f = fMo81toPx0680j_5;
                    f2 = 2.0f;
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jMo556getSizeNHjbRc & 4294967295L));
                    c = ' ';
                    fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo556getSizeNHjbRc >> 32));
                    int i3 = stroke.cap;
                    f3 = stroke.width;
                    linearProgressDrawingCache.currentStrokeCapWidth = ((i3 == 0 || stroke2.cap != 0) && fIntBitsToFloat <= fIntBitsToFloat2) ? Math.max(f3 / 2.0f, stroke2.width / 2.0f) : 0.0f;
                    androidPath2.rewind();
                    androidPath2.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    if (f16 == CropImageView.DEFAULT_ASPECT_RATIO) {
                        androidPath2.lineTo(fIntBitsToFloat2, CropImageView.DEFAULT_ASPECT_RATIO);
                        f9 = fIntBitsToFloat;
                        f10 = 0.0f;
                    } else {
                        f4 = fMo81toPx0680j_4 / 2.0f;
                        f5 = fIntBitsToFloat - f3;
                        f6 = (fMo81toPx0680j_4 * 2.0f) + fIntBitsToFloat2;
                        f7 = f4;
                        f8 = f4 / 2.0f;
                        while (f7 <= f6) {
                            androidPath2.internalPath.quadTo(f8, f5, f7, CropImageView.DEFAULT_ASPECT_RATIO);
                            f7 += f4;
                            f8 += f4;
                            f5 *= -1.0f;
                            f = f;
                            fIntBitsToFloat = fIntBitsToFloat;
                        }
                        f9 = fIntBitsToFloat;
                        f10 = CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    float f19 = f;
                    androidPath2.m472translatek4lQ0M((((long) Float.floatToRawIntBits(f10)) << c) | (((long) Float.floatToRawIntBits(f9 / 2.0f)) & 4294967295L));
                    androidPathMeasure.setPath(androidPath2);
                    float length3 = androidPathMeasure.internalPathMeasure.getLength();
                    Rect bounds2 = androidPath2.getBounds();
                    linearProgressDrawingCache.progressPathScale = length3 / ((bounds2.right - bounds2.left) + 1.0E-8f);
                    linearProgressDrawingCache.currentSize = jMo556getSizeNHjbRc;
                    linearProgressDrawingCache.currentWavelength = fMo81toPx0680j_4;
                    linearProgressDrawingCache.currentStroke = stroke;
                    linearProgressDrawingCache.currentTrackStroke = stroke2;
                    linearProgressDrawingCache.currentIndicatorTrackGapSize = f19;
                    z = true;
                }
                if (Size.m447equalsimpl0(linearProgressDrawingCache.currentSize, 9205357640488583168L)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("updateDrawPaths was called before updateFullPaths");
                } else {
                    AndroidPath[] androidPathArr2 = linearProgressDrawingCache.progressPathsToDraw;
                    androidPathArr2.getClass();
                    if (androidPathArr2.length == progressFractions.length / 2) {
                        if (z || !Arrays.equals(linearProgressDrawingCache.currentProgressFractions, progressFractions) || linearProgressDrawingCache.currentAmplitude != f16 || linearProgressDrawingCache.currentWaveOffset != floatValue) {
                            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (linearProgressDrawingCache.currentSize >> c));
                            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (linearProgressDrawingCache.currentSize & 4294967295L)) / f2;
                            float fMin = linearProgressDrawingCache.currentIndicatorTrackGapSize;
                            float f20 = fIntBitsToFloat3 - linearProgressDrawingCache.currentStrokeCapWidth;
                            androidPath.rewind();
                            androidPath.moveTo(f20, fIntBitsToFloat4);
                            AndroidPath[] androidPathArr3 = linearProgressDrawingCache.progressPathsToDraw;
                            androidPathArr3.getClass();
                            int length4 = androidPathArr3.length;
                            int i4 = 0;
                            boolean z2 = false;
                            while (i4 < length4) {
                                AndroidPath[] androidPathArr4 = linearProgressDrawingCache.progressPathsToDraw;
                                androidPathArr4.getClass();
                                androidPathArr4[i4].rewind();
                                int i5 = i4 * 2;
                                float f21 = progressFractions[i5];
                                float f22 = progressFractions[i5 + 1];
                                float f23 = f21 * fIntBitsToFloat3;
                                float f24 = f22 * fIntBitsToFloat3;
                                if (i4 == 0) {
                                    float f25 = linearProgressDrawingCache.currentStrokeCapWidth;
                                    fMin = f24 < f25 ? CropImageView.DEFAULT_ASPECT_RATIO : Math.min(f24 - f25, linearProgressDrawingCache.currentIndicatorTrackGapSize);
                                    z2 = f24 >= linearProgressDrawingCache.currentStrokeCapWidth;
                                }
                                float f26 = fIntBitsToFloat3;
                                float f27 = linearProgressDrawingCache.currentStrokeCapWidth;
                                float f28 = f26 - f27;
                                float f29 = f24 < f27 ? f27 : f24;
                                if (f29 > f28) {
                                    f29 = f28;
                                }
                                if (f23 >= f27) {
                                    f27 = f23;
                                }
                                if (f27 <= f28) {
                                    f28 = f27;
                                }
                                if (Math.abs(f22 - f21) > CropImageView.DEFAULT_ASPECT_RATIO) {
                                    float f30 = f16 == CropImageView.DEFAULT_ASPECT_RATIO ? CropImageView.DEFAULT_ASPECT_RATIO : linearProgressDrawingCache.currentWavelength * floatValue;
                                    float f31 = linearProgressDrawingCache.progressPathScale;
                                    AndroidPath[] androidPathArr5 = linearProgressDrawingCache.progressPathsToDraw;
                                    androidPathArr5.getClass();
                                    androidPathMeasure.getSegment((f28 + f30) * f31, f31 * (f29 + f30), androidPathArr5[i4]);
                                    AndroidPath[] androidPathArr6 = linearProgressDrawingCache.progressPathsToDraw;
                                    androidPathArr6.getClass();
                                    AndroidPath androidPath3 = androidPathArr6[i4];
                                    float[] fArrM507constructorimpl$default = Matrix.m507constructorimpl$default();
                                    Matrix.m514translateimpl(fArrM507constructorimpl$default, f30 > CropImageView.DEFAULT_ASPECT_RATIO ? -f30 : CropImageView.DEFAULT_ASPECT_RATIO, (f15 - f16) * fIntBitsToFloat4);
                                    if (f16 == f15) {
                                        f11 = f16;
                                    } else {
                                        f11 = f16;
                                        Matrix.m512scaleimpl(fArrM507constructorimpl$default, f15, f11);
                                    }
                                    android.graphics.Matrix matrix = androidPath3.mMatrix;
                                    if (matrix == null) {
                                        matrix = new android.graphics.Matrix();
                                        androidPath3.mMatrix = matrix;
                                    }
                                    ColorKt.m495setFromEL8BTi8(matrix, fArrM507constructorimpl$default);
                                    Path path = androidPath3.internalPath;
                                    android.graphics.Matrix matrix2 = androidPath3.mMatrix;
                                    matrix2.getClass();
                                    path.transform(matrix2);
                                } else {
                                    f11 = f16;
                                }
                                float f32 = z2 ? (linearProgressDrawingCache.currentStrokeCapWidth * f2) + fMin : fMin;
                                float f33 = f29 + f32;
                                if (f20 > f33) {
                                    androidPath.lineTo(Math.max(linearProgressDrawingCache.currentStrokeCapWidth, f33), fIntBitsToFloat4);
                                }
                                if (f24 > f23) {
                                    float fMax = Math.max(linearProgressDrawingCache.currentStrokeCapWidth, f28 - f32);
                                    androidPath.moveTo(fMax, fIntBitsToFloat4);
                                    f20 = fMax;
                                }
                                i4++;
                                f16 = f11;
                                fIntBitsToFloat3 = f26;
                                fMin = fMin;
                                f15 = 1.0f;
                            }
                            float f34 = f16;
                            float f35 = linearProgressDrawingCache.currentStrokeCapWidth;
                            if (f20 > f35) {
                                androidPath.lineTo(f35, fIntBitsToFloat4);
                            }
                            float[] fArr = linearProgressDrawingCache.currentProgressFractions;
                            fArr.getClass();
                            ArraysKt.copyInto$default(progressFractions, fArr, 14);
                            linearProgressDrawingCache.currentAmplitude = f34;
                            linearProgressDrawingCache.currentWaveOffset = floatValue;
                        }
                        float f36 = layoutNodeDrawScope.getLayoutDirection() == LayoutDirection.Ltr ? CropImageView.DEFAULT_ASPECT_RATIO : 180.0f;
                        long jMo555getCenterF1C5BW0 = canvasDrawScope.mo555getCenterF1C5BW0();
                        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
                        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                        emojiProcessor.getCanvas().save();
                        try {
                            ((DrawResult) emojiProcessor.mSpanFactory).m402rotateUv8p0NA(jMo555getCenterF1C5BW0, f36);
                            DrawScope.m548drawPathLG529CI$default(layoutNodeDrawScope, androidPath, determinateLinearWavyProgressNode.trackColor, CropImageView.DEFAULT_ASPECT_RATIO, determinateLinearWavyProgressNode.trackStroke, 52);
                            AndroidPath[] androidPathArr7 = linearProgressDrawingCache.progressPathsToDraw;
                            if (androidPathArr7 != null) {
                                for (AndroidPath androidPath4 : androidPathArr7) {
                                    DrawScope.m548drawPathLG529CI$default(layoutNodeDrawScope, androidPath4, determinateLinearWavyProgressNode.color, CropImageView.DEFAULT_ASPECT_RATIO, determinateLinearWavyProgressNode.stroke, 52);
                                }
                            }
                            Icons$Filled.m372drawStopIndicatorVnkRyUA(layoutNodeDrawScope, determinateLinearWavyProgressNode.getProgressFractions()[1], canvasDrawScope.mo556getSizeNHjbRc(), determinateLinearWavyProgressNode.stopSize, linearProgressDrawingCache.currentStrokeCapWidth, determinateLinearWavyProgressNode.trackStroke, determinateLinearWavyProgressNode.color);
                            return unit;
                        } finally {
                            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                        }
                    }
                    int length5 = progressFractions.length / 2;
                    AndroidPath[] androidPathArr8 = linearProgressDrawingCache.progressPathsToDraw;
                    androidPathArr8.getClass();
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(length5, "the given progress fraction pairs do not match the expected number of progress paths to draw. updateDrawPaths called with ", " pairs, while there are ", androidPathArr8.length, " expected progress paths."));
                }
                return null;
        }
    }
}
