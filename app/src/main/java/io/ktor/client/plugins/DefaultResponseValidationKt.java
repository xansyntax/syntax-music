package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "", "addDefaultResponseValidation", "(Lio/ktor/client/HttpClientConfig;)V", "Lio/ktor/util/AttributeKey;", "ValidateMark", "Lio/ktor/util/AttributeKey;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "", "NO_RESPONSE_TEXT", "Ljava/lang/String;", "BODY_FAILED_DECODING", "DEPRECATED_EXCEPTION_CTOR", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultResponseValidationKt {
    private static final String BODY_FAILED_DECODING = "<body failed decoding>";
    private static final String DEPRECATED_EXCEPTION_CTOR = "Please, provide response text in constructor";
    private static final Logger LOGGER;
    private static final String NO_RESPONSE_TEXT = "<no response text provided>";
    private static final AttributeKey<Unit> ValidateMark;

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        ValidateMark = new AttributeKey<>("ValidateMark", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultResponseValidation");
    }

    public static final void addDefaultResponseValidation(HttpClientConfig<?> httpClientConfig) {
        httpClientConfig.getClass();
        HttpCallValidatorKt.HttpResponseValidator(httpClientConfig, new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 3, httpClientConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addDefaultResponseValidation$lambda$0(HttpClientConfig httpClientConfig, HttpCallValidatorConfig httpCallValidatorConfig) {
        httpCallValidatorConfig.getClass();
        httpCallValidatorConfig.setExpectSuccess$ktor_client_core(httpClientConfig.getExpectSuccess());
        httpCallValidatorConfig.validateResponse(new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(null));
        return Unit.INSTANCE;
    }
}
