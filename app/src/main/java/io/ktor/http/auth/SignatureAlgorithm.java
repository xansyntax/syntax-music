package io.ktor.http.auth;

import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016¨\u0006\u001f"}, d2 = {"Lio/ktor/http/auth/SignatureAlgorithm;", "", "", ContentDisposition.Parameters.Name, "jcaAlgorithm", "Lio/ktor/http/auth/DigestAlgorithm;", "digestAlgorithm", "Lio/ktor/http/auth/KeyAlgorithm;", "keyAlgorithm", "xmlUri", "jwaName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/auth/DigestAlgorithm;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getJcaAlgorithm", "Lio/ktor/http/auth/DigestAlgorithm;", "getDigestAlgorithm", "()Lio/ktor/http/auth/DigestAlgorithm;", "getKeyAlgorithm-GYfFmDM", "getXmlUri", "getJwaName", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SignatureAlgorithm {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<SignatureAlgorithm> DEFAULT_ALGORITHMS;
    private static final SignatureAlgorithm ECDSA_SHA_256;
    private static final SignatureAlgorithm ECDSA_SHA_384;
    private static final SignatureAlgorithm ECDSA_SHA_512;
    private static final SignatureAlgorithm RSA_SHA_256;
    private static final SignatureAlgorithm RSA_SHA_384;
    private static final SignatureAlgorithm RSA_SHA_512;
    private final DigestAlgorithm digestAlgorithm;
    private final String jcaAlgorithm;
    private final String jwaName;
    private final String keyAlgorithm;
    private final String name;
    private final String xmlUri;

    static {
        DigestAlgorithm.Companion companion = DigestAlgorithm.INSTANCE;
        DigestAlgorithm sha_256 = companion.getSHA_256();
        KeyAlgorithm.Companion companion2 = KeyAlgorithm.INSTANCE;
        SignatureAlgorithm signatureAlgorithm = new SignatureAlgorithm("RSA-SHA-256", "SHA256withRSA", sha_256, companion2.m1695getRSAGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256", "RS256", null);
        RSA_SHA_256 = signatureAlgorithm;
        SignatureAlgorithm signatureAlgorithm2 = new SignatureAlgorithm("RSA-SHA-384", "SHA384withRSA", companion.getSHA_384(), companion2.m1695getRSAGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384", "RS384", null);
        RSA_SHA_384 = signatureAlgorithm2;
        SignatureAlgorithm signatureAlgorithm3 = new SignatureAlgorithm("RSA-SHA-512", "SHA512withRSA", companion.getSHA_512(), companion2.m1695getRSAGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512", "RS512", null);
        RSA_SHA_512 = signatureAlgorithm3;
        SignatureAlgorithm signatureAlgorithm4 = new SignatureAlgorithm("ECDSA-SHA-256", "SHA256withECDSA", companion.getSHA_256(), companion2.m1692getECGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256", "ES256", null);
        ECDSA_SHA_256 = signatureAlgorithm4;
        SignatureAlgorithm signatureAlgorithm5 = new SignatureAlgorithm("ECDSA-SHA-384", "SHA384withECDSA", companion.getSHA_384(), companion2.m1692getECGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha384", "ES384", null);
        ECDSA_SHA_384 = signatureAlgorithm5;
        SignatureAlgorithm signatureAlgorithm6 = new SignatureAlgorithm("ECDSA-SHA-512", "SHA512withECDSA", companion.getSHA_512(), companion2.m1692getECGYfFmDM(), "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha512", "ES512", null);
        ECDSA_SHA_512 = signatureAlgorithm6;
        DEFAULT_ALGORITHMS = CollectionsKt__IterablesKt.listOf((Object[]) new SignatureAlgorithm[]{signatureAlgorithm, signatureAlgorithm2, signatureAlgorithm3, signatureAlgorithm4, signatureAlgorithm5, signatureAlgorithm6});
    }

    private SignatureAlgorithm(String str, String str2, DigestAlgorithm digestAlgorithm, String str3, String str4, String str5) {
        str.getClass();
        str2.getClass();
        digestAlgorithm.getClass();
        str3.getClass();
        this.name = str;
        this.jcaAlgorithm = str2;
        this.digestAlgorithm = digestAlgorithm;
        this.keyAlgorithm = str3;
        this.xmlUri = str4;
        this.jwaName = str5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SignatureAlgorithm) {
            return Intrinsics.areEqual(this.name, ((SignatureAlgorithm) other).name);
        }
        return false;
    }

    public final DigestAlgorithm getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public final String getJcaAlgorithm() {
        return this.jcaAlgorithm;
    }

    public final String getJwaName() {
        return this.jwaName;
    }

    /* JADX INFO: renamed from: getKeyAlgorithm-GYfFmDM, reason: not valid java name and from getter */
    public final String getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public final String getName() {
        return this.name;
    }

    public final String getXmlUri() {
        return this.xmlUri;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/http/auth/SignatureAlgorithm$Companion;", "", "<init>", "()V", "", "uri", "Lio/ktor/http/auth/SignatureAlgorithm;", "fromXmlUri", "(Ljava/lang/String;)Lio/ktor/http/auth/SignatureAlgorithm;", ContentDisposition.Parameters.Name, "fromJwaName", "RSA_SHA_256", "Lio/ktor/http/auth/SignatureAlgorithm;", "getRSA_SHA_256", "()Lio/ktor/http/auth/SignatureAlgorithm;", "RSA_SHA_384", "getRSA_SHA_384", "RSA_SHA_512", "getRSA_SHA_512", "ECDSA_SHA_256", "getECDSA_SHA_256", "ECDSA_SHA_384", "getECDSA_SHA_384", "ECDSA_SHA_512", "getECDSA_SHA_512", "", "DEFAULT_ALGORITHMS", "Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignatureAlgorithm fromJwaName(String name) {
            Object next;
            name.getClass();
            Iterator it = SignatureAlgorithm.DEFAULT_ALGORITHMS.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((SignatureAlgorithm) next).getJwaName(), name)) {
                    return (SignatureAlgorithm) next;
                }
            }
            next = null;
            return (SignatureAlgorithm) next;
        }

        public final SignatureAlgorithm fromXmlUri(String uri) {
            Object next;
            uri.getClass();
            Iterator it = SignatureAlgorithm.DEFAULT_ALGORITHMS.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((SignatureAlgorithm) next).getXmlUri(), uri)) {
                    return (SignatureAlgorithm) next;
                }
            }
            next = null;
            return (SignatureAlgorithm) next;
        }

        public final SignatureAlgorithm getECDSA_SHA_256() {
            return SignatureAlgorithm.ECDSA_SHA_256;
        }

        public final SignatureAlgorithm getECDSA_SHA_384() {
            return SignatureAlgorithm.ECDSA_SHA_384;
        }

        public final SignatureAlgorithm getECDSA_SHA_512() {
            return SignatureAlgorithm.ECDSA_SHA_512;
        }

        public final SignatureAlgorithm getRSA_SHA_256() {
            return SignatureAlgorithm.RSA_SHA_256;
        }

        public final SignatureAlgorithm getRSA_SHA_384() {
            return SignatureAlgorithm.RSA_SHA_384;
        }

        public final SignatureAlgorithm getRSA_SHA_512() {
            return SignatureAlgorithm.RSA_SHA_512;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SignatureAlgorithm(String str, String str2, DigestAlgorithm digestAlgorithm, String str3, String str4, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, digestAlgorithm, str3, str4, str5);
    }

    public /* synthetic */ SignatureAlgorithm(String str, String str2, DigestAlgorithm digestAlgorithm, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, digestAlgorithm, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, null);
    }
}
