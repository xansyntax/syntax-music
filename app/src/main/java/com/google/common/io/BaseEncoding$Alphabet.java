package com.google.common.io;

import androidx.sqlite.SQLite;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BaseEncoding$Alphabet {
    public final int bitsPerChar;
    public final int bytesPerChunk;
    public final char[] chars;
    public final int charsPerChunk;
    public final byte[] decodabet;
    public final boolean ignoreCase;
    public final int mask;
    public final String name;

    public BaseEncoding$Alphabet(String str, char[] cArr, byte[] bArr, boolean z) {
        this.name = str;
        cArr.getClass();
        this.chars = cArr;
        try {
            int length = cArr.length;
            RoundingMode roundingMode = RoundingMode.UNNECESSARY;
            int iLog2 = IntMath.log2(length);
            this.bitsPerChar = iLog2;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iLog2);
            int i = 1 << (3 - iNumberOfTrailingZeros);
            this.charsPerChunk = i;
            this.bytesPerChunk = iLog2 >> iNumberOfTrailingZeros;
            this.mask = cArr.length - 1;
            this.decodabet = bArr;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < this.bytesPerChunk; i2++) {
                int i3 = this.bitsPerChar;
                RoundingMode roundingMode2 = RoundingMode.CEILING;
                zArr[IntMath.divide(i2 * 8, i3)] = true;
            }
            this.ignoreCase = z;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaseEncoding$Alphabet)) {
            return false;
        }
        BaseEncoding$Alphabet baseEncoding$Alphabet = (BaseEncoding$Alphabet) obj;
        return this.ignoreCase == baseEncoding$Alphabet.ignoreCase && Arrays.equals(this.chars, baseEncoding$Alphabet.chars);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.chars) + (this.ignoreCase ? 1231 : 1237);
    }

    public final String toString() {
        return this.name;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseEncoding$Alphabet(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (c < 128) {
                if (bArr[c] == -1) {
                    bArr[c] = (byte) i;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat("Duplicate character: %s", Character.valueOf(c)));
                    throw null;
                }
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat("Non-ASCII character: %s", Character.valueOf(c)));
                throw null;
            }
        }
        this(str, cArr, bArr, false);
    }
}
