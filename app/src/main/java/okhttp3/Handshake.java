package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Handshake {
    public final CipherSuite cipherSuite;
    public final List localCertificates;
    public final SynchronizedLazyImpl peerCertificates$delegate;
    public final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, Function0 function0) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = new SynchronizedLazyImpl(new Handshake$$ExternalSyntheticLambda0(function0, (byte) 0));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && handshake.cipherSuite == this.cipherSuite && Intrinsics.areEqual(handshake.peerCertificates(), peerCertificates()) && handshake.localCertificates.equals(this.localCertificates);
    }

    public final int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPeerCertificates, 10));
        for (Certificate certificate : listPeerCertificates) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                type2.getClass();
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                type.getClass();
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
