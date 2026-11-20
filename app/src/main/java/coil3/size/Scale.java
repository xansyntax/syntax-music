package coil3.size;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Scale {
    public static final /* synthetic */ Scale[] $VALUES;
    public static final Scale FILL;
    public static final Scale FIT;

    static {
        Scale scale = new Scale("FILL", 0);
        FILL = scale;
        Scale scale2 = new Scale("FIT", 1);
        FIT = scale2;
        $VALUES = new Scale[]{scale, scale2};
    }

    public static Scale valueOf(String str) {
        return (Scale) Enum.valueOf(Scale.class, str);
    }

    public static Scale[] values() {
        return (Scale[]) $VALUES.clone();
    }
}
