package androidx.compose.material3.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import kotlin.ULong;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleHostView extends View {
    public static final int[] PressedState = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] RestingState = new int[0];
    public Boolean bounded;
    public Long lastRippleStateChangeTimeMillis;
    public RoomDatabase$$ExternalSyntheticLambda0 onInvalidateRipple;
    public ActivityCompat$$ExternalSyntheticLambda0 resetRippleRunnable;
    public UnprojectedRipple ripple;

    private final void setRippleState(boolean z) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        long jLongValue = jCurrentAnimationTimeMillis - (l != null ? l.longValue() : 0L);
        if (z || jLongValue >= 5) {
            int[] iArr = z ? PressedState : RestingState;
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda0 = new ActivityCompat$$ExternalSyntheticLambda0((byte) 4, (Object) this);
            this.resetRippleRunnable = activityCompat$$ExternalSyntheticLambda0;
            postDelayed(activityCompat$$ExternalSyntheticLambda0, 50L);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$1(RippleHostView rippleHostView) {
        UnprojectedRipple unprojectedRipple = rippleHostView.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        rippleHostView.resetRippleRunnable = null;
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m381addRippleKOepWvA(PressInteraction.Press press, boolean z, long j, int i, long j2, float f, RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0) {
        long j3 = press.pressPosition;
        if (this.ripple == null || !Boolean.valueOf(z).equals(this.bounded)) {
            UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z);
            setBackground(unprojectedRipple);
            this.ripple = unprojectedRipple;
            this.bounded = Boolean.valueOf(z);
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        unprojectedRipple2.getClass();
        this.onInvalidateRipple = roomDatabase$$ExternalSyntheticLambda0;
        m382setRipplePropertiesbiQXAtU(j, i, j2, f);
        if (z) {
            unprojectedRipple2.setHotspot(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (4294967295L & j3)));
        } else {
            unprojectedRipple2.setHotspot(unprojectedRipple2.getBounds().centerX(), unprojectedRipple2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda0 = this.resetRippleRunnable;
        if (activityCompat$$ExternalSyntheticLambda0 != null) {
            removeCallbacks(activityCompat$$ExternalSyntheticLambda0);
            ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda1 = this.resetRippleRunnable;
            activityCompat$$ExternalSyntheticLambda1.getClass();
            activityCompat$$ExternalSyntheticLambda1.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (isAttachedToWindow()) {
            super.draw(canvas);
        } else {
            disposeRipple();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = this.onInvalidateRipple;
        if (roomDatabase$$ExternalSyntheticLambda0 != null) {
            roomDatabase$$ExternalSyntheticLambda0.invoke();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* JADX INFO: renamed from: setRippleProperties-biQXAtU, reason: not valid java name */
    public final void m382setRipplePropertiesbiQXAtU(long j, int i, long j2, float f) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple == null) {
            return;
        }
        if (unprojectedRipple.getRadius() != i) {
            unprojectedRipple.setRadius(i);
        }
        if (Build.VERSION.SDK_INT < 28) {
            f *= 2.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        long jColor = ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), f, Color.m483getColorSpaceimpl(j2));
        Color color = unprojectedRipple.rippleColor;
        if (!(color == null ? false : ULong.m1869equalsimpl0(color.value, jColor))) {
            unprojectedRipple.rippleColor = new Color(jColor);
            unprojectedRipple.setColor(ColorStateList.valueOf(ColorKt.m498toArgb8_81llA(jColor)));
        }
        Rect rect = new Rect(0, 0, MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L))));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        unprojectedRipple.setBounds(rect);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
