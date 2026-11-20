package com.metrolist.music.viewmodels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HomeViewModel$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1(HomeViewModel$2$1 homeViewModel$2$1, Continuation continuation) {
        super(continuation);
        this.this$0 = homeViewModel$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Object) null, this);
    }
}
