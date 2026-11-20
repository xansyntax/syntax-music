package io.ktor.util.converters;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.Uuid;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u0004\u0018\u00010\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00072\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0005\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/util/converters/DefaultConversionService;", "Lio/ktor/util/converters/ConversionService;", "<init>", "()V", "", "value", "", "", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "values", "Lio/ktor/util/reflect/TypeInfo;", LinkHeader.Parameters.Type, "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "Lkotlin/reflect/KClass;", "klass", "fromValue", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "convertPrimitives", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Ljava/lang/Comparable;", "typeName", "", "throwConversionException", "(Ljava/lang/String;)Ljava/lang/Void;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultConversionService implements ConversionService {
    public static final DefaultConversionService INSTANCE = new DefaultConversionService();

    private DefaultConversionService() {
    }

    private final Comparable<?> convertPrimitives(KClass<?> klass, String value) {
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return Integer.valueOf(Integer.parseInt(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return Float.valueOf(Float.parseFloat(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return Double.valueOf(Double.parseDouble(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return Long.valueOf(Long.parseLong(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            return Short.valueOf(Short.parseShort(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            return Byte.valueOf(Byte.parseByte(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(UShort.class))) {
            return new UShort(Okio__OkioKt.toUShort(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            value.getClass();
            UInt uIntOrNull = Okio__OkioKt.toUIntOrNull(value);
            if (uIntOrNull != null) {
                return uIntOrNull;
            }
            StringsKt__StringsJVMKt.numberFormatError(value);
            throw null;
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            value.getClass();
            ULong uLongOrNull = Okio__OkioKt.toULongOrNull(value);
            if (uLongOrNull != null) {
                return uLongOrNull;
            }
            StringsKt__StringsJVMKt.numberFormatError(value);
            throw null;
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(UByte.class))) {
            return new UByte(Okio__OkioKt.toUByte(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
            return Character.valueOf(StringsKt.single(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return Boolean.valueOf(Boolean.parseBoolean(value));
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Uuid.class))) {
            return CollectionsKt__IterablesKt.parse(value);
        }
        if (Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(String.class))) {
            return value;
        }
        return null;
    }

    private final Void throwConversionException(String typeName) throws DataConversionException {
        throw new DataConversionException(IntIntPair$$ExternalSyntheticOutline0.m("Type ", typeName, " is not supported in default data conversion service"));
    }

    public final Object fromValue(String value, KClass<?> klass) throws DataConversionException {
        value.getClass();
        klass.getClass();
        Comparable<?> comparableConvertPrimitives = convertPrimitives(klass, value);
        if (comparableConvertPrimitives != null) {
            return comparableConvertPrimitives;
        }
        Object objPlatformDefaultFromValues = ConversionServiceJvmKt.platformDefaultFromValues(value, klass);
        if (objPlatformDefaultFromValues != null) {
            return objPlatformDefaultFromValues;
        }
        throwConversionException(klass.toString());
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> values, TypeInfo type) throws DataConversionException {
        List<KTypeProjection> arguments;
        KTypeProjection kTypeProjection;
        KType type2;
        values.getClass();
        type.getClass();
        if (values.isEmpty()) {
            return null;
        }
        if (Intrinsics.areEqual(type.getType(), Reflection.getOrCreateKotlinClass(List.class)) || Intrinsics.areEqual(type.getType(), Reflection.getOrCreateKotlinClass(List.class))) {
            KType kotlinType = type.getKotlinType();
            KClassifier classifier = (kotlinType == null || (arguments = kotlinType.getArguments()) == null || (kTypeProjection = (KTypeProjection) CollectionsKt.single((List) arguments)) == null || (type2 = kTypeProjection.getType()) == null) ? null : type2.getClassifier();
            KClass<?> kClass = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(values, 10));
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    arrayList.add(INSTANCE.fromValue((String) it.next(), kClass));
                }
                return arrayList;
            }
        }
        if (values.isEmpty()) {
            throw new DataConversionException("There are no values when trying to construct single value " + type);
        }
        if (values.size() <= 1) {
            return fromValue((String) CollectionsKt.single((List) values), type.getType());
        }
        throw new DataConversionException("There are multiple values when trying to construct single value " + type);
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) throws DataConversionException {
        if (value == null) {
            return EmptyList.INSTANCE;
        }
        List<String> listPlatformDefaultToValues = ConversionServiceJvmKt.platformDefaultToValues(value);
        if (listPlatformDefaultToValues != null) {
            return listPlatformDefaultToValues;
        }
        if (value instanceof Iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) value).iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(INSTANCE.toValues(it.next()), arrayList);
            }
            return arrayList;
        }
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(value.getClass());
        if (orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Integer.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Float.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Double.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Long.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Short.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Byte.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Character.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Boolean.TYPE)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(Uuid.class)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(UShort.class)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(UInt.class)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(ULong.class)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(UByte.class)) || orCreateKotlinClass.equals(Reflection.getOrCreateKotlinClass(String.class))) {
            return CollectionsKt__IterablesKt.listOf(value.toString());
        }
        throw new DataConversionException("Class " + orCreateKotlinClass + " is not supported in default data conversion service");
    }
}
