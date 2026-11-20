package com.metrolist.music.viewmodels;

import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$speedDialItems$1 extends SuspendLambda implements Function5 {
    public /* synthetic */ List L$0;
    public /* synthetic */ List L$1;
    public /* synthetic */ List L$2;
    public /* synthetic */ HomePage L$3;

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        HomeViewModel$speedDialItems$1 homeViewModel$speedDialItems$1 = new HomeViewModel$speedDialItems$1(5, (Continuation) obj5);
        homeViewModel$speedDialItems$1.L$0 = (List) obj;
        homeViewModel$speedDialItems$1.L$1 = (List) obj2;
        homeViewModel$speedDialItems$1.L$2 = (List) obj3;
        homeViewModel$speedDialItems$1.L$3 = (HomePage) obj4;
        return homeViewModel$speedDialItems$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x031d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:73:0x01e4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r32v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object artistItem;
        Artist artist;
        Object playlistItem;
        Object albumItem;
        String str;
        ArrayList arrayList;
        List list = this.L$0;
        List list2 = this.L$1;
        List list3 = this.L$2;
        HomePage homePage = this.L$3;
        ResultKt.throwOnFailure(obj);
        int i = 10;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ?? arrayList3 = EmptyList.INSTANCE;
            if (!zHasNext) {
                List list4 = list2;
                List list5 = list3;
                ?? r2 = list4 == null ? arrayList3 : list4;
                ArrayList arrayList4 = new ArrayList();
                for (LocalItem localItem : r2) {
                    if (localItem == null) {
                        artistItem = null;
                    } else if (localItem instanceof Song) {
                        Song song = (Song) localItem;
                        SongEntity songEntity = song.song;
                        String str2 = songEntity.id;
                        String str3 = songEntity.title;
                        List<ArtistEntity> list6 = song.artists;
                        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                        for (ArtistEntity artistEntity : list6) {
                            arrayList5.add(new Artist(artistEntity.name, artistEntity.id));
                        }
                        String str4 = songEntity.thumbnailUrl;
                        artistItem = new SongItem(str2, str3, arrayList5, null, null, null, null, null, str4 == null ? "" : str4, false, null, null, null, null, null, false, null, 130808);
                    } else if (localItem instanceof Album) {
                        Album album = (Album) localItem;
                        AlbumEntity albumEntity = album.album;
                        String str5 = albumEntity.id;
                        String str6 = albumEntity.playlistId;
                        String str7 = str6 == null ? "" : str6;
                        String str8 = albumEntity.title;
                        List<ArtistEntity> list7 = album.artists;
                        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10));
                        for (ArtistEntity artistEntity2 : list7) {
                            arrayList6.add(new Artist(artistEntity2.name, artistEntity2.id));
                        }
                        Integer num = albumEntity.year;
                        String str9 = albumEntity.thumbnailUrl;
                        artistItem = new AlbumItem(str5, str7, str8, (List) arrayList6, num, str9 == null ? "" : str9, false, 132);
                    } else if (localItem instanceof com.metrolist.music.db.entities.Artist) {
                        ArtistEntity artistEntity3 = ((com.metrolist.music.db.entities.Artist) localItem).artist;
                        artistItem = new ArtistItem(artistEntity3.id, artistEntity3.name, artistEntity3.thumbnailUrl, (String) null, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 152);
                    } else {
                        artistItem = null;
                    }
                    if (artistItem != null) {
                        arrayList4.add(artistItem);
                    }
                }
                ?? r3 = list5 == null ? arrayList3 : list5;
                ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, 10));
                for (Song song2 : r3) {
                    SongEntity songEntity2 = song2.song;
                    String str10 = songEntity2.id;
                    String str11 = songEntity2.title;
                    List<ArtistEntity> list8 = song2.artists;
                    ArrayList arrayList8 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list8, 10));
                    for (ArtistEntity artistEntity4 : list8) {
                        arrayList8.add(new Artist(artistEntity4.name, artistEntity4.id));
                    }
                    String str12 = song2.song.thumbnailUrl;
                    arrayList7.add(new SongItem(str10, str11, arrayList8, null, null, null, null, null, str12 == null ? "" : str12, false, null, null, null, null, null, false, null, 130808));
                }
                List list9 = homePage != null ? homePage.sections : null;
                if (list9 != null) {
                    arrayList3 = list9;
                }
                ArrayList arrayList9 = new ArrayList();
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    CollectionsKt__MutableCollectionsKt.addAll(((HomePage.Section) it2.next()).items, arrayList9);
                }
                ArrayList arrayListPlus = CollectionsKt.plus((Iterable) arrayList9, (Collection) CollectionsKt.plus((Iterable) arrayList7, (Collection) CollectionsKt.plus((Iterable) arrayList4, (Collection) arrayList2)));
                HashSet hashSet = new HashSet();
                ArrayList arrayList10 = new ArrayList();
                int size = arrayListPlus.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayListPlus.get(i2);
                    i2++;
                    if (hashSet.add(((YTItem) obj2).getId())) {
                        arrayList10.add(obj2);
                    }
                }
                return CollectionsKt.take(arrayList10, 27);
            }
            SpeedDialItem speedDialItem = (SpeedDialItem) it.next();
            String str13 = speedDialItem.thumbnailUrl;
            String str14 = speedDialItem.subtitleIds;
            String str15 = speedDialItem.subtitle;
            String str16 = speedDialItem.type;
            switch (str16.hashCode()) {
                case -1632865838:
                    if (!str16.equals("PLAYLIST")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                        return null;
                    }
                    String str17 = speedDialItem.id;
                    String str18 = speedDialItem.title;
                    if (str15 != null) {
                        artist = new Artist(str15, str14);
                    } else {
                        artist = null;
                    }
                    playlistItem = new PlaylistItem(str17, str18, artist, (String) null, speedDialItem.thumbnailUrl, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                    albumItem = playlistItem;
                    arrayList2.add(albumItem);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    i = 10;
                    break;
                case -1548369850:
                    if (!str16.equals("LOCAL_PLAYLIST")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                        return null;
                    }
                    String str19 = speedDialItem.id;
                    String str110 = speedDialItem.title;
                    if (str15 != null) {
                        artist = new Artist(str15, str14);
                    } else {
                        artist = null;
                    }
                    playlistItem = new PlaylistItem(str19, str110, artist, (String) null, speedDialItem.thumbnailUrl, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                    albumItem = playlistItem;
                    arrayList2.add(albumItem);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    i = 10;
                    break;
                case 2551061:
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    if (!str16.equals("SONG")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                        return null;
                    }
                    String str20 = speedDialItem.id;
                    String str21 = speedDialItem.title;
                    if (str15 != null) {
                        List listSplit$default = StringsKt.split$default(str15, new String[]{", "}, 0, 6);
                        arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                        int i3 = 0;
                        for (Object obj3 : listSplit$default) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            arrayList3.add(new Artist((String) obj3, str14 != null ? (String) CollectionsKt.getOrNull(i3, StringsKt.split$default(str14, new String[]{", "}, 0, 6)) : null));
                            i3 = i4;
                            str20 = str20;
                        }
                    }
                    String str22 = str20;
                    ?? r32 = arrayList3;
                    String str23 = speedDialItem.albumId;
                    playlistItem = new SongItem(str22, str21, r32, (str23 == null || (str = speedDialItem.albumName) == null) ? null : new com.metrolist.innertube.models.Album(str, str23), null, null, null, null, str13 == null ? "" : str13, speedDialItem.explicit, null, null, null, null, null, false, null, 130288);
                    albumItem = playlistItem;
                    arrayList2.add(albumItem);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    i = 10;
                    break;
                    break;
                case 62359119:
                    if (!str16.equals("ALBUM")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                        return null;
                    }
                    String str24 = speedDialItem.id;
                    String str25 = speedDialItem.secondaryId;
                    String str26 = str25 == null ? "" : str25;
                    String str27 = speedDialItem.title;
                    if (str15 != null) {
                        List listSplit$default2 = StringsKt.split$default(str15, new String[]{", "}, 0, 6);
                        ArrayList arrayList11 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default2, i));
                        int i5 = 0;
                        for (Object obj4 : listSplit$default2) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            Iterator it3 = it;
                            arrayList11.add(new Artist((String) obj4, str14 != null ? (String) CollectionsKt.getOrNull(i5, StringsKt.split$default(str14, new String[]{", "}, 0, 6)) : null));
                            i5 = i6;
                            it = it3;
                            list2 = list2;
                            list3 = list3;
                        }
                        arrayList = arrayList11;
                    } else {
                        arrayList = null;
                    }
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    albumItem = new AlbumItem(str24, str26, str27, arrayList, (Integer) null, str13 == null ? "" : str13, speedDialItem.explicit, 36);
                    arrayList2.add(albumItem);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    i = 10;
                    break;
                    break;
                case 1939198791:
                    if (!str16.equals("ARTIST")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                        return null;
                    }
                    albumItem = new ArtistItem(speedDialItem.id, speedDialItem.title, speedDialItem.thumbnailUrl, (String) null, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 152);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    arrayList2.add(albumItem);
                    it = it;
                    list2 = list2;
                    list3 = list3;
                    i = 10;
                    break;
                    break;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type: ".concat(str16));
                    return null;
            }
        }
    }
}
