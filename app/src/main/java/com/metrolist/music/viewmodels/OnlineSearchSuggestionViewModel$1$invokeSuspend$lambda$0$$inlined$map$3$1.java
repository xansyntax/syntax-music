package com.metrolist.music.viewmodels;

import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
public final class OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DownloadUtil$getDownload$$inlined$map$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1(DownloadUtil$getDownload$$inlined$map$1 downloadUtil$getDownload$$inlined$map$1, Continuation continuation) {
        super(continuation);
        this.this$0 = downloadUtil$getDownload$$inlined$map$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
