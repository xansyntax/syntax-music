package kotlinx.serialization.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.ranges.IntProgression;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HashMapSerializer extends AbstractCollectionSerializer {
    public final /* synthetic */ byte $r8$classId;
    public final HashMapClassDesc descriptor;
    public final KSerializer keySerializer;
    public final KSerializer valueSerializer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HashMapSerializer(KSerializer kSerializer, KSerializer kSerializer2, byte b) {
        this(kSerializer, kSerializer2, (char) 0);
        this.$r8$classId = b;
        switch (b) {
            case 1:
                kSerializer.getClass();
                kSerializer2.getClass();
                this(kSerializer, kSerializer2, (char) 0);
                SerialDescriptor descriptor = kSerializer.getDescriptor();
                SerialDescriptor descriptor2 = kSerializer2.getDescriptor();
                descriptor.getClass();
                descriptor2.getClass();
                this.descriptor = new HashMapClassDesc(descriptor, descriptor2, "kotlin.collections.LinkedHashMap");
                break;
            default:
                kSerializer.getClass();
                kSerializer2.getClass();
                SerialDescriptor descriptor3 = kSerializer.getDescriptor();
                SerialDescriptor descriptor4 = kSerializer2.getDescriptor();
                descriptor3.getClass();
                descriptor4.getClass();
                this.descriptor = new HashMapClassDesc(descriptor3, descriptor4, "kotlin.collections.HashMap");
                break;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object builder() {
        switch (this.$r8$classId) {
            case 0:
                return new HashMap();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int builderSize(Object obj) {
        int size;
        switch (this.$r8$classId) {
            case 0:
                HashMap map = (HashMap) obj;
                map.getClass();
                size = map.size();
                break;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                linkedHashMap.getClass();
                size = linkedHashMap.size();
                break;
        }
        return size * 2;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void checkCapacity(int i, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((HashMap) obj).getClass();
                break;
            default:
                ((LinkedHashMap) obj).getClass();
                break;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator collectionIterator(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) obj;
                map.getClass();
                return map.entrySet().iterator();
            default:
                Map map2 = (Map) obj;
                map2.getClass();
                return map2.entrySet().iterator();
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) obj;
                map.getClass();
                return map.size();
            default:
                Map map2 = (Map) obj;
                map2.getClass();
                return map2.size();
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        byte b = this.$r8$classId;
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2) {
        Map map = (Map) obj;
        map.getClass();
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Size must be known in advance when using READ_ALL");
            return;
        }
        IntProgression intProgressionStep = UuidKt.step(UuidKt.until(0, i2 * 2), 2);
        int i3 = intProgressionStep.first;
        int i4 = intProgressionStep.last;
        int i5 = intProgressionStep.step;
        if ((i5 <= 0 || i3 > i4) && (i5 >= 0 || i4 > i3)) {
            return;
        }
        while (true) {
            readElement(compositeDecoder, i + i3, map, false);
            if (i3 == i4) {
                return;
            } else {
                i3 += i5;
            }
        }
    }

    public final void readElement(CompositeDecoder compositeDecoder, int i, Map map, boolean z) {
        int iDecodeElementIndex;
        map.getClass();
        Object objDecodeSerializableElement = compositeDecoder.decodeSerializableElement(getDescriptor(), i, this.keySerializer, null);
        if (z) {
            iDecodeElementIndex = compositeDecoder.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != i + 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i, iDecodeElementIndex, "Value must follow key in a map, index for key: ", ", returned index for value: "));
                return;
            }
        } else {
            iDecodeElementIndex = i + 1;
        }
        boolean zContainsKey = map.containsKey(objDecodeSerializableElement);
        KSerializer kSerializer = this.valueSerializer;
        map.put(objDecodeSerializableElement, (!zContainsKey || (kSerializer.getDescriptor().getKind() instanceof PrimitiveKind$INT)) ? compositeDecoder.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, kSerializer, null) : compositeDecoder.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, kSerializer, MapsKt__MapsKt.getValue(map, objDecodeSerializableElement)));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        int iCollectionSize = collectionSize(obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(descriptor, iCollectionSize);
        Iterator itCollectionIterator = collectionIterator(obj);
        int i = 0;
        while (itCollectionIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) itCollectionIterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i2 = i + 1;
            compositeEncoderBeginCollection.encodeSerializableElement(getDescriptor(), i, this.keySerializer, key);
            i += 2;
            compositeEncoderBeginCollection.encodeSerializableElement(getDescriptor(), i2, this.valueSerializer, value);
        }
        compositeEncoderBeginCollection.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw null;
            default:
                throw null;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toResult(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                HashMap map = (HashMap) obj;
                map.getClass();
                return map;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                linkedHashMap.getClass();
                return linkedHashMap;
        }
    }

    public HashMapSerializer(KSerializer kSerializer, KSerializer kSerializer2, char c) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final /* bridge */ /* synthetic */ void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        readElement(compositeDecoder, i, (Map) obj, true);
    }
}
