package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Connector;
import androidx.compose.ui.graphics.colorspace.ConnectorKt;
import androidx.compose.ui.graphics.colorspace.Illuminant;
import kotlin.ResultKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Color {
    public final long value;

    public /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m478boximpl(long j) {
        return new Color(j);
    }

    /* JADX INFO: renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m479convertvNxB06k(long j, ColorSpace colorSpace) {
        Connector connectorM526createConnectorYBCOT_4;
        ColorSpace colorSpaceM483getColorSpaceimpl = m483getColorSpaceimpl(j);
        int i = colorSpaceM483getColorSpaceimpl.id;
        int i2 = colorSpace.id;
        if ((i | i2) < 0) {
            connectorM526createConnectorYBCOT_4 = Illuminant.m526createConnectorYBCOT_4(colorSpaceM483getColorSpaceimpl, colorSpace);
        } else {
            MutableIntObjectMap mutableIntObjectMap = ConnectorKt.Connectors;
            int i3 = i | (i2 << 6);
            Object objM526createConnectorYBCOT_4 = mutableIntObjectMap.get(i3);
            if (objM526createConnectorYBCOT_4 == null) {
                objM526createConnectorYBCOT_4 = Illuminant.m526createConnectorYBCOT_4(colorSpaceM483getColorSpaceimpl, colorSpace);
                mutableIntObjectMap.set(i3, objM526createConnectorYBCOT_4);
            }
            connectorM526createConnectorYBCOT_4 = (Connector) objM526createConnectorYBCOT_4;
        }
        return connectorM526createConnectorYBCOT_4.mo525transformToColorl2rxGTc$ui_graphics(j);
    }

    /* JADX INFO: renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static long m480copywmQWz5c$default(long j, float f) {
        return ColorKt.Color(m485getRedimpl(j), m484getGreenimpl(j), m482getBlueimpl(j), f, m483getColorSpaceimpl(j));
    }

    /* JADX INFO: renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m481getAlphaimpl(long j) {
        float fUlongToDouble;
        float f;
        if ((63 & j) == 0) {
            fUlongToDouble = (float) ResultKt.ulongToDouble((j >>> 56) & 255);
            f = 255.0f;
        } else {
            fUlongToDouble = (float) ResultKt.ulongToDouble((j >>> 6) & 1023);
            f = 1023.0f;
        }
        return fUlongToDouble / f;
    }

    /* JADX INFO: renamed from: getBlue-impl, reason: not valid java name */
    public static final float m482getBlueimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ResultKt.ulongToDouble((j >>> 32) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 16) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m483getColorSpaceimpl(long j) {
        float[] fArr = ColorSpaces.SrgbPrimaries;
        return ColorSpaces.ColorSpacesArray[(int) (j & 63)];
    }

    /* JADX INFO: renamed from: getGreen-impl, reason: not valid java name */
    public static final float m484getGreenimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ResultKt.ulongToDouble((j >>> 40) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 32) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: getRed-impl, reason: not valid java name */
    public static final float m485getRedimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ResultKt.ulongToDouble((j >>> 48) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 48) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m486toStringimpl(long j) {
        float fM485getRedimpl = m485getRedimpl(j);
        float fM484getGreenimpl = m484getGreenimpl(j);
        float fM482getBlueimpl = m482getBlueimpl(j);
        float fM481getAlphaimpl = m481getAlphaimpl(j);
        String str = m483getColorSpaceimpl(j).name;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Color(", fM485getRedimpl, ", ", fM484getGreenimpl, ", ");
        sbM.append(fM482getBlueimpl);
        sbM.append(", ");
        sbM.append(fM481getAlphaimpl);
        sbM.append(", ");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, str, ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Color) {
            return this.value == ((Color) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m486toStringimpl(this.value);
    }
}
