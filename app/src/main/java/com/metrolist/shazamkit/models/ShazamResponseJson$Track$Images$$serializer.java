package com.metrolist.shazamkit.models;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.text.HexFormatKt;
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
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamResponseJson.Track.Images.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Images;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamResponseJson$Track$Images$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamResponseJson$Track$Images$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamResponseJson$Track$Images$$serializer shazamResponseJson$Track$Images$$serializer = new ShazamResponseJson$Track$Images$$serializer();
        INSTANCE = shazamResponseJson$Track$Images$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamResponseJson.Track.Images", shazamResponseJson$Track$Images$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("coverart", true);
        pluginGeneratedSerialDescriptor.addElement("coverarthq", true);
        pluginGeneratedSerialDescriptor.addElement("joecolor", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamResponseJson$Track$Images$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamResponseJson.Track.Images deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            i = 15;
            str2 = str7;
            str3 = str6;
            str4 = str5;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str10);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
                    i2 |= 8;
                }
            }
            i = i2;
            str2 = str8;
            str3 = str9;
            str4 = str10;
        }
        String str11 = str;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamResponseJson.Track.Images(i, str4, str3, str2, str11, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamResponseJson.Track.Images value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamResponseJson.Track.Images.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
