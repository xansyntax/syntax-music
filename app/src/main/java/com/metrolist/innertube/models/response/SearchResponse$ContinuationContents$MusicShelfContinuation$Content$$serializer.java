package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer$$serializer;
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
public final /* synthetic */ class SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer implements GeneratedSerializer {
    public static final SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer searchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer = new SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer();
        INSTANCE = searchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.SearchResponse.ContinuationContents.MusicShelfContinuation.Content", searchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveListItemRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{MusicResponsiveListItemRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            musicResponsiveListItemRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchResponse.ContinuationContents.MusicShelfContinuation.Content(i, musicResponsiveListItemRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchResponse.ContinuationContents.MusicShelfContinuation.Content content = (SearchResponse.ContinuationContents.MusicShelfContinuation.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, content.musicResponsiveListItemRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
