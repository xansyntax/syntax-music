package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpRequestRetryConfig$$ExternalSyntheticLambda3 implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return HttpRequestRetryConfig.modifyRequest$lambda$0((HttpRetryModifyRequestContext) obj, (HttpRequestBuilder) obj2);
    }
}
