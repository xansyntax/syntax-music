package io.ktor.client.engine;

import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003J%\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "", "Lkotlin/Function1;", "", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ HttpClientEngine create$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
        if (obj != null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: create");
            return null;
        }
        if ((i & 1) != 0) {
            function1 = new HttpClient$$ExternalSyntheticLambda1((byte) 25);
        }
        return httpClientEngineFactory.create(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit create$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
        httpClientEngineConfig.getClass();
        return Unit.INSTANCE;
    }

    HttpClientEngine create(Function1 block);
}
