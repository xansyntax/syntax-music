package com.metrolist.innertubex.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer playerResponse$PlaybackTracking$VideostatsUrl$$serializer = new PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer();
        INSTANCE = playerResponse$PlaybackTracking$VideostatsUrl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.PlaybackTracking.VideostatsUrl", playerResponse$PlaybackTracking$VideostatsUrl$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("baseUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
        } else {
            String strDecodeStringElement2 = null;
            boolean z = true;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 = 1;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.PlaybackTracking.VideostatsUrl(i, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.PlaybackTracking.VideostatsUrl videostatsUrl = (PlayerResponse.PlaybackTracking.VideostatsUrl) obj;
        videostatsUrl.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, videostatsUrl.baseUrl);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
