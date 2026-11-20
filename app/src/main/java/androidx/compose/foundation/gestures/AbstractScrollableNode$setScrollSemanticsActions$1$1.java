package androidx.compose.foundation.gestures;

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
public final class AbstractScrollableNode$setScrollSemanticsActions$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ float $x;
    public final /* synthetic */ float $y;
    public boolean label;
    public final /* synthetic */ ScrollableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractScrollableNode$setScrollSemanticsActions$1$1(ScrollableNode scrollableNode, float f, float f2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = scrollableNode;
        this.$x = f;
        this.$y = f2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AbstractScrollableNode$setScrollSemanticsActions$1$1(this.this$0, this.$x, this.$y, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AbstractScrollableNode$setScrollSemanticsActions$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(this.$x)) << 32) | (((long) Float.floatToRawIntBits(this.$y)) & 4294967295L);
            this.label = true;
            Object objM97semanticsScrollByd4ec7I = ScrollableKt.m97semanticsScrollByd4ec7I(this.this$0.scrollLogic, jFloatToRawIntBits, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM97semanticsScrollByd4ec7I == coroutineSingletons) {
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
