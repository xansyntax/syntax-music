package androidx.compose.animation;

import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.layout.IntrinsicSizeModifier;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.SingleLocalMap;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.sqlite.SQLite;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionModifierNode extends IntrinsicSizeModifier implements LayoutAwareModifierNode, ModifierLocalModifierNode {
    public Alignment currentAlignment;
    public EnterTransitionImpl enter;
    public ExitTransitionImpl exit;
    public EnterExitTransitionKt$$ExternalSyntheticLambda7 graphicsLayerBlock;
    public Function0 isEnabled;
    public long lookaheadSize;
    public SharedMutableTransformState mutableTransformState;
    public Transition.DeferredAnimation offsetAnimation;
    public final SingleLocalMap providedValues;
    public Transition.DeferredAnimation sizeAnimation;
    public final EnterExitTransitionModifierNode$$ExternalSyntheticLambda0 sizeTransitionSpec;
    public Transition.DeferredAnimation slideAnimation;
    public final EnterExitTransitionModifierNode$$ExternalSyntheticLambda0 slideSpec;
    public TransitionInstance transition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda0] */
    public EnterExitTransitionModifierNode(TransitionInstance transitionInstance, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, SharedMutableTransformState sharedMutableTransformState, Function0 function0, EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda7) {
        super((byte) 1);
        final byte b = 1;
        this.transition = transitionInstance;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransitionImpl;
        this.exit = exitTransitionImpl;
        this.isEnabled = function0;
        this.graphicsLayerBlock = enterExitTransitionKt$$ExternalSyntheticLambda7;
        this.mutableTransformState = sharedMutableTransformState;
        SingleLocalMap singleLocalMap = new SingleLocalMap();
        singleLocalMap.value$delegate.setValue(sharedMutableTransformState);
        this.providedValues = singleLocalMap;
        this.lookaheadSize = -9223372034707292160L;
        final byte b2 = 0;
        ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        this.sizeTransitionSpec = new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda0
            public final /* synthetic */ EnterExitTransitionModifierNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                FiniteAnimationSpec finiteAnimationSpec;
                FiniteAnimationSpec finiteAnimationSpec2;
                byte b3 = b2;
                EnterExitState enterExitState = EnterExitState.PostExit;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                EnterExitState enterExitState3 = EnterExitState.PreEnter;
                EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                Transition.Segment segment = (Transition.Segment) obj;
                switch (b3) {
                    case 0:
                        boolean zIsTransitioningTo = segment.isTransitioningTo(enterExitState3, enterExitState2);
                        Object obj2 = null;
                        if (zIsTransitioningTo) {
                            ChangeSizeConfig changeSizeConfig = enterExitTransitionModifierNode.enter.config.changeSize;
                            if (changeSizeConfig != null) {
                                obj2 = changeSizeConfig.animationSpec;
                            }
                        } else if (segment.isTransitioningTo(enterExitState2, enterExitState)) {
                            ChangeSizeConfig changeSizeConfig2 = enterExitTransitionModifierNode.exit.config.changeSize;
                            if (changeSizeConfig2 != null) {
                                obj2 = changeSizeConfig2.animationSpec;
                            }
                        } else {
                            obj2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                        }
                        return obj2 == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : obj2;
                    default:
                        if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                            SlideConfig slideConfig = enterExitTransitionModifierNode.enter.config.slide;
                            return (slideConfig == null || (finiteAnimationSpec2 = slideConfig.animationSpec) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : finiteAnimationSpec2;
                        }
                        if (!segment.isTransitioningTo(enterExitState2, enterExitState)) {
                            return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        SlideConfig slideConfig2 = enterExitTransitionModifierNode.exit.config.slide;
                        return (slideConfig2 == null || (finiteAnimationSpec = slideConfig2.animationSpec) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : finiteAnimationSpec;
                }
            }
        };
        this.slideSpec = new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda0
            public final /* synthetic */ EnterExitTransitionModifierNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                FiniteAnimationSpec finiteAnimationSpec;
                FiniteAnimationSpec finiteAnimationSpec2;
                byte b3 = b;
                EnterExitState enterExitState = EnterExitState.PostExit;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                EnterExitState enterExitState3 = EnterExitState.PreEnter;
                EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                Transition.Segment segment = (Transition.Segment) obj;
                switch (b3) {
                    case 0:
                        boolean zIsTransitioningTo = segment.isTransitioningTo(enterExitState3, enterExitState2);
                        Object obj2 = null;
                        if (zIsTransitioningTo) {
                            ChangeSizeConfig changeSizeConfig = enterExitTransitionModifierNode.enter.config.changeSize;
                            if (changeSizeConfig != null) {
                                obj2 = changeSizeConfig.animationSpec;
                            }
                        } else if (segment.isTransitioningTo(enterExitState2, enterExitState)) {
                            ChangeSizeConfig changeSizeConfig2 = enterExitTransitionModifierNode.exit.config.changeSize;
                            if (changeSizeConfig2 != null) {
                                obj2 = changeSizeConfig2.animationSpec;
                            }
                        } else {
                            obj2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                        }
                        return obj2 == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : obj2;
                    default:
                        if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                            SlideConfig slideConfig = enterExitTransitionModifierNode.enter.config.slide;
                            return (slideConfig == null || (finiteAnimationSpec2 = slideConfig.animationSpec) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : finiteAnimationSpec2;
                        }
                        if (!segment.isTransitioningTo(enterExitState2, enterExitState)) {
                            return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        SlideConfig slideConfig2 = enterExitTransitionModifierNode.exit.config.slide;
                        return (slideConfig2 == null || (finiteAnimationSpec = slideConfig2.animationSpec) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : finiteAnimationSpec;
                }
            }
        };
    }

    public final Alignment getAlignment() {
        Alignment alignment;
        Alignment alignment2;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSizeConfig changeSizeConfig = this.enter.config.changeSize;
            if (changeSizeConfig != null && (alignment2 = changeSizeConfig.alignment) != null) {
                return alignment2;
            }
            ChangeSizeConfig changeSizeConfig2 = this.exit.config.changeSize;
            if (changeSizeConfig2 != null) {
                return changeSizeConfig2.alignment;
            }
            return null;
        }
        ChangeSizeConfig changeSizeConfig3 = this.exit.config.changeSize;
        if (changeSizeConfig3 != null && (alignment = changeSizeConfig3.alignment) != null) {
            return alignment;
        }
        ChangeSizeConfig changeSizeConfig4 = this.enter.config.changeSize;
        if (changeSizeConfig4 != null) {
            return changeSizeConfig4.alignment;
        }
        return null;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final SQLite getProvidedValues() {
        return this.providedValues;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate2;
        TransformOrigin transformOrigin;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate3;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate4;
        long j2;
        long j3;
        IntOffset intOffset;
        long j4;
        final Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate5;
        if (this.transition.transitionState.getCurrentState() == this.transition.targetState$delegate.getValue()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.Companion.TopStart;
            }
            this.currentAlignment = alignment;
        }
        boolean zIsLookingAhead = measureScope.isLookingAhead();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsLookingAhead) {
            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
            long j5 = (((long) placeableMo598measureBRTryo0.width) << 32) | (((long) placeableMo598measureBRTryo0.height) & 4294967295L);
            this.lookaheadSize = j5;
            return measureScope.layout((int) (j5 >> 32), (int) (j5 & 4294967295L), emptyMap, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 2));
        }
        if (!((Boolean) this.isEnabled.invoke()).booleanValue()) {
            Placeable placeableMo598measureBRTryo1 = measurable.mo598measureBRTryo0(j);
            return measureScope.layout(placeableMo598measureBRTryo1.width, placeableMo598measureBRTryo1.height, emptyMap, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo1, (byte) 3));
        }
        EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda7 = this.graphicsLayerBlock;
        Transition.DeferredAnimation deferredAnimation = enterExitTransitionKt$$ExternalSyntheticLambda7.f$0;
        SharedMutableTransformState sharedMutableTransformState = enterExitTransitionKt$$ExternalSyntheticLambda7.f$1;
        Transition.DeferredAnimation deferredAnimation2 = enterExitTransitionKt$$ExternalSyntheticLambda7.f$2;
        TransitionInstance transitionInstance = enterExitTransitionKt$$ExternalSyntheticLambda7.f$3;
        final EnterTransitionImpl enterTransitionImpl = enterExitTransitionKt$$ExternalSyntheticLambda7.f$4;
        EnterExitTransitionConfig enterExitTransitionConfig = enterTransitionImpl.config;
        final ExitTransitionImpl exitTransitionImpl = enterExitTransitionKt$$ExternalSyntheticLambda7.f$5;
        Transition.DeferredAnimation deferredAnimation3 = enterExitTransitionKt$$ExternalSyntheticLambda7.f$6;
        final byte b = 1;
        final byte b2 = 0;
        if (deferredAnimation != null) {
            deferredAnimationDataAnimate = deferredAnimation.animate(new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FadeConfig fadeConfig;
                    FiniteAnimationSpec finiteAnimationSpec;
                    ScaleConfig scaleConfig;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    byte b3 = b2;
                    EnterExitState enterExitState = EnterExitState.PostExit;
                    EnterExitState enterExitState2 = EnterExitState.Visible;
                    EnterExitState enterExitState3 = EnterExitState.PreEnter;
                    float f = 1.0f;
                    ExitTransitionImpl exitTransitionImpl2 = exitTransitionImpl;
                    EnterTransitionImpl enterTransitionImpl2 = enterTransitionImpl;
                    switch (b3) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            SpringSpec springSpec = EnterExitTransitionKt.DefaultAlphaSpring;
                            if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                                FadeConfig fadeConfig2 = enterTransitionImpl2.config.fade;
                                if (fadeConfig2 == null || (finiteAnimationSpec = fadeConfig2.animationSpec) == null) {
                                    return springSpec;
                                }
                            } else if (!segment.isTransitioningTo(enterExitState2, enterExitState) || (fadeConfig = exitTransitionImpl2.config.fade) == null || (finiteAnimationSpec = fadeConfig.animationSpec) == null) {
                                return springSpec;
                            }
                            return finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            if (iOrdinal == 0) {
                                FadeConfig fadeConfig3 = enterTransitionImpl2.config.fade;
                                if (fadeConfig3 != null) {
                                    f = fadeConfig3.alpha;
                                }
                            } else if (iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                FadeConfig fadeConfig4 = exitTransitionImpl2.config.fade;
                                if (fadeConfig4 != null) {
                                    f = fadeConfig4.alpha;
                                }
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            SpringSpec springSpec2 = EnterExitTransitionKt.DefaultScaleSpring;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState2)) {
                                ScaleConfig scaleConfig2 = enterTransitionImpl2.config.scale;
                                if (scaleConfig2 == null || (finiteAnimationSpec2 = scaleConfig2.animationSpec) == null) {
                                    return springSpec2;
                                }
                            } else if (!segment2.isTransitioningTo(enterExitState2, enterExitState) || (scaleConfig = exitTransitionImpl2.config.scale) == null || (finiteAnimationSpec2 = scaleConfig.animationSpec) == null) {
                                return springSpec2;
                            }
                            return finiteAnimationSpec2;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 == 0) {
                                ScaleConfig scaleConfig3 = enterTransitionImpl2.config.scale;
                                if (scaleConfig3 != null) {
                                    f = scaleConfig3.scale;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ScaleConfig scaleConfig4 = exitTransitionImpl2.config.scale;
                                if (scaleConfig4 != null) {
                                    f = scaleConfig4.scale;
                                }
                            }
                            return Float.valueOf(f);
                    }
                }
            }, sharedMutableTransformState.isHandoffActive() ? Float.valueOf(sharedMutableTransformState.lastAlpha) : null, null, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FadeConfig fadeConfig;
                    FiniteAnimationSpec finiteAnimationSpec;
                    ScaleConfig scaleConfig;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    byte b3 = b;
                    EnterExitState enterExitState = EnterExitState.PostExit;
                    EnterExitState enterExitState2 = EnterExitState.Visible;
                    EnterExitState enterExitState3 = EnterExitState.PreEnter;
                    float f = 1.0f;
                    ExitTransitionImpl exitTransitionImpl2 = exitTransitionImpl;
                    EnterTransitionImpl enterTransitionImpl2 = enterTransitionImpl;
                    switch (b3) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            SpringSpec springSpec = EnterExitTransitionKt.DefaultAlphaSpring;
                            if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                                FadeConfig fadeConfig2 = enterTransitionImpl2.config.fade;
                                if (fadeConfig2 == null || (finiteAnimationSpec = fadeConfig2.animationSpec) == null) {
                                    return springSpec;
                                }
                            } else if (!segment.isTransitioningTo(enterExitState2, enterExitState) || (fadeConfig = exitTransitionImpl2.config.fade) == null || (finiteAnimationSpec = fadeConfig.animationSpec) == null) {
                                return springSpec;
                            }
                            return finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            if (iOrdinal == 0) {
                                FadeConfig fadeConfig3 = enterTransitionImpl2.config.fade;
                                if (fadeConfig3 != null) {
                                    f = fadeConfig3.alpha;
                                }
                            } else if (iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                FadeConfig fadeConfig4 = exitTransitionImpl2.config.fade;
                                if (fadeConfig4 != null) {
                                    f = fadeConfig4.alpha;
                                }
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            SpringSpec springSpec2 = EnterExitTransitionKt.DefaultScaleSpring;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState2)) {
                                ScaleConfig scaleConfig2 = enterTransitionImpl2.config.scale;
                                if (scaleConfig2 == null || (finiteAnimationSpec2 = scaleConfig2.animationSpec) == null) {
                                    return springSpec2;
                                }
                            } else if (!segment2.isTransitioningTo(enterExitState2, enterExitState) || (scaleConfig = exitTransitionImpl2.config.scale) == null || (finiteAnimationSpec2 = scaleConfig.animationSpec) == null) {
                                return springSpec2;
                            }
                            return finiteAnimationSpec2;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 == 0) {
                                ScaleConfig scaleConfig3 = enterTransitionImpl2.config.scale;
                                if (scaleConfig3 != null) {
                                    f = scaleConfig3.scale;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ScaleConfig scaleConfig4 = exitTransitionImpl2.config.scale;
                                if (scaleConfig4 != null) {
                                    f = scaleConfig4.scale;
                                }
                            }
                            return Float.valueOf(f);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate = null;
        }
        if (deferredAnimation2 != null) {
            final byte b3 = 2;
            final byte b4 = 3;
            deferredAnimationDataAnimate2 = deferredAnimation2.animate(new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FadeConfig fadeConfig;
                    FiniteAnimationSpec finiteAnimationSpec;
                    ScaleConfig scaleConfig;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    byte b5 = b3;
                    EnterExitState enterExitState = EnterExitState.PostExit;
                    EnterExitState enterExitState2 = EnterExitState.Visible;
                    EnterExitState enterExitState3 = EnterExitState.PreEnter;
                    float f = 1.0f;
                    ExitTransitionImpl exitTransitionImpl2 = exitTransitionImpl;
                    EnterTransitionImpl enterTransitionImpl2 = enterTransitionImpl;
                    switch (b5) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            SpringSpec springSpec = EnterExitTransitionKt.DefaultAlphaSpring;
                            if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                                FadeConfig fadeConfig2 = enterTransitionImpl2.config.fade;
                                if (fadeConfig2 == null || (finiteAnimationSpec = fadeConfig2.animationSpec) == null) {
                                    return springSpec;
                                }
                            } else if (!segment.isTransitioningTo(enterExitState2, enterExitState) || (fadeConfig = exitTransitionImpl2.config.fade) == null || (finiteAnimationSpec = fadeConfig.animationSpec) == null) {
                                return springSpec;
                            }
                            return finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            if (iOrdinal == 0) {
                                FadeConfig fadeConfig3 = enterTransitionImpl2.config.fade;
                                if (fadeConfig3 != null) {
                                    f = fadeConfig3.alpha;
                                }
                            } else if (iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                FadeConfig fadeConfig4 = exitTransitionImpl2.config.fade;
                                if (fadeConfig4 != null) {
                                    f = fadeConfig4.alpha;
                                }
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            SpringSpec springSpec2 = EnterExitTransitionKt.DefaultScaleSpring;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState2)) {
                                ScaleConfig scaleConfig2 = enterTransitionImpl2.config.scale;
                                if (scaleConfig2 == null || (finiteAnimationSpec2 = scaleConfig2.animationSpec) == null) {
                                    return springSpec2;
                                }
                            } else if (!segment2.isTransitioningTo(enterExitState2, enterExitState) || (scaleConfig = exitTransitionImpl2.config.scale) == null || (finiteAnimationSpec2 = scaleConfig.animationSpec) == null) {
                                return springSpec2;
                            }
                            return finiteAnimationSpec2;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 == 0) {
                                ScaleConfig scaleConfig3 = enterTransitionImpl2.config.scale;
                                if (scaleConfig3 != null) {
                                    f = scaleConfig3.scale;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ScaleConfig scaleConfig4 = exitTransitionImpl2.config.scale;
                                if (scaleConfig4 != null) {
                                    f = scaleConfig4.scale;
                                }
                            }
                            return Float.valueOf(f);
                    }
                }
            }, sharedMutableTransformState.isHandoffActive() ? Float.valueOf(sharedMutableTransformState.lastScale) : null, sharedMutableTransformState.scaleHandoffVelocity, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FadeConfig fadeConfig;
                    FiniteAnimationSpec finiteAnimationSpec;
                    ScaleConfig scaleConfig;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    byte b5 = b4;
                    EnterExitState enterExitState = EnterExitState.PostExit;
                    EnterExitState enterExitState2 = EnterExitState.Visible;
                    EnterExitState enterExitState3 = EnterExitState.PreEnter;
                    float f = 1.0f;
                    ExitTransitionImpl exitTransitionImpl2 = exitTransitionImpl;
                    EnterTransitionImpl enterTransitionImpl2 = enterTransitionImpl;
                    switch (b5) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            SpringSpec springSpec = EnterExitTransitionKt.DefaultAlphaSpring;
                            if (segment.isTransitioningTo(enterExitState3, enterExitState2)) {
                                FadeConfig fadeConfig2 = enterTransitionImpl2.config.fade;
                                if (fadeConfig2 == null || (finiteAnimationSpec = fadeConfig2.animationSpec) == null) {
                                    return springSpec;
                                }
                            } else if (!segment.isTransitioningTo(enterExitState2, enterExitState) || (fadeConfig = exitTransitionImpl2.config.fade) == null || (finiteAnimationSpec = fadeConfig.animationSpec) == null) {
                                return springSpec;
                            }
                            return finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            if (iOrdinal == 0) {
                                FadeConfig fadeConfig3 = enterTransitionImpl2.config.fade;
                                if (fadeConfig3 != null) {
                                    f = fadeConfig3.alpha;
                                }
                            } else if (iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                FadeConfig fadeConfig4 = exitTransitionImpl2.config.fade;
                                if (fadeConfig4 != null) {
                                    f = fadeConfig4.alpha;
                                }
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            SpringSpec springSpec2 = EnterExitTransitionKt.DefaultScaleSpring;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState2)) {
                                ScaleConfig scaleConfig2 = enterTransitionImpl2.config.scale;
                                if (scaleConfig2 == null || (finiteAnimationSpec2 = scaleConfig2.animationSpec) == null) {
                                    return springSpec2;
                                }
                            } else if (!segment2.isTransitioningTo(enterExitState2, enterExitState) || (scaleConfig = exitTransitionImpl2.config.scale) == null || (finiteAnimationSpec2 = scaleConfig.animationSpec) == null) {
                                return springSpec2;
                            }
                            return finiteAnimationSpec2;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 == 0) {
                                ScaleConfig scaleConfig3 = enterTransitionImpl2.config.scale;
                                if (scaleConfig3 != null) {
                                    f = scaleConfig3.scale;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ScaleConfig scaleConfig4 = exitTransitionImpl2.config.scale;
                                if (scaleConfig4 != null) {
                                    f = scaleConfig4.scale;
                                }
                            }
                            return Float.valueOf(f);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate2 = null;
        }
        if (transitionInstance.transitionState.getCurrentState() == EnterExitState.PreEnter) {
            ScaleConfig scaleConfig = enterExitTransitionConfig.scale;
            if (scaleConfig != null) {
                transformOrigin = new TransformOrigin(scaleConfig.transformOrigin);
            } else {
                ScaleConfig scaleConfig2 = exitTransitionImpl.config.scale;
                if (scaleConfig2 != null) {
                    transformOrigin = new TransformOrigin(scaleConfig2.transformOrigin);
                } else {
                    transformOrigin = null;
                }
            }
        } else {
            ScaleConfig scaleConfig3 = exitTransitionImpl.config.scale;
            if (scaleConfig3 != null) {
                transformOrigin = new TransformOrigin(scaleConfig3.transformOrigin);
            } else {
                ScaleConfig scaleConfig4 = enterExitTransitionConfig.scale;
                if (scaleConfig4 != null) {
                    transformOrigin = new TransformOrigin(scaleConfig4.transformOrigin);
                } else {
                    transformOrigin = null;
                }
            }
        }
        if (deferredAnimation3 != null) {
            deferredAnimationDataAnimate3 = deferredAnimation3.animate(new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 9), sharedMutableTransformState.isHandoffActive() ? new TransformOrigin(sharedMutableTransformState.lastTransformOrigin) : null, null, new UtilsKt$$ExternalSyntheticLambda0(transformOrigin, enterTransitionImpl, exitTransitionImpl, (byte) 2));
        } else {
            deferredAnimationDataAnimate3 = null;
        }
        final MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59((Object) sharedMutableTransformState, (Object) deferredAnimationDataAnimate, (Object) deferredAnimationDataAnimate2, (Object) deferredAnimationDataAnimate3, (byte) 1);
        final Placeable placeableMo598measureBRTryo2 = measurable.mo598measureBRTryo0(j);
        long j6 = (((long) placeableMo598measureBRTryo2.width) << 32) | (((long) placeableMo598measureBRTryo2.height) & 4294967295L);
        final long j7 = !IntSize.m810equalsimpl0(this.lookaheadSize, -9223372034707292160L) ? this.lookaheadSize : j6;
        Transition.DeferredAnimation deferredAnimation4 = this.sizeAnimation;
        if (deferredAnimation4 != null) {
            final byte b5 = 0;
            deferredAnimationDataAnimate4 = deferredAnimation4.animate(this.sizeTransitionSpec, null, null, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda3
                public final /* synthetic */ EnterExitTransitionModifierNode f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Function1 function1;
                    Function1 function2;
                    int iOrdinal;
                    Function1 function3;
                    Function1 function4;
                    byte b6 = b5;
                    long jM805minusqkQi6aY = 0;
                    long j8 = j7;
                    EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                    EnterExitState enterExitState = (EnterExitState) obj;
                    switch (b6) {
                        case 0:
                            int iOrdinal2 = enterExitState.ordinal();
                            if (iOrdinal2 == 0) {
                                ChangeSizeConfig changeSizeConfig = enterExitTransitionModifierNode.enter.config.changeSize;
                                if (changeSizeConfig != null && (function1 = changeSizeConfig.size) != null) {
                                    j8 = ((IntSize) function1.invoke(new IntSize(j8))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig2 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig2 != null && (function2 = changeSizeConfig2.size) != null) {
                                    j8 = ((IntSize) function2.invoke(new IntSize(j8))).packedValue;
                                }
                            }
                            return new IntSize(j8);
                        case 1:
                            if (enterExitTransitionModifierNode.currentAlignment != null && enterExitTransitionModifierNode.getAlignment() != null && !Intrinsics.areEqual(enterExitTransitionModifierNode.currentAlignment, enterExitTransitionModifierNode.getAlignment()) && (iOrdinal = enterExitState.ordinal()) != 0 && iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig3 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig3 != null) {
                                    Function1 function5 = changeSizeConfig3.size;
                                    long j9 = j7;
                                    long j10 = ((IntSize) function5.invoke(new IntSize(j9))).packedValue;
                                    Alignment alignment2 = enterExitTransitionModifierNode.getAlignment();
                                    alignment2.getClass();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    long jMo397alignKFBX0sM = alignment2.mo397alignKFBX0sM(j9, j10, layoutDirection);
                                    Alignment alignment3 = enterExitTransitionModifierNode.currentAlignment;
                                    alignment3.getClass();
                                    jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(jMo397alignKFBX0sM, alignment3.mo397alignKFBX0sM(j9, j10, layoutDirection));
                                }
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                        default:
                            SlideConfig slideConfig = enterExitTransitionModifierNode.enter.config.slide;
                            long j11 = (slideConfig == null || (function4 = slideConfig.slideOffset) == null) ? 0L : ((IntOffset) function4.invoke(new IntSize(j8))).packedValue;
                            SlideConfig slideConfig2 = enterExitTransitionModifierNode.exit.config.slide;
                            long j12 = (slideConfig2 == null || (function3 = slideConfig2.slideOffset) == null) ? 0L : ((IntOffset) function3.invoke(new IntSize(j8))).packedValue;
                            int iOrdinal3 = enterExitState.ordinal();
                            if (iOrdinal3 == 0) {
                                jM805minusqkQi6aY = j11;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                jM805minusqkQi6aY = j12;
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate4 = null;
        }
        if (deferredAnimationDataAnimate4 != null) {
            j2 = ((IntSize) deferredAnimationDataAnimate4.getValue()).packedValue;
            j3 = j6;
        } else {
            j2 = j6;
            j3 = j2;
        }
        final long jM789constrain4WqzIAM = ConstraintsKt.m789constrain4WqzIAM(j, j2);
        Transition.DeferredAnimation deferredAnimation5 = this.offsetAnimation;
        if (deferredAnimation5 != null) {
            final byte b6 = 1;
            intOffset = null;
            j4 = ((IntOffset) deferredAnimation5.animate(new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 22), null, null, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda3
                public final /* synthetic */ EnterExitTransitionModifierNode f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Function1 function1;
                    Function1 function2;
                    int iOrdinal;
                    Function1 function3;
                    Function1 function4;
                    byte b7 = b6;
                    long jM805minusqkQi6aY = 0;
                    long j8 = j7;
                    EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                    EnterExitState enterExitState = (EnterExitState) obj;
                    switch (b7) {
                        case 0:
                            int iOrdinal2 = enterExitState.ordinal();
                            if (iOrdinal2 == 0) {
                                ChangeSizeConfig changeSizeConfig = enterExitTransitionModifierNode.enter.config.changeSize;
                                if (changeSizeConfig != null && (function1 = changeSizeConfig.size) != null) {
                                    j8 = ((IntSize) function1.invoke(new IntSize(j8))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig2 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig2 != null && (function2 = changeSizeConfig2.size) != null) {
                                    j8 = ((IntSize) function2.invoke(new IntSize(j8))).packedValue;
                                }
                            }
                            return new IntSize(j8);
                        case 1:
                            if (enterExitTransitionModifierNode.currentAlignment != null && enterExitTransitionModifierNode.getAlignment() != null && !Intrinsics.areEqual(enterExitTransitionModifierNode.currentAlignment, enterExitTransitionModifierNode.getAlignment()) && (iOrdinal = enterExitState.ordinal()) != 0 && iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig3 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig3 != null) {
                                    Function1 function5 = changeSizeConfig3.size;
                                    long j9 = j7;
                                    long j10 = ((IntSize) function5.invoke(new IntSize(j9))).packedValue;
                                    Alignment alignment2 = enterExitTransitionModifierNode.getAlignment();
                                    alignment2.getClass();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    long jMo397alignKFBX0sM = alignment2.mo397alignKFBX0sM(j9, j10, layoutDirection);
                                    Alignment alignment3 = enterExitTransitionModifierNode.currentAlignment;
                                    alignment3.getClass();
                                    jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(jMo397alignKFBX0sM, alignment3.mo397alignKFBX0sM(j9, j10, layoutDirection));
                                }
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                        default:
                            SlideConfig slideConfig = enterExitTransitionModifierNode.enter.config.slide;
                            long j11 = (slideConfig == null || (function4 = slideConfig.slideOffset) == null) ? 0L : ((IntOffset) function4.invoke(new IntSize(j8))).packedValue;
                            SlideConfig slideConfig2 = enterExitTransitionModifierNode.exit.config.slide;
                            long j12 = (slideConfig2 == null || (function3 = slideConfig2.slideOffset) == null) ? 0L : ((IntOffset) function3.invoke(new IntSize(j8))).packedValue;
                            int iOrdinal3 = enterExitState.ordinal();
                            if (iOrdinal3 == 0) {
                                jM805minusqkQi6aY = j11;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                jM805minusqkQi6aY = j12;
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                    }
                }
            }).getValue()).packedValue;
        } else {
            intOffset = null;
            j4 = 0;
        }
        final long j8 = j4;
        Transition.DeferredAnimation deferredAnimation6 = this.slideAnimation;
        if (deferredAnimation6 != null) {
            SharedMutableTransformState sharedMutableTransformState2 = this.mutableTransformState;
            if (sharedMutableTransformState2.isHandoffActive()) {
                intOffset = new IntOffset(sharedMutableTransformState2.lastSlide);
            }
            final byte b7 = 2;
            deferredAnimationDataAnimate5 = deferredAnimation6.animate(this.slideSpec, intOffset, this.mutableTransformState.slideHandoffVelocity, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda3
                public final /* synthetic */ EnterExitTransitionModifierNode f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Function1 function1;
                    Function1 function2;
                    int iOrdinal;
                    Function1 function3;
                    Function1 function4;
                    byte b8 = b7;
                    long jM805minusqkQi6aY = 0;
                    long j9 = j7;
                    EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                    EnterExitState enterExitState = (EnterExitState) obj;
                    switch (b8) {
                        case 0:
                            int iOrdinal2 = enterExitState.ordinal();
                            if (iOrdinal2 == 0) {
                                ChangeSizeConfig changeSizeConfig = enterExitTransitionModifierNode.enter.config.changeSize;
                                if (changeSizeConfig != null && (function1 = changeSizeConfig.size) != null) {
                                    j9 = ((IntSize) function1.invoke(new IntSize(j9))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig2 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig2 != null && (function2 = changeSizeConfig2.size) != null) {
                                    j9 = ((IntSize) function2.invoke(new IntSize(j9))).packedValue;
                                }
                            }
                            return new IntSize(j9);
                        case 1:
                            if (enterExitTransitionModifierNode.currentAlignment != null && enterExitTransitionModifierNode.getAlignment() != null && !Intrinsics.areEqual(enterExitTransitionModifierNode.currentAlignment, enterExitTransitionModifierNode.getAlignment()) && (iOrdinal = enterExitState.ordinal()) != 0 && iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                ChangeSizeConfig changeSizeConfig3 = enterExitTransitionModifierNode.exit.config.changeSize;
                                if (changeSizeConfig3 != null) {
                                    Function1 function5 = changeSizeConfig3.size;
                                    long j10 = j7;
                                    long j11 = ((IntSize) function5.invoke(new IntSize(j10))).packedValue;
                                    Alignment alignment2 = enterExitTransitionModifierNode.getAlignment();
                                    alignment2.getClass();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    long jMo397alignKFBX0sM = alignment2.mo397alignKFBX0sM(j10, j11, layoutDirection);
                                    Alignment alignment3 = enterExitTransitionModifierNode.currentAlignment;
                                    alignment3.getClass();
                                    jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(jMo397alignKFBX0sM, alignment3.mo397alignKFBX0sM(j10, j11, layoutDirection));
                                }
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                        default:
                            SlideConfig slideConfig = enterExitTransitionModifierNode.enter.config.slide;
                            long j12 = (slideConfig == null || (function4 = slideConfig.slideOffset) == null) ? 0L : ((IntOffset) function4.invoke(new IntSize(j9))).packedValue;
                            SlideConfig slideConfig2 = enterExitTransitionModifierNode.exit.config.slide;
                            long j13 = (slideConfig2 == null || (function3 = slideConfig2.slideOffset) == null) ? 0L : ((IntOffset) function3.invoke(new IntSize(j9))).packedValue;
                            int iOrdinal3 = enterExitState.ordinal();
                            if (iOrdinal3 == 0) {
                                jM805minusqkQi6aY = j12;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                jM805minusqkQi6aY = j13;
                            }
                            return new IntOffset(jM805minusqkQi6aY);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate5 = intOffset;
        }
        final long j9 = j7;
        final long j10 = j3;
        return measureScope.layout((int) (jM789constrain4WqzIAM >> 32), (int) (jM789constrain4WqzIAM & 4294967295L), emptyMap, new Function1(deferredAnimationDataAnimate5, j10, j9, jM789constrain4WqzIAM, placeableMo598measureBRTryo2, j8, mainActivity$$ExternalSyntheticLambda59) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$$ExternalSyntheticLambda7
            public final /* synthetic */ State f$1;
            public final /* synthetic */ long f$3;
            public final /* synthetic */ long f$4;
            public final /* synthetic */ Placeable f$5;
            public final /* synthetic */ long f$6;
            public final /* synthetic */ MainActivity$$ExternalSyntheticLambda59 f$7;

            {
                this.f$3 = j9;
                this.f$4 = jM789constrain4WqzIAM;
                this.f$5 = placeableMo598measureBRTryo2;
                this.f$6 = j8;
                this.f$7 = mainActivity$$ExternalSyntheticLambda59;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.f$0;
                SharedMutableTransformState sharedMutableTransformState3 = enterExitTransitionModifierNode.mutableTransformState;
                State state = this.f$1;
                long jMo397alignKFBX0sM = 0;
                long j11 = state != null ? ((IntOffset) state.getValue()).packedValue : 0L;
                sharedMutableTransformState3.isMutating();
                sharedMutableTransformState3.activeTransitionSlide = j11;
                sharedMutableTransformState3.isMutating();
                if (sharedMutableTransformState3.isMutating()) {
                    sharedMutableTransformState3.lastSlide = j11;
                }
                Alignment alignment2 = enterExitTransitionModifierNode.currentAlignment;
                if (alignment2 != null) {
                    jMo397alignKFBX0sM = alignment2.mo397alignKFBX0sM(this.f$3, this.f$4, LayoutDirection.Ltr);
                }
                long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(jMo397alignKFBX0sM, j11);
                long j12 = this.f$6;
                placementScope.placeWithLayer(this.f$5, ((int) (jM806plusqkQi6aY >> 32)) + ((int) (j12 >> 32)), ((int) (jM806plusqkQi6aY & 4294967295L)) + ((int) (j12 & 4294967295L)), CropImageView.DEFAULT_ASPECT_RATIO, this.f$7);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.lookaheadSize = -9223372034707292160L;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
    }
}
