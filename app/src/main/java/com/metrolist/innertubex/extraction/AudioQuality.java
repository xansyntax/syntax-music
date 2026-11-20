package com.metrolist.innertubex.extraction;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioQuality {
    public static final /* synthetic */ AudioQuality[] $VALUES;
    public static final AudioQuality AUTO;
    public static final AudioQuality HIGH;
    public static final AudioQuality LOW;

    static {
        AudioQuality audioQuality = new AudioQuality("AUTO", 0);
        AUTO = audioQuality;
        AudioQuality audioQuality2 = new AudioQuality("LOW", 1);
        LOW = audioQuality2;
        AudioQuality audioQuality3 = new AudioQuality("HIGH", 2);
        HIGH = audioQuality3;
        $VALUES = new AudioQuality[]{audioQuality, audioQuality2, audioQuality3, new AudioQuality("MP4", 3)};
    }

    public static AudioQuality valueOf(String str) {
        return (AudioQuality) Enum.valueOf(AudioQuality.class, str);
    }

    public static AudioQuality[] values() {
        return (AudioQuality[]) $VALUES.clone();
    }
}
