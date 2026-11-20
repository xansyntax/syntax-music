package com.materialkolor;

import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.network.NetworkFetcher;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.dynamiccolor.ColorSpec2021;
import com.materialkolor.dynamiccolor.ColorSpec2021$$ExternalSyntheticLambda1;
import com.materialkolor.dynamiccolor.ColorSpec2021$$ExternalSyntheticLambda10;
import com.materialkolor.dynamiccolor.ColorSpec2021$$ExternalSyntheticLambda14;
import com.materialkolor.dynamiccolor.ColorSpec2021$$ExternalSyntheticLambda4;
import com.materialkolor.dynamiccolor.ColorSpec2021$$ExternalSyntheticLambda7;
import com.materialkolor.dynamiccolor.ColorSpec2025;
import com.materialkolor.dynamiccolor.ColorSpec2025$$ExternalSyntheticLambda1;
import com.materialkolor.dynamiccolor.ColorSpec2025$$ExternalSyntheticLambda10;
import com.materialkolor.dynamiccolor.ColorSpec2025$$ExternalSyntheticLambda13;
import com.materialkolor.dynamiccolor.ColorSpec2025$$ExternalSyntheticLambda5;
import com.materialkolor.dynamiccolor.DynamicColor;
import com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder;
import com.materialkolor.dynamiccolor.MaterialDynamicColors;
import com.materialkolor.ktx.DynamicColorKt;
import com.materialkolor.ktx.DynamicSchemeKt;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016H\u0007b\u0002\b\u0019¢\u0006\u0004\b\u0017\u0010\u0018\u001a¯\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0004\b\u001b\u0010\u001c\u001a©\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016H\u0007b\u0002\b\u0019¢\u0006\u0004\b\u001d\u0010\u001e\u001a£\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010!\u001a\u00020\u0001*\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¨\u0006#"}, d2 = {"rememberDynamicColorScheme", "Landroidx/compose/material3/ColorScheme;", "seedColor", "Landroidx/compose/ui/graphics/Color;", "isDark", "", "isAmoled", "primary", "secondary", "tertiary", "neutral", "neutralVariant", "error", "style", "Lcom/materialkolor/PaletteStyle;", "contrastLevel", "", "specVersion", "Lcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;", "platform", "Lcom/materialkolor/scheme/DynamicScheme$Platform;", "modifyColorScheme", "Lkotlin/Function1;", "rememberDynamicColorScheme-UQznLDA", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)Landroidx/compose/material3/ColorScheme;", "Landroidx/compose/runtime/Composable;", "dynamicColorScheme", "dynamicColorScheme-N98v4SY", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function1;)Landroidx/compose/material3/ColorScheme;", "rememberDynamicColorScheme-CdFb-wI", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)Landroidx/compose/material3/ColorScheme;", "dynamicColorScheme-onzyBm0", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Lkotlin/jvm/functions/Function1;)Landroidx/compose/material3/ColorScheme;", "toColorScheme", "Lcom/materialkolor/scheme/DynamicScheme;", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DynamicColorSchemeKt {
    /* JADX INFO: renamed from: dynamicColorScheme-N98v4SY, reason: not valid java name */
    public static final ColorScheme m923dynamicColorSchemeN98v4SY(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1) {
        paletteStyle.getClass();
        colorSpec$SpecVersion.getClass();
        platform.getClass();
        return toColorScheme(DynamicSchemeKt.m961DynamicSchemedtSySfE(j, z, color, color2, color3, color4, color5, color6, paletteStyle, d, colorSpec$SpecVersion, platform), z2, function1);
    }

    /* JADX INFO: renamed from: dynamicColorScheme-N98v4SY$default, reason: not valid java name */
    public static ColorScheme m924dynamicColorSchemeN98v4SY$default(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1, int i, Object obj) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        boolean z3 = (i & 4) != 0 ? false : z2;
        Color color7 = (i & 8) != 0 ? null : color;
        Color color8 = (i & 16) != 0 ? null : color2;
        Color color9 = (i & 32) != 0 ? null : color3;
        Color color10 = (i & 64) != 0 ? null : color4;
        Color color11 = (i & 128) != 0 ? null : color5;
        Color color12 = (i & 256) != 0 ? null : color6;
        PaletteStyle paletteStyle2 = (i & 512) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i & 1024) != 0 ? 0.0d : d;
        if ((i & 2048) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i & 4096) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        return m923dynamicColorSchemeN98v4SY(j, z, z3, color7, color8, color9, color10, color11, color12, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, (i & 8192) != 0 ? null : function1);
    }

    /* JADX INFO: renamed from: dynamicColorScheme-onzyBm0, reason: not valid java name */
    public static final ColorScheme m925dynamicColorSchemeonzyBm0(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1) {
        paletteStyle.getClass();
        colorSpec$SpecVersion.getClass();
        platform.getClass();
        return m923dynamicColorSchemeN98v4SY(j, z, z2, new Color(j), color, color2, color3, color4, color5, paletteStyle, d, colorSpec$SpecVersion, platform, function1);
    }

    /* JADX INFO: renamed from: dynamicColorScheme-onzyBm0$default, reason: not valid java name */
    public static ColorScheme m926dynamicColorSchemeonzyBm0$default(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1, int i, Object obj) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        boolean z3 = (i & 4) != 0 ? false : z2;
        Color color6 = (i & 8) != 0 ? null : color;
        Color color7 = (i & 16) != 0 ? null : color2;
        Color color8 = (i & 32) != 0 ? null : color3;
        Color color9 = (i & 64) != 0 ? null : color4;
        Color color10 = (i & 128) != 0 ? null : color5;
        PaletteStyle paletteStyle2 = (i & 256) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i & 512) != 0 ? 0.0d : d;
        if ((i & 1024) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i & 2048) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        return m925dynamicColorSchemeonzyBm0(j, z, z3, color6, color7, color8, color9, color10, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, (i & 4096) != 0 ? null : function1);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x0152  */
    /* JADX WARN: Code duplicated, block: B:112:0x0167  */
    /* JADX WARN: Code duplicated, block: B:114:0x0171  */
    /* JADX WARN: Code duplicated, block: B:120:0x0186  */
    /* JADX WARN: Code duplicated, block: B:122:0x0194  */
    /* JADX WARN: Code duplicated, block: B:124:0x019a  */
    /* JADX WARN: Code duplicated, block: B:125:0x019d  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:144:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:148:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:154:0x020d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0211  */
    /* JADX WARN: Code duplicated, block: B:157:0x0214  */
    /* JADX WARN: Code duplicated, block: B:160:0x0220  */
    /* JADX WARN: Code duplicated, block: B:162:0x0224  */
    /* JADX WARN: Code duplicated, block: B:54:0x008d A[PHI: r21
      0x008d: PHI (r21v9 androidx.compose.ui.graphics.Color) = (r21v2 androidx.compose.ui.graphics.Color), (r21v10 androidx.compose.ui.graphics.Color) binds: [B:53:0x008b, B:49:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0099  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3 A[PHI: r5 r24
      0x00b3: PHI (r5v7 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:64:0x00b1, B:61:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r24v5 boolean) = (r24v1 boolean), (r24v6 boolean) binds: [B:64:0x00b1, B:61:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fb A[PHI: r21
      0x00fb: PHI (r21v7 androidx.compose.ui.graphics.Color) = (r21v4 androidx.compose.ui.graphics.Color), (r21v8 androidx.compose.ui.graphics.Color) binds: [B:83:0x00f9, B:80:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x010a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:98:0x0133  */
    /* JADX INFO: renamed from: rememberDynamicColorScheme-CdFb-wI, reason: not valid java name */
    public static final ColorScheme m927rememberDynamicColorSchemeCdFbwI(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1, Composer composer, int i, int i2, int i3) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        Color color6;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Color color7;
        Color color8;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        GapComposer gapComposer;
        Object objRememberedValue;
        boolean z13 = (i3 & 4) != 0 ? false : z2;
        Color color9 = (i3 & 8) != 0 ? null : color;
        Color color10 = (i3 & 16) != 0 ? null : color2;
        Color color11 = (i3 & 32) != 0 ? null : color3;
        Color color12 = (i3 & 64) != 0 ? null : color4;
        Color color13 = (i3 & 128) != 0 ? null : color5;
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
        Function1 function2 = (i3 & 4096) == 0 ? function1 : null;
        if (((i & 14) ^ 6) > 4) {
            color6 = color9;
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
                    color7 = color6;
                    if (!((GapComposer) composer).changed(color7)) {
                        color8 = color7;
                    }
                    z8 = true;
                    boolean z15 = z8 | z14 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
                    if (((234881024 & i) ^ 100663296) > 67108864) {
                        if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                            z9 = true;
                        } else if ((i & 100663296) == 67108864) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else if ((i & 100663296) == 67108864) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    boolean z16 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z15 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
                    if (((i2 & 14) ^ 6) > 4) {
                        if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                            z10 = true;
                        } else if ((i2 & 6) == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else if ((i2 & 6) == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z17 = z16 | z10;
                    if (((i2 & 112) ^ 48) > 32) {
                        if (!((GapComposer) composer).changed(platform2.ordinal())) {
                            z11 = true;
                        } else if ((i2 & 48) == 32) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else if ((i2 & 48) == 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z12 = z17 | z11;
                    gapComposer = (GapComposer) composer;
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z12 || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    return (ColorScheme) objRememberedValue;
                }
                color7 = color6;
                color8 = color7;
                if ((i & 3072) == 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                boolean z18 = z8 | z14 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
                if (((234881024 & i) ^ 100663296) > 67108864) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 100663296) == 67108864) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z19 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z18 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
                if (((i2 & 14) ^ 6) > 4) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 6) == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z110 = z19 | z10;
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(platform2.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 48) == 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z110 | z11;
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
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
                color7 = color6;
                if (!((GapComposer) composer).changed(color7)) {
                    color8 = color7;
                }
                z8 = true;
                boolean z112 = z8 | z111 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
                if (((234881024 & i) ^ 100663296) > 67108864) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 100663296) == 67108864) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z113 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z112 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
                if (((i2 & 14) ^ 6) > 4) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 6) == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z114 = z113 | z10;
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(platform2.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 48) == 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z114 | z11;
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
            }
            color7 = color6;
            color8 = color7;
            if ((i & 3072) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z115 = z8 | z111 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
            if (((234881024 & i) ^ 100663296) > 67108864) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 100663296) == 67108864) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z116 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z115 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
            if (((i2 & 14) ^ 6) > 4) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 6) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z117 = z116 | z10;
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(platform2.ordinal())) {
                    z11 = true;
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 48) == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z117 | z11;
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
        }
        color6 = color9;
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
                color7 = color6;
                if (!((GapComposer) composer).changed(color7)) {
                    color8 = color7;
                }
                z8 = true;
                boolean z119 = z8 | z118 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
                if (((234881024 & i) ^ 100663296) > 67108864) {
                    if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                        z9 = true;
                    } else if ((i & 100663296) == 67108864) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z1110 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z119 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
                if (((i2 & 14) ^ 6) > 4) {
                    if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                        z10 = true;
                    } else if ((i2 & 6) == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z1111 = z1110 | z10;
                if (((i2 & 112) ^ 48) > 32) {
                    if (!((GapComposer) composer).changed(platform2.ordinal())) {
                        z11 = true;
                    } else if ((i2 & 48) == 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 = z1111 | z11;
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
            }
            color7 = color6;
            color8 = color7;
            if ((i & 3072) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z1112 = z8 | z118 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
            if (((234881024 & i) ^ 100663296) > 67108864) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 100663296) == 67108864) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z1113 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z1112 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
            if (((i2 & 14) ^ 6) > 4) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 6) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z1114 = z1113 | z10;
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(platform2.ordinal())) {
                    z11 = true;
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 48) == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z1114 | z11;
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
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
            color7 = color6;
            if (!((GapComposer) composer).changed(color7)) {
                color8 = color7;
            }
            z8 = true;
            boolean z1116 = z8 | z1115 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
            if (((234881024 & i) ^ 100663296) > 67108864) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z9 = true;
                } else if ((i & 100663296) == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else if ((i & 100663296) == 67108864) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z1117 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z1116 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
            if (((i2 & 14) ^ 6) > 4) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z10 = true;
                } else if ((i2 & 6) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else if ((i2 & 6) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z1118 = z1117 | z10;
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(platform2.ordinal())) {
                    z11 = true;
                } else if ((i2 & 48) == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if ((i2 & 48) == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = z1118 | z11;
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
        }
        color7 = color6;
        color8 = color7;
        if ((i & 3072) == 2048) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean z1119 = z8 | z1115 | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color10)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color11)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color12)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color13)) || (i & 12582912) == 8388608);
        if (((234881024 & i) ^ 100663296) > 67108864) {
            if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                z9 = true;
            } else if ((i & 100663296) == 67108864) {
                z9 = true;
            } else {
                z9 = false;
            }
        } else if ((i & 100663296) == 67108864) {
            z9 = true;
        } else {
            z9 = false;
        }
        boolean z11110 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z1119 | z9 | ((((i2 & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(function2)) || (i2 & 384) == 256);
        if (((i2 & 14) ^ 6) > 4) {
            if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                z10 = true;
            } else if ((i2 & 6) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else if ((i2 & 6) == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11111 = z11110 | z10;
        if (((i2 & 112) ^ 48) > 32) {
            if (!((GapComposer) composer).changed(platform2.ordinal())) {
                z11 = true;
            } else if ((i2 & 48) == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else if ((i2 & 48) == 32) {
            z11 = true;
        } else {
            z11 = false;
        }
        z12 = z11111 | z11;
        gapComposer = (GapComposer) composer;
        objRememberedValue = gapComposer.rememberedValue();
        if (z12) {
            objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = m925dynamicColorSchemeonzyBm0(j, z4, z7, color8, color10, color11, color12, color13, paletteStyle2, d2, colorSpec$SpecVersion2, platform2, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (ColorScheme) objRememberedValue;
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
    /* JADX WARN: Code duplicated, block: B:58:0x0097 A[PHI: r22
      0x0097: PHI (r22v8 androidx.compose.ui.graphics.Color) = (r22v2 androidx.compose.ui.graphics.Color), (r22v9 androidx.compose.ui.graphics.Color) binds: [B:57:0x0095, B:53:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd A[PHI: r5 r25
      0x00bd: PHI (r5v7 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:68:0x00bb, B:65:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x00bd: PHI (r25v5 boolean) = (r25v1 boolean), (r25v6 boolean) binds: [B:68:0x00bb, B:65:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0105 A[PHI: r22
      0x0105: PHI (r22v6 androidx.compose.ui.graphics.Color) = (r22v4 androidx.compose.ui.graphics.Color), (r22v7 androidx.compose.ui.graphics.Color) binds: [B:87:0x0103, B:84:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x0114  */
    /* JADX WARN: Code duplicated, block: B:94:0x011e  */
    /* JADX INFO: renamed from: rememberDynamicColorScheme-UQznLDA, reason: not valid java name */
    public static final ColorScheme m928rememberDynamicColorSchemeUQznLDA(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Function1 function1, Composer composer, int i, int i2, int i3) {
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
        Function1 function2 = (i3 & 8192) == 0 ? function1 : null;
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
                    z12 = z17 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
                    gapComposer = (GapComposer) composer;
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z12 || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    return (ColorScheme) objRememberedValue;
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
                z12 = z110 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
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
                z12 = z114 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
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
            z12 = z117 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
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
                z12 = z1111 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
                gapComposer = (GapComposer) composer;
                objRememberedValue = gapComposer.rememberedValue();
                if (z12) {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                return (ColorScheme) objRememberedValue;
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
            z12 = z1114 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
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
            z12 = z1118 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z12) {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (ColorScheme) objRememberedValue;
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
        z12 = z11111 | z11 | ((((i2 & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(function2)) || (i2 & 3072) == 2048);
        gapComposer = (GapComposer) composer;
        objRememberedValue = gapComposer.rememberedValue();
        if (z12) {
            objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = m923dynamicColorSchemeN98v4SY(j, z4, z7, color9, color11, color12, color13, color14, color15, paletteStyle2, d2, colorSpec$SpecVersion2, platform3, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (ColorScheme) objRememberedValue;
    }

    public static final ColorScheme toColorScheme(DynamicScheme dynamicScheme, boolean z, Function1 function1) {
        long jM;
        ColorScheme colorScheme;
        dynamicScheme.getClass();
        boolean z2 = dynamicScheme.isDark;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        long color = (z && z2) ? -72057594037927936L : DynamicColorKt.getColor(colorSpec2025.background(), dynamicScheme);
        long color2 = DynamicColorKt.getColor(colorSpec2025.error(), dynamicScheme);
        long color3 = DynamicColorKt.getColor(colorSpec2025.errorContainer(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "inverse_on_surface";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 19);
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 20);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 21);
        DynamicColor dynamicColorBuild = dynamicColor$Companion$Builder.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder2.name = "inverse_on_surface";
        dynamicColor$Companion$Builder2.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 13);
        dynamicColor$Companion$Builder2.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 14);
        dynamicColor$Companion$Builder2.background = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 15);
        dynamicColor$Companion$Builder2.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 16);
        long jM2 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder2, dynamicColorBuild, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder3 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder3.name = "inverse_primary";
        dynamicColor$Companion$Builder3.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 8);
        dynamicColor$Companion$Builder3.tone = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 9);
        dynamicColor$Companion$Builder3.background = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 10);
        dynamicColor$Companion$Builder3.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 11);
        DynamicColor dynamicColorBuild2 = dynamicColor$Companion$Builder3.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder4 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder4.name = "inverse_primary";
        dynamicColor$Companion$Builder4.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 12);
        dynamicColor$Companion$Builder4.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 13);
        dynamicColor$Companion$Builder4.background = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 14);
        dynamicColor$Companion$Builder4.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 15);
        long jM3 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder4, dynamicColorBuild2, dynamicScheme);
        long color4 = DynamicColorKt.getColor(colorSpec2025.inverseSurface(), dynamicScheme);
        if (z && z2) {
            jM = -4294967296L;
        } else {
            DynamicColor$Companion$Builder builder = colorSpec2025.onSurface().toBuilder();
            builder.name = "on_background";
            builder.tone = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 19);
            DynamicColor dynamicColorBuild3 = builder.build();
            DynamicColor$Companion$Builder dynamicColor$Companion$Builder5 = new DynamicColor$Companion$Builder();
            dynamicColor$Companion$Builder5.name = "on_background";
            dynamicColor$Companion$Builder5.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 3);
            dynamicColor$Companion$Builder5.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 4);
            dynamicColor$Companion$Builder5.background = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 5);
            dynamicColor$Companion$Builder5.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 6);
            jM = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder5, dynamicColorBuild3, dynamicScheme);
        }
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder6 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder6.name = "on_error";
        dynamicColor$Companion$Builder6.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 28);
        dynamicColor$Companion$Builder6.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 29);
        dynamicColor$Companion$Builder6.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 1);
        DynamicColor dynamicColorBuild4 = dynamicColor$Companion$Builder6.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder7 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder7.name = "on_error";
        dynamicColor$Companion$Builder7.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 21);
        dynamicColor$Companion$Builder7.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 22);
        dynamicColor$Companion$Builder7.background = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 23);
        dynamicColor$Companion$Builder7.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 24);
        long jM4 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder7, dynamicColorBuild4, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder8 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder8.name = "on_error_container";
        dynamicColor$Companion$Builder8.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 29);
        dynamicColor$Companion$Builder8.background = new YouTube$$ExternalSyntheticLambda0((byte) 1);
        dynamicColor$Companion$Builder8.contrastCurve = new YouTube$$ExternalSyntheticLambda0((byte) 2);
        DynamicColor dynamicColorBuild5 = dynamicColor$Companion$Builder8.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder9 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder9.name = "on_error_container";
        dynamicColor$Companion$Builder9.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 6);
        dynamicColor$Companion$Builder9.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 7);
        dynamicColor$Companion$Builder9.background = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 8);
        dynamicColor$Companion$Builder9.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 9);
        long jM5 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder9, dynamicColorBuild5, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder10 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder10.name = "on_primary";
        dynamicColor$Companion$Builder10.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 15);
        dynamicColor$Companion$Builder10.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 16);
        dynamicColor$Companion$Builder10.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 17);
        DynamicColor dynamicColorBuild6 = dynamicColor$Companion$Builder10.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder11 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder11.name = "on_primary";
        dynamicColor$Companion$Builder11.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 21);
        dynamicColor$Companion$Builder11.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 22);
        dynamicColor$Companion$Builder11.background = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 23);
        dynamicColor$Companion$Builder11.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 24);
        long jM6 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder11, dynamicColorBuild6, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder12 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder12.name = "on_primary_container";
        dynamicColor$Companion$Builder12.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 4);
        dynamicColor$Companion$Builder12.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 5);
        dynamicColor$Companion$Builder12.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 6);
        DynamicColor dynamicColorBuild7 = dynamicColor$Companion$Builder12.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder13 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder13.name = "on_primary_container";
        dynamicColor$Companion$Builder13.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 7);
        dynamicColor$Companion$Builder13.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 8);
        dynamicColor$Companion$Builder13.background = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 9);
        dynamicColor$Companion$Builder13.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 10);
        long jM7 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder13, dynamicColorBuild7, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder14 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder14.name = "on_secondary";
        dynamicColor$Companion$Builder14.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 0);
        dynamicColor$Companion$Builder14.background = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 13);
        dynamicColor$Companion$Builder14.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 21);
        DynamicColor dynamicColorBuild8 = dynamicColor$Companion$Builder14.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder15 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder15.name = "on_secondary";
        dynamicColor$Companion$Builder15.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 16);
        dynamicColor$Companion$Builder15.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 18);
        dynamicColor$Companion$Builder15.background = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 19);
        dynamicColor$Companion$Builder15.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 20);
        long jM8 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder15, dynamicColorBuild8, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder16 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder16.name = "on_secondary_container";
        dynamicColor$Companion$Builder16.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 22);
        dynamicColor$Companion$Builder16.background = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 23);
        dynamicColor$Companion$Builder16.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 24);
        DynamicColor dynamicColorBuild9 = dynamicColor$Companion$Builder16.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder17 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder17.name = "on_secondary_container";
        dynamicColor$Companion$Builder17.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 8);
        dynamicColor$Companion$Builder17.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 9);
        dynamicColor$Companion$Builder17.background = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 10);
        dynamicColor$Companion$Builder17.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 11);
        long jM9 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder17, dynamicColorBuild9, dynamicScheme);
        long color5 = (z && z2) ? -4294967296L : DynamicColorKt.getColor(colorSpec2025.onSurface(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder18 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder18.name = "on_surface_variant";
        dynamicColor$Companion$Builder18.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 10);
        dynamicColor$Companion$Builder18.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 11);
        dynamicColor$Companion$Builder18.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 12);
        dynamicColor$Companion$Builder18.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 13);
        DynamicColor dynamicColorBuild10 = dynamicColor$Companion$Builder18.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder19 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder19.name = "on_surface_variant";
        dynamicColor$Companion$Builder19.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 21);
        dynamicColor$Companion$Builder19.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 22);
        Class<ColorSpec2021> cls = ColorSpec2021.class;
        dynamicColor$Companion$Builder19.background = new NetworkFetcher.AnonymousClass2(1, colorSpec2025, cls, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 11);
        dynamicColor$Companion$Builder19.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 23);
        long jM10 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder19, dynamicColorBuild10, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder20 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder20.name = "on_tertiary";
        dynamicColor$Companion$Builder20.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 1);
        dynamicColor$Companion$Builder20.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 2);
        dynamicColor$Companion$Builder20.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 3);
        DynamicColor dynamicColorBuild11 = dynamicColor$Companion$Builder20.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder21 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder21.name = "on_tertiary";
        dynamicColor$Companion$Builder21.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 17);
        dynamicColor$Companion$Builder21.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 18);
        dynamicColor$Companion$Builder21.background = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 19);
        dynamicColor$Companion$Builder21.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 20);
        long jM11 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder21, dynamicColorBuild11, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder22 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder22.name = "on_tertiary_container";
        dynamicColor$Companion$Builder22.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 28);
        dynamicColor$Companion$Builder22.background = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 29);
        dynamicColor$Companion$Builder22.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 1);
        DynamicColor dynamicColorBuild12 = dynamicColor$Companion$Builder22.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder23 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder23.name = "on_tertiary_container";
        dynamicColor$Companion$Builder23.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 2);
        dynamicColor$Companion$Builder23.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 3);
        dynamicColor$Companion$Builder23.background = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 4);
        dynamicColor$Companion$Builder23.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 5);
        long jM12 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder23, dynamicColorBuild12, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder24 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder24.name = "outline";
        dynamicColor$Companion$Builder24.palette = new YouTube$$ExternalSyntheticLambda0((byte) 7);
        dynamicColor$Companion$Builder24.chromaMultiplier = new YouTube$$ExternalSyntheticLambda0((byte) 8);
        dynamicColor$Companion$Builder24.background = new YouTube$$ExternalSyntheticLambda0((byte) 9);
        dynamicColor$Companion$Builder24.contrastCurve = new YouTube$$ExternalSyntheticLambda0((byte) 10);
        DynamicColor dynamicColorBuild13 = dynamicColor$Companion$Builder24.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder25 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder25.name = "outline";
        dynamicColor$Companion$Builder25.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 28);
        dynamicColor$Companion$Builder25.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 29);
        int i = 0;
        dynamicColor$Companion$Builder25.background = new NetworkFetcher.AnonymousClass2(1, colorSpec2025, cls, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", i, (byte) 12);
        dynamicColor$Companion$Builder25.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 1);
        long jM13 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder25, dynamicColorBuild13, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder26 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder26.name = "outline_variant";
        dynamicColor$Companion$Builder26.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 2);
        dynamicColor$Companion$Builder26.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 3);
        dynamicColor$Companion$Builder26.background = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 4);
        dynamicColor$Companion$Builder26.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 5);
        DynamicColor dynamicColorBuild14 = dynamicColor$Companion$Builder26.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder27 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder27.name = "outline_variant";
        dynamicColor$Companion$Builder27.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 5);
        dynamicColor$Companion$Builder27.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 6);
        dynamicColor$Companion$Builder27.background = new NetworkFetcher.AnonymousClass2(1, colorSpec2025, cls, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", i, (byte) 13);
        dynamicColor$Companion$Builder27.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 7);
        long jM14 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder27, dynamicColorBuild14, dynamicScheme);
        long color6 = DynamicColorKt.getColor(colorSpec2025.primary(), dynamicScheme);
        long color7 = DynamicColorKt.getColor(colorSpec2025.primaryContainer(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder28 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder28.name = "scrim";
        dynamicColor$Companion$Builder28.palette = new RoomDatabase$$ExternalSyntheticLambda2((byte) 24);
        dynamicColor$Companion$Builder28.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 0);
        long color8 = DynamicColorKt.getColor(dynamicColor$Companion$Builder28.build(), dynamicScheme);
        long color9 = DynamicColorKt.getColor(colorSpec2025.secondary(), dynamicScheme);
        long color10 = DynamicColorKt.getColor(colorSpec2025.secondaryContainer(), dynamicScheme);
        long color11 = (z && z2) ? -72057594037927936L : DynamicColorKt.getColor(colorSpec2025.surface(), dynamicScheme);
        DynamicColor$Companion$Builder builder2 = colorSpec2025.primary().toBuilder();
        builder2.name = "surface_tint";
        DynamicColor dynamicColorBuild15 = builder2.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder29 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder29.name = "surface_tint";
        dynamicColor$Companion$Builder29.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 27);
        dynamicColor$Companion$Builder29.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 0);
        dynamicColor$Companion$Builder29.isBackground = true;
        long jM15 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder29, dynamicColorBuild15, dynamicScheme);
        long color12 = DynamicColorKt.getColor(colorSpec2025.surfaceBright(), dynamicScheme);
        long color13 = DynamicColorKt.getColor(colorSpec2025.surfaceDim(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder30 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder30.name = "surface_container";
        dynamicColor$Companion$Builder30.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 8);
        dynamicColor$Companion$Builder30.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 9);
        dynamicColor$Companion$Builder30.isBackground = true;
        dynamicColor$Companion$Builder30.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 10);
        DynamicColor dynamicColorBuild16 = dynamicColor$Companion$Builder30.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder31 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder31.name = "surface_container";
        dynamicColor$Companion$Builder31.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 25);
        dynamicColor$Companion$Builder31.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 26);
        dynamicColor$Companion$Builder31.isBackground = true;
        long jM16 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder31, dynamicColorBuild16, dynamicScheme);
        long color14 = DynamicColorKt.getColor(colorSpec2025.surfaceContainerHigh(), dynamicScheme);
        long color15 = DynamicColorKt.getColor(colorSpec2025.surfaceContainerHighest(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder32 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder32.name = "surface_container_low";
        dynamicColor$Companion$Builder32.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 18);
        dynamicColor$Companion$Builder32.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 19);
        dynamicColor$Companion$Builder32.isBackground = true;
        dynamicColor$Companion$Builder32.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 20);
        DynamicColor dynamicColorBuild17 = dynamicColor$Companion$Builder32.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder33 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder33.name = "surface_container_low";
        dynamicColor$Companion$Builder33.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 18);
        dynamicColor$Companion$Builder33.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 19);
        dynamicColor$Companion$Builder33.isBackground = true;
        long jM17 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder33, dynamicColorBuild17, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder34 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder34.name = "surface_container_lowest";
        dynamicColor$Companion$Builder34.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 17);
        dynamicColor$Companion$Builder34.tone = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 18);
        dynamicColor$Companion$Builder34.isBackground = true;
        DynamicColor dynamicColorBuild18 = dynamicColor$Companion$Builder34.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder35 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder35.name = "surface_container_lowest";
        dynamicColor$Companion$Builder35.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 8);
        dynamicColor$Companion$Builder35.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 9);
        dynamicColor$Companion$Builder35.isBackground = true;
        long jM18 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder35, dynamicColorBuild18, dynamicScheme);
        DynamicColor$Companion$Builder builder3 = colorSpec2025.surfaceContainerHighest().toBuilder();
        builder3.name = "surface_variant";
        DynamicColor dynamicColorBuild19 = builder3.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder36 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder36.name = "surface_variant";
        dynamicColor$Companion$Builder36.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 0);
        dynamicColor$Companion$Builder36.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 17);
        dynamicColor$Companion$Builder36.isBackground = true;
        long jM19 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder36, dynamicColorBuild19, dynamicScheme);
        long color16 = DynamicColorKt.getColor(colorSpec2025.tertiary(), dynamicScheme);
        long color17 = DynamicColorKt.getColor(colorSpec2025.tertiaryContainer(), dynamicScheme);
        long color18 = DynamicColorKt.getColor(colorSpec2025.primaryFixed(), dynamicScheme);
        long color19 = DynamicColorKt.getColor(colorSpec2025.primaryFixedDim(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder37 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder37.name = "on_primary_fixed";
        dynamicColor$Companion$Builder37.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 15);
        dynamicColor$Companion$Builder37.background = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 16);
        dynamicColor$Companion$Builder37.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 17);
        DynamicColor dynamicColorBuild20 = dynamicColor$Companion$Builder37.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder38 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder38.name = "on_primary_fixed";
        dynamicColor$Companion$Builder38.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 24);
        dynamicColor$Companion$Builder38.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 26);
        dynamicColor$Companion$Builder38.background = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 27);
        dynamicColor$Companion$Builder38.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 28);
        dynamicColor$Companion$Builder38.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 29);
        long jM20 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder38, dynamicColorBuild20, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder39 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder39.name = "on_primary_fixed_variant";
        dynamicColor$Companion$Builder39.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 7);
        dynamicColor$Companion$Builder39.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 8);
        dynamicColor$Companion$Builder39.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 9);
        DynamicColor dynamicColorBuild21 = dynamicColor$Companion$Builder39.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder40 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder40.name = "on_primary_fixed_variant";
        dynamicColor$Companion$Builder40.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 6);
        dynamicColor$Companion$Builder40.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 7);
        dynamicColor$Companion$Builder40.background = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 8);
        dynamicColor$Companion$Builder40.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 9);
        dynamicColor$Companion$Builder40.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 10);
        long jM21 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder40, dynamicColorBuild21, dynamicScheme);
        long color20 = DynamicColorKt.getColor(colorSpec2025.secondaryFixed(), dynamicScheme);
        long color21 = DynamicColorKt.getColor(colorSpec2025.secondaryFixedDim(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder41 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder41.name = "on_secondary_fixed";
        dynamicColor$Companion$Builder41.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 12);
        dynamicColor$Companion$Builder41.background = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 14);
        dynamicColor$Companion$Builder41.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 15);
        DynamicColor dynamicColorBuild22 = dynamicColor$Companion$Builder41.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder42 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder42.name = "on_secondary_fixed";
        dynamicColor$Companion$Builder42.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 15);
        dynamicColor$Companion$Builder42.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 17);
        dynamicColor$Companion$Builder42.background = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 18);
        dynamicColor$Companion$Builder42.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 19);
        dynamicColor$Companion$Builder42.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 20);
        long jM22 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder42, dynamicColorBuild22, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder43 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder43.name = "on_secondary_fixed_variant";
        dynamicColor$Companion$Builder43.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 26);
        dynamicColor$Companion$Builder43.background = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 27);
        dynamicColor$Companion$Builder43.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 28);
        DynamicColor dynamicColorBuild23 = dynamicColor$Companion$Builder43.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder44 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder44.name = "on_secondary_fixed_variant";
        dynamicColor$Companion$Builder44.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 1);
        dynamicColor$Companion$Builder44.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 2);
        dynamicColor$Companion$Builder44.background = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 3);
        dynamicColor$Companion$Builder44.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 4);
        dynamicColor$Companion$Builder44.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 5);
        long jM23 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder44, dynamicColorBuild23, dynamicScheme);
        long color22 = DynamicColorKt.getColor(colorSpec2025.tertiaryFixed(), dynamicScheme);
        long color23 = DynamicColorKt.getColor(colorSpec2025.tertiaryFixedDim(), dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder45 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder45.name = "on_tertiary_fixed";
        dynamicColor$Companion$Builder45.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 0);
        dynamicColor$Companion$Builder45.background = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 18);
        dynamicColor$Companion$Builder45.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 25);
        DynamicColor dynamicColorBuild24 = dynamicColor$Companion$Builder45.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder46 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder46.name = "on_tertiary_fixed";
        dynamicColor$Companion$Builder46.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 12);
        dynamicColor$Companion$Builder46.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 13);
        dynamicColor$Companion$Builder46.background = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 14);
        dynamicColor$Companion$Builder46.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 15);
        dynamicColor$Companion$Builder46.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 16);
        long jM24 = Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder46, dynamicColorBuild24, dynamicScheme);
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder47 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder47.name = "on_tertiary_fixed_variant";
        dynamicColor$Companion$Builder47.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 9);
        dynamicColor$Companion$Builder47.background = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 10);
        dynamicColor$Companion$Builder47.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 11);
        DynamicColor dynamicColorBuild25 = dynamicColor$Companion$Builder47.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder48 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder48.name = "on_tertiary_fixed_variant";
        dynamicColor$Companion$Builder48.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 26);
        dynamicColor$Companion$Builder48.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 27);
        dynamicColor$Companion$Builder48.background = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 28);
        dynamicColor$Companion$Builder48.secondBackground = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 29);
        dynamicColor$Companion$Builder48.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 1);
        ColorScheme colorScheme2 = new ColorScheme(color6, jM6, color7, jM7, jM3, color9, jM8, color10, jM9, color16, jM11, color17, jM12, color, jM, color11, color5, jM19, jM10, jM15, color4, jM2, color2, jM4, color3, jM5, jM13, jM14, color8, color12, color13, jM16, color14, color15, jM17, jM18, color18, color19, jM20, jM21, color20, color21, jM22, jM23, color22, color23, jM24, Format$$ExternalSyntheticOutline0.m(dynamicColor$Companion$Builder48, dynamicColorBuild25, dynamicScheme));
        return (function1 == null || (colorScheme = (ColorScheme) function1.invoke(colorScheme2)) == null) ? colorScheme2 : colorScheme;
    }

    public static /* synthetic */ ColorScheme toColorScheme$default(DynamicScheme dynamicScheme, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return toColorScheme(dynamicScheme, z, function1);
    }
}
