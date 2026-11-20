package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface TsPayloadReader {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;

        public DvbSubtitleInfo(String str, byte[] bArr) {
            this.language = str;
            this.initializationData = bArr;
        }
    }

    void consume(int i, ParsableByteArray parsableByteArray);

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrackIdGenerator {
        public final int firstTrackId;
        public String formatId;
        public final String formatIdPrefix;
        public int trackId;
        public final short trackIdIncrement;

        /* JADX WARN: Multi-variable type inference failed */
        public TrackIdGenerator(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i2;
            this.trackIdIncrement = i3;
            this.trackId = Integer.MIN_VALUE;
            this.formatId = "";
        }

        public final void generateNewId() {
            int i = this.trackId;
            this.trackId = i == Integer.MIN_VALUE ? this.firstTrackId : i + this.trackIdIncrement;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public final void maybeThrowUninitializedError() {
            if (this.trackId != Integer.MIN_VALUE) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("generateNewId() must be called before retrieving ids.");
        }

        public TrackIdGenerator(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }
    }
}
