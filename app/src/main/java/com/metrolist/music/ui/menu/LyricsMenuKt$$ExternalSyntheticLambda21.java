package com.metrolist.music.ui.menu;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda12;
import com.metrolist.music.viewmodels.SearchSuggestionViewState;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsMenuKt$$ExternalSyntheticLambda21 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ State f$1;
    public final /* synthetic */ State f$10;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ State f$9;

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda21(HapticFeedback hapticFeedback, MenuState menuState, Function0 function0, CoroutineScope coroutineScope, State state, PlayerConnection playerConnection, MutableState mutableState, NavHostController navHostController, boolean z, State state2, State state3) {
        this.f$6 = hapticFeedback;
        this.f$7 = menuState;
        this.f$2 = function0;
        this.f$8 = coroutineScope;
        this.f$1 = state;
        this.f$3 = playerConnection;
        this.f$4 = mutableState;
        this.f$5 = navHostController;
        this.f$0 = z;
        this.f$10 = state2;
        this.f$9 = state3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean zAreEqual;
        MediaMetadata.Album album;
        Object songMenuKt$$ExternalSyntheticLambda40;
        long j;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        State state = this.f$9;
        State state2 = this.f$10;
        boolean z = this.f$0;
        Object obj4 = this.f$5;
        Object obj5 = this.f$3;
        Object obj6 = this.f$8;
        Object obj7 = this.f$7;
        Object obj8 = this.f$6;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                MutableState mutableState = (MutableState) obj4;
                Function0 function0 = (Function0) obj8;
                Function0 function1 = (Function0) obj7;
                Function0 function2 = (Function0) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) state;
                MutableState mutableState2 = (MutableState) state2;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    gapComposer.startReplaceGroup(251358739);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (z) {
                        gapComposer.startReplaceGroup(-132663507);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$542755201;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1445971040;
                        State state3 = this.f$1;
                        boolean zChanged = gapComposer.changed(state3);
                        Function0 function3 = this.f$2;
                        boolean zChanged2 = zChanged | gapComposer.changed(function3) | gapComposer.changedInstance(musicDatabase);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new GapComposer$$ExternalSyntheticLambda0(function3, state3, musicDatabase, (byte) 15);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, Expect_jvmKt.rememberComposableLambda(763867100, new MainActivity$$ExternalSyntheticLambda9(function3, musicDatabase, state3, (byte) 22), gapComposer), 20));
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-128747432);
                        gapComposer.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f73lambda$1246526810;
                    ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$1337768005;
                    ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f196lambda$372904476;
                    MutableState mutableState3 = this.f$4;
                    boolean zChanged3 = gapComposer.changed(mutableState3);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState3, (byte) 22);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5, (Function0) objRememberedValue2, null, Expect_jvmKt.rememberComposableLambda(-1209954623, new SongMenuKt$$ExternalSyntheticLambda37(mutableState3, (byte) 8), gapComposer), 16));
                    ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f56lambda$1113519267;
                    ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f284lambda$97299140;
                    ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$918920987;
                    boolean zChanged4 = gapComposer.changed(mutableState);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 23);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl6, composableLambdaImpl7, composableLambdaImpl8, (Function0) objRememberedValue3, null, Expect_jvmKt.rememberComposableLambda(-327385928, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 9), gapComposer), 16));
                    ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f147lambda$18692834;
                    ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$997527293;
                    boolean zChanged5 = gapComposer.changed(function1) | gapComposer.changed(function0);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new QueueMenuKt$$ExternalSyntheticLambda21(function1, function0, (byte) 3);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue4, null, Expect_jvmKt.rememberComposableLambda(767440505, new MainActivity$$ExternalSyntheticLambda0((byte) 10, parcelableSnapshotMutableIntState), gapComposer), 20));
                    ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$1076133599;
                    ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.lambda$2092353726;
                    boolean zChanged6 = gapComposer.changed(function2) | gapComposer.changedInstance(musicDatabase);
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChanged6 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new GapComposer$$ExternalSyntheticLambda0(function2, mutableState2, musicDatabase, (byte) 16);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl11, composableLambdaImpl12, null, (Function0) objRememberedValue5, null, Expect_jvmKt.rememberComposableLambda(1862266938, new MainActivity$$ExternalSyntheticLambda9(function2, musicDatabase, mutableState2, (byte) 23), gapComposer), 20));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, 0);
                }
                break;
            default:
                HapticFeedback hapticFeedback = (HapticFeedback) obj8;
                MenuState menuState = (MenuState) obj7;
                CoroutineScope coroutineScope = (CoroutineScope) obj6;
                PlayerConnection playerConnection = (PlayerConnection) obj5;
                NavHostController navHostController = (NavHostController) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    YTItem yTItem = ((SearchSuggestionViewState) state2.getValue()).parsedUrlItem;
                    yTItem.getClass();
                    boolean z2 = yTItem instanceof SongItem;
                    State state4 = this.f$1;
                    String str = null;
                    if (z2) {
                        MediaMetadata mediaMetadata = (MediaMetadata) state4.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, ((SongItem) yTItem).id);
                    } else if (yTItem instanceof AlbumItem) {
                        MediaMetadata mediaMetadata2 = (MediaMetadata) state4.getValue();
                        if (mediaMetadata2 != null && (album = mediaMetadata2.album) != null) {
                            str = album.id;
                        }
                        zAreEqual = Intrinsics.areEqual(str, ((AlbumItem) yTItem).id);
                    } else if (yTItem instanceof EpisodeItem) {
                        MediaMetadata mediaMetadata3 = (MediaMetadata) state4.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata3 != null ? mediaMetadata3.id : null, ((EpisodeItem) yTItem).id);
                    } else {
                        zAreEqual = false;
                    }
                    boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance = gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(yTItem);
                    Function0 function4 = this.f$2;
                    boolean zChanged7 = zChangedInstance | gapComposer2.changed(function4) | gapComposer2.changedInstance(coroutineScope);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (zChanged7 || objRememberedValue6 == neverEqualPolicy) {
                        songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(hapticFeedback, menuState, yTItem, function4, coroutineScope, (byte) 27);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                    } else {
                        songMenuKt$$ExternalSyntheticLambda40 = objRememberedValue6;
                    }
                    Function0 function5 = (Function0) songMenuKt$$ExternalSyntheticLambda40;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(r18) | gapComposer2.changed(state4) | gapComposer2.changedInstance(playerConnection);
                    MutableState mutableState4 = this.f$4;
                    boolean zChanged8 = zChangedInstance2 | gapComposer2.changed(mutableState4) | gapComposer2.changed(function4) | gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue7 = gapComposer2.rememberedValue();
                    if (zChanged8 || objRememberedValue7 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(r18, (Object) playerConnection, (Object) function4, (Object) navHostController, state4, mutableState4, (byte) 14);
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                        objRememberedValue7 = songMenuKt$$ExternalSyntheticLambda73;
                    }
                    Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(Modifier.Companion.$$INSTANCE, false, function5, (Function0) objRememberedValue7, 239);
                    if (z) {
                        gapComposer2.startReplaceGroup(1167411552);
                        gapComposer2.end(false);
                        j = -72057594037927936L;
                    } else {
                        gapComposer2.startReplaceGroup(1167412741);
                        j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        gapComposer2.end(false);
                    }
                    MenuKt.YouTubeListItem(yTItem, ImageKt.m39backgroundbw27NRU(modifierM48combinedClickablehoGz1lA$default, j, ColorKt.RectangleShape), false, zAreEqual, zBooleanValue, false, null, Expect_jvmKt.rememberComposableLambda(68019508, new OnlineSearchScreenKt$$ExternalSyntheticLambda12(menuState, r18, function4, coroutineScope), gapComposer2), null, gapComposer2, 100663296, 716);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda21(boolean z, State state, Function0 function0, MusicDatabase musicDatabase, MutableState mutableState, MutableState mutableState2, Function0 function1, Function0 function2, Function0 function3, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState3) {
        this.f$0 = z;
        this.f$1 = state;
        this.f$2 = function0;
        this.f$3 = musicDatabase;
        this.f$4 = mutableState;
        this.f$5 = mutableState2;
        this.f$6 = function1;
        this.f$7 = function2;
        this.f$8 = function3;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$10 = mutableState3;
    }
}
