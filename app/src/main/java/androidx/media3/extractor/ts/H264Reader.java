package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil$PpsData;
import androidx.media3.container.NalUnitUtil$SpsData;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.wav.WavFormat;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class H264Reader implements ElementaryStreamReader {
    public final boolean allowNonIdrKeyframes;
    public final boolean detectAccessUnits;
    public String formatId;
    public boolean hasOutputFormat;
    public TrackOutput output;
    public boolean randomAccessIndicator;
    public SampleReader sampleReader;
    public final SeiReader seiReader;
    public long totalBytesWritten;
    public final boolean[] prefixFlags = new boolean[3];
    public final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7);
    public final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8);
    public final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6);
    public long pesTimeUs = -9223372036854775807L;
    public final ParsableByteArray seiWrapper = new ParsableByteArray();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SampleReader {
        public final boolean allowNonIdrKeyframes;
        public final WavFormat bitArray;
        public byte[] buffer;
        public int bufferLength;
        public final boolean detectAccessUnits;
        public long nalUnitStartPosition;
        public long nalUnitTimeUs;
        public int nalUnitType;
        public final TrackOutput output;
        public boolean randomAccessIndicator;
        public boolean sampleIsKeyframe;
        public long samplePosition;
        public long sampleTimeUs;
        public final SparseArray sps = new SparseArray();
        public final SparseArray pps = new SparseArray();
        public SliceHeaderData previousSliceHeader = new SliceHeaderData();
        public SliceHeaderData sliceHeader = new SliceHeaderData();
        public boolean isFilling = false;
        public boolean readingSample = false;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class SliceHeaderData {
            public boolean bottomFieldFlag;
            public boolean bottomFieldFlagPresent;
            public int deltaPicOrderCnt0;
            public int deltaPicOrderCnt1;
            public int deltaPicOrderCntBottom;
            public boolean fieldPicFlag;
            public int frameNum;
            public boolean hasSliceType;
            public boolean idrPicFlag;
            public int idrPicId;
            public boolean isComplete;
            public int nalRefIdc;
            public int picOrderCntLsb;
            public int picParameterSetId;
            public int sliceType;
            public NalUnitUtil$SpsData spsData;
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z;
            this.detectAccessUnits = z2;
            byte[] bArr = new byte[128];
            this.buffer = bArr;
            this.bitArray = new WavFormat(bArr, 0, 0);
            SliceHeaderData sliceHeaderData = this.sliceHeader;
            sliceHeaderData.hasSliceType = false;
            sliceHeaderData.isComplete = false;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.seiReader = seiReader;
        this.allowNonIdrKeyframes = z;
        this.detectAccessUnits = z2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) {
        int i;
        this.output.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        int i2 = parsableByteArray.position;
        int i3 = parsableByteArray.limit;
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray.bytesLeft(), parsableByteArray);
        while (true) {
            int iFindNalUnit = OpusUtil.findNalUnit(bArr, i2, i3, this.prefixFlags);
            if (iFindNalUnit == i3) {
                this.nalUnitData(bArr, i2, i3);
                return;
            }
            int i4 = bArr[iFindNalUnit + 3] & 31;
            if (iFindNalUnit <= 0 || bArr[iFindNalUnit - 1] != 0) {
                i = 3;
            } else {
                iFindNalUnit--;
                i = 4;
            }
            int i5 = iFindNalUnit - i2;
            if (i5 > 0) {
                this.nalUnitData(bArr, i2, iFindNalUnit);
            }
            int i6 = i3 - iFindNalUnit;
            long j = this.totalBytesWritten - ((long) i6);
            H264Reader h264Reader = this;
            h264Reader.endNalUnit(i6, i5 < 0 ? -i5 : 0, j, this.pesTimeUs);
            h264Reader.startNalUnit(i4, j, h264Reader.pesTimeUs);
            i2 = iFindNalUnit + i;
            this = h264Reader;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        this.formatId = trackIdGenerator.formatId;
        trackIdGenerator.maybeThrowUninitializedError();
        TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.trackId, 2);
        this.output = trackOutputTrack;
        this.sampleReader = new SampleReader(trackOutputTrack, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:73:0x0202  */
    /* JADX WARN: Code duplicated, block: B:92:0x023f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void endNalUnit(int i, int i2, long j, long j2) {
        long j3;
        int i3;
        long j4;
        long j5;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        RulerTrackingMap rulerTrackingMap = this.seiReader.reorderingBufferQueue;
        if (!this.hasOutputFormat || this.sampleReader.detectAccessUnits) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.sps;
            nalUnitTargetBuffer.endNalUnit(i2);
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.pps;
            nalUnitTargetBuffer2.endNalUnit(i2);
            boolean z4 = this.hasOutputFormat;
            boolean z5 = nalUnitTargetBuffer.isCompleted;
            if (z4) {
                if (z5) {
                    NalUnitUtil$SpsData spsNalUnit = OpusUtil.parseSpsNalUnit(nalUnitTargetBuffer.nalData, 3, nalUnitTargetBuffer.nalLength);
                    rulerTrackingMap.setMaxSize(spsNalUnit.maxNumReorderFrames);
                    this.sampleReader.sps.append(spsNalUnit.seqParameterSetId, spsNalUnit);
                    nalUnitTargetBuffer.reset();
                } else if (nalUnitTargetBuffer2.isCompleted) {
                    WavFormat wavFormat = new WavFormat(nalUnitTargetBuffer2.nalData, 4, nalUnitTargetBuffer2.nalLength);
                    int expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                    int expGolombCodeNum2 = wavFormat.readExpGolombCodeNum();
                    wavFormat.skipBit();
                    this.sampleReader.pps.append(expGolombCodeNum, new NalUnitUtil$PpsData(expGolombCodeNum, wavFormat.readBit(), expGolombCodeNum2));
                    nalUnitTargetBuffer2.reset();
                }
            } else if (z5 && nalUnitTargetBuffer2.isCompleted) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                NalUnitUtil$SpsData spsNalUnit2 = OpusUtil.parseSpsNalUnit(nalUnitTargetBuffer.nalData, 3, nalUnitTargetBuffer.nalLength);
                int i8 = spsNalUnit2.maxNumReorderFrames;
                WavFormat wavFormat2 = new WavFormat(nalUnitTargetBuffer2.nalData, 4, nalUnitTargetBuffer2.nalLength);
                int expGolombCodeNum3 = wavFormat2.readExpGolombCodeNum();
                int expGolombCodeNum4 = wavFormat2.readExpGolombCodeNum();
                wavFormat2.skipBit();
                NalUnitUtil$PpsData nalUnitUtil$PpsData = new NalUnitUtil$PpsData(expGolombCodeNum3, wavFormat2.readBit(), expGolombCodeNum4);
                int i9 = spsNalUnit2.profileIdc;
                int i10 = spsNalUnit2.constraintsFlagsAndReservedZero2Bits;
                int i11 = spsNalUnit2.levelIdc;
                byte[] bArr = CodecSpecificDataUtil.NAL_START_CODE;
                String str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11));
                TrackOutput trackOutput = this.output;
                Format.Builder builder = new Format.Builder();
                builder.id = this.formatId;
                builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                builder.sampleMimeType = MimeTypes.normalizeMimeType("video/avc");
                builder.codecs = str;
                builder.width = spsNalUnit2.width;
                builder.height = spsNalUnit2.height;
                builder.colorInfo = new ColorInfo(spsNalUnit2.colorSpace, spsNalUnit2.colorRange, spsNalUnit2.colorTransfer, null, spsNalUnit2.bitDepthLumaMinus8 + 8, spsNalUnit2.bitDepthChromaMinus8 + 8);
                builder.pixelWidthHeightRatio = spsNalUnit2.pixelWidthHeightRatio;
                builder.initializationData = arrayList;
                builder.maxNumReorderSamples = i8;
                Format$$ExternalSyntheticOutline0.m(builder, trackOutput);
                this.hasOutputFormat = true;
                rulerTrackingMap.setMaxSize(i8);
                this.sampleReader.sps.append(spsNalUnit2.seqParameterSetId, spsNalUnit2);
                this.sampleReader.pps.append(expGolombCodeNum3, nalUnitUtil$PpsData);
                nalUnitTargetBuffer.reset();
                nalUnitTargetBuffer2.reset();
            }
        }
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.sei;
        if (nalUnitTargetBuffer3.endNalUnit(i2)) {
            int iUnescapeStream = OpusUtil.unescapeStream(nalUnitTargetBuffer3.nalData, nalUnitTargetBuffer3.nalLength);
            byte[] bArr2 = nalUnitTargetBuffer3.nalData;
            ParsableByteArray parsableByteArray = this.seiWrapper;
            parsableByteArray.reset(bArr2, iUnescapeStream);
            parsableByteArray.setPosition(4);
            rulerTrackingMap.add(j2, parsableByteArray);
        }
        SampleReader sampleReader = this.sampleReader;
        boolean z6 = this.hasOutputFormat;
        if (sampleReader.nalUnitType == 9) {
            if (z6 && sampleReader.readingSample) {
                j3 = sampleReader.nalUnitStartPosition;
                i3 = i + ((int) (j - j3));
                j4 = sampleReader.sampleTimeUs;
                if (j4 != -9223372036854775807L) {
                    j5 = sampleReader.samplePosition;
                    if (j3 != j5) {
                        sampleReader.output.sampleMetadata(j4, sampleReader.sampleIsKeyframe ? 1 : 0, (int) (j3 - j5), i3, null);
                    }
                }
            }
            sampleReader.samplePosition = sampleReader.nalUnitStartPosition;
            sampleReader.sampleTimeUs = sampleReader.nalUnitTimeUs;
            sampleReader.sampleIsKeyframe = false;
            sampleReader.readingSample = true;
        } else if (sampleReader.detectAccessUnits) {
            SampleReader.SliceHeaderData sliceHeaderData = sampleReader.sliceHeader;
            SampleReader.SliceHeaderData sliceHeaderData2 = sampleReader.previousSliceHeader;
            if (sliceHeaderData.isComplete) {
                if (sliceHeaderData2.isComplete) {
                    NalUnitUtil$SpsData nalUnitUtil$SpsData = sliceHeaderData.spsData;
                    nalUnitUtil$SpsData.getClass();
                    NalUnitUtil$SpsData nalUnitUtil$SpsData2 = sliceHeaderData2.spsData;
                    nalUnitUtil$SpsData2.getClass();
                    int i12 = nalUnitUtil$SpsData2.picOrderCountType;
                    if (sliceHeaderData.frameNum != sliceHeaderData2.frameNum || sliceHeaderData.picParameterSetId != sliceHeaderData2.picParameterSetId || sliceHeaderData.fieldPicFlag != sliceHeaderData2.fieldPicFlag || ((sliceHeaderData.bottomFieldFlagPresent && sliceHeaderData2.bottomFieldFlagPresent && sliceHeaderData.bottomFieldFlag != sliceHeaderData2.bottomFieldFlag) || (((i5 = sliceHeaderData.nalRefIdc) != (i6 = sliceHeaderData2.nalRefIdc) && (i5 == 0 || i6 == 0)) || (((i7 = nalUnitUtil$SpsData.picOrderCountType) == 0 && i12 == 0 && (sliceHeaderData.picOrderCntLsb != sliceHeaderData2.picOrderCntLsb || sliceHeaderData.deltaPicOrderCntBottom != sliceHeaderData2.deltaPicOrderCntBottom)) || ((i7 == 1 && i12 == 1 && (sliceHeaderData.deltaPicOrderCnt0 != sliceHeaderData2.deltaPicOrderCnt0 || sliceHeaderData.deltaPicOrderCnt1 != sliceHeaderData2.deltaPicOrderCnt1)) || (z3 = sliceHeaderData.idrPicFlag) != sliceHeaderData2.idrPicFlag || (z3 && sliceHeaderData.idrPicId != sliceHeaderData2.idrPicId)))))) {
                        if (z6) {
                            j3 = sampleReader.nalUnitStartPosition;
                            i3 = i + ((int) (j - j3));
                            j4 = sampleReader.sampleTimeUs;
                            if (j4 != -9223372036854775807L) {
                                j5 = sampleReader.samplePosition;
                                if (j3 != j5) {
                                    sampleReader.output.sampleMetadata(j4, sampleReader.sampleIsKeyframe ? 1 : 0, (int) (j3 - j5), i3, null);
                                }
                            }
                        }
                        sampleReader.samplePosition = sampleReader.nalUnitStartPosition;
                        sampleReader.sampleTimeUs = sampleReader.nalUnitTimeUs;
                        sampleReader.sampleIsKeyframe = false;
                        sampleReader.readingSample = true;
                    }
                } else {
                    if (z6) {
                        j3 = sampleReader.nalUnitStartPosition;
                        i3 = i + ((int) (j - j3));
                        j4 = sampleReader.sampleTimeUs;
                        if (j4 != -9223372036854775807L) {
                            j5 = sampleReader.samplePosition;
                            if (j3 != j5) {
                                sampleReader.output.sampleMetadata(j4, sampleReader.sampleIsKeyframe ? 1 : 0, (int) (j3 - j5), i3, null);
                            }
                        }
                    }
                    sampleReader.samplePosition = sampleReader.nalUnitStartPosition;
                    sampleReader.sampleTimeUs = sampleReader.nalUnitTimeUs;
                    sampleReader.sampleIsKeyframe = false;
                    sampleReader.readingSample = true;
                }
            }
        }
        if (sampleReader.allowNonIdrKeyframes) {
            SampleReader.SliceHeaderData sliceHeaderData3 = sampleReader.sliceHeader;
            z = sliceHeaderData3.hasSliceType && ((i4 = sliceHeaderData3.sliceType) == 7 || i4 == 2);
        } else {
            z = sampleReader.randomAccessIndicator;
        }
        boolean z7 = sampleReader.sampleIsKeyframe;
        int i13 = sampleReader.nalUnitType;
        if (i13 == 5) {
            z2 = true;
        } else if (z) {
            z2 = true;
            if (i13 != 1) {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        boolean z8 = z7 | z2;
        sampleReader.sampleIsKeyframe = z8;
        sampleReader.nalUnitType = 24;
        if (z8) {
            this.randomAccessIndicator = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0102  */
    /* JADX WARN: Code duplicated, block: B:59:0x0104  */
    /* JADX WARN: Code duplicated, block: B:61:0x0107  */
    /* JADX WARN: Code duplicated, block: B:64:0x010e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0113  */
    /* JADX WARN: Code duplicated, block: B:68:0x0118  */
    /* JADX WARN: Code duplicated, block: B:71:0x011f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0139  */
    public final void nalUnitData(byte[] bArr, int i, int i2) {
        boolean bit;
        boolean bit2;
        boolean z;
        boolean z2;
        int expGolombCodeNum;
        int i3;
        int bits;
        int i4;
        int signedExpGolombCodedInt;
        int signedExpGolombCodedInt2;
        if (!this.hasOutputFormat || this.sampleReader.detectAccessUnits) {
            this.sps.appendToNalUnit(bArr, i, i2);
            this.pps.appendToNalUnit(bArr, i, i2);
        }
        this.sei.appendToNalUnit(bArr, i, i2);
        SampleReader sampleReader = this.sampleReader;
        SparseArray sparseArray = sampleReader.pps;
        WavFormat wavFormat = sampleReader.bitArray;
        if (sampleReader.isFilling) {
            int i5 = i2 - i;
            byte[] bArrCopyOf = sampleReader.buffer;
            int length = bArrCopyOf.length;
            int i6 = sampleReader.bufferLength + i5;
            if (length < i6) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6 * 2);
                sampleReader.buffer = bArrCopyOf;
            }
            System.arraycopy(bArr, i, bArrCopyOf, sampleReader.bufferLength, i5);
            int i7 = sampleReader.bufferLength + i5;
            sampleReader.bufferLength = i7;
            wavFormat.extraData = sampleReader.buffer;
            wavFormat.frameRateHz = 0;
            wavFormat.blockSize = 0;
            wavFormat.numChannels = i7;
            wavFormat.bitsPerSample = 0;
            wavFormat.assertValidOffset();
            if (wavFormat.canReadBits(8)) {
                wavFormat.skipBit();
                int bits2 = wavFormat.readBits(2);
                wavFormat.skipBits(5);
                if (wavFormat.canReadExpGolombCodedNum()) {
                    wavFormat.readExpGolombCodeNum();
                    if (wavFormat.canReadExpGolombCodedNum()) {
                        int expGolombCodeNum2 = wavFormat.readExpGolombCodeNum();
                        if (!sampleReader.detectAccessUnits) {
                            sampleReader.isFilling = false;
                            SampleReader.SliceHeaderData sliceHeaderData = sampleReader.sliceHeader;
                            sliceHeaderData.sliceType = expGolombCodeNum2;
                            sliceHeaderData.hasSliceType = true;
                            return;
                        }
                        if (wavFormat.canReadExpGolombCodedNum()) {
                            int expGolombCodeNum3 = wavFormat.readExpGolombCodeNum();
                            if (sparseArray.indexOfKey(expGolombCodeNum3) < 0) {
                                sampleReader.isFilling = false;
                                return;
                            }
                            NalUnitUtil$PpsData nalUnitUtil$PpsData = (NalUnitUtil$PpsData) sparseArray.get(expGolombCodeNum3);
                            SparseArray sparseArray2 = sampleReader.sps;
                            int i8 = nalUnitUtil$PpsData.seqParameterSetId;
                            boolean z3 = nalUnitUtil$PpsData.bottomFieldPicOrderInFramePresentFlag;
                            NalUnitUtil$SpsData nalUnitUtil$SpsData = (NalUnitUtil$SpsData) sparseArray2.get(i8);
                            boolean z4 = nalUnitUtil$SpsData.separateColorPlaneFlag;
                            int i9 = nalUnitUtil$SpsData.picOrderCntLsbLength;
                            int i10 = nalUnitUtil$SpsData.frameNumLength;
                            if (z4) {
                                if (!wavFormat.canReadBits(2)) {
                                    return;
                                } else {
                                    wavFormat.skipBits(2);
                                }
                            }
                            if (wavFormat.canReadBits(i10)) {
                                int bits3 = wavFormat.readBits(i10);
                                if (!nalUnitUtil$SpsData.frameMbsOnlyFlag) {
                                    if (wavFormat.canReadBits(1)) {
                                        bit = wavFormat.readBit();
                                        if (!bit) {
                                            bit2 = false;
                                        } else {
                                            if (!wavFormat.canReadBits(1)) {
                                                return;
                                            }
                                            bit2 = wavFormat.readBit();
                                            z = true;
                                        }
                                        if (sampleReader.nalUnitType == 5) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            expGolombCodeNum = 0;
                                        } else if (!wavFormat.canReadExpGolombCodedNum()) {
                                            return;
                                        } else {
                                            expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                                        }
                                        i3 = nalUnitUtil$SpsData.picOrderCountType;
                                        if (i3 != 0) {
                                            if (wavFormat.canReadBits(i9)) {
                                                bits = wavFormat.readBits(i9);
                                                if (!z3 && !bit) {
                                                    if (!wavFormat.canReadExpGolombCodedNum()) {
                                                        return;
                                                    }
                                                    signedExpGolombCodedInt2 = wavFormat.readSignedExpGolombCodedInt();
                                                    i4 = 0;
                                                }
                                                signedExpGolombCodedInt = 0;
                                                SampleReader.SliceHeaderData sliceHeaderData2 = sampleReader.sliceHeader;
                                                sliceHeaderData2.spsData = nalUnitUtil$SpsData;
                                                sliceHeaderData2.nalRefIdc = bits2;
                                                sliceHeaderData2.sliceType = expGolombCodeNum2;
                                                sliceHeaderData2.frameNum = bits3;
                                                sliceHeaderData2.picParameterSetId = expGolombCodeNum3;
                                                sliceHeaderData2.fieldPicFlag = bit;
                                                sliceHeaderData2.bottomFieldFlagPresent = z;
                                                sliceHeaderData2.bottomFieldFlag = bit2;
                                                sliceHeaderData2.idrPicFlag = z2;
                                                sliceHeaderData2.idrPicId = expGolombCodeNum;
                                                sliceHeaderData2.picOrderCntLsb = bits;
                                                sliceHeaderData2.deltaPicOrderCntBottom = signedExpGolombCodedInt2;
                                                sliceHeaderData2.deltaPicOrderCnt0 = i4;
                                                sliceHeaderData2.deltaPicOrderCnt1 = signedExpGolombCodedInt;
                                                sliceHeaderData2.isComplete = true;
                                                sliceHeaderData2.hasSliceType = true;
                                                sampleReader.isFilling = false;
                                            }
                                            return;
                                        }
                                        if (i3 == 1 || nalUnitUtil$SpsData.deltaPicOrderAlwaysZeroFlag) {
                                            bits = 0;
                                        } else {
                                            if (!wavFormat.canReadExpGolombCodedNum()) {
                                                return;
                                            }
                                            int signedExpGolombCodedInt3 = wavFormat.readSignedExpGolombCodedInt();
                                            if (!z3 || bit) {
                                                i4 = signedExpGolombCodedInt3;
                                                bits = 0;
                                                signedExpGolombCodedInt2 = 0;
                                                signedExpGolombCodedInt = 0;
                                            } else {
                                                if (!wavFormat.canReadExpGolombCodedNum()) {
                                                    return;
                                                }
                                                signedExpGolombCodedInt = wavFormat.readSignedExpGolombCodedInt();
                                                signedExpGolombCodedInt2 = 0;
                                                i4 = signedExpGolombCodedInt3;
                                                bits = 0;
                                            }
                                        }
                                        SampleReader.SliceHeaderData sliceHeaderData3 = sampleReader.sliceHeader;
                                        sliceHeaderData3.spsData = nalUnitUtil$SpsData;
                                        sliceHeaderData3.nalRefIdc = bits2;
                                        sliceHeaderData3.sliceType = expGolombCodeNum2;
                                        sliceHeaderData3.frameNum = bits3;
                                        sliceHeaderData3.picParameterSetId = expGolombCodeNum3;
                                        sliceHeaderData3.fieldPicFlag = bit;
                                        sliceHeaderData3.bottomFieldFlagPresent = z;
                                        sliceHeaderData3.bottomFieldFlag = bit2;
                                        sliceHeaderData3.idrPicFlag = z2;
                                        sliceHeaderData3.idrPicId = expGolombCodeNum;
                                        sliceHeaderData3.picOrderCntLsb = bits;
                                        sliceHeaderData3.deltaPicOrderCntBottom = signedExpGolombCodedInt2;
                                        sliceHeaderData3.deltaPicOrderCnt0 = i4;
                                        sliceHeaderData3.deltaPicOrderCnt1 = signedExpGolombCodedInt;
                                        sliceHeaderData3.isComplete = true;
                                        sliceHeaderData3.hasSliceType = true;
                                        sampleReader.isFilling = false;
                                        i4 = 0;
                                        signedExpGolombCodedInt2 = 0;
                                        signedExpGolombCodedInt = 0;
                                        SampleReader.SliceHeaderData sliceHeaderData4 = sampleReader.sliceHeader;
                                        sliceHeaderData4.spsData = nalUnitUtil$SpsData;
                                        sliceHeaderData4.nalRefIdc = bits2;
                                        sliceHeaderData4.sliceType = expGolombCodeNum2;
                                        sliceHeaderData4.frameNum = bits3;
                                        sliceHeaderData4.picParameterSetId = expGolombCodeNum3;
                                        sliceHeaderData4.fieldPicFlag = bit;
                                        sliceHeaderData4.bottomFieldFlagPresent = z;
                                        sliceHeaderData4.bottomFieldFlag = bit2;
                                        sliceHeaderData4.idrPicFlag = z2;
                                        sliceHeaderData4.idrPicId = expGolombCodeNum;
                                        sliceHeaderData4.picOrderCntLsb = bits;
                                        sliceHeaderData4.deltaPicOrderCntBottom = signedExpGolombCodedInt2;
                                        sliceHeaderData4.deltaPicOrderCnt0 = i4;
                                        sliceHeaderData4.deltaPicOrderCnt1 = signedExpGolombCodedInt;
                                        sliceHeaderData4.isComplete = true;
                                        sliceHeaderData4.hasSliceType = true;
                                        sampleReader.isFilling = false;
                                    }
                                    return;
                                }
                                bit = false;
                                bit2 = false;
                                z = bit2;
                                if (sampleReader.nalUnitType == 5) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    expGolombCodeNum = 0;
                                } else if (!wavFormat.canReadExpGolombCodedNum()) {
                                    return;
                                } else {
                                    expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                                }
                                i3 = nalUnitUtil$SpsData.picOrderCountType;
                                if (i3 != 0) {
                                    if (i3 == 1) {
                                    }
                                    bits = 0;
                                } else {
                                    if (wavFormat.canReadBits(i9)) {
                                        return;
                                    }
                                    bits = wavFormat.readBits(i9);
                                    if (!z3) {
                                    }
                                }
                                i4 = 0;
                                signedExpGolombCodedInt2 = 0;
                                signedExpGolombCodedInt = 0;
                                SampleReader.SliceHeaderData sliceHeaderData5 = sampleReader.sliceHeader;
                                sliceHeaderData5.spsData = nalUnitUtil$SpsData;
                                sliceHeaderData5.nalRefIdc = bits2;
                                sliceHeaderData5.sliceType = expGolombCodeNum2;
                                sliceHeaderData5.frameNum = bits3;
                                sliceHeaderData5.picParameterSetId = expGolombCodeNum3;
                                sliceHeaderData5.fieldPicFlag = bit;
                                sliceHeaderData5.bottomFieldFlagPresent = z;
                                sliceHeaderData5.bottomFieldFlag = bit2;
                                sliceHeaderData5.idrPicFlag = z2;
                                sliceHeaderData5.idrPicId = expGolombCodeNum;
                                sliceHeaderData5.picOrderCntLsb = bits;
                                sliceHeaderData5.deltaPicOrderCntBottom = signedExpGolombCodedInt2;
                                sliceHeaderData5.deltaPicOrderCnt0 = i4;
                                sliceHeaderData5.deltaPicOrderCnt1 = signedExpGolombCodedInt;
                                sliceHeaderData5.isComplete = true;
                                sliceHeaderData5.hasSliceType = true;
                                sampleReader.isFilling = false;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
        this.output.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        if (z) {
            this.seiReader.reorderingBufferQueue.flushQueueDownToSize(0);
            endNalUnit(0, 0, this.totalBytesWritten, this.pesTimeUs);
            startNalUnit(9, this.totalBytesWritten, this.pesTimeUs);
            endNalUnit(0, 0, this.totalBytesWritten, this.pesTimeUs);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.pesTimeUs = j;
        this.randomAccessIndicator = ((i & 2) != 0) | this.randomAccessIndicator;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.totalBytesWritten = 0L;
        this.randomAccessIndicator = false;
        this.pesTimeUs = -9223372036854775807L;
        OpusUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        this.seiReader.reorderingBufferQueue.flushQueueDownToSize(0);
        SampleReader sampleReader = this.sampleReader;
        if (sampleReader != null) {
            sampleReader.isFilling = false;
            sampleReader.readingSample = false;
            SampleReader.SliceHeaderData sliceHeaderData = sampleReader.sliceHeader;
            sliceHeaderData.hasSliceType = false;
            sliceHeaderData.isComplete = false;
        }
    }

    public final void startNalUnit(int i, long j, long j2) {
        if (!this.hasOutputFormat || this.sampleReader.detectAccessUnits) {
            this.sps.startNalUnit(i);
            this.pps.startNalUnit(i);
        }
        this.sei.startNalUnit(i);
        SampleReader sampleReader = this.sampleReader;
        boolean z = this.randomAccessIndicator;
        sampleReader.nalUnitType = i;
        sampleReader.nalUnitTimeUs = j2;
        sampleReader.nalUnitStartPosition = j;
        sampleReader.randomAccessIndicator = z;
        if (!sampleReader.allowNonIdrKeyframes || i != 1) {
            if (!sampleReader.detectAccessUnits) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        SampleReader.SliceHeaderData sliceHeaderData = sampleReader.previousSliceHeader;
        sampleReader.previousSliceHeader = sampleReader.sliceHeader;
        sampleReader.sliceHeader = sliceHeaderData;
        sliceHeaderData.hasSliceType = false;
        sliceHeaderData.isComplete = false;
        sampleReader.bufferLength = 0;
        sampleReader.isFilling = true;
    }
}
