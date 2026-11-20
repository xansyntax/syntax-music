package com.metrolist.innertube;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$accountInfo$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ YouTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTube$accountInfo$1(YouTube youTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = youTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM991accountInfoIoAF18A = this.this$0.m991accountInfoIoAF18A(this);
        return objM991accountInfoIoAF18A == CoroutineSingletons.COROUTINE_SUSPENDED ? objM991accountInfoIoAF18A : new Result(objM991accountInfoIoAF18A);
    }
}
