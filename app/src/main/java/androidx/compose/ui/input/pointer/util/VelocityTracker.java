package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import coil3.memory.RealStrongMemoryCache;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.ArraysKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VelocityTracker {
    public final RealStrongMemoryCache platformVelocityTracker = new RealStrongMemoryCache();

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m594addPositionUv8p0NA(long j, long j2) {
        this.platformVelocityTracker.m857addPositionUv8p0NA(j, j2);
    }

    /* JADX INFO: renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m595calculateVelocity9UxMQ8M() {
        return m596calculateVelocityAH228Gc(MathKt.Velocity(Float.MAX_VALUE, Float.MAX_VALUE));
    }

    /* JADX INFO: renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
    public final long m596calculateVelocityAH228Gc(long j) {
        if (Velocity.m819getXimpl(j) <= CropImageView.DEFAULT_ASPECT_RATIO || Velocity.m820getYimpl(j) <= CropImageView.DEFAULT_ASPECT_RATIO) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=".concat(Velocity.m824toStringimpl(j)));
        }
        RealStrongMemoryCache realStrongMemoryCache = this.platformVelocityTracker;
        return MathKt.Velocity(((VelocityTracker1D) realStrongMemoryCache.weakMemoryCache).calculateVelocity(Velocity.m819getXimpl(j)), ((VelocityTracker1D) realStrongMemoryCache.cache).calculateVelocity(Velocity.m820getYimpl(j)));
    }

    public final void resetTracking() {
        RealStrongMemoryCache realStrongMemoryCache = this.platformVelocityTracker;
        VelocityTracker1D velocityTracker1D = (VelocityTracker1D) realStrongMemoryCache.weakMemoryCache;
        DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D.samples;
        ArraysKt.fill(0, dataPointAtTimeArr.length, null, dataPointAtTimeArr);
        velocityTracker1D.index = 0;
        VelocityTracker1D velocityTracker1D2 = (VelocityTracker1D) realStrongMemoryCache.cache;
        DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D2.samples;
        ArraysKt.fill(0, dataPointAtTimeArr2.length, null, dataPointAtTimeArr2);
        velocityTracker1D2.index = 0;
        realStrongMemoryCache.initialMaxSize = 0L;
    }
}
