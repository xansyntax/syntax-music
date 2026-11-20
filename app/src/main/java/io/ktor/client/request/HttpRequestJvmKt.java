package io.ktor.client.request;

import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URL;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Ljava/net/URL;", "url", "Lio/ktor/http/URLBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/net/URL;)Lio/ktor/http/URLBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "invoke", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/net/URL;)Lio/ktor/client/request/HttpRequestBuilder;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestJvmKt {
    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, URL url) {
        companion.getClass();
        url.getClass();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, url);
        return httpRequestBuilder;
    }

    public static final URLBuilder url(HttpRequestBuilder httpRequestBuilder, URL url) {
        httpRequestBuilder.getClass();
        url.getClass();
        return URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
    }
}
