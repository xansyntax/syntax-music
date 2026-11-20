package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PairSerializer implements KSerializer {
    public final /* synthetic */ byte $r8$classId;
    public final SerialDescriptorImpl descriptor;
    public final KSerializer keySerializer;
    public final KSerializer valueSerializer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PairSerializer(KSerializer kSerializer, KSerializer kSerializer2, byte b) {
        this(kSerializer, kSerializer2, (char) 0);
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this(kSerializer, kSerializer2, (char) 0);
                this.descriptor = StringsKt__IndentKt.buildSerialDescriptor("kotlin.collections.Map.Entry", StructureKind$MAP.INSTANCE, new SerialDescriptor[0], new FileChannelsKt$$ExternalSyntheticLambda1(kSerializer, kSerializer2, (byte) 10));
                return;
            default:
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
                if (StringsKt.isBlank("kotlin.Pair")) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
                    throw null;
                }
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("kotlin.Pair");
                classSerialDescriptorBuilder.element("first", kSerializer.getDescriptor());
                classSerialDescriptorBuilder.element("second", kSerializer2.getDescriptor());
                this.descriptor = new SerialDescriptorImpl("kotlin.Pair", StructureKind$MAP.INSTANCE$1, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
                return;
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Object result;
        Object obj = EnumsKt.NULL;
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        boolean zDecodeSequentially = compositeDecoderBeginStructure.decodeSequentially();
        KSerializer kSerializer = this.valueSerializer;
        KSerializer kSerializer2 = this.keySerializer;
        if (zDecodeSequentially) {
            result = toResult(compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), 0, kSerializer2, null), compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), 1, kSerializer, null));
        } else {
            Object objDecodeSerializableElement = obj;
            Object objDecodeSerializableElement2 = objDecodeSerializableElement;
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    if (objDecodeSerializableElement == obj) {
                        throw new SerializationException("Element 'key' is missing");
                    }
                    if (objDecodeSerializableElement2 == obj) {
                        throw new SerializationException("Element 'value' is missing");
                    }
                    result = toResult(objDecodeSerializableElement, objDecodeSerializableElement2);
                    break;
                }
                if (iDecodeElementIndex == 0) {
                    objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), 0, kSerializer2, null);
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new SerializationException(IntIntPair$$ExternalSyntheticOutline0.m(iDecodeElementIndex, "Invalid index: "));
                    }
                    objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), 1, kSerializer, null);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return result;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        byte b = this.$r8$classId;
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Object key;
        Object value;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(getDescriptor());
        SerialDescriptor descriptor = getDescriptor();
        KSerializer kSerializer = this.keySerializer;
        byte b = this.$r8$classId;
        switch (b) {
            case 0:
                Pair pair = (Pair) obj;
                pair.getClass();
                key = pair.first;
                break;
            default:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                key = entry.getKey();
                break;
        }
        compositeEncoderBeginStructure.encodeSerializableElement(descriptor, 0, kSerializer, key);
        SerialDescriptor descriptor2 = getDescriptor();
        KSerializer kSerializer2 = this.valueSerializer;
        switch (b) {
            case 0:
                Pair pair2 = (Pair) obj;
                pair2.getClass();
                value = pair2.second;
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                entry2.getClass();
                value = entry2.getValue();
                break;
        }
        compositeEncoderBeginStructure.encodeSerializableElement(descriptor2, 1, kSerializer2, value);
        compositeEncoderBeginStructure.endStructure(getDescriptor());
    }

    public final Object toResult(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return new Pair(obj, obj2);
            default:
                return new MapEntrySerializer$MapEntry(obj, obj2);
        }
    }

    public PairSerializer(KSerializer kSerializer, KSerializer kSerializer2, char c) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }
}
