package io.ktor.http;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "", "entityTag", "", "etag", "(Lio/ktor/http/HeadersBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ApplicationResponsePropertiesKt {
    public static final void etag(HeadersBuilder headersBuilder, String str) {
        headersBuilder.getClass();
        str.getClass();
        headersBuilder.set(HttpHeaders.ETag, str);
    }
}
