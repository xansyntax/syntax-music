package androidx.media3.extractor.flv;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.navigation.NavOptions;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlvExtractor implements Extractor {
    public AudioTagPayloadReader audioReader;
    public int bytesToNextTagHeader;
    public ExtractorOutput extractorOutput;
    public long mediaTagTimestampOffsetUs;
    public final ScriptTagPayloadReader metadataReader;
    public boolean outputFirstSample;
    public boolean outputSeekMap;
    public byte state;
    public int tagDataSize;
    public long tagTimestampUs;
    public short tagType;
    public VideoTagPayloadReader videoReader;
    public final ParsableByteArray scratch = new ParsableByteArray(4);
    public final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    public final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    public final ParsableByteArray tagData = new ParsableByteArray();

    public FlvExtractor() {
        ScriptTagPayloadReader scriptTagPayloadReader = new ScriptTagPayloadReader(new DiscardingTrackOutput());
        scriptTagPayloadReader.durationUs = -9223372036854775807L;
        scriptTagPayloadReader.keyFrameTimesUs = new long[0];
        scriptTagPayloadReader.keyFrameTagPositions = new long[0];
        this.metadataReader = scriptTagPayloadReader;
        this.state = (byte) 1;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public final ParsableByteArray prepareTagData(ExtractorInput extractorInput) {
        int i = this.tagDataSize;
        ParsableByteArray parsableByteArray = this.tagData;
        byte[] bArr = parsableByteArray.data;
        if (i > bArr.length) {
            parsableByteArray.reset(new byte[Math.max(bArr.length * 2, i)], 0);
        } else {
            parsableByteArray.setPosition(0);
        }
        parsableByteArray.setLimit(this.tagDataSize);
        extractorInput.readFully(parsableByteArray.data, 0, this.tagDataSize);
        return parsableByteArray;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:144:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:145:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:184:0x03c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0171  */
    /* JADX WARN: Code duplicated, block: B:58:0x0179  */
    /* JADX WARN: Code duplicated, block: B:94:0x029f  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b4  */
    /* JADX WARN: Type inference failed for: r3v45, types: [int, short] */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        long j;
        long j2;
        short s;
        boolean z;
        boolean z2;
        long j3;
        byte b;
        this.extractorOutput.getClass();
        while (true) {
            byte b2 = this.state;
            boolean z3 = true;
            if (b2 == 1) {
                ParsableByteArray parsableByteArray = this.headerBuffer;
                if (!extractorInput.readFully(parsableByteArray.data, 0, 9, true)) {
                    return -1;
                }
                parsableByteArray.setPosition(0);
                parsableByteArray.skipBytes(4);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                boolean z4 = (unsignedByte & 4) != 0;
                boolean z5 = (unsignedByte & 1) != 0;
                if (z4 && this.audioReader == null) {
                    this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
                }
                if (z5 && this.videoReader == null) {
                    b = 2;
                    this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
                } else {
                    b = 2;
                }
                this.extractorOutput.endTracks();
                this.bytesToNextTagHeader = parsableByteArray.readInt() - 5;
                this.state = b;
            } else if (b2 == 2) {
                extractorInput.skipFully(this.bytesToNextTagHeader);
                this.bytesToNextTagHeader = 0;
                this.state = (byte) 3;
            } else if (b2 == 3) {
                ParsableByteArray parsableByteArray2 = this.tagHeaderBuffer;
                if (!extractorInput.readFully(parsableByteArray2.data, 0, 11, true)) {
                    return -1;
                }
                parsableByteArray2.setPosition(0);
                this.tagType = parsableByteArray2.readUnsignedByte();
                this.tagDataSize = parsableByteArray2.readUnsignedInt24();
                this.tagTimestampUs = parsableByteArray2.readUnsignedInt24();
                this.tagTimestampUs = (((long) (parsableByteArray2.readUnsignedByte() << 24)) | this.tagTimestampUs) * 1000;
                parsableByteArray2.skipBytes(3);
                this.state = (byte) 4;
            } else {
                if (b2 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return 0;
                }
                boolean z6 = this.outputFirstSample;
                ScriptTagPayloadReader scriptTagPayloadReader = this.metadataReader;
                if (z6) {
                    j = this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
                } else {
                    if (scriptTagPayloadReader.durationUs == -9223372036854775807L) {
                        j2 = 0;
                    } else {
                        j = this.tagTimestampUs;
                    }
                    s = this.tagType;
                    if (s == 8 || this.audioReader == null) {
                        int i = 4;
                        if (s != 9 && this.videoReader != null) {
                            if (!this.outputSeekMap) {
                                this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
                                this.outputSeekMap = true;
                            }
                            VideoTagPayloadReader videoTagPayloadReader = this.videoReader;
                            ParsableByteArray parsableByteArrayPrepareTagData = prepareTagData(extractorInput);
                            videoTagPayloadReader.getClass();
                            int unsignedByte2 = parsableByteArrayPrepareTagData.readUnsignedByte();
                            int i2 = (unsignedByte2 >> 4) & 15;
                            int i3 = unsignedByte2 & 15;
                            if (i3 != 7) {
                                throw new TagPayloadReader.UnsupportedFormatException(IntIntPair$$ExternalSyntheticOutline0.m(i3, "Video format not supported: "));
                            }
                            videoTagPayloadReader.frameType = i2;
                            if (i2 != 5) {
                                ParsableByteArray parsableByteArray3 = videoTagPayloadReader.nalStartCode;
                                TrackOutput trackOutput = (TrackOutput) videoTagPayloadReader.output;
                                ParsableByteArray parsableByteArray4 = videoTagPayloadReader.nalLength;
                                int unsignedByte3 = parsableByteArrayPrepareTagData.readUnsignedByte();
                                parsableByteArrayPrepareTagData.maybeAssertAtLeastBytesLeftForLegacyMethod(3);
                                byte[] bArr = parsableByteArrayPrepareTagData.data;
                                int i4 = parsableByteArrayPrepareTagData.position;
                                int i5 = i4 + 1;
                                parsableByteArrayPrepareTagData.position = i5;
                                int i6 = ((bArr[i4] & 255) << 24) >> 8;
                                int i7 = i4 + 2;
                                parsableByteArrayPrepareTagData.position = i7;
                                int i8 = ((bArr[i5] & 255) << 8) | i6;
                                parsableByteArrayPrepareTagData.position = i4 + 3;
                                long j4 = (((long) (i8 | (bArr[i7] & 255))) * 1000) + j2;
                                if (unsignedByte3 != 0 || videoTagPayloadReader.hasOutputFormat) {
                                    if (unsignedByte3 == 1 && videoTagPayloadReader.hasOutputFormat) {
                                        int i9 = videoTagPayloadReader.frameType == 1 ? 1 : 0;
                                        if (videoTagPayloadReader.hasOutputKeyframe || i9 != 0) {
                                            byte[] bArr2 = parsableByteArray4.data;
                                            bArr2[0] = 0;
                                            bArr2[1] = 0;
                                            bArr2[2] = 0;
                                            int i10 = 4 - videoTagPayloadReader.nalUnitLengthFieldLength;
                                            int i11 = 0;
                                            while (parsableByteArrayPrepareTagData.bytesLeft() > 0) {
                                                parsableByteArrayPrepareTagData.readBytes(parsableByteArray4.data, i10, videoTagPayloadReader.nalUnitLengthFieldLength);
                                                parsableByteArray4.setPosition(0);
                                                int unsignedIntToInt = parsableByteArray4.readUnsignedIntToInt();
                                                parsableByteArray3.setPosition(0);
                                                trackOutput.sampleData(i, parsableByteArray3);
                                                trackOutput.sampleData(unsignedIntToInt, parsableByteArrayPrepareTagData);
                                                i11 = i11 + 4 + unsignedIntToInt;
                                                i = 4;
                                            }
                                            ((TrackOutput) videoTagPayloadReader.output).sampleMetadata(j4, i9, i11, 0, null);
                                            videoTagPayloadReader.hasOutputKeyframe = true;
                                            z2 = true;
                                        }
                                    }
                                    z = z2;
                                    z3 = true;
                                } else {
                                    byte[] bArr3 = new byte[parsableByteArrayPrepareTagData.bytesLeft()];
                                    ParsableByteArray parsableByteArray5 = new ParsableByteArray(bArr3);
                                    parsableByteArrayPrepareTagData.readBytes(bArr3, 0, parsableByteArrayPrepareTagData.bytesLeft());
                                    AvcConfig avcConfig = AvcConfig.parse(parsableByteArray5);
                                    videoTagPayloadReader.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                                    Format.Builder builder = new Format.Builder();
                                    builder.containerMimeType = MimeTypes.normalizeMimeType("video/x-flv");
                                    builder.sampleMimeType = MimeTypes.normalizeMimeType("video/avc");
                                    builder.codecs = avcConfig.codecs;
                                    builder.width = avcConfig.width;
                                    builder.height = avcConfig.height;
                                    builder.pixelWidthHeightRatio = avcConfig.pixelWidthHeightRatio;
                                    builder.initializationData = avcConfig.initializationData;
                                    Format$$ExternalSyntheticOutline0.m(builder, trackOutput);
                                    videoTagPayloadReader.hasOutputFormat = true;
                                }
                                z2 = false;
                                if (z2) {
                                }
                                z3 = true;
                            }
                        } else if (s == 18 || this.outputSeekMap) {
                            extractorInput.skipFully(this.tagDataSize);
                            z = false;
                            z3 = false;
                        } else {
                            ParsableByteArray parsableByteArrayPrepareTagData2 = prepareTagData(extractorInput);
                            if (parsableByteArrayPrepareTagData2.readUnsignedByte() == 2 && "onMetaData".equals(ScriptTagPayloadReader.readAmfString(parsableByteArrayPrepareTagData2)) && parsableByteArrayPrepareTagData2.bytesLeft() != 0 && parsableByteArrayPrepareTagData2.readUnsignedByte() == 8) {
                                HashMap amfEcmaArray = ScriptTagPayloadReader.readAmfEcmaArray(parsableByteArrayPrepareTagData2);
                                Object obj = amfEcmaArray.get("duration");
                                if (obj instanceof Double) {
                                    double dDoubleValue = ((Double) obj).doubleValue();
                                    if (dDoubleValue > 0.0d) {
                                        scriptTagPayloadReader.durationUs = (long) (dDoubleValue * 1000000.0d);
                                    }
                                }
                                Object obj2 = amfEcmaArray.get("keyframes");
                                if (obj2 instanceof Map) {
                                    Map map = (Map) obj2;
                                    Object obj3 = map.get("filepositions");
                                    Object obj4 = map.get("times");
                                    if ((obj3 instanceof List) && (obj4 instanceof List)) {
                                        List list = (List) obj3;
                                        List list2 = (List) obj4;
                                        int size = list2.size();
                                        scriptTagPayloadReader.keyFrameTimesUs = new long[size];
                                        scriptTagPayloadReader.keyFrameTagPositions = new long[size];
                                        for (int i12 = 0; i12 < size; i12++) {
                                            Object obj5 = list.get(i12);
                                            Object obj6 = list2.get(i12);
                                            if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                                                scriptTagPayloadReader.keyFrameTimesUs = new long[0];
                                                scriptTagPayloadReader.keyFrameTagPositions = new long[0];
                                                break;
                                            }
                                            scriptTagPayloadReader.keyFrameTimesUs[i12] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                                            scriptTagPayloadReader.keyFrameTagPositions[i12] = ((Double) obj5).longValue();
                                        }
                                    }
                                }
                            }
                            long j5 = scriptTagPayloadReader.durationUs;
                            if (j5 != -9223372036854775807L) {
                                this.extractorOutput.seekMap(new IndexSeekMap(j5, scriptTagPayloadReader.keyFrameTagPositions, scriptTagPayloadReader.keyFrameTimesUs));
                                this.outputSeekMap = true;
                            }
                        }
                        z3 = true;
                    } else {
                        if (!this.outputSeekMap) {
                            this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
                            this.outputSeekMap = true;
                        }
                        AudioTagPayloadReader audioTagPayloadReader = this.audioReader;
                        ParsableByteArray parsableByteArrayPrepareTagData3 = prepareTagData(extractorInput);
                        TrackOutput trackOutput2 = (TrackOutput) audioTagPayloadReader.output;
                        if (audioTagPayloadReader.hasParsedAudioDataHeader) {
                            parsableByteArrayPrepareTagData3.skipBytes(1);
                        } else {
                            int unsignedByte4 = parsableByteArrayPrepareTagData3.readUnsignedByte();
                            int i13 = (unsignedByte4 >> 4) & 15;
                            audioTagPayloadReader.audioFormat = i13;
                            if (i13 == 2) {
                                int i14 = AudioTagPayloadReader.AUDIO_SAMPLING_RATE_TABLE[(unsignedByte4 >> 2) & 3];
                                Format.Builder builder2 = new Format.Builder();
                                builder2.containerMimeType = MimeTypes.normalizeMimeType("video/x-flv");
                                builder2.sampleMimeType = MimeTypes.normalizeMimeType("audio/mpeg");
                                builder2.channelCount = 1;
                                builder2.sampleRate = i14;
                                Format$$ExternalSyntheticOutline0.m(builder2, trackOutput2);
                                audioTagPayloadReader.hasOutputFormat = true;
                            } else if (i13 == 7 || i13 == 8) {
                                String str = i13 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                                Format.Builder builder3 = new Format.Builder();
                                builder3.containerMimeType = MimeTypes.normalizeMimeType("video/x-flv");
                                builder3.sampleMimeType = MimeTypes.normalizeMimeType(str);
                                builder3.channelCount = 1;
                                builder3.sampleRate = 8000;
                                Format$$ExternalSyntheticOutline0.m(builder3, trackOutput2);
                                audioTagPayloadReader.hasOutputFormat = true;
                            } else if (i13 != 10) {
                                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + audioTagPayloadReader.audioFormat);
                            }
                            audioTagPayloadReader.hasParsedAudioDataHeader = true;
                        }
                        TrackOutput trackOutput3 = (TrackOutput) audioTagPayloadReader.output;
                        if (audioTagPayloadReader.audioFormat == 2) {
                            int iBytesLeft = parsableByteArrayPrepareTagData3.bytesLeft();
                            trackOutput3.sampleData(iBytesLeft, parsableByteArrayPrepareTagData3);
                            ((TrackOutput) audioTagPayloadReader.output).sampleMetadata(j2, 1, iBytesLeft, 0, null);
                        } else {
                            int unsignedByte5 = parsableByteArrayPrepareTagData3.readUnsignedByte();
                            if (unsignedByte5 == 0 && !audioTagPayloadReader.hasOutputFormat) {
                                int iBytesLeft2 = parsableByteArrayPrepareTagData3.bytesLeft();
                                byte[] bArr4 = new byte[iBytesLeft2];
                                parsableByteArrayPrepareTagData3.readBytes(bArr4, 0, iBytesLeft2);
                                NavOptions.Builder audioSpecificConfig = AacUtil.parseAudioSpecificConfig(new VorbisBitArray(bArr4, iBytesLeft2), false);
                                Format.Builder builder4 = new Format.Builder();
                                builder4.containerMimeType = MimeTypes.normalizeMimeType("video/x-flv");
                                builder4.sampleMimeType = MimeTypes.normalizeMimeType("audio/mp4a-latm");
                                builder4.codecs = audioSpecificConfig.popUpToRoute;
                                builder4.channelCount = audioSpecificConfig.exitAnim;
                                builder4.sampleRate = audioSpecificConfig.enterAnim;
                                builder4.initializationData = Collections.singletonList(bArr4);
                                Format$$ExternalSyntheticOutline0.m(builder4, trackOutput3);
                                audioTagPayloadReader.hasOutputFormat = true;
                            } else if (audioTagPayloadReader.audioFormat != 10 || unsignedByte5 == 1) {
                                int iBytesLeft3 = parsableByteArrayPrepareTagData3.bytesLeft();
                                trackOutput3.sampleData(iBytesLeft3, parsableByteArrayPrepareTagData3);
                                ((TrackOutput) audioTagPayloadReader.output).sampleMetadata(j2, 1, iBytesLeft3, 0, null);
                            }
                            z = false;
                        }
                        z = true;
                    }
                    if (!this.outputFirstSample && z) {
                        this.outputFirstSample = true;
                        if (scriptTagPayloadReader.durationUs == -9223372036854775807L) {
                            j3 = -this.tagTimestampUs;
                        } else {
                            j3 = 0;
                        }
                        this.mediaTagTimestampOffsetUs = j3;
                    }
                    this.bytesToNextTagHeader = 4;
                    this.state = (byte) 2;
                    if (z3) {
                        return 0;
                    }
                }
                j2 = j;
                s = this.tagType;
                if (s == 8) {
                    int i15 = 4;
                    if (s != 9) {
                        if (s == 18) {
                        }
                        extractorInput.skipFully(this.tagDataSize);
                        z = false;
                        z3 = false;
                    } else {
                        if (s == 18) {
                        }
                        extractorInput.skipFully(this.tagDataSize);
                        z = false;
                        z3 = false;
                    }
                } else {
                    int i16 = 4;
                    if (s != 9) {
                        if (s == 18) {
                        }
                        extractorInput.skipFully(this.tagDataSize);
                        z = false;
                        z3 = false;
                    } else {
                        if (s == 18) {
                        }
                        extractorInput.skipFully(this.tagDataSize);
                        z = false;
                        z3 = false;
                    }
                }
                if (!this.outputFirstSample) {
                    this.outputFirstSample = true;
                    if (scriptTagPayloadReader.durationUs == -9223372036854775807L) {
                        j3 = -this.tagTimestampUs;
                    } else {
                        j3 = 0;
                    }
                    this.mediaTagTimestampOffsetUs = j3;
                }
                this.bytesToNextTagHeader = 4;
                this.state = (byte) 2;
                if (z3) {
                    return 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        if (j == 0) {
            this.state = (byte) 1;
            this.outputFirstSample = false;
        } else {
            this.state = (byte) 3;
        }
        this.bytesToNextTagHeader = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.scratch;
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.peekFully(parsableByteArray.data, 0, 3, false);
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readUnsignedInt24() == 4607062) {
            defaultExtractorInput.peekFully(parsableByteArray.data, 0, 2, false);
            parsableByteArray.setPosition(0);
            if ((parsableByteArray.readUnsignedShort() & 250) == 0) {
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
                parsableByteArray.setPosition(0);
                int i = parsableByteArray.readInt();
                defaultExtractorInput.peekBufferPosition = 0;
                defaultExtractorInput.advancePeekPosition(i, false);
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 4, false);
                parsableByteArray.setPosition(0);
                if (parsableByteArray.readInt() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
