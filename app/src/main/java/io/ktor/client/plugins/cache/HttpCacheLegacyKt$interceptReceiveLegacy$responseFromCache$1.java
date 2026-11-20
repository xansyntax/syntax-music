package io.ktor.client.plugins.cache;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HttpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1 extends AdaptedFunctionReference implements Function3 {
    public HttpCacheLegacyKt$interceptReceiveLegacy$responseFromCache$1(Object obj) {
        super(3, obj, HttpCacheLegacyKt.class, "findAndRefresh", "findAndRefresh(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/statement/HttpResponse;", 5);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequest httpRequest, HttpResponse httpResponse, Continuation continuation) {
        return HttpCacheLegacyKt.interceptReceiveLegacy$findAndRefresh((HttpCache) this.receiver, httpRequest, httpResponse, continuation);
    }
}
