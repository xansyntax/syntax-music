package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import coil3.util.FileSystemsKt;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda59 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ HapticFeedback f$3;
    public final /* synthetic */ MenuState f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ State f$6;
    public final /* synthetic */ PlayerConnection f$7;
    public final /* synthetic */ MutableState f$8;
    public final /* synthetic */ State f$9;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda59(ArrayList arrayList, HomeSection.HomePageSection homePageSection, float f, HapticFeedback hapticFeedback, MenuState menuState, boolean z, PlayerConnection playerConnection, MutableState mutableState, State state, State state2) {
        this.$r8$classId = (byte) 2;
        this.f$0 = arrayList;
        this.f$1 = homePageSection;
        this.f$2 = f;
        this.f$3 = hapticFeedback;
        this.f$4 = menuState;
        this.f$5 = z;
        this.f$7 = playerConnection;
        this.f$8 = mutableState;
        this.f$6 = state;
        this.f$9 = state2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        int i = 0;
        List list = this.f$0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        switch (b) {
            case 0:
                final MusicDatabase musicDatabase = (MusicDatabase) obj2;
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                HashSet hashSet = new HashSet();
                final ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (hashSet.add(((Song) obj3).song.id)) {
                        arrayList.add(obj3);
                    }
                }
                QueueKt$$ExternalSyntheticLambda4 queueKt$$ExternalSyntheticLambda4 = new QueueKt$$ExternalSyntheticLambda4((byte) 22);
                int size = arrayList.size();
                StatsScreenKt$StatsScreen$6$1$1$10$2$1$1 statsScreenKt$StatsScreen$6$1$1$10$2$1$1 = new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(queueKt$$ExternalSyntheticLambda4, arrayList, (byte) 9);
                AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass3 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 16);
                final byte b2 = 0;
                final float f = this.f$2;
                final HapticFeedback hapticFeedback = this.f$3;
                final MenuState menuState = this.f$4;
                final boolean z = this.f$5;
                final State state = this.f$6;
                final PlayerConnection playerConnection = this.f$7;
                final MutableState mutableState = this.f$8;
                final State state2 = this.f$9;
                lazyGridIntervalContent.items(size, statsScreenKt$StatsScreen$6$1$1$10$2$1$1, null, anonymousClass3, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$8$13$1$0$0$$inlined$items$default$5
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                        int i2;
                        MutableState mutableState2;
                        int i3;
                        MutableState mutableState3;
                        byte b3 = b2;
                        MutableState mutableState4 = mutableState;
                        boolean z2 = z;
                        float f2 = f;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        State state3 = state2;
                        MusicDatabase musicDatabase2 = musicDatabase;
                        List list2 = arrayList;
                        MenuState menuState2 = menuState;
                        State state4 = state;
                        HapticFeedback hapticFeedback2 = hapticFeedback;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        switch (b3) {
                            case 0:
                                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj4;
                                int iIntValue = ((Number) obj5).intValue();
                                Composer composer = (Composer) obj6;
                                int iIntValue2 = ((Number) obj7).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i2 = iIntValue2 | (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2);
                                } else {
                                    i2 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i2 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                                }
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                                    Song song = (Song) ((ArrayList) list2).get(iIntValue);
                                    gapComposer.startReplaceGroup(2069004218);
                                    final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase2.$$delegate_0.song(song.song.id), song, gapComposer, 0);
                                    Song song2 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                                    song2.getClass();
                                    Song song3 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                                    song3.getClass();
                                    String str = song3.song.id;
                                    MediaMetadata mediaMetadata = (MediaMetadata) state4.getValue();
                                    boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                                    boolean zBooleanValue = ((Boolean) state3.getValue()).booleanValue();
                                    Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(companion, f2);
                                    boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback2) | gapComposer.changed(menuState2) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(hapticFeedback2, menuState2, mutableStateCollectAsStateWithLifecycle, (byte) 1);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    Function0 function0 = (Function0) objRememberedValue;
                                    boolean zChanged = gapComposer.changed(z2) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(state4);
                                    final PlayerConnection playerConnection2 = playerConnection;
                                    boolean zChanged2 = gapComposer.changed(mutableState4) | zChanged | gapComposer.changedInstance(playerConnection2);
                                    Object objRememberedValue2 = gapComposer.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        final State state5 = state;
                                        final MutableState mutableState5 = mutableState;
                                        final boolean z3 = z;
                                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$14$2$1$1$3$2$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Queue listQueue;
                                                if (!z3) {
                                                    List list3 = HomeScreenKt.DailyDiscoverMessages;
                                                    MutableState mutableState6 = mutableStateCollectAsStateWithLifecycle;
                                                    Song song4 = (Song) mutableState6.getValue();
                                                    song4.getClass();
                                                    String str2 = song4.song.id;
                                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state5.getValue();
                                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                                    PlayerConnection playerConnection3 = playerConnection2;
                                                    if (zAreEqual2) {
                                                        playerConnection3.togglePlayPause();
                                                    } else {
                                                        if (((Boolean) mutableState5.getValue()).booleanValue()) {
                                                            YouTubeQueue.Companion companion2 = YouTubeQueue.INSTANCE;
                                                            Song song5 = (Song) mutableState6.getValue();
                                                            song5.getClass();
                                                            listQueue = companion2.radio(HexFormatKt.toMediaMetadata(song5));
                                                        } else {
                                                            Song song6 = (Song) mutableState6.getValue();
                                                            song6.getClass();
                                                            String str3 = song6.song.title;
                                                            Song song7 = (Song) mutableState6.getValue();
                                                            song7.getClass();
                                                            listQueue = new ListQueue(str3, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song7))), 0, 0L, 12, null);
                                                        }
                                                        playerConnection3.playQueue(listQueue);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        mutableState2 = mutableStateCollectAsStateWithLifecycle;
                                        gapComposer.updateRememberedValue(objRememberedValue2);
                                    } else {
                                        mutableState2 = mutableStateCollectAsStateWithLifecycle;
                                    }
                                    MenuKt.SongListItem(song2, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs, false, function0, (Function0) objRememberedValue2, 239), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(-12674083, new AccountScreenKt$AccountScreen$1$1$5$1$1$1((Object) hapticFeedback2, menuState2, mutableState2, (byte) 1), gapComposer), null, gapComposer, 24576, 432, 8684);
                                    gapComposer.end(false);
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                break;
                            default:
                                LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj4;
                                int iIntValue3 = ((Number) obj5).intValue();
                                Composer composer2 = (Composer) obj6;
                                int iIntValue4 = ((Number) obj7).intValue();
                                if ((iIntValue4 & 6) == 0) {
                                    i3 = iIntValue4 | (((GapComposer) composer2).changed(lazyGridItemScopeImpl2) ? 4 : 2);
                                } else {
                                    i3 = iIntValue4;
                                }
                                if ((iIntValue4 & 48) == 0) {
                                    i3 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                                }
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                    Song song4 = (Song) list2.get(iIntValue3);
                                    gapComposer2.startReplaceGroup(1156439723);
                                    final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase2.$$delegate_0.song(song4.song.id), song4, gapComposer2, 0);
                                    Song song5 = (Song) mutableStateCollectAsStateWithLifecycle2.getValue();
                                    song5.getClass();
                                    Song song6 = (Song) mutableStateCollectAsStateWithLifecycle2.getValue();
                                    song6.getClass();
                                    String str2 = song6.song.id;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state4.getValue();
                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                    boolean zBooleanValue2 = ((Boolean) state3.getValue()).booleanValue();
                                    int i4 = iIntValue3 + 1;
                                    Modifier modifierM155width3ABfNKs2 = SizeKt.m155width3ABfNKs(companion, f2);
                                    boolean zChangedInstance2 = gapComposer2.changedInstance(hapticFeedback2) | gapComposer2.changed(menuState2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2);
                                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                                        objRememberedValue3 = new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(hapticFeedback2, menuState2, mutableStateCollectAsStateWithLifecycle2, (byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue3);
                                    }
                                    Function0 function1 = (Function0) objRememberedValue3;
                                    boolean zChanged3 = gapComposer2.changed(z2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(state4);
                                    final PlayerConnection playerConnection3 = playerConnection;
                                    boolean zChanged4 = gapComposer2.changed(mutableState4) | zChanged3 | gapComposer2.changedInstance(playerConnection3);
                                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                        final State state6 = state;
                                        final MutableState mutableState6 = mutableState;
                                        final boolean z4 = z;
                                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$2$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Queue listQueue;
                                                if (!z4) {
                                                    List list3 = HomeScreenKt.DailyDiscoverMessages;
                                                    MutableState mutableState7 = mutableStateCollectAsStateWithLifecycle2;
                                                    Song song7 = (Song) mutableState7.getValue();
                                                    song7.getClass();
                                                    String str3 = song7.song.id;
                                                    MediaMetadata mediaMetadata3 = (MediaMetadata) state6.getValue();
                                                    boolean zAreEqual3 = Intrinsics.areEqual(str3, mediaMetadata3 != null ? mediaMetadata3.id : null);
                                                    PlayerConnection playerConnection4 = playerConnection3;
                                                    if (zAreEqual3) {
                                                        playerConnection4.togglePlayPause();
                                                    } else {
                                                        if (((Boolean) mutableState6.getValue()).booleanValue()) {
                                                            YouTubeQueue.Companion companion2 = YouTubeQueue.INSTANCE;
                                                            Song song8 = (Song) mutableState7.getValue();
                                                            song8.getClass();
                                                            listQueue = companion2.radio(HexFormatKt.toMediaMetadata(song8));
                                                        } else {
                                                            Song song9 = (Song) mutableState7.getValue();
                                                            song9.getClass();
                                                            String str4 = song9.song.title;
                                                            Song song10 = (Song) mutableState7.getValue();
                                                            song10.getClass();
                                                            listQueue = new ListQueue(str4, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song10))), 0, 0L, 12, null);
                                                        }
                                                        playerConnection4.playQueue(listQueue);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        mutableState3 = mutableStateCollectAsStateWithLifecycle2;
                                        gapComposer2.updateRememberedValue(objRememberedValue4);
                                    } else {
                                        mutableState3 = mutableStateCollectAsStateWithLifecycle2;
                                    }
                                    MenuKt.SongListItem(song5, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs2, false, function1, (Function0) objRememberedValue4, 239), null, false, true, false, null, null, zAreEqual2, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(1891080788, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState2, mutableState3, (byte) 0), gapComposer2), Integer.valueOf(i4), gapComposer2, 24576, 432, 492);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
            case 1:
                final MusicDatabase musicDatabase2 = (MusicDatabase) obj2;
                LazyGridIntervalContent lazyGridIntervalContent2 = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent2.getClass();
                HomeScreenKt$$ExternalSyntheticLambda97 homeScreenKt$$ExternalSyntheticLambda97 = new HomeScreenKt$$ExternalSyntheticLambda97((byte) 0);
                final List list2 = this.f$0;
                int size2 = list2.size();
                StatsScreenKt$StatsScreen$6$1$1$10$2$1$1 statsScreenKt$StatsScreen$6$1$1$10$2$1$2 = new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(homeScreenKt$$ExternalSyntheticLambda97, list2, (byte) 14);
                SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 22);
                final byte b3 = 1;
                final float f2 = this.f$2;
                final HapticFeedback hapticFeedback2 = this.f$3;
                final MenuState menuState2 = this.f$4;
                final boolean z2 = this.f$5;
                final State state3 = this.f$6;
                final PlayerConnection playerConnection2 = this.f$7;
                final MutableState mutableState2 = this.f$8;
                final State state4 = this.f$9;
                lazyGridIntervalContent2.items(size2, statsScreenKt$StatsScreen$6$1$1$10$2$1$2, null, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, -1942245546, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$8$13$1$0$0$$inlined$items$default$5
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                        int i2;
                        MutableState mutableState3;
                        int i3;
                        MutableState mutableState4;
                        byte b4 = b3;
                        MutableState mutableState5 = mutableState2;
                        boolean z3 = z2;
                        float f3 = f2;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        State state5 = state4;
                        MusicDatabase musicDatabase3 = musicDatabase2;
                        List list3 = list2;
                        MenuState menuState3 = menuState2;
                        State state6 = state3;
                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        switch (b4) {
                            case 0:
                                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj4;
                                int iIntValue = ((Number) obj5).intValue();
                                Composer composer = (Composer) obj6;
                                int iIntValue2 = ((Number) obj7).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i2 = iIntValue2 | (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2);
                                } else {
                                    i2 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i2 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                                }
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                                    Song song = (Song) ((ArrayList) list3).get(iIntValue);
                                    gapComposer.startReplaceGroup(2069004218);
                                    final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase3.$$delegate_0.song(song.song.id), song, gapComposer, 0);
                                    Song song2 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                                    song2.getClass();
                                    Song song3 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                                    song3.getClass();
                                    String str = song3.song.id;
                                    MediaMetadata mediaMetadata = (MediaMetadata) state6.getValue();
                                    boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                                    boolean zBooleanValue = ((Boolean) state5.getValue()).booleanValue();
                                    Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(companion, f3);
                                    boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback3) | gapComposer.changed(menuState3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(hapticFeedback3, menuState3, mutableStateCollectAsStateWithLifecycle, (byte) 1);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    Function0 function0 = (Function0) objRememberedValue;
                                    boolean zChanged = gapComposer.changed(z3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(state6);
                                    final PlayerConnection playerConnection3 = playerConnection2;
                                    boolean zChanged2 = gapComposer.changed(mutableState5) | zChanged | gapComposer.changedInstance(playerConnection3);
                                    Object objRememberedValue2 = gapComposer.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        final State state7 = state3;
                                        final MutableState mutableState6 = mutableState2;
                                        final boolean z4 = z2;
                                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$14$2$1$1$3$2$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Queue listQueue;
                                                if (!z4) {
                                                    List list4 = HomeScreenKt.DailyDiscoverMessages;
                                                    MutableState mutableState7 = mutableStateCollectAsStateWithLifecycle;
                                                    Song song4 = (Song) mutableState7.getValue();
                                                    song4.getClass();
                                                    String str2 = song4.song.id;
                                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state7.getValue();
                                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                                    PlayerConnection playerConnection4 = playerConnection3;
                                                    if (zAreEqual2) {
                                                        playerConnection4.togglePlayPause();
                                                    } else {
                                                        if (((Boolean) mutableState6.getValue()).booleanValue()) {
                                                            YouTubeQueue.Companion companion2 = YouTubeQueue.INSTANCE;
                                                            Song song5 = (Song) mutableState7.getValue();
                                                            song5.getClass();
                                                            listQueue = companion2.radio(HexFormatKt.toMediaMetadata(song5));
                                                        } else {
                                                            Song song6 = (Song) mutableState7.getValue();
                                                            song6.getClass();
                                                            String str3 = song6.song.title;
                                                            Song song7 = (Song) mutableState7.getValue();
                                                            song7.getClass();
                                                            listQueue = new ListQueue(str3, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song7))), 0, 0L, 12, null);
                                                        }
                                                        playerConnection4.playQueue(listQueue);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        mutableState3 = mutableStateCollectAsStateWithLifecycle;
                                        gapComposer.updateRememberedValue(objRememberedValue2);
                                    } else {
                                        mutableState3 = mutableStateCollectAsStateWithLifecycle;
                                    }
                                    MenuKt.SongListItem(song2, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs, false, function0, (Function0) objRememberedValue2, 239), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(-12674083, new AccountScreenKt$AccountScreen$1$1$5$1$1$1((Object) hapticFeedback3, menuState3, mutableState3, (byte) 1), gapComposer), null, gapComposer, 24576, 432, 8684);
                                    gapComposer.end(false);
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                break;
                            default:
                                LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj4;
                                int iIntValue3 = ((Number) obj5).intValue();
                                Composer composer2 = (Composer) obj6;
                                int iIntValue4 = ((Number) obj7).intValue();
                                if ((iIntValue4 & 6) == 0) {
                                    i3 = iIntValue4 | (((GapComposer) composer2).changed(lazyGridItemScopeImpl2) ? 4 : 2);
                                } else {
                                    i3 = iIntValue4;
                                }
                                if ((iIntValue4 & 48) == 0) {
                                    i3 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                                }
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                    Song song4 = (Song) list3.get(iIntValue3);
                                    gapComposer2.startReplaceGroup(1156439723);
                                    final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase3.$$delegate_0.song(song4.song.id), song4, gapComposer2, 0);
                                    Song song5 = (Song) mutableStateCollectAsStateWithLifecycle2.getValue();
                                    song5.getClass();
                                    Song song6 = (Song) mutableStateCollectAsStateWithLifecycle2.getValue();
                                    song6.getClass();
                                    String str2 = song6.song.id;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state6.getValue();
                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                    boolean zBooleanValue2 = ((Boolean) state5.getValue()).booleanValue();
                                    int i4 = iIntValue3 + 1;
                                    Modifier modifierM155width3ABfNKs2 = SizeKt.m155width3ABfNKs(companion, f3);
                                    boolean zChangedInstance2 = gapComposer2.changedInstance(hapticFeedback3) | gapComposer2.changed(menuState3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2);
                                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                                        objRememberedValue3 = new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(hapticFeedback3, menuState3, mutableStateCollectAsStateWithLifecycle2, (byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue3);
                                    }
                                    Function0 function1 = (Function0) objRememberedValue3;
                                    boolean zChanged3 = gapComposer2.changed(z3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(state6);
                                    final PlayerConnection playerConnection4 = playerConnection2;
                                    boolean zChanged4 = gapComposer2.changed(mutableState5) | zChanged3 | gapComposer2.changedInstance(playerConnection4);
                                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                        final State state8 = state3;
                                        final MutableState mutableState7 = mutableState2;
                                        final boolean z5 = z2;
                                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$2$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Queue listQueue;
                                                if (!z5) {
                                                    List list4 = HomeScreenKt.DailyDiscoverMessages;
                                                    MutableState mutableState8 = mutableStateCollectAsStateWithLifecycle2;
                                                    Song song7 = (Song) mutableState8.getValue();
                                                    song7.getClass();
                                                    String str3 = song7.song.id;
                                                    MediaMetadata mediaMetadata3 = (MediaMetadata) state8.getValue();
                                                    boolean zAreEqual3 = Intrinsics.areEqual(str3, mediaMetadata3 != null ? mediaMetadata3.id : null);
                                                    PlayerConnection playerConnection5 = playerConnection4;
                                                    if (zAreEqual3) {
                                                        playerConnection5.togglePlayPause();
                                                    } else {
                                                        if (((Boolean) mutableState7.getValue()).booleanValue()) {
                                                            YouTubeQueue.Companion companion2 = YouTubeQueue.INSTANCE;
                                                            Song song8 = (Song) mutableState8.getValue();
                                                            song8.getClass();
                                                            listQueue = companion2.radio(HexFormatKt.toMediaMetadata(song8));
                                                        } else {
                                                            Song song9 = (Song) mutableState8.getValue();
                                                            song9.getClass();
                                                            String str4 = song9.song.title;
                                                            Song song10 = (Song) mutableState8.getValue();
                                                            song10.getClass();
                                                            listQueue = new ListQueue(str4, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song10))), 0, 0L, 12, null);
                                                        }
                                                        playerConnection5.playQueue(listQueue);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        mutableState4 = mutableStateCollectAsStateWithLifecycle2;
                                        gapComposer2.updateRememberedValue(objRememberedValue4);
                                    } else {
                                        mutableState4 = mutableStateCollectAsStateWithLifecycle2;
                                    }
                                    MenuKt.SongListItem(song5, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs2, false, function1, (Function0) objRememberedValue4, 239), null, false, true, false, null, null, zAreEqual2, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(1891080788, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState3, mutableState4, (byte) 0), gapComposer2), Integer.valueOf(i4), gapComposer2, 24576, 432, 492);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
            default:
                ArrayList arrayList2 = (ArrayList) list;
                HomeSection.HomePageSection homePageSection = (HomeSection.HomePageSection) obj2;
                LazyGridIntervalContent lazyGridIntervalContent3 = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent3.getClass();
                HashSet hashSet2 = new HashSet();
                final ArrayList arrayList3 = new ArrayList();
                int size3 = arrayList2.size();
                while (i < size3) {
                    Object obj4 = arrayList2.get(i);
                    i++;
                    if (hashSet2.add(((SongItem) obj4).id)) {
                        arrayList3.add(obj4);
                    }
                }
                HomeScreenKt$$ExternalSyntheticLambda104 homeScreenKt$$ExternalSyntheticLambda104 = new HomeScreenKt$$ExternalSyntheticLambda104(homePageSection, (byte) 1);
                int size4 = arrayList3.size();
                StatsScreenKt$StatsScreen$6$1$1$10$2$1$1 statsScreenKt$StatsScreen$6$1$1$10$2$1$3 = new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(homeScreenKt$$ExternalSyntheticLambda104, arrayList3, (byte) 11);
                AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass4 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList3, (byte) 18);
                final float f3 = this.f$2;
                final HapticFeedback hapticFeedback3 = this.f$3;
                final MenuState menuState3 = this.f$4;
                final boolean z3 = this.f$5;
                final PlayerConnection playerConnection3 = this.f$7;
                final MutableState mutableState3 = this.f$8;
                final State state5 = this.f$6;
                final State state6 = this.f$9;
                lazyGridIntervalContent3.items(size4, statsScreenKt$StatsScreen$6$1$1$10$2$1$3, null, anonymousClass4, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$8$15$2$1$0$$inlined$items$default$5
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                        int i2;
                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj5;
                        int iIntValue = ((Number) obj6).intValue();
                        Composer composer = (Composer) obj7;
                        int iIntValue2 = ((Number) obj8).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i2 = (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i2 = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i2 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                        }
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                            final SongItem songItem = (SongItem) arrayList3.get(iIntValue);
                            gapComposer.startReplaceGroup(-1562974714);
                            String str = songItem.id;
                            MediaMetadata mediaMetadata = (MediaMetadata) state5.getValue();
                            boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                            boolean zBooleanValue = ((Boolean) state6.getValue()).booleanValue();
                            Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(Modifier.Companion.$$INSTANCE, f3);
                            HapticFeedback hapticFeedback4 = hapticFeedback3;
                            boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback4);
                            MenuState menuState4 = menuState3;
                            boolean zChanged = zChangedInstance | gapComposer.changed(menuState4) | gapComposer.changedInstance(songItem);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new ChartsScreenKt$ChartsScreen$3$1$1$1$4$1$1$1$3$1$1(hapticFeedback4, menuState4, songItem, (byte) 2);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            final boolean z4 = z3;
                            boolean zChanged2 = gapComposer.changed(z4);
                            final PlayerConnection playerConnection4 = playerConnection3;
                            boolean zChangedInstance2 = zChanged2 | gapComposer.changedInstance(playerConnection4);
                            final MutableState mutableState4 = mutableState3;
                            boolean zChanged3 = zChangedInstance2 | gapComposer.changed(mutableState4) | gapComposer.changedInstance(songItem);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$2$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Queue listQueue;
                                        if (!z4) {
                                            boolean zBooleanValue2 = ((Boolean) mutableState4.getValue()).booleanValue();
                                            SongItem songItem2 = songItem;
                                            if (zBooleanValue2) {
                                                WatchEndpoint watchEndpoint = songItem2.endpoint;
                                                if (watchEndpoint == null) {
                                                    watchEndpoint = new WatchEndpoint(62, songItem2.id, null, null);
                                                }
                                                listQueue = new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem2));
                                            } else {
                                                listQueue = new ListQueue(songItem2.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem2))), 0, 0L, 12, null);
                                            }
                                            playerConnection4.playQueue(listQueue);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            MenuKt.YouTubeListItem(songItem, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs, false, function0, (Function0) objRememberedValue2, 239), false, zAreEqual, zBooleanValue, false, null, Expect_jvmKt.rememberComposableLambda(-1170332196, new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(menuState4, songItem, (byte) 0), gapComposer), null, gapComposer, 102236160, 652);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
        }
        return unit;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda59(List list, MusicDatabase musicDatabase, float f, HapticFeedback hapticFeedback, MenuState menuState, boolean z, State state, PlayerConnection playerConnection, MutableState mutableState, State state2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = musicDatabase;
        this.f$2 = f;
        this.f$3 = hapticFeedback;
        this.f$4 = menuState;
        this.f$5 = z;
        this.f$6 = state;
        this.f$7 = playerConnection;
        this.f$8 = mutableState;
        this.f$9 = state2;
    }
}
