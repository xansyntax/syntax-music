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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content.ItemSectionRenderer.Content.ContinuationItemRenderer.ContinuationEndpoint", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("clickTrackingParams", true);
        pluginGeneratedSerialDescriptor.addElement("continuationCommand", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(StringSerializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand continuationCommand;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            continuationCommand = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand continuationCommand2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    continuationCommand2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE, continuationCommand2);
                    i2 |= 2;
                }
            }
            continuationCommand = continuationCommand2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint(i, str, continuationCommand);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint continuationEndpoint = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint) obj;
        continuationEndpoint.getClass();
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand continuationCommand = continuationEndpoint.continuationCommand;
        String str = continuationEndpoint.clickTrackingParams;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || continuationCommand != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE, continuationCommand);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
