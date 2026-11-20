package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0003*\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\b\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f\"\u001f\u0010\u0014\u001a\u00060\u000ej\u0002`\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\" \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u0019\"\u0015\u0010 \u001a\u00020\u001f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "e", "", "tryCancelBody", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "skipSaveBody", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "skipSavingBody", "Lio/ktor/util/AttributeKey;", "SKIP_SAVE_BODY", "Lio/ktor/util/AttributeKey;", "RESPONSE_BODY_SAVED", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER$delegate", "Lkotlin/Lazy;", "getLOGGER", "()Lorg/slf4j/Logger;", "LOGGER", "Lio/ktor/client/plugins/api/ClientPlugin;", "SaveBody", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBody", "()Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/SaveBodyPluginConfig;", "SaveBodyPlugin", "getSaveBodyPlugin", "getSaveBodyPlugin$annotations", "()V", "", "isSaved", "(Lio/ktor/client/statement/HttpResponse;)Z", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DoubleReceivePluginKt {
    private static final Lazy LOGGER$delegate;
    private static final AttributeKey<Unit> RESPONSE_BODY_SAVED;
    private static final AttributeKey<Unit> SKIP_SAVE_BODY;
    private static final ClientPlugin<Unit> SaveBody;
    private static final ClientPlugin<SaveBodyPluginConfig> SaveBodyPlugin;

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        TypeReference typeReferenceTypeOf2 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        byte b = 0;
        SKIP_SAVE_BODY = new AttributeKey<>("SkipSaveBody", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(Unit.class);
        } catch (Throwable unused2) {
        }
        RESPONSE_BODY_SAVED = new AttributeKey<>("ResponseBodySaved", new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2));
        LOGGER$delegate = new SynchronizedLazyImpl(new DoubleReceivePluginKt$$ExternalSyntheticLambda0(b));
        SaveBody = CreatePluginUtilsKt.createClientPlugin("SaveBody", new UserAgentKt$$ExternalSyntheticLambda0((byte) 3));
        SaveBodyPlugin = CreatePluginUtilsKt.createClientPlugin("DoubleReceivePlugin", DoubleReceivePluginKt$SaveBodyPlugin$1.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0((byte) 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger LOGGER_delegate$lambda$0() {
        return KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.SaveBody");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveBody$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.getClient().getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getBefore(), new DoubleReceivePluginKt$SaveBody$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveBodyPlugin$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        if (((SaveBodyPluginConfig) clientPluginBuilder.getPluginConfig()).getDisabled()) {
            getLOGGER().warn(Messages.SAVE_BODY_DISABLED_MESSAGE);
        } else {
            getLOGGER().warn(Messages.SAVE_BODY_ENABLED_MESSAGE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger getLOGGER() {
        return (Logger) LOGGER$delegate.getValue();
    }

    public static final ClientPlugin<Unit> getSaveBody() {
        return SaveBody;
    }

    public static final ClientPlugin<SaveBodyPluginConfig> getSaveBodyPlugin() {
        return SaveBodyPlugin;
    }

    public static final boolean isSaved(HttpResponse httpResponse) {
        httpResponse.getClass();
        return httpResponse.getCall().getAttributes().contains(RESPONSE_BODY_SAVED);
    }

    public static final void skipSaveBody(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getAttributes().put(SKIP_SAVE_BODY, Unit.INSTANCE);
    }

    @Deprecated
    public static final void skipSavingBody(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        getLOGGER().warn(Messages.SKIP_SAVING_BODY_MESSAGE);
    }

    public static final void tryCancelBody(HttpResponse httpResponse, Throwable th) {
        httpResponse.getClass();
        ByteReadChannel rawContent = httpResponse.getRawContent();
        if (rawContent.isClosedForRead()) {
            return;
        }
        try {
            rawContent.cancel(th);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            getLOGGER().debug("Failed to cancel response body", (Throwable) e2);
        }
    }

    public static /* synthetic */ void tryCancelBody$default(HttpResponse httpResponse, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        tryCancelBody(httpResponse, th);
    }

    @Deprecated
    public static /* synthetic */ void getSaveBodyPlugin$annotations() {
    }
}
