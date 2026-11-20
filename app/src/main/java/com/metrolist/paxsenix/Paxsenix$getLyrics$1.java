package com.metrolist.paxsenix;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Paxsenix$getLyrics$1 extends ContinuationImpl {
    public int I$0;
    public String L$0;
    public String L$1;
    public Paxsenix L$3;
    public List L$6;
    public Object L$7;
    public Ref$IntRef L$8;
    public Iterator L$9;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Paxsenix this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Paxsenix$getLyrics$1(Paxsenix paxsenix, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = paxsenix;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1532getLyricsyxL6bBk = this.this$0.m1532getLyricsyxL6bBk(0, null, null, null, this);
        return serializableM1532getLyricsyxL6bBk == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1532getLyricsyxL6bBk : new Result(serializableM1532getLyricsyxL6bBk);
    }
}
