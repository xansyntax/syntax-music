package com.metrolist.music.utils.potoken;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 560)
@DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$Companion", f = "PoTokenWebView.kt", l = {464, 475, 479}, m = "getNewPoTokenGenerator", v = 2)
public final class PoTokenWebView$Companion$getNewPoTokenGenerator$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PoTokenWebView.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenWebView$Companion$getNewPoTokenGenerator$1(PoTokenWebView.Companion companion, Continuation continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNewPoTokenGenerator(null, this);
    }
}
