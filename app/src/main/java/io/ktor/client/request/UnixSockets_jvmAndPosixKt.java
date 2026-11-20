package io.ktor.client.request;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "path", "", "unixSocket", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UnixSockets_jvmAndPosixKt {
    @Deprecated
    public static final /* synthetic */ void unixSocket(HttpRequestBuilder httpRequestBuilder, String str) {
        httpRequestBuilder.getClass();
        str.getClass();
        httpRequestBuilder.setCapability(UnixSocketCapability.INSTANCE, new UnixSocketSettings(str));
    }
}
