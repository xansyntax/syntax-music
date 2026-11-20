package io.ktor.util.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "value", "Lkotlin/reflect/KClass;", "klass", "", "platformDefaultFromValues", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "convertSimpleTypes", "", "platformDefaultToValues", "(Ljava/lang/Object;)Ljava/util/List;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConversionServiceJvmKt {
    private static final Object convertSimpleTypes(String str, KClass<?> kClass) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.class))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.class))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.class))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.class))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Byte.class))) {
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return str;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.class))) {
            return Character.valueOf(str.charAt(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigDecimal.class))) {
            return new BigDecimal(str);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigInteger.class))) {
            return new BigInteger(str);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(UUID.class))) {
            return UUID.fromString(str);
        }
        return null;
    }

    public static final Object platformDefaultFromValues(String str, KClass<?> kClass) throws DataConversionException {
        str.getClass();
        kClass.getClass();
        Object objConvertSimpleTypes = convertSimpleTypes(str, kClass);
        if (objConvertSimpleTypes != null) {
            return objConvertSimpleTypes;
        }
        Object obj = null;
        if (!Okio__OkioKt.getJavaClass(kClass).isEnum()) {
            return null;
        }
        Object[] enumConstants = Okio__OkioKt.getJavaClass(kClass).getEnumConstants();
        if (enumConstants != null) {
            for (Object obj2 : enumConstants) {
                obj2.getClass();
                if (Intrinsics.areEqual(((Enum) obj2).name(), str)) {
                    obj = obj2;
                    break;
                }
            }
            if (obj != null) {
                return obj;
            }
        }
        throw new DataConversionException("Value " + str + " is not a enum member name of " + kClass);
    }

    public static final List<String> platformDefaultToValues(Object obj) {
        obj.getClass();
        if (obj instanceof Enum) {
            return CollectionsKt__IterablesKt.listOf(((Enum) obj).name());
        }
        if (obj instanceof Integer) {
            return CollectionsKt__IterablesKt.listOf(((Integer) obj).toString());
        }
        if (obj instanceof Float) {
            return CollectionsKt__IterablesKt.listOf(((Float) obj).toString());
        }
        if (obj instanceof Double) {
            return CollectionsKt__IterablesKt.listOf(((Double) obj).toString());
        }
        if (obj instanceof Long) {
            return CollectionsKt__IterablesKt.listOf(((Long) obj).toString());
        }
        if (obj instanceof Boolean) {
            return CollectionsKt__IterablesKt.listOf(((Boolean) obj).toString());
        }
        if (obj instanceof Byte) {
            return CollectionsKt__IterablesKt.listOf(((Byte) obj).toString());
        }
        if (obj instanceof Short) {
            return CollectionsKt__IterablesKt.listOf(((Short) obj).toString());
        }
        if (obj instanceof String) {
            return CollectionsKt__IterablesKt.listOf(((String) obj).toString());
        }
        if (obj instanceof Character) {
            return CollectionsKt__IterablesKt.listOf(((Character) obj).toString());
        }
        if (obj instanceof BigDecimal) {
            return CollectionsKt__IterablesKt.listOf(((BigDecimal) obj).toString());
        }
        if (obj instanceof BigInteger) {
            return CollectionsKt__IterablesKt.listOf(((BigInteger) obj).toString());
        }
        if (obj instanceof UUID) {
            return CollectionsKt__IterablesKt.listOf(((UUID) obj).toString());
        }
        return null;
    }
}
