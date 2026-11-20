package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class SearchResponse$ContinuationContents$$serializer implements GeneratedSerializer {
    public static final SearchResponse$ContinuationContents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchResponse$ContinuationContents$$serializer searchResponse$ContinuationContents$$serializer = new SearchResponse$ContinuationContents$$serializer();
        INSTANCE = searchResponse$ContinuationContents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.SearchResponse.ContinuationContents", searchResponse$ContinuationContents$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicShelfContinuation", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SearchResponse.ContinuationContents.MusicShelfContinuation musicShelfContinuation;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicShelfContinuation = (SearchResponse.ContinuationContents.MusicShelfContinuation) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            musicShelfContinuation = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicShelfContinuation = (SearchResponse.ContinuationContents.MusicShelfContinuation) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE, musicShelfContinuation);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchResponse.ContinuationContents(i, musicShelfContinuation);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchResponse.ContinuationContents continuationContents = (SearchResponse.ContinuationContents) obj;
        continuationContents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE, continuationContents.musicShelfContinuation);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
