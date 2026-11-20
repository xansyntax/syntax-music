package okio.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.palette.graphics.ColorCutQuantizer;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.Path;
import okio.RealBufferedSource;
import okio.SegmentedByteString;
import okio.ZipFileSystem;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class _ZlibJvmKt {
    public static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static final LinkedHashMap buildIndex(ArrayList arrayList) {
        String str = Path.DIRECTORY_SEPARATOR;
        Path path = Path.Companion.get("/");
        Pair[] pairArr = {new Pair(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(1));
        MapsKt__MapsKt.putAll(linkedHashMap, pairArr);
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(arrayList, new ColorCutQuantizer.AnonymousClass1((byte) 19))) {
            if (((ZipEntry) linkedHashMap.put(zipEntry.canonicalPath, zipEntry)) == null) {
                while (true) {
                    Path path2 = zipEntry.canonicalPath;
                    Path pathParent = path2.parent();
                    if (pathParent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) linkedHashMap.get(pathParent);
                    if (zipEntry2 != null) {
                        zipEntry2.children.add(path2);
                        break;
                    }
                    ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                    linkedHashMap.put(pathParent, zipEntry3);
                    zipEntry3.children.add(path2);
                    zipEntry = zipEntry3;
                }
            }
        }
        return linkedHashMap;
    }

    public static final int decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final String getHex(int i) {
        CharsKt.checkRadix(16);
        String string = Integer.toString(i, 16);
        string.getClass();
        return "0x".concat(string);
    }

    public static boolean keepPath(Path path) {
        return !StringsKt__StringsJVMKt.endsWith(path.name(), ".class", true);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b6 A[Catch: all -> 0x014a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x014a, blocks: (B:3:0x000d, B:5:0x001b, B:6:0x0023, B:16:0x007a, B:18:0x0084, B:66:0x0149, B:62:0x0142, B:69:0x014e, B:97:0x01a9, B:100:0x01b6, B:95:0x01a4, B:107:0x01c2, B:110:0x01ce, B:111:0x01d5, B:112:0x01d6, B:113:0x01d9, B:114:0x01da, B:115:0x01ef, B:59:0x013d, B:92:0x019f, B:19:0x008d, B:21:0x0096, B:24:0x00a7, B:50:0x012c, B:46:0x0125, B:53:0x0130, B:54:0x0135, B:7:0x002c, B:9:0x0035, B:15:0x005b, B:104:0x01ba, B:105:0x01bf), top: B:131:0x000d, inners: #0, #1, #6, #10 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01a9 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #4 {all -> 0x014a, blocks: (B:3:0x000d, B:5:0x001b, B:6:0x0023, B:16:0x007a, B:18:0x0084, B:66:0x0149, B:62:0x0142, B:69:0x014e, B:97:0x01a9, B:100:0x01b6, B:95:0x01a4, B:107:0x01c2, B:110:0x01ce, B:111:0x01d5, B:112:0x01d6, B:113:0x01d9, B:114:0x01da, B:115:0x01ef, B:59:0x013d, B:92:0x019f, B:19:0x008d, B:21:0x0096, B:24:0x00a7, B:50:0x012c, B:46:0x0125, B:53:0x0130, B:54:0x0135, B:7:0x002c, B:9:0x0035, B:15:0x005b, B:104:0x01ba, B:105:0x01bf), top: B:131:0x000d, inners: #0, #1, #6, #10 }] */
    public static final ZipFileSystem openZip(Path path, FileSystem fileSystem, Function1 function1) {
        RealBufferedSource realBufferedSource;
        Throwable th;
        Throwable th2;
        Throwable th3;
        fileSystem.getClass();
        JvmFileHandle jvmFileHandleOpenReadOnly = fileSystem.openReadOnly(path);
        try {
            long size = jvmFileHandleOpenReadOnly.size();
            long j = size - 22;
            long j2 = 0;
            if (j < 0) {
                throw new IOException("not a zip: size=" + jvmFileHandleOpenReadOnly.size());
            }
            long jMax = Math.max(size - 65558, 0L);
            do {
                RealBufferedSource realBufferedSource2 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j));
                try {
                    if (realBufferedSource2.readIntLe() == 101010256) {
                        int shortLe = realBufferedSource2.readShortLe() & 65535;
                        int shortLe2 = realBufferedSource2.readShortLe() & 65535;
                        long shortLe3 = realBufferedSource2.readShortLe() & 65535;
                        if (shortLe3 != (realBufferedSource2.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
                            throw new IOException("unsupported zip: spanned");
                        }
                        realBufferedSource2.skip(4L);
                        long intLe = ((long) realBufferedSource2.readIntLe()) & 4294967295L;
                        int shortLe4 = realBufferedSource2.readShortLe() & 65535;
                        EocdRecord eocdRecord = new EocdRecord(shortLe4, shortLe3, intLe);
                        realBufferedSource2.readUtf8(shortLe4);
                        realBufferedSource2.close();
                        long j3 = j - 20;
                        if (j3 > 0) {
                            RealBufferedSource realBufferedSource3 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j3));
                            try {
                                if (realBufferedSource3.readIntLe() == 117853008) {
                                    int intLe2 = realBufferedSource3.readIntLe();
                                    long longLe = realBufferedSource3.readLongLe();
                                    if (realBufferedSource3.readIntLe() != 1 || intLe2 != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    RealBufferedSource realBufferedSource4 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(longLe));
                                    try {
                                        int intLe3 = realBufferedSource4.readIntLe();
                                        if (intLe3 != 101075792) {
                                            throw new IOException("bad zip: expected " + getHex(101075792) + " but was " + getHex(intLe3));
                                        }
                                        realBufferedSource4.skip(12L);
                                        int intLe4 = realBufferedSource4.readIntLe();
                                        int intLe5 = realBufferedSource4.readIntLe();
                                        long longLe2 = realBufferedSource4.readLongLe();
                                        if (longLe2 != realBufferedSource4.readLongLe() || intLe4 != 0 || intLe5 != 0) {
                                            throw new IOException("unsupported zip: spanned");
                                        }
                                        realBufferedSource4.skip(8L);
                                        EocdRecord eocdRecord2 = new EocdRecord(shortLe4, longLe2, realBufferedSource4.readLongLe());
                                        try {
                                            realBufferedSource4.close();
                                            th3 = null;
                                        } catch (Throwable th4) {
                                            th3 = th4;
                                        }
                                        eocdRecord = eocdRecord2;
                                        if (th3 != null) {
                                            throw th3;
                                        }
                                    } catch (Throwable th5) {
                                        try {
                                            realBufferedSource4.close();
                                        } catch (Throwable th6) {
                                            ResultKt.addSuppressed(th5, th6);
                                        }
                                        th3 = th5;
                                    }
                                }
                                try {
                                    realBufferedSource3.close();
                                    th2 = null;
                                } catch (Throwable th7) {
                                    th2 = th7;
                                }
                            } catch (Throwable th8) {
                                try {
                                    realBufferedSource3.close();
                                } catch (Throwable th9) {
                                    ResultKt.addSuppressed(th8, th9);
                                }
                                th2 = th8;
                            }
                            if (th2 != null) {
                                throw th2;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        RealBufferedSource realBufferedSource5 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(eocdRecord.centralDirectoryOffset));
                        try {
                            long j4 = eocdRecord.entryCount;
                            while (j2 < j4) {
                                ZipEntry centralDirectoryZipEntry = readCentralDirectoryZipEntry(realBufferedSource5);
                                realBufferedSource = realBufferedSource5;
                                try {
                                    if (centralDirectoryZipEntry.offset >= eocdRecord.centralDirectoryOffset) {
                                        throw new IOException("bad zip: local file header offset >= central directory offset");
                                    }
                                    if (((Boolean) function1.invoke(centralDirectoryZipEntry)).booleanValue()) {
                                        arrayList.add(centralDirectoryZipEntry);
                                    }
                                    j2++;
                                    realBufferedSource5 = realBufferedSource;
                                } catch (Throwable th10) {
                                    th = th10;
                                    th = th;
                                    try {
                                        realBufferedSource.close();
                                    } catch (Throwable th11) {
                                        ResultKt.addSuppressed(th, th11);
                                    }
                                    if (th == null) {
                                        throw th;
                                    }
                                    ZipFileSystem zipFileSystem = new ZipFileSystem(path, fileSystem, buildIndex(arrayList));
                                    try {
                                        jvmFileHandleOpenReadOnly.close();
                                    } catch (Throwable unused) {
                                    }
                                    return zipFileSystem;
                                }
                            }
                            try {
                                realBufferedSource5.close();
                                th = null;
                            } catch (Throwable th12) {
                                th = th12;
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            realBufferedSource = realBufferedSource5;
                        }
                        if (th == null) {
                            throw th;
                        }
                        ZipFileSystem zipFileSystem2 = new ZipFileSystem(path, fileSystem, buildIndex(arrayList));
                        jvmFileHandleOpenReadOnly.close();
                        return zipFileSystem2;
                    }
                    realBufferedSource2.close();
                    j--;
                } catch (Throwable th14) {
                    realBufferedSource2.close();
                    throw th14;
                }
            } while (j >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } catch (Throwable th15) {
            if (jvmFileHandleOpenReadOnly == null) {
                throw th15;
            }
            try {
                jvmFileHandleOpenReadOnly.close();
                throw th15;
            } catch (Throwable th16) {
                ResultKt.addSuppressed(th15, th16);
                throw th15;
            }
        }
    }

    public static final ZipEntry readCentralDirectoryZipEntry(final RealBufferedSource realBufferedSource) throws IOException {
        int intLe = realBufferedSource.readIntLe();
        if (intLe != 33639248) {
            throw new IOException("bad zip: expected " + getHex(33639248) + " but was " + getHex(intLe));
        }
        realBufferedSource.skip(4L);
        short shortLe = realBufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("unsupported zip: general purpose bit flag=".concat(getHex(i)));
            return null;
        }
        int shortLe2 = realBufferedSource.readShortLe() & 65535;
        int shortLe3 = realBufferedSource.readShortLe() & 65535;
        int shortLe4 = realBufferedSource.readShortLe() & 65535;
        long intLe2 = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        int shortLe5 = realBufferedSource.readShortLe() & 65535;
        int shortLe6 = realBufferedSource.readShortLe() & 65535;
        int shortLe7 = realBufferedSource.readShortLe() & 65535;
        realBufferedSource.skip(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        String utf8 = realBufferedSource.readUtf8(shortLe5);
        if (StringsKt.contains$default(utf8, (char) 0)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: filename contains 0x00");
            return null;
        }
        long j = ref$LongRef2.element == 4294967295L ? 8L : 0L;
        if (ref$LongRef.element == 4294967295L) {
            j += 8;
        }
        if (ref$LongRef3.element == 4294967295L) {
            j += 8;
        }
        final long j2 = j;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        readExtra(realBufferedSource, shortLe6, new Function2() { // from class: okio.internal.ZipFilesKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                RealBufferedSource realBufferedSource2 = realBufferedSource;
                if (iIntValue == 1) {
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    if (ref$BooleanRef2.element) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: zip64 extra repeated");
                        return null;
                    }
                    ref$BooleanRef2.element = true;
                    if (jLongValue < j2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: zip64 extra too short");
                        return null;
                    }
                    Ref$LongRef ref$LongRef4 = ref$LongRef2;
                    long longLe = ref$LongRef4.element;
                    if (longLe == 4294967295L) {
                        longLe = realBufferedSource2.readLongLe();
                    }
                    ref$LongRef4.element = longLe;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    ref$LongRef5.element = ref$LongRef5.element == 4294967295L ? realBufferedSource2.readLongLe() : 0L;
                    Ref$LongRef ref$LongRef6 = ref$LongRef3;
                    ref$LongRef6.element = ref$LongRef6.element == 4294967295L ? realBufferedSource2.readLongLe() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: NTFS extra too short");
                        return null;
                    }
                    realBufferedSource2.skip(4L);
                    _ZlibJvmKt.readExtra(realBufferedSource2, (int) (jLongValue - 4), new ZipFilesKt$$ExternalSyntheticLambda0(ref$ObjectRef, realBufferedSource2, ref$ObjectRef2, ref$ObjectRef3));
                }
                return Unit.INSTANCE;
            }
        });
        if (j2 > 0 && !ref$BooleanRef.element) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: zip64 extra required but absent");
            return null;
        }
        String utf9 = realBufferedSource.readUtf8(shortLe7);
        String str = Path.DIRECTORY_SEPARATOR;
        return new ZipEntry(Path.Companion.get("/").resolve(utf8), StringsKt__StringsJVMKt.endsWith(utf8, "/", false), utf9, intLe2, ref$LongRef.element, ref$LongRef2.element, shortLe2, ref$LongRef3.element, shortLe4, shortLe3, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, (Long) ref$ObjectRef3.element, 57344);
    }

    public static final void readExtra(RealBufferedSource realBufferedSource, int i, Function2 function2) throws IOException {
        Buffer buffer = realBufferedSource.bufferField;
        long j = i;
        while (j != 0) {
            if (j < 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: truncated header in extra field");
                return;
            }
            int shortLe = realBufferedSource.readShortLe() & 65535;
            long shortLe2 = ((long) realBufferedSource.readShortLe()) & 65535;
            long j2 = j - 4;
            if (j2 < shortLe2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: truncated value in extra field");
                return;
            }
            realBufferedSource.require(shortLe2);
            long j3 = buffer.size;
            function2.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long j4 = (buffer.size + shortLe2) - j3;
            if (j4 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(shortLe, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j4 > 0) {
                    buffer.skip(j4);
                }
                j = j2 - shortLe2;
            }
        }
    }

    public static final ZipEntry readOrSkipLocalHeader(RealBufferedSource realBufferedSource, ZipEntry zipEntry) throws IOException {
        int intLe = realBufferedSource.readIntLe();
        if (intLe != 67324752) {
            throw new IOException("bad zip: expected " + getHex(67324752) + " but was " + getHex(intLe));
        }
        realBufferedSource.skip(2L);
        short shortLe = realBufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("unsupported zip: general purpose bit flag=".concat(getHex(i)));
            return null;
        }
        realBufferedSource.skip(18L);
        long shortLe2 = ((long) realBufferedSource.readShortLe()) & 65535;
        int shortLe3 = realBufferedSource.readShortLe() & 65535;
        realBufferedSource.skip(shortLe2);
        if (zipEntry == null) {
            realBufferedSource.skip(shortLe3);
            return null;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        readExtra(realBufferedSource, shortLe3, new ZipFilesKt$$ExternalSyntheticLambda0(realBufferedSource, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        return new ZipEntry(zipEntry.canonicalPath, zipEntry.isDirectory, zipEntry.comment, zipEntry.crc, zipEntry.compressedSize, zipEntry.size, zipEntry.compressionMethod, zipEntry.offset, zipEntry.dosLastModifiedAtDate, zipEntry.dosLastModifiedAtTime, zipEntry.ntfsLastModifiedAtFiletime, zipEntry.ntfsLastAccessedAtFiletime, zipEntry.ntfsCreatedAtFiletime, (Integer) ref$ObjectRef.element, (Integer) ref$ObjectRef2.element, (Integer) ref$ObjectRef3.element);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    public static final int segment(SegmentedByteString segmentedByteString, int i) {
        int i2;
        int[] iArr = segmentedByteString.directory;
        int i3 = i + 1;
        int length = segmentedByteString.segments.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            i2 = (i4 + length) >>> 1;
            int i5 = iArr[i2];
            if (i5 < i3) {
                i4 = i2 + 1;
            } else {
                if (i5 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                length = i2 - 1;
            }
        }
        i2 = (-i4) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }
}
