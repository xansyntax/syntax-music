package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class PlayerResponse$PlaybackTracking$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlaybackTracking$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlaybackTracking$$serializer playerResponse$PlaybackTracking$$serializer = new PlayerResponse$PlaybackTracking$$serializer();
        INSTANCE = playerResponse$PlaybackTracking$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.PlaybackTracking", playerResponse$PlaybackTracking$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("videostatsPlaybackUrl", false);
        pluginGeneratedSerialDescriptor.addElement("videostatsWatchtimeUrl", false);
        pluginGeneratedSerialDescriptor.addElement("atrUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE), HexFormatKt.getNullable(PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl videostatsPlaybackUrl;
        PlayerResponse$PlaybackTracking.AtrUrl atrUrl;
        PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl videostatsWatchtimeUrl;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            videostatsPlaybackUrl = (PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE, null);
            videostatsWatchtimeUrl = (PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE, null);
            atrUrl = (PlayerResponse$PlaybackTracking.AtrUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            videostatsPlaybackUrl = null;
            PlayerResponse$PlaybackTracking.AtrUrl atrUrl2 = null;
            PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl videostatsWatchtimeUrl2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    videostatsPlaybackUrl = (PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE, videostatsPlaybackUrl);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    videostatsWatchtimeUrl2 = (PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE, videostatsWatchtimeUrl2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    atrUrl2 = (PlayerResponse$PlaybackTracking.AtrUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE, atrUrl2);
                    i2 |= 4;
                }
            }
            atrUrl = atrUrl2;
            videostatsWatchtimeUrl = videostatsWatchtimeUrl2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$PlaybackTracking(i, videostatsPlaybackUrl, videostatsWatchtimeUrl, atrUrl);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking = (PlayerResponse$PlaybackTracking) obj;
        playerResponse$PlaybackTracking.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE, playerResponse$PlaybackTracking.videostatsPlaybackUrl);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE, playerResponse$PlaybackTracking.videostatsWatchtimeUrl);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE, playerResponse$PlaybackTracking.atrUrl);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
