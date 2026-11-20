package androidx.compose.ui.node;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Invalidation {
    public static final /* synthetic */ Invalidation[] $VALUES;
    public static final Invalidation LookaheadMeasurement;
    public static final Invalidation LookaheadPlacement;
    public static final Invalidation Measurement;
    public static final Invalidation Placement;

    static {
        Invalidation invalidation = new Invalidation("LookaheadMeasurement", 0);
        LookaheadMeasurement = invalidation;
        Invalidation invalidation2 = new Invalidation("LookaheadPlacement", 1);
        LookaheadPlacement = invalidation2;
        Invalidation invalidation3 = new Invalidation("Measurement", 2);
        Measurement = invalidation3;
        Invalidation invalidation4 = new Invalidation("Placement", 3);
        Placement = invalidation4;
        $VALUES = new Invalidation[]{invalidation, invalidation2, invalidation3, invalidation4};
    }

    public static Invalidation valueOf(String str) {
        return (Invalidation) Enum.valueOf(Invalidation.class, str);
    }

    public static Invalidation[] values() {
        return (Invalidation[]) $VALUES.clone();
    }
}
