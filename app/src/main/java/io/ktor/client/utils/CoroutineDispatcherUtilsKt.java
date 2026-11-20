package io.ktor.client.utils;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "threadCount", "", "dispatcherName", "Lkotlinx/coroutines/CoroutineDispatcher;", "clientDispatcher", "(Lkotlinx/coroutines/Dispatchers;ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CoroutineDispatcherUtilsKt {
    public static final CoroutineDispatcher clientDispatcher(Dispatchers dispatchers, int i, String str) {
        dispatchers.getClass();
        str.getClass();
        return DefaultIoScheduler.INSTANCE.limitedParallelism(i, null);
    }

    public static /* synthetic */ CoroutineDispatcher clientDispatcher$default(Dispatchers dispatchers, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "ktor-client-dispatcher";
        }
        return clientDispatcher(dispatchers, i, str);
    }
}
