package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchSource {
    public static final /* synthetic */ SearchSource[] $VALUES;
    public static final SearchSource LOCAL;
    public static final SearchSource ONLINE;

    static {
        SearchSource searchSource = new SearchSource("LOCAL", 0);
        LOCAL = searchSource;
        SearchSource searchSource2 = new SearchSource("ONLINE", 1);
        ONLINE = searchSource2;
        $VALUES = new SearchSource[]{searchSource, searchSource2};
    }

    public static SearchSource valueOf(String str) {
        return (SearchSource) Enum.valueOf(SearchSource.class, str);
    }

    public static SearchSource[] values() {
        return (SearchSource[]) $VALUES.clone();
    }
}
