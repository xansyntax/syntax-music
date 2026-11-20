package com.metrolist.music.ui.component;

import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.SweepGradient;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppNavigationKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LensController f$0;

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda6(LensController lensController, byte b) {
        this.$r8$classId = b;
        this.f$0 = lensController;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LensController lensController = this.f$0;
        switch (b) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                float fFloatValue = (((Number) lensController.press.getValue()).floatValue() * 0.014f) + 1.0f;
                reusableGraphicsLayerScope.setScaleX(fFloatValue);
                reusableGraphicsLayerScope.setScaleY(fFloatValue);
                break;
            case 1:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope2.getClass();
                float fFloatValue2 = ((Number) lensController.press.getValue()).floatValue();
                reusableGraphicsLayerScope2.setScaleX((((Number) lensController.stretch.getValue()).floatValue() * 0.12f) + (0.07f * fFloatValue2) + 1.0f);
                reusableGraphicsLayerScope2.setScaleY((fFloatValue2 * 0.05f) + 1.0f);
                break;
            case 2:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope3.getClass();
                float fFloatValue3 = ((Number) lensController.press.getValue()).floatValue();
                Animatable animatable = lensController.stretch;
                reusableGraphicsLayerScope3.setScaleX((((Number) animatable.getValue()).floatValue() * 0.22f) + (0.16f * fFloatValue3) + 1.0f);
                reusableGraphicsLayerScope3.setScaleY(((fFloatValue3 * 0.1f) + 1.0f) - (((Number) animatable.getValue()).floatValue() * 0.05f));
                reusableGraphicsLayerScope3.setTranslationY((-(reusableGraphicsLayerScope3.graphicsDensity.getDensity() * 3.0f)) * fFloatValue3);
                break;
            case 3:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.getClass();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                layoutNodeDrawScope.drawContent();
                float fFloatValue4 = ((Number) lensController.press.getValue()).floatValue();
                if (fFloatValue4 > 0.01f) {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) / 2.0f;
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L);
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) * 0.16f;
                    float f = 0.32f * fFloatValue4;
                    DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), f, Color.m483getColorSpaceimpl(-72057594037927936L))), new Color(0L)}), CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat2, 8), 0L, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 122);
                    DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(0L), new Color(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), f, Color.m483getColorSpaceimpl(-72057594037927936L)))}), Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) - fIntBitsToFloat2, Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)), 8), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) - fIntBitsToFloat2)) & 4294967295L) | (Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO) << 32), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 120);
                    DrawScope.m551drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, new LinearGradient(0L, 9187343241974906880L, CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.95f * fFloatValue4, Color.m483getColorSpaceimpl(-4294967296L))), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), fFloatValue4 * 0.1f, Color.m483getColorSpaceimpl(-4294967296L))), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f * fFloatValue4, Color.m483getColorSpaceimpl(-4294967296L)))}), null), 0L, 0L, jFloatToRawIntBits, CropImageView.DEFAULT_ASPECT_RATIO, new Stroke(layoutNodeDrawScope.mo81toPx0680j_4(1.8f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 214);
                    DrawScope.m551drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, new SweepGradient(9205357640488583168L, CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(-40558789220368384L), new Color(-158501473091584L), new Color(-31409095835648L), new Color(-40532774603456512L), new Color(-40558789220368384L)}), null), 0L, 0L, jFloatToRawIntBits, fFloatValue4 * 0.55f, new Stroke(layoutNodeDrawScope.mo81toPx0680j_4(2.2f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 198);
                }
                break;
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope4.getClass();
                float fFloatValue5 = (((Number) lensController.press.getValue()).floatValue() * 0.018f) + 1.0f;
                reusableGraphicsLayerScope4.setScaleX(fFloatValue5);
                reusableGraphicsLayerScope4.setScaleY(fFloatValue5);
                break;
        }
        return unit;
    }
}
