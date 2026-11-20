package com.metrolist.shazamkit.models;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamRequestJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamRequestJson;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamRequestJson$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamRequestJson$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamRequestJson$$serializer shazamRequestJson$$serializer = new ShazamRequestJson$$serializer();
        INSTANCE = shazamRequestJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamRequestJson", shazamRequestJson$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("geolocation", false);
        pluginGeneratedSerialDescriptor.addElement("signature", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("timezone", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamRequestJson$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{ShazamRequestJson$Geolocation$$serializer.INSTANCE, ShazamRequestJson$Signature$$serializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamRequestJson deserialize(Decoder decoder) {
        ShazamRequestJson.Geolocation geolocation;
        String strDecodeStringElement;
        int i;
        ShazamRequestJson.Signature signature;
        long j;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            geolocation = (ShazamRequestJson.Geolocation) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ShazamRequestJson$Geolocation$$serializer.INSTANCE, null);
            ShazamRequestJson.Signature signature2 = (ShazamRequestJson.Signature) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ShazamRequestJson$Signature$$serializer.INSTANCE, null);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            i = 15;
            signature = signature2;
            j = jDecodeLongElement;
        } else {
            boolean z = true;
            geolocation = null;
            ShazamRequestJson.Signature signature3 = null;
            long jDecodeLongElement2 = 0;
            int i2 = 0;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    geolocation = (ShazamRequestJson.Geolocation) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ShazamRequestJson$Geolocation$$serializer.INSTANCE, geolocation);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    signature3 = (ShazamRequestJson.Signature) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ShazamRequestJson$Signature$$serializer.INSTANCE, signature3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i = i2;
            signature = signature3;
            j = jDecodeLongElement2;
        }
        ShazamRequestJson.Geolocation geolocation2 = geolocation;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamRequestJson(i, geolocation2, signature, j, strDecodeStringElement, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamRequestJson value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamRequestJson.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
