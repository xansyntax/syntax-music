package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarResult {
    public static final /* synthetic */ SnackbarResult[] $VALUES;
    public static final SnackbarResult ActionPerformed;
    public static final SnackbarResult Dismissed;

    static {
        SnackbarResult snackbarResult = new SnackbarResult("Dismissed", 0);
        Dismissed = snackbarResult;
        SnackbarResult snackbarResult2 = new SnackbarResult("ActionPerformed", 1);
        ActionPerformed = snackbarResult2;
        $VALUES = new SnackbarResult[]{snackbarResult, snackbarResult2};
    }

    public static SnackbarResult valueOf(String str) {
        return (SnackbarResult) Enum.valueOf(SnackbarResult.class, str);
    }

    public static SnackbarResult[] values() {
        return (SnackbarResult[]) $VALUES.clone();
    }
}
