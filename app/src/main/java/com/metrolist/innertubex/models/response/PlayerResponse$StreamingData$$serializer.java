package com.metrolist.innertubex.models.response;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$StreamingData$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$StreamingData$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$StreamingData$$serializer playerResponse$StreamingData$$serializer = new PlayerResponse$StreamingData$$serializer();
        INSTANCE = playerResponse$StreamingData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.StreamingData", playerResponse$StreamingData$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("formats", true);
        pluginGeneratedSerialDescriptor.addElement("adaptiveFormats", true);
        pluginGeneratedSerialDescriptor.addElement("expiresInSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("hlsManifestUrl", true);
        pluginGeneratedSerialDescriptor.addElement("dashManifestUrl", true);
        pluginGeneratedSerialDescriptor.addElement("serverAbrStreamingUrl", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = PlayerResponse.StreamingData.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable((KSerializer) lazyArr[0].getValue()), lazyArr[1].getValue(), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        List list2;
        String str;
        String str2;
        String str3;
        Integer num;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlayerResponse.StreamingData.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            list = list4;
            list2 = list3;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            str2 = str4;
            str3 = str5;
            num = num2;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            List list5 = null;
            List list6 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            Integer num3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list6);
                        i2 |= 1;
                        break;
                    case 1:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list5);
                        i2 |= 2;
                        break;
                    case 2:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
                        i2 |= 4;
                        break;
                    case 3:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i2 |= 8;
                        break;
                    case 4:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i2 |= 16;
                        break;
                    case 5:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str6);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            list = list5;
            list2 = list6;
            str = str6;
            str2 = str7;
            str3 = str8;
            num = num3;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.StreamingData(i, list2, list, num, str2, str3, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.StreamingData streamingData = (PlayerResponse.StreamingData) obj;
        streamingData.getClass();
        String str = streamingData.serverAbrStreamingUrl;
        String str2 = streamingData.dashManifestUrl;
        String str3 = streamingData.hlsManifestUrl;
        Integer num = streamingData.expiresInSeconds;
        List list = streamingData.adaptiveFormats;
        List list2 = streamingData.formats;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlayerResponse.StreamingData.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || list2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), list2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
