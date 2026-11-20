package com.metrolist.innertubex.extraction;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeExtractor$prewarm$fetchConfig$1 extends ContinuationImpl {
    public InnerTubeExtractor L$0;
    public Mutex L$1;
    public InnerTubeExtractor L$2;
    public InnerTubeExtractor.ConfigIdentity L$3;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return InnerTubeExtractor.prewarm$fetchConfig(null, false, this);
    }
}
