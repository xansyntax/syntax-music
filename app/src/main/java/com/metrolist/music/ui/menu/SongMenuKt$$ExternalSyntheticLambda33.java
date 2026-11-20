package com.metrolist.music.ui.menu;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt__BringIntoViewRequesterKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda72;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.parsing.ParserDslKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda33 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function0 f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ boolean f$9;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda33(Song song, NavHostController navHostController, Function0 function0, MutableState mutableState, CoroutineScope coroutineScope, MusicDatabase musicDatabase, BottomSheetPageState bottomSheetPageState, CoroutineScope coroutineScope2, MutableState mutableState2, boolean z, State state, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$3 = song;
        this.f$5 = navHostController;
        this.f$4 = function0;
        this.f$11 = mutableState;
        this.f$0 = coroutineScope;
        this.f$2 = musicDatabase;
        this.f$6 = bottomSheetPageState;
        this.f$7 = coroutineScope2;
        this.f$8 = mutableState2;
        this.f$9 = z;
        this.f$1 = state;
        this.f$10 = parcelableSnapshotMutableFloatState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object songMenuKt$$ExternalSyntheticLambda40;
        MusicDatabase musicDatabase;
        MutableState mutableState;
        CoroutineScope coroutineScope;
        Song song;
        GapComposer gapComposer;
        SyncUtils syncUtils;
        ?? r6;
        Object songMenuKt$$ExternalSyntheticLambda25;
        boolean z;
        GapComposer gapComposer2;
        Function0 function0;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = Composer.Companion.Empty;
        Object obj5 = this.f$11;
        Object obj6 = this.f$10;
        Object obj7 = this.f$7;
        Object obj8 = this.f$6;
        Object obj9 = this.f$5;
        Object obj10 = this.f$3;
        Object obj11 = this.f$2;
        Object obj12 = this.f$1;
        Object obj13 = this.f$0;
        Object obj14 = this.f$8;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj13;
                State state = (State) obj12;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj11;
                Song song2 = (Song) obj10;
                SyncUtils syncUtils2 = (SyncUtils) obj9;
                Event event = (Event) obj8;
                PlaylistSong playlistSong = (PlaylistSong) obj7;
                String str = (String) obj14;
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj6;
                MutableState mutableState2 = (MutableState) obj5;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    gapComposer3.startReplaceGroup(1543454555);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1671651278, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 15), gapComposer3);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1532865871, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 16), gapComposer3);
                    boolean zChangedInstance = gapComposer3.changedInstance(coroutineScope2) | gapComposer3.changed(state) | gapComposer3.changedInstance(musicDatabase2) | gapComposer3.changed(song2);
                    Function0 function1 = this.f$4;
                    boolean zChanged = zChangedInstance | gapComposer3.changed(function1);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue == obj4) {
                        musicDatabase = musicDatabase2;
                        mutableState = mutableState2;
                        coroutineScope = coroutineScope2;
                        song = song2;
                        GapComposer gapComposer4 = gapComposer3;
                        songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope, function1, (Object) musicDatabase, (Object) song, (Object) state, (byte) 10);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        gapComposer = gapComposer4;
                    } else {
                        mutableState = mutableState2;
                        gapComposer = gapComposer3;
                        musicDatabase = musicDatabase2;
                        songMenuKt$$ExternalSyntheticLambda40 = objRememberedValue;
                        coroutineScope = coroutineScope2;
                        song = song2;
                    }
                    r13.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) songMenuKt$$ExternalSyntheticLambda40, null, null, 52));
                    SongEntity songEntity = song.song;
                    if (songEntity.isEpisode) {
                        gapComposer.startReplaceGroup(1551731439);
                        boolean z2 = songEntity.inLibrary != null;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(165679251, new SongMenuKt$$ExternalSyntheticLambda26((byte) 8, z2), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-233033516, new SongMenuKt$$ExternalSyntheticLambda26((byte) 9, z2), gapComposer);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f240lambda$631746283;
                        boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | gapComposer.changed(z2) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(song) | gapComposer.changedInstance(syncUtils2) | gapComposer.changed(function1);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == obj4) {
                            Song song3 = song;
                            MusicDatabase musicDatabase3 = musicDatabase;
                            syncUtils = syncUtils2;
                            songMenuKt$$ExternalSyntheticLambda25 = new SongMenuKt$$ExternalSyntheticLambda25(coroutineScope, function1, z2, musicDatabase3, song3, syncUtils);
                            musicDatabase = musicDatabase3;
                            song = song3;
                            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda25);
                        } else {
                            songMenuKt$$ExternalSyntheticLambda25 = objRememberedValue2;
                            syncUtils = syncUtils2;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, composableLambdaImpl, (Function0) songMenuKt$$ExternalSyntheticLambda25, null, null, 48));
                        gapComposer.end(false);
                    } else {
                        syncUtils = syncUtils2;
                        gapComposer.startReplaceGroup(1554842351);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(-400354134, new SongMenuKt$$ExternalSyntheticLambda48(song, (byte) 0), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(-776187605, new SongMenuKt$$ExternalSyntheticLambda48(song, (byte) 2), gapComposer);
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f58lambda$1152021076;
                        boolean zChanged2 = gapComposer.changed(song) | gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(musicDatabase);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == obj4) {
                            objRememberedValue3 = new GapComposer$$ExternalSyntheticLambda0(song, musicDatabase, coroutineScope, (byte) 23);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        r13.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda5, composableLambdaImplRememberComposableLambda6, composableLambdaImpl2, (Function0) objRememberedValue3, null, null, 48));
                        gapComposer.end(false);
                    }
                    if (event != null) {
                        gapComposer.startReplaceGroup(1557475460);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f273lambda$893951300;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f136lambda$1804831043;
                        boolean zChanged3 = gapComposer.changed(function1) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(event);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == obj4) {
                            objRememberedValue4 = new GapComposer$$ExternalSyntheticLambda0(function1, musicDatabase, event, (byte) 24);
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        r13.add(new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue4, null, null, 52));
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1558355736);
                        gapComposer.end(false);
                    }
                    if (playlistSong != null) {
                        gapComposer.startReplaceGroup(1558470157);
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$771922395;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f88lambda$138957348;
                        boolean zChangedInstance3 = gapComposer.changedInstance(playlistSong) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(str) | gapComposer.changedInstance(syncUtils) | gapComposer.changed(function1);
                        Object objRememberedValue5 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue5 == obj4) {
                            objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda40((Object) playlistSong, (Object) musicDatabase, (Object) str, (Object) function1, (Object) syncUtils, (byte) 0);
                            gapComposer.updateRememberedValue(objRememberedValue5);
                        }
                        r13.add(new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, null, (Function0) objRememberedValue5, null, null, 52));
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1560448856);
                        gapComposer.end(false);
                    }
                    if (this.f$9) {
                        gapComposer.startReplaceGroup(1560516591);
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f146lambda$1857171206;
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$1526916347;
                        boolean zChanged4 = gapComposer.changed(function1) | gapComposer.changedInstance(cachePlaylistViewModel) | gapComposer.changed(song);
                        Object objRememberedValue6 = gapComposer.rememberedValue();
                        if (zChanged4 || objRememberedValue6 == obj4) {
                            objRememberedValue6 = new GapComposer$$ExternalSyntheticLambda0(function1, cachePlaylistViewModel, song, (byte) 22);
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        r13.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, null, (Function0) objRememberedValue6, null, null, 52));
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1561324792);
                        gapComposer.end(false);
                    }
                    if (songEntity.isUploaded) {
                        gapComposer.startReplaceGroup(1561454124);
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f152lambda$191297511;
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f52lambda$1102177254;
                        MutableState mutableState3 = mutableState;
                        boolean zChanged5 = gapComposer.changed(mutableState3);
                        Object objRememberedValue7 = gapComposer.rememberedValue();
                        if (zChanged5 || objRememberedValue7 == obj4) {
                            objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 3);
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        r13.add(new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue7, null, null, 52));
                        r6 = 0;
                        gapComposer.end(false);
                    } else {
                        r6 = 0;
                        gapComposer.startReplaceGroup(1562203704);
                        gapComposer.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(r13);
                    gapComposer.end(r6);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, r6);
                }
                break;
            case 1:
                Song song4 = (Song) obj10;
                NavHostController navHostController = (NavHostController) obj9;
                MutableState mutableState4 = (MutableState) obj5;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj13;
                MusicDatabase musicDatabase4 = (MusicDatabase) obj11;
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) obj8;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj7;
                MutableState mutableState5 = (MutableState) obj14;
                State state2 = (State) obj12;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj6;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer2;
                if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    gapComposer5.startReplaceGroup(446782305);
                    ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
                    SongEntity songEntity2 = song4.song;
                    boolean z3 = songEntity2.isEpisode;
                    String str2 = songEntity2.albumId;
                    Function0 function2 = this.f$4;
                    if (z3) {
                        gapComposer5.startReplaceGroup(1913486932);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(1912318356);
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$204761495;
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f155lambda$193951272;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(-592664039, new SongMenuKt$$ExternalSyntheticLambda48(song4, (byte) 3), gapComposer5);
                        boolean zChanged6 = gapComposer5.changed(song4) | gapComposer5.changedInstance(navHostController) | gapComposer5.changed(function2) | gapComposer5.changed(mutableState4);
                        Object objRememberedValue8 = gapComposer5.rememberedValue();
                        if (zChanged6 || objRememberedValue8 == obj4) {
                            objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda63(song4, navHostController, function2, mutableState4);
                            gapComposer5.updateRememberedValue(objRememberedValue8);
                        }
                        listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl11, composableLambdaImpl12, composableLambdaImplRememberComposableLambda7, (Function0) objRememberedValue8, null, null, 48));
                        gapComposer5.end(false);
                    }
                    boolean z4 = songEntity2.isEpisode;
                    if (str2 != null) {
                        gapComposer5.startReplaceGroup(1913591743);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda8 = Expect_jvmKt.rememberComposableLambda(-854869056, new SongMenuKt$$ExternalSyntheticLambda26((byte) 10, z4), gapComposer5);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda9 = Expect_jvmKt.rememberComposableLambda(-1765748799, new SongMenuKt$$ExternalSyntheticLambda26((byte) 11, z4), gapComposer5);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda10 = Expect_jvmKt.rememberComposableLambda(1618338754, new SongMenuKt$$ExternalSyntheticLambda48(song4, (byte) 4), gapComposer5);
                        boolean zChanged7 = gapComposer5.changed(function2) | gapComposer5.changed(z4) | gapComposer5.changedInstance(navHostController) | gapComposer5.changed(song4);
                        Object objRememberedValue9 = gapComposer5.rememberedValue();
                        if (zChanged7 || objRememberedValue9 == obj4) {
                            objRememberedValue9 = new SongMenuKt$$ExternalSyntheticLambda69(function2, z4, navHostController, song4);
                            gapComposer5.updateRememberedValue(objRememberedValue9);
                        }
                        listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda8, composableLambdaImplRememberComposableLambda9, composableLambdaImplRememberComposableLambda10, (Function0) objRememberedValue9, null, null, 48));
                        z = false;
                        gapComposer5.end(false);
                    } else {
                        z = false;
                        gapComposer5.startReplaceGroup(1915118772);
                        gapComposer5.end(false);
                    }
                    String str3 = (str2 == null || !z4) ? null : str2;
                    if (str3 == null) {
                        gapComposer5.startReplaceGroup(1915401212);
                        gapComposer5.end(z);
                        function0 = function2;
                        gapComposer2 = gapComposer5;
                    } else {
                        gapComposer5.startReplaceGroup(1915401213);
                        boolean z5 = this.f$9;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda11 = Expect_jvmKt.rememberComposableLambda(-1310972134, new SongMenuKt$$ExternalSyntheticLambda26((byte) 12, z5), gapComposer5);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda12 = Expect_jvmKt.rememberComposableLambda(-1444676197, new SongMenuKt$$ExternalSyntheticLambda26((byte) 13, z5), gapComposer5);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda13 = Expect_jvmKt.rememberComposableLambda(-1578380260, new SongMenuKt$$ExternalSyntheticLambda48(song4, (byte) 5), gapComposer5);
                        boolean zChanged8 = gapComposer5.changed(str3) | gapComposer5.changedInstance(coroutineScope4) | gapComposer5.changed(mutableState5) | gapComposer5.changedInstance(musicDatabase4) | gapComposer5.changed(song4) | gapComposer5.changed(function2);
                        Object objRememberedValue10 = gapComposer5.rememberedValue();
                        if (zChanged8 || objRememberedValue10 == obj4) {
                            gapComposer2 = gapComposer5;
                            SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(str3, coroutineScope4, function2, musicDatabase4, mutableState5, song4);
                            function0 = function2;
                            song4 = song4;
                            gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                            objRememberedValue10 = songMenuKt$$ExternalSyntheticLambda73;
                        } else {
                            function0 = function2;
                            gapComposer2 = gapComposer5;
                        }
                        listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda11, composableLambdaImplRememberComposableLambda12, composableLambdaImplRememberComposableLambda13, (Function0) objRememberedValue10, null, null, 48));
                        gapComposer2.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda14 = Expect_jvmKt.rememberComposableLambda(1710733522, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 17), gapComposer2);
                    ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$1571948115;
                    ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$1433162708;
                    boolean zChangedInstance4 = gapComposer2.changedInstance(coroutineScope3) | gapComposer2.changed(song4) | gapComposer2.changedInstance(musicDatabase4);
                    Object objRememberedValue11 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue11 == obj4) {
                        SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope3, (Object) parcelableSnapshotMutableFloatState, (Object) song4, (Object) musicDatabase4, (byte) 0);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                        objRememberedValue11 = songMenuKt$$ExternalSyntheticLambda63;
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda14, composableLambdaImpl13, composableLambdaImpl14, (Function0) objRememberedValue11, null, null, 48));
                    ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.f38lambda$1019729861;
                    ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f74lambda$1248519812;
                    ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.f102lambda$1477309763;
                    boolean zChanged9 = gapComposer2.changed(function0) | gapComposer2.changed(bottomSheetPageState) | gapComposer2.changed(song4);
                    Object objRememberedValue12 = gapComposer2.rememberedValue();
                    if (zChanged9 || objRememberedValue12 == obj4) {
                        objRememberedValue12 = new GapComposer$$ExternalSyntheticLambda0(function0, bottomSheetPageState, song4, (byte) 26);
                        gapComposer2.updateRememberedValue(objRememberedValue12);
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl15, composableLambdaImpl16, composableLambdaImpl17, (Function0) objRememberedValue12, null, null, 48));
                    ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                    gapComposer2.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild2, gapComposer2, 0);
                }
                break;
            default:
                final String str4 = (String) obj14;
                final Function1 function3 = (Function1) obj13;
                BringIntoViewRequesterImpl bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) obj12;
                final String str5 = (String) obj11;
                final Function1 function4 = (Function1) obj10;
                String str6 = (String) obj9;
                String str7 = (String) obj8;
                String str8 = (String) obj7;
                Function0 function5 = (Function0) obj6;
                Function0 function6 = (Function0) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer3;
                if (!gapComposer6.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer6, 54);
                    int iHashCode = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f);
                    long j = CardKt.getColorScheme(gapComposer6).primary;
                    long j2 = CardKt.getColorScheme(gapComposer6).outline;
                    TextFieldColors textFieldColorsM347colors0hiis_0 = TextFieldDefaults.m347colors0hiis_0(0L, 0L, 0L, 0L, CardKt.getColorScheme(gapComposer6).surfaceContainerLow, CardKt.getColorScheme(gapComposer6).surfaceContainerLow, 0L, 0L, null, j, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.5f, Color.m483getColorSpaceimpl(j2)), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, gapComposer6, 3072, 2147477455, 4095);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    Function0 function7 = this.f$4;
                    boolean zChanged10 = gapComposer6.changed(function7);
                    Object objRememberedValue13 = gapComposer6.rememberedValue();
                    if (zChanged10 || objRememberedValue13 == obj4) {
                        objRememberedValue13 = new AppBarKt$$ExternalSyntheticLambda8(function7, (byte) 10);
                        gapComposer6.updateRememberedValue(objRememberedValue13);
                    }
                    final byte b2 = 0;
                    ScrimKt.OutlinedTextField(str4, function3, FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue13), false, false, null, AlbumScreenKt.lambda$1029341619, AlbumScreenKt.lambda$798078900, AlbumScreenKt.lambda$566816181, Expect_jvmKt.rememberComposableLambda(335553462, new Function2() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda66
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj15, Object obj16) {
                            byte b3 = b2;
                            Unit unit2 = Unit.INSTANCE;
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            Function1 function8 = function3;
                            String str9 = str4;
                            switch (b3) {
                                case 0:
                                    Composer composer4 = (Composer) obj15;
                                    int iIntValue4 = ((Integer) obj16).intValue();
                                    GapComposer gapComposer7 = (GapComposer) composer4;
                                    if (!gapComposer7.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                                        gapComposer7.skipToGroupEnd();
                                    } else if (!StringsKt.isBlank(str9)) {
                                        gapComposer7.startReplaceGroup(2084348544);
                                        boolean zChanged11 = gapComposer7.changed(function8);
                                        Object objRememberedValue14 = gapComposer7.rememberedValue();
                                        if (zChanged11 || objRememberedValue14 == neverEqualPolicy) {
                                            objRememberedValue14 = new ParserDslKt$$ExternalSyntheticLambda0(function8, (byte) 11);
                                            gapComposer7.updateRememberedValue(objRememberedValue14);
                                        }
                                        CardKt.IconButton((Function0) objRememberedValue14, null, false, null, null, AlbumScreenKt.lambda$895074543, gapComposer7, 1572864, 62);
                                        gapComposer7.end(false);
                                    } else {
                                        gapComposer7.startReplaceGroup(2084544588);
                                        gapComposer7.end(false);
                                    }
                                    break;
                                default:
                                    Composer composer5 = (Composer) obj15;
                                    int iIntValue5 = ((Integer) obj16).intValue();
                                    GapComposer gapComposer8 = (GapComposer) composer5;
                                    if (!gapComposer8.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                        gapComposer8.skipToGroupEnd();
                                    } else if (!StringsKt.isBlank(str9)) {
                                        gapComposer8.startReplaceGroup(-1874867273);
                                        boolean zChanged12 = gapComposer8.changed(function8);
                                        Object objRememberedValue15 = gapComposer8.rememberedValue();
                                        if (zChanged12 || objRememberedValue15 == neverEqualPolicy) {
                                            objRememberedValue15 = new ParserDslKt$$ExternalSyntheticLambda0(function8, (byte) 12);
                                            gapComposer8.updateRememberedValue(objRememberedValue15);
                                        }
                                        CardKt.IconButton((Function0) objRememberedValue15, null, false, null, null, AlbumScreenKt.f321lambda$323710760, gapComposer8, 1572864, 62);
                                        gapComposer8.end(false);
                                    } else {
                                        gapComposer8.startReplaceGroup(-1874671229);
                                        gapComposer8.end(false);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }, gapComposer6), null, null, null, null, true, 0, 0, roundedCornerShapeM185RoundedCornerShape0680j_4, textFieldColorsM347colors0hiis_0, gapComposer6, 920125440, 12582912, 1965112);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f);
                    long j3 = CardKt.getColorScheme(gapComposer6).primary;
                    long j4 = CardKt.getColorScheme(gapComposer6).outline;
                    TextFieldColors textFieldColorsM347colors0hiis_1 = TextFieldDefaults.m347colors0hiis_0(0L, 0L, 0L, 0L, CardKt.getColorScheme(gapComposer6).surfaceContainerLow, CardKt.getColorScheme(gapComposer6).surfaceContainerLow, 0L, 0L, null, j3, ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.5f, Color.m483getColorSpaceimpl(j4)), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, gapComposer6, 3072, 2147477455, 4095);
                    Modifier modifierBringIntoViewRequester = BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester(SizeKt.fillMaxWidth(companion, 1.0f), bringIntoViewRequesterImpl);
                    boolean zChanged11 = gapComposer6.changed(function7);
                    Object objRememberedValue14 = gapComposer6.rememberedValue();
                    if (zChanged11 || objRememberedValue14 == obj4) {
                        objRememberedValue14 = new AppBarKt$$ExternalSyntheticLambda8(function7, (byte) 11);
                        gapComposer6.updateRememberedValue(objRememberedValue14);
                    }
                    Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierBringIntoViewRequester, (Function1) objRememberedValue14);
                    boolean zChanged12 = gapComposer6.changed(function4);
                    Object objRememberedValue15 = gapComposer6.rememberedValue();
                    if (zChanged12 || objRememberedValue15 == obj4) {
                        objRememberedValue15 = new CodecsKt$$ExternalSyntheticLambda0(function4, (byte) 15);
                        gapComposer6.updateRememberedValue(objRememberedValue15);
                    }
                    final byte b3 = 1;
                    ScrimKt.OutlinedTextField(str5, (Function1) objRememberedValue15, modifierOnFocusChanged, false, false, null, AlbumScreenKt.f306lambda$142069604, AlbumScreenKt.lambda$952756829, AlbumScreenKt.lambda$2047583262, Expect_jvmKt.rememberComposableLambda(-1152557601, new Function2() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda66
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj15, Object obj16) {
                            byte b4 = b3;
                            Unit unit2 = Unit.INSTANCE;
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            Function1 function8 = function4;
                            String str9 = str5;
                            switch (b4) {
                                case 0:
                                    Composer composer4 = (Composer) obj15;
                                    int iIntValue4 = ((Integer) obj16).intValue();
                                    GapComposer gapComposer7 = (GapComposer) composer4;
                                    if (!gapComposer7.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                                        gapComposer7.skipToGroupEnd();
                                    } else if (!StringsKt.isBlank(str9)) {
                                        gapComposer7.startReplaceGroup(2084348544);
                                        boolean zChanged13 = gapComposer7.changed(function8);
                                        Object objRememberedValue16 = gapComposer7.rememberedValue();
                                        if (zChanged13 || objRememberedValue16 == neverEqualPolicy) {
                                            objRememberedValue16 = new ParserDslKt$$ExternalSyntheticLambda0(function8, (byte) 11);
                                            gapComposer7.updateRememberedValue(objRememberedValue16);
                                        }
                                        CardKt.IconButton((Function0) objRememberedValue16, null, false, null, null, AlbumScreenKt.lambda$895074543, gapComposer7, 1572864, 62);
                                        gapComposer7.end(false);
                                    } else {
                                        gapComposer7.startReplaceGroup(2084544588);
                                        gapComposer7.end(false);
                                    }
                                    break;
                                default:
                                    Composer composer5 = (Composer) obj15;
                                    int iIntValue5 = ((Integer) obj16).intValue();
                                    GapComposer gapComposer8 = (GapComposer) composer5;
                                    if (!gapComposer8.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                        gapComposer8.skipToGroupEnd();
                                    } else if (!StringsKt.isBlank(str9)) {
                                        gapComposer8.startReplaceGroup(-1874867273);
                                        boolean zChanged14 = gapComposer8.changed(function8);
                                        Object objRememberedValue17 = gapComposer8.rememberedValue();
                                        if (zChanged14 || objRememberedValue17 == neverEqualPolicy) {
                                            objRememberedValue17 = new ParserDslKt$$ExternalSyntheticLambda0(function8, (byte) 12);
                                            gapComposer8.updateRememberedValue(objRememberedValue17);
                                        }
                                        CardKt.IconButton((Function0) objRememberedValue17, null, false, null, null, AlbumScreenKt.f321lambda$323710760, gapComposer8, 1572864, 62);
                                        gapComposer8.end(false);
                                    } else {
                                        gapComposer8.startReplaceGroup(-1874671229);
                                        gapComposer8.end(false);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }, gapComposer6), null, null, null, null, true, 0, 0, roundedCornerShapeM185RoundedCornerShape0680j_5, textFieldColorsM347colors0hiis_1, gapComposer6, 920125440, 12582912, 1965112);
                    EnterTransitionImpl enterTransitionImplPlus = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.slideInVertically$default(3, null));
                    ExitTransitionImpl exitTransitionImplPlus = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.slideOutVertically$default(3, null));
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda15 = Expect_jvmKt.rememberComposableLambda(-1292511435, new MainActivity$$ExternalSyntheticLambda7(str8, (byte) 8), gapComposer6);
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, this.f$9, null, enterTransitionImplPlus, exitTransitionImplPlus, null, composableLambdaImplRememberComposableLambda15, gapComposer6, 1600518, 18);
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, str6 != null, null, EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.slideInVertically$default(3, null)), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.slideOutVertically$default(3, null)), null, Expect_jvmKt.rememberComposableLambda(1940139422, new MainActivity$$ExternalSyntheticLambda7(str6, (byte) 9), gapComposer6), gapComposer6, 1600518, 18);
                    boolean z6 = (StringsKt.isBlank(StringsKt.trim(str4).toString()) && StringsKt.isBlank(str7)) ? false : true;
                    boolean z7 = str5.length() == 8;
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, z6 && !z7, null, null, null, null, Expect_jvmKt.rememberComposableLambda(-688954179, new ListenTogetherScreenKt$$ExternalSyntheticLambda72((byte) 0, function5, z6), gapComposer6), gapComposer6, 1572870, 30);
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, z6 && z7, null, null, null, null, Expect_jvmKt.rememberComposableLambda(976919516, new ItemsKt$$ExternalSyntheticLambda5(function6, z6, z7, (byte) 3), gapComposer6), gapComposer6, 1572870, 30);
                    gapComposer6.end(true);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda33(Function0 function0, String str, Function1 function1, BringIntoViewRequesterImpl bringIntoViewRequesterImpl, String str2, Function1 function2, boolean z, String str3, String str4, String str5, Function0 function3, Function0 function4) {
        this.f$4 = function0;
        this.f$8 = str;
        this.f$0 = function1;
        this.f$1 = bringIntoViewRequesterImpl;
        this.f$2 = str2;
        this.f$3 = function2;
        this.f$9 = z;
        this.f$5 = str3;
        this.f$6 = str4;
        this.f$7 = str5;
        this.f$10 = function3;
        this.f$11 = function4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda33(CoroutineScope coroutineScope, State state, MusicDatabase musicDatabase, Song song, Function0 function0, SyncUtils syncUtils, Event event, PlaylistSong playlistSong, String str, boolean z, CachePlaylistViewModel cachePlaylistViewModel, MutableState mutableState) {
        this.f$0 = coroutineScope;
        this.f$1 = state;
        this.f$2 = musicDatabase;
        this.f$3 = song;
        this.f$4 = function0;
        this.f$5 = syncUtils;
        this.f$6 = event;
        this.f$7 = playlistSong;
        this.f$8 = str;
        this.f$9 = z;
        this.f$10 = cachePlaylistViewModel;
        this.f$11 = mutableState;
    }
}
