package io.ktor.client.plugins.observer;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.slf4j.MDCContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0080@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "getResponseObserverContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ResponseObserverContextJvmKt {
    public static final Object getResponseObserverContext(Continuation continuation) {
        if (continuation.getContext().get(MDCContext.Key) == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
