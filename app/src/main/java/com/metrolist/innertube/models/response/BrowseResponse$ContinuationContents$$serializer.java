package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.MusicShelfRenderer;
import com.metrolist.innertube.models.MusicShelfRenderer$$serializer;
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
public final /* synthetic */ class BrowseResponse$ContinuationContents$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$ContinuationContents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$ContinuationContents$$serializer browseResponse$ContinuationContents$$serializer = new BrowseResponse$ContinuationContents$$serializer();
        INSTANCE = browseResponse$ContinuationContents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.ContinuationContents", browseResponse$ContinuationContents$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("sectionListContinuation", false);
        pluginGeneratedSerialDescriptor.addElement("musicPlaylistShelfContinuation", false);
        pluginGeneratedSerialDescriptor.addElement("gridContinuation", false);
        pluginGeneratedSerialDescriptor.addElement("musicShelfContinuation", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE), HexFormatKt.getNullable(MusicShelfRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation;
        MusicShelfRenderer musicShelfRenderer;
        BrowseResponse.ContinuationContents.GridContinuation gridContinuation;
        BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            sectionListContinuation = (BrowseResponse.ContinuationContents.SectionListContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE, null);
            BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation2 = (BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE, null);
            BrowseResponse.ContinuationContents.GridContinuation gridContinuation2 = (BrowseResponse.ContinuationContents.GridContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE, null);
            musicShelfRenderer = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicShelfRenderer$$serializer.INSTANCE, null);
            gridContinuation = gridContinuation2;
            musicPlaylistShelfContinuation = musicPlaylistShelfContinuation2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            sectionListContinuation = null;
            MusicShelfRenderer musicShelfRenderer2 = null;
            BrowseResponse.ContinuationContents.GridContinuation gridContinuation3 = null;
            BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    sectionListContinuation = (BrowseResponse.ContinuationContents.SectionListContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE, sectionListContinuation);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicPlaylistShelfContinuation3 = (BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE, musicPlaylistShelfContinuation3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    gridContinuation3 = (BrowseResponse.ContinuationContents.GridContinuation) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE, gridContinuation3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicShelfRenderer2 = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicShelfRenderer$$serializer.INSTANCE, musicShelfRenderer2);
                    i2 |= 8;
                }
            }
            musicShelfRenderer = musicShelfRenderer2;
            gridContinuation = gridContinuation3;
            musicPlaylistShelfContinuation = musicPlaylistShelfContinuation3;
            i = i2;
        }
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation2 = sectionListContinuation;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.ContinuationContents(i, sectionListContinuation2, musicPlaylistShelfContinuation, gridContinuation, musicShelfRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.ContinuationContents continuationContents = (BrowseResponse.ContinuationContents) obj;
        continuationContents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE, continuationContents.sectionListContinuation);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE, continuationContents.musicPlaylistShelfContinuation);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE, continuationContents.gridContinuation);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, MusicShelfRenderer$$serializer.INSTANCE, continuationContents.musicShelfContinuation);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
