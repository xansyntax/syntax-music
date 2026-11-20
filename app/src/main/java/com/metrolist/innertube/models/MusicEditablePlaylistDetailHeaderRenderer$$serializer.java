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
public final /* synthetic */ class MusicEditablePlaylistDetailHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final MusicEditablePlaylistDetailHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicEditablePlaylistDetailHeaderRenderer$$serializer musicEditablePlaylistDetailHeaderRenderer$$serializer = new MusicEditablePlaylistDetailHeaderRenderer$$serializer();
        INSTANCE = musicEditablePlaylistDetailHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer", musicEditablePlaylistDetailHeaderRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("editHeader", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE, MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicEditablePlaylistDetailHeaderRenderer.Header header;
        MusicEditablePlaylistDetailHeaderRenderer.EditHeader editHeader;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            header = (MusicEditablePlaylistDetailHeaderRenderer.Header) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE, null);
            editHeader = (MusicEditablePlaylistDetailHeaderRenderer.EditHeader) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            header = null;
            MusicEditablePlaylistDetailHeaderRenderer.EditHeader editHeader2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    header = (MusicEditablePlaylistDetailHeaderRenderer.Header) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE, header);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    editHeader2 = (MusicEditablePlaylistDetailHeaderRenderer.EditHeader) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE, editHeader2);
                    i2 |= 2;
                }
            }
            editHeader = editHeader2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicEditablePlaylistDetailHeaderRenderer(i, header, editHeader);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer = (MusicEditablePlaylistDetailHeaderRenderer) obj;
        musicEditablePlaylistDetailHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE, musicEditablePlaylistDetailHeaderRenderer.header);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE, musicEditablePlaylistDetailHeaderRenderer.editHeader);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
