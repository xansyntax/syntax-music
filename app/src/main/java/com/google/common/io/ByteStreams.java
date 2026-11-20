package com.google.common.io;

import coil3.util.UtilsKt;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ByteStreams {
    static {
        new AnonymousClass1();
    }

    public static byte[] combineBuffers(ArrayDeque arrayDeque, int i) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i = 0;
        while (i < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i2 = 0;
            while (i2 < iMin2) {
                int i3 = inputStream.read(bArr, i2, iMin2 - i2);
                if (i3 == -1) {
                    return combineBuffers(arrayDeque, i);
                }
                i2 += i3;
                i += i3;
            }
            iMin = StringsKt__IndentKt.saturatedCast(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return combineBuffers(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* JADX INFO: renamed from: com.google.common.io.ByteStreams$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends OutputStream {
        public final String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            bArr.getClass();
            UtilsKt.checkPositionIndexes(i, i2 + i, bArr.length);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            bArr.getClass();
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    }
}
