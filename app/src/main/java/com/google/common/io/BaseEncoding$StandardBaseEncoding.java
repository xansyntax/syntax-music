package com.google.common.io;

import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class BaseEncoding$StandardBaseEncoding {
    public static final BaseEncoding$Base16Encoding BASE16;
    public final BaseEncoding$Alphabet alphabet;
    public volatile BaseEncoding$StandardBaseEncoding lowerCase;
    public final Character paddingChar;

    static {
        final String str = "base64()";
        final String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        new BaseEncoding$StandardBaseEncoding(str, str2) { // from class: com.google.common.io.BaseEncoding$Base64Encoding
            /* JADX WARN: Illegal instructions before constructor call */
            {
                char[] charArray = str2.toCharArray();
                super(new BaseEncoding$Alphabet(str, charArray), (Character) '=');
                UtilsKt.checkArgument(charArray.length == 64);
            }

            @Override // com.google.common.io.BaseEncoding$StandardBaseEncoding
            public final void encodeTo(StringBuilder sb, byte[] bArr, int i) {
                int i2 = 0;
                UtilsKt.checkPositionIndexes(0, i, bArr.length);
                for (int i3 = i; i3 >= 3; i3 -= 3) {
                    int i4 = i2 + 2;
                    int i5 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
                    i2 += 3;
                    int i6 = i5 | (bArr[i4] & 255);
                    BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
                    char[] cArr = baseEncoding$Alphabet.chars;
                    char[] cArr2 = baseEncoding$Alphabet.chars;
                    sb.append(cArr[i6 >>> 18]);
                    sb.append(cArr2[(i6 >>> 12) & 63]);
                    sb.append(cArr2[(i6 >>> 6) & 63]);
                    sb.append(cArr2[i6 & 63]);
                }
                if (i2 < i) {
                    encodeChunkTo(sb, bArr, i2, i - i2);
                }
            }
        };
        final String str3 = "base64Url()";
        final String str4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
        new BaseEncoding$StandardBaseEncoding(str3, str4) { // from class: com.google.common.io.BaseEncoding$Base64Encoding
            /* JADX WARN: Illegal instructions before constructor call */
            {
                char[] charArray = str4.toCharArray();
                super(new BaseEncoding$Alphabet(str3, charArray), (Character) '=');
                UtilsKt.checkArgument(charArray.length == 64);
            }

            @Override // com.google.common.io.BaseEncoding$StandardBaseEncoding
            public final void encodeTo(StringBuilder sb, byte[] bArr, int i) {
                int i2 = 0;
                UtilsKt.checkPositionIndexes(0, i, bArr.length);
                for (int i3 = i; i3 >= 3; i3 -= 3) {
                    int i4 = i2 + 2;
                    int i5 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
                    i2 += 3;
                    int i6 = i5 | (bArr[i4] & 255);
                    BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
                    char[] cArr = baseEncoding$Alphabet.chars;
                    char[] cArr2 = baseEncoding$Alphabet.chars;
                    sb.append(cArr[i6 >>> 18]);
                    sb.append(cArr2[(i6 >>> 12) & 63]);
                    sb.append(cArr2[(i6 >>> 6) & 63]);
                    sb.append(cArr2[i6 & 63]);
                }
                if (i2 < i) {
                    encodeChunkTo(sb, bArr, i2, i - i2);
                }
            }
        };
        new BaseEncoding$StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new BaseEncoding$StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        BASE16 = new BaseEncoding$Base16Encoding(new BaseEncoding$Alphabet("base16()", new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public BaseEncoding$StandardBaseEncoding(BaseEncoding$Alphabet baseEncoding$Alphabet, Character ch) {
        boolean z;
        this.alphabet = baseEncoding$Alphabet;
        if (ch != null) {
            char cCharValue = ch.charValue();
            byte[] bArr = baseEncoding$Alphabet.decodabet;
            if (cCharValue >= bArr.length || bArr[cCharValue] == -1) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        UtilsKt.checkArgument(z, "Padding character %s was already in alphabet", ch);
        this.paddingChar = ch;
    }

    public final void encodeChunkTo(StringBuilder sb, byte[] bArr, int i, int i2) {
        UtilsKt.checkPositionIndexes(i, i + i2, bArr.length);
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        int i3 = baseEncoding$Alphabet.bytesPerChunk;
        int i4 = baseEncoding$Alphabet.bitsPerChar;
        int i5 = 0;
        UtilsKt.checkArgument(i2 <= i3);
        long j = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            j = (j | ((long) (bArr[i + i6] & 255))) << 8;
        }
        int i7 = ((i2 + 1) * 8) - i4;
        while (i5 < i2 * 8) {
            sb.append(baseEncoding$Alphabet.chars[((int) (j >>> (i7 - i5))) & baseEncoding$Alphabet.mask]);
            i5 += i4;
        }
        Character ch = this.paddingChar;
        if (ch != null) {
            while (i5 < baseEncoding$Alphabet.bytesPerChunk * 8) {
                sb.append(ch.charValue());
                i5 += i4;
            }
        }
    }

    public void encodeTo(StringBuilder sb, byte[] bArr, int i) {
        int i2 = 0;
        UtilsKt.checkPositionIndexes(0, i, bArr.length);
        while (i2 < i) {
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
            encodeChunkTo(sb, bArr, i2, Math.min(baseEncoding$Alphabet.bytesPerChunk, i - i2));
            i2 += baseEncoding$Alphabet.bytesPerChunk;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BaseEncoding$StandardBaseEncoding) {
            BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding = (BaseEncoding$StandardBaseEncoding) obj;
            if (this.alphabet.equals(baseEncoding$StandardBaseEncoding.alphabet) && Objects.equals(this.paddingChar, baseEncoding$StandardBaseEncoding.paddingChar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.paddingChar) ^ this.alphabet.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        sb.append(baseEncoding$Alphabet);
        if (8 % baseEncoding$Alphabet.bitsPerChar != 0) {
            Character ch = this.paddingChar;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public BaseEncoding$StandardBaseEncoding(String str, String str2) {
        this(new BaseEncoding$Alphabet(str, str2.toCharArray()), (Character) '=');
    }
}
