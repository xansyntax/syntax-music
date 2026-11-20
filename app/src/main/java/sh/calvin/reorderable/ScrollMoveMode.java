package sh.calvin.reorderable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ScrollMoveMode {
    public static final /* synthetic */ ScrollMoveMode[] $VALUES;
    public static final ScrollMoveMode SWAP;

    static {
        ScrollMoveMode scrollMoveMode = new ScrollMoveMode("SWAP", 0);
        SWAP = scrollMoveMode;
        $VALUES = new ScrollMoveMode[]{scrollMoveMode, new ScrollMoveMode("INSERT", 1)};
    }

    public static ScrollMoveMode valueOf(String str) {
        return (ScrollMoveMode) Enum.valueOf(ScrollMoveMode.class, str);
    }

    public static ScrollMoveMode[] values() {
        return (ScrollMoveMode[]) $VALUES.clone();
    }
}
