package com.metrolist.innertubex.models.body;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class PlayerBody$PlaybackContext$$serializer implements GeneratedSerializer {
    public static final PlayerBody$PlaybackContext$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerBody$PlaybackContext$$serializer playerBody$PlaybackContext$$serializer = new PlayerBody$PlaybackContext$$serializer();
        INSTANCE = playerBody$PlaybackContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.PlayerBody.PlaybackContext", playerBody$PlaybackContext$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("contentPlaybackContext", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlayerBody.PlaybackContext.ContentPlaybackContext contentPlaybackContext;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            contentPlaybackContext = (PlayerBody.PlaybackContext.ContentPlaybackContext) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            contentPlaybackContext = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    contentPlaybackContext = (PlayerBody.PlaybackContext.ContentPlaybackContext) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer.INSTANCE, contentPlaybackContext);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerBody.PlaybackContext(i, contentPlaybackContext);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerBody.PlaybackContext playbackContext = (PlayerBody.PlaybackContext) obj;
        playbackContext.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer.INSTANCE, playbackContext.contentPlaybackContext);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
