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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content.VideoSecondaryInfoRenderer", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("owner", true);
        pluginGeneratedSerialDescriptor.addElement("attributedDescription", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription attributedDescription;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            owner = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$$serializer.INSTANCE, null);
            attributedDescription = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            owner = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription attributedDescription2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    owner = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$$serializer.INSTANCE, owner);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    attributedDescription2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$$serializer.INSTANCE, attributedDescription2);
                    i2 |= 2;
                }
            }
            attributedDescription = attributedDescription2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer(i, owner, attributedDescription);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer) obj;
        videoSecondaryInfoRenderer.getClass();
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription attributedDescription = videoSecondaryInfoRenderer.attributedDescription;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner = videoSecondaryInfoRenderer.owner;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || owner != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$$serializer.INSTANCE, owner);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || attributedDescription != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$$serializer.INSTANCE, attributedDescription);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
