package com.metrolist.music.ui.screens.search;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.LyricsAnimationStyle;
import com.metrolist.music.constants.MiniPlayerBackgroundStyle;
import com.metrolist.music.constants.MixSortType;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.PodcastFilter;
import com.metrolist.music.constants.SearchSource;
import com.metrolist.music.constants.SliderStyle;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.playlist.CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.playlist.CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1;
import com.metrolist.music.ui.screens.settings.DarkMode;
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
public final class SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1 implements Flow {
    public final /* synthetic */ Preferences$Key $key$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1$1, reason: invalid class name */
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
            return SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ Preferences$Key $key$inlined;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1$2$1, reason: invalid class name */
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

        /* JADX WARN: Code duplicated, block: B:104:0x0183  */
        /* JADX WARN: Code duplicated, block: B:123:0x01c8  */
        /* JADX WARN: Code duplicated, block: B:142:0x020d  */
        /* JADX WARN: Code duplicated, block: B:161:0x0252  */
        /* JADX WARN: Code duplicated, block: B:180:0x0297  */
        /* JADX WARN: Code duplicated, block: B:199:0x02da  */
        /* JADX WARN: Code duplicated, block: B:218:0x031d  */
        /* JADX WARN: Code duplicated, block: B:237:0x0362  */
        /* JADX WARN: Code duplicated, block: B:256:0x03a5  */
        /* JADX WARN: Code duplicated, block: B:275:0x03e8  */
        /* JADX WARN: Code duplicated, block: B:28:0x0071  */
        /* JADX WARN: Code duplicated, block: B:294:0x042b  */
        /* JADX WARN: Code duplicated, block: B:313:0x046e  */
        /* JADX WARN: Code duplicated, block: B:332:0x04b1  */
        /* JADX WARN: Code duplicated, block: B:351:0x04f6  */
        /* JADX WARN: Code duplicated, block: B:370:0x0539  */
        /* JADX WARN: Code duplicated, block: B:389:0x057e  */
        /* JADX WARN: Code duplicated, block: B:408:0x05c1  */
        /* JADX WARN: Code duplicated, block: B:427:0x0606  */
        /* JADX WARN: Code duplicated, block: B:446:0x0649  */
        /* JADX WARN: Code duplicated, block: B:465:0x068e  */
        /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:484:0x06d3  */
        /* JADX WARN: Code duplicated, block: B:503:0x0716  */
        /* JADX WARN: Code duplicated, block: B:522:0x0759  */
        /* JADX WARN: Code duplicated, block: B:541:0x079e  */
        /* JADX WARN: Code duplicated, block: B:560:0x07e3  */
        /* JADX WARN: Code duplicated, block: B:66:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:85:0x013e  */
        /* JADX WARN: Code duplicated, block: B:9:0x002c  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1;
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1;
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1;
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1;
            LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1;
            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1;
            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1;
            LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1;
            LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1;
            AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
            CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1 cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
            LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1 localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1;
            LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1;
            AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1;
            byte b = this.$r8$classId;
            LibraryFilter libraryFilterValueOf = LibraryFilter.LIBRARY;
            LibraryViewType libraryViewTypeValueOf = LibraryViewType.GRID;
            GridItemSize gridItemSizeValueOf = GridItemSize.BIG;
            SongSortType songSortTypeValueOf = SongSortType.CREATE_DATE;
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
                    SearchSource searchSourceValueOf = SearchSource.ONLINE;
                    if (str != null) {
                        try {
                            searchSourceValueOf = SearchSource.valueOf(str);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    anonymousClass1.label = 1;
                    return flowCollector.emit(searchSourceValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i3 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj3 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i4 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                    AlbumFilter albumFilterValueOf = AlbumFilter.LIKED;
                    if (str2 != null) {
                        try {
                            albumFilterValueOf = AlbumFilter.valueOf(str2);
                            break;
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(albumFilterValueOf, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i5 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj4 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1.result;
                    int i6 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1.label;
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
                    AlbumSortType albumSortTypeValueOf = AlbumSortType.CREATE_DATE;
                    if (str3 != null) {
                        try {
                            albumSortTypeValueOf = AlbumSortType.valueOf(str3);
                            break;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(albumSortTypeValueOf, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 3:
                    if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1) continuation;
                        int i7 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                    }
                    Object obj5 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1.result;
                    int i8 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1.label;
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
                            gridItemSizeValueOf = GridItemSize.valueOf(str4);
                            break;
                        } catch (IllegalArgumentException unused4) {
                        }
                    }
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 4:
                    if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i9 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj6 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i10 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                            libraryViewTypeValueOf = LibraryViewType.valueOf(str5);
                            break;
                        } catch (IllegalArgumentException unused5) {
                        }
                    }
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(libraryViewTypeValueOf, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i11 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj7 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i12 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                    ArtistFilter artistFilterValueOf = ArtistFilter.LIKED;
                    if (str6 != null) {
                        try {
                            artistFilterValueOf = ArtistFilter.valueOf(str6);
                            break;
                        } catch (IllegalArgumentException unused6) {
                        }
                    }
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(artistFilterValueOf, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i13 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj8 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1.result;
                    int i14 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1.label;
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
                    ArtistSortType artistSortTypeValueOf = ArtistSortType.CREATE_DATE;
                    if (str7 != null) {
                        try {
                            artistSortTypeValueOf = ArtistSortType.valueOf(str7);
                            break;
                        } catch (IllegalArgumentException unused7) {
                        }
                    }
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(artistSortTypeValueOf, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1) continuation;
                        int i15 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                        }
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1(this, continuation);
                    }
                    Object obj9 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1.result;
                    int i16 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1.label;
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
                            gridItemSizeValueOf = GridItemSize.valueOf(str8);
                            break;
                        } catch (IllegalArgumentException unused8) {
                        }
                    }
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    if (continuation instanceof LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i17 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj10 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i18 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                    MixSortType mixSortTypeValueOf = MixSortType.CREATE_DATE;
                    if (str9 != null) {
                        try {
                            mixSortTypeValueOf = MixSortType.valueOf(str9);
                            break;
                        } catch (IllegalArgumentException unused9) {
                        }
                    }
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(mixSortTypeValueOf, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    if (continuation instanceof LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i19 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj11 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i20 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                            gridItemSizeValueOf = GridItemSize.valueOf(str10);
                            break;
                        } catch (IllegalArgumentException unused10) {
                        }
                    }
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 10:
                    if (continuation instanceof LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i21 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj12 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i22 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                    PlaylistSortType playlistSortTypeValueOf = PlaylistSortType.CREATE_DATE;
                    if (str11 != null) {
                        try {
                            playlistSortTypeValueOf = PlaylistSortType.valueOf(str11);
                            break;
                        } catch (IllegalArgumentException unused11) {
                        }
                    }
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(playlistSortTypeValueOf, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    if (continuation instanceof LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i23 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj13 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i24 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i25 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj14 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i26 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                    PodcastFilter podcastFilterValueOf = PodcastFilter.EPISODES;
                    if (str13 != null) {
                        try {
                            podcastFilterValueOf = PodcastFilter.valueOf(str13);
                            break;
                        } catch (IllegalArgumentException unused13) {
                        }
                    }
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(podcastFilterValueOf, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 13:
                    if (continuation instanceof LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i27 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj15 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i28 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                            songSortTypeValueOf = SongSortType.valueOf(str14);
                            break;
                        } catch (IllegalArgumentException unused14) {
                        }
                    }
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(songSortTypeValueOf, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 14:
                    if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i29 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj16 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i30 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                            libraryFilterValueOf = LibraryFilter.valueOf(str15);
                            break;
                        } catch (IllegalArgumentException unused15) {
                        }
                    }
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(libraryFilterValueOf, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 15:
                    if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i31 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj17 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i32 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                            libraryViewTypeValueOf = LibraryViewType.valueOf(str16);
                            break;
                        } catch (IllegalArgumentException unused16) {
                        }
                    }
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(libraryViewTypeValueOf, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 16:
                    if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1) continuation;
                        int i33 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                        }
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1(this, continuation);
                    }
                    Object obj18 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1.result;
                    int i34 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1.label;
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
                            libraryViewTypeValueOf = LibraryViewType.valueOf(str17);
                            break;
                        } catch (IllegalArgumentException unused17) {
                        }
                    }
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1.label = 1;
                    return flowCollector.emit(libraryViewTypeValueOf, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 17:
                    if (continuation instanceof LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1) {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i35 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj19 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i36 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                            songSortTypeValueOf = SongSortType.valueOf(str18);
                            break;
                        } catch (IllegalArgumentException unused18) {
                        }
                    }
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(songSortTypeValueOf, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 18:
                    if (continuation instanceof LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1) {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i37 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj20 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1.result;
                    int i38 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1.label;
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
                    SongFilter songFilterValueOf = SongFilter.LIKED;
                    if (str19 != null) {
                        try {
                            songFilterValueOf = SongFilter.valueOf(str19);
                            break;
                        } catch (IllegalArgumentException unused19) {
                        }
                    }
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(songFilterValueOf, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 19:
                    if (continuation instanceof AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) {
                        autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = (AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i39 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj21 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i40 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                            songSortTypeValueOf = SongSortType.valueOf(str20);
                            break;
                        } catch (IllegalArgumentException unused20) {
                        }
                    }
                    autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(songSortTypeValueOf, autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 20:
                    if (continuation instanceof CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1) {
                        cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = (CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i41 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj22 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i42 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                            songSortTypeValueOf = SongSortType.valueOf(str21);
                            break;
                        } catch (IllegalArgumentException unused21) {
                        }
                    }
                    cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(songSortTypeValueOf, cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 21:
                    if (continuation instanceof LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1) {
                        localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1 = (LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i43 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1 = new LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1 = new LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj23 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1.result;
                    int i44 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1.label;
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
                    DarkMode darkModeValueOf = DarkMode.AUTO;
                    if (str22 != null) {
                        try {
                            darkModeValueOf = DarkMode.valueOf(str22);
                            break;
                        } catch (IllegalArgumentException unused22) {
                        }
                    }
                    localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(darkModeValueOf, localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 22:
                    if (continuation instanceof LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) {
                        localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = (LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i45 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1 = new LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj24 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.result;
                    int i46 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label;
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
                    PlaylistSongSortType playlistSongSortTypeValueOf = PlaylistSongSortType.CUSTOM;
                    if (str23 != null) {
                        try {
                            playlistSongSortTypeValueOf = PlaylistSongSortType.valueOf(str23);
                            break;
                        } catch (IllegalArgumentException unused23) {
                        }
                    }
                    localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(playlistSongSortTypeValueOf, localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1) continuation;
                        int i47 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1(this, continuation);
                    }
                    Object obj25 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1.result;
                    int i48 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1.label;
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
                    MiniPlayerBackgroundStyle miniPlayerBackgroundStyleValueOf = MiniPlayerBackgroundStyle.DEFAULT;
                    if (str24 != null) {
                        try {
                            miniPlayerBackgroundStyleValueOf = MiniPlayerBackgroundStyle.valueOf(str24);
                            break;
                        } catch (IllegalArgumentException unused24) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1.label = 1;
                    return flowCollector.emit(miniPlayerBackgroundStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 24:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1) continuation;
                        int i49 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1(this, continuation);
                    }
                    Object obj26 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1.result;
                    int i50 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1.label;
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
                    LyricsAnimationStyle lyricsAnimationStyleValueOf = LyricsAnimationStyle.FADE;
                    if (str25 != null) {
                        try {
                            lyricsAnimationStyleValueOf = LyricsAnimationStyle.valueOf(str25);
                            break;
                        } catch (IllegalArgumentException unused25) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1.label = 1;
                    return flowCollector.emit(lyricsAnimationStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 25:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1) continuation;
                        int i51 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1(this, continuation);
                    }
                    Object obj27 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1.result;
                    int i52 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1.label;
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
                    SliderStyle sliderStyleValueOf = SliderStyle.DEFAULT;
                    if (str26 != null) {
                        try {
                            sliderStyleValueOf = SliderStyle.valueOf(str26);
                            break;
                        } catch (IllegalArgumentException unused26) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1.label = 1;
                    return flowCollector.emit(sliderStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 26:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1) continuation;
                        int i53 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1.label;
                        if ((i53 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1.label = i53 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1(this, continuation);
                    }
                    Object obj28 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1.result;
                    int i54 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1.label;
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
                    GridItemSize gridItemSizeValueOf2 = GridItemSize.SMALL;
                    if (str27 != null) {
                        try {
                            gridItemSizeValueOf2 = GridItemSize.valueOf(str27);
                            break;
                        } catch (IllegalArgumentException unused27) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1.label = 1;
                    return flowCollector.emit(gridItemSizeValueOf2, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 27:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1) continuation;
                        int i55 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1.label;
                        if ((i55 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1.label = i55 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1(this, continuation);
                    }
                    Object obj29 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1.result;
                    int i56 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1.label;
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
                            libraryFilterValueOf = LibraryFilter.valueOf(str28);
                            break;
                        } catch (IllegalArgumentException unused28) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1.label = 1;
                    return flowCollector.emit(libraryFilterValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 28:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1) continuation;
                        int i57 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1.label;
                        if ((i57 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1.label = i57 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1(this, continuation);
                    }
                    Object obj30 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1.result;
                    int i58 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1.label;
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
                    UiStyle uiStyleValueOf = UiStyle.EDITORIAL;
                    if (str29 != null) {
                        try {
                            uiStyleValueOf = UiStyle.valueOf(str29);
                            break;
                        } catch (IllegalArgumentException unused29) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1.label = 1;
                    return flowCollector.emit(uiStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1) continuation;
                        int i59 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1.label;
                        if ((i59 & Integer.MIN_VALUE) != 0) {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1.label = i59 - Integer.MIN_VALUE;
                        } else {
                            appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                        }
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1(this, continuation);
                    }
                    Object obj31 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1.result;
                    int i60 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1.label;
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
                    PlayerBackgroundStyle playerBackgroundStyleValueOf = PlayerBackgroundStyle.DEFAULT;
                    if (str30 != null) {
                        try {
                            playerBackgroundStyleValueOf = PlayerBackgroundStyle.valueOf(str30);
                            break;
                        } catch (IllegalArgumentException unused30) {
                        }
                    }
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1.label = 1;
                    return flowCollector.emit(playerBackgroundStyleValueOf, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(Flow flow, Preferences$Key preferences$Key, byte b) {
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
        LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1;
        LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1;
        LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1;
        LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1;
        LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1;
        LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1;
        LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1;
        LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1;
        LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1;
        LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1;
        LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1;
        LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1;
        LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1;
        LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1;
        LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1;
        LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1;
        LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1;
        LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1;
        AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1 autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1;
        CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1 cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1;
        LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1 localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1;
        LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1 localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1;
        AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1;
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
                if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i3 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj2 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1.result;
                int i4 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 1);
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass3, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1) {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1) continuation;
                    int i5 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj3 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1.result;
                int i6 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 2);
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass4, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1) {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1) continuation;
                    int i7 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1(this, continuation);
                    }
                } else {
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1(this, continuation);
                }
                Object obj4 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1.result;
                int i8 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 3);
                    libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1.label = 1;
                    return flow.collect(anonymousClass5, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$7$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i9 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj5 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i10 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 4);
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass6, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i11 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj6 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1.result;
                int i12 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 5);
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass7, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1) {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1) continuation;
                    int i13 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj7 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1.result;
                int i14 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 6);
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass8, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1) {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1) continuation;
                    int i15 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1(this, continuation);
                    }
                } else {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1(this, continuation);
                }
                Object obj8 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1.result;
                int i16 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 7);
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1.label = 1;
                    return flow.collect(anonymousClass9, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i17 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj9 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1.result;
                int i18 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 8);
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass10, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i19 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj10 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1.result;
                int i20 = libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 9);
                    libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass11, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i21 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj11 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i22 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 10);
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass12, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i23 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj12 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1.result;
                int i24 = libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 11);
                    libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass13, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i25 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj13 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i26 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 12);
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass14, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i27 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj14 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1.result;
                int i28 = libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 13);
                    libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass15, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1) {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i29 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj15 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1.result;
                int i30 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 14);
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass16, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1) {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i31 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj16 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1.result;
                int i32 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 15);
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass17, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1) {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1) continuation;
                    int i33 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                    }
                } else {
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1(this, continuation);
                }
                Object obj17 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1.result;
                int i34 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 16);
                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1.label = 1;
                    return flow.collect(anonymousClass18, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1) {
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i35 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj18 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1.result;
                int i36 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 17);
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass19, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1) {
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1) continuation;
                    int i37 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj19 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1.result;
                int i38 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 18);
                    librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass20, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1) {
                    autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1 = (AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i39 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj20 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1.result;
                int i40 = autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 19);
                    autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass21, autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1) {
                    cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1 = (CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i41 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1 = new CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1 = new CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj21 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1.result;
                int i42 = cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 20);
                    cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass22, cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1) {
                    localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1 = (LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1) continuation;
                    int i43 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1 = new LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1 = new LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj22 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1.result;
                int i44 = localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 21);
                    localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass23, localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1) {
                    localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1 = (LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1) continuation;
                    int i45 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1 = new LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1 = new LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj23 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1.result;
                int i46 = localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 22);
                    localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass24, localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1) continuation;
                    int i47 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1(this, continuation);
                }
                Object obj24 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1.result;
                int i48 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 24);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1.label = 1;
                    return flow.collect(anonymousClass25, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$11$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1) continuation;
                    int i49 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1(this, continuation);
                }
                Object obj25 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1.result;
                int i50 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 25);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1.label = 1;
                    return flow.collect(anonymousClass26, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$13$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 25:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1) continuation;
                    int i51 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1(this, continuation);
                }
                Object obj26 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1.result;
                int i52 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 26);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1.label = 1;
                    return flow.collect(anonymousClass27, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$15$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 26:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1) continuation;
                    int i53 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1.label;
                    if ((i53 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1.label = i53 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1(this, continuation);
                }
                Object obj27 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1.result;
                int i54 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1.label;
                if (i54 == 0) {
                    ResultKt.throwOnFailure(obj27);
                    AnonymousClass2 anonymousClass28 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 27);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1.label = 1;
                    return flow.collect(anonymousClass28, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$17$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i54 == 1) {
                    ResultKt.throwOnFailure(obj27);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 27:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1) continuation;
                    int i55 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1.label;
                    if ((i55 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1.label = i55 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1(this, continuation);
                }
                Object obj28 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1.result;
                int i56 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1.label;
                if (i56 == 0) {
                    ResultKt.throwOnFailure(obj28);
                    AnonymousClass2 anonymousClass29 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 28);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1.label = 1;
                    return flow.collect(anonymousClass29, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$19$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i56 == 1) {
                    ResultKt.throwOnFailure(obj28);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 28:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1) continuation;
                    int i57 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1.label;
                    if ((i57 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1.label = i57 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1(this, continuation);
                }
                Object obj29 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1.result;
                int i58 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1.label;
                if (i58 == 0) {
                    ResultKt.throwOnFailure(obj29);
                    AnonymousClass2 anonymousClass30 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 23);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1.label = 1;
                    return flow.collect(anonymousClass30, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i58 == 1) {
                    ResultKt.throwOnFailure(obj29);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1) {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1) continuation;
                    int i59 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1.label;
                    if ((i59 & Integer.MIN_VALUE) != 0) {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1.label = i59 - Integer.MIN_VALUE;
                    } else {
                        appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                    }
                } else {
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1 = new AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1(this, continuation);
                }
                Object obj30 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1.result;
                int i60 = appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1.label;
                if (i60 == 0) {
                    ResultKt.throwOnFailure(obj30);
                    AnonymousClass2 anonymousClass31 = new AnonymousClass2(flowCollector, preferences$Key, (byte) 29);
                    appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1.label = 1;
                    return flow.collect(anonymousClass31, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$3$1) == coroutineSingletons ? coroutineSingletons : unit;
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
