package com.metrolist.music.lyrics;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PaxsenixLyricsProvider$getAllLyrics$1 extends ContinuationImpl {
    public Function1 L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KuGouLyricsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaxsenixLyricsProvider$getAllLyrics$1(KuGouLyricsProvider kuGouLyricsProvider, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = kuGouLyricsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAllLyrics(null, null, null, null, 0, null, null, this);
    }
}
