package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.GapBuffer;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodedInputStream {
    public int groupDepth;
    public int messageDepth;
    public GapBuffer wrapper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ArrayDecoderOldVarint extends CodedInputStream {
        public final byte[] buffer;
        public final int bufferLimit;
        public int currentLimit = Integer.MAX_VALUE;
        public int lastTag;
        public int limit;
        public int pos;
        public final int startPos;

        public ArrayDecoderOldVarint(byte[] bArr, int i, int i2, boolean z) {
            this.buffer = bArr;
            int i3 = i2 + i;
            this.bufferLimit = i3;
            this.limit = i3;
            this.pos = i;
            this.startPos = i;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final void popLimit(int i) {
            this.currentLimit = i;
            int i2 = this.bufferLimit;
            if (i <= i2) {
                this.limit = i;
            } else {
                this.limit = i2;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int pushLimit(int i) {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.pos;
            int i3 = i2 + i;
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
                if (i > Integer.MAX_VALUE - (i2 - this.startPos)) {
                    throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
                }
            }
            int i4 = this.currentLimit;
            if (i3 > i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i3;
            int i5 = this.bufferLimit;
            if (i3 <= i5) {
                this.limit = i3;
                return i4;
            }
            this.limit = i5;
            return i4;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final boolean readBool() {
            return readRawVarint64() != 0;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x0031 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x0033  */
        /* JADX WARN: Code duplicated, block: B:24:0x0043  */
        /* JADX WARN: Code duplicated, block: B:26:0x0048  */
        @Override // com.google.protobuf.CodedInputStream
        public final ByteString.LiteralByteString readBytes() throws InvalidProtocolBufferException {
            byte[] bArrCopyOfRange;
            int rawVarint32Expected5BytesMax = readRawVarint32Expected5BytesMax();
            byte[] bArr = this.buffer;
            if (rawVarint32Expected5BytesMax > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (rawVarint32Expected5BytesMax <= i - i2) {
                    ByteString.LiteralByteString literalByteStringCopyFrom$1 = ByteString.copyFrom$1(bArr, i2, rawVarint32Expected5BytesMax);
                    this.pos += rawVarint32Expected5BytesMax;
                    return literalByteStringCopyFrom$1;
                }
            }
            if (rawVarint32Expected5BytesMax == 0) {
                return ByteString.EMPTY;
            }
            if (rawVarint32Expected5BytesMax > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (rawVarint32Expected5BytesMax <= i3 - i4) {
                    int i5 = rawVarint32Expected5BytesMax + i4;
                    this.pos = i5;
                    bArrCopyOfRange = Arrays.copyOfRange(bArr, i4, i5);
                } else {
                    if (rawVarint32Expected5BytesMax <= 0) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    if (rawVarint32Expected5BytesMax == 0) {
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                    bArrCopyOfRange = Internal.EMPTY_BYTE_ARRAY;
                }
            } else {
                if (rawVarint32Expected5BytesMax <= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (rawVarint32Expected5BytesMax == 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                bArrCopyOfRange = Internal.EMPTY_BYTE_ARRAY;
            }
            ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
            return bArrCopyOfRange.length == 0 ? ByteString.EMPTY : new ByteString.LiteralByteString(bArrCopyOfRange);
        }

        @Override // com.google.protobuf.CodedInputStream
        public final double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readEnum() {
            return readRawVarint32Expected10BytesMax();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readInt32() {
            return readRawVarint32Expected10BytesMax();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readInt64() {
            return readRawVarint64();
        }

        public final int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.limit - i < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = i + 4;
            byte[] bArr = this.buffer;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public final long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.limit - i < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = i + 8;
            byte[] bArr = this.buffer;
            return ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
        }

        public final int readRawVarint32Expected10BytesMax() {
            return readRawVarint32Old();
        }

        public final int readRawVarint32Expected5BytesMax() {
            return readRawVarint32Old();
        }

        public final int readRawVarint32Old() {
            int i;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.buffer;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public final long readRawVarint64() {
            long j;
            long j2;
            long j3;
            long j4;
            int i = this.pos;
            int i2 = this.limit;
            if (i2 != i) {
                int i3 = i + 1;
                byte[] bArr = this.buffer;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                j4 = (-2080896) ^ i9;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (((long) bArr[i8]) << 28);
                                if (j6 >= 0) {
                                    j2 = 266354560;
                                } else {
                                    i8 = i + 6;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (((long) bArr[i8]) << 42);
                                        if (j6 >= 0) {
                                            j2 = 4363953127296L;
                                        } else {
                                            i8 = i + 8;
                                            j7 = j6 ^ (((long) bArr[i4]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                j6 = j7 ^ (((long) bArr[i8]) << 56);
                                                if (j6 >= 0) {
                                                    j2 = 71499008037633920L;
                                                } else {
                                                    int i10 = i + 10;
                                                    long j8 = (((long) bArr[i4]) << 63) ^ j6;
                                                    if (j8 >= 0) {
                                                        j = j8 ^ (-9151873028817141888L);
                                                        i4 = i10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j4 = j3 ^ j7;
                                }
                                j = j2 ^ j6;
                            }
                            i4 = i8;
                            j = j4;
                        }
                    }
                    this.pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        public final long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                int i2 = this.pos;
                if (i2 == this.limit) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.pos = i2 + 1;
                byte b = this.buffer[i2];
                j |= ((long) (b & 127)) << i;
                if ((b & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32Expected5BytesMax());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final String readString() throws InvalidProtocolBufferException {
            int rawVarint32Expected5BytesMax = readRawVarint32Expected5BytesMax();
            if (rawVarint32Expected5BytesMax > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (rawVarint32Expected5BytesMax <= i - i2) {
                    String str = new String(this.buffer, i2, rawVarint32Expected5BytesMax, StandardCharsets.UTF_8);
                    this.pos += rawVarint32Expected5BytesMax;
                    return str;
                }
            }
            if (rawVarint32Expected5BytesMax == 0) {
                return "";
            }
            if (rawVarint32Expected5BytesMax < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32Expected5BytesMax = readRawVarint32Expected5BytesMax();
            String strDecodeUtf8 = "";
            if (rawVarint32Expected5BytesMax > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (rawVarint32Expected5BytesMax <= i - i2) {
                    if (rawVarint32Expected5BytesMax == 0) {
                        Utf8.MobileProcessor mobileProcessor = Utf8.processor;
                    } else {
                        strDecodeUtf8 = Utf8.processor.decodeUtf8(this.buffer, i2, rawVarint32Expected5BytesMax);
                    }
                    this.pos += rawVarint32Expected5BytesMax;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32Expected5BytesMax == 0) {
                return "";
            }
            if (rawVarint32Expected5BytesMax <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32Expected5BytesMax = readRawVarint32Expected5BytesMax();
            this.lastTag = rawVarint32Expected5BytesMax;
            if ((rawVarint32Expected5BytesMax >>> 3) != 0) {
                return rawVarint32Expected5BytesMax;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readUInt32() {
            return readRawVarint32Expected5BytesMax();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readUInt64() {
            return readRawVarint64();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StreamDecoder extends CodedInputStream {
        public final byte[] buffer;
        public int bufferSize;
        public int bufferSizeAfterLimit;
        public int currentLimit = Integer.MAX_VALUE;
        public final InputStream input;
        public int lastTag;
        public int pos;
        public int totalBytesRetired;

        public StreamDecoder(InputStream inputStream) {
            byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
            if (inputStream == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("input");
                throw null;
            }
            this.input = inputStream;
            this.buffer = new byte[4096];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        public static boolean isBeyondLimit(int i, int i2, int i3) {
            return i3 < i || i2 > i3 - i;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final boolean isAtEnd() {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.protobuf.CodedInputStream
        public final void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired + this.pos;
            if (i > Integer.MAX_VALUE - i2) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            if (isBeyondLimit(i2, i, this.currentLimit)) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i3 = this.currentLimit;
            this.currentLimit = i2 + i;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final ByteString.LiteralByteString readBytes() throws IOException {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            int i3 = i - i2;
            byte[] bArr = this.buffer;
            if (rawVarint32 <= i3 && rawVarint32 > 0) {
                ByteString.LiteralByteString literalByteStringCopyFrom$1 = ByteString.copyFrom$1(bArr, i2, rawVarint32);
                this.pos += rawVarint32;
                return literalByteStringCopyFrom$1;
            }
            if (rawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(rawVarint32);
            if (rawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom$1(rawBytesSlowPathOneChunk, 0, rawBytesSlowPathOneChunk.length);
            }
            int i4 = this.pos;
            int i5 = this.bufferSize;
            int length = i5 - i4;
            this.totalBytesRetired += i5;
            this.pos = 0;
            this.bufferSize = 0;
            ArrayList rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(rawVarint32 - length);
            byte[] bArr2 = new byte[rawVarint32];
            System.arraycopy(bArr, i4, bArr2, 0, length);
            int size = rawBytesSlowPathRemainingChunks.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = rawBytesSlowPathRemainingChunks.get(i6);
                i6++;
                byte[] bArr3 = (byte[]) obj;
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            try {
                ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
                return rawVarint32 == 0 ? ByteString.EMPTY : new ByteString.LiteralByteString(bArr2);
            } catch (InvalidProtocolBufferException e) {
                throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public final double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readInt64() {
            return readRawVarint64();
        }

        public final byte[] readRawBytesSlowPath(int i) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (rawBytesSlowPathOneChunk != null) {
                return rawBytesSlowPathOneChunk;
            }
            int i2 = this.pos;
            int i3 = this.bufferSize;
            int length = i3 - i2;
            this.totalBytesRetired += i3;
            this.pos = 0;
            this.bufferSize = 0;
            ArrayList rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i2, bArr, 0, length);
            int size = rawBytesSlowPathRemainingChunks.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = rawBytesSlowPathRemainingChunks.get(i4);
                i4++;
                byte[] bArr2 = (byte[]) obj;
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] readRawBytesSlowPathOneChunk(int i) throws IOException {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired + this.pos;
            if (isBeyondLimit(i2, i, Integer.MAX_VALUE)) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            if (isBeyondLimit(i2, i, this.currentLimit)) {
                int i3 = this.currentLimit;
                if (i3 >= i2) {
                    skipRawBytes(i3 - i2);
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i4 = this.bufferSize - this.pos;
            int i5 = i - i4;
            InputStream inputStream = this.input;
            if (i5 >= 4096) {
                try {
                    if (i5 > inputStream.available()) {
                        return null;
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.wasThrownFromInputStream = true;
                    throw e;
                }
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i4 < i) {
                try {
                    int i6 = inputStream.read(bArr, i4, i - i4);
                    if (i6 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += i6;
                    i4 += i6;
                } catch (InvalidProtocolBufferException e2) {
                    e2.wasThrownFromInputStream = true;
                    throw e2;
                }
            }
            return bArr;
        }

        public final ArrayList readRawBytesSlowPathRemainingChunks(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int iMin = Math.min(i, 4096);
                byte[] bArr = new byte[iMin];
                int i2 = 0;
                while (i2 < iMin) {
                    try {
                        int i3 = this.input.read(bArr, i2, iMin - i2);
                        if (i3 == -1) {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        this.totalBytesRetired += i3;
                        i2 += i3;
                    } catch (InvalidProtocolBufferException e) {
                        e.wasThrownFromInputStream = true;
                        throw e;
                    }
                }
                i -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.bufferSize - i < 4) {
                refillBuffer(4);
                i = this.pos;
            }
            this.pos = i + 4;
            byte[] bArr = this.buffer;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public final long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.bufferSize - i < 8) {
                refillBuffer(8);
                i = this.pos;
            }
            this.pos = i + 8;
            byte[] bArr = this.buffer;
            return ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
        }

        public final int readRawVarint32() {
            int i;
            int i2 = this.pos;
            int i3 = this.bufferSize;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.buffer;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public final long readRawVarint64() {
            long j;
            long j2;
            long j3;
            long j4;
            int i = this.pos;
            int i2 = this.bufferSize;
            if (i2 != i) {
                int i3 = i + 1;
                byte[] bArr = this.buffer;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                j4 = (-2080896) ^ i9;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (((long) bArr[i8]) << 28);
                                if (j6 >= 0) {
                                    j2 = 266354560;
                                } else {
                                    i8 = i + 6;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (((long) bArr[i8]) << 42);
                                        if (j6 >= 0) {
                                            j2 = 4363953127296L;
                                        } else {
                                            i8 = i + 8;
                                            j7 = j6 ^ (((long) bArr[i4]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                j6 = j7 ^ (((long) bArr[i8]) << 56);
                                                if (j6 >= 0) {
                                                    j2 = 71499008037633920L;
                                                } else {
                                                    int i10 = i + 10;
                                                    long j8 = (((long) bArr[i4]) << 63) ^ j6;
                                                    if (j8 >= 0) {
                                                        j = j8 ^ (-9151873028817141888L);
                                                        i4 = i10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j4 = j3 ^ j7;
                                }
                                j = j2 ^ j6;
                            }
                            i4 = i8;
                            j = j4;
                        }
                    }
                    this.pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        public final long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                if (this.pos == this.bufferSize) {
                    refillBuffer(1);
                }
                int i2 = this.pos;
                this.pos = i2 + 1;
                byte b = this.buffer[i2];
                j |= ((long) (b & 127)) << i;
                if ((b & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public final String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            byte[] bArr = this.buffer;
            if (rawVarint32 > 0) {
                int i = this.bufferSize;
                int i2 = this.pos;
                if (rawVarint32 <= i - i2) {
                    String str = new String(bArr, i2, rawVarint32, StandardCharsets.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (rawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(rawVarint32), StandardCharsets.UTF_8);
            }
            refillBuffer(rawVarint32);
            String str2 = new String(bArr, this.pos, rawVarint32, StandardCharsets.UTF_8);
            this.pos += rawVarint32;
            return str2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public final String readStringRequireUtf8() throws IOException {
            int rawVarint32 = readRawVarint32();
            int i = this.pos;
            int i2 = this.bufferSize;
            int i3 = i2 - i;
            byte[] rawBytesSlowPath = this.buffer;
            if (rawVarint32 <= i3 && rawVarint32 > 0) {
                this.pos = i + rawVarint32;
            } else {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i = 0;
                if (rawVarint32 <= i2) {
                    refillBuffer(rawVarint32);
                    this.pos = rawVarint32;
                } else {
                    rawBytesSlowPath = readRawBytesSlowPath(rawVarint32);
                }
            }
            if (rawVarint32 != 0) {
                return Utf8.processor.decodeUtf8(rawBytesSlowPath, i, rawVarint32);
            }
            Utf8.MobileProcessor mobileProcessor = Utf8.processor;
            return "";
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if ((rawVarint32 >>> 3) != 0) {
                return rawVarint32;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public final long readUInt64() {
            return readRawVarint64();
        }

        public final void recomputeBufferSizeAfterLimit() {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i2 = this.totalBytesRetired + i;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i4 = i2 - i3;
            this.bufferSizeAfterLimit = i4;
            this.bufferSize = i - i4;
        }

        public final void refillBuffer(int i) throws InvalidProtocolBufferException {
            if (tryRefillBuffer(i)) {
                return;
            }
            if (i <= (Integer.MAX_VALUE - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }

        public final void skipRawBytes(int i) throws InvalidProtocolBufferException {
            int i2 = this.bufferSize;
            int i3 = this.pos;
            if (i <= i2 - i3 && i >= 0) {
                this.pos = i3 + i;
                return;
            }
            InputStream inputStream = this.input;
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i4 = this.totalBytesRetired + i3;
            if (isBeyondLimit(i4, i, Integer.MAX_VALUE)) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
            if (isBeyondLimit(i4, i, this.currentLimit)) {
                int i5 = this.currentLimit;
                if (i5 >= i4) {
                    skipRawBytes(i5 - i4);
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i6 = this.totalBytesRetired;
            int i7 = this.pos;
            this.totalBytesRetired = i6 + i7;
            int i8 = this.bufferSize - i7;
            this.bufferSize = 0;
            this.pos = 0;
            while (i8 < i) {
                long j = i - i8;
                try {
                    try {
                        long jSkip = inputStream.skip(j);
                        if (jSkip < 0 || jSkip > j) {
                            throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i8 += (int) jSkip;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        e.wasThrownFromInputStream = true;
                        throw e;
                    }
                } catch (Throwable th) {
                    this.totalBytesRetired += i8;
                    recomputeBufferSizeAfterLimit();
                    throw th;
                }
            }
            this.totalBytesRetired += i8;
            recomputeBufferSizeAfterLimit();
            if (i8 >= i) {
                return;
            }
            int i9 = this.bufferSize;
            int i10 = i9 - this.pos;
            this.pos = i9;
            refillBuffer(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.bufferSize;
                if (i11 <= i12) {
                    this.pos = i11;
                    return;
                } else {
                    i10 += i12;
                    this.pos = i12;
                    refillBuffer(1);
                }
            }
        }

        public final boolean tryRefillBuffer(int i) throws IOException {
            InputStream inputStream = this.input;
            int i2 = this.pos;
            if (i2 + i <= this.bufferSize) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "refillBuffer() called when ", " bytes were already available in buffer"));
                return false;
            }
            int i3 = this.totalBytesRetired + i2;
            if (!isBeyondLimit(i3, i, Integer.MAX_VALUE) && !isBeyondLimit(i3, i, this.currentLimit)) {
                int i4 = this.pos;
                byte[] bArr = this.buffer;
                if (i4 > 0) {
                    int i5 = this.bufferSize;
                    if (i5 > i4) {
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.totalBytesRetired += i4;
                    this.bufferSize -= i4;
                    this.pos = 0;
                }
                int i6 = this.bufferSize;
                try {
                    int i7 = inputStream.read(bArr, i6, Math.min(bArr.length - i6, (Integer.MAX_VALUE - this.totalBytesRetired) - i6));
                    if (i7 == 0 || i7 < -1 || i7 > bArr.length) {
                        throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i7 + "\nThe InputStream implementation is buggy.");
                    }
                    if (i7 > 0) {
                        this.bufferSize += i7;
                        recomputeBufferSizeAfterLimit();
                        if (this.bufferSize >= i || tryRefillBuffer(i)) {
                            return true;
                        }
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.wasThrownFromInputStream = true;
                    throw e;
                }
            }
            return false;
        }
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return inputStream == null ? newInstance(Internal.EMPTY_BYTE_ARRAY, 0, 0, false) : new StreamDecoder(inputStream);
    }

    public static int readRawVarint32(InputStream inputStream, int i) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i);

    public final void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.messageDepth + this.groupDepth >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i);

    public abstract boolean readBool();

    public abstract ByteString.LiteralByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    public static ArrayDecoderOldVarint newInstance(byte[] bArr, int i, int i2, boolean z) {
        ArrayDecoderOldVarint arrayDecoderOldVarint = new ArrayDecoderOldVarint(bArr, i, i2, z);
        try {
            arrayDecoderOldVarint.pushLimit(i2);
            return arrayDecoderOldVarint;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
