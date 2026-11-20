package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
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
public final class LensController$slideTo$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $index;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ LensController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LensController$slideTo$1(LensController lensController, int i, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = lensController;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        int i = this.$index;
        LensController lensController = this.this$0;
        switch (b) {
            case 0:
                return new LensController$slideTo$1(lensController, i, continuation, (byte) 0);
            default:
                return new LensController$slideTo$1(lensController, i, continuation, (byte) 1);
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
        return ((LensController$slideTo$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.$index;
        LensController lensController = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Animatable animatable = lensController.pos;
                Float f = new Float(i);
                SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.58f, 380.0f, null, 4);
                this.label = true;
                return Animatable.animateTo$default(animatable, f, springSpecSpring$default, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            default:
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
                Animatable animatable2 = lensController.pos;
                Float f2 = new Float(i);
                SpringSpec springSpecSpring$default2 = ArcSplineKt.spring$default(0.55f, 360.0f, null, 4);
                this.label = true;
                return Animatable.animateTo$default(animatable2, f2, springSpecSpring$default2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
