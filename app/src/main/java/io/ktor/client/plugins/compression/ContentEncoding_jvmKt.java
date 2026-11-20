package io.ktor.client.plugins.compression;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "response", "", "shouldDecode", "(Lio/ktor/client/statement/HttpResponse;)Z", "ktor-client-encoding"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentEncoding_jvmKt {
    public static final boolean shouldDecode(HttpResponse httpResponse) {
        httpResponse.getClass();
        return httpResponse.getHeaders().get(HttpHeaders.ContentEncoding) != null;
    }
}
