package io.ktor.utils.io;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class IODispatcher_jvmKt {
    public static final CoroutineDispatcher ioDispatcher() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return DefaultIoScheduler.INSTANCE;
    }
}
