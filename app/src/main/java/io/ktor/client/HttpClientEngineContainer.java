package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/HttpClientEngineContainer;", "", "Lio/ktor/client/engine/HttpClientEngineFactory;", "getFactory", "()Lio/ktor/client/engine/HttpClientEngineFactory;", "factory", "", "getPriority", "()D", "priority", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HttpClientEngineContainer {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static double getPriority(HttpClientEngineContainer httpClientEngineContainer) {
            return HttpClientEngineContainer.super.getPriority();
        }
    }

    HttpClientEngineFactory<?> getFactory();

    default double getPriority() {
        return 1.0d;
    }
}
