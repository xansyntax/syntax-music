package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.io.EOFException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.io.encoding.Base64;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Buffer;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0005H\u0007¢\u0006\u0004\b\u0001\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\b\u001a\u00060\u0005j\u0002`\n*\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"", "encodeBase64", "(Ljava/lang/String;)Ljava/lang/String;", "", "([B)Ljava/lang/String;", "Lkotlinx/io/Source;", "(Lkotlinx/io/Source;)Ljava/lang/String;", "decodeBase64String", "decodeBase64Bytes", "(Ljava/lang/String;)[B", "Lio/ktor/utils/io/core/Input;", "(Lkotlinx/io/Source;)Lkotlinx/io/Source;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Base64Kt {
    @Deprecated
    public static final Source decodeBase64Bytes(Source source) throws EOFException {
        Object failure;
        Base64.PaddingOption paddingOption = Base64.PaddingOption.PRESENT_OPTIONAL;
        source.getClass();
        Buffer buffer = new Buffer();
        byte[] byteArrayImpl = Utf8Kt.readByteArrayImpl(source, -1);
        try {
            failure = Base64.decode$default(Base64.Default.withPadding(paddingOption), byteArrayImpl);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Base64.Default.getClass();
            failure = Base64.decode$default(Base64.UrlSafe.withPadding(paddingOption), byteArrayImpl);
        }
        BytePacketBuilderKt.writeFully$default(buffer, (byte[]) failure, 0, 0, 6, null);
        return buffer;
    }

    @Deprecated
    public static final String decodeBase64String(String str) {
        str.getClass();
        return StringsKt__StringsJVMKt.decodeToString(decodeBase64Bytes(str));
    }

    @Deprecated
    public static final String encodeBase64(Source source) {
        source.getClass();
        return Base64.encode$default(Base64.Default, Utf8Kt.readByteArrayImpl(source, -1));
    }

    @Deprecated
    public static final String encodeBase64(byte[] bArr) {
        bArr.getClass();
        return Base64.encode$default(Base64.Default, bArr);
    }

    @Deprecated
    public static final String encodeBase64(String str) {
        str.getClass();
        return Base64.encode$default(Base64.Default, StringsKt__StringsJVMKt.encodeToByteArray(str));
    }

    @Deprecated
    public static final byte[] decodeBase64Bytes(String str) {
        Object failure;
        Base64.PaddingOption paddingOption = Base64.PaddingOption.PRESENT_OPTIONAL;
        str.getClass();
        try {
            failure = Base64.decode$default(Base64.Default.withPadding(paddingOption), str, 0, 6);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Base64.Default.getClass();
            failure = Base64.decode$default(Base64.UrlSafe.withPadding(paddingOption), str, 0, 6);
        }
        return (byte[]) failure;
    }
}
