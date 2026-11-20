package androidx.media3.extractor.flac;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.ts.PsBinarySearchSeeker;
import com.google.common.collect.ImmutableList;
import java.nio.ByteOrder;
import java.util.Arrays;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlacExtractor implements Extractor {
    public PsBinarySearchSeeker binarySearchSeeker;
    public int currentFrameBytesWritten;
    public long currentFrameFirstSampleNumber;
    public ExtractorOutput extractorOutput;
    public FlacStreamMetadata flacStreamMetadata;
    public int frameStartMarker;
    public Metadata id3Metadata;
    public int minFrameSize;
    public TrackOutput trackOutput;
    public final byte[] streamMarkerAndInfoBlock = new byte[42];
    public final ParsableByteArray buffer = new ParsableByteArray(new byte[32768], 0);
    public final boolean id3MetadataDisabled = false;
    public final PositionHolder sampleNumberHolder = new PositionHolder();
    public byte state = 0;

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        FlacStreamMetadata flacStreamMetadata;
        SeekMap unseekable;
        long j;
        long j2;
        boolean zCheckAndReadFrameHeader;
        byte b = this.state;
        Metadata metadata = null;
        boolean z = true;
        int i = 0;
        if (b == 0) {
            extractorInput.resetPeekPosition();
            long peekPosition = extractorInput.getPeekPosition();
            Metadata metadataPeekId3Data = new Id3Peeker((byte) 0).peekId3Data(extractorInput, !this.id3MetadataDisabled ? null : Id3Decoder.NO_FRAMES_PREDICATE, 0);
            if (metadataPeekId3Data != null && metadataPeekId3Data.entries.length != 0) {
                metadata = metadataPeekId3Data;
            }
            extractorInput.skipFully((int) (extractorInput.getPeekPosition() - peekPosition));
            this.id3Metadata = metadata;
            this.state = (byte) 1;
            return 0;
        }
        byte[] bArr = this.streamMarkerAndInfoBlock;
        if (b == 1) {
            extractorInput.peekFully(bArr, 0, bArr.length);
            extractorInput.resetPeekPosition();
            this.state = (byte) 2;
            return 0;
        }
        int i2 = 4;
        int i3 = 3;
        if (b == 2) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(4);
            extractorInput.readFully(parsableByteArray.data, 0, 4);
            if (parsableByteArray.readUnsignedInt() != 1716281667) {
                throw ParserException.createForMalformedContainer(null, "Failed to read FLAC stream marker.");
            }
            this.state = (byte) 3;
            return 0;
        }
        int i4 = 7;
        int i5 = 6;
        if (b == 3) {
            int i6 = 0;
            FlacStreamMetadata flacStreamMetadata2 = this.flacStreamMetadata;
            boolean z2 = false;
            while (!z2) {
                extractorInput.resetPeekPosition();
                byte[] bArr2 = new byte[i2];
                VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr2, i2);
                int i7 = i6;
                extractorInput.peekFully(bArr2, i7, i2);
                boolean bit = vorbisBitArray.readBit();
                int bits = vorbisBitArray.readBits(i4);
                int bits2 = vorbisBitArray.readBits(24) + i2;
                if (bits == 0) {
                    byte[] bArr3 = new byte[38];
                    extractorInput.readFully(bArr3, i7, 38);
                    flacStreamMetadata2 = new FlacStreamMetadata(bArr3, i2);
                } else {
                    if (flacStreamMetadata2 == null) {
                        Path$$ExternalSyntheticBUOutline0.m();
                        return 0;
                    }
                    Metadata metadata2 = flacStreamMetadata2.metadata;
                    if (bits == i3) {
                        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bits2);
                        extractorInput.readFully(parsableByteArray2.data, i7, bits2);
                        flacStreamMetadata2 = new FlacStreamMetadata(flacStreamMetadata2.minBlockSizeSamples, flacStreamMetadata2.maxBlockSizeSamples, flacStreamMetadata2.minFrameSize, flacStreamMetadata2.maxFrameSize, flacStreamMetadata2.sampleRate, flacStreamMetadata2.channels, flacStreamMetadata2.bitsPerSample, flacStreamMetadata2.totalSamples, AacUtil.readSeekTableMetadataBlock(parsableByteArray2), flacStreamMetadata2.metadata);
                    } else {
                        if (bits == i2) {
                            ParsableByteArray parsableByteArray3 = new ParsableByteArray(bits2);
                            extractorInput.readFully(parsableByteArray3.data, 0, bits2);
                            parsableByteArray3.skipBytes(i2);
                            Metadata vorbisComments = AacUtil.parseVorbisComments(Arrays.asList((String[]) AacUtil.readVorbisCommentHeader(parsableByteArray3, false, false).delegate));
                            if (metadata2 != null) {
                                vorbisComments = metadata2.copyWithAppendedEntriesFrom(vorbisComments);
                            }
                            flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadata2.minBlockSizeSamples, flacStreamMetadata2.maxBlockSizeSamples, flacStreamMetadata2.minFrameSize, flacStreamMetadata2.maxFrameSize, flacStreamMetadata2.sampleRate, flacStreamMetadata2.channels, flacStreamMetadata2.bitsPerSample, flacStreamMetadata2.totalSamples, flacStreamMetadata2.seekTable, vorbisComments);
                        } else if (bits == i5) {
                            ParsableByteArray parsableByteArray4 = new ParsableByteArray(bits2);
                            extractorInput.readFully(parsableByteArray4.data, 0, bits2);
                            parsableByteArray4.skipBytes(4);
                            Metadata metadata3 = new Metadata(ImmutableList.of((Object) PictureFrame.fromPictureBlock(parsableByteArray4)));
                            if (metadata2 != null) {
                                metadata3 = metadata2.copyWithAppendedEntriesFrom(metadata3);
                            }
                            flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadata2.minBlockSizeSamples, flacStreamMetadata2.maxBlockSizeSamples, flacStreamMetadata2.minFrameSize, flacStreamMetadata2.maxFrameSize, flacStreamMetadata2.sampleRate, flacStreamMetadata2.channels, flacStreamMetadata2.bitsPerSample, flacStreamMetadata2.totalSamples, flacStreamMetadata2.seekTable, metadata3);
                        } else {
                            extractorInput.skipFully(bits2);
                        }
                        flacStreamMetadata2 = flacStreamMetadata;
                    }
                }
                String str = Util.DEVICE_DEBUG_INFO;
                this.flacStreamMetadata = flacStreamMetadata2;
                z2 = bit;
                i2 = 4;
                i3 = 3;
                i4 = 7;
                i5 = 6;
                i6 = 0;
            }
            this.flacStreamMetadata.getClass();
            this.minFrameSize = Math.max(this.flacStreamMetadata.minFrameSize, 6);
            Format format = this.flacStreamMetadata.getFormat(bArr, this.id3Metadata);
            TrackOutput trackOutput = this.trackOutput;
            String str2 = Util.DEVICE_DEBUG_INFO;
            Format.Builder builderBuildUpon = format.buildUpon();
            builderBuildUpon.containerMimeType = MimeTypes.normalizeMimeType("audio/flac");
            Format$$ExternalSyntheticOutline0.m(builderBuildUpon, trackOutput);
            this.trackOutput.durationUs(this.flacStreamMetadata.getDurationUs());
            this.state = (byte) 4;
            return 0;
        }
        long j3 = 0;
        if (b == 4) {
            extractorInput.resetPeekPosition();
            ParsableByteArray parsableByteArray5 = new ParsableByteArray(2);
            extractorInput.peekFully(parsableByteArray5.data, 0, 2);
            int unsignedShort = parsableByteArray5.readUnsignedShort();
            if ((unsignedShort >> 2) != 16382) {
                extractorInput.resetPeekPosition();
                throw ParserException.createForMalformedContainer(null, "First frame does not start with sync code.");
            }
            extractorInput.resetPeekPosition();
            this.frameStartMarker = unsignedShort;
            ExtractorOutput extractorOutput = this.extractorOutput;
            String str3 = Util.DEVICE_DEBUG_INFO;
            long position = extractorInput.getPosition();
            long length = extractorInput.getLength();
            this.flacStreamMetadata.getClass();
            final FlacStreamMetadata flacStreamMetadata3 = this.flacStreamMetadata;
            CallbackWrapper callbackWrapper = flacStreamMetadata3.seekTable;
            if (callbackWrapper != null && ((long[]) callbackWrapper.mCallback).length > 0) {
                unseekable = new SeekMap.Unseekable(flacStreamMetadata3, position, (byte) 1);
                i = 0;
            } else if (length == -1 || flacStreamMetadata3.totalSamples <= 0) {
                i = 0;
                unseekable = new SeekMap.Unseekable(flacStreamMetadata3.getDurationUs());
            } else {
                final int i8 = this.frameStartMarker;
                int i9 = flacStreamMetadata3.minFrameSize;
                OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 20, (Object) flacStreamMetadata3);
                BinarySearchSeeker$TimestampSeeker binarySearchSeeker$TimestampSeeker = new BinarySearchSeeker$TimestampSeeker(flacStreamMetadata3, i8) { // from class: androidx.media3.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker
                    public final FlacStreamMetadata flacStreamMetadata;
                    public final int frameStartMarker;
                    public final PositionHolder sampleNumberHolder = new PositionHolder();

                    {
                        this.flacStreamMetadata = flacStreamMetadata3;
                        this.frameStartMarker = i8;
                    }

                    public final long findNextFrame(ExtractorInput extractorInput2) {
                        PositionHolder positionHolder2;
                        FlacStreamMetadata flacStreamMetadata4;
                        int iPeek;
                        while (true) {
                            long peekPosition2 = extractorInput2.getPeekPosition();
                            long length2 = extractorInput2.getLength() - 6;
                            positionHolder2 = this.sampleNumberHolder;
                            flacStreamMetadata4 = this.flacStreamMetadata;
                            if (peekPosition2 >= length2) {
                                break;
                            }
                            long peekPosition3 = extractorInput2.getPeekPosition();
                            ParsableByteArray parsableByteArray6 = new ParsableByteArray(17);
                            int i10 = 0;
                            boolean zCheckAndReadFrameHeader2 = false;
                            extractorInput2.peekFully(parsableByteArray6.data, 0, 2);
                            char cPeekChar = parsableByteArray6.peekChar(0, ByteOrder.BIG_ENDIAN);
                            int i11 = this.frameStartMarker;
                            if (cPeekChar != i11) {
                                extractorInput2.resetPeekPosition();
                                extractorInput2.advancePeekPosition((int) (peekPosition3 - extractorInput2.getPosition()));
                            } else {
                                byte[] bArr4 = parsableByteArray6.data;
                                while (i10 < 15 && (iPeek = extractorInput2.peek(bArr4, 2 + i10, 15 - i10)) != -1) {
                                    i10 += iPeek;
                                }
                                parsableByteArray6.setLimit(i10 + 2);
                                extractorInput2.resetPeekPosition();
                                extractorInput2.advancePeekPosition((int) (peekPosition3 - extractorInput2.getPosition()));
                                zCheckAndReadFrameHeader2 = AacUtil.checkAndReadFrameHeader(parsableByteArray6, flacStreamMetadata4, i11, positionHolder2);
                            }
                            if (zCheckAndReadFrameHeader2) {
                                break;
                            }
                            extractorInput2.advancePeekPosition(1);
                        }
                        if (extractorInput2.getPeekPosition() < extractorInput2.getLength() - 6) {
                            return positionHolder2.position;
                        }
                        extractorInput2.advancePeekPosition((int) (extractorInput2.getLength() - extractorInput2.getPeekPosition()));
                        return flacStreamMetadata4.totalSamples;
                    }

                    @Override // androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker
                    public final BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput2, long j4) {
                        long position2 = extractorInput2.getPosition();
                        long jFindNextFrame = findNextFrame(extractorInput2);
                        long peekPosition2 = extractorInput2.getPeekPosition();
                        extractorInput2.advancePeekPosition(Math.max(6, this.flacStreamMetadata.minFrameSize));
                        long jFindNextFrame2 = findNextFrame(extractorInput2);
                        long peekPosition3 = extractorInput2.getPeekPosition();
                        if (jFindNextFrame > j4 || jFindNextFrame2 <= j4) {
                            return jFindNextFrame2 <= j4 ? new BinarySearchSeeker$TimestampSearchResult(-2, jFindNextFrame2, peekPosition3) : new BinarySearchSeeker$TimestampSearchResult(-1, jFindNextFrame, position2);
                        }
                        return new BinarySearchSeeker$TimestampSearchResult(0, -9223372036854775807L, peekPosition2);
                    }
                };
                long durationUs = flacStreamMetadata3.getDurationUs();
                long j4 = flacStreamMetadata3.totalSamples;
                int i10 = flacStreamMetadata3.maxFrameSize;
                if (i10 > 0) {
                    j = ((((long) i10) + ((long) i9)) / 2) + 1;
                } else {
                    int i11 = flacStreamMetadata3.minBlockSizeSamples;
                    j = 64 + (((((i11 != flacStreamMetadata3.maxBlockSizeSamples || i11 <= 0) ? 4096L : i11) * ((long) flacStreamMetadata3.channels)) * ((long) flacStreamMetadata3.bitsPerSample)) / 8);
                }
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, binarySearchSeeker$TimestampSeeker, durationUs, j4, position, length, j, Math.max(6, i9));
                this.binarySearchSeeker = psBinarySearchSeeker;
                unseekable = psBinarySearchSeeker.seekMap;
            }
            extractorOutput.seekMap(unseekable);
            this.state = (byte) 5;
            return i;
        }
        if (b != 5) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return 0;
        }
        this.trackOutput.getClass();
        this.flacStreamMetadata.getClass();
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.binarySearchSeeker;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.seekOperationParams != null) {
            return psBinarySearchSeeker2.handlePendingSeek(extractorInput, positionHolder);
        }
        if (this.currentFrameFirstSampleNumber == -1) {
            FlacStreamMetadata flacStreamMetadata4 = this.flacStreamMetadata;
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(1);
            byte[] bArr4 = new byte[1];
            extractorInput.peekFully(bArr4, 0, 1);
            boolean z3 = (bArr4[0] & 1) == 1;
            extractorInput.advancePeekPosition(2);
            i4 = z3 ? 7 : 6;
            ParsableByteArray parsableByteArray6 = new ParsableByteArray(i4);
            byte[] bArr5 = parsableByteArray6.data;
            int i12 = 0;
            while (i12 < i4) {
                int iPeek = extractorInput.peek(bArr5, i12, i4 - i12);
                if (iPeek == -1) {
                    break;
                }
                i12 += iPeek;
            }
            parsableByteArray6.setLimit(i12);
            extractorInput.resetPeekPosition();
            try {
                long utf8EncodedLong = parsableByteArray6.readUtf8EncodedLong();
                if (!z3) {
                    utf8EncodedLong *= (long) flacStreamMetadata4.maxBlockSizeSamples;
                }
                long j5 = flacStreamMetadata4.totalSamples;
                if (j5 == 0 || utf8EncodedLong <= j5) {
                    j3 = utf8EncodedLong;
                } else {
                    z = false;
                }
            } catch (NumberFormatException unused) {
            }
            if (!z) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            this.currentFrameFirstSampleNumber = j3;
        } else {
            ParsableByteArray parsableByteArray7 = this.buffer;
            int i13 = parsableByteArray7.limit;
            if (i13 < 32768) {
                int i14 = extractorInput.read(parsableByteArray7.data, i13, 32768 - i13);
                z = i14 == -1;
                if (!z) {
                    parsableByteArray7.setLimit(i13 + i14);
                } else if (parsableByteArray7.bytesLeft() == 0) {
                    long j6 = this.currentFrameFirstSampleNumber * 1000000;
                    FlacStreamMetadata flacStreamMetadata5 = this.flacStreamMetadata;
                    String str4 = Util.DEVICE_DEBUG_INFO;
                    this.trackOutput.sampleMetadata(j6 / ((long) flacStreamMetadata5.sampleRate), 1, this.currentFrameBytesWritten, 0, null);
                    return -1;
                }
            } else {
                z = false;
            }
            int i15 = parsableByteArray7.position;
            int i16 = this.currentFrameBytesWritten;
            int i17 = this.minFrameSize;
            if (i16 < i17) {
                parsableByteArray7.skipBytes(Math.min(i17 - i16, parsableByteArray7.bytesLeft()));
            }
            this.flacStreamMetadata.getClass();
            int i18 = parsableByteArray7.position;
            while (true) {
                int i19 = parsableByteArray7.limit - 16;
                PositionHolder positionHolder2 = this.sampleNumberHolder;
                if (i18 > i19) {
                    if (z) {
                        while (true) {
                            int i20 = parsableByteArray7.limit;
                            if (i18 <= i20 - this.minFrameSize) {
                                parsableByteArray7.setPosition(i18);
                                try {
                                    zCheckAndReadFrameHeader = AacUtil.checkAndReadFrameHeader(parsableByteArray7, this.flacStreamMetadata, this.frameStartMarker, positionHolder2);
                                } catch (IndexOutOfBoundsException unused2) {
                                    zCheckAndReadFrameHeader = false;
                                }
                                if (parsableByteArray7.position > parsableByteArray7.limit) {
                                    zCheckAndReadFrameHeader = false;
                                }
                                if (zCheckAndReadFrameHeader) {
                                    parsableByteArray7.setPosition(i18);
                                    j2 = positionHolder2.position;
                                    break;
                                }
                                i18++;
                            } else {
                                parsableByteArray7.setPosition(i20);
                            }
                        }
                    } else {
                        parsableByteArray7.setPosition(i18);
                    }
                    j2 = -1;
                    break;
                }
                parsableByteArray7.setPosition(i18);
                if (AacUtil.checkAndReadFrameHeader(parsableByteArray7, this.flacStreamMetadata, this.frameStartMarker, positionHolder2)) {
                    parsableByteArray7.setPosition(i18);
                    j2 = positionHolder2.position;
                    break;
                }
                i18++;
            }
            int i21 = parsableByteArray7.position - i15;
            parsableByteArray7.setPosition(i15);
            this.trackOutput.sampleData(i21, parsableByteArray7);
            int i22 = this.currentFrameBytesWritten + i21;
            this.currentFrameBytesWritten = i22;
            if (j2 != -1) {
                long j7 = this.currentFrameFirstSampleNumber * 1000000;
                FlacStreamMetadata flacStreamMetadata6 = this.flacStreamMetadata;
                String str5 = Util.DEVICE_DEBUG_INFO;
                this.trackOutput.sampleMetadata(j7 / ((long) flacStreamMetadata6.sampleRate), 1, i22, 0, null);
                this.currentFrameBytesWritten = 0;
                this.currentFrameFirstSampleNumber = j2;
            }
            int length2 = parsableByteArray7.data.length - parsableByteArray7.limit;
            if (parsableByteArray7.bytesLeft() < 16 && length2 < 16) {
                int iBytesLeft = parsableByteArray7.bytesLeft();
                byte[] bArr6 = parsableByteArray7.data;
                System.arraycopy(bArr6, parsableByteArray7.position, bArr6, 0, iBytesLeft);
                parsableByteArray7.setPosition(0);
                parsableByteArray7.setLimit(iBytesLeft);
            }
        }
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        if (j == 0) {
            this.state = (byte) 0;
        } else {
            PsBinarySearchSeeker psBinarySearchSeeker = this.binarySearchSeeker;
            if (psBinarySearchSeeker != null) {
                psBinarySearchSeeker.setSeekTargetUs(j2);
            }
        }
        this.currentFrameFirstSampleNumber = j2 != 0 ? -1L : 0L;
        this.currentFrameBytesWritten = 0;
        this.buffer.reset(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        Metadata metadataPeekId3Data = new Id3Peeker((byte) 0).peekId3Data(extractorInput, Id3Decoder.NO_FRAMES_PREDICATE, 0);
        if (metadataPeekId3Data != null) {
            int length = metadataPeekId3Data.entries.length;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        ((DefaultExtractorInput) extractorInput).peekFully(parsableByteArray.data, 0, 4, false);
        return parsableByteArray.readUnsignedInt() == 1716281667;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
