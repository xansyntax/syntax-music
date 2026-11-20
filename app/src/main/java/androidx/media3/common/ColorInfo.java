package androidx.media3.common;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorInfo {
    public static final String FIELD_CHROMA_BITDEPTH;
    public static final String FIELD_COLOR_RANGE;
    public static final String FIELD_COLOR_SPACE;
    public static final String FIELD_COLOR_TRANSFER;
    public static final String FIELD_HDR_STATIC_INFO;
    public static final String FIELD_LUMA_BITDEPTH;
    public static final ColorInfo SDR_BT709_LIMITED = new ColorInfo(1, 2, 3, null, -1, -1);
    public final int chromaBitdepth;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public int hashCode;
    public final byte[] hdrStaticInfo;
    public final int lumaBitdepth;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_COLOR_SPACE = Integer.toString(0, 36);
        FIELD_COLOR_RANGE = Integer.toString(1, 36);
        FIELD_COLOR_TRANSFER = Integer.toString(2, 36);
        FIELD_HDR_STATIC_INFO = Integer.toString(3, 36);
        FIELD_LUMA_BITDEPTH = Integer.toString(4, 36);
        FIELD_CHROMA_BITDEPTH = Integer.toString(5, 36);
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr, int i4, int i5) {
        this.colorSpace = i;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
        this.lumaBitdepth = i4;
        this.chromaBitdepth = i5;
    }

    public static String colorRangeToString(int i) {
        if (i == -1) {
            return "Unset color range";
        }
        if (i != 1) {
            return i != 2 ? IntIntPair$$ExternalSyntheticOutline0.m(i, "Undefined color range ") : "Limited range";
        }
        return "Full range";
    }

    public static String colorSpaceToString(int i) {
        if (i == -1) {
            return "Unset color space";
        }
        if (i == 6) {
            return "BT2020";
        }
        if (i != 1) {
            return i != 2 ? IntIntPair$$ExternalSyntheticOutline0.m(i, "Undefined color space ") : "BT601";
        }
        return "BT709";
    }

    public static String colorTransferToString(int i) {
        if (i == -1) {
            return "Unset color transfer";
        }
        if (i == 10) {
            return "Gamma 2.2";
        }
        if (i == 1) {
            return "Linear";
        }
        if (i == 2) {
            return "sRGB";
        }
        if (i == 3) {
            return "SDR SMPTE 170M";
        }
        if (i != 6) {
            return i != 7 ? IntIntPair$$ExternalSyntheticOutline0.m(i, "Undefined color transfer ") : "HLG";
        }
        return "ST2084 PQ";
    }

    public static boolean isEquivalentToAssumedSdrDefault(ColorInfo colorInfo) {
        if (colorInfo == null) {
            return true;
        }
        int i = colorInfo.colorSpace;
        if (i != -1 && i != 1 && i != 2) {
            return false;
        }
        int i2 = colorInfo.colorRange;
        if (i2 != -1 && i2 != 2) {
            return false;
        }
        int i3 = colorInfo.colorTransfer;
        if ((i3 != -1 && i3 != 3) || colorInfo.hdrStaticInfo != null) {
            return false;
        }
        int i4 = colorInfo.chromaBitdepth;
        if (i4 != -1 && i4 != 8) {
            return false;
        }
        int i5 = colorInfo.lumaBitdepth;
        return i5 == -1 || i5 == 8;
    }

    public static int isoColorPrimariesToColorSpace(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int isoTransferCharacteristicsToColorTransfer(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 4) {
            return 10;
        }
        if (i == 13) {
            return 2;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ColorInfo.class == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo) && this.lumaBitdepth == colorInfo.lumaBitdepth && this.chromaBitdepth == colorInfo.chromaBitdepth) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((Arrays.hashCode(this.hdrStaticInfo) + ((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31)) * 31) + this.lumaBitdepth) * 31) + this.chromaBitdepth;
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public final boolean isDataSpaceValid() {
        return (this.colorSpace == -1 || this.colorRange == -1 || this.colorTransfer == -1) ? false : true;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(colorSpaceToString(this.colorSpace));
        sb.append(", ");
        sb.append(colorRangeToString(this.colorRange));
        sb.append(", ");
        sb.append(colorTransferToString(this.colorTransfer));
        sb.append(", ");
        sb.append(this.hdrStaticInfo != null);
        sb.append(", ");
        String str2 = "NA";
        int i = this.lumaBitdepth;
        if (i != -1) {
            str = i + "bit Luma";
        } else {
            str = "NA";
        }
        sb.append(str);
        sb.append(", ");
        int i2 = this.chromaBitdepth;
        if (i2 != -1) {
            str2 = i2 + "bit Chroma";
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, str2, ")");
    }
}
