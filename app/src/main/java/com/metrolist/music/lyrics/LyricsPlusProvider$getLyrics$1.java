package com.metrolist.music.lyrics;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsPlusProvider$getLyrics$1 extends ContinuationImpl {
    public int I$0;
    public String L$2;
    public String L$3;
    public String L$4;
    public LyricsPlusProvider L$5;
    public BinimumLyricsFetchResult L$6;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LyricsPlusProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsPlusProvider$getLyrics$1(LyricsPlusProvider lyricsPlusProvider, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = lyricsPlusProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo1450getLyricsbMdYcbs = this.this$0.mo1450getLyricsbMdYcbs(null, null, null, null, 0, null, this);
        return objMo1450getLyricsbMdYcbs == CoroutineSingletons.COROUTINE_SUSPENDED ? objMo1450getLyricsbMdYcbs : new Result(objMo1450getLyricsbMdYcbs);
    }
}
