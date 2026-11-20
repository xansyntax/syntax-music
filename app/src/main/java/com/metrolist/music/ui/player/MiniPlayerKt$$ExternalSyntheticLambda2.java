package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Animatable f$0;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda2(Animatable animatable, byte b) {
        this.$r8$classId = b;
        this.f$0 = animatable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Animatable animatable = this.f$0;
        switch (b) {
            case 0:
                ((Density) obj).getClass();
                return new IntOffset(((long) MathKt.roundToInt(((Number) animatable.getValue()).floatValue())) << 32);
            case 1:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setAlpha(((Number) animatable.getValue()).floatValue());
                return unit;
            case 2:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope2.getClass();
                reusableGraphicsLayerScope2.setAlpha(((Number) animatable.getValue()).floatValue());
                return unit;
            case 3:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope3.getClass();
                float fFloatValue = ((Number) animatable.getValue()).floatValue();
                reusableGraphicsLayerScope3.setAlpha(fFloatValue);
                reusableGraphicsLayerScope3.setTranslationY(reusableGraphicsLayerScope3.graphicsDensity.getDensity() * 14.0f * (1.0f - fFloatValue));
                return unit;
            case 4:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope4.getClass();
                float fFloatValue2 = ((Number) animatable.getValue()).floatValue();
                reusableGraphicsLayerScope4.setScaleX(fFloatValue2);
                reusableGraphicsLayerScope4.setScaleY(fFloatValue2);
                return unit;
            case 5:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope5 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope5.getClass();
                float fFloatValue3 = ((Number) animatable.getValue()).floatValue();
                reusableGraphicsLayerScope5.setScaleX(fFloatValue3);
                reusableGraphicsLayerScope5.setScaleY(fFloatValue3);
                return unit;
            case 6:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope6 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope6.getClass();
                reusableGraphicsLayerScope6.setAlpha(((Number) animatable.getValue()).floatValue());
                reusableGraphicsLayerScope6.setClip(true);
                return unit;
            case 7:
                ((Density) obj).getClass();
                return new IntOffset(((long) MathKt.roundToInt(((Number) animatable.getValue()).floatValue())) << 32);
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope7 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope7.getClass();
                reusableGraphicsLayerScope7.setScaleX(((Number) animatable.getValue()).floatValue());
                reusableGraphicsLayerScope7.setScaleY(((Number) animatable.getValue()).floatValue());
                return unit;
        }
    }
}
