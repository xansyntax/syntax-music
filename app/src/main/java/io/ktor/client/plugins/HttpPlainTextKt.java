package io.ktor.client.plugins;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.StringsKt__Strings_jvmKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpPlainTextConfig;", "", "block", "Charsets", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpPlainText", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpPlainText", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpPlainTextKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpPlainText");
    private static final ClientPlugin<HttpPlainTextConfig> HttpPlainText = CreatePluginUtilsKt.createClientPlugin("HttpPlainText", HttpPlainTextKt$HttpPlainText$1.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0(7));

    public static final void Charsets(HttpClientConfig<?> httpClientConfig, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        httpClientConfig.install(HttpPlainText, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0121  */
    /* JADX WARN: Code duplicated, block: B:40:0x012b  */
    /* JADX WARN: Code duplicated, block: B:45:0x014a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0156  */
    /* JADX WARN: Code duplicated, block: B:52:0x016b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0183  */
    /* JADX WARN: Code duplicated, block: B:57:0x018d  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:? A[LOOP:2: B:38:0x0125->B:85:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ba A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static final Unit HttpPlainText$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        StringBuilder sb;
        String string;
        double d;
        Set<Charset> setKeySet;
        Iterator<T> it;
        clientPluginBuilder.getClass();
        Map<Charset, Float> charsetQuality$ktor_client_core = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsetQuality$ktor_client_core();
        charsetQuality$ktor_client_core.getClass();
        int size = charsetQuality$ktor_client_core.size();
        List listListOf = EmptyList.INSTANCE;
        if (size != 0) {
            Iterator<Map.Entry<Charset, Float>> it2 = charsetQuality$ktor_client_core.entrySet().iterator();
            if (it2.hasNext()) {
                Map.Entry<Charset, Float> next = it2.next();
                if (it2.hasNext()) {
                    ArrayList arrayList = new ArrayList(charsetQuality$ktor_client_core.size());
                    arrayList.add(new Pair(next.getKey(), next.getValue()));
                    do {
                        Map.Entry<Charset, Float> next2 = it2.next();
                        arrayList.add(new Pair(next2.getKey(), next2.getValue()));
                    } while (it2.hasNext());
                    listListOf = arrayList;
                } else {
                    listListOf = CollectionsKt__IterablesKt.listOf(new Pair(next.getKey(), next.getValue()));
                }
            }
        }
        List<Pair> listSortedWith = CollectionsKt.sortedWith(listListOf, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$0$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return RegexKt.compareValues((Float) ((Pair) t2).second, (Float) ((Pair) t).second);
            }
        });
        Charset responseCharsetFallback = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getResponseCharsetFallback();
        Set<Charset> charsets$ktor_client_core = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsets$ktor_client_core();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : charsets$ktor_client_core) {
            if (!((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsetQuality$ktor_client_core().containsKey((Charset) obj)) {
                arrayList2.add(obj);
            }
        }
        List<Charset> listSortedWith2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$0$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return RegexKt.compareValues(CharsetJVMKt.getName((Charset) t), CharsetJVMKt.getName((Charset) t2));
            }
        });
        Set<Charset> charsets$ktor_client_core2 = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsets$ktor_client_core();
        if ((charsets$ktor_client_core2 instanceof Collection) && charsets$ktor_client_core2.isEmpty()) {
            setKeySet = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsetQuality$ktor_client_core().keySet();
            if (setKeySet instanceof Collection) {
                it = setKeySet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!Intrinsics.areEqual((Charset) it.next(), Charsets.UTF_8)) {
                            sb = new StringBuilder();
                            for (Charset charset : listSortedWith2) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(CharsetJVMKt.getName(charset));
                            }
                            for (Pair pair : listSortedWith) {
                                Charset charset2 = (Charset) pair.first;
                                float fFloatValue = ((Number) pair.second).floatValue();
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                d = fFloatValue;
                                if (0.0d <= d) {
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                                return null;
                            }
                            string = sb.toString();
                        }
                    }
                }
            } else {
                it = setKeySet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!Intrinsics.areEqual((Charset) it.next(), Charsets.UTF_8)) {
                            sb = new StringBuilder();
                            while (r4.hasNext()) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(CharsetJVMKt.getName(charset));
                            }
                            while (r4.hasNext()) {
                                Charset charset3 = (Charset) pair.first;
                                float fFloatValue2 = ((Number) pair.second).floatValue();
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                d = fFloatValue2;
                                if (0.0d <= d) {
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                                return null;
                            }
                            string = sb.toString();
                        }
                    }
                }
            }
            string = null;
        } else {
            Iterator<T> it3 = charsets$ktor_client_core2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    setKeySet = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getCharsetQuality$ktor_client_core().keySet();
                    if ((setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
                        it = setKeySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!Intrinsics.areEqual((Charset) it.next(), Charsets.UTF_8)) {
                                }
                            }
                        }
                    }
                    string = null;
                } else if (!Intrinsics.areEqual((Charset) it3.next(), Charsets.UTF_8)) {
                }
                sb = new StringBuilder();
                while (r4.hasNext()) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(CharsetJVMKt.getName(charset));
                }
                while (r4.hasNext()) {
                    Charset charset4 = (Charset) pair.first;
                    float fFloatValue3 = ((Number) pair.second).floatValue();
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    d = fFloatValue3;
                    if (0.0d <= d || d > 1.0d) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                        return null;
                    }
                    sb.append(CharsetJVMKt.getName(charset4) + ";q=" + (((double) MathKt.roundToInt(100.0f * fFloatValue3)) / 100.0d));
                }
                string = sb.toString();
            }
        }
        Charset sendCharset = ((HttpPlainTextConfig) clientPluginBuilder.getPluginConfig()).getSendCharset();
        if (sendCharset == null && (sendCharset = (Charset) CollectionsKt.firstOrNull(listSortedWith2)) == null) {
            Pair pair2 = (Pair) CollectionsKt.firstOrNull(listSortedWith);
            sendCharset = pair2 != null ? (Charset) pair2.first : null;
            if (sendCharset == null) {
                sendCharset = Charsets.UTF_8;
            }
        }
        clientPluginBuilder.on(RenderRequestHook.INSTANCE, new HttpPlainTextKt$HttpPlainText$2$1(string, sendCharset, null));
        clientPluginBuilder.transformResponseBody(new HttpPlainTextKt$HttpPlainText$2$2(responseCharsetFallback, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HttpPlainText$lambda$0$addAcceptCharsetHeader(HttpRequestBuilder httpRequestBuilder, String str) {
        if (str == null || httpRequestBuilder.getHeaders().get(HttpHeaders.AcceptCharset) != null) {
            return;
        }
        Logger logger = LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Adding Accept-Charset=", str, " to ");
            sbM4m.append(httpRequestBuilder.getUrl());
            logger.trace(sbM4m.toString());
        }
        httpRequestBuilder.getHeaders().set(HttpHeaders.AcceptCharset, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HttpPlainText$lambda$0$read(Charset charset, HttpClientCall httpClientCall, Source source) {
        Charset charset2 = HttpMessagePropertiesKt.charset(httpClientCall.getResponse());
        if (charset2 != null) {
            charset = charset2;
        }
        Logger logger = LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Reading response body for " + httpClientCall.getRequest().getUrl() + " as String with charset " + charset);
        }
        return StringsKt__Strings_jvmKt.readText$default(source, charset, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingContent HttpPlainText$lambda$0$wrapContent(Charset charset, HttpRequestBuilder httpRequestBuilder, String str, ContentType contentType) {
        Charset charset2;
        ContentType plain = contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType;
        if (contentType != null && (charset2 = ContentTypesKt.charset(contentType)) != null) {
            charset = charset2;
        }
        Logger logger = LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Sending request body to " + httpRequestBuilder.getUrl() + " as text/plain with charset " + charset);
        }
        return new TextContent(str, ContentTypesKt.withCharset(plain, charset), null, 4, null);
    }

    public static final ClientPlugin<HttpPlainTextConfig> getHttpPlainText() {
        return HttpPlainText;
    }
}
