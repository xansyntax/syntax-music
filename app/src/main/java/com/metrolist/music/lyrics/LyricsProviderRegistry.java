package com.metrolist.music.lyrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LyricsProviderRegistry {
    public static final Map providerMap;
    public static final List providerNames;

    static {
        Map mapMapOf = MapsKt__MapsKt.mapOf(new Pair("BetterLyrics", BetterLyricsProvider.INSTANCE), new Pair("Paxsenix", KuGouLyricsProvider.INSTANCE$2), new Pair("LrcLib", KuGouLyricsProvider.INSTANCE$1), new Pair("KuGou", KuGouLyricsProvider.INSTANCE), new Pair("LyricsPlus", LyricsPlusProvider.INSTANCE), new Pair("Zemer", ZemerLyricsProvider.INSTANCE), new Pair("YouTubeSubtitle", BetterLyricsProvider.INSTANCE$2), new Pair("YouTube", BetterLyricsProvider.INSTANCE$1));
        providerMap = mapMapOf;
        providerNames = CollectionsKt.toList(mapMapOf.keySet());
    }

    public static List deserializeProviderOrder(String str) {
        str.getClass();
        if (StringsKt.isBlank(str)) {
            return getDefaultProviderOrder();
        }
        int i = 0;
        List listSplit$default = StringsKt.split$default(str, new String[]{","}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (providerNames.contains((String) obj)) {
                arrayList2.add(obj);
            }
        }
        List defaultProviderOrder = getDefaultProviderOrder();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : defaultProviderOrder) {
            if (!arrayList2.contains((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        return CollectionsKt.plus((Iterable) arrayList3, (Collection) arrayList2);
    }

    public static List getDefaultProviderOrder() {
        return CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"BetterLyrics", "LrcLib", "KuGou", "Paxsenix", "LyricsPlus", "Zemer", "YouTubeSubtitle", "YouTube"});
    }

    public static String serializeProviderOrder(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (providerNames.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, ",", null, null, null, 62);
    }
}
