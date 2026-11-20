package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001J%\u0010\u0007\u001a\u00028\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/HttpClientPlugin;", "", "TConfig", "TPlugin", "Lkotlin/Function1;", "", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Ljava/lang/Object;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "key", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HttpClientPlugin<TConfig, TPlugin> {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object prepare$default(HttpClientPlugin httpClientPlugin, Function1 function1, int i, Object obj) {
        if (obj != null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: prepare");
            return null;
        }
        if ((i & 1) != 0) {
            function1 = new UserAgentKt$$ExternalSyntheticLambda0((byte) 6);
        }
        return httpClientPlugin.prepare(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit prepare$lambda$0(Object obj) {
        obj.getClass();
        return Unit.INSTANCE;
    }

    AttributeKey<TPlugin> getKey();

    void install(TPlugin plugin, HttpClient scope);

    TPlugin prepare(Function1 block);
}
