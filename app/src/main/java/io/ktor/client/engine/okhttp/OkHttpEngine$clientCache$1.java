package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.HttpTimeoutConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class OkHttpEngine$clientCache$1 extends FunctionReferenceImpl implements Function1 {
    public OkHttpEngine$clientCache$1(Object obj) {
        super(1, obj, OkHttpEngine.class, "createOkHttpClient", "createOkHttpClient(Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final OkHttpClient invoke(HttpTimeoutConfig httpTimeoutConfig) {
        return ((OkHttpEngine) this.receiver).createOkHttpClient(httpTimeoutConfig);
    }
}
