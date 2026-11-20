package com.metrolist.music.db;

import androidx.compose.foundation.MutatorMutex;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.room.TransactionExecutor;
import coil3.util.UtilsKt;
import com.dokar.quickjs.QuickJs;
import com.google.common.base.Joiner;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlayCountEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.RelatedSongMap;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onGetChildren$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$playlistDuplicatesBatched$1;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$2$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import com.metrolist.music.utils.SyncUtils$executeSyncSavedPlaylists$2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicDatabase implements DatabaseDao {
    public final /* synthetic */ DatabaseDao $$delegate_0;
    public final InternalDatabase delegate;

    public MusicDatabase(InternalDatabase internalDatabase) {
        this.$$delegate_0 = internalDatabase.getDao();
        this.delegate = internalDatabase;
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void addLibraryTokens(String str, String str2, String str3) {
        str.getClass();
        this.$$delegate_0.addLibraryTokens(str, str2, str3);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object addSongsToPlaylist(Playlist playlist, List list, boolean z, ContinuationImpl continuationImpl) {
        return this.$$delegate_0.addSongsToPlaylist(playlist, list, z, continuationImpl);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object addToPlayCountRow(String str, int i, int i2, int i3, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.addToPlayCountRow(str, i, i2, i3, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow album(String str) {
        str.getClass();
        return this.$$delegate_0.album(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumEntity(String str, SuspendLambda suspendLambda) {
        return this.$$delegate_0.albumEntity(str, suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumSongs(String str) {
        str.getClass();
        return this.$$delegate_0.albumSongs(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumWithSongs(String str) {
        str.getClass();
        return this.$$delegate_0.albumWithSongs(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albums(AlbumSortType albumSortType, boolean z) {
        albumSortType.getClass();
        return this.$$delegate_0.albums(albumSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.albumsByCreateDateAsc(i, i2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByLengthAsc() {
        return this.$$delegate_0.albumsByLengthAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByNameAsc() {
        return this.$$delegate_0.albumsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByPlayTimeAsc() {
        return this.$$delegate_0.albumsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsBySongCountAsc() {
        return this.$$delegate_0.albumsBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByYearAsc() {
        return this.$$delegate_0.albumsByYearAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLiked(AlbumSortType albumSortType, boolean z) {
        albumSortType.getClass();
        return this.$$delegate_0.albumsLiked(albumSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByCreateDateAsc() {
        return this.$$delegate_0.albumsLikedByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByLengthAsc() {
        return this.$$delegate_0.albumsLikedByLengthAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByNameAsc() {
        return this.$$delegate_0.albumsLikedByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByPlayTimeAsc() {
        return this.$$delegate_0.albumsLikedByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedBySongCountAsc() {
        return this.$$delegate_0.albumsLikedBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByYearAsc() {
        return this.$$delegate_0.albumsLikedByYearAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploaded(AlbumSortType albumSortType, boolean z) {
        albumSortType.getClass();
        return this.$$delegate_0.albumsUploaded(albumSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByCreateDateAsc() {
        return this.$$delegate_0.albumsUploadedByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByLengthAsc() {
        return this.$$delegate_0.albumsUploadedByLengthAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByNameAsc() {
        return this.$$delegate_0.albumsUploadedByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByPlayTimeAsc() {
        return this.$$delegate_0.albumsUploadedByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedBySongCountAsc() {
        return this.$$delegate_0.albumsUploadedBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByYearAsc() {
        return this.$$delegate_0.albumsUploadedByYearAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow allArtistsByPlayTime() {
        return this.$$delegate_0.allArtistsByPlayTime();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow allSongs() {
        return this.$$delegate_0.allSongs();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artist(String str) {
        str.getClass();
        return this.$$delegate_0.artist(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistAlbumsPreview(String str) {
        str.getClass();
        return this.$$delegate_0.artistAlbumsPreview(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final ArtistEntity artistByName(String str) {
        str.getClass();
        return this.$$delegate_0.artistByName(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistEntity(String str, QuickJs.AnonymousClass3 anonymousClass3) {
        return this.$$delegate_0.artistEntity(str, anonymousClass3);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongs(String str, ArtistSongSortType artistSongSortType, boolean z) {
        str.getClass();
        artistSongSortType.getClass();
        return this.$$delegate_0.artistSongs(str, artistSongSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByCreateDateAsc(String str) {
        str.getClass();
        return this.$$delegate_0.artistSongsByCreateDateAsc(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByNameAsc(String str) {
        str.getClass();
        return this.$$delegate_0.artistSongsByNameAsc(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByPlayTimeAsc(String str) {
        str.getClass();
        return this.$$delegate_0.artistSongsByPlayTimeAsc(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsPreview(String str) {
        str.getClass();
        return this.$$delegate_0.artistSongsPreview(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artists(ArtistSortType artistSortType, boolean z) {
        artistSortType.getClass();
        return this.$$delegate_0.artists(artistSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarked(ArtistSortType artistSortType, boolean z) {
        artistSortType.getClass();
        return this.$$delegate_0.artistsBookmarked(artistSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByCreateDateAsc() {
        return this.$$delegate_0.artistsBookmarkedByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByNameAsc() {
        return this.$$delegate_0.artistsBookmarkedByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByPlayTimeAsc() {
        return this.$$delegate_0.artistsBookmarkedByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedBySongCountAsc() {
        return this.$$delegate_0.artistsBookmarkedBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.artistsByCreateDateAsc(i, i2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByNameAsc() {
        return this.$$delegate_0.artistsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByPlayTimeAsc() {
        return this.$$delegate_0.artistsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBySongCountAsc() {
        return this.$$delegate_0.artistsBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object bookmarkedArtistEntitiesByNameAsc(QuickJs.AnonymousClass3 anonymousClass3) {
        return this.$$delegate_0.bookmarkedArtistEntitiesByNameAsc(anonymousClass3);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object bookmarkedPlaylistBrowseIds(MediaLibrarySessionCallback$onGetChildren$1 mediaLibrarySessionCallback$onGetChildren$1) {
        return this.$$delegate_0.bookmarkedPlaylistBrowseIds(mediaLibrarySessionCallback$onGetChildren$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow bookmarkedPodcastChannels() {
        return this.$$delegate_0.bookmarkedPodcastChannels();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow cachePlaylistSongs() {
        return this.$$delegate_0.cachePlaylistSongs();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void checkpoint() {
        this.$$delegate_0.checkpoint();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearListenHistory() {
        this.$$delegate_0.clearListenHistory();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearPlaylist(String str) {
        str.getClass();
        this.$$delegate_0.clearPlaylist(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearRecognitionHistory() {
        this.$$delegate_0.clearRecognitionHistory();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearSearchHistory() {
        this.$$delegate_0.clearSearchHistory();
    }

    public final void close() throws Exception {
        Dispatcher dispatcher = this.delegate.closeBarrier;
        synchronized (dispatcher) {
            if (((AtomicBoolean) dispatcher.runningAsyncCalls).compareAndSet(false, true)) {
                while (((AtomicInteger) dispatcher.readyAsyncCalls).get() != 0) {
                }
                ((RoomDatabase$closeBarrier$1) dispatcher.executorServiceOrNull).invoke();
                ((AtomicBoolean) dispatcher.runningSyncCalls).compareAndSet(false, true);
            }
        }
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(Event event) {
        event.getClass();
        this.$$delegate_0.delete(event);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void deleteFormat(String str) {
        str.getClass();
        this.$$delegate_0.deleteFormat(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object deletePlayCountsForSong(String str, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.deletePlayCountsForSong(str, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void deleteRecognitionHistoryById(long j) {
        this.$$delegate_0.deleteRecognitionHistoryById(j);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodes(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.downloadedPodcastEpisodes(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByCreateDateAsc() {
        return this.$$delegate_0.downloadedPodcastEpisodesByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByNameAsc() {
        return this.$$delegate_0.downloadedPodcastEpisodesByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByPlayTimeAsc() {
        return this.$$delegate_0.downloadedPodcastEpisodesByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongs(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.downloadedSongs(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByCreateDateAsc() {
        return this.$$delegate_0.downloadedSongsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByNameAsc() {
        return this.$$delegate_0.downloadedSongsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByPlayTimeAsc() {
        return this.$$delegate_0.downloadedSongsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow eventCount() {
        return this.$$delegate_0.eventCount();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object existingSongIds(List list, MediaLibrarySessionCallback.C01641 c01641) {
        return this.$$delegate_0.existingSongIds(list, c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow firstEvent() {
        return this.$$delegate_0.firstEvent();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow forgottenFavorites(long j) {
        return this.$$delegate_0.forgottenFavorites(j);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow format(String str) {
        return this.$$delegate_0.format(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow getLifetimePlayCount(String str) {
        return this.$$delegate_0.getLifetimePlayCount(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getPlayCountsForSong(String str, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.getPlayCountsForSong(str, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Long getPlaybackPosition(String str) {
        str.getClass();
        return this.$$delegate_0.getPlaybackPosition(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow getRelatedSongs(String str) {
        str.getClass();
        return this.$$delegate_0.getRelatedSongs(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSetVideoId(String str, ContinuationImpl continuationImpl) {
        return this.$$delegate_0.getSetVideoId(str, continuationImpl);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSongById(String str, MusicService.C01661 c01661) {
        return this.$$delegate_0.getSongById(str, c01661);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Song getSongByIdBlocking(String str) {
        str.getClass();
        return this.$$delegate_0.getSongByIdBlocking(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSongsByIds(List list, MediaLibrarySessionCallback.C01641 c01641) {
        return this.$$delegate_0.getSongsByIds(list, c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Long getTotalPlayTimeForSong(String str) {
        str.getClass();
        return this.$$delegate_0.getTotalPlayTimeForSong(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final boolean hasRelatedSongs(String str) {
        str.getClass();
        return this.$$delegate_0.hasRelatedSongs(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow historyEvents(LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, LocalDateTime localDateTime4, LocalDateTime localDateTime5) {
        return this.$$delegate_0.historyEvents(localDateTime, localDateTime2, localDateTime3, localDateTime4, localDateTime5);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void inLibrary(String str, LocalDateTime localDateTime) {
        str.getClass();
        this.$$delegate_0.inLibrary(str, localDateTime);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void incrementTotalPlayTime(long j, String str) {
        str.getClass();
        this.$$delegate_0.incrementTotalPlayTime(j, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(MediaMetadata mediaMetadata, Function1 function1) {
        mediaMetadata.getClass();
        function1.getClass();
        this.$$delegate_0.insert(mediaMetadata, function1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object insertPlayCountRow(PlayCountEntity playCountEntity, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.insertPlayCountRow(playCountEntity, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow latestEvent() {
        return this.$$delegate_0.latestEvent();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object librarySongEntitiesByNameAsc(MutatorMutex.AnonymousClass2 anonymousClass2) {
        return this.$$delegate_0.librarySongEntitiesByNameAsc(anonymousClass2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedAlbumEntitiesByNameAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return this.$$delegate_0.likedAlbumEntitiesByNameAsc(syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedSongIds(SongMenuKt$SongMenu$2$1$1 songMenuKt$SongMenu$2$1$1) {
        return this.$$delegate_0.likedSongIds(songMenuKt$SongMenu$2$1$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongs(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.likedSongs(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByCreateDateAsc() {
        return this.$$delegate_0.likedSongsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedSongsByCreateDateDesc(int i, int i2, MediaLibrarySessionCallback.C01641 c01641) {
        return this.$$delegate_0.likedSongsByCreateDateDesc(i, i2, c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByNameAsc() {
        return this.$$delegate_0.likedSongsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByPlayTimeAsc() {
        return this.$$delegate_0.likedSongsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByRowIdAsc() {
        return this.$$delegate_0.likedSongsByRowIdAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsCount() {
        return this.$$delegate_0.likedSongsCount();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow lyrics(String str) {
        return this.$$delegate_0.lyrics(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedAlbums(LocalDateTime localDateTime, int i, int i2, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        return this.$$delegate_0.mostPlayedAlbums(localDateTime, i, i2, localDateTime2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedArtists(LocalDateTime localDateTime, int i, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        return this.$$delegate_0.mostPlayedArtists(localDateTime, i, localDateTime2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedSongs(LocalDateTime localDateTime, int i, int i2, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        return this.$$delegate_0.mostPlayedSongs(localDateTime, i, i2, localDateTime2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedSongsStats(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        return this.$$delegate_0.mostPlayedSongsStats(localDateTime, localDateTime2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void move(int i, int i2, String str) {
        str.getClass();
        this.$$delegate_0.move(i, i2, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlist(String str) {
        str.getClass();
        return this.$$delegate_0.playlist(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Playlist playlistBlocking(String str) {
        str.getClass();
        return this.$$delegate_0.playlistBlocking(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistByBrowseId(String str) {
        str.getClass();
        return this.$$delegate_0.playlistByBrowseId(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistDuplicates(String str, List list, AddToPlaylistDialogKt$playlistDuplicatesBatched$1 addToPlaylistDialogKt$playlistDuplicatesBatched$1) {
        return this.$$delegate_0.playlistDuplicates(str, list, addToPlaylistDialogKt$playlistDuplicatesBatched$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistEntitiesByNameAsc(SuspendLambda suspendLambda) {
        return this.$$delegate_0.playlistEntitiesByNameAsc(suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistSongIdsWithoutArtists(String str, SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return this.$$delegate_0.playlistSongIdsWithoutArtists(str, syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final List playlistSongMaps(String str) {
        str.getClass();
        return this.$$delegate_0.playlistSongMaps(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistSongs(String str) {
        str.getClass();
        return this.$$delegate_0.playlistSongs(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlists(PlaylistSortType playlistSortType, boolean z) {
        playlistSortType.getClass();
        return this.$$delegate_0.playlists(playlistSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.C01651 c01651) {
        return this.$$delegate_0.playlistsByCreateDateAsc(i, i2, c01651);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByNameAsc() {
        return this.$$delegate_0.playlistsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsBySongCountAsc() {
        return this.$$delegate_0.playlistsBySongCountAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByUpdatedDateAsc() {
        return this.$$delegate_0.playlistsByUpdatedDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow podcast(String str) {
        str.getClass();
        return this.$$delegate_0.podcast(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow podcastEpisodesByCreateDateAsc() {
        return this.$$delegate_0.podcastEpisodesByCreateDateAsc();
    }

    public final void query(Function1 function1) {
        Executor executor = this.delegate.internalQueryExecutor;
        if (executor != null) {
            executor.execute(new MusicDatabase$$ExternalSyntheticLambda0(function1, this, (byte) 0));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
            throw null;
        }
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow quickPicks(long j) {
        return this.$$delegate_0.quickPicks(j);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final int raw(Joiner joiner) {
        return this.$$delegate_0.raw(joiner);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow recognitionHistory() {
        return this.$$delegate_0.recognitionHistory();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void repairMissingVideoThumbnails() {
        this.$$delegate_0.repairMissingVideoThumbnails();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void replaceSongArtists(String str, ArrayList arrayList) {
        str.getClass();
        this.$$delegate_0.replaceSongArtists(str, arrayList);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object savedEpisodeEntitiesByCreateDateAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return this.$$delegate_0.savedEpisodeEntitiesByCreateDateAsc(syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodes(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.savedPodcastEpisodes(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByCreateDateAsc() {
        return this.$$delegate_0.savedPodcastEpisodesByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByNameAsc() {
        return this.$$delegate_0.savedPodcastEpisodesByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByPlayTimeAsc() {
        return this.$$delegate_0.savedPodcastEpisodesByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchAlbums(int i, String str) {
        str.getClass();
        return this.$$delegate_0.searchAlbums(i, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchArtists(int i, String str) {
        str.getClass();
        return this.$$delegate_0.searchArtists(i, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchHistory(String str) {
        str.getClass();
        return this.$$delegate_0.searchHistory(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchPlaylists(int i, String str) {
        str.getClass();
        return this.$$delegate_0.searchPlaylists(i, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchSongs(int i, String str) {
        str.getClass();
        return this.$$delegate_0.searchSongs(i, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchSongsExtended(int i, String str) {
        str.getClass();
        return this.$$delegate_0.searchSongsExtended(i, str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow song(String str) {
        return this.$$delegate_0.song(str);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object songEntity(String str, SuspendLambda suspendLambda) {
        return this.$$delegate_0.songEntity(str, suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final List songIdsWithoutArtists(List list) {
        list.getClass();
        return this.$$delegate_0.songIdsWithoutArtists(list);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songs(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.songs(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object songsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.songsByCreateDateAsc(i, i2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByNameAsc() {
        return this.$$delegate_0.songsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByPlayTimeAsc() {
        return this.$$delegate_0.songsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByRowIdAsc() {
        return this.$$delegate_0.songsByRowIdAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsInBookmarkedPlaylists() {
        return this.$$delegate_0.songsInBookmarkedPlaylists();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow subscribedPodcasts() {
        return this.$$delegate_0.subscribedPodcasts();
    }

    public final void transaction(Function1 function1) {
        InternalDatabase internalDatabase = this.delegate;
        TransactionExecutor transactionExecutor = internalDatabase.internalTransactionExecutor;
        if (transactionExecutor != null) {
            transactionExecutor.execute(new Util$$ExternalSyntheticLambda1((Object) internalDatabase, (Object) function1, (Object) this, (byte) 20));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
            throw null;
        }
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object transferEvents(String str, String str2, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.transferEvents(str, str2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object transferSongStats(String str, String str2, InnerTube$feedback$2 innerTube$feedback$2) {
        return this.$$delegate_0.transferSongStats(str, str2, innerTube$feedback$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(AlbumEntity albumEntity, AlbumPage albumPage, List list) {
        albumEntity.getClass();
        albumPage.getClass();
        this.$$delegate_0.update(albumEntity, albumPage, list);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updateArtistThumbnail(String str, String str2) {
        str.getClass();
        this.$$delegate_0.updateArtistThumbnail(str, str2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updateDownloadedInfo(String str, boolean z, LocalDateTime localDateTime) {
        str.getClass();
        this.$$delegate_0.updateDownloadedInfo(str, z, localDateTime);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updatePlaybackPosition(String str, Long l) {
        str.getClass();
        this.$$delegate_0.updatePlaybackPosition(str, l);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object uploadedAlbumEntitiesByNameAsc(SyncUtils$executeSyncSavedPlaylists$2 syncUtils$executeSyncSavedPlaylists$2) {
        return this.$$delegate_0.uploadedAlbumEntitiesByNameAsc(syncUtils$executeSyncSavedPlaylists$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object uploadedSongEntitiesByNameAsc(SyncUtils.C01852 c01852) {
        return this.$$delegate_0.uploadedSongEntitiesByNameAsc(c01852);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongs(SongSortType songSortType, boolean z) {
        songSortType.getClass();
        return this.$$delegate_0.uploadedSongs(songSortType, z);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByCreateDateAsc() {
        return this.$$delegate_0.uploadedSongsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByNameAsc() {
        return this.$$delegate_0.uploadedSongsByNameAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByPlayTimeAsc() {
        return this.$$delegate_0.uploadedSongsByPlayTimeAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByRowIdAsc() {
        return this.$$delegate_0.uploadedSongsByRowIdAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(FormatEntity formatEntity) {
        this.$$delegate_0.upsert(formatEntity);
    }

    public final Object withTransaction(Function2 function2, Continuation continuation) {
        Continuation continuation2 = null;
        InternalDatabase internalDatabase = this.delegate;
        Object objWithTransactionContext = UtilsKt.withTransactionContext(internalDatabase, continuation, new InnerTube$executeMutation$2$1(internalDatabase, new InnerTube$executeMutation$2$1(function2, this, continuation2, (byte) 7), continuation2, (byte) 4));
        return objWithTransactionContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithTransactionContext : Unit.INSTANCE;
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(LyricsEntity lyricsEntity) {
        this.$$delegate_0.upsert(lyricsEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByCreateDateAsc() {
        return this.$$delegate_0.albumsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByCreateDateAsc() {
        return this.$$delegate_0.artistsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByCreateDateAsc() {
        return this.$$delegate_0.playlistsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByCreateDateAsc() {
        return this.$$delegate_0.songsByCreateDateAsc();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(SongEntity songEntity) {
        this.$$delegate_0.upsert(songEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(AlbumEntity albumEntity) {
        this.$$delegate_0.delete(albumEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumSongs(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.albumSongs(str, i, i2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistSongsByCreateDateAsc(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return this.$$delegate_0.artistSongsByCreateDateAsc(str, i, i2, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(LyricsEntity lyricsEntity) {
        lyricsEntity.getClass();
        this.$$delegate_0.delete(lyricsEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistSongs(String str, int i, int i2, MediaLibrarySessionCallback.C01641 c01641) {
        return this.$$delegate_0.playlistSongs(str, i, i2, c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(PlaylistEntity playlistEntity) {
        this.$$delegate_0.delete(playlistEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(PlaylistSongMap playlistSongMap) {
        this.$$delegate_0.delete(playlistSongMap);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(PodcastEntity podcastEntity) {
        return this.$$delegate_0.insert(podcastEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(AlbumEntity albumEntity) {
        this.$$delegate_0.update(albumEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(SearchHistory searchHistory) {
        this.$$delegate_0.delete(searchHistory);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(RecognitionHistory recognitionHistory) {
        return this.$$delegate_0.insert(recognitionHistory);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(ArtistEntity artistEntity) {
        this.$$delegate_0.update(artistEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(SongEntity songEntity) {
        songEntity.getClass();
        this.$$delegate_0.delete(songEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(SongEntity songEntity) {
        songEntity.getClass();
        return this.$$delegate_0.insert(songEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(ArtistEntity artistEntity, ArtistPage artistPage) {
        artistEntity.getClass();
        artistPage.getClass();
        this.$$delegate_0.update(artistEntity, artistPage);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(AlbumPage albumPage) {
        albumPage.getClass();
        this.$$delegate_0.insert(albumPage);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PlaylistEntity playlistEntity) {
        this.$$delegate_0.update(playlistEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(ArtistEntity artistEntity) {
        artistEntity.getClass();
        this.$$delegate_0.insert(artistEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PlaylistEntity playlistEntity, PlaylistItem playlistItem) {
        playlistItem.getClass();
        this.$$delegate_0.update(playlistEntity, playlistItem);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(Event event) {
        this.$$delegate_0.insert(event);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PlaylistSongMap playlistSongMap) {
        playlistSongMap.getClass();
        this.$$delegate_0.update(playlistSongMap);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(PlaylistEntity playlistEntity) {
        playlistEntity.getClass();
        this.$$delegate_0.insert(playlistEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PodcastEntity podcastEntity) {
        this.$$delegate_0.update(podcastEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(PlaylistSongMap playlistSongMap) {
        this.$$delegate_0.insert(playlistSongMap);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(Song song, MediaMetadata mediaMetadata, boolean z, boolean z2) {
        this.$$delegate_0.update(song, mediaMetadata, z, z2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(RelatedSongMap relatedSongMap) {
        relatedSongMap.getClass();
        this.$$delegate_0.insert(relatedSongMap);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(SongEntity songEntity) {
        songEntity.getClass();
        this.$$delegate_0.update(songEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(SearchHistory searchHistory) {
        this.$$delegate_0.insert(searchHistory);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(SetVideoIdEntity setVideoIdEntity) {
        this.$$delegate_0.insert(setVideoIdEntity);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(AlbumEntity albumEntity) {
        return this.$$delegate_0.insert(albumEntity);
    }
}
