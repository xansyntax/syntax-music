package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscardingTrackOutput implements TrackOutput {
    public final byte[] readBuffer = new byte[4096];

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.skipBytes(i);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int sampleData$1(DataReader dataReader, int i, boolean z) throws EOFException {
        byte[] bArr = this.readBuffer;
        int i2 = dataReader.read(bArr, 0, Math.min(bArr.length, i));
        if (i2 != -1) {
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void format(Format format) {
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
    }
}
