package androidx.compose.foundation.gestures;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DragDetectionState$AwaitDown extends ScrollableKt {
    public AwaitTouchSlop awaitTouchSlop;
    public boolean consumedOnInitial;
    public boolean hasSeenInitialEvent;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AwaitTouchSlop {
        public static final /* synthetic */ AwaitTouchSlop[] $VALUES;
        public static final AwaitTouchSlop No;
        public static final AwaitTouchSlop NotInitialized;
        public static final AwaitTouchSlop Yes;

        static {
            AwaitTouchSlop awaitTouchSlop = new AwaitTouchSlop("Yes", 0);
            Yes = awaitTouchSlop;
            AwaitTouchSlop awaitTouchSlop2 = new AwaitTouchSlop("No", 1);
            No = awaitTouchSlop2;
            AwaitTouchSlop awaitTouchSlop3 = new AwaitTouchSlop("NotInitialized", 2);
            NotInitialized = awaitTouchSlop3;
            $VALUES = new AwaitTouchSlop[]{awaitTouchSlop, awaitTouchSlop2, awaitTouchSlop3};
        }

        public static AwaitTouchSlop valueOf(String str) {
            return (AwaitTouchSlop) Enum.valueOf(AwaitTouchSlop.class, str);
        }

        public static AwaitTouchSlop[] values() {
            return (AwaitTouchSlop[]) $VALUES.clone();
        }
    }
}
