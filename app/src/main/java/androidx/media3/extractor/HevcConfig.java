package androidx.media3.extractor;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil$H265LayerInfo;
import androidx.media3.container.NalUnitUtil$H265ProfileTierLevel;
import androidx.media3.container.NalUnitUtil$H265SpsData;
import androidx.media3.container.OpusUtil;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HevcConfig {
    public final int bitdepthChroma;
    public final int bitdepthLuma;
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int decodedHeight;
    public final int decodedWidth;
    public final List initializationData;
    public final int maxNumReorderPics;
    public final int maxSubLayers;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int stereoMode;
    public final Dispatcher vpsData;

    public HevcConfig(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, int i11, String str, Dispatcher dispatcher) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.maxSubLayers = i2;
        this.decodedWidth = i3;
        this.decodedHeight = i4;
        this.bitdepthLuma = i5;
        this.bitdepthChroma = i6;
        this.colorSpace = i7;
        this.colorRange = i8;
        this.colorTransfer = i9;
        this.stereoMode = i10;
        this.pixelWidthHeightRatio = f;
        this.maxNumReorderPics = i11;
        this.codecs = str;
        this.vpsData = dispatcher;
    }

    public static HevcConfig parseImpl(ParsableByteArray parsableByteArray, boolean z, Dispatcher dispatcher) {
        boolean z2;
        MimeTypes.Mp4aObjectType h265Sei3dRefDisplayInfo;
        int i = 4;
        try {
            if (z) {
                parsableByteArray.skipBytes(4);
            } else {
                parsableByteArray.skipBytes(21);
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int i2 = parsableByteArray.position;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                z2 = true;
                if (i4 >= unsignedByte2) {
                    break;
                }
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i6 = 0; i6 < unsignedShort; i6++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i5 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
                i4++;
            }
            parsableByteArray.setPosition(i2);
            byte[] bArr = new byte[i5];
            Dispatcher dispatcher2 = dispatcher;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            float f = 1.0f;
            String strBuildHevcCodecString = null;
            int i17 = 0;
            int i18 = 0;
            while (i17 < unsignedByte2) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                int i19 = i3;
                Dispatcher h265VpsNalUnit = dispatcher2;
                while (i19 < unsignedShort3) {
                    boolean z3 = z2;
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    int i20 = unsignedByte;
                    System.arraycopy(OpusUtil.NAL_START_CODE, i3, bArr, i18, i);
                    int i21 = i18 + 4;
                    System.arraycopy(parsableByteArray.data, parsableByteArray.position, bArr, i21, unsignedShort4);
                    if (unsignedByte3 == 32 && i19 == 0) {
                        h265VpsNalUnit = OpusUtil.parseH265VpsNalUnit(bArr, i21, i21 + unsignedShort4);
                    } else {
                        if (unsignedByte3 == 33 && i19 == 0) {
                            NalUnitUtil$H265SpsData h265SpsNalUnit = OpusUtil.parseH265SpsNalUnit(bArr, i21, i21 + unsignedShort4, h265VpsNalUnit);
                            i7 = h265SpsNalUnit.maxSubLayersMinus1 + 1;
                            i8 = h265SpsNalUnit.decodedWidth;
                            int i22 = h265SpsNalUnit.decodedHeight;
                            i10 = h265SpsNalUnit.bitDepthLumaMinus8 + 8;
                            i11 = h265SpsNalUnit.bitDepthChromaMinus8 + 8;
                            int i23 = h265SpsNalUnit.colorSpace;
                            i9 = i22;
                            int i24 = h265SpsNalUnit.colorRange;
                            int i25 = h265SpsNalUnit.colorTransfer;
                            float f2 = h265SpsNalUnit.pixelWidthHeightRatio;
                            int i26 = h265SpsNalUnit.maxNumReorderPics;
                            NalUnitUtil$H265ProfileTierLevel nalUnitUtil$H265ProfileTierLevel = h265SpsNalUnit.profileTierLevel;
                            if (nalUnitUtil$H265ProfileTierLevel != null) {
                                strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(nalUnitUtil$H265ProfileTierLevel.generalProfileSpace, nalUnitUtil$H265ProfileTierLevel.generalTierFlag, nalUnitUtil$H265ProfileTierLevel.generalProfileIdc, nalUnitUtil$H265ProfileTierLevel.generalProfileCompatibilityFlags, nalUnitUtil$H265ProfileTierLevel.constraintBytes, nalUnitUtil$H265ProfileTierLevel.generalLevelIdc);
                            }
                            i16 = i26;
                            f = f2;
                            i14 = i25;
                            i13 = i24;
                            i12 = i23;
                        } else if (unsignedByte3 == 39 && i19 == 0 && (h265Sei3dRefDisplayInfo = OpusUtil.parseH265Sei3dRefDisplayInfo(bArr, i21, i21 + unsignedShort4)) != null && h265VpsNalUnit != null) {
                            i3 = 0;
                            i15 = h265Sei3dRefDisplayInfo.audioObjectTypeIndication == ((NalUnitUtil$H265LayerInfo) ((ImmutableList) h265VpsNalUnit.executorServiceOrNull).get(0)).viewId ? 4 : 5;
                        }
                        i3 = 0;
                    }
                    i18 = i21 + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i19++;
                    z2 = z3;
                    unsignedByte = i20;
                    i = 4;
                }
                i17++;
                dispatcher2 = h265VpsNalUnit;
                i = 4;
            }
            return new HevcConfig(i5 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), unsignedByte + 1, i7, i8, i9, i10, i11, i12, i13, i14, i15, f, i16, strBuildHevcCodecString, dispatcher2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer(e, "Error parsing".concat(z ? "L-HEVC config" : "HEVC config"));
        }
    }
}
