package androidx.compose.ui.text.platform;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DispatcherKt {
    public static final HandlerContext FontCacheManagementDispatcher;

    static {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        FontCacheManagementDispatcher = MainDispatcherLoader.dispatcher;
    }
}
