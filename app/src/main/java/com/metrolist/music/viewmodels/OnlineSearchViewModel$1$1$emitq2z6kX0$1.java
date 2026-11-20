package com.metrolist.music.viewmodels;

import com.metrolist.innertube.pages.SearchResult;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchViewModel$1$1$emit-q2z6kX0$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchViewModel$1$1$emitq2z6kX0$1 extends ContinuationImpl {
    public String L$0;
    public Object L$1;
    public OnlineSearchViewModel L$2;
    public SearchResult L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ OnlineSearchViewModel$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineSearchViewModel$1$1$emitq2z6kX0$1(OnlineSearchViewModel$1$1 onlineSearchViewModel$1$1, Continuation continuation) {
        super(continuation);
        this.this$0 = onlineSearchViewModel$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1530emitq2z6kX0(null, this);
    }
}
