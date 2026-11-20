package androidx.compose.animation.core;

import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteTransition$run$1$1$3 extends SuspendLambda implements Function2 {
    public /* synthetic */ float F$0;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InfiniteTransition$run$1$1$3 infiniteTransition$run$1$1$3 = new InfiniteTransition$run$1$1$3(2, continuation);
        infiniteTransition$run$1$1$3.F$0 = ((Number) obj).floatValue();
        return infiniteTransition$run$1$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((InfiniteTransition$run$1$1$3) create(Float.valueOf(((Number) obj).floatValue()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        return Boolean.valueOf(this.F$0 > CropImageView.DEFAULT_ASPECT_RATIO);
    }
}
