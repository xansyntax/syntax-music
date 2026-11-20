package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0004\u0010\u0003\"\u0018\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "", "BrowserUserAgent", "(Lio/ktor/client/HttpClientConfig;)V", "CurlUserAgent", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/UserAgentConfig;", "UserAgent", "Lio/ktor/client/plugins/api/ClientPlugin;", "getUserAgent", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UserAgentKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.UserAgent");
    private static final ClientPlugin<UserAgentConfig> UserAgent = CreatePluginUtilsKt.createClientPlugin("UserAgent", UserAgentKt$UserAgent$2.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0(12));

    public static final void BrowserUserAgent(HttpClientConfig<?> httpClientConfig) {
        httpClientConfig.getClass();
        httpClientConfig.install(UserAgent, new UserAgentKt$$ExternalSyntheticLambda0((byte) 13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowserUserAgent$lambda$0(UserAgentConfig userAgentConfig) {
        userAgentConfig.getClass();
        userAgentConfig.setAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/70.0.3538.77 Chrome/70.0.3538.77 Safari/537.36");
        return Unit.INSTANCE;
    }

    public static final void CurlUserAgent(HttpClientConfig<?> httpClientConfig) {
        httpClientConfig.getClass();
        httpClientConfig.install(UserAgent, new UserAgentKt$$ExternalSyntheticLambda0((byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurlUserAgent$lambda$0(UserAgentConfig userAgentConfig) {
        userAgentConfig.getClass();
        userAgentConfig.setAgent("curl/7.61.0");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserAgent$lambda$1(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.onRequest(new UserAgentKt$UserAgent$3$1(((UserAgentConfig) clientPluginBuilder.getPluginConfig()).getAgent(), null));
        return Unit.INSTANCE;
    }

    public static final ClientPlugin<UserAgentConfig> getUserAgent() {
        return UserAgent;
    }
}
