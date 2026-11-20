package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer;
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
public final /* synthetic */ class NextResponse$Contents$$serializer implements GeneratedSerializer {
    public static final NextResponse$Contents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NextResponse$Contents$$serializer nextResponse$Contents$$serializer = new NextResponse$Contents$$serializer();
        INSTANCE = nextResponse$Contents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.NextResponse.Contents", nextResponse$Contents$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("singleColumnMusicWatchNextResultsRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("twoColumnWatchNextResults", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            singleColumnMusicWatchNextResultsRenderer = (NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE, null);
            youTubeDataPage$Contents$TwoColumnWatchNextResults = (YouTubeDataPage$Contents$TwoColumnWatchNextResults) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            singleColumnMusicWatchNextResultsRenderer = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    singleColumnMusicWatchNextResultsRenderer = (NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE, singleColumnMusicWatchNextResultsRenderer);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    youTubeDataPage$Contents$TwoColumnWatchNextResults2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer.INSTANCE, youTubeDataPage$Contents$TwoColumnWatchNextResults2);
                    i2 |= 2;
                }
            }
            youTubeDataPage$Contents$TwoColumnWatchNextResults = youTubeDataPage$Contents$TwoColumnWatchNextResults2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NextResponse.Contents(i, singleColumnMusicWatchNextResultsRenderer, youTubeDataPage$Contents$TwoColumnWatchNextResults);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NextResponse.Contents contents = (NextResponse.Contents) obj;
        contents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE, contents.singleColumnMusicWatchNextResultsRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer.INSTANCE, contents.twoColumnWatchNextResults);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
