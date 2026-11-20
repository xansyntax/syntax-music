package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.NavigationEndpoint$$serializer;
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
public final /* synthetic */ class NextResponse$$serializer implements GeneratedSerializer {
    public static final NextResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NextResponse$$serializer nextResponse$$serializer = new NextResponse$$serializer();
        INSTANCE = nextResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.NextResponse", nextResponse$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("continuationContents", false);
        pluginGeneratedSerialDescriptor.addElement("currentVideoEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{NextResponse$Contents$$serializer.INSTANCE, HexFormatKt.getNullable(NextResponse$ContinuationContents$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NextResponse.Contents contents;
        NavigationEndpoint navigationEndpoint;
        NextResponse.ContinuationContents continuationContents;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            contents = (NextResponse.Contents) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, NextResponse$Contents$$serializer.INSTANCE, null);
            continuationContents = (NextResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NextResponse$ContinuationContents$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            contents = null;
            NavigationEndpoint navigationEndpoint2 = null;
            NextResponse.ContinuationContents continuationContents2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    contents = (NextResponse.Contents) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, NextResponse$Contents$$serializer.INSTANCE, contents);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    continuationContents2 = (NextResponse.ContinuationContents) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NextResponse$ContinuationContents$$serializer.INSTANCE, continuationContents2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 4;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            continuationContents = continuationContents2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NextResponse(i, contents, continuationContents, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NextResponse nextResponse = (NextResponse) obj;
        nextResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, NextResponse$Contents$$serializer.INSTANCE, nextResponse.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, NextResponse$ContinuationContents$$serializer.INSTANCE, nextResponse.continuationContents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, nextResponse.currentVideoEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
