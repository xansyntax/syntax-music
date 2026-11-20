package io.ktor.network.sockets;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u0012J\u0011\u0010\u001b\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Lio/ktor/network/sockets/InetSocketAddress;", "Lio/ktor/network/sockets/SocketAddress;", "Ljava/net/InetSocketAddress;", "address", "<init>", "(Ljava/net/InetSocketAddress;)V", "", "hostname", "", "port", "(Ljava/lang/String;I)V", "", "([BI)V", "resolveAddress", "()[B", "component1", "()Ljava/lang/String;", "component2", "()I", "copy", "(Ljava/lang/String;I)Lio/ktor/network/sockets/InetSocketAddress;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/net/InetSocketAddress;", "getAddress$ktor_network", "()Ljava/net/InetSocketAddress;", "getHostname", "getPort", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InetSocketAddress extends SocketAddress {
    private final java.net.InetSocketAddress address;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InetSocketAddress(byte[] bArr, int i) {
        this(new java.net.InetSocketAddress(InetAddress.getByAddress(bArr), i));
        bArr.getClass();
        if (bArr.length == 4 || bArr.length == 16) {
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(new StringBuilder("Invalid IP address byte array length: "), bArr.length, ". Expected 4 (IPv4) or 16 (IPv6)."));
            throw null;
        }
    }

    public static /* synthetic */ InetSocketAddress copy$default(InetSocketAddress inetSocketAddress, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inetSocketAddress.getHostname();
        }
        if ((i2 & 2) != 0) {
            i = inetSocketAddress.getPort();
        }
        return inetSocketAddress.copy(str, i);
    }

    public final String component1() {
        return getHostname();
    }

    public final int component2() {
        return getPort();
    }

    public final InetSocketAddress copy(String hostname, int port) {
        hostname.getClass();
        return new InetSocketAddress(hostname, port);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!InetSocketAddress.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        return Intrinsics.areEqual(getAddress(), ((InetSocketAddress) other).getAddress());
    }

    public final String getHostname() {
        String hostName = getAddress().getHostName();
        hostName.getClass();
        return hostName;
    }

    public final int getPort() {
        return getAddress().getPort();
    }

    public int hashCode() {
        return getAddress().hashCode();
    }

    public final byte[] resolveAddress() {
        InetAddress address = getAddress().getAddress();
        if (address != null) {
            return address.getAddress();
        }
        return null;
    }

    public String toString() {
        String string = getAddress().toString();
        string.getClass();
        return string;
    }

    @Override // io.ktor.network.sockets.SocketAddress
    /* JADX INFO: renamed from: getAddress$ktor_network, reason: from getter */
    public java.net.InetSocketAddress getAddress() {
        return this.address;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InetSocketAddress(String str, int i) {
        this(new java.net.InetSocketAddress(str, i));
        str.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InetSocketAddress(java.net.InetSocketAddress inetSocketAddress) {
        super(null);
        inetSocketAddress.getClass();
        this.address = inetSocketAddress;
    }
}
