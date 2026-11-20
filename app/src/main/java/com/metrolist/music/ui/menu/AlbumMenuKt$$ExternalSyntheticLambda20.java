package com.metrolist.music.ui.menu;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda20 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ State f$6;
    public final /* synthetic */ State f$7;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8) {
        this.f$3 = mutableState;
        this.f$0 = mutableState2;
        this.f$1 = mutableState3;
        this.f$2 = mutableState4;
        this.f$4 = mutableState5;
        this.f$5 = mutableState6;
        this.f$6 = mutableState7;
        this.f$7 = mutableState8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v16, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r1v39, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        AddToPlaylistPosition addToPlaylistPosition;
        Function0 function0;
        MusicDatabase musicDatabase;
        MutableState mutableState;
        CoroutineScope coroutineScope;
        ?? r4;
        final MusicDatabase musicDatabase2;
        final SongItem songItem;
        CoroutineScope coroutineScope2;
        GapComposer gapComposer;
        Object songMenuKt$$ExternalSyntheticLambda40;
        CoroutineScope coroutineScope3;
        boolean z;
        ?? arrayList;
        byte b = this.$r8$classId;
        byte b2 = 14;
        State state = this.f$6;
        Object obj4 = Composer.Companion.Empty;
        State state2 = this.f$7;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$5;
        Object obj6 = this.f$4;
        Object obj7 = this.f$2;
        Object obj8 = this.f$1;
        Object obj9 = this.f$3;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                Album album = (Album) obj10;
                NavHostController navHostController = (NavHostController) obj8;
                Function0 function1 = (Function0) obj7;
                MutableState mutableState2 = (MutableState) obj9;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj6;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) state2;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                boolean z2 = (iIntValue & 17) != 16;
                int i = iIntValue & 1;
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(i, z2)) {
                    ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$708928016;
                    ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$197915857;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-313096302, new ItemsKt$$ExternalSyntheticLambda4(album, (byte) 2), gapComposer2);
                    boolean zChanged = gapComposer2.changed(album) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(function1) | gapComposer2.changed(mutableState2);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) album, (Object) navHostController, (Object) function1, (Object) mutableState2, (byte) 8);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                        objRememberedValue = songMenuKt$$ExternalSyntheticLambda63;
                    }
                    Material3MenuItemData material3MenuItemData = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue, null, null, 48);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(787049105, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 2), gapComposer2);
                    ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.lambda$276036946;
                    ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f179lambda$234975213;
                    boolean zChangedInstance = gapComposer2.changedInstance(coroutineScope4) | gapComposer2.changed(album) | gapComposer2.changedInstance(musicDatabase3);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda64 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope4, (Object) parcelableSnapshotMutableFloatState, (Object) album, (Object) musicDatabase3, (byte) 9);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda64);
                        objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda64;
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf((Object[]) new Material3MenuItemData[]{material3MenuItemData, new Material3MenuItemData(composableLambdaImplRememberComposableLambda2, composableLambdaImpl3, composableLambdaImpl4, (Function0) objRememberedValue2, null, null, 48)}), gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 1:
                MutableState mutableState3 = (MutableState) obj9;
                MutableState mutableState4 = (MutableState) obj10;
                MutableState mutableState5 = (MutableState) obj8;
                MutableState mutableState6 = (MutableState) obj7;
                MutableState mutableState7 = (MutableState) obj6;
                MutableState mutableState8 = (MutableState) obj5;
                MutableState mutableState9 = (MutableState) state;
                MutableState mutableState10 = (MutableState) state2;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    CrossfadeKt.AnimatedVisibility(Intrinsics.areEqual((String) mutableState3.getValue(), "weekdays_weekends"), null, EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(2129045766, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda17(mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, (byte) 0), gapComposer3), gapComposer3, 200064, 18);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 2:
                CoroutineScope coroutineScope5 = (CoroutineScope) obj6;
                MusicDatabase musicDatabase4 = (MusicDatabase) obj5;
                AddToPlaylistPosition addToPlaylistPosition2 = (AddToPlaylistPosition) obj10;
                Function0 function2 = (Function0) obj7;
                MutableState mutableState11 = (MutableState) obj9;
                MutableState mutableState12 = (MutableState) obj8;
                MutableState mutableState13 = (MutableState) state;
                MutableState mutableState14 = (MutableState) state2;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    boolean zChangedInstance2 = gapComposer4.changedInstance(coroutineScope5) | gapComposer4.changedInstance(musicDatabase4) | gapComposer4.changed(addToPlaylistPosition2.ordinal()) | gapComposer4.changed(function2);
                    Object objRememberedValue3 = gapComposer4.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == obj4) {
                        AddToPlaylistDialogKt$$ExternalSyntheticLambda11 addToPlaylistDialogKt$$ExternalSyntheticLambda11 = new AddToPlaylistDialogKt$$ExternalSyntheticLambda11(mutableState11, mutableState12, mutableState13, mutableState14, addToPlaylistPosition2, musicDatabase4, function2, coroutineScope5);
                        addToPlaylistPosition = addToPlaylistPosition2;
                        function0 = function2;
                        mutableState13 = mutableState13;
                        musicDatabase = musicDatabase4;
                        mutableState = mutableState12;
                        coroutineScope = coroutineScope5;
                        gapComposer4.updateRememberedValue(addToPlaylistDialogKt$$ExternalSyntheticLambda11);
                        objRememberedValue3 = addToPlaylistDialogKt$$ExternalSyntheticLambda11;
                    } else {
                        coroutineScope = coroutineScope5;
                        musicDatabase = musicDatabase4;
                        mutableState = mutableState12;
                        function0 = function2;
                        addToPlaylistPosition = addToPlaylistPosition2;
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.f118lambda$1633927040, gapComposer4, 805306368, 510);
                    boolean zChangedInstance3 = gapComposer4.changedInstance(coroutineScope) | gapComposer4.changedInstance(musicDatabase) | gapComposer4.changed(addToPlaylistPosition.ordinal()) | gapComposer4.changed(function0);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue4 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda29 songMenuKt$$ExternalSyntheticLambda29 = new SongMenuKt$$ExternalSyntheticLambda29(coroutineScope, mutableState11, musicDatabase, addToPlaylistPosition, function0, mutableState, mutableState13);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda29);
                        objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda29;
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AlbumMenuKt.lambda$1274838441, gapComposer4, 805306368, 510);
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (objRememberedValue5 == obj4) {
                        objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState11, (byte) 10);
                        gapComposer4.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AlbumMenuKt.f275lambda$924293304, gapComposer4, 805306374, 510);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 3:
                CoroutineScope coroutineScope6 = (CoroutineScope) obj6;
                MediaMetadata mediaMetadata = (MediaMetadata) obj10;
                MutableState mutableState15 = (MutableState) obj9;
                MusicDatabase musicDatabase5 = (MusicDatabase) obj5;
                Function0 function3 = (Function0) obj7;
                Function0 function4 = (Function0) obj8;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = (ParcelableSnapshotMutableFloatState) state2;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                ?? r3 = (GapComposer) composer4;
                if (r3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    r3.startReplaceGroup(1369419191);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1431042979, new ListItemKt$$ExternalSyntheticLambda11(state, b2), r3);
                    ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$2040113502;
                    ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$1216302687;
                    boolean zChangedInstance4 = r3.changedInstance(coroutineScope6) | r3.changed(mediaMetadata) | r3.changed(mutableState15) | r3.changedInstance(musicDatabase5);
                    Object objRememberedValue6 = r3.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue6 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda41 = new SongMenuKt$$ExternalSyntheticLambda40(coroutineScope6, parcelableSnapshotMutableFloatState2, mediaMetadata, musicDatabase5, mutableState15);
                        r3.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda41);
                        objRememberedValue6 = songMenuKt$$ExternalSyntheticLambda41;
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda3, composableLambdaImpl5, composableLambdaImpl6, (Function0) objRememberedValue6, null, null, 48));
                    ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f158lambda$1980983482;
                    ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$905773063;
                    ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f216lambda$502437688;
                    boolean zChanged2 = r3.changed(function3) | r3.changed(function4);
                    Object objRememberedValue7 = r3.rememberedValue();
                    if (zChanged2 || objRememberedValue7 == obj4) {
                        r4 = 0;
                        objRememberedValue7 = new QueueMenuKt$$ExternalSyntheticLambda21(function3, function4, (byte) 0);
                        r3.updateRememberedValue(objRememberedValue7);
                    } else {
                        r4 = 0;
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, composableLambdaImpl9, (Function0) objRememberedValue7, null, null, 48));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    r3.end(r4);
                    MenuKt.Material3MenuGroup(listBuilderBuild, r3, r4);
                } else {
                    r3.skipToGroupEnd();
                }
                break;
            case 4:
                SongItem songItem2 = (SongItem) obj10;
                MusicDatabase musicDatabase6 = (MusicDatabase) obj5;
                final SyncUtils syncUtils = (SyncUtils) obj8;
                final Function0 function5 = (Function0) obj7;
                Function0 function6 = (Function0) obj9;
                CoroutineScope coroutineScope7 = (CoroutineScope) obj6;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.startReplaceGroup(-2037046646);
                    ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
                    boolean z3 = songItem2.isEpisode;
                    final State state3 = this.f$6;
                    if (z3) {
                        gapComposer5.startReplaceGroup(1781227257);
                        if (songItem2.setVideoId != null) {
                            gapComposer5.startReplaceGroup(1781224219);
                            ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$2003386225;
                            ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f101lambda$1473685710;
                            boolean zChangedInstance5 = gapComposer5.changedInstance(musicDatabase6) | gapComposer5.changed(state3) | gapComposer5.changedInstance(syncUtils) | gapComposer5.changedInstance(songItem2) | gapComposer5.changed(function5);
                            Object objRememberedValue8 = gapComposer5.rememberedValue();
                            if (zChangedInstance5 || objRememberedValue8 == obj4) {
                                final byte b3 = 0;
                                musicDatabase2 = musicDatabase6;
                                songItem = songItem2;
                                objRememberedValue8 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b4 = b3;
                                        Unit unit2 = Unit.INSTANCE;
                                        State state4 = state3;
                                        Function0 function7 = function5;
                                        SongItem songItem3 = songItem;
                                        SyncUtils syncUtils2 = syncUtils;
                                        MusicDatabase musicDatabase7 = musicDatabase2;
                                        switch (b4) {
                                            case 0:
                                                musicDatabase7.query(new AppBarKt$$ExternalSyntheticLambda3(state4, (byte) 10));
                                                syncUtils2.saveEpisode(songItem3.id, songItem3.setVideoId, false);
                                                function7.invoke();
                                                break;
                                            default:
                                                musicDatabase7.query(new SongMenuKt$$ExternalSyntheticLambda4(songItem3, state4, (byte) 12));
                                                syncUtils2.saveEpisode(songItem3.id, null, true);
                                                function7.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer5.updateRememberedValue(objRememberedValue8);
                            } else {
                                musicDatabase2 = musicDatabase6;
                                songItem = songItem2;
                            }
                            listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, null, (Function0) objRememberedValue8, null, null, 52));
                            z = false;
                            gapComposer5.end(false);
                        } else {
                            musicDatabase2 = musicDatabase6;
                            songItem = songItem2;
                            gapComposer5.startReplaceGroup(1782549872);
                            ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f72lambda$1244766200;
                            ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$2139321353;
                            ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$1228441610;
                            boolean zChangedInstance6 = gapComposer5.changedInstance(musicDatabase2) | gapComposer5.changed(state3) | gapComposer5.changedInstance(songItem) | gapComposer5.changedInstance(syncUtils) | gapComposer5.changed(function5);
                            Object objRememberedValue9 = gapComposer5.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue9 == obj4) {
                                final byte b4 = 1;
                                Function0 function7 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b5 = b4;
                                        Unit unit2 = Unit.INSTANCE;
                                        State state4 = state3;
                                        Function0 function8 = function5;
                                        SongItem songItem3 = songItem;
                                        SyncUtils syncUtils2 = syncUtils;
                                        MusicDatabase musicDatabase7 = musicDatabase2;
                                        switch (b5) {
                                            case 0:
                                                musicDatabase7.query(new AppBarKt$$ExternalSyntheticLambda3(state4, (byte) 10));
                                                syncUtils2.saveEpisode(songItem3.id, songItem3.setVideoId, false);
                                                function8.invoke();
                                                break;
                                            default:
                                                musicDatabase7.query(new SongMenuKt$$ExternalSyntheticLambda4(songItem3, state4, (byte) 12));
                                                syncUtils2.saveEpisode(songItem3.id, null, true);
                                                function8.invoke();
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer5.updateRememberedValue(function7);
                                objRememberedValue9 = function7;
                            }
                            listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl12, composableLambdaImpl13, composableLambdaImpl14, (Function0) objRememberedValue9, null, null, 48));
                            z = false;
                            gapComposer5.end(false);
                        }
                        gapComposer5.end(z);
                    } else {
                        musicDatabase2 = musicDatabase6;
                        songItem = songItem2;
                        gapComposer5.startReplaceGroup(1784277471);
                        gapComposer5.end(false);
                    }
                    if (songItem.historyRemoveToken != null) {
                        gapComposer5.startReplaceGroup(1784383119);
                        ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.f252lambda$724378091;
                        ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f173lambda$2132588842;
                        boolean zChangedInstance7 = gapComposer5.changedInstance(coroutineScope7) | gapComposer5.changedInstance(songItem) | gapComposer5.changed(function6) | gapComposer5.changed(function5);
                        Object objRememberedValue10 = gapComposer5.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue10 == obj4) {
                            gapComposer = gapComposer5;
                            coroutineScope2 = coroutineScope7;
                            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda65 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope2, (Object) songItem, (Object) function6, (Object) function5, (byte) 20);
                            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda65);
                            objRememberedValue10 = songMenuKt$$ExternalSyntheticLambda65;
                        } else {
                            coroutineScope2 = coroutineScope7;
                            gapComposer = gapComposer5;
                        }
                        listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl15, composableLambdaImpl16, null, (Function0) objRememberedValue10, null, null, 52));
                        gapComposer.end(false);
                    } else {
                        coroutineScope2 = coroutineScope7;
                        gapComposer = gapComposer5;
                        gapComposer.startReplaceGroup(1785874591);
                        gapComposer.end(false);
                    }
                    State state4 = this.f$7;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-1719758681, new ListItemKt$$ExternalSyntheticLambda11(state4, (byte) 26), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(-933408024, new ListItemKt$$ExternalSyntheticLambda11(state4, (byte) 27), gapComposer);
                    boolean zChangedInstance8 = gapComposer.changedInstance(coroutineScope2) | gapComposer.changed(state4) | gapComposer.changedInstance(musicDatabase2) | gapComposer.changedInstance(songItem) | gapComposer.changed(function5);
                    Object objRememberedValue11 = gapComposer.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue11 == obj4) {
                        coroutineScope3 = coroutineScope2;
                        songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope3, function5, (Object) musicDatabase2, (Object) songItem, (Object) state4, (byte) 13);
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                    } else {
                        songMenuKt$$ExternalSyntheticLambda40 = objRememberedValue11;
                        coroutineScope3 = coroutineScope2;
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda4, composableLambdaImplRememberComposableLambda5, null, (Function0) songMenuKt$$ExternalSyntheticLambda40, null, null, 52));
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(-839056688, new ListItemKt$$ExternalSyntheticLambda11(state3, (byte) 28), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(-1070319407, new ListItemKt$$ExternalSyntheticLambda11(state3, (byte) 29), gapComposer);
                    ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.f78lambda$1301582126;
                    boolean zChanged3 = gapComposer.changed(state3) | gapComposer.changedInstance(coroutineScope3) | gapComposer.changedInstance(songItem) | gapComposer.changedInstance(musicDatabase2);
                    Object objRememberedValue12 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue12 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda66 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope3, musicDatabase2, (Object) state3, (Object) songItem, (byte) 21);
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda66);
                        objRememberedValue12 = songMenuKt$$ExternalSyntheticLambda66;
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda6, composableLambdaImplRememberComposableLambda7, composableLambdaImpl17, (Function0) objRememberedValue12, null, null, 48));
                    ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                    gapComposer.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild2, gapComposer, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            case 5:
                State state5 = (State) obj10;
                HapticFeedback hapticFeedback = (HapticFeedback) obj7;
                MenuState menuState = (MenuState) obj5;
                NavHostController navHostController2 = (NavHostController) obj8;
                CoroutineScope coroutineScope8 = (CoroutineScope) obj6;
                MutableState mutableState16 = (MutableState) obj9;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                boolean z4 = (iIntValue6 & 17) != 16;
                int i2 = iIntValue6 & 1;
                ?? r12 = (GapComposer) composer6;
                if (r12.shouldExecute(i2, z4)) {
                    if (((Boolean) mutableState16.getValue()).booleanValue()) {
                        List list = (List) state2.getValue();
                        arrayList = new ArrayList();
                        for (Object obj11 : list) {
                            if (!((Album) obj11).album.explicit) {
                                arrayList.add(obj11);
                            }
                        }
                    } else {
                        arrayList = (List) state2.getValue();
                    }
                    ?? r1 = arrayList;
                    WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                    InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(r12).systemBars, 15), r12);
                    boolean zChangedInstance9 = r12.changedInstance(r1);
                    State state6 = this.f$6;
                    boolean zChanged4 = r12.changed(state6) | zChangedInstance9 | r12.changed(state5) | r12.changedInstance(hapticFeedback) | r12.changed(menuState) | r12.changedInstance(navHostController2) | r12.changedInstance(coroutineScope8);
                    Object objRememberedValue13 = r12.rememberedValue();
                    if (zChanged4 || objRememberedValue13 == obj4) {
                        NavHostKt$$ExternalSyntheticLambda12 navHostKt$$ExternalSyntheticLambda12 = new NavHostKt$$ExternalSyntheticLambda12((Object) r1, (Object) hapticFeedback, (Object) menuState, (Object) navHostController2, (Object) coroutineScope8, state6, state5, (byte) 7);
                        r12.updateRememberedValue(navHostKt$$ExternalSyntheticLambda12);
                        objRememberedValue13 = navHostKt$$ExternalSyntheticLambda12;
                    }
                    IntMath.LazyRow(null, null, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue13, r12, 0, 507);
                } else {
                    r12.skipToGroupEnd();
                }
                break;
            default:
                Playlist playlist = (Playlist) obj10;
                MutableState mutableState17 = (MutableState) obj9;
                SnackbarHostState snackbarHostState = (SnackbarHostState) obj8;
                MutableState mutableState18 = (MutableState) obj7;
                MutableState mutableState19 = (MutableState) obj6;
                MutableState mutableState20 = (MutableState) obj5;
                MutableState mutableState21 = (MutableState) state2;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue7 & 6) == 0) {
                    iIntValue7 |= ((GapComposer) composer7).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer6 = (GapComposer) composer7;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                    List list2 = (List) mutableState18.getValue();
                    PlaylistItem playlistItem = (PlaylistItem) state.getValue();
                    Object objRememberedValue14 = gapComposer6.rememberedValue();
                    if (objRememberedValue14 == obj4) {
                        objRememberedValue14 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState19, (byte) 13);
                        gapComposer6.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function8 = (Function0) objRememberedValue14;
                    Object objRememberedValue15 = gapComposer6.rememberedValue();
                    if (objRememberedValue15 == obj4) {
                        objRememberedValue15 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState20, (byte) 14);
                        gapComposer6.updateRememberedValue(objRememberedValue15);
                    }
                    Function0 function9 = (Function0) objRememberedValue15;
                    Object objRememberedValue16 = gapComposer6.rememberedValue();
                    if (objRememberedValue16 == obj4) {
                        objRememberedValue16 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState21, (byte) 15);
                        gapComposer6.updateRememberedValue(objRememberedValue16);
                    }
                    Function0 function10 = (Function0) objRememberedValue16;
                    boolean zChanged5 = gapComposer6.changed(mutableState17);
                    Object objRememberedValue17 = gapComposer6.rememberedValue();
                    if (zChanged5 || objRememberedValue17 == obj4) {
                        objRememberedValue17 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState17, (byte) 16);
                        gapComposer6.updateRememberedValue(objRememberedValue17);
                    }
                    LocalPlaylistScreenKt.LocalPlaylistHeader(playlist, list2, playlistItem, function8, function9, function10, (Function0) objRememberedValue17, snackbarHostState, DialogKt.m1476riseInwH6b6FI$default(LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, Modifier.Companion.$$INSTANCE), 0), gapComposer6, 12807168);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, AddToPlaylistPosition addToPlaylistPosition, MusicDatabase musicDatabase, Function0 function0, CoroutineScope coroutineScope) {
        this.f$4 = coroutineScope;
        this.f$5 = musicDatabase;
        this.f$0 = addToPlaylistPosition;
        this.f$2 = function0;
        this.f$3 = mutableState;
        this.f$1 = mutableState2;
        this.f$6 = mutableState3;
        this.f$7 = mutableState4;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(State state, State state2, HapticFeedback hapticFeedback, MenuState menuState, NavHostController navHostController, CoroutineScope coroutineScope, MutableState mutableState, State state3) {
        this.f$6 = state;
        this.f$0 = state2;
        this.f$2 = hapticFeedback;
        this.f$5 = menuState;
        this.f$1 = navHostController;
        this.f$4 = coroutineScope;
        this.f$3 = mutableState;
        this.f$7 = state3;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(SongItem songItem, MusicDatabase musicDatabase, State state, SyncUtils syncUtils, Function0 function0, Function0 function1, CoroutineScope coroutineScope, State state2) {
        this.f$0 = songItem;
        this.f$5 = musicDatabase;
        this.f$6 = state;
        this.f$1 = syncUtils;
        this.f$2 = function0;
        this.f$3 = function1;
        this.f$4 = coroutineScope;
        this.f$7 = state2;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(Album album, NavHostController navHostController, Function0 function0, MutableState mutableState, CoroutineScope coroutineScope, MusicDatabase musicDatabase, State state, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$0 = album;
        this.f$1 = navHostController;
        this.f$2 = function0;
        this.f$3 = mutableState;
        this.f$4 = coroutineScope;
        this.f$5 = musicDatabase;
        this.f$6 = state;
        this.f$7 = parcelableSnapshotMutableFloatState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(Playlist playlist, MutableState mutableState, SnackbarHostState snackbarHostState, MutableState mutableState2, State state, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        this.f$0 = playlist;
        this.f$3 = mutableState;
        this.f$1 = snackbarHostState;
        this.f$2 = mutableState2;
        this.f$6 = state;
        this.f$4 = mutableState3;
        this.f$5 = mutableState4;
        this.f$7 = mutableState5;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda20(CoroutineScope coroutineScope, MediaMetadata mediaMetadata, MutableState mutableState, MusicDatabase musicDatabase, Function0 function0, Function0 function1, State state, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$4 = coroutineScope;
        this.f$0 = mediaMetadata;
        this.f$3 = mutableState;
        this.f$5 = musicDatabase;
        this.f$2 = function0;
        this.f$1 = function1;
        this.f$6 = state;
        this.f$7 = parcelableSnapshotMutableFloatState;
    }
}
