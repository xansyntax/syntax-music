package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbNode$measure$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float $size;
    public boolean label;
    public final /* synthetic */ ThumbNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThumbNode$measure$1(ThumbNode thumbNode, float f, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = thumbNode;
        this.$size = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        float f = this.$size;
        ThumbNode thumbNode = this.this$0;
        switch (b) {
            case 0:
                return new ThumbNode$measure$1(thumbNode, f, continuation, (byte) 0);
            default:
                return new ThumbNode$measure$1(thumbNode, f, continuation, (byte) 1);
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
        }
        return ((ThumbNode$measure$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objAnimateTo$default;
        Object objAnimateTo$default2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        float f = this.$size;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ThumbNode thumbNode = this.this$0;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = thumbNode.sizeAnim;
                    if (animatable == null) {
                        return unit;
                    }
                    Float f2 = new Float(f);
                    AnimationSpec animationSpec = thumbNode.isPressed ? CardKt.SnapSpec : thumbNode.animationSpec;
                    this.label = true;
                    objAnimateTo$default = Animatable.animateTo$default(animatable, f2, animationSpec, null, null, this, 12);
                    if (objAnimateTo$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objAnimateTo$default = obj;
                }
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = thumbNode.offsetAnim;
                    if (animatable2 == null) {
                        return unit;
                    }
                    Float f3 = new Float(f);
                    AnimationSpec animationSpec2 = thumbNode.isPressed ? CardKt.SnapSpec : thumbNode.animationSpec;
                    this.label = true;
                    objAnimateTo$default2 = Animatable.animateTo$default(animatable2, f3, animationSpec2, null, null, this, 12);
                    if (objAnimateTo$default2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objAnimateTo$default2 = obj;
                }
                return unit;
        }
    }
}
