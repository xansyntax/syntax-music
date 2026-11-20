package androidx.media3.extractor.mp4;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SefReader {
    public final ArrayList dataReferences = new ArrayList();
    public byte readerState = 0;
    public int tailLength;
    public static final Splitter COLON_SPLITTER = new Splitter(new Splitter$$ExternalSyntheticLambda0((byte) 0, new CharMatcher.Is(':', (byte) 0)));
    public static final Splitter ASTERISK_SPLITTER = new Splitter(new Splitter$$ExternalSyntheticLambda0((byte) 0, new CharMatcher.Is(GMTDateParser.ANY, (byte) 0)));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DataReference {
        public final int size;
        public final long startOffset;

        public DataReference(long j, int i) {
            this.startOffset = j;
            this.size = i;
        }
    }
}
