package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavHostController;
import androidx.room.RoomDatabase$closeBarrier$1;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import com.metrolist.music.ui.screens.playlist.PlaylistType;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.settings.integrations.DiscordSettingsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import com.metrolist.music.viewmodels.StatsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda9 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(MutableState mutableState, MutableState mutableState2, NavHostController navHostController, MusicDatabase musicDatabase, LocalPlaylistViewModel localPlaylistViewModel) {
        this.$r8$classId = (byte) 12;
        this.f$0 = localPlaylistViewModel;
        this.f$1 = musicDatabase;
        this.f$3 = mutableState;
        this.f$2 = navHostController;
        this.f$4 = mutableState2;
    }

    /* JADX WARN: Code duplicated, block: B:247:0x0a2e  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        MutableState mutableState;
        MutableState mutableState2;
        boolean z;
        MutableState mutableState3;
        byte b = this.$r8$classId;
        byte b2 = 27;
        byte b3 = 18;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$4;
        Object obj5 = this.f$2;
        Object obj6 = this.f$1;
        Object obj7 = this.f$0;
        Object obj8 = this.f$3;
        byte b4 = 16;
        boolean z2 = false;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj7;
                PlayerConnection playerConnection = (PlayerConnection) obj6;
                MediaMetadata mediaMetadata = (MediaMetadata) obj5;
                MutableState mutableState4 = (MutableState) obj8;
                Context context = (Context) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    MenuKt.NewActionGrid(CollectionsKt__IterablesKt.listOf((Object[]) new NewAction[]{new NewAction(AlbumMenuKt.lambda$1560074022, MathKt.stringResource(R.string.start_radio, gapComposer), Expect_jvmKt.rememberComposableLambda(-450198104, new MainActivity$$ExternalSyntheticLambda9(function0, playerConnection, mediaMetadata, b2), gapComposer)), new NewAction(AlbumMenuKt.f104lambda$1509227481, MathKt.stringResource(R.string.add_to_playlist, gapComposer), Expect_jvmKt.rememberComposableLambda(775467689, new SongMenuKt$$ExternalSyntheticLambda37(mutableState4, b4), gapComposer)), new NewAction(AlbumMenuKt.f183lambda$283561688, MathKt.stringResource(R.string.share, gapComposer), Expect_jvmKt.rememberComposableLambda(2001133482, new QueueMenuKt$$ExternalSyntheticLambda18(function0, context, mediaMetadata), gapComposer))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), 0, gapComposer, 48, 4);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Function3 function3 = (Function3) obj7;
                String str = (String) obj6;
                Song song = (Song) obj5;
                Map map = (Map) obj8;
                Integer num = (Integer) obj4;
                Object obj9 = (RowScope) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                obj9.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(obj9) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    function3.invoke(obj9, gapComposer2, Integer.valueOf(iIntValue2 & 14));
                    if (str == null) {
                        gapComposer2.startReplaceGroup(58810579);
                        List orderedArtists = song.getOrderedArtists();
                        String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer2), ServerSentEventKt.SPACE);
                        boolean zChangedInstance = gapComposer2.changedInstance(map);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 6);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        String strJoinByBullet = UtilsKt.joinByBullet(UtilsKt.joinToArtistString(orderedArtists, strM, (Function1) objRememberedValue), num == null ? UtilsKt.makeTimeString(Long.valueOf(((long) song.song.duration) * 1000)) : null);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m352TextNvy7gAk(strJoinByBullet, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 24960, 110586);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(59540908);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer2, 0, 24960, 110586);
                        gapComposer2.end(false);
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                MutableState mutableState5 = (MutableState) obj8;
                List list = (List) obj7;
                MutableState mutableState6 = (MutableState) obj6;
                MutableState mutableState7 = (MutableState) obj5;
                MutableState mutableState8 = (MutableState) obj4;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    CrossfadeKt.AnimatedVisibility(Intrinsics.areEqual((String) mutableState5.getValue(), "custom"), null, EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(-2043017593, new StatsScreenKt$$ExternalSyntheticLambda20(list, mutableState6, mutableState7, mutableState8, (byte) 1), gapComposer3), gapComposer3, 200064, 18);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 3:
                MutableState mutableState9 = (MutableState) obj8;
                MutableState mutableState10 = (MutableState) obj6;
                StatsViewModel statsViewModel = (StatsViewModel) obj5;
                Function0 function1 = (Function0) obj7;
                State state = (State) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.time_transfer_warning, gapComposer4), SizeKt.fillMaxWidth(companion, 1.0f), -281474976710656L, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, null, gapComposer4, 432, 0, 261112);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    boolean z3 = gapComposer4.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z3) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer4);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    MenuKt.SongSelectDropdown(MathKt.stringResource(R.string.time_transfer_source_song, gapComposer4), (List) state.getValue(), mutableState9, gapComposer4, 384);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    BiasAlignment.Vertical vertical = Alignment.Companion.Top;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer4, 0);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.time_transfer_listen_time_label, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                    if (mutableState9.getValue() != null) {
                        gapComposer4.startReplaceGroup(-516520216);
                        Object value = mutableState9.getValue();
                        value.getClass();
                        TextKt.m352TextNvy7gAk(MenuKt.formatMillis(((SongWithStats) value).timeListened), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262078);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-516280927);
                        gapComposer4.end(false);
                    }
                    gapComposer4.end(true);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    MenuKt.SongSelectDropdown(MathKt.stringResource(R.string.time_transfer_target_song, gapComposer4), (List) state.getValue(), mutableState10, gapComposer4, 384);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer4, 0);
                    int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.time_transfer_listen_time_label, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                    if (mutableState10.getValue() != null) {
                        gapComposer4.startReplaceGroup(-1783110127);
                        Object value2 = mutableState10.getValue();
                        value2.getClass();
                        TextKt.m352TextNvy7gAk(MenuKt.formatMillis(((SongWithStats) value2).timeListened), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262078);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-1782870838);
                        gapComposer4.end(false);
                    }
                    gapComposer4.end(true);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    boolean zChangedInstance2 = gapComposer4.changedInstance(statsViewModel) | gapComposer4.changed(function1);
                    Object objRememberedValue2 = gapComposer4.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        mutableState = mutableState10;
                        mutableState2 = mutableState9;
                        objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda63((Object) mutableState2, (Object) mutableState, (Object) statsViewModel, (Object) function1, (byte) 7);
                        gapComposer4.updateRememberedValue(objRememberedValue2);
                    } else {
                        mutableState = mutableState10;
                        mutableState2 = mutableState9;
                    }
                    Function0 function2 = (Function0) objRememberedValue2;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    if (mutableState2.getValue() == null || mutableState.getValue() == null) {
                        z = false;
                    } else {
                        Object value3 = mutableState2.getValue();
                        value3.getClass();
                        String str2 = ((SongWithStats) value3).id;
                        Object value4 = mutableState.getValue();
                        value4.getClass();
                        if (Intrinsics.areEqual(str2, ((SongWithStats) value4).id)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    CardKt.Button(function2, modifierFillMaxWidth, z, null, null, null, null, null, null, DialogKt.f13lambda$1243164339, gapComposer4, 805306416, 504);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 4:
                MutableState mutableState11 = (MutableState) obj8;
                MutableState mutableState12 = (MutableState) obj7;
                MutableState mutableState13 = (MutableState) obj6;
                String str3 = (String) obj5;
                MutableState mutableState14 = (MutableState) obj4;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    long j = ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant;
                    SurfaceKt.m337SurfaceT9BRK9s(modifierM137paddingVpY3zN4$default, roundedCornerShapeM185RoundedCornerShape0680j_4, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.5f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(2026755894, new PlayerKt$$ExternalSyntheticLambda92(mutableState11, mutableState12, mutableState13, str3, mutableState14), gapComposer5), gapComposer5, 12582918, 120);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            case 5:
                Function0 function4 = (Function0) obj7;
                MusicDatabase musicDatabase = (MusicDatabase) obj6;
                Playlist playlist = (Playlist) obj5;
                CoroutineScope coroutineScope = (CoroutineScope) obj4;
                MutableState mutableState15 = (MutableState) obj8;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    Object objRememberedValue3 = gapComposer6.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState15, (byte) 6);
                        gapComposer6.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.f276lambda$930842282, gapComposer6, 805306374, 510);
                    boolean zChanged = gapComposer6.changed(function4) | gapComposer6.changedInstance(musicDatabase) | gapComposer6.changed(playlist) | gapComposer6.changedInstance(coroutineScope);
                    Object objRememberedValue4 = gapComposer6.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(function4, musicDatabase, coroutineScope, mutableState15, playlist);
                        gapComposer6.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda40;
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AlbumMenuKt.f244lambda$658112435, gapComposer6, 805306368, 510);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
            case 6:
                Song song2 = (Song) obj7;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj6;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj5;
                Context context2 = (Context) obj4;
                SyncUtils syncUtils = (SyncUtils) obj8;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    SongEntity songEntity = song2.song;
                    boolean z4 = songEntity.isEpisode;
                    boolean z5 = z4 ? songEntity.inLibrary != null : songEntity.liked;
                    boolean zChanged2 = gapComposer7.changed(z4) | gapComposer7.changed(song2) | gapComposer7.changedInstance(musicDatabase2) | gapComposer7.changedInstance(coroutineScope2) | gapComposer7.changedInstance(context2) | gapComposer7.changedInstance(syncUtils);
                    Object objRememberedValue5 = gapComposer7.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda25 songMenuKt$$ExternalSyntheticLambda25 = new SongMenuKt$$ExternalSyntheticLambda25((byte) 0, song2, musicDatabase2, coroutineScope2, syncUtils, context2, z4);
                        gapComposer7.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda25);
                        objRememberedValue5 = songMenuKt$$ExternalSyntheticLambda25;
                    }
                    CardKt.IconButton((Function0) objRememberedValue5, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-1325575051, new SongMenuKt$$ExternalSyntheticLambda26(z2 ? (byte) 1 : (byte) 0, z5), gapComposer7), gapComposer7, 1572864, 62);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                break;
            case 7:
                List list2 = (List) obj6;
                NavHostController navHostController = (NavHostController) obj5;
                Function0 function5 = (Function0) obj7;
                MutableState mutableState16 = (MutableState) obj8;
                Map map2 = (Map) obj4;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f255lambda$745696561;
                    ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1649354256;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-250562223, new MainActivity$$ExternalSyntheticLambda1((Object) list2, (Object) map2, (byte) 19), gapComposer8);
                    boolean zChangedInstance3 = gapComposer8.changedInstance(list2) | gapComposer8.changedInstance(navHostController) | gapComposer8.changed(function5) | gapComposer8.changed(mutableState16);
                    Object objRememberedValue6 = gapComposer8.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy) {
                        YouTubeSongMenuKt$$ExternalSyntheticLambda28 youTubeSongMenuKt$$ExternalSyntheticLambda28 = new YouTubeSongMenuKt$$ExternalSyntheticLambda28(list2, navHostController, function5, mutableState16, (byte) 1);
                        gapComposer8.updateRememberedValue(youTubeSongMenuKt$$ExternalSyntheticLambda28);
                        objRememberedValue6 = youTubeSongMenuKt$$ExternalSyntheticLambda28;
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue6, null, null, 48)), gapComposer8, 0);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                break;
            case 8:
                State state2 = (State) obj7;
                State state3 = (State) obj6;
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj5;
                MenuState menuState = (MenuState) obj8;
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) obj4;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    boolean zChanged3 = gapComposer9.changed(state2);
                    Object objRememberedValue7 = gapComposer9.rememberedValue();
                    if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new MainActivity$$ExternalSyntheticLambda22(state2, (byte) 16);
                        gapComposer9.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function6 = (Function0) objRememberedValue7;
                    boolean zChanged4 = gapComposer9.changed(state3);
                    Object objRememberedValue8 = gapComposer9.rememberedValue();
                    if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new MainActivity$$ExternalSyntheticLambda22(state3, (byte) 17);
                        gapComposer9.updateRememberedValue(objRememberedValue8);
                    }
                    Function0 function7 = (Function0) objRememberedValue8;
                    boolean zChanged5 = gapComposer9.changed(mediaMetadata2);
                    Object objRememberedValue9 = gapComposer9.rememberedValue();
                    if (zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 12, mediaMetadata2);
                        gapComposer9.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function8 = (Function0) objRememberedValue9;
                    boolean zChanged6 = gapComposer9.changed(menuState);
                    Object objRememberedValue10 = gapComposer9.rememberedValue();
                    if (zChanged6 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new RoomDatabase$closeBarrier$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 18);
                        gapComposer9.updateRememberedValue(objRememberedValue10);
                    }
                    Function0 function9 = (Function0) ((KFunction) objRememberedValue10);
                    boolean zChanged7 = gapComposer9.changed(bottomSheetPageState) | gapComposer9.changed(state3);
                    Object objRememberedValue11 = gapComposer9.rememberedValue();
                    if (zChanged7 || objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(bottomSheetPageState, state3, (byte) 27);
                        gapComposer9.updateRememberedValue(objRememberedValue11);
                    }
                    AlbumMenuKt.LyricsMenu(function6, function7, function8, function9, (Function0) objRememberedValue11, null, gapComposer9, 0);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                break;
            case 9:
                List list3 = (List) obj6;
                List list4 = (List) obj5;
                MenuState menuState2 = (MenuState) obj4;
                Function0 function10 = (Function0) obj7;
                MutableState mutableState17 = (MutableState) obj8;
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else if (((Boolean) mutableState17.getValue()).booleanValue()) {
                    gapComposer10.startReplaceGroup(1034795461);
                    boolean z6 = list3.size() == list4.size() && !list3.isEmpty();
                    boolean zChangedInstance4 = gapComposer10.changedInstance(list3) | gapComposer10.changedInstance(list4);
                    Object objRememberedValue12 = gapComposer10.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new AlbumScreenKt$$ExternalSyntheticLambda13(list3, list4, (byte) 0);
                        gapComposer10.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.Checkbox(z6, (Function1) objRememberedValue12, null, false, null, gapComposer10, 0);
                    boolean z7 = !list3.isEmpty();
                    boolean zChanged8 = gapComposer10.changed(menuState2) | gapComposer10.changedInstance(list3) | gapComposer10.changedInstance(list4) | gapComposer10.changed(function10);
                    Object objRememberedValue13 = gapComposer10.rememberedValue();
                    if (zChanged8 || objRememberedValue13 == neverEqualPolicy) {
                        QueueKt$$ExternalSyntheticLambda34 queueKt$$ExternalSyntheticLambda34 = new QueueKt$$ExternalSyntheticLambda34((byte) 1, menuState2, list3, list4, function10);
                        gapComposer10.updateRememberedValue(queueKt$$ExternalSyntheticLambda34);
                        objRememberedValue13 = queueKt$$ExternalSyntheticLambda34;
                    }
                    CardKt.IconButton((Function0) objRememberedValue13, null, z7, null, null, AlbumScreenKt.lambda$903728686, gapComposer10, 1572864, 58);
                    gapComposer10.end(false);
                } else {
                    gapComposer10.startReplaceGroup(1036108187);
                    gapComposer10.end(false);
                }
                break;
            case 10:
                State state4 = (State) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                MenuState menuState3 = (MenuState) obj5;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj8;
                NavHostController navHostController2 = (NavHostController) obj4;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    String str4 = ((List) state4.getValue()).size() + ServerSentEventKt.SPACE + MathKt.stringResource(R.string.artists, gapComposer11);
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    MenuKt.NavigationTitle(str4, companion2, null, null, null, null, gapComposer11, 48, 60);
                    boolean zChanged9 = gapComposer11.changed(state4) | gapComposer11.changedInstance(hapticFeedback) | gapComposer11.changed(menuState3) | gapComposer11.changedInstance(coroutineScope3) | gapComposer11.changedInstance(navHostController2);
                    Object objRememberedValue14 = gapComposer11.rememberedValue();
                    if (zChanged9 || objRememberedValue14 == neverEqualPolicy) {
                        AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda40 = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) state4, (Object) hapticFeedback, (Object) menuState3, (Object) coroutineScope3, (Object) navHostController2, (byte) 13);
                        gapComposer11.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue14 = albumMenuKt$$ExternalSyntheticLambda40;
                    }
                    IntMath.LazyRow(companion2, null, null, null, null, null, false, null, (Function1) objRememberedValue14, gapComposer11, 6, 510);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                break;
            case 11:
                List list5 = (List) obj6;
                MenuState menuState4 = (MenuState) obj5;
                Function0 function11 = (Function0) obj7;
                PlaylistType playlistType = (PlaylistType) obj8;
                List list6 = (List) obj4;
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj10 : list5) {
                        if (list6.contains(((Song) obj10).song.id)) {
                            arrayList.add(obj10);
                        }
                    }
                    boolean zChanged10 = gapComposer12.changed(menuState4);
                    Object objRememberedValue15 = gapComposer12.rememberedValue();
                    if (zChanged10 || objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 11);
                        gapComposer12.updateRememberedValue(objRememberedValue15);
                    }
                    YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, (Function0) ((KFunction) objRememberedValue15), function11, null, playlistType == PlaylistType.UPLOADED, null, gapComposer12, 0, 40);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LocalPlaylistViewModel localPlaylistViewModel = (LocalPlaylistViewModel) obj7;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj6;
                MutableState mutableState18 = (MutableState) obj8;
                NavHostController navHostController3 = (NavHostController) obj5;
                MutableState mutableState19 = (MutableState) obj4;
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    Object objRememberedValue16 = gapComposer13.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState19, (byte) 11);
                        gapComposer13.updateRememberedValue(objRememberedValue16);
                    }
                    CardKt.TextButton((Function0) objRememberedValue16, null, false, null, null, null, TopPlaylistScreenKt.lambda$1472879669, gapComposer13, 805306374, 510);
                    boolean zChangedInstance5 = gapComposer13.changedInstance(musicDatabase3) | gapComposer13.changed(mutableState18) | gapComposer13.changedInstance(localPlaylistViewModel) | gapComposer13.changedInstance(navHostController3);
                    Object objRememberedValue17 = gapComposer13.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue17 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda41 = new SongMenuKt$$ExternalSyntheticLambda40(mutableState19, mutableState18, navHostController3, musicDatabase3, localPlaylistViewModel);
                        gapComposer13.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda41);
                        objRememberedValue17 = songMenuKt$$ExternalSyntheticLambda41;
                    }
                    CardKt.TextButton((Function0) objRememberedValue17, null, false, null, null, null, TopPlaylistScreenKt.lambda$1999436844, gapComposer13, 805306368, 510);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                break;
            case 13:
                PodcastItem podcastItem = (PodcastItem) obj7;
                OnlinePodcastViewModel onlinePodcastViewModel = (OnlinePodcastViewModel) obj6;
                NavHostController navHostController4 = (NavHostController) obj5;
                MutableState mutableState20 = (MutableState) obj8;
                State state5 = (State) obj4;
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    int size = ((List) mutableState20.getValue()).size();
                    PodcastEntity podcastEntity = (PodcastEntity) state5.getValue();
                    boolean z8 = (podcastEntity == null || podcastEntity.bookmarkedAt == null) ? false : true;
                    boolean zChangedInstance6 = gapComposer14.changedInstance(onlinePodcastViewModel);
                    Object objRememberedValue18 = gapComposer14.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue18 == neverEqualPolicy) {
                        objRememberedValue18 = new OnlinePodcastScreenKt$$ExternalSyntheticLambda16(onlinePodcastViewModel, z2 ? (byte) 1 : (byte) 0);
                        gapComposer14.updateRememberedValue(objRememberedValue18);
                    }
                    Function0 function12 = (Function0) objRememberedValue18;
                    boolean zChangedInstance7 = gapComposer14.changedInstance(podcastItem) | gapComposer14.changedInstance(navHostController4);
                    Object objRememberedValue19 = gapComposer14.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new QueueKt$$ExternalSyntheticLambda16(podcastItem, navHostController4, b3);
                        gapComposer14.updateRememberedValue(objRememberedValue19);
                    }
                    OnlinePodcastScreenKt.PodcastHeader(podcastItem, size, z8, function12, (Function0) objRememberedValue19, gapComposer14, 0);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                break;
            default:
                MutableState mutableState21 = (MutableState) obj8;
                MutableState mutableState22 = (MutableState) obj7;
                MutableState mutableState23 = (MutableState) obj6;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj5;
                Context context3 = (Context) obj4;
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    boolean zChanged11 = gapComposer15.changed(mutableState21);
                    Object objRememberedValue20 = gapComposer15.rememberedValue();
                    if (zChanged11 || objRememberedValue20 == neverEqualPolicy) {
                        objRememberedValue20 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState21, (byte) 26);
                        gapComposer15.updateRememberedValue(objRememberedValue20);
                    }
                    CardKt.TextButton((Function0) objRememberedValue20, null, false, null, null, null, LastFMSettingsKt.lambda$497131889, gapComposer15, 805306368, 510);
                    OffsetKt.Spacer(gapComposer15, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    boolean zChanged12 = gapComposer15.changed(mutableState22) | gapComposer15.changed(mutableState23) | gapComposer15.changedInstance(listenTogetherManager) | gapComposer15.changed(mutableState21) | gapComposer15.changedInstance(context3);
                    Object objRememberedValue21 = gapComposer15.rememberedValue();
                    if (zChanged12 || objRememberedValue21 == neverEqualPolicy) {
                        mutableState3 = mutableState22;
                        objRememberedValue21 = new SongMenuKt$$ExternalSyntheticLambda40((Object) listenTogetherManager, (Object) context3, (Object) mutableState3, (Object) mutableState23, (Object) mutableState21, (byte) 29);
                        gapComposer15.updateRememberedValue(objRememberedValue21);
                    } else {
                        mutableState3 = mutableState22;
                    }
                    CardKt.Button((Function0) objRememberedValue21, null, !StringsKt.isBlank(StringsKt.trim((String) mutableState3.getValue()).toString()), null, null, null, null, null, null, LastFMSettingsKt.lambda$1337055396, gapComposer15, 805306368, 506);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(MutableState mutableState, MutableState mutableState2, StatsViewModel statsViewModel, Function0 function0, MutableState mutableState3) {
        this.$r8$classId = (byte) 3;
        this.f$3 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = statsViewModel;
        this.f$0 = function0;
        this.f$4 = mutableState3;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(MutableState mutableState, Object obj, MutableState mutableState2, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$3 = mutableState;
        this.f$0 = obj;
        this.f$1 = mutableState2;
        this.f$2 = obj2;
        this.f$4 = obj3;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(Object obj, MusicDatabase musicDatabase, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = musicDatabase;
        this.f$2 = obj2;
        this.f$4 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(List list, Object obj, Function0 function0, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$1 = list;
        this.f$2 = obj;
        this.f$0 = function0;
        this.f$3 = obj2;
        this.f$4 = obj3;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda9(List list, List list2, MenuState menuState, Function0 function0, MutableState mutableState) {
        this.$r8$classId = (byte) 9;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$4 = menuState;
        this.f$0 = function0;
        this.f$3 = mutableState;
    }
}
