package com.metrolist.innertubex.cipher;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RemotePlayerConfigStore$refreshIfStale$1 extends ContinuationImpl {
    public String L$0;
    public MutexImpl L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RemotePlayerConfigStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemotePlayerConfigStore$refreshIfStale$1(RemotePlayerConfigStore remotePlayerConfigStore, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = remotePlayerConfigStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshIfStale$com_github_MetrolistGroup_innertubex(this);
    }
}
