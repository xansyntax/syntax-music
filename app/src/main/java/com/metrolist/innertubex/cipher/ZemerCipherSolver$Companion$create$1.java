package com.metrolist.innertubex.cipher;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ZemerCipherSolver$Companion$create$1 extends ContinuationImpl {
    public String L$0;
    public RemotePlayerConfigParser.HardcodedPlayerConfig L$1;
    public QuickJsEngine L$2;
    public Exception L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Path.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZemerCipherSolver$Companion$create$1(Path.Companion companion, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, null, this);
    }
}
