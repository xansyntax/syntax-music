package kotlinx.coroutines.sync;

import com.google.common.base.Joiner;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SemaphoreKt {
    public static final int MAX_SPIN_CYCLES = InlineList.systemProp$default(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");
    public static final Joiner PERMIT = new Joiner("PERMIT", (byte) 5);
    public static final Joiner TAKEN = new Joiner("TAKEN", (byte) 5);
    public static final Joiner BROKEN = new Joiner("BROKEN", (byte) 5);
    public static final Joiner CANCELLED = new Joiner("CANCELLED", (byte) 5);
    public static final int SEGMENT_SIZE = InlineList.systemProp$default(16, 12, "kotlinx.coroutines.semaphore.segmentSize");
}
