package io.ktor.client.plugins.compression;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.DelegatedCallKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HeadersKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.ReversedList;
import kotlin.collections.ReversedListReadOnly;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\r\u001a\u00020\u0005*\u00020\t2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\r\u001a\u00020\u0005*\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\r\u0010\u0011\"\u0018\u0010\u0014\u001a\u00060\u0012j\u0002`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0006¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\"&\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"&\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 \"\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f*\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;", "mode", "Lkotlin/Function1;", "Lio/ktor/client/plugins/compression/ContentEncodingConfig;", "", "block", "ContentEncoding", "(Lio/ktor/client/HttpClientConfig;Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "", "", "contentEncoderName", "compress", "(Lio/ktor/client/request/HttpRequestBuilder;[Ljava/lang/String;)V", "", "contentEncoderNames", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/util/List;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/api/ClientPlugin;", "getContentEncoding", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getContentEncoding$annotations", "()V", "Lio/ktor/util/AttributeKey;", "CompressionListAttribute", "Lio/ktor/util/AttributeKey;", "getCompressionListAttribute", "()Lio/ktor/util/AttributeKey;", "DecompressionListAttribute", "getDecompressionListAttribute", "Lio/ktor/client/statement/HttpResponse;", "getAppliedDecoders", "(Lio/ktor/client/statement/HttpResponse;)Ljava/util/List;", "appliedDecoders", "ktor-client-encoding"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentEncodingKt {
    private static final AttributeKey<List<String>> CompressionListAttribute;
    private static final AttributeKey<List<String>> DecompressionListAttribute;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.compression.ContentEncoding");
    private static final ClientPlugin<ContentEncodingConfig> ContentEncoding = CreatePluginUtilsKt.createClientPlugin("HttpEncoding", AnonymousClass1.INSTANCE, new SSEKt$$ExternalSyntheticLambda0(1));

    /* JADX INFO: renamed from: io.ktor.client.plugins.compression.ContentEncodingKt$ContentEncoding$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, ContentEncodingConfig.class, "<init>", "<init>()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ContentEncodingConfig invoke() {
            return new ContentEncodingConfig();
        }
    }

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        TypeReference typeReferenceTypeOf2 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        CompressionListAttribute = new AttributeKey<>("CompressionListAttribute", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(List.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
        } catch (Throwable unused2) {
        }
        DecompressionListAttribute = new AttributeKey<>("DecompressionListAttribute", new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2));
    }

    public static final void ContentEncoding(HttpClientConfig<?> httpClientConfig, ContentEncodingConfig.Mode mode, Function1 function1) {
        httpClientConfig.getClass();
        mode.getClass();
        function1.getClass();
        httpClientConfig.install(ContentEncoding, new FileChannelsKt$$ExternalSyntheticLambda1(mode, function1, (byte) 5));
    }

    public static /* synthetic */ void ContentEncoding$default(HttpClientConfig httpClientConfig, ContentEncodingConfig.Mode mode, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            mode = ContentEncodingConfig.Mode.DecompressResponse;
        }
        if ((i & 2) != 0) {
            function1 = new SSEKt$$ExternalSyntheticLambda0((byte) 2);
        }
        ContentEncoding(httpClientConfig, mode, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentEncoding$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        Map<String, ContentEncoder> encoders$ktor_client_encoding = ((ContentEncodingConfig) clientPluginBuilder.getPluginConfig()).getEncoders$ktor_client_encoding();
        Map<String, Float> qualityValues$ktor_client_encoding = ((ContentEncodingConfig) clientPluginBuilder.getPluginConfig()).getQualityValues$ktor_client_encoding();
        ContentEncodingConfig.Mode mode = ((ContentEncodingConfig) clientPluginBuilder.getPluginConfig()).getMode();
        StringBuilder sb = new StringBuilder();
        for (ContentEncoder contentEncoder : encoders$ktor_client_encoding.values()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(contentEncoder.getName());
            Float f = qualityValues$ktor_client_encoding.get(contentEncoder.getName());
            if (f != null) {
                float fFloatValue = f.floatValue();
                double d = fFloatValue;
                if (0.0d > d || d > 1.0d) {
                    throw new IllegalStateException(("Invalid quality value: " + fFloatValue + " for encoder: " + contentEncoder).toString());
                }
                sb.append(";q=".concat(StringsKt.take(5, String.valueOf(fFloatValue))));
            }
        }
        clientPluginBuilder.onRequest(new ContentEncodingKt$ContentEncoding$2$1(mode, sb.toString(), null));
        clientPluginBuilder.on(AfterRenderHook.INSTANCE, new ContentEncodingKt$ContentEncoding$2$2(mode, clientPluginBuilder, encoders$ktor_client_encoding, null));
        clientPluginBuilder.on(ReceiveStateHook.INSTANCE, new ContentEncodingKt$ContentEncoding$2$3(mode, encoders$ktor_client_encoding, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpResponse ContentEncoding$lambda$0$decode(Map<String, ? extends ContentEncoder> map, HttpResponse httpResponse) {
        if (!ContentEncoding_jvmKt.shouldDecode(httpResponse)) {
            return httpResponse;
        }
        String str = httpResponse.getHeaders().get(HttpHeaders.ContentEncoding);
        if (str == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Content-Encoding unavailable");
            return null;
        }
        List listSplit$default = StringsKt.split$default(str, new String[]{","}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            String lowerCase = StringsKt.trim((String) it.next()).toString().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            arrayList.add(lowerCase);
        }
        ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(reversedListReadOnly, 10));
        Iterator it2 = reversedListReadOnly.iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) ((ReversedList.AnonymousClass1) it2).delegateIterator;
            if (!listIterator.hasPrevious()) {
                Headers headers = HeadersKt.headers(new FileChannelsKt$$ExternalSyntheticLambda1(httpResponse, arrayList, (byte) 4));
                httpResponse.getCall().getAttributes().put(DecompressionListAttribute, arrayList);
                return DelegatedCallKt.replaceResponse(httpResponse.getCall(), headers, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList2, (byte) 11)).getResponse();
            }
            String str2 = (String) listIterator.previous();
            ContentEncoder contentEncoder = map.get(str2);
            if (contentEncoder == null) {
                throw new UnsupportedContentEncodingException(str2);
            }
            arrayList2.add(contentEncoder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentEncoding$lambda$0$decode$4(HttpResponse httpResponse, List list, HeadersBuilder headersBuilder) {
        headersBuilder.getClass();
        httpResponse.getHeaders().forEach(new URLParserKt$$ExternalSyntheticLambda0((byte) 9, headersBuilder));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!list.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            headersBuilder.append(HttpHeaders.ContentEncoding, CollectionsKt.joinToString$default(arrayList, ",", null, null, null, 62));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentEncoding$lambda$0$decode$4$0(HeadersBuilder headersBuilder, String str, List list) {
        str.getClass();
        list.getClass();
        boolean zEqualsIgnoreCase = str.equalsIgnoreCase(HttpHeaders.ContentEncoding);
        Unit unit = Unit.INSTANCE;
        if (!zEqualsIgnoreCase && !str.equalsIgnoreCase(HttpHeaders.ContentLength)) {
            headersBuilder.appendAll(str, list);
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel ContentEncoding$lambda$0$decode$5(List list, HttpResponse httpResponse) {
        httpResponse.getClass();
        return ContentEncoding$lambda$0$decodeContent(httpResponse, list);
    }

    private static final ByteReadChannel ContentEncoding$lambda$0$decodeContent(HttpResponse httpResponse, List<? extends ContentEncoder> list) {
        ByteReadChannel rawContent = httpResponse.getRawContent();
        for (ContentEncoder contentEncoder : list) {
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Decoding response with " + contentEncoder + " for " + httpResponse.getCall().getRequest().getUrl());
            }
            rawContent = contentEncoder.decode(rawContent, httpResponse.getCoroutineContext());
        }
        return rawContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentEncoding$lambda$1(ContentEncodingConfig contentEncodingConfig) {
        contentEncodingConfig.getClass();
        ContentEncodingConfig.gzip$default(contentEncodingConfig, null, 1, null);
        ContentEncodingConfig.deflate$default(contentEncodingConfig, null, 1, null);
        ContentEncodingConfig.identity$default(contentEncodingConfig, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentEncoding$lambda$2(ContentEncodingConfig.Mode mode, Function1 function1, ContentEncodingConfig contentEncodingConfig) {
        contentEncodingConfig.getClass();
        contentEncodingConfig.setMode(mode);
        function1.invoke(contentEncodingConfig);
        return Unit.INSTANCE;
    }

    public static final void compress(HttpRequestBuilder httpRequestBuilder, String... strArr) {
        httpRequestBuilder.getClass();
        strArr.getClass();
        httpRequestBuilder.getAttributes().put(CompressionListAttribute, ArraysKt.toList(strArr));
    }

    public static final List<String> getAppliedDecoders(HttpResponse httpResponse) {
        httpResponse.getClass();
        List<String> list = (List) httpResponse.getCall().getAttributes().getOrNull(DecompressionListAttribute);
        return list == null ? EmptyList.INSTANCE : list;
    }

    public static final AttributeKey<List<String>> getCompressionListAttribute() {
        return CompressionListAttribute;
    }

    public static final ClientPlugin<ContentEncodingConfig> getContentEncoding() {
        return ContentEncoding;
    }

    public static final AttributeKey<List<String>> getDecompressionListAttribute() {
        return DecompressionListAttribute;
    }

    public static /* synthetic */ void getContentEncoding$annotations() {
    }

    public static final void compress(HttpRequestBuilder httpRequestBuilder, List<String> list) {
        httpRequestBuilder.getClass();
        list.getClass();
        httpRequestBuilder.getAttributes().put(CompressionListAttribute, list);
    }
}
