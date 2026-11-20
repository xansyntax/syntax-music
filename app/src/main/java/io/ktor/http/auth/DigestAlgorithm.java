package io.ktor.http.auth;

import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0006\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0013"}, d2 = {"Lio/ktor/http/auth/DigestAlgorithm;", "", "", ContentDisposition.Parameters.Name, "hashName", "", "isSession", "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getHashName", "Z", "()Z", "getUri", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DigestAlgorithm {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<DigestAlgorithm> DEFAULT_ALGORITHMS;
    private static final DigestAlgorithm MD5;
    private static final DigestAlgorithm MD5_SESS;
    private static final DigestAlgorithm SHA_256;
    private static final DigestAlgorithm SHA_256_SESS;
    private static final DigestAlgorithm SHA_384;
    private static final DigestAlgorithm SHA_512;
    private static final DigestAlgorithm SHA_512_256;
    private static final DigestAlgorithm SHA_512_256_SESS;
    private static final List<DigestAlgorithm> XML_DIGEST_ALGORITHMS;
    private final String hashName;
    private final boolean isSession;
    private final String name;
    private final String uri;

    static {
        DigestAlgorithm digestAlgorithm = new DigestAlgorithm("MD5", "MD5", false);
        MD5 = digestAlgorithm;
        DigestAlgorithm digestAlgorithm2 = new DigestAlgorithm("MD5-sess", "MD5", true);
        MD5_SESS = digestAlgorithm2;
        DigestAlgorithm digestAlgorithm3 = new DigestAlgorithm("SHA-256", "SHA-256", false, "http://www.w3.org/2001/04/xmlenc#sha256");
        SHA_256 = digestAlgorithm3;
        DigestAlgorithm digestAlgorithm4 = new DigestAlgorithm("SHA-256-sess", "SHA-256", true);
        SHA_256_SESS = digestAlgorithm4;
        DigestAlgorithm digestAlgorithm5 = new DigestAlgorithm("SHA-384", "SHA-384", false, "http://www.w3.org/2001/04/xmldsig-more#sha384");
        SHA_384 = digestAlgorithm5;
        DigestAlgorithm digestAlgorithm6 = new DigestAlgorithm("SHA-512", "SHA-512", false, "http://www.w3.org/2001/04/xmlenc#sha512");
        SHA_512 = digestAlgorithm6;
        DigestAlgorithm digestAlgorithm7 = new DigestAlgorithm("SHA-512-256", "SHA-512/256", false);
        SHA_512_256 = digestAlgorithm7;
        DigestAlgorithm digestAlgorithm8 = new DigestAlgorithm("SHA-512-256-sess", "SHA-512/256", true);
        SHA_512_256_SESS = digestAlgorithm8;
        DEFAULT_ALGORITHMS = CollectionsKt__IterablesKt.listOf((Object[]) new DigestAlgorithm[]{digestAlgorithm7, digestAlgorithm8, digestAlgorithm3, digestAlgorithm4, digestAlgorithm, digestAlgorithm2});
        XML_DIGEST_ALGORITHMS = CollectionsKt__IterablesKt.listOf((Object[]) new DigestAlgorithm[]{digestAlgorithm3, digestAlgorithm5, digestAlgorithm6});
    }

    public DigestAlgorithm(String str, String str2, boolean z, String str3) {
        str.getClass();
        str2.getClass();
        this.name = str;
        this.hashName = str2;
        this.isSession = z;
        this.uri = str3;
    }

    public final String getHashName() {
        return this.hashName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: isSession, reason: from getter */
    public final boolean getIsSession() {
        return this.isSession;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR \u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001d\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR#\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0006¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u0003\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!¨\u0006&"}, d2 = {"Lio/ktor/http/auth/DigestAlgorithm$Companion;", "", "<init>", "()V", "", ContentDisposition.Parameters.Name, "Lio/ktor/http/auth/DigestAlgorithm;", "from", "(Ljava/lang/String;)Lio/ktor/http/auth/DigestAlgorithm;", "uri", "fromUri", "MD5", "Lio/ktor/http/auth/DigestAlgorithm;", "getMD5", "()Lio/ktor/http/auth/DigestAlgorithm;", "getMD5$annotations", "MD5_SESS", "getMD5_SESS", "getMD5_SESS$annotations", "SHA_256", "getSHA_256", "SHA_256_SESS", "getSHA_256_SESS", "SHA_384", "getSHA_384", "SHA_512", "getSHA_512", "SHA_512_256", "getSHA_512_256", "SHA_512_256_SESS", "getSHA_512_256_SESS", "", "DEFAULT_ALGORITHMS", "Ljava/util/List;", "getDEFAULT_ALGORITHMS", "()Ljava/util/List;", "getDEFAULT_ALGORITHMS$annotations", "XML_DIGEST_ALGORITHMS", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DigestAlgorithm from(String name) {
            Object next;
            name.getClass();
            Iterator<T> it = getDEFAULT_ALGORITHMS().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (StringsKt__StringsJVMKt.equals(((DigestAlgorithm) next).getName(), name, true)) {
                    return (DigestAlgorithm) next;
                }
            }
            next = null;
            return (DigestAlgorithm) next;
        }

        public final DigestAlgorithm fromUri(String uri) {
            Object next;
            uri.getClass();
            Iterator it = DigestAlgorithm.XML_DIGEST_ALGORITHMS.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((DigestAlgorithm) next).getUri(), uri)) {
                    return (DigestAlgorithm) next;
                }
            }
            next = null;
            return (DigestAlgorithm) next;
        }

        public final List<DigestAlgorithm> getDEFAULT_ALGORITHMS() {
            return DigestAlgorithm.DEFAULT_ALGORITHMS;
        }

        public final DigestAlgorithm getMD5() {
            return DigestAlgorithm.MD5;
        }

        public final DigestAlgorithm getMD5_SESS() {
            return DigestAlgorithm.MD5_SESS;
        }

        public final DigestAlgorithm getSHA_256() {
            return DigestAlgorithm.SHA_256;
        }

        public final DigestAlgorithm getSHA_256_SESS() {
            return DigestAlgorithm.SHA_256_SESS;
        }

        public final DigestAlgorithm getSHA_384() {
            return DigestAlgorithm.SHA_384;
        }

        public final DigestAlgorithm getSHA_512() {
            return DigestAlgorithm.SHA_512;
        }

        public final DigestAlgorithm getSHA_512_256() {
            return DigestAlgorithm.SHA_512_256;
        }

        public final DigestAlgorithm getSHA_512_256_SESS() {
            return DigestAlgorithm.SHA_512_256_SESS;
        }

        private Companion() {
        }

        public static /* synthetic */ void getDEFAULT_ALGORITHMS$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getMD5$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getMD5_SESS$annotations() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DigestAlgorithm(String str, String str2, boolean z) {
        this(str, str2, z, null);
        str.getClass();
        str2.getClass();
    }
}
