package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect {
    public long containerSize;
    public final Density density;
    public final EdgeEffectWrapper edgeEffectWrapper;
    public final boolean invalidationEnabled;
    public final DelegatingNode node;
    public long pointerId;
    public long pointerPosition = 9205357640488583168L;
    public final ParcelableSnapshotMutableState redrawSignal;
    public boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, Density density, PaddingValuesImpl paddingValuesImpl) {
        this.density = density;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m498toArgb8_81llA(-43234558140743680L));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
        this.invalidationEnabled = true;
        this.containerSize = 0L;
        this.pointerId = -1L;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ScrimKt$Scrim$dismissModifier$1$1((byte) 1, this));
        this.node = Build.VERSION.SDK_INT >= 31 ? new StretchOverscrollNode(suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode, this, edgeEffectWrapper) : new GlowOverscrollNode(suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode, this, edgeEffectWrapper, paddingValuesImpl);
    }

    public final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0129, code lost:
    
        if (r4 == r6) goto L51;
     */
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m30applyToFlingBMRW4eQ(long j, Function2 function2, ContinuationImpl continuationImpl) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        float fAbsorbToRelaxIfNeeded;
        float fAbsorbToRelaxIfNeeded2;
        long jM821minusAH228Gc;
        if (continuationImpl instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuationImpl;
            int i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = i - Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuationImpl);
            }
        } else {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuationImpl);
        }
        Object objInvoke = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        int i2 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        Unit unit = Unit.INSTANCE;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            boolean zM449isEmptyimpl = Size.m449isEmptyimpl(this.containerSize);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (zM449isEmptyimpl) {
                Object velocity = new Velocity(j);
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
                if (function2.invoke(velocity, androidEdgeEffectOverscrollEffect$applyToFling$1) != obj) {
                    return unit;
                }
            } else {
                boolean zIsStretched = EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect);
                Density density = this.density;
                if (!zIsStretched || Velocity.m819getXimpl(j) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    fAbsorbToRelaxIfNeeded = (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect) || Velocity.m819getXimpl(j) <= CropImageView.DEFAULT_ASPECT_RATIO) ? 0.0f : -ImageKt.absorbToRelaxIfNeeded(edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.m819getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), density);
                } else {
                    fAbsorbToRelaxIfNeeded = ImageKt.absorbToRelaxIfNeeded(edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.m819getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), density);
                }
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect) || Velocity.m820getYimpl(j) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    fAbsorbToRelaxIfNeeded2 = (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect) || Velocity.m820getYimpl(j) <= CropImageView.DEFAULT_ASPECT_RATIO) ? 0.0f : -ImageKt.absorbToRelaxIfNeeded(edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.m820getYimpl(j), Float.intBitsToFloat((int) (this.containerSize & 4294967295L)), density);
                } else {
                    fAbsorbToRelaxIfNeeded2 = ImageKt.absorbToRelaxIfNeeded(edgeEffectWrapper.getOrCreateTopEffect(), Velocity.m820getYimpl(j), Float.intBitsToFloat((int) (this.containerSize & 4294967295L)), density);
                }
                long jVelocity = MathKt.Velocity(fAbsorbToRelaxIfNeeded, fAbsorbToRelaxIfNeeded2);
                if (jVelocity != 0) {
                    invalidateOverscroll$foundation();
                }
                jM821minusAH228Gc = Velocity.m821minusAH228Gc(j, jVelocity);
                Object velocity2 = new Velocity(jM821minusAH228Gc);
                androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = jM821minusAH228Gc;
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                objInvoke = function2.invoke(velocity2, androidEdgeEffectOverscrollEffect$applyToFling$1);
            }
            return obj;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objInvoke);
            return unit;
        }
        if (i2 != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        jM821minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
        ResultKt.throwOnFailure(objInvoke);
        long jM821minusAH228Gc2 = Velocity.m821minusAH228Gc(jM821minusAH228Gc, ((Velocity) objInvoke).packedValue);
        this.scrollCycleInProgress = false;
        if (Velocity.m819getXimpl(jM821minusAH228Gc2) > CropImageView.DEFAULT_ASPECT_RATIO) {
            EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
            int iRoundToInt = MathKt.roundToInt(Velocity.m819getXimpl(jM821minusAH228Gc2));
            if (Build.VERSION.SDK_INT >= 31 || orCreateLeftEffect.isFinished()) {
                orCreateLeftEffect.onAbsorb(iRoundToInt);
            }
        } else if (Velocity.m819getXimpl(jM821minusAH228Gc2) < CropImageView.DEFAULT_ASPECT_RATIO) {
            EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
            int i3 = -MathKt.roundToInt(Velocity.m819getXimpl(jM821minusAH228Gc2));
            if (Build.VERSION.SDK_INT >= 31 || orCreateRightEffect.isFinished()) {
                orCreateRightEffect.onAbsorb(i3);
            }
        }
        if (Velocity.m820getYimpl(jM821minusAH228Gc2) > CropImageView.DEFAULT_ASPECT_RATIO) {
            EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
            int iRoundToInt2 = MathKt.roundToInt(Velocity.m820getYimpl(jM821minusAH228Gc2));
            if (Build.VERSION.SDK_INT >= 31 || orCreateTopEffect.isFinished()) {
                orCreateTopEffect.onAbsorb(iRoundToInt2);
            }
        } else if (Velocity.m820getYimpl(jM821minusAH228Gc2) < CropImageView.DEFAULT_ASPECT_RATIO) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
            int i4 = -MathKt.roundToInt(Velocity.m820getYimpl(jM821minusAH228Gc2));
            if (Build.VERSION.SDK_INT >= 31 || orCreateBottomEffect.isFinished()) {
                orCreateBottomEffect.onAbsorb(i4);
            }
        }
        animateToReleaseIfNeeded();
        return unit;
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation, reason: not valid java name */
    public final long m31displacementF1C5BW0$foundation() {
        long jM881getCenteruvyYCjk = this.pointerPosition;
        if ((9223372034707292159L & jM881getCenteruvyYCjk) == 9205357640488583168L) {
            jM881getCenteruvyYCjk = FileSystemsKt.m881getCenteruvyYCjk(this.containerSize);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM881getCenteruvyYCjk >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jM881getCenteruvyYCjk & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final void invalidateOverscroll$foundation() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    public final boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect) : 0.0f) != CropImageView.DEFAULT_ASPECT_RATIO) {
                return true;
            }
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect2) : 0.0f) != CropImageView.DEFAULT_ASPECT_RATIO) {
                return true;
            }
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect3) : 0.0f) != CropImageView.DEFAULT_ASPECT_RATIO) {
                return true;
            }
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            return (Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect4) : 0.0f) != CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return false;
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    public final float m32pullBottomk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m31displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        float fOnPullDistance = -fIntBitsToFloat2;
        float f = 1.0f - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fOnPullDistance = Api31Impl.onPullDistance(orCreateBottomEffect, fOnPullDistance, f);
        } else {
            orCreateBottomEffect.onPull(fOnPullDistance, f);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateBottomEffect) : 0.0f) == CropImageView.DEFAULT_ASPECT_RATIO ? Float.intBitsToFloat((int) (4294967295L & this.containerSize)) * (-fOnPullDistance) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    public final float m33pullLeftk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m31displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        float f = 1.0f - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = Api31Impl.onPullDistance(orCreateLeftEffect, fIntBitsToFloat2, f);
        } else {
            orCreateLeftEffect.onPull(fIntBitsToFloat2, f);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateLeftEffect) : 0.0f) == CropImageView.DEFAULT_ASPECT_RATIO ? Float.intBitsToFloat((int) (this.containerSize >> 32)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    public final float m34pullRightk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m31displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        float fOnPullDistance = -fIntBitsToFloat2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fOnPullDistance = Api31Impl.onPullDistance(orCreateRightEffect, fOnPullDistance, fIntBitsToFloat);
        } else {
            orCreateRightEffect.onPull(fOnPullDistance, fIntBitsToFloat);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateRightEffect) : 0.0f) == CropImageView.DEFAULT_ASPECT_RATIO ? Float.intBitsToFloat((int) (this.containerSize >> 32)) * (-fOnPullDistance) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    public final float m35pullTopk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m31displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = Api31Impl.onPullDistance(orCreateTopEffect, fIntBitsToFloat2, fIntBitsToFloat);
        } else {
            orCreateTopEffect.onPull(fIntBitsToFloat2, fIntBitsToFloat);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateTopEffect) : 0.0f) == CropImageView.DEFAULT_ASPECT_RATIO ? Float.intBitsToFloat((int) (this.containerSize & 4294967295L)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation, reason: not valid java name */
    public final void m36updateSizeuvyYCjk$foundation(long j) {
        boolean zM447equalsimpl0 = Size.m447equalsimpl0(this.containerSize, 0L);
        boolean zM447equalsimpl1 = Size.m447equalsimpl0(j, this.containerSize);
        this.containerSize = j;
        if (!zM447equalsimpl1) {
            int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32)));
            long jRoundToInt = (((long) MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRoundToInt) << 32);
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            edgeEffectWrapper.size = jRoundToInt;
            EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
            if (edgeEffect != null) {
                edgeEffect.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
            if (edgeEffect2 != null) {
                edgeEffect2.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
            if (edgeEffect3 != null) {
                edgeEffect3.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
            if (edgeEffect4 != null) {
                edgeEffect4.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect5 = edgeEffectWrapper.topEffectNegation;
            if (edgeEffect5 != null) {
                edgeEffect5.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect6 = edgeEffectWrapper.bottomEffectNegation;
            if (edgeEffect6 != null) {
                edgeEffect6.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect7 = edgeEffectWrapper.leftEffectNegation;
            if (edgeEffect7 != null) {
                edgeEffect7.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect8 = edgeEffectWrapper.rightEffectNegation;
            if (edgeEffect8 != null) {
                edgeEffect8.setSize((int) (4294967295L & jRoundToInt), (int) (jRoundToInt >> 32));
            }
        }
        if (zM447equalsimpl0 || zM447equalsimpl1) {
            return;
        }
        animateToReleaseIfNeeded();
    }
}
