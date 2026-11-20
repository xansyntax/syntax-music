package androidx.media3.container;

import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.Ac4Util$SyncFrameInfo;
import androidx.media3.extractor.wav.WavFormat;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.math.DoubleMath;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OpusUtil {
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object scratchEscapePositionsLock = new Object();
    public static int[] scratchEscapePositions = new int[10];

    public static ArrayList buildInitializationData(byte[] bArr) {
        long j = (((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000L).array());
        return arrayList;
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        UtilsKt.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            clearPrefixFlags(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    clearPrefixFlags(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static String getNalStructureMimeType(Format format) {
        String str = format.sampleMimeType;
        String str2 = format.codecs;
        if (Objects.equals(str, "video/dolby-vision") && str2 != null) {
            if (str2.startsWith("dva1") || str2.startsWith("dvav")) {
                return "video/avc";
            }
            if (str2.startsWith("dvh1") || str2.startsWith("dvhe")) {
                return "video/hevc";
            }
        }
        return format.sampleMimeType;
    }

    public static long getPacketDurationUs(byte b, byte b2) {
        int i;
        int i2;
        int i3 = b & 255;
        int i4 = b & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1 && i4 != 2) {
                i = b2 & 63;
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i2 = 2500 << i6;
        } else if (i5 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else {
            i2 = i6 == 3 ? 60000 : 10000 << i6;
        }
        return ((long) i) * ((long) i2);
    }

    public static boolean isDependedOn(byte[] bArr, int i, Format format) {
        int i2;
        if (Objects.equals(format.sampleMimeType, "video/avc")) {
            byte b = bArr[4];
            if (((b & 96) >> 5) == 0 && ((i2 = b & 31) == 1 || i2 == 9 || i2 == 14)) {
                return false;
            }
        } else if (Objects.equals(format.sampleMimeType, "video/hevc")) {
            Ac4Util$SyncFrameInfo h265NalHeader = parseH265NalHeader(new WavFormat(bArr, 4, i + 4));
            int i3 = h265NalHeader.sampleRate;
            if (i3 == 35) {
                return false;
            }
            if (i3 <= 14 && i3 % 2 == 0 && h265NalHeader.sampleCount == format.maxSubLayers - 1) {
                return false;
            }
        }
        return true;
    }

    public static int numberOfBytesInNalUnitHeader(Format format) {
        String nalStructureMimeType = getNalStructureMimeType(format);
        if (Objects.equals(nalStructureMimeType, "video/avc")) {
            return 1;
        }
        return (Objects.equals(nalStructureMimeType, "video/hevc") || Objects.equals(nalStructureMimeType, "video/vvc")) ? 2 : 0;
    }

    public static Ac4Util$SyncFrameInfo parseH265NalHeader(WavFormat wavFormat) {
        wavFormat.skipBit();
        return new Ac4Util$SyncFrameInfo(wavFormat.readBits(6), wavFormat.readBits(6), wavFormat.readBits(3) - 1);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0064  */
    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e A[SYNTHETIC] */
    public static NalUnitUtil$H265ProfileTierLevel parseH265ProfileTierLevel(WavFormat wavFormat, boolean z, int i, NalUnitUtil$H265ProfileTierLevel nalUnitUtil$H265ProfileTierLevel) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean bit;
        int bits;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        if (!z) {
            if (nalUnitUtil$H265ProfileTierLevel != null) {
                int i7 = nalUnitUtil$H265ProfileTierLevel.generalProfileSpace;
                bit = nalUnitUtil$H265ProfileTierLevel.generalTierFlag;
                bits = nalUnitUtil$H265ProfileTierLevel.generalProfileIdc;
                i5 = nalUnitUtil$H265ProfileTierLevel.generalProfileCompatibilityFlags;
                iArr2 = nalUnitUtil$H265ProfileTierLevel.constraintBytes;
                i2 = i7;
            } else {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
            }
            int bits2 = wavFormat.readBits(8);
            i6 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                if (wavFormat.readBit()) {
                    i6 += 88;
                }
                if (wavFormat.readBit()) {
                    i6 += 8;
                }
            }
            wavFormat.skipBits(i6);
            if (i > 0) {
                wavFormat.skipBits((8 - i) * 2);
            }
            return new NalUnitUtil$H265ProfileTierLevel(i2, z2, i3, i4, iArr, bits2);
        }
        int bits3 = wavFormat.readBits(2);
        bit = wavFormat.readBit();
        bits = wavFormat.readBits(5);
        i5 = 0;
        for (int i9 = 0; i9 < 32; i9++) {
            if (wavFormat.readBit()) {
                i5 |= 1 << i9;
            }
        }
        for (int i10 = 0; i10 < 6; i10++) {
            iArr2[i10] = wavFormat.readBits(8);
        }
        i2 = bits3;
        iArr = iArr2;
        z2 = bit;
        i3 = bits;
        i4 = i5;
        int bits4 = wavFormat.readBits(8);
        i6 = 0;
        while (i8 < i) {
            if (wavFormat.readBit()) {
                i6 += 88;
            }
            if (wavFormat.readBit()) {
                i6 += 8;
            }
        }
        wavFormat.skipBits(i6);
        if (i > 0) {
            wavFormat.skipBits((8 - i) * 2);
        }
        return new NalUnitUtil$H265ProfileTierLevel(i2, z2, i3, i4, iArr, bits4);
    }

    public static MimeTypes.Mp4aObjectType parseH265Sei3dRefDisplayInfo(byte[] bArr, int i, int i2) {
        byte b;
        int i3 = i + 2;
        do {
            i2--;
            b = bArr[i2];
            if (b != 0) {
                break;
            }
        } while (i2 > i3);
        if (b == 0 || i2 <= i3) {
            return null;
        }
        WavFormat wavFormat = new WavFormat(bArr, i3, i2 + 1);
        while (wavFormat.canReadBits(16)) {
            int bits = wavFormat.readBits(8);
            int i4 = 0;
            while (bits == 255) {
                i4 += 255;
                bits = wavFormat.readBits(8);
            }
            int i5 = i4 + bits;
            int bits2 = wavFormat.readBits(8);
            int i6 = 0;
            while (bits2 == 255) {
                i6 += 255;
                bits2 = wavFormat.readBits(8);
            }
            int i7 = i6 + bits2;
            if (i7 == 0 || !wavFormat.canReadBits(i7)) {
                return null;
            }
            if (i5 == 176) {
                int expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                boolean bit = wavFormat.readBit();
                int expGolombCodeNum2 = bit ? wavFormat.readExpGolombCodeNum() : 0;
                int expGolombCodeNum3 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum4 = -1;
                for (int i8 = 0; i8 <= expGolombCodeNum3; i8++) {
                    expGolombCodeNum4 = wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                    int bits3 = wavFormat.readBits(6);
                    if (bits3 == 63) {
                        return null;
                    }
                    wavFormat.readBits(bits3 == 0 ? Math.max(0, expGolombCodeNum - 30) : Math.max(0, (bits3 + expGolombCodeNum) - 31));
                    if (bit) {
                        int bits4 = wavFormat.readBits(6);
                        if (bits4 == 63) {
                            return null;
                        }
                        wavFormat.readBits(bits4 == 0 ? Math.max(0, expGolombCodeNum2 - 30) : Math.max(0, (bits4 + expGolombCodeNum2) - 31));
                    }
                    if (wavFormat.readBit()) {
                        wavFormat.skipBits(10);
                    }
                }
                return new MimeTypes.Mp4aObjectType(expGolombCodeNum4);
            }
            wavFormat.skipBits(i7 * 8);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004a  */
    /* JADX WARN: Code duplicated, block: B:202:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    public static NalUnitUtil$H265SpsData parseH265SpsNalUnit(byte[] bArr, int i, int i2, Dispatcher dispatcher) {
        int i3;
        int i4;
        int i5;
        int i6;
        int expGolombCodeNum;
        int i7;
        int expGolombCodeNum2;
        int i8;
        int i9;
        int iMax;
        int i10;
        int i11;
        int i12;
        int iIsoColorPrimariesToColorSpace;
        int iIsoTransferCharacteristicsToColorTransfer;
        int i13;
        NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices;
        WeakCache weakCache;
        Ac4Util$SyncFrameInfo h265NalHeader = parseH265NalHeader(new WavFormat(bArr, i, i2));
        WavFormat wavFormat = new WavFormat(bArr, i + 2, i2);
        int i14 = 4;
        wavFormat.skipBits(4);
        int bits = wavFormat.readBits(3);
        int i15 = h265NalHeader.frameSize;
        boolean z = i15 != 0 && bits == 7;
        if (dispatcher != null) {
            ImmutableList immutableList = (ImmutableList) dispatcher.executorServiceOrNull;
            if (immutableList.isEmpty()) {
                i3 = 0;
            } else {
                i3 = ((NalUnitUtil$H265LayerInfo) immutableList.get(Math.min(i15, immutableList.size() - 1))).layerIdInVps;
            }
        } else {
            i3 = 0;
        }
        NalUnitUtil$H265ProfileTierLevel h265ProfileTierLevel = null;
        if (!z) {
            wavFormat.skipBit();
            h265ProfileTierLevel = parseH265ProfileTierLevel(wavFormat, true, bits, null);
        } else if (dispatcher != null) {
            NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices2 = (NalUnitUtil$H265VideoSignalInfosAndIndices) dispatcher.readyAsyncCalls;
            int[] iArr = nalUnitUtil$H265VideoSignalInfosAndIndices2.indices;
            ImmutableList immutableList2 = nalUnitUtil$H265VideoSignalInfosAndIndices2.videoSignalInfos;
            int i16 = iArr[i3];
            if (immutableList2.size() > i16) {
                h265ProfileTierLevel = (NalUnitUtil$H265ProfileTierLevel) immutableList2.get(i16);
            }
        }
        wavFormat.readExpGolombCodeNum();
        if (z) {
            int bits2 = wavFormat.readBit() ? wavFormat.readBits(8) : -1;
            if (dispatcher == null || (weakCache = (WeakCache) dispatcher.runningAsyncCalls) == null) {
                expGolombCodeNum = 0;
                expGolombCodeNum2 = 0;
                i7 = 0;
                i9 = 0;
                i6 = 0;
                i8 = 0;
            } else {
                ImmutableList immutableList3 = (ImmutableList) weakCache.values;
                if (bits2 == -1) {
                    bits2 = ((int[]) weakCache.referenceQueue)[i3];
                }
                if (bits2 == -1 || immutableList3.size() <= bits2) {
                    expGolombCodeNum = 0;
                    expGolombCodeNum2 = 0;
                    i7 = 0;
                    i9 = 0;
                    i6 = 0;
                    i8 = 0;
                } else {
                    NalUnitUtil$H265RepFormat nalUnitUtil$H265RepFormat = (NalUnitUtil$H265RepFormat) immutableList3.get(bits2);
                    int i17 = nalUnitUtil$H265RepFormat.chromaFormatIdc;
                    i7 = nalUnitUtil$H265RepFormat.width;
                    int i18 = nalUnitUtil$H265RepFormat.height;
                    expGolombCodeNum = nalUnitUtil$H265RepFormat.bitDepthLumaMinus8;
                    expGolombCodeNum2 = nalUnitUtil$H265RepFormat.bitDepthChromaMinus8;
                    i6 = i18;
                    i8 = i6;
                    i9 = i7;
                }
            }
        } else {
            int expGolombCodeNum3 = wavFormat.readExpGolombCodeNum();
            if (expGolombCodeNum3 == 3) {
                wavFormat.skipBit();
            }
            int expGolombCodeNum4 = wavFormat.readExpGolombCodeNum();
            int expGolombCodeNum5 = wavFormat.readExpGolombCodeNum();
            if (wavFormat.readBit()) {
                int expGolombCodeNum6 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum7 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum8 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum9 = wavFormat.readExpGolombCodeNum();
                i4 = expGolombCodeNum4 - ((expGolombCodeNum6 + expGolombCodeNum7) * ((expGolombCodeNum3 == 1 || expGolombCodeNum3 == 2) ? 2 : 1));
                i5 = expGolombCodeNum5 - ((expGolombCodeNum8 + expGolombCodeNum9) * (expGolombCodeNum3 == 1 ? 2 : 1));
            } else {
                i4 = expGolombCodeNum4;
                i5 = expGolombCodeNum5;
            }
            i6 = i5;
            expGolombCodeNum = wavFormat.readExpGolombCodeNum();
            i7 = i4;
            expGolombCodeNum2 = wavFormat.readExpGolombCodeNum();
            i8 = expGolombCodeNum5;
            i9 = expGolombCodeNum4;
        }
        int expGolombCodeNum10 = wavFormat.readExpGolombCodeNum();
        if (z) {
            iMax = -1;
        } else {
            iMax = -1;
            for (int i19 = wavFormat.readBit() ? 0 : bits; i19 <= bits; i19++) {
                wavFormat.readExpGolombCodeNum();
                iMax = Math.max(wavFormat.readExpGolombCodeNum(), iMax);
                wavFormat.readExpGolombCodeNum();
            }
        }
        wavFormat.readExpGolombCodeNum();
        wavFormat.readExpGolombCodeNum();
        wavFormat.readExpGolombCodeNum();
        wavFormat.readExpGolombCodeNum();
        wavFormat.readExpGolombCodeNum();
        wavFormat.readExpGolombCodeNum();
        if (wavFormat.readBit()) {
            int i20 = 6;
            if (z ? wavFormat.readBit() : false) {
                wavFormat.skipBits(6);
            } else if (wavFormat.readBit()) {
                int i21 = 0;
                while (i21 < i14) {
                    int i22 = 0;
                    while (i22 < i20) {
                        if (wavFormat.readBit()) {
                            int iMin = Math.min(64, 1 << ((i21 << 1) + 4));
                            if (i21 > 1) {
                                wavFormat.readSignedExpGolombCodedInt();
                            }
                            for (int i23 = 0; i23 < iMin; i23++) {
                                wavFormat.readSignedExpGolombCodedInt();
                            }
                        } else {
                            wavFormat.readExpGolombCodeNum();
                        }
                        i22 += i21 == 3 ? 3 : 1;
                        i20 = 6;
                    }
                    i21++;
                    i14 = 4;
                    i20 = 6;
                }
            }
        }
        wavFormat.skipBits(2);
        if (wavFormat.readBit()) {
            wavFormat.skipBits(8);
            wavFormat.readExpGolombCodeNum();
            wavFormat.readExpGolombCodeNum();
            wavFormat.skipBit();
        }
        int expGolombCodeNum11 = wavFormat.readExpGolombCodeNum();
        int[] iArr2 = new int[0];
        int[] iArrCopyOf = new int[0];
        int i24 = 0;
        int expGolombCodeNum12 = -1;
        int i25 = -1;
        while (i24 < expGolombCodeNum11) {
            if (i24 == 0 || !wavFormat.readBit()) {
                int expGolombCodeNum13 = wavFormat.readExpGolombCodeNum();
                expGolombCodeNum12 = wavFormat.readExpGolombCodeNum();
                int[] iArr3 = new int[expGolombCodeNum13];
                int i26 = 0;
                while (i26 < expGolombCodeNum13) {
                    iArr3[i26] = (i26 > 0 ? iArr3[i26 - 1] : 0) - (wavFormat.readExpGolombCodeNum() + 1);
                    wavFormat.skipBit();
                    i26++;
                }
                int[] iArr4 = new int[expGolombCodeNum12];
                int i27 = 0;
                while (i27 < expGolombCodeNum12) {
                    iArr4[i27] = wavFormat.readExpGolombCodeNum() + 1 + (i27 > 0 ? iArr4[i27 - 1] : 0);
                    wavFormat.skipBit();
                    i27++;
                }
                i25 = expGolombCodeNum13;
                iArr2 = iArr3;
                iArrCopyOf = iArr4;
            } else {
                int i28 = i25 + expGolombCodeNum12;
                int expGolombCodeNum14 = (1 - ((wavFormat.readBit() ? 1 : 0) * 2)) * (wavFormat.readExpGolombCodeNum() + 1);
                int i29 = i28 + 1;
                boolean[] zArr = new boolean[i29];
                for (int i30 = 0; i30 <= i28; i30++) {
                    if (wavFormat.readBit()) {
                        zArr[i30] = true;
                    } else {
                        zArr[i30] = wavFormat.readBit();
                    }
                }
                int[] iArr5 = new int[i29];
                int[] iArr6 = new int[i29];
                int i31 = 0;
                for (int i32 = expGolombCodeNum12 - 1; i32 >= 0; i32--) {
                    int i33 = iArrCopyOf[i32] + expGolombCodeNum14;
                    if (i33 < 0 && zArr[i25 + i32]) {
                        iArr5[i31] = i33;
                        i31++;
                    }
                }
                if (expGolombCodeNum14 < 0 && zArr[i28]) {
                    iArr5[i31] = expGolombCodeNum14;
                    i31++;
                }
                int i34 = i31;
                int[] iArr7 = iArr2;
                for (int i35 = 0; i35 < i25; i35++) {
                    int i36 = iArr7[i35] + expGolombCodeNum14;
                    if (i36 < 0 && zArr[i35]) {
                        iArr5[i34] = i36;
                        i34++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr5, i34);
                int i37 = 0;
                for (int i38 = i25 - 1; i38 >= 0; i38--) {
                    int i39 = iArr7[i38] + expGolombCodeNum14;
                    if (i39 > 0 && zArr[i38]) {
                        iArr6[i37] = i39;
                        i37++;
                    }
                }
                if (expGolombCodeNum14 > 0 && zArr[i28]) {
                    iArr6[i37] = expGolombCodeNum14;
                    i37++;
                }
                int i40 = i34;
                int i41 = i37;
                for (int i42 = 0; i42 < expGolombCodeNum12; i42++) {
                    int i43 = iArrCopyOf[i42] + expGolombCodeNum14;
                    if (i43 > 0 && zArr[i25 + i42]) {
                        iArr6[i41] = i43;
                        i41++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr6, i41);
                expGolombCodeNum12 = i41;
                i25 = i40;
                iArr2 = iArrCopyOf2;
            }
            i24++;
            expGolombCodeNum11 = expGolombCodeNum11;
            i3 = i3;
        }
        int i44 = i3;
        if (wavFormat.readBit()) {
            int expGolombCodeNum15 = wavFormat.readExpGolombCodeNum();
            for (int i45 = 0; i45 < expGolombCodeNum15; i45++) {
                wavFormat.skipBits(expGolombCodeNum10 + 5);
            }
        }
        wavFormat.skipBits(2);
        float f = 1.0f;
        if (wavFormat.readBit()) {
            if (wavFormat.readBit()) {
                int bits3 = wavFormat.readBits(8);
                if (bits3 == 255) {
                    int bits4 = wavFormat.readBits(16);
                    int bits5 = wavFormat.readBits(16);
                    if (bits4 != 0 && bits5 != 0) {
                        f = bits4 / bits5;
                    }
                } else if (bits3 < 17) {
                    f = ASPECT_RATIO_IDC_VALUES[bits3];
                } else {
                    Format$$ExternalSyntheticOutline0.m(bits3, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                }
            }
            if (wavFormat.readBit()) {
                wavFormat.skipBit();
            }
            if (wavFormat.readBit()) {
                wavFormat.skipBits(3);
                i13 = wavFormat.readBit() ? 1 : 2;
                if (wavFormat.readBit()) {
                    int bits6 = wavFormat.readBits(8);
                    int bits7 = wavFormat.readBits(8);
                    wavFormat.skipBits(8);
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits6);
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits7);
                } else {
                    iIsoColorPrimariesToColorSpace = -1;
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
            } else if (dispatcher == null || (nalUnitUtil$H265VideoSignalInfosAndIndices = (NalUnitUtil$H265VideoSignalInfosAndIndices) dispatcher.runningSyncCalls) == null) {
                iIsoColorPrimariesToColorSpace = -1;
                iIsoTransferCharacteristicsToColorTransfer = -1;
                i13 = -1;
            } else {
                ImmutableList immutableList4 = nalUnitUtil$H265VideoSignalInfosAndIndices.videoSignalInfos;
                int i46 = nalUnitUtil$H265VideoSignalInfosAndIndices.indices[i44];
                if (immutableList4.size() > i46) {
                    NalUnitUtil$H265VideoSignalInfo nalUnitUtil$H265VideoSignalInfo = (NalUnitUtil$H265VideoSignalInfo) immutableList4.get(i46);
                    int i47 = nalUnitUtil$H265VideoSignalInfo.colorSpace;
                    int i48 = nalUnitUtil$H265VideoSignalInfo.colorRange;
                    iIsoTransferCharacteristicsToColorTransfer = nalUnitUtil$H265VideoSignalInfo.colorTransfer;
                    iIsoColorPrimariesToColorSpace = i47;
                    i13 = i48;
                } else {
                    iIsoColorPrimariesToColorSpace = -1;
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                    i13 = -1;
                }
            }
            if (wavFormat.readBit()) {
                wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
            }
            wavFormat.skipBit();
            if (wavFormat.readBit()) {
                i6 *= 2;
            }
            i10 = iIsoColorPrimariesToColorSpace;
            i12 = iIsoTransferCharacteristicsToColorTransfer;
            i11 = i13;
        } else {
            i10 = -1;
            i11 = -1;
            i12 = -1;
        }
        return new NalUnitUtil$H265SpsData(bits, h265ProfileTierLevel, expGolombCodeNum, expGolombCodeNum2, i7, i6, i9, i8, f, iMax, i10, i11, i12);
    }

    /* JADX WARN: Code duplicated, block: B:481:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0116  */
    /* JADX WARN: Code duplicated, block: B:62:0x011c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0122  */
    /* JADX WARN: Code duplicated, block: B:65:0x0128  */
    /* JADX WARN: Code duplicated, block: B:67:0x012e  */
    /* JADX WARN: Code duplicated, block: B:69:0x013b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0146  */
    /* JADX WARN: Code duplicated, block: B:74:0x014b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0153  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Dispatcher parseH265VpsNalUnit(byte[] bArr, int i, int i2) {
        int[] iArr;
        NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices;
        int bits;
        int bits2;
        int bits3;
        RegularImmutableList regularImmutableList;
        boolean[][] zArr;
        int i3;
        boolean[][] zArr2;
        int[] iArr2;
        int[] iArr3;
        int i4;
        boolean bit;
        int i5;
        int i6;
        int i7;
        boolean bit2;
        boolean bit3;
        int expGolombCodeNum;
        int i8;
        int i9;
        int i10;
        boolean z;
        boolean z2;
        WavFormat wavFormat = new WavFormat(bArr, i, i2);
        parseH265NalHeader(wavFormat);
        wavFormat.skipBits(4);
        boolean bit4 = wavFormat.readBit();
        boolean bit5 = wavFormat.readBit();
        int bits4 = wavFormat.readBits(6);
        int i11 = bits4 + 1;
        int bits5 = wavFormat.readBits(3);
        wavFormat.skipBits(17);
        NalUnitUtil$H265ProfileTierLevel h265ProfileTierLevel = parseH265ProfileTierLevel(wavFormat, true, bits5, null);
        for (int i12 = wavFormat.readBit() ? 0 : bits5; i12 <= bits5; i12++) {
            wavFormat.readExpGolombCodeNum();
            wavFormat.readExpGolombCodeNum();
            wavFormat.readExpGolombCodeNum();
        }
        int bits6 = wavFormat.readBits(6);
        int expGolombCodeNum2 = wavFormat.readExpGolombCodeNum() + 1;
        int i13 = 6;
        NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices2 = new NalUnitUtil$H265VideoSignalInfosAndIndices(ImmutableList.of((Object) h265ProfileTierLevel), new int[1], (byte) 1);
        boolean z3 = i11 >= 2 && expGolombCodeNum2 >= 2;
        boolean z4 = bit4 && bit5;
        int i14 = bits6 + 1;
        boolean z5 = i14 >= i11;
        if (!z3 || !z4 || !z5) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        Class cls = Integer.TYPE;
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) cls, expGolombCodeNum2, i14);
        int i15 = 1;
        int[] iArr5 = new int[expGolombCodeNum2];
        int[] iArr6 = new int[expGolombCodeNum2];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i16 = 1; i16 < expGolombCodeNum2; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 <= bits6; i18++) {
                if (wavFormat.readBit()) {
                    iArr4[i16][i17] = i18;
                    iArr6[i16] = i18;
                    i17++;
                }
                iArr5[i16] = i17;
            }
        }
        if (wavFormat.readBit()) {
            wavFormat.skipBits(64);
            if (wavFormat.readBit()) {
                wavFormat.readExpGolombCodeNum();
            }
            int expGolombCodeNum3 = wavFormat.readExpGolombCodeNum();
            int i19 = 0;
            while (i19 < expGolombCodeNum3) {
                wavFormat.readExpGolombCodeNum();
                if (i19 == 0 || wavFormat.readBit()) {
                    boolean bit6 = wavFormat.readBit();
                    boolean bit7 = wavFormat.readBit();
                    z2 = bit6;
                    z = bit7;
                    if (bit6 || bit7) {
                        bit = wavFormat.readBit();
                        if (bit) {
                            wavFormat.skipBits(19);
                        }
                        wavFormat.skipBits(8);
                        if (bit) {
                            wavFormat.skipBits(4);
                        }
                        wavFormat.skipBits(15);
                        i6 = bit6;
                        i5 = bit7;
                    }
                    i7 = 0;
                    while (i7 <= bits5) {
                        bit2 = wavFormat.readBit();
                        if (!bit2) {
                            bit2 = wavFormat.readBit();
                        }
                        if (bit2) {
                            wavFormat.readExpGolombCodeNum();
                            bit3 = false;
                        } else {
                            bit3 = wavFormat.readBit();
                        }
                        if (bit3) {
                            expGolombCodeNum = 0;
                        } else {
                            expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                        }
                        int[][] iArr7 = iArr4;
                        i8 = i6 + i5;
                        int[] iArr8 = iArr6;
                        i9 = 0;
                        while (i9 < i8) {
                            int i20 = i8;
                            for (i10 = 0; i10 <= expGolombCodeNum; i10++) {
                                wavFormat.readExpGolombCodeNum();
                                wavFormat.readExpGolombCodeNum();
                                if (bit) {
                                    wavFormat.readExpGolombCodeNum();
                                    wavFormat.readExpGolombCodeNum();
                                }
                                wavFormat.skipBit();
                            }
                            i9++;
                            i8 = i20;
                        }
                        i7++;
                        i19 = i19;
                        iArr4 = iArr7;
                        iArr6 = iArr8;
                    }
                    i19++;
                } else {
                    z2 = false;
                    z = false;
                }
                bit = false;
                i6 = z2;
                i5 = z;
                i7 = 0;
                while (i7 <= bits5) {
                    bit2 = wavFormat.readBit();
                    if (!bit2) {
                        bit2 = wavFormat.readBit();
                    }
                    if (bit2) {
                        wavFormat.readExpGolombCodeNum();
                        bit3 = false;
                    } else {
                        bit3 = wavFormat.readBit();
                    }
                    if (bit3) {
                        expGolombCodeNum = wavFormat.readExpGolombCodeNum();
                    } else {
                        expGolombCodeNum = 0;
                    }
                    int[][] iArr9 = iArr4;
                    i8 = i6 + i5;
                    int[] iArr10 = iArr6;
                    i9 = 0;
                    while (i9 < i8) {
                        int i21 = i8;
                        while (i10 <= expGolombCodeNum) {
                            wavFormat.readExpGolombCodeNum();
                            wavFormat.readExpGolombCodeNum();
                            if (bit) {
                                wavFormat.readExpGolombCodeNum();
                                wavFormat.readExpGolombCodeNum();
                            }
                            wavFormat.skipBit();
                        }
                        i9++;
                        i8 = i21;
                    }
                    i7++;
                    i19 = i19;
                    iArr4 = iArr9;
                    iArr6 = iArr10;
                }
                i19++;
            }
        }
        int[][] iArr11 = iArr4;
        int[] iArr12 = iArr6;
        if (!wavFormat.readBit()) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int i22 = wavFormat.bitsPerSample;
        if (i22 > 0) {
            wavFormat.skipBits(8 - i22);
        }
        NalUnitUtil$H265ProfileTierLevel h265ProfileTierLevel2 = parseH265ProfileTierLevel(wavFormat, false, bits5, h265ProfileTierLevel);
        boolean bit8 = wavFormat.readBit();
        boolean[] zArr3 = new boolean[16];
        int i23 = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            boolean bit9 = wavFormat.readBit();
            zArr3[i24] = bit9;
            if (bit9) {
                i23++;
            }
        }
        if (i23 == 0 || !zArr3[1]) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int[] iArr13 = new int[i23];
        for (int i25 = 0; i25 < i23 - (bit8 ? 1 : 0); i25++) {
            iArr13[i25] = wavFormat.readBits(3);
        }
        int[] iArr14 = new int[i23 + 1];
        if (bit8) {
            int i26 = 1;
            while (i26 < i23) {
                int[] iArr15 = iArr14;
                for (int i27 = 0; i27 < i26; i27++) {
                    iArr15[i26] = iArr13[i27] + 1 + iArr15[i26];
                }
                i26++;
                iArr14 = iArr15;
            }
            iArr = iArr14;
            iArr[i23] = 6;
        } else {
            iArr = iArr14;
        }
        int[][] iArr16 = (int[][]) Array.newInstance((Class<?>) cls, i11, i23);
        int[] iArr17 = new int[i11];
        iArr17[0] = 0;
        boolean bit10 = wavFormat.readBit();
        int i28 = 1;
        while (i28 < i11) {
            if (bit10) {
                i4 = i28;
                iArr17[i4] = wavFormat.readBits(i13);
            } else {
                i4 = i28;
                iArr17[i4] = i4;
            }
            if (bit8) {
                int i29 = 0;
                while (i29 < i23) {
                    int i30 = i29 + 1;
                    iArr16[i4][i29] = (iArr17[i4] & ((1 << iArr[i30]) - 1)) >> iArr[i29];
                    i29 = i30;
                }
            } else {
                int i31 = 0;
                while (i31 < i23) {
                    int i32 = i31;
                    iArr16[i4][i32] = wavFormat.readBits(iArr13[i31] + 1);
                    i31 = i32 + 1;
                }
            }
            i28 = i4 + 1;
            i13 = 6;
        }
        int[] iArr18 = new int[i14];
        int i33 = 1;
        int i34 = 0;
        while (i34 < i11) {
            iArr18[iArr17[i34]] = -1;
            int[] iArr19 = iArr18;
            int i35 = 0;
            int i36 = 0;
            while (i35 < 16) {
                if (zArr3[i35]) {
                    if (i35 == i15) {
                        iArr19[iArr17[i34]] = iArr16[i34][i36];
                    }
                    i36++;
                }
                i35++;
                i15 = 1;
            }
            if (i34 > 0) {
                int i37 = 0;
                while (true) {
                    if (i37 >= i34) {
                        i33++;
                        break;
                    }
                    int i38 = i37;
                    if (iArr19[iArr17[i34]] == iArr19[iArr17[i37]]) {
                        break;
                    }
                    i37 = i38 + 1;
                }
            }
            i34++;
            iArr18 = iArr19;
            i15 = 1;
        }
        int[] iArr20 = iArr18;
        int bits7 = wavFormat.readBits(4);
        if (i33 < 2 || bits7 == 0) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int[] iArr21 = new int[i33];
        for (int i39 = 0; i39 < i33; i39++) {
            iArr21[i39] = wavFormat.readBits(bits7);
        }
        int[] iArr22 = new int[i14];
        for (int i40 = 0; i40 < i11; i40++) {
            iArr22[Math.min(iArr17[i40], bits6)] = i40;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int i41 = 0;
        while (i41 <= bits6) {
            int[] iArr23 = iArr22;
            int i42 = i33;
            int iMin = Math.min(iArr20[i41], i42 - 1);
            builder.add((Object) new NalUnitUtil$H265LayerInfo(iArr23[i41], iMin >= 0 ? iArr21[iMin] : -1));
            i41++;
            iArr22 = iArr23;
            iArr17 = iArr17;
            i33 = i42;
        }
        int[] iArr24 = iArr17;
        RegularImmutableList regularImmutableListBuild = builder.build();
        if (((NalUnitUtil$H265LayerInfo) regularImmutableListBuild.get(0)).viewId == -1) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int i43 = 1;
        while (true) {
            if (i43 > bits6) {
                i43 = -1;
                break;
            }
            if (((NalUnitUtil$H265LayerInfo) regularImmutableListBuild.get(i43)).viewId != -1) {
                break;
            }
            i43++;
        }
        if (i43 == -1) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        Class cls2 = Boolean.TYPE;
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls2, i11, i11);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) cls2, i11, i11);
        for (int i44 = 1; i44 < i11; i44++) {
            for (int i45 = 0; i45 < i44; i45++) {
                boolean[] zArr6 = zArr4[i44];
                boolean[] zArr7 = zArr5[i44];
                boolean bit11 = wavFormat.readBit();
                zArr7[i45] = bit11;
                zArr6[i45] = bit11;
            }
        }
        for (int i46 = 1; i46 < i11; i46++) {
            int i47 = 0;
            while (i47 < bits4) {
                boolean[][] zArr8 = zArr4;
                for (int i48 = 0; i48 < i46; i48++) {
                    boolean[] zArr9 = zArr5[i46];
                    if (zArr9[i48] && zArr5[i48][i47]) {
                        zArr9[i47] = true;
                        break;
                    }
                }
                i47++;
                zArr4 = zArr8;
            }
        }
        boolean[][] zArr10 = zArr4;
        int[] iArr25 = new int[i14];
        for (int i49 = 0; i49 < i11; i49++) {
            int i50 = 0;
            for (int i51 = 0; i51 < i49; i51++) {
                i50 += zArr10[i49][i51] ? 1 : 0;
            }
            iArr25[iArr24[i49]] = i50;
        }
        int i52 = 0;
        for (int i53 = 0; i53 < i11; i53++) {
            if (iArr25[iArr24[i53]] == 0) {
                i52++;
            }
        }
        if (i52 > 1) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int[] iArr26 = new int[i11];
        int[] iArr27 = new int[expGolombCodeNum2];
        if (wavFormat.readBit()) {
            int i54 = 0;
            while (i54 < i11) {
                int i55 = i54;
                iArr26[i55] = wavFormat.readBits(3);
                i54 = i55 + 1;
            }
        } else {
            Arrays.fill(iArr26, 0, i11, bits5);
        }
        int i56 = 0;
        while (i56 < expGolombCodeNum2) {
            int i57 = i56;
            boolean[][] zArr11 = zArr5;
            int[] iArr28 = iArr26;
            int iMax = 0;
            for (int i58 = 0; i58 < iArr5[i57]; i58++) {
                iMax = Math.max(iMax, iArr28[((NalUnitUtil$H265LayerInfo) regularImmutableListBuild.get(iArr11[i57][i58])).layerIdInVps]);
            }
            iArr27[i57] = iMax + 1;
            i56 = i57 + 1;
            zArr5 = zArr11;
            iArr26 = iArr28;
        }
        boolean[][] zArr12 = zArr5;
        if (wavFormat.readBit()) {
            int i59 = 0;
            while (i59 < bits4) {
                int i60 = i59 + 1;
                int i61 = i60;
                while (i61 < i11) {
                    if (zArr10[i61][i59]) {
                        wavFormat.skipBits(3);
                    }
                    i61++;
                    bits4 = bits4;
                }
                i59 = i60;
            }
        }
        wavFormat.skipBit();
        int expGolombCodeNum4 = wavFormat.readExpGolombCodeNum() + 1;
        ImmutableList.Builder builder2 = ImmutableList.builder();
        builder2.add((Object) h265ProfileTierLevel);
        if (expGolombCodeNum4 > 1) {
            builder2.add((Object) h265ProfileTierLevel2);
            for (int i62 = 2; i62 < expGolombCodeNum4; i62++) {
                h265ProfileTierLevel2 = parseH265ProfileTierLevel(wavFormat, wavFormat.readBit(), bits5, h265ProfileTierLevel2);
                builder2.add((Object) h265ProfileTierLevel2);
            }
        }
        RegularImmutableList regularImmutableListBuild2 = builder2.build();
        int expGolombCodeNum5 = wavFormat.readExpGolombCodeNum() + expGolombCodeNum2;
        if (expGolombCodeNum5 > expGolombCodeNum2) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int bits8 = wavFormat.readBits(2);
        boolean[][] zArr13 = (boolean[][]) Array.newInstance((Class<?>) cls2, expGolombCodeNum5, i14);
        int[] iArr29 = new int[expGolombCodeNum5];
        int i63 = 0;
        int[] iArr30 = new int[expGolombCodeNum5];
        int i64 = 0;
        while (i64 < expGolombCodeNum2) {
            iArr29[i64] = i63;
            iArr30[i64] = iArr12[i64];
            if (bits8 == 0) {
                i3 = i64;
                zArr2 = zArr13;
                iArr2 = iArr29;
                iArr3 = iArr27;
                Arrays.fill(zArr13[i3], i63, iArr5[i3], true);
                iArr2[i3] = iArr5[i3];
            } else {
                i3 = i64;
                zArr2 = zArr13;
                iArr2 = iArr29;
                iArr3 = iArr27;
                if (bits8 == 1) {
                    int i65 = iArr12[i3];
                    for (int i66 = 0; i66 < iArr5[i3]; i66++) {
                        zArr2[i3][i66] = iArr11[i3][i66] == i65;
                    }
                    iArr2[i3] = 1;
                } else {
                    i63 = 0;
                    zArr2[0][0] = true;
                    iArr2[0] = 1;
                }
                i64 = i3 + 1;
                zArr13 = zArr2;
                iArr29 = iArr2;
                iArr27 = iArr3;
            }
            i63 = 0;
            i64 = i3 + 1;
            zArr13 = zArr2;
            iArr29 = iArr2;
            iArr27 = iArr3;
        }
        boolean[][] zArr14 = zArr13;
        int[] iArr31 = iArr29;
        int[] iArr32 = iArr27;
        int[] iArr33 = new int[i14];
        int i67 = 2;
        int[] iArr34 = new int[2];
        iArr34[1] = i14;
        iArr34[i63] = expGolombCodeNum5;
        boolean[][] zArr15 = (boolean[][]) Array.newInstance((Class<?>) cls2, iArr34);
        int i68 = 1;
        int i69 = 0;
        while (i68 < expGolombCodeNum5) {
            if (bits8 == i67) {
                for (int i70 = 0; i70 < iArr5[i68]; i70++) {
                    zArr14[i68][i70] = wavFormat.readBit();
                    int i71 = iArr31[i68];
                    boolean z6 = zArr14[i68][i70];
                    iArr31[i68] = i71 + (z6 ? 1 : 0);
                    if (z6) {
                        iArr30[i68] = iArr11[i68][i70];
                    }
                }
            }
            if (i69 == 0 && iArr11[i68][0] == 0 && zArr14[i68][0]) {
                for (int i72 = 1; i72 < iArr5[i68]; i72++) {
                    if (iArr11[i68][i72] == i43 && zArr14[i68][i43]) {
                        i69 = i68;
                    }
                }
            }
            int i73 = 0;
            while (i73 < iArr5[i68]) {
                if (expGolombCodeNum4 > 1) {
                    zArr15[i68][i73] = zArr14[i68][i73];
                    regularImmutableList = regularImmutableListBuild2;
                    zArr = zArr15;
                    RoundingMode roundingMode = RoundingMode.CEILING;
                    int iLog2 = DoubleMath.log2(expGolombCodeNum4);
                    if (!zArr[i68][i73]) {
                        int i74 = ((NalUnitUtil$H265LayerInfo) regularImmutableListBuild.get(iArr11[i68][i73])).layerIdInVps;
                        int i75 = 0;
                        while (i75 < i73) {
                            int i76 = i75;
                            if (zArr12[i74][((NalUnitUtil$H265LayerInfo) regularImmutableListBuild.get(iArr11[i68][i76])).layerIdInVps]) {
                                zArr[i68][i73] = true;
                                break;
                            }
                            i75 = i76 + 1;
                        }
                    }
                    if (zArr[i68][i73]) {
                        if (i69 <= 0 || i68 != i69) {
                            wavFormat.skipBits(iLog2);
                        } else {
                            iArr33[i73] = wavFormat.readBits(iLog2);
                        }
                    }
                } else {
                    regularImmutableList = regularImmutableListBuild2;
                    zArr = zArr15;
                }
                i73++;
                regularImmutableListBuild2 = regularImmutableList;
                zArr15 = zArr;
            }
            RegularImmutableList regularImmutableList2 = regularImmutableListBuild2;
            boolean[][] zArr16 = zArr15;
            if (iArr31[i68] == 1 && iArr25[iArr30[i68]] > 0) {
                wavFormat.skipBit();
            }
            i68++;
            regularImmutableListBuild2 = regularImmutableList2;
            zArr15 = zArr16;
            i67 = 2;
        }
        RegularImmutableList regularImmutableList3 = regularImmutableListBuild2;
        boolean[][] zArr17 = zArr15;
        if (i69 == 0) {
            return new Dispatcher((RegularImmutableList) null, nalUnitUtil$H265VideoSignalInfosAndIndices2, (WeakCache) null, (NalUnitUtil$H265VideoSignalInfosAndIndices) null);
        }
        int expGolombCodeNum6 = wavFormat.readExpGolombCodeNum();
        int i77 = expGolombCodeNum6 + 1;
        Maps.checkNonnegative(i77, "expectedSize");
        Maps.checkNonnegative(i77, "initialCapacity");
        int[] iArr35 = new int[i11];
        Object[] objArrCopyOf = new Object[i77];
        int i78 = 0;
        int i79 = 0;
        boolean z7 = false;
        while (i78 < i77) {
            int i80 = i78;
            int bits9 = wavFormat.readBits(16);
            int bits10 = wavFormat.readBits(16);
            boolean z8 = z7;
            if (wavFormat.readBit()) {
                bits = wavFormat.readBits(2);
                if (bits == 3) {
                    wavFormat.skipBit();
                }
                bits2 = wavFormat.readBits(4);
                bits3 = wavFormat.readBits(4);
            } else {
                bits = 0;
                bits2 = 0;
                bits3 = 0;
            }
            if (wavFormat.readBit()) {
                int expGolombCodeNum7 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum8 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum9 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum10 = wavFormat.readExpGolombCodeNum();
                bits9 -= (expGolombCodeNum7 + expGolombCodeNum8) * ((bits == 1 || bits == 2) ? 2 : 1);
                bits10 -= (expGolombCodeNum9 + expGolombCodeNum10) * (bits == 1 ? 2 : 1);
            }
            NalUnitUtil$H265RepFormat nalUnitUtil$H265RepFormat = new NalUnitUtil$H265RepFormat(bits, bits2, bits3, bits9, bits10);
            int iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i79 + 1);
            if (iExpandedCapacity > objArrCopyOf.length || z8) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                z7 = false;
            } else {
                z7 = z8;
            }
            objArrCopyOf[i79] = nalUnitUtil$H265RepFormat;
            i79++;
            i78 = i80 + 1;
        }
        if (i77 <= 1 || !wavFormat.readBit()) {
            for (int i81 = 1; i81 < i11; i81++) {
                iArr35[i81] = Math.min(i81, expGolombCodeNum6);
            }
        } else {
            RoundingMode roundingMode2 = RoundingMode.CEILING;
            int iLog3 = DoubleMath.log2(i77);
            for (int i82 = 1; i82 < i11; i82++) {
                iArr35[i82] = wavFormat.readBits(iLog3);
            }
        }
        WeakCache weakCache = new WeakCache(ImmutableList.asImmutableList(i79, objArrCopyOf), iArr35);
        wavFormat.skipBits(2);
        for (int i83 = 1; i83 < i11; i83++) {
            if (iArr25[iArr24[i83]] == 0) {
                wavFormat.skipBit();
            }
        }
        for (int i84 = 1; i84 < expGolombCodeNum5; i84++) {
            boolean bit12 = wavFormat.readBit();
            int i85 = 0;
            while (i85 < iArr32[i84]) {
                if ((i85 <= 0 || !bit12) ? i85 == 0 : wavFormat.readBit()) {
                    for (int i86 = 0; i86 < iArr5[i84]; i86++) {
                        if (zArr17[i84][i86]) {
                            wavFormat.readExpGolombCodeNum();
                        }
                    }
                    wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                }
                i85++;
            }
        }
        int expGolombCodeNum11 = wavFormat.readExpGolombCodeNum() + 2;
        if (wavFormat.readBit()) {
            wavFormat.skipBits(expGolombCodeNum11);
        } else {
            for (int i87 = 1; i87 < i11; i87++) {
                for (int i88 = 0; i88 < i87; i88++) {
                    if (zArr10[i87][i88]) {
                        wavFormat.skipBits(expGolombCodeNum11);
                    }
                }
            }
        }
        int expGolombCodeNum12 = wavFormat.readExpGolombCodeNum();
        for (int i89 = 1; i89 <= expGolombCodeNum12; i89++) {
            wavFormat.skipBits(8);
        }
        if (wavFormat.readBit()) {
            int i90 = wavFormat.bitsPerSample;
            if (i90 > 0) {
                wavFormat.skipBits(8 - i90);
            }
            if (!wavFormat.readBit() ? wavFormat.readBit() : true) {
                wavFormat.skipBit();
            }
            boolean bit13 = wavFormat.readBit();
            boolean bit14 = wavFormat.readBit();
            if (bit13 || bit14) {
                for (int i91 = 0; i91 < expGolombCodeNum2; i91++) {
                    for (int i92 = 0; i92 < iArr32[i91]; i92++) {
                        boolean bit15 = bit13 ? wavFormat.readBit() : false;
                        boolean bit16 = bit14 ? wavFormat.readBit() : false;
                        if (bit15) {
                            wavFormat.skipBits(32);
                        }
                        if (bit16) {
                            wavFormat.skipBits(18);
                        }
                    }
                }
            }
            boolean bit17 = wavFormat.readBit();
            int bits11 = bit17 ? wavFormat.readBits(4) + 1 : i11;
            Maps.checkNonnegative(bits11, "expectedSize");
            Maps.checkNonnegative(bits11, "initialCapacity");
            int[] iArr36 = new int[i11];
            Object[] objArrCopyOf2 = new Object[bits11];
            int i93 = 0;
            int i94 = 0;
            boolean z9 = false;
            while (i93 < bits11) {
                wavFormat.skipBits(3);
                int i95 = wavFormat.readBit() ? 1 : 2;
                int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(wavFormat.readBits(8));
                boolean z10 = bit17;
                int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(wavFormat.readBits(8));
                wavFormat.skipBits(8);
                NalUnitUtil$H265VideoSignalInfo nalUnitUtil$H265VideoSignalInfo = new NalUnitUtil$H265VideoSignalInfo(iIsoColorPrimariesToColorSpace, i95, iIsoTransferCharacteristicsToColorTransfer);
                int iExpandedCapacity2 = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf2.length, i94 + 1);
                if (iExpandedCapacity2 > objArrCopyOf2.length || z9) {
                    objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, iExpandedCapacity2);
                    z9 = false;
                }
                objArrCopyOf2[i94] = nalUnitUtil$H265VideoSignalInfo;
                i93++;
                i94++;
                bit17 = z10;
            }
            if (bit17 && bits11 > 1) {
                for (int i96 = 0; i96 < i11; i96++) {
                    iArr36[i96] = wavFormat.readBits(4);
                }
            }
            nalUnitUtil$H265VideoSignalInfosAndIndices = new NalUnitUtil$H265VideoSignalInfosAndIndices(ImmutableList.asImmutableList(i94, objArrCopyOf2), iArr36, (byte) 0);
        } else {
            nalUnitUtil$H265VideoSignalInfosAndIndices = null;
        }
        return new Dispatcher(regularImmutableListBuild, new NalUnitUtil$H265VideoSignalInfosAndIndices(regularImmutableList3, iArr33, (byte) 1), weakCache, nalUnitUtil$H265VideoSignalInfosAndIndices);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ae A[PHI: r19
      0x01ae: PHI (r19v6 float) = (r19v3 float), (r19v9 float), (r19v3 float), (r19v3 float), (r19v10 float) binds: [B:94:0x0190, B:104:0x01b5, B:98:0x01a6, B:99:0x01a8, B:100:0x01aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:102:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:104:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:113:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:114:0x01de  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:118:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:122:0x0208  */
    /* JADX WARN: Code duplicated, block: B:125:0x0214  */
    /* JADX WARN: Code duplicated, block: B:128:0x021f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0228  */
    /* JADX WARN: Code duplicated, block: B:134:0x022f  */
    /* JADX WARN: Code duplicated, block: B:137:0x023b  */
    /* JADX WARN: Code duplicated, block: B:139:0x0261  */
    /* JADX WARN: Code duplicated, block: B:61:0x011c  */
    /* JADX WARN: Code duplicated, block: B:64:0x012e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0140  */
    /* JADX WARN: Code duplicated, block: B:67:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0145  */
    /* JADX WARN: Code duplicated, block: B:69:0x0148  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:72:0x014f  */
    /* JADX WARN: Code duplicated, block: B:93:0x018c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0192  */
    /* JADX WARN: Code duplicated, block: B:97:0x019c  */
    public static NalUnitUtil$SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        int expGolombCodeNum;
        int expGolombCodeNum2;
        int i3;
        boolean z;
        int i4;
        int expGolombCodeNum3;
        boolean z2;
        boolean bit;
        int i5;
        int i6;
        int i7;
        int expGolombCodeNum4;
        int iIsoColorPrimariesToColorSpace;
        float f;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        int i12;
        int iIsoTransferCharacteristicsToColorTransfer;
        boolean bit2;
        boolean bit3;
        int bits;
        int bits2;
        int bits3;
        int i13;
        int i14;
        WavFormat wavFormat = new WavFormat(bArr, i + 1, i2);
        int bits4 = wavFormat.readBits(8);
        int bits5 = wavFormat.readBits(8);
        int bits6 = wavFormat.readBits(8);
        int expGolombCodeNum5 = wavFormat.readExpGolombCodeNum();
        if (bits4 == 100 || bits4 == 110 || bits4 == 122 || bits4 == 244 || bits4 == 44 || bits4 == 83 || bits4 == 86 || bits4 == 118 || bits4 == 128 || bits4 == 138) {
            expGolombCodeNum = wavFormat.readExpGolombCodeNum();
            boolean bit4 = expGolombCodeNum == 3 ? wavFormat.readBit() : false;
            int expGolombCodeNum6 = wavFormat.readExpGolombCodeNum();
            expGolombCodeNum2 = wavFormat.readExpGolombCodeNum();
            wavFormat.skipBit();
            if (wavFormat.readBit()) {
                int i15 = expGolombCodeNum != 3 ? 8 : 12;
                i3 = 16;
                int i16 = 0;
                while (i16 < i15) {
                    if (wavFormat.readBit()) {
                        int i17 = i16 < 6 ? 16 : 64;
                        int signedExpGolombCodedInt = 8;
                        int i18 = 8;
                        for (int i19 = 0; i19 < i17; i19++) {
                            if (signedExpGolombCodedInt != 0) {
                                signedExpGolombCodedInt = ((wavFormat.readSignedExpGolombCodedInt() + i18) + 256) % 256;
                            }
                            if (signedExpGolombCodedInt != 0) {
                                i18 = signedExpGolombCodedInt;
                            }
                        }
                    }
                    i16++;
                }
            } else {
                i3 = 16;
            }
            z = bit4;
            i4 = expGolombCodeNum6;
        } else {
            expGolombCodeNum = 1;
            i3 = 16;
            i4 = 0;
            z = false;
            expGolombCodeNum2 = 0;
        }
        int expGolombCodeNum7 = wavFormat.readExpGolombCodeNum() + 4;
        int expGolombCodeNum8 = wavFormat.readExpGolombCodeNum();
        if (expGolombCodeNum8 != 0) {
            if (expGolombCodeNum8 == 1) {
                boolean bit5 = wavFormat.readBit();
                wavFormat.readSignedExpGolombCodedInt();
                wavFormat.readSignedExpGolombCodedInt();
                bits4 = bits4;
                long expGolombCodeNum9 = wavFormat.readExpGolombCodeNum();
                expGolombCodeNum8 = expGolombCodeNum8;
                for (int i20 = 0; i20 < expGolombCodeNum9; i20++) {
                    wavFormat.readExpGolombCodeNum();
                }
                expGolombCodeNum2 = expGolombCodeNum2;
                z2 = bit5;
                expGolombCodeNum3 = 0;
            } else {
                expGolombCodeNum3 = 0;
            }
            wavFormat.readExpGolombCodeNum();
            wavFormat.skipBit();
            int expGolombCodeNum10 = wavFormat.readExpGolombCodeNum() + 1;
            int expGolombCodeNum11 = wavFormat.readExpGolombCodeNum() + 1;
            bit = wavFormat.readBit();
            i5 = 2 - (bit ? 1 : 0);
            int i21 = expGolombCodeNum11 * i5;
            if (!bit) {
                wavFormat.skipBit();
            }
            wavFormat.skipBit();
            i6 = expGolombCodeNum10 * 16;
            i7 = i21 * 16;
            if (wavFormat.readBit()) {
                int expGolombCodeNum12 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum13 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum14 = wavFormat.readExpGolombCodeNum();
                int expGolombCodeNum15 = wavFormat.readExpGolombCodeNum();
                if (expGolombCodeNum == 0) {
                    i13 = 1;
                } else {
                    if (expGolombCodeNum == 3) {
                        i13 = 1;
                    } else {
                        i13 = 2;
                    }
                    if (expGolombCodeNum == 1) {
                        i14 = 2;
                    } else {
                        i14 = 1;
                    }
                    i5 *= i14;
                }
                i6 -= (expGolombCodeNum12 + expGolombCodeNum13) * i13;
                i7 -= (expGolombCodeNum14 + expGolombCodeNum15) * i5;
            }
            int i22 = i7;
            int i23 = i6;
            int i24 = bits4;
            expGolombCodeNum4 = ((i24 != 44 || i24 == 86 || i24 == 100 || i24 == 110 || i24 == 122 || i24 == 244) && (bits5 & 16) != 0) ? 0 : i3;
            iIsoColorPrimariesToColorSpace = -1;
            f = 1.0f;
            if (wavFormat.readBit()) {
                if (!wavFormat.readBit()) {
                    bits = wavFormat.readBits(8);
                    if (bits == 255) {
                        int i25 = i3;
                        bits2 = wavFormat.readBits(i25);
                        bits3 = wavFormat.readBits(i25);
                        if (bits2 != 0 && bits3 != 0) {
                            f = bits2 / bits3;
                        }
                    } else if (bits < 17) {
                        f = ASPECT_RATIO_IDC_VALUES[bits];
                    } else {
                        Format$$ExternalSyntheticOutline0.m(bits, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                    }
                }
                if (wavFormat.readBit()) {
                    wavFormat.skipBit();
                }
                if (wavFormat.readBit()) {
                    wavFormat.skipBits(3);
                    if (wavFormat.readBit()) {
                        i12 = 1;
                    } else {
                        i12 = 2;
                    }
                    if (wavFormat.readBit()) {
                        int bits7 = wavFormat.readBits(8);
                        int bits8 = wavFormat.readBits(8);
                        wavFormat.skipBits(8);
                        iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits7);
                        iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8);
                    } else {
                        iIsoTransferCharacteristicsToColorTransfer = -1;
                    }
                } else {
                    i12 = -1;
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
                if (wavFormat.readBit()) {
                    wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                }
                if (wavFormat.readBit()) {
                    wavFormat.skipBits(65);
                }
                bit2 = wavFormat.readBit();
                if (bit2) {
                    skipHrdParameters(wavFormat);
                }
                bit3 = wavFormat.readBit();
                if (bit3) {
                    skipHrdParameters(wavFormat);
                }
                if (bit2 || bit3) {
                    wavFormat.skipBit();
                }
                wavFormat.skipBit();
                if (wavFormat.readBit()) {
                    wavFormat.skipBit();
                    wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                    expGolombCodeNum4 = wavFormat.readExpGolombCodeNum();
                    wavFormat.readExpGolombCodeNum();
                }
                f2 = f;
                i11 = iIsoColorPrimariesToColorSpace;
                i9 = i12;
                i10 = iIsoTransferCharacteristicsToColorTransfer;
                i8 = expGolombCodeNum4;
            } else {
                expGolombCodeNum7 = expGolombCodeNum7;
                i8 = expGolombCodeNum4;
                i9 = -1;
                i10 = -1;
                f2 = 1.0f;
                i11 = -1;
            }
            return new NalUnitUtil$SpsData(i24, bits5, bits6, expGolombCodeNum5, i23, i22, f2, i4, expGolombCodeNum2, z, bit, expGolombCodeNum7, expGolombCodeNum8, expGolombCodeNum3, z2, i11, i9, i10, i8);
        }
        expGolombCodeNum3 = wavFormat.readExpGolombCodeNum() + 4;
        z2 = false;
        wavFormat.readExpGolombCodeNum();
        wavFormat.skipBit();
        int expGolombCodeNum16 = wavFormat.readExpGolombCodeNum() + 1;
        int expGolombCodeNum17 = wavFormat.readExpGolombCodeNum() + 1;
        bit = wavFormat.readBit();
        i5 = 2 - (bit ? 1 : 0);
        int i26 = expGolombCodeNum17 * i5;
        if (!bit) {
            wavFormat.skipBit();
        }
        wavFormat.skipBit();
        i6 = expGolombCodeNum16 * 16;
        i7 = i26 * 16;
        if (wavFormat.readBit()) {
            int expGolombCodeNum18 = wavFormat.readExpGolombCodeNum();
            int expGolombCodeNum19 = wavFormat.readExpGolombCodeNum();
            int expGolombCodeNum110 = wavFormat.readExpGolombCodeNum();
            int expGolombCodeNum111 = wavFormat.readExpGolombCodeNum();
            if (expGolombCodeNum == 0) {
                i13 = 1;
            } else {
                if (expGolombCodeNum == 3) {
                    i13 = 1;
                } else {
                    i13 = 2;
                }
                if (expGolombCodeNum == 1) {
                    i14 = 2;
                } else {
                    i14 = 1;
                }
                i5 *= i14;
            }
            i6 -= (expGolombCodeNum18 + expGolombCodeNum19) * i13;
            i7 -= (expGolombCodeNum110 + expGolombCodeNum111) * i5;
        }
        int i27 = i7;
        int i28 = i6;
        int i29 = bits4;
        if (i29 != 44) {
        }
        iIsoColorPrimariesToColorSpace = -1;
        f = 1.0f;
        if (wavFormat.readBit()) {
            if (!wavFormat.readBit()) {
                bits = wavFormat.readBits(8);
                if (bits == 255) {
                    int i210 = i3;
                    bits2 = wavFormat.readBits(i210);
                    bits3 = wavFormat.readBits(i210);
                    if (bits2 != 0) {
                        f = bits2 / bits3;
                    }
                } else if (bits < 17) {
                    f = ASPECT_RATIO_IDC_VALUES[bits];
                } else {
                    Format$$ExternalSyntheticOutline0.m(bits, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                }
            }
            if (wavFormat.readBit()) {
                wavFormat.skipBit();
            }
            if (wavFormat.readBit()) {
                wavFormat.skipBits(3);
                if (wavFormat.readBit()) {
                    i12 = 1;
                } else {
                    i12 = 2;
                }
                if (wavFormat.readBit()) {
                    int bits9 = wavFormat.readBits(8);
                    int bits10 = wavFormat.readBits(8);
                    wavFormat.skipBits(8);
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits9);
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits10);
                } else {
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
            } else {
                i12 = -1;
                iIsoTransferCharacteristicsToColorTransfer = -1;
            }
            if (wavFormat.readBit()) {
                wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
            }
            if (wavFormat.readBit()) {
                wavFormat.skipBits(65);
            }
            bit2 = wavFormat.readBit();
            if (bit2) {
                skipHrdParameters(wavFormat);
            }
            bit3 = wavFormat.readBit();
            if (bit3) {
                skipHrdParameters(wavFormat);
            }
            if (bit2) {
                wavFormat.skipBit();
            } else {
                wavFormat.skipBit();
            }
            wavFormat.skipBit();
            if (wavFormat.readBit()) {
                wavFormat.skipBit();
                wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
                expGolombCodeNum4 = wavFormat.readExpGolombCodeNum();
                wavFormat.readExpGolombCodeNum();
            }
            f2 = f;
            i11 = iIsoColorPrimariesToColorSpace;
            i9 = i12;
            i10 = iIsoTransferCharacteristicsToColorTransfer;
            i8 = expGolombCodeNum4;
        } else {
            expGolombCodeNum7 = expGolombCodeNum7;
            i8 = expGolombCodeNum4;
            i9 = -1;
            i10 = -1;
            f2 = 1.0f;
            i11 = -1;
        }
        return new NalUnitUtil$SpsData(i29, bits5, bits6, expGolombCodeNum5, i28, i27, f2, i4, expGolombCodeNum2, z, bit, expGolombCodeNum7, expGolombCodeNum8, expGolombCodeNum3, z2, i11, i9, i10, i8);
    }

    public static void skipHrdParameters(WavFormat wavFormat) {
        int expGolombCodeNum = wavFormat.readExpGolombCodeNum() + 1;
        wavFormat.skipBits(8);
        for (int i = 0; i < expGolombCodeNum; i++) {
            wavFormat.readExpGolombCodeNum();
            wavFormat.readExpGolombCodeNum();
            wavFormat.skipBit();
        }
        wavFormat.skipBits(20);
    }

    public static ArrayList split(ByteBuffer byteBuffer) {
        int iRemaining;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (byteBufferAsReadOnlyBuffer.hasRemaining()) {
            try {
                byte b = byteBufferAsReadOnlyBuffer.get();
                int i = (b >> 3) & 15;
                if (((b >> 2) & 1) != 0) {
                    byteBufferAsReadOnlyBuffer.get();
                }
                if (((b >> 1) & 1) != 0) {
                    iRemaining = 0;
                    for (int i2 = 0; i2 < 8; i2++) {
                        byte b2 = byteBufferAsReadOnlyBuffer.get();
                        iRemaining |= (b2 & 127) << (i2 * 7);
                        if ((b2 & 128) == 0) {
                            break;
                        }
                    }
                } else {
                    iRemaining = byteBufferAsReadOnlyBuffer.remaining();
                }
                if (byteBufferAsReadOnlyBuffer.position() + iRemaining > byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                ByteBuffer byteBufferDuplicate = byteBufferAsReadOnlyBuffer.duplicate();
                byteBufferDuplicate.limit(byteBufferAsReadOnlyBuffer.position() + iRemaining);
                arrayList.add(new ObuParser$Obu(i, byteBufferDuplicate));
                byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.position() + iRemaining);
            } catch (BufferUnderflowException unused) {
            }
        }
        return arrayList;
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArrCopyOf = scratchEscapePositions;
                    if (iArrCopyOf.length <= i4) {
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
                        scratchEscapePositions = iArrCopyOf;
                    }
                    iArrCopyOf[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }
}
