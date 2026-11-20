package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.SearchSuggestionsSectionRenderer;
import com.metrolist.innertube.models.SearchSuggestionsSectionRenderer$$serializer;
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
public final /* synthetic */ class GetSearchSuggestionsResponse$Content$$serializer implements GeneratedSerializer {
    public static final GetSearchSuggestionsResponse$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetSearchSuggestionsResponse$Content$$serializer getSearchSuggestionsResponse$Content$$serializer = new GetSearchSuggestionsResponse$Content$$serializer();
        INSTANCE = getSearchSuggestionsResponse$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.GetSearchSuggestionsResponse.Content", getSearchSuggestionsResponse$Content$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("searchSuggestionsSectionRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SearchSuggestionsSectionRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SearchSuggestionsSectionRenderer searchSuggestionsSectionRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            searchSuggestionsSectionRenderer = (SearchSuggestionsSectionRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SearchSuggestionsSectionRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            searchSuggestionsSectionRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    searchSuggestionsSectionRenderer = (SearchSuggestionsSectionRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SearchSuggestionsSectionRenderer$$serializer.INSTANCE, searchSuggestionsSectionRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GetSearchSuggestionsResponse.Content(i, searchSuggestionsSectionRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GetSearchSuggestionsResponse.Content content = (GetSearchSuggestionsResponse.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, SearchSuggestionsSectionRenderer$$serializer.INSTANCE, content.searchSuggestionsSectionRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
