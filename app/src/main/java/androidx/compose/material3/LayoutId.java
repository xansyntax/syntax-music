package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutId {
    public static final /* synthetic */ LayoutId[] $VALUES;
    public static final LayoutId InnerCircle;
    public static final LayoutId Selector;

    static {
        LayoutId layoutId = new LayoutId("Selector", 0);
        Selector = layoutId;
        LayoutId layoutId2 = new LayoutId("InnerCircle", 1);
        InnerCircle = layoutId2;
        $VALUES = new LayoutId[]{layoutId, layoutId2};
    }

    public static LayoutId valueOf(String str) {
        return (LayoutId) Enum.valueOf(LayoutId.class, str);
    }

    public static LayoutId[] values() {
        return (LayoutId[]) $VALUES.clone();
    }
}
