package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PodcastFilter {
    public static final /* synthetic */ PodcastFilter[] $VALUES;
    public static final PodcastFilter CHANNELS;
    public static final PodcastFilter DOWNLOADED;
    public static final PodcastFilter EPISODES;

    static {
        PodcastFilter podcastFilter = new PodcastFilter("EPISODES", 0);
        EPISODES = podcastFilter;
        PodcastFilter podcastFilter2 = new PodcastFilter("CHANNELS", 1);
        CHANNELS = podcastFilter2;
        PodcastFilter podcastFilter3 = new PodcastFilter("DOWNLOADED", 2);
        DOWNLOADED = podcastFilter3;
        $VALUES = new PodcastFilter[]{podcastFilter, podcastFilter2, podcastFilter3};
    }

    public static PodcastFilter valueOf(String str) {
        return (PodcastFilter) Enum.valueOf(PodcastFilter.class, str);
    }

    public static PodcastFilter[] values() {
        return (PodcastFilter[]) $VALUES.clone();
    }
}
