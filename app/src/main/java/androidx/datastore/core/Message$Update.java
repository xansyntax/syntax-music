package androidx.datastore.core;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferredImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Message$Update {
    public final CompletableDeferredImpl ack;
    public final CoroutineContext callerContext;
    public final State lastState;
    public final Function2 transform;

    public Message$Update(Function2 function2, CompletableDeferredImpl completableDeferredImpl, State state, CoroutineContext coroutineContext) {
        coroutineContext.getClass();
        this.transform = function2;
        this.ack = completableDeferredImpl;
        this.lastState = state;
        this.callerContext = coroutineContext;
    }
}
