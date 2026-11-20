package okio;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Timeout$Companion$NONE$1 extends Timeout {
    @Override // okio.Timeout
    public final Timeout timeout(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this;
    }

    @Override // okio.Timeout
    public final void throwIfReached() {
    }

    @Override // okio.Timeout
    public final Timeout deadlineNanoTime(long j) {
        return this;
    }
}
