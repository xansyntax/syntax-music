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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults", youTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("results", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results results;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            results = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            results = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    results = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$$serializer.INSTANCE, results);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults(i, results);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults = (YouTubeDataPage$Contents$TwoColumnWatchNextResults) obj;
        youTubeDataPage$Contents$TwoColumnWatchNextResults.getClass();
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results results = youTubeDataPage$Contents$TwoColumnWatchNextResults.results;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || results != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$$serializer.INSTANCE, results);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
