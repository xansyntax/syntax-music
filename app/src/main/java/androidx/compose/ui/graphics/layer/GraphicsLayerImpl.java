package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface GraphicsLayerImpl {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final ComposedModifierKt$$ExternalSyntheticLambda0 DefaultDrawBlock = new ComposedModifierKt$$ExternalSyntheticLambda0(6);
    }

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas canvas);

    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo559getAmbientShadowColor0d7_KjU();

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int mo560getBlendMode0nO6VwU();

    float getCameraDistance();

    BlendModeColorFilter getColorFilter();

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    int mo561getCompositingStrategyke2Ky5w();

    default boolean getHasDisplayList() {
        return true;
    }

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo562getSpotShadowColor0d7_KjU();

    float getTranslationX();

    float getTranslationY();

    void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2);

    void setAlpha(float f);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo563setAmbientShadowColor8_81llA(long j);

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    void mo564setBlendModes9anfk8(int i);

    void setCameraDistance(float f);

    void setClip(boolean z);

    void setColorFilter();

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    void mo565setCompositingStrategyWpw9cng(int i);

    /* JADX INFO: renamed from: setOutline-O0kMr_c, reason: not valid java name */
    void mo566setOutlineO0kMr_c(Outline outline, long j);

    void setOutsets(int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    void mo567setPivotOffsetk4lQ0M(long j);

    /* JADX INFO: renamed from: setPosition-H0pRuoY, reason: not valid java name */
    void mo568setPositionH0pRuoY(int i, int i2, long j);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX();

    void setRotationY();

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo569setSpotShadowColor8_81llA(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);
}
