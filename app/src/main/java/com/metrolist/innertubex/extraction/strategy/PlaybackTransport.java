package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackTransport {
    public static final /* synthetic */ PlaybackTransport[] $VALUES;
    public static final PlaybackTransport DIRECT;
    public static final PlaybackTransport HLS;
    public static final PlaybackTransport SABR;

    static {
        PlaybackTransport playbackTransport = new PlaybackTransport("DIRECT", 0);
        DIRECT = playbackTransport;
        PlaybackTransport playbackTransport2 = new PlaybackTransport("SABR", 1);
        SABR = playbackTransport2;
        PlaybackTransport playbackTransport3 = new PlaybackTransport("HLS", 2);
        HLS = playbackTransport3;
        $VALUES = new PlaybackTransport[]{playbackTransport, playbackTransport2, playbackTransport3, new PlaybackTransport("DASH", 3)};
    }

    public static PlaybackTransport valueOf(String str) {
        return (PlaybackTransport) Enum.valueOf(PlaybackTransport.class, str);
    }

    public static PlaybackTransport[] values() {
        return (PlaybackTransport[]) $VALUES.clone();
    }
}
