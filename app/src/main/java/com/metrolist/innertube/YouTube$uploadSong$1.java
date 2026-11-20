package com.metrolist.innertube;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$uploadSong$1 extends ContinuationImpl {
    public Function1 L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ YouTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTube$uploadSong$1(YouTube youTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = youTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1047uploadSongyxL6bBk = this.this$0.m1047uploadSongyxL6bBk(null, 0L, null, null, this);
        return serializableM1047uploadSongyxL6bBk == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1047uploadSongyxL6bBk : new Result(serializableM1047uploadSongyxL6bBk);
    }
}
