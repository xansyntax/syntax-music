package androidx.media3.common.util;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableSet;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParsableByteArray {
    public static final char[] CR_AND_LF = {'\r', '\n'};
    public static final char[] LF = {'\n'};
    public static final ImmutableSet SUPPORTED_CHARSETS_FOR_READLINE = ImmutableSet.construct(5, StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    public static final AtomicBoolean shouldEnforceLimitOnLegacyMethods = new AtomicBoolean();
    public byte[] data;
    public int limit;
    public int position;

    public ParsableByteArray(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public static int decodeUtf8CodeUnit(int i, int i2, int i3, int i4) {
        byte b = (byte) i3;
        return StringsKt__IndentKt.fromBytes((byte) 0, CollectionsKt__IterablesKt.checkedCast(((i & 7) << 2) | ((i2 & 48) >> 4)), CollectionsKt__IterablesKt.checkedCast(((((byte) i2) & 15) << 4) | ((b & 60) >> 2)), CollectionsKt__IterablesKt.checkedCast(((b & 3) << 6) | (((byte) i4) & 63)));
    }

    public static int getSmallestCodeUnitSize(Charset charset) {
        UtilsKt.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean isUtf8ContinuationByte(byte b) {
        return (b & 192) == 128;
    }

    public final int bytesLeft() {
        return Math.max(this.limit - this.position, 0);
    }

    public final void ensureCapacity(int i) {
        byte[] bArr = this.data;
        if (i > bArr.length) {
            this.data = Arrays.copyOf(bArr, i);
        }
    }

    public final void maybeAssertAtLeastBytesLeftForLegacyMethod(int i) {
        if (!shouldEnforceLimitOnLegacyMethods.get() || bytesLeft() >= i) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "bytesNeeded= ", ", bytesLeft="), bytesLeft());
    }

    public final char peekChar(int i, ByteOrder byteOrder) {
        byte b;
        byte b2;
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
        byte[] bArr = this.data;
        int i2 = this.position;
        if (byteOrder == byteOrder2) {
            int i3 = i2 + i;
            b = bArr[i3];
            b2 = bArr[i3 + 1];
        } else {
            int i4 = i2 + i;
            b = bArr[i4 + 1];
            b2 = bArr[i4];
        }
        return (char) ((b2 & 255) | (b << 8));
    }

    public final int peekCodePointAndSize(Charset charset) {
        int codePoint;
        int i;
        UtilsKt.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        if (bytesLeft() < getSmallestCodeUnitSize(charset)) {
            FrameworkMediaDrm$$ExternalSyntheticLambda0.m(this.position, this.limit);
            return 0;
        }
        int i2 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b = this.data[this.position];
            if ((b & 128) == 0) {
                codePoint = Byte.toUnsignedInt(b);
                return (codePoint << 8) | i2;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b2 = this.data[this.position];
            if ((b2 & 128) == 0) {
                i = 1;
            } else if ((b2 & 224) == 192 && bytesLeft() >= 2 && isUtf8ContinuationByte(this.data[this.position + 1])) {
                i = 2;
            } else if ((this.data[this.position] & 240) == 224 && bytesLeft() >= 3 && isUtf8ContinuationByte(this.data[this.position + 1]) && isUtf8ContinuationByte(this.data[this.position + 2])) {
                i = 3;
            } else {
                i = ((this.data[this.position] & 248) == 240 && bytesLeft() >= 4 && isUtf8ContinuationByte(this.data[this.position + 1]) && isUtf8ContinuationByte(this.data[this.position + 2]) && isUtf8ContinuationByte(this.data[this.position + 3])) ? 4 : 0;
            }
            if (i == 1) {
                codePoint = Byte.toUnsignedInt(this.data[this.position]);
            } else if (i == 2) {
                byte[] bArr = this.data;
                int i3 = this.position;
                codePoint = decodeUtf8CodeUnit(0, 0, bArr[i3], bArr[i3 + 1]);
            } else {
                if (i != 3) {
                    if (i == 4) {
                        byte[] bArr2 = this.data;
                        int i4 = this.position;
                        codePoint = decodeUtf8CodeUnit(bArr2[i4], bArr2[i4 + 1], bArr2[i4 + 2], bArr2[i4 + 3]);
                    }
                    return 0;
                }
                byte[] bArr3 = this.data;
                int i5 = this.position;
                codePoint = decodeUtf8CodeUnit(0, bArr3[i5] & 15, bArr3[i5 + 1], bArr3[i5 + 2]);
            }
            i2 = i;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cPeekChar = peekChar(0, byteOrder);
            if (!Character.isHighSurrogate(cPeekChar) || bytesLeft() < 4) {
                codePoint = cPeekChar;
                i2 = 2;
            } else {
                codePoint = Character.toCodePoint(cPeekChar, peekChar(2, byteOrder));
                i2 = 4;
            }
        }
        return (codePoint << 8) | i2;
    }

    public final int peekInt() {
        if (bytesLeft() < 4) {
            FrameworkMediaDrm$$ExternalSyntheticLambda0.m(this.position, this.limit);
            return 0;
        }
        int i = readInt();
        this.position -= 4;
        return i;
    }

    public final int peekUnsignedByte() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        return this.data[this.position] & 255;
    }

    public final void readBytes(byte[] bArr, int i, int i2) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i2);
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final char readCharacterIfInList(Charset charset, char[] cArr) {
        int iPeekCodePointAndSize;
        if (bytesLeft() >= getSmallestCodeUnitSize(charset) && (iPeekCodePointAndSize = peekCodePointAndSize(charset)) != 0) {
            long j = iPeekCodePointAndSize >>> 8;
            UtilsKt.checkArgument(j, "out of range: %s", (j >> 32) == 0);
            int i = (int) j;
            if (!Character.isSupplementaryCodePoint(i)) {
                long j2 = i;
                char c = (char) j2;
                UtilsKt.checkArgument(j2, "Out of range: %s", ((long) c) == j2);
                for (char c2 : cArr) {
                    if (c2 == c) {
                        this.position = StringsKt__IndentKt.checkedCast(iPeekCodePointAndSize & 255) + this.position;
                        return c;
                    }
                }
            }
        }
        return (char) 0;
    }

    public final int readInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i + 2;
        this.position = i4;
        int i5 = ((bArr[i2] & 255) << 16) | i3;
        int i6 = i + 3;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.position = i + 4;
        return (bArr[i6] & 255) | i7;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x0088  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x0099  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5 A[ADDED_TO_REGION, EDGE_INSN: B:65:0x00b5->B:55:0x00b5 BREAK  A[LOOP:0: B:25:0x0051->B:53:0x00b2], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5 A[ADDED_TO_REGION, EDGE_INSN: B:67:0x00b5->B:55:0x00b5 BREAK  A[LOOP:0: B:25:0x0051->B:53:0x00b2], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00b2 A[SYNTHETIC] */
    public final String readLine(Charset charset) {
        int i;
        byte[] bArr;
        byte b;
        byte[] bArr2;
        byte b2;
        UtilsKt.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        if (bytesLeft() == 0) {
            return null;
        }
        Charset charset2 = StandardCharsets.US_ASCII;
        if (!charset.equals(charset2)) {
            readUtfCharsetFromBom();
        }
        if (charset.equals(StandardCharsets.UTF_8) || charset.equals(charset2)) {
            i = 1;
        } else {
            if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
                PathKt$$ExternalSyntheticBUOutline0.m$3(charset, "Unsupported charset: ");
                return null;
            }
            i = 2;
        }
        int i2 = this.position;
        while (true) {
            int i3 = this.limit;
            if (i2 >= i3 - (i - 1)) {
                i2 = i3;
                break;
            }
            if (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) {
                byte b3 = this.data[i2];
                String str = Util.DEVICE_DEBUG_INFO;
                if (b3 == 10 || b3 == 13) {
                    break;
                }
                if (!charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                    bArr = this.data;
                    if (bArr[i2] == 0) {
                        b = bArr[i2 + 1];
                        String str2 = Util.DEVICE_DEBUG_INFO;
                        if (b != 10 || b == 13) {
                            break;
                        }
                        if (charset.equals(StandardCharsets.UTF_16LE)) {
                            bArr2 = this.data;
                            if (bArr2[i2 + 1] == 0) {
                                b2 = bArr2[i2];
                                String str3 = Util.DEVICE_DEBUG_INFO;
                                if (b2 != 10 || b2 == 13) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        i2 += i;
                    } else {
                        if (charset.equals(StandardCharsets.UTF_16LE)) {
                            bArr2 = this.data;
                            if (bArr2[i2 + 1] == 0) {
                                b2 = bArr2[i2];
                                String str4 = Util.DEVICE_DEBUG_INFO;
                                if (b2 != 10) {
                                    break;
                                }
                                break;
                                break;
                            }
                            continue;
                        }
                        i2 += i;
                    }
                } else {
                    if (charset.equals(StandardCharsets.UTF_16LE)) {
                        bArr2 = this.data;
                        if (bArr2[i2 + 1] == 0) {
                            b2 = bArr2[i2];
                            String str5 = Util.DEVICE_DEBUG_INFO;
                            if (b2 != 10) {
                                break;
                                break;
                            }
                            break;
                            break;
                        }
                        continue;
                    }
                    i2 += i;
                }
            } else if (charset.equals(StandardCharsets.UTF_16)) {
                bArr = this.data;
                if (bArr[i2] == 0) {
                    b = bArr[i2 + 1];
                    String str6 = Util.DEVICE_DEBUG_INFO;
                    if (b != 10) {
                        break;
                    }
                    break;
                    break;
                }
                if (charset.equals(StandardCharsets.UTF_16LE)) {
                    bArr2 = this.data;
                    if (bArr2[i2 + 1] == 0) {
                        b2 = bArr2[i2];
                        String str7 = Util.DEVICE_DEBUG_INFO;
                        if (b2 != 10) {
                            break;
                            break;
                        }
                        break;
                        break;
                    }
                    continue;
                }
                i2 += i;
            } else {
                bArr = this.data;
                if (bArr[i2] == 0) {
                    b = bArr[i2 + 1];
                    String str8 = Util.DEVICE_DEBUG_INFO;
                    if (b != 10) {
                        break;
                        break;
                    }
                    break;
                    break;
                }
                if (charset.equals(StandardCharsets.UTF_16LE)) {
                    bArr2 = this.data;
                    if (bArr2[i2 + 1] == 0) {
                        b2 = bArr2[i2];
                        String str9 = Util.DEVICE_DEBUG_INFO;
                        if (b2 != 10) {
                            break;
                            break;
                        }
                        break;
                        break;
                    }
                    continue;
                }
                i2 += i;
            }
        }
        String string = readString(i2 - this.position, charset);
        if (this.position != this.limit && readCharacterIfInList(charset, CR_AND_LF) == '\r') {
            readCharacterIfInList(charset, LF);
        }
        return string;
    }

    public final int readLittleEndianInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.position = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.position = i + 4;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public final long readLittleEndianLong() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(8);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i + 2;
        this.position = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i + 3;
        this.position = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i + 4;
        this.position = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i + 5;
        this.position = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i + 6;
        this.position = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i + 7;
        this.position = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 48);
        this.position = i + 8;
        return ((((long) bArr[i8]) & 255) << 56) | j7;
    }

    public final short readLittleEndianShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        this.position = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public final long readLittleEndianUnsignedInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i + 2;
        this.position = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i + 3;
        this.position = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        this.position = i + 4;
        return ((((long) bArr[i4]) & 255) << 24) | j3;
    }

    public final int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(littleEndianInt, "Top bit not zero: "));
        return 0;
    }

    public final int readLittleEndianUnsignedShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        this.position = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final long readLong() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(8);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i + 2;
        this.position = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i4 = i + 3;
        this.position = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i + 4;
        this.position = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i + 5;
        this.position = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i + 6;
        this.position = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i + 7;
        this.position = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        this.position = i + 8;
        return (((long) bArr[i8]) & 255) | j7;
    }

    public final String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != 0) {
            i++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        String str = Util.DEVICE_DEBUG_INFO;
        String str2 = new String(bArr, i2, i - i2, StandardCharsets.UTF_8);
        this.position = i;
        if (i < this.limit) {
            this.position = i + 1;
        }
        return str2;
    }

    public final short readShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public final String readString(int i, Charset charset) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        return str;
    }

    public final int readSynchSafeInt() {
        return readUnsignedByte() | (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7);
    }

    public final int readUnsignedByte() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedFixedPoint1616() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i + 2;
        int i4 = (bArr[i2] & 255) | i3;
        this.position = i + 4;
        return i4;
    }

    public final long readUnsignedInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i + 2;
        this.position = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i4 = i + 3;
        this.position = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        this.position = i + 4;
        return (((long) bArr[i4]) & 255) | j3;
    }

    public final int readUnsignedInt24() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(3);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i + 2;
        this.position = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.position = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    public final int readUnsignedIntToInt() {
        int i = readInt();
        if (i >= 0) {
            return i;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "Top bit not zero: "));
        return 0;
    }

    public final int readUnsignedLeb128ToInt() {
        long j = 0;
        for (int i = 0; i < 9; i++) {
            if (this.position == this.limit) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Attempting to read a byte over the limit.");
                return 0;
            }
            long unsignedByte = readUnsignedByte();
            j |= (127 & unsignedByte) << (i * 7);
            if ((unsignedByte & 128) == 0) {
                break;
            }
        }
        return StringsKt__IndentKt.checkedCast(j);
    }

    public final long readUnsignedLongToLong() {
        long j = readLong();
        if (j >= 0) {
            return j;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Format$$ExternalSyntheticOutline0.m(j, "Top bit not zero: "));
        return 0L;
    }

    public final int readUnsignedShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public final long readUtf8EncodedLong() {
        int i;
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        long j = this.data[this.position];
        int i2 = 7;
        while (true) {
            if (i2 >= 0) {
                int i3 = 1 << i2;
                if ((((long) i3) & j) == 0) {
                    if (i2 < 6) {
                        j &= (long) (i3 - 1);
                        i = 7 - i2;
                        break;
                    }
                    if (i2 == 7) {
                        i = 1;
                        break;
                    }
                } else {
                    i2--;
                }
            }
            i = 0;
            break;
        }
        if (i == 0) {
            throw new NumberFormatException(Format$$ExternalSyntheticOutline0.m(j, "Invalid UTF-8 sequence first byte: "));
        }
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        for (int i4 = 1; i4 < i; i4++) {
            byte b = this.data[this.position + i4];
            if ((b & 192) != 128) {
                throw new NumberFormatException(Format$$ExternalSyntheticOutline0.m(j, "Invalid UTF-8 sequence continuation byte: "));
            }
            j = (j << 6) | ((long) (b & 63));
        }
        this.position += i;
        return j;
    }

    public final Charset readUtfCharsetFromBom() {
        if (bytesLeft() >= 3) {
            byte[] bArr = this.data;
            int i = this.position;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.position = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (bytesLeft() < 2) {
            return null;
        }
        byte[] bArr2 = this.data;
        int i2 = this.position;
        byte b = bArr2[i2];
        if (b == -2 && bArr2[i2 + 1] == -1) {
            this.position = i2 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.position = i2 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void reset(int i) {
        byte[] bArr = this.data;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        reset(bArr, i);
    }

    public final void setLimit(int i) {
        UtilsKt.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public final void setPosition(int i) {
        UtilsKt.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public final void skipBytes(int i) {
        setPosition(this.position + i);
    }

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public final void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public final String readNullTerminatedString(int i) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        if (i == 0) {
            return "";
        }
        int i2 = this.position;
        int i3 = (i2 + i) - 1;
        int i4 = (i3 >= this.limit || this.data[i3] != 0) ? i : i - 1;
        byte[] bArr = this.data;
        String str = Util.DEVICE_DEBUG_INFO;
        String str2 = new String(bArr, i2, i4, StandardCharsets.UTF_8);
        this.position += i;
        return str2;
    }
}
