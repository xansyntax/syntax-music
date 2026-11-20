package com.metrolist.music.lyrics;

import java.util.Iterator;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ZemerLyricsProvider$getLyrics$1 extends ContinuationImpl {
    public int I$0;
    public String L$1;
    public ZemerLyricsProvider L$5;
    public Iterator L$6;
    public Object L$8;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ZemerLyricsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZemerLyricsProvider$getLyrics$1(ZemerLyricsProvider zemerLyricsProvider, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = zemerLyricsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo1450getLyricsbMdYcbs = this.this$0.mo1450getLyricsbMdYcbs(null, null, null, null, 0, null, this);
        return objMo1450getLyricsbMdYcbs == CoroutineSingletons.COROUTINE_SUSPENDED ? objMo1450getLyricsbMdYcbs : new Result(objMo1450getLyricsbMdYcbs);
    }
}
