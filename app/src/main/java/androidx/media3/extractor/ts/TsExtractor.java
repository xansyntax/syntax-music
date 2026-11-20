package androidx.media3.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.compose.runtime.Latch;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.base.Splitter;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import kotlin.math.MathKt;
import okhttp3.Dispatcher$promoteAndExecute$Effects;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TsExtractor implements Extractor {
    public final SparseIntArray continuityCounters;
    public final PsDurationReader durationReader;
    public final int extractorFlags;
    public boolean hasOutputSeekMap;
    public ExtractorOutput output;
    public final Dispatcher$promoteAndExecute$Effects payloadReaderFactory;
    public int pcrPid;
    public boolean pendingSeekToStart;
    public int remainingPmts;
    public final CueDecoder subtitleParserFactory;
    public final List timestampAdjusters;
    public final SparseBooleanArray trackIds;
    public final SparseBooleanArray trackPids;
    public boolean tracksEnded;
    public PsBinarySearchSeeker tsBinarySearchSeeker;
    public final ParsableByteArray tsPacketBuffer = new ParsableByteArray(new byte[9400], 0);
    public final SparseArray tsPayloadReaders;

    public TsExtractor(int i, CueDecoder cueDecoder, TimestampAdjuster timestampAdjuster, Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$Effects) {
        this.payloadReaderFactory = dispatcher$promoteAndExecute$Effects;
        this.extractorFlags = i;
        this.subtitleParserFactory = cueDecoder;
        this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.trackIds = sparseBooleanArray;
        this.trackPids = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.tsPayloadReaders = sparseArray;
        this.continuityCounters = new SparseIntArray();
        this.durationReader = new PsDurationReader((byte) 1);
        this.output = ExtractorOutput.PLACEHOLDER;
        this.pcrPid = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), (TsPayloadReader) sparseArray2.valueAt(i2));
        }
        sparseArray.put(0, new SectionReader(new Splitter(this)));
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        if ((this.extractorFlags & 1) == 0) {
            extractorOutput = new Latch(extractorOutput, this.subtitleParserFactory);
        }
        this.output = extractorOutput;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [int] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.media3.extractor.ts.TsPayloadReader] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        ExtractorInput extractorInput2;
        int i;
        ?? r1;
        ?? r7;
        TsPayloadReader tsPayloadReader;
        boolean z;
        long pcrFromPacket;
        long length = extractorInput.getLength();
        if (this.tracksEnded) {
            long j = -9223372036854775807L;
            PsDurationReader psDurationReader = this.durationReader;
            if (length != -1 && !psDurationReader.isDurationRead) {
                int i2 = this.pcrPid;
                TimestampAdjuster timestampAdjuster = psDurationReader.scrTimestampAdjuster;
                ParsableByteArray parsableByteArray = psDurationReader.packetBuffer;
                if (i2 <= 0) {
                    psDurationReader.finishReadDuration(extractorInput);
                    return 0;
                }
                if (psDurationReader.isLastScrValueRead) {
                    if (psDurationReader.lastScrValue == -9223372036854775807L) {
                        psDurationReader.finishReadDuration(extractorInput);
                        return 0;
                    }
                    if (psDurationReader.isFirstScrValueRead) {
                        long j2 = psDurationReader.firstScrValue;
                        if (j2 == -9223372036854775807L) {
                            psDurationReader.finishReadDuration(extractorInput);
                            return 0;
                        }
                        psDurationReader.durationUs = timestampAdjuster.adjustTsTimestampGreaterThanPreviousTimestamp(psDurationReader.lastScrValue) - timestampAdjuster.adjustTsTimestamp(j2);
                        psDurationReader.finishReadDuration(extractorInput);
                        return 0;
                    }
                    int iMin = (int) Math.min(112800L, extractorInput.getLength());
                    if (extractorInput.getPosition() != 0) {
                        positionHolder.position = 0L;
                        return 1;
                    }
                    parsableByteArray.reset(iMin);
                    extractorInput.resetPeekPosition();
                    extractorInput.peekFully(parsableByteArray.data, 0, iMin);
                    int i3 = parsableByteArray.limit;
                    for (int i4 = parsableByteArray.position; i4 < i3; i4++) {
                        if (parsableByteArray.data[i4] == 71) {
                            pcrFromPacket = MathKt.readPcrFromPacket(parsableByteArray, i4, i2);
                            if (pcrFromPacket != -9223372036854775807L) {
                                psDurationReader.firstScrValue = pcrFromPacket;
                                psDurationReader.isFirstScrValueRead = true;
                                return 0;
                            }
                        }
                    }
                    pcrFromPacket = -9223372036854775807L;
                    psDurationReader.firstScrValue = pcrFromPacket;
                    psDurationReader.isFirstScrValueRead = true;
                    return 0;
                }
                long length2 = extractorInput.getLength();
                int iMin2 = (int) Math.min(112800L, length2);
                long j3 = length2 - ((long) iMin2);
                if (extractorInput.getPosition() != j3) {
                    positionHolder.position = j3;
                    return 1;
                }
                parsableByteArray.reset(iMin2);
                extractorInput.resetPeekPosition();
                extractorInput.peekFully(parsableByteArray.data, 0, iMin2);
                int i5 = parsableByteArray.position;
                int i6 = parsableByteArray.limit;
                for (int i7 = i6 - 188; i7 >= i5; i7--) {
                    byte[] bArr = parsableByteArray.data;
                    int i8 = 0;
                    for (int i9 = -4; i9 <= 4; i9++) {
                        int i10 = (i9 * 188) + i7;
                        if (i10 >= i5 && i10 < i6 && bArr[i10] == 71) {
                            i8++;
                            if (i8 == 5) {
                                long pcrFromPacket2 = MathKt.readPcrFromPacket(parsableByteArray, i7, i2);
                                if (pcrFromPacket2 == -9223372036854775807L) {
                                    break;
                                }
                                j = pcrFromPacket2;
                                break;
                            }
                        } else {
                            i8 = 0;
                        }
                    }
                }
                psDurationReader.lastScrValue = j;
                psDurationReader.isLastScrValueRead = true;
                return 0;
            }
            if (this.hasOutputSeekMap) {
                i = 1;
                z = false;
            } else {
                this.hasOutputSeekMap = true;
                long j4 = psDurationReader.durationUs;
                if (j4 != -9223372036854775807L) {
                    i = 1;
                    z = false;
                    PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(new CueDecoder((byte) 7), new StatusLine(this.pcrPid, psDurationReader.scrTimestampAdjuster), j4, j4 + 1, 0L, length, 188L, 940);
                    this.tsBinarySearchSeeker = psBinarySearchSeeker;
                    this.output.seekMap(psBinarySearchSeeker.seekMap);
                } else {
                    z = false;
                    i = 1;
                    this.output.seekMap(new SeekMap.Unseekable(j4));
                }
            }
            if (this.pendingSeekToStart) {
                this.pendingSeekToStart = z;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return i;
                }
            }
            PsBinarySearchSeeker psBinarySearchSeeker2 = this.tsBinarySearchSeeker;
            if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.seekOperationParams != null) {
                return psBinarySearchSeeker2.handlePendingSeek(extractorInput, positionHolder);
            }
            extractorInput2 = extractorInput;
            r1 = z;
        } else {
            extractorInput2 = extractorInput;
            i = 1;
            r1 = 0;
        }
        ParsableByteArray parsableByteArray2 = this.tsPacketBuffer;
        byte[] bArr2 = parsableByteArray2.data;
        if (9400 - parsableByteArray2.position < 188) {
            int iBytesLeft = parsableByteArray2.bytesLeft();
            if (iBytesLeft > 0) {
                System.arraycopy(bArr2, parsableByteArray2.position, bArr2, r1, iBytesLeft);
            }
            parsableByteArray2.reset(bArr2, iBytesLeft);
        }
        while (true) {
            int iBytesLeft2 = parsableByteArray2.bytesLeft();
            ?? r8 = this.tsPayloadReaders;
            if (iBytesLeft2 >= 188) {
                int i11 = parsableByteArray2.position;
                int i12 = parsableByteArray2.limit;
                byte[] bArr3 = parsableByteArray2.data;
                while (i11 < i12 && bArr3[i11] != 71) {
                    i11++;
                }
                parsableByteArray2.setPosition(i11);
                int i13 = i11 + 188;
                int i14 = parsableByteArray2.limit;
                if (i13 > i14) {
                    return r1;
                }
                int i15 = parsableByteArray2.readInt();
                if ((8388608 & i15) != 0) {
                    parsableByteArray2.setPosition(i13);
                    return r1;
                }
                ?? r6 = (4194304 & i15) != 0 ? 1 : r1;
                int i16 = (2096896 & i15) >> 8;
                ?? r9 = (i15 & 32) != 0 ? 1 : r1;
                if ((i15 & 16) != 0) {
                    tsPayloadReader = (TsPayloadReader) r8.get(i16);
                } else {
                    r7 = 0;
                }
                if (r7 == 0) {
                    r7 = tsPayloadReader;
                    parsableByteArray2.setPosition(i13);
                    return r1;
                }
                int i17 = i15 & 15;
                SparseIntArray sparseIntArray = this.continuityCounters;
                int i18 = sparseIntArray.get(i16, i17 - 1);
                sparseIntArray.put(i16, i17);
                if (i18 == i17) {
                    r7 = tsPayloadReader;
                    parsableByteArray2.setPosition(i13);
                    return r1;
                }
                if (i17 != ((i18 + 1) & 15)) {
                    r7 = tsPayloadReader;
                    r7.seek();
                }
                if (r9 != 0) {
                    int unsignedByte = parsableByteArray2.readUnsignedByte();
                    r6 = (r6 == true ? 1 : 0) | ((parsableByteArray2.readUnsignedByte() & 64) != 0 ? 2 : r1);
                    parsableByteArray2.skipBytes(unsignedByte - 1);
                }
                boolean z2 = this.tracksEnded;
                if (z2 || !this.trackPids.get(i16, r1)) {
                    parsableByteArray2.setLimit(i13);
                    r7.consume(r6, parsableByteArray2);
                    parsableByteArray2.setLimit(i14);
                }
                if (!z2 && this.tracksEnded && length != -1) {
                    this.pendingSeekToStart = true;
                }
                parsableByteArray2.setPosition(i13);
                return r1;
            }
            int i19 = parsableByteArray2.limit;
            int i20 = extractorInput2.read(bArr2, i19, 9400 - i19);
            if (i20 == -1) {
                for (?? r10 = r1; r10 < r8.size(); r10++) {
                    TsPayloadReader tsPayloadReader2 = (TsPayloadReader) r8.valueAt(r10);
                    if (tsPayloadReader2 instanceof PesReader) {
                        PesReader pesReader = (PesReader) tsPayloadReader2;
                        if (pesReader.state == 3 && pesReader.payloadSize == -1) {
                            pesReader.consume(i, new ParsableByteArray());
                        }
                    }
                    i = 1;
                }
                return -1;
            }
            parsableByteArray2.setLimit(i19 + i20);
            i = 1;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        PsBinarySearchSeeker psBinarySearchSeeker;
        long j3;
        SparseArray sparseArray = this.tsPayloadReaders;
        List list = this.timestampAdjusters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster) list.get(i);
            synchronized (timestampAdjuster) {
                j3 = timestampAdjuster.timestampOffsetUs;
            }
            boolean z = j3 == -9223372036854775807L;
            if (!z) {
                long firstSampleTimestampUs = timestampAdjuster.getFirstSampleTimestampUs();
                z = (firstSampleTimestampUs == -9223372036854775807L || firstSampleTimestampUs == 0 || firstSampleTimestampUs == j2) ? false : true;
            }
            if (z) {
                timestampAdjuster.reset(j2);
            }
        }
        if (j2 != 0 && (psBinarySearchSeeker = this.tsBinarySearchSeeker) != null) {
            psBinarySearchSeeker.setSeekTargetUs(j2);
        }
        this.tsPacketBuffer.reset(0);
        this.continuityCounters.clear();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            ((TsPayloadReader) sparseArray.valueAt(i2)).seek();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        byte[] bArr = this.tsPacketBuffer.data;
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.peekFully(bArr, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    defaultExtractorInput.skipFully(i, false);
                    return true;
                }
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
