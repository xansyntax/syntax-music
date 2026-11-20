package com.metrolist.music.utils;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$withRetry$1 extends ContinuationImpl {
    public byte I$0;
    public int I$1;
    public int I$2;
    public short J$0;
    public Function1 L$0;
    public Ref$LongRef L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SyncUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$withRetry$1(SyncUtils syncUtils, Continuation continuation) {
        super(continuation);
        this.this$0 = syncUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1522withRetryBWLJW6A = this.this$0.m1522withRetryBWLJW6A(0, 0L, null, this);
        return serializableM1522withRetryBWLJW6A == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1522withRetryBWLJW6A : new Result(serializableM1522withRetryBWLJW6A);
    }
}
