package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import com.google.common.math.IntMath;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsImageCardKt$rememberAdjustedFontSize$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $calculatedFontSize$delegate;
    public final /* synthetic */ Density $density;
    public final /* synthetic */ long $initialFontSize;
    public final /* synthetic */ float $maxHeight;
    public final /* synthetic */ float $maxWidth;
    public final /* synthetic */ TextMeasurer $measurer;
    public final /* synthetic */ long $minFontSize;
    public final /* synthetic */ TextStyle $style;
    public final /* synthetic */ String $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsImageCardKt$rememberAdjustedFontSize$1$1(Density density, String str, long j, long j2, TextMeasurer textMeasurer, TextStyle textStyle, float f, float f2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$density = density;
        this.$text = str;
        this.$minFontSize = j;
        this.$initialFontSize = j2;
        this.$measurer = textMeasurer;
        this.$style = textStyle;
        this.$maxWidth = f;
        this.$maxHeight = f2;
        this.$calculatedFontSize$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LyricsImageCardKt$rememberAdjustedFontSize$1$1(this.$density, this.$text, this.$minFontSize, this.$initialFontSize, this.$measurer, this.$style, this.$maxWidth, this.$maxHeight, this.$calculatedFontSize$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        LyricsImageCardKt$rememberAdjustedFontSize$1$1 lyricsImageCardKt$rememberAdjustedFontSize$1$1 = (LyricsImageCardKt$rememberAdjustedFontSize$1$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        lyricsImageCardKt$rememberAdjustedFontSize$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        float f2;
        long j;
        long j2;
        ResultKt.throwOnFailure(obj);
        float f3 = this.$maxWidth;
        Density density = this.$density;
        float fMo81toPx0680j_4 = density.mo81toPx0680j_4(f3) * 0.92f;
        float fMo81toPx0680j_5 = density.mo81toPx0680j_4(this.$maxHeight) * 0.92f;
        String str = this.$text;
        boolean zIsBlank = StringsKt.isBlank(str);
        Unit unit = Unit.INSTANCE;
        long jPack = this.$minFontSize;
        MutableState mutableState = this.$calculatedFontSize$delegate;
        if (zIsBlank) {
            mutableState.setValue(new TextUnit(jPack));
            return unit;
        }
        int length = str.length();
        TextStyle textStyle = this.$style;
        long j3 = this.$initialFontSize;
        if (length < 20) {
            long jPack2 = IntMath.pack(4294967296L, TextUnit.m814getValueimpl(j3) * 1.1f);
            f = fMo81toPx0680j_4;
            f2 = fMo81toPx0680j_5;
            j = j3;
            j2 = 4294967296L;
            long j4 = TextMeasurer.m738measurexDpz5zY$default(this.$measurer, new AnnotatedString(str), TextStyle.m750copyp1EtxEg$default(textStyle, 0L, jPack2, null, null, null, null, 0L, 0L, null, null, 16777213), false, 0L, null, null, null, 2044).size;
            if (((int) (j4 >> 32)) <= f && ((int) (j4 & 4294967295L)) <= f2) {
                mutableState.setValue(new TextUnit(jPack2));
                return unit;
            }
        } else {
            f = fMo81toPx0680j_4;
            f2 = fMo81toPx0680j_5;
            j = j3;
            j2 = 4294967296L;
            if (str.length() < 30) {
                long jPack3 = IntMath.pack(4294967296L, TextUnit.m814getValueimpl(j) * 0.9f);
                long j5 = TextMeasurer.m738measurexDpz5zY$default(this.$measurer, new AnnotatedString(str), TextStyle.m750copyp1EtxEg$default(textStyle, 0L, jPack3, null, null, null, null, 0L, 0L, null, null, 16777213), false, 0L, null, null, null, 2044).size;
                if (((int) (j5 >> 32)) <= f && ((int) (j5 & 4294967295L)) <= f2) {
                    mutableState.setValue(new TextUnit(jPack3));
                    return unit;
                }
            }
        }
        float fM814getValueimpl = TextUnit.m814getValueimpl(jPack);
        int i = 0;
        float fM814getValueimpl2 = TextUnit.m814getValueimpl(j);
        float f4 = fM814getValueimpl;
        while (fM814getValueimpl <= fM814getValueimpl2 && i < 20) {
            int i2 = i + 1;
            float f5 = (fM814getValueimpl + fM814getValueimpl2) / 2.0f;
            float f6 = f4;
            long j6 = TextMeasurer.m738measurexDpz5zY$default(this.$measurer, new AnnotatedString(str), TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.pack(j2, f5), null, null, null, null, 0L, 0L, null, null, 16777213), false, 0L, null, null, null, 2044).size;
            if (((int) (j6 >> 32)) > f || ((int) (j6 & 4294967295L)) > f2) {
                fM814getValueimpl2 = f5 - 0.5f;
                f4 = f6;
            } else {
                fM814getValueimpl = f5 + 0.5f;
                f4 = f5;
            }
            i = i2;
            j2 = 4294967296L;
        }
        float f7 = f4;
        if (f7 >= TextUnit.m814getValueimpl(jPack)) {
            jPack = IntMath.pack(4294967296L, f7);
        }
        mutableState.setValue(new TextUnit(jPack));
        return unit;
    }
}
