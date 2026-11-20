package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
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
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6;
import com.metrolist.music.viewmodels.DateAgo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3 implements Function4 {
    public final /* synthetic */ Object $dateAgo$inlined;
    public final /* synthetic */ Object $dateEvents$inlined;
    public final /* synthetic */ HapticFeedback $haptic$inlined;
    public final /* synthetic */ Object $inSelectMode$delegate$inlined;
    public final /* synthetic */ State $isPlaying$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ State $mediaMetadata$delegate$inlined;
    public final /* synthetic */ MenuState $menuState$inlined;
    public final /* synthetic */ PlayerConnection $playerConnection$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection$inlined;

    public HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(List list, List list2, DateAgo dateAgo, MutableState mutableState, HapticFeedback hapticFeedback, State state, PlayerConnection playerConnection, List list3, State state2, MenuState menuState) {
        this.$r8$classId = (byte) 0;
        this.$items = list;
        this.$selection$inlined = list2;
        this.$dateAgo$inlined = dateAgo;
        this.$inSelectMode$delegate$inlined = mutableState;
        this.$haptic$inlined = hapticFeedback;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$dateEvents$inlined = list3;
        this.$isPlaying$delegate$inlined = state2;
        this.$menuState$inlined = menuState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        Object obj5;
        Object obj6;
        Function0 function0;
        final Function1 function1;
        EventWithSong eventWithSong;
        int i2;
        boolean z;
        MediaMetadata.Album album;
        MenuState menuState;
        Object obj7;
        int i3;
        GapComposer gapComposer;
        boolean z2;
        MediaMetadata.Album album2;
        boolean z3;
        byte b = this.$r8$classId;
        List list = this.$items;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj8 = this.$dateAgo$inlined;
        State state = this.$mediaMetadata$delegate$inlined;
        State state2 = this.$isPlaying$delegate$inlined;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj9 = this.$dateEvents$inlined;
        final byte b2 = 1;
        Object obj10 = this.$inSelectMode$delegate$inlined;
        switch (b) {
            case 0:
                final List list2 = (List) obj9;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                final int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                DateAgo dateAgo = (DateAgo) obj8;
                MutableState mutableState = (MutableState) obj10;
                if ((iIntValue2 & 6) == 0) {
                    i = iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2);
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(i & 1, (i & 147) != 146)) {
                    final EventWithSong eventWithSong2 = (EventWithSong) list.get(iIntValue);
                    gapComposer2.startReplaceGroup(-933525363);
                    List list3 = this.$selection$inlined;
                    boolean zChangedInstance = gapComposer2.changedInstance(list3) | gapComposer2.changed(eventWithSong2);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        StatsScreenKt$StatsScreen$6$1$1$10$2$1$1 statsScreenKt$StatsScreen$6$1$1$10$2$1$1 = new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(list3, eventWithSong2, (byte) 1);
                        gapComposer2.updateRememberedValue(statsScreenKt$StatsScreen$6$1$1$10$2$1$1);
                        obj5 = statsScreenKt$StatsScreen$6$1$1$10$2$1$1;
                    } else {
                        obj5 = objRememberedValue;
                    }
                    Function1 function2 = (Function1) obj5;
                    dateAgo.getClass();
                    final String strHistoryScreen$dateAgoToString = AlbumScreenKt.HistoryScreen$dateAgoToString(dateAgo, gapComposer2);
                    Song song = eventWithSong2.song;
                    String str = song.song.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                    boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) state2.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged = gapComposer2.changed(mutableState);
                    HapticFeedback hapticFeedback = this.$haptic$inlined;
                    boolean zChangedInstance2 = zChanged | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(function2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    Object obj11 = objRememberedValue2;
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        AlbumScreenKt$AlbumScreen$3$1$4$1$1 albumScreenKt$AlbumScreen$3$1$4$1$1 = new AlbumScreenKt$AlbumScreen$3$1$4$1$1(hapticFeedback, function2, mutableState, (byte) 2);
                        gapComposer2.updateRememberedValue(albumScreenKt$AlbumScreen$3$1$4$1$1);
                        obj11 = albumScreenKt$AlbumScreen$3$1$4$1$1;
                    }
                    Function0 function3 = (Function0) obj11;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(list3) | gapComposer2.changed(mutableState) | gapComposer2.changed(function2) | gapComposer2.changed(eventWithSong2) | gapComposer2.changed(state);
                    final PlayerConnection playerConnection = this.$playerConnection$inlined;
                    boolean zChangedInstance4 = zChangedInstance3 | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(strHistoryScreen$dateAgoToString) | gapComposer2.changedInstance(list2) | ((((i & 112) ^ 48) > 32 && gapComposer2.changed(iIntValue)) || (i & 48) == 32);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue3 == neverEqualPolicy) {
                        final MutableState mutableState2 = (MutableState) obj10;
                        final State state3 = this.$mediaMetadata$delegate$inlined;
                        final List list4 = this.$selection$inlined;
                        function0 = function3;
                        function1 = function2;
                        obj6 = new Function0() { // from class: com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$3$4$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean zHistoryScreen$lambda$4 = AlbumScreenKt.HistoryScreen$lambda$4(mutableState2);
                                EventWithSong eventWithSong3 = eventWithSong2;
                                if (zHistoryScreen$lambda$4) {
                                    function1.invoke(Boolean.valueOf(!list4.contains(Long.valueOf(eventWithSong3.event.id))));
                                } else {
                                    String str2 = eventWithSong3.song.song.id;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state3.getValue();
                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                    PlayerConnection playerConnection2 = playerConnection;
                                    if (zAreEqual2) {
                                        playerConnection2.togglePlayPause();
                                    } else {
                                        List list5 = list2;
                                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                                        Iterator it = list5.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((EventWithSong) it.next()).song)));
                                        }
                                        playerConnection2.playQueue(new ListQueue(strHistoryScreen$dateAgoToString, arrayList, iIntValue, 0L, 8, null));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        eventWithSong = eventWithSong2;
                        gapComposer2.updateRememberedValue(obj6);
                    } else {
                        eventWithSong = eventWithSong2;
                        obj6 = objRememberedValue3;
                        function0 = function3;
                        function1 = function2;
                    }
                    MenuKt.SongListItem(song, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) obj6, 239)), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(-930770092, new HistoryScreenKt$HistoryScreen$4$1$1$3$4$3(this.$selection$inlined, eventWithSong, function1, this.$menuState$inlined, (MutableState) obj10, (byte) 0), gapComposer2), null, gapComposer2, 24576, 384, 10732);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                NavHostController navHostController = (NavHostController) obj8;
                final CoroutineScope coroutineScope = (CoroutineScope) obj9;
                if ((iIntValue4 & 6) == 0) {
                    i2 = iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2);
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    final LocalItem localItem = (LocalItem) list.get(iIntValue3);
                    gapComposer3.startReplaceGroup(1992477469);
                    if (localItem != null) {
                        boolean z4 = localItem instanceof Playlist;
                        final HapticFeedback hapticFeedback2 = this.$haptic$inlined;
                        final MenuState menuState2 = this.$menuState$inlined;
                        if (z4) {
                            gapComposer3.startReplaceGroup(1992299218);
                            Playlist playlist = (Playlist) localItem;
                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                            boolean zChangedInstance5 = gapComposer3.changedInstance(hapticFeedback2) | gapComposer3.changed(menuState2) | gapComposer3.changedInstance(localItem) | gapComposer3.changedInstance(coroutineScope);
                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                            if (zChangedInstance5 || objRememberedValue4 == neverEqualPolicy) {
                                final byte b3 = 0;
                                objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b4 = b3;
                                        Unit unit = Unit.INSTANCE;
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        LocalItem localItem2 = localItem;
                                        MenuState menuState3 = menuState2;
                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                        byte b5 = 1;
                                        switch (b4) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 656570041, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, b5)));
                                                break;
                                            case 1:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 860734554, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 3)));
                                                break;
                                            case 2:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 859505286, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 6)));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 1192272517, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 7)));
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                menuState = menuState2;
                                gapComposer3.updateRememberedValue(objRememberedValue4);
                            } else {
                                menuState = menuState2;
                            }
                            Function0 function4 = (Function0) objRememberedValue4;
                            boolean zChangedInstance6 = gapComposer3.changedInstance(localItem) | gapComposer3.changedInstance(navHostController);
                            Object objRememberedValue5 = gapComposer3.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue5 == neverEqualPolicy) {
                                z = false;
                                LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1 libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(localItem, navHostController, (byte) 0);
                                gapComposer3.updateRememberedValue(libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1);
                                obj7 = libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1;
                            } else {
                                z = false;
                                obj7 = objRememberedValue5;
                            }
                            MenuKt.PlaylistListItem(playlist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, z, function4, (Function0) obj7, 239)), false, null, Expect_jvmKt.rememberComposableLambda(-614207462, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(menuState, localItem, coroutineScope, z ? (byte) 1 : (byte) 0), gapComposer3), gapComposer3, 24576, 12);
                            gapComposer3.end(z);
                        } else if (localItem instanceof Song) {
                            gapComposer3.startReplaceGroup(1995316665);
                            Song song2 = (Song) localItem;
                            String str2 = song2.song.id;
                            MediaMetadata mediaMetadata2 = (MediaMetadata) state.getValue();
                            boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                            boolean zBooleanValue2 = ((Boolean) state2.getValue()).booleanValue();
                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                            boolean zChangedInstance7 = gapComposer3.changedInstance(hapticFeedback2) | gapComposer3.changed(menuState2) | gapComposer3.changedInstance(localItem);
                            Object objRememberedValue6 = gapComposer3.rememberedValue();
                            Object obj12 = objRememberedValue6;
                            if (zChangedInstance7 || objRememberedValue6 == neverEqualPolicy) {
                                final byte b4 = 0;
                                Function0 function5 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$4$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b5 = b4;
                                        Unit unit = Unit.INSTANCE;
                                        LocalItem localItem2 = localItem;
                                        MenuState menuState3 = menuState2;
                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                        byte b6 = 1;
                                        switch (b5) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, -1516926467, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 4)));
                                                break;
                                            case 1:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 1381164194, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, b6)));
                                                break;
                                            case 2:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 2089311682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 6)));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, -1212139715, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 7)));
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                gapComposer3.updateRememberedValue(function5);
                                obj12 = function5;
                            }
                            Function0 function6 = (Function0) obj12;
                            boolean zChangedInstance8 = gapComposer3.changedInstance(localItem) | gapComposer3.changed(state);
                            final PlayerConnection playerConnection2 = this.$playerConnection$inlined;
                            boolean zChangedInstance9 = zChangedInstance8 | gapComposer3.changedInstance(playerConnection2) | gapComposer3.changedInstance(this.$selection$inlined) | gapComposer3.changed((String) obj10);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            if (zChangedInstance9 || objRememberedValue7 == neverEqualPolicy) {
                                final String str3 = (String) obj10;
                                final State state4 = this.$mediaMetadata$delegate$inlined;
                                final byte b5 = 0;
                                final List list5 = this.$selection$inlined;
                                objRememberedValue7 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$5$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        int i4;
                                        int i5;
                                        byte b6 = b5;
                                        Unit unit = Unit.INSTANCE;
                                        List list6 = list5;
                                        State state5 = state4;
                                        LocalItem localItem2 = localItem;
                                        int i6 = 0;
                                        PlayerConnection playerConnection3 = playerConnection2;
                                        switch (b6) {
                                            case 0:
                                                Song song3 = (Song) localItem2;
                                                String str4 = song3.song.id;
                                                MediaMetadata mediaMetadata3 = (MediaMetadata) state5.getValue();
                                                if (Intrinsics.areEqual(str4, mediaMetadata3 != null ? mediaMetadata3.id : null)) {
                                                    playerConnection3.togglePlayPause();
                                                } else {
                                                    ArrayList arrayList = new ArrayList();
                                                    for (Object obj13 : list6) {
                                                        if (obj13 instanceof Song) {
                                                            arrayList.add(obj13);
                                                        }
                                                    }
                                                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj14 = arrayList.get(i7);
                                                        i7++;
                                                        arrayList2.add(UuidKt.toMediaItem((Song) obj14));
                                                    }
                                                    int size2 = arrayList.size();
                                                    int i8 = 0;
                                                    while (i8 < size2) {
                                                        Object obj15 = arrayList.get(i8);
                                                        i8++;
                                                        if (Intrinsics.areEqual(((Song) obj15).song.id, song3.song.id)) {
                                                            i4 = i6;
                                                            playerConnection3.playQueue(new ListQueue(str3, arrayList2, i4, 0L, 8, null));
                                                        } else {
                                                            i6++;
                                                        }
                                                        break;
                                                    }
                                                    i4 = -1;
                                                    playerConnection3.playQueue(new ListQueue(str3, arrayList2, i4, 0L, 8, null));
                                                }
                                                break;
                                            default:
                                                Song song4 = (Song) localItem2;
                                                String str5 = song4.song.id;
                                                MediaMetadata mediaMetadata4 = (MediaMetadata) state5.getValue();
                                                if (Intrinsics.areEqual(str5, mediaMetadata4 != null ? mediaMetadata4.id : null)) {
                                                    playerConnection3.togglePlayPause();
                                                } else {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    for (Object obj16 : list6) {
                                                        if (obj16 instanceof Song) {
                                                            arrayList3.add(obj16);
                                                        }
                                                    }
                                                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                                                    int size3 = arrayList3.size();
                                                    int i9 = 0;
                                                    while (i9 < size3) {
                                                        Object obj17 = arrayList3.get(i9);
                                                        i9++;
                                                        arrayList4.add(UuidKt.toMediaItem((Song) obj17));
                                                    }
                                                    int size4 = arrayList3.size();
                                                    int i10 = 0;
                                                    while (i10 < size4) {
                                                        Object obj18 = arrayList3.get(i10);
                                                        i10++;
                                                        if (Intrinsics.areEqual(((Song) obj18).song.id, song4.song.id)) {
                                                            i5 = i6;
                                                            playerConnection3.playQueue(new ListQueue(str3, arrayList4, i5, 0L, 8, null));
                                                        } else {
                                                            i6++;
                                                        }
                                                        break;
                                                    }
                                                    i5 = -1;
                                                    playerConnection3.playQueue(new ListQueue(str3, arrayList4, i5, 0L, 8, null));
                                                }
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                gapComposer3.updateRememberedValue(objRememberedValue7);
                            }
                            MenuKt.SongListItem(song2, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth3, false, function6, (Function0) objRememberedValue7, 239)), null, false, true, false, null, null, zAreEqual2, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(1119110603, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(menuState2, localItem, (byte) 0), gapComposer3), null, gapComposer3, 24576, 384, 10732);
                            gapComposer3.end(false);
                            z = false;
                        } else if (localItem instanceof Artist) {
                            gapComposer3.startReplaceGroup(1998760548);
                            Artist artist = (Artist) localItem;
                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                            boolean zChangedInstance10 = gapComposer3.changedInstance(hapticFeedback2) | gapComposer3.changed(menuState2) | gapComposer3.changedInstance(localItem) | gapComposer3.changedInstance(coroutineScope);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (zChangedInstance10 || objRememberedValue8 == neverEqualPolicy) {
                                final byte b6 = 1;
                                objRememberedValue8 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b7 = b6;
                                        Unit unit = Unit.INSTANCE;
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        LocalItem localItem2 = localItem;
                                        MenuState menuState3 = menuState2;
                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                        byte b8 = 1;
                                        switch (b7) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 656570041, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, b8)));
                                                break;
                                            case 1:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 860734554, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 3)));
                                                break;
                                            case 2:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 859505286, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 6)));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 1192272517, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem2, coroutineScope2, menuState3, (byte) 7)));
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                gapComposer3.updateRememberedValue(objRememberedValue8);
                            }
                            Function0 function7 = (Function0) objRememberedValue8;
                            boolean zChangedInstance11 = gapComposer3.changedInstance(navHostController) | gapComposer3.changedInstance(localItem);
                            Object objRememberedValue9 = gapComposer3.rememberedValue();
                            Object obj13 = objRememberedValue9;
                            if (zChangedInstance11 || objRememberedValue9 == neverEqualPolicy) {
                                LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1 libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$2 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(navHostController, localItem, (byte) 2);
                                gapComposer3.updateRememberedValue(libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$2);
                                obj13 = libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$2;
                            }
                            z = false;
                            MenuKt.ArtistListItem(artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth4, false, function7, (Function0) obj13, 239)), null, Expect_jvmKt.rememberComposableLambda(-234129578, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(menuState2, localItem, coroutineScope, (byte) 5), gapComposer3), gapComposer3, 3072, 4);
                            gapComposer3.end(false);
                        } else if (localItem instanceof Album) {
                            gapComposer3.startReplaceGroup(2001268882);
                            Album album3 = (Album) localItem;
                            String str4 = album3.album.id;
                            MediaMetadata mediaMetadata3 = (MediaMetadata) state.getValue();
                            boolean zAreEqual3 = Intrinsics.areEqual(str4, (mediaMetadata3 == null || (album = mediaMetadata3.album) == null) ? null : album.id);
                            boolean zBooleanValue3 = ((Boolean) state2.getValue()).booleanValue();
                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                            boolean zChangedInstance12 = gapComposer3.changedInstance(hapticFeedback2) | gapComposer3.changed(menuState2) | gapComposer3.changedInstance(localItem);
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            Object obj14 = objRememberedValue10;
                            if (zChangedInstance12 || objRememberedValue10 == neverEqualPolicy) {
                                Function0 function8 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$4$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b7 = b2;
                                        Unit unit = Unit.INSTANCE;
                                        LocalItem localItem2 = localItem;
                                        MenuState menuState3 = menuState2;
                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                        byte b8 = 1;
                                        switch (b7) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, -1516926467, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 4)));
                                                break;
                                            case 1:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 1381164194, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, b8)));
                                                break;
                                            case 2:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, 2089311682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 6)));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback3).m578performHapticFeedbackCdsT49E(0);
                                                menuState3.show(new ComposableLambdaImpl(true, -1212139715, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem2, menuState3, (byte) 7)));
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                gapComposer3.updateRememberedValue(function8);
                                obj14 = function8;
                            }
                            Function0 function9 = (Function0) obj14;
                            boolean zChangedInstance13 = gapComposer3.changedInstance(navHostController) | gapComposer3.changedInstance(localItem);
                            Object objRememberedValue11 = gapComposer3.rememberedValue();
                            Object obj15 = objRememberedValue11;
                            if (zChangedInstance13 || objRememberedValue11 == neverEqualPolicy) {
                                LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1 libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$3 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(navHostController, localItem, (byte) 1);
                                gapComposer3.updateRememberedValue(libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$3);
                                obj15 = libraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$3;
                            }
                            z = false;
                            MenuKt.AlbumListItem(album3, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth5, false, function9, (Function0) obj15, 239)), false, null, zAreEqual3, zBooleanValue3, Expect_jvmKt.rememberComposableLambda(-704469108, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(menuState2, localItem, (byte) 3), gapComposer3), gapComposer3, 1572864, 12);
                            gapComposer3.end(false);
                        }
                        gapComposer3.end(z);
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer3, -628463194, false);
                }
                gapComposer3.skipToGroupEnd();
                return Unit.INSTANCE;
            default:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                final CoroutineScope coroutineScope2 = (CoroutineScope) obj9;
                NavHostController navHostController2 = (NavHostController) obj8;
                if ((iIntValue6 & 6) == 0) {
                    i3 = iIntValue6 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2);
                } else {
                    i3 = iIntValue6;
                }
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                boolean z5 = (i3 & 147) != 146;
                int i4 = i3 & 1;
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(i4, z5)) {
                    final LocalItem localItem2 = (LocalItem) list.get(iIntValue5);
                    gapComposer4.startReplaceGroup(2091968633);
                    if (localItem2 != null) {
                        boolean z6 = localItem2 instanceof Playlist;
                        final MenuState menuState3 = this.$menuState$inlined;
                        final HapticFeedback hapticFeedback3 = this.$haptic$inlined;
                        if (z6) {
                            gapComposer4.startReplaceGroup(2091878887);
                            Playlist playlist2 = (Playlist) localItem2;
                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                            boolean zChangedInstance14 = gapComposer4.changedInstance(hapticFeedback3) | gapComposer4.changed(menuState3) | gapComposer4.changedInstance(localItem2) | gapComposer4.changedInstance(coroutineScope2);
                            Object objRememberedValue12 = gapComposer4.rememberedValue();
                            if (zChangedInstance14 || objRememberedValue12 == neverEqualPolicy) {
                                final byte b7 = 2;
                                objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b8 = b7;
                                        Unit unit = Unit.INSTANCE;
                                        CoroutineScope coroutineScope3 = coroutineScope2;
                                        LocalItem localItem3 = localItem2;
                                        MenuState menuState4 = menuState3;
                                        HapticFeedback hapticFeedback4 = hapticFeedback3;
                                        byte b9 = 1;
                                        switch (b8) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                menuState4.show(new ComposableLambdaImpl(true, 656570041, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, b9)));
                                                break;
                                            case 1:
                                                ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                menuState4.show(new ComposableLambdaImpl(true, 860734554, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 3)));
                                                break;
                                            case 2:
                                                ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                menuState4.show(new ComposableLambdaImpl(true, 859505286, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 6)));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                menuState4.show(new ComposableLambdaImpl(true, 1192272517, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 7)));
                                                break;
                                        }
                                        return unit;
                                    }
                                };
                                gapComposer4.updateRememberedValue(objRememberedValue12);
                            }
                            Function0 function10 = (Function0) objRememberedValue12;
                            boolean zChangedInstance15 = gapComposer4.changedInstance(localItem2) | gapComposer4.changedInstance(navHostController2);
                            Object objRememberedValue13 = gapComposer4.rememberedValue();
                            if (zChangedInstance15 || objRememberedValue13 == neverEqualPolicy) {
                                objRememberedValue13 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(localItem2, navHostController2, (byte) 3);
                                gapComposer4.updateRememberedValue(objRememberedValue13);
                            }
                            z3 = false;
                            MenuKt.PlaylistGridItem(playlist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, function10, (Function0) objRememberedValue13, 239)), false, null, true, gapComposer4, 24576, 12);
                            gapComposer = gapComposer4;
                            gapComposer.end(false);
                        } else {
                            gapComposer = gapComposer4;
                            if (localItem2 instanceof Song) {
                                gapComposer.startReplaceGroup(2093875349);
                                Song song3 = (Song) localItem2;
                                String str5 = song3.song.id;
                                MediaMetadata mediaMetadata4 = (MediaMetadata) state.getValue();
                                boolean zAreEqual4 = Intrinsics.areEqual(str5, mediaMetadata4 != null ? mediaMetadata4.id : null);
                                boolean zBooleanValue4 = ((Boolean) state2.getValue()).booleanValue();
                                Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                boolean zChangedInstance16 = gapComposer.changedInstance(hapticFeedback3) | gapComposer.changed(menuState3) | gapComposer.changedInstance(localItem2);
                                Object objRememberedValue14 = gapComposer.rememberedValue();
                                if (zChangedInstance16 || objRememberedValue14 == neverEqualPolicy) {
                                    final byte b8 = 2;
                                    objRememberedValue14 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$4$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b9 = b8;
                                            Unit unit = Unit.INSTANCE;
                                            LocalItem localItem3 = localItem2;
                                            MenuState menuState4 = menuState3;
                                            HapticFeedback hapticFeedback4 = hapticFeedback3;
                                            byte b10 = 1;
                                            switch (b9) {
                                                case 0:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, -1516926467, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 4)));
                                                    break;
                                                case 1:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 1381164194, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, b10)));
                                                    break;
                                                case 2:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 2089311682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 6)));
                                                    break;
                                                default:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, -1212139715, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 7)));
                                                    break;
                                            }
                                            return unit;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue14);
                                }
                                Function0 function11 = (Function0) objRememberedValue14;
                                boolean zChangedInstance17 = gapComposer.changedInstance(localItem2) | gapComposer.changed(state);
                                final PlayerConnection playerConnection3 = this.$playerConnection$inlined;
                                boolean zChangedInstance18 = zChangedInstance17 | gapComposer.changedInstance(playerConnection3) | gapComposer.changedInstance(this.$selection$inlined) | gapComposer.changed((String) obj10);
                                Object objRememberedValue15 = gapComposer.rememberedValue();
                                if (zChangedInstance18 || objRememberedValue15 == neverEqualPolicy) {
                                    final String str6 = (String) obj10;
                                    final State state5 = this.$mediaMetadata$delegate$inlined;
                                    final byte b9 = 1;
                                    final List list6 = this.$selection$inlined;
                                    objRememberedValue15 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$5$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            int i5;
                                            int i6;
                                            byte b10 = b9;
                                            Unit unit = Unit.INSTANCE;
                                            List list7 = list6;
                                            State state6 = state5;
                                            LocalItem localItem3 = localItem2;
                                            int i7 = 0;
                                            PlayerConnection playerConnection4 = playerConnection3;
                                            switch (b10) {
                                                case 0:
                                                    Song song4 = (Song) localItem3;
                                                    String str7 = song4.song.id;
                                                    MediaMetadata mediaMetadata5 = (MediaMetadata) state6.getValue();
                                                    if (Intrinsics.areEqual(str7, mediaMetadata5 != null ? mediaMetadata5.id : null)) {
                                                        playerConnection4.togglePlayPause();
                                                    } else {
                                                        ArrayList arrayList = new ArrayList();
                                                        for (Object obj16 : list7) {
                                                            if (obj16 instanceof Song) {
                                                                arrayList.add(obj16);
                                                            }
                                                        }
                                                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                                                        int size = arrayList.size();
                                                        int i8 = 0;
                                                        while (i8 < size) {
                                                            Object obj17 = arrayList.get(i8);
                                                            i8++;
                                                            arrayList2.add(UuidKt.toMediaItem((Song) obj17));
                                                        }
                                                        int size2 = arrayList.size();
                                                        int i9 = 0;
                                                        while (i9 < size2) {
                                                            Object obj18 = arrayList.get(i9);
                                                            i9++;
                                                            if (Intrinsics.areEqual(((Song) obj18).song.id, song4.song.id)) {
                                                                i5 = i7;
                                                                playerConnection4.playQueue(new ListQueue(str6, arrayList2, i5, 0L, 8, null));
                                                            } else {
                                                                i7++;
                                                            }
                                                            break;
                                                        }
                                                        i5 = -1;
                                                        playerConnection4.playQueue(new ListQueue(str6, arrayList2, i5, 0L, 8, null));
                                                    }
                                                    break;
                                                default:
                                                    Song song5 = (Song) localItem3;
                                                    String str8 = song5.song.id;
                                                    MediaMetadata mediaMetadata6 = (MediaMetadata) state6.getValue();
                                                    if (Intrinsics.areEqual(str8, mediaMetadata6 != null ? mediaMetadata6.id : null)) {
                                                        playerConnection4.togglePlayPause();
                                                    } else {
                                                        ArrayList arrayList3 = new ArrayList();
                                                        for (Object obj19 : list7) {
                                                            if (obj19 instanceof Song) {
                                                                arrayList3.add(obj19);
                                                            }
                                                        }
                                                        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                                                        int size3 = arrayList3.size();
                                                        int i10 = 0;
                                                        while (i10 < size3) {
                                                            Object obj110 = arrayList3.get(i10);
                                                            i10++;
                                                            arrayList4.add(UuidKt.toMediaItem((Song) obj110));
                                                        }
                                                        int size4 = arrayList3.size();
                                                        int i11 = 0;
                                                        while (i11 < size4) {
                                                            Object obj111 = arrayList3.get(i11);
                                                            i11++;
                                                            if (Intrinsics.areEqual(((Song) obj111).song.id, song5.song.id)) {
                                                                i6 = i7;
                                                                playerConnection4.playQueue(new ListQueue(str6, arrayList4, i6, 0L, 8, null));
                                                            } else {
                                                                i7++;
                                                            }
                                                            break;
                                                        }
                                                        i6 = -1;
                                                        playerConnection4.playQueue(new ListQueue(str6, arrayList4, i6, 0L, 8, null));
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue15);
                                }
                                MenuKt.SongGridItem(song3, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, function11, (Function0) objRememberedValue15, 239)), false, true, false, null, zAreEqual4, zBooleanValue4, true, gapComposer, 100666368, 52);
                                gapComposer.end(false);
                                z2 = false;
                            } else if (localItem2 instanceof Artist) {
                                gapComposer.startReplaceGroup(2096380893);
                                Artist artist2 = (Artist) localItem2;
                                Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                boolean zChangedInstance19 = gapComposer.changedInstance(hapticFeedback3) | gapComposer.changed(menuState3) | gapComposer.changedInstance(localItem2) | gapComposer.changedInstance(coroutineScope2);
                                Object objRememberedValue16 = gapComposer.rememberedValue();
                                if (zChangedInstance19 || objRememberedValue16 == neverEqualPolicy) {
                                    final byte b10 = 3;
                                    objRememberedValue16 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$1$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b11 = b10;
                                            Unit unit = Unit.INSTANCE;
                                            CoroutineScope coroutineScope3 = coroutineScope2;
                                            LocalItem localItem3 = localItem2;
                                            MenuState menuState4 = menuState3;
                                            HapticFeedback hapticFeedback4 = hapticFeedback3;
                                            byte b12 = 1;
                                            switch (b11) {
                                                case 0:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 656570041, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, b12)));
                                                    break;
                                                case 1:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 860734554, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 3)));
                                                    break;
                                                case 2:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 859505286, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 6)));
                                                    break;
                                                default:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 1192272517, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$3(localItem3, coroutineScope3, menuState4, (byte) 7)));
                                                    break;
                                            }
                                            return unit;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue16);
                                }
                                Function0 function12 = (Function0) objRememberedValue16;
                                boolean zChangedInstance20 = gapComposer.changedInstance(navHostController2) | gapComposer.changedInstance(localItem2);
                                Object objRememberedValue17 = gapComposer.rememberedValue();
                                if (zChangedInstance20 || objRememberedValue17 == neverEqualPolicy) {
                                    objRememberedValue17 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(navHostController2, localItem2, (byte) 4);
                                    gapComposer.updateRememberedValue(objRememberedValue17);
                                }
                                z3 = false;
                                MenuKt.ArtistGridItem(artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, function12, (Function0) objRememberedValue17, 239)), null, true, gapComposer, 3072, 4);
                                gapComposer.end(false);
                            } else if (localItem2 instanceof Album) {
                                gapComposer.startReplaceGroup(2097866475);
                                Album album4 = (Album) localItem2;
                                String str7 = album4.album.id;
                                MediaMetadata mediaMetadata5 = (MediaMetadata) state.getValue();
                                boolean zAreEqual5 = Intrinsics.areEqual(str7, (mediaMetadata5 == null || (album2 = mediaMetadata5.album) == null) ? null : album2.id);
                                boolean zBooleanValue5 = ((Boolean) state2.getValue()).booleanValue();
                                Modifier modifierFillMaxWidth9 = SizeKt.fillMaxWidth(companion, 1.0f);
                                boolean zChangedInstance21 = gapComposer.changedInstance(hapticFeedback3) | gapComposer.changed(menuState3) | gapComposer.changedInstance(localItem2);
                                Object objRememberedValue18 = gapComposer.rememberedValue();
                                if (zChangedInstance21 || objRememberedValue18 == neverEqualPolicy) {
                                    final byte b11 = 3;
                                    objRememberedValue18 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$4$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b12 = b11;
                                            Unit unit = Unit.INSTANCE;
                                            LocalItem localItem3 = localItem2;
                                            MenuState menuState4 = menuState3;
                                            HapticFeedback hapticFeedback4 = hapticFeedback3;
                                            byte b13 = 1;
                                            switch (b12) {
                                                case 0:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, -1516926467, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 4)));
                                                    break;
                                                case 1:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 1381164194, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, b13)));
                                                    break;
                                                case 2:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, 2089311682, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 6)));
                                                    break;
                                                default:
                                                    ((PlatformHapticFeedback) hapticFeedback4).m578performHapticFeedbackCdsT49E(0);
                                                    menuState4.show(new ComposableLambdaImpl(true, -1212139715, new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$6(localItem3, menuState4, (byte) 7)));
                                                    break;
                                            }
                                            return unit;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue18);
                                }
                                Function0 function13 = (Function0) objRememberedValue18;
                                boolean zChangedInstance22 = gapComposer.changedInstance(navHostController2) | gapComposer.changedInstance(localItem2);
                                Object objRememberedValue19 = gapComposer.rememberedValue();
                                if (zChangedInstance22 || objRememberedValue19 == neverEqualPolicy) {
                                    objRememberedValue19 = new LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(navHostController2, localItem2, (byte) 5);
                                    gapComposer.updateRememberedValue(objRememberedValue19);
                                }
                                z2 = false;
                                MenuKt.AlbumGridItem(album4, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth9, false, function13, (Function0) objRememberedValue19, 239)), (CoroutineScope) obj9, null, zAreEqual5, zBooleanValue5, true, gapComposer, 1572864, 8);
                                gapComposer.end(false);
                            }
                            gapComposer.end(z2);
                        }
                        z2 = z3;
                        gapComposer.end(z2);
                    } else {
                        gapComposer = gapComposer4;
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1040895798, false);
                }
                gapComposer4.skipToGroupEnd();
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(List list, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, NavHostController navHostController, State state, PlayerConnection playerConnection, List list2, String str, State state2, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$dateEvents$inlined = coroutineScope;
        this.$dateAgo$inlined = navHostController;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$selection$inlined = list2;
        this.$inSelectMode$delegate$inlined = str;
        this.$isPlaying$delegate$inlined = state2;
    }
}
