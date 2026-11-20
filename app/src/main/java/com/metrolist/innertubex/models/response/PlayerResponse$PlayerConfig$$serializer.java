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
public final /* synthetic */ class PlayerResponse$PlayerConfig$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlayerConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlayerConfig$$serializer playerResponse$PlayerConfig$$serializer = new PlayerResponse$PlayerConfig$$serializer();
        INSTANCE = playerResponse$PlayerConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.PlayerConfig", playerResponse$PlayerConfig$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("mediaCommonConfig", true);
        pluginGeneratedSerialDescriptor.addElement("audioConfig", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig;
        PlayerResponse.PlayerConfig.AudioConfig audioConfig;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            mediaCommonConfig = (PlayerResponse.PlayerConfig.MediaCommonConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer.INSTANCE, null);
            audioConfig = (PlayerResponse.PlayerConfig.AudioConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            mediaCommonConfig = null;
            PlayerResponse.PlayerConfig.AudioConfig audioConfig2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    mediaCommonConfig = (PlayerResponse.PlayerConfig.MediaCommonConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer.INSTANCE, mediaCommonConfig);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    audioConfig2 = (PlayerResponse.PlayerConfig.AudioConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE, audioConfig2);
                    i2 |= 2;
                }
            }
            audioConfig = audioConfig2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.PlayerConfig(i, mediaCommonConfig, audioConfig);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.PlayerConfig playerConfig = (PlayerResponse.PlayerConfig) obj;
        playerConfig.getClass();
        PlayerResponse.PlayerConfig.AudioConfig audioConfig = playerConfig.audioConfig;
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig = playerConfig.mediaCommonConfig;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || mediaCommonConfig != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer.INSTANCE, mediaCommonConfig);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || audioConfig != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE, audioConfig);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
