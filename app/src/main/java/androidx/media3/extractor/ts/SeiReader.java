package androidx.media3.extractor.ts;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SeiReader {
    public final /* synthetic */ byte $r8$classId;
    public final List closedCaptionFormats;
    public final TrackOutput[] outputs;
    public final RulerTrackingMap reorderingBufferQueue;

    public SeiReader(List list, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.closedCaptionFormats = list;
                this.outputs = new TrackOutput[list.size()];
                RulerTrackingMap rulerTrackingMap = new RulerTrackingMap(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 26, this));
                this.reorderingBufferQueue = rulerTrackingMap;
                rulerTrackingMap.setMaxSize(3);
                break;
            default:
                this.closedCaptionFormats = list;
                this.outputs = new TrackOutput[list.size()];
                this.reorderingBufferQueue = new RulerTrackingMap(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 25, this));
                break;
        }
    }

    public void consume(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 9) {
            return;
        }
        int i = parsableByteArray.readInt();
        int i2 = parsableByteArray.readInt();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if (i == 434 && i2 == 1195456820 && unsignedByte == 3) {
            this.reorderingBufferQueue.add(j, parsableByteArray);
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        byte b = this.$r8$classId;
        List list = this.closedCaptionFormats;
        TrackOutput[] trackOutputArr = this.outputs;
        switch (b) {
            case 0:
                for (int i = 0; i < trackOutputArr.length; i++) {
                    trackIdGenerator.generateNewId();
                    trackIdGenerator.maybeThrowUninitializedError();
                    TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.trackId, 3);
                    Format format = (Format) list.get(i);
                    String str = format.sampleMimeType;
                    UtilsKt.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: %s", str);
                    String str2 = format.id;
                    if (str2 == null) {
                        trackIdGenerator.maybeThrowUninitializedError();
                        str2 = trackIdGenerator.formatId;
                    }
                    Format.Builder builder = new Format.Builder();
                    builder.id = str2;
                    builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                    builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
                    builder.selectionFlags = format.selectionFlags;
                    builder.language = format.language;
                    builder.accessibilityChannel = format.accessibilityChannel;
                    builder.initializationData = format.initializationData;
                    Format$$ExternalSyntheticOutline0.m(builder, trackOutputTrack);
                    trackOutputArr[i] = trackOutputTrack;
                }
                break;
            default:
                for (int i2 = 0; i2 < trackOutputArr.length; i2++) {
                    trackIdGenerator.generateNewId();
                    trackIdGenerator.maybeThrowUninitializedError();
                    TrackOutput trackOutputTrack2 = extractorOutput.track(trackIdGenerator.trackId, 3);
                    Format format2 = (Format) list.get(i2);
                    String str3 = format2.sampleMimeType;
                    UtilsKt.checkArgument("application/cea-608".equals(str3) || "application/cea-708".equals(str3), "Invalid closed caption MIME type provided: %s", str3);
                    Format.Builder builder2 = new Format.Builder();
                    trackIdGenerator.maybeThrowUninitializedError();
                    builder2.id = trackIdGenerator.formatId;
                    builder2.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                    builder2.sampleMimeType = MimeTypes.normalizeMimeType(str3);
                    builder2.selectionFlags = format2.selectionFlags;
                    builder2.language = format2.language;
                    builder2.accessibilityChannel = format2.accessibilityChannel;
                    builder2.initializationData = format2.initializationData;
                    Format$$ExternalSyntheticOutline0.m(builder2, trackOutputTrack2);
                    trackOutputArr[i2] = trackOutputTrack2;
                }
                break;
        }
    }
}
