package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.lifecycle.SavedStateHandle;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda14;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda100;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda105;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda106;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda71;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda72;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$7$1;
import com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$8$1;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda32;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda33;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda84;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlyStateFlow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListenTogetherScreenKt {
    public static final void ConnectedUsersSection(ArrayList arrayList, boolean z, String str, Function2 function2, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1878791626);
        int i2 = i | (gapComposer.changed(arrayList) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(str) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(1632497949);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(1632500440);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(-2114585320, new HomeScreenKt$$ExternalSyntheticLambda29((List) arrayList, (Object) str, z, (Object) function2, (byte) 3), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda84(arrayList, z, str, function2, i, (byte) 7);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    public static final void ConnectionStatusCard(ConnectionState connectionState, Function0 function0, Function0 function1, Function0 function2, Composer composer, int i) {
        long jColor;
        long j;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1601419822);
        int i2 = i | (gapComposer.changed(connectionState.ordinal()) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(1366166817);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(1366169308);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
            Modifier modifierAnimateContentSize$default = CrossfadeKt.animateContentSize$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), ArcSplineKt.spring$default(0.5f, 200.0f, null, 4), 2);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
            int iOrdinal = connectionState.ordinal();
            if (iOrdinal == 0) {
                gapComposer.startReplaceGroup(1366199710);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                gapComposer.end(false);
            } else if (iOrdinal == 1) {
                gapComposer.startReplaceGroup(1366193600);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondaryContainer;
                gapComposer.end(false);
            } else if (iOrdinal == 2) {
                gapComposer.startReplaceGroup(1366189534);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer;
                gapComposer.end(false);
            } else if (iOrdinal == 3) {
                gapComposer.startReplaceGroup(1366193600);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondaryContainer;
                gapComposer.end(false);
            } else {
                if (iOrdinal != 4) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1366186650, false);
                }
                gapComposer.startReplaceGroup(1366196604);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.errorContainer;
                gapComposer.end(false);
            }
            CardKt.Card(modifierAnimateContentSize$default, roundedCornerShapeM185RoundedCornerShape0680j_4, CardKt.m267cardColorsro_MJ88(j, 0L, gapComposer, 14), null, borderStrokeM38BorderStrokecXLIe8U, Expect_jvmKt.rememberComposableLambda(1442876704, new SongMenuKt$$ExternalSyntheticLambda34(connectionState, function0, function1, function2, (byte) 13), gapComposer), gapComposer, 196608, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda3(connectionState, function0, function1, function2, i, (byte) 12);
        }
    }

    public static final void HeaderSection(boolean z, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1740581119);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            gapComposer.skipToGroupEnd();
        } else {
            if (z) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SongMenuKt$$ExternalSyntheticLambda26(z, i, (byte) 18);
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
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
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 80.0f), RoundedCornerShapeKt.CircleShape);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierClip, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primaryContainer, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.group_outlined, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 48.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimaryContainer, gapComposer, 440, 0);
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
            TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onBackground, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineMedium, gapComposer, 1572864, 0, 131002);
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 4.0f, gapComposer, R.string.listen_together_description, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 0, 130042);
            gapComposer = gapComposer;
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new SongMenuKt$$ExternalSyntheticLambda26(z, i, (byte) 19);
        }
    }

    public static final void JoinCreateRoomSection(String str, Function1 function1, String str2, Function1 function2, String str3, boolean z, String str4, String str5, BringIntoViewRequesterImpl bringIntoViewRequesterImpl, Function0 function0, Function0 function3, Function0 function4, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1277862539);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changed(str2) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changed(str3) ? 16384 : 8192) | (gapComposer.changed(z) ? 131072 : 65536) | (gapComposer.changed(str4) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(str5) ? 8388608 : 4194304) | (gapComposer.changed(bringIntoViewRequesterImpl) ? 67108864 : 33554432) | (gapComposer.changedInstance(function0) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, ((306783379 & i2) == 306783378 && (((gapComposer.changedInstance(function3) ? (char) 4 : (char) 2) | (gapComposer.changedInstance(function4) ? ' ' : (char) 16)) & 19) == 18) ? false : true)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(334765480);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(334767971);
                long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
                jColor = j;
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(1523009091, new SongMenuKt$$ExternalSyntheticLambda33(function4, str, function1, bringIntoViewRequesterImpl, str2, function2, z, str4, str3, str5, function0, function3), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda14(str, function1, str2, function2, str3, z, str4, str5, bringIntoViewRequesterImpl, function0, function3, function4, i);
        }
    }

    public static final void ListenTogetherScreen(final NavHostController navHostController, boolean z, Composer composer, int i) {
        NavHostController navHostController2;
        Object playerMenuKt$ListenTogetherDialog$8$1;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        Context context;
        MutableState mutableState4;
        GapComposer gapComposer;
        NeverEqualPolicy neverEqualPolicy;
        MutableState mutableStateCollectAsStateWithLifecycle;
        LazyListState lazyListState;
        GapComposer gapComposer2;
        SavedStateHandle savedStateHandle;
        navHostController.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(619949693);
        int i2 = (gapComposer3.changedInstance(navHostController) ? 4 : 2) | i;
        if (gapComposer3.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Context context2 = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer3.consume(MainActivityKt.LocalListenTogetherManager);
            WindowInsets windowInsets = (WindowInsets) gapComposer3.consume(MainActivityKt.LocalPlayerAwareWindowInsets);
            final String strStringResource = MathKt.stringResource(R.string.joining_room, gapComposer3);
            if (listenTogetherManager == null) {
                gapComposer3.startReplaceGroup(562301040);
                NotConfiguredContent(0, gapComposer3);
                gapComposer3.end(false);
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ListenTogetherScreenKt$$ExternalSyntheticLambda0(navHostController, z, i, (byte) 0);
                    return;
                }
                return;
            }
            gapComposer3.startReplaceGroup(562351973);
            gapComposer3.end(false);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.connectionState, gapComposer3);
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.roomState, gapComposer3);
            final MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.userId, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.pendingJoinRequests, gapComposer3);
            final MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.pendingSuggestions, gapComposer3);
            boolean z2 = z || ((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherInTopBarKey, Boolean.TRUE, gapComposer3, 48).$state.getValue()).booleanValue();
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherUsernameKey, "", gapComposer3, 48);
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                objRememberedValue = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 4);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState5 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer3, 48);
            Object[] objArr2 = new Object[0];
            boolean zChanged = gapComposer3.changed(dataStoreKt$rememberPreference$1$1RememberPreference);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy2) {
                objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda7(dataStoreKt$rememberPreference$1$1RememberPreference, (byte) 8);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, gapComposer3, 0);
            Object[] objArr3 = new Object[0];
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy2) {
                objRememberedValue3 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 5);
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState7 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue3, gapComposer3, 48);
            Object[] objArr4 = new Object[0];
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 6);
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState8 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) objRememberedValue4, gapComposer3, 48);
            Object[] objArr5 = new Object[0];
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 1);
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState9 = (MutableState) SaverKt.rememberSaveable(objArr5, (Function0) objRememberedValue5, gapComposer3, 48);
            Object[] objArr6 = new Object[0];
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy2) {
                objRememberedValue6 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 2);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr6, (Function0) objRememberedValue6, gapComposer3, 48);
            Object[] objArr7 = new Object[0];
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy2) {
                objRememberedValue7 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 3);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState11 = (MutableState) SaverKt.rememberSaveable(objArr7, (Function0) objRememberedValue7, gapComposer3, 48);
            final String strStringResource2 = MathKt.stringResource(R.string.waiting_for_approval, gapComposer3);
            String strStringResource3 = MathKt.stringResource(R.string.invalid_room_code, gapComposer3);
            String strStringResource4 = MathKt.stringResource(R.string.join_request_denied, gapComposer3);
            String str = (String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue();
            boolean zChanged2 = gapComposer3.changed(mutableState6) | gapComposer3.changed(dataStoreKt$rememberPreference$1$1RememberPreference);
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy2) {
                objRememberedValue8 = new PlayerMenuKt$ListenTogetherDialog$7$1(mutableState6, dataStoreKt$rememberPreference$1$1RememberPreference, null, (byte) 1);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            Stack.LaunchedEffect(gapComposer3, str, (Function2) objRememberedValue8);
            boolean zChangedInstance = gapComposer3.changedInstance(listenTogetherManager) | gapComposer3.changed(mutableState9) | gapComposer3.changed(strStringResource4) | gapComposer3.changed(strStringResource3) | gapComposer3.changed(mutableState8) | gapComposer3.changed(mutableState7) | gapComposer3.changedInstance(context2);
            Object objRememberedValue9 = gapComposer3.rememberedValue();
            if (zChangedInstance || objRememberedValue9 == neverEqualPolicy2) {
                mutableState = mutableStateCollectAsStateWithLifecycle5;
                mutableState2 = mutableState8;
                mutableState3 = mutableState9;
                playerMenuKt$ListenTogetherDialog$8$1 = new PlayerMenuKt$ListenTogetherDialog$8$1(listenTogetherManager, strStringResource4, strStringResource3, context2, mutableState3, mutableState2, mutableState7, null, (byte) 1);
                context = context2;
                mutableState4 = mutableState7;
                gapComposer3.updateRememberedValue(playerMenuKt$ListenTogetherDialog$8$1);
            } else {
                mutableState4 = mutableState7;
                mutableState2 = mutableState8;
                playerMenuKt$ListenTogetherDialog$8$1 = objRememberedValue9;
                mutableState = mutableStateCollectAsStateWithLifecycle5;
                mutableState3 = mutableState9;
                context = context2;
            }
            Stack.LaunchedEffect(gapComposer3, listenTogetherManager, (Function2) playerMenuKt$ListenTogetherDialog$8$1);
            final boolean zIsInRoom = listenTogetherManager.client.isInRoom();
            Listentogether.RoomState roomState = (Listentogether.RoomState) mutableStateCollectAsStateWithLifecycle3.getValue();
            final boolean zAreEqual = Intrinsics.areEqual(roomState != null ? roomState.getHostId() : null, (String) r16.getValue());
            if (((String) mutableState10.getValue()) == null || ((String) mutableState11.getValue()) == null) {
                mutableState = mutableState;
                gapComposer = gapComposer3;
                neverEqualPolicy = neverEqualPolicy2;
                gapComposer.startReplaceGroup(566595749);
                gapComposer.end(false);
            } else {
                gapComposer3.startReplaceGroup(565467535);
                String str2 = (String) mutableState11.getValue();
                String str3 = str2 != null ? str2 : "";
                boolean zChanged3 = gapComposer3.changed(mutableState10) | gapComposer3.changedInstance(listenTogetherManager) | gapComposer3.changed(mutableState11);
                Object objRememberedValue10 = gapComposer3.rememberedValue();
                if (zChanged3 || objRememberedValue10 == neverEqualPolicy2) {
                    objRememberedValue10 = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState10, listenTogetherManager, mutableState11, (byte) 3);
                    gapComposer3.updateRememberedValue(objRememberedValue10);
                }
                Function0 function0 = (Function0) objRememberedValue10;
                boolean zChanged4 = gapComposer3.changed(mutableState10) | gapComposer3.changed(mutableState11) | gapComposer3.changedInstance(listenTogetherManager);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (zChanged4 || objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState10, mutableState11, listenTogetherManager, (byte) 4);
                    gapComposer3.updateRememberedValue(objRememberedValue11);
                }
                Function0 function1 = (Function0) objRememberedValue11;
                boolean zChanged5 = gapComposer3.changed(mutableState10) | gapComposer3.changedInstance(listenTogetherManager) | gapComposer3.changed(mutableState11);
                Object objRememberedValue12 = gapComposer3.rememberedValue();
                if (zChanged5 || objRememberedValue12 == neverEqualPolicy2) {
                    objRememberedValue12 = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState10, listenTogetherManager, mutableState11, (byte) 5);
                    gapComposer3.updateRememberedValue(objRememberedValue12);
                }
                Function0 function2 = (Function0) objRememberedValue12;
                boolean zChanged6 = gapComposer3.changed(mutableState10) | gapComposer3.changed(mutableState11);
                Object objRememberedValue13 = gapComposer3.rememberedValue();
                if (zChanged6 || objRememberedValue13 == neverEqualPolicy2) {
                    objRememberedValue13 = new TooltipKt$$ExternalSyntheticLambda2(mutableState10, mutableState11, (byte) 6);
                    gapComposer3.updateRememberedValue(objRememberedValue13);
                }
                mutableState11 = mutableState11;
                neverEqualPolicy = neverEqualPolicy2;
                UserActionDialog(str3, function0, function1, function2, (Function0) objRememberedValue13, gapComposer3, 0);
                gapComposer = gapComposer3;
                gapComposer.end(false);
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue14;
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = new BringIntoViewRequesterImpl();
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            final BringIntoViewRequesterImpl bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) objRememberedValue15;
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(566928967);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(-1228637958);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            Boolean bool = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            boolean zChanged7 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue16 == neverEqualPolicy) {
                lazyListState = lazyListStateRememberLazyListState;
                objRememberedValue16 = new HomeScreenKt$HomeScreen$3$1(mutableStateCollectAsStateWithLifecycle, lazyListState, mutableStateCurrentBackStackEntryAsState, null, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue16);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
            }
            Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue16);
            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(ImageKt.m39backgroundbw27NRU(SizeKt.FillWholeMaxSize, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background, ColorKt.RectangleShape), OffsetKt.imeLambda);
            float fMo125calculateTopPaddingD9Ej5fM = OffsetKt.asPaddingValues(r27, gapComposer).mo125calculateTopPaddingD9Ej5fM() + 16.0f + CropImageView.DEFAULT_ASPECT_RATIO;
            float fMo122calculateBottomPaddingD9Ej5fM = OffsetKt.asPaddingValues(windowInsets, gapComposer).mo122calculateBottomPaddingD9Ej5fM() + 16.0f + CropImageView.DEFAULT_ASPECT_RATIO;
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(16.0f, fMo125calculateTopPaddingD9Ej5fM, 16.0f, fMo122calculateBottomPaddingD9Ej5fM + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            final MutableState mutableState12 = mutableState11;
            final MutableState mutableState13 = mutableState;
            final MutableState mutableState14 = mutableState2;
            boolean zChanged8 = gapComposer.changed(zIsInRoom) | gapComposer.changed(r26) | gapComposer.changedInstance(listenTogetherManager) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer.changed(zAreEqual) | gapComposer.changedInstance(context) | gapComposer.changed(r16) | gapComposer.changed(mutableState10) | gapComposer.changed(mutableState12) | gapComposer.changed(mutableState13) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle6) | gapComposer.changed(mutableState6) | gapComposer.changed(mutableState5) | gapComposer.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer.changed(mutableState14) | gapComposer.changed(mutableState3) | gapComposer.changed(strStringResource2) | gapComposer.changedInstance(bringIntoViewRequesterImpl);
            final MutableState mutableState15 = mutableState4;
            boolean zChanged9 = zChanged8 | gapComposer.changed(mutableState15) | gapComposer.changed(strStringResource) | gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(navHostController);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (zChanged9 || objRememberedValue17 == neverEqualPolicy) {
                final MutableState mutableState16 = mutableState3;
                final Context context3 = context;
                objRememberedValue17 = new Function1() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        String str4;
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                        lazyListIntervalContent.getClass();
                        byte b = 2;
                        boolean z3 = zIsInRoom;
                        byte b2 = 3;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -231871086, new MiniPlayerKt$$ExternalSyntheticLambda17(b, z3)), 3);
                        final ListenTogetherManager listenTogetherManager2 = listenTogetherManager;
                        State state = mutableStateCollectAsStateWithLifecycle2;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2068779145, new PlayerMenuKt$$ExternalSyntheticLambda71(listenTogetherManager2, state, (byte) 1)), 3);
                        if (((ConnectionState) state.getValue()) == ConnectionState.CONNECTED && !z3) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumScreenKt.f311lambda$1721377875, 3);
                        }
                        final Context context4 = context3;
                        if (z3) {
                            Listentogether.RoomState roomState2 = (Listentogether.RoomState) mutableStateCollectAsStateWithLifecycle3.getValue();
                            if (roomState2 != null) {
                                boolean z4 = zAreEqual;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 835544181, new PlayerMenuKt$$ExternalSyntheticLambda72(roomState2, z4, context4)), 3);
                                List<Listentogether.UserInfo> usersList = roomState2.getUsersList();
                                usersList.getClass();
                                ArrayList arrayList = new ArrayList();
                                for (Object obj2 : usersList) {
                                    if (((Listentogether.UserInfo) obj2).getIsConnected()) {
                                        arrayList.add(obj2);
                                    }
                                }
                                String str5 = (String) mutableStateCollectAsStateWithLifecycle4.getValue();
                                if (str5 == null) {
                                    str5 = "";
                                }
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1697577964, new SongMenuKt$$ExternalSyntheticLambda32(arrayList, z4, str5, mutableState10, mutableState12, (byte) 3)), 3);
                                if (z4) {
                                    State state2 = mutableState13;
                                    if (!((List) state2.getValue()).isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1955099920, new PlayerMenuKt$$ExternalSyntheticLambda71(listenTogetherManager2, state2, b)), 3);
                                    }
                                }
                                if (z4) {
                                    State state3 = mutableStateCollectAsStateWithLifecycle6;
                                    if (!((List) state3.getValue()).isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -446148153, new PlayerMenuKt$$ExternalSyntheticLambda71(listenTogetherManager2, state3, b2)), 3);
                                    }
                                }
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 860783021, new ListItemKt$$ExternalSyntheticLambda17((byte) 13, (Object) listenTogetherManager2)), 3);
                            }
                            str4 = null;
                        } else {
                            final MutableState mutableState17 = mutableState6;
                            final MutableState mutableState18 = mutableState5;
                            final String str6 = strStringResource2;
                            final BringIntoViewRequesterImpl bringIntoViewRequesterImpl2 = bringIntoViewRequesterImpl;
                            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference;
                            final MutableState mutableState19 = mutableState15;
                            final MutableState mutableState20 = mutableState14;
                            final MutableState mutableState21 = mutableState16;
                            final String str7 = strStringResource;
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(true, -1509753043, new Function3() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Composer composer2 = (Composer) obj4;
                                    int iIntValue = ((Integer) obj5).intValue();
                                    ((LazyItemScopeImpl) obj3).getClass();
                                    GapComposer gapComposer4 = (GapComposer) composer2;
                                    if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                        MutableState mutableState22 = mutableState17;
                                        String str8 = (String) mutableState22.getValue();
                                        boolean zChanged10 = gapComposer4.changed(mutableState22);
                                        Object objRememberedValue18 = gapComposer4.rememberedValue();
                                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                        if (zChanged10 || objRememberedValue18 == neverEqualPolicy3) {
                                            objRememberedValue18 = new TooltipKt$$ExternalSyntheticLambda5(mutableState22, (byte) 25);
                                            gapComposer4.updateRememberedValue(objRememberedValue18);
                                        }
                                        Function1 function3 = (Function1) objRememberedValue18;
                                        MutableState mutableState23 = mutableState18;
                                        String str9 = (String) mutableState23.getValue();
                                        boolean zChanged11 = gapComposer4.changed(mutableState23);
                                        Object objRememberedValue19 = gapComposer4.rememberedValue();
                                        if (zChanged11 || objRememberedValue19 == neverEqualPolicy3) {
                                            objRememberedValue19 = new TooltipKt$$ExternalSyntheticLambda5(mutableState23, (byte) 26);
                                            gapComposer4.updateRememberedValue(objRememberedValue19);
                                        }
                                        Function1 function4 = (Function1) objRememberedValue19;
                                        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1;
                                        String str10 = (String) dataStoreKt$rememberPreference$1$2.$state.getValue();
                                        MutableState mutableState24 = mutableState20;
                                        boolean zBooleanValue = ((Boolean) mutableState24.getValue()).booleanValue();
                                        MutableState mutableState25 = mutableState21;
                                        String str11 = (String) mutableState25.getValue();
                                        boolean zChanged12 = gapComposer4.changed(mutableState22) | gapComposer4.changed(dataStoreKt$rememberPreference$1$2);
                                        Context context5 = context4;
                                        boolean zChangedInstance2 = zChanged12 | gapComposer4.changedInstance(context5);
                                        MutableState mutableState26 = mutableState19;
                                        boolean zChanged13 = zChangedInstance2 | gapComposer4.changed(mutableState26) | gapComposer4.changed(mutableState24) | gapComposer4.changed(mutableState25);
                                        ListenTogetherManager listenTogetherManager3 = listenTogetherManager2;
                                        boolean zChangedInstance3 = zChanged13 | gapComposer4.changedInstance(listenTogetherManager3);
                                        Object objRememberedValue20 = gapComposer4.rememberedValue();
                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy3) {
                                            PlayerMenuKt$$ExternalSyntheticLambda105 playerMenuKt$$ExternalSyntheticLambda105 = new PlayerMenuKt$$ExternalSyntheticLambda105(context5, listenTogetherManager3, mutableState22, dataStoreKt$rememberPreference$1$2, mutableState26, mutableState24, mutableState25, (byte) 1);
                                            gapComposer4.updateRememberedValue(playerMenuKt$$ExternalSyntheticLambda105);
                                            objRememberedValue20 = playerMenuKt$$ExternalSyntheticLambda105;
                                        }
                                        Function0 function5 = (Function0) objRememberedValue20;
                                        boolean zChanged14 = gapComposer4.changed(mutableState22) | gapComposer4.changed(dataStoreKt$rememberPreference$1$2) | gapComposer4.changedInstance(context5);
                                        String str12 = str7;
                                        boolean zChanged15 = zChanged14 | gapComposer4.changed(str12) | gapComposer4.changed(mutableState23) | gapComposer4.changed(mutableState24) | gapComposer4.changed(mutableState26) | gapComposer4.changed(mutableState25) | gapComposer4.changedInstance(listenTogetherManager3);
                                        Object objRememberedValue21 = gapComposer4.rememberedValue();
                                        if (zChanged15 || objRememberedValue21 == neverEqualPolicy3) {
                                            PlayerMenuKt$$ExternalSyntheticLambda106 playerMenuKt$$ExternalSyntheticLambda106 = new PlayerMenuKt$$ExternalSyntheticLambda106(context5, str12, listenTogetherManager3, mutableState22, dataStoreKt$rememberPreference$1$2, mutableState23, mutableState24, mutableState26, mutableState25, (byte) 1);
                                            gapComposer4.updateRememberedValue(playerMenuKt$$ExternalSyntheticLambda106);
                                            objRememberedValue21 = playerMenuKt$$ExternalSyntheticLambda106;
                                        }
                                        Function0 function6 = (Function0) objRememberedValue21;
                                        CoroutineScope coroutineScope3 = coroutineScope2;
                                        boolean zChangedInstance4 = gapComposer4.changedInstance(coroutineScope3);
                                        BringIntoViewRequesterImpl bringIntoViewRequesterImpl3 = bringIntoViewRequesterImpl2;
                                        boolean zChangedInstance5 = zChangedInstance4 | gapComposer4.changedInstance(bringIntoViewRequesterImpl3);
                                        Object objRememberedValue22 = gapComposer4.rememberedValue();
                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy3) {
                                            objRememberedValue22 = new QueueKt$$ExternalSyntheticLambda16(coroutineScope3, bringIntoViewRequesterImpl3, (byte) 7);
                                            gapComposer4.updateRememberedValue(objRememberedValue22);
                                        }
                                        ListenTogetherScreenKt.JoinCreateRoomSection(str8, function3, str9, function4, str10, zBooleanValue, str11, str6, bringIntoViewRequesterImpl3, function5, function6, (Function0) objRememberedValue22, gapComposer4, 0);
                                    } else {
                                        gapComposer4.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            str4 = null;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, composableLambdaImpl, 3);
                        }
                        LazyListIntervalContent.item$default(lazyListIntervalContent, str4, str4, new ComposableLambdaImpl(true, 2078549706, new HomeScreenKt$$ExternalSyntheticLambda43(navHostController, b2)), 3);
                        return Unit.INSTANCE;
                    }
                };
                navHostController2 = navHostController;
                gapComposer2 = gapComposer;
                gapComposer2.updateRememberedValue(objRememberedValue17);
            } else {
                navHostController2 = navHostController;
                gapComposer2 = gapComposer;
            }
            GapComposer gapComposer4 = gapComposer2;
            IntMath.LazyColumn(modifierWindowInsetsPadding, lazyListState, paddingValuesImpl, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue17, gapComposer4, 24576, 488);
            gapComposer3 = gapComposer4;
            if (z2) {
                gapComposer3.startReplaceGroup(574945847);
                MenuKt.m1493TopAppBarGHTll3U(AlbumScreenKt.f298lambda$1066968564, null, Expect_jvmKt.rememberComposableLambda(-728681014, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 5), gapComposer3), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer3, 390, 250);
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(575420581);
                gapComposer3.end(false);
            }
        } else {
            navHostController2 = navHostController;
            gapComposer3.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer3.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new ListenTogetherScreenKt$$ExternalSyntheticLambda0(navHostController2, z, i, (byte) 1);
        }
    }

    public static final void NotConfiguredContent(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2076503833);
        if (gapComposer.shouldExecute(i & 1, i != 0)) {
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
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
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 24.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.group, 0, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 64.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 440, 0);
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 16.0f, gapComposer, R.string.listen_together, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineMedium, gapComposer, 1572864, 0, 131002);
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 8.0f, gapComposer, R.string.listen_together_not_configured, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer, 0, 0, 130042);
            gapComposer = gapComposer;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda97(i);
        }
    }

    public static final void PendingJoinRequestsSection(List list, Function1 function1, Function1 function2, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-569413607);
        int i2 = (gapComposer.changed(list) ? 4 : 2) | i | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128);
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1745620308);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(-1745617817);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(-267823257, new ListenTogetherScreenKt$$ExternalSyntheticLambda53(list, function1, function2, b), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListenTogetherScreenKt$$ExternalSyntheticLambda54(list, function1, function2, i, (byte) 0);
        }
    }

    public static final void PendingSuggestionsSection(List list, Function1 function1, Function1 function2, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-227816886);
        int i2 = (gapComposer.changed(list) ? 4 : 2) | i | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128);
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(111314365);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(111316856);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(890290492, new ListenTogetherScreenKt$$ExternalSyntheticLambda53(list, function1, function2, b), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListenTogetherScreenKt$$ExternalSyntheticLambda54(list, function1, function2, i, (byte) 1);
        }
    }

    public static final void RoomStatusCard(String str, boolean z, Context context, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1989468862);
        int i2 = (gapComposer.changed(str) ? 4 : 2) | i | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(context) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(619137425);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(619139916);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(-1389393268, new LoginScreenKt$$ExternalSyntheticLambda17((Object) str, z, (Object) context, (byte) 5), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(str, z, context, i, (byte) 9);
        }
    }

    public static final void SettingsLinkCard(Function0 function0, Composer composer, int i) {
        long jColor;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-522446912);
        int i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(439697523);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(439700014);
                jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            CardKt.Card(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), false, null, function0, 15), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 16.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), AlbumScreenKt.lambda$547112114, gapComposer, 196608, 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 10);
        }
    }

    public static final void UserActionDialog(String str, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1751973145);
        byte b = 4;
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changedInstance(function3) ? 16384 : 8192);
        byte b2 = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            DialogKt.DefaultDialog(function3, null, AlbumScreenKt.lambda$904204061, Expect_jvmKt.rememberComposableLambda(1076618142, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 19), gapComposer), Expect_jvmKt.rememberComposableLambda(2013784007, new PlayerMenuKt$$ExternalSyntheticLambda49(function3, b), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-325597007, new DialogKt$$ExternalSyntheticLambda4(function0, function1, function2, b2), gapComposer), gapComposer, ((i2 >> 12) & 14) | 1600896, 34);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda92(str, function0, function1, function2, function3, i, (byte) 8);
        }
    }

    public static final void UserAvatar(final Listentogether.UserInfo userInfo, final boolean z, final boolean z2, final Function0 function0, Composer composer, final int i) {
        boolean z3;
        long j;
        long j2;
        Modifier.Companion companion;
        long j3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1635743032);
        int i2 = i | (gapComposer.changed(userInfo) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(z2) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(SizeKt.m155width3ABfNKs(companion2, 72.0f), z2, null, function0, 14);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM46clickableoSLSa3U$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z4 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z4) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, companion2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 56.0f);
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            if (userInfo.getIsHost()) {
                gapComposer.startReplaceGroup(-1454865309);
                j = CardKt.getColorScheme(gapComposer).primary;
                z3 = false;
                gapComposer.end(false);
            } else {
                z3 = false;
                if (z) {
                    gapComposer.startReplaceGroup(-1454862907);
                    j = CardKt.getColorScheme(gapComposer).secondary;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1454860726);
                    j = CardKt.getColorScheme(gapComposer).surfaceVariant;
                    gapComposer.end(false);
                }
            }
            boolean z5 = z3;
            SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs, roundedCornerShape, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1120739009, new StringsKt__StringsKt$$ExternalSyntheticLambda1((Object) userInfo, z, (byte) 7), gapComposer), gapComposer, 12582918, 120);
            if (userInfo.getIsHost() || z) {
                gapComposer.startReplaceGroup(2144858705);
                Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(OffsetKt.m133offsetVpY3zN4(BoxScopeInstance.INSTANCE.align(companion2, Alignment.Companion.BottomEnd), 4.0f, 4.0f), 20.0f);
                if (userInfo.getIsHost()) {
                    gapComposer.startReplaceGroup(-1454821341);
                    j2 = CardKt.getColorScheme(gapComposer).primary;
                } else {
                    gapComposer.startReplaceGroup(-1454820091);
                    j2 = CardKt.getColorScheme(gapComposer).secondary;
                }
                gapComposer.end(z5);
                companion = companion2;
                SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs2, roundedCornerShape, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(784662086, new PlayerMenuKt$$ExternalSyntheticLambda100(userInfo, (byte) 1), gapComposer), gapComposer, 12582912, 120);
                gapComposer.end(z5);
            } else {
                gapComposer.startReplaceGroup(2145924454);
                gapComposer.end(z5);
                companion = companion2;
            }
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
            String username = userInfo.getUsername();
            username.getClass();
            TextStyle textStyle = CardKt.getTypography(gapComposer).labelMedium;
            FontWeight fontWeight = z ? FontWeight.Bold : FontWeight.Medium;
            if (userInfo.getIsHost()) {
                gapComposer.startReplaceGroup(-1286134391);
                j3 = CardKt.getColorScheme(gapComposer).primary;
            } else {
                gapComposer.startReplaceGroup(-1286133141);
                j3 = CardKt.getColorScheme(gapComposer).onSurface;
            }
            gapComposer.end(z5);
            TextKt.m352TextNvy7gAk(username, null, j3, 0L, null, fontWeight, null, 0L, new TextAlign(3), 0L, 2, false, 1, 0, textStyle, gapComposer, 0, 24960, 109498);
            gapComposer = gapComposer;
            if (userInfo.getIsHost()) {
                gapComposer.startReplaceGroup(-1215241626);
                String strStringResource = MathKt.stringResource(R.string.host_label, gapComposer);
                TextStyle textStyle2 = CardKt.getTypography(gapComposer).labelSmall;
                long j4 = CardKt.getColorScheme(gapComposer).primary;
                TextKt.m352TextNvy7gAk(strStringResource, null, ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.8f, Color.m483getColorSpaceimpl(j4)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer, 0, 0, 131066);
                gapComposer = gapComposer;
                gapComposer.end(z5);
            } else if (z) {
                gapComposer.startReplaceGroup(-1214976731);
                String strStringResource2 = MathKt.stringResource(R.string.you_label, gapComposer);
                TextStyle textStyle3 = CardKt.getTypography(gapComposer).labelSmall;
                long j5 = CardKt.getColorScheme(gapComposer).secondary;
                TextKt.m352TextNvy7gAk(strStringResource2, null, ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), 0.8f, Color.m483getColorSpaceimpl(j5)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle3, gapComposer, 0, 0, 131066);
                gapComposer = gapComposer;
                gapComposer.end(z5);
            } else {
                gapComposer.startReplaceGroup(-1214756352);
                gapComposer.end(z5);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, z2, function0, i) { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda79
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ Function0 f$3;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ListenTogetherScreenKt.UserAvatar(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
