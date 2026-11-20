package io.ktor.openapi;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/openapi/Response.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/Response;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/Response;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/Response;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class Response$$serializer implements GeneratedSerializer {
    public static final Response$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Response$$serializer response$$serializer = new Response$$serializer();
        INSTANCE = response$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.openapi.Response", response$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("headers", true);
        pluginGeneratedSerialDescriptor.addElement("content", true);
        pluginGeneratedSerialDescriptor.addElement("links", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Response$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = Response.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[3].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[4].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Response deserialize(Decoder decoder) {
        Map map;
        String str;
        Map map2;
        int i;
        Map map3;
        Map map4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = Response.$childSerializers;
        Response response = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            Map map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            Map map6 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            Map map7 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            str = strDecodeStringElement;
            map2 = map7;
            i = 31;
            map3 = map6;
            map4 = map5;
        } else {
            boolean z = true;
            int i2 = 0;
            Map map8 = null;
            String strDecodeStringElement2 = null;
            Map map9 = null;
            Map map10 = null;
            Map map11 = null;
            while (z) {
                response = response;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    map11 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), map11);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    map10 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), map10);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    map9 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), map9);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return response;
                    }
                    map8 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), map8);
                    i2 |= 16;
                }
            }
            map = map8;
            str = strDecodeStringElement2;
            map2 = map9;
            i = i2;
            map3 = map10;
            map4 = map11;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Response(i, str, map4, map3, map2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Response value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Response.write$Self$ktor_openapi_schema(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
