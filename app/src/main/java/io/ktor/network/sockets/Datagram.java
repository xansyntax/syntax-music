package io.ktor.network.sockets;

import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlinx.io.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/sockets/Datagram;", "", "Lkotlinx/io/Source;", "packet", "Lio/ktor/network/sockets/SocketAddress;", "address", "<init>", "(Lkotlinx/io/Source;Lio/ktor/network/sockets/SocketAddress;)V", "Lkotlinx/io/Source;", "getPacket", "()Lkotlinx/io/Source;", "Lio/ktor/network/sockets/SocketAddress;", "getAddress", "()Lio/ktor/network/sockets/SocketAddress;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Datagram {
    private final SocketAddress address;
    private final Source packet;

    public Datagram(Source source, SocketAddress socketAddress) {
        source.getClass();
        socketAddress.getClass();
        this.packet = source;
        this.address = socketAddress;
        if (ByteReadPacketKt.getRemaining(source) <= 65535) {
            return;
        }
        throw new IllegalArgumentException(("Datagram size limit exceeded: " + ByteReadPacketKt.getRemaining(source) + " of possible 65535").toString());
    }

    public final SocketAddress getAddress() {
        return this.address;
    }

    public final Source getPacket() {
        return this.packet;
    }
}
