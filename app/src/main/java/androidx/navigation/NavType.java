package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavType {
    public static final IntArrayNavType BoolArrayType;
    public static final IntNavType BoolType;
    public static final IntArrayNavType FloatArrayType;
    public static final IntNavType FloatType;
    public static final IntArrayNavType IntArrayType;
    public static final IntNavType IntType;
    public static final IntArrayNavType LongArrayType;
    public static final IntNavType LongType;
    public static final IntArrayNavType StringArrayType;
    public static final IntNavType StringType;
    public final boolean isNullableAllowed;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EnumType extends SerializableType {
        public final Class type;

        public EnumType(Class cls) {
            super(cls, 0);
            if (cls.isEnum()) {
                this.type = cls;
            } else {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " is not an Enum type.");
                throw null;
            }
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public final String getName() {
            return this.type.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        /* JADX INFO: renamed from: parseValue */
        public final Enum mo842parseValue(String str) {
            Object obj;
            Class cls = this.type;
            Object[] enumConstants = cls.getEnumConstants();
            enumConstants.getClass();
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i];
                if (StringsKt__StringsJVMKt.equals(((Enum) obj).name(), str, true)) {
                    break;
                }
                i++;
            }
            Enum r3 = (Enum) obj;
            if (r3 != null) {
                return r3;
            }
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Enum value ", str, " not found for type ");
            sbM4m.append(cls.getName());
            sbM4m.append('.');
            throw new IllegalArgumentException(sbM4m.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ParcelableArrayType extends NavType {
        public final Class arrayType;

        public ParcelableArrayType(Class cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " does not implement Parcelable.");
                throw null;
            }
            try {
                this.arrayType = Class.forName("[L" + cls.getName() + ';');
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !ParcelableArrayType.class.equals(obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.arrayType, ((ParcelableArrayType) obj).arrayType);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.arrayType.getName();
        }

        public final int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            str.getClass();
            this.arrayType.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        @Override // androidx.navigation.NavType
        public final boolean valueEquals(Object obj, Object obj2) {
            return ArraysKt.contentDeepEquals((Parcelable[]) obj, (Parcelable[]) obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ParcelableType extends NavType {
        public final Class type;

        public ParcelableType(Class cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
            } else {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " does not implement Parcelable or Serializable.");
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !ParcelableType.class.equals(obj.getClass())) {
                return false;
            }
            return this.type.equals(((ParcelableType) obj).type);
        }

        @Override // androidx.navigation.NavType
        public final Object get(String str, Bundle bundle) {
            bundle.getClass();
            return bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.type.getName();
        }

        public final int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: parseValue */
        public final Object mo842parseValue(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            str.getClass();
            this.type.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SerializableArrayType extends NavType {
        public final Class arrayType;

        public SerializableArrayType(Class cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " does not implement Serializable.");
                throw null;
            }
            try {
                this.arrayType = Class.forName("[L" + cls.getName() + ';');
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !SerializableArrayType.class.equals(obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.arrayType, ((SerializableArrayType) obj).arrayType);
        }

        @Override // androidx.navigation.NavType
        public final Object get(String str, Bundle bundle) {
            bundle.getClass();
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.arrayType.getName();
        }

        public final int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: parseValue */
        public final Object mo842parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Serializable, java.io.Serializable[], java.lang.Object] */
        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            ?? r3 = (Serializable[]) obj;
            str.getClass();
            this.arrayType.cast(r3);
            bundle.putSerializable(str, r3);
        }

        @Override // androidx.navigation.NavType
        public final boolean valueEquals(Object obj, Object obj2) {
            return ArraysKt.contentDeepEquals((Serializable[]) obj, (Serializable[]) obj2);
        }
    }

    static {
        byte b = 0;
        boolean z = false;
        IntType = new IntNavType(b, z);
        boolean z2 = true;
        IntArrayType = new IntArrayNavType(b, z2);
        byte b2 = 3;
        LongType = new IntNavType(b2, z);
        LongArrayType = new IntArrayNavType(b2, z2);
        byte b3 = 2;
        FloatType = new IntNavType(b3, z);
        FloatArrayType = new IntArrayNavType(b3, z2);
        byte b4 = 1;
        BoolType = new IntNavType(b4, z);
        BoolArrayType = new IntArrayNavType(b4, z2);
        byte b5 = 4;
        StringType = new IntNavType(b5, z2);
        StringArrayType = new IntArrayNavType(b5, z2);
    }

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    public Object get(String str, Bundle bundle) {
        bundle.getClass();
        return (Parcelable[]) bundle.get(str);
    }

    public abstract String getName();

    /* JADX INFO: renamed from: parseValue */
    public Object mo842parseValue(String str) {
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    public abstract void put(Bundle bundle, String str, Object obj);

    public final String toString() {
        return getName();
    }

    public boolean valueEquals(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public Object parseValue(Object obj, String str) {
        return mo842parseValue(str);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class SerializableType extends NavType {
        public final Class type;

        public SerializableType(Class cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " does not implement Serializable.");
                throw null;
            }
            if (cls.isEnum()) {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " is an Enum. You should use EnumType instead.");
                throw null;
            }
            this.type = cls;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return this.type.equals(((SerializableType) obj).type);
        }

        @Override // androidx.navigation.NavType
        public final Object get(String str, Bundle bundle) {
            bundle.getClass();
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public final int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: parseValue */
        public Serializable mo842parseValue(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            str.getClass();
            serializable.getClass();
            this.type.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        public SerializableType(Class cls, int i) {
            super(false);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
            } else {
                PathKt$$ExternalSyntheticBUOutline0.m((Object) cls, (Object) " does not implement Serializable.");
                throw null;
            }
        }
    }
}
