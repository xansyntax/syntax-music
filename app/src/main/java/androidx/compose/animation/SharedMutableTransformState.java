package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.music.playback.DownloadUtil;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.time.MonotonicTimeSource;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedMutableTransformState {
    public final Lazy catchUpAlpha$delegate;
    public final Lazy catchUpScale$delegate;
    public final Lazy catchUpSlide$delegate;
    public final Lazy catchUpTransformOrigin$delegate;
    public final Lazy catchUpVeil$delegate;
    public MutableTransform mutableData;
    public AnimationVector1D scaleHandoffVelocity;
    public VelocityTracker scaleVelocityTracker;
    public AnimationVector2D slideHandoffVelocity;
    public final ParcelableSnapshotMutableState mutationPhase$delegate = Stack.mutableStateOf$default(MutationPhase.Idle);
    public final TransformScopeImpl transformScope = new TransformScopeImpl();
    public final long startTime = MonotonicTimeSource.read();
    public long lastVeil = 0;
    public float lastAlpha = 1.0f;
    public float lastScale = 1.0f;
    public long lastTransformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
    public long lastSlide = 0;
    public float activeTransitionAlpha = 1.0f;
    public float activeTransitionScale = 1.0f;
    public long activeTransitionSlide = 0;
    public long activeTransitionVeil = 0;
    public long activeTransitionTransformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
    public float initialManualAlpha = 1.0f;
    public float initialManualScale = 1.0f;
    public long initialManualVeil = 0;
    public long initialManualTransformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);

    /* JADX INFO: renamed from: androidx.compose.animation.SharedMutableTransformState$startCatchUp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public long J$0;
        public long J$1;
        public long J$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedMutableTransformState.this.startCatchUp(this);
        }
    }

    public SharedMutableTransformState() {
        ScrollKt$$ExternalSyntheticLambda0 scrollKt$$ExternalSyntheticLambda0 = new ScrollKt$$ExternalSyntheticLambda0((byte) 8);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.catchUpAlpha$delegate = ResultKt.lazy(lazyThreadSafetyMode, scrollKt$$ExternalSyntheticLambda0);
        this.catchUpScale$delegate = ResultKt.lazy(lazyThreadSafetyMode, new ScrollKt$$ExternalSyntheticLambda0((byte) 9));
        this.catchUpSlide$delegate = ResultKt.lazy(lazyThreadSafetyMode, new ScrollKt$$ExternalSyntheticLambda0((byte) 10));
        this.catchUpVeil$delegate = ResultKt.lazy(lazyThreadSafetyMode, new ScrollKt$$ExternalSyntheticLambda0((byte) 11));
        this.catchUpTransformOrigin$delegate = ResultKt.lazy(lazyThreadSafetyMode, new ScrollKt$$ExternalSyntheticLambda0((byte) 12));
        new ScrollState$$ExternalSyntheticLambda0((byte) 5, this);
    }

    public final MutationPhase getMutationPhase$animation() {
        return (MutationPhase) this.mutationPhase$delegate.getValue();
    }

    public final boolean isHandoffActive() {
        return getMutationPhase$animation() == MutationPhase.Handoff;
    }

    public final boolean isMutating() {
        return getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp || getMutationPhase$animation() == MutationPhase.MutatingCatchingUp || getMutationPhase$animation() == MutationPhase.Mutating;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x010c A[PHI: r9 r11 r13
      0x010c: PHI (r9v4 long) = (r9v2 long), (r9v5 long) binds: [B:38:0x0109, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x010c: PHI (r11v3 long) = (r11v1 long), (r11v4 long) binds: [B:38:0x0109, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x010c: PHI (r13v4 long) = (r13v2 long), (r13v5 long) binds: [B:38:0x0109, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x0127 A[PHI: r9 r11
      0x0127: PHI (r9v6 long) = (r9v4 long), (r9v7 long) binds: [B:41:0x0124, B:15:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0127: PHI (r11v5 long) = (r11v3 long), (r11v6 long) binds: [B:41:0x0124, B:15:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x0140 A[PHI: r9
      0x0140: PHI (r9v8 long) = (r9v6 long), (r9v9 long) binds: [B:44:0x013d, B:14:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0157  */
    /* JADX WARN: Code duplicated, block: B:51:0x015f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0170, code lost:
    
        if (kotlinx.coroutines.AwaitKt.coroutineScope(r1, r2) == r8) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startCatchUp(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        float f;
        long j;
        long j2;
        long j3;
        Animatable animatable;
        Float f2;
        Animatable animatable2;
        IntOffset intOffset;
        Animatable animatable3;
        Color color;
        Animatable animatable4;
        TransformOrigin transformOrigin;
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
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.mutationPhase$delegate;
        MutationPhase mutationPhase = MutationPhase.MutatingCatchingUp;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(obj);
                float f3 = this.activeTransitionAlpha;
                f = this.activeTransitionScale;
                long j4 = this.activeTransitionSlide;
                j = this.activeTransitionVeil;
                long j5 = this.activeTransitionTransformOrigin;
                TransformScopeImpl transformScopeImpl = this.transformScope;
                this.initialManualAlpha = transformScopeImpl.isAlphaMutated() ? transformScopeImpl._alpha.getFloatValue() : 1.0f;
                this.initialManualScale = transformScopeImpl.isScaleMutated() ? transformScopeImpl._scale.getFloatValue() : 1.0f;
                this.initialManualVeil = transformScopeImpl.isVeilMutated() ? ((Color) transformScopeImpl._veil.getValue()).value : 0L;
                this.initialManualTransformOrigin = ((Boolean) transformScopeImpl.isTransformOriginMutated$delegate.getValue()).booleanValue() ? ((TransformOrigin) transformScopeImpl._transformOrigin.getValue()).packedValue : ColorKt.TransformOrigin(0.5f, 0.5f);
                Animatable animatable5 = (Animatable) this.catchUpAlpha$delegate.getValue();
                Float f4 = new Float(f3);
                anonymousClass1.F$0 = f;
                anonymousClass1.J$0 = j4;
                anonymousClass1.J$1 = j;
                anonymousClass1.J$2 = j5;
                anonymousClass1.label = 1;
                if (animatable5.snapTo(f4, anonymousClass1) != coroutineSingletons) {
                    j2 = j4;
                    j3 = j5;
                    animatable = (Animatable) this.catchUpScale$delegate.getValue();
                    f2 = new Float(f);
                    anonymousClass1.J$0 = j2;
                    anonymousClass1.J$1 = j;
                    anonymousClass1.J$2 = j3;
                    anonymousClass1.label = 2;
                    if (animatable.snapTo(f2, anonymousClass1) != coroutineSingletons) {
                        animatable2 = (Animatable) this.catchUpSlide$delegate.getValue();
                        intOffset = new IntOffset(j2);
                        anonymousClass1.J$0 = j;
                        anonymousClass1.J$1 = j3;
                        anonymousClass1.label = 3;
                        if (animatable2.snapTo(intOffset, anonymousClass1) != coroutineSingletons) {
                            animatable3 = (Animatable) this.catchUpVeil$delegate.getValue();
                            color = new Color(j);
                            anonymousClass1.J$0 = j3;
                            anonymousClass1.label = 4;
                            if (animatable3.snapTo(color, anonymousClass1) != coroutineSingletons) {
                                animatable4 = (Animatable) this.catchUpTransformOrigin$delegate.getValue();
                                transformOrigin = new TransformOrigin(j3);
                                anonymousClass1.label = 5;
                                if (animatable4.snapTo(transformOrigin, anonymousClass1) != coroutineSingletons) {
                                    if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                                        parcelableSnapshotMutableState.setValue(mutationPhase);
                                        DownloadUtil.AnonymousClass2 anonymousClass2 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                                        anonymousClass1.label = 6;
                                        break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                }
                return coroutineSingletons;
            case 1:
                j3 = anonymousClass1.J$2;
                j = anonymousClass1.J$1;
                j2 = anonymousClass1.J$0;
                f = anonymousClass1.F$0;
                ResultKt.throwOnFailure(obj);
                animatable = (Animatable) this.catchUpScale$delegate.getValue();
                f2 = new Float(f);
                anonymousClass1.J$0 = j2;
                anonymousClass1.J$1 = j;
                anonymousClass1.J$2 = j3;
                anonymousClass1.label = 2;
                if (animatable.snapTo(f2, anonymousClass1) != coroutineSingletons) {
                    animatable2 = (Animatable) this.catchUpSlide$delegate.getValue();
                    intOffset = new IntOffset(j2);
                    anonymousClass1.J$0 = j;
                    anonymousClass1.J$1 = j3;
                    anonymousClass1.label = 3;
                    if (animatable2.snapTo(intOffset, anonymousClass1) != coroutineSingletons) {
                        animatable3 = (Animatable) this.catchUpVeil$delegate.getValue();
                        color = new Color(j);
                        anonymousClass1.J$0 = j3;
                        anonymousClass1.label = 4;
                        if (animatable3.snapTo(color, anonymousClass1) != coroutineSingletons) {
                            animatable4 = (Animatable) this.catchUpTransformOrigin$delegate.getValue();
                            transformOrigin = new TransformOrigin(j3);
                            anonymousClass1.label = 5;
                            if (animatable4.snapTo(transformOrigin, anonymousClass1) != coroutineSingletons) {
                                if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                                    parcelableSnapshotMutableState.setValue(mutationPhase);
                                    DownloadUtil.AnonymousClass2 anonymousClass3 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                                    anonymousClass1.label = 6;
                                    break;
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            case 2:
                j3 = anonymousClass1.J$2;
                j = anonymousClass1.J$1;
                j2 = anonymousClass1.J$0;
                ResultKt.throwOnFailure(obj);
                animatable2 = (Animatable) this.catchUpSlide$delegate.getValue();
                intOffset = new IntOffset(j2);
                anonymousClass1.J$0 = j;
                anonymousClass1.J$1 = j3;
                anonymousClass1.label = 3;
                if (animatable2.snapTo(intOffset, anonymousClass1) != coroutineSingletons) {
                    animatable3 = (Animatable) this.catchUpVeil$delegate.getValue();
                    color = new Color(j);
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.label = 4;
                    if (animatable3.snapTo(color, anonymousClass1) != coroutineSingletons) {
                        animatable4 = (Animatable) this.catchUpTransformOrigin$delegate.getValue();
                        transformOrigin = new TransformOrigin(j3);
                        anonymousClass1.label = 5;
                        if (animatable4.snapTo(transformOrigin, anonymousClass1) != coroutineSingletons) {
                            if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                                parcelableSnapshotMutableState.setValue(mutationPhase);
                                DownloadUtil.AnonymousClass2 anonymousClass4 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                                anonymousClass1.label = 6;
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutineSingletons;
            case 3:
                j3 = anonymousClass1.J$1;
                j = anonymousClass1.J$0;
                ResultKt.throwOnFailure(obj);
                animatable3 = (Animatable) this.catchUpVeil$delegate.getValue();
                color = new Color(j);
                anonymousClass1.J$0 = j3;
                anonymousClass1.label = 4;
                if (animatable3.snapTo(color, anonymousClass1) != coroutineSingletons) {
                    animatable4 = (Animatable) this.catchUpTransformOrigin$delegate.getValue();
                    transformOrigin = new TransformOrigin(j3);
                    anonymousClass1.label = 5;
                    if (animatable4.snapTo(transformOrigin, anonymousClass1) != coroutineSingletons) {
                        if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                            parcelableSnapshotMutableState.setValue(mutationPhase);
                            DownloadUtil.AnonymousClass2 anonymousClass5 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                            anonymousClass1.label = 6;
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutineSingletons;
            case 4:
                j3 = anonymousClass1.J$0;
                ResultKt.throwOnFailure(obj);
                animatable4 = (Animatable) this.catchUpTransformOrigin$delegate.getValue();
                transformOrigin = new TransformOrigin(j3);
                anonymousClass1.label = 5;
                if (animatable4.snapTo(transformOrigin, anonymousClass1) != coroutineSingletons) {
                    if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                        parcelableSnapshotMutableState.setValue(mutationPhase);
                        DownloadUtil.AnonymousClass2 anonymousClass6 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                        anonymousClass1.label = 6;
                        break;
                    }
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            case 5:
                ResultKt.throwOnFailure(obj);
                if (getMutationPhase$animation() == MutationPhase.MutatingPendingCatchUp) {
                    parcelableSnapshotMutableState.setValue(mutationPhase);
                    DownloadUtil.AnonymousClass2 anonymousClass7 = new DownloadUtil.AnonymousClass2((Object) this, (Continuation) null, (byte) 1);
                    anonymousClass1.label = 6;
                    break;
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                if (getMutationPhase$animation() == mutationPhase) {
                    parcelableSnapshotMutableState.setValue(MutationPhase.Mutating);
                }
                return Unit.INSTANCE;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
