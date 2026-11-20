package com.metrolist.music;

import androidx.lifecycle.SavedStateHandle;
import androidx.media3.datasource.cache.SimpleCache;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.screens.equalizer.EQViewModel;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.AccountSettingsViewModel;
import com.metrolist.music.viewmodels.AccountViewModel;
import com.metrolist.music.viewmodels.AlbumViewModel;
import com.metrolist.music.viewmodels.ArtistAlbumsViewModel;
import com.metrolist.music.viewmodels.ArtistItemsViewModel;
import com.metrolist.music.viewmodels.ArtistSongsViewModel;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.BrowseViewModel;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.ChartsViewModel;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.music.viewmodels.LyricsViewModel;
import com.metrolist.music.viewmodels.MoodAndGenresViewModel;
import com.metrolist.music.viewmodels.NewReleaseViewModel;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.metrolist.music.viewmodels.PlaylistsViewModel;
import com.metrolist.music.viewmodels.StatsViewModel;
import com.metrolist.music.viewmodels.TopPlaylistViewModel;
import com.metrolist.music.viewmodels.YouTubeBrowseViewModel;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.internal.GeneratedComponent;
import dagger.internal.Provider;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DaggerApp_HiltComponents_SingletonC$ViewModelCImpl implements HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {
    public final SwitchingProvider accountSettingsViewModelProvider;
    public final SwitchingProvider accountViewModelProvider;
    public final SwitchingProvider albumViewModelProvider;
    public final SwitchingProvider artistAlbumsViewModelProvider;
    public final SwitchingProvider artistItemsViewModelProvider;
    public final SwitchingProvider artistSongsViewModelProvider;
    public final SwitchingProvider artistViewModelProvider;
    public final SwitchingProvider autoPlaylistViewModelProvider;
    public final SwitchingProvider backupRestoreViewModelProvider;
    public final SwitchingProvider browseViewModelProvider;
    public final SwitchingProvider cachePlaylistViewModelProvider;
    public final SwitchingProvider chartsViewModelProvider;
    public final SwitchingProvider eQViewModelProvider;
    public final SwitchingProvider historyViewModelProvider;
    public final SwitchingProvider homeViewModelProvider;
    public final SwitchingProvider libraryAlbumsViewModelProvider;
    public final SwitchingProvider libraryArtistsViewModelProvider;
    public final SwitchingProvider libraryMixViewModelProvider;
    public final SwitchingProvider libraryPlaylistsViewModelProvider;
    public final SwitchingProvider libraryPodcastsViewModelProvider;
    public final SwitchingProvider librarySongsViewModelProvider;
    public final SwitchingProvider localPlaylistViewModelProvider;
    public final SwitchingProvider localSearchViewModelProvider;
    public final SwitchingProvider lyricsMenuViewModelProvider;
    public final SwitchingProvider lyricsViewModelProvider;
    public final SwitchingProvider moodAndGenresViewModelProvider;
    public final SwitchingProvider newReleaseViewModelProvider;
    public final SwitchingProvider onlinePlaylistViewModelProvider;
    public final SwitchingProvider onlinePodcastViewModelProvider;
    public final SwitchingProvider onlineSearchSuggestionViewModelProvider;
    public final SwitchingProvider onlineSearchViewModelProvider;
    public final SwitchingProvider playlistsViewModelProvider;
    public final SavedStateHandle savedStateHandle;
    public final SwitchingProvider statsViewModelProvider;
    public final SwitchingProvider topPlaylistViewModelProvider;
    public final SwitchingProvider wizardViewModelProvider;
    public final SwitchingProvider youTubeBrowseViewModelProvider;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SwitchingProvider implements Provider {
        public final byte id;
        public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;
        public final DaggerApp_HiltComponents_SingletonC$ViewModelCImpl viewModelCImpl;

        /* JADX WARN: Multi-variable type inference failed */
        public SwitchingProvider(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ViewModelCImpl daggerApp_HiltComponents_SingletonC$ViewModelCImpl, int i) {
            this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
            this.viewModelCImpl = daggerApp_HiltComponents_SingletonC$ViewModelCImpl;
            this.id = i;
        }

        @Override // dagger.internal.Provider
        public final Object get() {
            DaggerApp_HiltComponents_SingletonC$ViewModelCImpl daggerApp_HiltComponents_SingletonC$ViewModelCImpl = this.viewModelCImpl;
            DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.singletonCImpl;
            byte b = this.id;
            switch (b) {
                case 0:
                    ((SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get()).getClass();
                    return new AccountSettingsViewModel();
                case 1:
                    return new AccountViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 2:
                    return new AlbumViewModel((MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                case 3:
                    return new ArtistAlbumsViewModel((MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                case 4:
                    return new ArtistItemsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                case 5:
                    return new ArtistSongsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 6:
                    return new ArtistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 7:
                    return new AutoPlaylistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 8:
                    return new BackupRestoreViewModel((MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 9:
                    return new BrowseViewModel(daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                case 10:
                    return new CachePlaylistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SimpleCache) daggerApp_HiltComponents_SingletonC$SingletonCImpl.providePlayerCacheProvider.get());
                case 11:
                    return new ChartsViewModel();
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new EQViewModel((EQProfileRepository) daggerApp_HiltComponents_SingletonC$SingletonCImpl.eQProfileRepositoryProvider.get(), (EqualizerService) daggerApp_HiltComponents_SingletonC$SingletonCImpl.equalizerServiceProvider.get());
                case 13:
                    return new HistoryViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 14:
                    return new HomeViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get(), (NetworkConnectivityObserver) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideNetworkConnectivityObserverProvider.get());
                case 15:
                    return new LibraryAlbumsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 16:
                    return new LibraryArtistsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 17:
                    return new LibraryMixViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 18:
                    return new LibraryPlaylistsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 19:
                    return new LibraryPodcastsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 20:
                    return new LibrarySongsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (DownloadUtil) daggerApp_HiltComponents_SingletonC$SingletonCImpl.downloadUtilProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 21:
                    return new LocalPlaylistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 22:
                    return new LocalSearchViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 23:
                    return new LyricsMenuViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.lyricsHelper(), (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (NetworkConnectivityObserver) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideNetworkConnectivityObserverProvider.get());
                case 24:
                    return new LyricsViewModel();
                case 25:
                    return new MoodAndGenresViewModel();
                case 26:
                    return new NewReleaseViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 27:
                    return new OnlinePlaylistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 28:
                    return new OnlinePodcastViewModel(daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 29:
                    return new OnlineSearchSuggestionViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 30:
                    return new OnlineSearchViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                case 31:
                    return new PlaylistsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get());
                case 32:
                    return new StatsViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 33:
                    return new TopPlaylistViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 34:
                    return new WizardViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (EQProfileRepository) daggerApp_HiltComponents_SingletonC$SingletonCImpl.eQProfileRepositoryProvider.get());
                case 35:
                    return new YouTubeBrowseViewModel(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, daggerApp_HiltComponents_SingletonC$ViewModelCImpl.savedStateHandle);
                default:
                    throw new AssertionError((int) b);
            }
        }
    }

    public DaggerApp_HiltComponents_SingletonC$ViewModelCImpl(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        this.accountSettingsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 0);
        this.accountViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 1);
        this.albumViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 2);
        this.artistAlbumsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 3);
        this.artistItemsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 4);
        this.artistSongsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 5);
        this.artistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 6);
        this.autoPlaylistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 7);
        this.backupRestoreViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 8);
        this.browseViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 9);
        this.cachePlaylistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 10);
        this.chartsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 11);
        this.eQViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 12);
        this.historyViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 13);
        this.homeViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 14);
        this.libraryAlbumsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 15);
        this.libraryArtistsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 16);
        this.libraryMixViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 17);
        this.libraryPlaylistsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 18);
        this.libraryPodcastsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 19);
        this.librarySongsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 20);
        this.localPlaylistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 21);
        this.localSearchViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 22);
        this.lyricsMenuViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 23);
        this.lyricsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 24);
        this.moodAndGenresViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 25);
        this.newReleaseViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 26);
        this.onlinePlaylistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 27);
        this.onlinePodcastViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 28);
        this.onlineSearchSuggestionViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 29);
        this.onlineSearchViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 30);
        this.playlistsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 31);
        this.statsViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 32);
        this.topPlaylistViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 33);
        this.wizardViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 34);
        this.youTubeBrowseViewModelProvider = new SwitchingProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl, this, 35);
    }
}
