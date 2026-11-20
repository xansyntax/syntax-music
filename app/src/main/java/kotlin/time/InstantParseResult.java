package kotlin.time;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface InstantParseResult {
    Instant toInstant();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public final class Success implements InstantParseResult {
        public final long epochSeconds;
        public final int nanosecondsOfSecond;

        public /* synthetic */ Success(int i, long j) {
            this.nanosecondsOfSecond = i;
            this.epochSeconds = j;
        }

        public static Success peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new Success(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }

        @Override // kotlin.time.InstantParseResult
        public Instant toInstant() {
            Instant instant = Instant.MIN;
            long j = Instant.MIN.epochSeconds;
            long j2 = this.epochSeconds;
            if (j2 >= j && j2 <= Instant.MAX.epochSeconds) {
                return Path.Companion.fromEpochSeconds(j2, this.nanosecondsOfSecond);
            }
            throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + j2 + ')');
        }

        public Success(long j, int i) {
            this.epochSeconds = j;
            this.nanosecondsOfSecond = i;
        }
    }
}
