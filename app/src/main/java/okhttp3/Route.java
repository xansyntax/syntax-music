package okhttp3;

import io.ktor.sse.ServerSentEventKt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal._HostnamesCommonKt;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Route {
    public final Address address;
    public final ByteString echConfigList;
    public final Proxy proxy;
    public final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress, ByteString byteString) {
        address.getClass();
        proxy.getClass();
        inetSocketAddress.getClass();
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
        this.echConfigList = byteString;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return Intrinsics.areEqual(route.address, this.address) && Intrinsics.areEqual(route.proxy, this.proxy) && Intrinsics.areEqual(route.socketAddress, this.socketAddress) && Intrinsics.areEqual(route.echConfigList, this.echConfigList);
    }

    public final int hashCode() {
        int iHashCode = (this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31)) * 31;
        ByteString byteString = this.echConfigList;
        return iHashCode + (byteString != null ? byteString.hashCode() : 0);
    }

    public final String toString() {
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        Address address = this.address;
        HttpUrl httpUrl = address.url;
        HttpUrl httpUrl2 = address.url;
        String str = httpUrl.host;
        InetSocketAddress inetSocketAddress = this.socketAddress;
        InetAddress address2 = inetSocketAddress.getAddress();
        String canonicalHost = (address2 == null || (hostAddress = address2.getHostAddress()) == null) ? null : _HostnamesCommonKt.toCanonicalHost(hostAddress);
        if (StringsKt.contains$default(str, ':')) {
            sb.append("[");
            sb.append(str);
            sb.append("]");
        } else {
            sb.append(str);
        }
        if (httpUrl2.port != inetSocketAddress.getPort() || str.equals(canonicalHost)) {
            sb.append(ServerSentEventKt.COLON);
            sb.append(httpUrl2.port);
        }
        if (!str.equals(canonicalHost)) {
            if (Intrinsics.areEqual(this.proxy, Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (canonicalHost == null) {
                sb.append("<unresolved>");
            } else if (StringsKt.contains$default(canonicalHost, ':')) {
                sb.append("[");
                sb.append(canonicalHost);
                sb.append("]");
            } else {
                sb.append(canonicalHost);
            }
            sb.append(ServerSentEventKt.COLON);
            sb.append(inetSocketAddress.getPort());
        }
        if (this.echConfigList != null) {
            sb.append(" with ECH");
        }
        return sb.toString();
    }
}
