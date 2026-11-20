package com.metrolist.music.lyrics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LyricsHelper$special$$inlined$map$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1(LyricsHelper$special$$inlined$map$1 lyricsHelper$special$$inlined$map$1, Continuation continuation) {
        super(continuation);
        this.this$0 = lyricsHelper$special$$inlined$map$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
