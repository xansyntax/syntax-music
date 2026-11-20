package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.sse.ClientSSESession;
import io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization;
import io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0018\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"$\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "Lio/ktor/http/ContentType;", "contentType", "", "exclude", "(Lio/ktor/client/request/HttpRequestBuilder;[Lio/ktor/http/ContentType;)V", "", "", "supportedSuffixTypes", "Ljava/util/Map;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "", "Lkotlin/reflect/KClass;", "DefaultCommonIgnoredTypes", "Ljava/util/Set;", "getDefaultCommonIgnoredTypes", "()Ljava/util/Set;", "Lio/ktor/util/AttributeKey;", "", "ExcludedContentTypes", "Lio/ktor/util/AttributeKey;", "getExcludedContentTypes", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "ContentNegotiation", "Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation$annotations", "()V", "ktor-client-content-negotiation"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentNegotiationKt {
    private static final ClientPlugin<ContentNegotiationConfig> ContentNegotiation;
    private static final Set<KClass<?>> DefaultCommonIgnoredTypes;
    private static final AttributeKey<List<ContentType>> ExcludedContentTypes;
    private static final Logger LOGGER;
    private static final Map<ContentType, String> supportedSuffixTypes;

    static {
        TypeReference typeReferenceTypeOf;
        ContentType.Application application = ContentType.Application.INSTANCE;
        supportedSuffixTypes = MapsKt__MapsKt.mapOf(new Pair(application.getJson(), "json"), new Pair(application.getXml(), "xml"), new Pair(new ContentType(ContentType.Application.TYPE, "fastinfoset", null, 4, null), "fastinfoset"), new Pair(new ContentType(ContentType.Application.TYPE, "vnd.wap.wbxml", null, 4, null), "wbxml"), new Pair(application.getZip(), "zip"));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
        byte b = 4;
        DefaultCommonIgnoredTypes = ArraysKt.toSet(new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class), Reflection.getOrCreateKotlinClass(ClientSSESession.class), Reflection.getOrCreateKotlinClass(ClientSSESessionWithDeserialization.class)});
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ContentType.class)));
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        ExcludedContentTypes = new AttributeKey<>("ExcludedContentTypesAttr", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ContentNegotiation = CreatePluginUtilsKt.createClientPlugin("ContentNegotiation", ContentNegotiationKt$ContentNegotiation$1.INSTANCE, new SSEKt$$ExternalSyntheticLambda0(b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentNegotiation$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        List<ContentNegotiationConfig.ConverterRegistration> registrations$ktor_client_content_negotiation = ((ContentNegotiationConfig) clientPluginBuilder.getPluginConfig()).getRegistrations$ktor_client_content_negotiation();
        Set<KClass<?>> ignoredTypes$ktor_client_content_negotiation = ((ContentNegotiationConfig) clientPluginBuilder.getPluginConfig()).getIgnoredTypes$ktor_client_content_negotiation();
        clientPluginBuilder.transformRequestBody(new ContentNegotiationKt$ContentNegotiation$2$1(registrations$ktor_client_content_negotiation, clientPluginBuilder, ignoredTypes$ktor_client_content_negotiation, null));
        clientPluginBuilder.transformResponseBody(new ContentNegotiationKt$ContentNegotiation$2$2(ignoredTypes$ktor_client_content_negotiation, registrations$ktor_client_content_negotiation, clientPluginBuilder, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0263  */
    /* JADX WARN: Code duplicated, block: B:102:0x0273  */
    /* JADX WARN: Code duplicated, block: B:105:0x0285  */
    /* JADX WARN: Code duplicated, block: B:106:0x0287  */
    /* JADX WARN: Code duplicated, block: B:109:0x02ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:113:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:115:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:117:0x02df  */
    /* JADX WARN: Code duplicated, block: B:119:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:126:0x032d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Iterable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x02ac -> B:111:0x02b0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object ContentNegotiation$lambda$0$convertRequest(java.util.List<io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig.ConverterRegistration> r13, io.ktor.client.plugins.api.ClientPluginBuilder<io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig> r14, java.util.Set<? extends kotlin.reflect.KClass<?>> r15, io.ktor.client.request.HttpRequestBuilder r16, java.lang.Object r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instruction units count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest(java.util.List, io.ktor.client.plugins.api.ClientPluginBuilder, java.util.Set, io.ktor.client.request.HttpRequestBuilder, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence ContentNegotiation$lambda$0$convertRequest$12(ContentNegotiationConfig.ConverterRegistration converterRegistration) {
        converterRegistration.getClass();
        return converterRegistration.getConverter().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object ContentNegotiation$lambda$0$convertResponse(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation continuation) {
        ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 contentNegotiationKt$ContentNegotiation$2$convertResponse$1;
        if (continuation instanceof ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = (ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) continuation;
            int i = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = i - Integer.MIN_VALUE;
            } else {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
            }
        } else {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
        }
        Object objDeserialize = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.result;
        int i2 = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDeserialize);
            if (!(obj instanceof ByteReadChannel)) {
                Logger logger = LOGGER;
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Response body is already transformed. Skipping ContentNegotiation for " + url + '.');
                    return null;
                }
            } else if (set.contains(typeInfo.getType())) {
                Logger logger2 = LOGGER;
                if (LoggerJvmKt.isTraceEnabled(logger2)) {
                    logger2.trace("Response body type " + typeInfo.getType() + " is in ignored types. Skipping ContentNegotiation for " + url + '.');
                    return null;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (((ContentNegotiationConfig.ConverterRegistration) obj2).getContentTypeMatcher().contains(contentType)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    arrayList2.add(((ContentNegotiationConfig.ConverterRegistration) obj3).getConverter());
                }
                if (arrayList2.isEmpty()) {
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    Logger logger3 = LOGGER;
                    if (LoggerJvmKt.isTraceEnabled(logger3)) {
                        logger3.trace("None of the registered converters match response with Content-Type=" + contentType + ". Skipping ContentNegotiation for " + url + '.');
                    }
                } else {
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$1 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$2 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$3 = url;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$4 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$5 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$6 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$7 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$8 = null;
                    contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = 1;
                    objDeserialize = ContentConverterKt.deserialize(arrayList2, (ByteReadChannel) obj, typeInfo, charset, contentNegotiationKt$ContentNegotiation$2$convertResponse$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objDeserialize == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            return null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        url = (Url) contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$3;
        ResultKt.throwOnFailure(objDeserialize);
        Logger logger4 = LOGGER;
        if (logger4.isTraceEnabled() && !(objDeserialize instanceof ByteReadChannel)) {
            logger4.trace("Response body was converted to " + Reflection.getOrCreateKotlinClass(objDeserialize.getClass()) + " for " + url + '.');
        }
        return objDeserialize;
    }

    public static final void exclude(HttpRequestBuilder httpRequestBuilder, ContentType... contentTypeArr) {
        httpRequestBuilder.getClass();
        contentTypeArr.getClass();
        Attributes attributes = httpRequestBuilder.getAttributes();
        AttributeKey<List<ContentType>> attributeKey = ExcludedContentTypes;
        Collection collection = (List) attributes.getOrNull(attributeKey);
        if (collection == null) {
            collection = EmptyList.INSTANCE;
        }
        Attributes attributes2 = httpRequestBuilder.getAttributes();
        ArrayList arrayList = new ArrayList(collection.size() + contentTypeArr.length);
        arrayList.addAll(collection);
        List listAsList = Arrays.asList(contentTypeArr);
        listAsList.getClass();
        arrayList.addAll(listAsList);
        attributes2.put(attributeKey, arrayList);
    }

    public static final ClientPlugin<ContentNegotiationConfig> getContentNegotiation() {
        return ContentNegotiation;
    }

    public static final Set<KClass<?>> getDefaultCommonIgnoredTypes() {
        return DefaultCommonIgnoredTypes;
    }

    public static final AttributeKey<List<ContentType>> getExcludedContentTypes() {
        return ExcludedContentTypes;
    }

    public static /* synthetic */ void getContentNegotiation$annotations() {
    }
}
