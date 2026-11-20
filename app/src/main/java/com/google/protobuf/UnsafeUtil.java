package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UnsafeUtil {
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
    public static final boolean IS_BIG_ENDIAN;
    public static final MemoryAccessor MEMORY_ACCESSOR;
    public static final Class MEMORY_CLASS;
    public static final Unsafe UNSAFE;

    /* JADX INFO: renamed from: com.google.protobuf.UnsafeUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        public final Object run() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JvmMemoryAccessor extends MemoryAccessor {
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ JvmMemoryAccessor(Unsafe unsafe, byte b) {
            super(unsafe, (byte) 0);
            this.$r8$classId = b;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean getBoolean(long j, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return this.unsafe.getBoolean(obj, j);
                case 1:
                    if (UnsafeUtil.IS_BIG_ENDIAN) {
                        return UnsafeUtil.getBooleanBigEndian(j, obj);
                    }
                    return ((byte) ((UnsafeUtil.getInt((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
                default:
                    if (UnsafeUtil.IS_BIG_ENDIAN) {
                        return UnsafeUtil.getBooleanBigEndian(j, obj);
                    }
                    return ((byte) ((UnsafeUtil.getInt((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final double getDouble(long j, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return this.unsafe.getDouble(obj, j);
                case 1:
                    return Double.longBitsToDouble(this.unsafe.getLong(obj, j));
                default:
                    return Double.longBitsToDouble(this.unsafe.getLong(obj, j));
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final float getFloat(long j, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return this.unsafe.getFloat(obj, j);
                case 1:
                    return Float.intBitsToFloat(this.unsafe.getInt(obj, j));
                default:
                    return Float.intBitsToFloat(this.unsafe.getInt(obj, j));
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final void putBoolean(Object obj, long j, boolean z) {
            switch (this.$r8$classId) {
                case 0:
                    this.unsafe.putBoolean(obj, j, z);
                    break;
                case 1:
                    if (!UnsafeUtil.IS_BIG_ENDIAN) {
                        UnsafeUtil.putBooleanLittleEndian(obj, j, z);
                    } else {
                        UnsafeUtil.putBooleanBigEndian(obj, j, z);
                    }
                    break;
                default:
                    if (!UnsafeUtil.IS_BIG_ENDIAN) {
                        UnsafeUtil.putBooleanLittleEndian(obj, j, z);
                    } else {
                        UnsafeUtil.putBooleanBigEndian(obj, j, z);
                    }
                    break;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final void putDouble(Object obj, long j, double d) {
            switch (this.$r8$classId) {
                case 0:
                    this.unsafe.putDouble(obj, j, d);
                    break;
                case 1:
                    this.unsafe.putLong(obj, j, Double.doubleToLongBits(d));
                    break;
                default:
                    this.unsafe.putLong(obj, j, Double.doubleToLongBits(d));
                    break;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final void putFloat(Object obj, long j, float f) {
            switch (this.$r8$classId) {
                case 0:
                    this.unsafe.putFloat(obj, j, f);
                    break;
                case 1:
                    this.unsafe.putInt(obj, j, Float.floatToIntBits(f));
                    break;
                default:
                    this.unsafe.putInt(obj, j, Float.floatToIntBits(f));
                    break;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            switch (this.$r8$classId) {
                case 0:
                    if (!super.supportsUnsafeArrayOperations()) {
                        return false;
                    }
                    try {
                        Class<?> cls = this.unsafe.getClass();
                        Class cls2 = Long.TYPE;
                        cls.getMethod("getByte", Object.class, cls2);
                        cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                        cls.getMethod("getBoolean", Object.class, cls2);
                        cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                        cls.getMethod("getFloat", Object.class, cls2);
                        cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                        cls.getMethod("getDouble", Object.class, cls2);
                        cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                        return true;
                    } catch (Throwable th) {
                        UnsafeUtil.logMissingMethod(th);
                        return false;
                    }
                default:
                    return super.supportsUnsafeArrayOperations();
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean supportsUnsafeByteBufferOperations() {
            switch (this.$r8$classId) {
                case 0:
                    Unsafe unsafe = this.unsafe;
                    if (unsafe == null) {
                        return false;
                    }
                    try {
                        Class<?> cls = unsafe.getClass();
                        cls.getMethod("objectFieldOffset", Field.class);
                        Class cls2 = Long.TYPE;
                        cls.getMethod("getLong", Object.class, cls2);
                        if (UnsafeUtil.bufferAddressField() == null) {
                            return false;
                        }
                        try {
                            Class<?> cls3 = unsafe.getClass();
                            cls3.getMethod("getByte", cls2);
                            cls3.getMethod("putByte", cls2, Byte.TYPE);
                            cls3.getMethod("getInt", cls2);
                            cls3.getMethod("putInt", cls2, Integer.TYPE);
                            cls3.getMethod("getLong", cls2);
                            cls3.getMethod("putLong", cls2, cls2);
                            cls3.getMethod("copyMemory", cls2, cls2, cls2);
                            cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return true;
                        } catch (Throwable th) {
                            UnsafeUtil.logMissingMethod(th);
                            return false;
                        }
                    } catch (Throwable th2) {
                        UnsafeUtil.logMissingMethod(th2);
                        return false;
                    }
                case 1:
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class MemoryAccessor {
        public final /* synthetic */ byte $r8$classId;
        public final Unsafe unsafe;

        public /* synthetic */ MemoryAccessor(Unsafe unsafe, byte b) {
            this.$r8$classId = b;
            this.unsafe = unsafe;
        }

        public abstract boolean getBoolean(long j, Object obj);

        public abstract double getDouble(long j, Object obj);

        public abstract float getFloat(long j, Object obj);

        public abstract void putBoolean(Object obj, long j, boolean z);

        public abstract void putByte(long j, Object obj, byte b);

        public abstract void putDouble(Object obj, long j, double d);

        public abstract void putFloat(Object obj, long j, float f);

        public boolean supportsUnsafeArrayOperations() {
            byte b = this.$r8$classId;
            Class cls = Integer.TYPE;
            Class cls2 = Long.TYPE;
            Unsafe unsafe = this.unsafe;
            switch (b) {
                case 0:
                    if (unsafe != null) {
                        try {
                            Class<?> cls3 = unsafe.getClass();
                            cls3.getMethod("objectFieldOffset", Field.class);
                            cls3.getMethod("arrayBaseOffset", Class.class);
                            cls3.getMethod("arrayIndexScale", Class.class);
                            cls3.getMethod("getInt", Object.class, cls2);
                            cls3.getMethod("putInt", Object.class, cls2, cls);
                            cls3.getMethod("getLong", Object.class, cls2);
                            cls3.getMethod("putLong", Object.class, cls2, cls2);
                            cls3.getMethod("getObject", Object.class, cls2);
                            cls3.getMethod("putObject", Object.class, cls2, Object.class);
                            return true;
                        } catch (Throwable th) {
                            UnsafeUtil.logMissingMethod(th);
                        }
                    }
                    return false;
                default:
                    if (unsafe != null) {
                        try {
                            Class<?> cls4 = unsafe.getClass();
                            cls4.getMethod("objectFieldOffset", Field.class);
                            cls4.getMethod("arrayBaseOffset", Class.class);
                            cls4.getMethod("arrayIndexScale", Class.class);
                            cls4.getMethod("getInt", Object.class, cls2);
                            cls4.getMethod("putInt", Object.class, cls2, cls);
                            cls4.getMethod("getLong", Object.class, cls2);
                            cls4.getMethod("putLong", Object.class, cls2, cls2);
                            cls4.getMethod("getObject", Object.class, cls2);
                            cls4.getMethod("putObject", Object.class, cls2, Object.class);
                            return true;
                        } catch (Throwable th2) {
                            androidx.datastore.preferences.protobuf.UnsafeUtil.logMissingMethod(th2);
                        }
                    }
                    return false;
            }
        }

        public abstract boolean supportsUnsafeByteBufferOperations();
    }

    static {
        Unsafe unsafe = getUnsafe();
        UNSAFE = unsafe;
        MEMORY_CLASS = Android.MEMORY_CLASS;
        boolean zDetermineAndroidSupportByAddressSize = determineAndroidSupportByAddressSize(Long.TYPE);
        boolean zDetermineAndroidSupportByAddressSize2 = determineAndroidSupportByAddressSize(Integer.TYPE);
        char c = 1;
        byte b = 0;
        JvmMemoryAccessor jvmMemoryAccessor = null;
        if (unsafe != null) {
            if (!Android.isOnAndroidDevice()) {
                jvmMemoryAccessor = new JvmMemoryAccessor(unsafe, b);
            } else if (zDetermineAndroidSupportByAddressSize) {
                jvmMemoryAccessor = new JvmMemoryAccessor(unsafe, (byte) 2);
            } else if (zDetermineAndroidSupportByAddressSize2) {
                jvmMemoryAccessor = new JvmMemoryAccessor(unsafe, c == true ? 1 : 0);
            }
        }
        MEMORY_ACCESSOR = jvmMemoryAccessor;
        if (jvmMemoryAccessor != null) {
            jvmMemoryAccessor.supportsUnsafeByteBufferOperations();
        }
        HAS_UNSAFE_ARRAY_OPERATIONS = jvmMemoryAccessor == null ? false : jvmMemoryAccessor.supportsUnsafeArrayOperations();
        arrayBaseOffset(byte[].class);
        arrayBaseOffset(boolean[].class);
        arrayIndexScale(boolean[].class);
        arrayBaseOffset(int[].class);
        arrayIndexScale(int[].class);
        arrayBaseOffset(long[].class);
        arrayIndexScale(long[].class);
        arrayBaseOffset(float[].class);
        arrayIndexScale(float[].class);
        arrayBaseOffset(double[].class);
        arrayIndexScale(double[].class);
        arrayBaseOffset(Object[].class);
        arrayIndexScale(Object[].class);
        Field fieldBufferAddressField = bufferAddressField();
        if (fieldBufferAddressField != null && jvmMemoryAccessor != null) {
            jvmMemoryAccessor.unsafe.objectFieldOffset(fieldBufferAddressField);
        }
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int arrayBaseOffset(Class cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.unsafe.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void arrayIndexScale(Class cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            MEMORY_ACCESSOR.unsafe.arrayIndexScale(cls);
        }
    }

    public static Field bufferAddressField() {
        Field declaredField;
        Field declaredField2;
        if (Android.isOnAndroidDevice()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean determineAndroidSupportByAddressSize(Class cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class cls2 = MEMORY_CLASS;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean getBooleanBigEndian(long j, Object obj) {
        return ((byte) ((getInt((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static int getInt(long j, Object obj) {
        return MEMORY_ACCESSOR.unsafe.getInt(obj, j);
    }

    public static long getLong(long j, Object obj) {
        return MEMORY_ACCESSOR.unsafe.getLong(obj, j);
    }

    public static Object getObject(long j, Object obj) {
        return MEMORY_ACCESSOR.unsafe.getObject(obj, j);
    }

    public static Unsafe getUnsafe() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    public static void logMissingMethod(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void putBooleanBigEndian(Object obj, long j, boolean z) {
        byte b = z ? (byte) 1 : (byte) 0;
        long j2 = (-4) & j;
        int i = getInt(j2, obj);
        int i2 = ((~((int) j)) & 3) << 3;
        putInt(((255 & b) << i2) | (i & (~(255 << i2))), j2, obj);
    }

    public static void putBooleanLittleEndian(Object obj, long j, boolean z) {
        byte b = z ? (byte) 1 : (byte) 0;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        putInt(((255 & b) << i) | (getInt(j2, obj) & (~(255 << i))), j2, obj);
    }

    public static void putInt(int i, long j, Object obj) {
        MEMORY_ACCESSOR.unsafe.putInt(obj, j, i);
    }

    public static void putLong(Object obj, long j, long j2) {
        MEMORY_ACCESSOR.unsafe.putLong(obj, j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        MEMORY_ACCESSOR.unsafe.putObject(obj, j, obj2);
    }
}
