package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpTimeoutKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ HttpTimeoutKt$$ExternalSyntheticLambda1(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                return HttpTimeoutKt.applyRequestTimeout$lambda$0((StandaloneCoroutine) obj2, (Throwable) obj);
            case 1:
                return DefaultTransformKt.AnonymousClass2.invokeSuspend$lambda$0$0((JobImpl) obj2, (Throwable) obj);
            case 2:
                return BodyProgressKt.withObservableDownload$lambda$0((ProgressListener) obj2, (HttpResponse) obj);
            case 3:
                return DefaultResponseValidationKt.addDefaultResponseValidation$lambda$0((HttpClientConfig) obj2, (HttpCallValidatorConfig) obj);
            case 4:
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$0((CompletableJob) obj2, (Throwable) obj);
            case 5:
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$1((DisposableHandle) obj2, (Throwable) obj);
            default:
                return HttpRequestRetryKt.HttpRequestRetry$lambda$0$prepareRequest$0((HttpRequestBuilder) obj2, (Throwable) obj);
        }
    }
}
