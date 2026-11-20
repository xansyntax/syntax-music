package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.gestures.AbstractScrollableNodeKt;
import androidx.compose.foundation.gestures.AbstractScrollableNodeKt$DefaultScrollMotionDurationScale$1;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.sqlite.SQLite;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    public final DecayAnimationSpecImpl decayAnimationSpec;
    public final AbstractScrollableNodeKt$DefaultScrollMotionDurationScale$1 motionScaleDuration = AbstractScrollableNodeKt.DefaultScrollMotionDurationScale;
    public final AnimationSpec snapAnimationSpec;
    public final SnapLayoutInfoProvider snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Function1 L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, CropImageView.DEFAULT_ASPECT_RATIO, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00261 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00261(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, CropImageView.DEFAULT_ASPECT_RATIO, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00271 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00271(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.tryApproach(null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, this);
        }
    }

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpecImpl decayAnimationSpecImpl, AnimationSpec animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpecImpl;
        this.snapAnimationSpec = animationSpec;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            if (Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(ScrollScope scrollScope, float f, Function1 function1, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Function1 function2;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(this, f, function1, scrollScope, null);
            anonymousClass1.L$0 = function1;
            anonymousClass1.label = 1;
            objWithContext = AwaitKt.withContext(this.motionScaleDuration, snapFlingBehavior$fling$result$1, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
            function2 = function1;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function2 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        AnimationResult animationResult = (AnimationResult) objWithContext;
        function2.invoke(new Float(CropImageView.DEFAULT_ASPECT_RATIO));
        return animationResult;
    }

    public final int hashCode() {
        return this.snapLayoutInfoProvider.hashCode() + ((this.decayAnimationSpec.hashCode() + (this.snapAnimationSpec.hashCode() * 31)) * 31);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performFling(ScrollScope scrollScope, float f, Function1 function1, ContinuationImpl continuationImpl) {
        C00261 c00261;
        if (continuationImpl instanceof C00261) {
            c00261 = (C00261) continuationImpl;
            int i = c00261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00261.label = i - Integer.MIN_VALUE;
            } else {
                c00261 = new C00261(continuationImpl);
            }
        } else {
            c00261 = new C00261(continuationImpl);
        }
        Object objFling = c00261.result;
        int i2 = c00261.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFling);
            c00261.label = 1;
            objFling = fling(scrollScope, f, function1, c00261);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFling == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        float fFloatValue = animationResult.remainingOffset.floatValue();
        AnimationState animationState = animationResult.currentAnimationState;
        float fFloatValue2 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (fFloatValue != CropImageView.DEFAULT_ASPECT_RATIO) {
            fFloatValue2 = ((Number) animationState.getVelocity()).floatValue();
        }
        return new Float(fFloatValue2);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object tryApproach(ScrollScope scrollScope, float f, float f2, SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0 snapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0, ContinuationImpl continuationImpl) {
        C00271 c00271;
        Object objAnimateDecay;
        if (continuationImpl instanceof C00271) {
            c00271 = (C00271) continuationImpl;
            int i = c00271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00271.label = i - Integer.MIN_VALUE;
            } else {
                c00271 = new C00271(continuationImpl);
            }
        } else {
            c00271 = new C00271(continuationImpl);
        }
        C00271 c00272 = c00271;
        Object obj = c00272.result;
        int i2 = c00272.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Math.abs(f) == CropImageView.DEFAULT_ASPECT_RATIO || Math.abs(f2) == CropImageView.DEFAULT_ASPECT_RATIO) {
                return ArcSplineKt.AnimationState$default(f, f2, 28);
            }
            c00272.label = 1;
            DecayAnimationSpecImpl decayAnimationSpecImpl = this.decayAnimationSpec;
            DrawResult drawResult = Math.abs(ArcSplineKt.calculateTargetValue(decayAnimationSpecImpl, CropImageView.DEFAULT_ASPECT_RATIO, f2)) >= Math.abs(f) ? new DrawResult((byte) 14, (Object) decayAnimationSpecImpl) : new DrawResult((byte) 15, (Object) this.snapAnimationSpec);
            Float f3 = new Float(f);
            Float f4 = new Float(f2);
            byte b = drawResult.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 14:
                    objAnimateDecay = SQLite.animateDecay(scrollScope, f3.floatValue(), ArcSplineKt.AnimationState$default(CropImageView.DEFAULT_ASPECT_RATIO, f4.floatValue(), 28), (DecayAnimationSpecImpl) drawResult.block, snapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0, c00272);
                    if (objAnimateDecay != coroutineSingletons) {
                        objAnimateDecay = (AnimationResult) objAnimateDecay;
                    }
                    break;
                default:
                    float fFloatValue = f3.floatValue();
                    float fFloatValue2 = f4.floatValue();
                    objAnimateDecay = SQLite.animateWithTarget(scrollScope, Math.signum(fFloatValue2) * Math.abs(fFloatValue), fFloatValue, ArcSplineKt.AnimationState$default(CropImageView.DEFAULT_ASPECT_RATIO, fFloatValue2, 28), (AnimationSpec) drawResult.block, snapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0, c00272);
                    if (objAnimateDecay != coroutineSingletons) {
                        objAnimateDecay = (AnimationResult) objAnimateDecay;
                    }
                    break;
            }
            obj = objAnimateDecay;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return ((AnimationResult) obj).currentAnimationState;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return performFling(scrollScope, f, ScrollableKt.NoOnReport, (ContinuationImpl) continuation);
    }
}
