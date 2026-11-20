package io.ktor.utils.io.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u0011\u001a)\u0010\u0013\u001a\u00020\u0000*\u00020\r2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0016\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u0019\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u001b\u0010\u001c\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010%\u001a\u00020\"*\u00020\rH\u0002¢\u0006\u0004\b#\u0010$\u001a;\u0010,\u001a\u00020+*\u00020&2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b,\u0010-\u001a;\u0010,\u001a\u00020+*\u00020&2\u0006\u0010(\u001a\u00020.2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b,\u0010/\u001a\u0017\u00103\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u00102¨\u00064"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "bytes", "", "offset", "length", "String", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "Lkotlinx/io/Source;", "readBytes", "(Lkotlinx/io/Source;)[B", "count", "(Lkotlinx/io/Source;I)[B", "n", "readTextExact", "(Lkotlinx/io/Source;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "charactersCount", "readTextExactCharacters", "(Lkotlinx/io/Source;ILjava/nio/charset/Charset;)Ljava/lang/String;", "readSingleByteExactCharacters$StringsKt__StringsKt", "readSingleByteExactCharacters", "readIso88591ExactCharacters$StringsKt__StringsKt", "(Lkotlinx/io/Source;I)Ljava/lang/String;", "readIso88591ExactCharacters", "readUtf8ExactCharacters$StringsKt__StringsKt", "readUtf8ExactCharacters", "peekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt", "(Lkotlinx/io/Source;I)I", "peekNextUtf8CodePointUtf16UnitsOrFail", "", "readByteOrFail$StringsKt__StringsKt", "(Lkotlinx/io/Source;)B", "readByteOrFail", "Lkotlinx/io/Sink;", "", ContentType.Text.TYPE, "fromIndex", "toIndex", "", "writeText", "(Lkotlinx/io/Sink;Ljava/lang/CharSequence;IILjava/nio/charset/Charset;)V", "", "(Lkotlinx/io/Sink;[CIILjava/nio/charset/Charset;)V", "", "prematureEndOfStreamToReadChars$StringsKt__StringsKt", "(I)Ljava/lang/Void;", "prematureEndOfStreamToReadChars", "ktor-io"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "io/ktor/utils/io/core/StringsKt")
public final /* synthetic */ class StringsKt__StringsKt {
    @Deprecated
    public static final String String(byte[] bArr, int i, int i2, Charset charset) {
        bArr.getClass();
        charset.getClass();
        if (charset.equals(Charsets.UTF_8)) {
            return StringsKt__StringsJVMKt.decodeToString$default(i, i2 + i, 4, bArr);
        }
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully(buffer, bArr, i, i2);
        return StringsKt__Strings_jvmKt.readText$default(buffer, charset, 0, 2, null);
    }

    public static /* synthetic */ String String$default(byte[] bArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return StringsKt.String(bArr, i, i2, charset);
    }

    private static final int peekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt(Source source, int i) throws MalformedInputException, EOFException {
        source.request(1L);
        if (source.getBuffer().sizeMut < 1) {
            prematureEndOfStreamToReadChars$StringsKt__StringsKt(i);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return 0;
        }
        byte b = source.getBuffer().get(0L);
        if ((b & 128) == 0) {
            return 1;
        }
        if ((b & 224) == 192) {
            source.request(2L);
            if (source.getBuffer().sizeMut >= 2) {
                return 1;
            }
            prematureEndOfStreamToReadChars$StringsKt__StringsKt(i);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return 0;
        }
        if ((b & 240) == 224) {
            source.request(3L);
            if (source.getBuffer().sizeMut >= 3) {
                return 1;
            }
            prematureEndOfStreamToReadChars$StringsKt__StringsKt(i);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return 0;
        }
        if ((b & 248) != 240) {
            throw new MalformedInputException("Invalid UTF-8 leading byte");
        }
        source.request(4L);
        if (source.getBuffer().sizeMut >= 4) {
            return 2;
        }
        prematureEndOfStreamToReadChars$StringsKt__StringsKt(i);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return 0;
    }

    private static final Void prematureEndOfStreamToReadChars$StringsKt__StringsKt(int i) throws EOFException {
        throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Not enough input bytes to read ", " characters."));
    }

    private static final byte readByteOrFail$StringsKt__StringsKt(Source source) throws EOFException {
        try {
            return source.readByte();
        } catch (EOFException unused) {
            prematureEndOfStreamToReadChars$StringsKt__StringsKt(1);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return (byte) 0;
        }
    }

    @Deprecated
    public static final byte[] readBytes(Source source) {
        source.getClass();
        return Utf8Kt.readByteArrayImpl(source, -1);
    }

    private static final String readIso88591ExactCharacters$StringsKt__StringsKt(Source source, int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) (readByteOrFail$StringsKt__StringsKt(source) & 255);
        }
        return new String(cArr);
    }

    private static final String readSingleByteExactCharacters$StringsKt__StringsKt(Source source, int i, Charset charset) {
        if (!StringsKt.supportsReadTextExactCharacters(charset)) {
            PathKt$$ExternalSyntheticBUOutline0.m$3(charset, "Unsupported charset: ");
            return null;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = readByteOrFail$StringsKt__StringsKt(source);
        }
        return String$default(bArr, 0, 0, charset, 6, null);
    }

    @Deprecated
    public static final String readTextExact(Source source, Charset charset, int i) {
        source.getClass();
        charset.getClass();
        return StringsKt.readTextExactCharacters(source, i, charset);
    }

    public static /* synthetic */ String readTextExact$default(Source source, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return StringsKt.readTextExact(source, charset, i);
    }

    public static final String readTextExactCharacters(Source source, int i, Charset charset) {
        source.getClass();
        charset.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "charactersCount shouldn't be negative: "));
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (charset.equals(Charsets.UTF_8)) {
            return readUtf8ExactCharacters$StringsKt__StringsKt(source, i);
        }
        return charset.equals(Charsets.ISO_8859_1) ? readIso88591ExactCharacters$StringsKt__StringsKt(source, i) : readSingleByteExactCharacters$StringsKt__StringsKt(source, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Source source, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return StringsKt.readTextExactCharacters(source, i, charset);
    }

    private static final String readUtf8ExactCharacters$StringsKt__StringsKt(Source source, int i) throws MalformedInputException, EOFException {
        StringBuilder sb = new StringBuilder(i);
        int i2 = i;
        while (i2 > 0) {
            int iPeekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt = peekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt(source, i);
            if (iPeekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt > i2) {
                throw new MalformedInputException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unable to read exactly ", " UTF-16 characters: next UTF-8 code point requires ", iPeekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt, " units."));
            }
            try {
                int codePointValue = Utf8Kt.readCodePointValue(source);
                int i3 = codePointValue <= 65535 ? 1 : 2;
                if (i3 != iPeekNextUtf8CodePointUtf16UnitsOrFail$StringsKt__StringsKt) {
                    throw new MalformedInputException("Invalid UTF-8 code point");
                }
                if (codePointValue <= 65535) {
                    sb.append((char) codePointValue);
                } else {
                    int i4 = codePointValue - 65536;
                    sb.append((char) ((i4 >>> 10) + 55296));
                    sb.append((char) ((i4 & 1023) + 56320));
                }
                i2 -= i3;
            } catch (EOFException unused) {
                prematureEndOfStreamToReadChars$StringsKt__StringsKt(i);
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            }
        }
        return sb.toString();
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        str.getClass();
        charset.getClass();
        return charset.equals(Charsets.UTF_8) ? StringsKt__StringsJVMKt.encodeToByteArray(str) : CharsetJVMKt.encodeToByteArray(charset.newEncoder(), str, 0, str.length());
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return StringsKt.toByteArray(str, charset);
    }

    public static final void writeText(Sink sink, char[] cArr, int i, int i2, Charset charset) {
        sink.getClass();
        cArr.getClass();
        charset.getClass();
        if (charset == Charsets.UTF_8) {
            Utf8Kt.writeString(sink, StringsKt__StringsJVMKt.concatToString(cArr, i, i2), 0, i2 - i);
        } else {
            EncodingKt.encode(charset.newEncoder(), cArr, i, i2, sink);
        }
    }

    public static /* synthetic */ void writeText$default(Sink sink, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        StringsKt.writeText(sink, charSequence, i, i2, charset);
    }

    @Deprecated
    public static final byte[] readBytes(Source source, int i) {
        source.getClass();
        return Utf8Kt.readByteArray(source, i);
    }

    public static /* synthetic */ void writeText$default(Sink sink, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        StringsKt.writeText(sink, cArr, i, i2, charset);
    }

    public static final void writeText(Sink sink, CharSequence charSequence, int i, int i2, Charset charset) {
        sink.getClass();
        charSequence.getClass();
        charset.getClass();
        if (charset == Charsets.UTF_8) {
            Utf8Kt.writeString(sink, charSequence.toString(), i, i2);
        } else {
            EncodingKt.encodeToImpl(charset.newEncoder(), sink, charSequence, i, i2);
        }
    }
}
