package com.metrolist.music.playback;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1(MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2, Continuation continuation) {
        super(continuation);
        this.this$0 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
