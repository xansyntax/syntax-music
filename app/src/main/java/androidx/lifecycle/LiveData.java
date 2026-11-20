package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {
    public static final Object NOT_SET = new Object();
    public volatile Object mData;
    public final Object mDataLock;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public final SafeIterableMap mObservers = new SafeIterableMap();
    public volatile Object mPendingData;

    public LiveData() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mData = obj;
    }
}
