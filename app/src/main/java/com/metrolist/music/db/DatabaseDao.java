package com.metrolist.music.db;

import androidx.compose.foundation.MutatorMutex;
import com.dokar.quickjs.QuickJs;
import com.google.common.base.Joiner;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistPage;
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
import com.metrolist.music.extensions.StringExtKt;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onGetChildren$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$playlistDuplicatesBatched$1;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$2$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import com.metrolist.music.utils.SyncUtils$executeSyncSavedPlaylists$2;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DatabaseDao {

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$transferSongStats$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public DatabaseDao L$0;
        public String L$1;
        public String L$2;
        public Iterator L$4;
        public PlayCountEntity L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseDao.transferSongStats$suspendImpl(DatabaseDao.this, null, null, this);
        }
    }

    static /* synthetic */ Flow mostPlayedAlbums$default(DatabaseDao databaseDao, LocalDateTime localDateTime, int i, LocalDateTime localDateTime2, int i2) {
        int i3 = (i2 & 4) != 0 ? 0 : 2;
        if ((i2 & 8) != 0) {
            localDateTime2 = LocalDateTime.now();
        }
        return databaseDao.mostPlayedAlbums(localDateTime, i, i3, localDateTime2);
    }

    static /* synthetic */ Flow mostPlayedArtists$default(DatabaseDao databaseDao, LocalDateTime localDateTime, int i, LocalDateTime localDateTime2, int i2) {
        if ((i2 & 2) != 0) {
            i = 6;
        }
        if ((i2 & 8) != 0) {
            localDateTime2 = LocalDateTime.now();
        }
        return databaseDao.mostPlayedArtists(localDateTime, i, localDateTime2);
    }

    static /* synthetic */ Flow mostPlayedSongs$default(DatabaseDao databaseDao, LocalDateTime localDateTime, int i, LocalDateTime localDateTime2, int i2) {
        if ((i2 & 8) != 0) {
            localDateTime2 = LocalDateTime.now();
        }
        return databaseDao.mostPlayedSongs(localDateTime, i, 0, localDateTime2);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    /* JADX WARN: Code duplicated, block: B:46:0x0123  */
    /* JADX WARN: Code duplicated, block: B:49:0x0143  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0143 -> B:50:0x0145). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0147 -> B:38:0x00e7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static java.lang.Object transferSongStats$suspendImpl(com.metrolist.music.db.DatabaseDao r19, java.lang.String r20, java.lang.String r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.db.DatabaseDao.transferSongStats$suspendImpl(com.metrolist.music.db.DatabaseDao, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    void addLibraryTokens(String str, String str2, String str3);

    Object addSongsToPlaylist(Playlist playlist, List list, boolean z, ContinuationImpl continuationImpl);

    Object addToPlayCountRow(String str, int i, int i2, int i3, AnonymousClass1 anonymousClass1);

    Flow album(String str);

    Object albumEntity(String str, SuspendLambda suspendLambda);

    Object albumSongs(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1);

    Flow albumSongs(String str);

    Flow albumWithSongs(String str);

    default Flow albums(AlbumSortType albumSortType, boolean z) {
        Flow flowAlbumsByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        albumSortType.getClass();
        switch (albumSortType.ordinal()) {
            case 0:
                flowAlbumsByCreateDateAsc = albumsByCreateDateAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 1:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsByNameAsc(), (byte) 10);
                flowAlbumsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 2:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsByCreateDateAsc(), (byte) 11);
                flowAlbumsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 3:
                flowAlbumsByCreateDateAsc = albumsByYearAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 4:
                flowAlbumsByCreateDateAsc = albumsBySongCountAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 5:
                flowAlbumsByCreateDateAsc = albumsByLengthAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            case 6:
                flowAlbumsByCreateDateAsc = albumsByPlayTimeAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsByCreateDateAsc, z, (byte) 1);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    Object albumsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1);

    Flow albumsByCreateDateAsc();

    Flow albumsByLengthAsc();

    Flow albumsByNameAsc();

    Flow albumsByPlayTimeAsc();

    Flow albumsBySongCountAsc();

    Flow albumsByYearAsc();

    default Flow albumsLiked(AlbumSortType albumSortType, boolean z) {
        Flow flowAlbumsLikedByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        albumSortType.getClass();
        switch (albumSortType.ordinal()) {
            case 0:
                flowAlbumsLikedByCreateDateAsc = albumsLikedByCreateDateAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 1:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsLikedByNameAsc(), (byte) 12);
                flowAlbumsLikedByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 2:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsLikedByCreateDateAsc(), (byte) 13);
                flowAlbumsLikedByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 3:
                flowAlbumsLikedByCreateDateAsc = albumsLikedByYearAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 4:
                flowAlbumsLikedByCreateDateAsc = albumsLikedBySongCountAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 5:
                flowAlbumsLikedByCreateDateAsc = albumsLikedByLengthAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            case 6:
                flowAlbumsLikedByCreateDateAsc = albumsLikedByPlayTimeAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsLikedByCreateDateAsc, z, (byte) 2);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    Flow albumsLikedByCreateDateAsc();

    Flow albumsLikedByLengthAsc();

    Flow albumsLikedByNameAsc();

    Flow albumsLikedByPlayTimeAsc();

    Flow albumsLikedBySongCountAsc();

    Flow albumsLikedByYearAsc();

    default Flow albumsUploaded(AlbumSortType albumSortType, boolean z) {
        Flow flowAlbumsUploadedByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        albumSortType.getClass();
        switch (albumSortType.ordinal()) {
            case 0:
                flowAlbumsUploadedByCreateDateAsc = albumsUploadedByCreateDateAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 1:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsUploadedByNameAsc(), (byte) 14);
                flowAlbumsUploadedByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 2:
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(albumsUploadedByCreateDateAsc(), (byte) 15);
                flowAlbumsUploadedByCreateDateAsc = databaseDao$songs$$inlined$map$1;
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 3:
                flowAlbumsUploadedByCreateDateAsc = albumsUploadedByYearAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 4:
                flowAlbumsUploadedByCreateDateAsc = albumsUploadedBySongCountAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 5:
                flowAlbumsUploadedByCreateDateAsc = albumsUploadedByLengthAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            case 6:
                flowAlbumsUploadedByCreateDateAsc = albumsUploadedByPlayTimeAsc();
                return new DatabaseDao$songs$$inlined$map$3(flowAlbumsUploadedByCreateDateAsc, z, (byte) 3);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    Flow albumsUploadedByCreateDateAsc();

    Flow albumsUploadedByLengthAsc();

    Flow albumsUploadedByNameAsc();

    Flow albumsUploadedByPlayTimeAsc();

    Flow albumsUploadedBySongCountAsc();

    Flow albumsUploadedByYearAsc();

    Flow allArtistsByPlayTime();

    Flow allSongs();

    Flow artist(String str);

    Flow artistAlbumsPreview(String str);

    ArtistEntity artistByName(String str);

    Object artistEntity(String str, QuickJs.AnonymousClass3 anonymousClass3);

    default Flow artistSongs(String str, ArtistSongSortType artistSongSortType, boolean z) {
        Flow flowArtistSongsByCreateDateAsc;
        str.getClass();
        artistSongSortType.getClass();
        int iOrdinal = artistSongSortType.ordinal();
        if (iOrdinal == 0) {
            flowArtistSongsByCreateDateAsc = artistSongsByCreateDateAsc(str);
        } else if (iOrdinal == 1) {
            flowArtistSongsByCreateDateAsc = new DatabaseDao$songs$$inlined$map$1(artistSongsByNameAsc(str), (byte) 16);
        } else {
            if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            flowArtistSongsByCreateDateAsc = artistSongsByPlayTimeAsc(str);
        }
        return new DatabaseDao$songs$$inlined$map$3(flowArtistSongsByCreateDateAsc, z, (byte) 4);
    }

    Object artistSongsByCreateDateAsc(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1);

    Flow artistSongsByCreateDateAsc(String str);

    Flow artistSongsByNameAsc(String str);

    Flow artistSongsByPlayTimeAsc(String str);

    Flow artistSongsPreview(String str);

    default Flow artists(ArtistSortType artistSortType, boolean z) {
        Flow flowArtistsByCreateDateAsc;
        artistSortType.getClass();
        int iOrdinal = artistSortType.ordinal();
        if (iOrdinal == 0) {
            flowArtistsByCreateDateAsc = artistsByCreateDateAsc();
        } else if (iOrdinal == 1) {
            flowArtistsByCreateDateAsc = artistsByNameAsc();
        } else if (iOrdinal == 2) {
            flowArtistsByCreateDateAsc = artistsBySongCountAsc();
        } else {
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            flowArtistsByCreateDateAsc = artistsByPlayTimeAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowArtistsByCreateDateAsc, z, (byte) 5);
    }

    default Flow artistsBookmarked(ArtistSortType artistSortType, boolean z) {
        Flow flowArtistsBookmarkedByCreateDateAsc;
        artistSortType.getClass();
        int iOrdinal = artistSortType.ordinal();
        if (iOrdinal == 0) {
            flowArtistsBookmarkedByCreateDateAsc = artistsBookmarkedByCreateDateAsc();
        } else if (iOrdinal == 1) {
            flowArtistsBookmarkedByCreateDateAsc = artistsBookmarkedByNameAsc();
        } else if (iOrdinal == 2) {
            flowArtistsBookmarkedByCreateDateAsc = artistsBookmarkedBySongCountAsc();
        } else {
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            flowArtistsBookmarkedByCreateDateAsc = artistsBookmarkedByPlayTimeAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowArtistsBookmarkedByCreateDateAsc, z, (byte) 6);
    }

    Flow artistsBookmarkedByCreateDateAsc();

    Flow artistsBookmarkedByNameAsc();

    Flow artistsBookmarkedByPlayTimeAsc();

    Flow artistsBookmarkedBySongCountAsc();

    Object artistsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1);

    Flow artistsByCreateDateAsc();

    Flow artistsByNameAsc();

    Flow artistsByPlayTimeAsc();

    Flow artistsBySongCountAsc();

    Object bookmarkedArtistEntitiesByNameAsc(QuickJs.AnonymousClass3 anonymousClass3);

    Object bookmarkedPlaylistBrowseIds(MediaLibrarySessionCallback$onGetChildren$1 mediaLibrarySessionCallback$onGetChildren$1);

    Flow bookmarkedPodcastChannels();

    Flow cachePlaylistSongs();

    default void checkpoint() {
        Regex regex = StringExtKt.combiningDiacriticalMarksRegex;
        raw(new Joiner("PRAGMA wal_checkpoint(FULL)", (byte) 4));
    }

    void clearListenHistory();

    void clearPlaylist(String str);

    void clearRecognitionHistory();

    void clearSearchHistory();

    void delete(AlbumEntity albumEntity);

    void delete(Event event);

    void delete(LyricsEntity lyricsEntity);

    void delete(PlaylistEntity playlistEntity);

    void delete(PlaylistSongMap playlistSongMap);

    void delete(SearchHistory searchHistory);

    void delete(SongEntity songEntity);

    void deleteFormat(String str);

    Object deletePlayCountsForSong(String str, AnonymousClass1 anonymousClass1);

    void deleteRecognitionHistoryById(long j);

    default Flow downloadedPodcastEpisodes(SongSortType songSortType, boolean z) {
        Flow flowDownloadedPodcastEpisodesByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(downloadedPodcastEpisodesByNameAsc(), (byte) 17);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(downloadedPodcastEpisodesByNameAsc(), (byte) 18);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowDownloadedPodcastEpisodesByCreateDateAsc = downloadedPodcastEpisodesByPlayTimeAsc();
            }
            flowDownloadedPodcastEpisodesByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowDownloadedPodcastEpisodesByCreateDateAsc = downloadedPodcastEpisodesByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowDownloadedPodcastEpisodesByCreateDateAsc, z, (byte) 7);
    }

    Flow downloadedPodcastEpisodesByCreateDateAsc();

    Flow downloadedPodcastEpisodesByNameAsc();

    Flow downloadedPodcastEpisodesByPlayTimeAsc();

    default Flow downloadedSongs(SongSortType songSortType, boolean z) {
        Flow flowDownloadedSongsByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(downloadedSongsByNameAsc(), (byte) 19);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(downloadedSongsByNameAsc(), (byte) 20);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowDownloadedSongsByCreateDateAsc = downloadedSongsByPlayTimeAsc();
            }
            flowDownloadedSongsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowDownloadedSongsByCreateDateAsc = downloadedSongsByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowDownloadedSongsByCreateDateAsc, z, (byte) 8);
    }

    Flow downloadedSongsByCreateDateAsc();

    Flow downloadedSongsByNameAsc();

    Flow downloadedSongsByPlayTimeAsc();

    Flow eventCount();

    Object existingSongIds(List list, MediaLibrarySessionCallback.C01641 c01641);

    Flow firstEvent();

    Flow forgottenFavorites(long j);

    Flow format(String str);

    Flow getLifetimePlayCount(String str);

    Object getPlayCountsForSong(String str, AnonymousClass1 anonymousClass1);

    Long getPlaybackPosition(String str);

    Flow getRelatedSongs(String str);

    Object getSetVideoId(String str, ContinuationImpl continuationImpl);

    Object getSongById(String str, MusicService.C01661 c01661);

    Song getSongByIdBlocking(String str);

    Object getSongsByIds(List list, MediaLibrarySessionCallback.C01641 c01641);

    Long getTotalPlayTimeForSong(String str);

    boolean hasRelatedSongs(String str);

    Flow historyEvents(LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, LocalDateTime localDateTime4, LocalDateTime localDateTime5);

    void inLibrary(String str, LocalDateTime localDateTime);

    void incrementTotalPlayTime(long j, String str);

    long insert(AlbumEntity albumEntity);

    long insert(PodcastEntity podcastEntity);

    long insert(RecognitionHistory recognitionHistory);

    long insert(SongEntity songEntity);

    void insert(AlbumPage albumPage);

    void insert(ArtistEntity artistEntity);

    void insert(Event event);

    void insert(PlaylistEntity playlistEntity);

    void insert(PlaylistSongMap playlistSongMap);

    void insert(RelatedSongMap relatedSongMap);

    void insert(SearchHistory searchHistory);

    void insert(SetVideoIdEntity setVideoIdEntity);

    void insert(MediaMetadata mediaMetadata, Function1 function1);

    Object insertPlayCountRow(PlayCountEntity playCountEntity, AnonymousClass1 anonymousClass1);

    Flow latestEvent();

    Object librarySongEntitiesByNameAsc(MutatorMutex.AnonymousClass2 anonymousClass2);

    Object likedAlbumEntitiesByNameAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2);

    Object likedSongIds(SongMenuKt$SongMenu$2$1$1 songMenuKt$SongMenu$2$1$1);

    default Flow likedSongs(SongSortType songSortType, boolean z) {
        Flow flowLikedSongsByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(likedSongsByNameAsc(), (byte) 21);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(likedSongsByRowIdAsc(), (byte) 22);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowLikedSongsByCreateDateAsc = likedSongsByPlayTimeAsc();
            }
            flowLikedSongsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowLikedSongsByCreateDateAsc = likedSongsByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowLikedSongsByCreateDateAsc, z, (byte) 9);
    }

    Flow likedSongsByCreateDateAsc();

    Object likedSongsByCreateDateDesc(int i, int i2, MediaLibrarySessionCallback.C01641 c01641);

    Flow likedSongsByNameAsc();

    Flow likedSongsByPlayTimeAsc();

    Flow likedSongsByRowIdAsc();

    Flow likedSongsCount();

    Flow lyrics(String str);

    Flow mostPlayedAlbums(LocalDateTime localDateTime, int i, int i2, LocalDateTime localDateTime2);

    Flow mostPlayedArtists(LocalDateTime localDateTime, int i, LocalDateTime localDateTime2);

    Flow mostPlayedSongs(LocalDateTime localDateTime, int i, int i2, LocalDateTime localDateTime2);

    Flow mostPlayedSongsStats(LocalDateTime localDateTime, LocalDateTime localDateTime2);

    void move(int i, int i2, String str);

    Flow playlist(String str);

    Playlist playlistBlocking(String str);

    Flow playlistByBrowseId(String str);

    Object playlistDuplicates(String str, List list, AddToPlaylistDialogKt$playlistDuplicatesBatched$1 addToPlaylistDialogKt$playlistDuplicatesBatched$1);

    Object playlistEntitiesByNameAsc(SuspendLambda suspendLambda);

    Object playlistSongIdsWithoutArtists(String str, SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2);

    List playlistSongMaps(String str);

    Object playlistSongs(String str, int i, int i2, MediaLibrarySessionCallback.C01641 c01641);

    Flow playlistSongs(String str);

    default Flow playlists(PlaylistSortType playlistSortType, boolean z) {
        Flow flowPlaylistsByCreateDateAsc;
        playlistSortType.getClass();
        int iOrdinal = playlistSortType.ordinal();
        if (iOrdinal == 0) {
            flowPlaylistsByCreateDateAsc = playlistsByCreateDateAsc();
        } else if (iOrdinal == 1) {
            flowPlaylistsByCreateDateAsc = new DatabaseDao$songs$$inlined$map$1(playlistsByNameAsc(), (byte) 23);
        } else if (iOrdinal == 2) {
            flowPlaylistsByCreateDateAsc = playlistsBySongCountAsc();
        } else {
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            flowPlaylistsByCreateDateAsc = playlistsByUpdatedDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowPlaylistsByCreateDateAsc, z, (byte) 10);
    }

    Object playlistsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.C01651 c01651);

    Flow playlistsByCreateDateAsc();

    Flow playlistsByNameAsc();

    Flow playlistsBySongCountAsc();

    Flow playlistsByUpdatedDateAsc();

    Flow podcast(String str);

    Flow podcastEpisodesByCreateDateAsc();

    Flow quickPicks(long j);

    int raw(Joiner joiner);

    Flow recognitionHistory();

    void repairMissingVideoThumbnails();

    void replaceSongArtists(String str, ArrayList arrayList);

    Object savedEpisodeEntitiesByCreateDateAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2);

    default Flow savedPodcastEpisodes(SongSortType songSortType, boolean z) {
        Flow flowSavedPodcastEpisodesByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(savedPodcastEpisodesByNameAsc(), (byte) 24);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(savedPodcastEpisodesByNameAsc(), (byte) 25);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowSavedPodcastEpisodesByCreateDateAsc = savedPodcastEpisodesByPlayTimeAsc();
            }
            flowSavedPodcastEpisodesByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowSavedPodcastEpisodesByCreateDateAsc = savedPodcastEpisodesByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowSavedPodcastEpisodesByCreateDateAsc, z, (byte) 11);
    }

    Flow savedPodcastEpisodesByCreateDateAsc();

    Flow savedPodcastEpisodesByNameAsc();

    Flow savedPodcastEpisodesByPlayTimeAsc();

    Flow searchAlbums(int i, String str);

    Flow searchArtists(int i, String str);

    Flow searchHistory(String str);

    Flow searchPlaylists(int i, String str);

    Flow searchSongs(int i, String str);

    Flow searchSongsExtended(int i, String str);

    Flow song(String str);

    Object songEntity(String str, SuspendLambda suspendLambda);

    List songIdsWithoutArtists(List list);

    default Flow songs(SongSortType songSortType, boolean z) {
        Flow flowSongsByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        byte b = 0;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(songsByNameAsc(), b);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(songsByRowIdAsc(), (byte) 26);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowSongsByCreateDateAsc = songsByPlayTimeAsc();
            }
            flowSongsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowSongsByCreateDateAsc = songsByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowSongsByCreateDateAsc, z, b);
    }

    Object songsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1);

    Flow songsByCreateDateAsc();

    Flow songsByNameAsc();

    Flow songsByPlayTimeAsc();

    Flow songsByRowIdAsc();

    Flow songsInBookmarkedPlaylists();

    Flow subscribedPodcasts();

    Object transferEvents(String str, String str2, AnonymousClass1 anonymousClass1);

    Object transferSongStats(String str, String str2, InnerTube$feedback$2 innerTube$feedback$2);

    void update(AlbumEntity albumEntity);

    void update(AlbumEntity albumEntity, AlbumPage albumPage, List list);

    void update(ArtistEntity artistEntity);

    void update(ArtistEntity artistEntity, ArtistPage artistPage);

    void update(PlaylistEntity playlistEntity);

    default void update(PlaylistEntity playlistEntity, PlaylistItem playlistItem) {
        Integer intOrNull;
        playlistItem.getClass();
        String str = playlistItem.title;
        String str2 = playlistItem.id;
        String str3 = playlistItem.thumbnail;
        boolean z = playlistItem.isEditable;
        String str4 = playlistItem.songCountText;
        if (str4 != null) {
            Pattern patternCompile = Pattern.compile("\\d+");
            patternCompile.getClass();
            Matcher matcher = patternCompile.matcher(str4);
            matcher.getClass();
            MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str4);
            intOrNull = matcherMatchResultFindNext != null ? StringsKt__StringsJVMKt.toIntOrNull(10, matcherMatchResultFindNext.getValue()) : null;
        } else {
            intOrNull = null;
        }
        WatchEndpoint watchEndpoint = playlistItem.playEndpoint;
        String str5 = watchEndpoint != null ? watchEndpoint.params : null;
        WatchEndpoint watchEndpoint2 = playlistItem.shuffleEndpoint;
        String str6 = watchEndpoint2 != null ? watchEndpoint2.params : null;
        WatchEndpoint watchEndpoint3 = playlistItem.radioEndpoint;
        update(PlaylistEntity.copy$default(playlistEntity, str, str2, null, z, null, intOrNull, str5, str3, str6, watchEndpoint3 != null ? watchEndpoint3.params : null, false, 12377));
    }

    void update(PlaylistSongMap playlistSongMap);

    void update(PodcastEntity podcastEntity);

    void update(Song song, MediaMetadata mediaMetadata, boolean z, boolean z2);

    void update(SongEntity songEntity);

    void updateArtistThumbnail(String str, String str2);

    void updateDownloadedInfo(String str, boolean z, LocalDateTime localDateTime);

    void updatePlaybackPosition(String str, Long l);

    Object uploadedAlbumEntitiesByNameAsc(SyncUtils$executeSyncSavedPlaylists$2 syncUtils$executeSyncSavedPlaylists$2);

    Object uploadedSongEntitiesByNameAsc(SyncUtils.C01852 c01852);

    default Flow uploadedSongs(SongSortType songSortType, boolean z) {
        Flow flowUploadedSongsByCreateDateAsc;
        DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1;
        songSortType.getClass();
        int iOrdinal = songSortType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(uploadedSongsByNameAsc(), (byte) 27);
            } else if (iOrdinal == 2) {
                databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(uploadedSongsByRowIdAsc(), (byte) 28);
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                flowUploadedSongsByCreateDateAsc = uploadedSongsByPlayTimeAsc();
            }
            flowUploadedSongsByCreateDateAsc = databaseDao$songs$$inlined$map$1;
        } else {
            flowUploadedSongsByCreateDateAsc = uploadedSongsByCreateDateAsc();
        }
        return new DatabaseDao$songs$$inlined$map$3(flowUploadedSongsByCreateDateAsc, z, (byte) 12);
    }

    Flow uploadedSongsByCreateDateAsc();

    Flow uploadedSongsByNameAsc();

    Flow uploadedSongsByPlayTimeAsc();

    Flow uploadedSongsByRowIdAsc();

    void upsert(FormatEntity formatEntity);

    void upsert(LyricsEntity lyricsEntity);

    void upsert(SongEntity songEntity);
}
