package com.metrolist.music.db.entities;

import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArtistPageCacheKt {
    public static final JsonImpl json = UuidKt.Json$default(new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 6));

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.util.ArrayList] */
    public static final String serializeArtistPage(List list, String str, String str2, String str3, boolean z, ArtistItem artistItem) {
        String str4;
        CachedArtistItem cachedArtistItem;
        int i;
        CachedItem episode;
        CachedItem podcast;
        ?? arrayList;
        CachedArtistItem cachedArtistItem2 = new CachedArtistItem(artistItem.id, artistItem.title, artistItem.thumbnail, artistItem.channelId, artistItem.isProfile);
        int i2 = 10;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ArtistSection artistSection = (ArtistSection) it.next();
            String str5 = artistSection.title;
            List<YTItem> list2 = artistSection.items;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, i2));
            for (YTItem yTItem : list2) {
                if (yTItem != null) {
                    if (yTItem instanceof SongItem) {
                        SongItem songItem = (SongItem) yTItem;
                        String str6 = songItem.id;
                        String str7 = songItem.title;
                        String str8 = songItem.thumbnail;
                        boolean z2 = songItem.explicit;
                        List<com.metrolist.innertube.models.Artist> list3 = songItem.artists;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, i2));
                        for (com.metrolist.innertube.models.Artist artist : list3) {
                            arrayList4.add(new CachedArtist(artist.name, artist.id));
                            cachedArtistItem2 = cachedArtistItem2;
                        }
                        cachedArtistItem = cachedArtistItem2;
                        com.metrolist.innertube.models.Album album = songItem.album;
                        podcast = new CachedItem.Song(str6, str7, str8, z2, arrayList4, album != null ? new CachedAlbum(album.name, album.id) : null, songItem.duration, songItem.setVideoId);
                        i = 10;
                    } else {
                        cachedArtistItem = cachedArtistItem2;
                        str4 = null;
                        if (yTItem instanceof AlbumItem) {
                            AlbumItem albumItem = (AlbumItem) yTItem;
                            String str9 = albumItem.id;
                            String str10 = albumItem.title;
                            String str11 = albumItem.thumbnail;
                            boolean z3 = albumItem.explicit;
                            List<com.metrolist.innertube.models.Artist> list4 = albumItem.artists;
                            if (list4 != null) {
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                                for (com.metrolist.innertube.models.Artist artist2 : list4) {
                                    arrayList.add(new CachedArtist(artist2.name, artist2.id));
                                }
                            } else {
                                arrayList = EmptyList.INSTANCE;
                            }
                            i = 10;
                            episode = new CachedItem.Album(albumItem.year, str9, str10, str11, albumItem.browseId, albumItem.playlistId, arrayList, z3);
                        } else {
                            i = 10;
                            if (yTItem instanceof PlaylistItem) {
                                PlaylistItem playlistItem = (PlaylistItem) yTItem;
                                String str12 = playlistItem.id;
                                String str13 = playlistItem.title;
                                String str14 = playlistItem.thumbnail;
                                String str15 = str14 == null ? "" : str14;
                                com.metrolist.innertube.models.Artist artist3 = playlistItem.author;
                                podcast = new CachedItem.Playlist(str12, str13, str15, artist3 != null ? new CachedArtist(artist3.name, artist3.id) : null, playlistItem.songCountText, playlistItem.authorAvatarUrl);
                            } else if (yTItem instanceof ArtistItem) {
                                ArtistItem artistItem2 = (ArtistItem) yTItem;
                                String str16 = artistItem2.id;
                                String str17 = artistItem2.title;
                                String str18 = artistItem2.thumbnail;
                                podcast = new CachedItem.Artist(str16, str17, str18 != null ? str18 : "", artistItem2.channelId);
                            } else if (yTItem instanceof PodcastItem) {
                                PodcastItem podcastItem = (PodcastItem) yTItem;
                                String str19 = podcastItem.id;
                                String str20 = podcastItem.title;
                                String str21 = podcastItem.thumbnail;
                                String str22 = str21 == null ? "" : str21;
                                com.metrolist.innertube.models.Artist artist4 = podcastItem.author;
                                podcast = new CachedItem.Podcast(str19, str20, str22, artist4 != null ? new CachedArtist(artist4.name, artist4.id) : null, podcastItem.episodeCountText, podcastItem.channelId);
                            } else if (yTItem instanceof EpisodeItem) {
                                EpisodeItem episodeItem = (EpisodeItem) yTItem;
                                String str23 = episodeItem.id;
                                String str24 = episodeItem.title;
                                String str25 = episodeItem.thumbnail;
                                boolean z4 = episodeItem.explicit;
                                com.metrolist.innertube.models.Artist artist5 = episodeItem.author;
                                CachedArtist cachedArtist = artist5 != null ? new CachedArtist(artist5.name, artist5.id) : null;
                                com.metrolist.innertube.models.Album album2 = episodeItem.podcast;
                                episode = new CachedItem.Episode(str23, str24, str25, z4, cachedArtist, album2 != null ? new CachedAlbum(album2.name, album2.id) : null, episodeItem.duration);
                            }
                        }
                        podcast = episode;
                    }
                    arrayList3.add(podcast);
                    i2 = i;
                    cachedArtistItem2 = cachedArtistItem;
                } else {
                    str4 = null;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return str4;
            }
            CachedArtistItem cachedArtistItem3 = cachedArtistItem2;
            int i3 = i2;
            BrowseEndpoint browseEndpoint = artistSection.moreEndpoint;
            arrayList2.add(new CachedSection(str5, arrayList3, browseEndpoint != null ? browseEndpoint.browseId : null, browseEndpoint != null ? browseEndpoint.params : null));
            i2 = i3;
            cachedArtistItem2 = cachedArtistItem3;
        }
        CachedArtistPage cachedArtistPage = new CachedArtistPage(cachedArtistItem2, arrayList2, str, str2, str3, z);
        JsonImpl jsonImpl = json;
        jsonImpl.getClass();
        return jsonImpl.encodeToString(CachedArtistPage.INSTANCE.serializer(), cachedArtistPage);
    }

    public static final ArtistPage toArtistPage(CachedArtistPage cachedArtistPage) {
        ArtistPage artistPage;
        Iterator it;
        Object episodeItem;
        Object songItem;
        cachedArtistPage.getClass();
        CachedArtistItem cachedArtistItem = cachedArtistPage.artist;
        ArtistItem artistItem = cachedArtistItem != null ? new ArtistItem(cachedArtistItem.id, cachedArtistItem.title, cachedArtistItem.thumbnail, cachedArtistItem.channelId, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, cachedArtistItem.isProfile) : new ArtistItem("", "", (String) null, (String) null, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 152);
        List list = cachedArtistPage.sections;
        int i = 10;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CachedSection cachedSection = (CachedSection) it2.next();
            String str = cachedSection.title;
            List<CachedItem> list2 = cachedSection.items;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, i));
            for (CachedItem cachedItem : list2) {
                if (cachedItem != null) {
                    if (cachedItem instanceof CachedItem.Song) {
                        CachedItem.Song song = (CachedItem.Song) cachedItem;
                        String str2 = song.id;
                        String str3 = song.title;
                        String str4 = song.thumbnail;
                        boolean z = song.explicit;
                        List<CachedArtist> list3 = song.artists;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, i));
                        for (CachedArtist cachedArtist : list3) {
                            arrayList3.add(new com.metrolist.innertube.models.Artist(cachedArtist.name, cachedArtist.id));
                            it2 = it2;
                        }
                        it = it2;
                        CachedAlbum cachedAlbum = song.album;
                        songItem = new SongItem(str2, str3, arrayList3, cachedAlbum != null ? new com.metrolist.innertube.models.Album(cachedAlbum.name, cachedAlbum.id) : null, song.duration, null, null, null, str4, z, null, song.videoId, null, null, null, false, null, 128224);
                    } else {
                        it = it2;
                        artistPage = null;
                        if (cachedItem instanceof CachedItem.Album) {
                            CachedItem.Album album = (CachedItem.Album) cachedItem;
                            String str5 = album.id;
                            String str6 = album.browseId;
                            String str7 = str6 == null ? str5 : str6;
                            String str8 = album.playlistId;
                            String str9 = str8 == null ? str5 : str8;
                            String str10 = album.title;
                            String str11 = album.thumbnail;
                            boolean z2 = album.explicit;
                            List<CachedArtist> list4 = album.artists;
                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                            for (CachedArtist cachedArtist2 : list4) {
                                arrayList4.add(new com.metrolist.innertube.models.Artist(cachedArtist2.name, cachedArtist2.id));
                                str5 = str5;
                            }
                            episodeItem = new AlbumItem(album.year, str7, str9, str5, str10, str11, arrayList4.isEmpty() ? null : arrayList4, z2);
                        } else if (cachedItem instanceof CachedItem.Playlist) {
                            CachedItem.Playlist playlist = (CachedItem.Playlist) cachedItem;
                            String str12 = playlist.id;
                            String str13 = playlist.title;
                            String str14 = playlist.thumbnail;
                            String str15 = !StringsKt.isBlank(str14) ? str14 : null;
                            CachedArtist cachedArtist3 = playlist.author;
                            episodeItem = new PlaylistItem(str12, str13, cachedArtist3 != null ? new com.metrolist.innertube.models.Artist(cachedArtist3.name, cachedArtist3.id) : null, playlist.songCountText, str15, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, playlist.authorAvatarUrl, 1792);
                        } else if (cachedItem instanceof CachedItem.Artist) {
                            CachedItem.Artist artist = (CachedItem.Artist) cachedItem;
                            String str16 = artist.id;
                            String str17 = artist.title;
                            String str18 = artist.thumbnail;
                            episodeItem = new ArtistItem(str16, str17, !StringsKt.isBlank(str18) ? str18 : null, artist.channelId, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 128);
                        } else if (cachedItem instanceof CachedItem.Podcast) {
                            CachedItem.Podcast podcast = (CachedItem.Podcast) cachedItem;
                            String str19 = podcast.id;
                            String str20 = podcast.title;
                            String str21 = podcast.thumbnail;
                            String str22 = !StringsKt.isBlank(str21) ? str21 : null;
                            CachedArtist cachedArtist4 = podcast.author;
                            episodeItem = new PodcastItem(str19, str20, cachedArtist4 != null ? new com.metrolist.innertube.models.Artist(cachedArtist4.name, cachedArtist4.id) : null, podcast.episodeCountText, str22, null, null, null, null, podcast.channelId, 384);
                        } else if (cachedItem instanceof CachedItem.Episode) {
                            CachedItem.Episode episode = (CachedItem.Episode) cachedItem;
                            String str23 = episode.id;
                            String str24 = episode.title;
                            String str25 = episode.thumbnail;
                            boolean z3 = episode.explicit;
                            CachedArtist cachedArtist5 = episode.author;
                            com.metrolist.innertube.models.Artist artist2 = cachedArtist5 != null ? new com.metrolist.innertube.models.Artist(cachedArtist5.name, cachedArtist5.id) : null;
                            CachedAlbum cachedAlbum2 = episode.album;
                            episodeItem = new EpisodeItem(str23, str24, artist2, cachedAlbum2 != null ? new com.metrolist.innertube.models.Album(cachedAlbum2.name, cachedAlbum2.id) : null, episode.duration, null, str25, z3, null, null, null, 7712);
                        }
                        songItem = episodeItem;
                    }
                    arrayList2.add(songItem);
                    it2 = it;
                    i = 10;
                } else {
                    artistPage = null;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return artistPage;
            }
            Iterator it3 = it2;
            String str26 = cachedSection.moreBrowseId;
            arrayList.add(new ArtistSection(str, arrayList2, str26 != null ? new BrowseEndpoint(str26, cachedSection.moreParams) : null));
            it2 = it3;
            i = 10;
        }
        return new ArtistPage(artistItem, arrayList, cachedArtistPage.description, cachedArtistPage.subscriberCountText, cachedArtistPage.monthlyListenerCount, null, cachedArtistPage.isSubscribed);
    }
}
