package com.metrolist.innertube.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeUrlParser {
    public static final List VIDEO_URL_PATTERNS = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("(?:https?://)?(?:www\\.)?(?:music\\.)?youtube\\.com/watch\\?.*v=([a-zA-Z0-9_-]{11})"), new Regex("(?:https?://)?(?:www\\.)?(?:music\\.)?youtube\\.com/watch\\?v=([a-zA-Z0-9_-]{11})"), new Regex("(?:https?://)?youtu\\.be/([a-zA-Z0-9_-]{11})"), new Regex("(?:https?://)?(?:www\\.)?youtube\\.com/shorts/([a-zA-Z0-9_-]{11})")});
    public static final Regex PLAYLIST_URL_PATTERN = new Regex("(?:https?://)?(?:www\\.)?(?:music\\.)?youtube\\.com/playlist\\?.*list=([a-zA-Z0-9_-]+)");
    public static final Regex ALBUM_URL_PATTERN = new Regex("(?:https?://)?(?:www\\.)?music\\.youtube\\.com/playlist\\?.*list=([a-zA-Z0-9_-]+)");
    public static final List ARTIST_URL_PATTERNS = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("(?:https?://)?(?:www\\.)?music\\.youtube\\.com/channel/([a-zA-Z0-9_-]+)"), new Regex("(?:https?://)?(?:www\\.)?music\\.youtube\\.com/browse/(MPRE[a-zA-Z0-9_-]+)")});

    public static Okio__OkioKt parse(String str) {
        String str2;
        String str3;
        MatcherMatchResult matcherMatchResultFind$default;
        String str4;
        String str5;
        str.getClass();
        String string = StringsKt.trim(str).toString();
        Iterator it = VIDEO_URL_PATTERNS.iterator();
        while (it.hasNext()) {
            MatcherMatchResult matcherMatchResultFind$default2 = Regex.find$default((Regex) it.next(), string);
            if (matcherMatchResultFind$default2 != null && (str5 = (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default2.getGroupValues())) != null) {
                return new YouTubeUrlParser$ParsedUrl$Video(str5);
            }
        }
        if (!StringsKt.contains(string, "music.youtube.com", false) && (matcherMatchResultFind$default = Regex.find$default(PLAYLIST_URL_PATTERN, string)) != null && (str4 = (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default.getGroupValues())) != null) {
            return new YouTubeUrlParser$ParsedUrl$Playlist(str4);
        }
        if (!StringsKt.contains(string, "music.youtube.com", false)) {
            return null;
        }
        MatcherMatchResult matcherMatchResultFind$default3 = Regex.find$default(ALBUM_URL_PATTERN, string);
        if (matcherMatchResultFind$default3 != null && (str3 = (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default3.getGroupValues())) != null) {
            return new YouTubeUrlParser$ParsedUrl$Album(str3);
        }
        Iterator it2 = ARTIST_URL_PATTERNS.iterator();
        while (it2.hasNext()) {
            MatcherMatchResult matcherMatchResultFind$default4 = Regex.find$default((Regex) it2.next(), string);
            if (matcherMatchResultFind$default4 != null && (str2 = (String) CollectionsKt.getOrNull(1, matcherMatchResultFind$default4.getGroupValues())) != null) {
                return new YouTubeUrlParser$ParsedUrl$Artist(str2);
            }
        }
        return null;
    }
}
