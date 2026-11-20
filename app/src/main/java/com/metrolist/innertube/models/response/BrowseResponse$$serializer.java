package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.ResponseContext;
import com.metrolist.innertube.models.ResponseContext$$serializer;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.ThumbnailRenderer$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class BrowseResponse$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$$serializer browseResponse$$serializer = new BrowseResponse$$serializer();
        INSTANCE = browseResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse", browseResponse$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("continuationContents", false);
        pluginGeneratedSerialDescriptor.addElement("onResponseReceivedActions", false);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("microformat", false);
        pluginGeneratedSerialDescriptor.addElement("responseContext", false);
        pluginGeneratedSerialDescriptor.addElement("background", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(BrowseResponse$Contents$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$ContinuationContents$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) BrowseResponse.$childSerializers[2].getValue()), HexFormatKt.getNullable(BrowseResponse$Header$$serializer.INSTANCE), HexFormatKt.getNullable(BrowseResponse$Microformat$$serializer.INSTANCE), ResponseContext$$serializer.INSTANCE, HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        BrowseResponse.ContinuationContents continuationContents;
        BrowseResponse.Microformat microformat;
        BrowseResponse.Contents contents;
        ThumbnailRenderer thumbnailRenderer;
        ResponseContext responseContext;
        BrowseResponse.Header header;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.$childSerializers;
        int i2 = 6;
        boolean z = true;
        BrowseResponse.Microformat microformat2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            BrowseResponse.Contents contents2 = (BrowseResponse.Contents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Contents$$serializer.INSTANCE, null);
            BrowseResponse.ContinuationContents continuationContents2 = (BrowseResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            BrowseResponse.Header header2 = (BrowseResponse.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$$serializer.INSTANCE, null);
            BrowseResponse.Microformat microformat3 = (BrowseResponse.Microformat) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Microformat$$serializer.INSTANCE, null);
            ResponseContext responseContext2 = (ResponseContext) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, ResponseContext$$serializer.INSTANCE, null);
            list = list2;
            contents = contents2;
            thumbnailRenderer = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ThumbnailRenderer$$serializer.INSTANCE, null);
            responseContext = responseContext2;
            header = header2;
            microformat = microformat3;
            i = 127;
            continuationContents = continuationContents2;
        } else {
            boolean z2 = true;
            int i3 = 0;
            List list3 = null;
            BrowseResponse.ContinuationContents continuationContents3 = null;
            BrowseResponse.Contents contents3 = null;
            ThumbnailRenderer thumbnailRenderer2 = null;
            ResponseContext responseContext3 = null;
            BrowseResponse.Header header3 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i2 = 6;
                        break;
                    case 0:
                        contents3 = (BrowseResponse.Contents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Contents$$serializer.INSTANCE, contents3);
                        i3 |= 1;
                        i2 = 6;
                        z = true;
                        break;
                    case 1:
                        continuationContents3 = (BrowseResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$$serializer.INSTANCE, continuationContents3);
                        i3 |= 2;
                        z = true;
                        i2 = 6;
                        break;
                    case 2:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list3);
                        i3 |= 4;
                        z = true;
                        break;
                    case 3:
                        header3 = (BrowseResponse.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$$serializer.INSTANCE, header3);
                        i3 |= 8;
                        z = true;
                        break;
                    case 4:
                        microformat2 = (BrowseResponse.Microformat) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Microformat$$serializer.INSTANCE, microformat2);
                        i3 |= 16;
                        z = true;
                        break;
                    case 5:
                        responseContext3 = (ResponseContext) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, ResponseContext$$serializer.INSTANCE, responseContext3);
                        i3 |= 32;
                        z = true;
                        break;
                    case 6:
                        thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer2);
                        i3 |= 64;
                        z = true;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            continuationContents = continuationContents3;
            microformat = microformat2;
            contents = contents3;
            thumbnailRenderer = thumbnailRenderer2;
            responseContext = responseContext3;
            header = header3;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse(i, contents, continuationContents, list, header, microformat, responseContext, thumbnailRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse browseResponse = (BrowseResponse) obj;
        browseResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Contents$$serializer.INSTANCE, browseResponse.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, BrowseResponse$ContinuationContents$$serializer.INSTANCE, browseResponse.continuationContents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), browseResponse.onResponseReceivedActions);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, BrowseResponse$Header$$serializer.INSTANCE, browseResponse.header);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, BrowseResponse$Microformat$$serializer.INSTANCE, browseResponse.microformat);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 5, ResponseContext$$serializer.INSTANCE, browseResponse.responseContext);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, ThumbnailRenderer$$serializer.INSTANCE, browseResponse.background);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
