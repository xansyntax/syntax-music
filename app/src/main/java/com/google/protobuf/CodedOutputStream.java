package com.google.protobuf;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import kotlin.io.FileSystemException;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodedOutputStream {
    public ConnectionPool wrapper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ArrayEncoder extends CodedOutputStream {
        public final byte[] buffer;
        public final int limit;
        public int position;

        public ArrayEncoder(byte[] bArr, int i) {
            if (((bArr.length - i) | i) < 0) {
                Locale locale = Locale.US;
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(bArr.length, i, "Array range is invalid. Buffer.length=", ", offset=0, length="));
                throw null;
            }
            this.buffer = bArr;
            this.position = 0;
            this.limit = i;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void write(byte b) throws FileSystemException {
            int i = this.position;
            try {
                int i2 = i + 1;
                try {
                    this.buffer[i] = b;
                    this.position = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i2;
                    throw new FileSystemException(i, this.limit, 1, e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z) throws FileSystemException {
            writeTag(i, 0);
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws FileSystemException {
            writeTag(i, 2);
            writeUInt32NoTag(byteString.size());
            byteString.writeTo$1(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i2) throws FileSystemException {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws FileSystemException {
            int i2 = this.position;
            try {
                byte[] bArr = this.buffer;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = (byte) (i >> 24);
                this.position = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new FileSystemException(i2, this.limit, 4, e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j) throws FileSystemException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws FileSystemException {
            int i = this.position;
            try {
                byte[] bArr = this.buffer;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                bArr[i + 7] = (byte) (j >> 56);
                this.position = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new FileSystemException(i, this.limit, 8, e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i2) throws FileSystemException {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws FileSystemException {
            if (i >= 0) {
                writeUInt32NoTag(i);
                return;
            }
            long j = i;
            int i2 = this.position;
            try {
                byte[] bArr = this.buffer;
                int i3 = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j) | 128);
                    int i4 = i2 + 2;
                    try {
                        bArr[i3] = (byte) (((int) (j >>> 7)) | 128);
                        int i5 = i2 + 3;
                        bArr[i4] = (byte) (((int) (j >>> 14)) | 128);
                        i4 = i2 + 4;
                        bArr[i5] = (byte) (((int) (j >>> 21)) | 128);
                        int i6 = i2 + 5;
                        bArr[i4] = (byte) (((int) (j >>> 28)) | 128);
                        int i7 = i2 + 6;
                        try {
                            bArr[i6] = -1;
                            int i8 = i2 + 7;
                            bArr[i7] = -1;
                            i7 = i2 + 8;
                            bArr[i8] = -1;
                            i3 = i2 + 9;
                            bArr[i7] = -1;
                            i2 += 10;
                            bArr[i3] = 1;
                            this.position = i2;
                        } catch (IndexOutOfBoundsException e) {
                            int i9 = i7;
                            e = e;
                            i2 = i9;
                            throw new FileSystemException(i2, this.limit, 10, e);
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                        i2 = i4;
                    }
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i2 = i3;
                }
            } catch (IndexOutOfBoundsException e4) {
                e = e4;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeLazy(byte[] bArr, int i, int i2) throws FileSystemException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new FileSystemException(this.position, this.limit, i2, e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws FileSystemException {
            writeTag(i, 2);
            int i2 = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                byte[] bArr = this.buffer;
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    Utf8.MobileProcessor mobileProcessor = Utf8.processor;
                    writeUInt32NoTag(mobileProcessor.encodedLength(str));
                    int i3 = this.position;
                    this.position = mobileProcessor.encodeUtf8(str, bArr, i3, bArr.length - i3);
                    return;
                }
                int i4 = i2 + iComputeUInt32SizeNoTag2;
                this.position = i4;
                int iEncodeUtf8 = Utf8.processor.encodeUtf8(str, bArr, i4, bArr.length - i4);
                this.position = i2;
                writeUInt32NoTag((iEncodeUtf8 - i2) - iComputeUInt32SizeNoTag2);
                this.position = iEncodeUtf8;
            } catch (IndexOutOfBoundsException e) {
                throw new FileSystemException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i, int i2) throws FileSystemException {
            writeUInt32NoTag((i << 3) | i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i2) throws FileSystemException {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws FileSystemException {
            int i2 = this.position;
            int i3 = i & (-128);
            byte[] bArr = this.buffer;
            try {
                if (i3 == 0) {
                    int i4 = i2 + 1;
                    bArr[i2] = (byte) i;
                    this.position = i4;
                    return;
                }
                int i5 = i2 + 1;
                bArr[i2] = (byte) (i | 128);
                int i6 = i >>> 7;
                try {
                    if ((i6 & (-128)) == 0) {
                        int i7 = i2 + 2;
                        bArr[i5] = (byte) i6;
                        this.position = i7;
                        return;
                    }
                    int i8 = i2 + 2;
                    try {
                        bArr[i5] = (byte) (i6 | 128);
                        int i9 = i >>> 14;
                        if ((i9 & (-128)) == 0) {
                            int i10 = i2 + 3;
                            bArr[i8] = (byte) i9;
                            this.position = i10;
                            return;
                        }
                        int i11 = i2 + 3;
                        try {
                            bArr[i8] = (byte) (i9 | 128);
                            int i12 = i >>> 21;
                            if ((i12 & (-128)) == 0) {
                                int i13 = i2 + 4;
                                bArr[i11] = (byte) i12;
                                this.position = i13;
                                return;
                            } else {
                                i8 = i2 + 4;
                                bArr[i11] = (byte) (i12 | 128);
                                int i14 = i2 + 5;
                                bArr[i8] = (byte) (i >>> 28);
                                this.position = i14;
                                return;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            e = e;
                            i3 = i11;
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                        i3 = i8;
                    }
                    throw new FileSystemException(i3, this.limit, 1, e);
                } catch (IndexOutOfBoundsException e3) {
                    i3 = i;
                    e = e3;
                }
            } catch (IndexOutOfBoundsException e4) {
                e = e4;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j) throws FileSystemException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws FileSystemException {
            int i = this.position;
            long j2 = j & (-128);
            byte[] bArr = this.buffer;
            try {
                if (j2 == 0) {
                    bArr[i] = (byte) j;
                    this.position = i + 1;
                    return;
                }
                bArr[i] = (byte) (((int) j) | 128);
                long j3 = j >>> 7;
                if ((j3 & (-128)) == 0) {
                    bArr[i + 1] = (byte) j3;
                    this.position = i + 2;
                    return;
                }
                bArr[i + 1] = (byte) (((int) j3) | 128);
                long j4 = j >>> 14;
                if ((j4 & (-128)) == 0) {
                    bArr[i + 2] = (byte) j4;
                    this.position = i + 3;
                    return;
                }
                bArr[i + 2] = (byte) (((int) j4) | 128);
                long j5 = j >>> 21;
                if ((j5 & (-128)) == 0) {
                    bArr[i + 3] = (byte) j5;
                    this.position = i + 4;
                    return;
                }
                bArr[i + 3] = (byte) (((int) j5) | 128);
                long j6 = j >>> 28;
                if ((j6 & (-128)) == 0) {
                    bArr[i + 4] = (byte) j6;
                    this.position = i + 5;
                    return;
                }
                bArr[i + 4] = (byte) (((int) j6) | 128);
                long j7 = j >>> 35;
                if ((j7 & (-128)) == 0) {
                    bArr[i + 5] = (byte) j7;
                    this.position = i + 6;
                    return;
                }
                bArr[i + 5] = (byte) (((int) j7) | 128);
                long j8 = j >>> 42;
                if ((j8 & (-128)) == 0) {
                    bArr[i + 6] = (byte) j8;
                    this.position = i + 7;
                    return;
                }
                bArr[i + 6] = (byte) (((int) j8) | 128);
                long j9 = j >>> 49;
                if ((j9 & (-128)) == 0) {
                    bArr[i + 7] = (byte) j9;
                    this.position = i + 8;
                    return;
                }
                bArr[i + 7] = (byte) (((int) j9) | 128);
                long j10 = j >>> 56;
                if (((-128) & j10) == 0) {
                    bArr[i + 8] = (byte) j10;
                    this.position = i + 9;
                } else {
                    bArr[i + 8] = (byte) (((int) j10) | 128);
                    bArr[i + 9] = (byte) (j >>> 63);
                    this.position = i + 10;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new FileSystemException(i, this.limit, 1, e);
            }
        }
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        int iComputeTagSize = computeTagSize(i);
        int size = byteString.size();
        return computeUInt32SizeNoTag(size) + size + iComputeTagSize;
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag((i >> 31) ^ (i << 1));
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag((j >> 63) ^ (j << 1));
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(i << 3);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int computeUInt64SizeNoTag(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() > 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Did not write as much data as expected.");
        } else {
            if (spaceLeft() >= 0) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Wrote more data than expected.");
        }
    }

    public int spaceLeft() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    public abstract void write(byte b);

    public abstract void writeBool(int i, boolean z);

    public abstract void writeBytes(int i, ByteString byteString);

    public abstract void writeFixed32(int i, int i2);

    public abstract void writeFixed32NoTag(int i);

    public abstract void writeFixed64(int i, long j);

    public abstract void writeFixed64NoTag(long j);

    public abstract void writeInt32(int i, int i2);

    public abstract void writeInt32NoTag(int i);

    public abstract void writeLazy(byte[] bArr, int i, int i2);

    public abstract void writeString(int i, String str);

    public abstract void writeTag(int i, int i2);

    public abstract void writeUInt32(int i, int i2);

    public abstract void writeUInt32NoTag(int i);

    public abstract void writeUInt64(int i, long j);

    public abstract void writeUInt64NoTag(long j);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OutputStreamEncoder extends CodedOutputStream {
        public final byte[] buffer;
        public final int limit;
        public final OutputStream out;
        public int position;

        public OutputStreamEncoder(OutputStream outputStream, int i) {
            if (outputStream == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("out");
                throw null;
            }
            this.out = outputStream;
            if (i < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("bufferSize must be >= 0");
                throw null;
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        public final void bufferFixed32NoTag(int i) {
            int i2 = this.position;
            byte[] bArr = this.buffer;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.position = i2 + 4;
        }

        public final void bufferFixed64NoTag(long j) {
            int i = this.position;
            byte[] bArr = this.buffer;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.position = i + 8;
        }

        public final void bufferTag(int i, int i2) {
            bufferUInt32NoTag((i << 3) | i2);
        }

        public final void bufferUInt32NoTag(int i) {
            int i2 = this.position;
            int i3 = i & (-128);
            byte[] bArr = this.buffer;
            if (i3 == 0) {
                bArr[i2] = (byte) i;
                this.position = i2 + 1;
                return;
            }
            bArr[i2] = (byte) (i | 128);
            int i4 = i >>> 7;
            if ((i4 & (-128)) == 0) {
                bArr[i2 + 1] = (byte) i4;
                this.position = i2 + 2;
                return;
            }
            bArr[i2 + 1] = (byte) (i4 | 128);
            int i5 = i >>> 14;
            if ((i5 & (-128)) == 0) {
                bArr[i2 + 2] = (byte) i5;
                this.position = i2 + 3;
                return;
            }
            bArr[i2 + 2] = (byte) (i5 | 128);
            int i6 = i >>> 21;
            if ((i6 & (-128)) == 0) {
                bArr[i2 + 3] = (byte) i6;
                this.position = i2 + 4;
            } else {
                bArr[i2 + 3] = (byte) (i6 | 128);
                bArr[i2 + 4] = (byte) (i >>> 28);
                this.position = i2 + 5;
            }
        }

        public final void bufferUInt64NoTag(long j) {
            int i = this.position;
            long j2 = j & (-128);
            byte[] bArr = this.buffer;
            if (j2 == 0) {
                bArr[i] = (byte) j;
                this.position = i + 1;
                return;
            }
            bArr[i] = (byte) (((int) j) | 128);
            long j3 = j >>> 7;
            if ((j3 & (-128)) == 0) {
                bArr[i + 1] = (byte) j3;
                this.position = i + 2;
                return;
            }
            bArr[i + 1] = (byte) (((int) j3) | 128);
            long j4 = j >>> 14;
            if ((j4 & (-128)) == 0) {
                bArr[i + 2] = (byte) j4;
                this.position = i + 3;
                return;
            }
            bArr[i + 2] = (byte) (((int) j4) | 128);
            long j5 = j >>> 21;
            if ((j5 & (-128)) == 0) {
                bArr[i + 3] = (byte) j5;
                this.position = i + 4;
                return;
            }
            bArr[i + 3] = (byte) (((int) j5) | 128);
            long j6 = j >>> 28;
            if ((j6 & (-128)) == 0) {
                bArr[i + 4] = (byte) j6;
                this.position = i + 5;
                return;
            }
            bArr[i + 4] = (byte) (((int) j6) | 128);
            long j7 = j >>> 35;
            if ((j7 & (-128)) == 0) {
                bArr[i + 5] = (byte) j7;
                this.position = i + 6;
                return;
            }
            bArr[i + 5] = (byte) (((int) j7) | 128);
            long j8 = j >>> 42;
            if ((j8 & (-128)) == 0) {
                bArr[i + 6] = (byte) j8;
                this.position = i + 7;
                return;
            }
            bArr[i + 6] = (byte) (((int) j8) | 128);
            long j9 = j >>> 49;
            if ((j9 & (-128)) == 0) {
                bArr[i + 7] = (byte) j9;
                this.position = i + 8;
                return;
            }
            bArr[i + 7] = (byte) (((int) j9) | 128);
            long j10 = j >>> 56;
            if (((-128) & j10) == 0) {
                bArr[i + 8] = (byte) j10;
                this.position = i + 9;
            } else {
                bArr[i + 8] = (byte) (((int) j10) | 128);
                bArr[i + 9] = (byte) (j >>> 63);
                this.position = i + 10;
            }
        }

        public final void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        public final void flushIfNotAvailable(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.position;
            int i4 = this.limit;
            int i5 = i4 - i3;
            byte[] bArr2 = this.buffer;
            if (i5 >= i2) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.position += i2;
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.position = i4;
            doFlush();
            if (i7 > i4) {
                this.out.write(bArr, i6, i7);
            } else {
                System.arraycopy(bArr, i6, bArr2, 0, i7);
                this.position = i7;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            byte b = z ? (byte) 1 : (byte) 0;
            int i2 = this.position;
            this.buffer[i2] = b;
            this.position = i2 + 1;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteString.size());
            byteString.writeTo$1(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i2) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            if (i2 >= 0) {
                bufferUInt32NoTag(i2);
            } else {
                bufferUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeLazy(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i2 = iComputeUInt32SizeNoTag + length;
            int i3 = this.limit;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int iEncodeUtf8 = Utf8.processor.encodeUtf8(str, bArr, 0, length);
                writeUInt32NoTag(iEncodeUtf8);
                write(bArr, 0, iEncodeUtf8);
                return;
            }
            if (i2 > i3 - this.position) {
                doFlush();
            }
            int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
            int i4 = this.position;
            byte[] bArr2 = this.buffer;
            try {
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    Utf8.MobileProcessor mobileProcessor = Utf8.processor;
                    int iEncodedLength = mobileProcessor.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = mobileProcessor.encodeUtf8(str, bArr2, this.position, iEncodedLength);
                    return;
                }
                int i5 = i4 + iComputeUInt32SizeNoTag2;
                this.position = i5;
                int iEncodeUtf9 = Utf8.processor.encodeUtf8(str, bArr2, i5, i3 - i5);
                this.position = i4;
                bufferUInt32NoTag((iEncodeUtf9 - i4) - iComputeUInt32SizeNoTag2);
                this.position = iEncodeUtf9;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new FileSystemException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i, int i2) throws IOException {
            writeUInt32NoTag((i << 3) | i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void write(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            int i = this.position;
            this.buffer[i] = b;
            this.position = i + 1;
        }
    }
}
