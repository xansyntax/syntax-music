package io.ktor.network.sockets;

import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.network.selector.SelectorManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0007\u001a\u00028\u0000\"\u0012\b\u0000\u0010\u0006*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005*\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketBuilder;", "aSocket", "(Lio/ktor/network/selector/SelectorManager;)Lio/ktor/network/sockets/SocketBuilder;", "Lio/ktor/network/sockets/Configurable;", "T", "tcpNoDelay", "(Lio/ktor/network/sockets/Configurable;)Lio/ktor/network/sockets/Configurable;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {
    public static final SocketBuilder aSocket(SelectorManager selectorManager) {
        selectorManager.getClass();
        return new SocketBuilder(selectorManager, SocketOptions.INSTANCE.create$ktor_network());
    }

    @Deprecated
    public static final <T extends Configurable<? extends T, ?>> T tcpNoDelay(T t) {
        t.getClass();
        return (T) t.configure(new URLUtilsKt$$ExternalSyntheticLambda0((byte) 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tcpNoDelay$lambda$0(SocketOptions socketOptions) {
        socketOptions.getClass();
        if (socketOptions instanceof SocketOptions.TCPClientSocketOptions) {
            ((SocketOptions.TCPClientSocketOptions) socketOptions).setNoDelay(true);
        }
        return Unit.INSTANCE;
    }
}
