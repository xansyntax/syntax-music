package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.room.RoomDatabase$closeBarrier$1;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$9$4$3;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AndroidAutoSection;
import com.metrolist.music.viewmodels.TopPlaylistViewModel;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountScreenKt$AccountScreen$1$1$11$1$1 implements Function0 {
    public final /* synthetic */ Object $haptic;
    public final /* synthetic */ Object $item;
    public final /* synthetic */ Object $menuState;
    public final /* synthetic */ byte $r8$classId;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function3 {
        public final /* synthetic */ Object $item;
        public final /* synthetic */ MenuState $menuState;
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(Object obj, MenuState menuState, byte b) {
            this.$r8$classId = b;
            this.$item = obj;
            this.$menuState = menuState;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            Object obj4 = this.$item;
            switch (b) {
                case 0:
                    Composer composer = (Composer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer = (GapComposer) composer;
                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        ArtistItem artistItem = (ArtistItem) obj4;
                        MenuState menuState = this.$menuState;
                        boolean zChanged = gapComposer.changed(menuState);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 28);
                            gapComposer.updateRememberedValue(roomDatabase$closeBarrier$1);
                            objRememberedValue = roomDatabase$closeBarrier$1;
                        }
                        YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem, (Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                    }
                    break;
                default:
                    Composer composer2 = (Composer) obj2;
                    int iIntValue2 = ((Number) obj3).intValue();
                    ((ColumnScopeInstance) obj).getClass();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        EventWithSong eventWithSong = (EventWithSong) obj4;
                        Song song = eventWithSong.song;
                        Event event = eventWithSong.event;
                        MenuState menuState2 = this.$menuState;
                        boolean zChanged2 = gapComposer2.changed(menuState2);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new HomeScreenKt$HomeScreen$8$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 16);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        SongMenuKt.SongMenu(song, event, null, null, (Function0) ((KFunction) objRememberedValue2), false, gapComposer2, 0, 44);
                    }
                    break;
            }
            return unit;
        }
    }

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$11$1$1(MenuState menuState, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$haptic = obj;
        this.$item = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        byte b2 = 0;
        byte b3 = 1;
        Unit unit = Unit.INSTANCE;
        Object obj = this.$menuState;
        Object obj2 = this.$haptic;
        Object obj3 = this.$item;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) ((HapticFeedback) obj2)).m578performHapticFeedbackCdsT49E(0);
                MenuState menuState = (MenuState) obj;
                menuState.show(new ComposableLambdaImpl(true, -1341175759, new AnonymousClass1((ArtistItem) obj3, menuState, b2)));
                break;
            case 1:
                ((PlatformHapticFeedback) ((HapticFeedback) obj2)).m578performHapticFeedbackCdsT49E(0);
                MenuState menuState2 = (MenuState) obj;
                menuState2.show(new ComposableLambdaImpl(true, 756168144, new ArtistScreenKt$ArtistScreen$2$1$1$9$4$3((YTItem) obj3, menuState2, b3)));
                break;
            case 2:
                MenuState menuState3 = (MenuState) obj;
                menuState3.show(new ComposableLambdaImpl(true, -726732627, new AccountScreenKt$AccountScreen$1$1$5$1$1$1(obj2, obj3, (Object) menuState3, (byte) 3)));
                break;
            case 3:
                MenuState menuState4 = (MenuState) obj;
                menuState4.show(new ComposableLambdaImpl(true, -182737901, new AccountScreenKt$AccountScreen$1$1$5$1$1$1(obj2, menuState4, (MutableState) obj3, (byte) 4)));
                break;
            case 4:
                ((TopPlaylistViewModel) obj3).topPeriod.setValue((MyTopFilter) ((Enum) obj2));
                ((MutableState) obj).setValue(Boolean.FALSE);
                break;
            case 5:
                ((PlatformHapticFeedback) ((HapticFeedback) obj2)).m578performHapticFeedbackCdsT49E(0);
                MenuState menuState5 = (MenuState) obj;
                menuState5.show(new ComposableLambdaImpl(true, 958351594, new OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3((EpisodeItem) obj3, menuState5, b3)));
                break;
            case 6:
                ((Function1) obj2).invoke(((SearchHistory) obj).query);
                ((Function0) obj3).invoke();
                break;
            case 7:
                ((Function1) obj2).invoke((String) obj);
                ((Function0) obj3).invoke();
                break;
            case 8:
                ((MutableState) obj).setValue(((Playlist) obj2).playlist.id);
                ((MutableState) obj3).setValue(Boolean.FALSE);
                break;
            case 9:
                MutableState mutableState = (MutableState) obj;
                List<Pair> list = (List) mutableState.getValue();
                AndroidAutoSection androidAutoSection = (AndroidAutoSection) obj3;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Pair pair : list) {
                    AndroidAutoSection androidAutoSection2 = (AndroidAutoSection) pair.first;
                    Boolean bool = (Boolean) pair.second;
                    arrayList.add(androidAutoSection2 == androidAutoSection ? new Pair(androidAutoSection2, Boolean.valueOf(!bool.booleanValue())) : new Pair(androidAutoSection2, bool));
                }
                mutableState.setValue(arrayList);
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(AiSettingsKt.serializeSections((List) mutableState.getValue()));
                break;
            default:
                ((MutableState) obj3).setValue(Boolean.FALSE);
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke((String) obj);
                break;
        }
        return unit;
    }

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$11$1$1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$haptic = obj;
        this.$menuState = obj2;
        this.$item = obj3;
    }
}
