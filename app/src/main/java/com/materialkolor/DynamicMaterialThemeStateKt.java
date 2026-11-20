package com.materialkolor;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.scheme.DynamicScheme;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a·\u0001\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a«\u0001\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "seedColor", "", "isDark", "isAmoled", "primary", "secondary", "tertiary", "neutral", "neutralVariant", "error", "Lcom/materialkolor/PaletteStyle;", "style", "", "contrastLevel", "Lcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;", "specVersion", "Lcom/materialkolor/scheme/DynamicScheme$Platform;", "platform", "Lkotlin/Function2;", "Lcom/materialkolor/DynamicMaterialThemeState;", "Landroidx/compose/material3/ColorScheme;", "modifyColorScheme", "rememberDynamicMaterialThemeState-UQznLDA", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Lcom/materialkolor/DynamicMaterialThemeState;", "rememberDynamicMaterialThemeState", "rememberDynamicMaterialThemeState-CdFb-wI", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Lcom/materialkolor/DynamicMaterialThemeState;", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DynamicMaterialThemeStateKt {
    /* JADX WARN: Code duplicated, block: B:116:0x0181  */
    /* JADX WARN: Code duplicated, block: B:118:0x0187  */
    /* JADX WARN: Code duplicated, block: B:119:0x018a  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:140:0x01df  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX INFO: renamed from: rememberDynamicMaterialThemeState-CdFb-wI, reason: not valid java name */
    public static final DynamicMaterialThemeState m934rememberDynamicMaterialThemeStateCdFbwI(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function2 function2, Composer composer, int i, int i2, int i3) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = (i3 & 4) != 0 ? false : z2;
        Color color6 = (i3 & 8) != 0 ? null : color;
        Color color7 = (i3 & 16) != 0 ? null : color2;
        Color color8 = (i3 & 32) != 0 ? null : color3;
        Color color9 = (i3 & 64) != 0 ? null : color4;
        Color color10 = (i3 & 128) != 0 ? null : color5;
        PaletteStyle paletteStyle2 = (i3 & 256) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i3 & 512) != 0 ? 0.0d : d;
        if ((i3 & 1024) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i3 & 2048) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        Function2 function3 = (i3 & 4096) != 0 ? null : function2;
        ColorSpec$SpecVersion colorSpec$SpecVersion3 = colorSpec$SpecVersion2;
        PaletteStyle paletteStyle3 = paletteStyle2;
        boolean z8 = (((i & 14) ^ 6) > 4 && ((GapComposer) composer).changed(j)) || (i & 6) == 4;
        if (((i & 112) ^ 48) > 32 && ((GapComposer) composer).changed(z)) {
            z3 = true;
        } else if ((i & 48) == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z9 = z7;
        boolean z10 = ((((i & 7168) ^ 3072) > 2048 && ((GapComposer) composer).changed(color6)) || (i & 3072) == 2048) | z8 | z3 | ((((i & 896) ^ 384) > 256 && ((GapComposer) composer).changed(z7)) || (i & 384) == 256) | ((((57344 & i) ^ 24576) > 16384 && ((GapComposer) composer).changed(color7)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) > 131072 && ((GapComposer) composer).changed(color8)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) > 1048576 && ((GapComposer) composer).changed(color9)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && ((GapComposer) composer).changed(color10)) || (i & 12582912) == 8388608);
        if (((234881024 & i) ^ 100663296) > 67108864) {
            if (((GapComposer) composer).changed(paletteStyle3.ordinal())) {
                z4 = true;
            } else if ((i & 100663296) == 67108864) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else if ((i & 100663296) == 67108864) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z11 = ((((1879048192 & i) ^ 805306368) > 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z10 | z4;
        if (((i2 & 14) ^ 6) > 4) {
            if (((GapComposer) composer).changed(colorSpec$SpecVersion3.ordinal())) {
                z5 = true;
            } else if ((i2 & 6) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
        } else if ((i2 & 6) == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z12 = z11 | z5;
        if (((i2 & 112) ^ 48) > 32) {
            if (((GapComposer) composer).changed(platform2.ordinal())) {
                z6 = true;
            } else if ((i2 & 48) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
        } else if ((i2 & 48) == 32) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean z13 = z12 | z6 | ((((i2 & 896) ^ 384) > 256 && ((GapComposer) composer).changed(function3)) || (i2 & 384) == 256);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (z13 || objRememberedValue == Composer.Companion.Empty) {
            DynamicMaterialThemeState dynamicMaterialThemeState = new DynamicMaterialThemeState(j, z, z9, paletteStyle3, d2, colorSpec$SpecVersion3, platform2, new Color(j), color6, color7, color8, color9, color10, function3);
            gapComposer.updateRememberedValue(dynamicMaterialThemeState);
            objRememberedValue = dynamicMaterialThemeState;
        }
        return (DynamicMaterialThemeState) objRememberedValue;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0133  */
    /* JADX WARN: Code duplicated, block: B:102:0x013d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:110:0x015c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0171  */
    /* JADX WARN: Code duplicated, block: B:118:0x017b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0190  */
    /* JADX WARN: Code duplicated, block: B:126:0x019a  */
    /* JADX WARN: Code duplicated, block: B:132:0x01af  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:150:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:152:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:153:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:156:0x0209  */
    /* JADX WARN: Code duplicated, block: B:158:0x0217  */
    /* JADX WARN: Code duplicated, block: B:160:0x021b  */
    /* JADX WARN: Code duplicated, block: B:161:0x021e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0228  */
    /* JADX WARN: Code duplicated, block: B:166:0x0232  */
    /* JADX WARN: Code duplicated, block: B:172:0x0245  */
    /* JADX WARN: Code duplicated, block: B:174:0x0249  */
    /* JADX WARN: Code duplicated, block: B:58:0x0097 A[PHI: r21
      0x0097: PHI (r21v9 androidx.compose.ui.graphics.Color) = (r21v2 androidx.compose.ui.graphics.Color), (r21v10 androidx.compose.ui.graphics.Color) binds: [B:57:0x0095, B:53:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd A[PHI: r5 r24
      0x00bd: PHI (r5v7 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:68:0x00bb, B:65:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x00bd: PHI (r24v5 boolean) = (r24v1 boolean), (r24v6 boolean) binds: [B:68:0x00bb, B:65:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0105 A[PHI: r21
      0x0105: PHI (r21v7 androidx.compose.ui.graphics.Color) = (r21v4 androidx.compose.ui.graphics.Color), (r21v8 androidx.compose.ui.graphics.Color) binds: [B:87:0x0103, B:84:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x0114  */
    /* JADX WARN: Code duplicated, block: B:94:0x011e  */
    /* JADX INFO: renamed from: rememberDynamicMaterialThemeState-UQznLDA, reason: not valid java name */
    public static final DynamicMaterialThemeState m935rememberDynamicMaterialThemeStateUQznLDA(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function2 function2, Composer composer, int i, int i2, int i3) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        Color color7;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Color color8;
        Color color9;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        GapComposer gapComposer;
        Object objRememberedValue;
        boolean z13 = (i3 & 4) != 0 ? false : z2;
        Color color10 = (i3 & 8) != 0 ? null : color;
        Color color11 = (i3 & 16) != 0 ? null : color2;
        Color color12 = (i3 & 32) != 0 ? null : color3;
        Color color13 = (i3 & 64) != 0 ? null : color4;
        Color color14 = (i3 & 128) != 0 ? null : color5;
        Color color15 = (i3 & 256) != 0 ? null : color6;
        PaletteStyle paletteStyle2 = (i3 & 512) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i3 & 1024) != 0 ? 0.0d : d;
        if ((i3 & 2048) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i3 & 4096) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        Function2 function3 = (i3 & 8192) == 0 ? function2 : null;
        DynamicScheme.Platform platform3 = platform2;
        if (((i & 14) ^ 6) > 4) {
            color7 = color10;
            if (((GapComposer) composer).changed(j)) {
                z3 = true;
            }
            if (((i & 112) ^ 48) > 32) {
                z4 = z;
                if (!((GapComposer) composer).changed(z4)) {
                    z5 = z3;
                }
                z6 = true;
                boolean z14 = z5 | z6 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(z13)) || (i & 384) == 256);
                z7 = z13;
                if (((i & 7168) ^ 3072) > 2048) {
                    color8 = color7;
                    if (!((GapComposer) composer).changed(color8)) {
                        color9 = color8;
                    }
                    z8 = true;
                    boolean z15 = z8 | z14 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
                    if (((1879048192 & i) ^ 805306368) > 536870912) {
                        if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                            z9 = true;
                        } else if ((i & 805306368) == 536870912) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else if ((i & 805306368) == 536870912) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    boolean z16 = z9 | z15 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
                    if (((i2 & 112) ^ 48) > 32) {
                        if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                            z10 = true;
                        } else if ((i2 & 48) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else if ((i2 & 48) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z17 = z16 | z10;
                    if (((i2 & 896) ^ 384) > 256) {
                        if (!((GapComposer) composer).changed(platform3.ordinal())) {
                            z11 = true;
                        } else if ((i2 & 384) == 256) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else if ((i2 & 384) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = z17 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
                    gapComposer = (GapComposer) composer;
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z12 || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    return (DynamicMaterialThemeState) objRememberedValue;
                }
                color8 = color7;
                color9 = color8;
                if ((i & 3072) == 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                boolean z18 = z8 | z14 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
                if (((1879048192 & i) ^ 805306368) > 536870912) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 805306368) == 536870912) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z19 = z9 | z18 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 48) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z110 = z19 | z10;
                if (((i2 & 896) ^ 384) > 256) {
                    if (!((GapComposer) composer).changed(platform3.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 384) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z110 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (DynamicMaterialThemeState) objRememberedValue;
            }
            z4 = z;
            z5 = z3;
            if ((i & 48) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z111 = z5 | z6 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(z13)) || (i & 384) == 256);
            z7 = z13;
            if (((i & 7168) ^ 3072) > 2048) {
                color8 = color7;
                if (!((GapComposer) composer).changed(color8)) {
                    color9 = color8;
                }
                z8 = true;
                boolean z112 = z8 | z111 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
                if (((1879048192 & i) ^ 805306368) > 536870912) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 805306368) == 536870912) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z113 = z9 | z112 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 48) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z114 = z113 | z10;
                if (((i2 & 896) ^ 384) > 256) {
                    if (!((GapComposer) composer).changed(platform3.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 384) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z114 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (DynamicMaterialThemeState) objRememberedValue;
            }
            color8 = color7;
            color9 = color8;
            if ((i & 3072) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z115 = z8 | z111 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
            if (((1879048192 & i) ^ 805306368) > 536870912) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 805306368) == 536870912) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z116 = z9 | z115 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 48) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z117 = z116 | z10;
            if (((i2 & 896) ^ 384) > 256) {
                if (!((GapComposer) composer).changed(platform3.ordinal())) {
                    z11 = true;
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 384) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z117 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (DynamicMaterialThemeState) objRememberedValue;
        }
        color7 = color10;
        if ((i & 6) == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (((i & 112) ^ 48) > 32) {
            z4 = z;
            if (!((GapComposer) composer).changed(z4)) {
                z5 = z3;
            }
            z6 = true;
            boolean z118 = z5 | z6 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(z13)) || (i & 384) == 256);
            z7 = z13;
            if (((i & 7168) ^ 3072) > 2048) {
                color8 = color7;
                if (!((GapComposer) composer).changed(color8)) {
                    color9 = color8;
                }
                z8 = true;
                boolean z119 = z8 | z118 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
                if (((1879048192 & i) ^ 805306368) > 536870912) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 805306368) == 536870912) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z1110 = z9 | z119 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 48) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z1111 = z1110 | z10;
                if (((i2 & 896) ^ 384) > 256) {
                    if (!((GapComposer) composer).changed(platform3.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 384) == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z1111 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (DynamicMaterialThemeState) objRememberedValue;
            }
            color8 = color7;
            color9 = color8;
            if ((i & 3072) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z1112 = z8 | z118 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
            if (((1879048192 & i) ^ 805306368) > 536870912) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 805306368) == 536870912) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z1113 = z9 | z1112 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 48) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z1114 = z1113 | z10;
            if (((i2 & 896) ^ 384) > 256) {
                if (!((GapComposer) composer).changed(platform3.ordinal())) {
                    z11 = true;
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 384) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z1114 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (DynamicMaterialThemeState) objRememberedValue;
        }
        z4 = z;
        z5 = z3;
        if ((i & 48) == 32) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean z1115 = z5 | z6 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(z13)) || (i & 384) == 256);
        z7 = z13;
        if (((i & 7168) ^ 3072) > 2048) {
            color8 = color7;
            if (!((GapComposer) composer).changed(color8)) {
                color9 = color8;
            }
            z8 = true;
            boolean z1116 = z8 | z1115 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
            if (((1879048192 & i) ^ 805306368) > 536870912) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 805306368) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 805306368) == 536870912) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z1117 = z9 | z1116 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 48) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z1118 = z1117 | z10;
            if (((i2 & 896) ^ 384) > 256) {
                if (!((GapComposer) composer).changed(platform3.ordinal())) {
                    z11 = true;
                } else if ((i2 & 384) == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 384) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z1118 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (DynamicMaterialThemeState) objRememberedValue;
        }
        color8 = color7;
        color9 = color8;
        if ((i & 3072) == 2048) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean z1119 = z8 | z1115 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color11)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color12)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color13)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color14)) || (i & 12582912) == 8388608) | ((((234881024 & i) ^ 100663296) <= 67108864 && ((GapComposer) composer).changed(color15)) || (i & 100663296) == 67108864);
        if (((1879048192 & i) ^ 805306368) > 536870912) {
            if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                z9 = true;
            } else if ((i & 805306368) == 536870912) {
                z9 = true;
            } else {
                z9 = false;
            }
        } else if ((i & 805306368) == 536870912) {
            z9 = true;
        } else {
            z9 = false;
        }
        boolean z11110 = z9 | z1119 | ((((i2 & 14) ^ 6) <= 4 && ((GapComposer) composer).changed(d2)) || (i2 & 6) == 4);
        if (((i2 & 112) ^ 48) > 32) {
            if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                z10 = true;
            } else if ((i2 & 48) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else if ((i2 & 48) == 32) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11111 = z11110 | z10;
        if (((i2 & 896) ^ 384) > 256) {
            if (!((GapComposer) composer).changed(platform3.ordinal())) {
                z11 = true;
            } else if ((i2 & 384) == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else if ((i2 & 384) == 256) {
            z11 = true;
        } else {
            z11 = false;
        }
        z12 = z11111 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function3)) || (i2 & 3072) == 2048);
        gapComposer = (GapComposer) composer;
        objRememberedValue = gapComposer.rememberedValue();
        if (z12) {
            objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
            gapComposer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = new DynamicMaterialThemeState(j, z4, z7, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, color9, color11, color12, color13, color14, color15, function3);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (DynamicMaterialThemeState) objRememberedValue;
    }
}
