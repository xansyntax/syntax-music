package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public final void mo53updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                this.magnifier.setZoom(f);
            }
            long j3 = 9223372034707292159L & j2;
            Magnifier magnifier = this.magnifier;
            if (j3 != 9205357640488583168L) {
                magnifier.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
            } else {
                magnifier.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
            }
        }
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public final PlatformMagnifier mo54createnHHXs2Y(View view, boolean z, long j, float f, float f2, boolean z2, Density density, float f3) {
        if (z) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long jMo82toSizeXkaWNTQ = density.mo82toSizeXkaWNTQ(j);
        float fMo81toPx0680j_4 = density.mo81toPx0680j_4(f);
        float fMo81toPx0680j_5 = density.mo81toPx0680j_4(f2);
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jMo82toSizeXkaWNTQ != 9205357640488583168L) {
            builder.setSize(MathKt.roundToInt(Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ & 4294967295L))));
        }
        if (!Float.isNaN(fMo81toPx0680j_4)) {
            builder.setCornerRadius(fMo81toPx0680j_4);
        }
        if (!Float.isNaN(fMo81toPx0680j_5)) {
            builder.setElevation(fMo81toPx0680j_5);
        }
        if (!Float.isNaN(f3)) {
            builder.setInitialZoom(f3);
        }
        builder.setClippingEnabled(z2);
        return new PlatformMagnifierImpl(builder.build());
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final boolean getCanUpdateZoom() {
        return true;
    }
}
