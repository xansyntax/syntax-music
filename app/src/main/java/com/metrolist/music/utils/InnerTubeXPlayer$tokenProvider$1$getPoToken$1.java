package com.metrolist.music.utils;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InnerTubeXPlayer$tokenProvider$1$getPoToken$1 extends ContinuationImpl {
    public String L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ConnectionPool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTubeXPlayer$tokenProvider$1$getPoToken$1(ConnectionPool connectionPool, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = connectionPool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPoToken(null, null, this);
    }
}
