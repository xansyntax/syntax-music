package io.ktor.client.plugins.cache;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HttpCache$Companion$install$2$responseFromCache$1 extends FunctionReferenceImpl implements Function3 {
    public HttpCache$Companion$install$2$responseFromCache$1(Object obj) {
        super(3, obj, HttpCache.class, "findAndRefresh", "findAndRefresh(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequest httpRequest, HttpResponse httpResponse, Continuation continuation) {
        return ((HttpCache) this.receiver).findAndRefresh(httpRequest, httpResponse, continuation);
    }
}
