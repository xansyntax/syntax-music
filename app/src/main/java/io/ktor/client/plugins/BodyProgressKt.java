package io.ktor.client.plugins;

import io.ktor.client.call.DelegatedCallKt;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\b\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f\"#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/content/ProgressListener;", "listener", "withObservableDownload", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/content/ProgressListener;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "onDownload", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/content/ProgressListener;)V", "onUpload", "Lio/ktor/util/AttributeKey;", "UploadProgressListenerAttributeKey", "Lio/ktor/util/AttributeKey;", "DownloadProgressListenerAttributeKey", "Lio/ktor/client/plugins/api/ClientPlugin;", "BodyProgress", "Lio/ktor/client/plugins/api/ClientPlugin;", "getBodyProgress", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getBodyProgress$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BodyProgressKt {
    private static final ClientPlugin<Unit> BodyProgress;
    private static final AttributeKey<ProgressListener> DownloadProgressListenerAttributeKey;
    private static final AttributeKey<ProgressListener> UploadProgressListenerAttributeKey;

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        TypeReference typeReferenceTypeOf2 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable unused2) {
        }
        DownloadProgressListenerAttributeKey = new AttributeKey<>("DownloadProgressListenerAttributeKey", new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2));
        BodyProgress = CreatePluginUtilsKt.createClientPlugin("BodyProgress", new UserAgentKt$$ExternalSyntheticLambda0((byte) 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BodyProgress$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.on(AfterRenderHook.INSTANCE, new BodyProgressKt$BodyProgress$1$1(null));
        clientPluginBuilder.on(AfterReceiveHook.INSTANCE, new BodyProgressKt$BodyProgress$1$2(null));
        return Unit.INSTANCE;
    }

    public static final ClientPlugin<Unit> getBodyProgress() {
        return BodyProgress;
    }

    public static final void onDownload(HttpRequestBuilder httpRequestBuilder, ProgressListener progressListener) {
        httpRequestBuilder.getClass();
        if (progressListener == null) {
            httpRequestBuilder.getAttributes().remove(DownloadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(DownloadProgressListenerAttributeKey, progressListener);
        }
    }

    public static final void onUpload(HttpRequestBuilder httpRequestBuilder, ProgressListener progressListener) {
        httpRequestBuilder.getClass();
        if (progressListener == null) {
            httpRequestBuilder.getAttributes().remove(UploadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(UploadProgressListenerAttributeKey, progressListener);
        }
    }

    public static final HttpResponse withObservableDownload(HttpResponse httpResponse, ProgressListener progressListener) {
        httpResponse.getClass();
        progressListener.getClass();
        return DelegatedCallKt.replaceResponse$default(httpResponse.getCall(), null, new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 2, progressListener), 1, null).getResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel withObservableDownload$lambda$0(ProgressListener progressListener, HttpResponse httpResponse) {
        httpResponse.getClass();
        return ByteChannelUtilsKt.observable(httpResponse.getRawContent(), httpResponse.getCoroutineContext(), HttpMessagePropertiesKt.contentLength(httpResponse), progressListener);
    }

    public static /* synthetic */ void getBodyProgress$annotations() {
    }
}
