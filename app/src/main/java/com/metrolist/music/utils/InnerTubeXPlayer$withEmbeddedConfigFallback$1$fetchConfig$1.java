package com.metrolist.music.utils;

import androidx.room.concurrent.FileLock;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 extends ContinuationImpl {
    public String L$0;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FileLock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1(FileLock fileLock, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = fileLock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchConfig(null, false, this);
    }
}
