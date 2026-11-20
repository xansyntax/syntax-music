package com.metrolist.innertubex.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$PlaybackTracking$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlaybackTracking$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlaybackTracking$$serializer playerResponse$PlaybackTracking$$serializer = new PlayerResponse$PlaybackTracking$$serializer();
        INSTANCE = playerResponse$PlaybackTracking$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.PlaybackTracking", playerResponse$PlaybackTracking$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("videostatsPlaybackUrl", true);
        pluginGeneratedSerialDescriptor.addElement("videostatsWatchtimeUrl", true);
        pluginGeneratedSerialDescriptor.addElement("atrUrl", true);
        pluginGeneratedSerialDescriptor.addElement("videostatsScheduledFlushWalltimeSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("videostatsDefaultFlushIntervalSeconds", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = PlayerResponse.PlaybackTracking.$childSerializers;
        PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer playerResponse$PlaybackTracking$VideostatsUrl$$serializer = PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(playerResponse$PlaybackTracking$VideostatsUrl$$serializer), HexFormatKt.getNullable(playerResponse$PlaybackTracking$VideostatsUrl$$serializer), HexFormatKt.getNullable(playerResponse$PlaybackTracking$VideostatsUrl$$serializer), HexFormatKt.getNullable((KSerializer) lazyArr[3].getValue()), HexFormatKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl;
        Integer num;
        int i;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl2;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlayerResponse.PlaybackTracking.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer playerResponse$PlaybackTracking$VideostatsUrl$$serializer = PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE;
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl4 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, playerResponse$PlaybackTracking$VideostatsUrl$$serializer, null);
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl5 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, playerResponse$PlaybackTracking$VideostatsUrl$$serializer, null);
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl6 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, playerResponse$PlaybackTracking$VideostatsUrl$$serializer, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            videostatsUrl = videostatsUrl6;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, null);
            i = 31;
            videostatsUrl2 = videostatsUrl5;
            videostatsUrl3 = videostatsUrl4;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl7 = null;
            Integer num2 = null;
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl8 = null;
            PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl9 = null;
            while (z) {
                obj = obj;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    videostatsUrl9 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl9);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    videostatsUrl8 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl8);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    videostatsUrl7 = (PlayerResponse.PlaybackTracking.VideostatsUrl) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl7);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num2);
                    i2 |= 16;
                }
            }
            list = list2;
            videostatsUrl = videostatsUrl7;
            num = num2;
            i = i2;
            videostatsUrl2 = videostatsUrl8;
            videostatsUrl3 = videostatsUrl9;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.PlaybackTracking(i, videostatsUrl3, videostatsUrl2, videostatsUrl, list, num);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.PlaybackTracking playbackTracking = (PlayerResponse.PlaybackTracking) obj;
        playbackTracking.getClass();
        Integer num = playbackTracking.videostatsDefaultFlushIntervalSeconds;
        List list = playbackTracking.videostatsScheduledFlushWalltimeSeconds;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl = playbackTracking.atrUrl;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl2 = playbackTracking.videostatsWatchtimeUrl;
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl3 = playbackTracking.videostatsPlaybackUrl;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlayerResponse.PlaybackTracking.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || videostatsUrl3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || videostatsUrl2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || videostatsUrl != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE, videostatsUrl);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
