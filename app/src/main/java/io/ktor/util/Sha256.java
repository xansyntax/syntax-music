package io.ktor.util;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001c¨\u0006'"}, d2 = {"Lio/ktor/util/Sha256;", "Lio/ktor/util/HashFunction;", "<init>", "()V", "", "input", "", "offset", "length", "", "update", "([BII)V", "pos", "processChunk", "([BI)V", "", "words", "hash", "([I)V", "digest", "()[B", "reset", "", "messageLength", "J", "unprocessed", "[B", "unprocessedLimit", "I", "[I", "h0", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "Companion", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Sha256 implements HashFunction {
    private static final int[] k = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private long messageLength;
    private int unprocessedLimit;
    private final byte[] unprocessed = new byte[64];
    private final int[] words = new int[64];
    private int h0 = 1779033703;
    private int h1 = -1150833019;
    private int h2 = 1013904242;
    private int h3 = -1521486534;
    private int h4 = 1359893119;
    private int h5 = -1694144372;
    private int h6 = 528734635;
    private int h7 = 1541459225;

    private final void hash(int[] words) {
        int[] iArr = k;
        int i = this.h0;
        int i2 = this.h1;
        int i3 = this.h2;
        int i4 = this.h3;
        int i5 = this.h4;
        int i6 = this.h5;
        int i7 = this.h6;
        int i8 = this.h7;
        int i9 = 0;
        while (i9 < 64) {
            int i10 = i8 + ((((i5 >>> 6) | (i5 << 26)) ^ ((i5 >>> 11) | (i5 << 21))) ^ ((i5 >>> 25) | (i5 << 7))) + ((i5 & i6) ^ ((~i5) & i7)) + iArr[i9] + words[i9];
            int i11 = i4 + i10;
            int i12 = i10 + ((((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19))) ^ ((i >>> 22) | (i << 10))) + (((i & i2) ^ (i & i3)) ^ (i2 & i3));
            i9++;
            int i13 = i2;
            i2 = i;
            i = i12;
            i8 = i7;
            i7 = i6;
            i6 = i5;
            i5 = i11;
            i4 = i3;
            i3 = i13;
        }
        this.h0 += i;
        this.h1 += i2;
        this.h2 += i3;
        this.h3 += i4;
        this.h4 += i5;
        this.h5 += i6;
        this.h6 += i7;
        this.h7 += i8;
    }

    private final void processChunk(byte[] input, int pos) {
        int i;
        int[] iArr = this.words;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            int i3 = pos + 3;
            int iAnd = (HashFunctionKt.and(input[pos + 1], 255) << 16) | (HashFunctionKt.and(input[pos], 255) << 24) | (HashFunctionKt.and(input[pos + 2], 255) << 8);
            pos += 4;
            iArr[i2] = iAnd | HashFunctionKt.and(input[i3], 255);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i4 = iArr[i - 15];
            int i5 = iArr[i - 2];
            iArr[i] = iArr[i - 16] + ((i4 >>> 3) ^ (((i4 >>> 7) | (i4 << 25)) ^ ((i4 >>> 18) | (i4 << 14)))) + iArr[i - 7] + ((i5 >>> 10) ^ (((i5 >>> 17) | (i5 << 15)) ^ ((i5 >>> 19) | (i5 << 13))));
        }
        hash(iArr);
    }

    private final void reset() {
        this.messageLength = 0L;
        byte[] bArr = this.unprocessed;
        Arrays.fill(bArr, 0, bArr.length, (byte) 0);
        this.unprocessedLimit = 0;
        ArraysKt.fill$default(0, this.words);
        this.h0 = 1779033703;
        this.h1 = -1150833019;
        this.h2 = 1013904242;
        this.h3 = -1521486534;
        this.h4 = 1359893119;
        this.h5 = -1694144372;
        this.h6 = 528734635;
        this.h7 = 1541459225;
    }

    @Override // io.ktor.util.HashFunction
    public byte[] digest() {
        byte[] bArr = this.unprocessed;
        int i = this.unprocessedLimit;
        long j = this.messageLength * 8;
        int i2 = i + 1;
        bArr[i] = -128;
        if (i2 > 56) {
            Arrays.fill(bArr, i2, 64, (byte) 0);
            processChunk(bArr, 0);
            Arrays.fill(bArr, 0, i2, (byte) 0);
        } else {
            Arrays.fill(bArr, i2, 56, (byte) 0);
        }
        bArr[56] = (byte) (j >>> 56);
        bArr[57] = (byte) (j >>> 48);
        bArr[58] = (byte) (j >>> 40);
        bArr[59] = (byte) (j >>> 32);
        bArr[60] = (byte) (j >>> 24);
        bArr[61] = (byte) (j >>> 16);
        bArr[62] = (byte) (j >>> 8);
        bArr[63] = (byte) j;
        processChunk(bArr, 0);
        int i3 = this.h0;
        int i4 = this.h1;
        int i5 = this.h2;
        int i6 = this.h3;
        int i7 = this.h4;
        int i8 = this.h5;
        int i9 = this.h6;
        int i10 = this.h7;
        reset();
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3, (byte) (i4 >> 24), (byte) (i4 >> 16), (byte) (i4 >> 8), (byte) i4, (byte) (i5 >> 24), (byte) (i5 >> 16), (byte) (i5 >> 8), (byte) i5, (byte) (i6 >> 24), (byte) (i6 >> 16), (byte) (i6 >> 8), (byte) i6, (byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7, (byte) (i8 >> 24), (byte) (i8 >> 16), (byte) (i8 >> 8), (byte) i8, (byte) (i9 >> 24), (byte) (i9 >> 16), (byte) (i9 >> 8), (byte) i9, (byte) (i10 >> 24), (byte) (i10 >> 16), (byte) (i10 >> 8), (byte) i10};
    }

    @Override // io.ktor.util.HashFunction
    public void update(byte[] input, int offset, int length) {
        input.getClass();
        this.messageLength += (long) length;
        int i = offset + length;
        byte[] bArr = this.unprocessed;
        int i2 = this.unprocessedLimit;
        if (i2 > 0) {
            int i3 = length + i2;
            if (i3 < 64) {
                ArraysKt.copyInto(i2, offset, i, input, bArr);
                this.unprocessedLimit = i3;
                return;
            } else {
                int i4 = (64 - i2) + offset;
                ArraysKt.copyInto(i2, offset, i4, input, bArr);
                processChunk(bArr, 0);
                this.unprocessedLimit = 0;
                offset = i4;
            }
        }
        while (offset < i) {
            int i5 = offset + 64;
            if (i5 > i) {
                ArraysKt.copyInto(0, offset, i, input, bArr);
                this.unprocessedLimit = i - offset;
                return;
            } else {
                processChunk(input, offset);
                offset = i5;
            }
        }
    }
}
