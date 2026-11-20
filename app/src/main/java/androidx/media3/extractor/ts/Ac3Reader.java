package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac4Util$SyncFrameInfo;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Ac3Reader implements ElementaryStreamReader {
    public final /* synthetic */ byte $r8$classId;
    public int bytesRead;
    public final String containerMimeType;
    public Format format;
    public String formatId;
    public final VorbisBitArray headerScratchBits;
    public final ParsableByteArray headerScratchBytes;
    public final String language;
    public boolean lastByteWas0B;
    public TrackOutput output;
    public final int roleFlags;
    public long sampleDurationUs;
    public int sampleSize;
    public byte state;
    public long timeUs;

    public Ac3Reader(String str, int i, String str2, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                VorbisBitArray vorbisBitArray = new VorbisBitArray(new byte[16], 16);
                this.headerScratchBits = vorbisBitArray;
                this.headerScratchBytes = new ParsableByteArray(vorbisBitArray.data);
                this.state = (byte) 0;
                this.bytesRead = 0;
                this.lastByteWas0B = false;
                this.timeUs = -9223372036854775807L;
                this.language = str;
                this.roleFlags = i;
                this.containerMimeType = str2;
                break;
            default:
                VorbisBitArray vorbisBitArray2 = new VorbisBitArray(new byte[128], 128);
                this.headerScratchBits = vorbisBitArray2;
                this.headerScratchBytes = new ParsableByteArray(vorbisBitArray2.data);
                this.state = (byte) 0;
                this.timeUs = -9223372036854775807L;
                this.language = str;
                this.roleFlags = i;
                this.containerMimeType = str2;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:183:0x0369  */
    /* JADX WARN: Code duplicated, block: B:186:0x0377  */
    /* JADX WARN: Code duplicated, block: B:188:0x037f  */
    /* JADX WARN: Code duplicated, block: B:195:0x0395 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:196:0x0397  */
    /* JADX WARN: Code duplicated, block: B:197:0x039c  */
    /* JADX WARN: Code duplicated, block: B:199:0x039f  */
    /* JADX WARN: Code duplicated, block: B:201:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:202:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:204:0x03b1  */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 13341. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
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
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        int bits;
        int i5;
        byte b;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        long j;
        parsableByteArray = parsableByteArray;
        byte b2 = this.$r8$classId;
        int i18 = this.roleFlags;
        String str2 = this.language;
        String str3 = this.containerMimeType;
        VorbisBitArray vorbisBitArray = this.headerScratchBits;
        long j2 = -9223372036854775807L;
        byte b3 = 0;
        byte b4 = 1;
        byte b5 = 2;
        ParsableByteArray parsableByteArray2 = this.headerScratchBytes;
        int i19 = 16;
        switch (b2) {
            case 0:
                this.output.getClass();
                while (parsableByteArray.bytesLeft() > 0) {
                    byte b6 = this.state;
                    if (b6 == 0) {
                        while (true) {
                            if (parsableByteArray.bytesLeft() <= 0) {
                                b3 = 0;
                                b4 = 1;
                                b5 = 2;
                            } else if (this.lastByteWas0B) {
                                int unsignedByte = parsableByteArray.readUnsignedByte();
                                if (unsignedByte == 119) {
                                    this.lastByteWas0B = false;
                                    b4 = 1;
                                    this.state = (byte) 1;
                                    byte[] bArr = parsableByteArray2.data;
                                    bArr[0] = 11;
                                    bArr[1] = 119;
                                    this.bytesRead = 2;
                                    b5 = 2;
                                    b3 = 0;
                                } else {
                                    this.lastByteWas0B = unsignedByte == 11;
                                }
                            } else {
                                this.lastByteWas0B = parsableByteArray.readUnsignedByte() == 11;
                            }
                        }
                    } else if (b6 == b4) {
                        byte[] bArr2 = parsableByteArray2.data;
                        int iMin = Math.min(parsableByteArray.bytesLeft(), 128 - this.bytesRead);
                        parsableByteArray.readBytes(bArr2, this.bytesRead, iMin);
                        int i20 = this.bytesRead + iMin;
                        this.bytesRead = i20;
                        if (i20 == 128) {
                            vorbisBitArray.setPosition(b3);
                            int[] iArr = AacUtil.CHANNEL_COUNT_BY_ACMOD;
                            int[] iArr2 = AacUtil.SAMPLE_RATE_BY_FSCOD;
                            int position = vorbisBitArray.getPosition();
                            vorbisBitArray.skipBits(40);
                            byte b7 = vorbisBitArray.readBits(5) > 10 ? b4 : (byte) 0;
                            vorbisBitArray.setPosition(position);
                            if (b7 != 0) {
                                vorbisBitArray.skipBits(i19);
                                int bits2 = vorbisBitArray.readBits(b5);
                                if (bits2 == 0) {
                                    b = 0;
                                } else if (bits2 != b4) {
                                    b = bits2 != b5 ? (byte) -1 : b5;
                                } else {
                                    b = b4;
                                }
                                vorbisBitArray.skipBits(3);
                                bits = (vorbisBitArray.readBits(11) + b4) * b5;
                                int bits3 = vorbisBitArray.readBits(b5);
                                if (bits3 == 3) {
                                    i5 = AacUtil.SAMPLE_RATE_BY_FSCOD2[vorbisBitArray.readBits(b5)];
                                    i6 = 3;
                                    i7 = 6;
                                } else {
                                    int bits4 = vorbisBitArray.readBits(b5);
                                    int i21 = AacUtil.BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[bits4];
                                    i5 = iArr2[bits3];
                                    i6 = bits4;
                                    i7 = i21;
                                }
                                i4 = i7 * 256;
                                int i22 = (bits * i5) / (i7 * 32);
                                int bits5 = vorbisBitArray.readBits(3);
                                boolean bit = vorbisBitArray.readBit();
                                int i23 = iArr[bits5] + (bit ? 1 : 0);
                                vorbisBitArray.skipBits(10);
                                if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(8);
                                }
                                if (bits5 == 0) {
                                    vorbisBitArray.skipBits(5);
                                    if (vorbisBitArray.readBit()) {
                                        vorbisBitArray.skipBits(8);
                                    }
                                }
                                if (b == 1 && vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(16);
                                }
                                if (vorbisBitArray.readBit()) {
                                    if (bits5 > 2) {
                                        vorbisBitArray.skipBits(2);
                                    }
                                    if ((bits5 & 1) == 0 || bits5 <= 2) {
                                        i13 = 6;
                                    } else {
                                        i13 = 6;
                                        vorbisBitArray.skipBits(6);
                                    }
                                    if ((bits5 & 4) != 0) {
                                        vorbisBitArray.skipBits(i13);
                                    }
                                    if (bit && vorbisBitArray.readBit()) {
                                        vorbisBitArray.skipBits(5);
                                    }
                                    if (b == 0) {
                                        if (vorbisBitArray.readBit()) {
                                            i14 = 6;
                                            vorbisBitArray.skipBits(6);
                                        } else {
                                            i14 = 6;
                                        }
                                        if (bits5 == 0 && vorbisBitArray.readBit()) {
                                            vorbisBitArray.skipBits(i14);
                                        }
                                        if (vorbisBitArray.readBit()) {
                                            vorbisBitArray.skipBits(i14);
                                        }
                                        i8 = i23;
                                        int bits6 = vorbisBitArray.readBits(2);
                                        if (bits6 == 1) {
                                            vorbisBitArray.skipBits(5);
                                        } else if (bits6 == 2) {
                                            vorbisBitArray.skipBits(12);
                                        } else {
                                            if (bits6 == 3) {
                                                int bits7 = vorbisBitArray.readBits(5);
                                                if (vorbisBitArray.readBit()) {
                                                    vorbisBitArray.skipBits(5);
                                                    if (vorbisBitArray.readBit()) {
                                                        i16 = 4;
                                                        vorbisBitArray.skipBits(4);
                                                    } else {
                                                        i16 = 4;
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(i16);
                                                    }
                                                    if (vorbisBitArray.readBit()) {
                                                        if (vorbisBitArray.readBit()) {
                                                            vorbisBitArray.skipBits(i16);
                                                        }
                                                        if (vorbisBitArray.readBit()) {
                                                            vorbisBitArray.skipBits(i16);
                                                        }
                                                    }
                                                }
                                                if (vorbisBitArray.readBit()) {
                                                    vorbisBitArray.skipBits(5);
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(7);
                                                        if (vorbisBitArray.readBit()) {
                                                            vorbisBitArray.skipBits(8);
                                                            i15 = 2;
                                                        } else {
                                                            i15 = 2;
                                                        }
                                                    } else {
                                                        i15 = 2;
                                                    }
                                                } else {
                                                    i15 = 2;
                                                }
                                                vorbisBitArray.skipBits((bits7 + i15) * 8);
                                                vorbisBitArray.byteAlign();
                                            }
                                            if (bits5 < i15) {
                                                if (vorbisBitArray.readBit()) {
                                                    vorbisBitArray.skipBits(14);
                                                }
                                                if (bits5 == 0 && vorbisBitArray.readBit()) {
                                                    vorbisBitArray.skipBits(14);
                                                }
                                            }
                                            i9 = i6;
                                            if (vorbisBitArray.readBit()) {
                                                if (i9 == 0) {
                                                    vorbisBitArray.skipBits(5);
                                                } else {
                                                    for (i17 = 0; i17 < i7; i17++) {
                                                        if (vorbisBitArray.readBit()) {
                                                            vorbisBitArray.skipBits(5);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i15 = 2;
                                        if (bits5 < i15) {
                                            if (vorbisBitArray.readBit()) {
                                                vorbisBitArray.skipBits(14);
                                            }
                                            if (bits5 == 0) {
                                                vorbisBitArray.skipBits(14);
                                            }
                                        }
                                        i9 = i6;
                                        if (vorbisBitArray.readBit()) {
                                            if (i9 == 0) {
                                                vorbisBitArray.skipBits(5);
                                            } else {
                                                while (i17 < i7) {
                                                    if (vorbisBitArray.readBit()) {
                                                        vorbisBitArray.skipBits(5);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        i8 = i23;
                                        i9 = i6;
                                    }
                                } else {
                                    i8 = i23;
                                    i9 = i6;
                                }
                                if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(5);
                                    if (bits5 == 2) {
                                        vorbisBitArray.skipBits(4);
                                    }
                                    if (bits5 >= 6) {
                                        vorbisBitArray.skipBits(2);
                                    }
                                    if (vorbisBitArray.readBit()) {
                                        i12 = 8;
                                        vorbisBitArray.skipBits(8);
                                    } else {
                                        i12 = 8;
                                    }
                                    if (bits5 == 0 && vorbisBitArray.readBit()) {
                                        vorbisBitArray.skipBits(i12);
                                    }
                                    i10 = 3;
                                    if (bits3 < 3) {
                                        vorbisBitArray.skipBit();
                                    }
                                } else {
                                    i10 = 3;
                                }
                                if (b == 0 && i9 != i10) {
                                    vorbisBitArray.skipBit();
                                }
                                if (b == 2 && (i9 == i10 || vorbisBitArray.readBit())) {
                                    i11 = 6;
                                    vorbisBitArray.skipBits(6);
                                } else {
                                    i11 = 6;
                                }
                                str = (vorbisBitArray.readBit() && vorbisBitArray.readBits(i11) == 1 && vorbisBitArray.readBits(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                                i = i22;
                                i3 = i8;
                            } else {
                                vorbisBitArray.skipBits(32);
                                int bits8 = vorbisBitArray.readBits(2);
                                String str4 = bits8 == 3 ? null : "audio/ac3";
                                int bits9 = vorbisBitArray.readBits(6);
                                i = AacUtil.BITRATE_BY_HALF_FRMSIZECOD[bits9 / 2] * CIOKt.DEFAULT_HTTP_POOL_SIZE;
                                int ac3SyncframeSize = AacUtil.getAc3SyncframeSize(bits8, bits9);
                                vorbisBitArray.skipBits(8);
                                int bits10 = vorbisBitArray.readBits(3);
                                if ((bits10 & 1) == 0 || bits10 == 1) {
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    vorbisBitArray.skipBits(2);
                                }
                                if ((bits10 & 4) != 0) {
                                    vorbisBitArray.skipBits(i2);
                                }
                                if (bits10 == i2) {
                                    vorbisBitArray.skipBits(i2);
                                }
                                int i24 = bits8 < 3 ? iArr2[bits8] : -1;
                                i3 = iArr[bits10] + (vorbisBitArray.readBit() ? 1 : 0);
                                i4 = 1536;
                                str = str4;
                                bits = ac3SyncframeSize;
                                i5 = i24;
                            }
                            Format format = this.format;
                            if (format == null || i3 != format.channelCount || i5 != format.sampleRate || !Objects.equals(str, format.sampleMimeType)) {
                                Format.Builder builder = new Format.Builder();
                                builder.id = this.formatId;
                                builder.containerMimeType = MimeTypes.normalizeMimeType(str3);
                                builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
                                builder.channelCount = i3;
                                builder.sampleRate = i5;
                                builder.language = str2;
                                builder.roleFlags = i18;
                                builder.peakBitrate = i;
                                if ("audio/ac3".equals(str)) {
                                    builder.averageBitrate = i;
                                }
                                Format format2 = new Format(builder);
                                this.format = format2;
                                this.output.format(format2);
                            }
                            this.sampleSize = bits;
                            this.sampleDurationUs = (((long) i4) * 1000000) / ((long) this.format.sampleRate);
                            parsableByteArray2.setPosition(0);
                            this.output.sampleData(128, parsableByteArray2);
                            this.state = (byte) 2;
                            b5 = 2;
                            b3 = 0;
                            b4 = 1;
                        } else {
                            parsableByteArray = parsableByteArray;
                        }
                    } else if (b6 == b5) {
                        int iMin2 = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(iMin2, parsableByteArray);
                        int i25 = this.bytesRead + iMin2;
                        this.bytesRead = i25;
                        if (i25 == this.sampleSize) {
                            UtilsKt.checkState(this.timeUs != -9223372036854775807L ? b4 : b3);
                            this.output.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = b3;
                        }
                    }
                    i19 = 16;
                }
                break;
            default:
                this.output.getClass();
                while (parsableByteArray.bytesLeft() > 0) {
                    byte b8 = this.state;
                    if (b8 == 0) {
                        j = j2;
                        while (parsableByteArray.bytesLeft() > 0) {
                            if (this.lastByteWas0B) {
                                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                                this.lastByteWas0B = unsignedByte2 == 172;
                                if (unsignedByte2 == 64 || unsignedByte2 == 65) {
                                    Object[] objArr = unsignedByte2 == 65;
                                    this.state = (byte) 1;
                                    byte[] bArr3 = parsableByteArray2.data;
                                    bArr3[0] = -84;
                                    bArr3[1] = (byte) (objArr == true ? 65 : 64);
                                    this.bytesRead = 2;
                                }
                            } else {
                                this.lastByteWas0B = parsableByteArray.readUnsignedByte() == 172;
                            }
                        }
                    } else if (b8 == 1) {
                        j = j2;
                        byte[] bArr4 = parsableByteArray2.data;
                        int iMin3 = Math.min(parsableByteArray.bytesLeft(), 16 - this.bytesRead);
                        parsableByteArray.readBytes(bArr4, this.bytesRead, iMin3);
                        int i26 = this.bytesRead + iMin3;
                        this.bytesRead = i26;
                        if (i26 == 16) {
                            vorbisBitArray.setPosition(0);
                            Ac4Util$SyncFrameInfo ac4SyncframeInfo = AacUtil.parseAc4SyncframeInfo(vorbisBitArray);
                            int i27 = ac4SyncframeInfo.sampleRate;
                            Format format3 = this.format;
                            if (format3 == null || 2 != format3.channelCount || i27 != format3.sampleRate || !"audio/ac4".equals(format3.sampleMimeType)) {
                                Format.Builder builder2 = new Format.Builder();
                                builder2.id = this.formatId;
                                builder2.containerMimeType = MimeTypes.normalizeMimeType(str3);
                                builder2.sampleMimeType = MimeTypes.normalizeMimeType("audio/ac4");
                                builder2.channelCount = 2;
                                builder2.sampleRate = i27;
                                builder2.language = str2;
                                builder2.roleFlags = i18;
                                Format format4 = new Format(builder2);
                                this.format = format4;
                                this.output.format(format4);
                            }
                            this.sampleSize = ac4SyncframeInfo.frameSize;
                            this.sampleDurationUs = (((long) ac4SyncframeInfo.sampleCount) * 1000000) / ((long) this.format.sampleRate);
                            parsableByteArray2.setPosition(0);
                            this.output.sampleData(16, parsableByteArray2);
                            this.state = (byte) 2;
                        }
                    } else if (b8 == 2) {
                        int iMin4 = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(iMin4, parsableByteArray);
                        int i28 = this.bytesRead + iMin4;
                        this.bytesRead = i28;
                        if (i28 == this.sampleSize) {
                            UtilsKt.checkState(this.timeUs != j2);
                            j = j2;
                            this.output.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = (byte) 0;
                        }
                    }
                    j2 = j;
                }
                break;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        switch (this.$r8$classId) {
            case 0:
                trackIdGenerator.generateNewId();
                trackIdGenerator.maybeThrowUninitializedError();
                this.formatId = trackIdGenerator.formatId;
                trackIdGenerator.maybeThrowUninitializedError();
                this.output = extractorOutput.track(trackIdGenerator.trackId, 1);
                break;
            default:
                trackIdGenerator.generateNewId();
                trackIdGenerator.maybeThrowUninitializedError();
                this.formatId = trackIdGenerator.formatId;
                trackIdGenerator.maybeThrowUninitializedError();
                this.output = extractorOutput.track(trackIdGenerator.trackId, 1);
                break;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
        byte b = this.$r8$classId;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        switch (this.$r8$classId) {
            case 0:
                this.timeUs = j;
                break;
            default:
                this.timeUs = j;
                break;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        switch (this.$r8$classId) {
            case 0:
                this.state = (byte) 0;
                this.bytesRead = 0;
                this.lastByteWas0B = false;
                this.timeUs = -9223372036854775807L;
                break;
            default:
                this.state = (byte) 0;
                this.bytesRead = 0;
                this.lastByteWas0B = false;
                this.timeUs = -9223372036854775807L;
                break;
        }
    }

    private final void packetFinished$androidx$media3$extractor$ts$Ac3Reader(boolean z) {
    }

    private final void packetFinished$androidx$media3$extractor$ts$Ac4Reader(boolean z) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Ac3Reader(String str) {
        this(null, 0, str, (byte) 0);
        this.$r8$classId = (byte) 0;
    }
}
