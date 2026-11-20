package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.navigation.NavHostController;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda37;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Serializable f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ State f$10;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function0 f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ CoroutineScope f$7;
    public final /* synthetic */ State f$8;
    public final /* synthetic */ MusicDatabase f$9;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda17(Context context, MutableState mutableState, MutableState mutableState2, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MusicDatabase musicDatabase, String str, ArrayList arrayList, Function0 function0, Function0 function1, CoroutineScope coroutineScope) {
        this.f$0 = arrayList;
        this.f$7 = coroutineScope;
        this.f$9 = musicDatabase;
        this.f$1 = context;
        this.f$2 = str;
        this.f$4 = function0;
        this.f$3 = function1;
        this.f$5 = mutableState;
        this.f$6 = mutableState2;
        this.f$8 = parcelableSnapshotMutableIntState;
        this.f$10 = parcelableSnapshotMutableIntState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Function0 function0;
        ListBuilder listBuilder;
        GapComposer gapComposer;
        Function0 function1;
        SongEntity songEntity;
        Object queueMenuKt$$ExternalSyntheticLambda23;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        State state = this.f$10;
        Object obj4 = this.f$6;
        Object obj5 = this.f$3;
        Object obj6 = this.f$2;
        Object obj7 = this.f$1;
        Serializable serializable = this.f$0;
        switch (b) {
            case 0:
                MediaMetadata mediaMetadata = (MediaMetadata) serializable;
                MediaMetadata.Album album = mediaMetadata.album;
                List list = (List) obj7;
                NavHostController navHostController = (NavHostController) obj6;
                BottomSheetState bottomSheetState = (BottomSheetState) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z = album != null ? !StringsKt__StringsJVMKt.startsWith(album.id, "MPREb_", false) : false;
                    gapComposer2.startReplaceGroup(-1571652309);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    boolean zIsEmpty = list.isEmpty();
                    Function0 function2 = this.f$4;
                    if (zIsEmpty || z) {
                        function0 = function2;
                        listBuilder = listBuilderCreateListBuilder;
                        gapComposer = gapComposer2;
                        gapComposer.startReplaceGroup(-347016259);
                        gapComposer.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-348630739);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$1044093678;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1266005359;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1487917040, new QueueMenuKt$$ExternalSyntheticLambda22(mediaMetadata, (byte) 1), gapComposer2);
                        boolean zChanged = gapComposer2.changed(mediaMetadata) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(bottomSheetState) | gapComposer2.changed(function2);
                        MutableState mutableState = this.f$5;
                        boolean zChanged2 = zChanged | gapComposer2.changed(mutableState);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                            listBuilder = listBuilderCreateListBuilder;
                            gapComposer = gapComposer2;
                            queueMenuKt$$ExternalSyntheticLambda23 = new QueueMenuKt$$ExternalSyntheticLambda23(mediaMetadata, navHostController, bottomSheetState, function2, mutableState, (byte) 1);
                            function0 = function2;
                            gapComposer.updateRememberedValue(queueMenuKt$$ExternalSyntheticLambda23);
                        } else {
                            queueMenuKt$$ExternalSyntheticLambda23 = objRememberedValue;
                            listBuilder = listBuilderCreateListBuilder;
                            function0 = function2;
                            gapComposer = gapComposer2;
                        }
                        listBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, (Function0) queueMenuKt$$ExternalSyntheticLambda23, null, null, 48));
                        gapComposer.end(false);
                    }
                    if (album != null) {
                        gapComposer.startReplaceGroup(-346904938);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-419466921, new SongMenuKt$$ExternalSyntheticLambda26((byte) 3, z), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1910706280, new SongMenuKt$$ExternalSyntheticLambda26((byte) 4, z), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(893021657, new QueueMenuKt$$ExternalSyntheticLambda22(mediaMetadata, (byte) 2), gapComposer);
                        boolean zChanged3 = gapComposer.changed(z) | gapComposer.changedInstance(navHostController) | gapComposer.changed(mediaMetadata) | gapComposer.changed(bottomSheetState) | gapComposer.changed(function0);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                            Function0 function3 = function0;
                            PlayerKt$$ExternalSyntheticLambda37 playerKt$$ExternalSyntheticLambda37 = new PlayerKt$$ExternalSyntheticLambda37(z, (Object) navHostController, (Object) mediaMetadata, (Object) bottomSheetState, function3, (byte) 1);
                            function1 = function3;
                            gapComposer.updateRememberedValue(playerKt$$ExternalSyntheticLambda37);
                            objRememberedValue2 = playerKt$$ExternalSyntheticLambda37;
                        } else {
                            function1 = function0;
                        }
                        listBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda2, composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, (Function0) objRememberedValue2, null, null, 48));
                        gapComposer.end(false);
                    } else {
                        function1 = function0;
                        gapComposer.startReplaceGroup(-345237603);
                        gapComposer.end(false);
                    }
                    Song song = (Song) state.getValue();
                    boolean z2 = ((song == null || (songEntity = song.song) == null) ? null : songEntity.inLibrary) != null;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(840574697, new SongMenuKt$$ExternalSyntheticLambda26((byte) 5, z2), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(1658470058, new SongMenuKt$$ExternalSyntheticLambda26((byte) 6, z2), gapComposer);
                    boolean zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changed(function1);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(playerConnection, function1, (byte) 19);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    listBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda5, composableLambdaImplRememberComposableLambda6, null, (Function0) objRememberedValue3, null, null, 52));
                    State state2 = this.f$8;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(1567287954, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 9), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda8 = Expect_jvmKt.rememberComposableLambda(1585714707, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 8), gapComposer);
                    CoroutineScope coroutineScope = this.f$7;
                    boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | gapComposer.changed(state2);
                    MusicDatabase musicDatabase = this.f$9;
                    boolean zChangedInstance3 = gapComposer.changedInstance(musicDatabase) | zChangedInstance2 | gapComposer.changed(mediaMetadata) | gapComposer.changed(function1);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope, function1, (Object) musicDatabase, (Object) mediaMetadata, (Object) state2, (byte) 6);
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda40;
                    }
                    listBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda7, composableLambdaImplRememberComposableLambda8, null, (Function0) objRememberedValue4, null, null, 52));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilder);
                    gapComposer.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, 0);
                }
                break;
            default:
                final ArrayList arrayList = (ArrayList) serializable;
                final Context context = (Context) obj7;
                final String str = (String) obj6;
                final Function0 function4 = (Function0) obj5;
                final MutableState mutableState2 = (MutableState) obj4;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.f$8;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) state;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    final MutableState mutableState3 = this.f$5;
                    if (!((Boolean) mutableState3.getValue()).booleanValue()) {
                        gapComposer3.startReplaceGroup(2026443407);
                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                        if (objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 19);
                            gapComposer3.updateRememberedValue(objRememberedValue5);
                        }
                        CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AlbumMenuKt.f37lambda$1001095843, gapComposer3, 805306374, 510);
                        boolean zChangedInstance4 = gapComposer3.changedInstance(arrayList);
                        final CoroutineScope coroutineScope2 = this.f$7;
                        boolean zChangedInstance5 = zChangedInstance4 | gapComposer3.changedInstance(coroutineScope2);
                        final MusicDatabase musicDatabase2 = this.f$9;
                        boolean zChangedInstance6 = zChangedInstance5 | gapComposer3.changedInstance(musicDatabase2) | gapComposer3.changedInstance(context) | gapComposer3.changed(str);
                        final Function0 function5 = this.f$4;
                        boolean zChanged4 = zChangedInstance6 | gapComposer3.changed(function5) | gapComposer3.changed(function4);
                        Object objRememberedValue6 = gapComposer3.rememberedValue();
                        if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                            Function0 function6 = new Function0() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda27
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    ArrayList arrayList2 = arrayList;
                                    parcelableSnapshotMutableIntState.setIntValue(arrayList2.size());
                                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = parcelableSnapshotMutableIntState2;
                                    parcelableSnapshotMutableIntState3.setIntValue(0);
                                    Boolean bool = Boolean.TRUE;
                                    MutableState mutableState4 = mutableState3;
                                    mutableState4.setValue(bool);
                                    List list2 = CollectionsKt.toList(arrayList2);
                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                    AwaitKt.launch$default(coroutineScope2, DefaultIoScheduler.INSTANCE, null, new SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1(list2, parcelableSnapshotMutableIntState3, musicDatabase2, context, str, function5, function4, mutableState4, mutableState2, null), 2);
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer3.updateRememberedValue(function6);
                            objRememberedValue6 = function6;
                        }
                        CardKt.TextButton((Function0) objRememberedValue6, null, false, null, null, null, AlbumMenuKt.lambda$1529284628, gapComposer3, 805306368, 510);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(2028578749);
                        gapComposer3.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda17(MediaMetadata mediaMetadata, List list, NavHostController navHostController, BottomSheetState bottomSheetState, Function0 function0, MutableState mutableState, PlayerConnection playerConnection, CoroutineScope coroutineScope, State state, MusicDatabase musicDatabase, State state2) {
        this.f$0 = mediaMetadata;
        this.f$1 = list;
        this.f$2 = navHostController;
        this.f$3 = bottomSheetState;
        this.f$4 = function0;
        this.f$5 = mutableState;
        this.f$6 = playerConnection;
        this.f$7 = coroutineScope;
        this.f$8 = state;
        this.f$9 = musicDatabase;
        this.f$10 = state2;
    }
}
