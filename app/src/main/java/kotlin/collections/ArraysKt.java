package kotlin.collections;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArraysKt extends Okio__OkioKt {
    public static List asList(Object[] objArr) {
        objArr.getClass();
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0010 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0012 A[RETURN] */
    public static boolean contains(char[] cArr, char c) {
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            if (c == cArr[i]) {
                if (i >= 0) {
                    return true;
                }
                return false;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contentDeepEquals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr != null && objArr2 != null && objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                Object obj2 = objArr2[i];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!contentDeepEquals((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof UByteArray) && (obj2 instanceof UByteArray)) {
                            if (!Arrays.equals(((UByteArray) obj).storage, ((UByteArray) obj2).storage)) {
                            }
                        } else if ((obj instanceof UShortArray) && (obj2 instanceof UShortArray)) {
                            if (!Arrays.equals(((UShortArray) obj).storage, ((UShortArray) obj2).storage)) {
                            }
                        } else if ((obj instanceof UIntArray) && (obj2 instanceof UIntArray)) {
                            if (!Arrays.equals(((UIntArray) obj).storage, ((UIntArray) obj2).storage)) {
                            }
                        } else if ((obj instanceof ULongArray) && (obj2 instanceof ULongArray)) {
                            if (!Arrays.equals(((ULongArray) obj).storage, ((ULongArray) obj2).storage)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void copyInto(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static /* synthetic */ void copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        copyInto(i, i2, i3, bArr, bArr2);
    }

    public static Object[] copyOfRange(Object[] objArr, int i, int i2) {
        objArr.getClass();
        Okio__OkioKt.copyOfRangeToIndexCheck(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    public static void fill(int i, int i2, Object obj, Object[] objArr) {
        objArr.getClass();
        Arrays.fill(objArr, i, i2, obj);
    }

    public static void fill$default(int i, int[] iArr) {
        int length = iArr.length;
        iArr.getClass();
        Arrays.fill(iArr, 0, length, i);
    }

    public static ArrayList filterNotNull(Object[] objArr) {
        objArr.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static IntRange getIndices(int[] iArr) {
        return new IntRange(0, iArr.length - 1, 1);
    }

    public static int getLastIndex(long[] jArr) {
        jArr.getClass();
        return jArr.length - 1;
    }

    public static Object getOrNull(int i, Object[] objArr) {
        objArr.getClass();
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int indexOf(Object[] objArr, Object obj) {
        objArr.getClass();
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void joinTo(Object[] objArr, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Function1 function1) {
        objArr.getClass();
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            StringsKt__IndentKt.appendElement(sb, obj, function1);
        }
        sb.append(charSequence3);
    }

    public static String joinToString$default(byte[] bArr, String str, Function1 function1, int i) {
        String str2 = (i & 2) != 0 ? "" : "[";
        String str3 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            function1 = null;
        }
        bArr.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) str);
            }
            if (function1 != null) {
                sb.append((CharSequence) function1.invoke(Byte.valueOf(b)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b));
            }
        }
        sb.append((CharSequence) str3);
        return sb.toString();
    }

    public static Float lastOrNull(float[] fArr) {
        fArr.getClass();
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    public static int maxOrThrow(int[] iArr) {
        if (iArr.length == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return 0;
        }
        int i = iArr[0];
        int i2 = 1;
        int length = iArr.length - 1;
        if (1 <= length) {
            while (true) {
                int i3 = iArr[i2];
                if (i < i3) {
                    i = i3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public static char single(char[] cArr) {
        cArr.getClass();
        int length = cArr.length;
        if (length == 0) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
            return (char) 0;
        }
        if (length == 1) {
            return cArr[0];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Array has more than one element.");
        return (char) 0;
    }

    public static List toList(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length == 1) {
            return CollectionsKt__IterablesKt.listOf(objArr[0]);
        }
        List listAsList = Arrays.asList(Arrays.copyOf(objArr, objArr.length));
        listAsList.getClass();
        return listAsList;
    }

    public static Set toSet(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return EmptySet.INSTANCE;
        }
        if (length == 1) {
            return CharsKt.setOf(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static void fill$default(long[] jArr, long j) {
        int length = jArr.length;
        jArr.getClass();
        Arrays.fill(jArr, 0, length, j);
    }

    public static void copyInto(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
    }

    public static void copyInto(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        iArr.getClass();
        iArr2.getClass();
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void copyInto(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        jArr.getClass();
        jArr2.getClass();
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Okio__OkioKt.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        bArrCopyOfRange.getClass();
        return bArrCopyOfRange;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        objArr.getClass();
        return indexOf(objArr, obj) >= 0;
    }

    public static /* synthetic */ void copyInto$default(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        copyInto(0, i, i2, objArr, objArr2);
    }

    public static /* synthetic */ void copyInto$default(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = iArr.length;
        }
        copyInto(i, 0, i2, iArr, iArr2);
    }

    public static void copyInto$default(float[] fArr, float[] fArr2, int i) {
        int length = (i & 8) != 0 ? fArr.length : 6;
        fArr.getClass();
        fArr2.getClass();
        System.arraycopy(fArr, 0, fArr2, 0, length);
    }

    public static String joinToString$default(Object[] objArr, String str, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str2 = str;
        CharSequence charSequence = (i & 2) != 0 ? "" : "innermostOf(";
        String str3 = (i & 4) == 0 ? ")" : "";
        objArr.getClass();
        StringBuilder sb = new StringBuilder();
        joinTo(objArr, sb, str2, charSequence, str3, "...", null);
        return sb.toString();
    }
}
