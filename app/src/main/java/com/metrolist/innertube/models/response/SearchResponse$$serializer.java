package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class SearchResponse$$serializer implements GeneratedSerializer {
    public static final SearchResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchResponse$$serializer searchResponse$$serializer = new SearchResponse$$serializer();
        INSTANCE = searchResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.SearchResponse", searchResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("continuationContents", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(SearchResponse$Contents$$serializer.INSTANCE), HexFormatKt.getNullable(SearchResponse$ContinuationContents$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SearchResponse.Contents contents;
        SearchResponse.ContinuationContents continuationContents;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            contents = (SearchResponse.Contents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SearchResponse$Contents$$serializer.INSTANCE, null);
            continuationContents = (SearchResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SearchResponse$ContinuationContents$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            contents = null;
            SearchResponse.ContinuationContents continuationContents2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    contents = (SearchResponse.Contents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SearchResponse$Contents$$serializer.INSTANCE, contents);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    continuationContents2 = (SearchResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SearchResponse$ContinuationContents$$serializer.INSTANCE, continuationContents2);
                    i2 |= 2;
                }
            }
            continuationContents = continuationContents2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchResponse(i, contents, continuationContents);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchResponse searchResponse = (SearchResponse) obj;
        searchResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, SearchResponse$Contents$$serializer.INSTANCE, searchResponse.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, SearchResponse$ContinuationContents$$serializer.INSTANCE, searchResponse.continuationContents);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
