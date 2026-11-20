package okhttp3;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CipherSuite {
    public static final CipherSuite TLS_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public final String javaName;
    public static final Protocol.Companion Companion = new Protocol.Companion();
    public static final CipherSuite$Companion$ORDER_BY_NAME$1 ORDER_BY_NAME = new CipherSuite$Companion$ORDER_BY_NAME$1();
    public static final LinkedHashMap INSTANCES = new LinkedHashMap();

    static {
        Protocol.Companion.init("SSL_RSA_WITH_NULL_MD5");
        Protocol.Companion.init("SSL_RSA_WITH_NULL_SHA");
        Protocol.Companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        Protocol.Companion.init("SSL_RSA_WITH_RC4_128_MD5");
        Protocol.Companion.init("SSL_RSA_WITH_RC4_128_SHA");
        Protocol.Companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Protocol.Companion.init("SSL_RSA_WITH_DES_CBC_SHA");
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = Protocol.Companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        Protocol.Companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        Protocol.Companion.init("SSL_DH_anon_WITH_RC4_128_MD5");
        Protocol.Companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        Protocol.Companion.init("SSL_DH_anon_WITH_DES_CBC_SHA");
        Protocol.Companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_KRB5_WITH_DES_CBC_SHA");
        Protocol.Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_KRB5_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_KRB5_WITH_DES_CBC_MD5");
        Protocol.Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        Protocol.Companion.init("TLS_KRB5_WITH_RC4_128_MD5");
        Protocol.Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        Protocol.Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        Protocol.Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        Protocol.Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        TLS_RSA_WITH_AES_128_CBC_SHA = Protocol.Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        TLS_RSA_WITH_AES_256_CBC_SHA = Protocol.Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_RSA_WITH_NULL_SHA256");
        Protocol.Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        Protocol.Companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Protocol.Companion.init("TLS_PSK_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_PSK_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_PSK_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_RSA_WITH_SEED_CBC_SHA");
        TLS_RSA_WITH_AES_128_GCM_SHA256 = Protocol.Companion.init("TLS_RSA_WITH_AES_128_GCM_SHA256");
        TLS_RSA_WITH_AES_256_GCM_SHA384 = Protocol.Companion.init("TLS_RSA_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        Protocol.Companion.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        Protocol.Companion.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        Protocol.Companion.init("TLS_FALLBACK_SCSV");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_NULL_SHA");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA");
        Protocol.Companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_anon_WITH_NULL_SHA");
        Protocol.Companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA");
        Protocol.Companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        Protocol.Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Protocol.Companion.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        Protocol.Companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        Protocol.Companion.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        Protocol.Companion.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Protocol.Companion.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Protocol.Companion.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        Protocol.Companion.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        Protocol.Companion.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        TLS_AES_128_GCM_SHA256 = Protocol.Companion.init("TLS_AES_128_GCM_SHA256");
        TLS_AES_256_GCM_SHA384 = Protocol.Companion.init("TLS_AES_256_GCM_SHA384");
        TLS_CHACHA20_POLY1305_SHA256 = Protocol.Companion.init("TLS_CHACHA20_POLY1305_SHA256");
        Protocol.Companion.init("TLS_AES_128_CCM_SHA256");
        Protocol.Companion.init("TLS_AES_128_CCM_8_SHA256");
    }

    public CipherSuite(String str) {
        this.javaName = str;
    }

    public final String toString() {
        return this.javaName;
    }
}
