package androidx.compose.ui.unit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutDirection {
    public static final /* synthetic */ LayoutDirection[] $VALUES;
    public static final LayoutDirection Ltr;
    public static final LayoutDirection Rtl;

    static {
        LayoutDirection layoutDirection = new LayoutDirection("Ltr", 0);
        Ltr = layoutDirection;
        LayoutDirection layoutDirection2 = new LayoutDirection("Rtl", 1);
        Rtl = layoutDirection2;
        $VALUES = new LayoutDirection[]{layoutDirection, layoutDirection2};
    }

    public static LayoutDirection valueOf(String str) {
        return (LayoutDirection) Enum.valueOf(LayoutDirection.class, str);
    }

    public static LayoutDirection[] values() {
        return (LayoutDirection[]) $VALUES.clone();
    }
}
