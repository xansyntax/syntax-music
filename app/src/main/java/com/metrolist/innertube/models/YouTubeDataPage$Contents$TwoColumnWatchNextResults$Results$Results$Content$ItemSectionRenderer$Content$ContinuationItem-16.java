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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content.ItemSectionRenderer.Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("token", true);
        pluginGeneratedSerialDescriptor.addElement("request", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            String str3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str);
                    i2 |= 2;
                }
            }
            i = i2;
            str2 = str3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand(i, str2, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand continuationCommand = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.C0003Content.ContinuationItemRenderer.ContinuationEndpoint.ContinuationCommand) obj;
        continuationCommand.getClass();
        String str = continuationCommand.request;
        String str2 = continuationCommand.token;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
