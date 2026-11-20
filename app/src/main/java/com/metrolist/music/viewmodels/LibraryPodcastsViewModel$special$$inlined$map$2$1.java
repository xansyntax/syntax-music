package com.metrolist.music.viewmodels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class LibraryPodcastsViewModel$special$$inlined$map$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HomeViewModel$special$$inlined$map$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryPodcastsViewModel$special$$inlined$map$2$1(HomeViewModel$special$$inlined$map$1 homeViewModel$special$$inlined$map$1, Continuation continuation) {
        super(continuation);
        this.this$0 = homeViewModel$special$$inlined$map$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
