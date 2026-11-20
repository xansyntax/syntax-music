package com.metrolist.music.viewmodels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ArtistSongsViewModel$songs$lambda$1$$inlined$map$1.AnonymousClass2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1(ArtistSongsViewModel$songs$lambda$1$$inlined$map$1.AnonymousClass2 anonymousClass2, Continuation continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
