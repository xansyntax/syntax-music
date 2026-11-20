package okhttp3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Address {
    public final CertificatePinner certificatePinner;
    public final List connectionSpecs;
    public final Dns dns;
    public final HostnameVerifier hostnameVerifier;
    public final List protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        str.getClass();
        dns.getClass();
        socketFactory.getClass();
        authenticator.getClass();
        list.getClass();
        list2.getClass();
        proxySelector.getClass();
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            builder.scheme = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unexpected scheme: ".concat(str2));
                throw null;
            }
            builder.scheme = "https";
        }
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(0, 0, 7, str));
        if (canonicalHost == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unexpected host: ".concat(str));
            throw null;
        }
        builder.host = canonicalHost;
        if (1 > i || i >= 65536) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "unexpected port: "));
            throw null;
        }
        builder.port = i;
        this.url = builder.build();
        this.protocols = _UtilJvmKt.toImmutableList(list);
        this.connectionSpecs = _UtilJvmKt.toImmutableList(list2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return this.url.equals(address.url) && equalsNonHost$okhttp(address);
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        return Intrinsics.areEqual(this.dns, address.dns) && Intrinsics.areEqual(this.proxyAuthenticator, address.proxyAuthenticator) && this.protocols.equals(address.protocols) && this.connectionSpecs.equals(address.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, address.proxySelector) && Intrinsics.areEqual(this.proxy, address.proxy) && Intrinsics.areEqual(this.sslSocketFactory, address.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, address.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, address.certificatePinner) && this.url.port == address.url.port;
    }

    public final int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.url.url)) * 31)) * 31, 31, this.protocols), 31, this.connectionSpecs)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.url;
        sb.append(httpUrl.host);
        sb.append(':');
        sb.append(httpUrl.port);
        sb.append(", ");
        Proxy proxy = this.proxy;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.proxySelector;
        }
        return Format$$ExternalSyntheticOutline0.m(sb, str, '}');
    }
}
