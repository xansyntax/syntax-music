package androidx.media3.extractor.text;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SubtitleExtractor implements Extractor {
    public int bytesRead;
    public final SubtitleParser subtitleParser;
    public TrackOutput trackOutput;
    public byte[] subtitleData = Util.EMPTY_BYTE_ARRAY;
    public final ParsableByteArray scratchSampleArray = new ParsableByteArray();
    public final Format format = null;
    public final ArrayList samples = new ArrayList();
    public byte state = 0;
    public long[] timestamps = Util.EMPTY_LONG_ARRAY;
    public long seekTimeUs = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Sample implements Comparable {
        public final byte[] data;
        public final long timeUs;

        public Sample(long j, byte[] bArr) {
            this.timeUs = j;
            this.data = bArr;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return Long.compare(this.timeUs, ((Sample) obj).timeUs);
        }
    }

    public SubtitleExtractor(SubtitleParser subtitleParser) {
        this.subtitleParser = subtitleParser;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        UtilsKt.checkState(this.state == 0);
        TrackOutput trackOutputTrack = extractorOutput.track(0, 3);
        this.trackOutput = trackOutputTrack;
        Format format = this.format;
        if (format != null) {
            trackOutputTrack.format(format);
            extractorOutput.endTracks();
            extractorOutput.seekMap(new IndexSeekMap(-9223372036854775807L, new long[]{0}, new long[]{0}));
        }
        this.state = (byte) 1;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0081 A[Catch: RuntimeException -> 0x00cb, TryCatch #0 {RuntimeException -> 0x00cb, blocks: (B:33:0x007b, B:35:0x0081, B:38:0x008c, B:39:0x00af, B:41:0x00b5, B:42:0x00c4, B:37:0x0089), top: B:67:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0089 A[Catch: RuntimeException -> 0x00cb, TryCatch #0 {RuntimeException -> 0x00cb, blocks: (B:33:0x007b, B:35:0x0081, B:38:0x008c, B:39:0x00af, B:41:0x00b5, B:42:0x00c4, B:37:0x0089), top: B:67:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b5 A[Catch: RuntimeException -> 0x00cb, LOOP:1: B:39:0x00af->B:41:0x00b5, LOOP_END, TryCatch #0 {RuntimeException -> 0x00cb, blocks: (B:33:0x007b, B:35:0x0081, B:38:0x008c, B:39:0x00af, B:41:0x00b5, B:42:0x00c4, B:37:0x0089), top: B:67:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:67:0x007b A[EXC_TOP_SPLITTER, PHI: r22
      0x007b: PHI (r22v4 int) = (r22v5 int), (r22v6 int) binds: [B:32:0x0079, B:29:0x0074] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        int i;
        long j;
        SubtitleParser.OutputOptions outputOptions;
        int i2;
        byte b = this.state;
        UtilsKt.checkState((b == 0 || b == 5) ? false : true);
        byte b2 = this.state;
        if (b2 == 1) {
            int iCheckedCast = extractorInput.getLength() != -1 ? StringsKt__IndentKt.checkedCast(extractorInput.getLength()) : 1024;
            if (iCheckedCast > this.subtitleData.length) {
                this.subtitleData = new byte[iCheckedCast];
            }
            this.bytesRead = 0;
            this.state = (byte) 2;
            b2 = 2;
        }
        ArrayList arrayList = this.samples;
        if (b2 == 2) {
            byte[] bArrCopyOf = this.subtitleData;
            if (bArrCopyOf.length == this.bytesRead) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + 1024);
                this.subtitleData = bArrCopyOf;
            }
            int i3 = this.bytesRead;
            int i4 = extractorInput.read(bArrCopyOf, i3, bArrCopyOf.length - i3);
            if (i4 != -1) {
                this.bytesRead += i4;
            }
            long length = extractorInput.getLength();
            if (length != -1) {
                i = 0;
                if (this.bytesRead == length) {
                    try {
                        j = this.seekTimeUs;
                        if (j != -9223372036854775807L) {
                            outputOptions = new SubtitleParser.OutputOptions(j, true);
                        } else {
                            outputOptions = SubtitleParser.OutputOptions.ALL;
                        }
                        this.subtitleParser.parse(this.subtitleData, 0, this.bytesRead, outputOptions, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 22, (Object) this));
                        Collections.sort(arrayList);
                        this.timestamps = new long[arrayList.size()];
                        for (i2 = i; i2 < arrayList.size(); i2++) {
                            this.timestamps[i2] = ((Sample) arrayList.get(i2)).timeUs;
                        }
                        this.subtitleData = Util.EMPTY_BYTE_ARRAY;
                        this.state = (byte) 4;
                    } catch (RuntimeException e) {
                        throw ParserException.createForMalformedContainer(e, "SubtitleParser failed.");
                    }
                }
            } else {
                i = 0;
            }
            if (i4 == -1) {
                j = this.seekTimeUs;
                if (j != -9223372036854775807L) {
                    outputOptions = new SubtitleParser.OutputOptions(j, true);
                } else {
                    outputOptions = SubtitleParser.OutputOptions.ALL;
                }
                this.subtitleParser.parse(this.subtitleData, 0, this.bytesRead, outputOptions, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 22, (Object) this));
                Collections.sort(arrayList);
                this.timestamps = new long[arrayList.size()];
                while (i2 < arrayList.size()) {
                    this.timestamps[i2] = ((Sample) arrayList.get(i2)).timeUs;
                }
                this.subtitleData = Util.EMPTY_BYTE_ARRAY;
                this.state = (byte) 4;
            }
        } else {
            i = 0;
        }
        if (this.state == 3) {
            if (extractorInput.skip(extractorInput.getLength() != -1 ? StringsKt__IndentKt.checkedCast(extractorInput.getLength()) : 1024) == -1) {
                long j2 = this.seekTimeUs;
                for (int iBinarySearchFloor = j2 == -9223372036854775807L ? i : Util.binarySearchFloor(this.timestamps, j2, true); iBinarySearchFloor < arrayList.size(); iBinarySearchFloor++) {
                    writeToOutput((Sample) arrayList.get(iBinarySearchFloor));
                }
                this.state = (byte) 4;
            }
        }
        if (this.state == 4) {
            return -1;
        }
        return i;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        if (this.state == 5) {
            return;
        }
        this.subtitleParser.reset();
        this.state = (byte) 5;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        byte b = this.state;
        byte b2 = 1;
        UtilsKt.checkState((b == 0 || b == 5) ? false : true);
        this.seekTimeUs = j2;
        byte b3 = this.state;
        if (b3 == 2) {
            this.state = (byte) 1;
        } else {
            b2 = b3;
        }
        if (b2 == 4) {
            this.state = (byte) 3;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return true;
    }

    public final void writeToOutput(Sample sample) {
        this.trackOutput.getClass();
        byte[] bArr = sample.data;
        int length = bArr.length;
        int length2 = bArr.length;
        ParsableByteArray parsableByteArray = this.scratchSampleArray;
        parsableByteArray.reset(bArr, length2);
        this.trackOutput.sampleData(length, parsableByteArray);
        this.trackOutput.sampleMetadata(sample.timeUs, 1, length, 0, null);
    }
}
