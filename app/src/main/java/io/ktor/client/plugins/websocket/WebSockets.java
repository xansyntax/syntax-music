package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.DefaultWebSocketSessionKt;
import io.ktor.websocket.WebSocketChannelsConfig;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketExtensionHeaderKt;
import io.ktor.websocket.WebSocketExtensionsConfig;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 /2\u00020\u0001:\u00020/B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\rB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b'\u0010&R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010(R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets;", "", "", "pingIntervalMillis", "maxFrameSize", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensionsConfig", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "<init>", "(JJLio/ktor/websocket/WebSocketExtensionsConfig;Lio/ktor/serialization/WebsocketContentConverter;Lio/ktor/websocket/WebSocketChannelsConfig;)V", "(JJ)V", "()V", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "", "installExtensions", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "", "Lio/ktor/websocket/WebSocketExtension;", "completeNegotiation", "(Lio/ktor/client/call/HttpClientCall;)Ljava/util/List;", "Lio/ktor/websocket/WebSocketExtensionHeader;", "protocols", "addNegotiatedProtocols", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/util/List;)V", "Lio/ktor/websocket/WebSocketSession;", "session", "Lio/ktor/websocket/DefaultWebSocketSession;", "convertSessionToDefault$ktor_client_core", "(Lio/ktor/websocket/WebSocketSession;)Lio/ktor/websocket/DefaultWebSocketSession;", "convertSessionToDefault", "J", "getPingIntervalMillis", "()J", "getMaxFrameSize", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "Lio/ktor/websocket/WebSocketChannelsConfig;", "getChannelsConfig", "()Lio/ktor/websocket/WebSocketChannelsConfig;", "Plugin", "Config", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSockets {

    /* JADX INFO: renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<WebSockets> key;
    private final WebSocketChannelsConfig channelsConfig;
    private final WebsocketContentConverter contentConverter;
    private final WebSocketExtensionsConfig extensionsConfig;
    private final long maxFrameSize;
    private final long pingIntervalMillis;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WebSockets.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(WebSockets.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("Websocket", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    public /* synthetic */ WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter, WebSocketChannelsConfig webSocketChannelsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, webSocketExtensionsConfig, (i & 8) != 0 ? null : websocketContentConverter, (i & 16) != 0 ? WebSocketChannelsConfig.INSTANCE.getUNLIMITED() : webSocketChannelsConfig);
    }

    private final void addNegotiatedProtocols(HttpRequestBuilder context, List<WebSocketExtensionHeader> protocols) {
        if (protocols.isEmpty()) {
            return;
        }
        UtilsKt.header(context, HttpHeaders.SecWebSocketExtensions, CollectionsKt.joinToString$default(protocols, ",", null, null, null, 62));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WebSocketExtension<?>> completeNegotiation(HttpClientCall call) {
        List<WebSocketExtensionHeader> webSocketExtensions;
        String str = call.getResponse().getHeaders().get(HttpHeaders.SecWebSocketExtensions);
        if (str == null || (webSocketExtensions = WebSocketExtensionHeaderKt.parseWebSocketExtensions(str)) == null) {
            webSocketExtensions = EmptyList.INSTANCE;
        }
        List list = (List) call.getAttributes().get(WebSocketsKt.REQUEST_EXTENSIONS_KEY);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((WebSocketExtension) obj).clientNegotiation(webSocketExtensions)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installExtensions(HttpRequestBuilder context) {
        List<WebSocketExtension<?>> listBuild = this.extensionsConfig.build();
        context.getAttributes().put(WebSocketsKt.REQUEST_EXTENSIONS_KEY, listBuild);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listBuild.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(((WebSocketExtension) it.next()).getProtocols(), arrayList);
        }
        addNegotiatedProtocols(context, arrayList);
    }

    public final DefaultWebSocketSession convertSessionToDefault$ktor_client_core(WebSocketSession session) {
        session.getClass();
        if (session instanceof DefaultWebSocketSession) {
            return (DefaultWebSocketSession) session;
        }
        long j = this.pingIntervalMillis;
        DefaultWebSocketSession DefaultWebSocketSession = DefaultWebSocketSessionKt.DefaultWebSocketSession(session, j, 2 * j, this.channelsConfig);
        DefaultWebSocketSession.setMaxFrameSize(this.maxFrameSize);
        return DefaultWebSocketSession;
    }

    public final WebSocketChannelsConfig getChannelsConfig() {
        return this.channelsConfig;
    }

    public final WebsocketContentConverter getContentConverter() {
        return this.contentConverter;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.WebSockets$Plugin, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lio/ktor/client/plugins/websocket/WebSockets;", "<init>", "()V", "Lkotlin/Function1;", "", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/websocket/WebSockets;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/websocket/WebSockets;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, WebSockets> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<WebSockets> getKey() {
            return WebSockets.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(WebSockets plugin, HttpClient scope) {
            plugin.getClass();
            scope.getClass();
            boolean zContains = scope.getEngine().getSupportedCapabilities().contains(WebSocketExtensionsCapability.INSTANCE);
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getRender(), new WebSockets$Plugin$install$1(zContains, plugin, null));
            scope.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new WebSockets$Plugin$install$2(plugin, zContains, null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public WebSockets prepare(Function1 block) {
            block.getClass();
            Config config = new Config();
            block.invoke(config);
            return new WebSockets(config.getPingIntervalMillis(), config.getMaxFrameSize(), config.getExtensionsConfig(), config.getContentConverter(), config.getChannelsConfig());
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/websocket/WebSocketChannelsConfig;", "", "block", "channels", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensions", "extensionsConfig", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "getExtensionsConfig$ktor_client_core", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "channelsConfig", "Lio/ktor/websocket/WebSocketChannelsConfig;", "getChannelsConfig$ktor_client_core", "()Lio/ktor/websocket/WebSocketChannelsConfig;", "getChannelsConfig$ktor_client_core$annotations", "", "pingIntervalMillis", "J", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "maxFrameSize", "getMaxFrameSize", "setMaxFrameSize", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "setContentConverter", "(Lio/ktor/serialization/WebsocketContentConverter;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        private WebsocketContentConverter contentConverter;
        private long pingIntervalMillis;
        private final WebSocketExtensionsConfig extensionsConfig = new WebSocketExtensionsConfig();
        private final WebSocketChannelsConfig channelsConfig = new WebSocketChannelsConfig();
        private long maxFrameSize = 2147483647L;

        public final void channels(Function1 block) {
            block.getClass();
            block.invoke(this.channelsConfig);
        }

        public final void extensions(Function1 block) {
            block.getClass();
            block.invoke(this.extensionsConfig);
        }

        /* JADX INFO: renamed from: getChannelsConfig$ktor_client_core, reason: from getter */
        public final WebSocketChannelsConfig getChannelsConfig() {
            return this.channelsConfig;
        }

        public final WebsocketContentConverter getContentConverter() {
            return this.contentConverter;
        }

        /* JADX INFO: renamed from: getExtensionsConfig$ktor_client_core, reason: from getter */
        public final WebSocketExtensionsConfig getExtensionsConfig() {
            return this.extensionsConfig;
        }

        public final long getMaxFrameSize() {
            return this.maxFrameSize;
        }

        public final long getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        public final void setContentConverter(WebsocketContentConverter websocketContentConverter) {
            this.contentConverter = websocketContentConverter;
        }

        public final void setMaxFrameSize(long j) {
            this.maxFrameSize = j;
        }

        public final void setPingIntervalMillis(long j) {
            this.pingIntervalMillis = j;
        }

        public static /* synthetic */ void getChannelsConfig$ktor_client_core$annotations() {
        }
    }

    public WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter, WebSocketChannelsConfig webSocketChannelsConfig) {
        webSocketExtensionsConfig.getClass();
        webSocketChannelsConfig.getClass();
        this.pingIntervalMillis = j;
        this.maxFrameSize = j2;
        this.extensionsConfig = webSocketExtensionsConfig;
        this.contentConverter = websocketContentConverter;
        this.channelsConfig = webSocketChannelsConfig;
    }

    public /* synthetic */ WebSockets(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 2147483647L : j2);
    }

    public WebSockets(long j, long j2) {
        this(j, j2, new WebSocketExtensionsConfig(), null, null, 24, null);
    }

    public WebSockets() {
        this(0L, 2147483647L, new WebSocketExtensionsConfig(), null, null, 24, null);
    }
}
