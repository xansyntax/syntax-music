package androidx.media3.extractor.ogg;

import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.VorbisUtil$Mode;
import androidx.media3.extractor.VorbisUtil$VorbisIdHeader;
import androidx.navigation.internal.NavGraphImpl;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VorbisReader extends StreamReader {
    public AtomicInt commentHeader;
    public int previousPacketBlockSize;
    public boolean seenFirstAudioPacket;
    public VorbisUtil$VorbisIdHeader vorbisIdHeader;
    public NavGraphImpl vorbisSetup;

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void onSeekEnd(long j) {
        this.currentGranule = j;
        this.seenFirstAudioPacket = j != 0;
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader = this.vorbisIdHeader;
        this.previousPacketBlockSize = vorbisUtil$VorbisIdHeader != null ? vorbisUtil$VorbisIdHeader.blockSize0 : 0;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        byte b = parsableByteArray.data[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        NavGraphImpl navGraphImpl = this.vorbisSetup;
        navGraphImpl.getClass();
        boolean z = ((VorbisUtil$Mode[]) navGraphImpl.startDestinationRoute)[(b >> 1) & (255 >>> (8 - navGraphImpl.startDestId))].blockFlag;
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader = (VorbisUtil$VorbisIdHeader) navGraphImpl.graph;
        int i = !z ? vorbisUtil$VorbisIdHeader.blockSize0 : vorbisUtil$VorbisIdHeader.blockSize1;
        long j = this.seenFirstAudioPacket ? (this.previousPacketBlockSize + i) / 4 : 0;
        byte[] bArr = parsableByteArray.data;
        int length = bArr.length;
        int i2 = parsableByteArray.limit + 4;
        if (length < i2) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
            parsableByteArray.reset(bArrCopyOf, bArrCopyOf.length);
        } else {
            parsableByteArray.setLimit(i2);
        }
        byte[] bArr2 = parsableByteArray.data;
        int i3 = parsableByteArray.limit;
        bArr2[i3 - 4] = (byte) (j & 255);
        bArr2[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr2[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr2[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = i;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:169:0x03ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:171:0x03af  */
    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j, CallbackWrapper callbackWrapper) throws ParserException {
        NavGraphImpl navGraphImpl;
        if (this.vorbisSetup != null) {
            ((Format) callbackWrapper.mCallback).getClass();
            return false;
        }
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader = this.vorbisIdHeader;
        int i = 4;
        if (vorbisUtil$VorbisIdHeader != null) {
            AtomicInt atomicInt = this.commentHeader;
            if (atomicInt == null) {
                this.commentHeader = AacUtil.readVorbisCommentHeader(parsableByteArray, true, true);
            } else {
                int i2 = parsableByteArray.limit;
                byte[] bArr = new byte[i2];
                System.arraycopy(parsableByteArray.data, 0, bArr, 0, i2);
                short s = vorbisUtil$VorbisIdHeader.channels;
                int i3 = 5;
                AacUtil.verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
                int unsignedByte = parsableByteArray.readUnsignedByte() + 1;
                VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
                int i4 = 8;
                vorbisBitArray.skipBits(parsableByteArray.position * 8);
                int i5 = 0;
                while (true) {
                    int i6 = i4;
                    int i7 = 16;
                    if (i5 >= unsignedByte) {
                        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader2 = vorbisUtil$VorbisIdHeader;
                        int i8 = 6;
                        int bits = vorbisBitArray.readBits(6) + 1;
                        for (int i9 = 0; i9 < bits; i9++) {
                            if (vorbisBitArray.readBits(16) != 0) {
                                throw ParserException.createForMalformedContainer(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i10 = 1;
                        int bits2 = vorbisBitArray.readBits(6) + 1;
                        int i11 = 0;
                        while (true) {
                            int i12 = 3;
                            if (i11 >= bits2) {
                                int bits3 = vorbisBitArray.readBits(i8) + 1;
                                int i13 = 0;
                                while (i13 < bits3) {
                                    if (vorbisBitArray.readBits(16) > 2) {
                                        throw ParserException.createForMalformedContainer(null, "residueType greater than 2 is not decodable");
                                    }
                                    vorbisBitArray.skipBits(24);
                                    vorbisBitArray.skipBits(24);
                                    vorbisBitArray.skipBits(24);
                                    int bits4 = vorbisBitArray.readBits(i8) + 1;
                                    int i14 = 8;
                                    vorbisBitArray.skipBits(8);
                                    int[] iArr = new int[bits4];
                                    for (int i15 = 0; i15 < bits4; i15++) {
                                        iArr[i15] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
                                    }
                                    int i16 = 0;
                                    while (i16 < bits4) {
                                        int i17 = 0;
                                        while (i17 < i14) {
                                            if ((iArr[i16] & (1 << i17)) != 0) {
                                                vorbisBitArray.skipBits(i14);
                                            }
                                            i17++;
                                            i14 = 8;
                                        }
                                        i16++;
                                        i14 = 8;
                                    }
                                    i13++;
                                    i8 = 6;
                                }
                                int bits5 = vorbisBitArray.readBits(i8) + 1;
                                for (int i18 = 0; i18 < bits5; i18++) {
                                    int bits6 = vorbisBitArray.readBits(16);
                                    if (bits6 != 0) {
                                        Log.e("VorbisUtil", "mapping type other than 0 not supported: " + bits6);
                                    } else {
                                        int bits7 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                                        if (vorbisBitArray.readBit()) {
                                            int bits8 = vorbisBitArray.readBits(8) + 1;
                                            for (int i19 = 0; i19 < bits8; i19++) {
                                                int i20 = s - 1;
                                                int i21 = 0;
                                                for (int i22 = i20; i22 > 0; i22 >>>= 1) {
                                                    i21++;
                                                }
                                                vorbisBitArray.skipBits(i21);
                                                int i23 = 0;
                                                while (i20 > 0) {
                                                    i23++;
                                                    i20 >>>= 1;
                                                }
                                                vorbisBitArray.skipBits(i23);
                                            }
                                        }
                                        if (vorbisBitArray.readBits(2) != 0) {
                                            throw ParserException.createForMalformedContainer(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (bits7 > 1) {
                                            for (int i24 = 0; i24 < s; i24++) {
                                                vorbisBitArray.skipBits(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < bits7; i25++) {
                                            vorbisBitArray.skipBits(8);
                                            vorbisBitArray.skipBits(8);
                                            vorbisBitArray.skipBits(8);
                                        }
                                    }
                                }
                                int bits9 = vorbisBitArray.readBits(6);
                                int i26 = bits9 + 1;
                                VorbisUtil$Mode[] vorbisUtil$ModeArr = new VorbisUtil$Mode[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    boolean bit = vorbisBitArray.readBit();
                                    vorbisBitArray.readBits(16);
                                    vorbisBitArray.readBits(16);
                                    vorbisBitArray.readBits(8);
                                    vorbisUtil$ModeArr[i27] = new VorbisUtil$Mode(bit);
                                }
                                if (!vorbisBitArray.readBit()) {
                                    throw ParserException.createForMalformedContainer(null, "framing bit after modes not set as expected");
                                }
                                int i28 = 0;
                                while (bits9 > 0) {
                                    i28++;
                                    bits9 >>>= 1;
                                }
                                navGraphImpl = new NavGraphImpl(vorbisUtil$VorbisIdHeader2, atomicInt, bArr, vorbisUtil$ModeArr, i28);
                                break;
                            }
                            int bits10 = vorbisBitArray.readBits(i7);
                            if (bits10 == 0) {
                                int i29 = i6;
                                vorbisBitArray.skipBits(i29);
                                vorbisBitArray.skipBits(16);
                                vorbisBitArray.skipBits(16);
                                vorbisBitArray.skipBits(6);
                                vorbisBitArray.skipBits(i29);
                                int bits11 = vorbisBitArray.readBits(4) + 1;
                                int i30 = 0;
                                while (i30 < bits11) {
                                    vorbisBitArray.skipBits(i29);
                                    i30++;
                                    i29 = 8;
                                }
                            } else {
                                if (bits10 != i10) {
                                    throw ParserException.createForMalformedContainer(null, "floor type greater than 1 not decodable: " + bits10);
                                }
                                int bits12 = vorbisBitArray.readBits(5);
                                int[] iArr2 = new int[bits12];
                                int i31 = -1;
                                for (int i32 = 0; i32 < bits12; i32++) {
                                    int bits13 = vorbisBitArray.readBits(4);
                                    iArr2[i32] = bits13;
                                    if (bits13 > i31) {
                                        i31 = bits13;
                                    }
                                }
                                int i33 = i31 + 1;
                                int[] iArr3 = new int[i33];
                                int i34 = 0;
                                while (i34 < i33) {
                                    iArr3[i34] = vorbisBitArray.readBits(i12) + 1;
                                    int bits14 = vorbisBitArray.readBits(2);
                                    int i35 = i6;
                                    if (bits14 > 0) {
                                        vorbisBitArray.skipBits(i35);
                                    }
                                    int i36 = i33;
                                    int i37 = 0;
                                    for (int i38 = 1; i37 < (i38 << bits14); i38 = 1) {
                                        vorbisBitArray.skipBits(i35);
                                        i37++;
                                        i35 = 8;
                                    }
                                    i34++;
                                    i33 = i36;
                                    i6 = 8;
                                    i12 = 3;
                                }
                                vorbisBitArray.skipBits(2);
                                int bits15 = vorbisBitArray.readBits(4);
                                int i39 = 0;
                                int i40 = 0;
                                for (int i41 = 0; i41 < bits12; i41++) {
                                    i39 += iArr3[iArr2[i41]];
                                    while (i40 < i39) {
                                        vorbisBitArray.skipBits(bits15);
                                        i40++;
                                    }
                                }
                            }
                            i11++;
                            i6 = 8;
                            i8 = 6;
                            i10 = 1;
                            i7 = 16;
                        }
                    } else {
                        if (vorbisBitArray.readBits(24) != 5653314) {
                            throw ParserException.createForMalformedContainer(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((vorbisBitArray.byteOffset * 8) + vorbisBitArray.bitOffset));
                        }
                        int bits16 = vorbisBitArray.readBits(16);
                        int bits17 = vorbisBitArray.readBits(24);
                        if (vorbisBitArray.readBit()) {
                            vorbisBitArray.skipBits(i3);
                            int bits18 = 0;
                            while (bits18 < bits17) {
                                int i42 = 0;
                                for (int i43 = bits17 - bits18; i43 > 0; i43 >>>= 1) {
                                    i42++;
                                }
                                bits18 += vorbisBitArray.readBits(i42);
                            }
                        } else {
                            boolean bit2 = vorbisBitArray.readBit();
                            for (int i44 = 0; i44 < bits17; i44++) {
                                if (!bit2) {
                                    vorbisBitArray.skipBits(i3);
                                } else if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(i3);
                                }
                            }
                        }
                        int bits19 = vorbisBitArray.readBits(i);
                        if (bits19 > 2) {
                            throw ParserException.createForMalformedContainer(null, "lookup type greater than 2 not decodable: " + bits19);
                        }
                        if (bits19 == 1 || bits19 == 2) {
                            vorbisBitArray.skipBits(32);
                            vorbisBitArray.skipBits(32);
                            int bits20 = vorbisBitArray.readBits(i) + 1;
                            vorbisBitArray.skipBits(1);
                            vorbisBitArray.skipBits((int) ((bits19 == 1 ? bits16 != 0 ? (long) Math.floor(Math.pow(bits17, 1.0d / ((double) bits16))) : 0L : ((long) bits16) * ((long) bits17)) * ((long) bits20)));
                        } else {
                            vorbisUtil$VorbisIdHeader = vorbisUtil$VorbisIdHeader;
                        }
                        i5++;
                        i4 = i6;
                        vorbisUtil$VorbisIdHeader = vorbisUtil$VorbisIdHeader;
                        i = 4;
                        i3 = 5;
                    }
                }
            }
            this.vorbisSetup = navGraphImpl;
            if (navGraphImpl == null) {
                return true;
            }
            VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader3 = (VorbisUtil$VorbisIdHeader) navGraphImpl.graph;
            ArrayList arrayList = new ArrayList();
            arrayList.add(vorbisUtil$VorbisIdHeader3.data);
            arrayList.add((byte[]) navGraphImpl.startDestIdName);
            Metadata vorbisComments = AacUtil.parseVorbisComments(ImmutableList.copyOf((String[]) ((AtomicInt) navGraphImpl.nodes).delegate));
            Format.Builder builder = new Format.Builder();
            builder.containerMimeType = MimeTypes.normalizeMimeType("audio/ogg");
            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/vorbis");
            builder.averageBitrate = vorbisUtil$VorbisIdHeader3.bitrateNominal;
            builder.peakBitrate = vorbisUtil$VorbisIdHeader3.bitrateMaximum;
            builder.channelCount = vorbisUtil$VorbisIdHeader3.channels;
            builder.sampleRate = vorbisUtil$VorbisIdHeader3.sampleRate;
            builder.initializationData = arrayList;
            builder.metadata = vorbisComments;
            callbackWrapper.mCallback = new Format(builder);
            return true;
        }
        AacUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        parsableByteArray.readLittleEndianUnsignedIntToInt();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        int littleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianInt = parsableByteArray.readLittleEndianInt();
        int i45 = littleEndianInt <= 0 ? -1 : littleEndianInt;
        int littleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int i46 = littleEndianInt2 <= 0 ? -1 : littleEndianInt2;
        parsableByteArray.readLittleEndianInt();
        int unsignedByte3 = parsableByteArray.readUnsignedByte();
        int iPow = (int) Math.pow(2.0d, unsignedByte3 & 15);
        int iPow2 = (int) Math.pow(2.0d, (unsignedByte3 & 240) >> 4);
        parsableByteArray.readUnsignedByte();
        this.vorbisIdHeader = new VorbisUtil$VorbisIdHeader(unsignedByte2, littleEndianUnsignedIntToInt, i45, i46, iPow, iPow2, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit));
        navGraphImpl = null;
        this.vorbisSetup = navGraphImpl;
        if (navGraphImpl == null) {
            return true;
        }
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader4 = (VorbisUtil$VorbisIdHeader) navGraphImpl.graph;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(vorbisUtil$VorbisIdHeader4.data);
        arrayList2.add((byte[]) navGraphImpl.startDestIdName);
        Metadata vorbisComments2 = AacUtil.parseVorbisComments(ImmutableList.copyOf((String[]) ((AtomicInt) navGraphImpl.nodes).delegate));
        Format.Builder builder2 = new Format.Builder();
        builder2.containerMimeType = MimeTypes.normalizeMimeType("audio/ogg");
        builder2.sampleMimeType = MimeTypes.normalizeMimeType("audio/vorbis");
        builder2.averageBitrate = vorbisUtil$VorbisIdHeader4.bitrateNominal;
        builder2.peakBitrate = vorbisUtil$VorbisIdHeader4.bitrateMaximum;
        builder2.channelCount = vorbisUtil$VorbisIdHeader4.channels;
        builder2.sampleRate = vorbisUtil$VorbisIdHeader4.sampleRate;
        builder2.initializationData = arrayList2;
        builder2.metadata = vorbisComments2;
        callbackWrapper.mCallback = new Format(builder2);
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }
}
