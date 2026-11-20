package androidx.compose.animation.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RepeatMode {
    public static final /* synthetic */ RepeatMode[] $VALUES;
    public static final RepeatMode Restart;
    public static final RepeatMode Reverse;

    static {
        RepeatMode repeatMode = new RepeatMode("Restart", 0);
        Restart = repeatMode;
        RepeatMode repeatMode2 = new RepeatMode("Reverse", 1);
        Reverse = repeatMode2;
        $VALUES = new RepeatMode[]{repeatMode, repeatMode2};
    }

    public static RepeatMode valueOf(String str) {
        return (RepeatMode) Enum.valueOf(RepeatMode.class, str);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) $VALUES.clone();
    }
}
