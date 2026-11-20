package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationState implements State {
    public long finishedTimeNanos;
    public boolean isRunning;
    public long lastFrameTimeNanos;
    public final TwoWayConverterImpl typeConverter;
    public final ParcelableSnapshotMutableState value$delegate;
    public AnimationVector velocityVector;

    public AnimationState(TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector, long j, long j2, boolean z) {
        AnimationVector animationVectorCopy;
        this.typeConverter = twoWayConverterImpl;
        this.value$delegate = Stack.mutableStateOf$default(obj);
        if (animationVector != null) {
            animationVectorCopy = ArcSplineKt.copy(animationVector);
        } else {
            animationVectorCopy = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
            animationVectorCopy.reset$animation_core();
        }
        this.velocityVector = animationVectorCopy;
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = j2;
        this.isRunning = z;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.convertFromVector.invoke(this.velocityVector);
    }

    public final String toString() {
        return "AnimationState(value=" + this.value$delegate.getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ")";
    }

    public /* synthetic */ AnimationState(TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector, int i) {
        this(twoWayConverterImpl, obj, (i & 4) != 0 ? null : animationVector, Long.MIN_VALUE, Long.MIN_VALUE, false);
    }
}
