package com.metrolist.music.ui.screens.equalizer;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImagePainter;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.eq.data.FilterType;
import com.metrolist.music.eq.data.ParametricEQBand;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda45;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda84;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda37;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EqScreenKt {
    public static final ComposableLambdaImpl lambda$39252988 = new ComposableLambdaImpl(false, 39252988, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(27));

    /* JADX INFO: renamed from: lambda$-1686998123, reason: not valid java name */
    public static final ComposableLambdaImpl f353lambda$1686998123 = new ComposableLambdaImpl(false, -1686998123, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(10));
    public static final ComposableLambdaImpl lambda$1480777075 = new ComposableLambdaImpl(false, 1480777075, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(1));
    public static final ComposableLambdaImpl lambda$410835660 = new ComposableLambdaImpl(false, 410835660, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(11));
    public static final ComposableLambdaImpl lambda$1932578738 = new ComposableLambdaImpl(false, 1932578738, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(2));

    /* JADX INFO: renamed from: lambda$-1687735534, reason: not valid java name */
    public static final ComposableLambdaImpl f354lambda$1687735534 = new ComposableLambdaImpl(false, -1687735534, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(3));
    public static final ComposableLambdaImpl lambda$1219249419 = new ComposableLambdaImpl(false, 1219249419, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(4));

    /* JADX INFO: renamed from: lambda$-551780734, reason: not valid java name */
    public static final ComposableLambdaImpl f359lambda$551780734 = new ComposableLambdaImpl(false, -551780734, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(5));

    /* JADX INFO: renamed from: lambda$-2059267745, reason: not valid java name */
    public static final ComposableLambdaImpl f356lambda$2059267745 = new ComposableLambdaImpl(false, -2059267745, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(6));

    /* JADX INFO: renamed from: lambda$-1903345877, reason: not valid java name */
    public static final ComposableLambdaImpl f355lambda$1903345877 = new ComposableLambdaImpl(false, -1903345877, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(7));
    public static final ComposableLambdaImpl lambda$1100582600 = new ComposableLambdaImpl(false, 1100582600, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(0));

    /* JADX INFO: renamed from: lambda$-783560626, reason: not valid java name */
    public static final ComposableLambdaImpl f360lambda$783560626 = new ComposableLambdaImpl(false, -783560626, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(28));
    public static final ComposableLambdaImpl lambda$293440587 = new ComposableLambdaImpl(false, 293440587, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(8));

    /* JADX INFO: renamed from: lambda$-2131017022, reason: not valid java name */
    public static final ComposableLambdaImpl f357lambda$2131017022 = new ComposableLambdaImpl(false, -2131017022, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(29));

    /* JADX INFO: renamed from: lambda$-1150062208, reason: not valid java name */
    public static final ComposableLambdaImpl f352lambda$1150062208 = new ComposableLambdaImpl(false, -1150062208, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(0));

    /* JADX INFO: renamed from: lambda$-372200997, reason: not valid java name */
    public static final ComposableLambdaImpl f358lambda$372200997 = new ComposableLambdaImpl(false, -372200997, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(9));

    public static final void EQProfileItem(final SavedEQProfile savedEQProfile, boolean z, Function0 function0, Function0 function1, Composer composer, int i) {
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(485719308);
        int i2 = i | (gapComposer2.changedInstance(savedEQProfile) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128) | (gapComposer2.changedInstance(function1) ? 2048 : 1024);
        final byte b = 0;
        byte b2 = 1;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ListItemColors listItemColorsGlassListItemColors = GlassComponentsKt.glassListItemColors(gapComposer2);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            ListItemKt.ListItem(OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(companion, false, null, function0, 15), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), false, Expect_jvmKt.rememberComposableLambda(-953258516, new PlayerKt$$ExternalSyntheticLambda45(b2, function0, z), gapComposer2), Expect_jvmKt.rememberComposableLambda(1407502381, new QueueKt$$ExternalSyntheticLambda39(mutableState, (byte) 5), gapComposer2), Expect_jvmKt.rememberComposableLambda(1834056879, new Function2() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = b;
                    Unit unit = Unit.INSTANCE;
                    SavedEQProfile savedEQProfile2 = savedEQProfile;
                    switch (b3) {
                        case 0:
                            List list = savedEQProfile2.bands;
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer3.skipToGroupEnd();
                            } else {
                                TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.band_count, list.size(), new Object[]{Integer.valueOf(list.size())}, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                            }
                            break;
                        default:
                            Composer composer3 = (Composer) obj;
                            int iIntValue2 = ((Integer) obj2).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer3;
                            if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                gapComposer4.skipToGroupEnd();
                            } else {
                                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_profile_confirmation, new Object[]{savedEQProfile2.name}, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                            }
                            break;
                    }
                    return unit;
                }
            }, gapComposer2), null, null, listItemColorsGlassListItemColors, null, null, Expect_jvmKt.rememberComposableLambda(2061090754, new StringsKt__StringsKt$$ExternalSyntheticLambda1((Object) savedEQProfile, z, (byte) 8), gapComposer2), gapComposer2, 200064, 1746);
            gapComposer = gapComposer2;
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(320558053);
                Modifier modifierM1479glassOverlay6a0pyJM = GlassComponentsKt.m1479glassOverlay6a0pyJM(companion, GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer), gapComposer);
                RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh8 = GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 16);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                final byte b3 = 1;
                CardKt.m251AlertDialogOix01E0((Function0) objRememberedValue2, Expect_jvmKt.rememberComposableLambda(1960856671, new EqScreenKt$$ExternalSyntheticLambda35(function1, mutableState, (byte) 0), gapComposer), modifierM1479glassOverlay6a0pyJM, Expect_jvmKt.rememberComposableLambda(-1353155811, new QueueKt$$ExternalSyntheticLambda39(mutableState, (byte) 6), gapComposer), null, f358lambda$372200997, Expect_jvmKt.rememberComposableLambda(-2029207238, new Function2() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        SavedEQProfile savedEQProfile2 = savedEQProfile;
                        switch (b4) {
                            case 0:
                                List list = savedEQProfile2.bands;
                                Composer composer2 = (Composer) obj;
                                int iIntValue = ((Integer) obj2).intValue();
                                GapComposer gapComposer3 = (GapComposer) composer2;
                                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.band_count, list.size(), new Object[]{Integer.valueOf(list.size())}, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj;
                                int iIntValue2 = ((Integer) obj2).intValue();
                                GapComposer gapComposer4 = (GapComposer) composer3;
                                if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_profile_confirmation, new Object[]{savedEQProfile2.name}, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer), roundedCornerShapeM1480glassShapeixp7dh8, 0L, 0L, 0L, 0L, null, gapComposer, 102435894, 384, 11792);
                gapComposer = gapComposer;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(321625910);
                gapComposer.end(false);
            }
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda84(savedEQProfile, z, function0, function1, i, (byte) 8);
        }
    }

    public static final void EqFrequencyResponseGraph(final List list, final double d, Modifier modifier, Composer composer, final int i) {
        final Modifier modifier2;
        long j;
        long j2;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1512398518);
        int i2 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changed(d) ? 32 : 16) | 384;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            final TextMeasurer textMeasurerRememberTextMeasurer = TextRangeKt.rememberTextMeasurer(gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
            long j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant;
            final long jColor = ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.4f, Color.m483getColorSpaceimpl(j4));
            long j5 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
            long jColor2 = ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), 0.7f, Color.m483getColorSpaceimpl(j5));
            final long j6 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            long j7 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            final long jColor3 = ColorKt.Color(Color.m485getRedimpl(j7), Color.m484getGreenimpl(j7), Color.m482getBlueimpl(j7), 0.15f, Color.m483getColorSpaceimpl(j7));
            long j8 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            long jColor4 = ColorKt.Color(Color.m485getRedimpl(j8), Color.m484getGreenimpl(j8), Color.m482getBlueimpl(j8), 0.5f, Color.m483getColorSpaceimpl(j8));
            final TextStyle textStyle = new TextStyle(jColor2, IntMath.getSp(10), null, null, null, 0L, 0, 0L, null, null, 16777212);
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((ParametricEQBand) obj).enabled) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    ArrayList arrayList3 = arrayList2;
                    if (i3 >= size) {
                        ArrayList arrayList4 = arrayList3;
                        j = j3;
                        double dLog10 = Math.log10(20.0d);
                        double dLog11 = Math.log10(20000.0d);
                        ArrayList arrayList5 = new ArrayList();
                        double d9 = 0.0d;
                        double d10 = 0.0d;
                        int i4 = 0;
                        while (i4 < 200) {
                            double d11 = dLog10;
                            long j9 = jColor4;
                            double dPow = Math.pow(10.0d, (((dLog11 - dLog10) * ((double) i4)) / 199.0d) + d11);
                            int size2 = arrayList4.size();
                            double dLog12 = 0.0d;
                            int i5 = 0;
                            while (i5 < size2) {
                                Object obj2 = arrayList4.get(i5);
                                i5++;
                                BiquadCoeffs biquadCoeffs = (BiquadCoeffs) obj2;
                                double d12 = (dPow * 6.283185307179586d) / 48000.0d;
                                double dCos = Math.cos(d12);
                                double d13 = d12 * 2.0d;
                                double dCos2 = Math.cos(d13);
                                double dSin = Math.sin(d12);
                                double dSin2 = Math.sin(d13);
                                ArrayList arrayList6 = arrayList4;
                                double d14 = dPow;
                                double d15 = biquadCoeffs.b0;
                                double d16 = biquadCoeffs.b1;
                                double d17 = (d16 * dCos) + d15;
                                double d18 = biquadCoeffs.b2;
                                double d19 = (d18 * dCos2) + d17;
                                double d20 = (d18 * dSin2) + (d16 * dSin);
                                double d21 = biquadCoeffs.a1;
                                double d22 = (dCos * d21) + 1.0d;
                                double d23 = biquadCoeffs.a2;
                                double d24 = (dCos2 * d23) + d22;
                                double d25 = (d23 * dSin2) + (dSin * d21);
                                double d26 = (d20 * d20) + (d19 * d19);
                                double d27 = (d25 * d25) + (d24 * d24);
                                dLog12 += d27 > 0.0d ? Math.log10(Math.max(d26 / d27, 1.0E-10d)) * 10.0d : 0.0d;
                                arrayList4 = arrayList6;
                                size2 = size2;
                                dPow = d14;
                            }
                            ArrayList arrayList7 = arrayList4;
                            arrayList5.add(new Pair(Double.valueOf(dPow), Double.valueOf(dLog12)));
                            if (dLog12 < d9) {
                                d9 = dLog12;
                            }
                            if (dLog12 > d10) {
                                d10 = dLog12;
                            }
                            i4++;
                            arrayList4 = arrayList7;
                            jColor4 = j9;
                            dLog10 = d11;
                        }
                        j2 = jColor4;
                        double dMax = Math.max(Math.ceil((Math.max(Math.abs(d9), Math.abs(d10)) + 1.0d) / 2.5d) * 2.5d, 2.5d);
                        objRememberedValue = new GraphData(arrayList5, dMax, -dMax, dMax * 2.0d);
                        gapComposer.updateRememberedValue(objRememberedValue);
                        break;
                    }
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    ParametricEQBand parametricEQBand = (ParametricEQBand) obj3;
                    double d28 = parametricEQBand.frequency;
                    ArrayList arrayList8 = arrayList;
                    double d29 = parametricEQBand.gain;
                    double d30 = parametricEQBand.q;
                    FilterType filterType = parametricEQBand.filterType;
                    double d31 = (6.283185307179586d * d28) / 48000.0d;
                    double dSin3 = Math.sin(d31);
                    double dCos3 = Math.cos(d31);
                    int iOrdinal = filterType.ordinal();
                    if (iOrdinal == 0) {
                        double dPow2 = Math.pow(10.0d, d29 / 40.0d);
                        double d32 = dSin3 / (d30 * 2.0d);
                        double d33 = d32 * dPow2;
                        d2 = d33 + 1.0d;
                        d3 = dCos3 * (-2.0d);
                        d4 = 1.0d - d33;
                        double d34 = d32 / dPow2;
                        d5 = d34 + 1.0d;
                        d6 = 1.0d - d34;
                        d7 = d3;
                    } else if (iOrdinal == 1) {
                        double dSqrt = Math.sqrt(Math.pow(10.0d, d29 / 20.0d));
                        double d35 = dSqrt + 1.0d;
                        double d36 = dSqrt - 1.0d;
                        double dSqrt2 = Math.sqrt(dSqrt) * 2.0d * Math.sqrt((((1.0d / dSqrt) + dSqrt) * 0.0d) + 2.0d) * (dSin3 / 2.0d);
                        double d37 = d36 * dCos3;
                        double d38 = d35 - d37;
                        double d39 = (d38 + dSqrt2) * dSqrt;
                        double d40 = dCos3 * d35;
                        double d41 = 2.0d * dSqrt * (d36 - d40);
                        double d42 = d35 + d37;
                        d3 = (d36 + d40) * (-2.0d);
                        d6 = d42 - dSqrt2;
                        d4 = dSqrt * (d38 - dSqrt2);
                        d7 = d41;
                        d5 = d42 + dSqrt2;
                        d2 = d39;
                    } else if (iOrdinal != 2) {
                        if (iOrdinal == 3) {
                            d8 = dSin3 / (d30 * 2.0d);
                            d7 = 1.0d - dCos3;
                            d2 = d7 / 2.0d;
                        } else {
                            if (iOrdinal != 4) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return;
                            }
                            d8 = dSin3 / (d30 * 2.0d);
                            double d43 = dCos3 + 1.0d;
                            d2 = d43 / 2.0d;
                            d7 = -d43;
                        }
                        d5 = d8 + 1.0d;
                        d3 = dCos3 * (-2.0d);
                        d6 = 1.0d - d8;
                        d4 = d2;
                    } else {
                        double dSqrt3 = Math.sqrt(Math.pow(10.0d, d29 / 20.0d));
                        double d44 = dSqrt3 + 1.0d;
                        double d45 = dSqrt3 - 1.0d;
                        double dSqrt4 = Math.sqrt(dSqrt3) * 2.0d * Math.sqrt((((1.0d / dSqrt3) + dSqrt3) * 0.0d) + 2.0d) * (dSin3 / 2.0d);
                        double d46 = d45 * dCos3;
                        double d47 = d44 + d46;
                        double d48 = dCos3 * d44;
                        double d49 = (-2.0d) * dSqrt3 * (d45 + d48);
                        double d50 = d44 - d46;
                        d3 = (d45 - d48) * 2.0d;
                        d6 = d50 - dSqrt4;
                        d5 = d50 + dSqrt4;
                        d2 = (d47 + dSqrt4) * dSqrt3;
                        d4 = dSqrt3 * (d47 - dSqrt4);
                        d7 = d49;
                    }
                    arrayList3.add(new BiquadCoeffs(d2 / d5, d7 / d5, d4 / d5, d3 / d5, d6 / d5));
                    arrayList2 = arrayList3;
                    arrayList = arrayList8;
                    j3 = j3;
                }
            } else {
                j2 = jColor4;
                j = j3;
            }
            final GraphData graphData = (GraphData) objRememberedValue;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            final long j10 = j2;
            SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 8.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1683559099, new Function2() { // from class: com.metrolist.music.ui.screens.equalizer.EqFrequencyResponseGraphKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    Composer composer2 = (Composer) obj4;
                    int iIntValue = ((Integer) obj5).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 200.0f), 4.0f);
                        final GraphData graphData2 = graphData;
                        boolean zChangedInstance = gapComposer2.changedInstance(graphData2);
                        final long j11 = j10;
                        boolean zChanged = zChangedInstance | gapComposer2.changed(j11);
                        final long j12 = jColor;
                        boolean zChanged2 = zChanged | gapComposer2.changed(j12);
                        final TextMeasurer textMeasurer = textMeasurerRememberTextMeasurer;
                        boolean zChanged3 = zChanged2 | gapComposer2.changed(textMeasurer);
                        final TextStyle textStyle2 = textStyle;
                        boolean zChanged4 = zChanged3 | gapComposer2.changed(textStyle2);
                        final long j13 = jColor3;
                        boolean zChanged5 = zChanged4 | gapComposer2.changed(j13);
                        final long j14 = j6;
                        boolean zChanged6 = gapComposer2.changed(j14) | zChanged5;
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged6 || objRememberedValue2 == Composer.Companion.Empty) {
                            objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.EqFrequencyResponseGraphKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj6) throws Throwable {
                                    EmojiProcessor emojiProcessor;
                                    long j15;
                                    EmojiProcessor emojiProcessor2;
                                    long j16;
                                    TextMeasurer textMeasurer2;
                                    TextStyle textStyle3;
                                    long j17;
                                    String strValueOf;
                                    long j18 = j13;
                                    long j19 = j14;
                                    DrawScope drawScope = (DrawScope) obj6;
                                    drawScope.getClass();
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)) - 8.0f;
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) - 24.0f;
                                    float f = fIntBitsToFloat - 40.0f;
                                    float f2 = fIntBitsToFloat2 - 8.0f;
                                    GraphData graphData3 = graphData2;
                                    double d51 = graphData3.dbTop;
                                    ArrayList arrayList9 = graphData3.points;
                                    double d52 = graphData3.dbBottom;
                                    double d53 = graphData3.dbRange;
                                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
                                    EmojiProcessor drawContext = drawScope.getDrawContext();
                                    long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                                    drawContext.getCanvas().save();
                                    try {
                                        ((DrawResult) drawContext.mSpanFactory).m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat3, fIntBitsToFloat4, 1);
                                        while (true) {
                                            emojiProcessor2 = drawContext;
                                            j16 = jM831getSizeNHjbRc;
                                            long j20 = j12;
                                            textMeasurer2 = textMeasurer;
                                            textStyle3 = textStyle2;
                                            j17 = j20;
                                            if (d52 > d51) {
                                                break;
                                            }
                                            float f3 = 8.0f + ((float) (((double) f2) * ((d51 - d52) / d53)));
                                            try {
                                                boolean z2 = Math.abs(d52) < 0.01d;
                                                long j21 = j19;
                                                long j22 = z2 ? j11 : j17;
                                                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(40.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
                                                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
                                                double d54 = d51;
                                                ArrayList arrayList10 = arrayList9;
                                                drawScope.mo535drawLineNGM6Ib0(j22, jFloatToRawIntBits, jFloatToRawIntBits2, z2 ? 1.5f : 0.5f, (496 & 16) != 0 ? 0 : 0, 3);
                                                if (d52 == 0.0d) {
                                                    strValueOf = "0";
                                                } else {
                                                    long j23 = (long) d52;
                                                    strValueOf = d52 == ((double) j23) ? String.valueOf(j23) : String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d52)}, 1));
                                                }
                                                TextLayoutResult textLayoutResultM737measurewNUYSr0$default = TextMeasurer.m737measurewNUYSr0$default(textMeasurer2, strValueOf, textStyle3, 0L, 1020);
                                                long j24 = textLayoutResultM737measurewNUYSr0$default.size;
                                                TextRangeKt.m748drawTextd8rzKo$default(drawScope, textLayoutResultM737measurewNUYSr0$default, 0L, (((long) Float.floatToRawIntBits(f3 - (((int) (j24 & 4294967295L)) / 2.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits((40.0f - ((int) (j24 >> 32))) - 4.0f)) << 32), 250);
                                                d52 += 2.5d;
                                                d51 = d54;
                                                arrayList9 = arrayList10;
                                                f = f;
                                                f2 = f2;
                                                drawContext = emojiProcessor2;
                                                jM831getSizeNHjbRc = j16;
                                                j19 = j21;
                                            } catch (Throwable th) {
                                                th = th;
                                                emojiProcessor = emojiProcessor2;
                                                j15 = j16;
                                            }
                                            th = th;
                                            emojiProcessor = emojiProcessor2;
                                            j15 = j16;
                                            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, j15);
                                            throw th;
                                        }
                                        long j25 = j19;
                                        float f4 = f;
                                        float f5 = f2;
                                        double d55 = d51;
                                        ArrayList arrayList11 = arrayList9;
                                        int i6 = 1;
                                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Double[]{Double.valueOf(100.0d), Double.valueOf(1000.0d), Double.valueOf(10000.0d)});
                                        List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"100", "1k", "10k"});
                                        int size3 = listListOf.size();
                                        int i7 = 0;
                                        while (i7 < size3) {
                                            float fEqFrequencyResponseGraph$lambda$1$0$0$freqToX = EqScreenKt.EqFrequencyResponseGraph$lambda$1$0$0$freqToX(f4, ((Number) listListOf.get(i7)).doubleValue());
                                            long j26 = j17;
                                            drawScope.mo535drawLineNGM6Ib0(j26, (((long) Float.floatToRawIntBits(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX)) << 32) | (((long) Float.floatToRawIntBits(8.0f)) & 4294967295L), (((long) Float.floatToRawIntBits(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), 0.5f, (496 & 16) != 0 ? 0 : 0, 3);
                                            j17 = j26;
                                            TextLayoutResult textLayoutResultM737measurewNUYSr0$default2 = TextMeasurer.m737measurewNUYSr0$default(textMeasurer2, (String) listListOf2.get(i7), textStyle3, 0L, 1020);
                                            TextRangeKt.m748drawTextd8rzKo$default(drawScope, textLayoutResultM737measurewNUYSr0$default2, 0L, (((long) Float.floatToRawIntBits(fIntBitsToFloat2 + 4.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX - (((int) (textLayoutResultM737measurewNUYSr0$default2.size >> 32)) / 2.0f))) << 32), 250);
                                            i7++;
                                            i6 = 1;
                                        }
                                        int i8 = i6;
                                        if (arrayList11.isEmpty()) {
                                            emojiProcessor = emojiProcessor2;
                                            j15 = j16;
                                        } else {
                                            AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                                            AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                                            float fEqFrequencyResponseGraph$lambda$1$0$0$freqToX2 = EqScreenKt.EqFrequencyResponseGraph$lambda$1$0$0$freqToX(f4, ((Number) ((Pair) CollectionsKt.first((List) arrayList11)).first).doubleValue());
                                            double d56 = f5;
                                            float fDoubleValue = 8.0f + ((float) (((d55 - ((Number) ((Pair) CollectionsKt.first((List) arrayList11)).second).doubleValue()) / d53) * d56));
                                            androidPathPath.moveTo(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX2, fDoubleValue);
                                            androidPathPath2.moveTo(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX2, fIntBitsToFloat2);
                                            androidPathPath2.lineTo(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX2, fDoubleValue);
                                            int size4 = arrayList11.size();
                                            for (int i9 = i8; i9 < size4; i9++) {
                                                Pair pair = (Pair) arrayList11.get(i9);
                                                double dDoubleValue = ((Number) pair.first).doubleValue();
                                                double dDoubleValue2 = ((Number) pair.second).doubleValue();
                                                float fEqFrequencyResponseGraph$lambda$1$0$0$freqToX3 = EqScreenKt.EqFrequencyResponseGraph$lambda$1$0$0$freqToX(f4, dDoubleValue);
                                                float f6 = 8.0f + ((float) (((d55 - dDoubleValue2) / d53) * d56));
                                                androidPathPath.lineTo(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX3, f6);
                                                androidPathPath2.lineTo(fEqFrequencyResponseGraph$lambda$1$0$0$freqToX3, f6);
                                            }
                                            androidPathPath2.lineTo(EqScreenKt.EqFrequencyResponseGraph$lambda$1$0$0$freqToX(f4, ((Number) ((Pair) CollectionsKt.last(arrayList11)).first).doubleValue()), fIntBitsToFloat2);
                                            androidPathPath2.internalPath.close();
                                            emojiProcessor = emojiProcessor2;
                                            j15 = j16;
                                            try {
                                                DrawScope.m548drawPathLG529CI$default(drawScope, androidPathPath2, j18, CropImageView.DEFAULT_ASPECT_RATIO, null, 60);
                                                DrawScope.m548drawPathLG529CI$default(drawScope, androidPathPath, j25, CropImageView.DEFAULT_ASPECT_RATIO, new Stroke(drawScope.mo81toPx0680j_4(2.0f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 52);
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, j15);
                                        return Unit.INSTANCE;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        emojiProcessor = drawContext;
                                        j15 = jM831getSizeNHjbRc;
                                    }
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        ImageKt.Canvas(6, gapComposer2, modifierM135padding3ABfNKs, (Function1) objRememberedValue2);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 12607488, 104);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(list, d, modifier2, i) { // from class: com.metrolist.music.ui.screens.equalizer.EqFrequencyResponseGraphKt$$ExternalSyntheticLambda1
                public final /* synthetic */ List f$0;
                public final /* synthetic */ double f$1;
                public final /* synthetic */ Modifier f$2;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    ((Integer) obj5).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    EqScreenKt.EqFrequencyResponseGraph(this.f$0, this.f$1, this.f$2, (Composer) obj4, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final float EqFrequencyResponseGraph$lambda$1$0$0$freqToX(float f, double d) {
        double dLog10 = Math.log10(20.0d);
        return 40.0f + ((float) (((Math.log10(d) - dLog10) / (Math.log10(20000.0d) - dLog10)) * ((double) f)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static final void EqScreen(EQViewModel eQViewModel, Composer composer, int i) {
        EQViewModel eQViewModel2;
        GapComposer gapComposer;
        final EQViewModel eQViewModel3;
        Object next;
        byte b;
        Modifier.Companion companion;
        Object obj;
        MutableState mutableState;
        GapComposer gapComposer2;
        ?? r0;
        GapComposer gapComposer3;
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(-1140094138);
        int i2 = i | 2;
        final byte b2 = 0;
        if (gapComposer4.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            gapComposer4.startDefaults();
            if ((i & 1) == 0 || gapComposer4.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer4.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                eQViewModel3 = (EQViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(EQViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer4), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer4);
            } else {
                gapComposer4.skipToGroupEnd();
                eQViewModel3 = eQViewModel;
            }
            gapComposer4.endDefaults();
            NavHostController navHostController = (NavHostController) gapComposer4.consume(MainActivityKt.LocalNavController);
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(eQViewModel3.state, gapComposer4);
            Object obj2 = (Context) gapComposer4.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue = gapComposer4.rememberedValue();
            Object obj3 = Composer.Companion.Empty;
            if (objRememberedValue == obj3) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer4.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer4.rememberedValue();
            if (objRememberedValue2 == obj3) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer4.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            FragmentManager.FragmentIntentSenderContract fragmentIntentSenderContract = new FragmentManager.FragmentIntentSenderContract((byte) 2);
            boolean zChangedInstance = gapComposer4.changedInstance(obj2) | gapComposer4.changedInstance(eQViewModel3);
            Object objRememberedValue3 = gapComposer4.rememberedValue();
            byte b3 = 20;
            if (zChangedInstance || objRememberedValue3 == obj3) {
                objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda21(obj2, eQViewModel3, mutableState2, b3);
                gapComposer4.updateRememberedValue(objRememberedValue3);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = LifecyclesKt.rememberLauncherForActivityResult(fragmentIntentSenderContract, (Function1) objRememberedValue3, gapComposer4, 0);
            Iterator it = ((EQState) mutableStateCollectAsStateWithLifecycle.getValue()).profiles.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((SavedEQProfile) next).id, ((EQState) mutableStateCollectAsStateWithLifecycle.getValue()).activeProfileId));
            SavedEQProfile savedEQProfile = (SavedEQProfile) next;
            List list = ((EQState) mutableStateCollectAsStateWithLifecycle.getValue()).profiles;
            String str = ((EQState) mutableStateCollectAsStateWithLifecycle.getValue()).activeProfileId;
            boolean zChangedInstance2 = gapComposer4.changedInstance(eQViewModel3);
            Object objRememberedValue4 = gapComposer4.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj3) {
                objRememberedValue4 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        byte b4 = b2;
                        Unit unit = Unit.INSTANCE;
                        EQViewModel eQViewModel4 = eQViewModel3;
                        String str2 = (String) obj4;
                        switch (b4) {
                            case 0:
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(eQViewModel4), null, null, new AsyncImagePainter.AnonymousClass1(str2, eQViewModel4, null, (byte) 24), 3);
                                break;
                            default:
                                str2.getClass();
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(eQViewModel4), null, null, new DataStoreKt$get$1(eQViewModel4, str2, (Continuation) null, (byte) 9), 3);
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer4.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            boolean zChangedInstance3 = gapComposer4.changedInstance(navHostController);
            Object objRememberedValue5 = gapComposer4.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == obj3) {
                objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 22);
                gapComposer4.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
            Object objRememberedValue6 = gapComposer4.rememberedValue();
            if (objRememberedValue6 == obj3) {
                objRememberedValue6 = new PlayerKt$$ExternalSyntheticLambda7(mutableState3, (byte) 19);
                gapComposer4.updateRememberedValue(objRememberedValue6);
            }
            Function0 function2 = (Function0) objRememberedValue6;
            Object objRememberedValue7 = gapComposer4.rememberedValue();
            if (objRememberedValue7 == obj3) {
                objRememberedValue7 = new PlayerKt$$ExternalSyntheticLambda7(mutableState3, (byte) 20);
                gapComposer4.updateRememberedValue(objRememberedValue7);
            }
            Function0 function3 = (Function0) objRememberedValue7;
            boolean zChangedInstance4 = gapComposer4.changedInstance(navHostController);
            Object objRememberedValue8 = gapComposer4.rememberedValue();
            if (zChangedInstance4 || objRememberedValue8 == obj3) {
                objRememberedValue8 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController, mutableState3, (byte) 2);
                gapComposer4.updateRememberedValue(objRememberedValue8);
            }
            Function0 function4 = (Function0) objRememberedValue8;
            boolean zChangedInstance5 = gapComposer4.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            Object objRememberedValue9 = gapComposer4.rememberedValue();
            if (zChangedInstance5 || objRememberedValue9 == obj3) {
                b = 0;
                objRememberedValue9 = new EqScreenKt$$ExternalSyntheticLambda11(managedActivityResultLauncherRememberLauncherForActivityResult, mutableState3, b);
                gapComposer4.updateRememberedValue(objRememberedValue9);
            } else {
                b = 0;
            }
            Function0 function5 = (Function0) objRememberedValue9;
            boolean zChangedInstance6 = gapComposer4.changedInstance(eQViewModel3);
            Object objRememberedValue10 = gapComposer4.rememberedValue();
            if (zChangedInstance6 || objRememberedValue10 == obj3) {
                final byte b4 = 1;
                objRememberedValue10 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.EqScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        byte b5 = b4;
                        Unit unit = Unit.INSTANCE;
                        EQViewModel eQViewModel4 = eQViewModel3;
                        String str2 = (String) obj4;
                        switch (b5) {
                            case 0:
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(eQViewModel4), null, null, new AsyncImagePainter.AnonymousClass1(str2, eQViewModel4, null, (byte) 24), 3);
                                break;
                            default:
                                str2.getClass();
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(eQViewModel4), null, null, new DataStoreKt$get$1(eQViewModel4, str2, (Continuation) null, (byte) 9), 3);
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer4.updateRememberedValue(objRememberedValue10);
            }
            SavedEQProfile.Companion companion2 = SavedEQProfile.INSTANCE;
            byte b5 = b;
            EQViewModel eQViewModel4 = eQViewModel3;
            EqScreenContent(list, str, savedEQProfile, function1, function0, zBooleanValue, function2, function3, function4, function5, (Function1) objRememberedValue10, gapComposer4, 14156288);
            String str2 = (String) mutableState2.getValue();
            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
            if (str2 != null) {
                gapComposer4.startReplaceGroup(59991028);
                Modifier modifierM1479glassOverlay6a0pyJM = GlassComponentsKt.m1479glassOverlay6a0pyJM(companion3, GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer4), gapComposer4);
                RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh8 = GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer4);
                Object objRememberedValue11 = gapComposer4.rememberedValue();
                if (objRememberedValue11 == obj3) {
                    objRememberedValue11 = new PlayerKt$$ExternalSyntheticLambda7(mutableState2, (byte) 14);
                    gapComposer4.updateRememberedValue(objRememberedValue11);
                }
                mutableState = mutableStateCollectAsStateWithLifecycle;
                companion = companion3;
                obj = obj3;
                boolean z = b5;
                CardKt.m251AlertDialogOix01E0((Function0) objRememberedValue11, Expect_jvmKt.rememberComposableLambda(498272281, new QueueKt$$ExternalSyntheticLambda39(mutableState2, (byte) 3), gapComposer4), modifierM1479glassOverlay6a0pyJM, null, null, f353lambda$1686998123, Expect_jvmKt.rememberComposableLambda(-85832076, new QueueKt$$ExternalSyntheticLambda39(mutableState2, (byte) 4), gapComposer4), roundedCornerShapeM1480glassShapeixp7dh8, 0L, 0L, 0L, 0L, null, gapComposer4, 102432822, 384, 11800);
                GapComposer gapComposer5 = gapComposer4;
                gapComposer5.end(z);
                r0 = z;
                gapComposer2 = gapComposer5;
            } else {
                companion = companion3;
                obj = obj3;
                boolean z2 = b5;
                mutableState = mutableStateCollectAsStateWithLifecycle;
                gapComposer4.startReplaceGroup(60681212);
                gapComposer4.end(z2);
                r0 = z2;
                gapComposer2 = gapComposer4;
            }
            if (((EQState) mutableState.getValue()).error != null) {
                gapComposer2.startReplaceGroup(60783357);
                Modifier modifierM1479glassOverlay6a0pyJM2 = GlassComponentsKt.m1479glassOverlay6a0pyJM(companion, GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer2), gapComposer2);
                RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh9 = GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer2);
                boolean zChangedInstance7 = gapComposer2.changedInstance(eQViewModel4);
                Object objRememberedValue12 = gapComposer2.rememberedValue();
                if (zChangedInstance7 || objRememberedValue12 == obj) {
                    objRememberedValue12 = new EqScreenKt$$ExternalSyntheticLambda2(eQViewModel4, r0);
                    gapComposer2.updateRememberedValue(objRememberedValue12);
                }
                eQViewModel4 = eQViewModel4;
                GapComposer gapComposer6 = gapComposer2;
                CardKt.m251AlertDialogOix01E0((Function0) objRememberedValue12, Expect_jvmKt.rememberComposableLambda(216686160, new EqScreenKt$$ExternalSyntheticLambda3(eQViewModel4), gapComposer2), modifierM1479glassOverlay6a0pyJM2, null, null, lambda$410835660, Expect_jvmKt.rememberComposableLambda(1533114859, new QueueKt$$ExternalSyntheticLambda39(mutableState, (byte) 7), gapComposer2), roundedCornerShapeM1480glassShapeixp7dh9, 0L, 0L, 0L, 0L, null, gapComposer6, 102432816, 384, 11800);
                GapComposer gapComposer7 = gapComposer6;
                gapComposer7.end(r0);
                gapComposer3 = gapComposer7;
            } else {
                gapComposer2.startReplaceGroup(61526396);
                gapComposer2.end(r0);
                gapComposer3 = gapComposer2;
            }
            eQViewModel2 = eQViewModel4;
            gapComposer = gapComposer3;
        } else {
            gapComposer4.skipToGroupEnd();
            eQViewModel2 = eQViewModel;
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new EqScreenKt$$ExternalSyntheticLambda3(eQViewModel2, i);
        }
    }

    public static final void EqScreenContent(List list, String str, SavedEQProfile savedEQProfile, Function1 function1, Function0 function0, boolean z, Function0 function2, Function0 function3, Function0 function4, Function0 function5, Function1 function6, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2116955442);
        int i2 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changedInstance(savedEQProfile) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changedInstance(function0) ? 16384 : 8192) | (gapComposer.changed(z) ? 131072 : 65536) | (gapComposer.changedInstance(function4) ? 67108864 : 33554432) | (gapComposer.changedInstance(function5) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, ((306783379 & i2) == 306783378 && ((gapComposer.changedInstance(function6) ? (char) 4 : (char) 2) & 3) == 2) ? false : true)) {
            ScrimKt.m317ScaffoldTvnljyQ(null, Expect_jvmKt.rememberComposableLambda(-2128690442, new ButtonKt$$ExternalSyntheticLambda6(function0, function2, z, function3, function4, function5), gapComposer), null, null, null, 0, 0L, 0L, null, Expect_jvmKt.rememberComposableLambda(1738997889, new QueueMenuKt$$ExternalSyntheticLambda12(savedEQProfile, str, list, function2, function1, function6), gapComposer), gapComposer, 805306416, 509);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda0(list, str, savedEQProfile, function1, function0, z, function2, function3, function4, function5, function6, i);
        }
    }

    public static final void NoEqualizationItem(int i, Composer composer, Function0 function0, boolean z) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(304705886);
        byte b = 2;
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ListItemKt.ListItem(OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(Modifier.Companion.$$INSTANCE, false, null, function0, 15), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), false, Expect_jvmKt.rememberComposableLambda(2044564030, new PlayerKt$$ExternalSyntheticLambda45(b, function0, z), gapComposer), null, null, null, null, GlassComponentsKt.glassListItemColors(gapComposer), null, null, Expect_jvmKt.rememberComposableLambda(396864276, new SongMenuKt$$ExternalSyntheticLambda26((byte) 21, z), gapComposer), gapComposer, 384, 1786);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda45(i, function0, z);
        }
    }
}
