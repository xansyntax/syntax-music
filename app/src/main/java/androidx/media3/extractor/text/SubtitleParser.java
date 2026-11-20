package androidx.media3.extractor.text;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SubtitleParser {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OutputOptions {
        public static final OutputOptions ALL = new OutputOptions(-9223372036854775807L, false);
        public final boolean outputAllCues;
        public final long startTimeUs;

        public OutputOptions(long j, boolean z) {
            this.startTimeUs = j;
            this.outputAllCues = z;
        }
    }

    void parse(byte[] bArr, int i, int i2, OutputOptions outputOptions, Consumer consumer);

    default Subtitle parseToLegacySubtitle(byte[] bArr, int i, int i2) {
        ImmutableList.Builder builder = ImmutableList.builder();
        parse(bArr, 0, i2, OutputOptions.ALL, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 23, (Object) builder));
        return new CuesWithTimingSubtitle(builder.build());
    }

    default void reset() {
    }
}
