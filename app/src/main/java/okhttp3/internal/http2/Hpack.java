package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Hpack {
    public static final Map NAME_TO_FIRST_INDEX;
    public static final Header[] STATIC_HEADER_TABLE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Reader {
        public int dynamicTableByteCount;
        public int headerCount;
        public long headerListByteCount;
        public final RealBufferedSource source;
        public int maxDynamicTableByteCount = 4096;
        public final ArrayList headerList = new ArrayList();
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Reader(Http2Reader.ContinuationSource continuationSource) {
            this.source = new RealBufferedSource(continuationSource);
        }

        public final void addHeader(Header header) throws IOException {
            this.headerList.add(header);
            long size$okio = this.headerListByteCount + ((long) (header.value.getSize$okio() + header.name.getSize$okio()));
            this.headerListByteCount = size$okio;
            if (size$okio <= 262144) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("header byte count limit of 262144 exceeded");
        }

        public final int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    header.getClass();
                    int i4 = header.hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        public final ByteString getName(int i) throws IOException {
            if (i >= 0) {
                Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                if (i <= headerArr.length - 1) {
                    return headerArr[i].name;
                }
            }
            int length = this.nextHeaderIndex + 1 + (i - Hpack.STATIC_HEADER_TABLE.length);
            if (length >= 0) {
                Header[] headerArr2 = this.dynamicTable;
                if (length < headerArr2.length) {
                    Header header = headerArr2[length];
                    header.getClass();
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final void insertIntoDynamicTable(Header header) throws IOException {
            addHeader(header);
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Header[] headerArr = this.dynamicTable;
                ArraysKt.fill(0, headerArr.length, null, headerArr);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
                headerArr2 = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            headerArr2[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final ByteString readByteString() throws IOException {
            RealBufferedSource realBufferedSource = this.source;
            byte b = realBufferedSource.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            int i = b & 255;
            int i2 = 0;
            boolean z = (b & 128) == 128;
            long j = readInt(i, 127);
            if (this.headerListByteCount + j > 262144) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("header byte count limit of 262144 exceeded");
                return null;
            }
            if (!z) {
                return realBufferedSource.readByteString(j);
            }
            Buffer buffer = new Buffer();
            Huffman.Node node = Huffman.root;
            Huffman.Node node2 = node;
            int i3 = 0;
            for (long j2 = 0; j2 < j; j2++) {
                byte b2 = realBufferedSource.readByte();
                byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                i2 = (i2 << 8) | (b2 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    Huffman.Node[] nodeArr = (Huffman.Node[]) node2.children;
                    nodeArr.getClass();
                    node2 = nodeArr[(i2 >>> (i3 - 8)) & 255];
                    node2.getClass();
                    if (((Huffman.Node[]) node2.children) == null) {
                        buffer.m1913writeByte(node2.symbol);
                        i3 -= node2.terminalBitCount;
                        node2 = node;
                    } else {
                        i3 -= 8;
                    }
                }
            }
            while (i3 > 0) {
                Huffman.Node[] nodeArr2 = (Huffman.Node[]) node2.children;
                nodeArr2.getClass();
                Huffman.Node node3 = nodeArr2[(i2 << (8 - i3)) & 255];
                node3.getClass();
                int i4 = node3.terminalBitCount;
                if (((Huffman.Node[]) node3.children) != null || i4 > i3) {
                    break;
                }
                buffer.m1913writeByte(node3.symbol);
                i3 -= i4;
                node2 = node;
            }
            return buffer.readByteString(buffer.size);
        }

        public final int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            long j = i2;
            int i4 = 0;
            int i5 = 0;
            while (i4 != 5) {
                byte b = this.source.readByte();
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                i4++;
                long j2 = ((long) (b & 127)) << i5;
                if (j2 > 2147483647L - j) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("HPACK integer overflow");
                    return 0;
                }
                j += j2;
                if ((b & 128) == 0) {
                    return (int) j;
                }
                i5 += 7;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("HPACK integer overflow");
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Writer {
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public final Buffer out;
        public int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        public int maxDynamicTableByteCount = 4096;
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Writer(Buffer buffer) {
            this.out = buffer;
        }

        public final void evictToRecoverBytes(int i) {
            int i2;
            if (i > 0) {
                int length = this.dynamicTable.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    header.getClass();
                    i -= header.hpackSize;
                    int i4 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    header2.getClass();
                    this.dynamicTableByteCount = i4 - header2.hpackSize;
                    this.headerCount--;
                    i3++;
                    length--;
                }
                Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i6 = this.nextHeaderIndex + 1;
                Arrays.fill(headerArr2, i6, i6 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
        }

        public final void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Header[] headerArr = this.dynamicTable;
                ArraysKt.fill(0, headerArr.length, null, headerArr);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
                headerArr2 = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            headerArr2[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void writeByteString(ByteString byteString) throws EOFException {
            byteString.getClass();
            int[] iArr = Huffman.CODES;
            int size$okio = byteString.getSize$okio();
            long j = 0;
            long j2 = 0;
            for (int i = 0; i < size$okio; i++) {
                byte bInternalGet$okio = byteString.internalGet$okio(i);
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                j2 += (long) Huffman.CODE_BIT_COUNTS[bInternalGet$okio & 255];
            }
            int i2 = (int) ((j2 + 7) >> 3);
            int size$okio2 = byteString.getSize$okio();
            Buffer buffer = this.out;
            if (i2 >= size$okio2) {
                writeInt(byteString.getSize$okio(), 127, 0);
                buffer.write(byteString);
                return;
            }
            Buffer buffer2 = new Buffer();
            int[] iArr2 = Huffman.CODES;
            int size$okio3 = byteString.getSize$okio();
            int i3 = 0;
            for (int i4 = 0; i4 < size$okio3; i4++) {
                byte bInternalGet$okio2 = byteString.internalGet$okio(i4);
                byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                int i5 = bInternalGet$okio2 & 255;
                int i6 = Huffman.CODES[i5];
                byte b = Huffman.CODE_BIT_COUNTS[i5];
                j = (j << b) | ((long) i6);
                i3 += b;
                while (i3 >= 8) {
                    i3 -= 8;
                    buffer2.m1913writeByte((int) (j >> i3));
                }
            }
            if (i3 > 0) {
                buffer2.m1913writeByte((int) ((j << (8 - i3)) | (255 >>> i3)));
            }
            ByteString byteString2 = buffer2.readByteString(buffer2.size);
            writeInt(byteString2.getSize$okio(), 127, 128);
            buffer.write(byteString2);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0069  */
        public final void writeHeaders(ArrayList arrayList) throws EOFException {
            int length;
            int length2;
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    writeInt(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header header = (Header) arrayList.get(i2);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Intrinsics.areEqual(headerArr[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (Intrinsics.areEqual(headerArr[length2].value, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        } else {
                            length = length2;
                            length2 = -1;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        Header header2 = this.dynamicTable[i3];
                        header2.getClass();
                        if (Intrinsics.areEqual(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i3];
                            header3.getClass();
                            if (Intrinsics.areEqual(header3.value, byteString)) {
                                length2 = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.m1913writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    ByteString byteString2 = Header.PSEUDO_PREFIX;
                    asciiLowercase.getClass();
                    byteString2.getClass();
                    if (!asciiLowercase.rangeEquals(0, byteString2, byteString2.getSize$okio()) || Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase)) {
                        writeInt(length, 63, 64);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(length, 15, 0);
                        writeByteString(byteString);
                    }
                }
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            Buffer buffer = this.out;
            if (i < i2) {
                buffer.m1913writeByte(i | i3);
                return;
            }
            buffer.m1913writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                buffer.m1913writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            buffer.m1913writeByte(i4);
        }
    }

    static {
        Header header = new Header("", Header.TARGET_AUTHORITY);
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header("GET", byteString);
        Header header3 = new Header("POST", byteString);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header("/", byteString2);
        Header header5 = new Header("/index.html", byteString2);
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header("http", byteString3);
        Header header7 = new Header("https", byteString3);
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header("200", byteString4), new Header("204", byteString4), new Header("206", byteString4), new Header("304", byteString4), new Header("400", byteString4), new Header("404", byteString4), new Header("500", byteString4), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        STATIC_HEADER_TABLE = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61, 1.0f);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        NAME_TO_FIRST_INDEX = mapUnmodifiableMap;
    }

    public static void checkLowercase(ByteString byteString) throws IOException {
        byteString.getClass();
        int size$okio = byteString.getSize$okio();
        for (int i = 0; i < size$okio; i++) {
            byte bInternalGet$okio = byteString.internalGet$okio(i);
            if (65 <= bInternalGet$okio && bInternalGet$okio < 91) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("PROTOCOL_ERROR response malformed: mixed case name: ".concat(byteString.utf8()));
                return;
            }
        }
    }
}
