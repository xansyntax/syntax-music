package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.SynchronizedLazyImpl;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawablePainter extends Painter implements RememberObserver {
    public final Drawable drawable;
    public final ParcelableSnapshotMutableState drawableIntrinsicSize$delegate;
    public final ParcelableSnapshotMutableState drawInvalidateTick$delegate = Stack.mutableStateOf$default(0);
    public final SynchronizedLazyImpl callback$delegate = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 3, this));

    public DrawablePainter(Drawable drawable) {
        this.drawable = drawable;
        this.drawableIntrinsicSize$delegate = Stack.mutableStateOf$default(new Size(DrawablePainterKt.getIntrinsicSize(drawable)));
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.drawable.setAlpha(UuidKt.coerceIn(MathKt.roundToInt(f * 255.0f), 0, 255));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.drawable.setColorFilter(blendModeColorFilter != null ? blendModeColorFilter.nativeColorFilter : null);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        layoutDirection.getClass();
        int iOrdinal = layoutDirection.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
        } else {
            i = 0;
        }
        this.drawable.setLayoutDirection(i);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo573getIntrinsicSizeNHjbRc() {
        return ((Size) this.drawableIntrinsicSize$delegate.getValue()).packedValue;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        onForgotten();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
        ((Number) this.drawInvalidateTick$delegate.getValue()).intValue();
        try {
            canvas.save();
            int i = Build.VERSION.SDK_INT;
            Drawable drawable = this.drawable;
            if (i < 28 || i >= 31 || !(drawable instanceof AnimatedImageDrawable)) {
                drawable.setBounds(0, 0, MathKt.roundToInt(Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L))));
            } else {
                canvas.scale(Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() >> 32)) / Float.intBitsToFloat((int) (mo573getIntrinsicSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (mo573getIntrinsicSizeNHjbRc() & 4294967295L)));
            }
            android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            drawable.draw(((AndroidCanvas) canvas).internalCanvas);
        } finally {
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Drawable drawable = this.drawable;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        drawable.setVisible(false, false);
        drawable.setCallback(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        Drawable.Callback callback = (Drawable.Callback) this.callback$delegate.getValue();
        Drawable drawable = this.drawable;
        drawable.setCallback(callback);
        drawable.setVisible(true, true);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
