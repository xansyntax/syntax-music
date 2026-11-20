package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissBoxValue {
    public static final /* synthetic */ SwipeToDismissBoxValue[] $VALUES;
    public static final SwipeToDismissBoxValue EndToStart;
    public static final SwipeToDismissBoxValue Settled;
    public static final SwipeToDismissBoxValue StartToEnd;

    static {
        SwipeToDismissBoxValue swipeToDismissBoxValue = new SwipeToDismissBoxValue("StartToEnd", 0);
        StartToEnd = swipeToDismissBoxValue;
        SwipeToDismissBoxValue swipeToDismissBoxValue2 = new SwipeToDismissBoxValue("EndToStart", 1);
        EndToStart = swipeToDismissBoxValue2;
        SwipeToDismissBoxValue swipeToDismissBoxValue3 = new SwipeToDismissBoxValue("Settled", 2);
        Settled = swipeToDismissBoxValue3;
        $VALUES = new SwipeToDismissBoxValue[]{swipeToDismissBoxValue, swipeToDismissBoxValue2, swipeToDismissBoxValue3};
    }

    public static SwipeToDismissBoxValue valueOf(String str) {
        return (SwipeToDismissBoxValue) Enum.valueOf(SwipeToDismissBoxValue.class, str);
    }

    public static SwipeToDismissBoxValue[] values() {
        return (SwipeToDismissBoxValue[]) $VALUES.clone();
    }
}
