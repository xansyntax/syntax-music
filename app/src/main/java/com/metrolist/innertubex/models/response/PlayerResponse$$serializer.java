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
public final /* synthetic */ class PlayerResponse$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$$serializer playerResponse$$serializer = new PlayerResponse$$serializer();
        INSTANCE = playerResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse", playerResponse$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("playabilityStatus", false);
        pluginGeneratedSerialDescriptor.addElement("streamingData", true);
        pluginGeneratedSerialDescriptor.addElement("videoDetails", true);
        pluginGeneratedSerialDescriptor.addElement("playbackTracking", true);
        pluginGeneratedSerialDescriptor.addElement("playerConfig", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{PlayerResponse$PlayabilityStatus$$serializer.INSTANCE, HexFormatKt.getNullable(PlayerResponse$StreamingData$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$VideoDetails$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$PlaybackTracking$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$PlayerConfig$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlayerResponse.PlayabilityStatus playabilityStatus;
        PlayerResponse.PlaybackTracking playbackTracking;
        PlayerResponse.PlayerConfig playerConfig;
        PlayerResponse.VideoDetails videoDetails;
        PlayerResponse.StreamingData streamingData;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            playabilityStatus = (PlayerResponse.PlayabilityStatus) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlayerResponse$PlayabilityStatus$$serializer.INSTANCE, null);
            PlayerResponse.StreamingData streamingData2 = (PlayerResponse.StreamingData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$StreamingData$$serializer.INSTANCE, null);
            PlayerResponse.VideoDetails videoDetails2 = (PlayerResponse.VideoDetails) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$VideoDetails$$serializer.INSTANCE, null);
            playbackTracking = (PlayerResponse.PlaybackTracking) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PlayerResponse$PlaybackTracking$$serializer.INSTANCE, null);
            playerConfig = (PlayerResponse.PlayerConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, PlayerResponse$PlayerConfig$$serializer.INSTANCE, null);
            videoDetails = videoDetails2;
            streamingData = streamingData2;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            playabilityStatus = null;
            PlayerResponse.PlaybackTracking playbackTracking2 = null;
            PlayerResponse.PlayerConfig playerConfig2 = null;
            PlayerResponse.VideoDetails videoDetails3 = null;
            PlayerResponse.StreamingData streamingData3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                obj = obj;
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    playabilityStatus = (PlayerResponse.PlayabilityStatus) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlayerResponse$PlayabilityStatus$$serializer.INSTANCE, playabilityStatus);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    streamingData3 = (PlayerResponse.StreamingData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$StreamingData$$serializer.INSTANCE, streamingData3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    videoDetails3 = (PlayerResponse.VideoDetails) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$VideoDetails$$serializer.INSTANCE, videoDetails3);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    playbackTracking2 = (PlayerResponse.PlaybackTracking) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PlayerResponse$PlaybackTracking$$serializer.INSTANCE, playbackTracking2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    playerConfig2 = (PlayerResponse.PlayerConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, PlayerResponse$PlayerConfig$$serializer.INSTANCE, playerConfig2);
                    i2 |= 16;
                }
            }
            playbackTracking = playbackTracking2;
            playerConfig = playerConfig2;
            videoDetails = videoDetails3;
            streamingData = streamingData3;
            i = i2;
        }
        PlayerResponse.PlayabilityStatus playabilityStatus2 = playabilityStatus;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse(i, playabilityStatus2, streamingData, videoDetails, playbackTracking, playerConfig);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse playerResponse = (PlayerResponse) obj;
        playerResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        PlayerResponse$PlayabilityStatus$$serializer playerResponse$PlayabilityStatus$$serializer = PlayerResponse$PlayabilityStatus$$serializer.INSTANCE;
        PlayerResponse.PlayabilityStatus playabilityStatus = playerResponse.playabilityStatus;
        PlayerResponse.PlayerConfig playerConfig = playerResponse.playerConfig;
        PlayerResponse.PlaybackTracking playbackTracking = playerResponse.playbackTracking;
        PlayerResponse.VideoDetails videoDetails = playerResponse.videoDetails;
        PlayerResponse.StreamingData streamingData = playerResponse.streamingData;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, playerResponse$PlayabilityStatus$$serializer, playabilityStatus);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || streamingData != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$StreamingData$$serializer.INSTANCE, streamingData);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || videoDetails != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$VideoDetails$$serializer.INSTANCE, videoDetails);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || playbackTracking != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, PlayerResponse$PlaybackTracking$$serializer.INSTANCE, playbackTracking);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || playerConfig != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, PlayerResponse$PlayerConfig$$serializer.INSTANCE, playerConfig);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
