package com.metrolist.lrclib;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LrcLib$getLyrics$1 extends ContinuationImpl {
    public int I$0;
    public String L$0;
    public String L$1;
    public LrcLib L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LrcLib this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LrcLib$getLyrics$1(LrcLib lrcLib, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = lrcLib;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1054getLyricsyxL6bBk = this.this$0.m1054getLyricsyxL6bBk(0, null, null, null, this);
        return serializableM1054getLyricsyxL6bBk == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1054getLyricsyxL6bBk : new Result(serializableM1054getLyricsyxL6bBk);
    }
}
