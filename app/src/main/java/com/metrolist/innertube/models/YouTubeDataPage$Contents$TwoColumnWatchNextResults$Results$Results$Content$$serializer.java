package com.metrolist.innertube.models;

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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("videoPrimaryInfoRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("videoSecondaryInfoRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("itemSectionRenderer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer videoPrimaryInfoRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer itemSectionRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            videoPrimaryInfoRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer.INSTANCE, null);
            videoSecondaryInfoRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer.INSTANCE, null);
            itemSectionRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            videoPrimaryInfoRenderer = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer itemSectionRenderer2 = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    videoPrimaryInfoRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer.INSTANCE, videoPrimaryInfoRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    videoSecondaryInfoRenderer2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer.INSTANCE, videoSecondaryInfoRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    itemSectionRenderer2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$$serializer.INSTANCE, itemSectionRenderer2);
                    i2 |= 4;
                }
            }
            itemSectionRenderer = itemSectionRenderer2;
            videoSecondaryInfoRenderer = videoSecondaryInfoRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content(i, videoPrimaryInfoRenderer, videoSecondaryInfoRenderer, itemSectionRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content content = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content) obj;
        content.getClass();
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer itemSectionRenderer = content.itemSectionRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer = content.videoSecondaryInfoRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer videoPrimaryInfoRenderer = content.videoPrimaryInfoRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || videoPrimaryInfoRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer.INSTANCE, videoPrimaryInfoRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || videoSecondaryInfoRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer.INSTANCE, videoSecondaryInfoRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || itemSectionRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$$serializer.INSTANCE, itemSectionRenderer);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
