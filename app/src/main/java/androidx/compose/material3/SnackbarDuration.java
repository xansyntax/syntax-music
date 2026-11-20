package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarDuration {
    public static final /* synthetic */ SnackbarDuration[] $VALUES;
    public static final SnackbarDuration Indefinite;
    public static final SnackbarDuration Short;

    static {
        SnackbarDuration snackbarDuration = new SnackbarDuration("Short", 0);
        Short = snackbarDuration;
        SnackbarDuration snackbarDuration2 = new SnackbarDuration("Long", 1);
        SnackbarDuration snackbarDuration3 = new SnackbarDuration("Indefinite", 2);
        Indefinite = snackbarDuration3;
        $VALUES = new SnackbarDuration[]{snackbarDuration, snackbarDuration2, snackbarDuration3};
    }

    public static SnackbarDuration valueOf(String str) {
        return (SnackbarDuration) Enum.valueOf(SnackbarDuration.class, str);
    }

    public static SnackbarDuration[] values() {
        return (SnackbarDuration[]) $VALUES.clone();
    }
}
