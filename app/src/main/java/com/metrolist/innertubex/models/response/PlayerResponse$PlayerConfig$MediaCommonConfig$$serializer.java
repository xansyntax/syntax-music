package com.metrolist.innertubex.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer playerResponse$PlayerConfig$MediaCommonConfig$$serializer = new PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer();
        INSTANCE = playerResponse$PlayerConfig$MediaCommonConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.PlayerConfig.MediaCommonConfig", playerResponse$PlayerConfig$MediaCommonConfig$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("mediaUstreamerRequestConfig", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig mediaUstreamerRequestConfig;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            mediaUstreamerRequestConfig = (PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            mediaUstreamerRequestConfig = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    mediaUstreamerRequestConfig = (PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$$serializer.INSTANCE, mediaUstreamerRequestConfig);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.PlayerConfig.MediaCommonConfig(i, mediaUstreamerRequestConfig);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig = (PlayerResponse.PlayerConfig.MediaCommonConfig) obj;
        mediaCommonConfig.getClass();
        PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig mediaUstreamerRequestConfig = mediaCommonConfig.mediaUstreamerRequestConfig;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || mediaUstreamerRequestConfig != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$$serializer.INSTANCE, mediaUstreamerRequestConfig);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
