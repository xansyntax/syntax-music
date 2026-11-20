package com.metrolist.music.ui.screens.recognition;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import coil3.util.FileSystemsKt;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda10;
import java.time.format.DateTimeFormatter;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RecognitionHistoryScreenKt {

    /* JADX INFO: renamed from: lambda$-683154865, reason: not valid java name */
    public static final ComposableLambdaImpl f421lambda$683154865 = new ComposableLambdaImpl(false, -683154865, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 15));
    public static final ComposableLambdaImpl lambda$366714350 = new ComposableLambdaImpl(false, 366714350, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 20));

    /* JADX INFO: renamed from: lambda$-943563614, reason: not valid java name */
    public static final ComposableLambdaImpl f427lambda$943563614 = new ComposableLambdaImpl(false, -943563614, new AiSettingsKt$$ExternalSyntheticLambda10(4));

    /* JADX INFO: renamed from: lambda$-942409959, reason: not valid java name */
    public static final ComposableLambdaImpl f426lambda$942409959 = new ComposableLambdaImpl(false, -942409959, new AiSettingsKt$$ExternalSyntheticLambda10(5));

    /* JADX INFO: renamed from: lambda$-152282309, reason: not valid java name */
    public static final ComposableLambdaImpl f414lambda$152282309 = new ComposableLambdaImpl(false, -152282309, new AiSettingsKt$$ExternalSyntheticLambda10(6));

    /* JADX INFO: renamed from: lambda$-181096438, reason: not valid java name */
    public static final ComposableLambdaImpl f417lambda$181096438 = new ComposableLambdaImpl(false, -181096438, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 21));

    /* JADX INFO: renamed from: lambda$-58192501, reason: not valid java name */
    public static final ComposableLambdaImpl f420lambda$58192501 = new ComposableLambdaImpl(false, -58192501, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 22));

    /* JADX INFO: renamed from: lambda$-879373225, reason: not valid java name */
    public static final ComposableLambdaImpl f423lambda$879373225 = new ComposableLambdaImpl(false, -879373225, new AiSettingsKt$$ExternalSyntheticLambda10(2));

    /* JADX INFO: renamed from: lambda$-1971355648, reason: not valid java name */
    public static final ComposableLambdaImpl f418lambda$1971355648 = new ComposableLambdaImpl(false, -1971355648, new AiSettingsKt$$ExternalSyntheticLambda10(3));

    /* JADX INFO: renamed from: lambda$-1542181960, reason: not valid java name */
    public static final ComposableLambdaImpl f415lambda$1542181960 = new ComposableLambdaImpl(false, -1542181960, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 16));
    public static final ComposableLambdaImpl lambda$555061016 = new ComposableLambdaImpl(false, 555061016, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 17));
    public static final ComposableLambdaImpl lambda$252004198 = new ComposableLambdaImpl(false, 252004198, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 18));

    /* JADX INFO: renamed from: lambda$-1092212599, reason: not valid java name */
    public static final ComposableLambdaImpl f412lambda$1092212599 = new ComposableLambdaImpl(false, -1092212599, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 19));

    /* JADX INFO: renamed from: lambda$-1556280156, reason: not valid java name */
    public static final ComposableLambdaImpl f416lambda$1556280156 = new ComposableLambdaImpl(false, -1556280156, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 23));

    /* JADX INFO: renamed from: lambda$-932939772, reason: not valid java name */
    public static final ComposableLambdaImpl f425lambda$932939772 = new ComposableLambdaImpl(false, -932939772, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 24));

    /* JADX INFO: renamed from: lambda$-810156361, reason: not valid java name */
    public static final ComposableLambdaImpl f422lambda$810156361 = new ComposableLambdaImpl(false, -810156361, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 25));

    /* JADX INFO: renamed from: lambda$-484560248, reason: not valid java name */
    public static final ComposableLambdaImpl f419lambda$484560248 = new ComposableLambdaImpl(false, -484560248, new AiSettingsKt$$ExternalSyntheticLambda10(7));
    public static final ComposableLambdaImpl lambda$1394527898 = new ComposableLambdaImpl(false, 1394527898, new AiSettingsKt$$ExternalSyntheticLambda10(8));
    public static final ComposableLambdaImpl lambda$349393112 = new ComposableLambdaImpl(false, 349393112, new AiSettingsKt$$ExternalSyntheticLambda10(9));

    /* JADX INFO: renamed from: lambda$-1265990463, reason: not valid java name */
    public static final ComposableLambdaImpl f413lambda$1265990463 = new ComposableLambdaImpl(false, -1265990463, new AiSettingsKt$$ExternalSyntheticLambda10(10));

    /* JADX INFO: renamed from: lambda$-924272312, reason: not valid java name */
    public static final ComposableLambdaImpl f424lambda$924272312 = new ComposableLambdaImpl(false, -924272312, new AiSettingsKt$$ExternalSyntheticLambda10(11));

    public static final void RecognitionHistoryItem(RecognitionHistory recognitionHistory, Function0 function0, Function0 function1, Composer composer, int i) {
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1654925689);
        int i2 = i | (gapComposer2.changedInstance(recognitionHistory) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) objRememberedValue;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function0, (byte) 18);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue2, 15), 20.0f, 12.0f), gapComposer2, 0);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM1473hairlineBottomiJQMabo);
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
            String str = recognitionHistory.coverArtUrl;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 60.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            AsyncImageKt.m849AsyncImage10Xjiaw(str, Format$$ExternalSyntheticOutline0.m(16.0f, 10.0f, gapComposer2, modifierM151size3ABfNKs), ContentScale.Companion.Crop, gapComposer2, 1572912, 1976);
            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
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
            String str2 = recognitionHistory.title;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m352TextNvy7gAk(str2, null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer2, 1572864, 24960, 110526);
            TextKt.m352TextNvy7gAk(recognitionHistory.artist, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer2, 0, 24960, 110586);
            String str3 = recognitionHistory.recognizedAt.format(dateTimeFormatter);
            str3.getClass();
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall;
            long j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
            TextKt.m352TextNvy7gAk(str3, null, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.7f, Color.m483getColorSpaceimpl(j)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 0, 0, 131066);
            gapComposer2.end(true);
            CardKt.IconButton(function1, null, false, null, null, f412lambda$1092212599, gapComposer2, ((i2 >> 6) & 14) | 1572864, 62);
            gapComposer = gapComposer2;
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 11, i, recognitionHistory, function0, function1);
        }
    }

    public static final void RecognitionHistoryScreen(NavHostController navHostController, Composer composer, int i) {
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        MutableState mutableState4;
        navHostController.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(146639160);
        int i2 = (gapComposer.changedInstance(navHostController) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.recognitionHistory(), EmptyList.INSTANCE, gapComposer, 48);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue3;
            if (((Boolean) mutableState5.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(545981450);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState5, (byte) 26);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-645914907, new PlayerKt$$ExternalSyntheticLambda82(coroutineScope, musicDatabase, mutableState5, (byte) 16), gapComposer);
                mutableState2 = mutableState5;
                mutableState = mutableStateCollectAsStateWithLifecycle;
                DialogKt.DefaultDialog((Function0) objRememberedValue4, null, f421lambda$683154865, lambda$366714350, composableLambdaImplRememberComposableLambda, null, f414lambda$152282309, gapComposer, 1600902, 34);
                gapComposer.end(false);
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle;
                mutableState2 = mutableState5;
                gapComposer.startReplaceGroup(547119274);
                gapComposer.end(false);
            }
            RecognitionHistory recognitionHistory = (RecognitionHistory) mutableState6.getValue();
            if (recognitionHistory == null) {
                gapComposer.startReplaceGroup(547175693);
                gapComposer.end(false);
                mutableState4 = mutableState6;
            } else {
                gapComposer.startReplaceGroup(547175694);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    mutableState3 = mutableState6;
                    objRememberedValue5 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState3, (byte) 29);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    mutableState3 = mutableState6;
                }
                mutableState4 = mutableState3;
                DialogKt.DefaultDialog((Function0) objRememberedValue5, null, f417lambda$181096438, f420lambda$58192501, Expect_jvmKt.rememberComposableLambda(1161659060, new SongMenuKt$$ExternalSyntheticLambda34(coroutineScope, musicDatabase, recognitionHistory, mutableState3, (byte) 18), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-1577214562, new ListItemKt$$ExternalSyntheticLambda17((byte) 18, (Object) recognitionHistory), gapComposer), gapComposer, 1600902, 34);
                gapComposer.end(false);
            }
            ScrimKt.m317ScaffoldTvnljyQ(null, Expect_jvmKt.rememberComposableLambda(624836348, new AlbumScreenKt$$ExternalSyntheticLambda8((Object) navHostController, (Object) mutableState, mutableState2, (byte) 12), gapComposer), null, null, null, 0, 0L, 0L, null, Expect_jvmKt.rememberComposableLambda(-268938105, new PlayerKt$$ExternalSyntheticLambda82(mutableState, navHostController, mutableState4, (byte) 17), gapComposer), gapComposer, 805306416, 509);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, i, (byte) 14);
        }
    }
}
