package com.metrolist.innertube;

import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.response.NextResponse;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$next$1 extends ContinuationImpl {
    public WatchEndpoint L$0;
    public YouTube L$2;
    public String L$4;
    public ArrayList L$6;
    public Integer L$7;
    public WatchEndpoint L$8;
    public NextResponse L$9;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ YouTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTube$next$1(YouTube youTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = youTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1024next0E7RQCE = this.this$0.m1024next0E7RQCE(null, null, this);
        return objM1024next0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1024next0E7RQCE : new Result(objM1024next0E7RQCE);
    }
}
