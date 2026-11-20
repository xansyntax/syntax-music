package io.ktor.client;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@KtorDsl
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u000b\u001a\u00020\n\"\b\b\u0001\u0010\u0006*\u00020\u0003\"\b\b\u0002\u0010\u0007*\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u0012\u001a\u00020\n\"\b\b\u0001\u0010\u0006*\u00020\u0003\"\b\b\u0002\u0010\u0007*\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0014\u001a\u00020\n\"\b\b\u0001\u0010\u0006*\u00020\u0003\"\b\b\u0002\u0010\u0007*\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0014\u0010\u0013J)\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0012\u0010\u0018J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u001e\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0086\u0002¢\u0006\u0004\b\u001e\u0010\u001fR0\u0010\"\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\r0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010$\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\r0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R,\u0010%\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\r0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R.\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0010R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\"\u00105\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R(\u00108\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b8\u0010-\u0012\u0004\b;\u0010\u0005\u001a\u0004\b9\u0010/\"\u0004\b:\u00101¨\u0006<"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "", "<init>", "()V", "TBuilder", "TPlugin", "Lio/ktor/client/plugins/HttpClientPlugin;", "plugin", "", "installPlugin", "(Lio/ktor/client/plugins/HttpClientPlugin;)V", "Lkotlin/Function1;", "block", "engine", "(Lkotlin/jvm/functions/Function1;)V", "configure", "install", "(Lio/ktor/client/plugins/HttpClientPlugin;Lkotlin/jvm/functions/Function1;)V", "installOrReplace", "", "key", "Lio/ktor/client/HttpClient;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "client", "(Lio/ktor/client/HttpClient;)V", "clone", "()Lio/ktor/client/HttpClientConfig;", "other", "plusAssign", "(Lio/ktor/client/HttpClientConfig;)V", "", "Lio/ktor/util/AttributeKey;", "plugins", "Ljava/util/Map;", "pluginConfigurations", "customInterceptors", "engineConfig", "Lkotlin/jvm/functions/Function1;", "getEngineConfig$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "setEngineConfig$ktor_client_core", "", "followRedirects", "Z", "getFollowRedirects", "()Z", "setFollowRedirects", "(Z)V", "useDefaultTransformers", "getUseDefaultTransformers", "setUseDefaultTransformers", "expectSuccess", "getExpectSuccess", "setExpectSuccess", "developmentMode", "getDevelopmentMode", "setDevelopmentMode", "getDevelopmentMode$annotations", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    private boolean expectSuccess;
    private final Map<AttributeKey<?>, Function1> plugins = new LinkedHashMap();
    private final Map<AttributeKey<?>, Function1> pluginConfigurations = new LinkedHashMap();
    private final Map<String, Function1> customInterceptors = new LinkedHashMap();
    private Function1 engineConfig = new HttpClient$$ExternalSyntheticLambda1(19);
    private boolean followRedirects = true;
    private boolean useDefaultTransformers = true;
    private boolean developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit engine$lambda$0(Function1 function1, Function1 function2, HttpClientEngineConfig httpClientEngineConfig) {
        httpClientEngineConfig.getClass();
        function1.invoke(httpClientEngineConfig);
        function2.invoke(httpClientEngineConfig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit engineConfig$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
        httpClientEngineConfig.getClass();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void install$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new HttpClient$$ExternalSyntheticLambda1((byte) 18);
        }
        httpClientConfig.install(httpClientPlugin, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(Object obj) {
        obj.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$1(Function1 function1, Function1 function2, Object obj) {
        obj.getClass();
        if (function1 != null) {
            function1.invoke(obj);
        }
        function2.invoke(obj);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void installOrReplace$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new HttpClient$$ExternalSyntheticLambda1((byte) 20);
        }
        httpClientConfig.installOrReplace(httpClientPlugin, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit installOrReplace$lambda$0(Object obj) {
        obj.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit installOrReplace$lambda$1(Function1 function1, Object obj) {
        obj.getClass();
        function1.invoke(obj);
        return Unit.INSTANCE;
    }

    private final <TBuilder, TPlugin> void installPlugin(HttpClientPlugin<? extends TBuilder, TPlugin> plugin) {
        if (this.plugins.containsKey(plugin.getKey())) {
            return;
        }
        this.plugins.put(plugin.getKey(), new MimesKt$$ExternalSyntheticLambda0((byte) 23, plugin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit installPlugin$lambda$0(HttpClientPlugin httpClientPlugin, HttpClient httpClient) {
        httpClient.getClass();
        Attributes attributes = (Attributes) httpClient.getAttributes().computeIfAbsent(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST(), new Shazam$$ExternalSyntheticLambda0((byte) 21));
        Function1 function1 = ((HttpClientConfig) httpClient.getConfig$ktor_client_core()).pluginConfigurations.get(httpClientPlugin.getKey());
        function1.getClass();
        Object objPrepare = httpClientPlugin.prepare(function1);
        httpClientPlugin.install(objPrepare, httpClient);
        attributes.put(httpClientPlugin.getKey(), objPrepare);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Attributes installPlugin$lambda$0$0() {
        return AttributesJvmKt.Attributes(true);
    }

    public final HttpClientConfig<T> clone() {
        HttpClientConfig<T> httpClientConfig = new HttpClientConfig<>();
        httpClientConfig.plusAssign(this);
        return httpClientConfig;
    }

    public final void engine(Function1 block) {
        block.getClass();
        this.engineConfig = new HttpClientConfig$$ExternalSyntheticLambda0(this.engineConfig, block, (byte) 3);
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    /* JADX INFO: renamed from: getEngineConfig$ktor_client_core, reason: from getter */
    public final Function1 getEngineConfig() {
        return this.engineConfig;
    }

    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final boolean getUseDefaultTransformers() {
        return this.useDefaultTransformers;
    }

    public final void install(HttpClient client) {
        client.getClass();
        Iterator<T> it = this.plugins.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(client);
        }
        Iterator<T> it2 = this.customInterceptors.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(client);
        }
    }

    public final <TBuilder, TPlugin> void installOrReplace(HttpClientPlugin<? extends TBuilder, TPlugin> plugin, Function1 configure) {
        plugin.getClass();
        configure.getClass();
        this.pluginConfigurations.put(plugin.getKey(), new CodecsKt$$ExternalSyntheticLambda0(configure, (byte) 21));
        installPlugin(plugin);
    }

    public final void plusAssign(HttpClientConfig<? extends T> other) {
        other.getClass();
        this.followRedirects = other.followRedirects;
        this.useDefaultTransformers = other.useDefaultTransformers;
        this.expectSuccess = other.expectSuccess;
        this.plugins.putAll(other.plugins);
        this.pluginConfigurations.putAll(other.pluginConfigurations);
        this.customInterceptors.putAll(other.customInterceptors);
    }

    public final void setDevelopmentMode(boolean z) {
        this.developmentMode = z;
    }

    public final void setEngineConfig$ktor_client_core(Function1 function1) {
        function1.getClass();
        this.engineConfig = function1;
    }

    public final void setExpectSuccess(boolean z) {
        this.expectSuccess = z;
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final void setUseDefaultTransformers(boolean z) {
        this.useDefaultTransformers = z;
    }

    @Deprecated
    public static /* synthetic */ void getDevelopmentMode$annotations() {
    }

    public final void install(String key, Function1 block) {
        key.getClass();
        block.getClass();
        this.customInterceptors.put(key, block);
    }

    public final <TBuilder, TPlugin> void install(HttpClientPlugin<? extends TBuilder, TPlugin> plugin, Function1 configure) {
        plugin.getClass();
        configure.getClass();
        this.pluginConfigurations.put(plugin.getKey(), new HttpClientConfig$$ExternalSyntheticLambda0(this.pluginConfigurations.get(plugin.getKey()), configure, (byte) 0));
        installPlugin(plugin);
    }
}
