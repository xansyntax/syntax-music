package io.ktor.util;

import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"io/ktor/util/CryptoKt__CryptoJvmKt", "io/ktor/util/CryptoKt__CryptoKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public final class CryptoKt {
    public static final int NONCE_SIZE_IN_BYTES = 16;
    public static final int NONCE_SIZE_IN_CHARS = 32;

    public static final Digest Digest(String str) {
        return CryptoKt__CryptoJvmKt.Digest(str);
    }

    public static final Object build(Digest digest, String str, Charset charset, Continuation continuation) {
        return CryptoKt__CryptoKt.build(digest, str, charset, continuation);
    }

    @Deprecated
    public static final String generateNonce() {
        return CryptoKt__CryptoKt.generateNonce();
    }

    public static final String generateNonceBlocking(int i) {
        return CryptoKt__CryptoJvmKt.generateNonceBlocking(i);
    }

    public static final Object generateNonceSuspend(int i, Continuation continuation) {
        return CryptoKt__CryptoJvmKt.generateNonceSuspend(i, continuation);
    }

    public static final Function1 getDigestFunction(String str, Function1 function1) {
        return CryptoKt__CryptoJvmKt.getDigestFunction(str, function1);
    }

    @Deprecated
    public static final String hex(byte[] bArr) {
        return CryptoKt__CryptoKt.hex(bArr);
    }

    public static final byte[] sha1(byte[] bArr) {
        return CryptoKt__CryptoJvmKt.sha1(bArr);
    }

    public static final byte[] sha256(byte[] bArr) {
        return CryptoKt__CryptoJvmKt.sha256(bArr);
    }

    public static final Object build(Digest digest, byte[] bArr, Continuation continuation) {
        return CryptoKt__CryptoKt.build(digest, bArr, continuation);
    }

    @Deprecated
    public static final byte[] generateNonce(int i) {
        return CryptoKt__CryptoKt.generateNonce(i);
    }

    @Deprecated
    public static final byte[] hex(String str) {
        return CryptoKt__CryptoKt.hex(str);
    }
}
