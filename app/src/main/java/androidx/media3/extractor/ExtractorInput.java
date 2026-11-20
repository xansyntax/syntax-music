package androidx.media3.extractor;

import androidx.media3.common.DataReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ExtractorInput extends DataReader {
    void advancePeekPosition(int i);

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i, int i2);

    void peekFully(byte[] bArr, int i, int i2);

    boolean peekFully(byte[] bArr, int i, int i2, boolean z);

    void readFully(byte[] bArr, int i, int i2);

    boolean readFully(byte[] bArr, int i, int i2, boolean z);

    void resetPeekPosition();

    int skip(int i);

    void skipFully(int i);

    boolean skipFully(int i, boolean z);
}
