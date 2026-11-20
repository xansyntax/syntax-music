package com.metrolist.innertube.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
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
public final /* synthetic */ class BrowseResponse$ContinuationContents$SectionListContinuation$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$ContinuationContents$SectionListContinuation$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$ContinuationContents$SectionListContinuation$$serializer browseResponse$ContinuationContents$SectionListContinuation$$serializer = new BrowseResponse$ContinuationContents$SectionListContinuation$$serializer();
        INSTANCE = browseResponse$ContinuationContents$SectionListContinuation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.ContinuationContents.SectionListContinuation", browseResponse$ContinuationContents$SectionListContinuation$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("contents", true);
        pluginGeneratedSerialDescriptor.addElement("continuations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = BrowseResponse.ContinuationContents.SectionListContinuation.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        List list2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.ContinuationContents.SectionListContinuation.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            List list4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list4);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                    i2 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.ContinuationContents.SectionListContinuation(i, list2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation = (BrowseResponse.ContinuationContents.SectionListContinuation) obj;
        sectionListContinuation.getClass();
        List list = sectionListContinuation.contents;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.ContinuationContents.SectionListContinuation.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), list);
        }
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), sectionListContinuation.continuations);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
