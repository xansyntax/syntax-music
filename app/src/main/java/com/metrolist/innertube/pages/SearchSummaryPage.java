package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Button;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.MusicCardShelfRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchSummaryPage {
    public final List summaries;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:179:0x0238  */
        /* JADX WARN: Code duplicated, block: B:181:0x023c  */
        /* JADX WARN: Code duplicated, block: B:186:0x0247  */
        /* JADX WARN: Code duplicated, block: B:189:0x0250  */
        /* JADX WARN: Code duplicated, block: B:199:0x0282  */
        /* JADX WARN: Code duplicated, block: B:209:0x02a5  */
        /* JADX WARN: Code duplicated, block: B:211:0x02a8  */
        /* JADX WARN: Code duplicated, block: B:212:0x02b7 A[PHI: r1
          0x02b7: PHI (r1v20 com.metrolist.innertube.models.Artist) = (r1v19 com.metrolist.innertube.models.Artist), (r1v32 com.metrolist.innertube.models.Artist) binds: [B:198:0x0280, B:211:0x02a8] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:217:0x02c2  */
        /* JADX WARN: Code duplicated, block: B:220:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:222:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:223:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:239:0x02ff  */
        /* JADX WARN: Code duplicated, block: B:241:0x030c  */
        /* JADX WARN: Code duplicated, block: B:242:0x030f  */
        /* JADX WARN: Code duplicated, block: B:257:0x033b  */
        /* JADX WARN: Code duplicated, block: B:258:0x033d  */
        /* JADX WARN: Code duplicated, block: B:262:0x0347  */
        /* JADX WARN: Code duplicated, block: B:271:0x0377  */
        /* JADX WARN: Code duplicated, block: B:274:0x0381  */
        /* JADX WARN: Code duplicated, block: B:276:0x038e  */
        /* JADX WARN: Code duplicated, block: B:277:0x0391  */
        /* JADX WARN: Code duplicated, block: B:284:0x039e  */
        /* JADX WARN: Code duplicated, block: B:289:0x03ab  */
        /* JADX WARN: Code duplicated, block: B:293:0x03b7  */
        /* JADX WARN: Code duplicated, block: B:295:0x03c4  */
        /* JADX WARN: Code duplicated, block: B:296:0x03c7  */
        /* JADX WARN: Code duplicated, block: B:303:0x03d4  */
        /* JADX WARN: Code duplicated, block: B:324:0x02e4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:327:0x0317 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:329:0x0399 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:332:0x03cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x0080  */
        /* JADX WARN: Multi-variable type inference failed */
        public static YTItem fromMusicCardShelfRenderer(MusicCardShelfRenderer musicCardShelfRenderer) throws IOException {
            String str;
            MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer;
            Runs runs;
            List list;
            String strJoinToString$default;
            Artist artist;
            String thumbnailUrl;
            Iterator it;
            Object next;
            Button button;
            WatchEndpoint watchEndpoint;
            Iterator it2;
            Object next2;
            Button button2;
            Button.ButtonRenderer buttonRenderer;
            NavigationEndpoint navigationEndpoint;
            Icon icon;
            String str2;
            Button.ButtonRenderer buttonRenderer2;
            NavigationEndpoint navigationEndpoint2;
            Icon icon2;
            String str3;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
            String str4;
            String strRemovePrefix;
            MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer2;
            Runs runs2;
            List list2;
            String strJoinToString$default2;
            Artist artist2;
            Artist artist3;
            String thumbnailUrl2;
            Iterator it3;
            Object next3;
            Button button3;
            Button.ButtonRenderer buttonRenderer3;
            NavigationEndpoint navigationEndpoint3;
            WatchEndpoint watchEndpoint2;
            Iterator it4;
            Object next4;
            Button button4;
            Button.ButtonRenderer buttonRenderer4;
            NavigationEndpoint navigationEndpoint4;
            WatchEndpoint watchEndpoint3;
            Icon icon3;
            String str5;
            Icon icon4;
            String str6;
            List list3;
            Run run;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
            Button.ButtonRenderer buttonRenderer5;
            NavigationEndpoint navigationEndpoint5;
            String str7;
            List list4;
            Run run2;
            String str8;
            Icon icon5;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig3;
            Run run3;
            String str9;
            String thumbnailUrl3;
            Object next5;
            Button.ButtonRenderer buttonRenderer6;
            NavigationEndpoint navigationEndpoint6;
            WatchEndpoint watchEndpoint4;
            Object next6;
            Button.ButtonRenderer buttonRenderer7;
            NavigationEndpoint navigationEndpoint7;
            WatchEndpoint watchEndpoint5;
            Icon icon6;
            Icon icon7;
            List list5;
            Run run4;
            String str10;
            Album album;
            Icon icon8;
            List list6;
            Run run5;
            String str11;
            List list7;
            Run run6;
            BrowseEndpoint browseEndpoint;
            musicCardShelfRenderer.getClass();
            MusicCardShelfRenderer.Header header = musicCardShelfRenderer.header;
            List list8 = musicCardShelfRenderer.subtitleBadges;
            Runs runs3 = musicCardShelfRenderer.title;
            ThumbnailRenderer thumbnailRenderer = musicCardShelfRenderer.thumbnail;
            List list9 = musicCardShelfRenderer.buttons;
            NavigationEndpoint navigationEndpoint8 = musicCardShelfRenderer.onTap;
            Runs runs4 = musicCardShelfRenderer.subtitle;
            List list10 = runs4.runs;
            List list11 = runs4.runs;
            Object obj = null;
            ArrayList arrayListSplitBySeparator = list10 != null ? CharsKt.splitBySeparator(list10) : null;
            WatchEndpoint watchEndpoint6 = navigationEndpoint8.watchEndpoint;
            BrowseEndpoint browseEndpoint2 = navigationEndpoint8.browseEndpoint;
            if (watchEndpoint6 != null) {
                String str12 = watchEndpoint6.videoId;
                if (str12 != null && (list5 = runs3.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list5)) != null && (str10 = run4.text) != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(list11);
                    if (arrayListSplitBySeparator == null || (list7 = (List) CollectionsKt.getOrNull(2, arrayListSplitBySeparator)) == null || (run6 = (Run) CollectionsKt.firstOrNull(list7)) == null) {
                        album = null;
                    } else {
                        NavigationEndpoint navigationEndpoint9 = run6.navigationEndpoint;
                        if ((navigationEndpoint9 != null ? navigationEndpoint9.browseEndpoint : null) == null) {
                            run6 = null;
                        }
                        if (run6 != null) {
                            String str13 = run6.text;
                            NavigationEndpoint navigationEndpoint10 = run6.navigationEndpoint;
                            String str14 = (navigationEndpoint10 == null || (browseEndpoint = navigationEndpoint10.browseEndpoint) == null) ? null : browseEndpoint.browseId;
                            str14.getClass();
                            album = new Album(str13, str14);
                        } else {
                            album = null;
                        }
                    }
                    Integer numM1883parseTime = (arrayListSplitBySeparator == null || (list6 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator)) == null || (run5 = (Run) CollectionsKt.firstOrNull(list6)) == null || (str11 = run5.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str11);
                    String musicVideoType = navigationEndpoint8.getMusicVideoType();
                    String thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl4 != null) {
                        if (list8 != null) {
                            for (Object obj2 : list8) {
                                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon8 = musicInlineBadgeRenderer.icon) == null) ? null : icon8.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            obj = (Badges) obj;
                        }
                        return new SongItem(str12, str10, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl4, obj != null, null, null, null, null, null, false, null, 130240);
                    }
                }
            } else if (browseEndpoint2 != null && browseEndpoint2.isArtistEndpoint()) {
                String str15 = browseEndpoint2.browseId;
                List list12 = runs3.runs;
                if (list12 != null && (run3 = (Run) CollectionsKt.firstOrNull(list12)) != null && (str9 = run3.text) != null && (thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl()) != null) {
                    Iterator it5 = list9.iterator();
                    do {
                        if (!it5.hasNext()) {
                            next5 = null;
                            break;
                        }
                        next5 = it5.next();
                        icon7 = ((Button) next5).buttonRenderer.icon;
                    } while (!Intrinsics.areEqual(icon7 != null ? icon7.iconType : null, "MUSIC_SHUFFLE"));
                    Button button5 = (Button) next5;
                    if (button5 != null && (buttonRenderer6 = button5.buttonRenderer) != null && (navigationEndpoint6 = buttonRenderer6.command) != null && (watchEndpoint4 = navigationEndpoint6.watchPlaylistEndpoint) != null) {
                        Iterator it6 = list9.iterator();
                        do {
                            if (!it6.hasNext()) {
                                next6 = null;
                                break;
                            }
                            next6 = it6.next();
                            icon6 = ((Button) next6).buttonRenderer.icon;
                        } while (!Intrinsics.areEqual(icon6 != null ? icon6.iconType : null, "MIX"));
                        Button button6 = (Button) next6;
                        if (button6 != null && (buttonRenderer7 = button6.buttonRenderer) != null && (navigationEndpoint7 = buttonRenderer7.command) != null && (watchEndpoint5 = navigationEndpoint7.watchPlaylistEndpoint) != null) {
                            return new ArtistItem(str15, str9, thumbnailUrl3, (String) null, (WatchEndpoint) null, watchEndpoint4, watchEndpoint5, 152);
                        }
                    }
                }
            } else if (browseEndpoint2 != null) {
                BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2 = browseEndpoint2.browseEndpointContextSupportedConfigs;
                if (!Intrinsics.areEqual((browseEndpointContextSupportedConfigs2 == null || (browseEndpointContextMusicConfig3 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig3.pageType, "MUSIC_PAGE_TYPE_ALBUM")) {
                    if (!Intrinsics.areEqual((browseEndpointContextSupportedConfigs2 == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_AUDIOBOOK")) {
                        if (browseEndpoint2 == null) {
                            browseEndpointContextSupportedConfigs = browseEndpoint2.browseEndpointContextSupportedConfigs;
                            if (browseEndpointContextSupportedConfigs != null) {
                                str4 = null;
                            } else {
                                str4 = null;
                            }
                            if (Intrinsics.areEqual(str4, "MUSIC_PAGE_TYPE_PLAYLIST")) {
                                strRemovePrefix = StringsKt.removePrefix(browseEndpoint2.browseId, "VL");
                                if (header != null) {
                                    strJoinToString$default2 = CollectionsKt.joinToString$default(list2, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 6), 30);
                                    artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list11));
                                    if (artist2 != null) {
                                        artist3 = artist2;
                                    } else {
                                        if (list11 != null) {
                                            if (run.navigationEndpoint == null) {
                                                run = null;
                                            } else {
                                                run = null;
                                            }
                                            if (run != null) {
                                                artist2 = new Artist(StringsKt.trim(run.text).toString(), null);
                                                artist3 = artist2;
                                            }
                                        }
                                        artist3 = null;
                                    }
                                    thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                                    if (thumbnailUrl2 != null) {
                                        it3 = list9.iterator();
                                        do {
                                            if (it3.hasNext()) {
                                                next3 = null;
                                                break;
                                            }
                                            next3 = it3.next();
                                            icon4 = ((Button) next3).buttonRenderer.icon;
                                            if (icon4 != null) {
                                                str6 = icon4.iconType;
                                            } else {
                                                str6 = null;
                                            }
                                        } while (!Intrinsics.areEqual(str6, "PLAY_ARROW"));
                                        button3 = (Button) next3;
                                        if (button3 != null) {
                                            it4 = list9.iterator();
                                            do {
                                                if (it4.hasNext()) {
                                                    next4 = null;
                                                    break;
                                                }
                                                next4 = it4.next();
                                                icon3 = ((Button) next4).buttonRenderer.icon;
                                                if (icon3 != null) {
                                                    str5 = icon3.iconType;
                                                } else {
                                                    str5 = null;
                                                }
                                            } while (!Intrinsics.areEqual(str5, "MUSIC_SHUFFLE"));
                                            button4 = (Button) next4;
                                            if (button4 != null) {
                                                return new PlaylistItem(strRemovePrefix, strJoinToString$default2, artist3, (String) null, thumbnailUrl2, watchEndpoint2, watchEndpoint3, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                                            }
                                        }
                                    }
                                }
                            } else if (browseEndpoint2 != null) {
                                str = browseEndpoint2.browseId;
                                if (header != null) {
                                    strJoinToString$default = CollectionsKt.joinToString$default(list, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 7), 30);
                                    artist = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(list11));
                                    thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                                    if (thumbnailUrl != null) {
                                        it = list9.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = null;
                                                break;
                                            }
                                            next = it.next();
                                            icon2 = ((Button) next).buttonRenderer.icon;
                                            if (icon2 != null) {
                                                str3 = icon2.iconType;
                                            } else {
                                                str3 = null;
                                            }
                                        } while (!Intrinsics.areEqual(str3, "PLAY_ARROW"));
                                        button = (Button) next;
                                        if (button != null) {
                                            watchEndpoint = null;
                                        } else {
                                            watchEndpoint = null;
                                        }
                                        it2 = list9.iterator();
                                        do {
                                            if (it2.hasNext()) {
                                                next2 = null;
                                                break;
                                            }
                                            next2 = it2.next();
                                            icon = ((Button) next2).buttonRenderer.icon;
                                            if (icon != null) {
                                                str2 = icon.iconType;
                                            } else {
                                                str2 = null;
                                            }
                                        } while (!Intrinsics.areEqual(str2, "MUSIC_SHUFFLE"));
                                        button2 = (Button) next2;
                                        if (button2 != null) {
                                            obj = navigationEndpoint.watchPlaylistEndpoint;
                                        }
                                        return new PodcastItem(str, strJoinToString$default, artist, null, thumbnailUrl, watchEndpoint, obj, null, null, null, 896);
                                    }
                                }
                            }
                        } else if (browseEndpoint2 != null) {
                            str = browseEndpoint2.browseId;
                            if (header != null) {
                                strJoinToString$default = CollectionsKt.joinToString$default(list, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 7), 30);
                                artist = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(list11));
                                thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                                if (thumbnailUrl != null) {
                                    it = list9.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        icon2 = ((Button) next).buttonRenderer.icon;
                                        if (icon2 != null) {
                                            str3 = icon2.iconType;
                                        } else {
                                            str3 = null;
                                        }
                                    } while (!Intrinsics.areEqual(str3, "PLAY_ARROW"));
                                    button = (Button) next;
                                    if (button != null) {
                                        watchEndpoint = null;
                                    } else {
                                        watchEndpoint = null;
                                    }
                                    it2 = list9.iterator();
                                    do {
                                        if (it2.hasNext()) {
                                            next2 = null;
                                            break;
                                        }
                                        next2 = it2.next();
                                        icon = ((Button) next2).buttonRenderer.icon;
                                        if (icon != null) {
                                            str2 = icon.iconType;
                                        } else {
                                            str2 = null;
                                        }
                                    } while (!Intrinsics.areEqual(str2, "MUSIC_SHUFFLE"));
                                    button2 = (Button) next2;
                                    if (button2 != null) {
                                        obj = navigationEndpoint.watchPlaylistEndpoint;
                                    }
                                    return new PodcastItem(str, strJoinToString$default, artist, null, thumbnailUrl, watchEndpoint, obj, null, null, null, 896);
                                }
                            }
                        }
                    }
                }
                String str16 = browseEndpoint2.browseId;
                Button button7 = (Button) CollectionsKt.firstOrNull(list9);
                if (button7 != null && (buttonRenderer5 = button7.buttonRenderer) != null && (navigationEndpoint5 = buttonRenderer5.command) != null) {
                    WatchEndpoint watchEndpoint7 = navigationEndpoint5.watchEndpoint;
                    if (watchEndpoint7 == null) {
                        watchEndpoint7 = navigationEndpoint5.watchPlaylistEndpoint;
                    }
                    if (watchEndpoint7 != null && (str7 = watchEndpoint7.playlistId) != null && (list4 = runs3.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str8 = run2.text) != null) {
                        Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                        ArrayList arrayListExtractArtists2 = PageHelper.extractArtists(list11);
                        String thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl5 != null) {
                            if (list8 != null) {
                                for (Object obj3 : list8) {
                                    Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2 = ((Badges) obj3).musicInlineBadgeRenderer;
                                    if (Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon5 = musicInlineBadgeRenderer2.icon) == null) ? null : icon5.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                        obj = obj3;
                                        break;
                                    }
                                }
                                obj = (Badges) obj;
                            }
                            return new AlbumItem(str16, str7, str8, arrayListExtractArtists2, (Integer) null, thumbnailUrl5, obj != null, 4);
                        }
                    }
                }
            } else if (browseEndpoint2 == null) {
                browseEndpointContextSupportedConfigs = browseEndpoint2.browseEndpointContextSupportedConfigs;
                if (browseEndpointContextSupportedConfigs != null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) {
                    str4 = null;
                } else {
                    str4 = browseEndpointContextMusicConfig.pageType;
                }
                if (Intrinsics.areEqual(str4, "MUSIC_PAGE_TYPE_PLAYLIST")) {
                    strRemovePrefix = StringsKt.removePrefix(browseEndpoint2.browseId, "VL");
                    if (header != null && (musicCardShelfHeaderBasicRenderer2 = header.musicCardShelfHeaderBasicRenderer) != null && (runs2 = musicCardShelfHeaderBasicRenderer2.title) != null && (list2 = runs2.runs) != null) {
                        strJoinToString$default2 = CollectionsKt.joinToString$default(list2, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 6), 30);
                        artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list11));
                        if (artist2 != null) {
                            artist3 = artist2;
                        } else {
                            if (list11 != null && (list3 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list11))) != null && (run = (Run) CollectionsKt.firstOrNull(list3)) != null) {
                                if (run.navigationEndpoint == null || StringsKt.isBlank(run.text)) {
                                    run = null;
                                }
                                if (run != null) {
                                    artist2 = new Artist(StringsKt.trim(run.text).toString(), null);
                                    artist3 = artist2;
                                }
                            }
                            artist3 = null;
                        }
                        thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl2 != null) {
                            it3 = list9.iterator();
                            do {
                                if (it3.hasNext()) {
                                    next3 = null;
                                    break;
                                }
                                next3 = it3.next();
                                icon4 = ((Button) next3).buttonRenderer.icon;
                                if (icon4 != null) {
                                    str6 = icon4.iconType;
                                } else {
                                    str6 = null;
                                }
                            } while (!Intrinsics.areEqual(str6, "PLAY_ARROW"));
                            button3 = (Button) next3;
                            if (button3 != null && (buttonRenderer3 = button3.buttonRenderer) != null && (navigationEndpoint3 = buttonRenderer3.command) != null && (watchEndpoint2 = navigationEndpoint3.watchPlaylistEndpoint) != null) {
                                it4 = list9.iterator();
                                do {
                                    if (it4.hasNext()) {
                                        next4 = null;
                                        break;
                                    }
                                    next4 = it4.next();
                                    icon3 = ((Button) next4).buttonRenderer.icon;
                                    if (icon3 != null) {
                                        str5 = icon3.iconType;
                                    } else {
                                        str5 = null;
                                    }
                                } while (!Intrinsics.areEqual(str5, "MUSIC_SHUFFLE"));
                                button4 = (Button) next4;
                                if (button4 != null && (buttonRenderer4 = button4.buttonRenderer) != null && (navigationEndpoint4 = buttonRenderer4.command) != null && (watchEndpoint3 = navigationEndpoint4.watchPlaylistEndpoint) != null) {
                                    return new PlaylistItem(strRemovePrefix, strJoinToString$default2, artist3, (String) null, thumbnailUrl2, watchEndpoint2, watchEndpoint3, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                                }
                            }
                        }
                    }
                } else if (browseEndpoint2 != null) {
                    str = browseEndpoint2.browseId;
                    if (header != null) {
                        strJoinToString$default = CollectionsKt.joinToString$default(list, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 7), 30);
                        artist = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(list11));
                        thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl != null) {
                            it = list9.iterator();
                            do {
                                if (it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                icon2 = ((Button) next).buttonRenderer.icon;
                                if (icon2 != null) {
                                    str3 = icon2.iconType;
                                } else {
                                    str3 = null;
                                }
                            } while (!Intrinsics.areEqual(str3, "PLAY_ARROW"));
                            button = (Button) next;
                            if (button != null) {
                                watchEndpoint = null;
                            } else {
                                watchEndpoint = null;
                            }
                            it2 = list9.iterator();
                            do {
                                if (it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                                icon = ((Button) next2).buttonRenderer.icon;
                                if (icon != null) {
                                    str2 = icon.iconType;
                                } else {
                                    str2 = null;
                                }
                            } while (!Intrinsics.areEqual(str2, "MUSIC_SHUFFLE"));
                            button2 = (Button) next2;
                            if (button2 != null) {
                                obj = navigationEndpoint.watchPlaylistEndpoint;
                            }
                            return new PodcastItem(str, strJoinToString$default, artist, null, thumbnailUrl, watchEndpoint, obj, null, null, null, 896);
                        }
                    }
                }
            } else if (browseEndpoint2 != null && browseEndpoint2.isPodcastEndpoint()) {
                str = browseEndpoint2.browseId;
                if (header != null && (musicCardShelfHeaderBasicRenderer = header.musicCardShelfHeaderBasicRenderer) != null && (runs = musicCardShelfHeaderBasicRenderer.title) != null && (list = runs.runs) != null) {
                    strJoinToString$default = CollectionsKt.joinToString$default(list, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 7), 30);
                    artist = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(list11));
                    thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl != null) {
                        it = list9.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            icon2 = ((Button) next).buttonRenderer.icon;
                            if (icon2 != null) {
                                str3 = icon2.iconType;
                            } else {
                                str3 = null;
                            }
                        } while (!Intrinsics.areEqual(str3, "PLAY_ARROW"));
                        button = (Button) next;
                        if (button != null || (buttonRenderer2 = button.buttonRenderer) == null || (navigationEndpoint2 = buttonRenderer2.command) == null) {
                            watchEndpoint = null;
                        } else {
                            watchEndpoint = navigationEndpoint2.watchPlaylistEndpoint;
                        }
                        it2 = list9.iterator();
                        do {
                            if (it2.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it2.next();
                            icon = ((Button) next2).buttonRenderer.icon;
                            if (icon != null) {
                                str2 = icon.iconType;
                            } else {
                                str2 = null;
                            }
                        } while (!Intrinsics.areEqual(str2, "MUSIC_SHUFFLE"));
                        button2 = (Button) next2;
                        if (button2 != null && (buttonRenderer = button2.buttonRenderer) != null && (navigationEndpoint = buttonRenderer.command) != null) {
                            obj = navigationEndpoint.watchPlaylistEndpoint;
                        }
                        return new PodcastItem(str, strJoinToString$default, artist, null, thumbnailUrl, watchEndpoint, obj, null, null, null, 896);
                    }
                }
            }
            return null;
        }
    }

    public SearchSummaryPage(List list) {
        this.summaries = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchSummaryPage) && this.summaries.equals(((SearchSummaryPage) obj).summaries);
    }

    public final int hashCode() {
        return this.summaries.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("SearchSummaryPage(summaries=", ")", this.summaries);
    }
}
