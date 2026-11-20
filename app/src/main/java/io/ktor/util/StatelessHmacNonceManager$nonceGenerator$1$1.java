package io.ktor.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$nonceGenerator$1$1", f = "StatelessHmacNonceManager.kt", l = {101}, m = "invokeSuspend", v = 1)
public final class StatelessHmacNonceManager$nonceGenerator$1$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ StatelessHmacNonceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager$nonceGenerator$1$1(StatelessHmacNonceManager statelessHmacNonceManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = statelessHmacNonceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatelessHmacNonceManager$nonceGenerator$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatelessHmacNonceManager$nonceGenerator$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        Function1 function1 = this.this$0.suspendNonceGenerator;
        this.label = 1;
        Object objInvoke = function1.invoke(this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
