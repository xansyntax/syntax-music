package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;
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
public final class TripleSerializer implements KSerializer {
    public final KSerializer aSerializer;
    public final KSerializer bSerializer;
    public final KSerializer cSerializer;
    public final SerialDescriptorImpl descriptor;

    public TripleSerializer(KSerializer kSerializer, KSerializer kSerializer2, KSerializer kSerializer3) {
        SerialDescriptorImpl serialDescriptorImpl;
        this.aSerializer = kSerializer;
        this.bSerializer = kSerializer2;
        this.cSerializer = kSerializer3;
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
        PingPongKt$$ExternalSyntheticLambda0 pingPongKt$$ExternalSyntheticLambda0 = new PingPongKt$$ExternalSyntheticLambda0((byte) 11, (Object) this);
        if (StringsKt.isBlank("kotlin.Triple")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
            serialDescriptorImpl = null;
        } else {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("kotlin.Triple");
            pingPongKt$$ExternalSyntheticLambda0.invoke(classSerialDescriptorBuilder);
            serialDescriptorImpl = new SerialDescriptorImpl("kotlin.Triple", StructureKind$MAP.INSTANCE$1, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
        }
        this.descriptor = serialDescriptorImpl;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SerialDescriptorImpl serialDescriptorImpl = this.descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptorImpl);
        boolean zDecodeSequentially = compositeDecoderBeginStructure.decodeSequentially();
        KSerializer kSerializer = this.cSerializer;
        KSerializer kSerializer2 = this.bSerializer;
        KSerializer kSerializer3 = this.aSerializer;
        if (zDecodeSequentially) {
            Object objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 0, kSerializer3, null);
            Object objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 1, kSerializer2, null);
            Object objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 2, kSerializer, null);
            compositeDecoderBeginStructure.endStructure(serialDescriptorImpl);
            return new Triple(objDecodeSerializableElement, objDecodeSerializableElement2, objDecodeSerializableElement3);
        }
        Object obj = EnumsKt.NULL;
        Object objDecodeSerializableElement4 = obj;
        Object objDecodeSerializableElement5 = objDecodeSerializableElement4;
        Object objDecodeSerializableElement6 = objDecodeSerializableElement5;
        while (true) {
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptorImpl);
            if (iDecodeElementIndex == -1) {
                compositeDecoderBeginStructure.endStructure(serialDescriptorImpl);
                if (objDecodeSerializableElement4 == obj) {
                    throw new SerializationException("Element 'first' is missing");
                }
                if (objDecodeSerializableElement5 == obj) {
                    throw new SerializationException("Element 'second' is missing");
                }
                if (objDecodeSerializableElement6 != obj) {
                    return new Triple(objDecodeSerializableElement4, objDecodeSerializableElement5, objDecodeSerializableElement6);
                }
                throw new SerializationException("Element 'third' is missing");
            }
            if (iDecodeElementIndex == 0) {
                objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 0, kSerializer3, null);
            } else if (iDecodeElementIndex == 1) {
                objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 1, kSerializer2, null);
            } else {
                if (iDecodeElementIndex != 2) {
                    throw new SerializationException(IntIntPair$$ExternalSyntheticOutline0.m(iDecodeElementIndex, "Unexpected index "));
                }
                objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptorImpl, 2, kSerializer, null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Triple triple = (Triple) obj;
        triple.getClass();
        SerialDescriptorImpl serialDescriptorImpl = this.descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptorImpl);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptorImpl, 0, this.aSerializer, triple.first);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptorImpl, 1, this.bSerializer, triple.second);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptorImpl, 2, this.cSerializer, triple.third);
        compositeEncoderBeginStructure.endStructure(serialDescriptorImpl);
    }
}
