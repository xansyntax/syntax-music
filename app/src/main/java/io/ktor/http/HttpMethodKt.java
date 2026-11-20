package io.ktor.http;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"", "Lio/ktor/http/HttpMethod;", "REQUESTS_WITHOUT_BODY", "Ljava/util/Set;", "", "getSupportsRequestBody", "(Lio/ktor/http/HttpMethod;)Z", "getSupportsRequestBody$annotations", "(Lio/ktor/http/HttpMethod;)V", "supportsRequestBody", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpMethodKt {
    private static final Set<HttpMethod> REQUESTS_WITHOUT_BODY = ArraysKt.toSet(new HttpMethod[]{HttpMethod.Get, HttpMethod.Head, HttpMethod.Options, HttpMethod.Trace});

    public static final boolean getSupportsRequestBody(HttpMethod httpMethod) {
        httpMethod.getClass();
        return !REQUESTS_WITHOUT_BODY.contains(httpMethod);
    }

    public static /* synthetic */ void getSupportsRequestBody$annotations(HttpMethod httpMethod) {
    }
}
