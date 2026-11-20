package io.ktor.network.sockets;

import io.ktor.network.sockets.Configurable;
import io.ktor.network.sockets.SocketOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u0000*\u0016\b\u0000\u0010\u0001 \u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004J#\u0010\b\u001a\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u00028\u00018&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/Configurable;", "T", "Lio/ktor/network/sockets/SocketOptions;", "Options", "", "Lkotlin/Function1;", "", "block", "configure", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/network/sockets/Configurable;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions;)V", "options", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Configurable<T extends Configurable<? extends T, Options>, Options extends SocketOptions> {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends Configurable<? extends T, Options>, Options extends SocketOptions> T configure(Configurable<? extends T, Options> configurable, Function1 function1) {
            function1.getClass();
            return (T) Configurable.super.configure(function1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default T configure(Function1 block) {
        block.getClass();
        SocketOptions socketOptionsCopy$ktor_network = getOptions().copy$ktor_network();
        socketOptionsCopy$ktor_network.getClass();
        block.invoke(socketOptionsCopy$ktor_network);
        setOptions(socketOptionsCopy$ktor_network);
        return this;
    }

    Options getOptions();

    void setOptions(Options options);
}
