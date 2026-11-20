package com.metrolist.innertube;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.plugins.DefaultRequestKt;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import java.io.File;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InnerTube$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube f$0;

    public /* synthetic */ InnerTube$$ExternalSyntheticLambda0(InnerTube innerTube, byte b) {
        this.$r8$classId = b;
        this.f$0 = innerTube;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 0;
        byte b3 = 1;
        Unit unit = Unit.INSTANCE;
        InnerTube innerTube = this.f$0;
        switch (b) {
            case 0:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.setExpectSuccess(false);
                httpClientConfig.install(ContentNegotiationKt.getContentNegotiation(), new YouTube$$ExternalSyntheticLambda0((byte) 14));
                httpClientConfig.install(ContentEncodingKt.getContentEncoding(), new YouTube$$ExternalSyntheticLambda0((byte) 15));
                httpClientConfig.engine(new InnerTube$$ExternalSyntheticLambda0(innerTube, b3));
                httpClientConfig.install(HttpTimeoutKt.getHttpTimeout(), new YouTube$$ExternalSyntheticLambda0((byte) 16));
                DefaultRequestKt.defaultRequest(httpClientConfig, new YouTube$$ExternalSyntheticLambda0((byte) 17));
                break;
            case 1:
                OkHttpConfig okHttpConfig = (OkHttpConfig) obj;
                okHttpConfig.getClass();
                okHttpConfig.config(new InnerTube$$ExternalSyntheticLambda0(innerTube, (byte) 2));
                break;
            default:
                OkHttpClient.Builder builder = (OkHttpClient.Builder) obj;
                builder.getClass();
                builder.connectionPool = new ConnectionPool(10);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout(30L, timeUnit);
                builder.readTimeout(60L, timeUnit);
                builder.writeTimeout(60L, timeUnit);
                builder.protocols(CollectionsKt__IterablesKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1}));
                builder.retryOnConnectionFailure = true;
                builder.cache = new Cache(new File(System.getProperty("java.io.tmpdir"), "http_cache"));
                Proxy proxy = innerTube.configuredProxy;
                if (proxy != null) {
                    builder.proxy(proxy);
                }
                String str = innerTube.configuredProxyAuth;
                if (str != null) {
                    builder.proxyAuthenticator(new InnerTube$$ExternalSyntheticLambda8(str, b2));
                }
                break;
        }
        return unit;
    }
}
