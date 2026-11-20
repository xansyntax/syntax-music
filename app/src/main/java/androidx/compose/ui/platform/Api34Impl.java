package androidx.compose.ui.platform;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api34Impl {
    public static final MotionEvent obtainMotionEventWithClassification(long j, long j2, int i, int i2, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i3, int i4, float f, float f2, int i5, int i6, int i7, int i8, int i9) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j2, i, i2, pointerPropertiesArr, pointerCoordsArr, i3, i4, f, f2, i5, i6, i7, 0, i8, i9);
        motionEventObtain.getClass();
        return motionEventObtain;
    }
}
