package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderStyle {
    public static final /* synthetic */ SliderStyle[] $VALUES;
    public static final SliderStyle DEFAULT;
    public static final SliderStyle SLIM;
    public static final SliderStyle WAVY;

    static {
        SliderStyle sliderStyle = new SliderStyle("DEFAULT", 0);
        DEFAULT = sliderStyle;
        SliderStyle sliderStyle2 = new SliderStyle("WAVY", 1);
        WAVY = sliderStyle2;
        SliderStyle sliderStyle3 = new SliderStyle("SLIM", 2);
        SLIM = sliderStyle3;
        $VALUES = new SliderStyle[]{sliderStyle, sliderStyle2, sliderStyle3};
    }

    public static SliderStyle valueOf(String str) {
        return (SliderStyle) Enum.valueOf(SliderStyle.class, str);
    }

    public static SliderStyle[] values() {
        return (SliderStyle[]) $VALUES.clone();
    }
}
