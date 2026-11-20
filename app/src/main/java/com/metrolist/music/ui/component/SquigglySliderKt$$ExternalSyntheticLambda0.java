package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SquigglySliderKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ MutableState f$11;
    public final /* synthetic */ long f$7;
    public final /* synthetic */ long f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ SquigglySliderKt$$ExternalSyntheticLambda0(float f, float f2, long j, long j2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2) {
        this.f$0 = f;
        this.f$1 = f2;
        this.f$7 = j;
        this.f$8 = j2;
        this.f$9 = parcelableSnapshotMutableFloatState;
        this.f$11 = parcelableSnapshotMutableFloatState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        long j;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        char c = ' ';
        long j2 = 4294967295L;
        MutableState mutableState = this.f$11;
        float f = this.f$1;
        Object obj2 = this.f$9;
        float f2 = this.f$0;
        switch (b) {
            case 0:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj2;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = (ParcelableSnapshotMutableFloatState) mutableState;
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(3.0f);
                float f3 = 1.0f;
                float fCoerceIn = f2 > CropImageView.DEFAULT_ASPECT_RATIO ? UuidKt.coerceIn(f / f2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : 0.0f;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                float f4 = fIntBitsToFloat * fCoerceIn;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) / 2.0f;
                float fCoerceIn2 = fCoerceIn > 1.0f ? f4 : ((UuidKt.coerceIn(fCoerceIn / 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * 1.0f) + CropImageView.DEFAULT_ASPECT_RATIO) * fIntBitsToFloat;
                AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                float f5 = (-parcelableSnapshotMutableFloatState.getFloatValue()) - 40.0f;
                androidPathPath.moveTo(f5, fIntBitsToFloat2);
                float fSquigglySlider$lambda$15$0$0$computeAmplitude = MenuKt.SquigglySlider$lambda$15$0$0$computeAmplitude(fCoerceIn2, parcelableSnapshotMutableFloatState2, f5, 1.0f);
                float f6 = f5;
                while (f6 < fIntBitsToFloat) {
                    f3 = -f3;
                    char c2 = c;
                    float f7 = f6 + 40.0f;
                    float f8 = 20.0f + f6;
                    float fSquigglySlider$lambda$15$0$0$computeAmplitude2 = MenuKt.SquigglySlider$lambda$15$0$0$computeAmplitude(fCoerceIn2, parcelableSnapshotMutableFloatState2, f7, f3);
                    float f9 = fIntBitsToFloat2 + fSquigglySlider$lambda$15$0$0$computeAmplitude2;
                    androidPathPath.internalPath.cubicTo(f8, fIntBitsToFloat2 + fSquigglySlider$lambda$15$0$0$computeAmplitude, f8, f9, f7, f9);
                    fSquigglySlider$lambda$15$0$0$computeAmplitude = fSquigglySlider$lambda$15$0$0$computeAmplitude2;
                    f6 = f7;
                    c = c2;
                    j2 = j2;
                }
                char c3 = c;
                long j3 = j2;
                float f10 = CropImageView.DEFAULT_ASPECT_RATIO + fMo81toPx0680j_4;
                float f11 = fMo81toPx0680j_4 / 2.0f;
                long j4 = this.f$8;
                MenuKt.SquigglySlider$lambda$15$0$0$drawPathSegment(drawScope, fIntBitsToFloat2, f10, androidPathPath, fMo81toPx0680j_4, CropImageView.DEFAULT_ASPECT_RATIO, f4, j4);
                long j5 = this.f$7;
                MenuKt.SquigglySlider$lambda$15$0$0$drawPathSegment(drawScope, fIntBitsToFloat2, f10, androidPathPath, fMo81toPx0680j_4, f4, fIntBitsToFloat, j5);
                DrawScope.m543drawCircleVaOC9Bg$default(drawScope, j4, f11, (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << c3) | (((long) Float.floatToRawIntBits(MenuKt.SquigglySlider$lambda$15$0$0$getWaveY(f5, fCoerceIn2, fIntBitsToFloat2, parcelableSnapshotMutableFloatState2, CropImageView.DEFAULT_ASPECT_RATIO))) & j3), null, 0, 120);
                float fSquigglySlider$lambda$15$0$0$getWaveY = MenuKt.SquigglySlider$lambda$15$0$0$getWaveY(f5, fCoerceIn2, fIntBitsToFloat2, parcelableSnapshotMutableFloatState2, fIntBitsToFloat);
                float f12 = fIntBitsToFloat2 - f10;
                float f13 = fIntBitsToFloat + f11;
                float f14 = fIntBitsToFloat2 + f10;
                EmojiProcessor drawContext = drawScope.getDrawContext();
                long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    ((DrawResult) drawContext.mSpanFactory).m401clipRectN_I0leg(fIntBitsToFloat, f12, f13, f14, 1);
                    j = jM831getSizeNHjbRc;
                    try {
                        DrawScope.m543drawCircleVaOC9Bg$default(drawScope, j5, f11, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << c3) | (((long) Float.floatToRawIntBits(fSquigglySlider$lambda$15$0$0$getWaveY)) & j3), null, 0, 120);
                        drawContext.getCanvas().restore();
                        drawContext.m832setSizeuvyYCjk(j);
                        DrawScope.m543drawCircleVaOC9Bg$default(drawScope, j4, drawScope.mo81toPx0680j_4(6.0f), (((long) Float.floatToRawIntBits(f4)) << c3) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & j3), null, 0, 120);
                        return unit;
                    } catch (Throwable th) {
                        th = th;
                        IntIntPair$$ExternalSyntheticOutline0.m(drawContext, j);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j = jM831getSizeNHjbRc;
                }
                break;
            default:
                Animatable animatable = (Animatable) obj2;
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                long j6 = ((Boolean) mutableState.getValue()).booleanValue() ? this.f$7 : this.f$8;
                float fMo81toPx0680j_5 = drawScope2.mo81toPx0680j_4(f2);
                DrawScope.m552drawRoundRectuAw5IA$default(drawScope2, j6, (((long) Float.floatToRawIntBits(((Number) animatable.getValue()).floatValue())) & 4294967295L) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), (((long) Float.floatToRawIntBits(fMo81toPx0680j_5)) << 32) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_5)) & 4294967295L), null, 240);
                return unit;
        }
    }

    public /* synthetic */ SquigglySliderKt$$ExternalSyntheticLambda0(long j, long j2, float f, Animatable animatable, float f2, MutableState mutableState) {
        this.f$7 = j;
        this.f$8 = j2;
        this.f$0 = f;
        this.f$9 = animatable;
        this.f$1 = f2;
        this.f$11 = mutableState;
    }
}
