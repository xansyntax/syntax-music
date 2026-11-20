package com.metrolist.innertube.models;

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
public final /* synthetic */ class MusicCardShelfRenderer$Header$$serializer implements GeneratedSerializer {
    public static final MusicCardShelfRenderer$Header$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicCardShelfRenderer$Header$$serializer musicCardShelfRenderer$Header$$serializer = new MusicCardShelfRenderer$Header$$serializer();
        INSTANCE = musicCardShelfRenderer$Header$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicCardShelfRenderer.Header", musicCardShelfRenderer$Header$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicCardShelfHeaderBasicRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicCardShelfHeaderBasicRenderer = (MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            musicCardShelfHeaderBasicRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicCardShelfHeaderBasicRenderer = (MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE, musicCardShelfHeaderBasicRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicCardShelfRenderer.Header(i, musicCardShelfHeaderBasicRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicCardShelfRenderer.Header header = (MusicCardShelfRenderer.Header) obj;
        header.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE, header.musicCardShelfHeaderBasicRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
