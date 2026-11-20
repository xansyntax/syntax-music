package kotlinx.serialization.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPolymorphicSerializer implements KSerializer {
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), 1, EntryPoints.findPolymorphicSerializer(this, compositeDecoderBeginStructure, compositeDecoderBeginStructure.decodeStringElement(getDescriptor(), 0)), null);
        } else {
            Object objDecodeSerializableElement2 = null;
            String strDecodeStringElement = null;
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    if (objDecodeSerializableElement2 != null) {
                        objDecodeSerializableElement = objDecodeSerializableElement2;
                        break;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Polymorphic value has not been read for class ", strDecodeStringElement));
                    return null;
                }
                if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(getDescriptor(), iDecodeElementIndex);
                } else {
                    if (iDecodeElementIndex != 1) {
                        StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                        if (strDecodeStringElement == null) {
                            strDecodeStringElement = "unknown class";
                        }
                        sb.append(strDecodeStringElement);
                        sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb.append(iDecodeElementIndex);
                        throw new SerializationException(sb.toString());
                    }
                    if (strDecodeStringElement == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot read polymorphic value before its type token");
                        return null;
                    }
                    objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, EntryPoints.findPolymorphicSerializer(this, compositeDecoderBeginStructure, strDecodeStringElement), null);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return objDecodeSerializableElement;
    }

    public SerializationStrategy findPolymorphicSerializerOrNull(Encoder encoder, Object obj) {
        obj.getClass();
        SerializersModule serializersModule = encoder.getSerializersModule();
        KClass baseClass = getBaseClass();
        ((SerialModuleImpl) serializersModule).getClass();
        baseClass.getClass();
        if (!baseClass.isInstance(obj)) {
            return null;
        }
        TypeIntrinsics.isFunctionOfArity(1, null);
        return null;
    }

    public abstract KClass getBaseClass();

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        obj.getClass();
        SerializationStrategy serializationStrategyFindPolymorphicSerializer = EntryPoints.findPolymorphicSerializer(this, encoder, obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
        compositeEncoderBeginStructure.encodeStringElement(getDescriptor(), 0, serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName());
        compositeEncoderBeginStructure.encodeSerializableElement(getDescriptor(), 1, serializationStrategyFindPolymorphicSerializer, obj);
        compositeEncoderBeginStructure.endStructure(descriptor);
    }

    public DeserializationStrategy findPolymorphicSerializerOrNull(CompositeDecoder compositeDecoder, String str) {
        SerializersModule serializersModule = compositeDecoder.getSerializersModule();
        KClass baseClass = getBaseClass();
        ((SerialModuleImpl) serializersModule).getClass();
        baseClass.getClass();
        TypeIntrinsics.isFunctionOfArity(1, null);
        return null;
    }
}
