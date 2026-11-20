package androidx.compose.ui.input.pointer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerClassification {
    public static final /* synthetic */ PointerClassification[] $VALUES;
    public static final PointerClassification Ambiguous;
    public static final PointerClassification DeepPress;
    public static final PointerClassification None;
    public static final PointerClassification Pan;
    public static final PointerClassification Pinch;

    static {
        PointerClassification pointerClassification = new PointerClassification("None", 0);
        None = pointerClassification;
        PointerClassification pointerClassification2 = new PointerClassification("Ambiguous", 1);
        Ambiguous = pointerClassification2;
        PointerClassification pointerClassification3 = new PointerClassification("DeepPress", 2);
        DeepPress = pointerClassification3;
        PointerClassification pointerClassification4 = new PointerClassification("Pinch", 3);
        Pinch = pointerClassification4;
        PointerClassification pointerClassification5 = new PointerClassification("Pan", 4);
        Pan = pointerClassification5;
        $VALUES = new PointerClassification[]{pointerClassification, pointerClassification2, pointerClassification3, pointerClassification4, pointerClassification5};
    }

    public static PointerClassification valueOf(String str) {
        return (PointerClassification) Enum.valueOf(PointerClassification.class, str);
    }

    public static PointerClassification[] values() {
        return (PointerClassification[]) $VALUES.clone();
    }
}
