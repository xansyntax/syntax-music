package kotlinx.serialization.json;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayClassDesc;
import kotlinx.serialization.internal.HashSetSerializer;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonArraySerializer implements KSerializer {
    public static final JsonArraySerializer INSTANCE = new JsonArraySerializer();
    public static final JsonArrayDescriptor descriptor = JsonArrayDescriptor.INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JsonArrayDescriptor implements SerialDescriptor {
        public static final JsonArrayDescriptor INSTANCE = new JsonArrayDescriptor();
        public static final String serialName = "kotlinx.serialization.json.JsonArray";
        public final /* synthetic */ ArrayClassDesc $$delegate_0;

        public JsonArrayDescriptor() {
            SerialDescriptor descriptor = JsonElementSerializer.INSTANCE.getDescriptor();
            descriptor.getClass();
            this.$$delegate_0 = new ArrayClassDesc(descriptor, (byte) 1);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getAnnotations() {
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getElementAnnotations(int i) {
            this.$$delegate_0.getElementAnnotations(i);
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor getElementDescriptor(int i) {
            return this.$$delegate_0.getElementDescriptor(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementIndex(String str) {
            str.getClass();
            return this.$$delegate_0.getElementIndex(str);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getElementName(int i) {
            return String.valueOf(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementsCount() {
            return 1;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final Okio__OkioKt getKind() {
            return StructureKind$MAP.INSTANCE$2;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getSerialName() {
            return serialName;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isElementOptional(int i) {
            this.$$delegate_0.isElementOptional(i);
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isNullable() {
            return false;
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        CollectionsKt__IterablesKt.asJsonDecoder(decoder);
        return new JsonArray((List) new HashSetSerializer(JsonElementSerializer.INSTANCE, (byte) 1).merge(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonArray jsonArray = (JsonArray) obj;
        jsonArray.getClass();
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        SerialDescriptor descriptor2 = jsonElementSerializer.getDescriptor();
        descriptor2.getClass();
        ArrayClassDesc arrayClassDesc = new ArrayClassDesc(descriptor2, (byte) 1);
        int size = jsonArray.size();
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(arrayClassDesc, size);
        Iterator<JsonElement> it = jsonArray.iterator();
        for (int i = 0; i < size; i++) {
            compositeEncoderBeginCollection.encodeSerializableElement(arrayClassDesc, i, jsonElementSerializer, it.next());
        }
        compositeEncoderBeginCollection.endStructure(arrayClassDesc);
    }
}
