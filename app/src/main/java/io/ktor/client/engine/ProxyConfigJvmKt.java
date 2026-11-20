package io.ktor.client.engine;

import io.ktor.http.LinkHeader;
import java.net.Proxy;
import java.net.SocketAddress;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0006*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b*\n\u0010\n\"\u00020\u00002\u00020\u0000¨\u0006\u000b"}, d2 = {"Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "resolveAddress", "(Ljava/net/Proxy;)Ljava/net/SocketAddress;", "Lio/ktor/client/engine/ProxyType;", "getType", "(Ljava/net/Proxy;)Lio/ktor/client/engine/ProxyType;", LinkHeader.Parameters.Type, "ProxyConfig", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ProxyConfigJvmKt {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.SOCKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ProxyType getType(Proxy proxy) {
        proxy.getClass();
        Proxy.Type type = proxy.type();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 1) {
            return i != 2 ? ProxyType.UNKNOWN : ProxyType.HTTP;
        }
        return ProxyType.SOCKS;
    }

    public static final SocketAddress resolveAddress(Proxy proxy) {
        proxy.getClass();
        SocketAddress socketAddressAddress = proxy.address();
        socketAddressAddress.getClass();
        return socketAddressAddress;
    }
}
