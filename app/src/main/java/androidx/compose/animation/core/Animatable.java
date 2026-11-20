package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertube.models.SongItem;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Animatable {
    public final SpringSpec defaultSpringSpec;
    public final AnimationState internalState;
    public final ParcelableSnapshotMutableState isRunning$delegate;
    public final String label;
    public Comparable lowerBound;
    public AnimationVector lowerBoundVector;
    public final MutatorMutex mutatorMutex;
    public final AnimationVector negativeInfinityBounds;
    public final AnimationVector positiveInfinityBounds;
    public final ParcelableSnapshotMutableState targetValue$delegate;
    public final TwoWayConverterImpl typeConverter;
    public Comparable upperBound;
    public AnimationVector upperBoundVector;
    public final Object visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$stop$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((Animatable) obj, continuation, (byte) 0);
                default:
                    return new AnonymousClass2((SongItem) obj, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                    return unit;
                default:
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ((Animatable) obj2).endAnimation();
                    return Unit.INSTANCE;
                default:
                    ResultKt.throwOnFailure(obj);
                    return CollectionsKt__IterablesKt.listOf(((SongItem) obj2).id);
            }
        }
    }

    public Animatable(Object obj, TwoWayConverterImpl twoWayConverterImpl, Object obj2, String str) {
        this.typeConverter = twoWayConverterImpl;
        this.visibilityThreshold = obj2;
        this.label = str;
        AnimationState animationState = new AnimationState(twoWayConverterImpl, obj, null, 60);
        this.internalState = animationState;
        this.isRunning$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        this.targetValue$delegate = Stack.mutableStateOf$default(obj);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(3, obj2);
        AnimationVector animationVector = animationState.velocityVector;
        boolean z = animationVector instanceof AnimationVector1D;
        AnimationVector animationVector2 = z ? ArcSplineKt.negativeInfinityBounds1D : animationVector instanceof AnimationVector2D ? ArcSplineKt.negativeInfinityBounds2D : animationVector instanceof AnimationVector3D ? ArcSplineKt.negativeInfinityBounds3D : ArcSplineKt.negativeInfinityBounds4D;
        this.negativeInfinityBounds = animationVector2;
        AnimationVector animationVector3 = z ? ArcSplineKt.positiveInfinityBounds1D : animationVector instanceof AnimationVector2D ? ArcSplineKt.positiveInfinityBounds2D : animationVector instanceof AnimationVector3D ? ArcSplineKt.positiveInfinityBounds3D : ArcSplineKt.positiveInfinityBounds4D;
        this.positiveInfinityBounds = animationVector3;
        this.lowerBoundVector = animationVector2;
        this.upperBoundVector = animationVector3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Float f, Function1 function1, Continuation continuation, int i) {
        if ((i & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        Object objInvoke = f;
        if ((i & 4) != 0) {
            objInvoke = animatable.typeConverter.convertFromVector.invoke(animatable.internalState.velocityVector);
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        Object value = animatable.getValue();
        TwoWayConverterImpl twoWayConverterImpl = animatable.typeConverter;
        return MutatorMutex.mutate$default(animatable.mutatorMutex, new Animatable$runAnimation$2(animatable, objInvoke, new TargetBasedAnimation(animationSpec2, twoWayConverterImpl, value, obj, (AnimationVector) twoWayConverterImpl.convertToVector.invoke(objInvoke)), animatable.internalState.lastFrameTimeNanos, function1, null), continuation);
    }

    public final Object clampToBounds(Object obj) {
        if (!Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) || !Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
            TwoWayConverterImpl twoWayConverterImpl = this.typeConverter;
            AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
            int size$animation_core = animationVector.getSize$animation_core();
            boolean z = false;
            for (int i = 0; i < size$animation_core; i++) {
                if (animationVector.get$animation_core(i) < this.lowerBoundVector.get$animation_core(i) || animationVector.get$animation_core(i) > this.upperBoundVector.get$animation_core(i)) {
                    animationVector.set$animation_core(i, UuidKt.coerceIn(animationVector.get$animation_core(i), this.lowerBoundVector.get$animation_core(i), this.upperBoundVector.get$animation_core(i)));
                    z = true;
                }
            }
            if (z) {
                return twoWayConverterImpl.convertFromVector.invoke(animationVector);
            }
        }
        return obj;
    }

    public final void endAnimation() {
        AnimationState animationState = this.internalState;
        animationState.velocityVector.reset$animation_core();
        animationState.lastFrameTimeNanos = Long.MIN_VALUE;
        this.isRunning$delegate.setValue(Boolean.FALSE);
    }

    public final Object getValue() {
        return this.internalState.value$delegate.getValue();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final Object snapTo(Object obj, Continuation continuation) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, new QuickJs.AnonymousClass2(this, obj, null, (byte) 1), continuation);
        return objMutate$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate$default : Unit.INSTANCE;
    }

    public final Object stop(SuspendLambda suspendLambda) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, new AnonymousClass2(this, null, (byte) 0), suspendLambda);
        return objMutate$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate$default : Unit.INSTANCE;
    }

    public final void updateBounds(Comparable comparable, Comparable comparable2) {
        TwoWayConverterImpl twoWayConverterImpl = this.typeConverter;
        AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(comparable);
        if (animationVector == null) {
            animationVector = this.negativeInfinityBounds;
        }
        AnimationVector animationVector2 = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(comparable2);
        if (animationVector2 == null) {
            animationVector2 = this.positiveInfinityBounds;
        }
        int size$animation_core = animationVector.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            if (animationVector.get$animation_core(i) > animationVector2.get$animation_core(i)) {
                PreconditionsKt.throwIllegalStateException("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + animationVector + " is greater than upper bound " + animationVector2 + " on index " + i);
            }
        }
        this.lowerBoundVector = animationVector;
        this.upperBoundVector = animationVector2;
        this.upperBound = comparable2;
        this.lowerBound = comparable;
        if (isRunning()) {
            return;
        }
        Object objClampToBounds = clampToBounds(getValue());
        if (Intrinsics.areEqual(objClampToBounds, getValue())) {
            return;
        }
        this.internalState.value$delegate.setValue(objClampToBounds);
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverterImpl twoWayConverterImpl, Object obj2, int i) {
        this(obj, twoWayConverterImpl, (i & 4) != 0 ? null : obj2, "Animatable");
    }
}
