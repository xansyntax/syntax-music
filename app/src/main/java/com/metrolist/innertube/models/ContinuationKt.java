package com.metrolist.innertube.models;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContinuationKt {
    public static final String getContinuation(List list) {
        Continuation.NextContinuationData nextContinuationData;
        list.getClass();
        Continuation continuation = (Continuation) CollectionsKt.firstOrNull(list);
        if (continuation == null || (nextContinuationData = continuation.nextContinuationData) == null) {
            return null;
        }
        return nextContinuationData.continuation;
    }
}
