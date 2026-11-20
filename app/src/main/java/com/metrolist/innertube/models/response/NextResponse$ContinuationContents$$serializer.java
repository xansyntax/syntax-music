package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.PlaylistPanelRenderer;
import com.metrolist.innertube.models.PlaylistPanelRenderer$$serializer;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class NextResponse$ContinuationContents$$serializer implements GeneratedSerializer {
    public static final NextResponse$ContinuationContents$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NextResponse$ContinuationContents$$serializer nextResponse$ContinuationContents$$serializer = new NextResponse$ContinuationContents$$serializer();
        INSTANCE = nextResponse$ContinuationContents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.NextResponse.ContinuationContents", nextResponse$ContinuationContents$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("playlistPanelContinuation", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{PlaylistPanelRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlaylistPanelRenderer playlistPanelRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            playlistPanelRenderer = (PlaylistPanelRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlaylistPanelRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            playlistPanelRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    playlistPanelRenderer = (PlaylistPanelRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, PlaylistPanelRenderer$$serializer.INSTANCE, playlistPanelRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NextResponse.ContinuationContents(i, playlistPanelRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NextResponse.ContinuationContents continuationContents = (NextResponse.ContinuationContents) obj;
        continuationContents.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, PlaylistPanelRenderer$$serializer.INSTANCE, continuationContents.playlistPanelContinuation);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
