package io.ktor.network.sockets;

import io.ktor.network.sockets.ASocket;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001J\u0010\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/Acceptable;", "Lio/ktor/network/sockets/ASocket;", "S", "accept", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Acceptable<S extends ASocket> extends ASocket {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <S extends ASocket> void dispose(Acceptable<? extends S> acceptable) {
            Acceptable.super.dispose();
        }
    }

    Object accept(Continuation continuation);
}
