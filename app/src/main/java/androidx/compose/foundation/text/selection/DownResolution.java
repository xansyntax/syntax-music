package androidx.compose.foundation.text.selection;

import io.ktor.http.HttpHeaders;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DownResolution {
    public static final /* synthetic */ DownResolution[] $VALUES;
    public static final DownResolution Cancel;
    public static final DownResolution Drag;
    public static final DownResolution Timeout;
    public static final DownResolution Up;

    static {
        DownResolution downResolution = new DownResolution("Up", 0);
        Up = downResolution;
        DownResolution downResolution2 = new DownResolution("Drag", 1);
        Drag = downResolution2;
        DownResolution downResolution3 = new DownResolution(HttpHeaders.Timeout, 2);
        Timeout = downResolution3;
        DownResolution downResolution4 = new DownResolution("Cancel", 3);
        Cancel = downResolution4;
        $VALUES = new DownResolution[]{downResolution, downResolution2, downResolution3, downResolution4};
    }

    public static DownResolution valueOf(String str) {
        return (DownResolution) Enum.valueOf(DownResolution.class, str);
    }

    public static DownResolution[] values() {
        return (DownResolution[]) $VALUES.clone();
    }
}
