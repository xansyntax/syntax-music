package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.Preferences$Key;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.artist.ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.playlist.CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Function1 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ MutableState this$0;

        public /* synthetic */ AnonymousClass2(MutableState mutableState, byte b) {
            this.$r8$classId = b;
            this.this$0 = mutableState;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            MutableState mutableState = this.this$0;
            switch (b) {
                case 0:
                    Enum r17 = (Enum) obj;
                    r17.getClass();
                    HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2 homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2 = (HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.$context, homeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.$key, r17, null, (byte) 23), 3);
                    break;
                case 1:
                    Enum r12 = (Enum) obj;
                    r12.getClass();
                    BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2 browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2 = (BrowseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2.$context, browseScreenKt$BrowseScreen$$inlined$rememberEnumPreference$2.$key, r12, null, (byte) 21), 3);
                    break;
                case 2:
                    Enum r7 = (Enum) obj;
                    r7.getClass();
                    ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2 composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2 = (ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.$context, composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.$key, r7, null, (byte) 22), 3);
                    break;
                case 3:
                    Enum r18 = (Enum) obj;
                    r18.getClass();
                    NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2 newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2 = (NewReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2.$context, newReleaseScreenKt$NewReleaseScreen$$inlined$rememberEnumPreference$2.$key, r18, null, (byte) 24), 3);
                    break;
                case 4:
                    Enum r13 = (Enum) obj;
                    r13.getClass();
                    YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2 youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2 = (YouTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2.$context, youTubeBrowseScreenKt$YouTubeBrowseScreen$$inlined$rememberEnumPreference$2.$key, r13, null, (byte) 25), 3);
                    break;
                case 5:
                    Enum r8 = (Enum) obj;
                    r8.getClass();
                    ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2 artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2 = (ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2.$context, artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2.$key, r8, null, (byte) 26), 3);
                    break;
                case 6:
                    Enum r19 = (Enum) obj;
                    r19.getClass();
                    ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2 artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2 = (ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2.$context, artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2.$key, r19, null, (byte) 27), 3);
                    break;
                case 7:
                    Enum r14 = (Enum) obj;
                    r14.getClass();
                    ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2 artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2 = (ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2.$context, artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2.$key, r14, null, (byte) 28), 3);
                    break;
                case 8:
                    Enum r9 = (Enum) obj;
                    r9.getClass();
                    LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2.$context, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2.$key, r9, null, (byte) 29), 3);
                    break;
                case 9:
                    Enum r110 = (Enum) obj;
                    r110.getClass();
                    LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4.$context, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4.$key, r110, null, (byte) 1), 3);
                    break;
                case 10:
                    Enum r15 = (Enum) obj;
                    r15.getClass();
                    LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6) mutableState;
                    AwaitKt.launch$default(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6.$context, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6.$key, r15, null, (byte) 2), 3);
                    break;
                case 11:
                    Enum r10 = (Enum) obj;
                    r10.getClass();
                    LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8) mutableState;
                    AwaitKt.launch$default(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8.$context, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8.$key, r10, null, (byte) 3), 3);
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    Enum r111 = (Enum) obj;
                    r111.getClass();
                    LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2.$context, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2.$key, r111, null, (byte) 4), 3);
                    break;
                case 13:
                    Enum r16 = (Enum) obj;
                    r16.getClass();
                    LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4.$context, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4.$key, r16, null, (byte) 5), 3);
                    break;
                case 14:
                    Enum r11 = (Enum) obj;
                    r11.getClass();
                    LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6) mutableState;
                    AwaitKt.launch$default(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6.$context, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6.$key, r11, null, (byte) 6), 3);
                    break;
                case 15:
                    Enum r112 = (Enum) obj;
                    r112.getClass();
                    LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8) mutableState;
                    AwaitKt.launch$default(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8.$context, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8.$key, r112, null, (byte) 7), 3);
                    break;
                case 16:
                    Enum r113 = (Enum) obj;
                    r113.getClass();
                    LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2.$context, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2.$key, r113, null, (byte) 8), 3);
                    break;
                case 17:
                    Enum r20 = (Enum) obj;
                    r20.getClass();
                    LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4.$context, libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4.$key, r20, null, (byte) 9), 3);
                    break;
                case 18:
                    Enum r114 = (Enum) obj;
                    r114.getClass();
                    LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2.$context, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2.$key, r114, null, (byte) 10), 3);
                    break;
                case 19:
                    Enum r115 = (Enum) obj;
                    r115.getClass();
                    LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4.$context, libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4.$key, r115, null, (byte) 11), 3);
                    break;
                case 20:
                    Enum r21 = (Enum) obj;
                    r21.getClass();
                    LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2.$context, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2.$key, r21, null, (byte) 12), 3);
                    break;
                case 21:
                    Enum r116 = (Enum) obj;
                    r116.getClass();
                    LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4.$context, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4.$key, r116, null, (byte) 13), 3);
                    break;
                case 22:
                    Enum r117 = (Enum) obj;
                    r117.getClass();
                    LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2.$context, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2.$key, r117, null, (byte) 14), 3);
                    break;
                case 23:
                    Enum r22 = (Enum) obj;
                    r22.getClass();
                    LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$context, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$key, r22, null, (byte) 15), 3);
                    break;
                case 24:
                    Enum r118 = (Enum) obj;
                    r118.getClass();
                    LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6) mutableState;
                    AwaitKt.launch$default(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$context, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$key, r118, null, (byte) 16), 3);
                    break;
                case 25:
                    Enum r119 = (Enum) obj;
                    r119.getClass();
                    LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2.$context, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2.$key, r119, null, (byte) 17), 3);
                    break;
                case 26:
                    Enum r23 = (Enum) obj;
                    r23.getClass();
                    LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) mutableState;
                    AwaitKt.launch$default(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4.$context, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4.$key, r23, null, (byte) 18), 3);
                    break;
                case 27:
                    Enum r120 = (Enum) obj;
                    r120.getClass();
                    AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2 autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2 = (AutoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2.$context, autoPlaylistScreenKt$AutoPlaylistScreen$$inlined$rememberEnumPreference$2.$key, r120, null, (byte) 19), 3);
                    break;
                case 28:
                    Enum r121 = (Enum) obj;
                    r121.getClass();
                    CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2 cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2 = (CachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2.$context, cachePlaylistScreenKt$CachePlaylistScreen$$inlined$rememberEnumPreference$2.$key, r121, null, (byte) 20), 3);
                    break;
                default:
                    Enum r24 = (Enum) obj;
                    r24.getClass();
                    LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2 localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2 = (LocalPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2) mutableState;
                    AwaitKt.launch$default(localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2.$context, localPlaylistScreenKt$LocalPlaylistHeader$$inlined$rememberEnumPreference$2.$key, r24, null, (byte) 21), 3);
                    break;
            }
            return unit;
        }
    }

    public HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
        this.$state = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$context = context;
        this.$key = preferences$Key;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new AnonymousClass2(this, (byte) 0);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        Enum r3 = (Enum) obj;
        r3.getClass();
        AwaitKt.launch$default(this.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(this.$context, this.$key, r3, null, (byte) 23), 3);
    }
}
