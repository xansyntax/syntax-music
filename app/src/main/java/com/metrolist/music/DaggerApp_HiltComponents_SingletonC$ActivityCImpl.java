package com.metrolist.music;

import com.google.common.collect.Maps;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$ActivityEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.internal.GeneratedComponent;
import dagger.internal.LazyClassKeyMap;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DaggerApp_HiltComponents_SingletonC$ActivityCImpl implements MainActivity_GeneratedInjector, DefaultViewModelFactories$ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, GeneratedComponent {
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl;
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

    public DaggerApp_HiltComponents_SingletonC$ActivityCImpl(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) {
        this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
        this.activityRetainedCImpl = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
    }

    public final LazyClassKeyMap getViewModelKeys() {
        Maps.checkNonnegative(36, "expectedSize");
        StatusLine statusLine = new StatusLine(36);
        Boolean bool = Boolean.TRUE;
        statusLine.put("com.metrolist.music.viewmodels.AccountSettingsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.AccountViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.AlbumViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.ArtistAlbumsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.ArtistItemsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.ArtistSongsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.ArtistViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.AutoPlaylistViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.BackupRestoreViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.BrowseViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.CachePlaylistViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.ChartsViewModel", bool);
        statusLine.put("com.metrolist.music.ui.screens.equalizer.EQViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.HistoryViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.HomeViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibraryAlbumsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibraryArtistsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibraryMixViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibraryPlaylistsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibraryPodcastsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LibrarySongsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LocalPlaylistViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LocalSearchViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LyricsMenuViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.LyricsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.MoodAndGenresViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.NewReleaseViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.OnlinePlaylistViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.OnlinePodcastViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.OnlineSearchViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.PlaylistsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.StatsViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.TopPlaylistViewModel", bool);
        statusLine.put("com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel", bool);
        statusLine.put("com.metrolist.music.viewmodels.YouTubeBrowseViewModel", bool);
        return new LazyClassKeyMap(statusLine.build(true));
    }
}
