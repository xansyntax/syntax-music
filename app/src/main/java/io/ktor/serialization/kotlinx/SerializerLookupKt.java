package io.ktor.serialization.kotlinx;

import io.ktor.http.LinkHeader;
import io.ktor.util.reflect.TypeInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0003*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0003*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "Lkotlinx/serialization/KSerializer;", "serializerForTypeInfo", "(Lkotlinx/serialization/modules/SerializersModule;Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "module", "checkTypeParameters", "(Lkotlin/reflect/KType;Lio/ktor/util/reflect/TypeInfo;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "", "value", "guessSerializer", "(Ljava/lang/Object;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "", "elementSerializer", "(Ljava/util/Collection;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "", "nullable", "maybeNullable", "(Lkotlinx/serialization/KSerializer;Z)Lkotlinx/serialization/KSerializer;", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerializerLookupKt {
    private static final KSerializer checkTypeParameters(KType kType, TypeInfo typeInfo, SerializersModule serializersModule) throws IOException {
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = arguments.iterator();
        while (true) {
            KType kType2 = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                KType type = ((KTypeProjection) it.next()).getType();
                if (type != null) {
                    serializersModule.getClass();
                    if (CharsKt.serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, type, false) == null) {
                        kType2 = type;
                    }
                }
                if (kType2 != null) {
                    arrayList.add(kType2);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        if (!arrayList.isEmpty()) {
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, null, null, null, new InstantKt$$ExternalSyntheticLambda0((byte) 5), 31);
            Pair pair = arrayList.size() == 1 ? new Pair("", "is") : new Pair("s", "are");
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            throw new SerializationException("Serializer for type argument" + str + ' ' + strJoinToString$default + ' ' + str2 + " not found for '" + typeInfo.getType().getSimpleName() + "'. Ensure that the listed type" + str + ' ' + str2 + " marked as '@Serializable'.");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence checkTypeParameters$lambda$1(KType kType) {
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KClass) {
            return "'" + ((KClass) classifier).getSimpleName() + '\'';
        }
        return "'" + kType + '\'';
    }

    private static final KSerializer elementSerializer(Collection<?> collection, SerializersModule serializersModule) {
        Collection<?> collection2 = collection;
        ArrayList arrayListFilterNotNull = CollectionsKt.filterNotNull(collection2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull, 10));
        int size = arrayListFilterNotNull.size();
        boolean z = false;
        int i = 0;
        z = false;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayListFilterNotNull.get(i2);
            i2++;
            arrayList.add(guessSerializer(obj, serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            if (hashSet.add(((KSerializer) obj2).getDescriptor().getSerialName())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            int size3 = arrayList2.size();
            while (i < size3) {
                Object obj3 = arrayList2.get(i);
                i++;
                arrayList3.add(((KSerializer) obj3).getDescriptor().getSerialName());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        KSerializer kSerializer = (KSerializer) CollectionsKt.singleOrNull(arrayList2);
        if (kSerializer == null) {
            kSerializer = StringSerializer.INSTANCE;
        }
        if (kSerializer.getDescriptor().isNullable()) {
            return kSerializer;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    z = true;
                    break;
                }
            }
        }
        return maybeNullable(kSerializer, z);
    }

    public static final KSerializer guessSerializer(Object obj, SerializersModule serializersModule) {
        KSerializer kSerializerGuessSerializer;
        serializersModule.getClass();
        if (obj == null) {
            return HexFormatKt.getNullable(StringSerializer.INSTANCE);
        }
        if (obj instanceof List) {
            KSerializer kSerializerElementSerializer = elementSerializer((Collection) obj, serializersModule);
            kSerializerElementSerializer.getClass();
            return new HashSetSerializer(kSerializerElementSerializer, (byte) 1);
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            Object obj2 = objArr.length == 0 ? null : objArr[0];
            return (obj2 == null || (kSerializerGuessSerializer = guessSerializer(obj2, serializersModule)) == null) ? new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1) : kSerializerGuessSerializer;
        }
        if (obj instanceof Set) {
            KSerializer kSerializerElementSerializer2 = elementSerializer((Collection) obj, serializersModule);
            kSerializerElementSerializer2.getClass();
            return new HashSetSerializer(kSerializerElementSerializer2, (byte) 2);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            return HexFormatKt.MapSerializer(elementSerializer(map.keySet(), serializersModule), elementSerializer(map.values(), serializersModule));
        }
        SerializersModule.getContextual$default(serializersModule, Reflection.getOrCreateKotlinClass(obj.getClass()));
        return CharsKt.serializer(Reflection.getOrCreateKotlinClass(obj.getClass()));
    }

    private static final KSerializer maybeNullable(KSerializer kSerializer, boolean z) {
        if (!z) {
            return kSerializer;
        }
        kSerializer.getClass();
        return HexFormatKt.getNullable(kSerializer);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    public static final KSerializer serializerForTypeInfo(SerializersModule serializersModule, TypeInfo typeInfo) {
        KSerializer kSerializerSerializer;
        serializersModule.getClass();
        typeInfo.getClass();
        KType kotlinType = typeInfo.getKotlinType();
        if (kotlinType == null) {
            SerializersModule.getContextual$default(serializersModule, typeInfo.getType());
            kSerializerSerializer = CharsKt.serializer(typeInfo.getType());
        } else {
            if (kotlinType.getArguments().isEmpty()) {
                kSerializerSerializer = null;
            } else {
                KSerializer kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt = CharsKt.serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, kotlinType, false);
                kSerializerSerializer = kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt == null ? checkTypeParameters(kotlinType, typeInfo, serializersModule) : kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt;
            }
            if (kSerializerSerializer == null) {
                SerializersModule.getContextual$default(serializersModule, typeInfo.getType());
                kSerializerSerializer = CharsKt.serializer(typeInfo.getType());
            }
        }
        return maybeNullable(kSerializerSerializer, typeInfo.getIsNullable());
    }
}
