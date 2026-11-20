package com.metrolist.music.utils;

import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PodcastRefreshTrigger {
    public static final SharedFlowImpl _refreshFlow;
    public static final ReadonlySharedFlow refreshFlow;

    static {
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default = StateFlowKt.MutableSharedFlow$default(1, 5, null);
        _refreshFlow = sharedFlowImplMutableSharedFlow$default;
        refreshFlow = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default);
    }
}
