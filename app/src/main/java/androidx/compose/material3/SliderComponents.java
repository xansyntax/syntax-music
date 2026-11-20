package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderComponents {
    public static final /* synthetic */ SliderComponents[] $VALUES;
    public static final SliderComponents THUMB;
    public static final SliderComponents TRACK;

    static {
        SliderComponents sliderComponents = new SliderComponents("THUMB", 0);
        THUMB = sliderComponents;
        SliderComponents sliderComponents2 = new SliderComponents("TRACK", 1);
        TRACK = sliderComponents2;
        $VALUES = new SliderComponents[]{sliderComponents, sliderComponents2};
    }

    public static SliderComponents valueOf(String str) {
        return (SliderComponents) Enum.valueOf(SliderComponents.class, str);
    }

    public static SliderComponents[] values() {
        return (SliderComponents[]) $VALUES.clone();
    }
}
