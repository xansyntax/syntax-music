package kotlinx.coroutines;

import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DefaultExecutorKt {
    public static final Delay DefaultDelay;

    static {
        String property;
        HandlerContext handlerContext;
        Delay delay;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            handlerContext = MainDispatcherLoader.dispatcher;
            HandlerContext handlerContext2 = handlerContext.immediate;
            if (handlerContext == null) {
                delay = handlerContext;
                delay = DefaultExecutor.INSTANCE;
            }
        } else {
            delay = DefaultExecutor.INSTANCE;
        }
        delay = handlerContext;
        DefaultDelay = delay;
    }
}
