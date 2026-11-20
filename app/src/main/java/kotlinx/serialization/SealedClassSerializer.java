package kotlinx.serialization;

import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SealedClassSerializer extends AbstractPolymorphicSerializer {
    public final List _annotations;
    public final ClassReference baseClass;
    public final Map class2Serializer;
    public final Lazy descriptor$delegate;
    public final LinkedHashMap serialName2Serializer;

    public SealedClassSerializer(String str, ClassReference classReference, KClass[] kClassArr, KSerializer[] kSerializerArr, Annotation[] annotationArr) {
        this.baseClass = classReference;
        this._annotations = EmptyList.INSTANCE;
        this.descriptor$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Url$$ExternalSyntheticLambda1(str, this, (byte) 4));
        if (kClassArr.length != kSerializerArr.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + classReference.getSimpleName() + " should be marked @Serializable");
        }
        int iMin = Math.min(kClassArr.length, kSerializerArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(new Pair(kClassArr[i], kSerializerArr[i]));
        }
        Map map = MapsKt__MapsKt.toMap(arrayList);
        this.class2Serializer = map;
        Set<Map.Entry> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : setEntrySet) {
            String serialName = ((KSerializer) entry.getValue()).getDescriptor().getSerialName();
            Object obj = linkedHashMap.get(serialName);
            if (obj == null) {
                linkedHashMap.containsKey(serialName);
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 != null) {
                StringBuilder sb = new StringBuilder("Multiple sealed subclasses of '");
                sb.append(this.baseClass);
                sb.append("' have the same serial name '");
                sb.append(serialName);
                sb.append("': '");
                sb.append(entry2.getKey());
                Object key = entry.getKey();
                sb.append("', '");
                sb.append(key);
                sb.append('\'');
                throw new IllegalStateException(sb.toString().toString());
            }
            linkedHashMap.put(serialName, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
        List listAsList = Arrays.asList(annotationArr);
        listAsList.getClass();
        this._annotations = listAsList;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy findPolymorphicSerializerOrNull(Encoder encoder, Object obj) {
        KSerializer kSerializer;
        obj.getClass();
        KSerializer kSerializer2 = (KSerializer) this.class2Serializer.get(Reflection.getOrCreateKotlinClass(obj.getClass()));
        if (kSerializer2 != null) {
            kSerializer = kSerializer2;
        } else {
            super.findPolymorphicSerializerOrNull(encoder, obj);
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        return null;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy findPolymorphicSerializerOrNull(CompositeDecoder compositeDecoder, String str) {
        KSerializer kSerializer = (KSerializer) this.serialName2Serializer.get(str);
        if (kSerializer != null) {
            return kSerializer;
        }
        super.findPolymorphicSerializerOrNull(compositeDecoder, str);
        return null;
    }
}
