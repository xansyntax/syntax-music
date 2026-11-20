package androidx.compose.animation.core;

import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.internal.Lock;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda4;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda45;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.platform.AndroidFontResourceLoader;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.RealImageLoader;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArcSplineKt {
    public static final AnimationVector1D positiveInfinityBounds1D = new AnimationVector1D(Float.POSITIVE_INFINITY);
    public static final AnimationVector2D positiveInfinityBounds2D = new AnimationVector2D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector3D positiveInfinityBounds3D = new AnimationVector3D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector4D positiveInfinityBounds4D = new AnimationVector4D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector1D negativeInfinityBounds1D = new AnimationVector1D(Float.NEGATIVE_INFINITY);
    public static final AnimationVector2D negativeInfinityBounds2D = new AnimationVector2D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final AnimationVector3D negativeInfinityBounds3D = new AnimationVector3D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final AnimationVector4D negativeInfinityBounds4D = new AnimationVector4D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final float[] OurPercentCache = new float[91];
    public static final SystemBarStyle$Companion$$ExternalSyntheticLambda0 SeekableTransitionStateTotalDurationChanged = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(24);
    public static final TwoWayConverterImpl FloatToVector = new TwoWayConverterImpl(new SystemBarStyle$Companion$$ExternalSyntheticLambda0(25), new BorderKt$$ExternalSyntheticLambda1(13));
    public static final TwoWayConverterImpl IntToVector = new TwoWayConverterImpl(new SystemBarStyle$Companion$$ExternalSyntheticLambda0(26), new SystemBarStyle$Companion$$ExternalSyntheticLambda0(27));
    public static final TwoWayConverterImpl DpToVector = new TwoWayConverterImpl(new SystemBarStyle$Companion$$ExternalSyntheticLambda0(28), new SystemBarStyle$Companion$$ExternalSyntheticLambda0(29));
    public static final TwoWayConverterImpl DpOffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(1), new BorderKt$$ExternalSyntheticLambda1(2));
    public static final TwoWayConverterImpl SizeToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(3), new BorderKt$$ExternalSyntheticLambda1(4));
    public static final TwoWayConverterImpl OffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(5), new BorderKt$$ExternalSyntheticLambda1(6));
    public static final TwoWayConverterImpl IntOffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(7), new BorderKt$$ExternalSyntheticLambda1(8));
    public static final TwoWayConverterImpl IntSizeToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(9), new BorderKt$$ExternalSyntheticLambda1(10));
    public static final TwoWayConverterImpl RectToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(11), new BorderKt$$ExternalSyntheticLambda1(12));

    public static Animatable Animatable$default(float f) {
        return new Animatable(Float.valueOf(f), FloatToVector, Float.valueOf(0.01f), 8);
    }

    public static AnimationState AnimationState$default(float f, float f2, int i) {
        if ((i & 2) != 0) {
            f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return new AnimationState(FloatToVector, Float.valueOf(f), new AnimationVector1D(f2), Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    public static final void UpdateInitialAndTargetValues(Transition transition, Transition.TransitionAnimationState transitionAnimationState, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(867041821);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(transitionAnimationState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? gapComposer.changed(obj2) : gapComposer.changedInstance(obj2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? gapComposer.changed(finiteAnimationSpec) : gapComposer.changedInstance(finiteAnimationSpec) ? 16384 : 8192;
        }
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.skipToGroupEnd();
        } else if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core(obj, obj2, finiteAnimationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core(obj2, finiteAnimationSpec, null, null);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4(transition, transitionAnimationState, obj, obj2, finiteAnimationSpec, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0122 A[Catch: CancellationException -> 0x003d, TryCatch #3 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:50:0x010d, B:52:0x0122, B:54:0x0140, B:56:0x014a, B:57:0x0157, B:58:0x015c, B:59:0x015d), top: B:80:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0140 A[Catch: CancellationException -> 0x003d, TryCatch #3 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:50:0x010d, B:52:0x0122, B:54:0x0140, B:56:0x014a, B:57:0x0157, B:58:0x015c, B:59:0x015d), top: B:80:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x014a A[Catch: CancellationException -> 0x003d, TryCatch #3 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:50:0x010d, B:52:0x0122, B:54:0x0140, B:56:0x014a, B:57:0x0157, B:58:0x015c, B:59:0x015d), top: B:80:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x015d A[Catch: CancellationException -> 0x003d, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:50:0x010d, B:52:0x0122, B:54:0x0140, B:56:0x014a, B:57:0x0157, B:58:0x015c, B:59:0x015d), top: B:80:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x017f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public static final Object animate(AnimationState animationState, Animation animation, long j, Function1 function1, ContinuationImpl continuationImpl) {
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$4;
        Ref$ObjectRef ref$ObjectRef;
        AnimationState animationState2;
        AnimationState animationState3;
        Ref$ObjectRef ref$ObjectRef2;
        Object objWithFrameNanos;
        Function1 function2;
        Function1 function3;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        Object obj;
        TimePickerKt$$ExternalSyntheticLambda45 timePickerKt$$ExternalSyntheticLambda45;
        Object objWithFrameNanos2;
        Animation animation2 = animation;
        AndroidFontResourceLoader androidFontResourceLoader = AndroidFontResourceLoader.$$INSTANCE;
        if (continuationImpl instanceof SuspendAnimationKt$animate$4) {
            suspendAnimationKt$animate$4 = (SuspendAnimationKt$animate$4) continuationImpl;
            int i = suspendAnimationKt$animate$4.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                suspendAnimationKt$animate$4.label = i - Integer.MIN_VALUE;
            } else {
                suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuationImpl);
            }
        } else {
            suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuationImpl);
        }
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$5 = suspendAnimationKt$animate$4;
        Object obj2 = suspendAnimationKt$animate$5.result;
        int i2 = suspendAnimationKt$animate$5.label;
        byte b = 5;
        byte b2 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Object valueFromNanos = animation2.getValueFromNanos(0L);
            AnimationVector velocityVectorFromNanos = animation2.getVelocityVectorFromNanos(0L);
            ref$ObjectRef = new Ref$ObjectRef();
            if (j == Long.MIN_VALUE) {
                try {
                    animationState2 = animationState;
                    try {
                        CheckboxKt$$ExternalSyntheticLambda4 checkboxKt$$ExternalSyntheticLambda4 = new CheckboxKt$$ExternalSyntheticLambda4(ref$ObjectRef, valueFromNanos, animation2, velocityVectorFromNanos, animationState2, getDurationScale(suspendAnimationKt$animate$5.getContext()), function1);
                        ref$ObjectRef2 = ref$ObjectRef;
                        try {
                            suspendAnimationKt$animate$5.L$0 = animationState2;
                            suspendAnimationKt$animate$5.L$1 = animation2;
                            suspendAnimationKt$animate$5.L$2 = function1;
                            suspendAnimationKt$animate$5.L$3 = ref$ObjectRef2;
                            suspendAnimationKt$animate$5.label = 1;
                            if (!animation2.isInfinite()) {
                                objWithFrameNanos = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(new CodecsKt$$ExternalSyntheticLambda0(checkboxKt$$ExternalSyntheticLambda4, b), suspendAnimationKt$animate$5);
                            } else {
                                if (suspendAnimationKt$animate$5.getContext().get(androidFontResourceLoader) != null) {
                                    throw new ClassCastException();
                                }
                                objWithFrameNanos = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(checkboxKt$$ExternalSyntheticLambda4, suspendAnimationKt$animate$5);
                            }
                            if (objWithFrameNanos != coroutineSingletons) {
                                animationState3 = animationState2;
                                function2 = function1;
                                ref$ObjectRef = ref$ObjectRef2;
                            }
                            return coroutineSingletons;
                        } catch (CancellationException e) {
                            e = e;
                            animationState3 = animationState2;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        animationState3 = animationState2;
                        animationScope = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope != null) {
                            animationScope.isRunning$delegate.setValue(Boolean.FALSE);
                        }
                        animationScope2 = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope2 != null) {
                            animationState3.isRunning = false;
                        }
                        throw e;
                    }
                } catch (CancellationException e3) {
                    e = e3;
                    animationState2 = animationState;
                }
            } else {
                ref$ObjectRef2 = ref$ObjectRef;
                try {
                    AnimationScope animationScope3 = new AnimationScope(valueFromNanos, animation2.getTypeConverter(), velocityVectorFromNanos, j, animation2.getTargetValue(), j, new SuspendAnimationKt$$ExternalSyntheticLambda2(animationState, b2));
                    doAnimationFrameWithScale(animationScope3, j, getDurationScale(suspendAnimationKt$animate$5.getContext()), animation2, animationState, function1);
                    ref$ObjectRef2.element = animationScope3;
                    animationState3 = animationState;
                    animation2 = animation;
                    function3 = function1;
                    ref$ObjectRef = ref$ObjectRef2;
                    do {
                        obj = ref$ObjectRef.element;
                        obj.getClass();
                        if (((Boolean) ((AnimationScope) obj).isRunning$delegate.getValue()).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        timePickerKt$$ExternalSyntheticLambda45 = new TimePickerKt$$ExternalSyntheticLambda45(ref$ObjectRef, getDurationScale(suspendAnimationKt$animate$5.getContext()), animation2, animationState3, function3, (byte) 1);
                        suspendAnimationKt$animate$5.L$0 = animationState3;
                        suspendAnimationKt$animate$5.L$1 = animation2;
                        suspendAnimationKt$animate$5.L$2 = function3;
                        suspendAnimationKt$animate$5.L$3 = ref$ObjectRef;
                        suspendAnimationKt$animate$5.label = 2;
                        if (animation2.isInfinite()) {
                            objWithFrameNanos2 = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(new CodecsKt$$ExternalSyntheticLambda0(timePickerKt$$ExternalSyntheticLambda45, b), suspendAnimationKt$animate$5);
                        } else {
                            if (suspendAnimationKt$animate$5.getContext().get(androidFontResourceLoader) == null) {
                                throw new ClassCastException();
                            }
                            objWithFrameNanos2 = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(timePickerKt$$ExternalSyntheticLambda45, suspendAnimationKt$animate$5);
                        }
                    } while (objWithFrameNanos2 != coroutineSingletons);
                    return coroutineSingletons;
                } catch (CancellationException e4) {
                    e = e4;
                    animationState3 = animationState;
                }
            }
            ref$ObjectRef = ref$ObjectRef2;
            animationScope = (AnimationScope) ref$ObjectRef.element;
            if (animationScope != null) {
                animationScope.isRunning$delegate.setValue(Boolean.FALSE);
            }
            animationScope2 = (AnimationScope) ref$ObjectRef.element;
            if (animationScope2 != null && animationScope2.lastFrameTimeNanos == animationState3.lastFrameTimeNanos) {
                animationState3.isRunning = false;
            }
            throw e;
        }
        if (i2 != 1 && i2 != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ref$ObjectRef = suspendAnimationKt$animate$5.L$3;
        function2 = suspendAnimationKt$animate$5.L$2;
        animation2 = suspendAnimationKt$animate$5.L$1;
        animationState3 = suspendAnimationKt$animate$5.L$0;
        try {
            ResultKt.throwOnFailure(obj2);
        } catch (CancellationException e5) {
            e = e5;
        }
        function3 = function2;
        do {
            obj = ref$ObjectRef.element;
            obj.getClass();
            if (((Boolean) ((AnimationScope) obj).isRunning$delegate.getValue()).booleanValue()) {
                return Unit.INSTANCE;
            }
            timePickerKt$$ExternalSyntheticLambda45 = new TimePickerKt$$ExternalSyntheticLambda45(ref$ObjectRef, getDurationScale(suspendAnimationKt$animate$5.getContext()), animation2, animationState3, function3, (byte) 1);
            suspendAnimationKt$animate$5.L$0 = animationState3;
            suspendAnimationKt$animate$5.L$1 = animation2;
            suspendAnimationKt$animate$5.L$2 = function3;
            suspendAnimationKt$animate$5.L$3 = ref$ObjectRef;
            suspendAnimationKt$animate$5.label = 2;
            if (animation2.isInfinite()) {
                objWithFrameNanos2 = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(new CodecsKt$$ExternalSyntheticLambda0(timePickerKt$$ExternalSyntheticLambda45, b), suspendAnimationKt$animate$5);
            } else {
                if (suspendAnimationKt$animate$5.getContext().get(androidFontResourceLoader) == null) {
                    throw new ClassCastException();
                }
                objWithFrameNanos2 = Stack.getMonotonicFrameClock(suspendAnimationKt$animate$5.getContext()).withFrameNanos(timePickerKt$$ExternalSyntheticLambda45, suspendAnimationKt$animate$5);
            }
        } while (objWithFrameNanos2 != coroutineSingletons);
        return coroutineSingletons;
    }

    public static /* synthetic */ Object animate$default(float f, float f2, AnimationSpec animationSpec, Function2 function2, SuspendLambda suspendLambda, int i) {
        if ((i & 8) != 0) {
            animationSpec = spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
        }
        return animate(f, f2, CropImageView.DEFAULT_ASPECT_RATIO, animationSpec, function2, suspendLambda);
    }

    public static final Object animateDecay(AnimationState animationState, DecayAnimationSpecImpl decayAnimationSpecImpl, boolean z, Function1 function1, ContinuationImpl continuationImpl) {
        Object objAnimate = animate(animationState, new DecayAnimation(decayAnimationSpecImpl, animationState.typeConverter, animationState.value$delegate.getValue(), animationState.velocityVector), z ? animationState.lastFrameTimeNanos : Long.MIN_VALUE, function1, continuationImpl);
        return objAnimate == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimate : Unit.INSTANCE;
    }

    public static final InfiniteTransition.TransitionAnimationState animateFloat(InfiniteTransition infiniteTransition, float f, float f2, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        InfiniteTransition.TransitionAnimationState transitionAnimationState;
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = infiniteTransition.new TransitionAnimationState(fValueOf, fValueOf2, infiniteRepeatableSpec);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(infiniteRepeatableSpec);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            transitionAnimationState = transitionAnimationState2;
            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) fValueOf, (Object) transitionAnimationState, (Object) fValueOf2, (Object) infiniteRepeatableSpec, (byte) 1);
            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
            objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda63;
        } else {
            transitionAnimationState = transitionAnimationState2;
        }
        Stack.SideEffect((Function0) objRememberedValue2, gapComposer);
        boolean zChangedInstance2 = gapComposer.changedInstance(infiniteTransition);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(infiniteTransition, transitionAnimationState, (byte) 3);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Stack.DisposableEffect(transitionAnimationState, (Function1) objRememberedValue3, gapComposer);
        return transitionAnimationState;
    }

    public static final Object animateTo(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, ContinuationImpl continuationImpl) {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.typeConverter, animationState.value$delegate.getValue(), obj, animationState.velocityVector), z ? animationState.lastFrameTimeNanos : Long.MIN_VALUE, function1, continuationImpl);
        return objAnimate == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Float f, AnimationSpec animationSpec, boolean z, Function1 function1, ContinuationImpl continuationImpl, int i) {
        if ((i & 2) != 0) {
            animationSpec = spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 23);
        }
        return animateTo(animationState, f, animationSpec2, z2, function1, continuationImpl);
    }

    public static final float calculateTargetValue(DecayAnimationSpecImpl decayAnimationSpecImpl, float f, float f2) {
        FloatDecayAnimationSpec floatDecayAnimationSpec = decayAnimationSpecImpl.floatDecaySpec;
        AnimationVector1D animationVector1D = new AnimationVector1D(CropImageView.DEFAULT_ASPECT_RATIO);
        int size$animation_core = animationVector1D.getSize$animation_core();
        int i = 0;
        while (i < size$animation_core) {
            animationVector1D.set$animation_core(i, floatDecayAnimationSpec.getTargetValue(i == 0 ? f : 0.0f, i == 0 ? f2 : 0.0f));
            i++;
        }
        return animationVector1D.value;
    }

    public static final AnimationVector copy(AnimationVector animationVector) {
        AnimationVector animationVectorNewVector$animation_core = animationVector.newVector$animation_core();
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            animationVectorNewVector$animation_core.set$animation_core(i, animationVector.get$animation_core(i));
        }
        return animationVectorNewVector$animation_core;
    }

    public static AnimationState copy$default(AnimationState animationState, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = ((Number) animationState.value$delegate.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f2 = ((AnimationVector1D) animationState.velocityVector).value;
        }
        return new AnimationState(animationState.typeConverter, Float.valueOf(f), new AnimationVector1D(f2), animationState.lastFrameTimeNanos, animationState.finishedTimeNanos, animationState.isRunning);
    }

    public static final Transition.DeferredAnimation createDeferredAnimation(Transition transition, TwoWayConverterImpl twoWayConverterImpl, String str, Composer composer, int i, int i2) {
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData;
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        boolean zChanged = ((GapComposer) composer).changed(transition);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = transition.new DeferredAnimation(twoWayConverterImpl, str);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Transition.DeferredAnimation deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        boolean zChanged2 = gapComposer.changed(transition) | gapComposer.changedInstance(deferredAnimation);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, deferredAnimation, (byte) 7);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(deferredAnimation, (Function1) objRememberedValue2, gapComposer);
        if (transition.isSeeking() && (deferredAnimationData = (Transition.DeferredAnimation.DeferredAnimationData) deferredAnimation.data$delegate.getValue()) != null) {
            Transition transition2 = Transition.this;
            deferredAnimationData.animation.updateInitialAndTargetValue$animation_core(deferredAnimationData.targetValueByState.invoke(transition2.getSegment().getInitialState()), deferredAnimationData.targetValueByState.invoke(transition2.getSegment().getTargetState()), (FiniteAnimationSpec) deferredAnimationData.transitionSpec.invoke(transition2.getSegment()));
        }
        return deferredAnimation;
    }

    public static final Transition.TransitionAnimationState createTransitionAnimation(Transition transition, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, TwoWayConverterImpl twoWayConverterImpl, Composer composer, int i) {
        Object obj3;
        Object obj4;
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && ((GapComposer) composer).changed(transition)) || (i & 6) == 4;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (z2 || objRememberedValue == neverEqualPolicy) {
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                obj3 = obj2;
                AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj3);
                animationVector.reset$animation_core();
                obj4 = obj;
                Transition.TransitionAnimationState transitionAnimationState = transition.new TransitionAnimationState(obj4, animationVector, twoWayConverterImpl);
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(transitionAnimationState);
                objRememberedValue = transitionAnimationState;
            } catch (Throwable th) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        } else {
            obj4 = obj;
            obj3 = obj2;
        }
        Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) objRememberedValue;
        int i4 = (i >> 3) & 8;
        int i5 = i << 3;
        byte b = 9;
        UpdateInitialAndTargetValues(transition, transitionAnimationState2, obj4, obj3, finiteAnimationSpec, gapComposer, i2 | (i4 << 6) | (i5 & 896) | (i4 << 9) | (i5 & 7168) | (57344 & i5));
        if ((i3 <= 4 || !gapComposer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChanged = gapComposer.changed(transitionAnimationState2) | z;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionAnimationState2, b);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(transitionAnimationState2, (Function1) objRememberedValue2, gapComposer);
        return transitionAnimationState2;
    }

    public static final void doAnimationFrameWithScale(AnimationScope animationScope, long j, float f, Animation animation, AnimationState animationState, Function1 function1) {
        long durationNanos = f == CropImageView.DEFAULT_ASPECT_RATIO ? animation.getDurationNanos() : (long) ((j - animationScope.startTimeNanos) / f);
        animationScope.lastFrameTimeNanos = j;
        animationScope.value$delegate.setValue(animation.getValueFromNanos(durationNanos));
        animationScope.velocityVector = animation.getVelocityVectorFromNanos(durationNanos);
        if (animation.isFinishedFromNanos(durationNanos)) {
            animationScope.finishedTimeNanos = animationScope.lastFrameTimeNanos;
            animationScope.isRunning$delegate.setValue(Boolean.FALSE);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    public static DecayAnimationSpecImpl exponentialDecay$default(int i) {
        return new DecayAnimationSpecImpl(new FlingCalculator((i & 1) != 0 ? 1.0f : 1.8f));
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(Alignment.Companion.$$INSTANCE);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= CropImageView.DEFAULT_ASPECT_RATIO) {
            return scaleFactor;
        }
        PreconditionsKt.throwIllegalStateException("negative scale factor");
        return scaleFactor;
    }

    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static InfiniteRepeatableSpec m19infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, int i) {
        if ((i & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, repeatMode, j);
    }

    public static final InfiniteTransition rememberInfiniteTransition(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new InfiniteTransition();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) objRememberedValue;
        infiniteTransition.run$animation_core(0, gapComposer);
        return infiniteTransition;
    }

    public static final Transition rememberTransition(TagPayloadReader tagPayloadReader, String str, Composer composer, int i) {
        byte b = 6;
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && ((GapComposer) composer).changed(tagPayloadReader)) || (i & 6) == 4;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer.Companion.Empty;
        Continuation continuation = null;
        if (z2 || objRememberedValue == obj) {
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                Object transitionInstance = new TransitionInstance(tagPayloadReader, null, str);
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(transitionInstance);
                objRememberedValue = transitionInstance;
            } catch (Throwable th) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        Transition transition = (Transition) objRememberedValue;
        if (tagPayloadReader instanceof SeekableTransitionState) {
            gapComposer.startReplaceGroup(-1357398105);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Object obj2 = (CoroutineScope) objRememberedValue2;
            boolean zChangedInstance = gapComposer.changedInstance(obj2) | ((i2 > 4 && gapComposer.changed(tagPayloadReader)) || (i & 6) == 4);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj) {
                objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(tagPayloadReader, obj2, b);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(obj2, (Function1) objRememberedValue3, gapComposer);
            SeekableTransitionState seekableTransitionState = (SeekableTransitionState) tagPayloadReader;
            Object value = seekableTransitionState.currentState$delegate.getValue();
            Object value2 = seekableTransitionState.targetState$delegate.getValue();
            if ((i2 <= 4 || !gapComposer.changed(tagPayloadReader)) && (i & 6) != 4) {
                z = false;
            }
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (z || objRememberedValue4 == obj) {
                objRememberedValue4 = new RealImageLoader.AnonymousClass2(tagPayloadReader, continuation, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.LaunchedEffect(value, value2, (Function2) objRememberedValue4, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(-1356407283);
            transition.animateTo$animation_core(tagPayloadReader.getTargetState(), gapComposer, 0);
            gapComposer.end(false);
        }
        boolean zChanged = gapComposer.changed(transition);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == obj) {
            objRememberedValue5 = new ScrollState$$ExternalSyntheticLambda0((byte) 7, transition);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        Stack.DisposableEffect(transition, (Function1) objRememberedValue5, gapComposer);
        return transition;
    }

    public static SnapSpec snap$default() {
        return new SnapSpec(0);
    }

    public static SpringSpec spring$default(float f, float f2, Object obj, int i) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1500.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return new SpringSpec(f, f2, obj);
    }

    public static TweenSpec tween$default(int i, int i2, Easing easing, int i3) {
        if ((i3 & 1) != 0) {
            i = 300;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            easing = EasingKt.FastOutSlowInEasing;
        }
        return new TweenSpec(i, i2, easing);
    }

    public static final void updateState(AnimationScope animationScope, AnimationState animationState) {
        animationState.value$delegate.setValue(animationScope.value$delegate.getValue());
        AnimationVector animationVector = animationState.velocityVector;
        AnimationVector animationVector2 = animationScope.velocityVector;
        int size$animation_core = animationVector.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            animationVector.set$animation_core(i, animationVector2.get$animation_core(i));
        }
        animationState.finishedTimeNanos = animationScope.finishedTimeNanos;
        animationState.lastFrameTimeNanos = animationScope.lastFrameTimeNanos;
        animationState.isRunning = ((Boolean) animationScope.isRunning$delegate.getValue()).booleanValue();
    }

    public static final TransitionInstance updateTransition(Object obj, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new TransitionInstance(new MutableTransitionState(obj), null, str);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        TransitionInstance transitionInstance = (TransitionInstance) objRememberedValue;
        transitionInstance.animateTo$animation_core(obj, gapComposer, (i & 8) | 48 | (i & 14));
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new ScrollState$$ExternalSyntheticLambda0((byte) 8, transitionInstance);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(transitionInstance, (Function1) objRememberedValue2, gapComposer);
        return transitionInstance;
    }

    public static AnimationState copy$default(AnimationState animationState, Object obj, int i) {
        if ((i & 1) != 0) {
            obj = animationState.value$delegate.getValue();
        }
        return new AnimationState(animationState.typeConverter, obj, copy(animationState.velocityVector), animationState.lastFrameTimeNanos, (i & 8) != 0 ? animationState.finishedTimeNanos : Long.MIN_VALUE, animationState.isRunning);
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, SuspendLambda suspendLambda) {
        Float f4 = new Float(f);
        Float f5 = new Float(f2);
        Float f6 = new Float(f3);
        TwoWayConverterImpl twoWayConverterImpl = FloatToVector;
        Function1 function1 = twoWayConverterImpl.convertToVector;
        AnimationVector animationVectorNewVector$animation_core = (AnimationVector) function1.invoke(f6);
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = ((AnimationVector) function1.invoke(f4)).newVector$animation_core();
        }
        AnimationVector animationVector = animationVectorNewVector$animation_core;
        Object objAnimate = animate(new AnimationState(twoWayConverterImpl, f4, animationVector, 56), new TargetBasedAnimation(animationSpec, twoWayConverterImpl, f4, f5, animationVector), Long.MIN_VALUE, new SuspendAnimationKt$$ExternalSyntheticLambda6(function2, (byte) 0), suspendLambda);
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAnimate != coroutineSingletons) {
            objAnimate = unit;
        }
        return objAnimate == coroutineSingletons ? objAnimate : unit;
    }
}
