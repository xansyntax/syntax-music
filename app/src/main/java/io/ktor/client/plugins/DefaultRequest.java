package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UnixSocketCapability;
import io.ktor.client.request.UnixSocketSettings;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u001d\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest;", "", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "block", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Plugin", "DefaultRequestBuilder", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultRequest {

    /* JADX INFO: renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<DefaultRequest> key;
    private final Function1 block;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultRequest.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(DefaultRequest.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("DefaultRequest", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    private DefaultRequest(Function1 function1) {
        this.block = function1;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultRequest$Plugin, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/client/plugins/DefaultRequest;", "<init>", "()V", "Lio/ktor/http/Url;", "baseUrl", "Lio/ktor/http/URLBuilder;", "requestUrl", "", "mergeUrls", "(Lio/ktor/http/Url;Lio/ktor/http/URLBuilder;)V", "", "", "parent", "child", "concatenatePath", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lkotlin/Function1;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/DefaultRequest;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/DefaultRequest;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> concatenatePath(List<String> parent, List<String> child) {
            if (child.isEmpty()) {
                return parent;
            }
            if (parent.isEmpty() || ((CharSequence) CollectionsKt.first((List) child)).length() == 0) {
                return child;
            }
            ListBuilder listBuilder = new ListBuilder((child.size() + parent.size()) - 1);
            int size = parent.size() - 1;
            for (int i = 0; i < size; i++) {
                listBuilder.add(parent.get(i));
            }
            listBuilder.addAll(child);
            return CollectionsKt__IterablesKt.build(listBuilder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void mergeUrls(Url baseUrl, URLBuilder requestUrl) {
            if (requestUrl.getProtocolOrNull() == null) {
                requestUrl.setProtocolOrNull(baseUrl.getProtocolOrNull());
            }
            if (requestUrl.getHost().length() > 0) {
                return;
            }
            URLBuilder URLBuilder = URLUtilsKt.URLBuilder(baseUrl);
            URLBuilder.setProtocolOrNull(requestUrl.getProtocolOrNull());
            if (requestUrl.getPort() != 0) {
                URLBuilder.setPort(requestUrl.getPort());
            }
            URLBuilder.setEncodedPathSegments(DefaultRequest.INSTANCE.concatenatePath(URLBuilder.getEncodedPathSegments(), requestUrl.getEncodedPathSegments()));
            if (requestUrl.getEncodedFragment().length() > 0) {
                URLBuilder.setEncodedFragment(requestUrl.getEncodedFragment());
            }
            ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
            StringValuesKt.appendAll(parametersBuilderParametersBuilder$default, URLBuilder.getEncodedParameters());
            URLBuilder.setEncodedParameters(requestUrl.getEncodedParameters());
            Iterator<T> it = parametersBuilderParametersBuilder$default.entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!URLBuilder.getEncodedParameters().contains(str)) {
                    URLBuilder.getEncodedParameters().appendAll(str, list);
                }
            }
            URLUtilsKt.takeFrom(requestUrl, URLBuilder);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<DefaultRequest> getKey() {
            return DefaultRequest.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(DefaultRequest plugin, HttpClient scope) {
            plugin.getClass();
            scope.getClass();
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new DefaultRequest$Plugin$install$1(plugin, null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public DefaultRequest prepare(Function1 block) {
            block.getClass();
            return new DefaultRequest(block, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DefaultRequest(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJS\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\u0010J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u0012J!\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0017\u0010\tJ-\u0010\u001d\u001a\u00020\u0006\"\b\b\u0000\u0010\u0019*\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010\f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0012R$\u0010\u000e\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/http/URLBuilder;", "", "block", "url", "(Lkotlin/jvm/functions/Function1;)V", "", "scheme", "host", "", "port", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "urlString", "(Ljava/lang/String;)V", "Lio/ktor/http/HeadersBuilder;", "headers", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/HeadersBuilder;", "Lio/ktor/util/Attributes;", "setAttributes", "", "T", "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "capability", "setCapability", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "unixSocket", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "value", "getHost", "()Ljava/lang/String;", "setHost", "getPort", "()I", "setPort", "(I)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {
        private final HeadersBuilder headers = new HeadersBuilder(0, 1, null);
        private final URLBuilder url = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        private final Attributes attributes = AttributesJvmKt.Attributes(true);

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map setCapability$lambda$0() {
            return new LinkedHashMap();
        }

        public static /* synthetic */ void url$default(DefaultRequestBuilder defaultRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            if ((i & 16) != 0) {
                function1 = new UserAgentKt$$ExternalSyntheticLambda0((byte) 2);
            }
            defaultRequestBuilder.url(str, str2, num, str3, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit url$lambda$0(URLBuilder uRLBuilder) {
            uRLBuilder.getClass();
            return Unit.INSTANCE;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        @Override // io.ktor.http.HttpMessageBuilder
        public HeadersBuilder getHeaders() {
            return this.headers;
        }

        public final String getHost() {
            return this.url.getHost();
        }

        public final int getPort() {
            return this.url.getPort();
        }

        public final URLBuilder getUrl() {
            return this.url;
        }

        public final HeadersBuilder headers(Function1 block) {
            block.getClass();
            HeadersBuilder headers = getHeaders();
            block.invoke(headers);
            return headers;
        }

        public final void setAttributes(Function1 block) {
            block.getClass();
            block.invoke(this.attributes);
        }

        public final <T> void setCapability(HttpClientEngineCapability<T> key, T capability) {
            key.getClass();
            capability.getClass();
            ((Map) this.attributes.computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), new DoubleReceivePluginKt$$ExternalSyntheticLambda0((byte) 2))).put(key, capability);
        }

        public final void setHost(String str) {
            str.getClass();
            if (StringsKt.contains(str, "/", false) || StringsKt.contains(str, "?", false) || StringsKt.contains(str, "#", false)) {
                DefaultRequestKt.LOGGER.warn("DefaultRequest.host was set to '" + str + "', which is not a valid host. Host must not contain scheme, path, query or fragment. Use `url(...)` or `url{ ... }` instead.");
            }
            this.url.setHost(str);
        }

        public final void setPort(int i) {
            this.url.setPort(i);
        }

        public final void unixSocket(String path) {
            path.getClass();
            setCapability(UnixSocketCapability.INSTANCE, new UnixSocketSettings(path));
        }

        public final void url(Function1 block) {
            block.getClass();
            block.invoke(this.url);
        }

        public final void url(String scheme, String host, Integer port, String path, Function1 block) {
            block.getClass();
            URLBuilderKt.set(this.url, scheme, host, port, path, block);
        }

        public final void url(String urlString) {
            urlString.getClass();
            URLParserKt.takeFrom(this.url, urlString);
        }
    }
}
