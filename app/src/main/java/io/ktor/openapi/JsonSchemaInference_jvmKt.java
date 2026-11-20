package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.GeneratedSerializer;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0015\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00130\u00122\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u00122\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a'\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00122\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0016\u001a#\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014*\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/openapi/JsonSchema$Discriminator$Mapping;", "mapping", "", "typeName", "(Lio/ktor/openapi/JsonSchema$Discriminator$Mapping;)Ljava/lang/String;", "Lkotlinx/serialization/KSerializer;", "serializer", "", "sealedSubclassComponentNameMapping", "(Lkotlinx/serialization/KSerializer;)Ljava/util/Map;", "", "index", "nestedSerializerAt", "(Lkotlinx/serialization/KSerializer;I)Lkotlinx/serialization/KSerializer;", "subclassComponentName", "(Lkotlinx/serialization/KSerializer;)Ljava/lang/String;", "unwrapNullableSerializer", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "sealedSubclassEntries", "(Lkotlinx/serialization/KSerializer;)Ljava/util/List;", "sealedSubclassKClasses", "sealedSubclassSerializers", "T", "", ContentDisposition.Parameters.Name, "findFieldValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "toKClassOrNull", "(Ljava/lang/Object;)Lkotlin/reflect/KClass;", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonSchemaInference_jvmKt {
    private static final <T> T findFieldValue(Object obj, String str) {
        Field field;
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            Field[] declaredFields = superclass.getDeclaredFields();
            declaredFields.getClass();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i];
                if (Intrinsics.areEqual(field.getName(), str)) {
                    break;
                }
                i++;
            }
            if (field != null) {
                field.setAccessible(true);
                T t = (T) field.get(obj);
                if (t == null) {
                    return null;
                }
                return t;
            }
        }
        return null;
    }

    public static final KSerializer nestedSerializerAt(KSerializer kSerializer, int i) {
        Iterable iterableListOf;
        KSerializer kSerializer2;
        if (kSerializer == null) {
            return null;
        }
        if (kSerializer.getDescriptor().isNullable()) {
            KSerializer kSerializer3 = (KSerializer) findFieldValue(kSerializer, "serializer");
            if (kSerializer3 == null) {
                return null;
            }
            return nestedSerializerAt(kSerializer3, i);
        }
        Pair pair = (Pair) CollectionsKt.getOrNull(i, sealedSubclassEntries(kSerializer));
        if (pair != null && (kSerializer2 = (KSerializer) pair.second) != null) {
            return kSerializer2;
        }
        if (kSerializer instanceof GeneratedSerializer) {
            return (KSerializer) ArraysKt.getOrNull(i, ((GeneratedSerializer) kSerializer).childSerializers());
        }
        if (Intrinsics.areEqual(kSerializer.getDescriptor().getKind(), StructureKind$MAP.INSTANCE$2)) {
            iterableListOf = CollectionsKt__IterablesKt.listOf("elementSerializer");
        } else {
            Okio__OkioKt kind = kSerializer.getDescriptor().getKind();
            StructureKind$MAP structureKind$MAP = StructureKind$MAP.INSTANCE;
            if (Intrinsics.areEqual(kind, structureKind$MAP) && i == 0) {
                iterableListOf = CollectionsKt__IterablesKt.listOf("keySerializer");
            } else {
                iterableListOf = (Intrinsics.areEqual(kSerializer.getDescriptor().getKind(), structureKind$MAP) && i == 1) ? CollectionsKt__IterablesKt.listOf("valueSerializer") : EmptyList.INSTANCE;
            }
        }
        Iterator it = iterableListOf.iterator();
        while (it.hasNext()) {
            KSerializer kSerializer4 = (KSerializer) findFieldValue(kSerializer, (String) it.next());
            if (kSerializer4 != null) {
                return kSerializer4;
            }
        }
        return null;
    }

    public static final Map<String, String> sealedSubclassComponentNameMapping(KSerializer kSerializer) {
        KSerializer kSerializerUnwrapNullableSerializer;
        if (kSerializer == null || (kSerializerUnwrapNullableSerializer = unwrapNullableSerializer(kSerializer)) == null) {
            return EmptyMap.INSTANCE;
        }
        List<Pair> listSealedSubclassEntries = sealedSubclassEntries(kSerializerUnwrapNullableSerializer);
        ArrayList arrayList = new ArrayList();
        for (Pair pair : listSealedSubclassEntries) {
            KClass kClass = (KClass) pair.first;
            KSerializer kSerializer2 = (KSerializer) pair.second;
            String qualifiedName = kClass.getQualifiedName();
            Pair pair2 = (qualifiedName == null && (qualifiedName = kClass.getSimpleName()) == null) ? null : new Pair(kSerializer2.getDescriptor().getSerialName(), qualifiedName);
            if (pair2 != null) {
                arrayList.add(pair2);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    private static final List<Pair> sealedSubclassEntries(KSerializer kSerializer) throws IllegalAccessException, InvocationTargetException {
        Map map;
        List<KSerializer> listSealedSubclassSerializers;
        Pair pair;
        Method[] methods = kSerializer.getClass().getMethods();
        methods.getClass();
        int length = methods.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                map = (Map) findFieldValue(kSerializer, "class2Serializer");
                break;
            }
            if (Intrinsics.areEqual(methods[i2].getName(), "getClass2Serializer$kotlinx_serialization_core")) {
                Method[] methods2 = kSerializer.getClass().getMethods();
                methods2.getClass();
                int length2 = methods2.length;
                while (true) {
                    if (i >= length2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1("Array contains no element matching the predicate.");
                        return null;
                    }
                    Method method = methods2[i];
                    if (Intrinsics.areEqual(method.getName(), "getClass2Serializer$kotlinx_serialization_core")) {
                        Object objInvoke = method.invoke(kSerializer, null);
                        if (!(objInvoke instanceof Map)) {
                            map = null;
                            break;
                        }
                        map = (Map) objInvoke;
                        break;
                    }
                    i++;
                }
            } else {
                i2++;
            }
        }
        if (map == null) {
            List<KClass<?>> listSealedSubclassKClasses = sealedSubclassKClasses(kSerializer);
            return (listSealedSubclassKClasses == null || (listSealedSubclassSerializers = sealedSubclassSerializers(kSerializer)) == null) ? EmptyList.INSTANCE : CollectionsKt.zip(listSealedSubclassKClasses, listSealedSubclassSerializers);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            KClass<?> kClassOrNull = toKClassOrNull(key);
            if (kClassOrNull != null) {
                KSerializer kSerializer2 = value instanceof KSerializer ? (KSerializer) value : null;
                if (kSerializer2 == null) {
                    pair = null;
                } else {
                    pair = new Pair(kClassOrNull, kSerializer2);
                }
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    private static final List<KClass<?>> sealedSubclassKClasses(KSerializer kSerializer) {
        Object[] objArr = (Object[]) findFieldValue(kSerializer, "subclasses");
        if (objArr != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                KClass<?> kClassOrNull = toKClassOrNull(obj);
                if (kClassOrNull != null) {
                    arrayList.add(kClassOrNull);
                }
            }
            return arrayList;
        }
        List list = (List) findFieldValue(kSerializer, "subclasses");
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            KClass<?> kClassOrNull2 = toKClassOrNull(it.next());
            if (kClassOrNull2 != null) {
                arrayList2.add(kClassOrNull2);
            }
        }
        return arrayList2;
    }

    private static final List<KSerializer> sealedSubclassSerializers(KSerializer kSerializer) {
        Object[] objArr = (Object[]) findFieldValue(kSerializer, "subclassSerializers");
        if (objArr != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                if (obj instanceof KSerializer) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        List list = (List) findFieldValue(kSerializer, "subclassSerializers");
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof KSerializer) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public static final String subclassComponentName(KSerializer kSerializer) {
        if (kSerializer == null) {
            return null;
        }
        Class<?> enclosingClass = kSerializer.getClass().getEnclosingClass();
        if (enclosingClass != null) {
            String strReplace = enclosingClass.getName().replace('$', '.');
            strReplace.getClass();
            return strReplace;
        }
        String name = kSerializer.getClass().getName();
        if (!StringsKt__StringsJVMKt.endsWith(name, String.valueOf(kSerializer), false)) {
            return null;
        }
        String strReplace2 = StringsKt.removeSuffix(name, String.valueOf(kSerializer)).replace('$', '.');
        strReplace2.getClass();
        return strReplace2;
    }

    private static final KClass<?> toKClassOrNull(Object obj) {
        if (obj instanceof KClass) {
            return (KClass) obj;
        }
        if (obj instanceof Class) {
            return Reflection.getOrCreateKotlinClass((Class) obj);
        }
        return null;
    }

    public static final String typeName(JsonSchema.Discriminator.Mapping mapping) {
        mapping.getClass();
        String qualifiedName = Reflection.getOrCreateKotlinClass(mapping.ref()).getQualifiedName();
        return qualifiedName == null ? Reflection.getOrCreateKotlinClass(mapping.ref()).getSimpleName() : qualifiedName;
    }

    private static final KSerializer unwrapNullableSerializer(KSerializer kSerializer) {
        return kSerializer.getDescriptor().isNullable() ? (KSerializer) findFieldValue(kSerializer, "serializer") : kSerializer;
    }
}
