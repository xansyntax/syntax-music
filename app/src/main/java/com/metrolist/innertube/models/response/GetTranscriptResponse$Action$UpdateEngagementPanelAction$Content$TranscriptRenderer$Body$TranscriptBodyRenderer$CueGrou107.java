package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer implements GeneratedSerializer {
    public static final GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer = new GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer();
        INSTANCE = getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup", getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("transcriptCueGroupRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer transcriptCueGroupRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            transcriptCueGroupRenderer = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            transcriptCueGroupRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    transcriptCueGroupRenderer = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE, transcriptCueGroupRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup(i, transcriptCueGroupRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup cueGroup = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup) obj;
        cueGroup.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE, cueGroup.transcriptCueGroupRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
