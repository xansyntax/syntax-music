package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/ConnectedDatagramSocket;", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/ABoundSocket;", "Lio/ktor/network/sockets/AConnectedSocket;", "Lio/ktor/network/sockets/DatagramReadWriteChannel;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ConnectedDatagramSocket extends ASocket, ABoundSocket, AConnectedSocket, DatagramReadWriteChannel {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dispose(ConnectedDatagramSocket connectedDatagramSocket) {
            ConnectedDatagramSocket.super.dispose();
        }

        @Deprecated
        public static Object receive(ConnectedDatagramSocket connectedDatagramSocket, Continuation continuation) {
            return ConnectedDatagramSocket.super.receive(continuation);
        }

        @Deprecated
        public static Object send(ConnectedDatagramSocket connectedDatagramSocket, Datagram datagram, Continuation continuation) {
            return ConnectedDatagramSocket.super.send(datagram, continuation);
        }
    }
}
