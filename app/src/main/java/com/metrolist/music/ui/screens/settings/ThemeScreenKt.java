package com.metrolist.music.ui.screens.settings;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.R$styleable;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TonalPalette;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.materialkolor.DynamicColorSchemeKt;
import com.materialkolor.PaletteStyle;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.http.parsing.ParserDslKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ThemeScreenKt {
    public static final List PaletteColors = CollectionsKt__IterablesKt.listOf((Object[]) new ThemePalette[]{new ThemePalette(R.string.palette_dynamic, 0), new ThemePalette(R.string.palette_crimson, -5536711060750336L), new ThemePalette(R.string.palette_rose, -11228899937615872L), new ThemePalette(R.string.palette_purple, -32047834781974528L), new ThemePalette(R.string.palette_deep_purple, -45539911901642752L), new ThemePalette(R.string.palette_indigo, -55932521577185280L), new ThemePalette(R.string.palette_blue, -63462827607719936L), new ThemePalette(R.string.palette_sky_blue, -71041761257979904L), new ThemePalette(R.string.palette_cyan, -71867649109262336L), new ThemePalette(R.string.palette_teal, -71906432663945216L), new ThemePalette(R.string.palette_green, -53022543795191808L), new ThemePalette(R.string.palette_light_green, -36957600876593152L), new ThemePalette(R.string.palette_lime, -17792078117339136L), new ThemePalette(R.string.palette_yellow, -606702785265664L), new ThemePalette(R.string.palette_amber, -84662395338752L), new ThemePalette(R.string.palette_orange, -1253443255664640L), new ThemePalette(R.string.palette_deep_orange, -3288510429659136L), new ThemePalette(R.string.palette_brown, -41292979519881216L), new ThemePalette(R.string.palette_grey, -38995876391157760L), new ThemePalette(R.string.palette_blue_grey, -48292225729167360L)});

    /* JADX INFO: renamed from: LandscapeThemeLayout-V-9fs2A, reason: not valid java name */
    public static final void m1510LandscapeThemeLayoutV9fs2A(PaddingValuesImpl paddingValuesImpl, DarkMode darkMode, Function1 function1, boolean z, Function1 function2, long j, Function1 function3, Composer composer, int i) {
        GapComposer gapComposer;
        darkMode.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1968496074);
        int i2 = i | (gapComposer2.changed(darkMode.ordinal()) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | (gapComposer2.changed(z) ? 2048 : 1024) | (gapComposer2.changedInstance(function2) ? 16384 : 8192) | (gapComposer2.changed(j) ? 131072 : 65536) | (gapComposer2.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer2.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            Modifier modifierPadding = OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValuesImpl);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPadding);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z2 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            if (0.4f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(0.4f > Float.MAX_VALUE ? Float.MAX_VALUE : 0.4f, true);
            FillElement fillElement = SizeKt.FillWholeMaxHeight;
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(layoutWeightElement.then(fillElement), 16.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterHorizontally, gapComposer2, 54);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM147heightInVpY3zN4$default = SizeKt.m147heightInVpY3zN4$default(SizeKt.fillMaxWidth(companion, 0.8f), CropImageView.DEFAULT_ASPECT_RATIO, 300.0f, 1);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM147heightInVpY3zN4$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            int i3 = i2 >> 3;
            m1513ThemeMockupXOJAsU(darkMode, z, j, gapComposer2, (i3 & 14) | ((i2 >> 6) & 112) | ((i2 >> 9) & 896));
            gapComposer2.end(true);
            gapComposer2.end(true);
            if (0.6f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(ImageKt.scroll$default(new LayoutWeightElement(0.6f > Float.MAX_VALUE ? Float.MAX_VALUE : 0.6f, true).then(fillElement), ImageKt.rememberScrollState(gapComposer2), true), CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 16.0f, 16.0f, 1);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
            int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
            m1512ThemeControlsyrwZFoE(darkMode, function1, z, function2, j, function3, gapComposer2, i3 & 524286);
            gapComposer = gapComposer2;
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 80.0f));
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda3(paddingValuesImpl, darkMode, function1, z, function2, j, function3, i, (byte) 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static final void ModeCircle(final DarkMode darkMode, final boolean z, final DarkMode darkMode2, final boolean z2, final boolean z3, final Function0 function0, Composer composer, final int i) throws Throwable {
        GapComposer gapComposer;
        ?? r5;
        ColorScheme colorSchemeM928rememberDynamicColorSchemeUQznLDA;
        GapComposer gapComposer2;
        long j;
        String strM;
        long j2;
        GapComposer gapComposer3;
        int i2;
        ColorScheme colorSchemeM285lightColorScheme_VG5OTI$default;
        darkMode.getClass();
        function0.getClass();
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(-1619844149);
        int i3 = (gapComposer4.changed(darkMode.ordinal()) ? 4 : 2) | i | (gapComposer4.changed(z) ? 32 : 16);
        if ((i & 3072) == 0) {
            i3 |= gapComposer4.changed(z2) ? 2048 : 1024;
        }
        int i4 = i3 | (gapComposer4.changedInstance(function0) ? 131072 : 65536);
        if (gapComposer4.shouldExecute(i4 & 1, (74899 & i4) != 74898)) {
            Context context = (Context) gapComposer4.consume(AndroidCompositionLocals_androidKt.LocalContext);
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer4);
            boolean z4 = darkMode == darkMode2 && z == z2;
            int iOrdinal = darkMode2.ordinal();
            if (iOrdinal == 0) {
                zIsSystemInDarkTheme = true;
            } else if (iOrdinal == 1) {
                zIsSystemInDarkTheme = false;
            } else if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            if (darkMode2 != DarkMode.AUTO || (i2 = Build.VERSION.SDK_INT) < 31) {
                gapComposer4.startReplaceGroup(1476261288);
                Shapes shapes = ThemeKt.EditorialShapes;
                r5 = 0;
                colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(-17343425833598976L, zIsSystemInDarkTheme, false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, null, null, null, gapComposer4, 805306368, 0, 15868);
                GapComposer gapComposer5 = gapComposer4;
                gapComposer5.end(false);
                gapComposer2 = gapComposer5;
            } else {
                gapComposer4.startReplaceGroup(1476149967);
                gapComposer4.end(false);
                int[] iArr = R$styleable.mc3_scheme;
                if (zIsSystemInDarkTheme) {
                    if (i2 >= 34) {
                        Resources.Theme theme = context.getTheme();
                        if (theme == null) {
                            theme = context.getResources().newTheme();
                        }
                        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(R.style.mc3_dark_scheme, iArr);
                        try {
                            colorSchemeM285lightColorScheme_VG5OTI$default = ColorSchemeKt.m283darkColorScheme_VG5OTI$default(((long) typedArrayObtainStyledAttributes.getColor(21, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(5, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(22, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(6, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(2, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(25, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(9, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(26, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(10, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(39, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(15, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(40, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(16, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(0, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(4, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(29, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(13, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(38, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(14, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(37, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(3, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(1, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(19, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(20, 0)) << 32, 0L, ((long) typedArrayObtainStyledAttributes.getColor(30, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(31, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(32, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(33, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(34, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(35, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(36, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(23, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(24, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(7, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(8, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(27, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(28, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(11, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(12, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(41, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(42, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(17, 0)) << 32, ((long) typedArrayObtainStyledAttributes.getColor(18, 0)) << 32, 331350016, 0);
                            typedArrayObtainStyledAttributes.recycle();
                        } catch (Throwable th) {
                            typedArrayObtainStyledAttributes.recycle();
                            throw th;
                        }
                    } else {
                        TonalPalette tonalPaletteDynamicTonalPalette = CardKt.dynamicTonalPalette(context);
                        long j3 = tonalPaletteDynamicTonalPalette.primary80;
                        long j4 = tonalPaletteDynamicTonalPalette.primary20;
                        long j5 = tonalPaletteDynamicTonalPalette.primary30;
                        long j6 = tonalPaletteDynamicTonalPalette.primary90;
                        long j7 = tonalPaletteDynamicTonalPalette.primary40;
                        long j8 = tonalPaletteDynamicTonalPalette.secondary80;
                        long j9 = tonalPaletteDynamicTonalPalette.secondary20;
                        long j10 = tonalPaletteDynamicTonalPalette.secondary30;
                        long j11 = tonalPaletteDynamicTonalPalette.secondary90;
                        long j12 = tonalPaletteDynamicTonalPalette.tertiary80;
                        long j13 = tonalPaletteDynamicTonalPalette.tertiary20;
                        long j14 = tonalPaletteDynamicTonalPalette.tertiary30;
                        long j15 = tonalPaletteDynamicTonalPalette.tertiary90;
                        long j16 = tonalPaletteDynamicTonalPalette.neutralVariant6;
                        long j17 = tonalPaletteDynamicTonalPalette.neutralVariant90;
                        long j18 = tonalPaletteDynamicTonalPalette.neutralVariant30;
                        colorSchemeM285lightColorScheme_VG5OTI$default = ColorSchemeKt.m283darkColorScheme_VG5OTI$default(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j16, j17, j18, tonalPaletteDynamicTonalPalette.neutralVariant80, j3, j17, tonalPaletteDynamicTonalPalette.neutralVariant20, tonalPaletteDynamicTonalPalette.neutralVariant60, j18, tonalPaletteDynamicTonalPalette.neutralVariant0, tonalPaletteDynamicTonalPalette.neutralVariant24, tonalPaletteDynamicTonalPalette.neutralVariant12, tonalPaletteDynamicTonalPalette.neutralVariant17, tonalPaletteDynamicTonalPalette.neutralVariant22, tonalPaletteDynamicTonalPalette.neutralVariant10, tonalPaletteDynamicTonalPalette.neutralVariant4, j16, j6, j3, tonalPaletteDynamicTonalPalette.primary10, j5, j11, j8, tonalPaletteDynamicTonalPalette.secondary10, j10, j15, j12, tonalPaletteDynamicTonalPalette.tertiary10, j14, 62914560, 0);
                    }
                } else if (i2 >= 34) {
                    Resources.Theme theme2 = context.getTheme();
                    if (theme2 == null) {
                        theme2 = context.getResources().newTheme();
                    }
                    TypedArray typedArrayObtainStyledAttributes2 = theme2.obtainStyledAttributes(R.style.mc3_light_scheme, iArr);
                    try {
                        colorSchemeM285lightColorScheme_VG5OTI$default = ColorSchemeKt.m285lightColorScheme_VG5OTI$default(((long) typedArrayObtainStyledAttributes2.getColor(21, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(5, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(22, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(6, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(2, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(25, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(9, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(26, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(10, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(39, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(15, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(40, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(16, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(0, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(4, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(29, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(13, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(38, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(14, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(37, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(3, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(1, 0)) << 32, 0L, ((long) typedArrayObtainStyledAttributes2.getColor(19, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(20, 0)) << 32, 0L, ((long) typedArrayObtainStyledAttributes2.getColor(30, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(31, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(32, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(33, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(34, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(35, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(36, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(23, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(24, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(7, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(8, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(27, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(28, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(11, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(12, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(41, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(42, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(17, 0)) << 32, ((long) typedArrayObtainStyledAttributes2.getColor(18, 0)) << 32, 331350016, 0);
                        typedArrayObtainStyledAttributes2.recycle();
                    } catch (Throwable th2) {
                        typedArrayObtainStyledAttributes2.recycle();
                        throw th2;
                    }
                } else {
                    TonalPalette tonalPaletteDynamicTonalPalette2 = CardKt.dynamicTonalPalette(context);
                    long j19 = tonalPaletteDynamicTonalPalette2.primary40;
                    long j20 = tonalPaletteDynamicTonalPalette2.primary100;
                    long j21 = tonalPaletteDynamicTonalPalette2.primary90;
                    long j22 = tonalPaletteDynamicTonalPalette2.primary10;
                    long j23 = tonalPaletteDynamicTonalPalette2.primary80;
                    long j24 = tonalPaletteDynamicTonalPalette2.secondary40;
                    long j25 = tonalPaletteDynamicTonalPalette2.secondary100;
                    long j26 = tonalPaletteDynamicTonalPalette2.secondary90;
                    long j27 = tonalPaletteDynamicTonalPalette2.secondary10;
                    long j28 = tonalPaletteDynamicTonalPalette2.tertiary40;
                    long j29 = tonalPaletteDynamicTonalPalette2.tertiary100;
                    long j30 = tonalPaletteDynamicTonalPalette2.tertiary90;
                    long j31 = tonalPaletteDynamicTonalPalette2.tertiary10;
                    long j32 = tonalPaletteDynamicTonalPalette2.neutralVariant98;
                    long j33 = tonalPaletteDynamicTonalPalette2.neutralVariant10;
                    long j34 = tonalPaletteDynamicTonalPalette2.neutralVariant90;
                    colorSchemeM285lightColorScheme_VG5OTI$default = ColorSchemeKt.m285lightColorScheme_VG5OTI$default(j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j32, j33, j34, tonalPaletteDynamicTonalPalette2.neutralVariant30, j19, tonalPaletteDynamicTonalPalette2.neutralVariant20, tonalPaletteDynamicTonalPalette2.neutralVariant95, 0L, tonalPaletteDynamicTonalPalette2.neutralVariant50, tonalPaletteDynamicTonalPalette2.neutralVariant80, tonalPaletteDynamicTonalPalette2.neutralVariant0, j32, tonalPaletteDynamicTonalPalette2.neutralVariant94, tonalPaletteDynamicTonalPalette2.neutralVariant92, j34, tonalPaletteDynamicTonalPalette2.neutralVariant96, tonalPaletteDynamicTonalPalette2.neutralVariant100, tonalPaletteDynamicTonalPalette2.neutralVariant87, j21, j23, j22, tonalPaletteDynamicTonalPalette2.primary30, j26, tonalPaletteDynamicTonalPalette2.secondary80, j27, tonalPaletteDynamicTonalPalette2.secondary30, j30, tonalPaletteDynamicTonalPalette2.tertiary80, j31, tonalPaletteDynamicTonalPalette2.tertiary30, 62914560, 0);
                }
                colorSchemeM928rememberDynamicColorSchemeUQznLDA = colorSchemeM285lightColorScheme_VG5OTI$default;
                r5 = 0;
                gapComposer2 = gapComposer4;
            }
            if (z2) {
                j = -72057594037927936L;
            } else {
                j = zIsSystemInDarkTheme ? colorSchemeM928rememberDynamicColorSchemeUQznLDA.surface : colorSchemeM928rememberDynamicColorSchemeUQznLDA.surface;
            }
            float f = z4 ? 2.0f : 1.0f;
            Object objRememberedValue = gapComposer2.rememberedValue();
            Object obj = Composer.Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            if (z2) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, -1892024362, R.string.cd_pure_black_mode, gapComposer2, (boolean) r5);
            } else if (darkMode2 == DarkMode.OFF) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, -1892021743, R.string.cd_light_mode, gapComposer2, (boolean) r5);
            } else {
                strM = darkMode2 == DarkMode.ON ? Format$$ExternalSyntheticOutline0.m(gapComposer2, -1892019312, R.string.cd_dark_mode, gapComposer2, (boolean) r5) : Format$$ExternalSyntheticOutline0.m(gapComposer2, -1892017582, R.string.cd_system_mode, gapComposer2, (boolean) r5);
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 48.0f);
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifierM151size3ABfNKs, roundedCornerShape), j, ColorKt.RectangleShape);
            if (z4) {
                gapComposer2.startReplaceGroup(-1892007916);
                j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
            } else {
                gapComposer2.startReplaceGroup(-1892006599);
                j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
            }
            gapComposer2.end(r5);
            Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(ImageKt.m42borderxT4_qwU(modifierM39backgroundbw27NRU, f, j2, roundedCornerShape), mutableInteractionSourceImpl, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 255), false, null, function0, 28);
            boolean zChanged = gapComposer2.changed(strM);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == obj) {
                objRememberedValue2 = new StringsKt__IndentKt$$ExternalSyntheticLambda0(strM, (byte) 16);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM45clickableO2vRcR0$default, r5, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, r5);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierSemantics);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (z3) {
                gapComposer2.startReplaceGroup(1164725697);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, r5, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), colorSchemeM928rememberDynamicColorSchemeUQznLDA.onSurface, gapComposer2, 440, 0);
                gapComposer2.end(r5);
                gapComposer3 = gapComposer2;
            } else if (z4) {
                gapComposer2.startReplaceGroup(1165027017);
                GapComposer gapComposer6 = gapComposer2;
                CrossfadeKt.AnimatedVisibility(z4, null, EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, r5, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m15scaleInL8ZKhE$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 0.3f, 4)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(150, r5, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m16scaleOutL8ZKhE$default(ArcSplineKt.tween$default(150, r5, null, 6), 0.3f, 4)), null, AiSettingsKt.f535lambda$241123446, gapComposer6, 196608, 18);
                GapComposer gapComposer7 = gapComposer6;
                gapComposer7.end(r5);
                gapComposer3 = gapComposer7;
            } else {
                gapComposer2.startReplaceGroup(1165967185);
                gapComposer2.end(r5);
                gapComposer3 = gapComposer2;
            }
            gapComposer3.end(true);
            gapComposer = gapComposer3;
        } else {
            gapComposer4.skipToGroupEnd();
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) throws Throwable {
                    ((Integer) obj3).getClass();
                    ThemeScreenKt.ModeCircle(darkMode, z, darkMode2, z2, z3, function0, (Composer) obj2, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void PaletteItem(ThemePalette themePalette, boolean z, Function0 function0, Composer composer, int i) {
        float f;
        long j;
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1610727190);
        int i2 = i | (gapComposer.changed(themePalette) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            ColorScheme colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(themePalette.seedColor, ImageKt.isSystemInDarkTheme(gapComposer), false, null, null, null, null, null, null, PaletteStyle.TonalSpot, 0.0d, null, null, null, gapComposer, 805306368, 0, 15868);
            if (z) {
                gapComposer = gapComposer;
                f = 2.0f;
            } else {
                gapComposer = gapComposer;
                f = 1.0f;
            }
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            String strStringResource = MathKt.stringResource(R.string.cd_palette_item, new Object[]{MathKt.stringResource(themePalette.nameRes, gapComposer)}, gapComposer);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), roundedCornerShapeM185RoundedCornerShape0680j_4);
            if (z) {
                gapComposer.startReplaceGroup(1720629759);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
            } else {
                gapComposer.startReplaceGroup(1720631076);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
            }
            gapComposer.end(false);
            Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(ImageKt.m42borderxT4_qwU(modifierClip, f, j, roundedCornerShapeM185RoundedCornerShape0680j_4), mutableInteractionSourceImpl, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 255), false, null, function0, 28);
            boolean zChanged = gapComposer.changed(strStringResource);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new StringsKt__IndentKt$$ExternalSyntheticLambda0(strStringResource, (byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM45clickableO2vRcR0$default, false, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierSemantics);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            if (ULong.m1869equalsimpl0(themePalette.seedColor, 0L)) {
                gapComposer.startReplaceGroup(829922628);
                FillElement fillElement = SizeKt.FillWholeMaxSize;
                Shapes shapes = ThemeKt.EditorialShapes;
                Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, -17343425833598976L, ColorKt.RectangleShape);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.palette, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 22.0f), -4294967296L, gapComposer, 3512, 0);
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(830478644);
                FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                boolean zChanged2 = gapComposer.changed(colorSchemeM928rememberDynamicColorSchemeUQznLDA);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new MimesKt$$ExternalSyntheticLambda0((byte) 17, colorSchemeM928rememberDynamicColorSchemeUQznLDA);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                ImageKt.Canvas(6, gapComposer, fillElement2, (Function1) objRememberedValue3);
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(themePalette, z, function0, i, (byte) 13);
        }
    }

    /* JADX INFO: renamed from: PortraitThemeLayout-V-9fs2A, reason: not valid java name */
    public static final void m1511PortraitThemeLayoutV9fs2A(PaddingValuesImpl paddingValuesImpl, DarkMode darkMode, Function1 function1, boolean z, Function1 function2, long j, Function1 function3, Composer composer, int i) {
        GapComposer gapComposer;
        darkMode.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-2074669106);
        int i2 = i | (gapComposer2.changed(darkMode.ordinal()) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | (gapComposer2.changed(z) ? 2048 : 1024) | (gapComposer2.changedInstance(function2) ? 16384 : 8192) | (gapComposer2.changed(j) ? 131072 : 65536) | (gapComposer2.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer2.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            Modifier modifierPadding = OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValuesImpl);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPadding);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z2 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer2, columnScopeInstance.weight(companion, 1.0f, true));
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion, 120.0f), 240.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM145height3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            int i3 = i2 >> 3;
            m1514ThemeMockupPortraitXOJAsU(darkMode, z, j, gapComposer2, (i3 & 14) | ((i2 >> 6) & 112) | ((i2 >> 9) & 896));
            gapComposer2.end(true);
            OffsetKt.Spacer(gapComposer2, columnScopeInstance.weight(companion, 1.0f, true));
            m1512ThemeControlsyrwZFoE(darkMode, function1, z, function2, j, function3, gapComposer2, i3 & 524286);
            gapComposer = gapComposer2;
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 120.0f));
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda3(paddingValuesImpl, darkMode, function1, z, function2, j, function3, i, (byte) 0);
        }
    }

    /* JADX INFO: renamed from: ThemeControls-yrwZFoE, reason: not valid java name */
    public static final void m1512ThemeControlsyrwZFoE(final DarkMode darkMode, final Function1 function1, final boolean z, final Function1 function2, final long j, final Function1 function3, Composer composer, int i) {
        int i2;
        GapComposer gapComposer;
        darkMode.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1338403310);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(darkMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 131072 : 65536;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh8 = GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            gapComposer = gapComposer2;
            CardKt.Card(modifierM137paddingVpY3zN4$default, roundedCornerShapeM1480glassShapeixp7dh8, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer, 0L, gapComposer, 14), CardKt.m268cardElevationaqJV_2Y(CropImageView.DEFAULT_ASPECT_RATIO), ImageKt.m38BorderStrokecXLIe8U(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, 1.0f), Expect_jvmKt.rememberComposableLambda(1179860192, new Function3() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
                    final byte b;
                    Composer composer2 = (Composer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 20.0f);
                        Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(24.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpacedAligned, horizontal, gapComposer3, 6);
                        int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs);
                        ComposeUiNode.Companion.getClass();
                        gapComposer3.startReusableNode();
                        boolean z2 = gapComposer3.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z2) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer3);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer3, 6);
                        int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.theme_mode, gapComposer3), null, 0L, gapComposer3, 0, 6);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.CenterHorizontally;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 2, horizontal2)), Alignment.Companion.CenterVertically, gapComposer3, 54);
                        int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                        final Function1 function4 = function1;
                        boolean zChanged = gapComposer3.changed(function4);
                        Object objRememberedValue = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new ParserDslKt$$ExternalSyntheticLambda0(function4, (byte) 14);
                            gapComposer3.updateRememberedValue(objRememberedValue);
                        }
                        DarkMode darkMode2 = darkMode;
                        boolean z3 = z;
                        ThemeScreenKt.ModeCircle(darkMode2, z3, DarkMode.AUTO, z3, true, (Function0) objRememberedValue, gapComposer3, 24960);
                        BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion, 1.0f), 32.0f), ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant, ColorKt.RectangleShape), gapComposer3, 0);
                        boolean zChanged2 = gapComposer3.changed(function4);
                        final Function1 function5 = function2;
                        boolean zChanged3 = zChanged2 | gapComposer3.changed(function5);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                            final byte b2 = 0;
                            objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    DarkMode darkMode3 = DarkMode.ON;
                                    Unit unit = Unit.INSTANCE;
                                    Function1 function6 = function5;
                                    Function1 function7 = function4;
                                    switch (b3) {
                                        case 0:
                                            function7.invoke(DarkMode.OFF);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        case 1:
                                            function7.invoke(darkMode3);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        default:
                                            function7.invoke(darkMode3);
                                            function6.invoke(Boolean.TRUE);
                                            break;
                                    }
                                    return unit;
                                }
                            };
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        ThemeScreenKt.ModeCircle(darkMode2, z3, DarkMode.OFF, false, false, (Function0) objRememberedValue2, gapComposer3, 28032);
                        boolean zChanged4 = gapComposer3.changed(function4) | gapComposer3.changed(function5);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                            final byte b3 = 1;
                            objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    DarkMode darkMode3 = DarkMode.ON;
                                    Unit unit = Unit.INSTANCE;
                                    Function1 function6 = function5;
                                    Function1 function7 = function4;
                                    switch (b4) {
                                        case 0:
                                            function7.invoke(DarkMode.OFF);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        case 1:
                                            function7.invoke(darkMode3);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        default:
                                            function7.invoke(darkMode3);
                                            function6.invoke(Boolean.TRUE);
                                            break;
                                    }
                                    return unit;
                                }
                            };
                            gapComposer3.updateRememberedValue(objRememberedValue3);
                        }
                        DarkMode darkMode3 = DarkMode.ON;
                        ThemeScreenKt.ModeCircle(darkMode2, z3, darkMode3, false, false, (Function0) objRememberedValue3, gapComposer3, 28032);
                        boolean zChanged5 = gapComposer3.changed(function4) | gapComposer3.changed(function5);
                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                        if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                            b = 2;
                            objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b;
                                    DarkMode darkMode4 = DarkMode.ON;
                                    Unit unit = Unit.INSTANCE;
                                    Function1 function6 = function5;
                                    Function1 function7 = function4;
                                    switch (b4) {
                                        case 0:
                                            function7.invoke(DarkMode.OFF);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        case 1:
                                            function7.invoke(darkMode4);
                                            function6.invoke(Boolean.FALSE);
                                            break;
                                        default:
                                            function7.invoke(darkMode4);
                                            function6.invoke(Boolean.TRUE);
                                            break;
                                    }
                                    return unit;
                                }
                            };
                            gapComposer3.updateRememberedValue(objRememberedValue4);
                        } else {
                            b = 2;
                        }
                        byte b4 = b;
                        ThemeScreenKt.ModeCircle(darkMode2, z3, darkMode3, true, false, (Function0) objRememberedValue4, gapComposer3, 28032);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                        ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer3, 6);
                        int iHashCode4 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                        DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.color_palette, gapComposer3), null, 0L, gapComposer3, 0, 6);
                        Arrangement$SpacedAligned arrangement$SpacedAligned2 = new Arrangement$SpacedAligned(12.0f, true, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(b4, horizontal2));
                        PaddingValuesImpl paddingValuesImplM127PaddingValuesYgX7TsA$default = OffsetKt.m127PaddingValuesYgX7TsA$default(b4, 4.0f);
                        long j2 = j;
                        boolean zChanged6 = gapComposer3.changed(j2);
                        Function1 function6 = function3;
                        boolean zChanged7 = zChanged6 | gapComposer3.changed(function6);
                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                        if (zChanged7 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new ScrimKt$$ExternalSyntheticLambda1(j2, function6, (byte) 5);
                            gapComposer3.updateRememberedValue(objRememberedValue5);
                        }
                        IntMath.LazyRow(null, null, paddingValuesImplM127PaddingValuesYgX7TsA$default, arrangement$SpacedAligned2, null, null, false, null, (Function1) objRememberedValue5, gapComposer3, 24960, 491);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196614, 0);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderDefaults$$ExternalSyntheticLambda3(darkMode, function1, z, function2, j, function3, i);
        }
    }

    /* JADX INFO: renamed from: ThemeMockup-XO-JAsU, reason: not valid java name */
    public static final void m1513ThemeMockupXOJAsU(DarkMode darkMode, boolean z, long j, Composer composer, int i) {
        int i2;
        boolean z2;
        long j2;
        darkMode.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(812685412);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(darkMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i2 |= gapComposer.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            j2 = j;
            i2 |= gapComposer.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer);
            int iOrdinal = darkMode.ordinal();
            if (iOrdinal == 0) {
                zIsSystemInDarkTheme = true;
            } else if (iOrdinal == 1) {
                zIsSystemInDarkTheme = false;
            } else if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            ThemeKt.m1515MetrolistThemeT042LqI(zIsSystemInDarkTheme, z2, j2, null, AiSettingsKt.lambda$1952148295, gapComposer, (i2 & 112) | 24576 | (i2 & 896), 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda6(darkMode, z, j, i, (byte) 0);
        }
    }

    /* JADX INFO: renamed from: ThemeMockupPortrait-XO-JAsU, reason: not valid java name */
    public static final void m1514ThemeMockupPortraitXOJAsU(DarkMode darkMode, boolean z, long j, Composer composer, int i) {
        int i2;
        boolean z2;
        long j2;
        darkMode.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(798452127);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(darkMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i2 |= gapComposer.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            j2 = j;
            i2 |= gapComposer.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer);
            int iOrdinal = darkMode.ordinal();
            if (iOrdinal == 0) {
                zIsSystemInDarkTheme = true;
            } else if (iOrdinal == 1) {
                zIsSystemInDarkTheme = false;
            } else if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            ThemeKt.m1515MetrolistThemeT042LqI(zIsSystemInDarkTheme, z2, j2, null, AiSettingsKt.f524lambda$2059490942, gapComposer, (i2 & 112) | 24576 | (i2 & 896), 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda6(darkMode, z, j, i, (byte) 1);
        }
    }

    public static final void ThemeScreen(NavHostController navHostController, Composer composer, int i) {
        navHostController.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-636850118);
        int i2 = (gapComposer.changedInstance(navHostController) ? 4 : 2) | i;
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Preferences$Key preferences$Key = PreferenceKeysKt.DarkModeKey;
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = StateFlowKt.distinctUntilChanged(new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 9));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, DarkMode.AUTO, gapComposer, 48);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2 themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2 = (ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2) objRememberedValue3;
            DarkMode darkMode = (DarkMode) themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2.component1();
            RenderScriptBlurEffect$updateSurface$2$4 renderScriptBlurEffect$updateSurface$2$4 = new RenderScriptBlurEffect$updateSurface$2$4((byte) 20, themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.PureBlackKey;
            Boolean bool = Boolean.FALSE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.PureBlackMiniPlayerKey, bool, gapComposer, 48);
            dataStoreKt$rememberPreference$1$1RememberPreference2.getClass();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference2);
            boolean zChanged = gapComposer.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda1);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda4((Object) mimesKt$$ExternalSyntheticLambda0, (Object) mimesKt$$ExternalSyntheticLambda1, (byte) 28);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            Preferences$Key preferences$Key3 = PreferenceKeysKt.SelectedThemeColorKey;
            Shapes shapes = ThemeKt.EditorialShapes;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(preferences$Key3, Integer.valueOf(ColorKt.m498toArgb8_81llA(-17343425833598976L)), gapComposer, 0);
            int iIntValue = ((Number) dataStoreKt$rememberPreference$1$1RememberPreference3.$state.getValue()).intValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda2 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference3);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.DynamicThemeKey, bool, gapComposer, 48);
            dataStoreKt$rememberPreference$1$1RememberPreference4.getClass();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda3 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference4);
            long j = ((long) iIntValue) << 32;
            boolean z = ((Configuration) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation == 2;
            boolean zChanged2 = gapComposer.changed(mimesKt$$ExternalSyntheticLambda2) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda3);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(mimesKt$$ExternalSyntheticLambda2, mimesKt$$ExternalSyntheticLambda3, (byte) 23);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function2 = (Function1) objRememberedValue5;
            if (z) {
                gapComposer.startReplaceGroup(-1529903506);
                m1510LandscapeThemeLayoutV9fs2A(new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO), darkMode, renderScriptBlurEffect$updateSurface$2$4, zBooleanValue, function1, j, function2, gapComposer, 6);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1529522609);
                m1511PortraitThemeLayoutV9fs2A(new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO), darkMode, renderScriptBlurEffect$updateSurface$2$4, zBooleanValue, function1, j, function2, gapComposer, 6);
                gapComposer.end(false);
            }
            MenuKt.m1493TopAppBarGHTll3U(AiSettingsKt.f551lambda$453820674, null, Expect_jvmKt.rememberComposableLambda(1475111552, new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController, b), gapComposer), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer, 390, 250);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController, i, (byte) 12);
        }
    }
}
