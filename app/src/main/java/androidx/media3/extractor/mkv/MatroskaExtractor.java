package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.compose.runtime.Latch;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.ThumbnailMetadata;
import androidx.media3.extractor.text.CueDecoder;
import androidx.navigation.NavOptions;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import okhttp3.ConnectionPool;
import okio.Path$$ExternalSyntheticBUOutline0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MatroskaExtractor implements Extractor {
    public static final byte[] SSA_DIALOGUE_FORMAT;
    public static final byte[] SSA_PREFIX;
    public static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final Map TRACK_NAME_TO_ROTATION_DEGREES;
    public static final byte[] VTT_PREFIX;
    public static final UUID WAVE_SUBFORMAT_PCM;
    public int blockAdditionalId;
    public long blockDurationUs;
    public int blockFlags;
    public long blockGroupDiscardPaddingNs;
    public boolean blockHasReferenceBlock;
    public int blockSampleCount;
    public int blockSampleIndex;
    public int[] blockSampleSizes;
    public byte blockState;
    public long blockTimeUs;
    public int blockTrackNumber;
    public int blockTrackNumberLength;
    public Track currentTrack;
    public final ParsableByteArray encryptionInitializationVector;
    public final ParsableByteArray encryptionSubsampleData;
    public ByteBuffer encryptionSubsampleDataBuffer;
    public ExtractorOutput extractorOutput;
    public boolean haveOutputSample;
    public boolean inCuesElement;
    public boolean isWebm;
    public final ParsableByteArray nalLength;
    public final ParsableByteArray nalStartCode;
    public final boolean parseSubtitlesDuringExtraction;
    public boolean pendingEndTracks;
    public final SparseArray perTrackCues;
    public final DefaultEbmlReader reader;
    public int sampleBytesRead;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public boolean sampleEncodingHandled;
    public boolean sampleInitializationVectorRead;
    public short samplePartitionCount;
    public boolean samplePartitionCountRead;
    public byte sampleSignalByte;
    public boolean sampleSignalByteRead;
    public final ParsableByteArray sampleStrippedBytes;
    public final ParsableByteArray scratch;
    public int seekEntryId;
    public final ParsableByteArray seekEntryIdBytes;
    public long seekEntryPosition;
    public boolean seekForCues;
    public final boolean seekForCuesEnabled;
    public long segmentContentSize;
    public boolean sentSeekMap;
    public final CueDecoder subtitleParserFactory;
    public final ParsableByteArray subtitleSample;
    public final ParsableByteArray supplementalData;
    public final SparseArray tracks;
    public final VarintReader varintReader;
    public final ParsableByteArray vorbisNumPageSamples;
    public long segmentContentPosition = -1;
    public long timecodeScale = -9223372036854775807L;
    public long durationTimecode = -9223372036854775807L;
    public long durationUs = -9223372036854775807L;
    public long currentCueTimeUs = -9223372036854775807L;
    public int currentCueTrackNumber = -1;
    public long currentCueClusterPosition = -1;
    public long currentCueRelativePosition = -1;
    public int primarySeekTrackNumber = -1;
    public long cuesContentPosition = -1;
    public long seekPositionAfterBuildingCues = -1;
    public long clusterTimecodeUs = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MatroskaSeekMap implements SeekMap {
        public final ChunkIndex chunkIndex;
        public final long durationUs;
        public final SparseArray perTrackCues;
        public final int primarySeekTrackNumber;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class CuePointData implements Comparable {
            public final long clusterPosition;
            public final long relativePosition;
            public final long timeUs;

            public CuePointData(long j, long j2, long j3) {
                this.timeUs = j;
                this.clusterPosition = j2;
                this.relativePosition = j3;
            }

            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return Long.compare(this.timeUs, ((CuePointData) obj).timeUs);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CuePointData)) {
                    return false;
                }
                CuePointData cuePointData = (CuePointData) obj;
                return this.timeUs == cuePointData.timeUs && this.clusterPosition == cuePointData.clusterPosition && this.relativePosition == cuePointData.relativePosition;
            }

            public final int hashCode() {
                return Objects.hash(Long.valueOf(this.timeUs), Long.valueOf(this.clusterPosition), Long.valueOf(this.relativePosition));
            }
        }

        public MatroskaSeekMap(SparseArray sparseArray, long j, int i, long j2, long j3) {
            ChunkIndex chunkIndex;
            int i2;
            this.perTrackCues = sparseArray;
            this.durationUs = j;
            this.primarySeekTrackNumber = i;
            List list = (List) sparseArray.get(i);
            if (list == null || list.isEmpty()) {
                chunkIndex = null;
            } else {
                int size = list.size();
                int[] iArrCopyOf = new int[size];
                long[] jArrCopyOf = new long[size];
                long[] jArrCopyOf2 = new long[size];
                long[] jArrCopyOf3 = new long[size];
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    CuePointData cuePointData = (CuePointData) list.get(i4);
                    jArrCopyOf3[i4] = cuePointData.timeUs;
                    jArrCopyOf[i4] = cuePointData.clusterPosition;
                }
                while (true) {
                    i2 = size - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    int i5 = i3 + 1;
                    iArrCopyOf[i3] = (int) (jArrCopyOf[i5] - jArrCopyOf[i3]);
                    jArrCopyOf2[i3] = jArrCopyOf3[i5] - jArrCopyOf3[i3];
                    i3 = i5;
                }
                int i6 = i2;
                while (i6 > 0 && jArrCopyOf3[i6] >= j) {
                    i6--;
                }
                iArrCopyOf[i6] = (int) ((j2 + j3) - jArrCopyOf[i6]);
                jArrCopyOf2[i6] = j - jArrCopyOf3[i6];
                if (i6 < i2) {
                    Log.w("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration.");
                    int i7 = i6 + 1;
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i7);
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i7);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i7);
                    jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i7);
                }
                chunkIndex = new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
            }
            this.chunkIndex = chunkIndex;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long getDurationUs() {
            return this.durationUs;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints getSeekPoints(long j) {
            ChunkIndex chunkIndex = this.chunkIndex;
            if (chunkIndex != null) {
                return chunkIndex.getSeekPoints(j);
            }
            SeekPoint seekPoint = SeekPoint.START;
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean isSeekable() {
            List list = (List) this.perTrackCues.get(this.primarySeekTrackNumber);
            return (list == null || list.isEmpty()) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Track {
        public int audioBitDepth;
        public int bitsPerChannel;
        public int blockAddIdType;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public Format format;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        public boolean isWebm;
        public String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public boolean waitingForDtsAnalysis;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        public final byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer(null, "Missing CodecPrivate for codec " + str);
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        SSA_DIALOGUE_FORMAT = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        SSA_PREFIX = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        VTT_PREFIX = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        Format$$ExternalSyntheticOutline0.m(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        Format$$ExternalSyntheticOutline0.m(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor(DefaultEbmlReader defaultEbmlReader, int i, CueDecoder cueDecoder) {
        this.reader = defaultEbmlReader;
        defaultEbmlReader.processor = new ConnectionPool(this);
        this.subtitleParserFactory = cueDecoder;
        this.perTrackCues = new SparseArray();
        this.seekForCuesEnabled = (i & 1) == 0;
        this.parseSubtitlesDuringExtraction = (i & 2) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(OpusUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.supplementalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
        this.pendingEndTracks = true;
    }

    public static byte[] formatSubtitleTimecode(long j, long j2, String str) {
        UtilsKt.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        String str3 = Util.DEVICE_DEBUG_INFO;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    public final void assertInCues(int i) {
        if (this.inCuesElement) {
            return;
        }
        throw ParserException.createForMalformedContainer(null, "Element " + i + " must be in a Cues");
    }

    public final void assertInTrackEntry(int i) {
        if (this.currentTrack != null) {
            return;
        }
        throw ParserException.createForMalformedContainer(null, "Element " + i + " must be in a TrackEntry");
    }

    public final void commitSampleToOutput(Track track, long j, int i, int i2, int i3) {
        byte[] subtitleTimecode;
        int i4;
        int i5;
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track.output, j, i, i2, i3, track.cryptoData);
        } else {
            if ("S_TEXT/UTF8".equals(track.codecId) || "S_TEXT/ASS".equals(track.codecId) || "S_TEXT/SSA".equals(track.codecId) || "S_TEXT/WEBVTT".equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.blockDurationUs;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = track.codecId;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        byte[] bArr = parsableByteArray.data;
                        str.getClass();
                        switch (str) {
                            case "S_TEXT/ASS":
                            case "S_TEXT/SSA":
                                subtitleTimecode = formatSubtitleTimecode(j2, 10000L, "%01d:%02d:%02d:%02d");
                                i4 = 21;
                                break;
                            case "S_TEXT/WEBVTT":
                                subtitleTimecode = formatSubtitleTimecode(j2, 1000L, "%02d:%02d:%02d.%03d");
                                i4 = 25;
                                break;
                            case "S_TEXT/UTF8":
                                subtitleTimecode = formatSubtitleTimecode(j2, 1000L, "%02d:%02d:%02d,%03d");
                                i4 = 19;
                                break;
                            default:
                                Path$$ExternalSyntheticBUOutline0.m();
                                return;
                        }
                        System.arraycopy(subtitleTimecode, 0, bArr, i4, subtitleTimecode.length);
                        for (int i6 = parsableByteArray.position; i6 < parsableByteArray.limit; i6++) {
                            if (parsableByteArray.data[i6] == 0) {
                                parsableByteArray.setLimit(i6);
                                track.output.sampleData(parsableByteArray.limit, parsableByteArray);
                                i5 = i2 + parsableByteArray.limit;
                            }
                        }
                        track.output.sampleData(parsableByteArray.limit, parsableByteArray);
                        i5 = i2 + parsableByteArray.limit;
                    }
                }
                i5 = i2;
            } else {
                i5 = i2;
            }
            if ((i & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0) {
                int i7 = this.blockSampleCount;
                ParsableByteArray parsableByteArray2 = this.supplementalData;
                if (i7 > 1) {
                    parsableByteArray2.reset(0);
                } else {
                    int i8 = parsableByteArray2.limit;
                    track.output.sampleData(parsableByteArray2, i8, 2);
                    i5 += i8;
                }
            }
            track.output.sampleMetadata(j, i, i5, i3, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        if (this.parseSubtitlesDuringExtraction) {
            extractorOutput = new Latch(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
    }

    public final void maybeEndTracks() {
        if (!this.pendingEndTracks) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.tracks;
            if (i >= sparseArray.size()) {
                ExtractorOutput extractorOutput = this.extractorOutput;
                extractorOutput.getClass();
                extractorOutput.endTracks();
                this.pendingEndTracks = false;
                return;
            }
            if (((Track) sparseArray.valueAt(i)).waitingForDtsAnalysis) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:184:0x035f  */
    /* JADX WARN: Code duplicated, block: B:325:0x0524  */
    /* JADX WARN: Code duplicated, block: B:487:0x07b5 A[PHI: r0
      0x07b5: PHI (r0v119 int) = (r0v63 int), (r0v115 int), (r0v116 int), (r0v117 int), (r0v121 int) binds: [B:610:0x0a29, B:499:0x07d4, B:496:0x07cd, B:493:0x07c6, B:484:0x079a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:622:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:627:0x0a7d  */
    /* JADX WARN: Code duplicated, block: B:628:0x0a80  */
    /* JADX WARN: Code duplicated, block: B:631:0x0a93  */
    /* JADX WARN: Code duplicated, block: B:632:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:634:0x0aa5  */
    /* JADX WARN: Code duplicated, block: B:636:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:638:0x0aae  */
    /* JADX WARN: Code duplicated, block: B:641:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:643:0x0abb  */
    /* JADX WARN: Code duplicated, block: B:646:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:649:0x0ad0  */
    /* JADX WARN: Code duplicated, block: B:652:0x0ad5  */
    /* JADX WARN: Code duplicated, block: B:654:0x0adb  */
    /* JADX WARN: Code duplicated, block: B:674:0x0b91  */
    /* JADX WARN: Code duplicated, block: B:676:0x0bad  */
    /* JADX WARN: Code duplicated, block: B:679:0x0bb2  */
    /* JADX WARN: Code duplicated, block: B:682:0x0bc5  */
    /* JADX WARN: Code duplicated, block: B:685:0x0bca  */
    /* JADX WARN: Code duplicated, block: B:691:0x0be3  */
    /* JADX WARN: Code duplicated, block: B:692:0x0be5  */
    /* JADX WARN: Code duplicated, block: B:694:0x0bef  */
    /* JADX WARN: Code duplicated, block: B:695:0x0bf2  */
    /* JADX WARN: Code duplicated, block: B:697:0x0bfc  */
    /* JADX WARN: Code duplicated, block: B:703:0x0c14  */
    /* JADX WARN: Code duplicated, block: B:705:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:707:0x0c33  */
    /* JADX WARN: Code duplicated, block: B:722:0x0c5e  */
    /* JADX WARN: Code duplicated, block: B:727:0x0c72  */
    /* JADX WARN: Code duplicated, block: B:728:0x0c75  */
    /* JADX WARN: Code duplicated, block: B:76:0x0192  */
    /* JADX WARN: Code duplicated, block: B:79:0x019e  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [okhttp3.ConnectionPool] */
    /* JADX WARN: Type inference failed for: r1v107 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v113 */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.media3.extractor.ExtractorInput] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.media3.extractor.ExtractorInput] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r35v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v113 */
    /* JADX WARN: Type inference failed for: r4v119 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.media3.extractor.mkv.DefaultEbmlReader] */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.media3.extractor.mkv.VarintReader] */
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
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        boolean z;
        int i;
        byte b;
        byte b2;
        String str;
        ?? r4;
        int i2;
        int iAssembleVarint;
        ?? r1;
        boolean z2;
        ?? r2;
        byte b3;
        byte b4;
        List listSingletonList;
        int pcmEncoding;
        ?? r3;
        int i3;
        ArrayList arrayList;
        RuntimeException runtimeException;
        Pair pair;
        String str2;
        String str3;
        List list;
        List listOf;
        String str4;
        List list2;
        List list3;
        int i4;
        Format.Builder builder;
        boolean zIsAudio;
        int i5;
        int i6;
        float f;
        ColorInfo colorInfo;
        String str5;
        int iIntValue;
        byte[] bArr;
        int i7;
        int i8;
        int i9;
        String str6;
        String str7;
        Joiner joiner;
        List list4;
        int i10;
        List list5;
        int i11;
        long j;
        long j2;
        long j3;
        Metadata metadata;
        ThumbnailMetadata thumbnailMetadata;
        Metadata metadataCopyWithAppendedEntries;
        MatroskaExtractor matroskaExtractor = this;
        boolean z3 = false;
        matroskaExtractor.haveOutputSample = false;
        boolean z4 = true;
        boolean z5 = true;
        while (z5 && !matroskaExtractor.haveOutputSample) {
            ?? r7 = matroskaExtractor.reader;
            ?? r8 = r7.varintReader;
            ArrayDeque arrayDeque = r7.masterElementsStack;
            r7.processor.getClass();
            while (true) {
                DefaultEbmlReader.MasterElement masterElement = (DefaultEbmlReader.MasterElement) arrayDeque.peek();
                if (masterElement == null || extractorInput.getPosition() < masterElement.elementEndPosition) {
                    boolean z6 = z3 ? 1 : 0;
                    byte b5 = r7.elementState;
                    ?? r5 = extractorInput;
                    if (b5 == 0) {
                        int i12 = 4;
                        long unsignedVarint = r8.readUnsignedVarint(r5, true, z6, 4);
                        if (unsignedVarint == -2) {
                            byte[] bArr2 = r7.scratch;
                            r5.resetPeekPosition();
                            ?? r6 = z6;
                            while (true) {
                                r5.peekFully(bArr2, r6, i12);
                                byte b6 = bArr2[r6];
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= 8) {
                                        i2 = -1;
                                    } else if ((VarintReader.VARINT_LENGTH_MASKS[i13] & ((long) b6)) != 0) {
                                        i2 = i13 + 1;
                                    } else {
                                        i13++;
                                    }
                                }
                                if (i2 != -1 && i2 <= 4) {
                                    iAssembleVarint = (int) VarintReader.assembleVarint(i2, false, bArr2);
                                    Object obj = r7.processor.delegate;
                                    if (iAssembleVarint == 357149030 || iAssembleVarint == 524531317 || iAssembleVarint == 475249515 || iAssembleVarint == 374648427) {
                                    }
                                }
                                r5.skipFully(1);
                                i12 = 4;
                                r6 = 0;
                            }
                            r5.skipFully(i2);
                            unsignedVarint = iAssembleVarint;
                        }
                        z = true;
                        if (unsignedVarint == -1) {
                            r4 = 0;
                            z5 = false;
                            r1 = r5;
                        } else {
                            r7.elementId = (int) unsignedVarint;
                            r7.elementState = (byte) 1;
                            b5 = 1;
                        }
                    } else {
                        z = true;
                    }
                    if (b5 == z) {
                        r7.elementContentSize = r8.readUnsignedVarint(r5, false, z, 8);
                        r7.elementState = (byte) 2;
                    }
                    ?? r0 = r7.processor;
                    int i14 = r7.elementId;
                    Object obj2 = r0.delegate;
                    switch (i14) {
                        case 131:
                        case 136:
                        case 155:
                        case 159:
                        case 176:
                        case 179:
                        case 186:
                        case 215:
                        case 231:
                        case 238:
                        case 240:
                        case 241:
                        case 247:
                        case 251:
                        case 16871:
                        case 16980:
                        case 17029:
                        case 17143:
                        case 18401:
                        case 18408:
                        case 20529:
                        case 20530:
                        case 21420:
                        case 21432:
                        case 21680:
                        case 21682:
                        case 21690:
                        case 21930:
                        case 21938:
                        case 21945:
                        case 21946:
                        case 21947:
                        case 21948:
                        case 21949:
                        case 21998:
                        case 22186:
                        case 22203:
                        case 25188:
                        case 30114:
                        case 30321:
                        case 2352003:
                        case 2807729:
                            i = 2;
                            break;
                        case 134:
                        case 17026:
                        case 21358:
                        case 2274716:
                            i = 3;
                            break;
                        case 160:
                        case 166:
                        case 174:
                        case 183:
                        case 187:
                        case 224:
                        case 225:
                        case 16868:
                        case 18407:
                        case 19899:
                        case 20532:
                        case 20533:
                        case 21936:
                        case 21968:
                        case 25152:
                        case 28032:
                        case 30113:
                        case 30320:
                        case 290298740:
                        case 357149030:
                        case 374648427:
                        case 408125543:
                        case 440786851:
                        case 475249515:
                        case 524531317:
                            i = 1;
                            break;
                        case 161:
                        case 163:
                        case 165:
                        case 16877:
                        case 16981:
                        case 18402:
                        case 21419:
                        case 25506:
                        case 30322:
                            i = 4;
                            break;
                        case 181:
                        case 17545:
                        case 21969:
                        case 21970:
                        case 21971:
                        case 21972:
                        case 21973:
                        case 21974:
                        case 21975:
                        case 21976:
                        case 21977:
                        case 21978:
                        case 30323:
                        case 30324:
                        case 30325:
                            i = 5;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        r5.skipFully((int) r7.elementContentSize);
                        r7.elementState = (byte) 0;
                        z3 = false;
                        z4 = true;
                    } else if (i == 1) {
                        long position = r5.getPosition();
                        arrayDeque.push(new DefaultEbmlReader.MasterElement(r7.elementId, r7.elementContentSize + position));
                        r7.processor.startMasterElement(r7.elementId, position, r7.elementContentSize);
                        b = 0;
                        r7.elementState = (byte) 0;
                        r2 = r5;
                    } else if (i == 2) {
                        long j4 = r7.elementContentSize;
                        if (j4 > 8) {
                            throw ParserException.createForMalformedContainer(null, "Invalid integer size: " + r7.elementContentSize);
                        }
                        r0.integerElement(i14, r7.readInteger(r5, (int) j4));
                        b = 0;
                        r7.elementState = (byte) 0;
                        r2 = r5;
                    } else if (i == 3) {
                        long j5 = r7.elementContentSize;
                        if (j5 > 2147483647L) {
                            throw ParserException.createForMalformedContainer(null, "String element size: " + r7.elementContentSize);
                        }
                        int i15 = (int) j5;
                        if (i15 == 0) {
                            str = "";
                            b2 = 0;
                        } else {
                            byte[] bArr3 = new byte[i15];
                            r5.readFully(bArr3, 0, i15);
                            while (i15 > 0 && bArr3[i15 - 1] == 0) {
                                i15--;
                            }
                            b2 = 0;
                            str = new String(bArr3, 0, i15);
                        }
                        r0.stringElement(i14, str);
                        r7.elementState = b2;
                        b = b2;
                        r2 = r5;
                    } else if (i == 4) {
                        r0.binaryElement(i14, (int) r7.elementContentSize, r5);
                        b = 0;
                        r7.elementState = (byte) 0;
                        r2 = r5;
                    } else {
                        if (i != 5) {
                            throw ParserException.createForMalformedContainer(null, "Invalid element type " + i);
                        }
                        long j6 = r7.elementContentSize;
                        if (j6 != 4 && j6 != 8) {
                            throw ParserException.createForMalformedContainer(null, "Invalid float size: " + r7.elementContentSize);
                        }
                        int i16 = (int) j6;
                        long integer = r7.readInteger(r5, i16);
                        double dIntBitsToFloat = i16 == 4 ? Float.intBitsToFloat((int) integer) : Double.longBitsToDouble(integer);
                        MatroskaExtractor matroskaExtractor2 = (MatroskaExtractor) r0.delegate;
                        if (i14 == 181) {
                            matroskaExtractor2.assertInTrackEntry(i14);
                            matroskaExtractor2.currentTrack.sampleRate = (int) dIntBitsToFloat;
                        } else if (i14 != 17545) {
                            switch (i14) {
                                case 21969:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryRChromaticityX = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryRChromaticityY = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryGChromaticityX = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryGChromaticityY = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryBChromaticityX = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.primaryBChromaticityY = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.whitePointChromaticityX = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.whitePointChromaticityY = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.maxMasteringLuminance = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    matroskaExtractor2.assertInTrackEntry(i14);
                                    matroskaExtractor2.currentTrack.minMasteringLuminance = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i14) {
                                        case 30323:
                                            matroskaExtractor2.assertInTrackEntry(i14);
                                            matroskaExtractor2.currentTrack.projectionPoseYaw = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            matroskaExtractor2.assertInTrackEntry(i14);
                                            matroskaExtractor2.currentTrack.projectionPosePitch = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            matroskaExtractor2.assertInTrackEntry(i14);
                                            matroskaExtractor2.currentTrack.projectionPoseRoll = (float) dIntBitsToFloat;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            matroskaExtractor2.durationTimecode = (long) dIntBitsToFloat;
                        }
                        b = 0;
                        r7.elementState = (byte) 0;
                        r2 = r5;
                    }
                } else {
                    ConnectionPool connectionPool = r7.processor;
                    int i17 = ((DefaultEbmlReader.MasterElement) arrayDeque.pop()).elementId;
                    MatroskaExtractor matroskaExtractor3 = (MatroskaExtractor) connectionPool.delegate;
                    SparseArray sparseArray = matroskaExtractor3.perTrackCues;
                    SparseArray sparseArray2 = matroskaExtractor3.tracks;
                    matroskaExtractor3.extractorOutput.getClass();
                    if (i17 != 160) {
                        if (i17 == 174) {
                            Track track = matroskaExtractor3.currentTrack;
                            track.getClass();
                            String str8 = track.codecId;
                            if (str8 == null) {
                                throw ParserException.createForMalformedContainer(null, "CodecId is missing in TrackEntry element");
                            }
                            switch (str8) {
                                case "V_MPEG4/ISO/AP":
                                case "V_MPEG4/ISO/SP":
                                case "A_MS/ACM":
                                case "A_TRUEHD":
                                case "A_VORBIS":
                                case "A_MPEG/L2":
                                case "A_MPEG/L3":
                                case "V_MS/VFW/FOURCC":
                                case "S_DVBSUB":
                                case "V_MPEG4/ISO/ASP":
                                case "V_MPEG4/ISO/AVC":
                                case "S_VOBSUB":
                                case "A_DTS/LOSSLESS":
                                case "A_AAC":
                                case "A_AC3":
                                case "A_DTS":
                                case "V_AV1":
                                case "V_VP8":
                                case "V_VP9":
                                case "S_HDMV/PGS":
                                case "V_THEORA":
                                case "A_DTS/EXPRESS":
                                case "A_PCM/FLOAT/IEEE":
                                case "A_PCM/INT/BIG":
                                case "A_PCM/INT/LIT":
                                case "S_TEXT/ASS":
                                case "S_TEXT/SSA":
                                case "V_MPEGH/ISO/HEVC":
                                case "S_TEXT/WEBVTT":
                                case "S_TEXT/UTF8":
                                case "V_MPEG2":
                                case "A_EAC3":
                                case "A_FLAC":
                                case "A_OPUS":
                                    int i18 = track.number;
                                    switch (str8) {
                                        case "V_MPEG4/ISO/AP":
                                            b4 = 0;
                                            break;
                                        case "V_MPEG4/ISO/SP":
                                            b4 = 1;
                                            break;
                                        case "A_MS/ACM":
                                            b4 = 2;
                                            break;
                                        case "A_TRUEHD":
                                            b4 = 3;
                                            break;
                                        case "A_VORBIS":
                                            b4 = 4;
                                            break;
                                        case "A_MPEG/L2":
                                            b4 = 5;
                                            break;
                                        case "A_MPEG/L3":
                                            b4 = 6;
                                            break;
                                        case "V_MS/VFW/FOURCC":
                                            b4 = 7;
                                            break;
                                        case "S_DVBSUB":
                                            b4 = 8;
                                            break;
                                        case "V_MPEG4/ISO/ASP":
                                            b4 = 9;
                                            break;
                                        case "V_MPEG4/ISO/AVC":
                                            b4 = 10;
                                            break;
                                        case "S_VOBSUB":
                                            b4 = 11;
                                            break;
                                        case "A_DTS/LOSSLESS":
                                            b4 = 12;
                                            break;
                                        case "A_AAC":
                                            b4 = 13;
                                            break;
                                        case "A_AC3":
                                            b4 = 14;
                                            break;
                                        case "A_DTS":
                                            b4 = 15;
                                            break;
                                        case "V_AV1":
                                            b4 = 16;
                                            break;
                                        case "V_VP8":
                                            b4 = 17;
                                            break;
                                        case "V_VP9":
                                            b4 = 18;
                                            break;
                                        case "S_HDMV/PGS":
                                            b4 = 19;
                                            break;
                                        case "V_THEORA":
                                            b4 = 20;
                                            break;
                                        case "A_DTS/EXPRESS":
                                            b4 = 21;
                                            break;
                                        case "A_PCM/FLOAT/IEEE":
                                            b4 = 22;
                                            break;
                                        case "A_PCM/INT/BIG":
                                            b4 = 23;
                                            break;
                                        case "A_PCM/INT/LIT":
                                            b4 = 24;
                                            break;
                                        case "S_TEXT/ASS":
                                            b4 = 25;
                                            break;
                                        case "S_TEXT/SSA":
                                            b4 = 26;
                                            break;
                                        case "V_MPEGH/ISO/HEVC":
                                            b4 = 27;
                                            break;
                                        case "S_TEXT/WEBVTT":
                                            b4 = 28;
                                            break;
                                        case "S_TEXT/UTF8":
                                            b4 = 29;
                                            break;
                                        case "V_MPEG2":
                                            b4 = 30;
                                            break;
                                        case "A_EAC3":
                                            b4 = 31;
                                            break;
                                        case "A_FLAC":
                                            b4 = 32;
                                            break;
                                        case "A_OPUS":
                                            b4 = 33;
                                            break;
                                        default:
                                            b4 = -1;
                                            break;
                                    }
                                    String str9 = "video/x-unknown";
                                    switch (b4) {
                                        case 0:
                                        case 1:
                                        case 9:
                                            byte[] bArr4 = track.codecPrivate;
                                            listSingletonList = bArr4 == null ? null : Collections.singletonList(bArr4);
                                            str9 = "video/mp4v-es";
                                            listOf = listSingletonList;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null && (joiner = Joiner.parse(new ParsableByteArray(track.dolbyVisionConfigBytes))) != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z7 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i19 = (z7 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5 || (i7 = track.displayHeight) == i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = (track.height * i6) / (track.width * i7);
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f || track.primaryRChromaticityY == -1.0f || track.primaryGChromaticityX == -1.0f || track.primaryGChromaticityY == -1.0f || track.primaryBChromaticityX == -1.0f || track.primaryBChromaticityY == -1.0f || track.whitePointChromaticityX == -1.0f || track.whitePointChromaticityY == -1.0f || track.maxMasteringLuminance == -1.0f || track.minMasteringLuminance == -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        byte[] bArr5 = new byte[25];
                                                        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr5).order(ByteOrder.LITTLE_ENDIAN);
                                                        byteBufferOrder.put((byte) 0);
                                                        byteBufferOrder.putShort((short) ((track.primaryRChromaticityX * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.primaryRChromaticityY * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.primaryGChromaticityX * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.primaryGChromaticityY * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.primaryBChromaticityX * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.primaryBChromaticityY * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.whitePointChromaticityX * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) ((track.whitePointChromaticityY * 50000.0f) + 0.5f));
                                                        byteBufferOrder.putShort((short) (track.maxMasteringLuminance + 0.5f));
                                                        byteBufferOrder.putShort((short) (track.minMasteringLuminance + 0.5f));
                                                        byteBufferOrder.putShort((short) track.maxContentLuminance);
                                                        byteBufferOrder.putShort((short) track.maxFrameAverageLuminance);
                                                        bArr = bArr5;
                                                    }
                                                    int i20 = track.colorSpace;
                                                    int i21 = track.colorRange;
                                                    int i22 = track.colorTransfer;
                                                    int i23 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i20, i21, i22, bArr, i23, i23);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null && map.containsKey(str5)) {
                                                    iIntValue = ((Integer) map.get(track.name)).intValue();
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0 && Float.compare(track.projectionPoseYaw, CropImageView.DEFAULT_ASPECT_RATIO) == 0 && Float.compare(track.projectionPosePitch, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0 || Float.compare(track.projectionPoseRoll, 180.0f) == 0) {
                                                        iIntValue = 180;
                                                    } else if (Float.compare(track.projectionPoseRoll, -90.0f) == 0) {
                                                        iIntValue = 270;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9) && !"text/x-ssa".equals(str9) && !"text/vtt".equals(str9) && !"application/vobsub".equals(str9) && !"application/pgs".equals(str9) && !"application/dvbsubs".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null && !map.containsKey(str6)) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i19;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 2:
                                            ParsableByteArray parsableByteArray = new ParsableByteArray(track.getCodecPrivate(track.codecId));
                                            try {
                                                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                                                if (littleEndianUnsignedShort != 1) {
                                                    if (littleEndianUnsignedShort == 65534) {
                                                        parsableByteArray.setPosition(24);
                                                        long j7 = parsableByteArray.readLong();
                                                        UUID uuid = WAVE_SUBFORMAT_PCM;
                                                        if (j7 != uuid.getMostSignificantBits() || parsableByteArray.readLong() != uuid.getLeastSignificantBits()) {
                                                        }
                                                        str9 = "audio/x-unknown";
                                                        pcmEncoding = -1;
                                                        i3 = -1;
                                                        str3 = null;
                                                        list3 = null;
                                                        if (track.dolbyVisionConfigBytes != null) {
                                                            str3 = joiner.separator;
                                                            str9 = "video/dolby-vision";
                                                        }
                                                        boolean z8 = track.flagDefault;
                                                        if (track.flagForced) {
                                                            i4 = 2;
                                                        } else {
                                                            i4 = 0;
                                                        }
                                                        int i110 = (z8 ? 1 : 0) | i4;
                                                        builder = new Format.Builder();
                                                        zIsAudio = MimeTypes.isAudio(str9);
                                                        Map map2 = TRACK_NAME_TO_ROTATION_DEGREES;
                                                        if (zIsAudio) {
                                                            builder.channelCount = track.channelCount;
                                                            builder.sampleRate = track.sampleRate;
                                                            builder.pcmEncoding = pcmEncoding;
                                                        } else if (MimeTypes.isVideo(str9)) {
                                                            if (track.displayUnit == 0) {
                                                                i8 = track.displayWidth;
                                                                i5 = -1;
                                                                if (i8 == -1) {
                                                                    i8 = track.width;
                                                                }
                                                                track.displayWidth = i8;
                                                                i9 = track.displayHeight;
                                                                if (i9 == -1) {
                                                                    i9 = track.height;
                                                                }
                                                                track.displayHeight = i9;
                                                            } else {
                                                                i5 = -1;
                                                            }
                                                            i6 = track.displayWidth;
                                                            if (i6 != i5) {
                                                                f = -1.0f;
                                                            } else {
                                                                f = -1.0f;
                                                            }
                                                            if (track.hasColorInfo) {
                                                                if (track.primaryRChromaticityX != -1.0f) {
                                                                    bArr = null;
                                                                } else {
                                                                    bArr = null;
                                                                }
                                                                int i24 = track.colorSpace;
                                                                int i25 = track.colorRange;
                                                                int i26 = track.colorTransfer;
                                                                int i27 = track.bitsPerChannel;
                                                                colorInfo = new ColorInfo(i24, i25, i26, bArr, i27, i27);
                                                            } else {
                                                                colorInfo = null;
                                                            }
                                                            str5 = track.name;
                                                            if (str5 == null) {
                                                                iIntValue = -1;
                                                            } else {
                                                                iIntValue = -1;
                                                            }
                                                            if (track.projectionType == 0) {
                                                                if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                                    iIntValue = 0;
                                                                } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                                    iIntValue = 90;
                                                                } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                                    iIntValue = 180;
                                                                } else {
                                                                    iIntValue = 180;
                                                                }
                                                            }
                                                            builder.width = track.width;
                                                            builder.height = track.height;
                                                            builder.pixelWidthHeightRatio = f;
                                                            builder.rotationDegrees = iIntValue;
                                                            builder.projectionData = track.projectionData;
                                                            builder.stereoMode = track.stereoMode;
                                                            builder.colorInfo = colorInfo;
                                                        } else if (!"application/x-subrip".equals(str9)) {
                                                            throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                                        }
                                                        str6 = track.name;
                                                        if (str6 != null) {
                                                            builder.label = track.name;
                                                        }
                                                        builder.id = Integer.toString(i18);
                                                        if (track.isWebm) {
                                                            str7 = "video/webm";
                                                        } else {
                                                            str7 = "video/x-matroska";
                                                        }
                                                        builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                                        builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                                        builder.maxInputSize = i3;
                                                        builder.language = track.language;
                                                        builder.selectionFlags = i110;
                                                        builder.initializationData = list3;
                                                        builder.codecs = str3;
                                                        builder.drmInitData = track.drmInitData;
                                                        track.format = new Format(builder);
                                                        track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                                        sparseArray2.put(track.number, track);
                                                    }
                                                    Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                                    str9 = "audio/x-unknown";
                                                    pcmEncoding = -1;
                                                    i3 = -1;
                                                    str3 = null;
                                                    list3 = null;
                                                    if (track.dolbyVisionConfigBytes != null) {
                                                        str3 = joiner.separator;
                                                        str9 = "video/dolby-vision";
                                                    }
                                                    boolean z9 = track.flagDefault;
                                                    if (track.flagForced) {
                                                        i4 = 2;
                                                    } else {
                                                        i4 = 0;
                                                    }
                                                    int i111 = (z9 ? 1 : 0) | i4;
                                                    builder = new Format.Builder();
                                                    zIsAudio = MimeTypes.isAudio(str9);
                                                    Map map3 = TRACK_NAME_TO_ROTATION_DEGREES;
                                                    if (zIsAudio) {
                                                        builder.channelCount = track.channelCount;
                                                        builder.sampleRate = track.sampleRate;
                                                        builder.pcmEncoding = pcmEncoding;
                                                    } else if (MimeTypes.isVideo(str9)) {
                                                        if (track.displayUnit == 0) {
                                                            i8 = track.displayWidth;
                                                            i5 = -1;
                                                            if (i8 == -1) {
                                                                i8 = track.width;
                                                            }
                                                            track.displayWidth = i8;
                                                            i9 = track.displayHeight;
                                                            if (i9 == -1) {
                                                                i9 = track.height;
                                                            }
                                                            track.displayHeight = i9;
                                                        } else {
                                                            i5 = -1;
                                                        }
                                                        i6 = track.displayWidth;
                                                        if (i6 != i5) {
                                                            f = -1.0f;
                                                        } else {
                                                            f = -1.0f;
                                                        }
                                                        if (track.hasColorInfo) {
                                                            if (track.primaryRChromaticityX != -1.0f) {
                                                                bArr = null;
                                                            } else {
                                                                bArr = null;
                                                            }
                                                            int i28 = track.colorSpace;
                                                            int i29 = track.colorRange;
                                                            int i210 = track.colorTransfer;
                                                            int i211 = track.bitsPerChannel;
                                                            colorInfo = new ColorInfo(i28, i29, i210, bArr, i211, i211);
                                                        } else {
                                                            colorInfo = null;
                                                        }
                                                        str5 = track.name;
                                                        if (str5 == null) {
                                                            iIntValue = -1;
                                                        } else {
                                                            iIntValue = -1;
                                                        }
                                                        if (track.projectionType == 0) {
                                                            if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                                iIntValue = 0;
                                                            } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                                iIntValue = 90;
                                                            } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                                iIntValue = 180;
                                                            } else {
                                                                iIntValue = 180;
                                                            }
                                                        }
                                                        builder.width = track.width;
                                                        builder.height = track.height;
                                                        builder.pixelWidthHeightRatio = f;
                                                        builder.rotationDegrees = iIntValue;
                                                        builder.projectionData = track.projectionData;
                                                        builder.stereoMode = track.stereoMode;
                                                        builder.colorInfo = colorInfo;
                                                    } else if (!"application/x-subrip".equals(str9)) {
                                                        throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                                    }
                                                    str6 = track.name;
                                                    if (str6 != null) {
                                                        builder.label = track.name;
                                                    }
                                                    builder.id = Integer.toString(i18);
                                                    if (track.isWebm) {
                                                        str7 = "video/webm";
                                                    } else {
                                                        str7 = "video/x-matroska";
                                                    }
                                                    builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                                    builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                                    builder.maxInputSize = i3;
                                                    builder.language = track.language;
                                                    builder.selectionFlags = i111;
                                                    builder.initializationData = list3;
                                                    builder.codecs = str3;
                                                    builder.drmInitData = track.drmInitData;
                                                    track.format = new Format(builder);
                                                    track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                                    sparseArray2.put(track.number, track);
                                                    break;
                                                }
                                                int i30 = track.audioBitDepth;
                                                String str10 = Util.DEVICE_DEBUG_INFO;
                                                pcmEncoding = Util.getPcmEncoding(i30, ByteOrder.LITTLE_ENDIAN);
                                                if (pcmEncoding == 0) {
                                                    Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + track.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                                                    str9 = "audio/x-unknown";
                                                    pcmEncoding = -1;
                                                } else {
                                                    str9 = "audio/raw";
                                                }
                                                i3 = -1;
                                                str3 = null;
                                                list3 = null;
                                                if (track.dolbyVisionConfigBytes != null) {
                                                    str3 = joiner.separator;
                                                    str9 = "video/dolby-vision";
                                                }
                                                boolean z10 = track.flagDefault;
                                                if (track.flagForced) {
                                                    i4 = 2;
                                                } else {
                                                    i4 = 0;
                                                }
                                                int i112 = (z10 ? 1 : 0) | i4;
                                                builder = new Format.Builder();
                                                zIsAudio = MimeTypes.isAudio(str9);
                                                Map map4 = TRACK_NAME_TO_ROTATION_DEGREES;
                                                if (zIsAudio) {
                                                    builder.channelCount = track.channelCount;
                                                    builder.sampleRate = track.sampleRate;
                                                    builder.pcmEncoding = pcmEncoding;
                                                } else if (MimeTypes.isVideo(str9)) {
                                                    if (track.displayUnit == 0) {
                                                        i8 = track.displayWidth;
                                                        i5 = -1;
                                                        if (i8 == -1) {
                                                            i8 = track.width;
                                                        }
                                                        track.displayWidth = i8;
                                                        i9 = track.displayHeight;
                                                        if (i9 == -1) {
                                                            i9 = track.height;
                                                        }
                                                        track.displayHeight = i9;
                                                    } else {
                                                        i5 = -1;
                                                    }
                                                    i6 = track.displayWidth;
                                                    if (i6 != i5) {
                                                        f = -1.0f;
                                                    } else {
                                                        f = -1.0f;
                                                    }
                                                    if (track.hasColorInfo) {
                                                        if (track.primaryRChromaticityX != -1.0f) {
                                                            bArr = null;
                                                        } else {
                                                            bArr = null;
                                                        }
                                                        int i212 = track.colorSpace;
                                                        int i213 = track.colorRange;
                                                        int i214 = track.colorTransfer;
                                                        int i215 = track.bitsPerChannel;
                                                        colorInfo = new ColorInfo(i212, i213, i214, bArr, i215, i215);
                                                    } else {
                                                        colorInfo = null;
                                                    }
                                                    str5 = track.name;
                                                    if (str5 == null) {
                                                        iIntValue = -1;
                                                    } else {
                                                        iIntValue = -1;
                                                    }
                                                    if (track.projectionType == 0) {
                                                        if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                            iIntValue = 0;
                                                        } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                            iIntValue = 90;
                                                        } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                            iIntValue = 180;
                                                        } else {
                                                            iIntValue = 180;
                                                        }
                                                    }
                                                    builder.width = track.width;
                                                    builder.height = track.height;
                                                    builder.pixelWidthHeightRatio = f;
                                                    builder.rotationDegrees = iIntValue;
                                                    builder.projectionData = track.projectionData;
                                                    builder.stereoMode = track.stereoMode;
                                                    builder.colorInfo = colorInfo;
                                                } else if (!"application/x-subrip".equals(str9)) {
                                                    throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                                }
                                                str6 = track.name;
                                                if (str6 != null) {
                                                    builder.label = track.name;
                                                }
                                                builder.id = Integer.toString(i18);
                                                if (track.isWebm) {
                                                    str7 = "video/webm";
                                                } else {
                                                    str7 = "video/x-matroska";
                                                }
                                                builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                                builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                                builder.maxInputSize = i3;
                                                builder.language = track.language;
                                                builder.selectionFlags = i112;
                                                builder.initializationData = list3;
                                                builder.codecs = str3;
                                                builder.drmInitData = track.drmInitData;
                                                track.format = new Format(builder);
                                                track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                                sparseArray2.put(track.number, track);
                                            } catch (ArrayIndexOutOfBoundsException unused) {
                                                throw ParserException.createForMalformedContainer(null, "Error parsing MS/ACM codec private");
                                            }
                                            break;
                                        case 3:
                                            track.trueHdSampleRechunker = new TrueHdSampleRechunker();
                                            str9 = "audio/true-hd";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z11 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i113 = (z11 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map5 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i216 = track.colorSpace;
                                                    int i217 = track.colorRange;
                                                    int i218 = track.colorTransfer;
                                                    int i219 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i216, i217, i218, bArr, i219, i219);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i113;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 4:
                                            byte[] codecPrivate = track.getCodecPrivate(str8);
                                            try {
                                                r3 = codecPrivate[0];
                                                try {
                                                    if (r3 != 2) {
                                                        throw ParserException.createForMalformedContainer(null, "Error parsing vorbis codec private");
                                                    }
                                                    int i31 = 0;
                                                    int i32 = 1;
                                                    while (true) {
                                                        int i33 = codecPrivate[i32] & 255;
                                                        if (i33 != 255) {
                                                            int i34 = i32 + 1;
                                                            int i35 = i31 + i33;
                                                            int i36 = 0;
                                                            while (true) {
                                                                int i37 = codecPrivate[i34] & 255;
                                                                if (i37 != 255) {
                                                                    int i38 = i34 + 1;
                                                                    int i39 = i36 + i37;
                                                                    if (codecPrivate[i38] != 1) {
                                                                        throw ParserException.createForMalformedContainer(null, "Error parsing vorbis codec private");
                                                                    }
                                                                    byte[] bArr6 = new byte[i35];
                                                                    System.arraycopy(codecPrivate, i38, bArr6, 0, i35);
                                                                    int i40 = i38 + i35;
                                                                    if (codecPrivate[i40] != 3) {
                                                                        throw ParserException.createForMalformedContainer(null, "Error parsing vorbis codec private");
                                                                    }
                                                                    int i41 = i40 + i39;
                                                                    if (codecPrivate[i41] != 5) {
                                                                        throw ParserException.createForMalformedContainer(null, "Error parsing vorbis codec private");
                                                                    }
                                                                    byte[] bArr7 = new byte[codecPrivate.length - i41];
                                                                    System.arraycopy(codecPrivate, i41, bArr7, 0, codecPrivate.length - i41);
                                                                    ArrayList arrayList2 = new ArrayList(2);
                                                                    arrayList2.add(bArr6);
                                                                    arrayList2.add(bArr7);
                                                                    str9 = "audio/vorbis";
                                                                    i3 = 8192;
                                                                    arrayList = arrayList2;
                                                                    pcmEncoding = -1;
                                                                    list4 = arrayList;
                                                                    str3 = null;
                                                                    list3 = list4;
                                                                    if (track.dolbyVisionConfigBytes != null) {
                                                                        str3 = joiner.separator;
                                                                        str9 = "video/dolby-vision";
                                                                    }
                                                                    boolean z12 = track.flagDefault;
                                                                    if (track.flagForced) {
                                                                        i4 = 2;
                                                                    } else {
                                                                        i4 = 0;
                                                                    }
                                                                    int i114 = (z12 ? 1 : 0) | i4;
                                                                    builder = new Format.Builder();
                                                                    zIsAudio = MimeTypes.isAudio(str9);
                                                                    Map map6 = TRACK_NAME_TO_ROTATION_DEGREES;
                                                                    if (zIsAudio) {
                                                                        builder.channelCount = track.channelCount;
                                                                        builder.sampleRate = track.sampleRate;
                                                                        builder.pcmEncoding = pcmEncoding;
                                                                    } else if (MimeTypes.isVideo(str9)) {
                                                                        if (track.displayUnit == 0) {
                                                                            i8 = track.displayWidth;
                                                                            i5 = -1;
                                                                            if (i8 == -1) {
                                                                                i8 = track.width;
                                                                            }
                                                                            track.displayWidth = i8;
                                                                            i9 = track.displayHeight;
                                                                            if (i9 == -1) {
                                                                                i9 = track.height;
                                                                            }
                                                                            track.displayHeight = i9;
                                                                        } else {
                                                                            i5 = -1;
                                                                        }
                                                                        i6 = track.displayWidth;
                                                                        if (i6 != i5) {
                                                                            f = -1.0f;
                                                                        } else {
                                                                            f = -1.0f;
                                                                        }
                                                                        if (track.hasColorInfo) {
                                                                            if (track.primaryRChromaticityX != -1.0f) {
                                                                                bArr = null;
                                                                            } else {
                                                                                bArr = null;
                                                                            }
                                                                            int i2110 = track.colorSpace;
                                                                            int i2111 = track.colorRange;
                                                                            int i2112 = track.colorTransfer;
                                                                            int i2113 = track.bitsPerChannel;
                                                                            colorInfo = new ColorInfo(i2110, i2111, i2112, bArr, i2113, i2113);
                                                                        } else {
                                                                            colorInfo = null;
                                                                        }
                                                                        str5 = track.name;
                                                                        if (str5 == null) {
                                                                            iIntValue = -1;
                                                                        } else {
                                                                            iIntValue = -1;
                                                                        }
                                                                        if (track.projectionType == 0) {
                                                                            if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                                                iIntValue = 0;
                                                                            } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                                                iIntValue = 90;
                                                                            } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                                                iIntValue = 180;
                                                                            } else {
                                                                                iIntValue = 180;
                                                                            }
                                                                        }
                                                                        builder.width = track.width;
                                                                        builder.height = track.height;
                                                                        builder.pixelWidthHeightRatio = f;
                                                                        builder.rotationDegrees = iIntValue;
                                                                        builder.projectionData = track.projectionData;
                                                                        builder.stereoMode = track.stereoMode;
                                                                        builder.colorInfo = colorInfo;
                                                                    } else if (!"application/x-subrip".equals(str9)) {
                                                                        throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                                                    }
                                                                    str6 = track.name;
                                                                    if (str6 != null) {
                                                                        builder.label = track.name;
                                                                    }
                                                                    builder.id = Integer.toString(i18);
                                                                    if (track.isWebm) {
                                                                        str7 = "video/webm";
                                                                    } else {
                                                                        str7 = "video/x-matroska";
                                                                    }
                                                                    builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                                                    builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                                                    builder.maxInputSize = i3;
                                                                    builder.language = track.language;
                                                                    builder.selectionFlags = i114;
                                                                    builder.initializationData = list3;
                                                                    builder.codecs = str3;
                                                                    builder.drmInitData = track.drmInitData;
                                                                    track.format = new Format(builder);
                                                                    track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                                                    sparseArray2.put(track.number, track);
                                                                } else {
                                                                    i36 += 255;
                                                                    i34++;
                                                                }
                                                            }
                                                        } else {
                                                            i31 += 255;
                                                            i32++;
                                                        }
                                                    }
                                                } catch (ArrayIndexOutOfBoundsException unused2) {
                                                    throw ParserException.createForMalformedContainer(r3, "Error parsing vorbis codec private");
                                                }
                                            } catch (ArrayIndexOutOfBoundsException unused3) {
                                                r3 = 0;
                                            }
                                            break;
                                        case 5:
                                            str9 = "audio/mpeg-L2";
                                            pcmEncoding = -1;
                                            i3 = 4096;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z13 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i115 = (z13 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map7 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2114 = track.colorSpace;
                                                    int i2115 = track.colorRange;
                                                    int i2116 = track.colorTransfer;
                                                    int i2117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2114, i2115, i2116, bArr, i2117, i2117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i115;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 6:
                                            str9 = "audio/mpeg";
                                            pcmEncoding = -1;
                                            i3 = 4096;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z14 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i116 = (z14 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map8 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2118 = track.colorSpace;
                                                    int i2119 = track.colorRange;
                                                    int i21110 = track.colorTransfer;
                                                    int i21111 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2118, i2119, i21110, bArr, i21111, i21111);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i116;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 7:
                                            ParsableByteArray parsableByteArray2 = new ParsableByteArray(track.getCodecPrivate(track.codecId));
                                            try {
                                                parsableByteArray2.skipBytes(16);
                                                long littleEndianUnsignedInt = parsableByteArray2.readLittleEndianUnsignedInt();
                                                if (littleEndianUnsignedInt == 1482049860) {
                                                    try {
                                                        pair = new Pair("video/divx", null);
                                                        str2 = null;
                                                    } catch (ArrayIndexOutOfBoundsException unused4) {
                                                        runtimeException = null;
                                                    }
                                                } else {
                                                    if (littleEndianUnsignedInt == 859189832) {
                                                        pair = new Pair("video/3gpp", null);
                                                    } else {
                                                        if (littleEndianUnsignedInt == 826496599) {
                                                            int i42 = parsableByteArray2.position + 20;
                                                            byte[] bArr8 = parsableByteArray2.data;
                                                            while (true) {
                                                                if (i42 < bArr8.length - 4) {
                                                                    if (bArr8[i42] == 0 && bArr8[i42 + 1] == 0 && bArr8[i42 + 2] == 1) {
                                                                        if (bArr8[i42 + 3] == 15) {
                                                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr8, i42, bArr8.length)));
                                                                        }
                                                                    }
                                                                    i42++;
                                                                } else {
                                                                    runtimeException = null;
                                                                    try {
                                                                        throw ParserException.createForMalformedContainer(null, "Failed to find FourCC VC1 initialization data");
                                                                    } catch (ArrayIndexOutOfBoundsException unused5) {
                                                                    }
                                                                }
                                                                throw ParserException.createForMalformedContainer(runtimeException, "Error parsing FourCC private data");
                                                            }
                                                        }
                                                        Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                                                        str2 = null;
                                                        pair = new Pair("video/x-unknown", null);
                                                    }
                                                    str2 = null;
                                                }
                                                str9 = (String) pair.first;
                                                str3 = str2;
                                                list = (List) pair.second;
                                                pcmEncoding = -1;
                                                i3 = -1;
                                                list3 = list;
                                                if (track.dolbyVisionConfigBytes != null) {
                                                    str3 = joiner.separator;
                                                    str9 = "video/dolby-vision";
                                                }
                                                boolean z15 = track.flagDefault;
                                                if (track.flagForced) {
                                                    i4 = 2;
                                                } else {
                                                    i4 = 0;
                                                }
                                                int i117 = (z15 ? 1 : 0) | i4;
                                                builder = new Format.Builder();
                                                zIsAudio = MimeTypes.isAudio(str9);
                                                Map map9 = TRACK_NAME_TO_ROTATION_DEGREES;
                                                if (zIsAudio) {
                                                    builder.channelCount = track.channelCount;
                                                    builder.sampleRate = track.sampleRate;
                                                    builder.pcmEncoding = pcmEncoding;
                                                } else if (MimeTypes.isVideo(str9)) {
                                                    if (track.displayUnit == 0) {
                                                        i8 = track.displayWidth;
                                                        i5 = -1;
                                                        if (i8 == -1) {
                                                            i8 = track.width;
                                                        }
                                                        track.displayWidth = i8;
                                                        i9 = track.displayHeight;
                                                        if (i9 == -1) {
                                                            i9 = track.height;
                                                        }
                                                        track.displayHeight = i9;
                                                    } else {
                                                        i5 = -1;
                                                    }
                                                    i6 = track.displayWidth;
                                                    if (i6 != i5) {
                                                        f = -1.0f;
                                                    } else {
                                                        f = -1.0f;
                                                    }
                                                    if (track.hasColorInfo) {
                                                        if (track.primaryRChromaticityX != -1.0f) {
                                                            bArr = null;
                                                        } else {
                                                            bArr = null;
                                                        }
                                                        int i21112 = track.colorSpace;
                                                        int i21113 = track.colorRange;
                                                        int i21114 = track.colorTransfer;
                                                        int i21115 = track.bitsPerChannel;
                                                        colorInfo = new ColorInfo(i21112, i21113, i21114, bArr, i21115, i21115);
                                                    } else {
                                                        colorInfo = null;
                                                    }
                                                    str5 = track.name;
                                                    if (str5 == null) {
                                                        iIntValue = -1;
                                                    } else {
                                                        iIntValue = -1;
                                                    }
                                                    if (track.projectionType == 0) {
                                                        if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                            iIntValue = 0;
                                                        } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                            iIntValue = 90;
                                                        } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                            iIntValue = 180;
                                                        } else {
                                                            iIntValue = 180;
                                                        }
                                                    }
                                                    builder.width = track.width;
                                                    builder.height = track.height;
                                                    builder.pixelWidthHeightRatio = f;
                                                    builder.rotationDegrees = iIntValue;
                                                    builder.projectionData = track.projectionData;
                                                    builder.stereoMode = track.stereoMode;
                                                    builder.colorInfo = colorInfo;
                                                } else if (!"application/x-subrip".equals(str9)) {
                                                    throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                                }
                                                str6 = track.name;
                                                if (str6 != null) {
                                                    builder.label = track.name;
                                                }
                                                builder.id = Integer.toString(i18);
                                                if (track.isWebm) {
                                                    str7 = "video/webm";
                                                } else {
                                                    str7 = "video/x-matroska";
                                                }
                                                builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                                builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                                builder.maxInputSize = i3;
                                                builder.language = track.language;
                                                builder.selectionFlags = i117;
                                                builder.initializationData = list3;
                                                builder.codecs = str3;
                                                builder.drmInitData = track.drmInitData;
                                                track.format = new Format(builder);
                                                track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                                sparseArray2.put(track.number, track);
                                            } catch (ArrayIndexOutOfBoundsException unused6) {
                                                runtimeException = null;
                                            }
                                            break;
                                        case 8:
                                            byte[] bArr9 = new byte[4];
                                            System.arraycopy(track.getCodecPrivate(str8), 0, bArr9, 0, 4);
                                            listOf = ImmutableList.of((Object) bArr9);
                                            str9 = "application/dvbsubs";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z16 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i118 = (z16 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map10 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21116 = track.colorSpace;
                                                    int i21117 = track.colorRange;
                                                    int i21118 = track.colorTransfer;
                                                    int i21119 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21116, i21117, i21118, bArr, i21119, i21119);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i118;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 10:
                                            AvcConfig avcConfig = AvcConfig.parse(new ParsableByteArray(track.getCodecPrivate(track.codecId)));
                                            ArrayList arrayList3 = avcConfig.initializationData;
                                            track.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                                            str4 = avcConfig.codecs;
                                            str9 = "video/avc";
                                            list2 = arrayList3;
                                            str3 = str4;
                                            list = list2;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list3 = list;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z17 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i119 = (z17 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map11 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211110 = track.colorSpace;
                                                    int i211111 = track.colorRange;
                                                    int i211112 = track.colorTransfer;
                                                    int i211113 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211110, i211111, i211112, bArr, i211113, i211113);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i119;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 11:
                                            listOf = ImmutableList.of((Object) track.getCodecPrivate(str8));
                                            str9 = "application/vobsub";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z18 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1110 = (z18 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map12 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211114 = track.colorSpace;
                                                    int i211115 = track.colorRange;
                                                    int i211116 = track.colorTransfer;
                                                    int i211117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211114, i211115, i211116, bArr, i211117, i211117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1110;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                                            str9 = "audio/vnd.dts.hd";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z19 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1111 = (z19 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map13 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211118 = track.colorSpace;
                                                    int i211119 = track.colorRange;
                                                    int i2111110 = track.colorTransfer;
                                                    int i2111111 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211118, i211119, i2111110, bArr, i2111111, i2111111);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1111;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 13:
                                            List listSingletonList2 = Collections.singletonList(track.getCodecPrivate(str8));
                                            byte[] bArr10 = track.codecPrivate;
                                            NavOptions.Builder audioSpecificConfig = AacUtil.parseAudioSpecificConfig(new VorbisBitArray(bArr10, bArr10.length), false);
                                            track.sampleRate = audioSpecificConfig.enterAnim;
                                            track.channelCount = audioSpecificConfig.exitAnim;
                                            str9 = "audio/mp4a-latm";
                                            list = listSingletonList2;
                                            str3 = audioSpecificConfig.popUpToRoute;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list3 = list;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z110 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1112 = (z110 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map14 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111112 = track.colorSpace;
                                                    int i2111113 = track.colorRange;
                                                    int i2111114 = track.colorTransfer;
                                                    int i2111115 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111112, i2111113, i2111114, bArr, i2111115, i2111115);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1112;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 14:
                                            str9 = "audio/ac3";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z111 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1113 = (z111 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map15 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111116 = track.colorSpace;
                                                    int i2111117 = track.colorRange;
                                                    int i2111118 = track.colorTransfer;
                                                    int i2111119 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111116, i2111117, i2111118, bArr, i2111119, i2111119);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1113;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 15:
                                        case 21:
                                            track.waitingForDtsAnalysis = true;
                                            str9 = "audio/vnd.dts";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z112 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1114 = (z112 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map16 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111110 = track.colorSpace;
                                                    int i21111111 = track.colorRange;
                                                    int i21111112 = track.colorTransfer;
                                                    int i21111113 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111110, i21111111, i21111112, bArr, i21111113, i21111113);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1114;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 16:
                                            byte[] bArr11 = track.codecPrivate;
                                            listSingletonList = bArr11 == null ? null : ImmutableList.of((Object) bArr11);
                                            str9 = "video/av01";
                                            listOf = listSingletonList;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z113 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1115 = (z113 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map17 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111114 = track.colorSpace;
                                                    int i21111115 = track.colorRange;
                                                    int i21111116 = track.colorTransfer;
                                                    int i21111117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111114, i21111115, i21111116, bArr, i21111117, i21111117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1115;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 17:
                                            str9 = "video/x-vnd.on2.vp8";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z114 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1116 = (z114 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map18 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111118 = track.colorSpace;
                                                    int i21111119 = track.colorRange;
                                                    int i211111110 = track.colorTransfer;
                                                    int i211111111 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111118, i21111119, i211111110, bArr, i211111111, i211111111);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1116;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 18:
                                            byte[] bArr12 = track.codecPrivate;
                                            listSingletonList = bArr12 == null ? null : ImmutableList.of((Object) bArr12);
                                            str9 = "video/x-vnd.on2.vp9";
                                            listOf = listSingletonList;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z115 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1117 = (z115 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map19 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211111112 = track.colorSpace;
                                                    int i211111113 = track.colorRange;
                                                    int i211111114 = track.colorTransfer;
                                                    int i211111115 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211111112, i211111113, i211111114, bArr, i211111115, i211111115);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1117;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 19:
                                            str9 = "application/pgs";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z116 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1118 = (z116 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map110 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211111116 = track.colorSpace;
                                                    int i211111117 = track.colorRange;
                                                    int i211111118 = track.colorTransfer;
                                                    int i211111119 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211111116, i211111117, i211111118, bArr, i211111119, i211111119);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1118;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 20:
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z117 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i1119 = (z117 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map111 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111111110 = track.colorSpace;
                                                    int i2111111111 = track.colorRange;
                                                    int i2111111112 = track.colorTransfer;
                                                    int i2111111113 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111111110, i2111111111, i2111111112, bArr, i2111111113, i2111111113);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i1119;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 22:
                                            if (track.audioBitDepth == 32) {
                                                str9 = "audio/raw";
                                                pcmEncoding = 4;
                                            } else {
                                                Log.w("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + track.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                                                str9 = "audio/x-unknown";
                                                pcmEncoding = -1;
                                            }
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z118 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11110 = (z118 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map112 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111111114 = track.colorSpace;
                                                    int i2111111115 = track.colorRange;
                                                    int i2111111116 = track.colorTransfer;
                                                    int i2111111117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111111114, i2111111115, i2111111116, bArr, i2111111117, i2111111117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11110;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 23:
                                            int i43 = track.audioBitDepth;
                                            if (i43 == 8) {
                                                str9 = "audio/raw";
                                                pcmEncoding = 3;
                                            } else {
                                                if (i43 == 16) {
                                                    pcmEncoding = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                                                } else if (i43 == 24) {
                                                    pcmEncoding = 1342177280;
                                                } else if (i43 == 32) {
                                                    pcmEncoding = 1610612736;
                                                } else {
                                                    Log.w("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + track.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                                                    str9 = "audio/x-unknown";
                                                    pcmEncoding = -1;
                                                }
                                                str9 = "audio/raw";
                                            }
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z119 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11111 = (z119 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map113 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111111118 = track.colorSpace;
                                                    int i2111111119 = track.colorRange;
                                                    int i21111111110 = track.colorTransfer;
                                                    int i21111111111 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111111118, i2111111119, i21111111110, bArr, i21111111111, i21111111111);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11111;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 24:
                                            int i44 = track.audioBitDepth;
                                            String str11 = Util.DEVICE_DEBUG_INFO;
                                            pcmEncoding = Util.getPcmEncoding(i44, ByteOrder.LITTLE_ENDIAN);
                                            if (pcmEncoding == 0) {
                                                Log.w("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + track.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                                                str9 = "audio/x-unknown";
                                                pcmEncoding = -1;
                                            } else {
                                                str9 = "audio/raw";
                                            }
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1110 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11112 = (z1110 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map114 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111111112 = track.colorSpace;
                                                    int i21111111113 = track.colorRange;
                                                    int i21111111114 = track.colorTransfer;
                                                    int i21111111115 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111111112, i21111111113, i21111111114, bArr, i21111111115, i21111111115);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11112;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 25:
                                        case 26:
                                            listOf = ImmutableList.of((Object) SSA_DIALOGUE_FORMAT, (Object) track.getCodecPrivate(str8));
                                            str9 = "text/x-ssa";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1111 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11113 = (z1111 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map115 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111111116 = track.colorSpace;
                                                    int i21111111117 = track.colorRange;
                                                    int i21111111118 = track.colorTransfer;
                                                    int i21111111119 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111111116, i21111111117, i21111111118, bArr, i21111111119, i21111111119);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11113;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 27:
                                            HevcConfig impl = HevcConfig.parseImpl(new ParsableByteArray(track.getCodecPrivate(track.codecId)), false, null);
                                            List list6 = impl.initializationData;
                                            track.nalUnitLengthFieldLength = impl.nalUnitLengthFieldLength;
                                            str4 = impl.codecs;
                                            str9 = "video/hevc";
                                            list2 = list6;
                                            str3 = str4;
                                            list = list2;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list3 = list;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1112 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11114 = (z1112 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map116 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211111111110 = track.colorSpace;
                                                    int i211111111111 = track.colorRange;
                                                    int i211111111112 = track.colorTransfer;
                                                    int i211111111113 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211111111110, i211111111111, i211111111112, bArr, i211111111113, i211111111113);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11114;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 28:
                                            str9 = "text/vtt";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1113 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11115 = (z1113 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map117 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211111111114 = track.colorSpace;
                                                    int i211111111115 = track.colorRange;
                                                    int i211111111116 = track.colorTransfer;
                                                    int i211111111117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211111111114, i211111111115, i211111111116, bArr, i211111111117, i211111111117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11115;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 29:
                                            str9 = "application/x-subrip";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1114 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11116 = (z1114 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map118 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i211111111118 = track.colorSpace;
                                                    int i211111111119 = track.colorRange;
                                                    int i2111111111110 = track.colorTransfer;
                                                    int i2111111111111 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i211111111118, i211111111119, i2111111111110, bArr, i2111111111111, i2111111111111);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11116;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 30:
                                            str9 = "video/mpeg2";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1115 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11117 = (z1115 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map119 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111111111112 = track.colorSpace;
                                                    int i2111111111113 = track.colorRange;
                                                    int i2111111111114 = track.colorTransfer;
                                                    int i2111111111115 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111111111112, i2111111111113, i2111111111114, bArr, i2111111111115, i2111111111115);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11117;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 31:
                                            str9 = "audio/eac3";
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            str3 = null;
                                            list3 = null;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1116 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11118 = (z1116 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map1110 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i2111111111116 = track.colorSpace;
                                                    int i2111111111117 = track.colorRange;
                                                    int i2111111111118 = track.colorTransfer;
                                                    int i2111111111119 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i2111111111116, i2111111111117, i2111111111118, bArr, i2111111111119, i2111111111119);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11118;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 32:
                                            listSingletonList = Collections.singletonList(track.getCodecPrivate(str8));
                                            str9 = "audio/flac";
                                            listOf = listSingletonList;
                                            pcmEncoding = -1;
                                            i3 = -1;
                                            list4 = listOf;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1117 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i11119 = (z1117 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map1111 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111111111110 = track.colorSpace;
                                                    int i21111111111111 = track.colorRange;
                                                    int i21111111111112 = track.colorTransfer;
                                                    int i21111111111113 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111111111110, i21111111111111, i21111111111112, bArr, i21111111111113, i21111111111113);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i11119;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        case 33:
                                            ArrayList arrayList4 = new ArrayList(3);
                                            arrayList4.add(track.getCodecPrivate(track.codecId));
                                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                                            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                                            arrayList4.add(byteBufferAllocate.order(byteOrder).putLong(track.codecDelayNs).array());
                                            arrayList4.add(ByteBuffer.allocate(8).order(byteOrder).putLong(track.seekPreRollNs).array());
                                            str9 = "audio/opus";
                                            i3 = 5760;
                                            arrayList = arrayList4;
                                            pcmEncoding = -1;
                                            list4 = arrayList;
                                            str3 = null;
                                            list3 = list4;
                                            if (track.dolbyVisionConfigBytes != null) {
                                                str3 = joiner.separator;
                                                str9 = "video/dolby-vision";
                                            }
                                            boolean z1118 = track.flagDefault;
                                            if (track.flagForced) {
                                                i4 = 2;
                                            } else {
                                                i4 = 0;
                                            }
                                            int i111110 = (z1118 ? 1 : 0) | i4;
                                            builder = new Format.Builder();
                                            zIsAudio = MimeTypes.isAudio(str9);
                                            Map map1112 = TRACK_NAME_TO_ROTATION_DEGREES;
                                            if (zIsAudio) {
                                                builder.channelCount = track.channelCount;
                                                builder.sampleRate = track.sampleRate;
                                                builder.pcmEncoding = pcmEncoding;
                                            } else if (MimeTypes.isVideo(str9)) {
                                                if (track.displayUnit == 0) {
                                                    i8 = track.displayWidth;
                                                    i5 = -1;
                                                    if (i8 == -1) {
                                                        i8 = track.width;
                                                    }
                                                    track.displayWidth = i8;
                                                    i9 = track.displayHeight;
                                                    if (i9 == -1) {
                                                        i9 = track.height;
                                                    }
                                                    track.displayHeight = i9;
                                                } else {
                                                    i5 = -1;
                                                }
                                                i6 = track.displayWidth;
                                                if (i6 != i5) {
                                                    f = -1.0f;
                                                } else {
                                                    f = -1.0f;
                                                }
                                                if (track.hasColorInfo) {
                                                    if (track.primaryRChromaticityX != -1.0f) {
                                                        bArr = null;
                                                    } else {
                                                        bArr = null;
                                                    }
                                                    int i21111111111114 = track.colorSpace;
                                                    int i21111111111115 = track.colorRange;
                                                    int i21111111111116 = track.colorTransfer;
                                                    int i21111111111117 = track.bitsPerChannel;
                                                    colorInfo = new ColorInfo(i21111111111114, i21111111111115, i21111111111116, bArr, i21111111111117, i21111111111117);
                                                } else {
                                                    colorInfo = null;
                                                }
                                                str5 = track.name;
                                                if (str5 == null) {
                                                    iIntValue = -1;
                                                } else {
                                                    iIntValue = -1;
                                                }
                                                if (track.projectionType == 0) {
                                                    if (Float.compare(track.projectionPoseRoll, CropImageView.DEFAULT_ASPECT_RATIO) == 0) {
                                                        iIntValue = 0;
                                                    } else if (Float.compare(track.projectionPoseRoll, 90.0f) == 0) {
                                                        iIntValue = 90;
                                                    } else if (Float.compare(track.projectionPoseRoll, -180.0f) != 0) {
                                                        iIntValue = 180;
                                                    } else {
                                                        iIntValue = 180;
                                                    }
                                                }
                                                builder.width = track.width;
                                                builder.height = track.height;
                                                builder.pixelWidthHeightRatio = f;
                                                builder.rotationDegrees = iIntValue;
                                                builder.projectionData = track.projectionData;
                                                builder.stereoMode = track.stereoMode;
                                                builder.colorInfo = colorInfo;
                                            } else if (!"application/x-subrip".equals(str9)) {
                                                throw ParserException.createForMalformedContainer(null, "Unexpected MIME type.");
                                            }
                                            str6 = track.name;
                                            if (str6 != null) {
                                                builder.label = track.name;
                                            }
                                            builder.id = Integer.toString(i18);
                                            if (track.isWebm) {
                                                str7 = "video/webm";
                                            } else {
                                                str7 = "video/x-matroska";
                                            }
                                            builder.containerMimeType = MimeTypes.normalizeMimeType(str7);
                                            builder.sampleMimeType = MimeTypes.normalizeMimeType(str9);
                                            builder.maxInputSize = i3;
                                            builder.language = track.language;
                                            builder.selectionFlags = i111110;
                                            builder.initializationData = list3;
                                            builder.codecs = str3;
                                            builder.drmInitData = track.drmInitData;
                                            track.format = new Format(builder);
                                            track.output = matroskaExtractor3.extractorOutput.track(track.number, track.type);
                                            sparseArray2.put(track.number, track);
                                            break;
                                        default:
                                            throw ParserException.createForMalformedContainer(null, "Unrecognized codec identifier.");
                                    }
                                default:
                                    matroskaExtractor3.currentTrack = null;
                                    break;
                            }
                        } else if (i17 != 183) {
                            if (i17 == 19899) {
                                int i45 = matroskaExtractor3.seekEntryId;
                                if (i45 != -1) {
                                    long j8 = matroskaExtractor3.seekEntryPosition;
                                    if (j8 != -1) {
                                        if (i45 == 475249515) {
                                            matroskaExtractor3.cuesContentPosition = j8;
                                        }
                                    }
                                }
                                throw ParserException.createForMalformedContainer(null, "Mandatory element SeekID or SeekPosition not found");
                            }
                            if (i17 == 25152) {
                                matroskaExtractor3.assertInTrackEntry(i17);
                                Track track2 = matroskaExtractor3.currentTrack;
                                if (track2.hasContentEncryption) {
                                    TrackOutput.CryptoData cryptoData = track2.cryptoData;
                                    if (cryptoData == null) {
                                        throw ParserException.createForMalformedContainer(null, "Encrypted Track found but ContentEncKeyID was not found");
                                    }
                                    track2.drmInitData = new DrmInitData(null, true, new DrmInitData.SchemeData(C.UUID_NIL, null, "video/webm", cryptoData.encryptionKey));
                                }
                            } else if (i17 == 28032) {
                                matroskaExtractor3.assertInTrackEntry(i17);
                                Track track3 = matroskaExtractor3.currentTrack;
                                if (track3.hasContentEncryption && track3.sampleStrippedBytes != null) {
                                    throw ParserException.createForMalformedContainer(null, "Combining encryption and compression is not supported");
                                }
                            } else if (i17 == 357149030) {
                                if (matroskaExtractor3.timecodeScale == -9223372036854775807L) {
                                    matroskaExtractor3.timecodeScale = 1000000L;
                                }
                                long j9 = matroskaExtractor3.durationTimecode;
                                if (j9 != -9223372036854775807L) {
                                    matroskaExtractor3.durationUs = matroskaExtractor3.scaleTimecodeToUs(j9);
                                }
                            } else if (i17 == 374648427) {
                                boolean z20 = z3 ? 1 : 0;
                                if (sparseArray2.size() == 0) {
                                    throw ParserException.createForMalformedContainer(null, "No valid tracks were found");
                                }
                                boolean z21 = (!matroskaExtractor3.seekForCuesEnabled || matroskaExtractor3.cuesContentPosition == -1) ? true : z20 ? 1 : 0;
                                int i46 = -1;
                                int i47 = -1;
                                int i48 = -1;
                                int i49 = -1;
                                for (int i50 = z20 ? 1 : 0; i50 < sparseArray2.size(); i50++) {
                                    Track track4 = (Track) sparseArray2.valueAt(i50);
                                    int i51 = track4.type;
                                    if (i51 == 2) {
                                        if (track4.flagDefault) {
                                            i46 = track4.number;
                                        }
                                        if (i47 == -1) {
                                            i47 = track4.number;
                                        }
                                    } else if (i51 == 1) {
                                        if (track4.flagDefault) {
                                            i48 = track4.number;
                                        }
                                        if (i49 == -1) {
                                            i49 = track4.number;
                                        }
                                    }
                                    if (z21) {
                                        track4.output.getClass();
                                        if (!track4.waitingForDtsAnalysis) {
                                            TrackOutput trackOutput = track4.output;
                                            Format format = track4.format;
                                            format.getClass();
                                            trackOutput.format(format);
                                        }
                                    }
                                }
                                if (i46 != -1) {
                                    matroskaExtractor3.primarySeekTrackNumber = i46;
                                } else if (i47 != -1) {
                                    matroskaExtractor3.primarySeekTrackNumber = i47;
                                } else if (i48 != -1) {
                                    matroskaExtractor3.primarySeekTrackNumber = i48;
                                } else if (i49 != -1) {
                                    matroskaExtractor3.primarySeekTrackNumber = i49;
                                } else {
                                    matroskaExtractor3.primarySeekTrackNumber = sparseArray2.size() > 0 ? ((Track) sparseArray2.valueAt(z20 ? 1 : 0)).number : -1;
                                }
                                if (z21) {
                                    matroskaExtractor3.maybeEndTracks();
                                }
                            } else if (i17 == 475249515 && !matroskaExtractor3.sentSeekMap) {
                                int i52 = z3 ? 1 : 0;
                                while (true) {
                                    if (i52 < sparseArray.size()) {
                                        if (((List) sparseArray.valueAt(i52)).isEmpty()) {
                                            i52++;
                                        } else if (matroskaExtractor3.durationUs != -9223372036854775807L) {
                                            for (int i53 = z3 ? 1 : 0; i53 < sparseArray.size(); i53++) {
                                                Collections.sort((List) sparseArray.valueAt(i53));
                                            }
                                            matroskaExtractor3.extractorOutput.seekMap(new MatroskaSeekMap(sparseArray, matroskaExtractor3.durationUs, matroskaExtractor3.primarySeekTrackNumber, matroskaExtractor3.segmentContentPosition, matroskaExtractor3.segmentContentSize));
                                        }
                                    }
                                    matroskaExtractor3.extractorOutput.seekMap(new SeekMap.Unseekable(matroskaExtractor3.durationUs));
                                }
                                matroskaExtractor3.sentSeekMap = z4;
                                matroskaExtractor3.inCuesElement = z3;
                                int i54 = z3 ? 1 : 0;
                                while (i54 < sparseArray2.size()) {
                                    Track track5 = (Track) sparseArray2.valueAt(i54);
                                    long j10 = matroskaExtractor3.durationUs;
                                    long j11 = matroskaExtractor3.segmentContentPosition;
                                    long j12 = matroskaExtractor3.segmentContentSize;
                                    boolean z22 = z3;
                                    int i55 = z4;
                                    if (track5.type != 2 || (list5 = (List) sparseArray.get(track5.number)) == null || list5.isEmpty()) {
                                        i11 = i54;
                                    } else {
                                        if (list5.isEmpty()) {
                                            i11 = i54;
                                        } else {
                                            i11 = i54;
                                            int iMin = Math.min(list5.size(), 20);
                                            double d = 0.0d;
                                            int i56 = z22 ? 1 : 0;
                                            int i57 = -1;
                                            while (i56 < iMin) {
                                                MatroskaSeekMap.CuePointData cuePointData = (MatroskaSeekMap.CuePointData) list5.get(i56);
                                                long j13 = j11;
                                                long j14 = cuePointData.timeUs;
                                                long j15 = cuePointData.relativePosition;
                                                long j16 = cuePointData.clusterPosition;
                                                if (j14 > 10000000) {
                                                    if (i57 == -1) {
                                                        j = ((MatroskaSeekMap.CuePointData) list5.get(i57 == true ? 1 : 0)).timeUs;
                                                    }
                                                    if (j != -9223372036854775807L) {
                                                        Format format2 = track5.format;
                                                        format2.getClass();
                                                        metadata = format2.metadata;
                                                        thumbnailMetadata = new ThumbnailMetadata(j);
                                                        if (metadata == null) {
                                                            Metadata.Entry[] entryArr = new Metadata.Entry[i55];
                                                            entryArr[z22 ? 1 : 0] = thumbnailMetadata;
                                                            metadataCopyWithAppendedEntries = new Metadata(entryArr);
                                                        } else {
                                                            Metadata.Entry[] entryArr2 = new Metadata.Entry[i55];
                                                            entryArr2[z22 ? 1 : 0] = thumbnailMetadata;
                                                            metadataCopyWithAppendedEntries = metadata.copyWithAppendedEntries(entryArr2);
                                                        }
                                                        Format.Builder builderBuildUpon = track5.format.buildUpon();
                                                        builderBuildUpon.metadata = metadataCopyWithAppendedEntries;
                                                        track5.format = new Format(builderBuildUpon);
                                                    }
                                                } else {
                                                    if (i56 < list5.size() - 1) {
                                                        MatroskaSeekMap.CuePointData cuePointData2 = (MatroskaSeekMap.CuePointData) list5.get(i56 + 1);
                                                        j2 = (cuePointData2.clusterPosition + cuePointData2.relativePosition) - (j16 + j15);
                                                        j3 = cuePointData2.timeUs - j14;
                                                    } else {
                                                        j2 = (j13 + j12) - (j16 + j15);
                                                        j3 = j10 - j14;
                                                    }
                                                    if (j3 > 0) {
                                                        double d2 = j2 / j3;
                                                        if (d2 > d) {
                                                            d = d2;
                                                            i57 = i56;
                                                        }
                                                    }
                                                    i56++;
                                                    j11 = j13;
                                                }
                                            }
                                            if (i57 == -1) {
                                                j = ((MatroskaSeekMap.CuePointData) list5.get(i57 == true ? 1 : 0)).timeUs;
                                            }
                                            if (j != -9223372036854775807L) {
                                                Format format3 = track5.format;
                                                format3.getClass();
                                                metadata = format3.metadata;
                                                thumbnailMetadata = new ThumbnailMetadata(j);
                                                if (metadata == null) {
                                                    Metadata.Entry[] entryArr3 = new Metadata.Entry[i55];
                                                    entryArr3[z22 ? 1 : 0] = thumbnailMetadata;
                                                    metadataCopyWithAppendedEntries = new Metadata(entryArr3);
                                                } else {
                                                    Metadata.Entry[] entryArr4 = new Metadata.Entry[i55];
                                                    entryArr4[z22 ? 1 : 0] = thumbnailMetadata;
                                                    metadataCopyWithAppendedEntries = metadata.copyWithAppendedEntries(entryArr4);
                                                }
                                                Format.Builder builderBuildUpon2 = track5.format.buildUpon();
                                                builderBuildUpon2.metadata = metadataCopyWithAppendedEntries;
                                                track5.format = new Format(builderBuildUpon2);
                                            }
                                        }
                                        j = -9223372036854775807L;
                                        if (j != -9223372036854775807L) {
                                            Format format4 = track5.format;
                                            format4.getClass();
                                            metadata = format4.metadata;
                                            thumbnailMetadata = new ThumbnailMetadata(j);
                                            if (metadata == null) {
                                                Metadata.Entry[] entryArr5 = new Metadata.Entry[i55];
                                                entryArr5[z22 ? 1 : 0] = thumbnailMetadata;
                                                metadataCopyWithAppendedEntries = new Metadata(entryArr5);
                                            } else {
                                                Metadata.Entry[] entryArr6 = new Metadata.Entry[i55];
                                                entryArr6[z22 ? 1 : 0] = thumbnailMetadata;
                                                metadataCopyWithAppendedEntries = metadata.copyWithAppendedEntries(entryArr6);
                                            }
                                            Format.Builder builderBuildUpon3 = track5.format.buildUpon();
                                            builderBuildUpon3.metadata = metadataCopyWithAppendedEntries;
                                            track5.format = new Format(builderBuildUpon3);
                                        }
                                    }
                                    if (!track5.waitingForDtsAnalysis) {
                                        track5.output.getClass();
                                        TrackOutput trackOutput2 = track5.output;
                                        Format format5 = track5.format;
                                        format5.getClass();
                                        trackOutput2.format(format5);
                                    }
                                    i54 = i11 + 1;
                                    z3 = z22 ? 1 : 0;
                                    z4 = true;
                                }
                                matroskaExtractor3.maybeEndTracks();
                                b3 = z3 ? 1 : 0;
                            }
                        } else if (!matroskaExtractor3.sentSeekMap) {
                            matroskaExtractor3.assertInCues(i17);
                            if (matroskaExtractor3.currentCueTimeUs != -9223372036854775807L && (i10 = matroskaExtractor3.currentCueTrackNumber) != -1 && matroskaExtractor3.currentCueClusterPosition != -1) {
                                List arrayList5 = (List) sparseArray.get(i10);
                                if (arrayList5 == null) {
                                    arrayList5 = new ArrayList();
                                    sparseArray.put(matroskaExtractor3.currentCueTrackNumber, arrayList5);
                                }
                                arrayList5.add(new MatroskaSeekMap.CuePointData(matroskaExtractor3.currentCueTimeUs, matroskaExtractor3.segmentContentPosition + matroskaExtractor3.currentCueClusterPosition, matroskaExtractor3.currentCueRelativePosition));
                            }
                        }
                        b3 = 0;
                    } else if (matroskaExtractor3.blockState != 2) {
                        b3 = 0;
                    } else {
                        Track track6 = (Track) sparseArray2.get(matroskaExtractor3.blockTrackNumber);
                        track6.output.getClass();
                        if (matroskaExtractor3.blockGroupDiscardPaddingNs > 0 && "A_OPUS".equals(track6.codecId)) {
                            ParsableByteArray parsableByteArray3 = matroskaExtractor3.supplementalData;
                            byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(matroskaExtractor3.blockGroupDiscardPaddingNs).array();
                            parsableByteArray3.getClass();
                            parsableByteArray3.reset(bArrArray, bArrArray.length);
                        }
                        int i58 = 0;
                        for (int i59 = 0; i59 < matroskaExtractor3.blockSampleCount; i59++) {
                            i58 += matroskaExtractor3.blockSampleSizes[i59];
                        }
                        int i60 = 0;
                        while (i60 < matroskaExtractor3.blockSampleCount) {
                            long j17 = matroskaExtractor3.blockTimeUs + ((long) ((track6.defaultSampleDurationNs * i60) / CIOKt.DEFAULT_HTTP_POOL_SIZE));
                            int i61 = matroskaExtractor3.blockFlags;
                            if (i60 == 0 && !matroskaExtractor3.blockHasReferenceBlock) {
                                i61 |= 1;
                            }
                            int i62 = matroskaExtractor3.blockSampleSizes[i60];
                            int i63 = i58 - i62;
                            matroskaExtractor3.commitSampleToOutput(track6, j17, i61, i62, i63);
                            i60++;
                            i58 = i63;
                        }
                        b3 = 0;
                        matroskaExtractor3.blockState = (byte) 0;
                    }
                    r2 = extractorInput;
                    b = b3;
                }
                z5 = true;
                r1 = r2;
                r4 = b;
            }
            if (z5) {
                long position2 = r1.getPosition();
                matroskaExtractor = this;
                if (matroskaExtractor.seekForCues) {
                    matroskaExtractor.seekPositionAfterBuildingCues = position2;
                    positionHolder.position = matroskaExtractor.cuesContentPosition;
                    matroskaExtractor.seekForCues = r4;
                    return 1;
                }
                z2 = true;
                if (matroskaExtractor.sentSeekMap) {
                    long j18 = matroskaExtractor.seekPositionAfterBuildingCues;
                    if (j18 != -1) {
                        positionHolder.position = j18;
                        matroskaExtractor.seekPositionAfterBuildingCues = -1L;
                        return 1;
                    }
                } else {
                    continue;
                }
            } else {
                z2 = true;
                matroskaExtractor = this;
            }
            z4 = z2;
            z3 = false;
        }
        if (z5) {
            return 0;
        }
        int i64 = 0;
        while (true) {
            SparseArray sparseArray3 = matroskaExtractor.tracks;
            if (i64 >= sparseArray3.size()) {
                return -1;
            }
            Track track7 = (Track) sparseArray3.valueAt(i64);
            track7.output.getClass();
            TrueHdSampleRechunker trueHdSampleRechunker = track7.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(track7.output, track7.cryptoData);
            }
            i64++;
        }
    }

    public final void readScratch(ExtractorInput extractorInput, int i) {
        ParsableByteArray parsableByteArray = this.scratch;
        if (parsableByteArray.limit >= i) {
            return;
        }
        byte[] bArr = parsableByteArray.data;
        if (bArr.length < i) {
            parsableByteArray.ensureCapacity(Math.max(bArr.length * 2, i));
        }
        byte[] bArr2 = parsableByteArray.data;
        int i2 = parsableByteArray.limit;
        extractorInput.readFully(bArr2, i2, i - i2);
        parsableByteArray.setLimit(i);
    }

    public final void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = (short) 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    public final long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 == -9223372036854775807L) {
            throw ParserException.createForMalformedContainer(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        String str = Util.DEVICE_DEBUG_INFO;
        return Util.scaleLargeValue(j, j2, 1000L, RoundingMode.DOWN);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = (byte) 0;
        DefaultEbmlReader defaultEbmlReader = this.reader;
        defaultEbmlReader.elementState = (byte) 0;
        defaultEbmlReader.masterElementsStack.clear();
        VarintReader varintReader = defaultEbmlReader.varintReader;
        varintReader.state = false;
        varintReader.length = 0;
        VarintReader varintReader2 = this.varintReader;
        varintReader2.state = false;
        varintReader2.length = 0;
        resetWriteSampleData();
        this.inCuesElement = false;
        this.currentCueTimeUs = -9223372036854775807L;
        this.currentCueTrackNumber = -1;
        this.currentCueClusterPosition = -1L;
        this.currentCueRelativePosition = -1L;
        if (!this.sentSeekMap) {
            this.perTrackCues.clear();
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.tracks;
            if (i >= sparseArray.size()) {
                return;
            }
            TrueHdSampleRechunker trueHdSampleRechunker = ((Track) sparseArray.valueAt(i)).trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.foundSyncframe = false;
                trueHdSampleRechunker.chunkSampleCount = 0;
            }
            i++;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        PriorityQueue priorityQueue = new PriorityQueue((byte) 6);
        ParsableByteArray parsableByteArray = (ParsableByteArray) priorityQueue.array;
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        long j = defaultExtractorInput.streamLength;
        long j2 = 1024;
        if (j != -1 && j <= 1024) {
            j2 = j;
        }
        int i = (int) j2;
        defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
        priorityQueue.size = 4;
        for (long unsignedInt = parsableByteArray.readUnsignedInt(); unsignedInt != 440786851; unsignedInt = ((unsignedInt << 8) & (-256)) | ((long) (parsableByteArray.data[0] & 255))) {
            int i2 = priorityQueue.size + 1;
            priorityQueue.size = i2;
            if (i2 == i) {
                return false;
            }
            defaultExtractorInput.peekFully(parsableByteArray.data, 0, 1, false);
        }
        long uint = priorityQueue.readUint(defaultExtractorInput);
        long j3 = priorityQueue.size;
        if (uint != Long.MIN_VALUE && (j == -1 || j3 + uint < j)) {
            while (true) {
                long j4 = priorityQueue.size;
                long j5 = j3 + uint;
                if (j4 < j5) {
                    if (priorityQueue.readUint(defaultExtractorInput) == Long.MIN_VALUE) {
                        break;
                    }
                    long uint2 = priorityQueue.readUint(defaultExtractorInput);
                    if (uint2 < 0 || uint2 > 2147483647L) {
                        break;
                    }
                    if (uint2 != 0) {
                        int i3 = (int) uint2;
                        defaultExtractorInput.advancePeekPosition(i3, false);
                        priorityQueue.size += i3;
                    }
                } else if (j4 == j5) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01df  */
    /* JADX WARN: Type inference failed for: r8v32, types: [int, short] */
    public final int writeSampleData(ExtractorInput extractorInput, Track track, int i, boolean z) {
        int iSampleData;
        int iSampleData2;
        int i2;
        boolean z2;
        short s;
        if ("S_TEXT/UTF8".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            int i3 = this.sampleBytesWritten;
            resetWriteSampleData();
            return i3;
        }
        if ("S_TEXT/ASS".equals(track.codecId) || "S_TEXT/SSA".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            int i4 = this.sampleBytesWritten;
            resetWriteSampleData();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, VTT_PREFIX, i);
            int i5 = this.sampleBytesWritten;
            resetWriteSampleData();
            return i5;
        }
        int i6 = 2;
        if (track.waitingForDtsAnalysis) {
            track.format.getClass();
            ParsableByteArray parsableByteArray = new ParsableByteArray(i);
            if (extractorInput.peekFully(parsableByteArray.data, 0, i, true)) {
                extractorInput.resetPeekPosition();
                if (AacUtil.getFrameType(parsableByteArray.peekInt()) == 1 && parsableByteArray.bytesLeft() >= 10) {
                    byte[] bArr = new byte[10];
                    parsableByteArray.readBytes(bArr, 0, 10);
                    parsableByteArray.setPosition(0);
                    int dtsFrameSize = AacUtil.getDtsFrameSize(bArr);
                    if (dtsFrameSize > 0 && parsableByteArray.bytesLeft() >= dtsFrameSize + 4) {
                        parsableByteArray.skipBytes(dtsFrameSize);
                        if (AacUtil.getFrameType(parsableByteArray.readInt()) == 2) {
                            Format.Builder builderBuildUpon = track.format.buildUpon();
                            builderBuildUpon.sampleMimeType = MimeTypes.normalizeMimeType("audio/vnd.dts.hd");
                            track.format = new Format(builderBuildUpon);
                        }
                    }
                }
            }
            track.output.format(track.format);
            track.waitingForDtsAnalysis = false;
            maybeEndTracks();
        }
        TrackOutput trackOutput = track.output;
        boolean z3 = this.sampleEncodingHandled;
        ParsableByteArray parsableByteArray2 = this.sampleStrippedBytes;
        if (!z3) {
            boolean z4 = track.hasContentEncryption;
            ParsableByteArray parsableByteArray3 = this.scratch;
            if (z4) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(parsableByteArray3.data, 0, 1);
                    this.sampleBytesRead++;
                    byte b = parsableByteArray3.data[0];
                    if ((b & 128) == 128) {
                        throw ParserException.createForMalformedContainer(null, "Extension bit is set in signal byte");
                    }
                    this.sampleSignalByte = b;
                    this.sampleSignalByteRead = true;
                }
                byte b2 = this.sampleSignalByte;
                if ((b2 & 1) != 1) {
                    i2 = 2;
                } else {
                    boolean z5 = (b2 & 2) == 2;
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        ParsableByteArray parsableByteArray4 = this.encryptionInitializationVector;
                        extractorInput.readFully(parsableByteArray4.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        parsableByteArray3.data[0] = (byte) ((z5 ? 128 : 0) | 8);
                        parsableByteArray3.setPosition(0);
                        trackOutput.sampleData(parsableByteArray3, 1, 1);
                        this.sampleBytesWritten++;
                        parsableByteArray4.setPosition(0);
                        trackOutput.sampleData(parsableByteArray4, 8, 1);
                        this.sampleBytesWritten += 8;
                    }
                    if (z5) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(parsableByteArray3.data, 0, 1);
                            this.sampleBytesRead++;
                            parsableByteArray3.setPosition(0);
                            this.samplePartitionCount = parsableByteArray3.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i7 = this.samplePartitionCount * 4;
                        parsableByteArray3.reset(i7);
                        extractorInput.readFully(parsableByteArray3.data, 0, i7);
                        this.sampleBytesRead += i7;
                        short s2 = (short) ((this.samplePartitionCount / 2) + 1);
                        int i8 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i8) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i8);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s2);
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            s = this.samplePartitionCount;
                            if (i9 >= s) {
                                break;
                            }
                            int unsignedIntToInt = parsableByteArray3.readUnsignedIntToInt();
                            int i11 = i9 % 2;
                            int i12 = i6;
                            ByteBuffer byteBuffer2 = this.encryptionSubsampleDataBuffer;
                            if (i11 == 0) {
                                byteBuffer2.putShort((short) (unsignedIntToInt - i10));
                            } else {
                                byteBuffer2.putInt(unsignedIntToInt - i10);
                            }
                            i9++;
                            i10 = unsignedIntToInt;
                            i6 = i12;
                        }
                        i2 = i6;
                        int i13 = (i - this.sampleBytesRead) - i10;
                        int i14 = s % 2;
                        ByteBuffer byteBuffer3 = this.encryptionSubsampleDataBuffer;
                        if (i14 == 1) {
                            byteBuffer3.putInt(i13);
                        } else {
                            byteBuffer3.putShort((short) i13);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        byte[] bArrArray = this.encryptionSubsampleDataBuffer.array();
                        ParsableByteArray parsableByteArray5 = this.encryptionSubsampleData;
                        parsableByteArray5.reset(bArrArray, i8);
                        trackOutput.sampleData(parsableByteArray5, i8, 1);
                        this.sampleBytesWritten += i8;
                    } else {
                        i2 = 2;
                    }
                }
            } else {
                i2 = 2;
                byte[] bArr2 = track.sampleStrippedBytes;
                if (bArr2 != null) {
                    parsableByteArray2.reset(bArr2, bArr2.length);
                }
            }
            if ("A_OPUS".equals(track.codecId)) {
                z2 = z;
            } else {
                z2 = track.maxBlockAdditionId > 0;
            }
            if (z2) {
                this.blockFlags |= WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                this.supplementalData.reset(0);
                int i15 = (parsableByteArray2.limit + i) - this.sampleBytesRead;
                parsableByteArray3.reset(4);
                byte[] bArr3 = parsableByteArray3.data;
                bArr3[0] = (byte) ((i15 >> 24) & 255);
                bArr3[1] = (byte) ((i15 >> 16) & 255);
                bArr3[i2] = (byte) ((i15 >> 8) & 255);
                bArr3[3] = (byte) (i15 & 255);
                trackOutput.sampleData(parsableByteArray3, 4, i2);
                this.sampleBytesWritten += 4;
            }
            this.sampleEncodingHandled = true;
        }
        int i16 = i + parsableByteArray2.limit;
        if (!"V_MPEG4/ISO/AVC".equals(track.codecId) && !"V_MPEGH/ISO/HEVC".equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                UtilsKt.checkState(parsableByteArray2.limit == 0);
                track.trueHdSampleRechunker.startSample(extractorInput);
            }
            while (true) {
                int i17 = this.sampleBytesRead;
                if (i17 >= i16) {
                    break;
                }
                int i18 = i16 - i17;
                int iBytesLeft = parsableByteArray2.bytesLeft();
                if (iBytesLeft > 0) {
                    iSampleData2 = Math.min(i18, iBytesLeft);
                    trackOutput.sampleData(iSampleData2, parsableByteArray2);
                } else {
                    iSampleData2 = trackOutput.sampleData((DataReader) extractorInput, i18, false);
                }
                this.sampleBytesRead += iSampleData2;
                this.sampleBytesWritten += iSampleData2;
            }
        } else {
            ParsableByteArray parsableByteArray6 = this.nalLength;
            byte[] bArr4 = parsableByteArray6.data;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i19 = track.nalUnitLengthFieldLength;
            int i20 = 4 - i19;
            while (this.sampleBytesRead < i16) {
                int i21 = this.sampleCurrentNalBytesRemaining;
                if (i21 == 0) {
                    int iMin = Math.min(i19, parsableByteArray2.bytesLeft());
                    extractorInput.readFully(bArr4, i20 + iMin, i19 - iMin);
                    if (iMin > 0) {
                        parsableByteArray2.readBytes(bArr4, i20, iMin);
                    }
                    this.sampleBytesRead += i19;
                    parsableByteArray6.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = parsableByteArray6.readUnsignedIntToInt();
                    ParsableByteArray parsableByteArray7 = this.nalStartCode;
                    parsableByteArray7.setPosition(0);
                    trackOutput.sampleData(4, parsableByteArray7);
                    this.sampleBytesWritten += 4;
                } else {
                    int iBytesLeft2 = parsableByteArray2.bytesLeft();
                    if (iBytesLeft2 > 0) {
                        iSampleData = Math.min(i21, iBytesLeft2);
                        trackOutput.sampleData(iSampleData, parsableByteArray2);
                    } else {
                        iSampleData = trackOutput.sampleData((DataReader) extractorInput, i21, false);
                    }
                    this.sampleBytesRead += iSampleData;
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                }
            }
        }
        if ("A_VORBIS".equals(track.codecId)) {
            ParsableByteArray parsableByteArray8 = this.vorbisNumPageSamples;
            parsableByteArray8.setPosition(0);
            trackOutput.sampleData(4, parsableByteArray8);
            this.sampleBytesWritten += 4;
        }
        int i22 = this.sampleBytesWritten;
        resetWriteSampleData();
        return i22;
    }

    public final void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) {
        int length = bArr.length + i;
        ParsableByteArray parsableByteArray = this.subtitleSample;
        byte[] bArr2 = parsableByteArray.data;
        if (bArr2.length < length) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + i);
            parsableByteArray.getClass();
            parsableByteArray.reset(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        extractorInput.readFully(parsableByteArray.data, bArr.length, i);
        parsableByteArray.setPosition(0);
        parsableByteArray.setLimit(length);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
