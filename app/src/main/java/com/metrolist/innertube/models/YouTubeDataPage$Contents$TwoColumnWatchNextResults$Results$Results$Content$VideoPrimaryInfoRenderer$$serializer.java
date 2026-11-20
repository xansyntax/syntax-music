package com.metrolist.innertube.models;

import io.ktor.http.LinkHeader;
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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content.VideoPrimaryInfoRenderer", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("viewCount", true);
        pluginGeneratedSerialDescriptor.addElement("dateText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title title;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText dateText;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.ViewCount viewCount;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            title = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$$serializer.INSTANCE, null);
            viewCount = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.ViewCount) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$$serializer.INSTANCE, null);
            dateText = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            title = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText dateText2 = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.ViewCount viewCount2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    title = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$$serializer.INSTANCE, title);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    viewCount2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.ViewCount) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$$serializer.INSTANCE, viewCount2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    dateText2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$$serializer.INSTANCE, dateText2);
                    i2 |= 4;
                }
            }
            dateText = dateText2;
            viewCount = viewCount2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer(i, title, viewCount, dateText);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer videoPrimaryInfoRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer) obj;
        videoPrimaryInfoRenderer.getClass();
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText dateText = videoPrimaryInfoRenderer.dateText;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.ViewCount viewCount = videoPrimaryInfoRenderer.viewCount;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title title = videoPrimaryInfoRenderer.title;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || title != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$$serializer.INSTANCE, title);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || viewCount != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$$serializer.INSTANCE, viewCount);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || dateText != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$$serializer.INSTANCE, dateText);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
