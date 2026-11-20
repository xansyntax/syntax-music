package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Tabs;
import com.metrolist.innertube.models.Tabs$$serializer;
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
public final /* synthetic */ class SearchResponse$Contents$$serializer implements GeneratedSerializer {
    public static final SearchResponse$Contents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchResponse$Contents$$serializer searchResponse$Contents$$serializer = new SearchResponse$Contents$$serializer();
        INSTANCE = searchResponse$Contents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.SearchResponse.Contents", searchResponse$Contents$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("tabbedSearchResultsRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Tabs$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Tabs tabs;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            tabs = (Tabs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            tabs = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    tabs = (Tabs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, tabs);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchResponse.Contents(i, tabs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchResponse.Contents contents = (SearchResponse.Contents) obj;
        contents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, contents.tabbedSearchResultsRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
