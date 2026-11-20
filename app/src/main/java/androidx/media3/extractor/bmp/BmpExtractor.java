package androidx.media3.extractor.bmp;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BmpExtractor implements Extractor {
    public final /* synthetic */ byte $r8$classId;
    public final SingleSampleExtractor imageExtractor;

    public BmpExtractor(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.imageExtractor = new SingleSampleExtractor(35152, 2, "image/png");
                break;
            default:
                this.imageExtractor = new SingleSampleExtractor(16973, 2, "image/bmp");
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        byte b = this.$r8$classId;
        SingleSampleExtractor singleSampleExtractor = this.imageExtractor;
        switch (b) {
            case 0:
                singleSampleExtractor.init(extractorOutput);
                break;
            default:
                singleSampleExtractor.init(extractorOutput);
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        byte b = this.$r8$classId;
        SingleSampleExtractor singleSampleExtractor = this.imageExtractor;
        switch (b) {
            case 0:
                break;
        }
        return singleSampleExtractor.read(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        byte b = this.$r8$classId;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        byte b = this.$r8$classId;
        SingleSampleExtractor singleSampleExtractor = this.imageExtractor;
        switch (b) {
            case 0:
                singleSampleExtractor.seek(j, j2);
                break;
            default:
                singleSampleExtractor.seek(j, j2);
                break;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        byte b = this.$r8$classId;
        SingleSampleExtractor singleSampleExtractor = this.imageExtractor;
        switch (b) {
            case 0:
                break;
        }
        return singleSampleExtractor.sniff(extractorInput);
    }

    private final void release$androidx$media3$extractor$bmp$BmpExtractor() {
    }

    private final void release$androidx$media3$extractor$png$PngExtractor() {
    }
}
