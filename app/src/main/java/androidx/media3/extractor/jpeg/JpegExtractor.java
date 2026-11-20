package androidx.media3.extractor.jpeg;

import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JpegExtractor implements Extractor {
    public final /* synthetic */ byte $r8$classId = 0;
    public final Object extractor;

    public JpegExtractor(int i) {
        if ((i & 1) != 0) {
            this.extractor = new SingleSampleExtractor(65496, 2, "image/jpeg");
        } else {
            this.extractor = new JpegMotionPhotoExtractor();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        byte b = this.$r8$classId;
        Object obj = this.extractor;
        switch (b) {
            case 0:
                ((Extractor) obj).init(extractorOutput);
                break;
            default:
                TrackOutput trackOutputTrack = extractorOutput.track(0, 3);
                extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
                extractorOutput.endTracks();
                Format format = (Format) obj;
                Format.Builder builderBuildUpon = format.buildUpon();
                builderBuildUpon.sampleMimeType = MimeTypes.normalizeMimeType("text/x-unknown");
                builderBuildUpon.codecs = format.sampleMimeType;
                Format$$ExternalSyntheticOutline0.m(builderBuildUpon, trackOutputTrack);
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        switch (this.$r8$classId) {
            case 0:
                return ((Extractor) this.extractor).read(extractorInput, positionHolder);
            default:
                return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        switch (this.$r8$classId) {
            case 0:
                ((Extractor) this.extractor).release();
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        switch (this.$r8$classId) {
            case 0:
                ((Extractor) this.extractor).seek(j, j2);
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        switch (this.$r8$classId) {
            case 0:
                return ((Extractor) this.extractor).sniff(extractorInput);
            default:
                return true;
        }
    }

    private final void release$androidx$media3$exoplayer$source$DefaultMediaSourceFactory$UnknownSubtitlesExtractor() {
    }

    public JpegExtractor(Format format) {
        this.extractor = format;
    }

    private final void seek$androidx$media3$exoplayer$source$DefaultMediaSourceFactory$UnknownSubtitlesExtractor(long j, long j2) {
    }
}
