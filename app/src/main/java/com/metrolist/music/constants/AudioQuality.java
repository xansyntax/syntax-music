package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioQuality {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ AudioQuality[] $VALUES;
    public static final AudioQuality AUTO;
    public static final AudioQuality HIGH;

    static {
        AudioQuality audioQuality = new AudioQuality("AUTO", 0);
        AUTO = audioQuality;
        AudioQuality audioQuality2 = new AudioQuality("LOW", 1);
        AudioQuality audioQuality3 = new AudioQuality("HIGH", 2);
        HIGH = audioQuality3;
        AudioQuality[] audioQualityArr = {audioQuality, audioQuality2, audioQuality3};
        $VALUES = audioQualityArr;
        $ENTRIES = new EnumEntriesList(audioQualityArr);
    }

    public static AudioQuality valueOf(String str) {
        return (AudioQuality) Enum.valueOf(AudioQuality.class, str);
    }

    public static AudioQuality[] values() {
        return (AudioQuality[]) $VALUES.clone();
    }
}
