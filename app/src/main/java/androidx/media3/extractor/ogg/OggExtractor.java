package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.CueDecoder;
import coil3.memory.RealStrongMemoryCache$cache$1;
import java.util.Arrays;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OggExtractor implements Extractor {
    public ExtractorOutput output;
    public StreamReader streamReader;
    public boolean streamReaderInitialized;

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0175  */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        byte[] bArr;
        this.output.getClass();
        if (this.streamReader == null) {
            if (!sniffInternal(extractorInput)) {
                throw ParserException.createForMalformedContainer(null, "Failed to determine bitstream type");
            }
            extractorInput.resetPeekPosition();
        }
        if (!this.streamReaderInitialized) {
            TrackOutput trackOutputTrack = this.output.track(0, 1);
            this.output.endTracks();
            StreamReader streamReader = this.streamReader;
            streamReader.extractorOutput = this.output;
            streamReader.trackOutput = trackOutputTrack;
            streamReader.reset(true);
            this.streamReaderInitialized = true;
        }
        StreamReader streamReader2 = this.streamReader;
        OggPacket oggPacket = streamReader2.oggPacket;
        ParsableByteArray parsableByteArray = oggPacket.packetArray;
        streamReader2.trackOutput.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        byte b = streamReader2.state;
        if (b == 0) {
            while (oggPacket.populate(extractorInput)) {
                long position = extractorInput.getPosition();
                long j = streamReader2.payloadStartPosition;
                streamReader2.lengthOfReadPacket = position - j;
                if (!streamReader2.readHeaders(parsableByteArray, j, streamReader2.setupData)) {
                    Format format = (Format) streamReader2.setupData.mCallback;
                    streamReader2.sampleRate = format.sampleRate;
                    if (!streamReader2.formatSet) {
                        streamReader2.trackOutput.format(format);
                        streamReader2.formatSet = true;
                    }
                    RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) streamReader2.setupData.mExecutor;
                    if (realStrongMemoryCache$cache$1 == null) {
                        if (extractorInput.getLength() == -1) {
                            streamReader2.oggSeeker = new CueDecoder((byte) 13);
                        } else {
                            OggPageHeader oggPageHeader = oggPacket.pageHeader;
                            streamReader2.oggSeeker = new DefaultOggSeeker(streamReader2, streamReader2.payloadStartPosition, extractorInput.getLength(), oggPageHeader.headerSize + oggPageHeader.bodySize, oggPageHeader.granulePosition, (oggPageHeader.type & 4) != 0);
                        }
                        streamReader2.state = 2;
                        bArr = parsableByteArray.data;
                        if (bArr.length == 65025) {
                            return 0;
                        }
                        parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.limit)), parsableByteArray.limit);
                        return 0;
                    }
                    streamReader2.oggSeeker = realStrongMemoryCache$cache$1;
                    streamReader2.state = 2;
                    bArr = parsableByteArray.data;
                    if (bArr.length == 65025) {
                        return 0;
                    }
                    parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.limit)), parsableByteArray.limit);
                    return 0;
                }
                streamReader2.payloadStartPosition = extractorInput.getPosition();
            }
            streamReader2.state = (byte) 3;
            return -1;
        }
        if (b == 1) {
            extractorInput.skipFully((int) streamReader2.payloadStartPosition);
            streamReader2.state = (byte) 2;
            return 0;
        }
        if (b != 2) {
            if (b == 3) {
                return -1;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return 0;
        }
        long j2 = streamReader2.oggSeeker.read(extractorInput);
        if (j2 >= 0) {
            positionHolder.position = j2;
            return 1;
        }
        if (j2 < -1) {
            streamReader2.onSeekEnd(-(j2 + 2));
        }
        if (!streamReader2.seekMapSet) {
            SeekMap seekMapCreateSeekMap = streamReader2.oggSeeker.createSeekMap();
            seekMapCreateSeekMap.getClass();
            streamReader2.extractorOutput.seekMap(seekMapCreateSeekMap);
            streamReader2.trackOutput.durationUs(seekMapCreateSeekMap.getDurationUs());
            streamReader2.seekMapSet = true;
        }
        if (streamReader2.lengthOfReadPacket <= 0 && !oggPacket.populate(extractorInput)) {
            streamReader2.state = (byte) 3;
            return -1;
        }
        streamReader2.lengthOfReadPacket = 0L;
        long jPreparePayload = streamReader2.preparePayload(parsableByteArray);
        if (jPreparePayload >= 0) {
            long j3 = streamReader2.currentGranule;
            if (j3 + jPreparePayload >= streamReader2.targetGranule) {
                long j4 = (j3 * 1000000) / ((long) streamReader2.sampleRate);
                streamReader2.trackOutput.sampleData(parsableByteArray.limit, parsableByteArray);
                streamReader2.trackOutput.sampleMetadata(j4, 1, parsableByteArray.limit, 0, null);
                streamReader2.targetGranule = -1L;
            }
        }
        streamReader2.currentGranule += jPreparePayload;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        StreamReader streamReader = this.streamReader;
        if (streamReader != null) {
            OggPacket oggPacket = streamReader.oggPacket;
            OggPageHeader oggPageHeader = oggPacket.pageHeader;
            oggPageHeader.type = (short) 0;
            oggPageHeader.granulePosition = 0L;
            oggPageHeader.pageSegmentCount = (short) 0;
            oggPageHeader.headerSize = 0;
            oggPageHeader.bodySize = 0;
            oggPacket.packetArray.reset(0);
            oggPacket.currentSegmentIndex = -1;
            oggPacket.populated = false;
            if (j == 0) {
                streamReader.reset(!streamReader.seekMapSet);
                return;
            }
            if (streamReader.state != 0) {
                long j3 = (((long) streamReader.sampleRate) * j2) / 1000000;
                streamReader.targetGranule = j3;
                OggSeeker oggSeeker = streamReader.oggSeeker;
                String str = Util.DEVICE_DEBUG_INFO;
                oggSeeker.startSeek(j3);
                streamReader.state = (byte) 2;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        try {
            return sniffInternal(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    public final boolean sniffInternal(ExtractorInput extractorInput) {
        boolean zVerifyVorbisHeaderCapturePattern;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.populate(extractorInput, true) && (oggPageHeader.type & 2) == 2) {
            int iMin = Math.min(oggPageHeader.bodySize, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            extractorInput.peekFully(parsableByteArray.data, 0, iMin);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563) {
                this.streamReader = new FlacReader();
                return true;
            }
            parsableByteArray.setPosition(0);
            try {
                zVerifyVorbisHeaderCapturePattern = AacUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
            } catch (ParserException unused) {
                zVerifyVorbisHeaderCapturePattern = false;
            }
            if (zVerifyVorbisHeaderCapturePattern) {
                this.streamReader = new VorbisReader();
            } else {
                parsableByteArray.setPosition(0);
                if (OpusReader.peekPacketStartsWith(parsableByteArray, OpusReader.OPUS_ID_HEADER_SIGNATURE)) {
                    this.streamReader = new OpusReader();
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
