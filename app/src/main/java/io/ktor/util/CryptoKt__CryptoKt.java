package io.ktor.util;

import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087@¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\r\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\f\b\u0002\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0087@¢\u0006\u0004\b\r\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"", "bytes", "", "hex", "([B)Ljava/lang/String;", "s", "(Ljava/lang/String;)[B", "generateNonce", "()Ljava/lang/String;", "", ContentDisposition.Parameters.Size, "(I)[B", "Lio/ktor/util/Digest;", "build", "(Lio/ktor/util/Digest;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "string", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Lio/ktor/util/Digest;Ljava/lang/String;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "digits", "[C", "NONCE_SIZE_IN_BYTES", "I", "NONCE_SIZE_IN_CHARS", "ktor-utils"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
final /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    public static final Object build(Digest digest, String str, Charset charset, Continuation continuation) {
        digest.plusAssign(StringsKt.toByteArray(str, charset));
        return digest.build(continuation);
    }

    public static /* synthetic */ Object build$default(Digest digest, String str, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return CryptoKt.build(digest, str, charset, continuation);
    }

    @Deprecated
    public static final byte[] generateNonce(int i) {
        Buffer buffer = new Buffer();
        while (BytePacketBuilderKt.getSize(buffer) < i) {
            StringsKt__StringsKt.writeText$default(buffer, CryptoKt__CryptoJvmKt.generateNonceBlocking$default(0, 1, null), 0, 0, (Charset) null, 14, (Object) null);
        }
        return Utf8Kt.readByteArray(buffer, i);
    }

    @Deprecated
    public static final byte[] hex(String str) {
        str.getClass();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String strValueOf = String.valueOf(str.charAt(i2));
            CharsKt.checkRadix(16);
            int i3 = Integer.parseInt(strValueOf, 16) << 4;
            String strValueOf2 = String.valueOf(str.charAt(i2 + 1));
            CharsKt.checkRadix(16);
            bArr[i] = (byte) (Integer.parseInt(strValueOf2, 16) | i3);
        }
        return bArr;
    }

    public static final Object build(Digest digest, byte[] bArr, Continuation continuation) {
        digest.plusAssign(bArr);
        return digest.build(continuation);
    }

    @Deprecated
    public static final String generateNonce() {
        return CryptoKt.generateNonceBlocking(32);
    }

    @Deprecated
    public static final String hex(byte[] bArr) {
        bArr.getClass();
        char[] cArr = new char[bArr.length * 2];
        char[] cArr2 = digits;
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = cArr2[(b & 255) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
