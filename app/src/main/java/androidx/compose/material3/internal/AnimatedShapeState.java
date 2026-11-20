package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.RoundedCornerShape;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedShapeState {
    public RoundedCornerShape cachedMorphedShape;
    public final FiniteAnimationSpec spec;
    public RoundedCornerShape startShape;
    public RoundedCornerShape targetShape;
    public final Animatable progress = ArcSplineKt.Animatable$default(1.0f);
    public float cachedProgress = -1.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnimatedShapeState$animateToShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimatedShapeState.this.animateToShape(null, this);
        }
    }

    public AnimatedShapeState(RoundedCornerShape roundedCornerShape, FiniteAnimationSpec finiteAnimationSpec) {
        this.spec = finiteAnimationSpec;
        this.startShape = roundedCornerShape;
        this.targetShape = roundedCornerShape;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
    
        if (r15 == r10) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0126, code lost:
    
        if (r15 == r10) goto L64;
     */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToShape(RoundedCornerShape roundedCornerShape, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        RoundedCornerShape roundedCornerShape2;
        float f;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objAnimateTo$default = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        Unit unit = Unit.INSTANCE;
        Animatable animatable = this.progress;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                f = anonymousClass2.F$0;
                ResultKt.throwOnFailure(objAnimateTo$default);
                Float f2 = new Float(1.0f);
                Float f3 = new Float(-f);
                anonymousClass2.label = 2;
                objAnimateTo$default = Animatable.animateTo$default(animatable, f2, this.spec, f3, null, anonymousClass2, 8);
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        ResultKt.throwOnFailure(objAnimateTo$default);
                        Float f4 = new Float(1.0f);
                        anonymousClass2.label = 4;
                        objAnimateTo$default = Animatable.animateTo$default(animatable, f4, this.spec, null, null, anonymousClass2, 12);
                    } else {
                        if (i2 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(objAnimateTo$default);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(objAnimateTo$default);
            }
            return unit;
        }
        ResultKt.throwOnFailure(objAnimateTo$default);
        if (Intrinsics.areEqual(this.targetShape, roundedCornerShape)) {
            return unit;
        }
        if (Intrinsics.areEqual(roundedCornerShape, this.startShape)) {
            this.startShape = this.targetShape;
            this.targetShape = roundedCornerShape;
            this.cachedMorphedShape = null;
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            float fFloatValue2 = ((Number) ArcSplineKt.FloatToVector.convertFromVector.invoke(animatable.internalState.velocityVector)).floatValue();
            Float f5 = new Float(1.0f - fFloatValue);
            anonymousClass2.F$0 = fFloatValue2;
            anonymousClass2.label = 1;
            if (animatable.snapTo(f5, anonymousClass2) != coroutineSingletons) {
                f = fFloatValue2;
                Float f6 = new Float(1.0f);
                Float f7 = new Float(-f);
                anonymousClass2.label = 2;
                objAnimateTo$default = Animatable.animateTo$default(animatable, f6, this.spec, f7, null, anonymousClass2, 8);
            }
        } else {
            float fFloatValue3 = ((Number) animatable.getValue()).floatValue();
            RoundedCornerShape roundedCornerShape3 = this.startShape;
            RoundedCornerShape roundedCornerShape4 = this.targetShape;
            if (fFloatValue3 == 1.0f) {
                roundedCornerShape2 = roundedCornerShape4;
            } else if (fFloatValue3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                if (!Intrinsics.areEqual(roundedCornerShape3, roundedCornerShape4)) {
                    Object objLerp = roundedCornerShape3 != null ? roundedCornerShape3.lerp(fFloatValue3, roundedCornerShape4) : null;
                    if (objLerp == null && roundedCornerShape4 != null) {
                        objLerp = roundedCornerShape4.lerp(1.0f - fFloatValue3, roundedCornerShape3);
                    }
                    if (objLerp != null) {
                        obj = objLerp;
                    } else if (fFloatValue3 >= 0.5f) {
                        obj = roundedCornerShape3;
                        roundedCornerShape2 = roundedCornerShape3;
                        obj = roundedCornerShape3;
                        obj = roundedCornerShape4;
                    }
                } else if (fFloatValue3 >= 0.5f) {
                    obj = roundedCornerShape3;
                    roundedCornerShape2 = roundedCornerShape3;
                    obj = roundedCornerShape3;
                    obj = roundedCornerShape4;
                }
                obj = roundedCornerShape3;
                roundedCornerShape2 = roundedCornerShape3;
                obj = roundedCornerShape3;
                obj.getClass();
                roundedCornerShape2 = (RoundedCornerShape) obj;
            }
            roundedCornerShape2 = roundedCornerShape3;
            this.startShape = roundedCornerShape2;
            this.targetShape = roundedCornerShape;
            this.cachedMorphedShape = null;
            Float f8 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
            anonymousClass2.label = 3;
            if (animatable.snapTo(f8, anonymousClass2) != coroutineSingletons) {
                Float f9 = new Float(1.0f);
                anonymousClass2.label = 4;
                objAnimateTo$default = Animatable.animateTo$default(animatable, f9, this.spec, null, null, anonymousClass2, 12);
            }
        }
        return coroutineSingletons;
    }
}
