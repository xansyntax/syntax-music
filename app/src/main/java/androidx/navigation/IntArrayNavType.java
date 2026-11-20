package androidx.navigation;

import android.os.Bundle;
import coil3.util.FileSystemsKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntArrayNavType extends NavType {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntArrayNavType(byte b, boolean z) {
        super(z);
        this.$r8$classId = b;
    }

    @Override // androidx.navigation.NavType
    public final Object get(String str, Bundle bundle) {
        switch (this.$r8$classId) {
            case 0:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                int[] intArray = bundle.getIntArray(str);
                if (intArray != null) {
                    return intArray;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            case 1:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                boolean[] booleanArray = bundle.getBooleanArray(str);
                if (booleanArray != null) {
                    return booleanArray;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            case 2:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                float[] floatArray = bundle.getFloatArray(str);
                if (floatArray != null) {
                    return floatArray;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            case 3:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                long[] longArray = bundle.getLongArray(str);
                if (longArray != null) {
                    return longArray;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            default:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                String[] stringArray = bundle.getStringArray(str);
                if (stringArray != null) {
                    return stringArray;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
        }
    }

    @Override // androidx.navigation.NavType
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "integer[]";
            case 1:
                return "boolean[]";
            case 2:
                return "float[]";
            case 3:
                return "long[]";
            default:
                return "string[]";
        }
    }

    @Override // androidx.navigation.NavType
    public final Object parseValue(Object obj, String str) {
        switch (this.$r8$classId) {
            case 0:
                int[] iArr = (int[]) obj;
                if (iArr == null) {
                    return parseValue(str);
                }
                int[] value = parseValue(str);
                int length = iArr.length;
                int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
                System.arraycopy(value, 0, iArrCopyOf, length, 1);
                return iArrCopyOf;
            case 1:
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null) {
                    return m841parseValue(str);
                }
                boolean[] zArrM841parseValue = m841parseValue(str);
                int length2 = zArr.length;
                boolean[] zArrCopyOf = Arrays.copyOf(zArr, length2 + 1);
                System.arraycopy(zArrM841parseValue, 0, zArrCopyOf, length2, 1);
                return zArrCopyOf;
            case 2:
                float[] fArr = (float[]) obj;
                if (fArr == null) {
                    return new float[]{Float.parseFloat(str)};
                }
                float[] fArr2 = {Float.parseFloat(str)};
                int length3 = fArr.length;
                float[] fArrCopyOf = Arrays.copyOf(fArr, length3 + 1);
                System.arraycopy(fArr2, 0, fArrCopyOf, length3, 1);
                return fArrCopyOf;
            case 3:
                long[] jArr = (long[]) obj;
                if (jArr == null) {
                    return m840parseValue(str);
                }
                long[] jArrM840parseValue = m840parseValue(str);
                int length4 = jArr.length;
                long[] jArrCopyOf = Arrays.copyOf(jArr, length4 + 1);
                System.arraycopy(jArrM840parseValue, 0, jArrCopyOf, length4, 1);
                return jArrCopyOf;
            default:
                String[] strArr = (String[]) obj;
                if (strArr == null) {
                    return new String[]{str};
                }
                String[] strArr2 = {str};
                int length5 = strArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(strArr, length5 + 1);
                System.arraycopy(strArr2, 0, objArrCopyOf, length5, 1);
                return (String[]) objArrCopyOf;
        }
    }

    @Override // androidx.navigation.NavType
    public final void put(Bundle bundle, String str, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int[] iArr = (int[]) obj;
                str.getClass();
                if (iArr == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putIntArray(str, iArr);
                }
                break;
            case 1:
                boolean[] zArr = (boolean[]) obj;
                str.getClass();
                if (zArr == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putBooleanArray(str, zArr);
                }
                break;
            case 2:
                float[] fArr = (float[]) obj;
                str.getClass();
                if (fArr == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putFloatArray(str, fArr);
                }
                break;
            case 3:
                long[] jArr = (long[]) obj;
                str.getClass();
                if (jArr == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putLongArray(str, jArr);
                }
                break;
            default:
                String[] strArr = (String[]) obj;
                str.getClass();
                if (strArr == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putStringArray(str, strArr);
                }
                break;
        }
    }

    @Override // androidx.navigation.NavType
    public final boolean valueEquals(Object obj, Object obj2) {
        Integer[] numArr;
        Boolean[] boolArr;
        Float[] fArr;
        Long[] lArr;
        Object[] objArr = null;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                int[] iArr = (int[]) obj;
                int[] iArr2 = (int[]) obj2;
                if (iArr != null) {
                    numArr = new Integer[iArr.length];
                    int length = iArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        numArr[i2] = Integer.valueOf(iArr[i2]);
                    }
                } else {
                    numArr = null;
                }
                if (iArr2 != null) {
                    objArr = new Integer[iArr2.length];
                    int length2 = iArr2.length;
                    while (i < length2) {
                        objArr[i] = Integer.valueOf(iArr2[i]);
                        i++;
                    }
                }
                return ArraysKt.contentDeepEquals(numArr, objArr);
            case 1:
                boolean[] zArr = (boolean[]) obj;
                boolean[] zArr2 = (boolean[]) obj2;
                if (zArr != null) {
                    boolArr = new Boolean[zArr.length];
                    int length3 = zArr.length;
                    for (int i3 = 0; i3 < length3; i3++) {
                        boolArr[i3] = Boolean.valueOf(zArr[i3]);
                    }
                } else {
                    boolArr = null;
                }
                if (zArr2 != null) {
                    objArr = new Boolean[zArr2.length];
                    int length4 = zArr2.length;
                    while (i < length4) {
                        objArr[i] = Boolean.valueOf(zArr2[i]);
                        i++;
                    }
                }
                return ArraysKt.contentDeepEquals(boolArr, objArr);
            case 2:
                float[] fArr2 = (float[]) obj;
                float[] fArr3 = (float[]) obj2;
                if (fArr2 != null) {
                    fArr = new Float[fArr2.length];
                    int length5 = fArr2.length;
                    for (int i4 = 0; i4 < length5; i4++) {
                        fArr[i4] = Float.valueOf(fArr2[i4]);
                    }
                } else {
                    fArr = null;
                }
                if (fArr3 != null) {
                    objArr = new Float[fArr3.length];
                    int length6 = fArr3.length;
                    while (i < length6) {
                        objArr[i] = Float.valueOf(fArr3[i]);
                        i++;
                    }
                }
                return ArraysKt.contentDeepEquals(fArr, objArr);
            case 3:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                if (jArr != null) {
                    lArr = new Long[jArr.length];
                    int length7 = jArr.length;
                    for (int i5 = 0; i5 < length7; i5++) {
                        lArr[i5] = Long.valueOf(jArr[i5]);
                    }
                } else {
                    lArr = null;
                }
                if (jArr2 != null) {
                    objArr = new Long[jArr2.length];
                    int length8 = jArr2.length;
                    while (i < length8) {
                        objArr[i] = Long.valueOf(jArr2[i]);
                        i++;
                    }
                }
                return ArraysKt.contentDeepEquals(lArr, objArr);
            default:
                return ArraysKt.contentDeepEquals((String[]) obj, (String[]) obj2);
        }
    }

    /* JADX INFO: renamed from: parseValue, reason: collision with other method in class */
    public static long[] m840parseValue(String str) {
        return new long[]{((Number) NavType.LongType.mo842parseValue(str)).longValue()};
    }

    /* JADX INFO: renamed from: parseValue, reason: collision with other method in class */
    public static boolean[] m841parseValue(String str) {
        return new boolean[]{((Boolean) NavType.BoolType.mo842parseValue(str)).booleanValue()};
    }

    public static int[] parseValue(String str) {
        return new int[]{((Number) NavType.IntType.mo842parseValue(str)).intValue()};
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: parseValue, reason: collision with other method in class */
    public final Object mo842parseValue(String str) {
        switch (this.$r8$classId) {
            case 0:
                return parseValue(str);
            case 1:
                return m841parseValue(str);
            case 2:
                return new float[]{Float.parseFloat(str)};
            case 3:
                return m840parseValue(str);
            default:
                return new String[]{str};
        }
    }
}
