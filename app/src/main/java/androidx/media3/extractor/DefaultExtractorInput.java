package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    public final DataReader dataReader;
    public int peekBufferLength;
    public int peekBufferPosition;
    public long position;
    public final long streamLength;
    public byte[] peekBuffer = new byte[65536];
    public final byte[] scratchSpace = new byte[4096];

    static {
        MediaLibraryInfo.registerModule("media3.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j, long j2) {
        this.dataReader = dataReader;
        this.position = j;
        this.streamLength = j2;
    }

    public final boolean advancePeekPosition(int i, boolean z) {
        ensureSpaceForPeek(i);
        int fromUpstream = this.peekBufferLength - this.peekBufferPosition;
        while (fromUpstream < i) {
            DefaultExtractorInput defaultExtractorInput = this;
            int i2 = i;
            boolean z2 = z;
            fromUpstream = defaultExtractorInput.readFromUpstream(this.peekBuffer, this.peekBufferPosition, i2, fromUpstream, z2);
            if (fromUpstream == -1) {
                return false;
            }
            defaultExtractorInput.peekBufferLength = defaultExtractorInput.peekBufferPosition + fromUpstream;
            this = defaultExtractorInput;
            i = i2;
            z = z2;
        }
        this.peekBufferPosition += i;
        return true;
    }

    public final void ensureSpaceForPeek(int i) {
        int i2 = this.peekBufferPosition + i;
        byte[] bArr = this.peekBuffer;
        if (i2 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long getLength() {
        return this.streamLength;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long getPeekPosition() {
        return this.position + ((long) this.peekBufferPosition);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long getPosition() {
        return this.position;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final int peek(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iMin;
        ensureSpaceForPeek(i2);
        int i3 = this.peekBufferLength;
        int i4 = this.peekBufferPosition;
        int i5 = i3 - i4;
        if (i5 == 0) {
            defaultExtractorInput = this;
            iMin = defaultExtractorInput.readFromUpstream(this.peekBuffer, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            defaultExtractorInput.peekBufferLength += iMin;
        } else {
            defaultExtractorInput = this;
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(defaultExtractorInput.peekBuffer, defaultExtractorInput.peekBufferPosition, bArr, i, iMin);
        defaultExtractorInput.peekBufferPosition += iMin;
        return iMin;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i2, bArr, i, i2);
        return true;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int i3 = this.peekBufferLength;
        int fromUpstream = 0;
        if (i3 != 0) {
            int iMin = Math.min(i3, i2);
            System.arraycopy(this.peekBuffer, 0, bArr, i, iMin);
            updatePeekBuffer(iMin);
            fromUpstream = iMin;
        }
        if (fromUpstream == 0) {
            defaultExtractorInput = this;
            fromUpstream = defaultExtractorInput.readFromUpstream(bArr, i, i2, 0, true);
        } else {
            defaultExtractorInput = this;
        }
        if (fromUpstream != -1) {
            defaultExtractorInput.position += (long) fromUpstream;
        }
        return fromUpstream;
    }

    public final int readFromUpstream(byte[] bArr, int i, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.dataReader.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean readFully(byte[] bArr, int i, int i2, boolean z) throws EOFException, InterruptedIOException {
        int iMin;
        int i3 = this.peekBufferLength;
        if (i3 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i3, i2);
            System.arraycopy(this.peekBuffer, 0, bArr, i, iMin);
            updatePeekBuffer(iMin);
        }
        int fromUpstream = iMin;
        while (fromUpstream < i2 && fromUpstream != -1) {
            fromUpstream = readFromUpstream(bArr, i, i2, fromUpstream, z);
        }
        if (fromUpstream != -1) {
            this.position += (long) fromUpstream;
        }
        return fromUpstream != -1;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final int skip(int i) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iMin = Math.min(this.peekBufferLength, i);
        updatePeekBuffer(iMin);
        if (iMin == 0) {
            byte[] bArr = this.scratchSpace;
            defaultExtractorInput = this;
            iMin = defaultExtractorInput.readFromUpstream(bArr, 0, Math.min(i, bArr.length), 0, true);
        } else {
            defaultExtractorInput = this;
        }
        if (iMin != -1) {
            defaultExtractorInput.position += (long) iMin;
        }
        return iMin;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean skipFully(int i, boolean z) throws EOFException, InterruptedIOException {
        int iMin = Math.min(this.peekBufferLength, i);
        updatePeekBuffer(iMin);
        int fromUpstream = iMin;
        while (fromUpstream < i && fromUpstream != -1) {
            byte[] bArr = this.scratchSpace;
            fromUpstream = readFromUpstream(bArr, -fromUpstream, Math.min(i, bArr.length + fromUpstream), fromUpstream, z);
        }
        if (fromUpstream != -1) {
            this.position += (long) fromUpstream;
        }
        return fromUpstream != -1;
    }

    public final void updatePeekBuffer(int i) {
        int i2 = this.peekBufferLength - i;
        this.peekBufferLength = i2;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.peekBuffer = bArr2;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void peekFully(byte[] bArr, int i, int i2) {
        peekFully(bArr, i, i2, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void advancePeekPosition(int i) {
        advancePeekPosition(i, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void skipFully(int i) throws EOFException, InterruptedIOException {
        skipFully(i, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void readFully(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        readFully(bArr, i, i2, false);
    }
}
