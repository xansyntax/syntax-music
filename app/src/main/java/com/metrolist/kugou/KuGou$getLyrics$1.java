package com.metrolist.kugou;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.encoding.Base64;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KuGou$getLyrics$1 extends ContinuationImpl {
    public int I$0;
    public KuGou L$3;
    public Base64.Default L$6;
    public KuGou L$7;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KuGou this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuGou$getLyrics$1(KuGou kuGou, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = kuGou;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1049getLyricsyxL6bBk = this.this$0.m1049getLyricsyxL6bBk(0, null, null, null, this);
        return serializableM1049getLyricsyxL6bBk == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1049getLyricsyxL6bBk : new Result(serializableM1049getLyricsyxL6bBk);
    }
}
