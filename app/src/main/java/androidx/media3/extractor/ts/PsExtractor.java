package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.text.CueDecoder;
import io.ktor.client.utils.CIOKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PsExtractor implements Extractor {
    public boolean foundAllTracks;
    public boolean foundAudioTrack;
    public boolean foundVideoTrack;
    public boolean hasOutputSeekMap;
    public long lastTrackPosition;
    public ExtractorOutput output;
    public PsBinarySearchSeeker psBinarySearchSeeker;
    public final TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0);
    public final ParsableByteArray psPacketBuffer = new ParsableByteArray(4096);
    public final SparseArray psPayloadReaders = new SparseArray();
    public final PsDurationReader durationReader = new PsDurationReader((byte) 0);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PesReader {
        public boolean dtsFlag;
        public final ElementaryStreamReader pesPayloadReader;
        public final VorbisBitArray pesScratch = new VorbisBitArray(new byte[64], 64);
        public boolean ptsFlag;
        public boolean seenFirstDts;
        public final TimestampAdjuster timestampAdjuster;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.pesPayloadReader = elementaryStreamReader;
            this.timestampAdjuster = timestampAdjuster;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        char c;
        long j;
        ?? r4;
        ?? r5;
        long jAdjustTsTimestamp;
        ElementaryStreamReader h262Reader;
        long j2;
        long j3;
        PsDurationReader psDurationReader = this.durationReader;
        TimestampAdjuster timestampAdjuster = psDurationReader.scrTimestampAdjuster;
        this.output.getClass();
        long length = extractorInput.getLength();
        if (length != -1) {
            c = 3;
            if (!psDurationReader.isDurationRead) {
                ParsableByteArray parsableByteArray = psDurationReader.packetBuffer;
                if (!psDurationReader.isLastScrValueRead) {
                    long length2 = extractorInput.getLength();
                    int iMin = (int) Math.min(20000L, length2);
                    long j4 = length2 - ((long) iMin);
                    if (extractorInput.getPosition() != j4) {
                        positionHolder.position = j4;
                        return 1;
                    }
                    parsableByteArray.reset(iMin);
                    extractorInput.resetPeekPosition();
                    extractorInput.peekFully(parsableByteArray.data, 0, iMin);
                    int i = parsableByteArray.position;
                    for (int i2 = parsableByteArray.limit - 4; i2 >= i; i2--) {
                        if (PsDurationReader.peekIntAtPosition(parsableByteArray.data, i2) == 442) {
                            parsableByteArray.setPosition(i2 + 4);
                            long scrValueFromPack = PsDurationReader.readScrValueFromPack(parsableByteArray);
                            if (scrValueFromPack != -9223372036854775807L) {
                                j3 = scrValueFromPack;
                                psDurationReader.lastScrValue = j3;
                                psDurationReader.isLastScrValueRead = true;
                                return 0;
                            }
                        }
                    }
                    j3 = -9223372036854775807L;
                    psDurationReader.lastScrValue = j3;
                    psDurationReader.isLastScrValueRead = true;
                    return 0;
                }
                if (psDurationReader.lastScrValue == -9223372036854775807L) {
                    psDurationReader.finishReadDuration(extractorInput);
                    return 0;
                }
                if (psDurationReader.isFirstScrValueRead) {
                    long j5 = psDurationReader.firstScrValue;
                    if (j5 == -9223372036854775807L) {
                        psDurationReader.finishReadDuration(extractorInput);
                        return 0;
                    }
                    psDurationReader.durationUs = timestampAdjuster.adjustTsTimestampGreaterThanPreviousTimestamp(psDurationReader.lastScrValue) - timestampAdjuster.adjustTsTimestamp(j5);
                    psDurationReader.finishReadDuration(extractorInput);
                    return 0;
                }
                int iMin2 = (int) Math.min(20000L, extractorInput.getLength());
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return 1;
                }
                parsableByteArray.reset(iMin2);
                extractorInput.resetPeekPosition();
                extractorInput.peekFully(parsableByteArray.data, 0, iMin2);
                int i3 = parsableByteArray.limit;
                for (int i4 = parsableByteArray.position; i4 < i3 - 3; i4++) {
                    if (PsDurationReader.peekIntAtPosition(parsableByteArray.data, i4) == 442) {
                        parsableByteArray.setPosition(i4 + 4);
                        long scrValueFromPack2 = PsDurationReader.readScrValueFromPack(parsableByteArray);
                        if (scrValueFromPack2 != -9223372036854775807L) {
                            j2 = scrValueFromPack2;
                            psDurationReader.firstScrValue = j2;
                            psDurationReader.isFirstScrValueRead = true;
                            return 0;
                        }
                    }
                }
                j2 = -9223372036854775807L;
                psDurationReader.firstScrValue = j2;
                psDurationReader.isFirstScrValueRead = true;
                return 0;
            }
        } else {
            c = 3;
        }
        byte b = 7;
        if (this.hasOutputSeekMap) {
            j = 0;
            r4 = 1;
            r5 = 0;
        } else {
            this.hasOutputSeekMap = true;
            long j6 = psDurationReader.durationUs;
            if (j6 != -9223372036854775807L) {
                r5 = 0;
                r4 = 1;
                j = 0;
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(new CueDecoder(b), new CallbackWrapper(timestampAdjuster), j6, j6 + 1, 0L, length, 188L, CIOKt.DEFAULT_HTTP_POOL_SIZE);
                this.psBinarySearchSeeker = psBinarySearchSeeker;
                this.output.seekMap(psBinarySearchSeeker.seekMap);
            } else {
                r4 = 1;
                r5 = 0;
                j = 0;
                this.output.seekMap(new SeekMap.Unseekable(j6));
            }
        }
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.psBinarySearchSeeker;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.seekOperationParams != null) {
            return psBinarySearchSeeker2.handlePendingSeek(extractorInput, positionHolder);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = length != -1 ? length - extractorInput.getPeekPosition() : -1L;
        if (peekPosition != -1 && peekPosition < 4) {
            return -1;
        }
        ParsableByteArray parsableByteArray2 = this.psPacketBuffer;
        if (!extractorInput.peekFully(parsableByteArray2.data, r5, 4, r4)) {
            return -1;
        }
        parsableByteArray2.setPosition(r5);
        int i5 = parsableByteArray2.readInt();
        if (i5 == 441) {
            return -1;
        }
        if (i5 == 442) {
            extractorInput.peekFully(parsableByteArray2.data, r5, 10);
            parsableByteArray2.setPosition(9);
            extractorInput.skipFully((parsableByteArray2.readUnsignedByte() & 7) + 14);
            return r5;
        }
        if (i5 == 443) {
            extractorInput.peekFully(parsableByteArray2.data, r5, 2);
            parsableByteArray2.setPosition(r5);
            extractorInput.skipFully(parsableByteArray2.readUnsignedShort() + 6);
            return r5;
        }
        if (((i5 & (-256)) >> 8) != r4) {
            extractorInput.skipFully(r4);
            return r5;
        }
        int i6 = i5 & 255;
        SparseArray sparseArray = this.psPayloadReaders;
        PesReader pesReader = (PesReader) sparseArray.get(i6);
        if (!this.foundAllTracks) {
            if (pesReader == null) {
                if (i6 == 189) {
                    h262Reader = new Ac3Reader("video/mp2p");
                    this.foundAudioTrack = r4;
                    this.lastTrackPosition = extractorInput.getPosition();
                } else if ((i5 & 224) == 192) {
                    h262Reader = new MpegAudioReader(null, r5, "video/mp2p");
                    this.foundAudioTrack = r4;
                    this.lastTrackPosition = extractorInput.getPosition();
                } else if ((i5 & 240) == 224) {
                    h262Reader = new H262Reader(null, "video/mp2p");
                    this.foundVideoTrack = r4;
                    this.lastTrackPosition = extractorInput.getPosition();
                } else {
                    h262Reader = null;
                }
                if (h262Reader != null) {
                    h262Reader.createTracks(this.output, new TsPayloadReader.TrackIdGenerator(i6, 256));
                    pesReader = new PesReader(h262Reader, this.timestampAdjuster);
                    sparseArray.put(i6, pesReader);
                }
            }
            if (extractorInput.getPosition() > ((this.foundAudioTrack && this.foundVideoTrack) ? this.lastTrackPosition + 8192 : 1048576L)) {
                this.foundAllTracks = r4;
                this.output.endTracks();
            }
        }
        extractorInput.peekFully(parsableByteArray2.data, r5, 2);
        parsableByteArray2.setPosition(r5);
        int unsignedShort = parsableByteArray2.readUnsignedShort() + 6;
        if (pesReader == null) {
            extractorInput.skipFully(unsignedShort);
            return r5;
        }
        parsableByteArray2.reset(unsignedShort);
        extractorInput.readFully(parsableByteArray2.data, r5, unsignedShort);
        parsableByteArray2.setPosition(6);
        ElementaryStreamReader elementaryStreamReader = pesReader.pesPayloadReader;
        VorbisBitArray vorbisBitArray = pesReader.pesScratch;
        parsableByteArray2.readBytes(vorbisBitArray.data, r5, 3);
        vorbisBitArray.setPosition(r5);
        vorbisBitArray.skipBits(8);
        pesReader.ptsFlag = vorbisBitArray.readBit();
        pesReader.dtsFlag = vorbisBitArray.readBit();
        vorbisBitArray.skipBits(6);
        parsableByteArray2.readBytes(vorbisBitArray.data, r5, vorbisBitArray.readBits(8));
        vorbisBitArray.setPosition(r5);
        TimestampAdjuster timestampAdjuster2 = pesReader.timestampAdjuster;
        if (pesReader.ptsFlag) {
            vorbisBitArray.skipBits(4);
            long bits = ((long) vorbisBitArray.readBits(3)) << 30;
            vorbisBitArray.skipBits(r4);
            long bits2 = bits | ((long) (vorbisBitArray.readBits(15) << 15));
            vorbisBitArray.skipBits(r4);
            long bits3 = bits2 | ((long) vorbisBitArray.readBits(15));
            vorbisBitArray.skipBits(r4);
            if (!pesReader.seenFirstDts && pesReader.dtsFlag) {
                vorbisBitArray.skipBits(4);
                long bits4 = ((long) vorbisBitArray.readBits(3)) << 30;
                vorbisBitArray.skipBits(r4);
                long bits5 = bits4 | ((long) (vorbisBitArray.readBits(15) << 15));
                vorbisBitArray.skipBits(r4);
                long bits6 = ((long) vorbisBitArray.readBits(15)) | bits5;
                vorbisBitArray.skipBits(r4);
                timestampAdjuster2.adjustTsTimestamp(bits6);
                pesReader.seenFirstDts = r4;
            }
            jAdjustTsTimestamp = timestampAdjuster2.adjustTsTimestamp(bits3);
        } else {
            jAdjustTsTimestamp = j;
        }
        elementaryStreamReader.packetStarted(4, jAdjustTsTimestamp);
        elementaryStreamReader.consume(parsableByteArray2);
        elementaryStreamReader.packetFinished(r5);
        parsableByteArray2.setLimit(parsableByteArray2.data.length);
        return r5;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        long j3;
        SparseArray sparseArray = this.psPayloadReaders;
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
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
        PsBinarySearchSeeker psBinarySearchSeeker = this.psBinarySearchSeeker;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.setSeekTargetUs(j2);
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            PesReader pesReader = (PesReader) sparseArray.valueAt(i);
            pesReader.seenFirstDts = false;
            pesReader.pesPayloadReader.seek();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        byte[] bArr = new byte[14];
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.peekFully(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            defaultExtractorInput.advancePeekPosition(bArr[13] & 7, false);
            defaultExtractorInput.peekFully(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
