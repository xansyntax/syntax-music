package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.MusicDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicDetailHeaderRenderer$$serializer;
import com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer$$serializer;
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
public final /* synthetic */ class BrowseResponse$Header$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$$serializer browseResponse$Header$$serializer = new BrowseResponse$Header$$serializer();
        INSTANCE = browseResponse$Header$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header", browseResponse$Header$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("musicImmersiveHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicDetailHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicEditablePlaylistDetailHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicVisualHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicHeaderRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicDetailHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicImmersiveHeaderRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE, null);
            MusicDetailHeaderRenderer musicDetailHeaderRenderer2 = (MusicDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicDetailHeaderRenderer$$serializer.INSTANCE, null);
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer2 = (MusicEditablePlaylistDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, null);
            musicVisualHeaderRenderer = (BrowseResponse.Header.MusicVisualHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE, null);
            musicHeaderRenderer = (BrowseResponse.Header.MusicHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE, null);
            musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer2;
            musicDetailHeaderRenderer = musicDetailHeaderRenderer2;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            musicImmersiveHeaderRenderer = null;
            BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer2 = null;
            BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer2 = null;
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer3 = null;
            MusicDetailHeaderRenderer musicDetailHeaderRenderer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                obj = obj;
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicImmersiveHeaderRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE, musicImmersiveHeaderRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicDetailHeaderRenderer3 = (MusicDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicDetailHeaderRenderer$$serializer.INSTANCE, musicDetailHeaderRenderer3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    musicEditablePlaylistDetailHeaderRenderer3 = (MusicEditablePlaylistDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, musicEditablePlaylistDetailHeaderRenderer3);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    musicVisualHeaderRenderer2 = (BrowseResponse.Header.MusicVisualHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE, musicVisualHeaderRenderer2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    musicHeaderRenderer2 = (BrowseResponse.Header.MusicHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE, musicHeaderRenderer2);
                    i2 |= 16;
                }
            }
            musicVisualHeaderRenderer = musicVisualHeaderRenderer2;
            musicHeaderRenderer = musicHeaderRenderer2;
            musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer3;
            musicDetailHeaderRenderer = musicDetailHeaderRenderer3;
            i = i2;
        }
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer2 = musicImmersiveHeaderRenderer;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header(i, musicImmersiveHeaderRenderer2, musicDetailHeaderRenderer, musicEditablePlaylistDetailHeaderRenderer, musicVisualHeaderRenderer, musicHeaderRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header header = (BrowseResponse.Header) obj;
        header.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE, header.musicImmersiveHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicDetailHeaderRenderer$$serializer.INSTANCE, header.musicDetailHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, header.musicEditablePlaylistDetailHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE, header.musicVisualHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE, header.musicHeaderRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
