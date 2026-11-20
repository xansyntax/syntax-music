package kotlinx.coroutines;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ThreadLocalEventLoop {
    public static final ThreadLocal ref = new ThreadLocal();

    public static EventLoop getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal threadLocal = ref;
        EventLoop eventLoop = (EventLoop) threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        BlockingEventLoop blockingEventLoop = new BlockingEventLoop(Thread.currentThread());
        threadLocal.set(blockingEventLoop);
        return blockingEventLoop;
    }
}
