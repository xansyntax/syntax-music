package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE = new PlatformMagnifierFactoryApi28Impl();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class PlatformMagnifierImpl implements PlatformMagnifier {
        public final Magnifier magnifier;

        public PlatformMagnifierImpl(Magnifier magnifier) {
            this.magnifier = magnifier;
        }

        public final void dismiss() {
            this.magnifier.dismiss();
        }

        /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
        public final long m55getSizeYbymL2g() {
            return (((long) this.magnifier.getWidth()) << 32) | (((long) this.magnifier.getHeight()) & 4294967295L);
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo53updateWko1d7g(long j, long j2, float f) {
            this.magnifier.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        }

        public final void updateContent() {
            this.magnifier.update();
        }
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public final PlatformMagnifier mo54createnHHXs2Y(View view, boolean z, long j, float f, float f2, boolean z2, Density density, float f3) {
        return new PlatformMagnifierImpl(new Magnifier(view));
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final boolean getCanUpdateZoom() {
        return false;
    }
}
