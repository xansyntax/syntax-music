package com.metrolist.shazamkit;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Shazam$recognize$1 extends ContinuationImpl {
    public long J$0;
    public String L$0;
    public String L$1;
    public Mutex L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Shazam this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Shazam$recognize$1(Shazam shazam, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = shazam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1533recognize0E7RQCE = this.this$0.m1533recognize0E7RQCE(0L, null, this);
        return objM1533recognize0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1533recognize0E7RQCE : new Result(objM1533recognize0E7RQCE);
    }
}
