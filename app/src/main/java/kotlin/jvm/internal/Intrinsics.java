package kotlin.jvm.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Intrinsics {
    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static void sanitizeStackTrace(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static void throwUndefinedForReified() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(IntIntPair$$ExternalSyntheticOutline0.m("lateinit property ", str, " has not been initialized"));
        sanitizeStackTrace(uninitializedPropertyAccessException, Intrinsics.class.getName());
        throw uninitializedPropertyAccessException;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public abstract class Kotlin {
        public static final Object[] EMPTY = new Object[0];

        public static final void appendClass(StringBuilder sb, Class cls) {
            while (cls.isArray()) {
                sb.append("[");
                cls = cls.getComponentType();
                cls.getClass();
            }
            if (cls.equals(Void.TYPE)) {
                sb.append("V");
                return;
            }
            if (cls.equals(Integer.TYPE)) {
                sb.append("I");
                return;
            }
            if (cls.equals(Long.TYPE)) {
                sb.append("J");
                return;
            }
            if (cls.equals(Short.TYPE)) {
                sb.append("S");
                return;
            }
            if (cls.equals(Byte.TYPE)) {
                sb.append("B");
                return;
            }
            if (cls.equals(Boolean.TYPE)) {
                sb.append("Z");
                return;
            }
            if (cls.equals(Character.TYPE)) {
                sb.append("C");
                return;
            }
            if (cls.equals(Float.TYPE)) {
                sb.append("F");
                return;
            }
            if (cls.equals(Double.TYPE)) {
                sb.append("D");
                return;
            }
            sb.append("L");
            String strReplace = cls.getName().replace('.', '/');
            strReplace.getClass();
            sb.append((CharSequence) strReplace);
            sb.append(";");
        }

        public static final Object[] toArray(Collection collection, Object[] objArr) {
            Object[] objArrCopyOf;
            collection.getClass();
            objArr.getClass();
            int size = collection.size();
            int i = 0;
            if (size != 0) {
                Iterator it = collection.iterator();
                if (it.hasNext()) {
                    if (size <= objArr.length) {
                        objArrCopyOf = objArr;
                    } else {
                        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                        objNewInstance.getClass();
                        objArrCopyOf = (Object[]) objNewInstance;
                    }
                    while (true) {
                        int i2 = i + 1;
                        objArrCopyOf[i] = it.next();
                        if (i2 >= objArrCopyOf.length) {
                            if (!it.hasNext()) {
                                return objArrCopyOf;
                            }
                            int i3 = ((i2 * 3) + 1) >>> 1;
                            if (i3 <= i2) {
                                i3 = 2147483645;
                                if (i2 >= 2147483645) {
                                    throw new OutOfMemoryError();
                                }
                            }
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                        } else if (!it.hasNext()) {
                            if (objArrCopyOf != objArr) {
                                return Arrays.copyOf(objArrCopyOf, i2);
                            }
                            objArr[i2] = null;
                            return objArr;
                        }
                        i = i2;
                    }
                } else if (objArr.length > 0) {
                    objArr[0] = null;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }

        public static final Object[] toArray(Collection collection) {
            collection.getClass();
            int size = collection.size();
            Object[] objArr = EMPTY;
            if (size == 0) {
                return objArr;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                return objArr;
            }
            Object[] objArrCopyOf = new Object[size];
            int i = 0;
            while (true) {
                int i2 = i + 1;
                objArrCopyOf[i] = it.next();
                if (i2 >= objArrCopyOf.length) {
                    if (!it.hasNext()) {
                        return objArrCopyOf;
                    }
                    int i3 = ((i2 * 3) + 1) >>> 1;
                    if (i3 <= i2) {
                        i3 = 2147483645;
                        if (i2 >= 2147483645) {
                            throw new OutOfMemoryError();
                        }
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                } else if (!it.hasNext()) {
                    return Arrays.copyOf(objArrCopyOf, i2);
                }
                i = i2;
            }
        }
    }
}
