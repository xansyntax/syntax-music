package androidx.compose.animation.core;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.MutableObjectList;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.media3.extractor.flv.TagPayloadReader;
import androidx.navigation.NavBackStackEntry;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SeekableTransitionState extends TagPayloadReader {
    public final SeekableTransitionState$$ExternalSyntheticLambda1 animateOneFrameLambda;
    public Object composedTargetState;
    public CancellableContinuationImpl compositionContinuation;
    public final MutexImpl compositionContinuationMutex;
    public SeekingAnimationState currentAnimation;
    public final ParcelableSnapshotMutableState currentState$delegate;
    public float durationScale;
    public final SeekableTransitionState$$ExternalSyntheticLambda1 firstFrameLambda;
    public final ParcelableSnapshotMutableFloatState fraction$delegate;
    public final MutableObjectList initialValueAnimations;
    public long lastFrameTimeNanos;
    public final MutatorMutex mutatorMutex;
    public final SliderState$$ExternalSyntheticLambda0 recalculateTotalDurationNanos;
    public SnapshotStateObserver snapshotStateObserver;
    public final ParcelableSnapshotMutableState targetState$delegate;
    public long totalDurationNanos;
    public Transition transition;
    public static final AnimationVector1D ZeroVelocity = new AnimationVector1D(CropImageView.DEFAULT_ASPECT_RATIO);
    public static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SeekingAnimationState {
        public VectorizedFiniteAnimationSpec animationSpec;
        public long animationSpecDuration;
        public long durationNanos;
        public AnimationVector1D initialVelocity;
        public boolean isComplete;
        public long progressNanos;
        public final AnimationVector1D start = new AnimationVector1D(CropImageView.DEFAULT_ASPECT_RATIO);
        public float value;

        public final String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeekableTransitionState.this.runAnimations(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function1 {
        public final /* synthetic */ float $fraction;
        public final /* synthetic */ Object $oldTargetState;
        public final /* synthetic */ Object $targetState;
        public final /* synthetic */ Transition $transition;
        public boolean label;
        public final /* synthetic */ SeekableTransitionState this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 extends SuspendLambda implements Function2 {
            public final /* synthetic */ float $fraction;
            public final /* synthetic */ Object $oldTargetState;
            public final /* synthetic */ Object $targetState;
            public final /* synthetic */ Transition $transition;
            public /* synthetic */ Object L$0;
            public boolean label;
            public final /* synthetic */ SeekableTransitionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f, Continuation continuation) {
                super(2, continuation);
                this.$targetState = obj;
                this.$oldTargetState = obj2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z = this.label;
                Unit unit = Unit.INSTANCE;
                Continuation continuation = null;
                byte b = 1;
                SeekableTransitionState seekableTransitionState = this.this$0;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object obj2 = this.$targetState;
                    Object obj3 = this.$oldTargetState;
                    if (Intrinsics.areEqual(obj2, obj3)) {
                        seekableTransitionState.currentAnimation = null;
                        if (Intrinsics.areEqual(seekableTransitionState.currentState$delegate.getValue(), obj2)) {
                            return unit;
                        }
                    } else {
                        seekableTransitionState.moveAnimationToInitialState();
                    }
                    boolean zAreEqual = Intrinsics.areEqual(obj2, obj3);
                    float f = this.$fraction;
                    if (!zAreEqual) {
                        Transition transition = this.$transition;
                        transition.updateTarget$animation_core(obj2);
                        transition.setPlayTimeNanos(0L);
                        seekableTransitionState.targetState$delegate.setValue(obj2);
                        transition.resetAnimationFraction$animation_core(f);
                    }
                    seekableTransitionState.setFraction(f);
                    if (seekableTransitionState.initialValueAnimations.isNotEmpty()) {
                        AwaitKt.launch$default(coroutineScope, null, null, new SyncUtils.AnonymousClass2(seekableTransitionState, continuation, b), 3);
                    } else {
                        seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    this.label = true;
                    Object objWaitForCompositionAfterTargetStateChange = seekableTransitionState.waitForCompositionAfterTargetStateChange(this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWaitForCompositionAfterTargetStateChange == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                seekableTransitionState.seekToFraction();
                return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f, Continuation continuation) {
            super(1, continuation);
            this.$targetState = obj;
            this.$oldTargetState = obj2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((AnonymousClass3) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
                this.label = true;
                Object objCoroutineScope = AwaitKt.coroutineScope(anonymousClass1, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCoroutineScope == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00161 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00161(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeekableTransitionState.this.waitForComposition(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00171 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00171(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeekableTransitionState.this.waitForCompositionAfterTargetStateChange(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1] */
    public SeekableTransitionState(NavBackStackEntry navBackStackEntry) {
        super((byte) 1);
        final byte b = 1;
        this.targetState$delegate = Stack.mutableStateOf$default(navBackStackEntry);
        this.currentState$delegate = Stack.mutableStateOf$default(navBackStackEntry);
        this.composedTargetState = navBackStackEntry;
        this.recalculateTotalDurationNanos = new SliderState$$ExternalSyntheticLambda0((byte) 5, this);
        this.fraction$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
        this.compositionContinuationMutex = new MutexImpl();
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList();
        final byte b2 = 0;
        this.firstFrameLambda = new Function1(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1
            public final /* synthetic */ SeekableTransitionState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                SeekableTransitionState seekableTransitionState = this.f$0;
                long jLongValue = ((Long) obj).longValue();
                switch (b3) {
                    case 0:
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        break;
                    default:
                        long j = jLongValue - seekableTransitionState.lastFrameTimeNanos;
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        long jRoundToLong = MathKt.roundToLong(j / ((double) seekableTransitionState.durationScale));
                        MutableObjectList mutableObjectList = seekableTransitionState.initialValueAnimations;
                        if (mutableObjectList.isNotEmpty()) {
                            Object[] objArr = mutableObjectList.content;
                            int i = mutableObjectList._size;
                            int i2 = 0;
                            for (int i3 = 0; i3 < i; i3++) {
                                SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i3];
                                SeekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                                seekingAnimationState.isComplete = true;
                            }
                            Transition transition = seekableTransitionState.transition;
                            if (transition != null) {
                                transition.updateInitialValues$animation_core();
                            }
                            int i4 = mutableObjectList._size;
                            Object[] objArr2 = mutableObjectList.content;
                            IntRange intRangeUntil = UuidKt.until(0, i4);
                            int i5 = intRangeUntil.first;
                            int i6 = intRangeUntil.last;
                            if (i5 <= i6) {
                                while (true) {
                                    objArr2[i5 - i2] = objArr2[i5];
                                    if (((SeekableTransitionState.SeekingAnimationState) objArr2[i5]).isComplete) {
                                        i2++;
                                    }
                                    if (i5 != i6) {
                                        i5++;
                                    }
                                }
                            }
                            ArraysKt.fill(i4 - i2, i4, null, objArr2);
                            mutableObjectList._size -= i2;
                        }
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = seekableTransitionState.currentAnimation;
                        if (seekingAnimationState2 != null) {
                            seekingAnimationState2.durationNanos = seekableTransitionState.totalDurationNanos;
                            SeekableTransitionState.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                            seekableTransitionState.setFraction(seekingAnimationState2.value);
                            if (seekingAnimationState2.value == 1.0f) {
                                seekableTransitionState.currentAnimation = null;
                            }
                            seekableTransitionState.seekToFraction();
                        }
                        break;
                }
                return unit;
            }
        };
        this.animateOneFrameLambda = new Function1(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1
            public final /* synthetic */ SeekableTransitionState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b3 = b;
                Unit unit = Unit.INSTANCE;
                SeekableTransitionState seekableTransitionState = this.f$0;
                long jLongValue = ((Long) obj).longValue();
                switch (b3) {
                    case 0:
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        break;
                    default:
                        long j = jLongValue - seekableTransitionState.lastFrameTimeNanos;
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        long jRoundToLong = MathKt.roundToLong(j / ((double) seekableTransitionState.durationScale));
                        MutableObjectList mutableObjectList = seekableTransitionState.initialValueAnimations;
                        if (mutableObjectList.isNotEmpty()) {
                            Object[] objArr = mutableObjectList.content;
                            int i = mutableObjectList._size;
                            int i2 = 0;
                            for (int i3 = 0; i3 < i; i3++) {
                                SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i3];
                                SeekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                                seekingAnimationState.isComplete = true;
                            }
                            Transition transition = seekableTransitionState.transition;
                            if (transition != null) {
                                transition.updateInitialValues$animation_core();
                            }
                            int i4 = mutableObjectList._size;
                            Object[] objArr2 = mutableObjectList.content;
                            IntRange intRangeUntil = UuidKt.until(0, i4);
                            int i5 = intRangeUntil.first;
                            int i6 = intRangeUntil.last;
                            if (i5 <= i6) {
                                while (true) {
                                    objArr2[i5 - i2] = objArr2[i5];
                                    if (((SeekableTransitionState.SeekingAnimationState) objArr2[i5]).isComplete) {
                                        i2++;
                                    }
                                    if (i5 != i6) {
                                        i5++;
                                    }
                                }
                            }
                            ArraysKt.fill(i4 - i2, i4, null, objArr2);
                            mutableObjectList._size -= i2;
                        }
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = seekableTransitionState.currentAnimation;
                        if (seekingAnimationState2 != null) {
                            seekingAnimationState2.durationNanos = seekableTransitionState.totalDurationNanos;
                            SeekableTransitionState.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                            seekableTransitionState.setFraction(seekingAnimationState2.value);
                            if (seekingAnimationState2.value == 1.0f) {
                                seekableTransitionState.currentAnimation = null;
                            }
                            seekableTransitionState.seekToFraction();
                        }
                        break;
                }
                return unit;
            }
        };
    }

    public static void recalculateAnimationValue(SeekingAnimationState seekingAnimationState, long j) {
        long j2 = seekingAnimationState.progressNanos + j;
        seekingAnimationState.progressNanos = j2;
        long j3 = seekingAnimationState.animationSpecDuration;
        if (j2 >= j3) {
            seekingAnimationState.value = 1.0f;
            return;
        }
        VectorizedFiniteAnimationSpec vectorizedFiniteAnimationSpec = seekingAnimationState.animationSpec;
        AnimationVector1D animationVector1D = seekingAnimationState.start;
        if (vectorizedFiniteAnimationSpec == null) {
            float f = j2 / j3;
            seekingAnimationState.value = (f * 1.0f) + ((1.0f - f) * animationVector1D.get$animation_core(0));
            return;
        }
        AnimationVector1D animationVector1D2 = seekingAnimationState.initialVelocity;
        if (animationVector1D2 == null) {
            animationVector1D2 = ZeroVelocity;
        }
        seekingAnimationState.value = UuidKt.coerceIn(((AnimationVector1D) vectorizedFiniteAnimationSpec.getValueFromNanos(j2, animationVector1D, Target1, animationVector1D2)).get$animation_core(0), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public final Object animateOneFrame(ContinuationImpl continuationImpl) {
        float durationScale = ArcSplineKt.getDurationScale(continuationImpl.getContext());
        Unit unit = Unit.INSTANCE;
        if (durationScale <= CropImageView.DEFAULT_ASPECT_RATIO) {
            endAllAnimations();
            return unit;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = Stack.getMonotonicFrameClock(continuationImpl.getContext()).withFrameNanos(this.animateOneFrameLambda, continuationImpl);
        return objWithFrameNanos == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithFrameNanos : unit;
    }

    public final void endAllAnimations() {
        Transition transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Object getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    public final void moveAnimationToInitialState() {
        Transition transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos > 0) {
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.fraction$delegate;
                if (parcelableSnapshotMutableFloatState.getFloatValue() == 1.0f || Intrinsics.areEqual(this.currentState$delegate.getValue(), this.targetState$delegate.getValue())) {
                    seekingAnimationState = null;
                } else {
                    SeekingAnimationState seekingAnimationState2 = new SeekingAnimationState();
                    seekingAnimationState2.value = parcelableSnapshotMutableFloatState.getFloatValue();
                    long j = this.totalDurationNanos;
                    seekingAnimationState2.durationNanos = j;
                    seekingAnimationState2.animationSpecDuration = MathKt.roundToLong((1.0d - ((double) parcelableSnapshotMutableFloatState.getFloatValue())) * j);
                    seekingAnimationState2.start.set$animation_core(0, parcelableSnapshotMutableFloatState.getFloatValue());
                    seekingAnimationState = seekingAnimationState2;
                }
            } else {
                seekingAnimationState = null;
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.durationNanos = this.totalDurationNanos;
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runAnimations(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
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
        MutableObjectList mutableObjectList = this.initialValueAnimations;
        Unit unit = Unit.INSTANCE;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (mutableObjectList.isEmpty() && this.currentAnimation == null) {
                return unit;
            }
            if (ArcSplineKt.getDurationScale(anonymousClass1.getContext()) == CropImageView.DEFAULT_ASPECT_RATIO) {
                endAllAnimations();
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return unit;
            }
            if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
                anonymousClass1.label = 1;
                if (Stack.getMonotonicFrameClock(anonymousClass1.getContext()).withFrameNanos(this.firstFrameLambda, anonymousClass1) != obj2) {
                }
            }
            return obj2;
        }
        if (i2 != 1 && i2 != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        do {
            if (!mutableObjectList.isNotEmpty() && this.currentAnimation == null) {
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return unit;
            }
            anonymousClass1.label = 2;
        } while (animateOneFrame(anonymousClass1) != obj2);
        return obj2;
    }

    public final Object seekTo(float f, Object obj, SuspendLambda suspendLambda) {
        if (CropImageView.DEFAULT_ASPECT_RATIO > f || f > 1.0f) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition transition = this.transition;
        if (transition != null) {
            Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, new AnonymousClass3(obj, this.targetState$delegate.getValue(), this, transition, f, null), suspendLambda);
            if (objMutate$default == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return objMutate$default;
            }
        }
        return Unit.INSTANCE;
    }

    public final void seekToFraction() {
        Transition transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core(MathKt.roundToLong(((double) this.fraction$delegate.getFloatValue()) * ((Number) transition.totalDurationNanos$delegate.getValue()).longValue()));
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void setCurrentState$animation_core(Object obj) {
        this.currentState$delegate.setValue(obj);
    }

    public final void setFraction(float f) {
        this.fraction$delegate.setFloatValue(f);
    }

    public final void setSnapshotStateObserver$animation_core(SnapshotStateObserver snapshotStateObserver) {
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        if (Intrinsics.areEqual(this.snapshotStateObserver, snapshotStateObserver)) {
            return;
        }
        SnapshotStateObserver snapshotStateObserver2 = this.snapshotStateObserver;
        if (snapshotStateObserver2 != null) {
            snapshotStateObserver2.clear(this);
        }
        SnapshotStateObserver snapshotStateObserver3 = this.snapshotStateObserver;
        if (snapshotStateObserver3 != null && (onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = snapshotStateObserver3.applyUnsubscribe) != null) {
            onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
        }
        this.snapshotStateObserver = snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.start();
        }
        SnapshotStateObserver snapshotStateObserver4 = this.snapshotStateObserver;
        if (snapshotStateObserver4 != null) {
            snapshotStateObserver4.observeReads(this, ArcSplineKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void transitionConfigured$animation_core(Transition transition) {
        Transition transition2 = this.transition;
        if (transition2 != null && !transition.equals(transition2)) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void transitionRemoved$animation_core() {
        this.transition = null;
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.clear(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0075  */
    /* JADX WARN: Code duplicated, block: B:27:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitForComposition(ContinuationImpl continuationImpl) {
        C00161 c00161;
        Object value;
        Object obj;
        if (continuationImpl instanceof C00161) {
            c00161 = (C00161) continuationImpl;
            int i = c00161.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00161.label = i - Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuationImpl);
            }
        } else {
            c00161 = new C00161(continuationImpl);
        }
        Object obj2 = c00161.result;
        int i2 = c00161.label;
        MutexImpl mutexImpl = this.compositionContinuationMutex;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            value = this.targetState$delegate.getValue();
            c00161.L$0 = value;
            c00161.label = 1;
            if (mutexImpl.lock(c00161) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            Object obj3 = c00161.L$0;
            ResultKt.throwOnFailure(obj2);
            value = obj3;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            obj = c00161.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        if (Intrinsics.areEqual(obj2, obj)) {
            return Unit.INSTANCE;
        }
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        throw new CancellationException("targetState while waiting for composition");
        c00161.L$0 = value;
        c00161.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(c00161));
        cancellableContinuationImpl.initCancellability();
        this.compositionContinuation = cancellableContinuationImpl;
        mutexImpl.unlock(null);
        Object result = cancellableContinuationImpl.getResult();
        if (result != coroutineSingletons) {
            obj = value;
            obj2 = result;
            if (Intrinsics.areEqual(obj2, obj)) {
                return Unit.INSTANCE;
            }
            this.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("targetState while waiting for composition");
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0084, please report this as an issue */
    public final Object waitForCompositionAfterTargetStateChange(ContinuationImpl continuationImpl) {
        C00171 c00171;
        Object value;
        Object obj;
        if (continuationImpl instanceof C00171) {
            c00171 = (C00171) continuationImpl;
            int i = c00171.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00171.label = i - Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuationImpl);
            }
        } else {
            c00171 = new C00171(continuationImpl);
        }
        Object obj2 = c00171.result;
        int i2 = c00171.label;
        MutexImpl mutexImpl = this.compositionContinuationMutex;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            value = this.targetState$delegate.getValue();
            c00171.L$0 = value;
            c00171.label = 1;
            if (mutexImpl.lock(c00171) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            Object obj3 = c00171.L$0;
            ResultKt.throwOnFailure(obj2);
            value = obj3;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            obj = c00171.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        if (!Intrinsics.areEqual(obj2, obj)) {
            this.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
        }
        return Unit.INSTANCE;
        if (!Intrinsics.areEqual(value, this.composedTargetState)) {
            c00171.L$0 = value;
            c00171.label = 2;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(c00171));
            cancellableContinuationImpl.initCancellability();
            this.compositionContinuation = cancellableContinuationImpl;
            mutexImpl.unlock(null);
            Object result = cancellableContinuationImpl.getResult();
            if (result != coroutineSingletons) {
                obj = value;
                obj2 = result;
                if (!Intrinsics.areEqual(obj2, obj)) {
                    this.lastFrameTimeNanos = Long.MIN_VALUE;
                    throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
                }
            }
            return coroutineSingletons;
        }
        mutexImpl.unlock(null);
        return Unit.INSTANCE;
    }
}
