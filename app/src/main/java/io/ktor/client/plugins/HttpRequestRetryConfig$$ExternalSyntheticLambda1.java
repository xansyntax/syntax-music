package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpRequestRetryConfig$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ HttpRequestRetryConfig$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean zNoRetry$lambda$0;
        HttpRetryShouldRetryContext httpRetryShouldRetryContext = (HttpRetryShouldRetryContext) obj;
        switch (this.$r8$classId) {
            case 0:
                zNoRetry$lambda$0 = HttpRequestRetryConfig.noRetry$lambda$0(httpRetryShouldRetryContext, (HttpRequest) obj2, (HttpResponse) obj3);
                break;
            case 1:
                zNoRetry$lambda$0 = HttpRequestRetryConfig.noRetry$lambda$1(httpRetryShouldRetryContext, (HttpRequestBuilder) obj2, (Throwable) obj3);
                break;
            default:
                zNoRetry$lambda$0 = HttpRequestRetryConfig.retryOnServerErrors$lambda$0(httpRetryShouldRetryContext, (HttpRequest) obj2, (HttpResponse) obj3);
                break;
        }
        return Boolean.valueOf(zNoRetry$lambda$0);
    }
}
