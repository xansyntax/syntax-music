package androidx.media3.extractor.avif;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AvifExtractor implements Extractor {
    public final /* synthetic */ byte $r8$classId;
    public final SingleSampleExtractor imageExtractor;
    public final ParsableByteArray scratch;

    public AvifExtractor(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.scratch = new ParsableByteArray(4);
                this.imageExtractor = new SingleSampleExtractor(-1, -1, "image/webp");
                break;
            default:
                this.scratch = new ParsableByteArray(4);
                this.imageExtractor = new SingleSampleExtractor(-1, -1, "image/avif");
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
        ParsableByteArray parsableByteArray = this.scratch;
        switch (b) {
            case 0:
                DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
                defaultExtractorInput.advancePeekPosition(4, false);
                parsableByteArray.reset(4);
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
                if (parsableByteArray.readUnsignedInt() == 1718909296) {
                    parsableByteArray.reset(4);
                    defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
                    if (parsableByteArray.readUnsignedInt() == 1635150182) {
                        return true;
                    }
                }
                return false;
            default:
                parsableByteArray.reset(4);
                DefaultExtractorInput defaultExtractorInput2 = (DefaultExtractorInput) extractorInput;
                defaultExtractorInput2.peekFully(parsableByteArray.data, 0, 4, false);
                if (parsableByteArray.readUnsignedInt() == 1380533830) {
                    defaultExtractorInput2.advancePeekPosition(4, false);
                    parsableByteArray.reset(4);
                    defaultExtractorInput2.peekFully(parsableByteArray.data, 0, 4, false);
                    if (parsableByteArray.readUnsignedInt() == 1464156752) {
                        return true;
                    }
                }
                return false;
        }
    }

    private final void release$androidx$media3$extractor$avif$AvifExtractor() {
    }

    private final void release$androidx$media3$extractor$webp$WebpExtractor() {
    }
}
