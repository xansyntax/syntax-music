package androidx.compose.ui.platform;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    default float getHandwritingGestureLineMargin() {
        return 16.0f;
    }

    default float getHandwritingSlop() {
        return 2.0f;
    }

    long getLongPressTimeoutMillis();

    default float getMaximumFlingVelocity() {
        return Float.MAX_VALUE;
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    default long mo649getMinimumTouchTargetSizeMYxV2XQ() {
        return UtilsKt.m890DpSizeYgX7TsA(48.0f, 48.0f);
    }

    float getTouchSlop();
}
