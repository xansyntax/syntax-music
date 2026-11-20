package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.sqlite.SQLite;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ float $initialVelocity;
    public final /* synthetic */ Function1 $onRemainingScrollOffsetUpdate;
    public final /* synthetic */ ScrollScope $this_fling;
    public Ref$FloatRef L$0;
    public byte label;
    public final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f, Function1 function1, ScrollScope scrollScope, Continuation continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f;
        this.$onRemainingScrollOffsetUpdate = function1;
        this.$this_fling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SnapFlingBehavior$fling$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Ref$FloatRef ref$FloatRef;
        Object objTryApproach;
        SnapFlingBehavior snapFlingBehavior = this.this$0;
        SnapLayoutInfoProvider snapLayoutInfoProvider = snapFlingBehavior.snapLayoutInfoProvider;
        byte b = this.label;
        final byte b2 = 1;
        final Function1 function1 = this.$onRemainingScrollOffsetUpdate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            DecayAnimationSpecImpl decayAnimationSpecImpl = snapFlingBehavior.decayAnimationSpec;
            float f = this.$initialVelocity;
            float fCalculateApproachOffset = snapLayoutInfoProvider.calculateApproachOffset(f, ArcSplineKt.calculateTargetValue(decayAnimationSpecImpl, CropImageView.DEFAULT_ASPECT_RATIO, f));
            if (Float.isNaN(fCalculateApproachOffset)) {
                InlineClassHelperKt.throwIllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
            }
            ref$FloatRef = new Ref$FloatRef();
            float fSignum = Math.signum(f) * Math.abs(fCalculateApproachOffset);
            ref$FloatRef.element = fSignum;
            function1.invoke(new Float(fSignum));
            float f2 = ref$FloatRef.element;
            final byte b3 = 0;
            ?? r4 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    byte b4 = b3;
                    Unit unit = Unit.INSTANCE;
                    Function1 function2 = function1;
                    Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                    float fFloatValue = ((Float) obj2).floatValue();
                    switch (b4) {
                        case 0:
                            float f3 = ref$FloatRef2.element - fFloatValue;
                            ref$FloatRef2.element = f3;
                            function2.invoke(Float.valueOf(f3));
                            break;
                        default:
                            float f4 = ref$FloatRef2.element - fFloatValue;
                            ref$FloatRef2.element = f4;
                            function2.invoke(Float.valueOf(f4));
                            break;
                    }
                    return unit;
                }
            };
            this.L$0 = ref$FloatRef;
            this.label = (byte) 1;
            objTryApproach = snapFlingBehavior.tryApproach(this.$this_fling, f2, this.$initialVelocity, r4, this);
            if (objTryApproach != coroutineSingletons) {
            }
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        Ref$FloatRef ref$FloatRef2 = this.L$0;
        ResultKt.throwOnFailure(obj);
        ref$FloatRef = ref$FloatRef2;
        objTryApproach = obj;
        AnimationState animationState = (AnimationState) objTryApproach;
        float fCalculateSnapOffset = snapLayoutInfoProvider.calculateSnapOffset(((Number) animationState.getVelocity()).floatValue());
        if (Float.isNaN(fCalculateSnapOffset)) {
            InlineClassHelperKt.throwIllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
        }
        ref$FloatRef.element = fCalculateSnapOffset;
        AnimationState animationStateCopy$default = ArcSplineKt.copy$default(animationState, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 30);
        AnimationSpec animationSpec = snapFlingBehavior.snapAnimationSpec;
        Function1 function2 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                byte b4 = b2;
                Unit unit = Unit.INSTANCE;
                Function1 function3 = function1;
                Ref$FloatRef ref$FloatRef3 = ref$FloatRef;
                float fFloatValue = ((Float) obj2).floatValue();
                switch (b4) {
                    case 0:
                        float f3 = ref$FloatRef3.element - fFloatValue;
                        ref$FloatRef3.element = f3;
                        function3.invoke(Float.valueOf(f3));
                        break;
                    default:
                        float f4 = ref$FloatRef3.element - fFloatValue;
                        ref$FloatRef3.element = f4;
                        function3.invoke(Float.valueOf(f4));
                        break;
                }
                return unit;
            }
        };
        this.L$0 = null;
        this.label = (byte) 2;
        Object objAnimateWithTarget = SQLite.animateWithTarget(this.$this_fling, fCalculateSnapOffset, fCalculateSnapOffset, animationStateCopy$default, animationSpec, function2, this);
        return objAnimateWithTarget == coroutineSingletons ? coroutineSingletons : objAnimateWithTarget;
    }
}
