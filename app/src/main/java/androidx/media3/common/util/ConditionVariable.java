package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConditionVariable {
    public final SystemClock clock = SystemClock.DEFAULT;
    public boolean isOpen;

    public ConditionVariable(int i) {
    }

    public final synchronized void block() {
        while (!this.isOpen) {
            this.clock.getClass();
            wait();
        }
    }

    public final synchronized boolean blockUninterruptible(long j) {
        try {
            if (j <= 0) {
                return this.isOpen;
            }
            this.clock.getClass();
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j2 = j + jElapsedRealtime;
            if (j2 < jElapsedRealtime) {
                blockUninterruptible();
            } else {
                boolean z = false;
                while (!this.isOpen && jElapsedRealtime < j2) {
                    try {
                        this.clock.getClass();
                        wait(j2 - jElapsedRealtime);
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                    this.clock.getClass();
                    jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
            return this.isOpen;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized void blockUninterruptible() {
        boolean z = false;
        while (!this.isOpen) {
            try {
                this.clock.getClass();
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }
}
