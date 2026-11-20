package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicMultiRowListItemRenderer$PlaybackProgress$$serializer implements GeneratedSerializer {
    public static final MusicMultiRowListItemRenderer$PlaybackProgress$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicMultiRowListItemRenderer$PlaybackProgress$$serializer musicMultiRowListItemRenderer$PlaybackProgress$$serializer = new MusicMultiRowListItemRenderer$PlaybackProgress$$serializer();
        INSTANCE = musicMultiRowListItemRenderer$PlaybackProgress$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicMultiRowListItemRenderer.PlaybackProgress", musicMultiRowListItemRenderer$PlaybackProgress$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("value", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(FloatSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Float f;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            f = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            f = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    f = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicMultiRowListItemRenderer.PlaybackProgress(i, f);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicMultiRowListItemRenderer.PlaybackProgress playbackProgress = (MusicMultiRowListItemRenderer.PlaybackProgress) obj;
        playbackProgress.getClass();
        Float f = playbackProgress.value;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || f != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
