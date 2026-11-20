package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.music.playback.MusicService;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutItemAnimation {
    public final CoroutineScope coroutineScope;
    public FiniteAnimationSpec fadeInSpec;
    public FiniteAnimationSpec fadeOutSpec;
    public final GraphicsContext graphicsContext;
    public final ParcelableSnapshotMutableState isAppearanceAnimationInProgress$delegate;
    public final ParcelableSnapshotMutableState isDisappearanceAnimationFinished$delegate;
    public final ParcelableSnapshotMutableState isDisappearanceAnimationInProgress$delegate;
    public final ParcelableSnapshotMutableState isPlacementAnimationInProgress$delegate;
    public boolean isRunningMovingAwayAnimation;
    public GraphicsLayer layer;
    public long lookaheadOffset;
    public final SliderState$$ExternalSyntheticLambda0 onLayerPropertyChanged;
    public final ParcelableSnapshotMutableState placementDelta$delegate;
    public final Animatable placementDeltaAnimation;
    public long placementOffset;
    public FiniteAnimationSpec placementSpec;
    public long targetOffset;
    public final Animatable visibilityAnimation;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ LazyLayoutItemAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(LazyLayoutItemAnimation lazyLayoutItemAnimation, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = lazyLayoutItemAnimation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1(lazyLayoutItemAnimation, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1(lazyLayoutItemAnimation, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass1(lazyLayoutItemAnimation, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass1(lazyLayoutItemAnimation, continuation, (byte) 3);
                default:
                    return new AnonymousClass1(lazyLayoutItemAnimation, continuation, (byte) 4);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable = lazyLayoutItemAnimation.placementDeltaAnimation;
                        this.label = true;
                        return animatable.stop(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = lazyLayoutItemAnimation.visibilityAnimation;
                    Float f = new Float(1.0f);
                    this.label = true;
                    return animatable2.snapTo(f, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable3 = lazyLayoutItemAnimation.placementDeltaAnimation;
                        IntOffset intOffset = new IntOffset(0L);
                        this.label = true;
                        if (animatable3.snapTo(intOffset, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    lazyLayoutItemAnimation.m172setPlacementDeltagyyYBs(0L);
                    lazyLayoutItemAnimation.isPlacementAnimationInProgress$delegate.setValue(Boolean.FALSE);
                    return unit;
                case 3:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable4 = lazyLayoutItemAnimation.visibilityAnimation;
                        this.label = true;
                        return animatable4.stop(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable5 = lazyLayoutItemAnimation.visibilityAnimation;
                        this.label = true;
                        return animatable5.stop(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, SliderState$$ExternalSyntheticLambda0 sliderState$$ExternalSyntheticLambda0) {
        this.coroutineScope = coroutineScope;
        this.graphicsContext = graphicsContext;
        this.onLayerPropertyChanged = sliderState$$ExternalSyntheticLambda0;
        Boolean bool = Boolean.FALSE;
        this.isPlacementAnimationInProgress$delegate = Stack.mutableStateOf$default(bool);
        this.isAppearanceAnimationInProgress$delegate = Stack.mutableStateOf$default(bool);
        this.isDisappearanceAnimationInProgress$delegate = Stack.mutableStateOf$default(bool);
        this.isDisappearanceAnimationFinished$delegate = Stack.mutableStateOf$default(bool);
        this.targetOffset = 9223372034707292159L;
        this.placementOffset = 0L;
        this.lookaheadOffset = 9223372034707292159L;
        Object obj = null;
        this.layer = graphicsContext != null ? graphicsContext.createGraphicsLayer() : null;
        int i = 12;
        this.placementDeltaAnimation = new Animatable(new IntOffset(0L), ArcSplineKt.IntOffsetToVector, obj, i);
        this.visibilityAnimation = new Animatable(Float.valueOf(1.0f), ArcSplineKt.FloatToVector, obj, i);
        this.placementDelta$delegate = Stack.mutableStateOf$default(new IntOffset(0L));
    }

    public final void animateAppearance() {
        GraphicsLayer graphicsLayer = this.layer;
        FiniteAnimationSpec finiteAnimationSpec = this.fadeInSpec;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.isAppearanceAnimationInProgress$delegate;
        boolean zBooleanValue = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        CoroutineScope coroutineScope = this.coroutineScope;
        Continuation continuation = null;
        if (zBooleanValue || finiteAnimationSpec == null || graphicsLayer == null) {
            if (isDisappearanceAnimationInProgress()) {
                if (graphicsLayer != null) {
                    graphicsLayer.setAlpha(1.0f);
                }
                AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, (byte) 1), 3);
                return;
            }
            return;
        }
        parcelableSnapshotMutableState.setValue(Boolean.TRUE);
        boolean zIsDisappearanceAnimationInProgress = isDisappearanceAnimationInProgress();
        boolean z = !zIsDisappearanceAnimationInProgress;
        if (!zIsDisappearanceAnimationInProgress) {
            graphicsLayer.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        AwaitKt.launch$default(coroutineScope, null, null, new MusicService.AnonymousClass19(z, this, finiteAnimationSpec, graphicsLayer, (Continuation) null), 3);
    }

    public final boolean isDisappearanceAnimationInProgress() {
        return ((Boolean) this.isDisappearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    public final void release() {
        GraphicsContext graphicsContext;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.isPlacementAnimationInProgress$delegate;
        boolean zBooleanValue = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        byte b = 3;
        CoroutineScope coroutineScope = this.coroutineScope;
        byte b2 = 0;
        Continuation continuation = null;
        if (zBooleanValue) {
            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
            AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, b2), 3);
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.isAppearanceAnimationInProgress$delegate;
        if (((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue()) {
            parcelableSnapshotMutableState2.setValue(Boolean.FALSE);
            AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, b), 3);
        }
        if (isDisappearanceAnimationInProgress()) {
            this.isDisappearanceAnimationInProgress$delegate.setValue(Boolean.FALSE);
            AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, (byte) 4), 3);
        }
        this.isRunningMovingAwayAnimation = false;
        m172setPlacementDeltagyyYBs(0L);
        this.targetOffset = 9223372034707292159L;
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null && (graphicsContext = this.graphicsContext) != null) {
            graphicsContext.releaseGraphicsLayer(graphicsLayer);
        }
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m172setPlacementDeltagyyYBs(long j) {
        this.placementDelta$delegate.setValue(new IntOffset(j));
    }
}
