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
public final /* synthetic */ class SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer implements GeneratedSerializer {
    public static final SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer searchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer = new SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer();
        INSTANCE = searchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SearchSuggestionsSectionRenderer.Content.SearchSuggestionRenderer", searchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("suggestion", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Runs$$serializer.INSTANCE, NavigationEndpoint$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        NavigationEndpoint navigationEndpoint;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            NavigationEndpoint navigationEndpoint2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 2;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchSuggestionsSectionRenderer.Content.SearchSuggestionRenderer(i, runs, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchSuggestionsSectionRenderer.Content.SearchSuggestionRenderer searchSuggestionRenderer = (SearchSuggestionsSectionRenderer.Content.SearchSuggestionRenderer) obj;
        searchSuggestionRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, searchSuggestionRenderer.suggestion);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, searchSuggestionRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
