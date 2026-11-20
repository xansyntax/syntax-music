package com.metrolist.music.api;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpenRouterService$translate$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ OpenRouterService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenRouterService$translate$1(OpenRouterService openRouterService, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = openRouterService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1056translatetZkwj4A = this.this$0.m1056translatetZkwj4A(null, null, null, null, null, null, 0, null, this);
        return objM1056translatetZkwj4A == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1056translatetZkwj4A : new Result(objM1056translatetZkwj4A);
    }
}
