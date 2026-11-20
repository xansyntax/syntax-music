package com.metrolist.innertube.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer implements GeneratedSerializer {
    public static final GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer = new GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer();
        INSTANCE = getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer", getTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("cue", false);
        pluginGeneratedSerialDescriptor.addElement("startOffsetMs", false);
        pluginGeneratedSerialDescriptor.addElement("durationMs", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE, longSerializer, longSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer.SimpleText simpleText;
        int i;
        long jDecodeLongElement;
        long jDecodeLongElement2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            simpleText = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer.SimpleText) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE, null);
            i = 7;
            jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
        } else {
            boolean z = true;
            simpleText = null;
            long jDecodeLongElement3 = 0;
            int i2 = 0;
            long jDecodeLongElement4 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    simpleText = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer.SimpleText) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE, simpleText);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                    i2 |= 4;
                }
            }
            i = i2;
            jDecodeLongElement = jDecodeLongElement4;
            jDecodeLongElement2 = jDecodeLongElement3;
        }
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer.SimpleText simpleText2 = simpleText;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer(i, simpleText2, jDecodeLongElement, jDecodeLongElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer transcriptCueRenderer = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue.TranscriptCueRenderer) obj;
        transcriptCueRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE, transcriptCueRenderer.cue);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 1, transcriptCueRenderer.startOffsetMs);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 2, transcriptCueRenderer.durationMs);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
