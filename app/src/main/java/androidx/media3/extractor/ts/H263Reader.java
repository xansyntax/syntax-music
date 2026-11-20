package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import java.util.Arrays;
import java.util.Collections;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class H263Reader implements ElementaryStreamReader {
    public static final float[] PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    public final CsdBuffer csdBuffer;
    public String formatId;
    public boolean hasOutputFormat;
    public TrackOutput output;
    public long pesTimeUs;
    public final boolean[] prefixFlags = new boolean[4];
    public SampleReader sampleReader;
    public long totalBytesWritten;
    public final NalUnitTargetBuffer userData;
    public final ParsableByteArray userDataParsable;
    public final SeiReader userDataReader;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CsdBuffer {
        public static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        public boolean isFilling;
        public int length;
        public byte state;
        public int volStartPosition;

        public final void onData(byte[] bArr, int i, int i2) {
            if (this.isFilling) {
                int i3 = i2 - i;
                byte[] bArrCopyOf = this.data;
                int length = bArrCopyOf.length;
                int i4 = this.length + i3;
                if (length < i4) {
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, i4 * 2);
                    this.data = bArrCopyOf;
                }
                System.arraycopy(bArr, i, bArrCopyOf, this.length, i3);
                this.length += i3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SampleReader {
        public boolean lookingForVopCodingType;
        public final TrackOutput output;
        public boolean readingSample;
        public boolean sampleIsKeyframe;
        public long samplePosition;
        public long sampleTimeUs;
        public int startCodeValue;
        public int vopBytesRead;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        public final void onData(byte[] bArr, int i, int i2) {
            if (this.lookingForVopCodingType) {
                int i3 = this.vopBytesRead;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.vopBytesRead = (i2 - i) + i3;
                } else {
                    this.sampleIsKeyframe = ((bArr[i4] & 192) >> 6) == 0;
                    this.lookingForVopCodingType = false;
                }
            }
        }

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
        public final void onDataEnd(int i, long j, boolean z) {
            UtilsKt.checkState(this.sampleTimeUs != -9223372036854775807L);
            if (this.startCodeValue == 182 && z && this.readingSample) {
                this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, (int) (j - this.samplePosition), i, null);
            }
            if (this.startCodeValue != 179) {
                this.samplePosition = j;
            }
        }
    }

    public H263Reader(SeiReader seiReader) {
        this.userDataReader = seiReader;
        CsdBuffer csdBuffer = new CsdBuffer();
        csdBuffer.data = new byte[128];
        this.csdBuffer = csdBuffer;
        this.pesTimeUs = -9223372036854775807L;
        this.userData = new NalUnitTargetBuffer(178);
        this.userDataParsable = new ParsableByteArray();
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0232  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        float f;
        this.sampleReader.getClass();
        this.output.getClass();
        int i5 = parsableByteArray.position;
        int i6 = parsableByteArray.limit;
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray.bytesLeft(), parsableByteArray);
        while (true) {
            int iFindNalUnit = OpusUtil.findNalUnit(bArr, i5, i6, this.prefixFlags);
            CsdBuffer csdBuffer = this.csdBuffer;
            NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
            if (iFindNalUnit == i6) {
                if (!this.hasOutputFormat) {
                    csdBuffer.onData(bArr, i5, i6);
                }
                this.sampleReader.onData(bArr, i5, i6);
                if (nalUnitTargetBuffer != null) {
                    nalUnitTargetBuffer.appendToNalUnit(bArr, i5, i6);
                    return;
                }
                return;
            }
            int i7 = iFindNalUnit + 3;
            byte b = parsableByteArray.data[i7];
            int i8 = b & 255;
            int i9 = iFindNalUnit - i5;
            if (this.hasOutputFormat) {
                i = i6;
                i2 = i7;
            } else {
                if (i9 > 0) {
                    csdBuffer.onData(bArr, i5, iFindNalUnit);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                byte b2 = csdBuffer.state;
                if (b2 != 0) {
                    i = i6;
                    if (b2 == 1) {
                        i2 = i7;
                        i4 = 0;
                        if (i8 != 181) {
                            Log.w("H263Reader", "Unexpected start code value");
                            csdBuffer.isFilling = false;
                            csdBuffer.length = 0;
                            csdBuffer.state = (byte) 0;
                        } else {
                            csdBuffer.state = (byte) 2;
                        }
                    } else if (b2 != 2) {
                        i2 = i7;
                        if (b2 != 3) {
                            if (b2 != 4) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return;
                            }
                            if (i8 == 179 || i8 == 181) {
                                csdBuffer.length -= i10;
                                csdBuffer.isFilling = false;
                                TrackOutput trackOutput = this.output;
                                int i11 = csdBuffer.volStartPosition;
                                String str = this.formatId;
                                str.getClass();
                                byte[] bArrCopyOf = Arrays.copyOf(csdBuffer.data, csdBuffer.length);
                                VorbisBitArray vorbisBitArray = new VorbisBitArray(bArrCopyOf, bArrCopyOf.length);
                                vorbisBitArray.skipBytes(i11);
                                vorbisBitArray.skipBytes(4);
                                vorbisBitArray.skipBit();
                                vorbisBitArray.skipBits(8);
                                if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(4);
                                    vorbisBitArray.skipBits(3);
                                }
                                int bits = vorbisBitArray.readBits(4);
                                if (bits == 15) {
                                    int bits2 = vorbisBitArray.readBits(8);
                                    int bits3 = vorbisBitArray.readBits(8);
                                    if (bits3 == 0) {
                                        Log.w("H263Reader", "Invalid aspect ratio");
                                        f = 1.0f;
                                    } else {
                                        f = bits2 / bits3;
                                    }
                                } else if (bits < 7) {
                                    f = PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO[bits];
                                } else {
                                    Log.w("H263Reader", "Invalid aspect ratio");
                                    f = 1.0f;
                                }
                                if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(2);
                                    vorbisBitArray.skipBits(1);
                                    if (vorbisBitArray.readBit()) {
                                        vorbisBitArray.skipBits(15);
                                        vorbisBitArray.skipBit();
                                        vorbisBitArray.skipBits(15);
                                        vorbisBitArray.skipBit();
                                        vorbisBitArray.skipBits(15);
                                        vorbisBitArray.skipBit();
                                        vorbisBitArray.skipBits(3);
                                        vorbisBitArray.skipBits(11);
                                        vorbisBitArray.skipBit();
                                        vorbisBitArray.skipBits(15);
                                        vorbisBitArray.skipBit();
                                    }
                                }
                                if (vorbisBitArray.readBits(2) != 0) {
                                    Log.w("H263Reader", "Unhandled video object layer shape");
                                }
                                vorbisBitArray.skipBit();
                                int bits4 = vorbisBitArray.readBits(16);
                                vorbisBitArray.skipBit();
                                if (vorbisBitArray.readBit()) {
                                    if (bits4 == 0) {
                                        Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                    } else {
                                        int i12 = 0;
                                        for (int i13 = bits4 - 1; i13 > 0; i13 >>= 1) {
                                            i12++;
                                        }
                                        vorbisBitArray.skipBits(i12);
                                    }
                                }
                                vorbisBitArray.skipBit();
                                int bits5 = vorbisBitArray.readBits(13);
                                vorbisBitArray.skipBit();
                                int bits6 = vorbisBitArray.readBits(13);
                                vorbisBitArray.skipBit();
                                vorbisBitArray.skipBit();
                                Format.Builder builder = new Format.Builder();
                                builder.id = str;
                                builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                builder.sampleMimeType = MimeTypes.normalizeMimeType("video/mp4v-es");
                                builder.width = bits5;
                                builder.height = bits6;
                                builder.pixelWidthHeightRatio = f;
                                builder.initializationData = Collections.singletonList(bArrCopyOf);
                                Format$$ExternalSyntheticOutline0.m(builder, trackOutput);
                                this.hasOutputFormat = true;
                            } else {
                                i4 = 0;
                            }
                        } else if ((b & 240) != 32) {
                            Log.w("H263Reader", "Unexpected start code value");
                            i4 = 0;
                            csdBuffer.isFilling = false;
                            csdBuffer.length = 0;
                            csdBuffer.state = (byte) 0;
                        } else {
                            i4 = 0;
                            csdBuffer.volStartPosition = csdBuffer.length;
                            csdBuffer.state = (byte) 4;
                        }
                    } else {
                        i2 = i7;
                        i4 = 0;
                        if (i8 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            csdBuffer.isFilling = false;
                            csdBuffer.length = 0;
                            csdBuffer.state = (byte) 0;
                        } else {
                            csdBuffer.state = (byte) 3;
                        }
                    }
                } else {
                    i = i6;
                    i2 = i7;
                    i4 = 0;
                    if (i8 == 176) {
                        csdBuffer.state = (byte) 1;
                        csdBuffer.isFilling = true;
                    }
                }
                csdBuffer.onData(CsdBuffer.START_CODE, i4, 3);
            }
            this.sampleReader.onData(bArr, i5, iFindNalUnit);
            if (nalUnitTargetBuffer == null) {
                z = true;
            } else {
                if (i9 > 0) {
                    nalUnitTargetBuffer.appendToNalUnit(bArr, i5, iFindNalUnit);
                    i3 = 0;
                } else {
                    i3 = -i9;
                }
                if (nalUnitTargetBuffer.endNalUnit(i3)) {
                    int iUnescapeStream = OpusUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength);
                    String str2 = Util.DEVICE_DEBUG_INFO;
                    byte[] bArr2 = nalUnitTargetBuffer.nalData;
                    ParsableByteArray parsableByteArray2 = this.userDataParsable;
                    parsableByteArray2.reset(bArr2, iUnescapeStream);
                    this.userDataReader.consume(this.pesTimeUs, parsableByteArray2);
                }
                if (i8 == 178) {
                    z = true;
                    if (parsableByteArray.data[iFindNalUnit + 2] == 1) {
                        nalUnitTargetBuffer.startNalUnit(i8);
                    }
                } else {
                    z = true;
                }
            }
            int i14 = i - iFindNalUnit;
            this.sampleReader.onDataEnd(i14, this.totalBytesWritten - ((long) i14), this.hasOutputFormat);
            SampleReader sampleReader = this.sampleReader;
            long j = this.pesTimeUs;
            sampleReader.startCodeValue = i8;
            sampleReader.sampleIsKeyframe = false;
            sampleReader.readingSample = (i8 == 182 || i8 == 179) ? z : false;
            sampleReader.lookingForVopCodingType = i8 == 182 ? z : false;
            sampleReader.vopBytesRead = 0;
            sampleReader.sampleTimeUs = j;
            i6 = i;
            i5 = i2;
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
        this.sampleReader = new SampleReader(trackOutputTrack);
        this.userDataReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
        this.sampleReader.getClass();
        if (z) {
            this.sampleReader.onDataEnd(0, this.totalBytesWritten, this.hasOutputFormat);
            SampleReader sampleReader = this.sampleReader;
            sampleReader.readingSample = false;
            sampleReader.lookingForVopCodingType = false;
            sampleReader.sampleIsKeyframe = false;
            sampleReader.startCodeValue = -1;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.pesTimeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        OpusUtil.clearPrefixFlags(this.prefixFlags);
        CsdBuffer csdBuffer = this.csdBuffer;
        csdBuffer.isFilling = false;
        csdBuffer.length = 0;
        csdBuffer.state = (byte) 0;
        SampleReader sampleReader = this.sampleReader;
        if (sampleReader != null) {
            sampleReader.readingSample = false;
            sampleReader.lookingForVopCodingType = false;
            sampleReader.sampleIsKeyframe = false;
            sampleReader.startCodeValue = -1;
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.reset();
        }
        this.totalBytesWritten = 0L;
        this.pesTimeUs = -9223372036854775807L;
    }
}
