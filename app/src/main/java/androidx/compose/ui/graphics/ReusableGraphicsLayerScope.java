package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReusableGraphicsLayerScope implements Density {
    public boolean clip;
    public int mutatedFields;
    public ColorKt outline;
    public RenderEffect renderEffect;
    public float rotationZ;
    public float shadowElevation;
    public float translationX;
    public float translationY;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float alpha = 1.0f;
    public long ambientShadowColor = -72057594037927936L;
    public long spotShadowColor = -72057594037927936L;
    public float cameraDistance = 8.0f;
    public long transformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
    public Shape shape = ColorKt.RectangleShape;
    public long size = 9205357640488583168L;
    public LayerOutsets outsets = LayerOutsets.Zero;
    public Density graphicsDensity = LifecyclesKt.Density$default();
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;
    public byte blendMode = 3;

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    public final void reset$1$1() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
        setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
        setShadowElevation(CropImageView.DEFAULT_ASPECT_RATIO);
        m515setAmbientShadowColor8_81llA(-72057594037927936L);
        m516setSpotShadowColor8_81llA(-72057594037927936L);
        if (this.rotationZ != CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mutatedFields |= 1024;
            this.rotationZ = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (this.cameraDistance != 8.0f) {
            this.mutatedFields |= 2048;
            this.cameraDistance = 8.0f;
        }
        m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.5f));
        setShape(ColorKt.RectangleShape);
        setClip(false);
        setRenderEffect(null);
        if (this.blendMode != 3) {
            this.mutatedFields |= 524288;
            this.blendMode = (byte) 3;
        }
        LayerOutsets layerOutsets = LayerOutsets.Zero;
        if (!Intrinsics.areEqual(this.outsets, layerOutsets)) {
            this.mutatedFields |= ByteChannelKt.CHANNEL_MAX_SIZE;
            this.outsets = layerOutsets;
        }
        this.size = 9205357640488583168L;
        this.outline = null;
        this.mutatedFields = 0;
    }

    public final void setAlpha(float f) {
        if (this.alpha == f) {
            return;
        }
        this.mutatedFields |= 4;
        this.alpha = f;
    }

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m515setAmbientShadowColor8_81llA(long j) {
        if (ULong.m1869equalsimpl0(this.ambientShadowColor, j)) {
            return;
        }
        this.mutatedFields |= 64;
        this.ambientShadowColor = j;
    }

    public final void setClip(boolean z) {
        if (this.clip != z) {
            this.mutatedFields |= 16384;
            this.clip = z;
        }
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.renderEffect, renderEffect)) {
            return;
        }
        this.mutatedFields |= 131072;
        this.renderEffect = renderEffect;
    }

    public final void setScaleX(float f) {
        if (this.scaleX == f) {
            return;
        }
        this.mutatedFields |= 1;
        this.scaleX = f;
    }

    public final void setScaleY(float f) {
        if (this.scaleY == f) {
            return;
        }
        this.mutatedFields |= 2;
        this.scaleY = f;
    }

    public final void setShadowElevation(float f) {
        if (this.shadowElevation == f) {
            return;
        }
        this.mutatedFields |= 32;
        this.shadowElevation = f;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.mutatedFields |= 8192;
        this.shape = shape;
    }

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m516setSpotShadowColor8_81llA(long j) {
        if (ULong.m1869equalsimpl0(this.spotShadowColor, j)) {
            return;
        }
        this.mutatedFields |= 128;
        this.spotShadowColor = j;
    }

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    public final void m517setTransformOrigin__ExYCQ(long j) {
        if (TransformOrigin.m519equalsimpl0(this.transformOrigin, j)) {
            return;
        }
        this.mutatedFields |= 4096;
        this.transformOrigin = j;
    }

    public final void setTranslationX(float f) {
        if (this.translationX == f) {
            return;
        }
        this.mutatedFields |= 8;
        this.translationX = f;
    }

    public final void setTranslationY(float f) {
        if (this.translationY == f) {
            return;
        }
        this.mutatedFields |= 16;
        this.translationY = f;
    }
}
