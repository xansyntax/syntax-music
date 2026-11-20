package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.navigation.NavOptions;
import coil3.util.UtilsKt;
import java.util.Arrays;
import java.util.Collections;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AdtsReader implements ElementaryStreamReader {
    public static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    public final String containerMimeType;
    public int currentFrameVersion;
    public TrackOutput currentOutput;
    public long currentSampleDuration;
    public final boolean exposeId3;
    public String formatId;
    public boolean foundFirstFrame;
    public boolean hasCrc;
    public boolean hasOutputFormat;
    public TrackOutput id3Output;
    public final String language;
    public TrackOutput output;
    public final int roleFlags;
    public int sampleSize;
    public final VorbisBitArray adtsScratch = new VorbisBitArray(new byte[7], 7);
    public final ParsableByteArray id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
    public int firstFrameVersion = -1;
    public int firstFrameSampleRateIndex = -1;
    public long sampleDurationUs = -9223372036854775807L;
    public long timeUs = -9223372036854775807L;
    public byte state = 0;
    public int bytesRead = 0;
    public short matchState = 256;

    public AdtsReader(int i, String str, String str2, boolean z) {
        this.exposeId3 = z;
        this.language = str;
        this.roleFlags = i;
        this.containerMimeType = str2;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0205  */
    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) {
        byte b;
        int i;
        byte b2;
        char c;
        int i2;
        char c2;
        int i3;
        int i4;
        int i5;
        this.output.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        while (parsableByteArray.bytesLeft() > 0) {
            byte b3 = this.state;
            byte b4 = -1;
            ParsableByteArray parsableByteArray2 = this.id3HeaderBuffer;
            byte b5 = 3;
            VorbisBitArray vorbisBitArray = this.adtsScratch;
            int i6 = 0;
            int i7 = 4;
            int i8 = 1;
            if (b3 == 0) {
                byte[] bArr = parsableByteArray.data;
                int i9 = parsableByteArray.position;
                int i10 = parsableByteArray.limit;
                while (true) {
                    if (i9 < i10) {
                        int i11 = i9 + 1;
                        byte b6 = b5;
                        byte b7 = bArr[i9];
                        int i12 = b7 & 255;
                        if (this.matchState == 512 && ((65280 | (((byte) i12) & 255 ? 1 : 0) ? 1 : 0) & 65526) == 65520) {
                            if (!this.foundFirstFrame) {
                                int i13 = i9 - 1;
                                parsableByteArray.setPosition(i9);
                                byte[] bArr2 = vorbisBitArray.data;
                                if (parsableByteArray.bytesLeft() < i8) {
                                    b = -1;
                                } else {
                                    parsableByteArray.readBytes(bArr2, i6, i8);
                                    vorbisBitArray.setPosition(i7);
                                    int bits = vorbisBitArray.readBits(i8);
                                    int i14 = this.firstFrameVersion;
                                    if (i14 == -1 || bits == i14) {
                                        if (this.firstFrameSampleRateIndex != -1) {
                                            byte[] bArr3 = vorbisBitArray.data;
                                            if (parsableByteArray.bytesLeft() >= i8) {
                                                parsableByteArray.readBytes(bArr3, i6, i8);
                                                vorbisBitArray.setPosition(2);
                                                i3 = 4;
                                                if (vorbisBitArray.readBits(4) != this.firstFrameSampleRateIndex) {
                                                    b = -1;
                                                } else {
                                                    parsableByteArray.setPosition(i11);
                                                }
                                            }
                                        } else {
                                            i3 = 4;
                                        }
                                        byte[] bArr4 = vorbisBitArray.data;
                                        if (parsableByteArray.bytesLeft() >= i3) {
                                            parsableByteArray.readBytes(bArr4, i6, i3);
                                            vorbisBitArray.setPosition(14);
                                            int bits2 = vorbisBitArray.readBits(13);
                                            if (bits2 < 7) {
                                                b = -1;
                                            } else {
                                                byte[] bArr5 = parsableByteArray.data;
                                                int i15 = parsableByteArray.limit;
                                                int i16 = i13 + bits2;
                                                if (i16 < i15) {
                                                    byte b8 = bArr5[i16];
                                                    b = -1;
                                                    if (b8 == -1) {
                                                        int i17 = i16 + 1;
                                                        if (i17 != i15) {
                                                            byte b9 = bArr5[i17];
                                                            if (((65280 | (b9 & 255 ? 1 : 0) ? 1 : 0) & 65526) == 65520 && ((b9 & 8) >> 3) == bits) {
                                                            }
                                                        }
                                                    } else if (b8 == 73 && ((i4 = i16 + 1) == i15 || (bArr5[i4] == 68 && ((i5 = i16 + 2) == i15 || bArr5[i5] == 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        b = -1;
                                    }
                                }
                                i = 1;
                            }
                            this.currentFrameVersion = (b7 & 8) >> 3;
                            this.hasCrc = (b7 & 1) == 0;
                            if (this.foundFirstFrame) {
                                this.state = b6;
                                this.bytesRead = 0;
                            } else {
                                this.state = (byte) 1;
                                this.bytesRead = 0;
                            }
                            parsableByteArray.setPosition(i11);
                        } else {
                            b = b4;
                            i = i8;
                        }
                        short s = this.matchState;
                        int i18 = i12 | s;
                        if (i18 == 329) {
                            b2 = 3;
                            c = 256;
                            i2 = 0;
                            c2 = 2;
                            this.matchState = (short) 768;
                        } else if (i18 == 511) {
                            b2 = 3;
                            c = 256;
                            i2 = 0;
                            c2 = 2;
                            this.matchState = (short) 512;
                        } else if (i18 == 836) {
                            b2 = 3;
                            c = 256;
                            i2 = 0;
                            c2 = 2;
                            this.matchState = (short) 1024;
                        } else if (i18 != 1075) {
                            c = 256;
                            if (s != 256) {
                                this.matchState = (short) 256;
                                b2 = 3;
                                i2 = 0;
                                c2 = 2;
                            } else {
                                b2 = 3;
                                i2 = 0;
                                c2 = 2;
                            }
                            i8 = i;
                            b4 = b;
                            i7 = 4;
                            i6 = i2;
                            b5 = b2;
                        } else {
                            this.state = (byte) 2;
                            this.bytesRead = 3;
                            this.sampleSize = 0;
                            parsableByteArray2.setPosition(0);
                            parsableByteArray.setPosition(i11);
                        }
                        i9 = i11;
                        i8 = i;
                        b4 = b;
                        i7 = 4;
                        i6 = i2;
                        b5 = b2;
                    } else {
                        parsableByteArray.setPosition(i9);
                    }
                }
            } else if (b3 != 1) {
                if (b3 == 2) {
                    byte[] bArr6 = parsableByteArray2.data;
                    int iMin = Math.min(parsableByteArray.bytesLeft(), 10 - this.bytesRead);
                    parsableByteArray.readBytes(bArr6, this.bytesRead, iMin);
                    int i19 = this.bytesRead + iMin;
                    this.bytesRead = i19;
                    if (i19 == 10) {
                        this.id3Output.sampleData(10, parsableByteArray2);
                        parsableByteArray2.setPosition(6);
                        TrackOutput trackOutput = this.id3Output;
                        int synchSafeInt = parsableByteArray2.readSynchSafeInt() + 10;
                        this.state = (byte) 4;
                        this.bytesRead = 10;
                        this.currentOutput = trackOutput;
                        this.currentSampleDuration = 0L;
                        this.sampleSize = synchSafeInt;
                    }
                } else if (b3 == 3) {
                    int i20 = this.hasCrc ? 7 : 5;
                    byte[] bArr7 = vorbisBitArray.data;
                    int iMin2 = Math.min(parsableByteArray.bytesLeft(), i20 - this.bytesRead);
                    parsableByteArray.readBytes(bArr7, this.bytesRead, iMin2);
                    int i21 = this.bytesRead + iMin2;
                    this.bytesRead = i21;
                    if (i21 == i20) {
                        vorbisBitArray.setPosition(0);
                        if (this.hasOutputFormat) {
                            vorbisBitArray.skipBits(10);
                        } else {
                            int bits3 = vorbisBitArray.readBits(2) + 1;
                            if (bits3 != 2) {
                                Log.w("AdtsReader", "Detected audio object type: " + bits3 + ", but assuming AAC LC.");
                                bits3 = 2;
                            }
                            vorbisBitArray.skipBits(5);
                            int bits4 = vorbisBitArray.readBits(3);
                            int i22 = this.firstFrameSampleRateIndex;
                            byte[] bArr8 = {(byte) (((bits3 << 3) & 248) | ((i22 >> 1) & 7)), (byte) (((bits4 << 3) & 120) | ((i22 << 7) & 128))};
                            NavOptions.Builder audioSpecificConfig = AacUtil.parseAudioSpecificConfig(new VorbisBitArray(bArr8, 2), false);
                            Format.Builder builder = new Format.Builder();
                            builder.id = this.formatId;
                            builder.containerMimeType = MimeTypes.normalizeMimeType(this.containerMimeType);
                            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/mp4a-latm");
                            builder.codecs = audioSpecificConfig.popUpToRoute;
                            builder.channelCount = audioSpecificConfig.exitAnim;
                            builder.sampleRate = audioSpecificConfig.enterAnim;
                            builder.initializationData = Collections.singletonList(bArr8);
                            builder.language = this.language;
                            builder.roleFlags = this.roleFlags;
                            Format format = new Format(builder);
                            this.sampleDurationUs = 1024000000 / ((long) format.sampleRate);
                            this.output.format(format);
                            this.hasOutputFormat = true;
                        }
                        vorbisBitArray.skipBits(4);
                        int bits5 = vorbisBitArray.readBits(13);
                        int i23 = bits5 - 7;
                        if (this.hasCrc) {
                            i23 = bits5 - 9;
                        }
                        TrackOutput trackOutput2 = this.output;
                        long j = this.sampleDurationUs;
                        this.state = (byte) 4;
                        this.bytesRead = 0;
                        this.currentOutput = trackOutput2;
                        this.currentSampleDuration = j;
                        this.sampleSize = i23;
                    }
                } else {
                    if (b3 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return;
                    }
                    int iMin3 = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                    this.currentOutput.sampleData(iMin3, parsableByteArray);
                    int i24 = this.bytesRead + iMin3;
                    this.bytesRead = i24;
                    if (i24 == this.sampleSize) {
                        UtilsKt.checkState(this.timeUs != -9223372036854775807L);
                        this.currentOutput.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
                        this.timeUs += this.currentSampleDuration;
                        this.state = (byte) 0;
                        this.bytesRead = 0;
                        this.matchState = (short) 256;
                    }
                }
            } else if (parsableByteArray.bytesLeft() != 0) {
                vorbisBitArray.data[0] = parsableByteArray.data[parsableByteArray.position];
                vorbisBitArray.setPosition(2);
                int bits6 = vorbisBitArray.readBits(4);
                int i25 = this.firstFrameSampleRateIndex;
                if (i25 == -1 || bits6 == i25) {
                    if (!this.foundFirstFrame) {
                        this.foundFirstFrame = true;
                        this.firstFrameVersion = this.currentFrameVersion;
                        this.firstFrameSampleRateIndex = bits6;
                    }
                    this.state = (byte) 3;
                    this.bytesRead = 0;
                } else {
                    this.foundFirstFrame = false;
                    this.state = (byte) 0;
                    this.bytesRead = 0;
                    this.matchState = (short) 256;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        this.formatId = trackIdGenerator.formatId;
        trackIdGenerator.maybeThrowUninitializedError();
        TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.trackId, 1);
        this.output = trackOutputTrack;
        this.currentOutput = trackOutputTrack;
        if (!this.exposeId3) {
            this.id3Output = new DiscardingTrackOutput();
            return;
        }
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        TrackOutput trackOutputTrack2 = extractorOutput.track(trackIdGenerator.trackId, 5);
        this.id3Output = trackOutputTrack2;
        Format.Builder builder = new Format.Builder();
        trackIdGenerator.maybeThrowUninitializedError();
        builder.id = trackIdGenerator.formatId;
        builder.containerMimeType = MimeTypes.normalizeMimeType(this.containerMimeType);
        builder.sampleMimeType = MimeTypes.normalizeMimeType("application/id3");
        Format$$ExternalSyntheticOutline0.m(builder, trackOutputTrack2);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.timeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.timeUs = -9223372036854775807L;
        this.foundFirstFrame = false;
        this.state = (byte) 0;
        this.bytesRead = 0;
        this.matchState = (short) 256;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
    }
}
