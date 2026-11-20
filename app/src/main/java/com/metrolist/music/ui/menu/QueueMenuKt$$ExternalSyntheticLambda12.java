package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.OriginalLyricsKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardState;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardStep;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda30;
import com.metrolist.music.ui.screens.settings.BackupAndRestoreKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.settings.integrations.DiscordSettingsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda45;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.StatsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda12 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(SnapshotStateList snapshotStateList, List list, MenuState menuState, MutableState mutableState, MutableState mutableState2, Function0 function0) {
        this.$r8$classId = (byte) 10;
        this.f$1 = snapshotStateList;
        this.f$0 = list;
        this.f$2 = menuState;
        this.f$5 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = function0;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda8(Object obj, Object obj2, Object obj3) {
        SnapshotStateList snapshotStateList = (SnapshotStateList) this.f$1;
        List list = (List) this.f$0;
        MenuState menuState = (MenuState) this.f$2;
        MutableState mutableState = (MutableState) this.f$5;
        MutableState mutableState2 = (MutableState) this.f$3;
        Function0 function0 = (Function0) this.f$4;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zOnlinePlaylistScreen$lambda$20 = TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState2);
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zOnlinePlaylistScreen$lambda$20) {
                gapComposer.startReplaceGroup(-1752959254);
                boolean z = snapshotStateList.size() == list.size() && !snapshotStateList.isEmpty();
                boolean zChangedInstance = gapComposer.changedInstance(list);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda4((Object) snapshotStateList, (Object) list, (byte) 21);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                CardKt.Checkbox(z, (Function1) objRememberedValue, null, false, null, gapComposer, 0);
                boolean z2 = !snapshotStateList.isEmpty();
                boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(list);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new AlarmSettingsKt$$ExternalSyntheticLambda30(list, snapshotStateList, function0, menuState);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                CardKt.IconButton((Function0) objRememberedValue2, null, z2, null, null, TopPlaylistScreenKt.lambda$2048978586, gapComposer, 1572864, 58);
                gapComposer.end(false);
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-1751148017);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1751474757);
                boolean zChanged2 = gapComposer.changed(mutableState);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 20);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, TopPlaylistScreenKt.f389lambda$1550405359, gapComposer, 1572864, 62);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$BackupAndRestoreKt$$ExternalSyntheticLambda17(Object obj, Object obj2, Object obj3) {
        MutableState mutableState = (MutableState) this.f$5;
        BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) this.f$0;
        Context context = (Context) this.f$1;
        MutableState mutableState2 = (MutableState) this.f$2;
        MutableState mutableState3 = (MutableState) this.f$3;
        MutableState mutableState4 = (MutableState) this.f$4;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new BackupAndRestoreKt$$ExternalSyntheticLambda16(mutableState, mutableState2, mutableState3, mutableState4, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.lambda$1450858200, gapComposer, 805306368, 510);
            boolean zChanged2 = gapComposer.changed(mutableState) | gapComposer.changedInstance(backupRestoreViewModel) | gapComposer.changedInstance(context);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(mutableState, mutableState2, backupRestoreViewModel, context, mutableState3, mutableState4);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda73;
            }
            CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AiSettingsKt.lambda$1723588047, gapComposer, 805306368, 510);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$integrations$ListenTogetherSettingsKt$$ExternalSyntheticLambda13(Object obj, Object obj2, Object obj3) {
        MutableState mutableState = (MutableState) this.f$5;
        MutableState mutableState2 = (MutableState) this.f$0;
        MutableState mutableState3 = (MutableState) this.f$1;
        MutableState mutableState4 = (MutableState) this.f$2;
        ListenTogetherManager listenTogetherManager = (ListenTogetherManager) this.f$3;
        Context context = (Context) this.f$4;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState, (byte) 25);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, LastFMSettingsKt.f635lambda$950874958, gapComposer, 805306368, 510);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(Modifier.Companion.$$INSTANCE, 8.0f));
            boolean zChanged2 = gapComposer.changed(mutableState2) | gapComposer.changed(mutableState3) | gapComposer.changed(mutableState4) | gapComposer.changedInstance(listenTogetherManager) | gapComposer.changed(mutableState) | gapComposer.changedInstance(context);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda73(listenTogetherManager, context, mutableState2, mutableState3, mutableState4, mutableState);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CardKt.Button((Function0) objRememberedValue2, null, !StringsKt.isBlank(StringsKt.trim((String) mutableState2.getValue()).toString()) && ((String) mutableState3.getValue()).length() == 8, null, null, null, null, null, null, LastFMSettingsKt.f596lambda$110951451, gapComposer, 805306368, 506);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:177:0x0837  */
    /* JADX WARN: Code duplicated, block: B:181:0x085e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ?? r4;
        SnapshotStateList snapshotStateList;
        Material3MenuItemData material3MenuItemData;
        boolean z;
        Material3MenuItemData material3MenuItemData2;
        ?? r5;
        boolean z2;
        List list;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        long jColor;
        long j;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj4 = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$4;
        Object obj6 = this.f$3;
        Object obj7 = this.f$2;
        Object obj8 = this.f$1;
        Object obj9 = this.f$5;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                List list2 = (List) obj10;
                MediaMetadata mediaMetadata = (MediaMetadata) obj8;
                NavHostController navHostController = (NavHostController) obj7;
                BottomSheetState bottomSheetState = (BottomSheetState) obj6;
                Function0 function0 = (Function0) obj5;
                MutableState mutableState = (MutableState) obj9;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.startReplaceGroup(-388207277);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (list2.isEmpty()) {
                        gapComposer.startReplaceGroup(1936051787);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1934552627);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f50lambda$1097552096;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f182lambda$279656735;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(538238626, new QueueMenuKt$$ExternalSyntheticLambda22(mediaMetadata, (byte) 0), gapComposer);
                        boolean zChanged = gapComposer.changed(mediaMetadata) | gapComposer.changedInstance(navHostController) | gapComposer.changed(bottomSheetState) | gapComposer.changed(function0) | gapComposer.changed(mutableState);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue3 == obj4) {
                            objRememberedValue3 = new QueueMenuKt$$ExternalSyntheticLambda23(mediaMetadata, navHostController, bottomSheetState, function0, mutableState, (byte) 0);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue3, null, null, 48));
                        gapComposer.end(false);
                    }
                    if (mediaMetadata.album != null) {
                        gapComposer.startReplaceGroup(1936145376);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f43lambda$1045117751;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f40lambda$1026690998;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1008264245, new QueueMenuKt$$ExternalSyntheticLambda22(mediaMetadata, (byte) 3), gapComposer);
                        boolean zChangedInstance3 = gapComposer.changedInstance(navHostController) | gapComposer.changed(mediaMetadata) | gapComposer.changed(bottomSheetState) | gapComposer.changed(function0);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == obj4) {
                            objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda63((Object) navHostController, (Object) mediaMetadata, (Object) bottomSheetState, (Object) function0, (byte) 13);
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, composableLambdaImplRememberComposableLambda2, (Function0) objRememberedValue4, null, null, 48));
                        r4 = 0;
                        gapComposer.end(false);
                    } else {
                        r4 = 0;
                        gapComposer.startReplaceGroup(1937386027);
                        gapComposer.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer.end(r4);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, r4);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                MutableState mutableState2 = (MutableState) obj9;
                List list3 = (List) obj10;
                State state = (State) obj8;
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj7;
                MutableState mutableState3 = (MutableState) obj6;
                MutableState mutableState4 = (MutableState) obj5;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer2, 54);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    boolean zChanged2 = gapComposer2.changed(mutableState2);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == obj4) {
                        objRememberedValue5 = new OriginalLyricsKt$$ExternalSyntheticLambda1(snapshotStateList2, mutableState2, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.FilledTonalButton((Function0) objRememberedValue5, null, false, null, null, null, null, DialogKt.f29lambda$341175415, gapComposer2, 805306368, 510);
                    boolean zChangedInstance4 = gapComposer2.changedInstance(list3) | gapComposer2.changed(state) | gapComposer2.changed(mutableState2);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue6 == obj4) {
                        snapshotStateList = snapshotStateList2;
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73((Object) snapshotStateList, (Object) list3, (Object) state, mutableState3, mutableState4, mutableState2, (byte) 6);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                        objRememberedValue6 = songMenuKt$$ExternalSyntheticLambda73;
                    } else {
                        snapshotStateList = snapshotStateList2;
                    }
                    CardKt.FilledTonalButton((Function0) objRememberedValue6, null, !snapshotStateList.isEmpty(), null, null, null, null, DialogKt.f27lambda$2107686734, gapComposer2, 805306368, 506);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                MusicDatabase musicDatabase = (MusicDatabase) obj8;
                MutableState mutableState5 = (MutableState) obj9;
                List list4 = (List) obj10;
                DownloadUtil downloadUtil = (DownloadUtil) obj7;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj6;
                MutableState mutableState6 = (MutableState) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.startReplaceGroup(371063982);
                    ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(1190932561, new SongMenuKt$$ExternalSyntheticLambda37(mutableState5, (byte) 18), gapComposer3);
                    ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f148lambda$1869970448;
                    boolean zChangedInstance5 = gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(mutableState5) | gapComposer3.changedInstance(list4);
                    Object objRememberedValue7 = gapComposer3.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue7 == obj4) {
                        objRememberedValue7 = new GapComposer$$ExternalSyntheticLambda0(musicDatabase, list4, mutableState5, (byte) 20);
                        gapComposer3.updateRememberedValue(objRememberedValue7);
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda3, composableLambdaImpl5, null, (Function0) objRememberedValue7, null, null, 52));
                    int intValue = parcelableSnapshotMutableIntState.getIntValue();
                    if (intValue == 0 || intValue == 2) {
                        gapComposer3.startReplaceGroup(1346906001);
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f89lambda$1395002617;
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1189292198;
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (objRememberedValue8 == obj4) {
                            objRememberedValue8 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState6, (byte) 24);
                            gapComposer3.updateRememberedValue(objRememberedValue8);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl6, composableLambdaImpl7, null, (Function0) objRememberedValue8, null, null, 52);
                        z = false;
                        gapComposer3.end(false);
                    } else {
                        if (intValue != 3) {
                            gapComposer3.startReplaceGroup(1347706328);
                            ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f137lambda$1819218585;
                            ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f132lambda$1768174970;
                            boolean zChangedInstance6 = gapComposer3.changedInstance(list4) | gapComposer3.changedInstance(downloadUtil);
                            Object objRememberedValue9 = gapComposer3.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue9 == obj4) {
                                z2 = false;
                                objRememberedValue9 = new SelectionSongsMenuKt$$ExternalSyntheticLambda39(list4, downloadUtil, (byte) 0);
                                gapComposer3.updateRememberedValue(objRememberedValue9);
                            } else {
                                z2 = false;
                            }
                            material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl8, composableLambdaImpl9, null, (Function0) objRememberedValue9, null, null, 52);
                            gapComposer3.end(z2);
                            r5 = z2;
                        } else {
                            gapComposer3.startReplaceGroup(1345487038);
                            CardColors cardColorsM267cardColorsro_MJ88 = CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, 0L, gapComposer3, 14);
                            ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$1254125072;
                            ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f69lambda$1232568465;
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            if (objRememberedValue10 == obj4) {
                                objRememberedValue10 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState6, (byte) 23);
                                gapComposer3.updateRememberedValue(objRememberedValue10);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, null, (Function0) objRememberedValue10, cardColorsM267cardColorsro_MJ88, null, 36);
                            z = false;
                            gapComposer3.end(false);
                        }
                        listBuilderCreateListBuilder2.add(material3MenuItemData2);
                        ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                        gapComposer3.end(r5);
                        MenuKt.Material3MenuGroup(listBuilderBuild2, gapComposer3, r5);
                    }
                    material3MenuItemData2 = material3MenuItemData;
                    r5 = z;
                    listBuilderCreateListBuilder2.add(material3MenuItemData2);
                    ListBuilder listBuilderBuild3 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                    gapComposer3.end(r5);
                    MenuKt.Material3MenuGroup(listBuilderBuild3, gapComposer3, r5);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                PlaylistItem playlistItem = (PlaylistItem) obj8;
                List list5 = (List) obj10;
                State state2 = (State) obj7;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj6;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                Context context = (Context) obj9;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else if (Intrinsics.areEqual(playlistItem.id, "LM") || playlistItem.isEditable) {
                    gapComposer4.startReplaceGroup(285891540);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(281074047);
                    boolean zChanged3 = gapComposer4.changed(state2) | gapComposer4.changedInstance(musicDatabase2) | gapComposer4.changedInstance(playlistItem) | gapComposer4.changedInstance(coroutineScope) | gapComposer4.changedInstance(list5) | gapComposer4.changedInstance(context);
                    Object objRememberedValue11 = gapComposer4.rememberedValue();
                    if (zChanged3 || objRememberedValue11 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda74 = new SongMenuKt$$ExternalSyntheticLambda73(musicDatabase2, coroutineScope, state2, playlistItem, list5, context);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda74);
                        objRememberedValue11 = songMenuKt$$ExternalSyntheticLambda74;
                    }
                    CardKt.IconButton((Function0) objRememberedValue11, null, false, null, null, Expect_jvmKt.rememberComposableLambda(458389415, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 23), gapComposer4), gapComposer4, 1572864, 62);
                    gapComposer4.end(false);
                }
                return unit;
            case 4:
                ChartsPage.ChartSection chartSection = (ChartsPage.ChartSection) obj10;
                State state3 = (State) obj8;
                State state4 = (State) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                MenuState menuState = (MenuState) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj9;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((GapComposer) composer5).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    OffsetKt.BoxWithConstraints(SizeKt.fillMaxWidth(companion, 1.0f), null, Expect_jvmKt.rememberComposableLambda(-2024645258, new SongMenuKt$$ExternalSyntheticLambda8(lazyItemScopeImpl, chartSection, state3, state4, hapticFeedback, menuState, playerConnection), gapComposer5), gapComposer5, 3078, 6);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                List listListOf = (List) obj10;
                List list6 = (List) obj8;
                List list7 = (List) obj7;
                final StatsViewModel statsViewModel = (StatsViewModel) obj6;
                State state5 = (State) obj5;
                State state6 = (State) obj9;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    int iOrdinal = ((OptionStats) state5.getValue()).ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            gapComposer6.startReplaceGroup(777973769);
                            gapComposer6.end(false);
                            list = list6;
                        } else if (iOrdinal == 2) {
                            gapComposer6.startReplaceGroup(778099722);
                            gapComposer6.end(false);
                            list = list7;
                        } else {
                            if (iOrdinal != 3) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer6, 1133470433, false);
                            }
                            gapComposer6.startReplaceGroup(778284389);
                            listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(0, MathKt.pluralStringResource(R.plurals.n_week, 1, new Object[]{1}, gapComposer6)), new Pair(1, MathKt.pluralStringResource(R.plurals.n_month, 1, new Object[]{1}, gapComposer6)), new Pair(2, MathKt.pluralStringResource(R.plurals.n_month, 3, new Object[]{3}, gapComposer6)), new Pair(3, MathKt.pluralStringResource(R.plurals.n_month, 6, new Object[]{6}, gapComposer6)), new Pair(4, MathKt.pluralStringResource(R.plurals.n_year, 1, new Object[]{1}, gapComposer6)), new Pair(5, MathKt.stringResource(R.string.filter_all, gapComposer6))});
                            gapComposer6.end(false);
                        }
                        List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(OptionStats.CONTINUOUS, MathKt.stringResource(R.string.continuous, gapComposer6)), new Pair(OptionStats.WEEKS, MathKt.stringResource(R.string.weeks, gapComposer6)), new Pair(OptionStats.MONTHS, MathKt.stringResource(R.string.months, gapComposer6)), new Pair(OptionStats.YEARS, MathKt.stringResource(R.string.years, gapComposer6))});
                        OptionStats optionStats = (OptionStats) state5.getValue();
                        zChangedInstance = gapComposer6.changedInstance(statsViewModel);
                        objRememberedValue = gapComposer6.rememberedValue();
                        if (zChangedInstance || objRememberedValue == obj4) {
                            final byte b2 = 0;
                            objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj11) {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    StatsViewModel statsViewModel2 = statsViewModel;
                                    switch (b3) {
                                        case 0:
                                            OptionStats optionStats2 = (OptionStats) obj11;
                                            optionStats2.getClass();
                                            StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                            stateFlowImpl.getClass();
                                            stateFlowImpl.updateState(null, optionStats2);
                                            StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                            stateFlowImpl2.getClass();
                                            stateFlowImpl2.updateState(null, 0);
                                            break;
                                        default:
                                            Integer num = (Integer) obj11;
                                            num.getClass();
                                            StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                            stateFlowImpl3.getClass();
                                            stateFlowImpl3.updateState(null, num);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer6.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        Integer numValueOf = Integer.valueOf(((Number) state6.getValue()).intValue());
                        zChangedInstance2 = gapComposer6.changedInstance(statsViewModel);
                        objRememberedValue2 = gapComposer6.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == obj4) {
                            final byte b3 = 1;
                            objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj11) {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    StatsViewModel statsViewModel2 = statsViewModel;
                                    switch (b4) {
                                        case 0:
                                            OptionStats optionStats2 = (OptionStats) obj11;
                                            optionStats2.getClass();
                                            StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                            stateFlowImpl.getClass();
                                            stateFlowImpl.updateState(null, optionStats2);
                                            StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                            stateFlowImpl2.getClass();
                                            stateFlowImpl2.updateState(null, 0);
                                            break;
                                        default:
                                            Integer num = (Integer) obj11;
                                            num.getClass();
                                            StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                            stateFlowImpl3.getClass();
                                            stateFlowImpl3.updateState(null, num);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer6.updateRememberedValue(objRememberedValue2);
                        }
                        DialogKt.m1462ChoiceChipsRow88mDfTA(list, listListOf2, optionStats, function1, numValueOf, (Function1) objRememberedValue2, null, 0L, gapComposer6, 0);
                    } else {
                        gapComposer6.startReplaceGroup(777847754);
                        gapComposer6.end(false);
                    }
                    list = listListOf;
                    List listListOf3 = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(OptionStats.CONTINUOUS, MathKt.stringResource(R.string.continuous, gapComposer6)), new Pair(OptionStats.WEEKS, MathKt.stringResource(R.string.weeks, gapComposer6)), new Pair(OptionStats.MONTHS, MathKt.stringResource(R.string.months, gapComposer6)), new Pair(OptionStats.YEARS, MathKt.stringResource(R.string.years, gapComposer6))});
                    OptionStats optionStats2 = (OptionStats) state5.getValue();
                    zChangedInstance = gapComposer6.changedInstance(statsViewModel);
                    objRememberedValue = gapComposer6.rememberedValue();
                    if (zChangedInstance) {
                        final byte b4 = 0;
                        objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj11) {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                StatsViewModel statsViewModel2 = statsViewModel;
                                switch (b5) {
                                    case 0:
                                        OptionStats optionStats3 = (OptionStats) obj11;
                                        optionStats3.getClass();
                                        StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, optionStats3);
                                        StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                        stateFlowImpl2.getClass();
                                        stateFlowImpl2.updateState(null, 0);
                                        break;
                                    default:
                                        Integer num = (Integer) obj11;
                                        num.getClass();
                                        StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, num);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer6.updateRememberedValue(objRememberedValue);
                    } else {
                        final byte b5 = 0;
                        objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj11) {
                                byte b6 = b5;
                                Unit unit2 = Unit.INSTANCE;
                                StatsViewModel statsViewModel2 = statsViewModel;
                                switch (b6) {
                                    case 0:
                                        OptionStats optionStats3 = (OptionStats) obj11;
                                        optionStats3.getClass();
                                        StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, optionStats3);
                                        StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                        stateFlowImpl2.getClass();
                                        stateFlowImpl2.updateState(null, 0);
                                        break;
                                    default:
                                        Integer num = (Integer) obj11;
                                        num.getClass();
                                        StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, num);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer6.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function2 = (Function1) objRememberedValue;
                    Integer numValueOf2 = Integer.valueOf(((Number) state6.getValue()).intValue());
                    zChangedInstance2 = gapComposer6.changedInstance(statsViewModel);
                    objRememberedValue2 = gapComposer6.rememberedValue();
                    if (zChangedInstance2) {
                        final byte b6 = 1;
                        objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj11) {
                                byte b7 = b6;
                                Unit unit2 = Unit.INSTANCE;
                                StatsViewModel statsViewModel2 = statsViewModel;
                                switch (b7) {
                                    case 0:
                                        OptionStats optionStats3 = (OptionStats) obj11;
                                        optionStats3.getClass();
                                        StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, optionStats3);
                                        StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                        stateFlowImpl2.getClass();
                                        stateFlowImpl2.updateState(null, 0);
                                        break;
                                    default:
                                        Integer num = (Integer) obj11;
                                        num.getClass();
                                        StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, num);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer6.updateRememberedValue(objRememberedValue2);
                    } else {
                        final byte b7 = 1;
                        objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj11) {
                                byte b8 = b7;
                                Unit unit2 = Unit.INSTANCE;
                                StatsViewModel statsViewModel2 = statsViewModel;
                                switch (b8) {
                                    case 0:
                                        OptionStats optionStats3 = (OptionStats) obj11;
                                        optionStats3.getClass();
                                        StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, optionStats3);
                                        StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                                        stateFlowImpl2.getClass();
                                        stateFlowImpl2.updateState(null, 0);
                                        break;
                                    default:
                                        Integer num = (Integer) obj11;
                                        num.getClass();
                                        StateFlowImpl stateFlowImpl3 = statsViewModel2.indexChips;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, num);
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer6.updateRememberedValue(objRememberedValue2);
                    }
                    DialogKt.m1462ChoiceChipsRow88mDfTA(list, listListOf3, optionStats2, function2, numValueOf2, (Function1) objRememberedValue2, null, 0L, gapComposer6, 0);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                State state7 = (State) obj10;
                State state8 = (State) obj8;
                State state9 = (State) obj6;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj5;
                MenuState menuState2 = (MenuState) obj9;
                NavHostController navHostController2 = (NavHostController) obj7;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    String str = ((List) state7.getValue()).size() + ServerSentEventKt.SPACE + MathKt.stringResource(R.string.albums, gapComposer7);
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    MenuKt.NavigationTitle(str, companion2, null, null, null, null, gapComposer7, 48, 60);
                    if (((List) state7.getValue()).isEmpty()) {
                        gapComposer7.startReplaceGroup(-1754837751);
                        gapComposer7.end(false);
                    } else {
                        gapComposer7.startReplaceGroup(-1757210460);
                        boolean zChanged4 = gapComposer7.changed(state7) | gapComposer7.changed(state8) | gapComposer7.changed(state9) | gapComposer7.changedInstance(hapticFeedback2) | gapComposer7.changed(menuState2) | gapComposer7.changedInstance(navHostController2);
                        Object objRememberedValue12 = gapComposer7.rememberedValue();
                        if (zChanged4 || objRememberedValue12 == obj4) {
                            SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(state7, hapticFeedback2, menuState2, navHostController2, state8, state9, (byte) 4);
                            gapComposer7.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda20);
                            objRememberedValue12 = songMenuKt$$ExternalSyntheticLambda20;
                        }
                        IntMath.LazyRow(companion2, null, null, null, null, null, false, null, (Function1) objRememberedValue12, gapComposer7, 6, 510);
                        gapComposer7.end(false);
                    }
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                SavedEQProfile savedEQProfile = (SavedEQProfile) obj8;
                String str2 = (String) obj7;
                Function1 function3 = (Function1) obj6;
                List list8 = (List) obj10;
                Function1 function4 = (Function1) obj9;
                Function0 function5 = (Function0) obj5;
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue8 & 6) == 0) {
                    iIntValue8 |= ((GapComposer) composer8).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.fillMaxWidth(companion, 1.0f), paddingValues);
                    PaddingValuesImpl paddingValuesImplM128PaddingValuesa9UjIt4$default = OffsetKt.m128PaddingValuesa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues((WindowInsets) gapComposer8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer8).mo122calculateBottomPaddingD9Ej5fM(), 7);
                    boolean zChangedInstance7 = gapComposer8.changedInstance(savedEQProfile) | gapComposer8.changed(str2) | gapComposer8.changed(function3) | gapComposer8.changedInstance(list8) | gapComposer8.changed(function4) | gapComposer8.changed(function5);
                    Object objRememberedValue13 = gapComposer8.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue13 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda21 = new SongMenuKt$$ExternalSyntheticLambda20(savedEQProfile, str2, list8, function5, function3, function4);
                        gapComposer8.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda21);
                        objRememberedValue13 = songMenuKt$$ExternalSyntheticLambda21;
                    }
                    IntMath.LazyColumn(modifierPadding, null, paddingValuesImplM128PaddingValuesa9UjIt4$default, null, null, null, false, null, (Function1) objRememberedValue13, gapComposer8, 0, 506);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                WizardState wizardState = (WizardState) obj10;
                Function0 function6 = (Function0) obj5;
                Function1 function7 = (Function1) obj8;
                Function1 function8 = (Function1) obj7;
                Function1 function9 = (Function1) obj6;
                Function0 function10 = (Function0) obj9;
                PaddingValues paddingValues2 = (PaddingValues) obj;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                paddingValues2.getClass();
                if ((iIntValue9 & 6) == 0) {
                    iIntValue9 |= ((GapComposer) composer9).changed(paddingValues2) ? 4 : 2;
                }
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 19) != 18)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    Modifier modifierPadding2 = OffsetKt.padding(fillElement, paddingValues2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode2 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierPadding2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf3 = Integer.valueOf(iHashCode2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer9, numValueOf3, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer9);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer9, 0);
                    int iHashCode3 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer9, fillElement);
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer9, 0, 7);
                    WizardStep wizardStep = wizardState.currentStep;
                    Object objRememberedValue14 = gapComposer9.rememberedValue();
                    if (objRememberedValue14 == obj4) {
                        objRememberedValue14 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 16);
                        gapComposer9.updateRememberedValue(objRememberedValue14);
                    }
                    CrossfadeKt.AnimatedContent(wizardStep, null, (Function1) objRememberedValue14, null, "wizard_step", null, Expect_jvmKt.rememberComposableLambda(827096050, new RecognitionScreenKt$$ExternalSyntheticLambda6(wizardState, function6, function7, function8, function9, function10, (byte) 1), gapComposer9), gapComposer9, 1597824, 42);
                    gapComposer9.end(true);
                    if (wizardState.error != null) {
                        gapComposer9.startReplaceGroup(1765626894);
                        ScrimKt.m321SnackbareQBnUkQ(OffsetKt.m135padding3ABfNKs(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.BottomCenter), 16.0f), null, null, null, 0L, 0L, 0L, 0L, Expect_jvmKt.rememberComposableLambda(-502511070, new WizardScreenKt$$ExternalSyntheticLambda12(wizardState, (byte) 0), gapComposer9), gapComposer9, 805306368, 510);
                        gapComposer9.end(false);
                    } else {
                        gapComposer9.startReplaceGroup(1765869066);
                        gapComposer9.end(false);
                    }
                    gapComposer9.end(true);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                SnapshotStateList snapshotStateList3 = (SnapshotStateList) obj10;
                MutableState mutableState7 = (MutableState) obj9;
                MenuState menuState3 = (MenuState) obj8;
                MutableState mutableState8 = (MutableState) obj7;
                MutableState mutableState9 = (MutableState) obj6;
                Function0 function11 = (Function0) obj5;
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else if (LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState9)) {
                    gapComposer10.startReplaceGroup(1173253438);
                    boolean z3 = snapshotStateList3.size() == ((List) mutableState7.getValue()).size() && !snapshotStateList3.isEmpty();
                    boolean zChanged5 = gapComposer10.changed(mutableState7);
                    Object objRememberedValue15 = gapComposer10.rememberedValue();
                    if (zChanged5 || objRememberedValue15 == obj4) {
                        objRememberedValue15 = new SongMenuKt$$ExternalSyntheticLambda4((Object) snapshotStateList3, (Object) mutableState7, (byte) 18);
                        gapComposer10.updateRememberedValue(objRememberedValue15);
                    }
                    CardKt.Checkbox(z3, (Function1) objRememberedValue15, null, false, null, gapComposer10, 0);
                    boolean z4 = !snapshotStateList3.isEmpty();
                    boolean zChanged6 = gapComposer10.changed(menuState3) | gapComposer10.changed(mutableState7);
                    Object objRememberedValue16 = gapComposer10.rememberedValue();
                    if (zChanged6 || objRememberedValue16 == obj4) {
                        AlarmSettingsKt$$ExternalSyntheticLambda30 alarmSettingsKt$$ExternalSyntheticLambda30 = new AlarmSettingsKt$$ExternalSyntheticLambda30(menuState3, snapshotStateList3, function11, mutableState7, (byte) 1);
                        gapComposer10.updateRememberedValue(alarmSettingsKt$$ExternalSyntheticLambda30);
                        objRememberedValue16 = alarmSettingsKt$$ExternalSyntheticLambda30;
                    }
                    CardKt.IconButton((Function0) objRememberedValue16, null, z4, null, null, TopPlaylistScreenKt.lambda$1647676290, gapComposer10, 1572864, 58);
                    gapComposer10.end(false);
                } else if (((Boolean) mutableState8.getValue()).booleanValue()) {
                    gapComposer10.startReplaceGroup(1175332825);
                    gapComposer10.end(false);
                } else {
                    gapComposer10.startReplaceGroup(1174945542);
                    boolean zChanged7 = gapComposer10.changed(mutableState8);
                    Object objRememberedValue17 = gapComposer10.rememberedValue();
                    if (zChanged7 || objRememberedValue17 == obj4) {
                        objRememberedValue17 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState8, (byte) 10);
                        gapComposer10.updateRememberedValue(objRememberedValue17);
                    }
                    CardKt.IconButton((Function0) objRememberedValue17, null, false, null, null, TopPlaylistScreenKt.lambda$7910507, gapComposer10, 1572864, 62);
                    gapComposer10.end(false);
                }
                return unit;
            case 10:
                return invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda8(obj, obj2, obj3);
            case 11:
                return invoke$com$metrolist$music$ui$screens$settings$BackupAndRestoreKt$$ExternalSyntheticLambda17(obj, obj2, obj3);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$ui$screens$settings$integrations$ListenTogetherSettingsKt$$ExternalSyntheticLambda13(obj, obj2, obj3);
            default:
                List list9 = (List) obj10;
                MutableState mutableState10 = (MutableState) obj9;
                String str3 = (String) obj8;
                Function1 function12 = (Function1) obj7;
                String str4 = (String) obj6;
                Function1 function13 = (Function1) obj5;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer11), true);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer11, 6);
                    int iHashCode4 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier4, ComposeUiNode.Companion.SetModifier);
                    gapComposer11.startReplaceGroup(-125827122);
                    Iterator it = list9.iterator();
                    while (it.hasNext()) {
                        ListenTogetherServer listenTogetherServer = (ListenTogetherServer) it.next();
                        boolean zAreEqual = Intrinsics.areEqual(listenTogetherServer.url, str4);
                        if (UiStyleKt.isGlassStyle(gapComposer11)) {
                            gapComposer11.startReplaceGroup(888264045);
                            gapComposer11.end(false);
                            jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
                        } else {
                            gapComposer11.startReplaceGroup(888266536);
                            jColor = ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                            gapComposer11.end(false);
                        }
                        BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        boolean zChanged8 = gapComposer11.changed(function13) | gapComposer11.changedInstance(listenTogetherServer);
                        Object objRememberedValue18 = gapComposer11.rememberedValue();
                        if (zChanged8 || objRememberedValue18 == obj4) {
                            objRememberedValue18 = new QueueKt$$ExternalSyntheticLambda16(function13, listenTogetherServer, (byte) 29);
                            gapComposer11.updateRememberedValue(objRememberedValue18);
                        }
                        Iterator it2 = it;
                        String str5 = str4;
                        Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue18, 15);
                        RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh8 = GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 16.0f, gapComposer11);
                        if (zAreEqual) {
                            gapComposer11.startReplaceGroup(1766903382);
                            j = ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer;
                            gapComposer11.end(false);
                        } else {
                            gapComposer11.startReplaceGroup(1767022360);
                            j = ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant;
                            gapComposer11.end(false);
                        }
                        CardKt.Card(modifierM46clickableoSLSa3U$default, roundedCornerShapeM1480glassShapeixp7dh8, CardKt.m267cardColorsro_MJ88(j, 0L, gapComposer11, 14), null, borderStrokeM38BorderStrokecXLIe8U, Expect_jvmKt.rememberComposableLambda(623846728, new SliderKt$$ExternalSyntheticLambda1(zAreEqual, (Object) listenTogetherServer, (byte) 5), gapComposer11), gapComposer11, 196608, 8);
                        it = it2;
                        str4 = str5;
                    }
                    gapComposer11.end(false);
                    CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer11, 0, 7);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_custom_server, gapComposer11), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).typography.titleSmall, gapComposer11, 1572864, 0, 131006);
                    String str6 = (String) mutableState10.getValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged9 = gapComposer11.changed(mutableState10);
                    Object objRememberedValue19 = gapComposer11.rememberedValue();
                    if (zChanged9 || objRememberedValue19 == obj4) {
                        objRememberedValue19 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState10, (byte) 6);
                        gapComposer11.updateRememberedValue(objRememberedValue19);
                    }
                    ScrimKt.OutlinedTextField(str6, (Function1) objRememberedValue19, modifierFillMaxWidth2, false, false, null, LastFMSettingsKt.f595lambda$1109082863, null, LastFMSettingsKt.lambda$904279631, null, null, null, null, null, true, 0, 0, null, null, gapComposer11, 102236544, 12582912, 8257208);
                    boolean z5 = !StringsKt.isBlank(str3);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    boolean zChanged10 = gapComposer11.changed(function12) | gapComposer11.changed(str3);
                    Object objRememberedValue20 = gapComposer11.rememberedValue();
                    if (zChanged10 || objRememberedValue20 == obj4) {
                        objRememberedValue20 = new PlaylistScreenMenusKt$$ExternalSyntheticLambda3((byte) 2, str3, function12);
                        gapComposer11.updateRememberedValue(objRememberedValue20);
                    }
                    CardKt.Button((Function0) objRememberedValue20, modifierFillMaxWidth3, z5, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, null, null, null, LastFMSettingsKt.lambda$752192487, gapComposer11, 805306416, 496);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(State state, State state2, State state3, HapticFeedback hapticFeedback, MenuState menuState, NavHostController navHostController) {
        this.$r8$classId = (byte) 6;
        this.f$0 = state;
        this.f$1 = state2;
        this.f$3 = state3;
        this.f$4 = hapticFeedback;
        this.f$5 = menuState;
        this.f$2 = navHostController;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(MutableState mutableState, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$5 = mutableState;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(PlaylistItem playlistItem, List list, MutableState mutableState, MusicDatabase musicDatabase, CoroutineScope coroutineScope, Context context) {
        this.$r8$classId = (byte) 3;
        this.f$1 = playlistItem;
        this.f$0 = list;
        this.f$2 = mutableState;
        this.f$3 = musicDatabase;
        this.f$4 = coroutineScope;
        this.f$5 = context;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(MusicDatabase musicDatabase, MutableState mutableState, List list, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState2) {
        this.$r8$classId = (byte) 2;
        this.f$1 = musicDatabase;
        this.f$5 = mutableState;
        this.f$0 = list;
        this.f$2 = downloadUtil;
        this.f$3 = parcelableSnapshotMutableIntState;
        this.f$4 = mutableState2;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(SavedEQProfile savedEQProfile, String str, List list, Function0 function0, Function1 function1, Function1 function2) {
        this.$r8$classId = (byte) 7;
        this.f$1 = savedEQProfile;
        this.f$2 = str;
        this.f$3 = function1;
        this.f$0 = list;
        this.f$5 = function2;
        this.f$4 = function0;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(WizardState wizardState, Function0 function0, Function1 function1, Function1 function2, Function1 function3, Function0 function4) {
        this.$r8$classId = (byte) 8;
        this.f$0 = wizardState;
        this.f$4 = function0;
        this.f$1 = function1;
        this.f$2 = function2;
        this.f$3 = function3;
        this.f$5 = function4;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = obj6;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda12(List list, MutableState mutableState, Object obj, Object obj2, Object obj3, Function function, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$5 = mutableState;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$4 = function;
    }
}
