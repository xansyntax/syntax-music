package okhttp3.internal.concurrent;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Task {
    public final boolean cancelable;
    public final String name;
    public long nextExecuteNanoTime;
    public TaskQueue queue;

    public Task(String str, boolean z) {
        str.getClass();
        this.name = str;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public abstract long runOnce();

    public final String toString() {
        return this.name;
    }
}
