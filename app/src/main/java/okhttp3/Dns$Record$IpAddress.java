package okhttp3;

import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Dns$Record$IpAddress {
    public final InetAddress address;
    public final String hostname;

    public Dns$Record$IpAddress(String str, InetAddress inetAddress) {
        inetAddress.getClass();
        this.address = inetAddress;
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
        if (canonicalHost != null) {
            this.hostname = canonicalHost;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unexpected hostname: ".concat(str));
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dns$Record$IpAddress)) {
            return false;
        }
        Dns$Record$IpAddress dns$Record$IpAddress = (Dns$Record$IpAddress) obj;
        return dns$Record$IpAddress.hostname.equals(this.hostname) && Intrinsics.areEqual(dns$Record$IpAddress.address, this.address);
    }

    public final int hashCode() {
        return this.address.hashCode() + (this.hostname.hashCode() * 31);
    }

    public final String toString() {
        return this.hostname + '/' + this.address.getHostAddress();
    }
}
