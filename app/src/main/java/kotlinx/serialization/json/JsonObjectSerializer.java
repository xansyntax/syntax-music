package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.StringSerializer;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonObjectSerializer implements KSerializer {
    public static final JsonObjectSerializer INSTANCE = new JsonObjectSerializer();
    public static final JsonObjectDescriptor descriptor = JsonObjectDescriptor.INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JsonObjectDescriptor implements SerialDescriptor {
        public static final JsonObjectDescriptor INSTANCE = new JsonObjectDescriptor();
        public static final String serialName = "kotlinx.serialization.json.JsonObject";
        public final /* synthetic */ HashMapClassDesc $$delegate_0 = HexFormatKt.MapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE).descriptor;

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
            return 2;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final Okio__OkioKt getKind() {
            return StructureKind$MAP.INSTANCE;
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
        return new JsonObject((Map) HexFormatKt.MapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE).deserialize(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonObject jsonObject = (JsonObject) obj;
        jsonObject.getClass();
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        HexFormatKt.MapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE).serialize(encoder, jsonObject);
    }
}
