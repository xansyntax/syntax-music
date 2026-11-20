package okhttp3.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.HttpHeaders;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.cache.DiskLruCache$fileSystem$1;
import okio.Buffer;
import okio.ByteString;
import okio.FileSystem;
import okio.Options;
import okio.Path;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Options UNICODE_BOMS;

    static {
        ByteString byteString = ByteString.EMPTY;
        ByteString[] byteStringArr = {Path.Companion.decodeHex("efbbbf"), Path.Companion.decodeHex("feff"), Path.Companion.decodeHex("fffe0000"), Path.Companion.decodeHex("fffe"), Path.Companion.decodeHex("0000feff")};
        ArrayList arrayList = new ArrayList(new ArrayAsCollection(byteStringArr, false));
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(-1);
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5) {
            arrayList2.set(CollectionsKt__IterablesKt.binarySearch$default(arrayList, byteStringArr[i2]), Integer.valueOf(i3));
            i2++;
            i3++;
        }
        if (((ByteString) arrayList.get(0)).getSize$okio() <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("the empty byte string is not a supported option");
            return;
        }
        int i4 = 0;
        while (i4 < arrayList.size()) {
            ByteString byteString2 = (ByteString) arrayList.get(i4);
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList.size()) {
                ByteString byteString3 = (ByteString) arrayList.get(i6);
                byteString3.getClass();
                byteString2.getClass();
                if (!byteString3.rangeEquals(0, byteString2, byteString2.getSize$okio())) {
                    break;
                }
                if (byteString3.getSize$okio() == byteString2.getSize$okio()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$4(byteString3, "duplicate option: ");
                    return;
                } else if (((Number) arrayList2.get(i6)).intValue() > ((Number) arrayList2.get(i4)).intValue()) {
                    arrayList.remove(i6);
                    ((Number) arrayList2.remove(i6)).intValue();
                } else {
                    i6++;
                }
            }
            i4 = i5;
        }
        Buffer buffer = new Buffer();
        CollectionsKt__IterablesKt.buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int i7 = (int) (buffer.size / 4);
        int[] iArr = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            iArr[i8] = buffer.readInt();
        }
        UNICODE_BOMS = new Options((ByteString[]) Arrays.copyOf(byteStringArr, 5), iArr);
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "length=", ", offset=");
            sbM.append(j2);
            sbM.append(", count=");
            sbM.append(j2);
            throw new ArrayIndexOutOfBoundsException(sbM.toString());
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        closeable.getClass();
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void deleteContents(FileSystem fileSystem, Path path) throws IOException {
        fileSystem.getClass();
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).isDirectory) {
                        deleteContents(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteIfExists(DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1, Path path) {
        diskLruCache$fileSystem$1.getClass();
        path.getClass();
        try {
            diskLruCache$fileSystem$1.delegate.delete(path);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final int delimiterOffset(int i, int i2, String str, String str2) {
        while (i < i2) {
            if (StringsKt.contains$default(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, i, i2, c);
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(int i, int i2, String str) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int indexOfLastNonAsciiWhitespace(int i, int i2, String str) {
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        strArr2.getClass();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isSensitiveHeader(String str) {
        str.getClass();
        return str.equalsIgnoreCase(HttpHeaders.Authorization) || str.equalsIgnoreCase(HttpHeaders.Cookie) || str.equalsIgnoreCase(HttpHeaders.ProxyAuthorization) || str.equalsIgnoreCase(HttpHeaders.SetCookie);
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    public static final int readMedium(RealBufferedSource realBufferedSource) {
        return (realBufferedSource.readByte() & 255) | ((realBufferedSource.readByte() & 255) << 16) | ((realBufferedSource.readByte() & 255) << 8);
    }

    public static final int toNonNegativeInt(int i, String str) {
        if (str == null) {
            return i;
        }
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static final int delimiterOffset(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }
}
