package io.ktor.http;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.date.GMTDateParser;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BufferKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a3\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a\u001b\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a=\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001b\u0010\u001c\u001a3\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001d\u0010\u001e\u001a7\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u001c\u001a?\u0010\"\u001a\u00020\u0000*\u00020 2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u001f\u0010)\u001a\u00020(*\u00060$j\u0002`%2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0017\u0010-\u001a\u00020\u00172\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.\u001a\u0017\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0017H\u0002¢\u0006\u0004\b0\u00101\u001a'\u00105\u001a\u00020(*\u0002022\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(03H\u0002¢\u0006\u0004\b5\u00106\"\u0014\u00107\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108\"\u0014\u00109\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108\"\u0014\u0010:\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108\"\u0014\u0010;\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00108\"\u001a\u0010<\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u00108\u001a\u0004\b=\u0010>\"\u0014\u0010?\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108¨\u0006@"}, d2 = {"", "", "encodeFull", "spaceToPlus", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "encodeURLQueryComponent", "(Ljava/lang/String;ZZLjava/nio/charset/Charset;)Ljava/lang/String;", "encodeURLPathPart", "(Ljava/lang/String;)Ljava/lang/String;", "encodeSlash", "encodeEncoded", "encodeURLPath", "(Ljava/lang/String;ZZ)Ljava/lang/String;", "encodeOAuth", "encodeURLParameter", "(Ljava/lang/String;Z)Ljava/lang/String;", "Lio/ktor/http/AsciiBitSet;", "allowed", "percentEncode", "(Ljava/lang/String;Lio/ktor/http/AsciiBitSet;)Ljava/lang/String;", "encodeURLParameterValue", "", "start", "end", "plusIsSpace", "decodeURLQueryComponent", "(Ljava/lang/String;IIZLjava/nio/charset/Charset;)Ljava/lang/String;", "decodeURLPart", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Ljava/lang/String;", "decodeScan", "", "prefixEnd", "decodeImpl", "(Ljava/lang/CharSequence;IIIZLjava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "byte", "", "appendPercentEncoded", "(Ljava/lang/StringBuilder;B)V", "", "c2", "charToHexDigit", "(C)I", "digit", "hexDigitToChar", "(I)C", "Lkotlinx/io/Source;", "Lkotlin/Function1;", "block", "forEach", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "URL_ALPHABET", "Lio/ktor/http/AsciiBitSet;", "HEX_ALPHABET", "URL_PROTOCOL_PART", "VALID_PATH_PART", "ATTRIBUTE_CHARACTERS", "getATTRIBUTE_CHARACTERS", "()Lio/ktor/http/AsciiBitSet;", "URL_PARAMETER_CHARS", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CodecsKt {
    private static final AsciiBitSet ATTRIBUTE_CHARACTERS;
    private static final AsciiBitSet HEX_ALPHABET;
    private static final AsciiBitSet URL_ALPHABET;
    private static final AsciiBitSet URL_PARAMETER_CHARS;
    private static final AsciiBitSet URL_PROTOCOL_PART;
    private static final AsciiBitSet VALID_PATH_PART;

    static {
        ArrayList arrayListPlus;
        ArrayList arrayListPlus2;
        AsciiBitSet.Companion companion = AsciiBitSet.INSTANCE;
        Iterable charRange = new CharRange('a', GMTDateParser.ZONE);
        CharRange charRange2 = new CharRange('A', 'Z');
        if (charRange instanceof Collection) {
            arrayListPlus = CollectionsKt.plus((Iterable) charRange2, (Collection) charRange);
        } else {
            ArrayList arrayList = new ArrayList();
            CollectionsKt__MutableCollectionsKt.addAll(charRange, arrayList);
            CollectionsKt__MutableCollectionsKt.addAll(charRange2, arrayList);
            arrayListPlus = arrayList;
        }
        AsciiBitSet asciiBitSetOf = companion.of(CollectionsKt.plus((Iterable) new CharRange('0', '9'), (Collection) arrayListPlus));
        URL_ALPHABET = asciiBitSetOf;
        Iterable charRange3 = new CharRange('a', 'f');
        CharRange charRange4 = new CharRange('A', 'F');
        if (charRange3 instanceof Collection) {
            arrayListPlus2 = CollectionsKt.plus((Iterable) charRange4, (Collection) charRange3);
        } else {
            ArrayList arrayList2 = new ArrayList();
            CollectionsKt__MutableCollectionsKt.addAll(charRange3, arrayList2);
            CollectionsKt__MutableCollectionsKt.addAll(charRange4, arrayList2);
            arrayListPlus2 = arrayList2;
        }
        HEX_ALPHABET = companion.of(CollectionsKt.plus((Iterable) new CharRange('0', '9'), (Collection) arrayListPlus2));
        URL_PROTOCOL_PART = companion.of(":/?#[]@!$&'()*,;=-._~+");
        VALID_PATH_PART = companion.of(":@!$&'()*+,;=-._~");
        ATTRIBUTE_CHARACTERS = asciiBitSetOf.plus(companion.of("!#$&+-.^_`|~"));
        URL_PARAMETER_CHARS = asciiBitSetOf.plus(companion.of("-._~"));
    }

    private static final void appendPercentEncoded(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(hexDigitToChar((b & 255) >> 4));
        sb.append(hexDigitToChar(b & 15));
    }

    private static final int charToHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        if ('a' > c || c >= 'g') {
            return -1;
        }
        return c - 'W';
    }

    private static final String decodeImpl(CharSequence charSequence, int i, int i2, int i3, boolean z, Charset charset) throws URLDecodeException {
        int i4 = i2 - i;
        if (i4 > 255) {
            i4 /= 3;
        }
        StringBuilder sb = new StringBuilder(i4);
        if (i3 > i) {
            sb.append(charSequence, i, i3);
        }
        byte[] bArr = null;
        while (i3 < i2) {
            char cCharAt = charSequence.charAt(i3);
            if (z && cCharAt == '+') {
                sb.append(' ');
            } else if (cCharAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(i2 - i3) / 3];
                }
                int i5 = 0;
                while (i3 < i2 && charSequence.charAt(i3) == '%') {
                    int i6 = i3 + 2;
                    if (i6 >= i2) {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + charSequence.subSequence(i3, charSequence.length()).toString() + ", in " + ((Object) charSequence) + " at " + i3);
                    }
                    int i7 = i3 + 1;
                    int iCharToHexDigit = charToHexDigit(charSequence.charAt(i7));
                    int iCharToHexDigit2 = charToHexDigit(charSequence.charAt(i6));
                    if (iCharToHexDigit == -1 || iCharToHexDigit2 == -1) {
                        throw new URLDecodeException("Wrong HEX escape: %" + charSequence.charAt(i7) + charSequence.charAt(i6) + ", in " + ((Object) charSequence) + ", at " + i3);
                    }
                    bArr[i5] = (byte) ((iCharToHexDigit * 16) + iCharToHexDigit2);
                    i3 += 3;
                    i5++;
                }
                sb.append(StringsKt__StringsJVMKt.decodeToString$default(0, i5, 4, bArr));
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    private static final String decodeScan(String str, int i, int i2, boolean z, Charset charset) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (z && cCharAt == '+')) {
                return decodeImpl(str, i, i2, i3, z, charset);
            }
        }
        return (i == 0 && i2 == str.length()) ? str.toString() : str.substring(i, i2);
    }

    public static final String decodeURLPart(String str, int i, int i2, Charset charset) {
        str.getClass();
        charset.getClass();
        return decodeScan(str, i, i2, false, charset);
    }

    public static /* synthetic */ String decodeURLPart$default(String str, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLPart(str, i, i2, charset);
    }

    public static final String decodeURLQueryComponent(String str, int i, int i2, boolean z, Charset charset) {
        str.getClass();
        charset.getClass();
        return decodeScan(str, i, i2, z, charset);
    }

    public static /* synthetic */ String decodeURLQueryComponent$default(String str, int i, int i2, boolean z, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLQueryComponent(str, i, i2, z, charset);
    }

    public static final String encodeOAuth(String str) {
        str.getClass();
        return encodeURLParameter$default(str, false, 1, null);
    }

    public static final String encodeURLParameter(String str, boolean z) {
        str.getClass();
        byte[] byteArray = StringsKt.toByteArray(str, Charsets.UTF_8);
        StringBuilder sb = new StringBuilder(byteArray.length);
        for (byte b : byteArray) {
            if (URL_PARAMETER_CHARS.contains(b)) {
                sb.append((char) b);
            } else if (z && b == 32) {
                sb.append('+');
            } else {
                appendPercentEncoded(sb, b);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String encodeURLParameter$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return encodeURLParameter(str, z);
    }

    public static final String encodeURLParameterValue(String str) {
        str.getClass();
        return encodeURLParameter(str, true);
    }

    public static final String encodeURLPath(String str, boolean z, boolean z2) {
        int i;
        str.getClass();
        StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if ((!z && cCharAt == '/') || URL_ALPHABET.contains(cCharAt) || VALID_PATH_PART.contains(cCharAt)) {
                sb.append(cCharAt);
                i2++;
            } else {
                if (!z2 && cCharAt == '%' && (i = i2 + 2) < str.length()) {
                    AsciiBitSet asciiBitSet = HEX_ALPHABET;
                    int i3 = i2 + 1;
                    if (asciiBitSet.contains(str.charAt(i3)) && asciiBitSet.contains(str.charAt(i))) {
                        sb.append(cCharAt);
                        sb.append(str.charAt(i3));
                        sb.append(str.charAt(i));
                        i2 += 3;
                    }
                }
                if (cCharAt < 128) {
                    appendPercentEncoded(sb, (byte) cCharAt);
                    i2++;
                } else {
                    int i4 = (55296 > cCharAt || cCharAt >= 57344) ? 1 : 2;
                    CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                    charsetEncoderNewEncoder.getClass();
                    int i5 = i4 + i2;
                    forEach(EncodingKt.encode(charsetEncoderNewEncoder, str, i2, i5), new MimesKt$$ExternalSyntheticLambda0((byte) 26, sb));
                    i2 = i5;
                }
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String encodeURLPath$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return encodeURLPath(str, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit encodeURLPath$lambda$0$0(StringBuilder sb, byte b) {
        appendPercentEncoded(sb, b);
        return Unit.INSTANCE;
    }

    public static final String encodeURLPathPart(String str) {
        str.getClass();
        return encodeURLPath$default(str, true, false, 2, null);
    }

    public static final String encodeURLQueryComponent(String str, boolean z, boolean z2, Charset charset) {
        str.getClass();
        charset.getClass();
        byte[] byteArray = StringsKt.toByteArray(str, charset);
        StringBuilder sb = new StringBuilder(byteArray.length);
        for (byte b : byteArray) {
            if (b == 32) {
                if (z2) {
                    sb.append('+');
                } else {
                    sb.append("%20");
                }
            } else if (URL_ALPHABET.contains(b) || (!z && URL_PROTOCOL_PART.contains(b))) {
                sb.append((char) b);
            } else {
                appendPercentEncoded(sb, b);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String encodeURLQueryComponent$default(String str, boolean z, boolean z2, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return encodeURLQueryComponent(str, z, z2, charset);
    }

    private static final void forEach(Source source, Function1 function1) {
        ByteReadPacketKt.takeWhile(source, new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean forEach$lambda$0(Function1 function1, Buffer buffer) {
        buffer.getClass();
        while (BufferKt.canRead(buffer)) {
            function1.invoke(Byte.valueOf(buffer.readByte()));
        }
        return true;
    }

    public static final AsciiBitSet getATTRIBUTE_CHARACTERS() {
        return ATTRIBUTE_CHARACTERS;
    }

    private static final char hexDigitToChar(int i) {
        return (char) ((i < 0 || i >= 10) ? ((char) (i + 65)) - '\n' : i + 48);
    }

    public static final String percentEncode(String str, AsciiBitSet asciiBitSet) {
        str.getClass();
        asciiBitSet.getClass();
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!asciiBitSet.contains(str.charAt(i2))) {
                i++;
            }
        }
        if (i == 0) {
            return str;
        }
        byte[] byteArray = StringsKt.toByteArray(str, Charsets.UTF_8);
        int length = str.length() - i;
        char[] cArr = new char[((byteArray.length - length) * 3) + length];
        int i3 = 0;
        for (byte b : byteArray) {
            if (asciiBitSet.contains(b)) {
                cArr[i3] = (char) b;
                i3++;
            } else {
                cArr[i3] = '%';
                int i4 = i3 + 2;
                cArr[i3 + 1] = hexDigitToChar((b & 255) >> 4);
                i3 += 3;
                cArr[i4] = hexDigitToChar(b & 15);
            }
        }
        return new String(cArr);
    }
}
