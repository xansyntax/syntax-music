package androidx.room;

import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.NetworkFetcher;
import com.google.common.math.IntMath;
import com.metrolist.music.db.InternalDatabase_Impl;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InvalidationTracker {
    public final InternalDatabase_Impl database;
    public final AtomicInteger flowCount;
    public final TriggerBasedInvalidationTracker implementation;
    public final LinkedHashMap observerMap;
    public final ReentrantLock observerMapLock;
    public final UtilsKt$$ExternalSyntheticLambda0 onRefreshCompleted;
    public final UtilsKt$$ExternalSyntheticLambda0 onRefreshScheduled;
    public final Object trackerLock;

    public InvalidationTracker(InternalDatabase_Impl internalDatabase_Impl, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, String... strArr) {
        this.database = internalDatabase_Impl;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(internalDatabase_Impl, linkedHashMap, linkedHashMap2, strArr, internalDatabase_Impl.useTempTrackingTable, new NetworkFetcher.AnonymousClass2(1, this, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, (byte) 7));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        this.flowCount = new AtomicInteger(0);
        this.onRefreshScheduled = new UtilsKt$$ExternalSyntheticLambda0(this, (byte) 12);
        this.onRefreshCompleted = new UtilsKt$$ExternalSyntheticLambda0(this, (byte) 13);
        Collections.newSetFromMap(new IdentityHashMap()).getClass();
        this.trackerLock = new Object();
        triggerBasedInvalidationTracker.onAllowRefresh = new RoomDatabase$$ExternalSyntheticLambda0((byte) 24, this);
    }

    public final void refreshAsync() {
        if (((AtomicBoolean) this.database.closeBarrier.runningSyncCalls).get()) {
            return;
        }
        this.implementation.refreshInvalidationAsync$room_runtime(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public final Object sync$room_runtime(SuspendLambda suspendLambda) {
        IntMath.throwIfClosed(this.database);
        Object objSyncTriggers$room_runtime = this.implementation.syncTriggers$room_runtime(suspendLambda);
        return objSyncTriggers$room_runtime == CoroutineSingletons.COROUTINE_SUSPENDED ? objSyncTriggers$room_runtime : Unit.INSTANCE;
    }
}
