package com.metrolist.innertube.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer browseResponse$TwoColumnBrowseResultsRenderer$$serializer = new BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer();
        INSTANCE = browseResponse$TwoColumnBrowseResultsRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.TwoColumnBrowseResultsRenderer", browseResponse$TwoColumnBrowseResultsRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("tabs", false);
        pluginGeneratedSerialDescriptor.addElement("secondaryContents", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable((KSerializer) BrowseResponse.TwoColumnBrowseResultsRenderer.$childSerializers[0].getValue()), HexFormatKt.getNullable(BrowseResponse$SecondaryContents$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        BrowseResponse.SecondaryContents secondaryContents;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.TwoColumnBrowseResultsRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            secondaryContents = (BrowseResponse.SecondaryContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$SecondaryContents$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            BrowseResponse.SecondaryContents secondaryContents2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    secondaryContents2 = (BrowseResponse.SecondaryContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$SecondaryContents$$serializer.INSTANCE, secondaryContents2);
                    i2 |= 2;
                }
            }
            list = list2;
            secondaryContents = secondaryContents2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.TwoColumnBrowseResultsRenderer(i, list, secondaryContents);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer = (BrowseResponse.TwoColumnBrowseResultsRenderer) obj;
        twoColumnBrowseResultsRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) BrowseResponse.TwoColumnBrowseResultsRenderer.$childSerializers[0].getValue(), twoColumnBrowseResultsRenderer.tabs);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$SecondaryContents$$serializer.INSTANCE, twoColumnBrowseResultsRenderer.secondaryContents);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
