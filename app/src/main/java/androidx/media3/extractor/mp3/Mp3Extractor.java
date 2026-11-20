package androidx.media3.extractor.mp3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil$Header;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.base.Predicates$ObjectPredicate;
import com.yalantis.ucrop.view.CropImageView;
import java.io.EOFException;
import java.math.RoundingMode;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp3Extractor implements Extractor {
    public TrackOutput currentTrackOutput;
    public boolean disableSeeking;
    public long endPositionOfLastSampleRead;
    public ExtractorOutput extractorOutput;
    public long firstSamplePosition;
    public Metadata id3Metadata;
    public boolean isSeekInProgress;
    public TrackOutput realTrackOutput;
    public int sampleBytesRemaining;
    public long samplesRead;
    public long seekTimeUs;
    public Seeker seeker;
    public final DiscardingTrackOutput skippingTrackOutput;
    public int synchronizedHeaderData;
    public Metadata xingMetadata;
    public final ParsableByteArray scratch = new ParsableByteArray(10);
    public final MpegAudioUtil$Header synchronizedHeader = new MpegAudioUtil$Header();
    public final GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
    public long basisTimeUs = -9223372036854775807L;
    public final Id3Peeker id3Peeker = new Id3Peeker((byte) 0);

    public Mp3Extractor() {
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.skippingTrackOutput = discardingTrackOutput;
        this.currentTrackOutput = discardingTrackOutput;
        this.endPositionOfLastSampleRead = -1L;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        TrackOutput trackOutputTrack = extractorOutput.track(0, 1);
        this.realTrackOutput = trackOutputTrack;
        this.currentTrackOutput = trackOutputTrack;
        this.extractorOutput.endTracks();
    }

    public final void maybeUpdateCbrDurationToLastSample() {
        Seeker seeker = this.seeker;
        if ((seeker instanceof ConstantBitrateSeeker) && ((ConstantBitrateSeeker) seeker).isSeekable()) {
            long j = this.endPositionOfLastSampleRead;
            if (j == -1 || j == this.seeker.getDataEndPosition()) {
                return;
            }
            ConstantBitrateSeeker constantBitrateSeeker = (ConstantBitrateSeeker) this.seeker;
            this.seeker = new ConstantBitrateSeeker(this.endPositionOfLastSampleRead, constantBitrateSeeker.firstFramePosition, constantBitrateSeeker.bitrate, constantBitrateSeeker.frameSize, constantBitrateSeeker.allowSeeksIfLengthUnknown, false);
            ExtractorOutput extractorOutput = this.extractorOutput;
            extractorOutput.getClass();
            extractorOutput.seekMap(this.seeker);
            TrackOutput trackOutput = this.realTrackOutput;
            trackOutput.getClass();
            trackOutput.durationUs(this.seeker.getDurationUs());
        }
    }

    public final boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) {
        Seeker seeker = this.seeker;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition == -1 || extractorInput.getPeekPosition() <= dataEndPosition - 4) {
            }
            return true;
        }
        try {
            return !extractorInput.peekFully(this.scratch.data, 0, 4, true);
        } catch (EOFException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:104:0x0246  */
    /* JADX WARN: Code duplicated, block: B:105:0x0251  */
    /* JADX WARN: Code duplicated, block: B:108:0x0264  */
    /* JADX WARN: Code duplicated, block: B:110:0x026c  */
    /* JADX WARN: Code duplicated, block: B:114:0x027c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0282  */
    /* JADX WARN: Code duplicated, block: B:118:0x0286  */
    /* JADX WARN: Code duplicated, block: B:11:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x028a  */
    /* JADX WARN: Code duplicated, block: B:126:0x02be  */
    /* JADX WARN: Code duplicated, block: B:128:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:12:0x0047  */
    /* JADX WARN: Code duplicated, block: B:130:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:138:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:140:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:146:0x032b  */
    /* JADX WARN: Code duplicated, block: B:147:0x032f  */
    /* JADX WARN: Code duplicated, block: B:149:0x0336  */
    /* JADX WARN: Code duplicated, block: B:14:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x0344  */
    /* JADX WARN: Code duplicated, block: B:154:0x0353  */
    /* JADX WARN: Code duplicated, block: B:157:0x0358 A[LOOP:0: B:148:0x0334->B:157:0x0358, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:162:0x0362  */
    /* JADX WARN: Code duplicated, block: B:164:0x036a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0378  */
    /* JADX WARN: Code duplicated, block: B:169:0x038c  */
    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0391 A[LOOP:1: B:163:0x0368->B:172:0x0391, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:176:0x039a  */
    /* JADX WARN: Code duplicated, block: B:177:0x039e  */
    /* JADX WARN: Code duplicated, block: B:180:0x03bd A[LOOP:2: B:179:0x03bb->B:180:0x03bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:185:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:187:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:188:0x0402 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x0405  */
    /* JADX WARN: Code duplicated, block: B:192:0x0409  */
    /* JADX WARN: Code duplicated, block: B:193:0x043a  */
    /* JADX WARN: Code duplicated, block: B:197:0x045f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:198:0x0461  */
    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    /* JADX WARN: Code duplicated, block: B:202:0x049c  */
    /* JADX WARN: Code duplicated, block: B:204:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:206:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:208:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:211:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:214:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:21:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:229:0x0544  */
    /* JADX WARN: Code duplicated, block: B:231:0x054f  */
    /* JADX WARN: Code duplicated, block: B:232:0x0552  */
    /* JADX WARN: Code duplicated, block: B:235:0x055a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code duplicated, block: B:247:0x035b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x035d A[EDGE_INSN: B:248:0x035d->B:159:0x035d BREAK  A[LOOP:0: B:148:0x0334->B:157:0x0358], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x0396 A[EDGE_INSN: B:250:0x0396->B:174:0x0396 BREAK  A[LOOP:1: B:163:0x0368->B:172:0x0391], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:31:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:42:0x0108  */
    /* JADX WARN: Code duplicated, block: B:44:0x010b  */
    /* JADX WARN: Code duplicated, block: B:46:0x010e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0117  */
    /* JADX WARN: Code duplicated, block: B:50:0x011c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0121  */
    /* JADX WARN: Code duplicated, block: B:52:0x0126  */
    /* JADX WARN: Code duplicated, block: B:56:0x0145  */
    /* JADX WARN: Code duplicated, block: B:59:0x015c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0162  */
    /* JADX WARN: Code duplicated, block: B:63:0x017e  */
    /* JADX WARN: Code duplicated, block: B:68:0x019e  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01bb A[LOOP:4: B:77:0x01b9->B:78:0x01bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:80:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01df  */
    /* JADX WARN: Code duplicated, block: B:88:0x0201 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x0209  */
    /* JADX WARN: Code duplicated, block: B:94:0x021f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0237  */
    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean, int] */
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
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws Throwable {
        MpegAudioUtil$Header mpegAudioUtil$Header;
        Throwable th;
        int i;
        long j;
        Seeker seeker;
        ParsableByteArray parsableByteArray;
        boolean z;
        long j2;
        long position;
        long j3;
        ?? r4;
        int iSampleData;
        int i2;
        int i3;
        ParsableByteArray parsableByteArray2;
        int i4;
        int i5;
        int i6;
        int i7;
        long j4;
        int i8;
        GaplessInfoHolder gaplessInfoHolder;
        MpegAudioUtil$Header mpegAudioUtil$Header2;
        int i9;
        int i10;
        int unsignedIntToInt;
        long jMin;
        long[] jArr;
        Mp3InfoReplayGain mp3InfoReplayGain;
        int i11;
        int i12;
        long j5;
        int i13;
        int i14;
        int i15;
        int i16;
        Mp3InfoReplayGain mp3InfoReplayGain2;
        Metadata metadata;
        long position2;
        long length;
        long jSampleCountToDurationUs;
        long j6;
        long j7;
        Seeker constantBitrateSeeker;
        long length2;
        long jSampleCountToDurationUs2;
        float fIntBitsToFloat;
        Mp3InfoReplayGain.GainField gainField;
        Mp3InfoReplayGain.GainField gainField2;
        int i17;
        long[] jArr2;
        int i18;
        Metadata metadata2;
        long position3;
        Metadata.Entry[] entryArr;
        int length3;
        int i19;
        Metadata.Entry entry;
        MlltFrame mlltFrame;
        int[] iArr;
        Metadata.Entry[] entryArr2;
        int length4;
        int i20;
        Metadata.Entry entry2;
        TextInformationFrame textInformationFrame;
        char c;
        long jMsToUs;
        int length5;
        long[] jArr3;
        long[] jArr4;
        int i21;
        MlltSeeker mlltSeeker;
        Metadata.Entry entry3;
        Metadata.Entry entry4;
        boolean z2;
        Seeker unseekableSeeker;
        boolean z3;
        Metadata metadataCopyWithAppendedEntriesFrom;
        Metadata metadata3;
        Format.Builder builder;
        long length6;
        long position4;
        long j8;
        long j9;
        int i22;
        long jSampleCountToDurationUs3;
        int unsignedShort;
        int unsignedShort2;
        int unsignedShort3;
        long[] jArr5;
        long[] jArr6;
        MpegAudioUtil$Header mpegAudioUtil$Header3;
        long j10;
        int i23;
        long j11;
        long jMax;
        MpegAudioUtil$Header mpegAudioUtil$Header4;
        int unsignedByte;
        this.realTrackOutput.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        int i24 = this.synchronizedHeaderData;
        int i25 = 0;
        MpegAudioUtil$Header mpegAudioUtil$Header5 = this.synchronizedHeader;
        if (i24 == 0) {
            try {
                synchronize(extractorInput, false);
                seeker = this.seeker;
                parsableByteArray = this.scratch;
                if (seeker == null) {
                    parsableByteArray2 = new ParsableByteArray(mpegAudioUtil$Header5.frameSize);
                    th = null;
                    extractorInput.peekFully(parsableByteArray2.data, 0, mpegAudioUtil$Header5.frameSize);
                    i4 = mpegAudioUtil$Header5.version & 1;
                    i5 = mpegAudioUtil$Header5.channels;
                    i6 = 21;
                    j = 1000000;
                    if (i4 != 0) {
                        if (i5 != 1) {
                            i7 = 36;
                        }
                        j4 = 0;
                        j2 = -9223372036854775807L;
                        if (parsableByteArray2.limit >= i7 + 4) {
                            parsableByteArray2.setPosition(i7);
                            i8 = parsableByteArray2.readInt();
                            if (i8 != 1483304551 && i8 != 1231971951) {
                                if (parsableByteArray2.limit >= 40) {
                                    parsableByteArray2.setPosition(36);
                                    if (parsableByteArray2.readInt() == 1447187017) {
                                        i8 = 1447187017;
                                    } else {
                                        i8 = 0;
                                    }
                                } else {
                                    i8 = 0;
                                }
                            }
                        } else if (parsableByteArray2.limit >= 40) {
                            parsableByteArray2.setPosition(36);
                            if (parsableByteArray2.readInt() == 1447187017) {
                                i8 = 1447187017;
                            } else {
                                i8 = 0;
                            }
                        } else {
                            i8 = 0;
                        }
                        gaplessInfoHolder = this.gaplessInfoHolder;
                        if (i8 == 1231971951) {
                            mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                            i9 = 0;
                            i10 = parsableByteArray2.readInt();
                            if ((i10 & 1) != 0) {
                                unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                            } else {
                                unsignedIntToInt = -1;
                            }
                            if ((i10 & 2) != 0) {
                                jMin = parsableByteArray2.readUnsignedInt();
                            } else {
                                jMin = -1;
                            }
                            if ((i10 & 4) == 4) {
                                jArr2 = new long[100];
                                i18 = 0;
                                for (i17 = 100; i18 < i17; i17 = 100) {
                                    jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                    i18++;
                                }
                                jArr = jArr2;
                            } else {
                                jArr = null;
                            }
                            if ((i10 & 8) != 0) {
                                parsableByteArray2.skipBytes(4);
                            }
                            if (parsableByteArray2.bytesLeft() >= 24) {
                                parsableByteArray2.skipBytes(11);
                                fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                                int unsignedShort4 = parsableByteArray2.readUnsignedShort();
                                int unsignedShort5 = parsableByteArray2.readUnsignedShort();
                                gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort4);
                                gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort5);
                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO && gainField == null && gainField2 == null) {
                                    mp3InfoReplayGain = null;
                                } else {
                                    mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                                }
                                parsableByteArray2.skipBytes(2);
                                int unsignedInt24 = parsableByteArray2.readUnsignedInt24();
                                i12 = (16773120 & unsignedInt24) >> 12;
                                i11 = unsignedInt24 & 4095;
                            } else {
                                mp3InfoReplayGain = null;
                                i11 = -1;
                                i12 = -1;
                            }
                            j5 = unsignedIntToInt;
                            i13 = mpegAudioUtil$Header2.frameSize;
                            i14 = mpegAudioUtil$Header2.sampleRate;
                            i15 = mpegAudioUtil$Header2.bitrate;
                            i16 = mpegAudioUtil$Header2.samplesPerFrame;
                            mp3InfoReplayGain2 = mp3InfoReplayGain;
                            if ((gaplessInfoHolder.encoderDelay != -1 || gaplessInfoHolder.encoderPadding == -1) && i12 != -1 && i11 != -1) {
                                gaplessInfoHolder.encoderDelay = i12;
                                gaplessInfoHolder.encoderPadding = i11;
                            }
                            if (mp3InfoReplayGain2 != null) {
                                metadata = new Metadata(mp3InfoReplayGain2);
                            } else {
                                metadata = null;
                            }
                            this.xingMetadata = metadata;
                            position2 = extractorInput.getPosition();
                            extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                            if (i8 == 1483304551) {
                                length2 = extractorInput.getLength();
                                if (j5 != -1 || j5 == 0) {
                                    jSampleCountToDurationUs2 = -9223372036854775807L;
                                } else {
                                    jSampleCountToDurationUs2 = Util.sampleCountToDurationUs(i14, (j5 * ((long) i16)) - 1);
                                }
                                if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                    constantBitrateSeeker = null;
                                } else {
                                    if (jMin != -1 && length2 != -1 && position2 + jMin != length2) {
                                        long j12 = length2 - position2;
                                        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j12, "Data size mismatch between stream (", ") and Xing frame (");
                                        sbM.append(jMin);
                                        sbM.append("), using smaller value.");
                                        Log.i("XingSeeker", sbM.toString());
                                        jMin = Math.min(jMin, j12);
                                    }
                                    constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                                }
                            } else {
                                length = extractorInput.getLength();
                                jSampleCountToDurationUs = (j5 != -1 || j5 == 0) ? -9223372036854775807L : Util.sampleCountToDurationUs(i14, (((long) i16) * j5) - 1);
                                if (jSampleCountToDurationUs != -9223372036854775807L) {
                                    if (jMin != -1) {
                                        long j13 = position2 + jMin;
                                        j6 = jMin - ((long) i13);
                                        j7 = j13;
                                    } else if (length != -1) {
                                        j6 = (length - position2) - ((long) i13);
                                        j7 = length;
                                    } else {
                                        constantBitrateSeeker = null;
                                    }
                                    long j14 = j6;
                                    RoundingMode roundingMode = RoundingMode.HALF_UP;
                                    constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j14, 8000000L, jSampleCountToDurationUs, roundingMode)), StringsKt__IndentKt.checkedCast(MathKt.divide(j14, j5, roundingMode)), false, true);
                                } else {
                                    constantBitrateSeeker = null;
                                }
                            }
                        } else if (i8 != 1447187017) {
                            length6 = extractorInput.getLength();
                            position4 = extractorInput.getPosition();
                            parsableByteArray2.skipBytes(6);
                            int i26 = parsableByteArray2.readInt();
                            i9 = 0;
                            j8 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                            j9 = j8 + ((long) i26);
                            i22 = parsableByteArray2.readInt();
                            if (i22 <= 0) {
                                jSampleCountToDurationUs3 = Util.sampleCountToDurationUs(mpegAudioUtil$Header5.sampleRate, (((long) i22) * ((long) mpegAudioUtil$Header5.samplesPerFrame)) - 1);
                                unsignedShort = parsableByteArray2.readUnsignedShort();
                                unsignedShort2 = parsableByteArray2.readUnsignedShort();
                                unsignedShort3 = parsableByteArray2.readUnsignedShort();
                                parsableByteArray2.skipBytes(2);
                                jArr5 = new long[unsignedShort];
                                jArr6 = new long[unsignedShort];
                                mpegAudioUtil$Header3 = mpegAudioUtil$Header5;
                                j10 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                                i23 = 0;
                                while (true) {
                                    if (i23 < unsignedShort) {
                                        long[] jArr7 = jArr5;
                                        long[] jArr8 = jArr6;
                                        MpegAudioUtil$Header mpegAudioUtil$Header6 = mpegAudioUtil$Header3;
                                        if (length6 != -1 || length6 == j9) {
                                            j11 = j9;
                                        } else {
                                            StringBuilder sbM2 = Fragment$5$$ExternalSyntheticOutline0.m(length6, "VBRI data size mismatch: ", ", ");
                                            j11 = j9;
                                            sbM2.append(j11);
                                            Log.w("VbriSeeker", sbM2.toString());
                                        }
                                        if (j11 != j10) {
                                            StringBuilder sbM3 = Fragment$5$$ExternalSyntheticOutline0.m(j11, "VBRI bytes and ToC mismatch (using max): ", ", ");
                                            sbM3.append(j10);
                                            sbM3.append("\nSeeking will be inaccurate.");
                                            Log.w("VbriSeeker", sbM3.toString());
                                            jMax = Math.max(j11, j10);
                                        } else {
                                            jMax = j11;
                                        }
                                        mpegAudioUtil$Header2 = mpegAudioUtil$Header6;
                                        constantBitrateSeeker = new VbriSeeker(jArr7, jArr8, jSampleCountToDurationUs3, j8, jMax, mpegAudioUtil$Header2.bitrate);
                                        break;
                                    }
                                    long[] jArr9 = jArr6;
                                    mpegAudioUtil$Header4 = mpegAudioUtil$Header3;
                                    int i27 = i23;
                                    long[] jArr10 = jArr5;
                                    jArr10[i27] = (((long) i23) * jSampleCountToDurationUs3) / ((long) unsignedShort);
                                    jArr9[i27] = j10;
                                    if (unsignedShort3 != 1) {
                                        unsignedByte = parsableByteArray2.readUnsignedByte();
                                    } else if (unsignedShort3 != 2) {
                                        unsignedByte = parsableByteArray2.readUnsignedShort();
                                    } else if (unsignedShort3 != 3) {
                                        unsignedByte = parsableByteArray2.readUnsignedInt24();
                                    } else {
                                        if (unsignedShort3 != 4) {
                                            constantBitrateSeeker = null;
                                            mpegAudioUtil$Header2 = mpegAudioUtil$Header4;
                                            break;
                                        }
                                        unsignedByte = parsableByteArray2.readUnsignedIntToInt();
                                    }
                                    j10 += ((long) unsignedByte) * ((long) unsignedShort2);
                                    i23 = i27 + 1;
                                    jArr6 = jArr9;
                                    mpegAudioUtil$Header3 = mpegAudioUtil$Header4;
                                    jArr5 = jArr10;
                                }
                            } else {
                                constantBitrateSeeker = null;
                                mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                            }
                            extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                        } else if (i8 != 1483304551) {
                            extractorInput.resetPeekPosition();
                            constantBitrateSeeker = null;
                            mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                            i9 = 0;
                        } else {
                            mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                            i9 = 0;
                            i10 = parsableByteArray2.readInt();
                            if ((i10 & 1) != 0) {
                                unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                            } else {
                                unsignedIntToInt = -1;
                            }
                            if ((i10 & 2) != 0) {
                                jMin = parsableByteArray2.readUnsignedInt();
                            } else {
                                jMin = -1;
                            }
                            if ((i10 & 4) == 4) {
                                jArr2 = new long[100];
                                i18 = 0;
                                while (i18 < i17) {
                                    jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                    i18++;
                                }
                                jArr = jArr2;
                            } else {
                                jArr = null;
                            }
                            if ((i10 & 8) != 0) {
                                parsableByteArray2.skipBytes(4);
                            }
                            if (parsableByteArray2.bytesLeft() >= 24) {
                                parsableByteArray2.skipBytes(11);
                                fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                                int unsignedShort6 = parsableByteArray2.readUnsignedShort();
                                int unsignedShort7 = parsableByteArray2.readUnsignedShort();
                                gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort6);
                                gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort7);
                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                    mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                                } else {
                                    mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                                }
                                parsableByteArray2.skipBytes(2);
                                int unsignedInt25 = parsableByteArray2.readUnsignedInt24();
                                i12 = (16773120 & unsignedInt25) >> 12;
                                i11 = unsignedInt25 & 4095;
                            } else {
                                mp3InfoReplayGain = null;
                                i11 = -1;
                                i12 = -1;
                            }
                            j5 = unsignedIntToInt;
                            i13 = mpegAudioUtil$Header2.frameSize;
                            i14 = mpegAudioUtil$Header2.sampleRate;
                            i15 = mpegAudioUtil$Header2.bitrate;
                            i16 = mpegAudioUtil$Header2.samplesPerFrame;
                            mp3InfoReplayGain2 = mp3InfoReplayGain;
                            if (gaplessInfoHolder.encoderDelay != -1) {
                                gaplessInfoHolder.encoderDelay = i12;
                                gaplessInfoHolder.encoderPadding = i11;
                            } else {
                                gaplessInfoHolder.encoderDelay = i12;
                                gaplessInfoHolder.encoderPadding = i11;
                            }
                            if (mp3InfoReplayGain2 != null) {
                                metadata = new Metadata(mp3InfoReplayGain2);
                            } else {
                                metadata = null;
                            }
                            this.xingMetadata = metadata;
                            position2 = extractorInput.getPosition();
                            extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                            if (i8 == 1483304551) {
                                length2 = extractorInput.getLength();
                                if (j5 != -1) {
                                    jSampleCountToDurationUs2 = -9223372036854775807L;
                                } else {
                                    jSampleCountToDurationUs2 = -9223372036854775807L;
                                }
                                if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                    constantBitrateSeeker = null;
                                } else {
                                    if (jMin != -1) {
                                        long j15 = length2 - position2;
                                        StringBuilder sbM4 = Fragment$5$$ExternalSyntheticOutline0.m(j15, "Data size mismatch between stream (", ") and Xing frame (");
                                        sbM4.append(jMin);
                                        sbM4.append("), using smaller value.");
                                        Log.i("XingSeeker", sbM4.toString());
                                        jMin = Math.min(jMin, j15);
                                    }
                                    constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                                }
                            } else {
                                length = extractorInput.getLength();
                                if (j5 != -1) {
                                }
                                if (jSampleCountToDurationUs != -9223372036854775807L) {
                                    if (jMin != -1) {
                                        long j16 = position2 + jMin;
                                        j6 = jMin - ((long) i13);
                                        j7 = j16;
                                    } else if (length != -1) {
                                        j6 = (length - position2) - ((long) i13);
                                        j7 = length;
                                    } else {
                                        constantBitrateSeeker = null;
                                    }
                                    long j17 = j6;
                                    RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                                    constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j17, 8000000L, jSampleCountToDurationUs, roundingMode2)), StringsKt__IndentKt.checkedCast(MathKt.divide(j17, j5, roundingMode2)), false, true);
                                } else {
                                    constantBitrateSeeker = null;
                                }
                            }
                        }
                        metadata2 = this.id3Metadata;
                        position3 = extractorInput.getPosition();
                        if (metadata2 == null) {
                            mlltSeeker = null;
                        } else {
                            entryArr = metadata2.entries;
                            length3 = entryArr.length;
                            i19 = i9;
                            while (true) {
                                if (i19 < length3) {
                                    entry = null;
                                    break;
                                }
                                entry4 = entryArr[i19];
                                if (MlltFrame.class.isAssignableFrom(entry4.getClass())) {
                                    entry = (Metadata.Entry) MlltFrame.class.cast(entry4);
                                    if (!Predicates$ObjectPredicate.ALWAYS_TRUE.apply(entry)) {
                                        entry = null;
                                    }
                                } else {
                                    entry = null;
                                }
                                if (entry != null) {
                                    break;
                                }
                                i19++;
                            }
                            mlltFrame = (MlltFrame) entry;
                            if (mlltFrame == null) {
                                mlltSeeker = null;
                            } else {
                                iArr = mlltFrame.bytesDeviations;
                                entryArr2 = metadata2.entries;
                                length4 = entryArr2.length;
                                i20 = 0;
                                while (true) {
                                    if (i20 < length4) {
                                        entry2 = null;
                                        break;
                                    }
                                    entry3 = entryArr2[i20];
                                    if (TextInformationFrame.class.isAssignableFrom(entry3.getClass())) {
                                        entry2 = (Metadata.Entry) TextInformationFrame.class.cast(entry3);
                                        if (!((TextInformationFrame) entry2).id.equals("TLEN")) {
                                            entry2 = null;
                                        }
                                    } else {
                                        entry2 = null;
                                    }
                                    if (entry2 != null) {
                                        break;
                                    }
                                    i20++;
                                }
                                textInformationFrame = (TextInformationFrame) entry2;
                                if (textInformationFrame == null) {
                                    jMsToUs = -9223372036854775807L;
                                    c = 0;
                                } else {
                                    c = 0;
                                    jMsToUs = Util.msToUs(Long.parseLong((String) textInformationFrame.values.get(0)));
                                }
                                length5 = iArr.length;
                                int i28 = length5 + 1;
                                jArr3 = new long[i28];
                                jArr4 = new long[i28];
                                jArr3[c] = position3;
                                jArr4[c] = 0;
                                i21 = 1;
                                while (i21 <= length5) {
                                    int i29 = i21 - 1;
                                    long j18 = position3 + ((long) (mlltFrame.bytesBetweenReference + iArr[i29]));
                                    j4 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i29]);
                                    jArr3[i21] = j18;
                                    jArr4[i21] = j4;
                                    i21++;
                                    length5 = length5;
                                    position3 = j18;
                                }
                                mlltSeeker = new MlltSeeker(jMsToUs, jArr3, jArr4);
                            }
                        }
                        if (this.disableSeeking) {
                            unseekableSeeker = new Seeker.UnseekableSeeker(-9223372036854775807L);
                            parsableByteArray = parsableByteArray;
                            gaplessInfoHolder = gaplessInfoHolder;
                            mpegAudioUtil$Header = mpegAudioUtil$Header2;
                            z3 = true;
                            i25 = 0;
                        } else {
                            j2 = -9223372036854775807L;
                            if (mlltSeeker != null) {
                                constantBitrateSeeker = mlltSeeker;
                            } else if (constantBitrateSeeker == null) {
                                constantBitrateSeeker = null;
                            }
                            if (constantBitrateSeeker == null) {
                                int i30 = i9;
                                extractorInput.peekFully(parsableByteArray.data, i30, 4);
                                parsableByteArray.setPosition(i30);
                                mpegAudioUtil$Header2.setForHeaderData(parsableByteArray.readInt());
                                mpegAudioUtil$Header = mpegAudioUtil$Header2;
                                z2 = true;
                                i25 = 0;
                                constantBitrateSeeker = new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), mpegAudioUtil$Header2.bitrate, mpegAudioUtil$Header2.frameSize, false, true);
                            } else {
                                mpegAudioUtil$Header = mpegAudioUtil$Header2;
                                z2 = true;
                                i25 = 0;
                            }
                            constantBitrateSeeker.isSeekable();
                            constantBitrateSeeker.isSeekable();
                            this.realTrackOutput.durationUs(constantBitrateSeeker.getDurationUs());
                            unseekableSeeker = constantBitrateSeeker;
                            z3 = z2;
                        }
                        this.seeker = unseekableSeeker;
                        this.extractorOutput.seekMap(unseekableSeeker);
                        metadataCopyWithAppendedEntriesFrom = this.id3Metadata;
                        metadata3 = this.xingMetadata;
                        if (metadataCopyWithAppendedEntriesFrom != null) {
                            if (metadata3 != null) {
                                metadataCopyWithAppendedEntriesFrom = metadataCopyWithAppendedEntriesFrom.copyWithAppendedEntriesFrom(metadata3);
                            }
                            metadata3 = metadataCopyWithAppendedEntriesFrom;
                        }
                        builder = new Format.Builder();
                        builder.containerMimeType = MimeTypes.normalizeMimeType("audio/mpeg");
                        builder.sampleMimeType = MimeTypes.normalizeMimeType(mpegAudioUtil$Header.mimeType);
                        builder.maxInputSize = 4096;
                        builder.channelCount = mpegAudioUtil$Header.channels;
                        builder.sampleRate = mpegAudioUtil$Header.sampleRate;
                        builder.encoderDelay = gaplessInfoHolder.encoderDelay;
                        builder.encoderPadding = gaplessInfoHolder.encoderPadding;
                        builder.metadata = metadata3;
                        if (this.seeker.getAverageBitrate() != -2147483647) {
                            builder.averageBitrate = this.seeker.getAverageBitrate();
                        }
                        this.currentTrackOutput.format(new Format(builder));
                        this.firstSamplePosition = extractorInput.getPosition();
                        r4 = z3;
                    } else if (i5 == 1) {
                        i6 = 13;
                    }
                    i7 = i6;
                    j4 = 0;
                    j2 = -9223372036854775807L;
                    if (parsableByteArray2.limit >= i7 + 4) {
                        parsableByteArray2.setPosition(i7);
                        i8 = parsableByteArray2.readInt();
                        if (i8 != 1483304551) {
                            if (parsableByteArray2.limit >= 40) {
                                parsableByteArray2.setPosition(36);
                                if (parsableByteArray2.readInt() == 1447187017) {
                                    i8 = 1447187017;
                                } else {
                                    i8 = 0;
                                }
                            } else {
                                i8 = 0;
                            }
                        }
                    } else if (parsableByteArray2.limit >= 40) {
                        parsableByteArray2.setPosition(36);
                        if (parsableByteArray2.readInt() == 1447187017) {
                            i8 = 1447187017;
                        } else {
                            i8 = 0;
                        }
                    } else {
                        i8 = 0;
                    }
                    gaplessInfoHolder = this.gaplessInfoHolder;
                    if (i8 == 1231971951) {
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                        i10 = parsableByteArray2.readInt();
                        if ((i10 & 1) != 0) {
                            unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                        } else {
                            unsignedIntToInt = -1;
                        }
                        if ((i10 & 2) != 0) {
                            jMin = parsableByteArray2.readUnsignedInt();
                        } else {
                            jMin = -1;
                        }
                        if ((i10 & 4) == 4) {
                            jArr2 = new long[100];
                            i18 = 0;
                            while (i18 < i17) {
                                jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                i18++;
                            }
                            jArr = jArr2;
                        } else {
                            jArr = null;
                        }
                        if ((i10 & 8) != 0) {
                            parsableByteArray2.skipBytes(4);
                        }
                        if (parsableByteArray2.bytesLeft() >= 24) {
                            parsableByteArray2.skipBytes(11);
                            fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                            int unsignedShort8 = parsableByteArray2.readUnsignedShort();
                            int unsignedShort9 = parsableByteArray2.readUnsignedShort();
                            gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort8);
                            gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort9);
                            if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            } else {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            }
                            parsableByteArray2.skipBytes(2);
                            int unsignedInt26 = parsableByteArray2.readUnsignedInt24();
                            i12 = (16773120 & unsignedInt26) >> 12;
                            i11 = unsignedInt26 & 4095;
                        } else {
                            mp3InfoReplayGain = null;
                            i11 = -1;
                            i12 = -1;
                        }
                        j5 = unsignedIntToInt;
                        i13 = mpegAudioUtil$Header2.frameSize;
                        i14 = mpegAudioUtil$Header2.sampleRate;
                        i15 = mpegAudioUtil$Header2.bitrate;
                        i16 = mpegAudioUtil$Header2.samplesPerFrame;
                        mp3InfoReplayGain2 = mp3InfoReplayGain;
                        if (gaplessInfoHolder.encoderDelay != -1) {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        } else {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        }
                        if (mp3InfoReplayGain2 != null) {
                            metadata = new Metadata(mp3InfoReplayGain2);
                        } else {
                            metadata = null;
                        }
                        this.xingMetadata = metadata;
                        position2 = extractorInput.getPosition();
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                        if (i8 == 1483304551) {
                            length2 = extractorInput.getLength();
                            if (j5 != -1) {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            } else {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            }
                            if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                constantBitrateSeeker = null;
                            } else {
                                if (jMin != -1) {
                                    long j19 = length2 - position2;
                                    StringBuilder sbM5 = Fragment$5$$ExternalSyntheticOutline0.m(j19, "Data size mismatch between stream (", ") and Xing frame (");
                                    sbM5.append(jMin);
                                    sbM5.append("), using smaller value.");
                                    Log.i("XingSeeker", sbM5.toString());
                                    jMin = Math.min(jMin, j19);
                                }
                                constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                            }
                        } else {
                            length = extractorInput.getLength();
                            if (j5 != -1) {
                            }
                            if (jSampleCountToDurationUs != -9223372036854775807L) {
                                if (jMin != -1) {
                                    long j110 = position2 + jMin;
                                    j6 = jMin - ((long) i13);
                                    j7 = j110;
                                } else if (length != -1) {
                                    j6 = (length - position2) - ((long) i13);
                                    j7 = length;
                                } else {
                                    constantBitrateSeeker = null;
                                }
                                long j111 = j6;
                                RoundingMode roundingMode3 = RoundingMode.HALF_UP;
                                constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j111, 8000000L, jSampleCountToDurationUs, roundingMode3)), StringsKt__IndentKt.checkedCast(MathKt.divide(j111, j5, roundingMode3)), false, true);
                            } else {
                                constantBitrateSeeker = null;
                            }
                        }
                    } else if (i8 != 1447187017) {
                        length6 = extractorInput.getLength();
                        position4 = extractorInput.getPosition();
                        parsableByteArray2.skipBytes(6);
                        int i210 = parsableByteArray2.readInt();
                        i9 = 0;
                        j8 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                        j9 = j8 + ((long) i210);
                        i22 = parsableByteArray2.readInt();
                        if (i22 <= 0) {
                            jSampleCountToDurationUs3 = Util.sampleCountToDurationUs(mpegAudioUtil$Header5.sampleRate, (((long) i22) * ((long) mpegAudioUtil$Header5.samplesPerFrame)) - 1);
                            unsignedShort = parsableByteArray2.readUnsignedShort();
                            unsignedShort2 = parsableByteArray2.readUnsignedShort();
                            unsignedShort3 = parsableByteArray2.readUnsignedShort();
                            parsableByteArray2.skipBytes(2);
                            jArr5 = new long[unsignedShort];
                            jArr6 = new long[unsignedShort];
                            mpegAudioUtil$Header3 = mpegAudioUtil$Header5;
                            j10 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                            i23 = 0;
                            while (true) {
                                if (i23 < unsignedShort) {
                                    long[] jArr11 = jArr5;
                                    long[] jArr12 = jArr6;
                                    MpegAudioUtil$Header mpegAudioUtil$Header7 = mpegAudioUtil$Header3;
                                    if (length6 != -1) {
                                        j11 = j9;
                                    } else {
                                        j11 = j9;
                                    }
                                    if (j11 != j10) {
                                        StringBuilder sbM6 = Fragment$5$$ExternalSyntheticOutline0.m(j11, "VBRI bytes and ToC mismatch (using max): ", ", ");
                                        sbM6.append(j10);
                                        sbM6.append("\nSeeking will be inaccurate.");
                                        Log.w("VbriSeeker", sbM6.toString());
                                        jMax = Math.max(j11, j10);
                                    } else {
                                        jMax = j11;
                                    }
                                    mpegAudioUtil$Header2 = mpegAudioUtil$Header7;
                                    constantBitrateSeeker = new VbriSeeker(jArr11, jArr12, jSampleCountToDurationUs3, j8, jMax, mpegAudioUtil$Header2.bitrate);
                                    break;
                                }
                                long[] jArr13 = jArr6;
                                mpegAudioUtil$Header4 = mpegAudioUtil$Header3;
                                int i211 = i23;
                                long[] jArr14 = jArr5;
                                jArr14[i211] = (((long) i23) * jSampleCountToDurationUs3) / ((long) unsignedShort);
                                jArr13[i211] = j10;
                                if (unsignedShort3 != 1) {
                                    unsignedByte = parsableByteArray2.readUnsignedByte();
                                } else if (unsignedShort3 != 2) {
                                    unsignedByte = parsableByteArray2.readUnsignedShort();
                                } else if (unsignedShort3 != 3) {
                                    unsignedByte = parsableByteArray2.readUnsignedInt24();
                                } else {
                                    if (unsignedShort3 != 4) {
                                        constantBitrateSeeker = null;
                                        mpegAudioUtil$Header2 = mpegAudioUtil$Header4;
                                        break;
                                    }
                                    unsignedByte = parsableByteArray2.readUnsignedIntToInt();
                                }
                                j10 += ((long) unsignedByte) * ((long) unsignedShort2);
                                i23 = i211 + 1;
                                jArr6 = jArr13;
                                mpegAudioUtil$Header3 = mpegAudioUtil$Header4;
                                jArr5 = jArr14;
                            }
                        } else {
                            constantBitrateSeeker = null;
                            mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        }
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                    } else if (i8 != 1483304551) {
                        extractorInput.resetPeekPosition();
                        constantBitrateSeeker = null;
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                    } else {
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                        i10 = parsableByteArray2.readInt();
                        if ((i10 & 1) != 0) {
                            unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                        } else {
                            unsignedIntToInt = -1;
                        }
                        if ((i10 & 2) != 0) {
                            jMin = parsableByteArray2.readUnsignedInt();
                        } else {
                            jMin = -1;
                        }
                        if ((i10 & 4) == 4) {
                            jArr2 = new long[100];
                            i18 = 0;
                            while (i18 < i17) {
                                jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                i18++;
                            }
                            jArr = jArr2;
                        } else {
                            jArr = null;
                        }
                        if ((i10 & 8) != 0) {
                            parsableByteArray2.skipBytes(4);
                        }
                        if (parsableByteArray2.bytesLeft() >= 24) {
                            parsableByteArray2.skipBytes(11);
                            fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                            int unsignedShort10 = parsableByteArray2.readUnsignedShort();
                            int unsignedShort11 = parsableByteArray2.readUnsignedShort();
                            gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort10);
                            gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort11);
                            if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            } else {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            }
                            parsableByteArray2.skipBytes(2);
                            int unsignedInt27 = parsableByteArray2.readUnsignedInt24();
                            i12 = (16773120 & unsignedInt27) >> 12;
                            i11 = unsignedInt27 & 4095;
                        } else {
                            mp3InfoReplayGain = null;
                            i11 = -1;
                            i12 = -1;
                        }
                        j5 = unsignedIntToInt;
                        i13 = mpegAudioUtil$Header2.frameSize;
                        i14 = mpegAudioUtil$Header2.sampleRate;
                        i15 = mpegAudioUtil$Header2.bitrate;
                        i16 = mpegAudioUtil$Header2.samplesPerFrame;
                        mp3InfoReplayGain2 = mp3InfoReplayGain;
                        if (gaplessInfoHolder.encoderDelay != -1) {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        } else {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        }
                        if (mp3InfoReplayGain2 != null) {
                            metadata = new Metadata(mp3InfoReplayGain2);
                        } else {
                            metadata = null;
                        }
                        this.xingMetadata = metadata;
                        position2 = extractorInput.getPosition();
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                        if (i8 == 1483304551) {
                            length2 = extractorInput.getLength();
                            if (j5 != -1) {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            } else {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            }
                            if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                constantBitrateSeeker = null;
                            } else {
                                if (jMin != -1) {
                                    long j112 = length2 - position2;
                                    StringBuilder sbM7 = Fragment$5$$ExternalSyntheticOutline0.m(j112, "Data size mismatch between stream (", ") and Xing frame (");
                                    sbM7.append(jMin);
                                    sbM7.append("), using smaller value.");
                                    Log.i("XingSeeker", sbM7.toString());
                                    jMin = Math.min(jMin, j112);
                                }
                                constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                            }
                        } else {
                            length = extractorInput.getLength();
                            if (j5 != -1) {
                            }
                            if (jSampleCountToDurationUs != -9223372036854775807L) {
                                if (jMin != -1) {
                                    long j113 = position2 + jMin;
                                    j6 = jMin - ((long) i13);
                                    j7 = j113;
                                } else if (length != -1) {
                                    j6 = (length - position2) - ((long) i13);
                                    j7 = length;
                                } else {
                                    constantBitrateSeeker = null;
                                }
                                long j114 = j6;
                                RoundingMode roundingMode4 = RoundingMode.HALF_UP;
                                constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j114, 8000000L, jSampleCountToDurationUs, roundingMode4)), StringsKt__IndentKt.checkedCast(MathKt.divide(j114, j5, roundingMode4)), false, true);
                            } else {
                                constantBitrateSeeker = null;
                            }
                        }
                    }
                    metadata2 = this.id3Metadata;
                    position3 = extractorInput.getPosition();
                    if (metadata2 == null) {
                        mlltSeeker = null;
                    } else {
                        entryArr = metadata2.entries;
                        length3 = entryArr.length;
                        i19 = i9;
                        while (true) {
                            if (i19 < length3) {
                                entry = null;
                                break;
                            }
                            entry4 = entryArr[i19];
                            if (MlltFrame.class.isAssignableFrom(entry4.getClass())) {
                                entry = (Metadata.Entry) MlltFrame.class.cast(entry4);
                                if (!Predicates$ObjectPredicate.ALWAYS_TRUE.apply(entry)) {
                                    entry = null;
                                }
                            } else {
                                entry = null;
                            }
                            if (entry != null) {
                                break;
                                break;
                            }
                            i19++;
                        }
                        mlltFrame = (MlltFrame) entry;
                        if (mlltFrame == null) {
                            mlltSeeker = null;
                        } else {
                            iArr = mlltFrame.bytesDeviations;
                            entryArr2 = metadata2.entries;
                            length4 = entryArr2.length;
                            i20 = 0;
                            while (true) {
                                if (i20 < length4) {
                                    entry2 = null;
                                    break;
                                }
                                entry3 = entryArr2[i20];
                                if (TextInformationFrame.class.isAssignableFrom(entry3.getClass())) {
                                    entry2 = (Metadata.Entry) TextInformationFrame.class.cast(entry3);
                                    if (!((TextInformationFrame) entry2).id.equals("TLEN")) {
                                        entry2 = null;
                                    }
                                } else {
                                    entry2 = null;
                                }
                                if (entry2 != null) {
                                    break;
                                    break;
                                }
                                i20++;
                            }
                            textInformationFrame = (TextInformationFrame) entry2;
                            if (textInformationFrame == null) {
                                jMsToUs = -9223372036854775807L;
                                c = 0;
                            } else {
                                c = 0;
                                jMsToUs = Util.msToUs(Long.parseLong((String) textInformationFrame.values.get(0)));
                            }
                            length5 = iArr.length;
                            int i212 = length5 + 1;
                            jArr3 = new long[i212];
                            jArr4 = new long[i212];
                            jArr3[c] = position3;
                            jArr4[c] = 0;
                            i21 = 1;
                            while (i21 <= length5) {
                                int i213 = i21 - 1;
                                long j115 = position3 + ((long) (mlltFrame.bytesBetweenReference + iArr[i213]));
                                j4 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i213]);
                                jArr3[i21] = j115;
                                jArr4[i21] = j4;
                                i21++;
                                length5 = length5;
                                position3 = j115;
                            }
                            mlltSeeker = new MlltSeeker(jMsToUs, jArr3, jArr4);
                        }
                    }
                    if (this.disableSeeking) {
                        unseekableSeeker = new Seeker.UnseekableSeeker(-9223372036854775807L);
                        parsableByteArray = parsableByteArray;
                        gaplessInfoHolder = gaplessInfoHolder;
                        mpegAudioUtil$Header = mpegAudioUtil$Header2;
                        z3 = true;
                        i25 = 0;
                    } else {
                        j2 = -9223372036854775807L;
                        if (mlltSeeker != null) {
                            constantBitrateSeeker = mlltSeeker;
                        } else if (constantBitrateSeeker == null) {
                            constantBitrateSeeker = null;
                        }
                        if (constantBitrateSeeker == null) {
                            int i31 = i9;
                            extractorInput.peekFully(parsableByteArray.data, i31, 4);
                            parsableByteArray.setPosition(i31);
                            mpegAudioUtil$Header2.setForHeaderData(parsableByteArray.readInt());
                            mpegAudioUtil$Header = mpegAudioUtil$Header2;
                            z2 = true;
                            i25 = 0;
                            constantBitrateSeeker = new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), mpegAudioUtil$Header2.bitrate, mpegAudioUtil$Header2.frameSize, false, true);
                        } else {
                            mpegAudioUtil$Header = mpegAudioUtil$Header2;
                            z2 = true;
                            i25 = 0;
                        }
                        constantBitrateSeeker.isSeekable();
                        constantBitrateSeeker.isSeekable();
                        this.realTrackOutput.durationUs(constantBitrateSeeker.getDurationUs());
                        unseekableSeeker = constantBitrateSeeker;
                        z3 = z2;
                    }
                    this.seeker = unseekableSeeker;
                    this.extractorOutput.seekMap(unseekableSeeker);
                    metadataCopyWithAppendedEntriesFrom = this.id3Metadata;
                    metadata3 = this.xingMetadata;
                    if (metadataCopyWithAppendedEntriesFrom != null) {
                        if (metadata3 != null) {
                            metadataCopyWithAppendedEntriesFrom = metadataCopyWithAppendedEntriesFrom.copyWithAppendedEntriesFrom(metadata3);
                        }
                        metadata3 = metadataCopyWithAppendedEntriesFrom;
                    }
                    builder = new Format.Builder();
                    builder.containerMimeType = MimeTypes.normalizeMimeType("audio/mpeg");
                    builder.sampleMimeType = MimeTypes.normalizeMimeType(mpegAudioUtil$Header.mimeType);
                    builder.maxInputSize = 4096;
                    builder.channelCount = mpegAudioUtil$Header.channels;
                    builder.sampleRate = mpegAudioUtil$Header.sampleRate;
                    builder.encoderDelay = gaplessInfoHolder.encoderDelay;
                    builder.encoderPadding = gaplessInfoHolder.encoderPadding;
                    builder.metadata = metadata3;
                    if (this.seeker.getAverageBitrate() != -2147483647) {
                        builder.averageBitrate = this.seeker.getAverageBitrate();
                    }
                    this.currentTrackOutput.format(new Format(builder));
                    this.firstSamplePosition = extractorInput.getPosition();
                    r4 = z3;
                } else {
                    mpegAudioUtil$Header = mpegAudioUtil$Header5;
                    parsableByteArray = parsableByteArray;
                    z = true;
                    th = null;
                    j = 1000000;
                    j2 = -9223372036854775807L;
                    if (this.firstSamplePosition != 0) {
                        position = extractorInput.getPosition();
                        j3 = this.firstSamplePosition;
                        if (position < j3) {
                            r4 = z;
                            r4 = z;
                            extractorInput.skipFully((int) (j3 - position));
                            r4 = z;
                        }
                    }
                }
                r4 = z;
                r4 = z;
                r4 = z;
                if (this.sampleBytesRemaining == 0) {
                    extractorInput.resetPeekPosition();
                    if (peekEndOfStreamOrHeader(extractorInput)) {
                        i = -1;
                        i25 = -1;
                    } else {
                        parsableByteArray.setPosition(i25);
                        i3 = parsableByteArray.readInt();
                        if (((-128000) & i3) == (((long) this.synchronizedHeaderData) & (-128000)) || AacUtil.getFrameSize(i3) == -1) {
                            extractorInput.skipFully(r4);
                            this.synchronizedHeaderData = i25;
                        } else {
                            mpegAudioUtil$Header.setForHeaderData(i3);
                            if (this.basisTimeUs == j2) {
                                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                            }
                            this.sampleBytesRemaining = mpegAudioUtil$Header.frameSize;
                            this.endPositionOfLastSampleRead = extractorInput.getPosition() + ((long) mpegAudioUtil$Header.frameSize);
                            if (this.seeker instanceof IndexSeeker) {
                                long j20 = ((this.samplesRead + ((long) mpegAudioUtil$Header.samplesPerFrame)) * j) / ((long) mpegAudioUtil$Header.sampleRate);
                                throw th;
                            }
                            iSampleData = this.currentTrackOutput.sampleData(extractorInput, this.sampleBytesRemaining, (boolean) r4);
                            if (iSampleData == -1) {
                                i = -1;
                                i25 = -1;
                            } else {
                                i2 = this.sampleBytesRemaining - iSampleData;
                                this.sampleBytesRemaining = i2;
                                if (i2 <= 0) {
                                    this.currentTrackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * j) / ((long) mpegAudioUtil$Header.sampleRate)), 1, mpegAudioUtil$Header.frameSize, 0, null);
                                    this.samplesRead += (long) mpegAudioUtil$Header.samplesPerFrame;
                                    this.sampleBytesRemaining = i25;
                                }
                            }
                        }
                        i = -1;
                    }
                } else {
                    iSampleData = this.currentTrackOutput.sampleData(extractorInput, this.sampleBytesRemaining, (boolean) r4);
                    if (iSampleData == -1) {
                        i = -1;
                        i25 = -1;
                    } else {
                        i2 = this.sampleBytesRemaining - iSampleData;
                        this.sampleBytesRemaining = i2;
                        if (i2 <= 0) {
                            this.currentTrackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * j) / ((long) mpegAudioUtil$Header.sampleRate)), 1, mpegAudioUtil$Header.frameSize, 0, null);
                            this.samplesRead += (long) mpegAudioUtil$Header.samplesPerFrame;
                            this.sampleBytesRemaining = i25;
                        }
                        i = -1;
                    }
                }
            } catch (EOFException unused) {
                mpegAudioUtil$Header = mpegAudioUtil$Header5;
                th = null;
                i = -1;
                i25 = -1;
                j = 1000000;
            }
        } else {
            seeker = this.seeker;
            parsableByteArray = this.scratch;
            if (seeker == null) {
                parsableByteArray2 = new ParsableByteArray(mpegAudioUtil$Header5.frameSize);
                th = null;
                extractorInput.peekFully(parsableByteArray2.data, 0, mpegAudioUtil$Header5.frameSize);
                i4 = mpegAudioUtil$Header5.version & 1;
                i5 = mpegAudioUtil$Header5.channels;
                i6 = 21;
                j = 1000000;
                if (i4 != 0) {
                    if (i5 != 1) {
                        i7 = 36;
                    }
                    j4 = 0;
                    j2 = -9223372036854775807L;
                    if (parsableByteArray2.limit >= i7 + 4) {
                        parsableByteArray2.setPosition(i7);
                        i8 = parsableByteArray2.readInt();
                        if (i8 != 1483304551) {
                            if (parsableByteArray2.limit >= 40) {
                                parsableByteArray2.setPosition(36);
                                if (parsableByteArray2.readInt() == 1447187017) {
                                    i8 = 1447187017;
                                } else {
                                    i8 = 0;
                                }
                            } else {
                                i8 = 0;
                            }
                        }
                    } else if (parsableByteArray2.limit >= 40) {
                        parsableByteArray2.setPosition(36);
                        if (parsableByteArray2.readInt() == 1447187017) {
                            i8 = 1447187017;
                        } else {
                            i8 = 0;
                        }
                    } else {
                        i8 = 0;
                    }
                    gaplessInfoHolder = this.gaplessInfoHolder;
                    if (i8 == 1231971951) {
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                        i10 = parsableByteArray2.readInt();
                        if ((i10 & 1) != 0) {
                            unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                        } else {
                            unsignedIntToInt = -1;
                        }
                        if ((i10 & 2) != 0) {
                            jMin = parsableByteArray2.readUnsignedInt();
                        } else {
                            jMin = -1;
                        }
                        if ((i10 & 4) == 4) {
                            jArr2 = new long[100];
                            i18 = 0;
                            while (i18 < i17) {
                                jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                i18++;
                            }
                            jArr = jArr2;
                        } else {
                            jArr = null;
                        }
                        if ((i10 & 8) != 0) {
                            parsableByteArray2.skipBytes(4);
                        }
                        if (parsableByteArray2.bytesLeft() >= 24) {
                            parsableByteArray2.skipBytes(11);
                            fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                            int unsignedShort12 = parsableByteArray2.readUnsignedShort();
                            int unsignedShort13 = parsableByteArray2.readUnsignedShort();
                            gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort12);
                            gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort13);
                            if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            } else {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            }
                            parsableByteArray2.skipBytes(2);
                            int unsignedInt28 = parsableByteArray2.readUnsignedInt24();
                            i12 = (16773120 & unsignedInt28) >> 12;
                            i11 = unsignedInt28 & 4095;
                        } else {
                            mp3InfoReplayGain = null;
                            i11 = -1;
                            i12 = -1;
                        }
                        j5 = unsignedIntToInt;
                        i13 = mpegAudioUtil$Header2.frameSize;
                        i14 = mpegAudioUtil$Header2.sampleRate;
                        i15 = mpegAudioUtil$Header2.bitrate;
                        i16 = mpegAudioUtil$Header2.samplesPerFrame;
                        mp3InfoReplayGain2 = mp3InfoReplayGain;
                        if (gaplessInfoHolder.encoderDelay != -1) {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        } else {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        }
                        if (mp3InfoReplayGain2 != null) {
                            metadata = new Metadata(mp3InfoReplayGain2);
                        } else {
                            metadata = null;
                        }
                        this.xingMetadata = metadata;
                        position2 = extractorInput.getPosition();
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                        if (i8 == 1483304551) {
                            length2 = extractorInput.getLength();
                            if (j5 != -1) {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            } else {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            }
                            if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                constantBitrateSeeker = null;
                            } else {
                                if (jMin != -1) {
                                    long j116 = length2 - position2;
                                    StringBuilder sbM8 = Fragment$5$$ExternalSyntheticOutline0.m(j116, "Data size mismatch between stream (", ") and Xing frame (");
                                    sbM8.append(jMin);
                                    sbM8.append("), using smaller value.");
                                    Log.i("XingSeeker", sbM8.toString());
                                    jMin = Math.min(jMin, j116);
                                }
                                constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                            }
                        } else {
                            length = extractorInput.getLength();
                            if (j5 != -1) {
                            }
                            if (jSampleCountToDurationUs != -9223372036854775807L) {
                                if (jMin != -1) {
                                    long j117 = position2 + jMin;
                                    j6 = jMin - ((long) i13);
                                    j7 = j117;
                                } else if (length != -1) {
                                    j6 = (length - position2) - ((long) i13);
                                    j7 = length;
                                } else {
                                    constantBitrateSeeker = null;
                                }
                                long j118 = j6;
                                RoundingMode roundingMode5 = RoundingMode.HALF_UP;
                                constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j118, 8000000L, jSampleCountToDurationUs, roundingMode5)), StringsKt__IndentKt.checkedCast(MathKt.divide(j118, j5, roundingMode5)), false, true);
                            } else {
                                constantBitrateSeeker = null;
                            }
                        }
                    } else if (i8 != 1447187017) {
                        length6 = extractorInput.getLength();
                        position4 = extractorInput.getPosition();
                        parsableByteArray2.skipBytes(6);
                        int i214 = parsableByteArray2.readInt();
                        i9 = 0;
                        j8 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                        j9 = j8 + ((long) i214);
                        i22 = parsableByteArray2.readInt();
                        if (i22 <= 0) {
                            jSampleCountToDurationUs3 = Util.sampleCountToDurationUs(mpegAudioUtil$Header5.sampleRate, (((long) i22) * ((long) mpegAudioUtil$Header5.samplesPerFrame)) - 1);
                            unsignedShort = parsableByteArray2.readUnsignedShort();
                            unsignedShort2 = parsableByteArray2.readUnsignedShort();
                            unsignedShort3 = parsableByteArray2.readUnsignedShort();
                            parsableByteArray2.skipBytes(2);
                            jArr5 = new long[unsignedShort];
                            jArr6 = new long[unsignedShort];
                            mpegAudioUtil$Header3 = mpegAudioUtil$Header5;
                            j10 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                            i23 = 0;
                            while (true) {
                                if (i23 < unsignedShort) {
                                    long[] jArr15 = jArr5;
                                    long[] jArr16 = jArr6;
                                    MpegAudioUtil$Header mpegAudioUtil$Header8 = mpegAudioUtil$Header3;
                                    if (length6 != -1) {
                                        j11 = j9;
                                    } else {
                                        j11 = j9;
                                    }
                                    if (j11 != j10) {
                                        StringBuilder sbM9 = Fragment$5$$ExternalSyntheticOutline0.m(j11, "VBRI bytes and ToC mismatch (using max): ", ", ");
                                        sbM9.append(j10);
                                        sbM9.append("\nSeeking will be inaccurate.");
                                        Log.w("VbriSeeker", sbM9.toString());
                                        jMax = Math.max(j11, j10);
                                    } else {
                                        jMax = j11;
                                    }
                                    mpegAudioUtil$Header2 = mpegAudioUtil$Header8;
                                    constantBitrateSeeker = new VbriSeeker(jArr15, jArr16, jSampleCountToDurationUs3, j8, jMax, mpegAudioUtil$Header2.bitrate);
                                    break;
                                }
                                long[] jArr17 = jArr6;
                                mpegAudioUtil$Header4 = mpegAudioUtil$Header3;
                                int i215 = i23;
                                long[] jArr18 = jArr5;
                                jArr18[i215] = (((long) i23) * jSampleCountToDurationUs3) / ((long) unsignedShort);
                                jArr17[i215] = j10;
                                if (unsignedShort3 != 1) {
                                    unsignedByte = parsableByteArray2.readUnsignedByte();
                                } else if (unsignedShort3 != 2) {
                                    unsignedByte = parsableByteArray2.readUnsignedShort();
                                } else if (unsignedShort3 != 3) {
                                    unsignedByte = parsableByteArray2.readUnsignedInt24();
                                } else {
                                    if (unsignedShort3 != 4) {
                                        constantBitrateSeeker = null;
                                        mpegAudioUtil$Header2 = mpegAudioUtil$Header4;
                                        break;
                                    }
                                    unsignedByte = parsableByteArray2.readUnsignedIntToInt();
                                }
                                j10 += ((long) unsignedByte) * ((long) unsignedShort2);
                                i23 = i215 + 1;
                                jArr6 = jArr17;
                                mpegAudioUtil$Header3 = mpegAudioUtil$Header4;
                                jArr5 = jArr18;
                            }
                        } else {
                            constantBitrateSeeker = null;
                            mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        }
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                    } else if (i8 != 1483304551) {
                        extractorInput.resetPeekPosition();
                        constantBitrateSeeker = null;
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                    } else {
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                        i9 = 0;
                        i10 = parsableByteArray2.readInt();
                        if ((i10 & 1) != 0) {
                            unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                        } else {
                            unsignedIntToInt = -1;
                        }
                        if ((i10 & 2) != 0) {
                            jMin = parsableByteArray2.readUnsignedInt();
                        } else {
                            jMin = -1;
                        }
                        if ((i10 & 4) == 4) {
                            jArr2 = new long[100];
                            i18 = 0;
                            while (i18 < i17) {
                                jArr2[i18] = parsableByteArray2.readUnsignedByte();
                                i18++;
                            }
                            jArr = jArr2;
                        } else {
                            jArr = null;
                        }
                        if ((i10 & 8) != 0) {
                            parsableByteArray2.skipBytes(4);
                        }
                        if (parsableByteArray2.bytesLeft() >= 24) {
                            parsableByteArray2.skipBytes(11);
                            fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                            int unsignedShort14 = parsableByteArray2.readUnsignedShort();
                            int unsignedShort15 = parsableByteArray2.readUnsignedShort();
                            gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort14);
                            gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort15);
                            if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            } else {
                                mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                            }
                            parsableByteArray2.skipBytes(2);
                            int unsignedInt29 = parsableByteArray2.readUnsignedInt24();
                            i12 = (16773120 & unsignedInt29) >> 12;
                            i11 = unsignedInt29 & 4095;
                        } else {
                            mp3InfoReplayGain = null;
                            i11 = -1;
                            i12 = -1;
                        }
                        j5 = unsignedIntToInt;
                        i13 = mpegAudioUtil$Header2.frameSize;
                        i14 = mpegAudioUtil$Header2.sampleRate;
                        i15 = mpegAudioUtil$Header2.bitrate;
                        i16 = mpegAudioUtil$Header2.samplesPerFrame;
                        mp3InfoReplayGain2 = mp3InfoReplayGain;
                        if (gaplessInfoHolder.encoderDelay != -1) {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        } else {
                            gaplessInfoHolder.encoderDelay = i12;
                            gaplessInfoHolder.encoderPadding = i11;
                        }
                        if (mp3InfoReplayGain2 != null) {
                            metadata = new Metadata(mp3InfoReplayGain2);
                        } else {
                            metadata = null;
                        }
                        this.xingMetadata = metadata;
                        position2 = extractorInput.getPosition();
                        extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                        if (i8 == 1483304551) {
                            length2 = extractorInput.getLength();
                            if (j5 != -1) {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            } else {
                                jSampleCountToDurationUs2 = -9223372036854775807L;
                            }
                            if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                                constantBitrateSeeker = null;
                            } else {
                                if (jMin != -1) {
                                    long j119 = length2 - position2;
                                    StringBuilder sbM10 = Fragment$5$$ExternalSyntheticOutline0.m(j119, "Data size mismatch between stream (", ") and Xing frame (");
                                    sbM10.append(jMin);
                                    sbM10.append("), using smaller value.");
                                    Log.i("XingSeeker", sbM10.toString());
                                    jMin = Math.min(jMin, j119);
                                }
                                constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                            }
                        } else {
                            length = extractorInput.getLength();
                            if (j5 != -1) {
                            }
                            if (jSampleCountToDurationUs != -9223372036854775807L) {
                                if (jMin != -1) {
                                    long j1110 = position2 + jMin;
                                    j6 = jMin - ((long) i13);
                                    j7 = j1110;
                                } else if (length != -1) {
                                    j6 = (length - position2) - ((long) i13);
                                    j7 = length;
                                } else {
                                    constantBitrateSeeker = null;
                                }
                                long j1111 = j6;
                                RoundingMode roundingMode6 = RoundingMode.HALF_UP;
                                constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j1111, 8000000L, jSampleCountToDurationUs, roundingMode6)), StringsKt__IndentKt.checkedCast(MathKt.divide(j1111, j5, roundingMode6)), false, true);
                            } else {
                                constantBitrateSeeker = null;
                            }
                        }
                    }
                    metadata2 = this.id3Metadata;
                    position3 = extractorInput.getPosition();
                    if (metadata2 == null) {
                        mlltSeeker = null;
                    } else {
                        entryArr = metadata2.entries;
                        length3 = entryArr.length;
                        i19 = i9;
                        while (true) {
                            if (i19 < length3) {
                                entry = null;
                                break;
                            }
                            entry4 = entryArr[i19];
                            if (MlltFrame.class.isAssignableFrom(entry4.getClass())) {
                                entry = (Metadata.Entry) MlltFrame.class.cast(entry4);
                                if (!Predicates$ObjectPredicate.ALWAYS_TRUE.apply(entry)) {
                                    entry = null;
                                }
                            } else {
                                entry = null;
                            }
                            if (entry != null) {
                                break;
                                break;
                            }
                            i19++;
                        }
                        mlltFrame = (MlltFrame) entry;
                        if (mlltFrame == null) {
                            mlltSeeker = null;
                        } else {
                            iArr = mlltFrame.bytesDeviations;
                            entryArr2 = metadata2.entries;
                            length4 = entryArr2.length;
                            i20 = 0;
                            while (true) {
                                if (i20 < length4) {
                                    entry2 = null;
                                    break;
                                }
                                entry3 = entryArr2[i20];
                                if (TextInformationFrame.class.isAssignableFrom(entry3.getClass())) {
                                    entry2 = (Metadata.Entry) TextInformationFrame.class.cast(entry3);
                                    if (!((TextInformationFrame) entry2).id.equals("TLEN")) {
                                        entry2 = null;
                                    }
                                } else {
                                    entry2 = null;
                                }
                                if (entry2 != null) {
                                    break;
                                    break;
                                }
                                i20++;
                            }
                            textInformationFrame = (TextInformationFrame) entry2;
                            if (textInformationFrame == null) {
                                jMsToUs = -9223372036854775807L;
                                c = 0;
                            } else {
                                c = 0;
                                jMsToUs = Util.msToUs(Long.parseLong((String) textInformationFrame.values.get(0)));
                            }
                            length5 = iArr.length;
                            int i216 = length5 + 1;
                            jArr3 = new long[i216];
                            jArr4 = new long[i216];
                            jArr3[c] = position3;
                            jArr4[c] = 0;
                            i21 = 1;
                            while (i21 <= length5) {
                                int i217 = i21 - 1;
                                long j1112 = position3 + ((long) (mlltFrame.bytesBetweenReference + iArr[i217]));
                                j4 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i217]);
                                jArr3[i21] = j1112;
                                jArr4[i21] = j4;
                                i21++;
                                length5 = length5;
                                position3 = j1112;
                            }
                            mlltSeeker = new MlltSeeker(jMsToUs, jArr3, jArr4);
                        }
                    }
                    if (this.disableSeeking) {
                        unseekableSeeker = new Seeker.UnseekableSeeker(-9223372036854775807L);
                        parsableByteArray = parsableByteArray;
                        gaplessInfoHolder = gaplessInfoHolder;
                        mpegAudioUtil$Header = mpegAudioUtil$Header2;
                        z3 = true;
                        i25 = 0;
                    } else {
                        j2 = -9223372036854775807L;
                        if (mlltSeeker != null) {
                            constantBitrateSeeker = mlltSeeker;
                        } else if (constantBitrateSeeker == null) {
                            constantBitrateSeeker = null;
                        }
                        if (constantBitrateSeeker == null) {
                            int i32 = i9;
                            extractorInput.peekFully(parsableByteArray.data, i32, 4);
                            parsableByteArray.setPosition(i32);
                            mpegAudioUtil$Header2.setForHeaderData(parsableByteArray.readInt());
                            mpegAudioUtil$Header = mpegAudioUtil$Header2;
                            z2 = true;
                            i25 = 0;
                            constantBitrateSeeker = new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), mpegAudioUtil$Header2.bitrate, mpegAudioUtil$Header2.frameSize, false, true);
                        } else {
                            mpegAudioUtil$Header = mpegAudioUtil$Header2;
                            z2 = true;
                            i25 = 0;
                        }
                        constantBitrateSeeker.isSeekable();
                        constantBitrateSeeker.isSeekable();
                        this.realTrackOutput.durationUs(constantBitrateSeeker.getDurationUs());
                        unseekableSeeker = constantBitrateSeeker;
                        z3 = z2;
                    }
                    this.seeker = unseekableSeeker;
                    this.extractorOutput.seekMap(unseekableSeeker);
                    metadataCopyWithAppendedEntriesFrom = this.id3Metadata;
                    metadata3 = this.xingMetadata;
                    if (metadataCopyWithAppendedEntriesFrom != null) {
                        if (metadata3 != null) {
                            metadataCopyWithAppendedEntriesFrom = metadataCopyWithAppendedEntriesFrom.copyWithAppendedEntriesFrom(metadata3);
                        }
                        metadata3 = metadataCopyWithAppendedEntriesFrom;
                    }
                    builder = new Format.Builder();
                    builder.containerMimeType = MimeTypes.normalizeMimeType("audio/mpeg");
                    builder.sampleMimeType = MimeTypes.normalizeMimeType(mpegAudioUtil$Header.mimeType);
                    builder.maxInputSize = 4096;
                    builder.channelCount = mpegAudioUtil$Header.channels;
                    builder.sampleRate = mpegAudioUtil$Header.sampleRate;
                    builder.encoderDelay = gaplessInfoHolder.encoderDelay;
                    builder.encoderPadding = gaplessInfoHolder.encoderPadding;
                    builder.metadata = metadata3;
                    if (this.seeker.getAverageBitrate() != -2147483647) {
                        builder.averageBitrate = this.seeker.getAverageBitrate();
                    }
                    this.currentTrackOutput.format(new Format(builder));
                    this.firstSamplePosition = extractorInput.getPosition();
                    r4 = z3;
                } else if (i5 == 1) {
                    i6 = 13;
                }
                i7 = i6;
                j4 = 0;
                j2 = -9223372036854775807L;
                if (parsableByteArray2.limit >= i7 + 4) {
                    parsableByteArray2.setPosition(i7);
                    i8 = parsableByteArray2.readInt();
                    if (i8 != 1483304551) {
                        if (parsableByteArray2.limit >= 40) {
                            parsableByteArray2.setPosition(36);
                            if (parsableByteArray2.readInt() == 1447187017) {
                                i8 = 1447187017;
                            } else {
                                i8 = 0;
                            }
                        } else {
                            i8 = 0;
                        }
                    }
                } else if (parsableByteArray2.limit >= 40) {
                    parsableByteArray2.setPosition(36);
                    if (parsableByteArray2.readInt() == 1447187017) {
                        i8 = 1447187017;
                    } else {
                        i8 = 0;
                    }
                } else {
                    i8 = 0;
                }
                gaplessInfoHolder = this.gaplessInfoHolder;
                if (i8 == 1231971951) {
                    mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                    i9 = 0;
                    i10 = parsableByteArray2.readInt();
                    if ((i10 & 1) != 0) {
                        unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                    } else {
                        unsignedIntToInt = -1;
                    }
                    if ((i10 & 2) != 0) {
                        jMin = parsableByteArray2.readUnsignedInt();
                    } else {
                        jMin = -1;
                    }
                    if ((i10 & 4) == 4) {
                        jArr2 = new long[100];
                        i18 = 0;
                        while (i18 < i17) {
                            jArr2[i18] = parsableByteArray2.readUnsignedByte();
                            i18++;
                        }
                        jArr = jArr2;
                    } else {
                        jArr = null;
                    }
                    if ((i10 & 8) != 0) {
                        parsableByteArray2.skipBytes(4);
                    }
                    if (parsableByteArray2.bytesLeft() >= 24) {
                        parsableByteArray2.skipBytes(11);
                        fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                        int unsignedShort16 = parsableByteArray2.readUnsignedShort();
                        int unsignedShort17 = parsableByteArray2.readUnsignedShort();
                        gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort16);
                        gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort17);
                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                            mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                        } else {
                            mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                        }
                        parsableByteArray2.skipBytes(2);
                        int unsignedInt210 = parsableByteArray2.readUnsignedInt24();
                        i12 = (16773120 & unsignedInt210) >> 12;
                        i11 = unsignedInt210 & 4095;
                    } else {
                        mp3InfoReplayGain = null;
                        i11 = -1;
                        i12 = -1;
                    }
                    j5 = unsignedIntToInt;
                    i13 = mpegAudioUtil$Header2.frameSize;
                    i14 = mpegAudioUtil$Header2.sampleRate;
                    i15 = mpegAudioUtil$Header2.bitrate;
                    i16 = mpegAudioUtil$Header2.samplesPerFrame;
                    mp3InfoReplayGain2 = mp3InfoReplayGain;
                    if (gaplessInfoHolder.encoderDelay != -1) {
                        gaplessInfoHolder.encoderDelay = i12;
                        gaplessInfoHolder.encoderPadding = i11;
                    } else {
                        gaplessInfoHolder.encoderDelay = i12;
                        gaplessInfoHolder.encoderPadding = i11;
                    }
                    if (mp3InfoReplayGain2 != null) {
                        metadata = new Metadata(mp3InfoReplayGain2);
                    } else {
                        metadata = null;
                    }
                    this.xingMetadata = metadata;
                    position2 = extractorInput.getPosition();
                    extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                    if (i8 == 1483304551) {
                        length2 = extractorInput.getLength();
                        if (j5 != -1) {
                            jSampleCountToDurationUs2 = -9223372036854775807L;
                        } else {
                            jSampleCountToDurationUs2 = -9223372036854775807L;
                        }
                        if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                            constantBitrateSeeker = null;
                        } else {
                            if (jMin != -1) {
                                long j1113 = length2 - position2;
                                StringBuilder sbM11 = Fragment$5$$ExternalSyntheticOutline0.m(j1113, "Data size mismatch between stream (", ") and Xing frame (");
                                sbM11.append(jMin);
                                sbM11.append("), using smaller value.");
                                Log.i("XingSeeker", sbM11.toString());
                                jMin = Math.min(jMin, j1113);
                            }
                            constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                        }
                    } else {
                        length = extractorInput.getLength();
                        if (j5 != -1) {
                        }
                        if (jSampleCountToDurationUs != -9223372036854775807L) {
                            if (jMin != -1) {
                                long j1114 = position2 + jMin;
                                j6 = jMin - ((long) i13);
                                j7 = j1114;
                            } else if (length != -1) {
                                j6 = (length - position2) - ((long) i13);
                                j7 = length;
                            } else {
                                constantBitrateSeeker = null;
                            }
                            long j1115 = j6;
                            RoundingMode roundingMode7 = RoundingMode.HALF_UP;
                            constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j1115, 8000000L, jSampleCountToDurationUs, roundingMode7)), StringsKt__IndentKt.checkedCast(MathKt.divide(j1115, j5, roundingMode7)), false, true);
                        } else {
                            constantBitrateSeeker = null;
                        }
                    }
                } else if (i8 != 1447187017) {
                    length6 = extractorInput.getLength();
                    position4 = extractorInput.getPosition();
                    parsableByteArray2.skipBytes(6);
                    int i218 = parsableByteArray2.readInt();
                    i9 = 0;
                    j8 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                    j9 = j8 + ((long) i218);
                    i22 = parsableByteArray2.readInt();
                    if (i22 <= 0) {
                        jSampleCountToDurationUs3 = Util.sampleCountToDurationUs(mpegAudioUtil$Header5.sampleRate, (((long) i22) * ((long) mpegAudioUtil$Header5.samplesPerFrame)) - 1);
                        unsignedShort = parsableByteArray2.readUnsignedShort();
                        unsignedShort2 = parsableByteArray2.readUnsignedShort();
                        unsignedShort3 = parsableByteArray2.readUnsignedShort();
                        parsableByteArray2.skipBytes(2);
                        jArr5 = new long[unsignedShort];
                        jArr6 = new long[unsignedShort];
                        mpegAudioUtil$Header3 = mpegAudioUtil$Header5;
                        j10 = position4 + ((long) mpegAudioUtil$Header5.frameSize);
                        i23 = 0;
                        while (true) {
                            if (i23 < unsignedShort) {
                                long[] jArr19 = jArr5;
                                long[] jArr110 = jArr6;
                                MpegAudioUtil$Header mpegAudioUtil$Header9 = mpegAudioUtil$Header3;
                                if (length6 != -1) {
                                    j11 = j9;
                                } else {
                                    j11 = j9;
                                }
                                if (j11 != j10) {
                                    StringBuilder sbM12 = Fragment$5$$ExternalSyntheticOutline0.m(j11, "VBRI bytes and ToC mismatch (using max): ", ", ");
                                    sbM12.append(j10);
                                    sbM12.append("\nSeeking will be inaccurate.");
                                    Log.w("VbriSeeker", sbM12.toString());
                                    jMax = Math.max(j11, j10);
                                } else {
                                    jMax = j11;
                                }
                                mpegAudioUtil$Header2 = mpegAudioUtil$Header9;
                                constantBitrateSeeker = new VbriSeeker(jArr19, jArr110, jSampleCountToDurationUs3, j8, jMax, mpegAudioUtil$Header2.bitrate);
                                break;
                            }
                            long[] jArr111 = jArr6;
                            mpegAudioUtil$Header4 = mpegAudioUtil$Header3;
                            int i219 = i23;
                            long[] jArr112 = jArr5;
                            jArr112[i219] = (((long) i23) * jSampleCountToDurationUs3) / ((long) unsignedShort);
                            jArr111[i219] = j10;
                            if (unsignedShort3 != 1) {
                                unsignedByte = parsableByteArray2.readUnsignedByte();
                            } else if (unsignedShort3 != 2) {
                                unsignedByte = parsableByteArray2.readUnsignedShort();
                            } else if (unsignedShort3 != 3) {
                                unsignedByte = parsableByteArray2.readUnsignedInt24();
                            } else {
                                if (unsignedShort3 != 4) {
                                    constantBitrateSeeker = null;
                                    mpegAudioUtil$Header2 = mpegAudioUtil$Header4;
                                    break;
                                }
                                unsignedByte = parsableByteArray2.readUnsignedIntToInt();
                            }
                            j10 += ((long) unsignedByte) * ((long) unsignedShort2);
                            i23 = i219 + 1;
                            jArr6 = jArr111;
                            mpegAudioUtil$Header3 = mpegAudioUtil$Header4;
                            jArr5 = jArr112;
                        }
                    } else {
                        constantBitrateSeeker = null;
                        mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                    }
                    extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                } else if (i8 != 1483304551) {
                    extractorInput.resetPeekPosition();
                    constantBitrateSeeker = null;
                    mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                    i9 = 0;
                } else {
                    mpegAudioUtil$Header2 = mpegAudioUtil$Header5;
                    i9 = 0;
                    i10 = parsableByteArray2.readInt();
                    if ((i10 & 1) != 0) {
                        unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                    } else {
                        unsignedIntToInt = -1;
                    }
                    if ((i10 & 2) != 0) {
                        jMin = parsableByteArray2.readUnsignedInt();
                    } else {
                        jMin = -1;
                    }
                    if ((i10 & 4) == 4) {
                        jArr2 = new long[100];
                        i18 = 0;
                        while (i18 < i17) {
                            jArr2[i18] = parsableByteArray2.readUnsignedByte();
                            i18++;
                        }
                        jArr = jArr2;
                    } else {
                        jArr = null;
                    }
                    if ((i10 & 8) != 0) {
                        parsableByteArray2.skipBytes(4);
                    }
                    if (parsableByteArray2.bytesLeft() >= 24) {
                        parsableByteArray2.skipBytes(11);
                        fIntBitsToFloat = Float.intBitsToFloat(parsableByteArray2.readInt());
                        int unsignedShort18 = parsableByteArray2.readUnsignedShort();
                        int unsignedShort19 = parsableByteArray2.readUnsignedShort();
                        gainField = Mp3InfoReplayGain.GainField.parse(unsignedShort18);
                        gainField2 = Mp3InfoReplayGain.GainField.parse(unsignedShort19);
                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                            mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                        } else {
                            mp3InfoReplayGain = new Mp3InfoReplayGain(fIntBitsToFloat, gainField, gainField2);
                        }
                        parsableByteArray2.skipBytes(2);
                        int unsignedInt211 = parsableByteArray2.readUnsignedInt24();
                        i12 = (16773120 & unsignedInt211) >> 12;
                        i11 = unsignedInt211 & 4095;
                    } else {
                        mp3InfoReplayGain = null;
                        i11 = -1;
                        i12 = -1;
                    }
                    j5 = unsignedIntToInt;
                    i13 = mpegAudioUtil$Header2.frameSize;
                    i14 = mpegAudioUtil$Header2.sampleRate;
                    i15 = mpegAudioUtil$Header2.bitrate;
                    i16 = mpegAudioUtil$Header2.samplesPerFrame;
                    mp3InfoReplayGain2 = mp3InfoReplayGain;
                    if (gaplessInfoHolder.encoderDelay != -1) {
                        gaplessInfoHolder.encoderDelay = i12;
                        gaplessInfoHolder.encoderPadding = i11;
                    } else {
                        gaplessInfoHolder.encoderDelay = i12;
                        gaplessInfoHolder.encoderPadding = i11;
                    }
                    if (mp3InfoReplayGain2 != null) {
                        metadata = new Metadata(mp3InfoReplayGain2);
                    } else {
                        metadata = null;
                    }
                    this.xingMetadata = metadata;
                    position2 = extractorInput.getPosition();
                    extractorInput.skipFully(mpegAudioUtil$Header2.frameSize);
                    if (i8 == 1483304551) {
                        length2 = extractorInput.getLength();
                        if (j5 != -1) {
                            jSampleCountToDurationUs2 = -9223372036854775807L;
                        } else {
                            jSampleCountToDurationUs2 = -9223372036854775807L;
                        }
                        if (jSampleCountToDurationUs2 == -9223372036854775807L) {
                            constantBitrateSeeker = null;
                        } else {
                            if (jMin != -1) {
                                long j1116 = length2 - position2;
                                StringBuilder sbM13 = Fragment$5$$ExternalSyntheticOutline0.m(j1116, "Data size mismatch between stream (", ") and Xing frame (");
                                sbM13.append(jMin);
                                sbM13.append("), using smaller value.");
                                Log.i("XingSeeker", sbM13.toString());
                                jMin = Math.min(jMin, j1116);
                            }
                            constantBitrateSeeker = new XingSeeker(position2, i13, jSampleCountToDurationUs2, i15, jMin, jArr);
                        }
                    } else {
                        length = extractorInput.getLength();
                        if (j5 != -1) {
                        }
                        if (jSampleCountToDurationUs != -9223372036854775807L) {
                            if (jMin != -1) {
                                long j1117 = position2 + jMin;
                                j6 = jMin - ((long) i13);
                                j7 = j1117;
                            } else if (length != -1) {
                                j6 = (length - position2) - ((long) i13);
                                j7 = length;
                            } else {
                                constantBitrateSeeker = null;
                            }
                            long j1118 = j6;
                            RoundingMode roundingMode8 = RoundingMode.HALF_UP;
                            constantBitrateSeeker = new ConstantBitrateSeeker(j7, position2 + ((long) i13), StringsKt__IndentKt.checkedCast(Util.scaleLargeValue(j1118, 8000000L, jSampleCountToDurationUs, roundingMode8)), StringsKt__IndentKt.checkedCast(MathKt.divide(j1118, j5, roundingMode8)), false, true);
                        } else {
                            constantBitrateSeeker = null;
                        }
                    }
                }
                metadata2 = this.id3Metadata;
                position3 = extractorInput.getPosition();
                if (metadata2 == null) {
                    mlltSeeker = null;
                } else {
                    entryArr = metadata2.entries;
                    length3 = entryArr.length;
                    i19 = i9;
                    while (true) {
                        if (i19 < length3) {
                            entry = null;
                            break;
                        }
                        entry4 = entryArr[i19];
                        if (MlltFrame.class.isAssignableFrom(entry4.getClass())) {
                            entry = (Metadata.Entry) MlltFrame.class.cast(entry4);
                            if (!Predicates$ObjectPredicate.ALWAYS_TRUE.apply(entry)) {
                                entry = null;
                            }
                        } else {
                            entry = null;
                        }
                        if (entry != null) {
                            break;
                            break;
                        }
                        i19++;
                    }
                    mlltFrame = (MlltFrame) entry;
                    if (mlltFrame == null) {
                        mlltSeeker = null;
                    } else {
                        iArr = mlltFrame.bytesDeviations;
                        entryArr2 = metadata2.entries;
                        length4 = entryArr2.length;
                        i20 = 0;
                        while (true) {
                            if (i20 < length4) {
                                entry2 = null;
                                break;
                            }
                            entry3 = entryArr2[i20];
                            if (TextInformationFrame.class.isAssignableFrom(entry3.getClass())) {
                                entry2 = (Metadata.Entry) TextInformationFrame.class.cast(entry3);
                                if (!((TextInformationFrame) entry2).id.equals("TLEN")) {
                                    entry2 = null;
                                }
                            } else {
                                entry2 = null;
                            }
                            if (entry2 != null) {
                                break;
                                break;
                            }
                            i20++;
                        }
                        textInformationFrame = (TextInformationFrame) entry2;
                        if (textInformationFrame == null) {
                            jMsToUs = -9223372036854775807L;
                            c = 0;
                        } else {
                            c = 0;
                            jMsToUs = Util.msToUs(Long.parseLong((String) textInformationFrame.values.get(0)));
                        }
                        length5 = iArr.length;
                        int i2110 = length5 + 1;
                        jArr3 = new long[i2110];
                        jArr4 = new long[i2110];
                        jArr3[c] = position3;
                        jArr4[c] = 0;
                        i21 = 1;
                        while (i21 <= length5) {
                            int i2111 = i21 - 1;
                            long j1119 = position3 + ((long) (mlltFrame.bytesBetweenReference + iArr[i2111]));
                            j4 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i2111]);
                            jArr3[i21] = j1119;
                            jArr4[i21] = j4;
                            i21++;
                            length5 = length5;
                            position3 = j1119;
                        }
                        mlltSeeker = new MlltSeeker(jMsToUs, jArr3, jArr4);
                    }
                }
                if (this.disableSeeking) {
                    unseekableSeeker = new Seeker.UnseekableSeeker(-9223372036854775807L);
                    parsableByteArray = parsableByteArray;
                    gaplessInfoHolder = gaplessInfoHolder;
                    mpegAudioUtil$Header = mpegAudioUtil$Header2;
                    z3 = true;
                    i25 = 0;
                } else {
                    j2 = -9223372036854775807L;
                    if (mlltSeeker != null) {
                        constantBitrateSeeker = mlltSeeker;
                    } else if (constantBitrateSeeker == null) {
                        constantBitrateSeeker = null;
                    }
                    if (constantBitrateSeeker == null) {
                        int i33 = i9;
                        extractorInput.peekFully(parsableByteArray.data, i33, 4);
                        parsableByteArray.setPosition(i33);
                        mpegAudioUtil$Header2.setForHeaderData(parsableByteArray.readInt());
                        mpegAudioUtil$Header = mpegAudioUtil$Header2;
                        z2 = true;
                        i25 = 0;
                        constantBitrateSeeker = new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), mpegAudioUtil$Header2.bitrate, mpegAudioUtil$Header2.frameSize, false, true);
                    } else {
                        mpegAudioUtil$Header = mpegAudioUtil$Header2;
                        z2 = true;
                        i25 = 0;
                    }
                    constantBitrateSeeker.isSeekable();
                    constantBitrateSeeker.isSeekable();
                    this.realTrackOutput.durationUs(constantBitrateSeeker.getDurationUs());
                    unseekableSeeker = constantBitrateSeeker;
                    z3 = z2;
                }
                this.seeker = unseekableSeeker;
                this.extractorOutput.seekMap(unseekableSeeker);
                metadataCopyWithAppendedEntriesFrom = this.id3Metadata;
                metadata3 = this.xingMetadata;
                if (metadataCopyWithAppendedEntriesFrom != null) {
                    if (metadata3 != null) {
                        metadataCopyWithAppendedEntriesFrom = metadataCopyWithAppendedEntriesFrom.copyWithAppendedEntriesFrom(metadata3);
                    }
                    metadata3 = metadataCopyWithAppendedEntriesFrom;
                }
                builder = new Format.Builder();
                builder.containerMimeType = MimeTypes.normalizeMimeType("audio/mpeg");
                builder.sampleMimeType = MimeTypes.normalizeMimeType(mpegAudioUtil$Header.mimeType);
                builder.maxInputSize = 4096;
                builder.channelCount = mpegAudioUtil$Header.channels;
                builder.sampleRate = mpegAudioUtil$Header.sampleRate;
                builder.encoderDelay = gaplessInfoHolder.encoderDelay;
                builder.encoderPadding = gaplessInfoHolder.encoderPadding;
                builder.metadata = metadata3;
                if (this.seeker.getAverageBitrate() != -2147483647) {
                    builder.averageBitrate = this.seeker.getAverageBitrate();
                }
                this.currentTrackOutput.format(new Format(builder));
                this.firstSamplePosition = extractorInput.getPosition();
                r4 = z3;
            } else {
                mpegAudioUtil$Header = mpegAudioUtil$Header5;
                parsableByteArray = parsableByteArray;
                z = true;
                th = null;
                j = 1000000;
                j2 = -9223372036854775807L;
                if (this.firstSamplePosition != 0) {
                    position = extractorInput.getPosition();
                    j3 = this.firstSamplePosition;
                    if (position < j3) {
                        r4 = z;
                        r4 = z;
                        extractorInput.skipFully((int) (j3 - position));
                        r4 = z;
                    }
                }
            }
            r4 = z;
            r4 = z;
            r4 = z;
            if (this.sampleBytesRemaining == 0) {
                extractorInput.resetPeekPosition();
                if (peekEndOfStreamOrHeader(extractorInput)) {
                    i = -1;
                    i25 = -1;
                } else {
                    parsableByteArray.setPosition(i25);
                    i3 = parsableByteArray.readInt();
                    if (((-128000) & i3) == (((long) this.synchronizedHeaderData) & (-128000))) {
                    }
                    extractorInput.skipFully(r4);
                    this.synchronizedHeaderData = i25;
                    i = -1;
                }
            } else {
                iSampleData = this.currentTrackOutput.sampleData(extractorInput, this.sampleBytesRemaining, (boolean) r4);
                if (iSampleData == -1) {
                    i = -1;
                    i25 = -1;
                } else {
                    i2 = this.sampleBytesRemaining - iSampleData;
                    this.sampleBytesRemaining = i2;
                    if (i2 <= 0) {
                        this.currentTrackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * j) / ((long) mpegAudioUtil$Header.sampleRate)), 1, mpegAudioUtil$Header.frameSize, 0, null);
                        this.samplesRead += (long) mpegAudioUtil$Header.samplesPerFrame;
                        this.sampleBytesRemaining = i25;
                    }
                    i = -1;
                }
            }
        }
        if (i25 == i) {
            Seeker seeker2 = this.seeker;
            if (seeker2 instanceof IndexSeeker) {
                if (seeker2.getDurationUs() != ((this.samplesRead * j) / ((long) mpegAudioUtil$Header.sampleRate)) + this.basisTimeUs) {
                    ((IndexSeeker) this.seeker).getClass();
                    throw th;
                }
            }
        }
        return i25;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
        this.endPositionOfLastSampleRead = -1L;
        this.seekTimeUs = j2;
        if (this.seeker instanceof IndexSeeker) {
            throw null;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return synchronize(extractorInput, true);
    }

    public final boolean synchronize(ExtractorInput extractorInput, boolean z) throws EOFException {
        int peekPosition;
        int i;
        int frameSize;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataPeekId3Data = this.id3Peeker.peekId3Data(extractorInput, null, 131072);
            this.id3Metadata = metadataPeekId3Data;
            if (metadataPeekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(metadataPeekId3Data);
            }
            peekPosition = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(peekPosition);
            }
            i = 0;
        } else {
            peekPosition = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (peekEndOfStreamOrHeader(extractorInput)) {
                if (i2 > 0) {
                    break;
                }
                maybeUpdateCbrDurationToLastSample();
                throw new EOFException();
            }
            ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.setPosition(0);
            int i4 = parsableByteArray.readInt();
            if ((i == 0 || ((-128000) & i4) == (((long) i) & (-128000))) && (frameSize = AacUtil.getFrameSize(i4)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    this.synchronizedHeader.setForHeaderData(i4);
                    i = i4;
                }
                extractorInput.advancePeekPosition(frameSize - 4);
            } else {
                int i5 = i3 + 1;
                if (i3 == 131072) {
                    if (z) {
                        return false;
                    }
                    maybeUpdateCbrDurationToLastSample();
                    throw new EOFException();
                }
                if (z) {
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(peekPosition + i5);
                } else {
                    extractorInput.skipFully(1);
                }
                i2 = 0;
                i3 = i5;
                i = 0;
            }
        }
        if (z) {
            extractorInput.skipFully(peekPosition + i3);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i;
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
