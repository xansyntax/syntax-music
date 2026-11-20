package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import java.util.ArrayDeque;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultEbmlReader {
    public long elementContentSize;
    public int elementId;
    public byte elementState;
    public ConnectionPool processor;
    public final byte[] scratch = new byte[8];
    public final ArrayDeque masterElementsStack = new ArrayDeque();
    public final VarintReader varintReader = new VarintReader();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MasterElement {
        public final long elementEndPosition;
        public final int elementId;

        public MasterElement(int i, long j) {
            this.elementId = i;
            this.elementEndPosition = j;
        }
    }

    public final long readInteger(ExtractorInput extractorInput, int i) {
        byte[] bArr = this.scratch;
        extractorInput.readFully(bArr, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return j;
    }
}
