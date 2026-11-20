package com.metrolist.innertube;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$accountsList$1 extends ContinuationImpl {
    public Json.Default L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ YouTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTube$accountsList$1(YouTube youTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = youTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM992accountsListIoAF18A = this.this$0.m992accountsListIoAF18A(this);
        return serializableM992accountsListIoAF18A == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM992accountsListIoAF18A : new Result(serializableM992accountsListIoAF18A);
    }
}
