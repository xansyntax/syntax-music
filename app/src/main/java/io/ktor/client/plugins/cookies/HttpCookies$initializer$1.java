package io.ktor.client.plugins.cookies;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$initializer$1", f = "HttpCookies.kt", l = {34}, m = "invokeSuspend", v = 1)
public final class HttpCookies$initializer$1 extends SuspendLambda implements Function2 {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ HttpCookies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$initializer$1(HttpCookies httpCookies, Continuation continuation) {
        super(2, continuation);
        this.this$0 = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpCookies$initializer$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpCookies$initializer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        HttpCookies httpCookies;
        int i;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List list = this.this$0.defaults;
            HttpCookies httpCookies2 = this.this$0;
            it = list.iterator();
            httpCookies = httpCookies2;
            i = 0;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.I$0;
            it = (Iterator) this.L$2;
            httpCookies = (HttpCookies) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Function2 function2 = (Function2) it.next();
            CookiesStorage cookiesStorage = httpCookies.storage;
            this.L$0 = null;
            this.L$1 = httpCookies;
            this.L$2 = it;
            this.L$3 = null;
            this.L$4 = null;
            this.I$0 = i;
            this.I$1 = 0;
            this.label = 1;
            Object objInvoke = function2.invoke(cookiesStorage, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
