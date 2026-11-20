package com.metrolist.music.viewmodels;

import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DatabaseDao$songs$$inlined$map$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1(DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3, Continuation continuation) {
        super(continuation);
        this.this$0 = databaseDao$songs$$inlined$map$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
