package io.ktor.client.plugins;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.http.URLBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserAgentKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ UserAgentKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return UserAgentKt.CurlUserAgent$lambda$0((UserAgentConfig) obj);
            case 1:
                return BodyProgressKt.BodyProgress$lambda$0((ClientPluginBuilder) obj);
            case 2:
                return DefaultRequest.DefaultRequestBuilder.url$lambda$0((URLBuilder) obj);
            case 3:
                return DoubleReceivePluginKt.SaveBody$lambda$0((ClientPluginBuilder) obj);
            case 4:
                return DoubleReceivePluginKt.SaveBodyPlugin$lambda$0((ClientPluginBuilder) obj);
            case 5:
                return HttpCallValidatorKt.HttpCallValidator$lambda$0((ClientPluginBuilder) obj);
            case 6:
                return HttpClientPlugin.prepare$lambda$0(obj);
            case 7:
                return HttpPlainTextKt.HttpPlainText$lambda$0((ClientPluginBuilder) obj);
            case 8:
                return HttpRedirectKt.HttpRedirect$lambda$0((ClientPluginBuilder) obj);
            case 9:
                return HttpRequestLifecycleKt.HttpRequestLifecycle$lambda$0((ClientPluginBuilder) obj);
            case 10:
                return HttpRequestRetryKt.HttpRequestRetry$lambda$0((ClientPluginBuilder) obj);
            case 11:
                return HttpTimeoutKt.HttpTimeout$lambda$1((ClientPluginBuilder) obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return UserAgentKt.UserAgent$lambda$1((ClientPluginBuilder) obj);
            default:
                return UserAgentKt.BrowserUserAgent$lambda$0((UserAgentConfig) obj);
        }
    }
}
