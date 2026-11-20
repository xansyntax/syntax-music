package com.metrolist.music.playback;

import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SyncUtils$special$$inlined$map$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1(SyncUtils$special$$inlined$map$1 syncUtils$special$$inlined$map$1, Continuation continuation) {
        super(continuation);
        this.this$0 = syncUtils$special$$inlined$map$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
