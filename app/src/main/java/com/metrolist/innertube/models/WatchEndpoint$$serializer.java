package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
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
public final /* synthetic */ class WatchEndpoint$$serializer implements GeneratedSerializer {
    public static final WatchEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        WatchEndpoint$$serializer watchEndpoint$$serializer = new WatchEndpoint$$serializer();
        INSTANCE = watchEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.WatchEndpoint", watchEndpoint$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("videoId", true);
        pluginGeneratedSerialDescriptor.addElement("playlistId", true);
        pluginGeneratedSerialDescriptor.addElement("playlistSetVideoId", true);
        pluginGeneratedSerialDescriptor.addElement("params", true);
        pluginGeneratedSerialDescriptor.addElement("index", true);
        pluginGeneratedSerialDescriptor.addElement("watchEndpointMusicSupportedConfigs", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs;
        Integer num;
        int i;
        String str2;
        String str3;
        String str4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, null);
            watchEndpointMusicSupportedConfigs = (WatchEndpoint.WatchEndpointMusicSupportedConfigs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE, null);
            num = num2;
            i = 63;
            str2 = str7;
            str3 = str6;
            str4 = str5;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs2 = null;
            Integer num3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str10);
                        i2 |= 1;
                        break;
                    case 1:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i2 |= 2;
                        break;
                    case 2:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i2 |= 4;
                        break;
                    case 3:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
                        i2 |= 8;
                        break;
                    case 4:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num3);
                        i2 |= 16;
                        break;
                    case 5:
                        watchEndpointMusicSupportedConfigs2 = (WatchEndpoint.WatchEndpointMusicSupportedConfigs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE, watchEndpointMusicSupportedConfigs2);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            watchEndpointMusicSupportedConfigs = watchEndpointMusicSupportedConfigs2;
            num = num3;
            i = i2;
            str2 = str8;
            str3 = str9;
            str4 = str10;
        }
        String str11 = str;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new WatchEndpoint(i, str4, str3, str2, str11, num, watchEndpointMusicSupportedConfigs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        WatchEndpoint watchEndpoint = (WatchEndpoint) obj;
        watchEndpoint.getClass();
        WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs = watchEndpoint.watchEndpointMusicSupportedConfigs;
        Integer num = watchEndpoint.index;
        String str = watchEndpoint.params;
        String str2 = watchEndpoint.playlistSetVideoId;
        String str3 = watchEndpoint.playlistId;
        String str4 = watchEndpoint.videoId;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || watchEndpointMusicSupportedConfigs != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE, watchEndpointMusicSupportedConfigs);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
