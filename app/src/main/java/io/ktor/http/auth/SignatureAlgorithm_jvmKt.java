package io.ktor.http.auth;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/auth/SignatureAlgorithm;", "Ljava/security/Signature;", "toJcaSignature", "(Lio/ktor/http/auth/SignatureAlgorithm;)Ljava/security/Signature;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SignatureAlgorithm_jvmKt {
    public static final Signature toJcaSignature(SignatureAlgorithm signatureAlgorithm) throws NoSuchAlgorithmException {
        signatureAlgorithm.getClass();
        Signature signature = Signature.getInstance(signatureAlgorithm.getJcaAlgorithm());
        signature.getClass();
        return signature;
    }
}
