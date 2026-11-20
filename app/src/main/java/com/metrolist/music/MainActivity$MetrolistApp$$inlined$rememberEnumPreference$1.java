package com.metrolist.music;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.LyricsAnimationStyle;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.SliderStyle;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.component.ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.component.ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1;
import com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.player.ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.player.ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.artist.ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.artist.ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.theme.UiStyle;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1 implements Flow {
    public final /* synthetic */ Preferences$Key $key$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ Preferences$Key $key$inlined;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Preferences$Key preferences$Key, byte b) {
            this.$r8$classId = b;
            switch (b) {
                case 1:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 2:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 3:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 4:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 5:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 6:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 7:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 8:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 9:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 10:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 11:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 13:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 14:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 15:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 16:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 17:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 18:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 19:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 20:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 21:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 22:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 23:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 24:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 25:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 26:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 27:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 28:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                case 29:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
                default:
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = preferences$Key;
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:104:0x0198  */
        /* JADX WARN: Code duplicated, block: B:123:0x01de  */
        /* JADX WARN: Code duplicated, block: B:142:0x0224  */
        /* JADX WARN: Code duplicated, block: B:161:0x026a  */
        /* JADX WARN: Code duplicated, block: B:180:0x02b0  */
        /* JADX WARN: Code duplicated, block: B:199:0x02f6  */
        /* JADX WARN: Code duplicated, block: B:218:0x033c  */
        /* JADX WARN: Code duplicated, block: B:237:0x0384  */
        /* JADX WARN: Code duplicated, block: B:256:0x03ca  */
        /* JADX WARN: Code duplicated, block: B:275:0x0410  */
        /* JADX WARN: Code duplicated, block: B:28:0x007e  */
        /* JADX WARN: Code duplicated, block: B:294:0x0456  */
        /* JADX WARN: Code duplicated, block: B:313:0x049c  */
        /* JADX WARN: Code duplicated, block: B:332:0x04e2  */
        /* JADX WARN: Code duplicated, block: B:351:0x0528  */
        /* JADX WARN: Code duplicated, block: B:370:0x056e  */
        /* JADX WARN: Code duplicated, block: B:389:0x05b4  */
        /* JADX WARN: Code duplicated, block: B:408:0x05fa  */
        /* JADX WARN: Code duplicated, block: B:427:0x0642  */
        /* JADX WARN: Code duplicated, block: B:446:0x0688  */
        /* JADX WARN: Code duplicated, block: B:465:0x06ce  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:484:0x0714  */
        /* JADX WARN: Code duplicated, block: B:503:0x075a  */
        /* JADX WARN: Code duplicated, block: B:522:0x07a0  */
        /* JADX WARN: Code duplicated, block: B:541:0x07e6  */
        /* JADX WARN: Code duplicated, block: B:560:0x082c  */
        /* JADX WARN: Code duplicated, block: B:66:0x010c  */
        /* JADX WARN: Code duplicated, block: B:85:0x0152  */
        /* JADX WARN: Code duplicated, block: B:9:0x0036  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1;
            MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1;
            MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1;
            ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1;
            ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1;
            ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1 itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1;
            OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1;
            OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1;
            OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1;
            OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1;
            GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1 gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1;
            AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1;
            AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1;
            AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1;
            AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1;
            MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1 miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1;
            PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1;
            PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1;
            ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1 thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1;
            AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1 accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1;
            BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1 browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1;
            ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1 composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1;
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1 homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1;
            NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1 newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1;
            YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1 youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1;
            ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1;
            ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1 artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1;
            ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1 artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1;
            byte b = this.$r8$classId;
            UiStyle uiStyleValueOf = UiStyle.EDITORIAL;
            LyricsPosition lyricsPositionValueOf = LyricsPosition.CENTER;
            AddToPlaylistPosition addToPlaylistPositionValueOf = AddToPlaylistPosition.BEGINNING;
            PlaylistSortType playlistSortTypeValueOf = PlaylistSortType.NAME;
            PlayerBackgroundStyle playerBackgroundStyleValueOf = PlayerBackgroundStyle.DEFAULT;
            DarkMode darkModeValueOf = DarkMode.AUTO;
            GridItemSize gridItemSizeValueOf = GridItemSize.BIG;
            Unit unit = Unit.INSTANCE;
            Preferences$Key preferences$Key = this.$key$inlined;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ResultKt.throwOnFailure(obj2);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj2);
                    String str = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    anonymousClass1.label = 1;
                    return flowCollector.emit(darkModeValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    if (continuation instanceof MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1) {
                        mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i3 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj3 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1.result;
                    int i4 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            ResultKt.throwOnFailure(obj3);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj3);
                    String str2 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str2 != null) {
                        try {
                            uiStyleValueOf = UiStyle.valueOf(str2);
                            break;
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(uiStyleValueOf, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    if (continuation instanceof MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1) {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i5 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj4 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1.result;
                    int i6 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            ResultKt.throwOnFailure(obj4);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj4);
                    String str3 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str3 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str3);
                            break;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 3:
                    if (continuation instanceof MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1) {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i7 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj5 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1.result;
                    int i8 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            ResultKt.throwOnFailure(obj5);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj5);
                    String str4 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str4 != null) {
                        try {
                            uiStyleValueOf = UiStyle.valueOf(str4);
                            break;
                        } catch (IllegalArgumentException unused4) {
                        }
                    }
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(uiStyleValueOf, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 4:
                    if (continuation instanceof ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1) {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i9 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj6 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1.result;
                    int i10 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            ResultKt.throwOnFailure(obj6);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                    String str5 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str5 != null) {
                        try {
                            lyricsPositionValueOf = LyricsPosition.valueOf(str5);
                            break;
                        } catch (IllegalArgumentException unused5) {
                        }
                    }
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(lyricsPositionValueOf, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    if (continuation instanceof ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1) {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i11 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj7 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1.result;
                    int i12 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj7);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                    String str6 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str6 != null) {
                        try {
                            playerBackgroundStyleValueOf = PlayerBackgroundStyle.valueOf(str6);
                            break;
                        } catch (IllegalArgumentException unused6) {
                        }
                    }
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(playerBackgroundStyleValueOf, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1) {
                        itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1 = (ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i13 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1 = new ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1 = new ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj8 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1.result;
                    int i14 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i14 != 0) {
                        if (i14 == 1) {
                            ResultKt.throwOnFailure(obj8);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj8);
                    String str7 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str7 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str7);
                            break;
                        } catch (IllegalArgumentException unused7) {
                        }
                    }
                    itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i15 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj9 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1.result;
                    int i16 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj9);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                    String str8 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str8 != null) {
                        try {
                            lyricsPositionValueOf = LyricsPosition.valueOf(str8);
                            break;
                        } catch (IllegalArgumentException unused8) {
                        }
                    }
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(lyricsPositionValueOf, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i17 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj10 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1.result;
                    int i18 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            ResultKt.throwOnFailure(obj10);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj10);
                    String str9 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    LyricsAnimationStyle lyricsAnimationStyleValueOf = LyricsAnimationStyle.APPLE;
                    if (str9 != null) {
                        try {
                            lyricsAnimationStyleValueOf = LyricsAnimationStyle.valueOf(str9);
                            break;
                        } catch (IllegalArgumentException unused9) {
                        }
                    }
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(lyricsAnimationStyleValueOf, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i19 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj11 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1.result;
                    int i20 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1.label;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            ResultKt.throwOnFailure(obj11);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                    String str10 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str10 != null) {
                        try {
                            playerBackgroundStyleValueOf = PlayerBackgroundStyle.valueOf(str10);
                            break;
                        } catch (IllegalArgumentException unused10) {
                        }
                    }
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(playerBackgroundStyleValueOf, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 10:
                    if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1) continuation;
                        int i21 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                        }
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                    }
                    Object obj12 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1.result;
                    int i22 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1.label;
                    if (i22 != 0) {
                        if (i22 == 1) {
                            ResultKt.throwOnFailure(obj12);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj12);
                    String str11 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str11 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str11);
                            break;
                        } catch (IllegalArgumentException unused11) {
                        }
                    }
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    if (continuation instanceof GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1) {
                        gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1 = (GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i23 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj13 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1.result;
                    int i24 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i24 != 0) {
                        if (i24 == 1) {
                            ResultKt.throwOnFailure(obj13);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj13);
                    String str12 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str12 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str12);
                            break;
                        } catch (IllegalArgumentException unused12) {
                        }
                    }
                    gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1) {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i25 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj14 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1.result;
                    int i26 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i26 != 0) {
                        if (i26 == 1) {
                            ResultKt.throwOnFailure(obj14);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj14);
                    String str13 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str13 != null) {
                        try {
                            addToPlaylistPositionValueOf = AddToPlaylistPosition.valueOf(str13);
                            break;
                        } catch (IllegalArgumentException unused13) {
                        }
                    }
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(addToPlaylistPositionValueOf, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 13:
                    if (continuation instanceof AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1) {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i27 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj15 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1.result;
                    int i28 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i28 != 0) {
                        if (i28 == 1) {
                            ResultKt.throwOnFailure(obj15);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj15);
                    String str14 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str14 != null) {
                        try {
                            playlistSortTypeValueOf = PlaylistSortType.valueOf(str14);
                            break;
                        } catch (IllegalArgumentException unused14) {
                        }
                    }
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(playlistSortTypeValueOf, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 14:
                    if (continuation instanceof AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1) {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i29 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj16 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1.result;
                    int i30 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i30 != 0) {
                        if (i30 == 1) {
                            ResultKt.throwOnFailure(obj16);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj16);
                    String str15 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str15 != null) {
                        try {
                            addToPlaylistPositionValueOf = AddToPlaylistPosition.valueOf(str15);
                            break;
                        } catch (IllegalArgumentException unused15) {
                        }
                    }
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(addToPlaylistPositionValueOf, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 15:
                    if (continuation instanceof AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1) {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i31 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj17 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1.result;
                    int i32 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i32 != 0) {
                        if (i32 == 1) {
                            ResultKt.throwOnFailure(obj17);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj17);
                    String str16 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str16 != null) {
                        try {
                            playlistSortTypeValueOf = PlaylistSortType.valueOf(str16);
                            break;
                        } catch (IllegalArgumentException unused16) {
                        }
                    }
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(playlistSortTypeValueOf, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 16:
                    if (continuation instanceof MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1) {
                        miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1 = (MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i33 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1 = new MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1 = new MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj18 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1.result;
                    int i34 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i34 != 0) {
                        if (i34 == 1) {
                            ResultKt.throwOnFailure(obj18);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj18);
                    String str17 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str17 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str17);
                            break;
                        } catch (IllegalArgumentException unused17) {
                        }
                    }
                    miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 17:
                    if (continuation instanceof PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1) {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i35 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj19 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1.result;
                    int i36 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i36 != 0) {
                        if (i36 == 1) {
                            ResultKt.throwOnFailure(obj19);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj19);
                    String str18 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str18 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str18);
                            break;
                        } catch (IllegalArgumentException unused18) {
                        }
                    }
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 18:
                    if (continuation instanceof PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1) {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i37 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj20 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1.result;
                    int i38 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1.label;
                    if (i38 != 0) {
                        if (i38 == 1) {
                            ResultKt.throwOnFailure(obj20);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj20);
                    String str19 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    SliderStyle sliderStyleValueOf = SliderStyle.DEFAULT;
                    if (str19 != null) {
                        try {
                            sliderStyleValueOf = SliderStyle.valueOf(str19);
                            break;
                        } catch (IllegalArgumentException unused19) {
                        }
                    }
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(sliderStyleValueOf, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 19:
                    if (continuation instanceof ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1) {
                        thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1 = (ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i39 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj21 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1.result;
                    int i40 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i40 != 0) {
                        if (i40 == 1) {
                            ResultKt.throwOnFailure(obj21);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj21);
                    String str20 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str20 != null) {
                        try {
                            playerBackgroundStyleValueOf = PlayerBackgroundStyle.valueOf(str20);
                            break;
                        } catch (IllegalArgumentException unused20) {
                        }
                    }
                    thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(playerBackgroundStyleValueOf, thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 20:
                    if (continuation instanceof AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1) {
                        accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1 = (AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i41 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1 = new AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1 = new AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj22 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i42 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i42 != 0) {
                        if (i42 == 1) {
                            ResultKt.throwOnFailure(obj22);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj22);
                    String str21 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str21 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str21);
                            break;
                        } catch (IllegalArgumentException unused21) {
                        }
                    }
                    accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 21:
                    if (continuation instanceof BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1) {
                        browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1 = (BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i43 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1 = new BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1 = new BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj23 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i44 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i44 != 0) {
                        if (i44 == 1) {
                            ResultKt.throwOnFailure(obj23);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj23);
                    String str22 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str22 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str22);
                            break;
                        } catch (IllegalArgumentException unused22) {
                        }
                    }
                    browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 22:
                    if (continuation instanceof ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1) {
                        composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1 = (ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i45 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1 = new ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1 = new ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj24 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1.result;
                    int i46 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i46 != 0) {
                        if (i46 == 1) {
                            ResultKt.throwOnFailure(obj24);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj24);
                    String str23 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str23 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str23);
                            break;
                        } catch (IllegalArgumentException unused23) {
                        }
                    }
                    composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    if (continuation instanceof HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1) {
                        homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1 = (HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i47 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj25 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i48 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i48 != 0) {
                        if (i48 == 1) {
                            ResultKt.throwOnFailure(obj25);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj25);
                    String str24 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str24 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str24);
                            break;
                        } catch (IllegalArgumentException unused24) {
                        }
                    }
                    homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 24:
                    if (continuation instanceof NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1) {
                        newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1 = (NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i49 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1 = new NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1 = new NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj26 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i50 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i50 != 0) {
                        if (i50 == 1) {
                            ResultKt.throwOnFailure(obj26);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj26);
                    String str25 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str25 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str25);
                            break;
                        } catch (IllegalArgumentException unused25) {
                        }
                    }
                    newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 25:
                    if (continuation instanceof YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1) {
                        youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1 = (YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i51 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj27 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i52 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i52 != 0) {
                        if (i52 == 1) {
                            ResultKt.throwOnFailure(obj27);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj27);
                    String str26 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str26 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str26);
                            break;
                        } catch (IllegalArgumentException unused26) {
                        }
                    }
                    youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 26:
                    if (continuation instanceof ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = (ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i53 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i53 & Integer.MIN_VALUE) != 0) {
                            artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label = i53 - Integer.MIN_VALUE;
                        } else {
                            artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj28 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i54 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i54 != 0) {
                        if (i54 == 1) {
                            ResultKt.throwOnFailure(obj28);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj28);
                    String str27 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str27 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str27);
                            break;
                        } catch (IllegalArgumentException unused27) {
                        }
                    }
                    artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 27:
                    if (continuation instanceof ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1 = (ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i55 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i55 & Integer.MIN_VALUE) != 0) {
                            artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1.label = i55 - Integer.MIN_VALUE;
                        } else {
                            artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj29 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i56 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i56 != 0) {
                        if (i56 == 1) {
                            ResultKt.throwOnFailure(obj29);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj29);
                    String str28 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    if (str28 != null) {
                        try {
                            gridItemSizeValueOf = GridItemSize.valueOf(str28);
                            break;
                        } catch (IllegalArgumentException unused28) {
                        }
                    }
                    artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 28:
                    if (continuation instanceof ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1 = (ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i57 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i57 & Integer.MIN_VALUE) != 0) {
                            artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1.label = i57 - Integer.MIN_VALUE;
                        } else {
                            artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1 = new ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj30 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i58 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i58 != 0) {
                        if (i58 == 1) {
                            ResultKt.throwOnFailure(obj30);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj30);
                    String str29 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    ArtistSongSortType artistSongSortTypeValueOf = ArtistSongSortType.CREATE_DATE;
                    if (str29 != null) {
                        try {
                            artistSongSortTypeValueOf = ArtistSongSortType.valueOf(str29);
                            break;
                        } catch (IllegalArgumentException unused29) {
                        }
                    }
                    artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(artistSongSortTypeValueOf, artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i59 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i59 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label = i59 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj31 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i60 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                    if (i60 != 0) {
                        if (i60 == 1) {
                            ResultKt.throwOnFailure(obj31);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj31);
                    String str30 = (String) ((MutablePreferences) obj).get(preferences$Key);
                    LibraryViewType libraryViewTypeValueOf = LibraryViewType.GRID;
                    if (str30 != null) {
                        try {
                            libraryViewTypeValueOf = LibraryViewType.valueOf(str30);
                            break;
                        } catch (IllegalArgumentException unused30) {
                        }
                    }
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(libraryViewTypeValueOf, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(Flow flow, Preferences$Key preferences$Key, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 2:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 3:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 4:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 5:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 6:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 7:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 8:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 9:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 10:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 11:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 13:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 14:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 15:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 16:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 17:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 18:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 19:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 20:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 21:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 22:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 23:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 24:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 25:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 26:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 27:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 28:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            case 29:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
            default:
                this.$this_unsafeTransform$inlined = flow;
                this.$key$inlined = preferences$Key;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:144:0x0237  */
    /* JADX WARN: Code duplicated, block: B:159:0x0272  */
    /* JADX WARN: Code duplicated, block: B:174:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:204:0x0323  */
    /* JADX WARN: Code duplicated, block: B:219:0x035e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0399  */
    /* JADX WARN: Code duplicated, block: B:249:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:264:0x040f  */
    /* JADX WARN: Code duplicated, block: B:279:0x044a  */
    /* JADX WARN: Code duplicated, block: B:294:0x0485  */
    /* JADX WARN: Code duplicated, block: B:309:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:324:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:339:0x0536  */
    /* JADX WARN: Code duplicated, block: B:354:0x0570  */
    /* JADX WARN: Code duplicated, block: B:369:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:384:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:399:0x061e  */
    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX WARN: Code duplicated, block: B:414:0x0658  */
    /* JADX WARN: Code duplicated, block: B:429:0x0692  */
    /* JADX WARN: Code duplicated, block: B:444:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x014b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0186  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1;
        MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1;
        MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1;
        ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1;
        ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1;
        ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1 itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1;
        OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1;
        OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1;
        OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1;
        OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1;
        GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1 gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1;
        AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1;
        AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1;
        AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1;
        AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1;
        MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1 miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1;
        PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1;
        PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1;
        ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1 thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1;
        AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1 accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1;
        BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1 browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1;
        ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1 composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1;
        HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1 homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1;
        NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1 newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1;
        YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1 youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1;
        ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1 artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1;
        ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1 artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1;
        ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1 artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1;
        LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Preferences$Key preferences$Key = this.$key$inlined;
        Flow flow = this.$this_unsafeTransform$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 0);
                    anonymousClass1.label = 1;
                    return flow.collect(anonymousClass2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                if (continuation instanceof MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1) {
                    mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1) continuation;
                    int i3 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj2 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1.result;
                int i4 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 1);
                    mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass3, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1) {
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1) continuation;
                    int i5 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj3 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1.result;
                int i6 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 2);
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass4, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1) {
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1) continuation;
                    int i7 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj4 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1.result;
                int i8 = mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 3);
                    mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass5, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1) {
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1) continuation;
                    int i9 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj5 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1.result;
                int i10 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 4);
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass6, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1) {
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1) continuation;
                    int i11 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj6 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1.result;
                int i12 = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 5);
                    experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass7, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1) {
                    itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1 = (ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1) continuation;
                    int i13 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1 = new ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1 = new ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj7 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1.result;
                int i14 = itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 6);
                    itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass8, itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1) {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1) continuation;
                    int i15 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj8 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1.result;
                int i16 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 7);
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass9, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1) {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1) continuation;
                    int i17 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj9 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1.result;
                int i18 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 8);
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass10, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1) {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1) continuation;
                    int i19 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj10 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1.result;
                int i20 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 9);
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass11, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1) {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1) continuation;
                    int i21 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1(this, continuation);
                    }
                } else {
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1 = new OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1(this, continuation);
                }
                Object obj11 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1.result;
                int i22 = originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 10);
                    originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1.label = 1;
                    return flow.collect(anonymousClass12, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$7$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1) {
                    gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1 = (GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1) continuation;
                    int i23 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj12 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1.result;
                int i24 = gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 11);
                    gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass13, gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1) {
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1) continuation;
                    int i25 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj13 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1.result;
                int i26 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 12);
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass14, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1) {
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1) continuation;
                    int i27 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1 = new AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj14 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1.result;
                int i28 = addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 13);
                    addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass15, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1) {
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1) continuation;
                    int i29 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj15 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1.result;
                int i30 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 14);
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass16, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1) {
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1) continuation;
                    int i31 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj16 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1.result;
                int i32 = addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 15);
                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass17, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1) {
                    miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1 = (MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1) continuation;
                    int i33 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1 = new MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1 = new MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj17 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1.result;
                int i34 = miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 16);
                    miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass18, miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1) {
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1) continuation;
                    int i35 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj18 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1.result;
                int i36 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 17);
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass19, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1) {
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1) continuation;
                    int i37 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj19 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1.result;
                int i38 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 18);
                    playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass20, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1) {
                    thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1 = (ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1) continuation;
                    int i39 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj20 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1.result;
                int i40 = thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 19);
                    thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass21, thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1) {
                    accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1 = (AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i41 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1 = new AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1 = new AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj21 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1.result;
                int i42 = accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 20);
                    accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass22, accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1) {
                    browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1 = (BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i43 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1 = new BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1 = new BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj22 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1.result;
                int i44 = browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 21);
                    browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass23, browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1) {
                    composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1 = (ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1) continuation;
                    int i45 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1 = new ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1 = new ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj23 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1.result;
                int i46 = composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 22);
                    composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass24, composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1) {
                    homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1 = (HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i47 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj24 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1.result;
                int i48 = homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 23);
                    homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass25, homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1) {
                    newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1 = (NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i49 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1 = new NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1 = new NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj25 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1.result;
                int i50 = newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 24);
                    newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass26, newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 25:
                if (continuation instanceof YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1) {
                    youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1 = (YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i51 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj26 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1.result;
                int i52 = youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 25);
                    youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass27, youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 26:
                if (continuation instanceof ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1) {
                    artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1 = (ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i53 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i53 & Integer.MIN_VALUE) != 0) {
                        artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1.label = i53 - Integer.MIN_VALUE;
                    } else {
                        artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj27 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i54 = artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i54 == 0) {
                    ResultKt.throwOnFailure(obj27);
                    AnonymousClass2 anonymousClass28 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 26);
                    artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass28, artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i54 == 1) {
                    ResultKt.throwOnFailure(obj27);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 27:
                if (continuation instanceof ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1) {
                    artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1 = (ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i55 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i55 & Integer.MIN_VALUE) != 0) {
                        artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1.label = i55 - Integer.MIN_VALUE;
                    } else {
                        artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj28 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i56 = artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i56 == 0) {
                    ResultKt.throwOnFailure(obj28);
                    AnonymousClass2 anonymousClass29 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 27);
                    artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass29, artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i56 == 1) {
                    ResultKt.throwOnFailure(obj28);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 28:
                if (continuation instanceof ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1) {
                    artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1 = (ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i57 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i57 & Integer.MIN_VALUE) != 0) {
                        artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1.label = i57 - Integer.MIN_VALUE;
                    } else {
                        artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1 = new ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj29 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i58 = artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i58 == 0) {
                    ResultKt.throwOnFailure(obj29);
                    AnonymousClass2 anonymousClass30 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 28);
                    artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass30, artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i58 == 1) {
                    ResultKt.throwOnFailure(obj29);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i59 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i59 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1.label = i59 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj30 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i60 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i60 == 0) {
                    ResultKt.throwOnFailure(obj30);
                    AnonymousClass2 anonymousClass31 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 29);
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass31, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i60 == 1) {
                    ResultKt.throwOnFailure(obj30);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
