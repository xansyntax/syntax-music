package io.ktor.client.plugins.contentnegotiation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt", f = "ContentNegotiation.kt", l = {370}, m = "ContentNegotiation$lambda$0$convertResponse", v = 1)
public final class ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    public ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentNegotiationKt.ContentNegotiation$lambda$0$convertResponse(null, null, null, null, null, null, null, null, this);
    }
}
