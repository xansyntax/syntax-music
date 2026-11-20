package com.metrolist.music.ui.theme;

import android.graphics.Bitmap;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.palette.graphics.Palette;
import com.google.common.math.IntMath;
import com.materialkolor.DynamicColorSchemeKt;
import com.materialkolor.PaletteStyle;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ThemeKt {
    public static final Path.Companion ColorSaver;
    public static final Typography EditorialTypography;
    public static final Typography GlassTypography;
    public static final Shapes EditorialShapes = new Shapes(RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(4.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
    public static final Shapes GlassShapes = new Shapes(RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(14.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(20.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(28.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(36.0f));
    public static final ColorScheme PaperLight = ColorSchemeKt.m285lightColorScheme_VG5OTI$default(-29200683781586944L, -4294967296L, -39792871997440L, -56281801202597888L, -81793357185024L, -44369322860085248L, -4294967296L, -6507103086706688L, -64146500501897216L, -71943889073733632L, -4294967296L, -6507103086706688L, -64146500501897216L, -570693779456000L, -64146500501897216L, -570693779456000L, -64146500501897216L, -7068906283859968L, -40978377460416512L, -29200683781586944L, -57930871075766272L, -2831328340869120L, 0, -33369718341500928L, -8201471979945984L, 0, -570693779456000L, -3679064690786304L, -5374533095653376L, -7068906283859968L, -2265066967662592L, -4294967296L, -9612111038644224L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 331350016, 65520);
    public static final ColorScheme PaperDark = ColorSchemeKt.m283darkColorScheme_VG5OTI$default(-17343425833598976L, -4294967296L, -29200683781586944L, -39792871997440L, -29200683781586944L, -14418188032802816L, -63583567728345088L, -59062294310551552L, -5091988672086016L, -40577639831830528L, -72022267931918336L, -59062294310551552L, -5091988672086016L, -64711658068508672L, -5091988672086016L, -64711658068508672L, -5091988672086016L, -59062294310551552L, -24591024231809024L, -17343425833598976L, -5091988672086016L, -64711658068508672L, -40978377460416512L, -57931983472295936L, 0, -56237614579056640L, -61886974042046464L, -59062294310551552L, -56237614579056640L, -63299867958575104L, -66124551985037312L, -66124551985037312L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 331350016, 65520);
    public static final ColorScheme GlassLight = ColorSchemeKt.m285lightColorScheme_VG5OTI$default(-7494000671981568L, -4294967296L, -37580963840000L, -54307052549308416L, -81793357185024L, -20138526125326336L, -4294967296L, 4099788859489910784L, -54307052549308416L, -11745627452997632L, -4294967296L, 3735249262519255040L, -51217321796042752L, -2266179364192256L, -64430187386765312L, -2266179364192256L, -64430187386765312L, 7357501998519812096L, -46350690057977856L, -7494000671981568L, -60192609443774464L, -2266179364192256L, 0, -33071703445733376L, 3682564702585487360L, 0, -4294967296L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, -7071135371886592L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 331350016, 65520);
    public static final ColorScheme GlassDark = ColorSchemeKt.m283darkColorScheme_VG5OTI$default(-141441862991872L, -55716643635986432L, -42174972528951296L, -37580963840000L, -7494000671981568L, -78769700208640L, -55694661993365504L, 4683602170602323968L, -37580963840000L, -123488899694592L, -51217321796042752L, 4683620123565621248L, -41901700939776L, -68667739559952384L, -2830228829241344L, -68667739559952384L, -2830228829241344L, 3026418945298006016L, -18657964999049216L, -141441862991872L, -2830228829241344L, -64712761875103744L, -31375114054402048L, 3386706915487645696L, 0, 3746994885677285376L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, -68667739559952384L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 331350016, 65520);

    static {
        Typography typography = new Typography();
        FontWeight fontWeight = FontWeight.Normal;
        TextStyle textStyle = typography.displayLarge;
        TextStyle textStyleSerif = serif(textStyle, fontWeight, -0.7f);
        TextStyle textStyle2 = typography.displayMedium;
        TextStyle textStyleSerif2 = serif(textStyle2, fontWeight, -0.6f);
        TextStyle textStyle3 = typography.displaySmall;
        TextStyle textStyleSerif3 = serif(textStyle3, fontWeight, -0.5f);
        TextStyle textStyle4 = typography.headlineLarge;
        TextStyle textStyleSerif4 = serif(textStyle4, fontWeight, -0.4f);
        FontWeight fontWeight2 = FontWeight.Medium;
        TextStyle textStyle5 = typography.headlineMedium;
        TextStyle textStyleSerif5 = serif(textStyle5, fontWeight2, -0.2f);
        TextStyle textStyle6 = typography.headlineSmall;
        TextStyle textStyleSerif6 = serif(textStyle6, fontWeight2, CropImageView.DEFAULT_ASPECT_RATIO);
        TextStyle textStyle7 = typography.titleLarge;
        TextStyle textStyleSerif7 = serif(textStyle7, fontWeight2, CropImageView.DEFAULT_ASPECT_RATIO);
        FontWeight fontWeight3 = FontWeight.SemiBold;
        TextStyle textStyle8 = typography.titleMedium;
        TextStyle textStyleSans = sans(textStyle8, fontWeight3, 0.1f);
        TextStyle textStyle9 = typography.titleSmall;
        TextStyle textStyleSans2 = sans(textStyle9, fontWeight3, 0.1f);
        TextStyle textStyle10 = typography.bodyLarge;
        TextStyle textStyleSans3 = sans(textStyle10, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO);
        TextStyle textStyle11 = typography.bodyMedium;
        TextStyle textStyleSans4 = sans(textStyle11, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO);
        TextStyle textStyle12 = typography.bodySmall;
        TextStyle textStyleSans5 = sans(textStyle12, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO);
        TextStyle textStyle13 = typography.labelLarge;
        TextStyle textStyleSans6 = sans(textStyle13, fontWeight3, 0.5f);
        TextStyle textStyle14 = typography.labelMedium;
        TextStyle textStyleSans7 = sans(textStyle14, fontWeight2, 0.9f);
        FontWeight fontWeight4 = FontWeight.Bold;
        TextStyle textStyle15 = typography.labelSmall;
        EditorialTypography = typography.copy(textStyleSerif, textStyleSerif2, textStyleSerif3, textStyleSerif4, textStyleSerif5, textStyleSerif6, textStyleSerif7, textStyleSans, textStyleSans2, textStyleSans3, textStyleSans4, textStyleSans5, textStyleSans6, textStyleSans7, sans(textStyle15, fontWeight4, 1.2f));
        GlassTypography = typography.copy(sans(textStyle, fontWeight4, -1.0f), sans(textStyle2, fontWeight4, -0.8f), sans(textStyle3, fontWeight4, -0.6f), sans(textStyle4, fontWeight4, -0.5f), sans(textStyle5, fontWeight4, -0.4f), sans(textStyle6, fontWeight3, -0.3f), sans(textStyle7, fontWeight3, -0.2f), sans(textStyle8, fontWeight3, CropImageView.DEFAULT_ASPECT_RATIO), sans(textStyle9, fontWeight3, CropImageView.DEFAULT_ASPECT_RATIO), sans(textStyle10, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO), sans(textStyle11, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO), sans(textStyle12, fontWeight, CropImageView.DEFAULT_ASPECT_RATIO), sans(textStyle13, fontWeight3, 0.2f), sans(textStyle14, fontWeight2, 0.4f), sans(textStyle15, fontWeight4, 0.8f));
        ColorSaver = new Path.Companion((byte) 6);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01be  */
    /* JADX WARN: Code duplicated, block: B:104:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x01d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:115:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:119:0x0223  */
    /* JADX WARN: Code duplicated, block: B:122:0x0231  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x0066  */
    /* JADX WARN: Code duplicated, block: B:42:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    /* JADX WARN: Code duplicated, block: B:47:0x007a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0083  */
    /* JADX WARN: Code duplicated, block: B:54:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2 A[PHI: r8 r10
      0x00b2: PHI (r8v11 boolean) = (r8v5 boolean), (r8v2 boolean) binds: [B:69:0x00be, B:63:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x00b2: PHI (r10v11 long) = (r10v4 long), (r10v2 long) binds: [B:69:0x00be, B:63:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:89:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x014f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0178  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:98:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b4  */
    /* JADX INFO: renamed from: MetrolistTheme-T042LqI, reason: not valid java name */
    public static final void m1515MetrolistThemeT042LqI(boolean z, boolean z2, long j, UiStyle uiStyle, ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        long j2;
        int i5;
        int i6;
        int iOrdinal;
        int i7;
        boolean z4;
        final ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer;
        final UiStyle uiStyle2;
        final long j3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        boolean z5;
        UiStyle uiStyle3;
        boolean z6;
        boolean z7;
        int i8;
        UiStyle uiStyle4;
        int i9;
        ColorScheme colorSchemeM928rememberDynamicColorSchemeUQznLDA;
        ColorScheme colorScheme;
        boolean z8;
        ColorScheme colorSchemeM280copy_VG5OTI$default;
        boolean z9;
        boolean z10;
        Object objRememberedValue;
        ColorScheme colorSchemeM280copy_VG5OTI$default2;
        int i10;
        final boolean z11 = z;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(224682706);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(z11) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                z3 = z2;
                i3 |= gapComposer2.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    j2 = j;
                    if (gapComposer2.changed(j2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    if (uiStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = uiStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (gapComposer2.changedInstance(composableLambdaImpl)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i3 |= i10;
                }
                if ((i3 & 9363) != 9362) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer2.shouldExecute(i3 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            z3 = false;
                        }
                        if (i4 != 0) {
                            j2 = -17343425833598976L;
                        }
                        if (i6 != 0) {
                            z5 = z3;
                            uiStyle3 = UiStyle.EDITORIAL;
                            j2 = j2;
                        }
                        gapComposer2.endDefaults();
                        if (uiStyle3 == UiStyle.GLASS) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (ULong.m1869equalsimpl0(j2, -17343425833598976L)) {
                            gapComposer2.startReplaceGroup(1963912962);
                            gapComposer2.end(false);
                            if (!z6 && z) {
                                colorScheme = GlassDark;
                            } else if (z6) {
                                colorScheme = GlassLight;
                            } else if (z) {
                                colorScheme = PaperDark;
                            } else {
                                colorScheme = PaperLight;
                            }
                            gapComposer = gapComposer2;
                            i8 = i3;
                            i9 = 32;
                            uiStyle4 = uiStyle3;
                            z7 = z6;
                            z8 = false;
                            z11 = z;
                        } else {
                            gapComposer2.startReplaceGroup(1964094932);
                            z7 = z6;
                            i8 = i3;
                            uiStyle4 = uiStyle3;
                            i9 = 32;
                            colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(j2, z, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, ColorSpec$SpecVersion.SPEC_2025, null, null, gapComposer2, ((i3 >> 6) & 14) | 805306368 | ((i3 << 3) & 112), 48, 13820);
                            z11 = z;
                            gapComposer = gapComposer2;
                            if (z7) {
                                if (z11) {
                                    colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3386706915487645696L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, 2013265919, 65520);
                                } else {
                                    colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3682564702585487360L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, 2013265919, 65520);
                                }
                                colorScheme = colorSchemeM280copy_VG5OTI$default;
                            } else {
                                colorScheme = colorSchemeM928rememberDynamicColorSchemeUQznLDA;
                            }
                            z8 = false;
                            gapComposer.end(false);
                        }
                        boolean zChanged = gapComposer.changed(colorScheme);
                        if ((i8 & 112) == i9) {
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        z10 = zChanged | z9 | (((((i8 & 14) ^ 6) > 4 || !gapComposer.changed(z11)) && (i8 & 6) != 4) ? z8 : true);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (z10 || objRememberedValue == Composer.Companion.Empty) {
                            if (z11 || !z5) {
                                colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                            } else {
                                colorScheme.getClass();
                                colorSchemeM280copy_VG5OTI$default2 = ColorScheme.m280copy_VG5OTI$default(colorScheme, 0L, 0L, 0L, 0L, 0L, 0L, -40961, DatagramKt.MAX_DATAGRAM_SIZE);
                            }
                            gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                            objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                        }
                        UiStyle uiStyle5 = uiStyle4;
                        composableLambdaImpl2 = composableLambdaImpl;
                        Stack.CompositionLocalProvider(UiStyleKt.LocalUiStyle.defaultProvidedValue$runtime(uiStyle5), Expect_jvmKt.rememberComposableLambda(1071765010, new StringValuesKt$$ExternalSyntheticLambda1((ColorScheme) objRememberedValue, z7, composableLambdaImpl2), gapComposer), gapComposer, 56);
                        uiStyle2 = uiStyle5;
                        z3 = z5;
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    z5 = z3;
                    j2 = j2;
                    uiStyle3 = uiStyle;
                    gapComposer2.endDefaults();
                    if (uiStyle3 == UiStyle.GLASS) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (ULong.m1869equalsimpl0(j2, -17343425833598976L)) {
                        gapComposer2.startReplaceGroup(1963912962);
                        gapComposer2.end(false);
                        if (!z6) {
                            if (z6) {
                                colorScheme = GlassLight;
                            } else if (z) {
                                colorScheme = PaperDark;
                            } else {
                                colorScheme = PaperLight;
                            }
                        } else if (z6) {
                            colorScheme = GlassLight;
                        } else if (z) {
                            colorScheme = PaperDark;
                        } else {
                            colorScheme = PaperLight;
                        }
                        gapComposer = gapComposer2;
                        i8 = i3;
                        i9 = 32;
                        uiStyle4 = uiStyle3;
                        z7 = z6;
                        z8 = false;
                        z11 = z;
                    } else {
                        gapComposer2.startReplaceGroup(1964094932);
                        z7 = z6;
                        i8 = i3;
                        uiStyle4 = uiStyle3;
                        i9 = 32;
                        colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(j2, z, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, ColorSpec$SpecVersion.SPEC_2025, null, null, gapComposer2, ((i3 >> 6) & 14) | 805306368 | ((i3 << 3) & 112), 48, 13820);
                        z11 = z;
                        gapComposer = gapComposer2;
                        if (z7) {
                            if (z11) {
                                colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3386706915487645696L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, 2013265919, 65520);
                            } else {
                                colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3682564702585487360L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, 2013265919, 65520);
                            }
                            colorScheme = colorSchemeM280copy_VG5OTI$default;
                        } else {
                            colorScheme = colorSchemeM928rememberDynamicColorSchemeUQznLDA;
                        }
                        z8 = false;
                        gapComposer.end(false);
                    }
                    boolean zChanged2 = gapComposer.changed(colorScheme);
                    if ((i8 & 112) == i9) {
                        z9 = true;
                    } else {
                        z9 = z8;
                    }
                    z10 = zChanged2 | z9 | (((((i8 & 14) ^ 6) > 4 || !gapComposer.changed(z11)) && (i8 & 6) != 4) ? z8 : true);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z10) {
                        if (z11) {
                            colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                        } else {
                            colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                        }
                        gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                        objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                    } else {
                        if (z11) {
                            colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                        } else {
                            colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                        }
                        gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                        objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                    }
                    UiStyle uiStyle6 = uiStyle4;
                    composableLambdaImpl2 = composableLambdaImpl;
                    Stack.CompositionLocalProvider(UiStyleKt.LocalUiStyle.defaultProvidedValue$runtime(uiStyle6), Expect_jvmKt.rememberComposableLambda(1071765010, new StringValuesKt$$ExternalSyntheticLambda1((ColorScheme) objRememberedValue, z7, composableLambdaImpl2), gapComposer), gapComposer, 56);
                    uiStyle2 = uiStyle6;
                    z3 = z5;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    uiStyle2 = uiStyle;
                }
                j3 = j2;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z12 = z3;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            ThemeKt.m1515MetrolistThemeT042LqI(z11, z12, j3, uiStyle2, composableLambdaImpl2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i3 |= 384;
            j2 = j;
            i6 = i2 & 8;
            if (i6 != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (uiStyle == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = uiStyle.ordinal();
                }
                if (gapComposer2.changed(iOrdinal)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (gapComposer2.changedInstance(composableLambdaImpl)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i3 |= i10;
            }
            if ((i3 & 9363) != 9362) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        z3 = false;
                    }
                    if (i4 != 0) {
                        j2 = -17343425833598976L;
                    }
                    if (i6 != 0) {
                        z5 = z3;
                        uiStyle3 = UiStyle.EDITORIAL;
                        j2 = j2;
                    } else {
                        z5 = z3;
                        j2 = j2;
                        uiStyle3 = uiStyle;
                    }
                } else {
                    if (i11 != 0) {
                        z3 = false;
                    }
                    if (i4 != 0) {
                        j2 = -17343425833598976L;
                    }
                    if (i6 != 0) {
                        z5 = z3;
                        uiStyle3 = UiStyle.EDITORIAL;
                        j2 = j2;
                    } else {
                        z5 = z3;
                        j2 = j2;
                        uiStyle3 = uiStyle;
                    }
                }
                gapComposer2.endDefaults();
                if (uiStyle3 == UiStyle.GLASS) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (ULong.m1869equalsimpl0(j2, -17343425833598976L)) {
                    gapComposer2.startReplaceGroup(1963912962);
                    gapComposer2.end(false);
                    if (!z6) {
                        if (z6) {
                            colorScheme = GlassLight;
                        } else if (z) {
                            colorScheme = PaperDark;
                        } else {
                            colorScheme = PaperLight;
                        }
                    } else if (z6) {
                        colorScheme = GlassLight;
                    } else if (z) {
                        colorScheme = PaperDark;
                    } else {
                        colorScheme = PaperLight;
                    }
                    gapComposer = gapComposer2;
                    i8 = i3;
                    i9 = 32;
                    uiStyle4 = uiStyle3;
                    z7 = z6;
                    z8 = false;
                    z11 = z;
                } else {
                    gapComposer2.startReplaceGroup(1964094932);
                    z7 = z6;
                    i8 = i3;
                    uiStyle4 = uiStyle3;
                    i9 = 32;
                    colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(j2, z, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, ColorSpec$SpecVersion.SPEC_2025, null, null, gapComposer2, ((i3 >> 6) & 14) | 805306368 | ((i3 << 3) & 112), 48, 13820);
                    z11 = z;
                    gapComposer = gapComposer2;
                    if (z7) {
                        if (z11) {
                            colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3386706915487645696L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, 2013265919, 65520);
                        } else {
                            colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3682564702585487360L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, 2013265919, 65520);
                        }
                        colorScheme = colorSchemeM280copy_VG5OTI$default;
                    } else {
                        colorScheme = colorSchemeM928rememberDynamicColorSchemeUQznLDA;
                    }
                    z8 = false;
                    gapComposer.end(false);
                }
                boolean zChanged3 = gapComposer.changed(colorScheme);
                if ((i8 & 112) == i9) {
                    z9 = true;
                } else {
                    z9 = z8;
                }
                z10 = zChanged3 | z9 | (((((i8 & 14) ^ 6) > 4 || !gapComposer.changed(z11)) && (i8 & 6) != 4) ? z8 : true);
                objRememberedValue = gapComposer.rememberedValue();
                if (z10) {
                    if (z11) {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    } else {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    }
                    gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                    objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                } else {
                    if (z11) {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    } else {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    }
                    gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                    objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                }
                UiStyle uiStyle7 = uiStyle4;
                composableLambdaImpl2 = composableLambdaImpl;
                Stack.CompositionLocalProvider(UiStyleKt.LocalUiStyle.defaultProvidedValue$runtime(uiStyle7), Expect_jvmKt.rememberComposableLambda(1071765010, new StringValuesKt$$ExternalSyntheticLambda1((ColorScheme) objRememberedValue, z7, composableLambdaImpl2), gapComposer), gapComposer, 56);
                uiStyle2 = uiStyle7;
                z3 = z5;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                uiStyle2 = uiStyle;
            }
            j3 = j2;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z13 = z3;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        ThemeKt.m1515MetrolistThemeT042LqI(z11, z13, j3, uiStyle2, composableLambdaImpl2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 48;
        z3 = z2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                j2 = j;
                if (gapComposer2.changed(j2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (uiStyle == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = uiStyle.ordinal();
                }
                if (gapComposer2.changed(iOrdinal)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (gapComposer2.changedInstance(composableLambdaImpl)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i3 |= i10;
            }
            if ((i3 & 9363) != 9362) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        z3 = false;
                    }
                    if (i4 != 0) {
                        j2 = -17343425833598976L;
                    }
                    if (i6 != 0) {
                        z5 = z3;
                        uiStyle3 = UiStyle.EDITORIAL;
                        j2 = j2;
                    } else {
                        z5 = z3;
                        j2 = j2;
                        uiStyle3 = uiStyle;
                    }
                } else {
                    if (i11 != 0) {
                        z3 = false;
                    }
                    if (i4 != 0) {
                        j2 = -17343425833598976L;
                    }
                    if (i6 != 0) {
                        z5 = z3;
                        uiStyle3 = UiStyle.EDITORIAL;
                        j2 = j2;
                    } else {
                        z5 = z3;
                        j2 = j2;
                        uiStyle3 = uiStyle;
                    }
                }
                gapComposer2.endDefaults();
                if (uiStyle3 == UiStyle.GLASS) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (ULong.m1869equalsimpl0(j2, -17343425833598976L)) {
                    gapComposer2.startReplaceGroup(1963912962);
                    gapComposer2.end(false);
                    if (!z6) {
                        if (z6) {
                            colorScheme = GlassLight;
                        } else if (z) {
                            colorScheme = PaperDark;
                        } else {
                            colorScheme = PaperLight;
                        }
                    } else if (z6) {
                        colorScheme = GlassLight;
                    } else if (z) {
                        colorScheme = PaperDark;
                    } else {
                        colorScheme = PaperLight;
                    }
                    gapComposer = gapComposer2;
                    i8 = i3;
                    i9 = 32;
                    uiStyle4 = uiStyle3;
                    z7 = z6;
                    z8 = false;
                    z11 = z;
                } else {
                    gapComposer2.startReplaceGroup(1964094932);
                    z7 = z6;
                    i8 = i3;
                    uiStyle4 = uiStyle3;
                    i9 = 32;
                    colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(j2, z, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, ColorSpec$SpecVersion.SPEC_2025, null, null, gapComposer2, ((i3 >> 6) & 14) | 805306368 | ((i3 << 3) & 112), 48, 13820);
                    z11 = z;
                    gapComposer = gapComposer2;
                    if (z7) {
                        if (z11) {
                            colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3386706915487645696L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, 2013265919, 65520);
                        } else {
                            colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3682564702585487360L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, 2013265919, 65520);
                        }
                        colorScheme = colorSchemeM280copy_VG5OTI$default;
                    } else {
                        colorScheme = colorSchemeM928rememberDynamicColorSchemeUQznLDA;
                    }
                    z8 = false;
                    gapComposer.end(false);
                }
                boolean zChanged4 = gapComposer.changed(colorScheme);
                if ((i8 & 112) == i9) {
                    z9 = true;
                } else {
                    z9 = z8;
                }
                z10 = zChanged4 | z9 | (((((i8 & 14) ^ 6) > 4 || !gapComposer.changed(z11)) && (i8 & 6) != 4) ? z8 : true);
                objRememberedValue = gapComposer.rememberedValue();
                if (z10) {
                    if (z11) {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    } else {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    }
                    gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                    objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                } else {
                    if (z11) {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    } else {
                        colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                    }
                    gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                    objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
                }
                UiStyle uiStyle8 = uiStyle4;
                composableLambdaImpl2 = composableLambdaImpl;
                Stack.CompositionLocalProvider(UiStyleKt.LocalUiStyle.defaultProvidedValue$runtime(uiStyle8), Expect_jvmKt.rememberComposableLambda(1071765010, new StringValuesKt$$ExternalSyntheticLambda1((ColorScheme) objRememberedValue, z7, composableLambdaImpl2), gapComposer), gapComposer, 56);
                uiStyle2 = uiStyle8;
                z3 = z5;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                uiStyle2 = uiStyle;
            }
            j3 = j2;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z14 = z3;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        ThemeKt.m1515MetrolistThemeT042LqI(z11, z14, j3, uiStyle2, composableLambdaImpl2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 384;
        j2 = j;
        i6 = i2 & 8;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (uiStyle == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = uiStyle.ordinal();
            }
            if (gapComposer2.changed(iOrdinal)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i & 24576) == 0) {
            if (gapComposer2.changedInstance(composableLambdaImpl)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        }
        if ((i3 & 9363) != 9362) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (gapComposer2.shouldExecute(i3 & 1, z4)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    z3 = false;
                }
                if (i4 != 0) {
                    j2 = -17343425833598976L;
                }
                if (i6 != 0) {
                    z5 = z3;
                    uiStyle3 = UiStyle.EDITORIAL;
                    j2 = j2;
                } else {
                    z5 = z3;
                    j2 = j2;
                    uiStyle3 = uiStyle;
                }
            } else {
                if (i11 != 0) {
                    z3 = false;
                }
                if (i4 != 0) {
                    j2 = -17343425833598976L;
                }
                if (i6 != 0) {
                    z5 = z3;
                    uiStyle3 = UiStyle.EDITORIAL;
                    j2 = j2;
                } else {
                    z5 = z3;
                    j2 = j2;
                    uiStyle3 = uiStyle;
                }
            }
            gapComposer2.endDefaults();
            if (uiStyle3 == UiStyle.GLASS) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (ULong.m1869equalsimpl0(j2, -17343425833598976L)) {
                gapComposer2.startReplaceGroup(1963912962);
                gapComposer2.end(false);
                if (!z6) {
                    if (z6) {
                        colorScheme = GlassLight;
                    } else if (z) {
                        colorScheme = PaperDark;
                    } else {
                        colorScheme = PaperLight;
                    }
                } else if (z6) {
                    colorScheme = GlassLight;
                } else if (z) {
                    colorScheme = PaperDark;
                } else {
                    colorScheme = PaperLight;
                }
                gapComposer = gapComposer2;
                i8 = i3;
                i9 = 32;
                uiStyle4 = uiStyle3;
                z7 = z6;
                z8 = false;
                z11 = z;
            } else {
                gapComposer2.startReplaceGroup(1964094932);
                z7 = z6;
                i8 = i3;
                uiStyle4 = uiStyle3;
                i9 = 32;
                colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(j2, z, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, ColorSpec$SpecVersion.SPEC_2025, null, null, gapComposer2, ((i3 >> 6) & 14) | 805306368 | ((i3 << 3) & 112), 48, 13820);
                z11 = z;
                gapComposer = gapComposer2;
                if (z7) {
                    if (z11) {
                        colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3386706915487645696L, 1729382252615303168L, 2305843004918726656L, 3026418945298006016L, 1152921500311879680L, 648518342046384128L, 2013265919, 65520);
                    } else {
                        colorSchemeM280copy_VG5OTI$default = ColorScheme.m280copy_VG5OTI$default(colorSchemeM928rememberDynamicColorSchemeUQznLDA, 3682564702585487360L, -7349874596163616768L, -5476377151177490432L, -3674937300229292032L, -9151314447111815168L, 7421932181611610112L, 2013265919, 65520);
                    }
                    colorScheme = colorSchemeM280copy_VG5OTI$default;
                } else {
                    colorScheme = colorSchemeM928rememberDynamicColorSchemeUQznLDA;
                }
                z8 = false;
                gapComposer.end(false);
            }
            boolean zChanged5 = gapComposer.changed(colorScheme);
            if ((i8 & 112) == i9) {
                z9 = true;
            } else {
                z9 = z8;
            }
            z10 = zChanged5 | z9 | (((((i8 & 14) ^ 6) > 4 || !gapComposer.changed(z11)) && (i8 & 6) != 4) ? z8 : true);
            objRememberedValue = gapComposer.rememberedValue();
            if (z10) {
                if (z11) {
                    colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                } else {
                    colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                }
                gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
            } else {
                if (z11) {
                    colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                } else {
                    colorSchemeM280copy_VG5OTI$default2 = colorScheme;
                }
                gapComposer.updateRememberedValue(colorSchemeM280copy_VG5OTI$default2);
                objRememberedValue = colorSchemeM280copy_VG5OTI$default2;
            }
            UiStyle uiStyle9 = uiStyle4;
            composableLambdaImpl2 = composableLambdaImpl;
            Stack.CompositionLocalProvider(UiStyleKt.LocalUiStyle.defaultProvidedValue$runtime(uiStyle9), Expect_jvmKt.rememberComposableLambda(1071765010, new StringValuesKt$$ExternalSyntheticLambda1((ColorScheme) objRememberedValue, z7, composableLambdaImpl2), gapComposer), gapComposer, 56);
            uiStyle2 = uiStyle9;
            z3 = z5;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            uiStyle2 = uiStyle;
        }
        j3 = j2;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z15 = z3;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ThemeKt.m1515MetrolistThemeT042LqI(z11, z15, j3, uiStyle2, composableLambdaImpl2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final long extractThemeColor(Bitmap bitmap) {
        Palette.Builder builder = new Palette.Builder(bitmap);
        builder.mMaxColors = (byte) 8;
        Palette paletteGenerate = builder.generate();
        int iM498toArgb8_81llA = ColorKt.m498toArgb8_81llA(-17343425833598976L);
        List<Palette.Swatch> listUnmodifiableList = Collections.unmodifiableList(paletteGenerate.mSwatches);
        listUnmodifiableList.getClass();
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listUnmodifiableList, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (Palette.Swatch swatch : listUnmodifiableList) {
            linkedHashMap.put(Integer.valueOf(swatch.mRgb), Integer.valueOf(swatch.mPopulation));
        }
        return ((long) ((Number) CollectionsKt.first((List) EntryPoints.score(linkedHashMap, 1, Integer.valueOf(iM498toArgb8_81llA), true))).intValue()) << 32;
    }

    public static final TextStyle sans(TextStyle textStyle, FontWeight fontWeight, float f) {
        return TextStyle.m750copyp1EtxEg$default(textStyle, 0L, 0L, fontWeight, null, FontKt.DmSansFamily, null, IntMath.pack(4294967296L, f), 0L, null, null, 16777051);
    }

    public static final TextStyle serif(TextStyle textStyle, FontWeight fontWeight, float f) {
        return TextStyle.m750copyp1EtxEg$default(textStyle, 0L, 0L, fontWeight, null, FontKt.NewsreaderFamily, null, IntMath.pack(4294967296L, f), 0L, null, null, 16777051);
    }
}
