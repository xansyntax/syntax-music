package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda3;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$12$1;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WizardScreenKt {

    /* JADX INFO: renamed from: lambda$-2088387345, reason: not valid java name */
    public static final ComposableLambdaImpl f363lambda$2088387345 = new ComposableLambdaImpl(false, -2088387345, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(12));

    /* JADX INFO: renamed from: lambda$-952243459, reason: not valid java name */
    public static final ComposableLambdaImpl f365lambda$952243459 = new ComposableLambdaImpl(false, -952243459, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(2));

    /* JADX INFO: renamed from: lambda$-740494270, reason: not valid java name */
    public static final ComposableLambdaImpl f364lambda$740494270 = new ComposableLambdaImpl(false, -740494270, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(13));

    /* JADX INFO: renamed from: lambda$-1298478333, reason: not valid java name */
    public static final ComposableLambdaImpl f361lambda$1298478333 = new ComposableLambdaImpl(false, -1298478333, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(14));

    /* JADX INFO: renamed from: lambda$-1856462396, reason: not valid java name */
    public static final ComposableLambdaImpl f362lambda$1856462396 = new ComposableLambdaImpl(false, -1856462396, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(15));

    public static final void ModelItem(DeviceModel deviceModel, Function0 function0, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1126985173);
        byte b = 16;
        int i2 = (gapComposer.changed(deviceModel) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-700985602);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(-700983111);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), false, null, function0, 15), null, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(339816349, new ListItemKt$$ExternalSyntheticLambda17(b, deviceModel), gapComposer), gapComposer, 196608, 10);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(deviceModel, function0, i, (byte) 26);
        }
    }

    public static final void ModelSelectionStep(final String str, final List list, final boolean z, final boolean z2, final Function0 function0, final Function1 function1, final Function1 function2, Composer composer, final int i) {
        Function1 function3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function4;
        GapComposer gapComposer;
        boolean z3;
        Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1213146322);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(list) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changed(z2) ? 2048 : 1024) | (gapComposer2.changedInstance(function0) ? 16384 : 8192) | (gapComposer2.changedInstance(function1) ? 131072 : 65536) | (gapComposer2.changedInstance(function2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 599187) != 599186)) {
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            FocusOwner focusOwner = (FocusOwner) gapComposer2.consume(CompositionLocalsKt.LocalFocusManager);
            Boolean boolValueOf = Boolean.valueOf(lazyListStateRememberLazyListState.scrollableState.isScrollInProgress());
            boolean zChanged = gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changedInstance(focusOwner);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new InterruptibleKt$runInterruptible$2(lazyListStateRememberLazyListState, focusOwner, null, (byte) 2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer2, boolValueOf, (Function2) objRememberedValue);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer2.startReplaceGroup(-1306088272);
                gapComposer2.end(false);
                FillElement fillElement = SizeKt.FillWholeMaxSize;
                Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(fillElement, 16.0f);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.Start, gapComposer2, 0);
                int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                String strStringResource = MathKt.stringResource(R.string.wizard_search_model_hint, gapComposer2);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                TextKt.m352TextNvy7gAk(strStringResource, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer2, 48, 0, 131068);
                ScrimKt.OutlinedTextField(str, function1, SizeKt.fillMaxWidth(companion, 1.0f), false, false, null, f364lambda$740494270, f361lambda$1298478333, f362lambda$1856462396, null, null, null, null, null, true, 0, 0, null, null, gapComposer2, (i2 & 14) | 114819456 | ((i2 >> 12) & 112), 12582912, 8257080);
                gapComposer2 = gapComposer2;
                OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
                if (z) {
                    gapComposer2.startReplaceGroup(-232612423);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 31, 0L, 0L, gapComposer2, null);
                    gapComposer2.end(true);
                    gapComposer2.end(false);
                } else {
                    if (!list.isEmpty() || StringsKt.isBlank(str)) {
                        gapComposer2.startReplaceGroup(-231938483);
                        Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                        boolean z4 = ((i2 & 3670016) == 1048576) | ((i2 & 112) == 32);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (z4 || objRememberedValue2 == neverEqualPolicy) {
                            function3 = function2;
                            objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda4((Object) list, (Object) function3, (byte) 16);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            function3 = function2;
                        }
                        IntMath.LazyColumn(null, lazyListStateRememberLazyListState, null, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue2, gapComposer2, 24576, 493);
                        gapComposer2 = gapComposer2;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-232347249);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.wizard_no_models, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer2, 0, 0, 131066);
                        gapComposer2 = gapComposer2;
                        gapComposer2.end(true);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                }
                function3 = function2;
                gapComposer2.end(true);
            } else {
                gapComposer2.startReplaceGroup(-1307155943);
                FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement2);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                if (z) {
                    gapComposer2.startReplaceGroup(-522676147);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
                    int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 31, 0L, 0L, gapComposer2, null);
                    String strM$1 = Format$$ExternalSyntheticOutline0.m$1(companion, 16.0f, gapComposer2, R.string.eq_downloading, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strM$1, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer2, 0, 0, 131066);
                    gapComposer = gapComposer2;
                    gapComposer.end(true);
                    gapComposer.end(false);
                    z3 = false;
                } else {
                    gapComposer2.startReplaceGroup(-522191400);
                    CardKt.Button(function0, null, false, null, null, null, null, null, null, f365lambda$952243459, gapComposer2, ((i2 >> 12) & 14) | 805306368, 510);
                    gapComposer = gapComposer2;
                    z3 = false;
                    gapComposer.end(false);
                }
                gapComposer.end(true);
                gapComposer.end(z3);
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b = 0;
                function4 = new Function2(str, list, z, z2, function0, function1, function2, i, b) { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda18
                    public final /* synthetic */ byte $r8$classId;
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ List f$1;
                    public final /* synthetic */ boolean f$2;
                    public final /* synthetic */ boolean f$3;
                    public final /* synthetic */ Function0 f$4;
                    public final /* synthetic */ Function1 f$5;
                    public final /* synthetic */ Function1 f$6;

                    {
                        this.$r8$classId = b;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b2 = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        switch (b2) {
                            case 0:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                                WizardScreenKt.ModelSelectionStep(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                                break;
                            default:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                                WizardScreenKt.ModelSelectionStep(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags2);
                                break;
                        }
                        return unit;
                    }
                };
            }
            recomposeScopeImplEndRestartGroup.block = function4;
        }
        function3 = function2;
        gapComposer2.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b2 = 1;
            final Function1 function5 = function3;
            function4 = new Function2(str, list, z, z2, function0, function1, function5, i, b2) { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda18
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ String f$0;
                public final /* synthetic */ List f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Function1 f$6;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b3) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                            WizardScreenKt.ModelSelectionStep(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                            WizardScreenKt.ModelSelectionStep(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function4;
        }
    }

    public static final void VariantItem(EQProfileVariant eQProfileVariant, boolean z, Function0 function0, Composer composer, int i) {
        long jColor;
        long j;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1464945268);
        int i2 = (gapComposer.changed(eQProfileVariant) ? 4 : 2) | i | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-936862361);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(-936859870);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), false, null, function0, 15);
            if (z) {
                gapComposer.startReplaceGroup(1022320324);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1022399622);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant;
                gapComposer.end(false);
            }
            CardKt.Card(modifierM46clickableoSLSa3U$default, null, CardKt.m267cardColorsro_MJ88(j, 0L, gapComposer, 14), null, borderStrokeM38BorderStrokecXLIe8U, Expect_jvmKt.rememberComposableLambda(-2142577982, new LoginScreenKt$$ExternalSyntheticLambda17(z, (Object) function0, (Object) eQProfileVariant, (byte) 6), gapComposer), gapComposer, 196608, 10);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(eQProfileVariant, z, function0, i, (byte) 11);
        }
    }

    public static final void VariantSelectionStep(String str, List list, Set set, boolean z, Function1 function1, Function0 function0, boolean z2, Composer composer, int i) {
        Function0 function2 = function0;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1629716161);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(list) ? 32 : 16) | (gapComposer.changed(set) ? 256 : 128) | (gapComposer.changed(z) ? 2048 : 1024) | (gapComposer.changedInstance(function1) ? 16384 : 8192) | (gapComposer.changedInstance(function2) ? 131072 : 65536) | (gapComposer.changed(z2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(new LayoutWeightElement(1.0f, true), 16.0f);
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            boolean z3 = ((i2 & 14) == 4) | ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((i2 & 57344) == 16384);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z3 || objRememberedValue == Composer.Companion.Empty) {
                MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59((Object) list, str, (Object) set, (Object) function1, (byte) 19);
                gapComposer.updateRememberedValue(mainActivity$$ExternalSyntheticLambda59);
                objRememberedValue = mainActivity$$ExternalSyntheticLambda59;
            }
            IntMath.LazyColumn(modifierM135padding3ABfNKs, null, null, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24576, 494);
            function2 = function0;
            SurfaceKt.m337SurfaceT9BRK9s(null, null, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(104489038, new WizardScreenKt$$ExternalSyntheticLambda16(z2, z, function2), gapComposer), gapComposer, 12804096, 79);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda5(str, list, set, z, function1, function2, z2, i);
        }
    }

    public static final void WizardScreen(final WizardViewModel wizardViewModel, Function0 function0, Composer composer, int i) {
        Function0 function1;
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(198602376);
        int i2 = i | 2 | (gapComposer.changedInstance(function0) ? 32 : 16);
        final byte b = 0;
        final byte b2 = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                wizardViewModel = (WizardViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(WizardViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
            }
            int i3 = i2 & (-15);
            gapComposer.endDefaults();
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(wizardViewModel.state, gapComposer);
            Boolean boolValueOf = Boolean.valueOf(((WizardState) mutableStateCollectAsStateWithLifecycle.getValue()).isComplete);
            boolean zChanged = ((i3 & 112) == 32) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LyricsMenuKt$LyricsMenu$12$1(function0, mutableStateCollectAsStateWithLifecycle, null, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue);
            WizardState wizardState = (WizardState) mutableStateCollectAsStateWithLifecycle.getValue();
            boolean zChangedInstance = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Object value;
                        WizardState wizardStateCopy$default;
                        byte b3 = b;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b3) {
                            case 0:
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new SyncUtils.AnonymousClass2(wizardViewModel2, null, (byte) 27), 3);
                                return unit;
                            case 1:
                                int iOrdinal = ((WizardState) wizardViewModel2._state.getValue()).currentStep.ordinal();
                                if (iOrdinal != 0) {
                                    if (iOrdinal != 1) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DiscordRpcManager.AnonymousClass4(wizardViewModel2, null, (byte) 9), 3);
                                }
                                return unit;
                            default:
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                    wizardStateCopy$default = (WizardState) value;
                                    if (WizardViewModel.WhenMappings.$EnumSwitchMapping$0[wizardStateCopy$default.currentStep.ordinal()] == 2) {
                                        wizardViewModel2.searchModels(wizardStateCopy$default.modelSearchQuery);
                                        wizardStateCopy$default = WizardState.copy$default(wizardStateCopy$default, WizardStep.MODEL_SELECTION, null, null, null, EmptyList.INSTANCE, EmptySet.INSTANCE, false, null, 974);
                                    }
                                } while (!stateFlowImpl.compareAndSet(value, wizardStateCopy$default));
                                return unit;
                        }
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            boolean zChangedInstance2 = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object value;
                        Object value2;
                        Object value3;
                        WizardState wizardState2;
                        Set mutableSet;
                        byte b3 = b;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b3) {
                            case 0:
                                String str = (String) obj;
                                str.getClass();
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                } while (!stateFlowImpl.compareAndSet(value, WizardState.copy$default((WizardState) value, null, str, null, null, null, null, false, null, 1021)));
                                StandaloneCoroutine standaloneCoroutine = wizardViewModel2.searchJob;
                                if (standaloneCoroutine != null) {
                                    standaloneCoroutine.cancel(null);
                                }
                                wizardViewModel2.searchJob = AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DataStoreKt$get$1(wizardViewModel2, str, (Continuation) null, (byte) 10), 3);
                                break;
                            case 1:
                                DeviceModel deviceModel = (DeviceModel) obj;
                                deviceModel.getClass();
                                StateFlowImpl stateFlowImpl2 = wizardViewModel2._state;
                                do {
                                    value2 = stateFlowImpl2.getValue();
                                } while (!stateFlowImpl2.compareAndSet(value2, WizardState.copy$default((WizardState) value2, null, null, null, deviceModel, null, null, false, null, 1015)));
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new WizardViewModel$loadVariants$1(wizardViewModel2, deviceModel.id, null, (byte) 0), 3);
                                break;
                            default:
                                String str2 = (String) obj;
                                str2.getClass();
                                StateFlowImpl stateFlowImpl3 = wizardViewModel2._state;
                                do {
                                    value3 = stateFlowImpl3.getValue();
                                    wizardState2 = (WizardState) value3;
                                    mutableSet = CollectionsKt.toMutableSet(wizardState2.selectedVariantIds);
                                    if (mutableSet.contains(str2)) {
                                        mutableSet.remove(str2);
                                    } else {
                                        mutableSet.add(str2);
                                    }
                                } while (!stateFlowImpl3.compareAndSet(value3, WizardState.copy$default(wizardState2, null, null, null, null, null, mutableSet, false, null, 991)));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            boolean zChangedInstance3 = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object value;
                        Object value2;
                        Object value3;
                        WizardState wizardState2;
                        Set mutableSet;
                        byte b3 = b2;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b3) {
                            case 0:
                                String str = (String) obj;
                                str.getClass();
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                } while (!stateFlowImpl.compareAndSet(value, WizardState.copy$default((WizardState) value, null, str, null, null, null, null, false, null, 1021)));
                                StandaloneCoroutine standaloneCoroutine = wizardViewModel2.searchJob;
                                if (standaloneCoroutine != null) {
                                    standaloneCoroutine.cancel(null);
                                }
                                wizardViewModel2.searchJob = AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DataStoreKt$get$1(wizardViewModel2, str, (Continuation) null, (byte) 10), 3);
                                break;
                            case 1:
                                DeviceModel deviceModel = (DeviceModel) obj;
                                deviceModel.getClass();
                                StateFlowImpl stateFlowImpl2 = wizardViewModel2._state;
                                do {
                                    value2 = stateFlowImpl2.getValue();
                                } while (!stateFlowImpl2.compareAndSet(value2, WizardState.copy$default((WizardState) value2, null, null, null, deviceModel, null, null, false, null, 1015)));
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new WizardViewModel$loadVariants$1(wizardViewModel2, deviceModel.id, null, (byte) 0), 3);
                                break;
                            default:
                                String str2 = (String) obj;
                                str2.getClass();
                                StateFlowImpl stateFlowImpl3 = wizardViewModel2._state;
                                do {
                                    value3 = stateFlowImpl3.getValue();
                                    wizardState2 = (WizardState) value3;
                                    mutableSet = CollectionsKt.toMutableSet(wizardState2.selectedVariantIds);
                                    if (mutableSet.contains(str2)) {
                                        mutableSet.remove(str2);
                                    } else {
                                        mutableSet.add(str2);
                                    }
                                } while (!stateFlowImpl3.compareAndSet(value3, WizardState.copy$default(wizardState2, null, null, null, null, null, mutableSet, false, null, 991)));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            boolean zChangedInstance4 = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            final byte b3 = 2;
            if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new Function1() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object value;
                        Object value2;
                        Object value3;
                        WizardState wizardState2;
                        Set mutableSet;
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b4) {
                            case 0:
                                String str = (String) obj;
                                str.getClass();
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                } while (!stateFlowImpl.compareAndSet(value, WizardState.copy$default((WizardState) value, null, str, null, null, null, null, false, null, 1021)));
                                StandaloneCoroutine standaloneCoroutine = wizardViewModel2.searchJob;
                                if (standaloneCoroutine != null) {
                                    standaloneCoroutine.cancel(null);
                                }
                                wizardViewModel2.searchJob = AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DataStoreKt$get$1(wizardViewModel2, str, (Continuation) null, (byte) 10), 3);
                                break;
                            case 1:
                                DeviceModel deviceModel = (DeviceModel) obj;
                                deviceModel.getClass();
                                StateFlowImpl stateFlowImpl2 = wizardViewModel2._state;
                                do {
                                    value2 = stateFlowImpl2.getValue();
                                } while (!stateFlowImpl2.compareAndSet(value2, WizardState.copy$default((WizardState) value2, null, null, null, deviceModel, null, null, false, null, 1015)));
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new WizardViewModel$loadVariants$1(wizardViewModel2, deviceModel.id, null, (byte) 0), 3);
                                break;
                            default:
                                String str2 = (String) obj;
                                str2.getClass();
                                StateFlowImpl stateFlowImpl3 = wizardViewModel2._state;
                                do {
                                    value3 = stateFlowImpl3.getValue();
                                    wizardState2 = (WizardState) value3;
                                    mutableSet = CollectionsKt.toMutableSet(wizardState2.selectedVariantIds);
                                    if (mutableSet.contains(str2)) {
                                        mutableSet.remove(str2);
                                    } else {
                                        mutableSet.add(str2);
                                    }
                                } while (!stateFlowImpl3.compareAndSet(value3, WizardState.copy$default(wizardState2, null, null, null, null, null, mutableSet, false, null, 991)));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function5 = (Function1) objRememberedValue5;
            boolean zChangedInstance5 = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Object value;
                        WizardState wizardStateCopy$default;
                        byte b4 = b2;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b4) {
                            case 0:
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new SyncUtils.AnonymousClass2(wizardViewModel2, null, (byte) 27), 3);
                                return unit;
                            case 1:
                                int iOrdinal = ((WizardState) wizardViewModel2._state.getValue()).currentStep.ordinal();
                                if (iOrdinal != 0) {
                                    if (iOrdinal != 1) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DiscordRpcManager.AnonymousClass4(wizardViewModel2, null, (byte) 9), 3);
                                }
                                return unit;
                            default:
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                    wizardStateCopy$default = (WizardState) value;
                                    if (WizardViewModel.WhenMappings.$EnumSwitchMapping$0[wizardStateCopy$default.currentStep.ordinal()] == 2) {
                                        wizardViewModel2.searchModels(wizardStateCopy$default.modelSearchQuery);
                                        wizardStateCopy$default = WizardState.copy$default(wizardStateCopy$default, WizardStep.MODEL_SELECTION, null, null, null, EmptyList.INSTANCE, EmptySet.INSTANCE, false, null, 974);
                                    }
                                } while (!stateFlowImpl.compareAndSet(value, wizardStateCopy$default));
                                return unit;
                        }
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Function0 function6 = (Function0) objRememberedValue6;
            boolean zChangedInstance6 = gapComposer.changedInstance(wizardViewModel);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new Function0() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Object value;
                        WizardState wizardStateCopy$default;
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        WizardViewModel wizardViewModel2 = wizardViewModel;
                        switch (b4) {
                            case 0:
                                AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new SyncUtils.AnonymousClass2(wizardViewModel2, null, (byte) 27), 3);
                                return unit;
                            case 1:
                                int iOrdinal = ((WizardState) wizardViewModel2._state.getValue()).currentStep.ordinal();
                                if (iOrdinal != 0) {
                                    if (iOrdinal != 1) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(wizardViewModel2), null, null, new DiscordRpcManager.AnonymousClass4(wizardViewModel2, null, (byte) 9), 3);
                                }
                                return unit;
                            default:
                                StateFlowImpl stateFlowImpl = wizardViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                    wizardStateCopy$default = (WizardState) value;
                                    if (WizardViewModel.WhenMappings.$EnumSwitchMapping$0[wizardStateCopy$default.currentStep.ordinal()] == 2) {
                                        wizardViewModel2.searchModels(wizardStateCopy$default.modelSearchQuery);
                                        wizardStateCopy$default = WizardState.copy$default(wizardStateCopy$default, WizardStep.MODEL_SELECTION, null, null, null, EmptyList.INSTANCE, EmptySet.INSTANCE, false, null, 974);
                                    }
                                } while (!stateFlowImpl.compareAndSet(value, wizardStateCopy$default));
                                return unit;
                        }
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            function1 = function0;
            WizardScreenContent(wizardState, function2, function3, function4, function5, function6, (Function0) objRememberedValue7, function1, gapComposer, (i3 << 18) & 29360128);
        } else {
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(wizardViewModel, function1, i, (byte) 27);
        }
    }

    public static final void WizardScreenContent(WizardState wizardState, Function0 function0, Function1 function1, Function1 function2, Function1 function3, Function0 function4, Function0 function5, Function0 function6, Composer composer, int i) {
        int i2;
        Function0 function7;
        Function1 function8;
        Function1 function9;
        Function1 function10;
        Function0 function11;
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1921460465);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer2.changed(wizardState) : gapComposer2.changedInstance(wizardState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function7 = function0;
            i2 |= gapComposer2.changedInstance(function7) ? 32 : 16;
        } else {
            function7 = function0;
        }
        if ((i & 384) == 0) {
            function8 = function1;
            i2 |= gapComposer2.changedInstance(function8) ? 256 : 128;
        } else {
            function8 = function1;
        }
        if ((i & 3072) == 0) {
            function9 = function2;
            i2 |= gapComposer2.changedInstance(function9) ? 2048 : 1024;
        } else {
            function9 = function2;
        }
        if ((i & 24576) == 0) {
            function10 = function3;
            i2 |= gapComposer2.changedInstance(function10) ? 16384 : 8192;
        } else {
            function10 = function3;
        }
        if ((196608 & i) == 0) {
            function11 = function4;
            i2 |= gapComposer2.changedInstance(function11) ? 131072 : 65536;
        } else {
            function11 = function4;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function5) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function6) ? 8388608 : 4194304;
        }
        byte b = 0;
        if (gapComposer2.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            gapComposer = gapComposer2;
            ScrimKt.m317ScaffoldTvnljyQ(null, Expect_jvmKt.rememberComposableLambda(-1716686637, new WizardScreenKt$$ExternalSyntheticLambda7(wizardState, function5, function6, b), gapComposer2), null, null, null, 0, 0L, 0L, null, Expect_jvmKt.rememberComposableLambda(2055563614, new QueueMenuKt$$ExternalSyntheticLambda12(wizardState, function7, function8, function9, function10, function11), gapComposer2), gapComposer, 805306416, 509);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt$$ExternalSyntheticLambda3(wizardState, function0, function1, function2, function3, function4, function5, function6, i);
        }
    }
}
