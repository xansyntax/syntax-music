package okio.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: renamed from: okio.internal.-Path, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Path {
    public static final ByteString ANY_SLASH;
    public static final ByteString BACKSLASH;
    public static final ByteString DOT;
    public static final ByteString DOT_DOT;
    public static final ByteString SLASH;

    static {
        ByteString byteString = ByteString.EMPTY;
        SLASH = okio.Path.Companion.encodeUtf8("/");
        BACKSLASH = okio.Path.Companion.encodeUtf8("\\");
        ANY_SLASH = okio.Path.Companion.encodeUtf8("/\\");
        DOT = okio.Path.Companion.encodeUtf8(".");
        DOT_DOT = okio.Path.Companion.encodeUtf8("..");
    }

    public static final okio.Path commonResolve(okio.Path path, okio.Path path2, boolean z) {
        path2.getClass();
        if (rootLength(path2) != -1 || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.bytes);
        if (buffer.size > 0) {
            buffer.write(slash);
        }
        buffer.write(path2.bytes);
        return toPath(buffer, z);
    }

    public static final ByteString getSlash(okio.Path path) {
        ByteString byteString = path.bytes;
        ByteString byteString2 = SLASH;
        if (ByteString.indexOf$default(byteString, byteString2) != -1) {
            return byteString2;
        }
        ByteString byteString3 = path.bytes;
        ByteString byteString4 = BACKSLASH;
        if (ByteString.indexOf$default(byteString3, byteString4) != -1) {
            return byteString4;
        }
        return null;
    }

    public static final int rootLength(okio.Path path) {
        ByteString byteString = path.bytes;
        if (byteString.getSize$okio() != 0) {
            if (byteString.internalGet$okio(0) != 47) {
                if (byteString.internalGet$okio(0) == 92) {
                    if (byteString.getSize$okio() > 2 && byteString.internalGet$okio(1) == 92) {
                        ByteString byteString2 = BACKSLASH;
                        byteString2.getClass();
                        int iIndexOf = byteString.indexOf(byteString2.internalArray$okio(), 2);
                        return iIndexOf == -1 ? byteString.getSize$okio() : iIndexOf;
                    }
                } else if (byteString.getSize$okio() > 2 && byteString.internalGet$okio(1) == 58 && byteString.internalGet$okio(2) == 92) {
                    char cInternalGet$okio = (char) byteString.internalGet$okio(0);
                    if ('a' <= cInternalGet$okio && cInternalGet$okio < '{') {
                        return 3;
                    }
                    if ('A' <= cInternalGet$okio && cInternalGet$okio < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:83:0x0117 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0119  */
    /* JADX WARN: Code duplicated, block: B:88:0x012e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0110 A[EDGE_INSN: B:98:0x0110->B:81:0x0110 BREAK  A[LOOP:1: B:53:0x00ab->B:112:0x00ab], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00fe A[SYNTHETIC] */
    public static final okio.Path toPath(Buffer buffer, boolean z) throws EOFException {
        ByteString byteString;
        long j;
        char c;
        boolean z2;
        ArrayList arrayList;
        boolean zExhausted;
        ByteString byteString2;
        int size;
        int i;
        long jIndexOfElement;
        ByteString byteString3;
        ByteString byteString4;
        Buffer buffer2 = new Buffer();
        ByteString slash = null;
        int i2 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte b = buffer.readByte();
            if (slash == null) {
                slash = toSlash(b);
            }
            i2++;
        }
        boolean z3 = i2 >= 2 && Intrinsics.areEqual(slash, byteString);
        ByteString byteString5 = ANY_SLASH;
        if (z3) {
            slash.getClass();
            buffer2.write(slash);
            buffer2.write(slash);
        } else {
            if (i2 <= 0) {
                long jIndexOfElement2 = buffer.indexOfElement(byteString5);
                if (slash == null) {
                    slash = jIndexOfElement2 == -1 ? toSlash(okio.Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(jIndexOfElement2));
                }
                if (Intrinsics.areEqual(slash, byteString) && buffer.size >= 2) {
                    j = -1;
                    if (buffer.getByte(1L) == 58 && (('a' <= (c = (char) buffer.getByte(0L)) && c < '{') || ('A' <= c && c < '['))) {
                        if (jIndexOfElement2 == 2) {
                            buffer2.write(buffer, 3L);
                        } else {
                            buffer2.write(buffer, 2L);
                        }
                    }
                }
                if (buffer2.size > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                arrayList = new ArrayList();
                while (true) {
                    zExhausted = buffer.exhausted();
                    byteString2 = DOT;
                    if (!zExhausted) {
                        break;
                    }
                    jIndexOfElement = buffer.indexOfElement(byteString5);
                    if (jIndexOfElement == j) {
                        byteString3 = buffer.readByteString(buffer.size);
                    } else {
                        byteString3 = buffer.readByteString(jIndexOfElement);
                        buffer.readByte();
                    }
                    byteString4 = DOT_DOT;
                    if (Intrinsics.areEqual(byteString3, byteString4)) {
                        if (z2 || !arrayList.isEmpty()) {
                            if (z || (!z2 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last(arrayList), byteString4)))) {
                                arrayList.add(byteString3);
                            } else if (!z3 || arrayList.size() != 1) {
                                CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                            }
                        }
                    } else if (Intrinsics.areEqual(byteString3, byteString2) && !Intrinsics.areEqual(byteString3, ByteString.EMPTY)) {
                        arrayList.add(byteString3);
                    }
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    if (i > 0) {
                        buffer2.write(slash);
                    }
                    buffer2.write((ByteString) arrayList.get(i));
                }
                if (buffer2.size == 0) {
                    buffer2.write(byteString2);
                }
                return new okio.Path(buffer2.readByteString(buffer2.size));
            }
            slash.getClass();
            buffer2.write(slash);
        }
        j = -1;
        if (buffer2.size > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        arrayList = new ArrayList();
        while (true) {
            zExhausted = buffer.exhausted();
            byteString2 = DOT;
            if (!zExhausted) {
                break;
                break;
            }
            jIndexOfElement = buffer.indexOfElement(byteString5);
            if (jIndexOfElement == j) {
                byteString3 = buffer.readByteString(buffer.size);
            } else {
                byteString3 = buffer.readByteString(jIndexOfElement);
                buffer.readByte();
            }
            byteString4 = DOT_DOT;
            if (Intrinsics.areEqual(byteString3, byteString4)) {
                if (z2) {
                }
                if (z) {
                }
                arrayList.add(byteString3);
            } else if (Intrinsics.areEqual(byteString3, byteString2)) {
            }
        }
        size = arrayList.size();
        while (i < size) {
            if (i > 0) {
                buffer2.write(slash);
            }
            buffer2.write((ByteString) arrayList.get(i));
        }
        if (buffer2.size == 0) {
            buffer2.write(byteString2);
        }
        return new okio.Path(buffer2.readByteString(buffer2.size));
    }

    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("not a directory separator: ", str));
        return null;
    }

    public static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(b, "not a directory separator: "));
        return null;
    }
}
