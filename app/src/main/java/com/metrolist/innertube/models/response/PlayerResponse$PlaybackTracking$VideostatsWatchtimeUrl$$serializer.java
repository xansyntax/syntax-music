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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer playerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer = new PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer();
        INSTANCE = playerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.PlaybackTracking.VideostatsWatchtimeUrl", playerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("baseUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl(i, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl videostatsWatchtimeUrl = (PlayerResponse$PlaybackTracking.VideostatsWatchtimeUrl) obj;
        videostatsWatchtimeUrl.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, videostatsWatchtimeUrl.baseUrl);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
