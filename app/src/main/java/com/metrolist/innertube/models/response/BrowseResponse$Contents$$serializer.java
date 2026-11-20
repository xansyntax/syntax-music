package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.SectionListRenderer;
import com.metrolist.innertube.models.SectionListRenderer$$serializer;
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
public final /* synthetic */ class BrowseResponse$Contents$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Contents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Contents$$serializer browseResponse$Contents$$serializer = new BrowseResponse$Contents$$serializer();
        INSTANCE = browseResponse$Contents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Contents", browseResponse$Contents$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("singleColumnBrowseResultsRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("sectionListRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("twoColumnBrowseResultsRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Tabs$$serializer.INSTANCE), HexFormatKt.getNullable(SectionListRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Tabs tabs;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        SectionListRenderer sectionListRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            tabs = (Tabs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, null);
            sectionListRenderer = (SectionListRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SectionListRenderer$$serializer.INSTANCE, null);
            twoColumnBrowseResultsRenderer = (BrowseResponse.TwoColumnBrowseResultsRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            tabs = null;
            BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer2 = null;
            SectionListRenderer sectionListRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    tabs = (Tabs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, tabs);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    sectionListRenderer2 = (SectionListRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SectionListRenderer$$serializer.INSTANCE, sectionListRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    twoColumnBrowseResultsRenderer2 = (BrowseResponse.TwoColumnBrowseResultsRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE, twoColumnBrowseResultsRenderer2);
                    i2 |= 4;
                }
            }
            twoColumnBrowseResultsRenderer = twoColumnBrowseResultsRenderer2;
            sectionListRenderer = sectionListRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Contents(i, tabs, sectionListRenderer, twoColumnBrowseResultsRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Contents contents = (BrowseResponse.Contents) obj;
        contents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Tabs$$serializer.INSTANCE, contents.singleColumnBrowseResultsRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, SectionListRenderer$$serializer.INSTANCE, contents.sectionListRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE, contents.twoColumnBrowseResultsRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
