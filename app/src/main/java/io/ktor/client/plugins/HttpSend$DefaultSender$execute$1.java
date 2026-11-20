package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", l = {141}, m = "execute", v = 1)
public final class HttpSend$DefaultSender$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpSend.DefaultSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$DefaultSender$execute$1(HttpSend.DefaultSender defaultSender, Continuation continuation) {
        super(continuation);
        this.this$0 = defaultSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
