package com.metrolist.lastfm;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LastFM$updateNowPlaying$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LastFM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LastFM$updateNowPlaying$1(LastFM lastFM, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = lastFM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1053updateNowPlayinghUnOzRk = this.this$0.m1053updateNowPlayinghUnOzRk(null, null, null, null, this);
        return objM1053updateNowPlayinghUnOzRk == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1053updateNowPlayinghUnOzRk : new Result(objM1053updateNowPlayinghUnOzRk);
    }
}
