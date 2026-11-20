package okhttp3;

import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic"),
    HTTP_3("h3");

    public static final Companion Companion = new Companion();
    public final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.protocol;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements Authenticator, TrailersSource {
        public static final Companion NO_COOKIES = new Companion();

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static TlsVersion forJavaName(String str) {
            str.getClass();
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unexpected TLS version: ".concat(str));
            return null;
        }

        public static Protocol get(String str) throws IOException {
            if (str.equals("http/1.0")) {
                return Protocol.HTTP_1_0;
            }
            if (str.equals("http/1.1")) {
                return Protocol.HTTP_1_1;
            }
            if (str.equals("h2_prior_knowledge")) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            if (str.equals("h2")) {
                return Protocol.HTTP_2;
            }
            if (str.equals("spdy/3.1")) {
                return Protocol.SPDY_3;
            }
            if (str.equals("quic")) {
                return Protocol.QUIC;
            }
            if (StringsKt__StringsJVMKt.startsWith(str, "h3", false)) {
                return Protocol.HTTP_3;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Unexpected protocol: ".concat(str));
            return null;
        }

        public static CipherSuite init(String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        @Override // okhttp3.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }

        /* JADX INFO: renamed from: forJavaName, reason: collision with other method in class */
        public synchronized CipherSuite m1909forJavaName(String str) {
            CipherSuite cipherSuite;
            String strConcat;
            try {
                str.getClass();
                LinkedHashMap linkedHashMap = CipherSuite.INSTANCES;
                cipherSuite = (CipherSuite) linkedHashMap.get(str);
                if (cipherSuite == null) {
                    if (StringsKt__StringsJVMKt.startsWith(str, "TLS_", false)) {
                        strConcat = "SSL_".concat(str.substring(4));
                    } else {
                        strConcat = StringsKt__StringsJVMKt.startsWith(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str;
                    }
                    cipherSuite = (CipherSuite) linkedHashMap.get(strConcat);
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(str);
                    }
                    linkedHashMap.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }
    }
}
