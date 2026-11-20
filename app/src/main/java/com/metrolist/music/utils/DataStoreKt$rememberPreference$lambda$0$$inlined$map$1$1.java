package com.metrolist.music.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes2.dex */
public final class DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1(FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1, Continuation continuation) {
        super(continuation);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
