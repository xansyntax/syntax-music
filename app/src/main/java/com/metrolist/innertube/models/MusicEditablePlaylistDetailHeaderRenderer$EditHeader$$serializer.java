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
public final /* synthetic */ class MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer implements GeneratedSerializer {
    public static final MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer musicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer = new MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer();
        INSTANCE = musicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer.EditHeader", musicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicPlaylistEditHeaderRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicPlaylistEditHeaderRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicPlaylistEditHeaderRenderer musicPlaylistEditHeaderRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicPlaylistEditHeaderRenderer = (MusicPlaylistEditHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicPlaylistEditHeaderRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            musicPlaylistEditHeaderRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicPlaylistEditHeaderRenderer = (MusicPlaylistEditHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicPlaylistEditHeaderRenderer$$serializer.INSTANCE, musicPlaylistEditHeaderRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicEditablePlaylistDetailHeaderRenderer.EditHeader(i, musicPlaylistEditHeaderRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicEditablePlaylistDetailHeaderRenderer.EditHeader editHeader = (MusicEditablePlaylistDetailHeaderRenderer.EditHeader) obj;
        editHeader.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicPlaylistEditHeaderRenderer$$serializer.INSTANCE, editHeader.musicPlaylistEditHeaderRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
