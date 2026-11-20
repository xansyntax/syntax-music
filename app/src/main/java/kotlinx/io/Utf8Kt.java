package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.util.date.GMTDateParser;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Utf8Kt {
    public static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public static final void checkBounds(long j, long j2, long j3) {
        if (j2 < 0 || j3 > j) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j2, "startIndex (", ") and endIndex (");
            sbM.append(j3);
            sbM.append(") are not within the range [0..size(");
            sbM.append(j);
            sbM.append("))");
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (j2 <= j3) {
            return;
        }
        StringBuilder sbM2 = Fragment$5$$ExternalSyntheticOutline0.m(j2, "startIndex (", ") > endIndex (");
        sbM2.append(j3);
        sbM2.append(')');
        throw new IllegalArgumentException(sbM2.toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if (j2 < 0 || j2 > j || j - j2 < j3 || j3 < 0) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j2, "offset (", ") and byteCount (");
            sbM.append(j3);
            sbM.append(") are not within the range [0..size(");
            sbM.append(j);
            sbM.append("))");
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public static final String commonReadUtf8(Buffer buffer, long j) {
        if (j == 0) {
            return "";
        }
        Segment segment = buffer.head;
        if (segment == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreacheable");
            return null;
        }
        if (segment.getSize() < j) {
            byte[] byteArray = readByteArray(buffer, (int) j);
            return UuidKt.commonToUtf8String(byteArray, 0, byteArray.length);
        }
        byte[] bArr = segment.data;
        int i = segment.pos;
        String strCommonToUtf8String = UuidKt.commonToUtf8String(bArr, i, Math.min(segment.limit, ((int) j) + i));
        buffer.skip(j);
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) throws EOFException {
        int i;
        int i2;
        int i3;
        buffer.require(1L);
        byte b = buffer.get(0L);
        if ((b & 128) == 0) {
            i = b & 127;
            i3 = 0;
            i2 = 1;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                buffer.skip(1L);
                return 65533;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (buffer.sizeMut < j) {
            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i2, "size < ", ": ");
            sbM2m.append(buffer.sizeMut);
            sbM2m.append(" (to read code point prefixed 0x");
            char[] cArr = HEX_DIGIT_CHARS;
            sbM2m.append(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]}));
            sbM2m.append(')');
            throw new EOFException(sbM2m.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = buffer.get(j2);
            if ((b2 & 192) != 128) {
                buffer.skip(j2);
                return 65533;
            }
            i = (i << 6) | (b2 & 63);
        }
        buffer.skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 > i || i >= 57344) && i >= i3) {
            return i;
        }
        return 65533;
    }

    public static final long indexOf(Source source, byte b, long j) {
        String str;
        String str2;
        Segment segment;
        long j2;
        long j3;
        int iIndexOf;
        long j4;
        source.getClass();
        long j5 = 0;
        if (0 > j) {
            if (j < 0) {
                str = "startIndex (0) and endIndex (";
                str2 = ") should be non negative";
            } else {
                str = "startIndex (0) is not within the range [0..endIndex(";
                str2 = "))";
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, str, str2));
            return 0L;
        }
        if (0 == j) {
            return -1L;
        }
        long j6 = 0;
        while (j6 < j && source.request(1 + j6)) {
            Buffer buffer = source.getBuffer();
            long jMin = Math.min(j, source.getBuffer().sizeMut);
            buffer.getClass();
            long jMin2 = Math.min(jMin, buffer.sizeMut);
            checkBounds(buffer.sizeMut, j6, jMin2);
            if (j6 == jMin2 || (segment = buffer.head) == null) {
                j3 = j5;
                j4 = -1;
                j2 = -1;
            } else {
                long j7 = j5;
                long size = buffer.sizeMut;
                j2 = -1;
                if (size - j6 < j6) {
                    Segment segment2 = buffer.tail;
                    while (segment2 != null && size > j6) {
                        size -= (long) (segment2.limit - segment2.pos);
                        if (size <= j6) {
                            break;
                        }
                        segment2 = segment2.prev;
                    }
                    if (size == -1) {
                        j3 = j7;
                    } else {
                        while (true) {
                            if (jMin2 <= size) {
                                long j8 = j7;
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                                return j8;
                            }
                            segment2.getClass();
                            j3 = j7;
                            iIndexOf = indexOf(segment2, b, Math.max((int) (j6 - size), 0), Math.min(segment2.getSize(), (int) (jMin2 - size)));
                            if (iIndexOf != -1) {
                                j4 = size + ((long) iIndexOf);
                            } else {
                                size += (long) segment2.getSize();
                                segment2 = segment2.next;
                                if (segment2 != null && size < jMin2) {
                                    j7 = j3;
                                }
                            }
                        }
                    }
                    j4 = -1;
                } else {
                    j3 = j7;
                    size = j3;
                    while (segment != null) {
                        long j9 = ((long) (segment.limit - segment.pos)) + size;
                        if (j9 > j6) {
                            break;
                        }
                        segment = segment.next;
                        size = j9;
                    }
                    if (size != -1) {
                        while (true) {
                            if (jMin2 <= size) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                                return j3;
                            }
                            segment.getClass();
                            iIndexOf = indexOf(segment, b, Math.max((int) (j6 - size), 0), Math.min(segment.getSize(), (int) (jMin2 - size)));
                            if (iIndexOf != -1) {
                                j4 = size + ((long) iIndexOf);
                            } else {
                                size += (long) segment.getSize();
                                segment = segment.next;
                                if (segment == null || size >= jMin2) {
                                }
                            }
                        }
                    }
                    j4 = -1;
                }
            }
            if (j4 != j2) {
                return j4;
            }
            j6 = source.getBuffer().sizeMut;
            j5 = j3;
        }
        return -1L;
    }

    public static /* synthetic */ long indexOf$default(Source source, byte b, long j, int i) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        return indexOf(source, b, j);
    }

    public static final boolean isEmpty(Segment segment) {
        segment.getClass();
        return segment.getSize() == 0;
    }

    public static final int readAtMostTo(Source source, ByteBuffer byteBuffer) {
        source.getClass();
        byteBuffer.getClass();
        if (source.getBuffer().sizeMut == 0) {
            source.request(8192L);
            if (source.getBuffer().sizeMut == 0) {
                return -1;
            }
        }
        Buffer buffer = source.getBuffer();
        buffer.getClass();
        if (buffer.exhausted()) {
            return -1;
        }
        if (buffer.exhausted()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
            return 0;
        }
        Segment segment = buffer.head;
        segment.getClass();
        byte[] bArr = segment.data;
        int i = segment.pos;
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - i);
        byteBuffer.put(bArr, i, iMin);
        if (iMin == 0) {
            return iMin;
        }
        if (iMin < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
            return 0;
        }
        if (iMin <= segment.getSize()) {
            buffer.skip(iMin);
            return iMin;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
        return 0;
    }

    public static final byte[] readByteArray(Source source, int i) {
        long j = i;
        if (j >= 0) {
            return readByteArrayImpl(source, i);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
        return null;
    }

    public static final byte[] readByteArrayImpl(Source source, int i) throws EOFException {
        if (i == -1) {
            for (long j = 2147483647L; source.getBuffer().sizeMut < 2147483647L && source.request(j); j *= 2) {
            }
            if (source.getBuffer().sizeMut >= 2147483647L) {
                throw new IllegalStateException(("Can't create an array of size " + source.getBuffer().sizeMut).toString());
            }
            i = (int) source.getBuffer().sizeMut;
        } else {
            source.require(i);
        }
        byte[] bArr = new byte[i];
        readTo(source.getBuffer(), bArr, 0, i);
        return bArr;
    }

    public static final int readCodePointValue(Source source) {
        source.getClass();
        if (source instanceof Buffer) {
            return commonReadUtf8CodePoint((Buffer) source);
        }
        source.require(1L);
        byte b = source.getBuffer().get(0L);
        if ((b & 224) == 192) {
            source.require(2L);
        } else if ((b & 240) == 224) {
            source.require(3L);
        } else if ((b & 248) == 240) {
            source.require(4L);
        }
        return commonReadUtf8CodePoint(source.getBuffer());
    }

    public static String readLineStrict$default(Source source) throws EOFException {
        source.getClass();
        long j = 1;
        source.require(1L);
        long jIndexOf = indexOf(source, (byte) 10, Long.MAX_VALUE);
        if (jIndexOf == 0) {
            source.skip(1L);
            return "";
        }
        if (jIndexOf <= 0) {
            if (source.getBuffer().sizeMut >= Long.MAX_VALUE) {
                throw new EOFException();
            }
            throw new EOFException();
        }
        long j2 = jIndexOf - 1;
        if (source.getBuffer().get(j2) == 13) {
            j = 2;
            jIndexOf = j2;
        }
        String string = readString(source, jIndexOf);
        source.skip(j);
        return string;
    }

    public static final String readString(Source source, long j) {
        source.getClass();
        source.require(j);
        return commonReadUtf8(source.getBuffer(), j);
    }

    public static final String readStringImpl(Buffer buffer, long j, Charset charset) throws EOFException {
        int i;
        String str;
        if (j < 0 || j > 2147483647L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") is not within the range [0..2147483647)"));
            return null;
        }
        if (buffer.sizeMut < j) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "Buffer contains less bytes then required (byteCount: ", ", size: ");
            sbM.append(buffer.sizeMut);
            sbM.append(')');
            throw new EOFException(sbM.toString());
        }
        if (j == 0) {
            return "";
        }
        if (buffer.exhausted()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
            return null;
        }
        Segment segment = buffer.head;
        segment.getClass();
        byte[] bArr = segment.data;
        int i2 = segment.pos;
        if (segment.limit - i2 >= j) {
            i = (int) j;
            str = new String(bArr, i2, i, charset);
        } else {
            i = 0;
            str = null;
        }
        if (i != 0) {
            if (i < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                return null;
            }
            if (i > segment.getSize()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                return null;
            }
            buffer.skip(i);
        }
        return str == null ? new String(readByteArray(buffer, (int) j), charset) : str;
    }

    public static final void readTo(Source source, byte[] bArr, int i, int i2) throws EOFException {
        source.getClass();
        bArr.getClass();
        checkBounds(bArr.length, i, i2);
        int i3 = i;
        while (i3 < i2) {
            int atMostTo = source.readAtMostTo(bArr, i3, i2);
            if (atMostTo == -1) {
                throw new EOFException("Source exhausted before reading " + (i2 - i) + " bytes. Only " + atMostTo + " bytes were read.");
            }
            i3 += atMostTo;
        }
    }

    public static final void transferFrom(Buffer buffer, ByteBuffer byteBuffer) {
        buffer.getClass();
        int iRemaining = byteBuffer.remaining();
        while (iRemaining > 0) {
            Segment segmentWritableSegment = buffer.writableSegment(1);
            byte[] bArr = segmentWritableSegment.data;
            int i = segmentWritableSegment.limit;
            int iMin = Math.min(iRemaining, bArr.length - i);
            byteBuffer.get(bArr, i, iMin);
            if (iMin == 1) {
                segmentWritableSegment.limit += iMin;
                buffer.sizeMut += (long) iMin;
            } else if (iMin < 0 || iMin > segmentWritableSegment.getRemainingCapacity()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iMin, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                return;
            } else if (iMin != 0) {
                segmentWritableSegment.limit += iMin;
                buffer.sizeMut += (long) iMin;
            } else if (isEmpty(segmentWritableSegment)) {
                buffer.recycleTail();
            }
            iRemaining -= iMin;
        }
    }

    public static final void write(Sink sink, ByteBuffer byteBuffer) {
        sink.getClass();
        long j = sink.getBuffer().sizeMut;
        transferFrom(sink.getBuffer(), byteBuffer);
        long j2 = sink.getBuffer().sizeMut;
        sink.hintEmit();
    }

    public static final void writeCodePointValue(Buffer buffer, int i) {
        String strConcatToString;
        if (i < 0 || i > 1114111) {
            StringBuilder sb = new StringBuilder("Code point value is out of Unicode codespace 0..0x10ffff: 0x");
            if (i != 0) {
                char[] cArr = HEX_DIGIT_CHARS;
                int i2 = 0;
                char c = cArr[0];
                char[] cArr2 = {c, c, c, c, c, c, cArr[(i >> 4) & 15], cArr[i & 15]};
                while (i2 < 8 && cArr2[i2] == '0') {
                    i2++;
                }
                strConcatToString = StringsKt__StringsJVMKt.concatToString(cArr2, i2, 8);
            } else {
                strConcatToString = "0";
            }
            sb.append(strConcatToString);
            sb.append(" (");
            sb.append(i);
            sb.append(')');
            throw new IllegalArgumentException(sb.toString());
        }
        if (i < 128) {
            buffer.writeByte((byte) i);
            return;
        }
        if (i < 2048) {
            Segment segmentWritableSegment = buffer.writableSegment(2);
            byte[] bArr = segmentWritableSegment.data;
            int i3 = segmentWritableSegment.limit;
            bArr[i3] = (byte) ((i >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment.limit = i3 + 2;
            buffer.sizeMut += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            buffer.writeByte((byte) 63);
            return;
        }
        if (i < 65536) {
            Segment segmentWritableSegment2 = buffer.writableSegment(3);
            byte[] bArr2 = segmentWritableSegment2.data;
            int i4 = segmentWritableSegment2.limit;
            bArr2[i4] = -32;
            bArr2[i4 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment2.limit = i4 + 3;
            buffer.sizeMut += 3;
            return;
        }
        Segment segmentWritableSegment3 = buffer.writableSegment(4);
        byte[] bArr3 = segmentWritableSegment3.data;
        int i5 = segmentWritableSegment3.limit;
        bArr3[i5] = -16;
        bArr3[i5 + 1] = -128;
        bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i5 + 3] = (byte) ((i & 63) | 128);
        segmentWritableSegment3.limit = i5 + 4;
        buffer.sizeMut += 4;
    }

    public static final void writeString(Sink sink, String str, int i, int i2) {
        char cCharAt;
        long j;
        long j2;
        sink.getClass();
        str.getClass();
        checkBounds(str.length(), i, i2);
        Buffer buffer = sink.getBuffer();
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                Segment segmentWritableSegment = buffer.writableSegment(1);
                byte[] bArr = segmentWritableSegment.data;
                int i3 = -i;
                int iMin = Math.min(i2, segmentWritableSegment.getRemainingCapacity() + i);
                int i4 = i + 1;
                bArr[segmentWritableSegment.limit + i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[segmentWritableSegment.limit + i + i3] = (byte) cCharAt;
                }
                int i5 = i3 + i;
                if (i5 == 1) {
                    segmentWritableSegment.limit += i5;
                    buffer.sizeMut += (long) i5;
                } else if (i5 < 0 || i5 > segmentWritableSegment.getRemainingCapacity()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i5, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                    return;
                } else if (i5 != 0) {
                    segmentWritableSegment.limit += i5;
                    buffer.sizeMut += (long) i5;
                } else if (isEmpty(segmentWritableSegment)) {
                    buffer.recycleTail();
                }
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentWritableSegment2 = buffer.writableSegment(2);
                    byte[] bArr2 = segmentWritableSegment2.data;
                    int i6 = segmentWritableSegment2.limit;
                    bArr2[i6] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i6 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment2.limit = i6 + 2;
                    j = buffer.sizeMut;
                    j2 = 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment segmentWritableSegment3 = buffer.writableSegment(3);
                    byte[] bArr3 = segmentWritableSegment3.data;
                    int i7 = segmentWritableSegment3.limit;
                    bArr3[i7] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i7 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i7 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment3.limit = i7 + 3;
                    j = buffer.sizeMut;
                    j2 = 3;
                } else {
                    int i8 = i + 1;
                    char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        buffer.writeByte((byte) 63);
                        i = i8;
                    } else {
                        int i9 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment4 = buffer.writableSegment(4);
                        byte[] bArr4 = segmentWritableSegment4.data;
                        int i10 = segmentWritableSegment4.limit;
                        bArr4[i10] = (byte) ((i9 >> 18) | 240);
                        bArr4[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                        bArr4[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                        bArr4[i10 + 3] = (byte) ((i9 & 63) | 128);
                        segmentWritableSegment4.limit = i10 + 4;
                        buffer.sizeMut += 4;
                        i += 2;
                    }
                }
                buffer.sizeMut = j + j2;
                i++;
            }
        }
        sink.hintEmit();
    }

    public static final byte[] readByteArray(Source source) {
        source.getClass();
        return readByteArrayImpl(source, -1);
    }

    public static final int indexOf(Segment segment, byte b, int i, int i2) {
        if (i >= 0 && i < segment.getSize()) {
            if (i <= i2 && i2 <= segment.getSize()) {
                int i3 = segment.pos;
                byte[] bArr = segment.data;
                while (i < i2) {
                    if (bArr[i3 + i] == b) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) String.valueOf(i2));
            return 0;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) String.valueOf(i));
        return 0;
    }
}
