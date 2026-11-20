package com.metrolist.music.viewmodels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__LimitKt$take$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1(FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1, Continuation continuation) {
        super(continuation);
        this.this$0 = flowKt__LimitKt$take$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
