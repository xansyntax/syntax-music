package com.metrolist.innertube.models;

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
public final /* synthetic */ class MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer implements GeneratedSerializer {
    public static final MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer musicEditablePlaylistDetailHeaderRenderer$Header$$serializer = new MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer();
        INSTANCE = musicEditablePlaylistDetailHeaderRenderer$Header$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer.Header", musicEditablePlaylistDetailHeaderRenderer$Header$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("musicDetailHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveHeaderRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicDetailHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveHeaderRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicDetailHeaderRenderer = (MusicDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicDetailHeaderRenderer$$serializer.INSTANCE, null);
            musicResponsiveHeaderRenderer = (MusicResponsiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            musicDetailHeaderRenderer = null;
            MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicDetailHeaderRenderer = (MusicDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicDetailHeaderRenderer$$serializer.INSTANCE, musicDetailHeaderRenderer);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicResponsiveHeaderRenderer2 = (MusicResponsiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, musicResponsiveHeaderRenderer2);
                    i2 |= 2;
                }
            }
            musicResponsiveHeaderRenderer = musicResponsiveHeaderRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicEditablePlaylistDetailHeaderRenderer.Header(i, musicDetailHeaderRenderer, musicResponsiveHeaderRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicEditablePlaylistDetailHeaderRenderer.Header header = (MusicEditablePlaylistDetailHeaderRenderer.Header) obj;
        header.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicDetailHeaderRenderer$$serializer.INSTANCE, header.musicDetailHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, header.musicResponsiveHeaderRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
