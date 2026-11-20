package io.ktor.http.auth;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nHÖ\u0081\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0012"}, d2 = {"Lio/ktor/http/auth/KeyAlgorithm;", "", "", ContentDisposition.Parameters.Name, "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getName", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeyAlgorithm {
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RSA = m1686constructorimpl("RSA");
    private static final String EC = m1686constructorimpl("EC");
    private static final String HMAC = m1686constructorimpl("HMAC");
    private static final String OKP = m1686constructorimpl("OKP");

    private /* synthetic */ KeyAlgorithm(String str) {
        this.name = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyAlgorithm m1685boximpl(String str) {
        return new KeyAlgorithm(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m1686constructorimpl(String str) {
        str.getClass();
        return str;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1687equalsimpl(String str, Object obj) {
        return (obj instanceof KeyAlgorithm) && Intrinsics.areEqual(str, ((KeyAlgorithm) obj).m1691unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1688equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1689hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1690toStringimpl(String str) {
        return Format$$ExternalSyntheticOutline0.m(')', "KeyAlgorithm(name=", str);
    }

    public boolean equals(Object other) {
        return m1687equalsimpl(this.name, other);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return m1689hashCodeimpl(this.name);
    }

    public String toString() {
        return m1690toStringimpl(this.name);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m1691unboximpl() {
        return this.name;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lio/ktor/http/auth/KeyAlgorithm$Companion;", "", "<init>", "()V", "Lio/ktor/http/auth/KeyAlgorithm;", "RSA", "Ljava/lang/String;", "getRSA-GYfFmDM", "()Ljava/lang/String;", "EC", "getEC-GYfFmDM", "HMAC", "getHMAC-GYfFmDM", "OKP", "getOKP-GYfFmDM", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getEC-GYfFmDM, reason: not valid java name */
        public final String m1692getECGYfFmDM() {
            return KeyAlgorithm.EC;
        }

        /* JADX INFO: renamed from: getHMAC-GYfFmDM, reason: not valid java name */
        public final String m1693getHMACGYfFmDM() {
            return KeyAlgorithm.HMAC;
        }

        /* JADX INFO: renamed from: getOKP-GYfFmDM, reason: not valid java name */
        public final String m1694getOKPGYfFmDM() {
            return KeyAlgorithm.OKP;
        }

        /* JADX INFO: renamed from: getRSA-GYfFmDM, reason: not valid java name */
        public final String m1695getRSAGYfFmDM() {
            return KeyAlgorithm.RSA;
        }

        private Companion() {
        }
    }
}
