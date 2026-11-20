package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackTransportPreference {
    public static final /* synthetic */ PlaybackTransportPreference[] $VALUES;
    public static final PlaybackTransportPreference AUTO;

    static {
        PlaybackTransportPreference playbackTransportPreference = new PlaybackTransportPreference("AUTO", 0);
        AUTO = playbackTransportPreference;
        $VALUES = new PlaybackTransportPreference[]{playbackTransportPreference, new PlaybackTransportPreference("DIRECT", 1), new PlaybackTransportPreference("SABR", 2), new PlaybackTransportPreference("HLS", 3)};
    }

    public static PlaybackTransportPreference valueOf(String str) {
        return (PlaybackTransportPreference) Enum.valueOf(PlaybackTransportPreference.class, str);
    }

    public static PlaybackTransportPreference[] values() {
        return (PlaybackTransportPreference[]) $VALUES.clone();
    }
}
